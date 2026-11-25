package com.haier.uhome.search.json.notify;

import com.haier.uhome.search.b.a;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBleAdvUnboundNotify extends BasicNotify {

    @b(name = "bleDevId")
    private String mBleDevId;

    @b(name = "companyId")
    private String mCompanyId;

    @b(name = "isDupAdv")
    private int mDupAdv;

    @b(name = "machineID")
    private String mMachineID;

    @b(name = "name")
    private String mName;

    @b(name = "productCode")
    private String mProductCode;

    @b(name = "protVers")
    private String mProtVers;

    @b(name = "protocol")
    private String mProtocol;

    public String getBleDevId() {
        return this.mBleDevId;
    }

    public String getCompanyId() {
        return this.mCompanyId;
    }

    public int getDupAdv() {
        return this.mDupAdv;
    }

    public String getMachineID() {
        return this.mMachineID;
    }

    public String getName() {
        return this.mName;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new a();
    }

    public String getProductCode() {
        return this.mProductCode;
    }

    public String getProtVers() {
        return this.mProtVers;
    }

    public String getProtocol() {
        return this.mProtocol;
    }

    public void setBleDevId(String str) {
        this.mBleDevId = str;
    }

    public void setCompanyId(String str) {
        this.mCompanyId = str;
    }

    public void setDupAdv(int i7) {
        this.mDupAdv = i7;
    }

    public void setMachineID(String str) {
        this.mMachineID = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setProductCode(String str) {
        this.mProductCode = str;
    }

    public void setProtVers(String str) {
        this.mProtVers = str;
    }

    public void setProtocol(String str) {
        this.mProtocol = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceBleAdvUnboundNotify{mDupAdv=" + this.mDupAdv + ", mCompanyId='" + this.mCompanyId + "', mName='" + this.mName + "', mMachineID='" + this.mMachineID + "', mBleDevId='" + this.mBleDevId + "', mProtocol='" + this.mProtocol + "', mProtVers='" + this.mProtVers + "', mProductCode='" + this.mProductCode + "'}";
    }
}
