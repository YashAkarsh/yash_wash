package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f16036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Intent f16037b;

    n(Context context, Intent intent) {
        this.f16036a = context;
        this.f16037b = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.f16036a.startActivity(this.f16037b);
        } catch (ActivityNotFoundException e8) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e8);
        }
    }
}
