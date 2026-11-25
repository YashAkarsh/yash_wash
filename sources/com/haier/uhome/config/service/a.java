package com.haier.uhome.config.service;

import android.util.Base64;
import com.haier.uhome.config.json.ConfigProtocol;
import com.haier.uhome.config.json.req.BleMeshDeviceInfoReq;
import com.haier.uhome.config.json.resp.BleMeshDeviceInfoResp;
import com.haier.uhome.mesh.api.ConfigClientModel;
import com.haier.uhome.mesh.api.model.MeshAppKey;
import com.haier.uhome.mesh.api.model.MeshDeviceNode;
import com.haier.uhome.mesh.api.model.MeshNetKey;
import com.haier.uhome.mesh.util.KeyTools;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.haier.library.common.util.m implements ICallback<MeshDeviceNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28511a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f28512b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f28513c = "CONNECTED";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f28514d = 2345;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f28515e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f28516f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f28517g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f28518h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f28519i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.haier.uhome.config.entity.a.a f28520j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MeshDeviceNode f28521k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.haier.uhome.config.a.h<Integer, String> f28522l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.haier.uhome.usdk.base.d.e f28523m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BleMeshDeviceInfoResp f28524n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ConfigClientModel f28525o = ConfigClientModel.getInstance();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f28526p;

    static {
        ConfigProtocol.registerBleMesh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void c(BleMeshDeviceInfoResp bleMeshDeviceInfoResp) {
        this.f28526p = 2;
        this.f28525o.inviteByOOB(this.f28520j.a(), 0, Base64.decode(bleMeshDeviceInfoResp.getOob(), 2), bleMeshDeviceInfoResp.getElementAddr(), this);
    }

    public void a(com.haier.uhome.config.entity.a.a aVar, final TraceNode traceNode, com.haier.uhome.usdk.base.d.e eVar, int i7, com.haier.uhome.config.a.h<Integer, String> hVar) {
        if (b()) {
            hVar.onFailure(ErrorConst.ERR_USDK_DEVICE_CONFIG_IN_PROGRESS.toError());
            return;
        }
        this.f28520j = aVar;
        this.f28522l = hVar;
        this.f28523m = eVar;
        a(i7);
        hVar.a(1);
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.config.service.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f28698a.c(traceNode);
            }
        });
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onFailure(uSDKError usdkerror) {
        e3.a.e("Mesh config: inviteByOOB error %s", usdkerror.toString());
        if (c()) {
            e3.a.v("Mesh config: inviteByOOB failure but already total timeout!", new Object[0]);
            return;
        }
        final BleMeshDeviceInfoResp bleMeshDeviceInfoResp = this.f28524n;
        if (!ConfigClientModel.INVITE_OOB_ERRORS_NO_RETRY.contains(Integer.valueOf(usdkerror.getCode()))) {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.config.service.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28685a.c(bleMeshDeviceInfoResp);
                }
            }, 1L);
        } else {
            this.f28522l.onFailure(usdkerror);
            d();
        }
    }

    private void f() {
        this.f28525o.bindAppKeyToModel(this.f28521k.getUnicast(), 0, KeyTools.getVendorModelId(f28514d, 1), this.f28520j.f().c().getIndex(), new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.config.service.t
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                this.f28689a.b(usdkerror);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        b(this.f28521k);
    }

    private void b(MeshDeviceNode meshDeviceNode) {
        this.f28526p = 3;
        com.haier.uhome.config.entity.a.b bVarF = this.f28520j.f();
        MeshNetKey meshNetKeyB = bVarF.b();
        MeshAppKey meshAppKeyC = bVarF.c();
        if (meshNetKeyB == null) {
            e3.a.v("Mesh config: setAppKey netKey is null!", new Object[0]);
            this.f28522l.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        } else if (meshAppKeyC == null) {
            e3.a.v("Mesh config: setAppKey appKey is null!", new Object[0]);
            this.f28522l.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        } else {
            this.f28525o.setAppKey(meshDeviceNode.getUnicast(), meshNetKeyB.getIndex(), meshAppKeyC.getIndex(), new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.config.service.r
                @Override // com.haier.uhome.usdk.base.api.s
                public final void onCallback(uSDKError usdkerror) {
                    this.f28680a.a(usdkerror);
                }
            });
        }
    }

    private void a(BleMeshDeviceInfoResp bleMeshDeviceInfoResp) {
        this.f28524n = bleMeshDeviceInfoResp;
        this.f28522l.a(2);
        c(bleMeshDeviceInfoResp);
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(MeshDeviceNode meshDeviceNode) {
        if (c()) {
            e3.a.v("Mesh config: inviteByOOB success but already total timeout!", new Object[0]);
        } else {
            this.f28521k = meshDeviceNode;
            b(meshDeviceNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(uSDKError usdkerror) {
        e3.a.e("Mesh config: onBindAppKeyToModel result error: %s!", usdkerror);
        if (c()) {
            e3.a.v("Mesh config: onBindAppKeyToModel result but already total timeout!", new Object[0]);
        } else if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
            this.f28522l.onSuccess(com.haier.library.common.util.c.a(this.f28521k.getMeshKey()));
            d();
        } else {
            this.f28522l.onFailure(usdkerror);
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(uSDKError usdkerror) {
        e3.a.e("Mesh config: setAppKey result error: %s!", usdkerror);
        if (c()) {
            e3.a.v("Mesh config: setAppKey result but already total timeout!", new Object[0]);
        } else if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
            f();
        } else {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.config.service.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28678a.g();
                }
            }, 1000L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void c(final TraceNode traceNode) {
        this.f28526p = 1;
        com.haier.uhome.config.entity.a.a aVar = this.f28520j;
        if (!"CONNECTED".equals(this.f28522l.a())) {
            this.f28522l.onFailure(ErrorConst.ERR_USDK_CLOUD_OFFLINE.toError());
            d();
            return;
        }
        BleMeshDeviceInfoReq bleMeshDeviceInfoReq = new BleMeshDeviceInfoReq();
        bleMeshDeviceInfoReq.setNativeSender(this.f28523m);
        bleMeshDeviceInfoReq.setTimeout(5);
        bleMeshDeviceInfoReq.setElementNum(1);
        bleMeshDeviceInfoReq.setUuid(aVar.b());
        bleMeshDeviceInfoReq.setNetID(String.valueOf(aVar.f().a()));
        bleMeshDeviceInfoReq.setTraceId(traceNode != null ? traceNode.getTraceId() : "");
        bleMeshDeviceInfoReq.setLongProductCode(aVar.e());
        bleMeshDeviceInfoReq.setUplusID(aVar.c());
        com.haier.uhome.usdk.base.d.f.a().a(bleMeshDeviceInfoReq, 5, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.config.service.v
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f28694a.a(traceNode, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BasicResp basicResp, final TraceNode traceNode) {
        if (c()) {
            e3.a.v("Mesh config: ble_mesh_device_info_resp but already total timeout!", new Object[0]);
            return;
        }
        BleMeshDeviceInfoResp bleMeshDeviceInfoResp = (BleMeshDeviceInfoResp) basicResp;
        if (bleMeshDeviceInfoResp.getErrNo() == ErrorConst.ERR_USDK_TIMEOUT.getErrorId()) {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.config.service.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28691a.b(traceNode);
                }
            }, 200L, TimeUnit.MILLISECONDS);
        } else if (bleMeshDeviceInfoResp.getErrNo() == ErrorConst.RET_USDK_OK.getErrorId()) {
            a(bleMeshDeviceInfoResp);
        } else {
            this.f28522l.onFailure(com.haier.uhome.usdk.base.utils.c.a(basicResp));
            d();
        }
    }

    @Override // com.haier.library.common.util.m
    protected void a() {
        int i7 = this.f28526p;
        if (i7 == 1) {
            this.f28522l.onFailure(ErrorConst.ERR_USDK_MESH_DEVICE_INFO_REQUEST_FAIL.toError());
            return;
        }
        if (i7 == 2) {
            this.f28522l.onFailure(ErrorConst.ERR_USDK_MESH_DEVICE_PROVISION_FAIL.toError());
        } else if (i7 == 3) {
            this.f28522l.onFailure(ErrorConst.ERR_USDK_MESH_DEVICE_CONFIGURATION_FAIL.toError());
        } else {
            this.f28522l.onFailure(ErrorConst.ERR_USDK_TIMEOUT.toError());
        }
    }
}
