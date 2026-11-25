package com.haier.uhome.config.json.req;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class WithoutWifi {

    @b(name = "randomNumber")
    private int randomNum;

    @b(name = "sessionKey")
    private String sessionKey;

    public int getRandomNum() {
        return this.randomNum;
    }

    public String getSessionKey() {
        return this.sessionKey;
    }

    public void setRandomNum(int i7) {
        this.randomNum = i7;
    }

    public void setSessionKey(String str) {
        this.sessionKey = str;
    }

    public String toString() {
        return "WithoutWifi{sessionKey='" + this.sessionKey + "', randomNum=" + this.randomNum + '}';
    }
}
