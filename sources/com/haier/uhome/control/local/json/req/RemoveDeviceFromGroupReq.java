package com.haier.uhome.control.local.json.req;

import com.haier.uhome.control.local.json.ProtocolConst;

/* JADX INFO: loaded from: classes2.dex */
public class RemoveDeviceFromGroupReq extends AddDeviceToGroupReq {
    @Override // com.haier.uhome.control.local.json.req.AddDeviceToGroupReq, com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_REMOVE_DEVICE_FROM_GROUP;
    }
}
