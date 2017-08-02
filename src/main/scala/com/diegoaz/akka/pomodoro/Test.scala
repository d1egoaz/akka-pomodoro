import scala.io.StdIn.readLine

// https://www.reddit.com/r/scala/comments/6qxw3e/is_this_good_scala_code/
object Pomodoro extends App {

  println("Pomodoro\n========\n")

  while (true) {
    print("Press enter to start")
    readLine
    startWork
    startPause
  }

  def startWork = {
    (25 to 0 by -1) foreach { x =>
      print("\r" + x + " minutes of work left ")
      if (x>0) Thread sleep 60000
    }
    println
  }

  def startPause = {
    (5 to 0 by -1) foreach { x =>
      print("\r" + x + " minutes of pause left ")
      if (x>0) Thread sleep 60000
    }
    println
  }
}
