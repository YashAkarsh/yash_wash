package com.haier.uhome.mesh.bridge;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.s;

/* JADX INFO: loaded from: classes2.dex */
public class RtkCoreMeshGroupBindCallbackWrapper extends o4.b {
    private s mAddModelToGroupCallback;
    private s mRmModelToGroupCallback;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static RtkCoreMeshGroupBindCallbackWrapper f29495a = new RtkCoreMeshGroupBindCallbackWrapper();

        private a() {
        }
    }

    public static RtkCoreMeshGroupBindCallbackWrapper getInstance() {
        return a.f29495a;
    }

    @Override // o4.b
    public void meshBindModelToGroupSuccess(boolean z7) {
        s sVar = this.mAddModelToGroupCallback;
        if (sVar != null) {
            sVar.onCallback((z7 ? ErrorConst.RET_USDK_OK : ErrorConst.ERR_INTERNAL).toError());
        }
        this.mAddModelToGroupCallback = null;
    }

    void setAddModelToGroupCallback(s sVar) {
        this.mAddModelToGroupCallback = sVar;
    }

    void setRmModelToGroupCallback(s sVar) {
        this.mRmModelToGroupCallback = sVar;
    }

    private RtkCoreMeshGroupBindCallbackWrapper() {
    }
}
