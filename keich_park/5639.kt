fun main() {
    val numbers = mutableListOf<Int>()

    while (true) {
        val input = readLine()?.toIntOrNull() ?: break
        numbers.add(input)
    }

    val stack = Array(numbers.size) { Node5639(0) }
    var pointer = 0

    val root = Node5639(numbers[0])
    stack[pointer++] = root
    numbers.drop(1).forEach { n ->
        val lastNode = stack[pointer - 1]
        if (n < lastNode.item) {
            stack[pointer++] = Node5639(n).also {
                lastNode.left = it
            }
        } else {
            var current = stack[--pointer]
            while (pointer > 0 && !(current.item < n && n < stack[pointer - 1].item)) {
                current = stack[--pointer]
            }

            stack[pointer++] = Node5639(n).also {
                current.right = it
            }
        }
    }

    explore(root)
}

private data class Node5639(
    val item: Int,
    var left: Node5639? = null,
    var right: Node5639? = null
)

private fun explore(node: Node5639) {
    node.left?.let {
        explore(it)
    }

    node.right?.let {
        explore(it)
    }

    println(node.item)
}