package com.example.form;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;

/**
 * ホテル検索時に使用するフォーム.
 *
 * @author sota.akahane
 */
public class HotelForm {
    @Pattern(regexp = "^$|^[+-]?\\d{1,7}$", message = "不正な値です。")
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HotelForm{" +
                "price='" + price + '\'' +
                '}';
    }
}
