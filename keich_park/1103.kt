private val dx = listOf(0, 1, 0, -1)
private val dy = listOf(1, 0, -1, 0)
private var n = 0
private var m = 0
private lateinit var pad: Array<String>
private lateinit var dp: Array<Array<Int>>
private var infinite = false

private fun main() {
    val (_n, _m) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    n = _n
    m = _m
    pad = Array(n) { "" }
    dp = Array(n) { Array(m) { -1 } }

    repeat(n) {
        pad[it] = readLine() ?: return
    }

    dfs(0 to 0, setOf())

    if (!infinite) {
        println(dp.maxOf { it.maxOf { it } })
    } else {
        println(-1)
    }
}

private fun dfs(
    position: Pair<Int, Int>,
    history: Set<Pair<Int, Int>>
) {
    if (infinite) {
        return
    }

    val (x, y) = position
    val count = history.size

    // 방문한 적이 있으면 무한대로 끝
    if (history.contains(position)) {
        infinite = true
        return
    }

    // 현 위치의 최대 이동 횟수보다 적으면 움직이지 않음
    if (dp[x][y] >= count + 1) {
        return
    }

    // 최대 이동 횟수 표시
    dp[x][y] = count + 1

    // 4가지 방향으로 시도
    (0..3).forEach { i ->
        val nx = x + dx[i] * (pad[x][y] - '0')
        val ny = y + dy[i] * (pad[x][y] - '0')

        if (!(nx in 0 until n && ny in 0 until m) || pad[nx][ny] == 'H') {
            return@forEach
        }

        dfs(nx to ny, history + position)
    }
}