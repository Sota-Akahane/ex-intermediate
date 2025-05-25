package com.example.service;

import com.example.domain.Team;
import com.example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 球団情報関連の業務処理を行うサービスクラス.
 *
 * @author sota.akahane
 */
@Service
@Transactional
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    /**
     * 球団情報一覧を取得する.
     *
     * @return 球団情報一覧
     */
    public List<Team> showList() {

        return teamRepository.findAll();
    }

    /**
     * 球団の詳細情報を取得する.
     *
     * @param id teamsテーブルの主キー
     * @return 球団情報
     */
    public Team showDetail(Integer id) {

        return teamRepository.findById(id);
    }
}
