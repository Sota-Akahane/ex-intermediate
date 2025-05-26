package com.example.repository;

import com.example.domain.Clothe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * clothesテーブルを操作するリポジトリクラス.
 *
 * @author sota.akahane
 */
@Repository
public class ClotheRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Clothe> CLOTHE_ROW_MAPPER
            = (rs, i) -> {
        Clothe clothe = new Clothe();
        clothe.setGender(rs.getInt("gender"));
        return clothe;
    };
}
