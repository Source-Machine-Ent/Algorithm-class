private lateinit var smallerThan: Array<MutableSet<Int>>
private lateinit var biggerThan: Array<MutableSet<Int>>

fun main() {
    val (n, m) = readLine()?.split(' ')?.map { it.toInt() } ?: return

    biggerThan = Array(n) { mutableSetOf<Int>() }
    smallerThan = Array(n) { mutableSetOf<Int>() }
    repeat(m) {
        val (small, big) = readLine()?.split(' ')?.map { it.toInt() } ?: return
        smallerThan[small - 1].add(big - 1)
        biggerThan[big - 1].add(small - 1)
    }

    val result = (0 until n).count {
        val smaller = getSmaller(it)
        val bigger = getBigger(it)
        smaller.size + bigger.size + 1 == n
    }
    println(result)
}

private fun getSmaller(i: Int): Set<Int> {
    return smallerThan[i].fold(setOf()) { acc, n -> acc + getSmaller(n) + n }
}

private fun getBigger(i: Int): Set<Int> {
    return biggerThan[i].fold(setOf()) { acc, n -> acc + getBigger(n) + n }
}