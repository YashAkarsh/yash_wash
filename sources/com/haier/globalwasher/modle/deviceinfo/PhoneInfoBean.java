package com.haier.globalwasher.modle.deviceinfo;

import android.os.Build;
import v2.a;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneInfoBean {
    private String deviecId;
    private String id;
    private String serial;
    private String tags;
    private String appVersion = a.a();
    private String brand = Build.BRAND;
    private String model = Build.MODEL;
    private String deviceVersion = Build.VERSION.RELEASE;
    private String product = Build.PRODUCT;
    private String manufacturer = Build.MANUFACTURER;
    private String board = Build.BOARD;
    private String device = Build.DEVICE;
    private String display = Build.DISPLAY;

    public PhoneInfoBean() {
        String str = Build.ID;
        this.id = str;
        this.serial = str;
        this.tags = Build.TAGS;
        this.deviecId = Build.FINGERPRINT;
    }

    public String getBoard() {
        return this.board;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getDevice() {
        return this.device;
    }

    public String getDeviceVersion() {
        return this.deviceVersion;
    }

    public String getDeviecId() {
        return this.deviecId;
    }

    public String getDisplay() {
        return this.display;
    }

    public String getId() {
        return this.id;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public String getProduct() {
        return this.product;
    }

    public String getSerial() {
        return this.serial;
    }

    public String getTags() {
        return this.tags;
    }

    public String toString() {
        return "PhoneInfoBean{appVersion='" + this.appVersion + "', brand='" + this.brand + "', model='" + this.model + "', deviceVersion='" + this.deviceVersion + "', product='" + this.product + "', manufacturer='" + this.manufacturer + "', board='" + this.board + "', device='" + this.device + "', display='" + this.display + "', id='" + this.id + "', serial='" + this.serial + "', tags='" + this.tags + "', deviecId='" + this.deviecId + "'}";
    }
}
