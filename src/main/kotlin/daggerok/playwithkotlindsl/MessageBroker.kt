package daggerok.playwithkotlindsl

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.ArrayBlockingQueue

fun testMessageBroker() {
  val queue = ArrayBlockingQueue<Any>(1024).apply {
    GlobalScope.launch {
      while (true) {
        println("0")
        val next = take()
        println("queue: $next")
      }
    }
  }

  runBlocking {
    queue.add("ololo")
    delay(1234)

    queue.add("trololo")
    delay(123)

    queue.add("nononono")
    delay(993)

    queue.add("nononono")
  }

  println("Done.")
}
