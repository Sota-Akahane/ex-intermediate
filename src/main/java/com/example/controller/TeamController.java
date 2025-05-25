package com.example.controller;

import com.example.domain.Team;
import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 球団情報関連の処理の制御を行うコントローラクラス.
 *
 * @author sota.akahane
 */
@Controller
@RequestMapping("/ex01")
public class TeamController {
    @Autowired
    private TeamService teamService;

    /**
     * 球団情報一覧を表示する.
     *
     * @param model リクエストスコープ
     * @return 球団情報一覧画面にフォワード
     */
    @GetMapping("showList")
    public String showList(Model model) {
        List<Team> teamList
                = teamService.showList();

        model.addAttribute("teamList", teamList);

        return "list";
    }

    /**
     * 引数に受け取ったIDの球団の詳細情報を表示する.
     *
     * @param id    teamsテーブルの主キー
     * @param model リクエストスコープ
     * @return 球団の詳細情報画面にフォワード
     */
    @GetMapping("showDetail")
    public String showDetail(String id, Model model) {
        Integer intId = Integer.parseInt(id);

        Team team
                = teamService.showDetail(intId);

        model.addAttribute("team", team);

        return "detail";
    }
}
