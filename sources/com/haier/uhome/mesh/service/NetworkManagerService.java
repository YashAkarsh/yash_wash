package com.haier.uhome.mesh.service;

import com.haier.uhome.mesh.api.model.MeshAppKey;
import com.haier.uhome.mesh.api.model.MeshDeviceNode;
import com.haier.uhome.mesh.api.model.MeshNetKey;
import com.haier.uhome.mesh.bridge.IMesh;
import com.haier.uhome.mesh.bridge.IMeshCallback;
import com.haier.uhome.mesh.bridge.IVendorModel;
import com.haier.uhome.mesh.bridge.IVendorModelCallback;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import com.haier.uhome.mesh.util.KeyTools;
import com.haier.uhome.usdk.base.api.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkManagerService {
    private IMesh mIMesh;
    private IVendorModel mIVendorModel;
    private Map<Long, HaierClientModel> mModelHashMap;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static NetworkManagerService f29506a = new NetworkManagerService();

        private a() {
        }
    }

    public static NetworkManagerService getInstance() {
        return a.f29506a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerVendorModel$0(MeshVendorModelCallback meshVendorModelCallback, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, byte[] bArr) {
        if (meshVendorModelCallback != null) {
            meshVendorModelCallback.onVendorData(i7, i8, new VendorData(i9, i12, i13, i14, i15, i16, i17, i18, bArr));
        }
    }

    public void addKnownNodes(MeshDeviceNode meshDeviceNode, o oVar) {
        this.mIMesh.addKnownNodes(meshDeviceNode, oVar);
    }

    public HaierClientModel getVendorModel(int i7, int i8) {
        return this.mModelHashMap.get(Long.valueOf(KeyTools.getGlobalVendorModelId(i7, i8)));
    }

    public void initStack(int i7, long j7, List<MeshDeviceNode> list, List<MeshNetKey> list2, List<MeshAppKey> list3, o oVar) {
        this.mIMesh.initStack(i7, j7, list, list2, list3, oVar);
    }

    int registerVendorModel(final int i7, final int i8, final MeshVendorModelCallback meshVendorModelCallback) {
        try {
            if (this.mModelHashMap == null) {
                this.mModelHashMap = new HashMap();
            }
            Long lValueOf = Long.valueOf(KeyTools.getGlobalVendorModelId(i7, i8));
            if (this.mModelHashMap.containsKey(lValueOf)) {
                e3.a.v("Model already register", new Object[0]);
                return -4;
            }
            this.mModelHashMap.put(lValueOf, new HaierClientModel(i7, i8));
            return this.mIVendorModel.registerVendorModel(i7, i8, new IVendorModelCallback() { // from class: com.haier.uhome.mesh.service.b
                @Override // com.haier.uhome.mesh.bridge.IVendorModelCallback
                public final void onVendorData(int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, byte[] bArr) {
                    NetworkManagerService.lambda$registerVendorModel$0(meshVendorModelCallback, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, bArr);
                }
            });
        } catch (Exception e8) {
            e3.a.u("registerVendorModel <%s-%s> error <%s>", Integer.toHexString(i7), Integer.toHexString(i8), e8.getMessage());
            return -6;
        }
    }

    public void setCallback(IMeshCallback iMeshCallback) {
        this.mIMesh.setMeshCallback(iMeshCallback);
    }

    public void setLogLevel(int i7) {
        this.mIMesh.setLogLevel(i7);
    }

    public void setProxyNode(String str, o oVar) {
        this.mIMesh.setProxyNode(str, oVar);
    }

    public void startMeshModule(o oVar) {
        this.mIMesh.startMeshModule(oVar);
    }

    public void stopMeshModule(o oVar) {
        this.mIMesh.stopMeshModule(oVar);
    }

    private NetworkManagerService() {
        this.mModelHashMap = new HashMap();
        this.mIMesh = RtkCoreMeshWrapper.getInstance();
        this.mIVendorModel = RtkCoreMeshWrapper.getInstance();
    }
}
