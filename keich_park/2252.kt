fun main() {
    val (n, m) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    // (before -> List<after>)
    val referenceMap = mutableMapOf<Int, MutableSet<Int>>()
    // (after -> n(before))
    val referenceCountMap = mutableMapOf<Int, Int>()
    repeat(n) {
        referenceMap[it + 1] = mutableSetOf()
        referenceCountMap[it + 1] = 0
    }

    repeat(m) {
        val (before, after) = readLine()?.split(' ')?.map { it.toInt() } ?: return
        referenceMap[before]!!.add(after)
        referenceCountMap[after] = referenceCountMap[after]?.plus(1) ?: 1
    }

    val result = mutableListOf<Int>()
    while (referenceCountMap.isNotEmpty()) {
        val nodes = referenceCountMap.filterValues { it == 0 }
        for (node in nodes.keys) {
            result.add(node)
            for (next in referenceMap[node] ?: listOf()) {
                referenceCountMap[next] = referenceCountMap[next]!! - 1
            }
            referenceCountMap.remove(node)
        }
    }
    println(result.joinToString(" "))
}