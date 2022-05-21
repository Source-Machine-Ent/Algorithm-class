fun main() {
    val n = readLine()?.toInt() ?: return
    val matrix = (1..n).map {
        readLine()?.split(' ')?.map { it.toInt() } ?: return
    }

    val dp = Array(n) { Array(n) { 0 } }

    for (i in 1..n) {
        for (j in 0 until n - i) {
            if (i == 1) {
                dp[j][j + i] = matrix[j][0] * matrix[j][1] * matrix[j + 1][1]
                continue
            }

            dp[j][j + i] = Int.MAX_VALUE
            for (k in j until j + i) {
                dp[j][j + i] = minOf(
                    dp[j][j + i],
                    dp[j][k] + dp[k + 1][j + i] + matrix[j][0] * matrix[k][1] * matrix[j + i][1]
                )
            }
        }
    }

    println(dp[0][n-1])
}