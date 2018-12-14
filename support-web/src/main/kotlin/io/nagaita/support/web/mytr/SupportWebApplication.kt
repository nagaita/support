package io.nagaita.support.web.mytr

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SupportWebApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SupportWebApplication::class.java, *args)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SupportWebApplication>(*args)
}
