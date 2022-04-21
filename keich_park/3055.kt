import java.util.*

fun main() {
    val (r, c) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val map = Array(r) { Array(c) { ' ' } }
    val queue = ArrayDeque<Pair<Int, Int>>(r * c)
    var hole = 0 to 0
    val waterInitList = mutableListOf<Pair<Int, Int>>()

    val directions = listOf(
        0 to 1,
        1 to 0,
        0 to -1,
        -1 to 0
    )

    repeat(r) { row ->
        val line = readLine()?.toList() ?: return
        map[row] = line.toTypedArray()
        line.forEachIndexed { col, char ->
            when (char) {
                'S' -> queue.add(row to col)
                'D' -> hole = row to col
                '*' -> waterInitList.add(row to col)
            }
        }
    }
    queue.addAll(waterInitList)

    val distanceMap = Array(r) { Array(c) { 0 } }
    while (queue.isNotEmpty()) {
        val (x, y) = queue.pollFirst()
        if (map[hole.first][hole.second] == 'S') {
            println(distanceMap[hole.first][hole.second])
            return
        }

        directions.forEach { (dx, dy) ->
            val (nx, ny) = x + dx to y + dy
            if (nx in 0 until r && ny in 0 until c) {
                if ((map[nx][ny] == '.' || map[nx][ny] == 'D') && map[x][y] == 'S') {
                    map[nx][ny] = 'S'
                    distanceMap[nx][ny] = distanceMap[x][y] + 1
                    queue.add(nx to ny)
                } else if ((map[nx][ny] == '.' || map[nx][ny] == 'S') && map[x][y] == '*') {
                    map[nx][ny] = '*'
                    queue.add(nx to ny)
                }
            }
        }
    }

    println("KAKTUS")
}

data class Item(
    val position: Pair<Int, Int>,
    val move: Int
)
