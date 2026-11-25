package com.haier.uhome.usdk.scene.json.down;

import g3.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ActionResultInfo {

    @b(name = "actionId")
    private String actionId;

    @b(name = "actionSn")
    private String actionSn;

    @b(name = "batchResult")
    private boolean batchResult;

    @b(name = "createTime")
    private String createTime;

    @b(name = "detailInfo")
    private List<DetailInfo> detailInfo;

    @b(name = "updateTime")
    private String updateTime;

    public String getActionId() {
        return this.actionId;
    }

    public String getActionSn() {
        return this.actionSn;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public List<DetailInfo> getDetailInfo() {
        return this.detailInfo;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public boolean isBatchResult() {
        return this.batchResult;
    }

    public void setActionId(String str) {
        this.actionId = str;
    }

    public void setActionSn(String str) {
        this.actionSn = str;
    }

    public void setBatchResult(boolean z7) {
        this.batchResult = z7;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setDetailInfo(List<DetailInfo> list) {
        this.detailInfo = list;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public String toString() {
        return "ActionResultInfo{actionSn='" + this.actionSn + "', actionId='" + this.actionId + "', batchResult=" + this.batchResult + ", createTime='" + this.createTime + "', updateTime='" + this.updateTime + "', detailInfo=" + this.detailInfo + '}';
    }
}
