package com.haier.uhome.search.service.entity;

import android.util.Base64;
import com.haier.uhome.usdk.base.annotation.Keep;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class MeshDeviceUUIDInfo {

    @g3.b(deserialize = false)
    private String devUuid;

    @g3.b(name = "bit_reserved")
    private int mBitReserved;

    @g3.b(name = "company_id")
    private String mCompanyId;

    @g3.b(deserialize = false)
    private String mLongProductCode;

    @g3.b(name = "mac")
    private String mMac;

    @g3.b(name = "product_id")
    private String mProductCode;

    @g3.b(name = "reserved")
    private String mReserved;

    @g3.b(name = "is_silence")
    private int mSilence;

    @g3.b(name = "version")
    private int mVersion;

    @g3.b(deserialize = false)
    private String typeId;

    private String decodeProperty(String str) {
        if (com.haier.library.common.util.c.m(str)) {
            return str;
        }
        try {
            return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
        } catch (Exception e8) {
            e3.a.f("Decode content: %s error", str, e8.getMessage(), new Object[0]);
            return str;
        }
    }

    public void decodeProperties() {
        setCompanyId(decodeProperty(this.mCompanyId));
        setReserved(decodeProperty(this.mReserved));
    }

    public int getBitReserved() {
        return this.mBitReserved;
    }

    public String getCompanyId() {
        return this.mCompanyId;
    }

    public String getDevUuid() {
        return this.devUuid;
    }

    public String getLongProductCode() {
        return this.mLongProductCode;
    }

    public String getMac() {
        return this.mMac;
    }

    public String getProductCode() {
        return this.mProductCode;
    }

    public String getReserved() {
        return this.mReserved;
    }

    public int getSilence() {
        return this.mSilence;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setBitReserved(int i7) {
        this.mBitReserved = i7;
    }

    public void setCompanyId(String str) {
        this.mCompanyId = str;
    }

    public void setDevUuid(String str) {
        this.devUuid = str;
    }

    public void setLongProductCode(String str) {
        this.mLongProductCode = str;
    }

    public void setMac(String str) {
        this.mMac = str;
    }

    public void setProductCode(String str) {
        this.mProductCode = str;
    }

    public void setReserved(String str) {
        this.mReserved = str;
    }

    public void setSilence(int i7) {
        this.mSilence = i7;
    }

    public void setTypeId(String str) {
        this.typeId = str;
    }

    public void setVersion(int i7) {
        this.mVersion = i7;
    }

    public String toString() {
        return "MeshDeviceUUIDInfo{mCompanyId=" + this.mCompanyId + ", mProductCode=" + this.mProductCode + ", mMac=" + this.mMac + ", mVersion=" + this.mVersion + ", mSilence=" + this.mSilence + ", mBitReserved=" + this.mBitReserved + ", mReserved='" + this.mReserved + ", mLongProductCode=" + this.mLongProductCode + ", devUuid=" + this.devUuid + ", typeId=" + this.typeId + '}';
    }
}
