import java.util.*

fun main() {
    val input = readLine() ?: return
    val stack = Stack<Node>()

    val root = mutableListOf<Node>()

    input.forEach { c ->
        when (c) {
            '(', '[' -> {
                val node = Node(
                    if (c == '(') Node.Type.SMALL
                    else Node.Type.BIG
                )
                if (stack.isEmpty()) {
                    root.add(node)
                } else {
                    stack.last().children.add(node)
                }
                stack.add(node)
            }
            ')', ']' -> {
                if (stack.isEmpty()) {
                    println(0)
                    return
                }

                val node = stack.pop()
                if (
                    (c == ')' && node.type == Node.Type.BIG) ||
                    (c == ']' && node.type == Node.Type.SMALL)
                ) {
                    println(0)
                    return
                }
            }
            else -> {
                println(0)
                return
            }
        }
    }

    if (stack.isNotEmpty()) {
        println(0)
        return
    }
    println(root.sumOf { dfs(it) })
}

private fun dfs(node: Node): Int {
    return if (node.children.isEmpty()) {
        if (node.type == Node.Type.SMALL) 2
        else 3
    } else {
        if (node.type == Node.Type.SMALL) 2 * node.children.sumOf { dfs(it) }
        else 3 * node.children.sumOf { dfs(it) }
    }
}

data class Node(
    val type: Type,
    val children: MutableList<Node> = mutableListOf()
) {
    enum class Type {
        SMALL, BIG
    }
}