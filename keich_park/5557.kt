private lateinit var numbers: List<Int>
private var lastNumber: Int = 0

fun main() {
    val n = readLine()?.toInt() ?: return
    val inputs = readLine()?.split(' ')?.map { it.toInt() } ?: return

    lastNumber = inputs.last()
    numbers = inputs.subList(0, inputs.size - 1)

    println(dfs(0, 0))
}

private fun dfs(i: Int, result: Int): Int {
    if (result < 0 || result > 20) return 0
    if (i == numbers.size) {
        return if (result == lastNumber) 1 else 0
    }

    return dfs(i + 1, result + numbers[i]) + dfs(i + 1, result - numbers[i])
}