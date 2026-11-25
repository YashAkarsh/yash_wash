package com.haier.uhome.control.base.json.req;

import android.text.TextUtils;
import com.haier.uhome.control.base.json.OperArgs;
import com.haier.uhome.control.base.json.ProtocolConst;
import com.haier.uhome.trace.api.TraceProtocolConst;
import g3.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceOperReq extends BasicOpReq {

    @b(name = TraceProtocolConst.PRO_ARGS)
    private List<OperArgs> args;

    @b(name = "op")
    private String op;

    public List<OperArgs> getArgs() {
        return this.args;
    }

    public String getOp() {
        return this.op;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_DEVICE_OPER;
    }

    public void setArgs(List<OperArgs> list) {
        if (list == null) {
            throw new IllegalArgumentException("DeviceOperReq args should not be null");
        }
        this.args = list;
    }

    public void setOp(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("DeviceOperReq op should not be null");
        }
        this.op = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicOpReq, com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceOperReq{");
        sb.append(super.toString());
        sb.append(", op=");
        sb.append(this.op);
        sb.append(", args=");
        List<OperArgs> list = this.args;
        sb.append(list == null ? "null" : list.toString());
        sb.append('}');
        return sb.toString();
    }
}
