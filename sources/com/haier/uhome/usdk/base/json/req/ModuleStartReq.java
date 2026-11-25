package com.haier.uhome.usdk.base.json.req;

import com.haier.uhome.nfc.service.HttpHelper;
import com.haier.uhome.usdk.base.json.BasicReq;
import com.haier.uhome.usdk.base.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ModuleStartReq extends BasicReq {

    @b(name = HttpHelper.a.f29520d)
    private String clientId;

    @b(name = "profileM_ApiLevel")
    private int profileM_ApiLevel;

    @b(name = "profileSavePath")
    private String profileSavePath;

    @b(name = "profileUrl")
    private String profileUrl;

    @b(name = "appId")
    private String appId = "";

    @b(name = "appKey")
    private String appKey = "";

    @b(name = "sdkType")
    private String sdkType = "";

    @b(name = "sdkVer")
    private String sdkVer = "";

    @b(name = "appVer")
    private String appVer = "";

    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppVer() {
        return this.appVer;
    }

    public String getClientId() {
        return this.clientId;
    }

    public int getProfileM_ApiLevel() {
        return this.profileM_ApiLevel;
    }

    public String getProfileSavePath() {
        return this.profileSavePath;
    }

    public String getProfileUrl() {
        return this.profileUrl;
    }

    public String getSdkType() {
        return this.sdkType;
    }

    public String getSdkVer() {
        return this.sdkVer;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_MODULE_START;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setAppVer(String str) {
        this.appVer = str;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setProfileM_ApiLevel(int i7) {
        this.profileM_ApiLevel = i7;
    }

    public void setProfileSavePath(String str) {
        this.profileSavePath = str;
    }

    public void setProfileUrl(String str) {
        this.profileUrl = str;
    }

    public void setSdkType(String str) {
        this.sdkType = str;
    }

    public void setSdkVer(String str) {
        this.sdkVer = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "ModuleStartReq{" + super.toString() + ", clientId=" + this.clientId + ", profileUrl=" + this.profileUrl + ", profileSavePath=" + this.profileSavePath + ", appId=" + this.appId + ", appKey=" + this.appKey + ", sdkType=" + this.sdkType + ", sdkVer=" + this.sdkVer + ", appVer=" + this.appVer + ", profileM_ApiLevel=" + this.profileM_ApiLevel + '}';
    }
}
