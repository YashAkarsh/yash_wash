package com.haier.uhome.mesh.api;

import com.haier.uhome.mesh.api.callback.MeshNetworkCallback;
import com.haier.uhome.mesh.api.model.InitNodeParam;
import com.haier.uhome.mesh.api.model.MeshDeviceNode;
import com.haier.uhome.mesh.bridge.IMeshCallback;
import com.haier.uhome.mesh.service.NetworkManagerService;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.utils.b;

/* JADX INFO: loaded from: classes2.dex */
public class MeshNetworkManager {
    private NetworkManagerService mNetworkManagerService;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static MeshNetworkManager f29489a = new MeshNetworkManager();

        private a() {
        }
    }

    public static MeshNetworkManager getInstance() {
        return a.f29489a;
    }

    public void addKnownNodes(MeshDeviceNode meshDeviceNode, o oVar) {
        this.mNetworkManagerService.addKnownNodes(meshDeviceNode, oVar);
    }

    public void initStack(InitNodeParam initNodeParam, o oVar) {
        if (initNodeParam == null) {
            e3.a.h("init failed, initNodeParam is null", new Object[0]);
            b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
            return;
        }
        this.mNetworkManagerService.initStack(initNodeParam.getUnicast(), initNodeParam.getIvIndex(), initNodeParam.getKnownNodes(), initNodeParam.getNetKeys(), initNodeParam.getAppKeys(), oVar);
    }

    public void setLogLevel(int i7) {
        this.mNetworkManagerService.setLogLevel(i7);
    }

    public void setNetworkCallback(final MeshNetworkCallback meshNetworkCallback) {
        if (meshNetworkCallback != null) {
            this.mNetworkManagerService.setCallback(new IMeshCallback() { // from class: com.haier.uhome.mesh.api.MeshNetworkManager.1
                @Override // com.haier.uhome.mesh.bridge.IMeshCallback
                public void onIvIndexUpdate(long j7) {
                    meshNetworkCallback.onIvIndexUpdate(j7);
                }

                @Override // com.haier.uhome.mesh.bridge.IMeshCallback
                public void onProxyConnected(String str) {
                    meshNetworkCallback.onProxyConnected(str);
                }

                @Override // com.haier.uhome.mesh.bridge.IMeshCallback
                public void onProxyDisConnected(String str) {
                    meshNetworkCallback.onProxyDisConnected(str);
                }
            });
        }
    }

    public void setProxyNode(String str, o oVar) {
        this.mNetworkManagerService.setProxyNode(str, oVar);
    }

    public void startMeshModule(o oVar) {
        this.mNetworkManagerService.startMeshModule(oVar);
    }

    public void stopMeshModule(o oVar) {
        this.mNetworkManagerService.stopMeshModule(oVar);
    }

    private MeshNetworkManager() {
        this.mNetworkManagerService = NetworkManagerService.getInstance();
    }
}
