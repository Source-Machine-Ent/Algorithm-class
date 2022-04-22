import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val queue = Array(10000) { 0 }
    var head = 0
    var tail = 0

    val n = reader.readLine().toInt()
    repeat(n) {
        val tokenizer = StringTokenizer(reader.readLine())

        when (tokenizer.nextToken()) {
            "push" -> queue[head++] = tokenizer.nextToken().toInt()
            "pop" -> writer.write("${if (head != tail) queue[tail++] else -1}\n")
            "size" -> writer.write("${head - tail}\n")
            "empty" -> writer.write("${if (head == tail) 1 else 0}\n")
            "front" -> writer.write("${if (head != tail) queue[tail] else -1}\n")
            "back" -> writer.write("${if (head != tail) queue[head-1] else -1}\n")
        }
    }

    writer.flush()
    writer.close()
}