package com.wiysoft.cocoon.rawparser.model;

import java.util.Date;

/**
 * Created by weiliyang on 6/19/15.
 */
public final class Entry {

    public static final String TYPE_BUY = "买盘";
    public static final String TYPE_SELL = "卖盘";

    private Date date;
    private double price;
    private double change;
    private double changePercentage;
    private long volume;
    private long value;
    private String type;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(double changePercentage) {
        this.changePercentage = changePercentage;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
