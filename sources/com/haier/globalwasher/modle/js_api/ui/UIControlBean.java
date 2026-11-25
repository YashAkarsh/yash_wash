package com.haier.globalwasher.modle.js_api.ui;

import com.haier.globalwasher.modle.js_api.BaseJsBean;

/* JADX INFO: loaded from: classes2.dex */
public class UIControlBean extends BaseJsBean {
    private String title;
    private String url;

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "UIControlBean{url='" + this.url + "', title='" + this.title + "', callBackMethodName='" + getCallBackMethodName() + "'}";
    }
}
