package com.haier.uhome.control.cloud.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class FetchFotaStatusResp extends BasicResp {

    @b(name = "devId")
    private String devId;

    @b(name = "upgradeStatus")
    private int status;

    @b(name = "upgradeErrNo")
    private int upgradeErrNo;

    public String getDevId() {
        return this.devId;
    }

    public int getStatus() {
        return this.status;
    }

    public int getUpgradeErrNo() {
        return this.upgradeErrNo;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setStatus(int i7) {
        this.status = i7;
    }

    public void setUpgradeErrNo(int i7) {
        this.upgradeErrNo = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "FetchFotaStatusResp{devId=" + this.devId + ", status=" + this.status + '}';
    }
}
