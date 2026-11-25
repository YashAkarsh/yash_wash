package com.haier.uhome.account.model.geamodel;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class GEALocation {

    @b(name = "cityCode")
    private String cityCode;

    @b(name = "latitude")
    private Double latitude;

    @b(name = "longitude")
    private Double longitude;

    public String getCityCode() {
        return this.cityCode;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setLatitude(Double d8) {
        this.latitude = d8;
    }

    public void setLongitude(Double d8) {
        this.longitude = d8;
    }
}
