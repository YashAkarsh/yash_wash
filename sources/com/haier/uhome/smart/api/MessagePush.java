package com.haier.uhome.smart.api;

import com.haier.uhome.trace.api.TraceNode;

/* JADX INFO: loaded from: classes2.dex */
public class MessagePush {
    private MessageActionType mAction;
    private TraceNode mCSNode;
    private String mDevId;
    private String mLanguage;
    private int mSn;
    private MessageStyle mStype;
    private String mTimezone;

    public MessageActionType getAction() {
        return this.mAction;
    }

    public TraceNode getCSNode() {
        return this.mCSNode;
    }

    public String getDevId() {
        return this.mDevId;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public int getSn() {
        return this.mSn;
    }

    public MessageStyle getStype() {
        return this.mStype;
    }

    public String getTimezone() {
        return this.mTimezone;
    }

    public void setAction(MessageActionType messageActionType) {
        this.mAction = messageActionType;
    }

    public void setCSNode(TraceNode traceNode) {
        this.mCSNode = traceNode;
    }

    public void setDevId(String str) {
        this.mDevId = str;
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }

    public void setSn(int i7) {
        this.mSn = i7;
    }

    public void setStype(MessageStyle messageStyle) {
        this.mStype = messageStyle;
    }

    public void setTimezone(String str) {
        this.mTimezone = str;
    }

    public String toString() {
        return "MessagePush{mDevId='" + this.mDevId + "', mCSNode=" + this.mCSNode + ", mStype=" + this.mStype + ", mAction=" + this.mAction + ", mTimezone='" + this.mTimezone + "', mLanguage='" + this.mLanguage + "', mSn='" + this.mSn + "'}";
    }
}
