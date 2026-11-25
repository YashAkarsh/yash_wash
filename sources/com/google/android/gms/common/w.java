package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"HandlerLeak"})
final class w extends com.google.android.gms.internal.base.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f15997b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(g gVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f15997b = gVar;
        this.f15996a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i7 = message.what;
        if (i7 != 1) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Don't know how to handle this message: ");
            sb.append(i7);
            Log.w("GoogleApiAvailability", sb.toString());
            return;
        }
        int iJ = this.f15997b.j(this.f15996a);
        if (this.f15997b.o(iJ)) {
            this.f15997b.C(this.f15996a, iJ);
        }
    }
}
