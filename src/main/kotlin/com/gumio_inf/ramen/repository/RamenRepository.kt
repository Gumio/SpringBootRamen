package com.gumio_inf.ramen.repository

import com.gumio_inf.ramen.domain.Ramen
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

/**
 * Created by gumio_inf on 2017/05/12.
 */

@Repository
interface RamenRepository: JpaRepository<Ramen, Int> {
    @Query("SELECT x FROM Ramen x ORDER BY x.name, x.taste")
    fun findAllOrderByNamePage(pageable: Pageable): Page<Ramen>
}