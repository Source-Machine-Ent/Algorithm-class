fun main() {
    val stack = Array(10000) { 0 }
    var pointer = 0

    val n = readLine()?.toInt() ?: return

    repeat(n) {
        val command = readLine()?.split(' ') ?: return

        when (command[0]) {
            "push" -> stack[pointer++] = command[1].toInt()
            "pop" -> {
                if (pointer > 0) println(stack[pointer-- - 1])
                else println(-1)
            }
            "size" -> println(pointer)
            "empty" -> println(if (pointer == 0) 1 else 0)
            "top" -> {
                if (pointer > 0) println(stack[pointer - 1])
                else println(-1)
            }
        }
    }
}