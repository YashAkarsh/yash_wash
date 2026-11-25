package com.haier.uhome.nfc.service.entity;

import com.haier.globalwasher.presenter.o;
import g3.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NFCInfoResp {

    @b(name = "mac")
    private String MAC;

    @b(name = "nfcSerialNumber")
    private String NFCSerialNumber;
    private String custom;

    @b(name = o.f25218y)
    private String deviceID;

    @b(name = "hotspot")
    private String hotSpot;

    @b(name = "hwProductId")
    private String hwProductID;

    @b(name = "img")
    private String imageUrl;

    @b(name = "modelCode")
    private String modelCode;
    private String productCode;

    @b(name = "productCodes")
    private List<TypeCodeInfo> productCodes;

    @b(name = "appTypeCode")
    private String typeCode;

    @b(name = "appTypeName")
    private String typeName;

    public static NFCInfo of(NFCInfoResp nFCInfoResp) {
        NFCInfo nFCInfo = new NFCInfo();
        nFCInfo.setNFCSerialNumber(nFCInfoResp.getNFCSerialNumber());
        nFCInfo.setMAC(nFCInfoResp.getMAC());
        nFCInfo.setProductCode(nFCInfoResp.getProductCode());
        nFCInfo.setHwProductID(nFCInfoResp.getHwProductID());
        nFCInfo.setDeviceID(nFCInfoResp.getDeviceID());
        return nFCInfo;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public String getHotSpot() {
        return this.hotSpot;
    }

    public String getHwProductID() {
        return this.hwProductID;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getMAC() {
        return this.MAC;
    }

    public String getModelCode() {
        return this.modelCode;
    }

    public String getNFCSerialNumber() {
        return this.NFCSerialNumber;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public List<TypeCodeInfo> getProductCodes() {
        return this.productCodes;
    }

    public String getTypeCode() {
        return this.typeCode;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setDeviceID(String str) {
        this.deviceID = str;
    }

    public void setHotSpot(String str) {
        this.hotSpot = str;
    }

    public void setHwProductID(String str) {
        this.hwProductID = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setMAC(String str) {
        this.MAC = str;
    }

    public void setModelCode(String str) {
        this.modelCode = str;
    }

    public void setNFCSerialNumber(String str) {
        this.NFCSerialNumber = str;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public void setProductCodes(List<TypeCodeInfo> list) {
        this.productCodes = list;
    }

    public void setTypeCode(String str) {
        this.typeCode = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }
}
