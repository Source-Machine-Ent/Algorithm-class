fun main() {
    val t = readLine()?.toInt() ?: return
    repeat(t) {
        val (_n, m) = readLine()?.split(' ')?.map { it.toInt() } ?: return
        val n = minOf(_n, m - _n)
        val result = (m downTo m - n + 1).fold(1) { acc, i -> acc * i / (m - i + 1) }
        println(result)
    }
}