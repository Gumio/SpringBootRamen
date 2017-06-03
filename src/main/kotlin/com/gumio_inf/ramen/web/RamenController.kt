package com.gumio_inf.ramen.api

import com.gumio_inf.ramen.domain.Ramen
import com.gumio_inf.ramen.service.RamenService
import com.gumio_inf.ramen.web.RamenForm
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 * Created by gumio_inf on 2017/05/15.
 */
@Controller
@RequestMapping("ramens")
class RamenController {
    @Autowired val ramenService: RamenService? = null

    @ModelAttribute
    fun setupForm(): RamenForm = RamenForm()

    // 顧客全取得
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun list(model: Model): String {
        val ramens = ramenService?.findAll()
        model.addAttribute("ramens", ramens)
        return "ramens/list"
    }

    // 顧客新規作成
    @RequestMapping(value = "create", method = arrayOf(RequestMethod.POST))
    fun create(@Validated form: RamenForm, result: BindingResult, model: Model): String {

        if (result.hasErrors()) return list(model)
        val ramen = Ramen()
        BeanUtils.copyProperties(form, ramen)
        ramenService?.create(ramen)
        return "redirect:/ramens"
    }

    @RequestMapping(value = "edit", params = arrayOf("form"), method = arrayOf(RequestMethod.GET))
    fun editForm(@RequestParam id: Int, form: RamenForm): String {
        val ramen = ramenService?.findOne(id)
        BeanUtils.copyProperties(ramen, form)
        return "ramens/edit"
    }

    @RequestMapping(value = "edit", method = arrayOf(RequestMethod.POST))
    fun edit(@RequestParam id: Int, @Validated form: RamenForm, result: BindingResult): String {
        if (result.hasErrors()) return editForm(id, form)

        val ramen = Ramen()
        BeanUtils.copyProperties(form, ramen)
        ramen.id = id
        ramenService?.update(ramen)
        return "redirect:/ramens"
    }

    @RequestMapping(value = "edit", params = arrayOf("goToTop"))
    fun goToTop(): String = "redirect:/ramens"

    @RequestMapping(value = "delete", method = arrayOf(RequestMethod.POST))
    fun delete(@RequestParam id: Int): String {
        ramenService?.delete(id)
        return "redirect:/ramens"
    }
}