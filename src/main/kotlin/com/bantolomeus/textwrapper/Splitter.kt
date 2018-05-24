package com.bantolomeus.textwrapper

open class Splitter {

    private val lineBreak = "\n"
    private val space = " "

    fun split(text: String, maxRowLength: Int): String {

        var inputWithoutLineBreaks = text.replace(lineBreak, space)
        var result = ""

        if (inputWithoutLineBreaks.length <= maxRowLength) return inputWithoutLineBreaks

        while (inputWithoutLineBreaks.isNotEmpty()) {
            if (inputWithoutLineBreaks[0] == ' ') {
                inputWithoutLineBreaks = inputWithoutLineBreaks.substring(1)
            }
            if (inputWithoutLineBreaks.length <= maxRowLength) {
                result += inputWithoutLineBreaks
                return result
            }
            val lastSpaceInRow = inputWithoutLineBreaks.substring(0, maxRowLength).lastIndexOf(space)

            if (lastSpaceInRow == -1) {
                result += inputWithoutLineBreaks.substring(0, maxRowLength) + space + lineBreak
                inputWithoutLineBreaks = inputWithoutLineBreaks.substring(maxRowLength)
            } else {
                result += inputWithoutLineBreaks.substring(0, lastSpaceInRow + 1) + lineBreak
                inputWithoutLineBreaks = inputWithoutLineBreaks.substring(lastSpaceInRow + 1)
            }
        }
        return result
    }
}
