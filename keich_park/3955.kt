fun main() {
    val t = readLine()?.toInt() ?: return
    repeat(t) {
        val (k, c) = readLine()?.split(' ')?.map { it.toInt() } ?: return

        if (c == 1) {
            if (k+1 > 1000000000) println("IMPOSSIBLE")
            else println(k + 1)
        } else if (k == 1) {
            println(1)
        } else {
            val (gcd, s, t) = exEuclid(k, c)

            if (gcd != 1) {
                println("IMPOSSIBLE")
            } else {
                val result = (t % k + k) % k
                println(result)
            }
        }
    }
}

fun exEuclid(a: Int, b: Int): Triple<Int, Int, Int> {
    var q = 0
    var r = 0
    var r1 = a
    var r2 = b
    var s1 = 1
    var s2 = 0
    var s = 0
    var t1 = 0
    var t2 = 1
    var t = 0

    while (r2 > 0) {
        q = r1 / r2
        r = r1 - q * r2
        r1 = r2
        r2 = r

        s = s1 - q * s2
        s1 = s2
        s2 = s

        t = t1 - q * t2
        t1 = t2
        t2 = t
    }

    return Triple(r1, s1, t1)
}