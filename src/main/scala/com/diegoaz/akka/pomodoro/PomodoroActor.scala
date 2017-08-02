package com.d1egoaz.akka.pomodoro

import akka.actor.{Actor, Cancellable, ActorLogging, ActorRef, ActorSystem, Props}
import scala.io.StdIn
import scala.concurrent.duration._

object Pomodoro {

  def props: Props = Props[Pomodoro]

  final case object StartWork
  final case object StartPause
  final case object Ready
  final case class Tick(currentTime: FiniteDuration)

  val pomodoroDuration: FiniteDuration = 5.seconds // 25.seconds
  val pomodoroPauseduration: FiniteDuration = 2.seconds // 5.seconds
  val tickDuration: FiniteDuration = 500.millis // 1.minute
}

class Pomodoro extends Actor with ActorLogging {
  import Pomodoro._
  import context.dispatcher

  var pomodoroTick: Option[Cancellable] = None

  private def sendTick(current: FiniteDuration): Unit =
    pomodoroTick = Some(context.system.scheduler.scheduleOnce(tickDuration, self, Tick(current)))

  def ready: Receive = {
    case StartWork =>
      log.info(s"\n>>> Starting Pomodoro. $pomodoroDuration left")
      context.system.scheduler.scheduleOnce(pomodoroDuration, self, StartPause)
      sendTick(tickDuration)
      context.become(work)
  }

  def handleTick: Receive = {
    case Tick(current) =>
      log.info(s"$current of $pomodoroDuration")
      sendTick(current + tickDuration)
    case StartWork =>
      log.info("There is already a Pomodoro/Pause in progress")
  }

  def work: Receive = handleTick.orElse {
    case StartPause =>
      pomodoroTick.foreach(_.cancel())
      log.info(s"\n>>> Pausing for $pomodoroPauseduration")
      context.system.scheduler.scheduleOnce(pomodoroPauseduration, self, Ready)
      sendTick(tickDuration)
      context.become(pause)
  }

  def pause: Receive = handleTick.orElse {
    case Ready =>
      pomodoroTick.foreach(_.cancel())
      log.info("\n>>> Ready for a new Pomodoro. Press q or c")
      context.become(ready)
  }

  override def receive = ready
}

object AkkaPomodoro {
  private val system: ActorSystem = ActorSystem("akkaPomodoro")
  private val pomodoro: ActorRef = system.actorOf(Pomodoro.props, "pomodoroActor")

  private def menu(option: String): Unit =
    option match {
      case "q" =>
        println("bye!")
        system.terminate()
        System.exit(0)
      case "c" =>
        pomodoro ! Pomodoro.StartWork
      case _ => ()
    }

  private def readOption(): String = {
    println("""| Please select one of the following:
               | c - Create Pomodoro
               | q - Quit""".stripMargin)
    StdIn.readLine()
  }

  def main(args: Array[String]) {
    while (true) {
      menu(readOption())
    }
  }
}
