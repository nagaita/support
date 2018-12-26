package io.nagaita.support.web.mytr.controller

import io.nagaita.support.web.mytr.service.TaskService
import io.nagaita.support.web.mytr.service.TrBoardService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/tr/boards")
class TrBoardController(
        private val taskService: TaskService,
        private val trBoardService: TrBoardService) {

    @GetMapping("/")
    fun list(model: Model): String {
        model.addAttribute("boardList", trBoardService.select())
        model.addAttribute("form", BoardForm())
        return "tr/board/list"
    }

    @PostMapping("/")
    fun create(@ModelAttribute("form") form: BoardForm): String {
        trBoardService.create(requireNotNull(form.title), requireNotNull(form.sortOrder))
        return "redirect:./"
    }

    @GetMapping("/{boardId}")
    fun view(@PathVariable boardId: Long, model: Model): String {
        model.addAttribute("board", trBoardService.select(boardId))
        return "tr/board/view"
    }


}

data class BoardForm(val title: String? = null, val sortOrder: Int? = null)