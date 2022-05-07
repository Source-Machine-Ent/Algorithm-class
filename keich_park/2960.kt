fun main() {
    val (n, k) = readLine()?.split(' ')?.map { it.toInt() } ?: return
    val array = Array(n + 1) { true }
    array[0] = false
    array[1] = false

    var current = 0
    (2..n).forEach { i ->
        if (array[i]) {
            (i..n step i).forEach { j ->
                if (array[j] && ++current == k) {
                    println(j)
                    return
                }
                array[j] = false
            }
        }
    }
}