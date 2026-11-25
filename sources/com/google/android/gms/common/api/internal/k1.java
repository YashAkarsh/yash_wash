package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public interface k1 {
    void a(@c.o0 Bundle bundle);

    void b();

    void c(ConnectionResult connectionResult, com.google.android.gms.common.api.a<?> aVar, boolean z7);

    void d(int i7);

    void e();

    <A extends com.google.android.gms.common.api.a.b, R extends com.google.android.gms.common.api.t, T extends e.a<R, A>> T f(T t7);

    boolean g();

    <A extends com.google.android.gms.common.api.a.b, T extends e.a<? extends com.google.android.gms.common.api.t, A>> T h(T t7);
}
