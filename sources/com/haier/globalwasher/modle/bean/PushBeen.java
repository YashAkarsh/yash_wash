package com.haier.globalwasher.modle.bean;

import com.google.gson.f;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PushBeen implements Serializable {
    private String baiduUserId;
    private String channelId;
    private String message;
    private String orderId;
    private String queueId;
    private String typeId;
    private String userId;
    private String weburl;

    public static PushBeen objectFromData(String str) {
        return (PushBeen) new f().n(str, PushBeen.class);
    }

    public String getBaiduUserId() {
        return this.baiduUserId;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getMessage() {
        return this.message;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getQueueId() {
        return this.queueId;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getWeburl() {
        return this.weburl;
    }

    public void setBaiduUserId(String str) {
        this.baiduUserId = str;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setQueueId(String str) {
        this.queueId = str;
    }

    public void setTypeId(String str) {
        this.typeId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setWeburl(String str) {
        this.weburl = str;
    }

    public String toString() {
        return "PushBeen{queueId='" + this.queueId + "', baiduUserId='" + this.baiduUserId + "', orderId='" + this.orderId + "', typeId='" + this.typeId + "', message='" + this.message + "', userId='" + this.userId + "'}";
    }
}
