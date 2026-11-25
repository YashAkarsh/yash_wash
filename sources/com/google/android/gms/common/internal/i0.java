package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Scope> f15746a;

    public i0(Set<Scope> set) {
        u.k(set);
        this.f15746a = Collections.unmodifiableSet(set);
    }
}
