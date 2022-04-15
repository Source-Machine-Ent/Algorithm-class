fun main() {
    val (n, _k) = readLine()?.split(' ', limit = 2)?.map { it.toInt() } ?: return
    val k = minOf(_k, n - _k)

    println((0 until k).fold(1) { acc, i -> acc * (n - i) / (i + 1) })
}