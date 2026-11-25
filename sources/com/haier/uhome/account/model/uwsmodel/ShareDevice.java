package com.haier.uhome.account.model.uwsmodel;

import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ShareDevice {

    @b(name = "devFamilyId")
    private String devFamilyId;

    @b(name = "devInfo")
    private DeviceBriefInfo devInfo;

    @b(name = "devName")
    private String devName;

    @b(name = "devOwner")
    private UserBriefInfo[] devOwner;

    @b(name = "devShareUser")
    private UserBriefInfo devShareUser;

    @b(name = "permission")
    private Permission permission;

    public String getDevFamilyId() {
        return this.devFamilyId;
    }

    public DeviceBriefInfo getDevInfo() {
        return this.devInfo;
    }

    public String getDevName() {
        return this.devName;
    }

    public UserBriefInfo[] getDevOwner() {
        return this.devOwner;
    }

    public UserBriefInfo getDevShareUser() {
        return this.devShareUser;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public void setDevFamilyId(String str) {
        this.devFamilyId = str;
    }

    public void setDevInfo(DeviceBriefInfo deviceBriefInfo) {
        this.devInfo = deviceBriefInfo;
    }

    public void setDevName(String str) {
        this.devName = str;
    }

    public void setDevOwner(UserBriefInfo[] userBriefInfoArr) {
        this.devOwner = userBriefInfoArr;
    }

    public void setDevShareUser(UserBriefInfo userBriefInfo) {
        this.devShareUser = userBriefInfo;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
