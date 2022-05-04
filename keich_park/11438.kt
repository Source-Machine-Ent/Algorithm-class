import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var graph: Array<MutableList<Int>>
lateinit var parent: Array<Array<Int>>
lateinit var depthArray: Array<Int>
private const val MAX = 17

val reader = BufferedReader(InputStreamReader(System.`in`))
val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = reader.readLine().toInt()
    graph = Array(n + 1) { mutableListOf<Int>() }
    parent = Array(n + 1) { Array(MAX) { 0 } }
    depthArray = Array(n + 1) { -1 }
    repeat(n - 1) {
        val (a, b) = reader.readLine().split(' ').map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    depthArray[1] = 0
    dfs(1, 0)

    (1 until MAX).forEach { i ->
        (1..n).forEach { j ->
            // parent[j][i] : j의 2^i 번째 부모
            // parent[j][i] : j의 2^(i-1)번째 부모의 2^(i-1)번째 부모
            parent[j][i] = parent[parent[j][i - 1]][i - 1]
        }
    }

    val m = reader.readLine().toInt()
    repeat(m) {
        val (a, b) = reader.readLine().split(' ').map { it.toInt() }
        writer.write("${lca(a, b)}\n")
    }

    writer.flush()
    writer.close()
}

fun dfs(
    x: Int,
    depth: Int
) {
    depthArray[x] = depth
    graph[x].forEach { y ->
        if (depthArray[y] != -1) return@forEach
        parent[y][0] = x
        dfs(y, depth + 1)
    }
}

fun lca(_a: Int, _b: Int): Int {
    var (a, b) = if (depthArray[_a] > depthArray[_b]) _b to _a else _a to _b
    (MAX-1 downTo 0).forEach { i ->
        if (depthArray[b] - depthArray[a] >= 1 shl i) b = parent[b][i]
    }

    if (a == b) return a

    (MAX-1 downTo 0).forEach { i ->
        if (parent[a][i] != parent[b][i]) {
            a = parent[a][i]
            b = parent[b][i]
        }
    }
    return parent[a][0]
}