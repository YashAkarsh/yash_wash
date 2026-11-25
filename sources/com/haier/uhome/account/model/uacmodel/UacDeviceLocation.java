package com.haier.uhome.account.model.uacmodel;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UacDeviceLocation {

    @b(name = "latitude")
    private String latitude;

    @b(name = "longitude")
    private String longitude;

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }
}
