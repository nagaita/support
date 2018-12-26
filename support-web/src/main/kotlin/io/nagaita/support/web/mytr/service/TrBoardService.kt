package io.nagaita.support.web.mytr.service

import io.nagaita.support.web.mytr.repository.TrBoardRepository
import io.nagaita.support.web.mytr.repository.TrBoardVo
import org.springframework.stereotype.Service

@Service
class TrBoardService(val trBoardRepository: TrBoardRepository) {

    fun select(): List<TrBoardVo> {
        return trBoardRepository.select()
    }

    fun select(id: Long): TrBoardVo? {
        return trBoardRepository.select(id)
    }

    fun create(title: String, sortOrder: Int) {
        trBoardRepository.insert(title, sortOrder)
    }
}