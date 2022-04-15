fun main() {
    val n = readLine()?.toInt() ?: return
    val triangle = (1..n).map {
        readLine()?.split(' ')?.map { it.toInt() } ?: return
    }
    val result = Array(n) { Array(it + 1) { 0 } }

    repeat(n) { row ->
        repeat(row + 1) { col ->
            result[row][col] = triangle[row][col] + when {
                row == 0 -> 0
                col == 0 -> result[row - 1][col]
                col == row -> result[row - 1][col - 1]
                else -> maxOf(result[row - 1][col - 1], result[row - 1][col])
            }
        }
    }

    println(result[n-1].maxOrNull() ?: 0)
}