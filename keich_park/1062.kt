var n = 0
var k = 0
var wordList = emptyList<Set<Char>>()
var maxCount = 0

fun main() {
    val (_n, _k) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    n = _n
    k = _k
    wordList = (1..n).map { readLine()?.toSet() ?: return }
    val chars = Array(26) { false }
    "antic".forEach { c ->
        chars[c - 'a'] = true
    }

    val result = when {
        k < 5 -> 0
        k == 26 -> n
        else -> {
            backtracking(chars, 0, 0)
            maxCount
        }
    }

    println(result)
}

fun backtracking(chars: Array<Boolean>, start: Int, count: Int) {
    if (count == k - 5) {
        val result = wordList.count { word ->
            word.all { c -> chars[c - 'a'] }
        }
        maxCount = maxOf(result, maxCount)
        return
    }

    (start..25).forEach { i ->
        if (!chars[i]) {
            chars[i] = true
            backtracking(chars, i + 1, count + 1)
            chars[i] = false
        }
    }
}