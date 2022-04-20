fun main() {
    val (n, m) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val numbers = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val accum = Array(n + 1) { 0 }
    (1..n).forEach {
        accum[it] = accum[it - 1] + numbers[it - 1]
    }
    repeat(m) {
        val (a, b) = readLine()?.split(' ')?.map { it.toInt() } ?: return
        println(accum[b] - accum[a - 1])
    }
}