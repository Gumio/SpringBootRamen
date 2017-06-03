package com.gumio_inf.ramen.web

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by gumio_inf on 2017/05/16.
 */
data class RamenForm(
        @NotNull
        @Size(min = 1, max = 127)
        var name: String = "",
        @NotNull
        @Size(min = 1, max = 127)
        var taste: String = ""
)