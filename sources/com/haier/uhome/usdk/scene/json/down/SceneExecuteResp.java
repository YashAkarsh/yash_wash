package com.haier.uhome.usdk.scene.json.down;

import com.haier.library.json.a;
import com.haier.uhome.usdk.scene.json.ProtocolConst;
import g3.b;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SceneExecuteResp implements BaseDown {

    @b(name = "actionResultInfo")
    private List<ActionResultInfo> actionResultInfo;

    @b(name = "createTime")
    private String createTime;

    @b(name = "reportType")
    private String reportType;

    @b(name = "sceneId")
    private String sceneId;

    @b(name = "sn")
    private String sn;

    @b(name = "status")
    private int status;

    @b(name = "triggerType")
    private String triggerType;

    @b(name = "triggerValue")
    private String triggerValue;

    @b(name = "updateTime")
    private String updateTime;

    @Override // com.haier.uhome.usdk.scene.json.down.BaseDown
    public String buildJson() {
        HashMap map = new HashMap(1);
        map.put(ProtocolConst.DOWN_SCENE_EXECUTE, this);
        return a.Z(map);
    }

    public List<ActionResultInfo> getActionResultInfo() {
        return this.actionResultInfo;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getReportType() {
        return this.reportType;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public String getSn() {
        return this.sn;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTriggerType() {
        return this.triggerType;
    }

    public String getTriggerValue() {
        return this.triggerValue;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setActionResultInfo(List<ActionResultInfo> list) {
        this.actionResultInfo = list;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setReportType(String str) {
        this.reportType = str;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public void setStatus(int i7) {
        this.status = i7;
    }

    public void setTriggerType(String str) {
        this.triggerType = str;
    }

    public void setTriggerValue(String str) {
        this.triggerValue = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public String toString() {
        return "SceneExecuteResp{sn='" + this.sn + "', sceneId='" + this.sceneId + "', status=" + this.status + ", createTime='" + this.createTime + "', updateTime='" + this.updateTime + "', triggerType='" + this.triggerType + "', triggerValue='" + this.triggerValue + "', reportType='" + this.reportType + "', actionResultInfo=" + this.actionResultInfo + '}';
    }
}
