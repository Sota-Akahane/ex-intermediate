package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import com.example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ホテル検索の処理を行うサービスクラス.
 *
 * @author sota.akahane
 */
@Service
@Transactional
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    /**
     * 引数に渡された価格以下のホテルを検索する.
     *
     * @param price 価格
     * @return 全ホテル情報一覧
     */
    public List<Hotel> searchByLessThan(String price) {
        List<Hotel> hotelList = null;
        if (price.isEmpty()) {
            hotelList = hotelRepository.findAll();
        } else {
            hotelList = hotelRepository.findByPrice(Integer.parseInt(price));
        }

        return hotelList;
    }
}
