package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class h implements com.google.android.gms.common.api.t, com.google.android.gms.common.api.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c1.a
    @c.m0
    protected final Status f15235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c1.a
    @c.m0
    protected final DataHolder f15236b;

    @c1.a
    protected h(@c.m0 DataHolder dataHolder, @c.m0 Status status) {
        this.f15235a = status;
        this.f15236b = dataHolder;
    }

    @Override // com.google.android.gms.common.api.t
    @c1.a
    @c.m0
    public Status G() {
        return this.f15235a;
    }

    @Override // com.google.android.gms.common.api.p
    @c1.a
    public void i() {
        DataHolder dataHolder = this.f15236b;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @c1.a
    protected h(@c.m0 DataHolder dataHolder) {
        this(dataHolder, new Status(dataHolder.v0()));
    }
}
