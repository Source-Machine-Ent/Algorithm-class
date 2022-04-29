fun main() {
    val n = readLine()?.toInt() ?: return
    val m = readLine()?.toInt() ?: return

    val parent = Array(n + 1) { it }
    var cost = 0

    (1..m).map {
        readLine()?.split(' ')?.map { it.toInt() } ?: return
    }.sortedBy {
        it[2]
    }.forEach { (a, b, c) ->
        val parentA = findParent(parent, a)
        val parentB = findParent(parent, b)
        if (parentA == parentB) return@forEach

        parent[minOf(parentA, parentB)] = maxOf(parentA, parentB)
        cost += c
    }

    println(cost)
}

fun findParent(array: Array<Int>, a: Int): Int {
    if (array[a] == a) return a
    return findParent(array, array[a])
}