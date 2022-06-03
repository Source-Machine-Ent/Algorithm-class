fun main() {
    val (n, target) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val memoryList = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val costList = readLine()?.split(' ')?.map { it.toInt() } ?: return

    val costSum = costList.sum()
    val dp = Array(n + 1) { Array(costSum + 1) { 0 } }

    var result = costSum
    (1..n).forEach { i ->
        val memory = memoryList[i - 1]
        val cost = costList[i - 1]

        (1..costSum).forEach { j -> // j 만큼의 cost를 허용한다고 할 때
            if (cost > j) { // i번째 앱의 cost가 j보다 크면 건너뜀
                dp[i][j] = dp[i - 1][j]
            } else { // i번째 앱의 cost가 j보다 작거나 같으면 이전 앱의 cost에서 결과 가져옴
                dp[i][j] = maxOf(memory + dp[i - 1][j - cost], dp[i - 1][j])
            }

            if (dp[i][j] >= target) {
                result = minOf(result, j)
            }
        }
    }

    if (target > 0) {
        println(result)
    } else {
        println(0)
    }
}