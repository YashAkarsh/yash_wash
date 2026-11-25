package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.DeviceOtaDownloadNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceOtaDownloadNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = "fileName")
    private String fileName;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "param")
    private String param;

    @b(name = "url")
    private String url;

    public String getDevId() {
        return this.devId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceOtaDownloadNotifyHandler();
    }

    public String getParam() {
        return this.param;
    }

    public String getUrl() {
        return this.url;
    }

    public void setDevId(String str) {
        this.devId = str;
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

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceOtaDownloadNotify{devId='" + this.devId + "', url='" + this.url + "', fileName='" + this.fileName + "', param=" + this.param + ", from=" + this.from + '}';
    }
}
