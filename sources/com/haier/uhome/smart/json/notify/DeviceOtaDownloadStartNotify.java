package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.DeviceOtaDownloadStartNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceOtaDownloadStartNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "param")
    private String param;

    @b(name = "type")
    private String type;

    @b(name = "upgradeSn")
    private String upgradeSn;

    public String getDevId() {
        return this.devId;
    }

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceOtaDownloadStartNotifyHandler();
    }

    public String getParam() {
        return this.param;
    }

    public String getType() {
        return this.type;
    }

    public String getUpgradeSn() {
        return this.upgradeSn;
    }

    public void setDevid(String str) {
        this.devId = str;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setParam(String str) {
        this.param = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUpgradeSn(String str) {
        this.upgradeSn = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceOtaDownloadStartNotify{devId='" + this.devId + "', type='" + this.type + "', upgradeSn='" + this.upgradeSn + "', param=" + this.param + ", from='" + this.from + "'}";
    }
}
