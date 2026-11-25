package com.google.android.gms.common.api.internal;

import android.os.Looper;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<n<?>> f15359a = Collections.newSetFromMap(new WeakHashMap());

    @c1.a
    @c.m0
    public static <L> n<L> a(@c.m0 L l7, @c.m0 Looper looper, @c.m0 String str) {
        com.google.android.gms.common.internal.u.l(l7, "Listener must not be null");
        com.google.android.gms.common.internal.u.l(looper, "Looper must not be null");
        com.google.android.gms.common.internal.u.l(str, "Listener type must not be null");
        return new n<>(looper, l7, str);
    }

    @c1.a
    @c.m0
    public static <L> n<L> b(@c.m0 L l7, @c.m0 Executor executor, @c.m0 String str) {
        com.google.android.gms.common.internal.u.l(l7, "Listener must not be null");
        com.google.android.gms.common.internal.u.l(executor, "Executor must not be null");
        com.google.android.gms.common.internal.u.l(str, "Listener type must not be null");
        return new n<>(executor, l7, str);
    }

    @c1.a
    @c.m0
    public static <L> n.a<L> c(@c.m0 L l7, @c.m0 String str) {
        com.google.android.gms.common.internal.u.l(l7, "Listener must not be null");
        com.google.android.gms.common.internal.u.l(str, "Listener type must not be null");
        com.google.android.gms.common.internal.u.h(str, "Listener type must not be empty");
        return new n.a<>(l7, str);
    }

    @c.m0
    public final <L> n<L> d(@c.m0 L l7, @c.m0 Looper looper, @c.m0 String str) {
        n<L> nVarA = a(l7, looper, "NO_TYPE");
        this.f15359a.add(nVarA);
        return nVarA;
    }

    public final void e() {
        Iterator<n<?>> it = this.f15359a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f15359a.clear();
    }
}
