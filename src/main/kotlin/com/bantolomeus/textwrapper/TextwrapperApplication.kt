package com.bantolomeus.textwrapper

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TextwrapperApplication

    val splitter = Splitter()

    fun main(args: Array<String>) {
        runApplication<TextwrapperApplication>(*args)
        System.out.println(splitter.split("Es blaut die Nacht,\n" +
                "die Sternlein blinken,\n" +
                "Schneeflöcklein leis hernieder sinken.", 9))
    }



