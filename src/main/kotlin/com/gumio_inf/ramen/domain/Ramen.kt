package com.gumio_inf.ramen.domain

import javax.persistence.*

/**
 * Created by gumio_inf on 2017/05/12.
 */
@Entity
@Table(name = "ramens")
data class Ramen(
        @Id
        @GeneratedValue
        var id: Int? = null,
        var name: String = "",
        var taste: String = ""
)