package com.haier.uhome.control.cloud.service;

import android.text.TextUtils;
import com.haier.uhome.control.base.json.req.BleMeshSelfNodeInfoReq;
import com.haier.uhome.control.base.json.resp.BleMeshSelfNodeInfoResp;
import com.haier.uhome.mesh.api.model.MeshAppKey;
import com.haier.uhome.mesh.api.model.MeshNetKey;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f29147a = b.a();

    public void a(final ICallback<com.haier.uhome.control.base.a.c> iCallback) {
        if (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().e())) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        BleMeshSelfNodeInfoReq bleMeshSelfNodeInfoReq = new BleMeshSelfNodeInfoReq();
        bleMeshSelfNodeInfoReq.setClientId(com.haier.uhome.usdk.base.service.e.a().k());
        bleMeshSelfNodeInfoReq.setUserId(com.haier.uhome.usdk.base.service.e.a().e());
        bleMeshSelfNodeInfoReq.setNativeSender(this.f29147a);
        bleMeshSelfNodeInfoReq.setTimeout(15);
        bleMeshSelfNodeInfoReq.setTraceId("");
        com.haier.uhome.usdk.base.d.a.a().a(bleMeshSelfNodeInfoReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.cloud.service.f
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f29208a.a(iCallback, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (!usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
            return;
        }
        try {
            com.haier.uhome.control.base.a.c cVarA = a((BleMeshSelfNodeInfoResp) basicResp);
            if (cVarA == null) {
                com.haier.uhome.usdk.base.utils.b.a(iCallback, ErrorConst.ERR_INTERNAL.toError());
            } else {
                com.haier.uhome.usdk.base.utils.b.a((ICallback<com.haier.uhome.control.base.a.c>) iCallback, cVarA);
            }
        } catch (ClassCastException e8) {
            e8.printStackTrace();
            com.haier.uhome.usdk.base.utils.b.a(iCallback, ErrorConst.ERR_INTERNAL.toError());
        }
    }

    private com.haier.uhome.control.base.a.c a(BleMeshSelfNodeInfoResp bleMeshSelfNodeInfoResp) {
        if (bleMeshSelfNodeInfoResp == null) {
            return null;
        }
        com.haier.uhome.control.base.a.c cVar = new com.haier.uhome.control.base.a.c();
        cVar.a(new MeshAppKey(bleMeshSelfNodeInfoResp.getAppKeyIndex(), bleMeshSelfNodeInfoResp.getAppkey()));
        cVar.a(new MeshNetKey(bleMeshSelfNodeInfoResp.getNetKeyIndex(), bleMeshSelfNodeInfoResp.getNetKey()));
        cVar.b(bleMeshSelfNodeInfoResp.getIvIndex());
        cVar.a(bleMeshSelfNodeInfoResp.getElementAddr());
        cVar.a(bleMeshSelfNodeInfoResp.getNetID());
        return cVar;
    }
}
