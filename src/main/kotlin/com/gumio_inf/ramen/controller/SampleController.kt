package com.gumio_inf.ramen.controller

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

@Component
@RequestMapping("/ramen")
class SampleController {

    @GetMapping("hello")
    @ResponseBody
    fun hello(): String {
        return "hello world!"
    }
}