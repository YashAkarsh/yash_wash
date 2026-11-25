package com.haier.uhome.config.json.resp;

import com.haier.globalwasher.presenter.o;
import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BleConfigResp extends BasicResp {

    @b(name = "channel")
    private int channel;

    @b(name = "companyId")
    private String companyId;

    @b(name = o.f25218y)
    private String deviceId;

    @b(name = "errInfo")
    private String errInfo;

    @b(name = "error")
    private int error;

    @b(name = "hwType")
    private String hwType;

    @b(name = "hwVersion")
    private String hwVersion;

    @b(name = "isChannelValid")
    private boolean isChannelValid;

    @b(name = "isModuleTypeValid")
    private boolean isModuleTypeValid;

    @b(name = "isOtaAble")
    private boolean isOtaAble;

    @b(name = "moduleType")
    private int moduleType;

    @b(name = "productCode")
    private String productCode;

    @b(name = "swType")
    private String swType;

    @b(name = "swVersion")
    private String swVersion;

    @b(name = "upVersion")
    private String upVersion;

    @b(name = "uplusId")
    private String uplusId;

    public int getChannel() {
        return this.channel;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getErrInfo() {
        return this.errInfo;
    }

    public int getError() {
        return this.error;
    }

    public String getHwType() {
        return this.hwType;
    }

    public String getHwVersion() {
        return this.hwVersion;
    }

    public boolean getIsModuleTypeValid() {
        return this.isModuleTypeValid;
    }

    public int getModuleType() {
        return this.moduleType;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getSwType() {
        return this.swType;
    }

    public String getSwVersion() {
        return this.swVersion;
    }

    public String getUpVersion() {
        return this.upVersion;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public boolean isChannelValid() {
        return this.isChannelValid;
    }

    public boolean isOtaAble() {
        return this.isOtaAble;
    }

    public void setChannel(int i7) {
        this.channel = i7;
    }

    public void setChannelValid(boolean z7) {
        this.isChannelValid = z7;
    }

    public void setCompanyId(String str) {
        this.companyId = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setErrInfo(String str) {
        this.errInfo = str;
    }

    public void setError(int i7) {
        this.error = i7;
    }

    public void setHwType(String str) {
        this.hwType = str;
    }

    public void setHwVersion(String str) {
        this.hwVersion = str;
    }

    public void setIsModuleTypeValid(boolean z7) {
        this.isModuleTypeValid = z7;
    }

    public void setModuleType(int i7) {
        this.moduleType = i7;
    }

    public void setOtaAble(boolean z7) {
        this.isOtaAble = z7;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public void setSwType(String str) {
        this.swType = str;
    }

    public void setSwVersion(String str) {
        this.swVersion = str;
    }

    public void setUpVersion(String str) {
        this.upVersion = str;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "BleConfigResp{" + super.toString() + ",errInfo=" + this.errInfo + ",error=" + this.error + ",uplusId=" + this.uplusId + '}';
    }
}
