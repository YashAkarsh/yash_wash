package com.haier.uhome.mesh.bridge;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.text.TextUtils;
import com.haier.library.common.util.p;
import com.haier.library.common.util.u;
import com.haier.library.common.util.y;
import com.haier.uhome.mesh.api.model.MeshAppKey;
import com.haier.uhome.mesh.api.model.MeshDeviceNode;
import com.haier.uhome.mesh.api.model.MeshNetKey;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.api.s;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.service.e;
import com.realsil.sdk.mesh.RtkMeshManager;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class RtkCoreMeshWrapper implements IConfigModel, IMesh, IVendorModel {
    private static final byte IDENTITY = 1;
    private static final String LOG_TAG = "Rtk-HaierMesh";
    private static final int MESH_TTL = 4;
    public static final long RTK_PROV_CONNECT_TIMEOUT = 10000;
    private static final long SEQ_NUMBER_SAVE_INTERVAL = 100;
    private static final String SEQ_NUMBER_SAVE_PATH = "rtk_mesh_seq_number";
    private AtomicBoolean mModuleStarted;
    private AtomicBoolean mStackInited;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static RtkCoreMeshWrapper f29497a = new RtkCoreMeshWrapper();

        private a() {
        }
    }

    public static RtkCoreMeshWrapper getInstance() {
        return a.f29497a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r4.a lambda$transformMeshNodes$0(MeshDeviceNode meshDeviceNode) {
        return new r4.a(meshDeviceNode.getUnicast(), meshDeviceNode.getElementNum(), meshDeviceNode.getMeshKey());
    }

    private ErrorConst startMeshModuleIfNeed() {
        if (this.mModuleStarted.get()) {
            e3.a.v("Mesh module is already start!", new Object[0]);
            return ErrorConst.RET_USDK_OK;
        }
        Context contextB = e.a().b();
        if (contextB == null) {
            e3.a.h("startMeshModule fail,context is null ", new Object[0]);
            return ErrorConst.ERR_USDK_NOT_CALL_INIT;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("startMeshModule fail, ble is disable!", new Object[0]);
            return ErrorConst.ERR_USDK_BLE_NOT_OPEN;
        }
        try {
            if (!this.mModuleStarted.compareAndSet(false, true)) {
                return ErrorConst.RET_USDK_OK;
            }
            RtkMeshManager.B(contextB);
            setLogLevel(e3.a.m());
            RtkMeshManager.z().K(false);
            RtkMeshManager.z().J(RtkMeshManagerCallbackWrapper.getInstance());
            n4.b.F().u0(RtkCoreMeshCallbackWrapper.getInstance());
            n4.b.F().B0(RtkCoreMeshGroupBindCallbackWrapper.getInstance());
            e3.a.e("Mesh module start success!", new Object[0]);
            return ErrorConst.RET_USDK_OK;
        } catch (Exception e8) {
            e3.a.h("RTK Mesh initial fail !!", new Object[0]);
            e8.printStackTrace();
            this.mModuleStarted.compareAndSet(true, false);
            return ErrorConst.ERR_INTERNAL;
        }
    }

    private Boolean successInit() {
        return Boolean.valueOf(this.mModuleStarted.get() && this.mStackInited.get());
    }

    private List<r4.a> transformMeshNodes(List<MeshDeviceNode> list) {
        return u.a(list, new p() { // from class: com.haier.uhome.mesh.bridge.b
            @Override // com.haier.library.common.util.p
            public final Object transform(Object obj) {
                return RtkCoreMeshWrapper.lambda$transformMeshNodes$0((MeshDeviceNode) obj);
            }
        });
    }

    @Override // com.haier.uhome.mesh.bridge.IMesh
    public void addKnownNodes(MeshDeviceNode meshDeviceNode, o oVar) {
        if (meshDeviceNode == null) {
            e3.a.h("addKnownNodes error, node is null", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
        }
        e3.a.e("addKnownNodes <%s> ok!", meshDeviceNode);
        DataCenter.getInstance().addKnownNodes(meshDeviceNode);
        n4.b.F().j(transformMeshNodes(Collections.singletonList(meshDeviceNode)));
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
    }

    @Override // com.haier.uhome.mesh.bridge.IConfigModel
    public void addModelToGroup(int i7, int i8, int i9, int i10, s sVar) {
        if (!successInit().booleanValue()) {
            e3.a.v("addModelToGroup fail, stack not init!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_MODULE_UNSTARTED.toError());
        } else if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("addModelToGroup fail, ble is disable!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError());
        } else {
            RtkCoreMeshGroupBindCallbackWrapper.getInstance().setAddModelToGroupCallback(sVar);
            n4.b.F().R((short) i7, i9, (short) i10, false, i8);
        }
    }

    @Override // com.haier.uhome.mesh.bridge.IConfigModel
    public void bindAppKeyToModel(int i7, int i8, int i9, int i10, s sVar) {
        if (!successInit().booleanValue()) {
            e3.a.v("bindAppKeyToModel fail, stack not init!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("bindAppKeyToModel fail, ble is disable!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError());
            return;
        }
        RtkCoreMeshCallbackWrapper.getInstance().setBindAppKeyToModelCallback(sVar);
        short s7 = (short) i7;
        short s8 = (short) (i7 + i8);
        short s9 = (short) i10;
        if (DataCenter.getInstance().getAppKey(i10) != null) {
            n4.b.F().k0(s7, s8, s9, i9);
        } else {
            e3.a.v("bindAppKeyToModel failed,appKey not found by index<%d>", Integer.valueOf(i10));
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        }
    }

    @Override // com.haier.uhome.mesh.bridge.IMesh
    public void closeConnect() {
        RtkMeshManager.z().r();
    }

    @Override // com.haier.uhome.mesh.bridge.IMesh
    public void closeGatt(String str) {
        RtkMeshManager.z().s(str);
    }

    @Override // com.haier.uhome.mesh.bridge.IMesh
    public void initStack(int i7, long j7, List<MeshDeviceNode> list, List<MeshNetKey> list2, List<MeshAppKey> list3, o oVar) {
        ErrorConst errorConstStartMeshModuleIfNeed = startMeshModuleIfNeed();
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (errorConst != errorConstStartMeshModuleIfNeed) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, errorConstStartMeshModuleIfNeed);
            return;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("init fail, ble is disable!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_BLE_NOT_OPEN);
            return;
        }
        if (i7 > 32767 || i7 < 1) {
            e3.a.h("init fail,unicast = <%d>", Integer.valueOf(i7));
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
            return;
        }
        if (j7 < 0) {
            e3.a.h("init fail,ivIndex = <%d>", Long.valueOf(j7));
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
            return;
        }
        if (u.h(list2) || list2.size() < 1) {
            e3.a.h("init fail,netKeys = <%s> ", list2);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
            return;
        }
        if (u.h(list3) || list3.size() < 1) {
            e3.a.h("init fail,appKeys = <%s> ", list3);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
            return;
        }
        this.mStackInited.set(false);
        short s7 = (short) i7;
        try {
            byte[] data = list2.get(0).getData();
            byte[] data2 = list3.get(0).getData();
            transformMeshNodes(list);
            long jK = y.a(e.a().b()).k(SEQ_NUMBER_SAVE_PATH, 0L);
            e3.a.e("stack init seqNumber to %d", Long.valueOf(jK));
            int iG0 = n4.b.F().g0(s7, data, data2, null, j7, jK > 0 ? jK : 0L);
            if (iG0 == 0 || iG0 == 3) {
                DataCenter.getInstance().recordInitData(i7, j7, list, list2, list3);
                this.mStackInited.set(true);
                com.haier.uhome.usdk.base.utils.b.a(oVar, errorConst);
                long j8 = jK + SEQ_NUMBER_SAVE_INTERVAL;
                e3.a.e("stack init record seqNumber to %d", Long.valueOf(j8));
                y.a(e.a().b()).f(SEQ_NUMBER_SAVE_PATH, j8);
                RtkCoreMeshCallbackWrapper.getInstance().setSeqNumCallback(new ICallback<Integer>() { // from class: com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper.1
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(Integer num) {
                        e3.a.e("stack init record seqNumber to %d", num);
                        y.a(e.a().b()).f(RtkCoreMeshWrapper.SEQ_NUMBER_SAVE_PATH, num.intValue());
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                    }
                });
            } else {
                e3.a.h("init fail, meshStackInit ret -> %d", Integer.valueOf(iG0));
                com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
            }
        } catch (Exception e8) {
            e3.a.h("init fail, %s", e8.getMessage());
            this.mStackInited.set(false);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
        }
    }

    @Override // com.haier.uhome.mesh.bridge.IConfigModel
    public void inviteByOOB(String str, int i7, byte[] bArr, int i8, ICallback<MeshDeviceNode> iCallback) {
        e3.a.e("inviteByOOB params address: %s, attentionDuration: %d, oob: %s, unicast: %d", str, Integer.valueOf(i7), com.haier.library.common.util.c.a(bArr), Integer.valueOf(i8));
        if (!successInit().booleanValue()) {
            e3.a.v("inviteByOOB fail, stack not init!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("inviteByOOB fail, ble is disable!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError());
            return;
        }
        if (TextUtils.isEmpty(str) || !BluetoothAdapter.checkBluetoothAddress(str.toUpperCase())) {
            e3.a.v("inviteByOOB fail, address = <%s>!", str);
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (i7 < 0) {
            e3.a.v("inviteByOOB fail, attentionDuration = <%d>!", Integer.valueOf(i7));
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (i8 < 0) {
            e3.a.v("inviteByOOB fail, unicast = <%d>!", Integer.valueOf(i8));
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        } else if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("inviteByOOB fail, ble is disable!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError());
        } else {
            RtkCoreMeshCallbackWrapper.getInstance().setInviteCallback(iCallback);
            RtkMeshManager.z().F(str.toUpperCase(), (byte) i7, bArr, i8, RTK_PROV_CONNECT_TIMEOUT);
        }
    }

    @Override // com.haier.uhome.mesh.bridge.IConfigModel
    public boolean isNodeIdentifyAdvAddress(int i7, byte[] bArr, byte[] bArr2) {
        return RtkMeshManager.z().E(i7, bArr, bArr2);
    }

    @Override // com.haier.uhome.mesh.bridge.IVendorModel
    public int registerVendorModel(int i7, int i8, IVendorModelCallback iVendorModelCallback) {
        if (!successInit().booleanValue()) {
            e3.a.v("registerVendorModel fail, stack not init!", new Object[0]);
            return -1;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("registerVendorModel fail, ble is disable!", new Object[0]);
            return -2;
        }
        RtkCoreMeshCallbackWrapper.getInstance().setMeshVendorModelCallback(iVendorModelCallback);
        boolean zJ0 = n4.b.F().j0((short) i7, i8);
        e3.a.e("registerVendorModel modelId -> 0x%s ret = %s", Integer.toHexString(i8), Boolean.valueOf(zJ0));
        return zJ0 ? 0 : -5;
    }

    @Override // com.haier.uhome.mesh.bridge.IConfigModel
    public void rmModelFromGroup(int i7, int i8, int i9, int i10, s sVar) {
        if (!successInit().booleanValue()) {
            e3.a.v("rmModelFromGroup fail, stack not init!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_MODULE_UNSTARTED.toError());
        } else if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("rmModelFromGroup fail, ble is disable!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError());
        } else {
            RtkCoreMeshGroupBindCallbackWrapper.getInstance().setRmModelToGroupCallback(sVar);
            n4.b.F().W((short) i7, i9, (short) i10, false, i8);
        }
    }

    @Override // com.haier.uhome.mesh.bridge.IVendorModel
    public int sendVendorData(int i7, int i8, byte[] bArr, int i9) {
        if (!successInit().booleanValue()) {
            e3.a.v("sendVendorData fail, stack not init!", new Object[0]);
            return -1;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("sendVendorData fail, ble is disable!", new Object[0]);
            return -2;
        }
        short s7 = (short) i8;
        if (DataCenter.getInstance().getAppKey(i8) == null) {
            e3.a.v("sendVendorData failed,appKey not found by index<%d>", Integer.valueOf(i8));
            return -3;
        }
        byte bW0 = n4.b.F().w0(i7, s7, bArr, bArr.length, i9);
        e3.a.e("sendVendorData to %d ret -> %d", Integer.valueOf(i7), Integer.valueOf(bW0));
        return bW0;
    }

    @Override // com.haier.uhome.mesh.bridge.IConfigModel
    public void setAppKey(int i7, int i8, int i9, s sVar) {
        if (!successInit().booleanValue()) {
            e3.a.v("setAppKey fail, stack not init!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("setAppKey fail, ble is disable!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError());
            return;
        }
        short s7 = (short) i7;
        short s8 = (short) i8;
        short s9 = (short) i9;
        MeshAppKey appKey = DataCenter.getInstance().getAppKey(i9);
        if (appKey == null) {
            e3.a.v("setAppKey failed,appKey not found by index<%d>", Integer.valueOf(i9));
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        } else {
            RtkCoreMeshCallbackWrapper.getInstance().setSetAppKeyCallback(sVar);
            n4.b.F().k(s7, s8, s9, appKey.getData());
        }
    }

    @Override // com.haier.uhome.mesh.bridge.IConfigModel
    public void setCallback(IConfigCallback iConfigCallback) {
        RtkCoreMeshCallbackWrapper.getInstance().setConfigCallback(iConfigCallback);
    }

    @Override // com.haier.uhome.mesh.bridge.IConfigModel
    public void setCfgNodeIdentity(int i7, int i8, s sVar) {
        if (!successInit().booleanValue()) {
            e3.a.v("rmModelFromGroup fail, stack not init!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_MODULE_UNSTARTED.toError());
        } else {
            synchronized (RtkCoreMeshCallbackWrapper.getInstance()) {
                n4.b.F().y0((short) i7, (short) i8, (byte) 1);
                RtkCoreMeshCallbackWrapper.getInstance().setNodeIdentityCallback(sVar);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x001e  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.haier.uhome.mesh.bridge.IMesh
    public void setLogLevel(int i7) {
        int i8;
        boolean z7;
        RtkMeshManager rtkMeshManagerZ;
        if (i7 != 1) {
            if (i7 != 2) {
                i8 = 4;
                if (i7 != 4) {
                    if (i7 != 8) {
                        i8 = 0;
                    } else {
                        i8 = 5;
                    }
                }
            } else {
                i8 = 3;
            }
            z7 = 1;
            rtkMeshManagerZ = RtkMeshManager.z();
            if (rtkMeshManagerZ != null) {
                e3.a.e("setLogLevel RTKMesh enable -> %s level -> %d rtkLogLevel -> %d", Boolean.valueOf(z7), Integer.valueOf(i7), Integer.valueOf(i8));
                rtkMeshManagerZ.I(LOG_TAG, z7, i8);
            }
        }
        i8 = 1;
        z7 = i8;
        rtkMeshManagerZ = RtkMeshManager.z();
        if (rtkMeshManagerZ != null) {
            e3.a.e("setLogLevel RTKMesh enable -> %s level -> %d rtkLogLevel -> %d", Boolean.valueOf(z7), Integer.valueOf(i7), Integer.valueOf(i8));
            rtkMeshManagerZ.I(LOG_TAG, z7, i8);
        }
    }

    @Override // com.haier.uhome.mesh.bridge.IMesh
    public void setMeshCallback(IMeshCallback iMeshCallback) {
        RtkMeshManagerCallbackWrapper.getInstance().setMeshCallback(iMeshCallback);
        RtkCoreMeshCallbackWrapper.getInstance().setMeshCallback(iMeshCallback);
    }

    @Override // com.haier.uhome.mesh.bridge.IConfigModel
    public void setProxyFilterType(int i7, s sVar) {
        if (!successInit().booleanValue()) {
            e3.a.v("setProxyFilterType fail, stack not init!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_MODULE_UNSTARTED.toError());
        } else if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("setProxyFilterType fail, ble is disable!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError());
        } else {
            e3.a.v("proxyCfgSetFilterType ret, %s", Boolean.valueOf(n4.b.F().p0(i7)));
            e3.a.v("proxyCfgAddRemoveAddr[set white list] ret, %s", Boolean.valueOf(n4.b.F().o0((short) 1, true, new short[]{-1}, (short) 1)));
            n4.b.F().E0(4);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.RET_USDK_OK.toError());
        }
    }

    @Override // com.haier.uhome.mesh.bridge.IMesh
    public void setProxyNode(String str, o oVar) {
        if (!successInit().booleanValue()) {
            e3.a.v("setProxyNode fail, stack not init!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_MODULE_UNSTARTED);
            return;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("setProxyNode fail, ble is disable!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_BLE_NOT_OPEN);
        } else if (TextUtils.isEmpty(str) || !BluetoothAdapter.checkBluetoothAddress(str.toUpperCase())) {
            e3.a.v("setProxyNode fail, address = <%s>!", str);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
        } else {
            e3.a.e("RTK setProxyNode ret -> %s", Boolean.valueOf(RtkMeshManager.z().k(str.toUpperCase())));
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
        }
    }

    @Override // com.haier.uhome.mesh.bridge.IMesh
    public void startAutoConnect() {
        RtkMeshManager.z().L();
    }

    @Override // com.haier.uhome.mesh.bridge.IMesh
    public void startMeshModule(o oVar) {
        com.haier.uhome.usdk.base.utils.b.a(oVar, startMeshModuleIfNeed());
    }

    @Override // com.haier.uhome.mesh.bridge.IMesh
    public void stopMeshModule(o oVar) {
        if (!this.mModuleStarted.get()) {
            e3.a.v("Mesh module is already stop!", new Object[0]);
            return;
        }
        RtkMeshManager rtkMeshManagerZ = RtkMeshManager.z();
        if (rtkMeshManagerZ != null) {
            rtkMeshManagerZ.J(null);
        }
        n4.b bVarF = n4.b.F();
        if (bVarF != null) {
            bVarF.F0(RtkCoreMeshCallbackWrapper.getInstance());
            bVarF.B0(null);
        }
        this.mModuleStarted.set(false);
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
    }

    @Override // com.haier.uhome.mesh.bridge.IConfigModel
    public void unBindAppKeyFromModel(int i7, int i8, int i9, int i10, s sVar) {
        if (!successInit().booleanValue()) {
            e3.a.v("unBindAppKeyFromModel fail, stack not init!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_MODULE_UNSTARTED.toError());
        } else {
            if (!com.haier.uhome.usdk.base.utils.a.c()) {
                e3.a.v("unBindAppKeyFromModel fail, ble is disable!", new Object[0]);
                com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError());
                return;
            }
            RtkCoreMeshCallbackWrapper.getInstance().setUnBindAppKeyToModelCallback(sVar);
            n4.b.F().l0((short) i7, (short) (i7 + i8), (short) i10, i9);
        }
    }

    @Override // com.haier.uhome.mesh.bridge.IConfigModel
    public void unsetDevice(int i7, s sVar) {
        if (!successInit().booleanValue()) {
            e3.a.v("unsetDevice fail, stack not init!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_MODULE_UNSTARTED.toError());
        } else if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("unsetDevice fail, ble is disable!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(sVar, ErrorConst.ERR_USDK_BLE_NOT_OPEN.toError());
        } else {
            RtkCoreMeshCallbackWrapper.getInstance().setUnsetDeviceCallback(sVar);
            n4.b.F().v0((short) i7);
        }
    }

    private RtkCoreMeshWrapper() {
        this.mModuleStarted = new AtomicBoolean(false);
        this.mStackInited = new AtomicBoolean(false);
    }
}
