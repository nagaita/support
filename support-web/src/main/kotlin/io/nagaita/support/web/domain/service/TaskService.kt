package io.nagaita.support.web.domain.service

import io.nagaita.support.web.repository.BoardRepository
import org.springframework.stereotype.Service

class Task(val id: Long, val title: String)

@Service
class TaskService(private val boardRepository: BoardRepository) {

    fun selectAll(): List<Task> {
        boardRepository.selectAll()
        return listOf(Task(1L, "Task #1"), Task(2L, "Task #2"), Task(3L, "Task #3"))
    }

}