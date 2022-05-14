fun main() {
    val isPrime = Array(1000001) { true }
    isPrime[0] = false
    isPrime[1] = false
    (2..1000).forEach { i ->
        if (isPrime[i]) {
            (i * 2..1000000 step i).forEach { j ->
                isPrime[j] = false
            }
        }
    }

    var input = readLine()?.toInt() ?: return
    while (input != 0) {
        (0 until input).firstOrNull { isPrime[it] && isPrime[input - it] }
            ?.let { a ->
                println("${input} = $a + ${input - a}")
            } ?: println("Goldbach's conjecture is wrong.")

        input = readLine()?.toInt() ?: return
    }
}