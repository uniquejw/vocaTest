package com.example.board.dto;

public class WordCateDto {
    int cateId;
    String cateType;
    int cateDay;
    String cateTitle;

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateType() {
        return cateType;
    }

    public void setCateType(String cateType) {
        this.cateType = cateType;
    }

    public int getCateDay() {
        return cateDay;
    }

    public void setCateDay(int cateDay) {
        this.cateDay = cateDay;
    }

    public String getCateTitle() {
        return cateTitle;
    }

    public void setCateTitle(String cateTitle) {
        this.cateTitle = cateTitle;
    }
}
