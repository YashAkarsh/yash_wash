package com.haier.uhome.usdk.scene.json.up;

import com.haier.uhome.trace.api.TraceProtocolConst;
import g3.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ActionsBean {

    @b(name = "actionId")
    private String actionId;

    @b(name = "actionSn")
    private String actionSn;

    @b(name = TraceProtocolConst.PRO_ARGS)
    private List<Args> args;

    @b(name = "priority")
    private int priority;

    @b(name = "type")
    private String type;

    public String getActionId() {
        return this.actionId;
    }

    public String getActionSn() {
        return this.actionSn;
    }

    public List<Args> getArgs() {
        return this.args;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getType() {
        return this.type;
    }

    public void setActionId(String str) {
        this.actionId = str;
    }

    public void setActionSn(String str) {
        this.actionSn = str;
    }

    public void setArgs(List<Args> list) {
        this.args = list;
    }

    public void setPriority(int i7) {
        this.priority = i7;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "ActionsBean{type='" + this.type + "', priority=" + this.priority + ", actionId='" + this.actionId + "', actionSn='" + this.actionSn + "', args=" + this.args + '}';
    }
}
