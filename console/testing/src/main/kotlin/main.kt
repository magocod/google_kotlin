fun main(args: Array<String>) {
    println("Hello test!")
    val s = Sample()
    println("sum: 1 + 2")
    println(s.sum(1, 2))
}

class Sample() {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}