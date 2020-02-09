import java.io.File

fun main(args : Array<String>) {
    println("What time is it? It's MATH TIME!")

    val rand = java.util.Random()
    val builder = StringBuilder()

    builder.appendln("\\documentclass{article}")
    builder.appendln("\\usepackage[margin=0.5in]{geometry}")
    builder.appendln("\\title{Math Problems for Ronan, and Only Ronan}")

    builder.appendln("\\begin{document}")
    builder.appendln("\\maketitle")
    builder.appendln("\\begin{huge}")
    builder.appendln("\\noindent")

    for (i in 0 until 5) {
        for (j in 0 until 8) {
            appendTwoDigitAdditionProblem(builder, rand.nextInt(100), rand.nextInt(100))
            builder.appendln("\\enspace")
        }
        builder.appendln("\\\\[40pt]")
    }

    builder.appendln("\\end{huge}")
    builder.appendln("\\end{document}")

    writeToFile("myfile.tex", builder.toString())
}

fun appendTwoDigitAdditionProblem(builder: StringBuilder, num1: Int, num2: Int) {
    require(num1 in 0..99) { "Arguments must be within the range 0..99" }
    require(num2 in 0..99) { "Arguments must be within the range 0..99" }

    builder.appendln("\\begin{tabular}{c@{\\,}c@{\\,}c}")
    builder.appendln("  & ${if (num1 / 10 == 0) " " else num1 / 10 } & ${num1 % 10} \\\\")
    builder.appendln("+ & ${if (num2 / 10 == 0) " " else num2 / 10 } & ${num2 % 10} \\\\")
    builder.appendln("\\hline")
    builder.appendln("  &   &   \\\\")
    builder.appendln("\\end{tabular}")
}

fun writeToFile(filename: String, content: String) {
    File(filename).printWriter().use { out ->
        out.print(content)
    }
}