package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class zabx extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    Context f15476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b2 f15477b;

    public zabx(b2 b2Var) {
        this.f15477b = b2Var;
    }

    public final void a(Context context) {
        this.f15476a = context;
    }

    public final synchronized void b() {
        Context context = this.f15476a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f15476a = null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f15477b.a();
            b();
        }
    }
}
