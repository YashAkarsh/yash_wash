package com.haier.uhome.mesh.bridge;

import n4.d;

/* JADX INFO: loaded from: classes2.dex */
public class RtkMeshManagerCallbackWrapper extends d {
    private volatile IMeshCallback mMeshCallback;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static RtkMeshManagerCallbackWrapper f29498a = new RtkMeshManagerCallbackWrapper();

        private a() {
        }
    }

    public static RtkMeshManagerCallbackWrapper getInstance() {
        return a.f29498a;
    }

    @Override // n4.d
    public void onProxyDeviceConnected(String str) {
        if (this.mMeshCallback != null) {
            this.mMeshCallback.onProxyConnected(str);
        }
    }

    @Override // n4.d
    public void onProxyDeviceDisconnected(String str) {
        if (this.mMeshCallback != null) {
            this.mMeshCallback.onProxyDisConnected(str);
        }
    }

    void setMeshCallback(IMeshCallback iMeshCallback) {
        this.mMeshCallback = iMeshCallback;
    }

    private RtkMeshManagerCallbackWrapper() {
    }
}
