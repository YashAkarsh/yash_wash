package com.google.android.gms.common.data;

import android.os.Bundle;
import c.m0;
import c.o0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    @c1.a
    protected final DataHolder f15551a;

    @c1.a
    protected a(@o0 DataHolder dataHolder) {
        this.f15551a = dataHolder;
    }

    @Override // com.google.android.gms.common.data.b
    @m0
    public Iterator<T> R() {
        return new l(this);
    }

    @Override // com.google.android.gms.common.data.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        i();
    }

    @Override // com.google.android.gms.common.data.b
    public abstract T get(int i7);

    @Override // com.google.android.gms.common.data.b
    public int getCount() {
        DataHolder dataHolder = this.f15551a;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    @Override // com.google.android.gms.common.data.b, com.google.android.gms.common.api.p
    public void i() {
        DataHolder dataHolder = this.f15551a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.common.data.b
    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.f15551a;
        return dataHolder == null || dataHolder.isClosed();
    }

    @Override // com.google.android.gms.common.data.b, java.lang.Iterable
    @m0
    public Iterator<T> iterator() {
        return new c(this);
    }

    @Override // com.google.android.gms.common.data.b
    @o0
    public final Bundle y() {
        DataHolder dataHolder = this.f15551a;
        if (dataHolder == null) {
            return null;
        }
        return dataHolder.y();
    }
}
