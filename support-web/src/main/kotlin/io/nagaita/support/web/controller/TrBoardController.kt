package io.nagaita.support.web.controller

import io.nagaita.support.web.domain.service.TaskService
import io.nagaita.support.web.domain.service.TrBoardService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/tr/boards")
class TrBoardController(
        private val taskService: TaskService,
        private val trBoardService: TrBoardService) {

    @GetMapping("/")
    fun list(model: Model): String {
        model.addAttribute("boardList", trBoardService.select())
        return "tr/board/list"
    }

    @GetMapping("/{boardId}")
    fun view(@PathVariable boardId: Long, model: Model): String {
        model.addAttribute("board", trBoardService.select(boardId))
        return "tr/board/view"
    }

}