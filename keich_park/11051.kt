fun main() {
    val (n, _k) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val k = minOf(_k, n - _k)

    val arr = Array(n + 1) { Array(n + 1) { 0 } }
    repeat(n + 1) { i ->
        arr[i][0] = 1
        arr[i][i] = 1
    }

    for (i in 0..n) {
        for (j in 1..minOf(i - 1, k)) {
            arr[i][j] = (arr[i - 1][j - 1] + arr[i-1][j]) % 10007
        }
    }

    println(arr[n][k])
}
