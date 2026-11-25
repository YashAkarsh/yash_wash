package com.google.android.gms.common.data;

import c.m0;
import com.google.android.gms.common.internal.u;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class l<T> extends c<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f15564c;

    public l(@m0 b<T> bVar) {
        super(bVar);
    }

    @Override // com.google.android.gms.common.data.c, java.util.Iterator
    @m0
    public final T next() {
        if (!hasNext()) {
            int i7 = this.f15553b;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Cannot advance the iterator beyond ");
            sb.append(i7);
            throw new NoSuchElementException(sb.toString());
        }
        int i8 = this.f15553b + 1;
        this.f15553b = i8;
        if (i8 == 0) {
            T t7 = (T) u.k(this.f15552a.get(0));
            this.f15564c = t7;
            if (!(t7 instanceof f)) {
                String strValueOf = String.valueOf(t7.getClass());
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 44);
                sb2.append("DataBuffer reference of type ");
                sb2.append(strValueOf);
                sb2.append(" is not movable");
                throw new IllegalStateException(sb2.toString());
            }
        } else {
            ((f) u.k(this.f15564c)).n(this.f15553b);
        }
        return this.f15564c;
    }
}
