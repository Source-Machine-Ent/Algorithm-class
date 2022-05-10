fun main() {
    val (n, m) = readLine()?.split(' ')?.map { it.toInt() } ?: return

    val edges = Array(n) { Array(n) { false } }

    repeat(m) {
        val (small, tall) = readLine()?.split(' ')?.map { it.toInt() } ?: return
        edges[small - 1][tall - 1] = true
    }

    (0 until n).forEach { k ->
        (0 until n).forEach { i ->
            (0 until n).forEach { j ->
                if (edges[i][k] && edges[k][j])
                    edges[i][j] = true
            }
        }
    }

    val result = (0 until n).count { i ->
        (0 until n).count { j ->
            edges[i][j] || edges[j][i]
        } == n - 1
    }
    println(result)
}
