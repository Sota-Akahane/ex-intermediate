package com.example.service;

import com.example.domain.Clothe;
import com.example.repository.ClotheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 衣類検索機能関連の業務処理を行うサービスクラス.
 *
 * @author sota.akahane
 */
@Service
@Transactional
public class ClotheService {
    @Autowired
    private ClotheRepository clotheRepository;

    /**
     * 性別と色から衣類を検索する.
     *
     * @param gender 性別を表すコード
     * @param color  色
     * @return 条件に合致する衣類
     */
    public List<Clothe> searchByColorAndGender(Integer gender, String color) {
        return clotheRepository.findByColorAndGender(gender, color);
    }
}
