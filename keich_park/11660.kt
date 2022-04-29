fun main() {
    val (n, m) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val numbers = (1..n).map { readLine()?.split(' ')?.map { it.toInt() }  ?: return }
    val accum = Array(n + 1) { Array(n + 1) { 0 } }

    (1..n).forEach { r ->
        (1..n).forEach { c ->
            accum[r][c] = accum[r-1][c] + accum[r][c-1] - accum[r-1][c-1] + numbers[r-1][c-1]
        }
    }

    repeat(m) {
        val (x1, y1, x2, y2) = readLine()?.split(' ')?.map { it.toInt() } ?: return
        println(accum[x2][y2] + accum[x1-1][y1-1] - accum[x2][y1-1] - accum[x1-1][y2])
    }
}