private lateinit var charList: List<Char>
private lateinit var visited: Array<Boolean>
private var l = 0
private var c = 0
private val result = mutableListOf<String>()

fun main() {
    val inputs = readLine()?.split(' ')?.map { it.toInt() } ?: return
    l = inputs[0]
    c = inputs[1]
    charList = readLine()?.split(' ')?.map { it[0] }?.sorted() ?: return
    visited = Array(c) { false }

    dfs("", 0, 0, 0)
    result.forEach {
        println(it)
    }
}

private fun dfs(currentStr: String, i: Int, vowelCount: Int, consonantCount: Int) {
    if (vowelCount + consonantCount == l) {
        if (vowelCount >= 1 && consonantCount >= 2) {
            result.add(currentStr)
        }

        return
    }

    if (i == c) return

    (i until c).forEach { j ->
        if (!visited[j]) {
            val isVowel = charList[j] in "aeiou"

            visited[j] = true
            if (isVowel) {
                dfs(currentStr + charList[j], j + 1, vowelCount + 1, consonantCount)
            } else {
                dfs(currentStr + charList[j], j + 1, vowelCount, consonantCount + 1)
            }
            visited[j] = false
        }
    }
}
