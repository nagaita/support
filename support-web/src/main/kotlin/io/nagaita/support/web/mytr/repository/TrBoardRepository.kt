package io.nagaita.support.web.mytr.repository

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class TrBoardRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) {

    // TODO order by
    fun select(): List<TrBoardVo> {
        val sql = """
            |SELECT
            |  b.id         AS "board.id",
            |  b.title      AS "board.title",
            |  b.sort_order AS "board.sort_order"
            |FROM board b;
        """.trimMargin()
        val paramMap = MapSqlParameterSource()
        return jdbcTemplate.queryForList(sql, paramMap).map {
            TrBoardVo(
                    it["board.id"] as Long,
                    it["board.title"] as String,
                    it["board.sort_order"] as Int,
                    emptyList()
            )
        }
    }

    // TODO order by
    fun select(boardId: Long): TrBoardVo? {
        val sql = """
            |SELECT
            |  b.id         AS "board.id",
            |  b.title      AS "board.title",
            |  b.sort_order AS "board.sort_order",
            |  l.id         AS "list.id",
            |  l.title      AS "list.title",
            |  l.sort_order AS "list.sort_order",
            |  c.id         AS "card.id",
            |  c.title      AS "card.title",
            |  c.sort_order AS "card.sort_order"
            |FROM board b
            |  INNER JOIN list l ON b.id = l.board_id
            |  INNER JOIN card c ON l.id = c.list_id
            |WHERE b.id = :boardId;
        """.trimMargin()
        val paramMap = MapSqlParameterSource().apply {
            addValue("boardId", boardId)
        }
        return jdbcTemplate.queryForList(sql, paramMap).asSequence().map {
            JoinedRow(
                    it["board.id"] as Long,
                    it["board.title"] as String,
                    it["board.sort_order"] as Int,
                    it["list.id"] as Long,
                    it["list.title"] as String,
                    it["list.sort_order"] as Int,
                    it["card.id"] as Long,
                    it["card.title"] as String,
                    it["card.sort_order"] as Int
            )
        }.groupBy {
            it.boardId
        }.map { groupByBoard ->
            groupByBoard.value.asSequence().groupBy {
                it.listId
            }.map { groupByList ->
                groupByList.value.map { row ->
                    TrCardVo(row.cardId, row.cardTitle, row.cardSortOrder)
                }.let { cards ->
                    TrListVo(groupByList.value[0].listId, groupByList.value[0].listTitle, groupByList.value[0].listSortOrder, cards)
                }
            }.let { lists ->
                TrBoardVo(groupByBoard.value[0].boardId, groupByBoard.value[0].boardTitle, groupByBoard.value[0].boardSortOrder, lists)
            }
        }.firstOrNull()
    }

    fun insert(title: String, sortOrder: Int) {
        val sql = "INSERT INTO board (title, sort_order) VALUES (:title, :sortOrder);"
        val paramMap = MapSqlParameterSource().apply {
            addValue("title", title)
            addValue("sortOrder", sortOrder)
        }
        jdbcTemplate.update(sql, paramMap)
    }

}

private data class JoinedRow(
        val boardId: Long,
        val boardTitle: String,
        val boardSortOrder: Int,
        val listId: Long,
        val listTitle: String,
        val listSortOrder: Int,
        val cardId: Long,
        val cardTitle: String,
        val cardSortOrder: Int
)

data class TrBoardVo(
        val id: Long,
        val title: String,
        val sortOrder: Int,
        val trLists: List<TrListVo>
)

data class TrListVo(
        val id: Long,
        val title: String,
        val sortOrder: Int,
        val trCards: List<TrCardVo>)

data class TrCardVo(
        val id: Long,
        val title: String,
        val sortOrder: Int
)