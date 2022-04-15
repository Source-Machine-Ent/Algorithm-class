fun main() {
    val (n, m) = readLine()?.split(' ', limit = 2)?.map { it.toInt() } ?: return
    val groupArray = Array(n + 1) { it }

    repeat(m) {
        val (t, a, b) = readLine()?.split(' ', limit = 3)?.map { it.toInt() } ?: return

        if (t == 0) {
            val groupA = findGroup(groupArray, a)
            val groupB = findGroup(groupArray, b)
            groupArray[maxOf(groupA, groupB)] = minOf(groupA, groupB)
        } else {
            if (findGroup(groupArray, a) == findGroup(groupArray, b)) println("yes")
            else println("no")
        }
    }
}

fun findGroup(array: Array<Int>, i: Int): Int {
    if (array[i] == i) return i
    array[i] = findGroup(array, array[i])
    return array[i]
}
