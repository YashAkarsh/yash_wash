package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKTransparentMessage {
    private String content;
    private String mac;
    private uSDKMessageTypeConst type;

    protected uSDKTransparentMessage() {
    }

    public String getDeviceMac() {
        return this.mac;
    }

    public String getMessageContent() {
        return this.content;
    }

    public uSDKMessageTypeConst getMessageType() {
        return this.type;
    }

    protected void setContent(String str) {
        this.content = str;
    }

    protected void setMac(String str) {
        this.mac = str;
    }

    protected void setType(uSDKMessageTypeConst usdkmessagetypeconst) {
        this.type = usdkmessagetypeconst;
    }
}
