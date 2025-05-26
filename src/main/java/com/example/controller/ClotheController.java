package com.example.controller;

import com.example.domain.Clothe;
import com.example.form.ClotheForm;
import com.example.service.ClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 衣類検索機能関連の処理を行うコントローラクラス.
 *
 * @author sota.akahane
 */
@Controller
@RequestMapping("/ex03")
public class ClotheController {
    @Autowired
    private ClotheService clotheService;

    @GetMapping("/toSearch")
    public String toSearch(ClotheForm form) {
        return "clothe-search";
    }

    @PostMapping("/search")
    public String search(@Validated ClotheForm form,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            return toSearch(form);
        }

        Integer genderCode = Integer.parseInt(form.getGender());

        List<Clothe> clotheList
                = clotheService.searchByColorAndGender(genderCode, form.getColor());

        if (clotheList.isEmpty()) {
            model.addAttribute("nonexistError", "該当する衣類は存在しません。");
        }

        model.addAttribute("clotheList", clotheList);

        return "clothe-search";
    }
}
