fun main() {
    val n = readLine()?.toInt() ?: return
    val numbers = (1..n).map { readLine()?.toInt() ?: return }

    when (n) {
        1 -> println(numbers[0])
        2 -> println(numbers[0] + numbers[1])
        else -> {
            val dp = Array(n) { 0 }

            dp[0] = numbers[0]
            dp[1] = numbers[0] + numbers[1]
            dp[2] = maxOf(numbers[0] + numbers[2], numbers[1] + numbers[2])

            (3 until n).forEach { i ->
                dp[i] = maxOf(dp[i-2] + numbers[i], dp[i-3] + numbers[i-1] + numbers[i])
            }
            println(dp[n-1])
        }
    }
}