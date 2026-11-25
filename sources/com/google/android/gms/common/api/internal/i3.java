package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Status f15274c = new Status(8, "The connection to Google Play services was lost");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g1.d0
    final Set<BasePendingResult<?>> f15275a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h3 f15276b = new h3(this);

    final void a(BasePendingResult<? extends com.google.android.gms.common.api.t> basePendingResult) {
        this.f15275a.add(basePendingResult);
        basePendingResult.v(this.f15276b);
    }

    public final void b() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f15275a.toArray(new BasePendingResult[0])) {
            basePendingResult.v(null);
            if (basePendingResult.u()) {
                this.f15275a.remove(basePendingResult);
            }
        }
    }
}
