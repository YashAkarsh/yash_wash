package com.google.common.collect;

import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class cf implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set f20097a;

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f20097a.contains(obj);
    }
}
