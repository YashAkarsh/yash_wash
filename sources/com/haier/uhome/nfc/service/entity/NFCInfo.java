package com.haier.uhome.nfc.service.entity;

import com.haier.globalwasher.presenter.o;
import com.haier.uhome.usdk.base.annotation.Keep;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class NFCInfo {

    @b(name = "mac")
    private String MAC;

    @b(name = "nfcSerialNumber")
    private String NFCSerialNumber;
    private String custom;

    @b(name = o.f25218y)
    private String deviceID;

    @b(name = "hwProductId")
    private String hwProductID;
    private String productCode;

    public static NFCInfo of(String str, String str2, String str3, String str4, String str5) {
        NFCInfo nFCInfo = new NFCInfo();
        nFCInfo.NFCSerialNumber = str;
        nFCInfo.MAC = str2;
        nFCInfo.productCode = str3;
        nFCInfo.hwProductID = str4;
        nFCInfo.custom = str5;
        return nFCInfo;
    }

    public String getCustom() {
        return this.custom;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public String getHwProductID() {
        return this.hwProductID;
    }

    public String getMAC() {
        return this.MAC;
    }

    public String getNFCSerialNumber() {
        return this.NFCSerialNumber;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setCustom(String str) {
        this.custom = str;
    }

    public void setDeviceID(String str) {
        this.deviceID = str;
    }

    public void setHwProductID(String str) {
        this.hwProductID = str;
    }

    public void setMAC(String str) {
        this.MAC = str;
    }

    public void setNFCSerialNumber(String str) {
        this.NFCSerialNumber = str;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public String toString() {
        return "序列号 nfcSerialNumber='" + this.NFCSerialNumber + "'\n productId hwProductId='" + this.hwProductID + "'\n 产品编码 productCode='" + this.productCode + "'\n mac地址 mac='" + this.MAC + "'\n 设备ID deviceId='" + this.deviceID + "'\n 自定义字段 custom=" + this.custom;
    }
}
