private lateinit var tree: Array<Long>
private lateinit var numbers: Array<Long>

fun main() {
    val (n, m, k) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    numbers = (1..n).map { readLine()?.toLong() ?: return }.toTypedArray()
    tree = Array(4 * n) { 0 }

    makeTree(0, n - 1, 1)

    repeat(m + k) {
        val (_a, _b, _c) = readLine()?.split(' ') ?: return
        val a = _a.toInt()
        val b = _b.toInt()
        if (a == 1) {
            val c = _c.toLong()
            update(0, n-1, 1, b-1, c - numbers[b-1])
            numbers[b-1] = c
        } else {
            val c = _c.toInt()
            println(sum(0, n-1, 1, b-1, c-1))
        }
    }
}

private fun makeTree(start: Int, end: Int, node: Int): Long {
    if (start == end) {
        return numbers[start].also {
            tree[node] = it
        }
    }

    val mid = (start + end) / 2
    return (makeTree(start, mid, node * 2) + makeTree(mid + 1, end, node * 2 + 1)).also {
        tree[node] = it
    }
}

// start, end: 노드의 시작, 끝 인덱스
// left, right: 구하는 범위의 인덱스
private fun sum(start: Int, end: Int, node: Int, left: Int, right: Int): Long {
    // 노드가 범위 밖
    if (left > end || right < start) return 0

    // 노드가 범위 내
    if (left <= start && end <= right) return tree[node]

    // 그 외
    val mid = (start + end) / 2
    return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right)
}

private fun update(start: Int, end: Int, node: Int, index: Int, diff: Long) {
    if (index < start || index > end) return

    tree[node] += diff
    if (start == end) return

    val mid = (start + end) / 2
    update(start, mid, node * 2, index, diff)
    update(mid + 1, end, node * 2 + 1, index, diff)
}