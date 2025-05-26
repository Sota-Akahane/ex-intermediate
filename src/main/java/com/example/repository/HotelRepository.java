package com.example.repository;

import com.example.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * hotelsテーブルを操作するリポジトリクラス.
 *
 * @author sota.akahane
 */
@Repository
public class HotelRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * Hotelオブジェクトを生成するRowMapper.
     */
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER
            = (rs, i) -> {
        Hotel hotel = new Hotel();
        hotel.setHotelName(rs.getString("hotel_name"));
        hotel.setNearestStation(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        return hotel;
    };

    /**
     * ホテル一覧を取得する.
     *
     * @return ホテル情報一覧
     */
    public List<Hotel> findAll() {
        String sql
                = "SELECT id, hotel_name, nearest_station, price FROM hotels " +
                "ORDER BY price DESC;";

        return template.query(sql, HOTEL_ROW_MAPPER);
    }

    /**
     * 引数に渡したprice以下の価格のホテル一覧を取得する.
     *
     * @param price 価格
     * @return 条件に合致するホテル情報一覧
     */
    public List<Hotel> findByPrice(Integer price) {
        String sql
                = "SELECT id, hotel_name, nearest_station, price FROM hotels " +
                "WHERE price <= :price ORDER BY price;";

        SqlParameterSource param
                = new MapSqlParameterSource().addValue("price", price);

        return template.query(sql, param, HOTEL_ROW_MAPPER);
    }
}
