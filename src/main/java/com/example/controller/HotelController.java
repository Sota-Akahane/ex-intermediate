package com.example.controller;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * ホテル検索機能の制御を行うコントローラクラス.
 *
 * @author sota.akahane
 */
@Controller
@RequestMapping("/ex02")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    /**
     * ホテル検索画面を表示する.
     *
     * @param form 入力値チェック用のフォームオブジェクト
     * @return ホテル検索画面にフォワード
     */
    @GetMapping("/toSearch")
    public String toSearch(HotelForm form) {
        return "hotel-search";
    }

    /**
     * 入力値以下の価格のホテルを表示する.
     * もし空文字が入力値なら、全件を表示する。
     *
     * @param form               入力値チェック用のフォームオブジェクト
     * @param result             入力値チェックのエラーを格納する
     * @param redirectAttributes フラッシュスコープ
     * @return ホテル検索画面にリダイレクト
     */
    @PostMapping("/search")
    public String search(@Validated HotelForm form,
                         BindingResult result,
                         RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return toSearch(form);
        }

        List<Hotel> hotelList = hotelService.searchByLessThan(form.getPrice());
        if (hotelList.isEmpty()) {
            redirectAttributes.addFlashAttribute("nonexistError",
                    "その価格のホテルは存在しません。");
        }

        redirectAttributes.addFlashAttribute("hotelList", hotelList);

        return "redirect:/ex02/toSearch";
    }
}
