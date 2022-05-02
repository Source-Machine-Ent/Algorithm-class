var result = "-1"
var current = 0
var end = -1
var size = -1
var target = -1

fun main() {
    val (n, m, k) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val array = Array(n + m) { false }
    end = n
    size = n + m - 1
    target = k

    backtracking1256(array, 0, 0)

    println(result)
}


fun backtracking1256(array: Array<Boolean>, start: Int, count: Int) {
    if (count == end) {
        if (current++ == target - 1) {
            result = array.joinToString("") { if (it) "a" else "z" }
        }
        return
    }

    (start..size).forEach { i ->
        if (!array[i]) {
            array[i] = true
            backtracking1256(array, i + 1, count+1)
            array[i] = false
        }
    }
}