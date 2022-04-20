fun main() {
    val (n, m) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val outSetList = Array(n + 1) { mutableSetOf<Int>() }
    val inList = Array(n + 1) { 0 }

    repeat(m) {
        val (before, after) = readLine()?.split(' ')?.map { it.toInt() } ?: return
        outSetList[before].add(after)
        inList[after]++
    }

    val result = mutableListOf<Int>()
    val queue = Array(n) { 0 }
    var nextIn = 0
    var nextOut = 0

    inList.forEachIndexed { index, count ->
        if (index > 0 && count == 0) queue[nextIn++] = index
    }

    while (result.size < n) {
        val node = queue[nextOut++]
        result.add(node)
        for (next in outSetList[node]) {
            if (--inList[next] == 0) {
                queue[nextIn++] = next
            }
        }
    }
    println(result.joinToString(" "))
}