fun main() {
    val n = readLine()?.toInt() ?: return
    val numbers = readLine()?.split(' ')?.map { it.toInt() }?.sorted() ?: return
    val m = readLine()?.toInt() ?: return
    val targets = readLine()?.split(' ')?.map { it.toInt() } ?: return

    targets.forEach { target ->
        var left = 0
        var right = n
        var contains = false

        while (left < right) {
            val mid = (left + right) / 2
            if (numbers[mid] == target) {
                contains = true
                break
            }

            if (numbers[mid] > target) right = mid
            else left = mid + 1
        }

        if (contains) println(1)
        else println(0)
    }
}