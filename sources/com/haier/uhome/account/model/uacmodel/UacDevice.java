package com.haier.uhome.account.model.uacmodel;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UacDevice {

    @b(name = "address")
    private UacDeviceAddress address;

    @b(name = "attrs")
    private UacDeviceAttribute attrs;

    @b(name = "deviceModules")
    private UacDeviceModulesInfo[] deviceModules;

    @b(name = "id")
    private String id;

    @b(name = "location")
    private UacDeviceLocation location;

    @b(name = "name")
    private String name;

    @b(name = "status")
    private Boolean status = Boolean.FALSE;

    @b(name = "typeInfo")
    private UacDeviceTypeInfo typeInfo;

    public UacDeviceAddress getAddress() {
        return this.address;
    }

    public UacDeviceAttribute getAttrs() {
        return this.attrs;
    }

    public UacDeviceModulesInfo[] getDeviceModules() {
        return this.deviceModules;
    }

    public String getId() {
        return this.id;
    }

    public UacDeviceLocation getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public UacDeviceTypeInfo getTypeInfo() {
        return this.typeInfo;
    }

    public void setAddress(UacDeviceAddress uacDeviceAddress) {
        this.address = uacDeviceAddress;
    }

    public void setAttrs(UacDeviceAttribute uacDeviceAttribute) {
        this.attrs = uacDeviceAttribute;
    }

    public void setDeviceModules(UacDeviceModulesInfo[] uacDeviceModulesInfoArr) {
        this.deviceModules = uacDeviceModulesInfoArr;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLocation(UacDeviceLocation uacDeviceLocation) {
        this.location = uacDeviceLocation;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStatus(Boolean bool) {
        this.status = bool;
    }

    public void setTypeInfo(UacDeviceTypeInfo uacDeviceTypeInfo) {
        this.typeInfo = uacDeviceTypeInfo;
    }
}
