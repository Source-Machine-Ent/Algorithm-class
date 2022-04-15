import kotlin.math.abs

fun main() {
    while (true) {
        val commandList = readCommand() ?: return
        val n = readLine()?.toInt() ?: return
        repeat(n) {
            val v = readLine()?.toLong() ?: return
            println(executeCommand(commandList, v) ?: "ERROR")
        }
        readLine()
        println()
    }
}

fun readCommand(): List<String>? {
    val commandList = mutableListOf<String>()
    while (true) {
        val command = readLine() ?: break
        commandList.add(command)
        if (command == "END") break
        if (command == "QUIT") return null
    }
    return commandList
}

fun executeCommand(commandList: List<String>, initNumber: Long): Long? {
    val stack = Array(1000) { 0L }
    stack[0] = initNumber
    var pointer = 1

    for (command in commandList) {
        val core = command.substring(0..2)
        when {
            core == "END" -> break
            core == "NUM" -> stack[pointer++] = command.substring(4).toLong()

            pointer < 1 -> return null
            core == "POP" -> pointer--
            core == "INV" -> stack[pointer - 1] = -stack[pointer - 1]
            core == "DUP" -> stack[pointer] = stack[pointer++ - 1]

            pointer < 2 -> return null
            core == "SWP" -> {
                val temp = stack[pointer - 1]
                stack[pointer - 1] = stack[pointer - 2]
                stack[pointer - 2] = temp
            }
            core == "ADD" -> {
                stack[pointer - 2] = stack[pointer - 2] + stack[pointer-- - 1]
                if (abs(stack[pointer - 1]) > 1000000000) return null
            }
            core == "SUB" -> {
                stack[pointer - 2] = stack[pointer - 2] - stack[pointer-- - 1]
                if (abs(stack[pointer - 1]) > 1000000000) return null
            }
            core == "MUL" -> {
                stack[pointer - 2] = stack[pointer - 2] * stack[pointer-- - 1]
                if (abs(stack[pointer - 1]) > 1000000000) return null
            }

            stack[pointer - 1] == 0L -> return null
            core == "DIV" -> {
                val sign = if (stack[pointer - 2] * stack[pointer - 1] >= 0) 1 else -1
                stack[pointer - 2] = abs(stack[pointer - 2]) / abs(stack[pointer-- - 1]) * sign
            }
            core == "MOD" -> {
                val sign = if (stack[pointer - 2] >= 0) 1 else -1
                stack[pointer - 2] = abs(stack[pointer - 2]) % abs(stack[pointer-- - 1]) * sign
            }
        }
    }

    return if (pointer == 1) stack[0] else null
}