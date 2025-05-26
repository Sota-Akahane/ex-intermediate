package com.example.domain;

/**
 * 衣服を表すドメインクラス.
 *
 * @author sota.akahane
 */
public class Clothe {
    /** 性別 */
    private Integer gender;
    /** 色 */
    private String color;

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
