package com.haier.uhome.control.base.json;

import com.haier.uhome.account.okhttp.uAccountRequest;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceTokenInfoList {

    @b(name = uAccountRequest.KEY_RET_CODE)
    private String retCode;

    @b(name = uAccountRequest.KEY_RET_INFO)
    private String retInfo;

    @b(name = "tokenList")
    private DeviceTokenInfo[] tokenList;

    public String getRetCode() {
        return this.retCode;
    }

    public String getRetInfo() {
        return this.retInfo;
    }

    public DeviceTokenInfo[] getTokenList() {
        return this.tokenList;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public void setRetInfo(String str) {
        this.retInfo = str;
    }

    public void setTokenList(DeviceTokenInfo[] deviceTokenInfoArr) {
        this.tokenList = deviceTokenInfoArr;
    }
}
