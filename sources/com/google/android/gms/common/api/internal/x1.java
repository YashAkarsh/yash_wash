package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.haier.uhome.account.api.RetInfoContent;

/* JADX INFO: loaded from: classes.dex */
final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c<?> f15452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Feature f15453b;

    /* synthetic */ x1(c cVar, Feature feature, w1 w1Var) {
        this.f15452a = cVar;
        this.f15453b = feature;
    }

    public final boolean equals(@c.o0 Object obj) {
        if (obj != null && (obj instanceof x1)) {
            x1 x1Var = (x1) obj;
            if (com.google.android.gms.common.internal.s.b(this.f15452a, x1Var.f15452a) && com.google.android.gms.common.internal.s.b(this.f15453b, x1Var.f15453b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.s.c(this.f15452a, this.f15453b);
    }

    public final String toString() {
        return com.google.android.gms.common.internal.s.d(this).a(RetInfoContent.BindKEY_ISNULL, this.f15452a).a("feature", this.f15453b).toString();
    }
}
