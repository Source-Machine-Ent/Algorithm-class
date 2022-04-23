fun main() {
    val n = readLine()?.toInt() ?: return
    val numList = readLine()?.split(' ')?.map { it.toInt() } ?: return

    val fromStart = Array(n) { numList[it] }
    val fromEnd = Array(n) { numList[it] }

    (1 until n).forEach { i ->
        fromStart[i] = getGcdOf(fromStart[i - 1], fromStart[i])
        fromEnd[n - i -1] = getGcdOf(fromEnd[n - i - 1], fromEnd[n - i])
    }

    val exclusiveGcd = (0 until n).map { i ->
        when (i) {
            0 -> fromEnd[1]
            n - 1 -> fromStart[n - 2]
            else -> getGcdOf(fromStart[i - 1], fromEnd[i + 1])
        }
    }

    val maxGcd = exclusiveGcd.withIndex().maxByOrNull { it.value } ?: return
    if (numList[maxGcd.index] % maxGcd.value == 0) {
        println(-1)
    } else {
        println("${maxGcd.value} ${numList[maxGcd.index]}")
    }
}

fun getGcdOf(a: Int, b: Int): Int = if (b != 0) getGcdOf(b, a % b) else a