fun main() {
    val (n, m) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val table = (1..n).map { readLine()?.map { it.digitToInt() }?.toTypedArray() ?: return }.toTypedArray()

    (1 until n).forEach { i ->
        (1 until m).forEach { j ->
            if (table[i][j] == 1) {
                table[i][j] = minOf(table[i-1][j-1], table[i][j-1], table[i-1][j]) + 1
            }
        }
    }

    val size = table.maxOf { array -> array.maxOf { it } }
    println(size * size)
}