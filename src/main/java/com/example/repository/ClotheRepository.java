package com.example.repository;

import com.example.domain.Clothe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * clothesテーブルを操作するリポジトリクラス.
 *
 * @author sota.akahane
 */
@Repository
public class ClotheRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * Clotheオブジェクトを生成するためのRowMapper
     */
    private static final RowMapper<Clothe> CLOTHE_ROW_MAPPER
            = (rs, i) -> {
        Clothe clothe = new Clothe();
        clothe.setId(rs.getInt("id"));
        clothe.setGenre(rs.getString("genre"));
        clothe.setGender(rs.getInt("gender"));
        clothe.setColor(rs.getString("color"));
        clothe.setPrice(rs.getInt("price"));
        clothe.setSize(rs.getString("size"));
        return clothe;
    };

    /**
     * 性別と色で衣類を検索する.
     *
     * @param gender 性別を表すコード
     * @param color  色
     * @return 条件に合致する衣類
     */
    public List<Clothe> findByColorAndGender(Integer gender, String color) {
        String sql = """
                SELECT id, genre, gender, color, size, price FROM clothes
                 WHERE gender = :gender AND color = :color ORDER BY price
                """;

        SqlParameterSource param
                = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);

        return template.query(sql, param, CLOTHE_ROW_MAPPER);
    }
}
