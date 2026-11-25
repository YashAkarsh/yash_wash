package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class e4<T> extends td<T> implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f20193d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Comparator<? super T>[] f20194c;

    e4(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        this.f20194c = new Comparator[]{comparator, comparator2};
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    public int compare(T t7, T t8) {
        int i7 = 0;
        while (true) {
            Comparator<? super T>[] comparatorArr = this.f20194c;
            if (i7 >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i7].compare(t7, t8);
            if (iCompare != 0) {
                return iCompare;
            }
            i7++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e4) {
            return Arrays.equals(this.f20194c, ((e4) obj).f20194c);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f20194c);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.f20194c) + ")";
    }

    e4(Iterable<? extends Comparator<? super T>> iterable) {
        this.f20194c = (Comparator[]) ma.P(iterable, new Comparator[0]);
    }
}
