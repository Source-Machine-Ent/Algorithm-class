fun main() {
    // a/b + c/d
    val (a, b) = readLine()?.split(' ', limit = 2)?.map { it.toInt() } ?: return
    val (c, d) = readLine()?.split(' ', limit = 2)?.map { it.toInt() } ?: return
    val up = a * d + b * c
    val down = b * d

    val upMap = getPrimeMap(up)
    val downMap = getPrimeMap(down)

    var divide = 1
    upMap.forEach { (p, n) ->
        val intersection = minOf(n, downMap[p] ?: 0)
        divide *= (1..intersection).fold(1) { old, _ -> old * p }
    }

    println("${up / divide} ${down / divide}")
}

fun getPrimeMap(n: Int): Map<Int, Int> {
    val primeMap = mutableMapOf<Int, Int>()
    var i = 2
    var current = n
    while (current > 1) {
        if (current % i == 0) {
            primeMap[i] = primeMap[i]?.plus(1) ?: 1
            current /= i
        } else {
            i++
        }
    }
    return primeMap
}