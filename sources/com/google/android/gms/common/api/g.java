package com.google.android.gms.common.api;

import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class g implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Status f15098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15099b;

    @c1.a
    @com.google.android.gms.common.internal.y
    public g(@m0 Status status, boolean z7) {
        this.f15098a = (Status) com.google.android.gms.common.internal.u.l(status, "Status must not be null");
        this.f15099b = z7;
    }

    @Override // com.google.android.gms.common.api.t
    @c1.a
    @m0
    public Status G() {
        return this.f15098a;
    }

    @c1.a
    public boolean a() {
        return this.f15099b;
    }

    @c1.a
    public final boolean equals(@o0 Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f15098a.equals(gVar.f15098a) && this.f15099b == gVar.f15099b;
    }

    @c1.a
    public final int hashCode() {
        return ((this.f15098a.hashCode() + 527) * 31) + (this.f15099b ? 1 : 0);
    }
}
