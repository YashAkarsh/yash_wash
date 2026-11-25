package com.google.android.gms.common.data;

import android.os.Bundle;
import c.m0;
import c.o0;
import java.io.Closeable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public interface b<T> extends Iterable<T>, com.google.android.gms.common.api.p, Closeable {
    @m0
    Iterator<T> R();

    void close();

    T get(int i7);

    int getCount();

    void i();

    @Deprecated
    boolean isClosed();

    @Override // java.lang.Iterable
    @m0
    Iterator<T> iterator();

    @o0
    @c1.a
    Bundle y();
}
