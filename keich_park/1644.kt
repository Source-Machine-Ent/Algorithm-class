fun main() {
    val target = readLine()?.toInt() ?: return

    if (target == 1) {
        println(0)
        return
    }

    val isPrime = Array(target + 1) { true }
    isPrime[0] = false
    isPrime[1] = false
    (2..target).forEach { i ->
        if (isPrime[i]) {
            (i*2..target step i).forEach { j ->
                isPrime[j] = false
            }
        }
    }

    val primeList = isPrime.withIndex().filter { it.value }.map { it.index }
    var start = 0
    var end = 1
    var current = primeList[0]
    var result = 0

    while (start <= end && end <= primeList.size) {
        when {
            end == primeList.size -> {
                if (current > target) {
                    current -= primeList[start++]
                } else if (current == target) {
                    result++
                    break
                } else {
                    break
                }
            }
            current < target -> {
                current += primeList[end++]
            }
            current == target -> {
                result++
                current += primeList[end++]
            }
            current > target -> {
                current -= primeList[start++]
            }
        }
    }

    println(result)
}