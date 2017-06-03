package com.gumio_inf.ramen

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class RamenApplication /* {

   @Autowired val ramenRepository: RamenRepository? = null

    override fun run(vararg args: String?) {
        // データ追加
        val created: Ramen? = ramenRepository?.save(Ramen(null, "Gumioo", "Gumimi"))
        println("${created} is created")
        // ページング処理
        val pageable = PageRequest(0, 3)
        val page = ramenRepository?.findAll(pageable)
        // データ表示
        ramenRepository?.findAll()?.forEach { println(it) }
    }
}*/
fun main(args: Array<String>) {
    SpringApplication.run(RamenApplication::class.java, *args)
}