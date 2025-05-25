package com.example.repository;

import com.example.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * teamsテーブルを操作するリポジトリクラス.
 *
 * @author sota.akahane
 */
@Repository
public class TeamRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * Teamオブジェクトを生成するRowMapper.
     */
    public static final RowMapper<Team> TEAM_ROW_MAPPER
            = (rs, i) -> {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setTeamName(rs.getString("team_name"));
        team.setHeadquarters(rs.getString("headquarters"));
        team.setInauguration(rs.getString("inauguration"));
        team.setHistory(rs.getString("history"));
        return team;
    };

    /**
     * 球団情報の一覧を発足日の昇順で取得する.
     *
     * @return 球団情報一覧
     */
    public List<Team> findAll() {
        String sql
                = "SELECT id, team_name, headquarters, inauguration, history " +
                "FROM teams ORDER BY inauguration;";

        return template.query(sql, TEAM_ROW_MAPPER);
    }

    /**
     * 主キーから球団情報を取得する.
     *
     * @param id teamsテーブルの主キー
     * @return 球団情報
     */
    public Team findById(Integer id) {
        String sql
                = "SELECT id, team_name, headquarters, inauguration, history " +
                "FROM teams WHERE id = :id;";

        SqlParameterSource params
                = new MapSqlParameterSource().addValue("id", id);

        return template.queryForObject(sql, params, TEAM_ROW_MAPPER);
    }
}
