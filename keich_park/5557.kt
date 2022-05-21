fun main() {
    val n = readLine()?.toInt() ?: return
    val numbers = readLine()?.split(' ')?.map { it.toInt() } ?: return

    val array = Array(n) { Array(21) { 0L } }
    array[0][numbers[0]] = 1

    (1..n-2).forEach { i ->
        (0..20).forEach { j ->
            if (array[i - 1][j] > 0) {
                if (j + numbers[i] <= 20) {
                    array[i][j + numbers[i]] += array[i-1][j]
                }
                if (j - numbers[i] >= 0) {
                    array[i][j - numbers[i]] += array[i-1][j]
                }
            }
        }
    }

    println(array[n-2][numbers[n-1]])
}