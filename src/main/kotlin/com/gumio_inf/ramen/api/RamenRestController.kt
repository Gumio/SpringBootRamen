package com.gumio_inf.ramen.api

import com.gumio_inf.ramen.domain.Ramen
import com.gumio_inf.ramen.service.RamenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

/**
 * Created by gumio_inf on 2017/05/15.
 */
@RestController
@RequestMapping("api/ramens")
class RamenRestController {
    // 注入
    @Autowired val ramenService: RamenService? = null

    // 全取得
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getRamens(@PageableDefault pageable: Pageable): Page<Ramen>? = ramenService?.findAllPage(pageable)

    // 1件の取得
    @RequestMapping(value = "{id}", method = arrayOf(RequestMethod.GET))
    fun getRamen(@PathVariable id: Int): Ramen? = ramenService?.findOne(id)

    // 新規作成
    @RequestMapping(method = arrayOf(RequestMethod.POST))
    @ResponseStatus(HttpStatus.CREATED)
    fun postRamens(@RequestBody ramen: Ramen, uriBuilder: UriComponentsBuilder): ResponseEntity<Ramen?> {
        val created = ramenService?.create(ramen)
        val headers = HttpHeaders()
        headers.location = uriBuilder.path("api/ramens/{id}").buildAndExpand(created?.id).toUri()
        return ResponseEntity(created, headers, HttpStatus.CREATED)
    }

    // １件更新
    @RequestMapping(value = "{id}", method = arrayOf(RequestMethod.PUT))
    fun putRamen(@PathVariable id: Int, @RequestBody ramen: Ramen): Ramen? {
        ramen.id = id
        return ramenService?.update(ramen)
    }

    // １件削除
    @RequestMapping(value = "{id}", method = arrayOf(RequestMethod.DELETE))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteRamen(@PathVariable id: Int) {
        ramenService?.delete(id)
    }
}