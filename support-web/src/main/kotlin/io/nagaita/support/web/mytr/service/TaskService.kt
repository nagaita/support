package io.nagaita.support.web.mytr.service

import io.nagaita.support.web.mytr.repository.TrBoardRepository
import org.springframework.stereotype.Service

class Task(val id: Long, val title: String)

@Service
class TaskService(private val trBoardRepository: TrBoardRepository) {

    fun selectAll(): List<Task> {
        return listOf(Task(1L, "Task #1"), Task(2L, "Task #2"), Task(3L, "Task #3"))
    }

}