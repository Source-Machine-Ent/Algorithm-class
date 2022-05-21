import kotlin.math.abs

private var n = 0
private lateinit var array: Array<Int>
private var result = 0

fun main() {
    n = readLine()?.toInt() ?: return
    array = Array(n) { 0 }

    dfs(0)

    println(result)
}

private fun dfs(row: Int) {
    if (row == n) {
        result++
        return
    }

    (0 until n).forEach { col ->
        for (j in 0 until row) {
            if (array[j] == col) return@forEach
            if (row - j == abs(col - array[j])) return@forEach
        }

        array[row] = col
        dfs(row + 1)
    }
}