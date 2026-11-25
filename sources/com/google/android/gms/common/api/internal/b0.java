package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class b0 {
    @c1.a
    public static void a(@c.m0 Status status, @c.m0 com.google.android.gms.tasks.n<Void> nVar) {
        b(status, null, nVar);
    }

    @c1.a
    public static <TResult> void b(@c.m0 Status status, @c.o0 TResult tresult, @c.m0 com.google.android.gms.tasks.n<TResult> nVar) {
        if (status.G0()) {
            nVar.c(tresult);
        } else {
            nVar.b(new com.google.android.gms.common.api.b(status));
        }
    }

    @c1.a
    @c.m0
    @Deprecated
    public static com.google.android.gms.tasks.m<Void> c(@c.m0 com.google.android.gms.tasks.m<Boolean> mVar) {
        return mVar.m(new c3());
    }

    @c1.a
    public static <ResultT> boolean d(@c.m0 Status status, @c.o0 ResultT resultt, @c.m0 com.google.android.gms.tasks.n<ResultT> nVar) {
        return status.G0() ? nVar.e(resultt) : nVar.d(new com.google.android.gms.common.api.b(status));
    }
}
