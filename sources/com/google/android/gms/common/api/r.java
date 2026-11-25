package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import c.m0;
import com.google.android.gms.common.api.t;

/* JADX INFO: loaded from: classes.dex */
public abstract class r<R extends t> extends v<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f15517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15518b;

    protected r(@m0 Activity activity, int i7) {
        com.google.android.gms.common.internal.u.l(activity, "Activity must not be null");
        this.f15517a = activity;
        this.f15518b = i7;
    }

    @Override // com.google.android.gms.common.api.v
    @c1.a
    public final void b(@m0 Status status) {
        if (!status.s0()) {
            d(status);
            return;
        }
        try {
            status.I0(this.f15517a, this.f15518b);
        } catch (IntentSender.SendIntentException e8) {
            Log.e("ResolvingResultCallback", "Failed to start resolution", e8);
            d(new Status(8));
        }
    }

    @Override // com.google.android.gms.common.api.v
    public abstract void c(@m0 R r7);

    public abstract void d(@m0 Status status);
}
