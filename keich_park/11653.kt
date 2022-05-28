fun main() {
    var n = readLine()?.toInt() ?: return

    if (n == 1) return

    val isPrime = Array(n + 1) { true }
    isPrime[0] = false
    isPrime[1] = false
    (2..n).forEach { i ->
        if (isPrime[i]) {
            (i * 2..n step i).forEach { j ->
                isPrime[j] = false
            }
        }
    }

    val primeList = isPrime.withIndex().filter { it.value }.map { it.index }
    var i = 0

    while (n > 1) {
        if (n % primeList[i] == 0) {
            n /= primeList[i]
            println(primeList[i])
        } else {
            i++
        }
    }
}