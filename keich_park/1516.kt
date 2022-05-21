fun main() {
    val n = readLine()?.toInt() ?: return

    val inOrder = Array(n) { 0 }
    val inList = Array(n) { mutableListOf<Int>() }
    val outList = Array(n) { mutableListOf<Int>() }
    val buildTime = Array(n) { 0 }
    val needTime = Array(n) { 0 }

    repeat(n) { i ->
        val inputs = readLine()?.split(' ')?.map { it.toInt() } ?: return
        buildTime[i] = inputs[0]
        if (inputs.size == 2) {
            buildTime[i] = inputs[0]
        } else {
            inputs.subList(1, inputs.size - 1).forEach { parent ->
                outList[parent - 1].add(i)
                inList[i].add(parent - 1)
                inOrder[i]++
            }
        }
    }

    while (inOrder.any { it >= 0 }) {
        inOrder.withIndex()
            .filter { (i, value) ->
                value == 0
            }
            .forEach { (i, value) ->
                if (inList[i].isEmpty()) {
                    needTime[i] = buildTime[i]
                } else {
                    needTime[i] = inList[i].maxOf {
                        needTime[it]
                    } + buildTime[i]
                }

                outList[i].forEach {
                    inOrder[it]--
                }

                inOrder[i]--
            }
    }
    needTime.forEach {
        println(it)
    }
}