private lateinit var nums: List<String>
private lateinit var visited: Array<Boolean>
private var n = 0
private var k = 0
private var result = mutableSetOf<String>()

fun main() {
    n = readLine()?.toInt() ?: return
    k = readLine()?.toInt() ?: return
    nums = (1..n).map { readLine() ?: return }
    visited = Array(n) { false }

    dfs("", 0)

    println(result.size)
}

private fun dfs(number: String, current: Int) {
    if (current == k) {
        result.add(number)
        return
    }

    (0 until n).forEach { i ->
        if (visited[i]) {
            return@forEach
        }

        visited[i] = true
        dfs(number + nums[i], current + 1)
        visited[i] = false
    }
}
