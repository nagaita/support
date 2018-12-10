package io.nagaita.support.web.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class BoardRepository(private val jdbcTemplate: JdbcTemplate) {

    fun selectAll(): List<String> {
        val list = jdbcTemplate.execute("select * from board")
        System.out.println(list)
        return listOf()
    }

}