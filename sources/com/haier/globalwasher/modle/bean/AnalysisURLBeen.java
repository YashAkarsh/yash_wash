package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AnalysisURLBeen implements Serializable {
    private String deviceRQ;
    private String type;
    private String url;

    public String getDeviceRQ() {
        return this.deviceRQ;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setDeviceRQ(String str) {
        this.deviceRQ = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "AnalysisURLBeen{type='" + this.type + "', deviceRQ='" + this.deviceRQ + "', url='" + this.url + "'}";
    }
}
