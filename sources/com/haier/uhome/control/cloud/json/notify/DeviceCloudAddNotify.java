package com.haier.uhome.control.cloud.json.notify;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceCloudAddNotify extends DeviceAddNotify {

    @b(name = "isGroup")
    private boolean isGroup;

    @b(name = "channel")
    private int mChannel;

    @b(name = "devRole")
    private int mDevRole;

    @b(name = "devVer")
    private String mDevVer;

    @b(name = "addr")
    private int mElementAddr;

    @b(name = "groupId")
    private String mGroupId;

    @b(name = "machineId")
    private String mMachineId;

    @b(name = "parentDevId")
    private String mParentDevId;

    @b(name = "productCode")
    private String mProductCode;

    public int getChannel() {
        return this.mChannel;
    }

    public int getDevRole() {
        return this.mDevRole;
    }

    public String getDevVer() {
        return this.mDevVer;
    }

    public int getElementAddr() {
        return this.mElementAddr;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getMachineId() {
        return this.mMachineId;
    }

    public String getParentDevId() {
        return this.mParentDevId;
    }

    public String getProductCode() {
        return this.mProductCode;
    }

    public boolean isGroup() {
        return this.isGroup;
    }

    public void setChannel(int i7) {
        this.mChannel = i7;
    }

    public void setDevRole(int i7) {
        this.mDevRole = i7;
    }

    public void setDevVer(String str) {
        this.mDevVer = str;
    }

    public void setElementAddr(int i7) {
        this.mElementAddr = i7;
    }

    public void setGroup(boolean z7) {
        this.isGroup = z7;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setMachineId(String str) {
        this.mMachineId = str;
    }

    public void setParentDevId(String str) {
        this.mParentDevId = str;
    }

    public void setProductCode(String str) {
        this.mProductCode = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceCloudAddNotify{mElementAddr=" + this.mElementAddr + ", isGroup=" + this.isGroup + ", mMachineId='" + this.mMachineId + "', mProductCode='" + this.mProductCode + "', mParentDevId='" + this.mParentDevId + "', mGroupId='" + this.mGroupId + "', mDevVer='" + this.mDevVer + "', mDevRole=" + this.mDevRole + ", mChannel=" + this.mChannel + '}';
    }
}
