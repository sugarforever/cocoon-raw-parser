package com.wiysoft.cocoon.rawparser.model;

import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * Created by weiliyang on 6/19/15.
 */
public final class Entry {

    public static final String TYPE_BUY = "买盘";
    public static final String TYPE_SELL = "卖盘";
    public static final String TYPE_NEUTRAL = "中性盘";

    private Date date;
    private float price;
    private float change;
    private float changePercentage;
    private long volume;
    private long value;
    private String type;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public float getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(float changePercentage) {
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
        if (StringUtils.equals(type, TYPE_BUY))
            this.type = "b";
        else if (StringUtils.equals(type, TYPE_SELL))
            this.type = "s";
        else if (StringUtils.equals(type, TYPE_NEUTRAL))
            this.type = "n";
        else
            this.type = "-";
    }
}
