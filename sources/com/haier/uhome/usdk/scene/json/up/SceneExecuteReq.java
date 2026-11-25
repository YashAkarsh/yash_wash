package com.haier.uhome.usdk.scene.json.up;

import g3.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SceneExecuteReq extends BaseUp {

    @b(name = "actions")
    private List<ActionsBean> actions;

    @b(name = "sceneId")
    private String sceneId;

    @b(name = "sceneSn")
    private String sceneSn;

    @b(name = "triggerType")
    private String triggerType;

    @b(name = "triggerValue")
    private String triggerValue;

    public List<ActionsBean> getActions() {
        return this.actions;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public String getSceneSn() {
        return this.sceneSn;
    }

    public String getTriggerType() {
        return this.triggerType;
    }

    public String getTriggerValue() {
        return this.triggerValue;
    }

    public void setActions(List<ActionsBean> list) {
        this.actions = list;
    }

    public void setSceneId(String str) {
        this.sceneId = str;
    }

    public void setSceneSn(String str) {
        this.sceneSn = str;
    }

    public void setTriggerType(String str) {
        this.triggerType = str;
    }

    public void setTriggerValue(String str) {
        this.triggerValue = str;
    }

    @Override // com.haier.uhome.usdk.scene.json.up.BaseUp
    public String toString() {
        return "SceneExecuteReq{sceneSn='" + this.sceneSn + "', sceneId='" + this.sceneId + "', triggerType='" + this.triggerType + "', triggerValue='" + this.triggerValue + "', actions=" + this.actions + '}';
    }
}
