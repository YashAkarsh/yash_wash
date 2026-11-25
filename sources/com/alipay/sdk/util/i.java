package com.alipay.sdk.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.alipay.android.app.IRemoteServiceCallback;

/* JADX INFO: loaded from: classes.dex */
class i extends IRemoteServiceCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f13804a;

    i(f fVar) {
        this.f13804a = fVar;
    }

    @Override // com.alipay.android.app.IRemoteServiceCallback
    public boolean isHideLoadingScreen() throws RemoteException {
        return false;
    }

    @Override // com.alipay.android.app.IRemoteServiceCallback
    public void payEnd(boolean z7, String str) throws RemoteException {
    }

    @Override // com.alipay.android.app.IRemoteServiceCallback
    public void startActivity(String str, String str2, int i7, Bundle bundle) throws RemoteException {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putInt("CallingPid", i7);
            intent.putExtras(bundle);
        } catch (Exception unused) {
        }
        intent.setClassName(str, str2);
        if (this.f13804a.f13793a != null) {
            this.f13804a.f13793a.startActivity(intent);
        }
        this.f13804a.f13797e.b();
    }
}
