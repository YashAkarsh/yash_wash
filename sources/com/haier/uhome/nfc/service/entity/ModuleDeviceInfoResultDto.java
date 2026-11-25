package com.haier.uhome.nfc.service.entity;

import com.haier.globalwasher.presenter.o;
import com.haier.uhome.usdk.base.annotation.Keep;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class ModuleDeviceInfoResultDto {

    @b(name = "appTypeCode")
    private String appTypeCode;

    @b(name = "appTypeName")
    private String appTypeName;

    @b(name = "channel")
    private String channel;

    @b(name = o.f25218y)
    private String deviceId;

    @b(name = "hardwareType")
    private String hardwareType;

    @b(name = "hardwareVers")
    private String hardwareVers;

    @b(name = "moduleType")
    private String moduleType;

    @b(name = "productCode")
    private String productCode;

    @b(name = "softwareType")
    private String softwareType;

    @b(name = "softwareVers")
    private String softwareVers;

    @b(name = "typeId")
    private String typeId;

    public String getAppTypeCode() {
        return this.appTypeCode;
    }

    public String getAppTypeName() {
        return this.appTypeName;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getHardwareType() {
        return this.hardwareType;
    }

    public String getHardwareVers() {
        return this.hardwareVers;
    }

    public String getModuleType() {
        return this.moduleType;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getSoftwareType() {
        return this.softwareType;
    }

    public String getSoftwareVers() {
        return this.softwareVers;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public void setAppTypeCode(String str) {
        this.appTypeCode = str;
    }

    public void setAppTypeName(String str) {
        this.appTypeName = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setHardwareType(String str) {
        this.hardwareType = str;
    }

    public void setHardwareVers(String str) {
        this.hardwareVers = str;
    }

    public void setModuleType(String str) {
        this.moduleType = str;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public void setSoftwareType(String str) {
        this.softwareType = str;
    }

    public void setSoftwareVers(String str) {
        this.softwareVers = str;
    }

    public void setTypeId(String str) {
        this.typeId = str;
    }
}
