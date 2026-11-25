package com.haier.uhome.mesh.bridge;

import com.haier.uhome.mesh.api.model.MeshDeviceNode;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.s;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class RtkCoreMeshCallbackWrapper extends o4.a {
    private s mBindAppKeyToModelCallback;
    private IConfigCallback mConfigCallback;
    private ICallback<MeshDeviceNode> mInviteCallback;
    private IMeshCallback mMeshCallback;
    private IVendorModelCallback mMeshVendorModelCallback;
    private ICallback<Integer> mSeqNumCallback;
    private s mSetAppKeyCallback;
    private s mUnBindAppKeyToModelCallback;
    private s mUnsetDeviceCallback;
    private s nodeIdentityCallback;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static RtkCoreMeshCallbackWrapper f29494a = new RtkCoreMeshCallbackWrapper();

        private a() {
        }
    }

    public static RtkCoreMeshCallbackWrapper getInstance() {
        return a.f29494a;
    }

    @Override // o4.a
    public void ivUpdateFlagNotification(long j7) {
        e3.a.e("RTK ivUpdateFlagNotification -> newIvIndex = %d", Long.valueOf(j7));
        IMeshCallback iMeshCallback = this.mMeshCallback;
        if (iMeshCallback != null) {
            iMeshCallback.onIvIndexUpdate(j7);
        } else {
            e3.a.e("RTK ivUpdateFlagNotification mMeshCallback == null!", new Object[0]);
        }
    }

    @Override // o4.a
    public void meshAddAppKeyComplete(byte b8, int i7, int i8) {
        e3.a.e("RTK mSetAppKeyCallback result = %d,netKyeIndex = %d,appKeyIndex = %d!", Byte.valueOf(b8), Integer.valueOf(i7), Integer.valueOf(i8));
        s sVar = this.mSetAppKeyCallback;
        if (sVar == null) {
            e3.a.e("RTK mSetAppKeyCallback mInviteCallback == null!", new Object[0]);
        } else {
            this.mSetAppKeyCallback = null;
            sVar.onCallback(b8 == 0 ? ErrorConst.RET_USDK_OK.toError() : new uSDKError(b8, RtkErrMsg.getStatusErrMsg(b8)));
        }
    }

    @Override // o4.a
    public void meshBindModelToAppComplete(byte b8, int i7, int i8, int i9) {
        e3.a.e("RTK meshBindModelToAppSuccess result = %d,model = %d,appKeyIndex = %d,element = %d!", Byte.valueOf(b8), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
        s sVar = this.mBindAppKeyToModelCallback;
        if (sVar == null) {
            e3.a.e("RTK meshBindModelToAppSuccess mInviteCallback == null!", new Object[0]);
        } else {
            this.mBindAppKeyToModelCallback = null;
            sVar.onCallback(b8 == 0 ? ErrorConst.RET_USDK_OK.toError() : new uSDKError(b8, RtkErrMsg.getStatusErrMsg(b8)));
        }
    }

    @Override // o4.a
    public void meshCfgNodeIdentityStatComplete(byte b8, int i7, int i8) {
        uSDKError error;
        e3.a.e("RTK meshCfgNodeIdentity -> status = %d, identity = %d, netKeyIndex = %d", Byte.valueOf(b8), Integer.valueOf(i7), Integer.valueOf(i8));
        if (b8 == 0) {
            error = ErrorConst.RET_USDK_OK.toError();
        } else {
            uSDKError error2 = ErrorConst.ERR_INTERNAL.toError();
            error2.setCode(b8);
            error = error2;
        }
        synchronized (this) {
            s sVar = this.nodeIdentityCallback;
            if (sVar == null) {
                e3.a.v("RTK meshCfgNodeIdentityStatComplete nodeIdentityCallback == null!", new Object[0]);
            } else {
                sVar.onCallback(error);
                this.nodeIdentityCallback = null;
            }
        }
    }

    @Override // o4.a
    public void meshProvsionComplete(byte b8, byte b9, byte[] bArr, short s7, byte b10, String str) {
        e3.a.d("RTK meshProvsionComplete: 0x%s-0x%s, devKey: %s, unicast: %d, elementNum: %d, bleAddr: %s", Integer.toHexString(b8), Integer.toHexString(b9), com.haier.library.common.util.c.a(bArr), Short.valueOf(s7), Byte.valueOf(b10), str);
        ICallback<MeshDeviceNode> iCallback = this.mInviteCallback;
        if (iCallback == null) {
            e3.a.e("RTK meshProvsionComplete mInviteCallback == null!", new Object[0]);
            return;
        }
        this.mInviteCallback = null;
        if (b8 == 0) {
            iCallback.onSuccess(new MeshDeviceNode(str, s7, bArr, b10));
        } else {
            iCallback.onFailure(b8 == 5 ? new uSDKError((b8 << 8) + b9, RtkErrMsg.getProvisioningErrMsg(b9)) : new uSDKError(b8 << 8, RtkErrMsg.getRtkErrMsg(b8)));
        }
    }

    @Override // o4.a
    public void meshResetNodeResult(boolean z7) {
        e3.a.e("RTK meshResetNodeResult: %s", Boolean.valueOf(z7));
        s sVar = this.mUnsetDeviceCallback;
        if (sVar == null) {
            e3.a.e("RTK meshResetNodeResult mUnsetDeviceCallback == null!", new Object[0]);
        } else {
            this.mUnsetDeviceCallback = null;
            sVar.onCallback((z7 ? ErrorConst.RET_USDK_OK : ErrorConst.ERR_INTERNAL).toError());
        }
    }

    @Override // o4.a
    public void onVendorModelData(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, byte[] bArr) {
        e3.a.e("RTK onVendorModelData -> %s", com.haier.library.common.util.c.a(bArr));
        IVendorModelCallback iVendorModelCallback = this.mMeshVendorModelCallback;
        if (iVendorModelCallback != null) {
            iVendorModelCallback.onVendorData(i8, i10, i7, i9, i11, i12, i13, i14, i15, i16, bArr);
        } else {
            e3.a.e("RTK onVendorModelData onVendorModelData == null!", new Object[0]);
        }
    }

    @Override // o4.a
    public void onVendorModelDatatrans(int i7) {
        e3.a.e("sendVendorData ret %d", Integer.valueOf(i7));
    }

    @Override // o4.a
    public void receiveProxyConfigurationMessage(int i7, int i8, short s7) {
        e3.a.e("RTK receiveProxyConfigurationMessage unicast == %d-%d-%d!", Integer.valueOf(i7), Integer.valueOf(i8), Short.valueOf(s7));
        IConfigCallback iConfigCallback = this.mConfigCallback;
        if (iConfigCallback != null) {
            iConfigCallback.onGetProxyUnicast(i7);
        } else {
            e3.a.e("RTK receiveProxyConfigurationMessage mConfigCallback == null!", new Object[0]);
        }
    }

    @Override // o4.a
    public void seqNumberNotification(int i7) {
        e3.a.e("RTK seqNumberNotification seqNum = %d", Integer.valueOf(i7));
        ICallback<Integer> iCallback = this.mSeqNumCallback;
        if (iCallback != null) {
            iCallback.onSuccess(Integer.valueOf(i7));
        }
    }

    void setBindAppKeyToModelCallback(s sVar) {
        this.mBindAppKeyToModelCallback = sVar;
    }

    void setConfigCallback(IConfigCallback iConfigCallback) {
        this.mConfigCallback = iConfigCallback;
    }

    void setInviteCallback(ICallback<MeshDeviceNode> iCallback) {
        this.mInviteCallback = iCallback;
    }

    void setMeshCallback(IMeshCallback iMeshCallback) {
        this.mMeshCallback = iMeshCallback;
    }

    void setMeshVendorModelCallback(IVendorModelCallback iVendorModelCallback) {
        this.mMeshVendorModelCallback = iVendorModelCallback;
    }

    synchronized void setNodeIdentityCallback(s sVar) {
        this.nodeIdentityCallback = sVar;
    }

    void setSeqNumCallback(ICallback<Integer> iCallback) {
        this.mSeqNumCallback = iCallback;
    }

    void setSetAppKeyCallback(s sVar) {
        this.mSetAppKeyCallback = sVar;
    }

    void setUnBindAppKeyToModelCallback(s sVar) {
        this.mUnBindAppKeyToModelCallback = sVar;
    }

    void setUnsetDeviceCallback(s sVar) {
        this.mUnsetDeviceCallback = sVar;
    }

    private RtkCoreMeshCallbackWrapper() {
    }
}
