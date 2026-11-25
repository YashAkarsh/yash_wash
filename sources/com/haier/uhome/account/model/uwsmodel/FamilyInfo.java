package com.haier.uhome.account.model.uwsmodel;

import g3.b;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class FamilyInfo {

    @b(name = "appId")
    private String appId;

    @b(name = "createtime")
    private Date createtime;

    @b(name = "familyId")
    private String familyId;

    @b(name = "familyName")
    private String familyName;

    @b(name = "familyOwner")
    private UserBriefInfo familyOwner;

    public String getAppId() {
        return this.appId;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public UserBriefInfo getFamilyOwner() {
        return this.familyOwner;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCreatetime(Date date) {
        this.createtime = date;
    }

    public void setFamilyId(String str) {
        this.familyId = str;
    }

    public void setFamilyName(String str) {
        this.familyName = str;
    }

    public void setFamilyOwner(UserBriefInfo userBriefInfo) {
        this.familyOwner = userBriefInfo;
    }
}
