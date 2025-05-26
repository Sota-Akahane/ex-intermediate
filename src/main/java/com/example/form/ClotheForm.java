package com.example.form;

import jakarta.validation.constraints.NotEmpty;

public class ClotheForm {
    @NotEmpty(message = "性別を選択してください。")
    private String gender;
    @NotEmpty(message = "色を選択してください。")
    private String color;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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
        return "ClotheForm{" +
                "gender='" + gender + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
