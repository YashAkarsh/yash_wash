package com.haier.globalwasher.modle.bean;

/* JADX INFO: loaded from: classes2.dex */
public class APIContralViewBean {
    private String picUrl;
    private String showInvitUrl;
    private String showModule;
    private String title;

    public String getContent() {
        return this.title;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getShowInvitUrl() {
        return this.showInvitUrl;
    }

    public String getShowModule() {
        return this.showModule;
    }

    public String toString() {
        return "APIContralViewBean{showModule='" + this.showModule + "', picUrl='" + this.picUrl + "', showInvitUrl='" + this.showInvitUrl + "', title='" + this.title + "'}";
    }
}
