package com.google.android.gms.common.api;

import android.util.Log;
import c.m0;
import com.google.android.gms.common.api.t;

/* JADX INFO: loaded from: classes.dex */
public abstract class v<R extends t> implements u<R> {
    @Override // com.google.android.gms.common.api.u
    @c1.a
    public final void a(@m0 R r7) {
        Status statusG = r7.G();
        if (statusG.G0()) {
            c(r7);
            return;
        }
        b(statusG);
        if (r7 instanceof p) {
            try {
                ((p) r7).i();
            } catch (RuntimeException e8) {
                Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(r7)), e8);
            }
        }
    }

    public abstract void b(@m0 Status status);

    public abstract void c(@m0 R r7);
}
