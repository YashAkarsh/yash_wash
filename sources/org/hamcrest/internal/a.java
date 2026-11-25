package org.hamcrest.internal;

import java.lang.reflect.Array;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class a implements Iterator<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f39728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f39729b = 0;

    public a(Object obj) {
        if (!obj.getClass().isArray()) {
            throw new IllegalArgumentException("not an array");
        }
        this.f39728a = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f39729b < Array.getLength(this.f39728a);
    }

    @Override // java.util.Iterator
    public Object next() {
        Object obj = this.f39728a;
        int i7 = this.f39729b;
        this.f39729b = i7 + 1;
        return Array.get(obj, i7);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("cannot remove items from an array");
    }
}
