package com.gumio_inf.ramen

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class RamenApplication

fun main(args: Array<String>) {
    SpringApplication.run(RamenApplication::class.java, *args)
}