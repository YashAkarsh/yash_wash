package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public interface f2 {
    ConnectionResult e();

    boolean f();

    ConnectionResult g(long j7, TimeUnit timeUnit);

    void h();

    <A extends com.google.android.gms.common.api.a.b, R extends com.google.android.gms.common.api.t, T extends e.a<R, A>> T i(@c.m0 T t7);

    boolean j();

    <A extends com.google.android.gms.common.api.a.b, T extends e.a<? extends com.google.android.gms.common.api.t, A>> T k(@c.m0 T t7);

    void l();

    void m();

    void n();

    boolean o(w wVar);

    void p(String str, @c.o0 FileDescriptor fileDescriptor, PrintWriter printWriter, @c.o0 String[] strArr);

    @c.o0
    ConnectionResult q(@c.m0 com.google.android.gms.common.api.a<?> aVar);
}
