# Akka Pomodoro

Just a test project to demostrate that the Pomodoro
can be built without blocking the thread.

See https://www.reddit.com/r/scala/comments/6qxw3e/is_this_good_scala_code/
for more info


## Instructions

- Clone the repo.
- Run sbt
- Choose the program you want to run
```
Multiple main classes detected, select one to run:

 [1] Pomodoro
 [2] com.d1egoaz.akka.pomodoro.AkkaPomodoro
```
- AkkaPomodoro will log:
```
 Please select one of the following:
 c - Create Pomodoro
 q - Quit
[INFO] [08/01/2017 22:07:33.987] [akkaPomodoro-akka.actor.default-dispatcher-4] [akka://akkaPomodoro/user/pomodoroActor] 
>>> Starting Pomodoro. 5 seconds left
[INFO] [08/01/2017 22:07:34.516] [akkaPomodoro-akka.actor.default-dispatcher-3] [akka://akkaPomodoro/user/pomodoroActor] 500 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:35.031] [akkaPomodoro-akka.actor.default-dispatcher-4] [akka://akkaPomodoro/user/pomodoroActor] 1000 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:35.550] [akkaPomodoro-akka.actor.default-dispatcher-3] [akka://akkaPomodoro/user/pomodoroActor] 1500 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:36.071] [akkaPomodoro-akka.actor.default-dispatcher-4] [akka://akkaPomodoro/user/pomodoroActor] 2000 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:36.591] [akkaPomodoro-akka.actor.default-dispatcher-3] [akka://akkaPomodoro/user/pomodoroActor] 2500 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:37.111] [akkaPomodoro-akka.actor.default-dispatcher-4] [akka://akkaPomodoro/user/pomodoroActor] 3000 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:37.631] [akkaPomodoro-akka.actor.default-dispatcher-3] [akka://akkaPomodoro/user/pomodoroActor] 3500 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:38.151] [akkaPomodoro-akka.actor.default-dispatcher-4] [akka://akkaPomodoro/user/pomodoroActor] 4000 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:38.671] [akkaPomodoro-akka.actor.default-dispatcher-3] [akka://akkaPomodoro/user/pomodoroActor] 4500 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:39.014] [akkaPomodoro-akka.actor.default-dispatcher-4] [akka://akkaPomodoro/user/pomodoroActor] 
>>> Pausing for 2 seconds
[INFO] [08/01/2017 22:07:39.530] [akkaPomodoro-akka.actor.default-dispatcher-3] [akka://akkaPomodoro/user/pomodoroActor] 500 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:40.051] [akkaPomodoro-akka.actor.default-dispatcher-4] [akka://akkaPomodoro/user/pomodoroActor] 1000 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:40.571] [akkaPomodoro-akka.actor.default-dispatcher-3] [akka://akkaPomodoro/user/pomodoroActor] 1500 milliseconds of 5 seconds
[INFO] [08/01/2017 22:07:41.033] [akkaPomodoro-akka.actor.default-dispatcher-3] [akka://akkaPomodoro/user/pomodoroActor]
>>> Ready for a new Pomodoro. Press q or c

```
