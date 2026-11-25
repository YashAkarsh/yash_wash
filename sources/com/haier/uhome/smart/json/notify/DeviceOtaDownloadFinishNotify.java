package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.DeviceOtaDownloadFinishNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceOtaDownloadFinishNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = "errNo")
    private int errNo;

    @b(name = "fileName")
    private String fileName;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "param")
    private String param;

    public String getDevId() {
        return this.devId;
    }

    public int getErrNo() {
        return this.errNo;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceOtaDownloadFinishNotifyHandler();
    }

    public String getParam() {
        return this.param;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setErrNo(int i7) {
        this.errNo = i7;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setParam(String str) {
        this.param = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceOtaDownloadFinishNotify{devId='" + this.devId + "', fileName='" + this.fileName + "', errNo=" + this.errNo + ", param=" + this.param + ", from=" + this.from + '}';
    }
}
