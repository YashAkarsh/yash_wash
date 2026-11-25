package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class rf {
    private rf() {
    }

    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? td.A() : comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        com.google.common.base.e0.E(comparator);
        com.google.common.base.e0.E(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else {
            if (!(iterable instanceof qf)) {
                return false;
            }
            comparator2 = ((qf) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
