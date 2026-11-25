package com.haier.uhome.account.model;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UacDeviceAddress {

    @b(name = "cityCode")
    private String cityCode;

    @b(name = "cityEName")
    private String cityEName;

    @b(name = "cityName")
    private String cityName;

    @b(name = "countryName")
    private String countryName;

    @b(name = "districtName")
    private String districtName;

    @b(name = "provinceName")
    private String provinceName;

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCityEName() {
        return this.cityEName;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public String getProvinceName() {
        return this.provinceName;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setCityEName(String str) {
        this.cityEName = str;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public void setDistrictName(String str) {
        this.districtName = str;
    }

    public void setProvinceName(String str) {
        this.provinceName = str;
    }
}
