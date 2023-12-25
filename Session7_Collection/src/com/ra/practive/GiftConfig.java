package com.ra.practive;

public class GiftConfig {
    private String giftCode;
    private String giftName;
    private String giftType;
    private double rate;
    private boolean free;
    private int limitTotal;
    private int limitPlayer;

    public GiftConfig() {
    }

    public GiftConfig(String giftCode, String giftName, String giftType, double rate, boolean free, int limitTotal, int limitPlayer) {
        this.giftCode = giftCode;
        this.giftName = giftName;
        this.giftType = giftType;
        this.rate = rate;
        this.free = free;
        this.limitTotal = limitTotal;
        this.limitPlayer = limitPlayer;
    }

    public String getGiftCode() {
        return giftCode;
    }

    public void setGiftCode(String giftCode) {
        this.giftCode = giftCode;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftType() {
        return giftType;
    }

    public void setGiftType(String giftType) {
        this.giftType = giftType;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getLimitTotal() {
        return limitTotal;
    }

    public void setLimitTotal(int limitTotal) {
        this.limitTotal = limitTotal;
    }

    public int getLimitPlayer() {
        return limitPlayer;
    }

    public void setLimitPlayer(int limitPlayer) {
        this.limitPlayer = limitPlayer;
    }
}
