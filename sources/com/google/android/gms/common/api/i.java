package com.google.android.gms.common.api;

import android.os.Bundle;
import c.m0;
import c.o0;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.data.a;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class i<T, R extends com.google.android.gms.common.data.a<T> & t> extends s<R> implements com.google.android.gms.common.data.b<T> {
    @c1.a
    public i() {
    }

    @Override // com.google.android.gms.common.data.b
    @m0
    public final Iterator<T> R() {
        return ((com.google.android.gms.common.data.a) b()).R();
    }

    @Override // com.google.android.gms.common.data.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((com.google.android.gms.common.data.a) b()).close();
    }

    @Override // com.google.android.gms.common.data.b
    @m0
    public final T get(int i7) {
        return (T) ((com.google.android.gms.common.data.a) b()).get(i7);
    }

    @Override // com.google.android.gms.common.data.b
    public final int getCount() {
        return ((com.google.android.gms.common.data.a) b()).getCount();
    }

    @Override // com.google.android.gms.common.data.b, com.google.android.gms.common.api.p
    public final void i() {
        ((com.google.android.gms.common.data.a) b()).i();
    }

    @Override // com.google.android.gms.common.data.b
    public final boolean isClosed() {
        return ((com.google.android.gms.common.data.a) b()).isClosed();
    }

    @Override // com.google.android.gms.common.data.b, java.lang.Iterable
    @m0
    public final Iterator<T> iterator() {
        return ((com.google.android.gms.common.data.a) b()).iterator();
    }

    @Override // com.google.android.gms.common.data.b
    @o0
    public final Bundle y() {
        return ((com.google.android.gms.common.data.a) b()).y();
    }

    /* JADX WARN: Incorrect types in method signature: (TR;)V */
    /* JADX WARN: Multi-variable type inference failed */
    @c1.a
    public i(@m0 com.google.android.gms.common.data.a aVar) {
        super(aVar);
    }
}
