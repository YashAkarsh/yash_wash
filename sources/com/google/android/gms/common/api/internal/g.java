package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class g<L> implements n.b<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataHolder f15213a;

    @c1.a
    protected g(@c.m0 DataHolder dataHolder) {
        this.f15213a = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.n.b
    @c1.a
    public final void a(@c.m0 L l7) {
        c(l7, this.f15213a);
    }

    @Override // com.google.android.gms.common.api.internal.n.b
    @c1.a
    public void b() {
        DataHolder dataHolder = this.f15213a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @c1.a
    protected abstract void c(@c.m0 L l7, @c.m0 DataHolder dataHolder);
}
