import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val (n, m) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val pad = Array(n) { readLine() ?: return }
    val queue = ArrayDeque<CoinMove>()
    val dp = Array(n) { Array(m) { -1 } }
    val dx = listOf(0, 1, 0, -1)
    val dy = listOf(1, 0, -1, 0)

    queue.add(CoinMove(
        position = 0 to 0,
        history = setOf()
    ))

    var maxMove = 0
    while (queue.isNotEmpty()) {
        val (position, history) = queue.removeFirst()
        val (x, y) = position
        val count = history.size

        // 구멍에 빠짐
        if (pad[x][y] == 'H') {
            continue
        }

        // 현재 위치에서 움직일 수 있으니까
        maxMove = maxOf(maxMove, count + 1)

        // 방문한 적이 있으면 무한대로 끝
        if (history.contains(position)) {
            println(-1)
            return
        }

        // 현 위치의 최대 이동 횟수보다 적으면 움직이지 않음
        if (dp[x][y] >= count + 1) {
            continue
        }

        // 최대 이동 횟수 표시
        dp[x][y] = count + 1

        // 4가지 방향으로 시도
        (0..3).forEach { i ->
            val nx = x + dx[i] * (pad[x][y] - '0')
            val ny = y + dy[i] * (pad[x][y] - '0')

            if (!(nx in 0 until n && ny in 0 until m)) {
                return@forEach
            }

            queue.add(CoinMove(nx to ny, history + position))
        }
    }

    println(maxMove)
}

data class CoinMove(
    val position: Pair<Int, Int>,
    val history: Set<Pair<Int, Int>>
)