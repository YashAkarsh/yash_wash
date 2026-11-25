package com.haier.uhome.config.json.notify;

import com.alipay.sdk.util.m;
import com.haier.uhome.config.c.g;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class NewDirectLinkBindProgressNotify extends BasicNotify {

    @b(name = "devId")
    private String mDevId;

    @b(name = "errNo")
    private int mErrNo;

    @b(name = "progress")
    private int mProgress;

    @b(name = m.f13818c)
    private int mResult;

    public String getDevId() {
        return this.mDevId;
    }

    public int getErrNo() {
        return this.mErrNo;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new g();
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getResult() {
        return this.mResult;
    }

    public void setDevId(String str) {
        this.mDevId = str;
    }

    public void setErrNo(int i7) {
        this.mErrNo = i7;
    }

    public void setProgress(int i7) {
        this.mProgress = i7;
    }

    public void setResult(int i7) {
        this.mResult = i7;
    }
}
