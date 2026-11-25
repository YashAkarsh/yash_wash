package com.haier.uhome.mesh.api;

import com.haier.uhome.mesh.api.callback.MeshConfigCallback;
import com.haier.uhome.mesh.api.model.MeshDeviceNode;
import com.haier.uhome.mesh.bridge.IConfigCallback;
import com.haier.uhome.mesh.bridge.IConfigModel;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.s;
import f4.e;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigClientModel {
    public static final List<Integer> INVITE_OOB_ERRORS_NO_RETRY = Arrays.asList(Integer.valueOf(e.a.f33921a), 1281, 1282, 1284, 1286, 1289, 1536, 4608);
    public static final int PROXY_FILTER_BLACK_LIST = 1;
    public static final int PROXY_FILTER_WHITE_LIST = 0;
    private IConfigModel mIConfigModel;
    private List<MeshConfigCallback> mProxyConfigCallbacks;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ConfigClientModel f29486a = new ConfigClientModel();

        private a() {
        }
    }

    public static ConfigClientModel getInstance() {
        return a.f29486a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(int i7) {
        Iterator<MeshConfigCallback> it = this.mProxyConfigCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onGetProxyUnicast(i7);
        }
    }

    public void addModelToGroup(int i7, int i8, int i9, int i10, s sVar) {
        this.mIConfigModel.addModelToGroup(i7, i8, i9, i10, sVar);
    }

    public void bindAppKeyToModel(int i7, int i8, int i9, int i10, s sVar) {
        this.mIConfigModel.bindAppKeyToModel(i7, i8, i9, i10, sVar);
    }

    public void inviteByOOB(String str, int i7, byte[] bArr, int i8, ICallback<MeshDeviceNode> iCallback) {
        this.mIConfigModel.inviteByOOB(str, i7, bArr, i8, iCallback);
    }

    public void registerCallback(MeshConfigCallback meshConfigCallback) {
        this.mProxyConfigCallbacks.add(meshConfigCallback);
    }

    public void rmModelFromGroup(int i7, int i8, int i9, int i10, s sVar) {
        this.mIConfigModel.rmModelFromGroup(i7, i8, i9, i10, sVar);
    }

    public void setAppKey(int i7, int i8, int i9, s sVar) {
        this.mIConfigModel.setAppKey(i7, i8, i9, sVar);
    }

    public void setProxyFilterType(int i7, s sVar) {
        this.mIConfigModel.setProxyFilterType(i7, sVar);
    }

    public void unBindAppKeyFromModel(int i7, int i8, int i9, int i10, s sVar) {
        this.mIConfigModel.unBindAppKeyFromModel(i7, i8, i9, i10, sVar);
    }

    public void unRegisterCallback(MeshConfigCallback meshConfigCallback) {
        this.mProxyConfigCallbacks.remove(meshConfigCallback);
    }

    public void unsetDevice(int i7, s sVar) {
        this.mIConfigModel.unsetDevice(i7, sVar);
    }

    private ConfigClientModel() {
        this.mProxyConfigCallbacks = new CopyOnWriteArrayList();
        RtkCoreMeshWrapper rtkCoreMeshWrapper = RtkCoreMeshWrapper.getInstance();
        this.mIConfigModel = rtkCoreMeshWrapper;
        rtkCoreMeshWrapper.setCallback(new IConfigCallback() { // from class: com.haier.uhome.mesh.api.a
            @Override // com.haier.uhome.mesh.bridge.IConfigCallback
            public final void onGetProxyUnicast(int i7) {
                this.f29492a.lambda$new$0(i7);
            }
        });
    }
}
