package io.nagaita.support.web.controller

import io.nagaita.support.web.domain.service.TaskService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class IndexController(private val taskService: TaskService) {

    @GetMapping
    fun show(model: Model): String {
        model.addAttribute("tasks", taskService.selectAll())
        return "index"
    }

}