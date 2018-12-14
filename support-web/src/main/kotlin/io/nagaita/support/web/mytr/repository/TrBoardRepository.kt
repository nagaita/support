package io.nagaita.support.web.mytr.repository

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class TrBoardRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) {

    // TODO order by
    fun select(): List<TrBoardVo> {
        val sql = buildString {
            appendln("SELECT b.id, b.title, b.sort_order FROM board b;")
        }
        val paramMap = MapSqlParameterSource()
        return jdbcTemplate.queryForList(sql, paramMap).map {
            TrBoardVo(
                    it["id"] as Long,
                    it["title"] as String,
                    it["sort_order"] as Int,
                    emptyList()
            )
        }
    }

    // TODO order by
    // TODO want to select at only once
    // TODO not use copy for performance
    fun select(id: Long): TrBoardVo? {
        val board = selectBoard(id) ?: return null
        val lists = selectList(board.id)
        val cards = selectCard(lists.map { it.id })
        val listWithCards = lists.map { list ->
            list.copy(trCards = cards.filter { card -> list.id == card.listId })
        }
        return board.copy(trLists = listWithCards)
    }

    private fun selectBoard(id: Long): TrBoardVo? {
        val sql = buildString {
            append("SELECT b.id, b.title, b.sort_order FROM board b WHERE b.id = :id;")
        }
        val paramMap = MapSqlParameterSource().apply {
            addValue("id", id)
        }
        return jdbcTemplate.queryForObject(sql, paramMap) { resultSet: ResultSet, _ ->
            TrBoardVo(
                    resultSet.getLong("id"),
                    resultSet.getString("title"),
                    resultSet.getInt("sort_order"),
                    emptyList()
            )
        }
    }

    // TODO add index for foreign keys
    private fun selectList(boardId: Long): List<TrListVo> {
        val sql = buildString {
            appendln("SELECT l.id, l.board_id, l.title, l.sort_order FROM list l WHERE l.board_id = :boardId")
        }
        val paramMap = MapSqlParameterSource().apply {
            addValue("boardId", boardId)
        }
        return jdbcTemplate.queryForList(sql, paramMap).map {
            TrListVo(
                    it["id"] as Long,
                    it["board_id"] as Long,
                    it["title"] as String,
                    it["sort_order"] as Int,
                    emptyList()
            )
        }
    }

    // TODO add index for foreign keys
    private fun selectCard(listIds: List<Long>): List<TrCardVo> {
        val sql = buildString {
            appendln("SELECT c.id, c.list_id, c.title, c.sort_order FROM card c WHERE c.list_id in (:listIds);")
        }
        val paramMap = MapSqlParameterSource().apply {
            addValue("listIds", listIds)
        }
        return jdbcTemplate.queryForList(sql, paramMap).map {
            TrCardVo(
                    it["id"] as Long,
                    it["list_id"] as Long,
                    it["title"] as String,
                    it["sort_order"] as Int
            )
        }
    }

}

data class TrBoardVo(
        val id: Long,
        val title: String,
        val sortOrder: Int,
        val trLists: List<TrListVo>
)

data class TrListVo(
        val id: Long,
        val boardId: Long, // TODO remove after modifying the way to select data from DB
        val title: String,
        val sortOrder: Int,
        val trCards: List<TrCardVo>)

data class TrCardVo(
        val id: Long,
        val listId: Long, // TODO remove after modifying the way to select data from DB
        val title: String,
        val sortOrder: Int
)