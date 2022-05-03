fun main() {
    val (n, m, k) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val array = Array(n + 1) { Array(m + 1) { 1L } }

    (1..n).forEach { a ->
        (1..m).forEach { z ->
            // K <= 1000000000 이므로. 안하면 오버플로우 발생.
            array[a][z] = minOf(array[a-1][z] + array[a][z-1], 1000000001)
        }
    }

    if (array[n][m] < k) {
        println(-1)
    } else {
        var a = n
        var z = m
        var less = k.toLong()

        var result = ""
        while (true) {
            if (a == 0) {
                repeat(z) {
                    result += "z"
                }
                break
            } else if (z == 0) {
                repeat(a) {
                    result += "a"
                }
                break
            }

            // array[a-1][z] : a로 시작하는 문자열의 개수
            if (less <= array[a-1][z]) {
                result += "a"
                a -= 1
            } else {
                less -= array[a-1][z]
                result += "z"
                z -= 1
            }
        }

        println(result)
    }
}