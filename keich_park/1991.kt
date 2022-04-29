fun main() {
    val n = readLine()?.toInt() ?: return
    val nodes = mutableMapOf<String, Pair<String?, String?>>()
    repeat(n) {
        val (root, left, right) = readLine()?.split(' ') ?: return
        nodes[root] = Pair(
            if (left == ".") null else left,
            if (right == ".") null else right,
        )
    }

    println(prefix(nodes, "A"))
    println(infix(nodes, "A"))
    println(postfix(nodes, "A"))
}

fun prefix(nodes: Map<String, Pair<String?, String?>>, node: String): String {
    return node +
            (nodes[node]?.first?.let { prefix(nodes, it) } ?: "") +
            (nodes[node]?.second?.let { prefix(nodes, it) } ?: "")
}

fun infix(nodes: Map<String, Pair<String?, String?>>, node: String): String {
    return (nodes[node]?.first?.let { infix(nodes, it) } ?: "") +
            node +
            (nodes[node]?.second?.let { infix(nodes, it) } ?: "")
}

fun postfix(nodes: Map<String, Pair<String?, String?>>, node: String): String {
    return (nodes[node]?.first?.let { postfix(nodes, it) } ?: "") +
            (nodes[node]?.second?.let { postfix(nodes, it) } ?: "") +
            node
}