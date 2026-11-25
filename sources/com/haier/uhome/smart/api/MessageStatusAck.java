package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public class MessageStatusAck {
    private String mDevId;
    private String mMessageId;
    private String mPushId;
    private String mReadTime;
    private MessageStatus mStatus;

    public String getDevId() {
        return this.mDevId;
    }

    public String getMessageId() {
        return this.mMessageId;
    }

    public String getPushId() {
        return this.mPushId;
    }

    public String getReadTime() {
        return this.mReadTime;
    }

    public MessageStatus getStatus() {
        return this.mStatus;
    }

    public void setDevId(String str) {
        this.mDevId = str;
    }

    public void setMessageId(String str) {
        this.mMessageId = str;
    }

    public void setPushId(String str) {
        this.mPushId = str;
    }

    public void setReadTime(String str) {
        this.mReadTime = str;
    }

    public void setStatus(MessageStatus messageStatus) {
        this.mStatus = messageStatus;
    }

    public String toString() {
        return "MessageStatusAck{mDevId='" + this.mDevId + "', mPushId='" + this.mPushId + "', mMessageId='" + this.mMessageId + "', mStatus=" + this.mStatus + ", mReadTime='" + this.mReadTime + "'}";
    }
}
