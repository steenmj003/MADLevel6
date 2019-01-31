package com.hva.joris.madlevel6;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuoteItem {

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("year")
    @Expose
    private Integer year;

    @SerializedName("number")
    @Expose
    private Integer number;

    @SerializedName("found")
    @Expose
    private Boolean found;

    @SerializedName("type")
    @Expose
    private String type;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
