package com.haier.uhome.mesh.api;

import com.haier.uhome.mesh.api.callback.MeshScannerCallback;
import com.haier.uhome.mesh.bridge.IScanner;
import com.haier.uhome.mesh.bridge.IScannerCallback;
import com.haier.uhome.mesh.bridge.RtkScannerWrapper;
import com.haier.uhome.usdk.base.api.o;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MeshScannerManager {
    private Map<MeshScannerCallback, IScannerCallback> mCallbackMap;
    private IScanner mIScanner;

    private static class a implements IScannerCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MeshScannerCallback f29490a;

        a(MeshScannerCallback meshScannerCallback) {
            this.f29490a = meshScannerCallback;
        }

        @Override // com.haier.uhome.mesh.bridge.IScannerCallback
        public void onProxyDeviceFound(String str, String str2, int i7, byte[] bArr) {
            this.f29490a.onProxyDeviceFound(str, str2, i7);
        }

        @Override // com.haier.uhome.mesh.bridge.IScannerCallback
        public void onUnProvDeviceFound(String str, String str2, byte[] bArr, byte[] bArr2) {
            this.f29490a.onUnProvDeviceFound(str, str2, bArr);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static MeshScannerManager f29491a = new MeshScannerManager();

        private b() {
        }
    }

    public static MeshScannerManager getInstance() {
        return b.f29491a;
    }

    public void registerCallback(MeshScannerCallback meshScannerCallback) {
        if (meshScannerCallback != null && this.mCallbackMap.get(meshScannerCallback) == null) {
            a aVar = new a(meshScannerCallback);
            this.mIScanner.registerCallback(aVar);
            this.mCallbackMap.put(meshScannerCallback, aVar);
        }
    }

    public void scanProv(o oVar) {
        this.mIScanner.scanProv(oVar);
    }

    public void scanProxy(o oVar) {
        this.mIScanner.scanProxy(oVar);
    }

    public void stopScanProv(o oVar) {
        this.mIScanner.stopScanProv(oVar);
    }

    public void stopScanProxy(o oVar) {
        this.mIScanner.stopScanProxy(oVar);
    }

    public void unRegisterCallback(MeshScannerCallback meshScannerCallback) {
        IScannerCallback iScannerCallback;
        if (meshScannerCallback == null || (iScannerCallback = this.mCallbackMap.get(meshScannerCallback)) == null) {
            return;
        }
        this.mIScanner.unRegisterCallback(iScannerCallback);
        this.mCallbackMap.remove(meshScannerCallback);
    }

    private MeshScannerManager() {
        this.mCallbackMap = new HashMap();
        this.mIScanner = RtkScannerWrapper.getInstance();
    }
}
