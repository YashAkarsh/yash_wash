package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class vd {
    private vd() {
    }

    static <T> T[] a(Object[] objArr, int i7, int i8, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i7, i8, tArr.getClass());
    }

    static <T> T[] b(T[] tArr, int i7) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i7));
    }

    static <K, V> Map<K, V> c(int i7) {
        return wb.k0(i7);
    }

    static <E> Set<E> d(int i7) {
        return af.y(i7);
    }

    static <K, V> Map<K, V> e(int i7) {
        return wb.o0(i7);
    }

    static <E> Set<E> f(int i7) {
        return af.C(i7);
    }

    static <E> Set<E> g() {
        return af.A();
    }

    static <K, V> Map<K, V> h() {
        return wb.m0();
    }

    static int i(int i7) {
        return i7;
    }

    static int j(int i7) {
        return i7;
    }

    static nb k(nb nbVar) {
        return nbVar.l();
    }
}
