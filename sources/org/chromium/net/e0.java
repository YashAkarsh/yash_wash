package org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
final class e0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProxyChangeListener f39133a;

    e0(ProxyChangeListener proxyChangeListener) {
        this.f39133a = proxyChangeListener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
            this.f39133a.n();
        }
    }
}
