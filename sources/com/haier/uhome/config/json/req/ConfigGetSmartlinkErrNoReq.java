package com.haier.uhome.config.json.req;

import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigGetSmartlinkErrNoReq extends BasicReq {
    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_SMARTLINK_ERRINFO_GET;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "ConfigGetSmartlinkErrNoReq{sn=" + getSn() + '}';
    }
}
