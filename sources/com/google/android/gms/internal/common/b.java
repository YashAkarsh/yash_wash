package com.google.android.gms.internal.common;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class b<E> extends c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object[] f16093a = new Object[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f16094b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f16095c;

    b(int i7) {
    }

    private final void b(int i7) {
        Object[] objArr = this.f16093a;
        int length = objArr.length;
        if (length >= i7) {
            if (this.f16095c) {
                this.f16093a = (Object[]) objArr.clone();
                this.f16095c = false;
                return;
            }
            return;
        }
        int i8 = length + (length >> 1) + 1;
        if (i8 < i7) {
            int iHighestOneBit = Integer.highestOneBit(i7 - 1);
            i8 = iHighestOneBit + iHighestOneBit;
        }
        if (i8 < 0) {
            i8 = Integer.MAX_VALUE;
        }
        this.f16093a = Arrays.copyOf(objArr, i8);
        this.f16095c = false;
    }

    public final b<E> a(E e8) {
        e8.getClass();
        b(this.f16094b + 1);
        Object[] objArr = this.f16093a;
        int i7 = this.f16094b;
        this.f16094b = i7 + 1;
        objArr[i7] = e8;
        return this;
    }
}
