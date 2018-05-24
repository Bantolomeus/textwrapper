package com.bantolomeus.textwrapper

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class TextwrapperApplicationTests {

    private val textWrapper = Splitter()

    val inputText = "Es blaut die Nacht,\n" +
            "die Sternlein blinken,\n" +
            "Schneeflöcklein leis hernieder sinken."

    @Test
    fun splittingWithNine(){

        val expectedText =
                "Es blaut \n" +
                "die \n" +
                "Nacht, \n" +
                "die \n" +
                "Sternlein \n" +
                "blinken, \n" +
                "Schneeflö \n" +
                "cklein \n" +
                "leis \n" +
                "hernieder \n" +
                "sinken."

        val actualText = textWrapper.split(inputText, 9)

        Assert.assertEquals(expectedText, actualText)
    }

    @Test
    fun splittingWith14(){

        val expectedText =
                "Es blaut die \n" +
                "Nacht, die \n" +
                "Sternlein \n" +
                "blinken, \n" +
                "Schneeflöcklei \n" +
                "n leis \n" +
                "hernieder \n" +
                "sinken."

        val actualText = textWrapper.split(inputText, 14)

        Assert.assertEquals(expectedText, actualText)
    }

    @Test
    fun splittingWith1000(){

        val expectedText = "Es blaut die Nacht, die Sternlein blinken, Schneeflöcklein leis hernieder sinken."

        val actualText = textWrapper.split(inputText, 1000)

        Assert.assertEquals(expectedText, actualText)
    }
}
