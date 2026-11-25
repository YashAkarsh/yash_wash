package com.haier.uhome.account.model;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UacDeviceModulesInfo {

    @b(name = "moduleId")
    private String moduleId;

    @b(name = "moduleInfos")
    private UacModulesInfoItem[] moduleInfos;

    @b(name = "moduleType")
    private String moduleType;

    public String getModuleId() {
        return this.moduleId;
    }

    public UacModulesInfoItem[] getModuleInfos() {
        return this.moduleInfos;
    }

    public String getModuleType() {
        return this.moduleType;
    }

    public void setModuleId(String str) {
        this.moduleId = str;
    }

    public void setModuleInfos(UacModulesInfoItem[] uacModulesInfoItemArr) {
        this.moduleInfos = uacModulesInfoItemArr;
    }

    public void setModuleType(String str) {
        this.moduleType = str;
    }
}
