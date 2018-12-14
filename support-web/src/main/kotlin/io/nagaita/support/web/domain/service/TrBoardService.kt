package io.nagaita.support.web.domain.service

import io.nagaita.support.web.repository.TrBoardRepository
import io.nagaita.support.web.repository.TrBoardVo
import org.springframework.stereotype.Service

@Service
class TrBoardService(val trBoardRepository: TrBoardRepository) {

    fun select(): List<TrBoardVo> {
        return trBoardRepository.select()
    }

    fun select(id: Long): TrBoardVo? {
        return trBoardRepository.select(id)
    }
}