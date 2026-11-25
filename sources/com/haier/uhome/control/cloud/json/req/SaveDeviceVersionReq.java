package com.haier.uhome.control.cloud.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.control.cloud.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class SaveDeviceVersionReq extends BasicReq {

    @b(name = "channel")
    private int mChannel;

    @b(name = "companyId")
    private String mCompanyId;

    @b(name = "devId")
    private String mDevId;

    @b(name = "longProductCode")
    private String mLongProductCode;

    @b(name = "machineID")
    private String mMachineID;

    @b(name = "module")
    private String mModule;

    @b(name = a.f13674p)
    private int mTimeout;

    @b(name = "uplusId")
    private String mUplusId;

    public int getChannel() {
        return this.mChannel;
    }

    public String getCompanyId() {
        return this.mCompanyId;
    }

    public String getDevId() {
        return this.mDevId;
    }

    public String getLongProductCode() {
        return this.mLongProductCode;
    }

    public String getMachineID() {
        return this.mMachineID;
    }

    public String getModule() {
        return this.mModule;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public String getUplusId() {
        return this.mUplusId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_SAVE_DEVICE_VERSION;
    }

    public void setChannel(int i7) {
        this.mChannel = i7;
    }

    public void setCompanyId(String str) {
        this.mCompanyId = str;
    }

    public void setDevId(String str) {
        this.mDevId = str;
    }

    public void setLongProductCode(String str) {
        this.mLongProductCode = str;
    }

    public void setMachineID(String str) {
        this.mMachineID = str;
    }

    public void setModule(String str) {
        this.mModule = str;
    }

    public void setTimeout(int i7) {
        this.mTimeout = i7;
    }

    public void setUplusId(String str) {
        this.mUplusId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "SaveDeviceVersionReq{mTimeout=" + this.mTimeout + ", mModule='" + this.mModule + "', mDevId='" + this.mDevId + "', mUplusId='" + this.mUplusId + "', mLongProductCode='" + this.mLongProductCode + "', mChannel=" + this.mChannel + ", mCompanyId='" + this.mCompanyId + "', mMachineID='" + this.mMachineID + "'}";
    }
}
