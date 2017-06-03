package com.gumio_inf.ramen.service

import com.gumio_inf.ramen.domain.Ramen
import com.gumio_inf.ramen.repository.RamenRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by gumio_inf on 2017/05/12.
 */
@Service
@Transactional
class RamenService {
    @Autowired val ramenRepository: RamenRepository? = null

    fun findAll(): List<Ramen>? = ramenRepository?.findAll()
    fun findAllPage(pageable: Pageable): Page<Ramen>? = ramenRepository?.findAllOrderByNamePage(pageable)
    fun findOne(id: Int): Ramen? = ramenRepository?.findOne(id)
    fun create(ramen: Ramen): Ramen? = ramenRepository?.save(ramen)
    fun update(ramen: Ramen): Ramen? =  ramenRepository?.save(ramen)
    fun delete(id: Int) = ramenRepository?.delete(id)
}