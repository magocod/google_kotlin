
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val formatter = DateTimeFormatter.ISO_LOCAL_TIME
val time = { formatter.format(LocalDateTime.now()) }

suspend fun getValue(): Double {
    println("entering getValue() at ${time()}")
    delay(3000)
    println("leaving getValue() at ${time()}")
    return Math.random()
}

fun main() {
    val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
    runBlocking {
//        repeat(3) {
//            GlobalScope.launch {
//                println("${Thread.currentThread()} has started")
//                for (i in states) {
//                    println("${Thread.currentThread()} - $i")
//                    delay(5000)
//                }
//            }
//        }
        var count = 0
        for (i in 1..50) {
            GlobalScope.launch {
                println("${Thread.currentThread()} has started")
                for (i in states) {
                    println("${Thread.currentThread()} - $i")
                    count += 1
                    println("Thread: $i count: $count")
                }
            }
        }
    }
}
