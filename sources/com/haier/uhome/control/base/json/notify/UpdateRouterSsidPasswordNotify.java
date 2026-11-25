package com.haier.uhome.control.base.json.notify;

import com.alipay.sdk.util.m;
import com.facebook.internal.ServerProtocol;
import com.haier.uhome.control.base.handler.h;
import com.haier.uhome.usdk.base.c.e;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateRouterSsidPasswordNotify extends BasicDeviceNotify {

    @b(name = "bleDevId")
    private String bleDevId;

    @b(name = "progress")
    private int progress;

    @b(name = m.f13818c)
    private int result;

    @b(name = ServerProtocol.DIALOG_PARAM_STATE)
    private int state;

    @b(name = "stateCode")
    private int stateCode;

    public String getBleDevId() {
        return this.bleDevId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new h();
    }

    public int getProgress() {
        return this.progress;
    }

    public int getResult() {
        return this.result;
    }

    public int getState() {
        return this.state;
    }

    public int getStateCode() {
        return this.stateCode;
    }

    public void setBleDevId(String str) {
        this.bleDevId = str;
    }

    public void setProgress(int i7) {
        this.progress = i7;
    }

    public void setResult(int i7) {
        this.result = i7;
    }

    public void setState(int i7) {
        this.state = i7;
    }

    public void setStateCode(int i7) {
        this.stateCode = i7;
    }

    @Override // com.haier.uhome.control.base.json.notify.BasicDeviceNotify, com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "UpdateRouterSsidPasswordNotify{, bleDevId='" + this.bleDevId + "', progress=" + this.progress + ", result=" + this.result + ", state=" + this.state + ", stateCode=" + this.stateCode + '}';
    }
}
