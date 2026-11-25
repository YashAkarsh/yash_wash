package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<BasePendingResult<?>, Boolean> f15237a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.google.android.gms.tasks.n<?>, Boolean> f15238b = Collections.synchronizedMap(new WeakHashMap());

    private final void h(boolean z7, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f15237a) {
            map = new HashMap(this.f15237a);
        }
        synchronized (this.f15238b) {
            map2 = new HashMap(this.f15238b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z7 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).l(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z7 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((com.google.android.gms.tasks.n) entry2.getKey()).d(new com.google.android.gms.common.api.b(status));
            }
        }
    }

    final void c(BasePendingResult<? extends com.google.android.gms.common.api.t> basePendingResult, boolean z7) {
        this.f15237a.put(basePendingResult, Boolean.valueOf(z7));
        basePendingResult.c(new f0(this, basePendingResult));
    }

    final <TResult> void d(com.google.android.gms.tasks.n<TResult> nVar, boolean z7) {
        this.f15238b.put(nVar, Boolean.valueOf(z7));
        nVar.a().e(new g0(this, nVar));
    }

    final void e(int i7, @c.o0 String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i7 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i7 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        h(true, new Status(20, sb.toString()));
    }

    public final void f() {
        h(false, i.f15245r);
    }

    final boolean g() {
        return (this.f15237a.isEmpty() && this.f15238b.isEmpty()) ? false : true;
    }
}
