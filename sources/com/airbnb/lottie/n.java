package com.airbnb.lottie;

import c.o0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class n<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private final V f12162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final Throwable f12163b;

    public n(V v7) {
        this.f12162a = v7;
        this.f12163b = null;
    }

    @o0
    public Throwable a() {
        return this.f12163b;
    }

    @o0
    public V b() {
        return this.f12162a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (b() != null && b().equals(nVar.b())) {
            return true;
        }
        if (a() == null || nVar.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public n(Throwable th) {
        this.f12163b = th;
        this.f12162a = null;
    }
}
