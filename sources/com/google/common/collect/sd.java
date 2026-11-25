package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class sd {
    private sd() {
    }

    @u1.a
    static Object a(Object obj, int i7) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i7);
    }

    @u1.a
    static Object[] b(Object... objArr) {
        return c(objArr, objArr.length);
    }

    @u1.a
    static Object[] c(Object[] objArr, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            a(objArr[i8], i8);
        }
        return objArr;
    }

    public static <T> T[] d(T t7, T[] tArr) {
        T[] tArr2 = (T[]) j(tArr, tArr.length + 1);
        tArr2[0] = t7;
        System.arraycopy(tArr, 0, tArr2, 1, tArr.length);
        return tArr2;
    }

    public static <T> T[] e(T[] tArr, T t7) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length + 1);
        tArr2[tArr.length] = t7;
        return tArr2;
    }

    @s1.c
    public static <T> T[] f(T[] tArr, T[] tArr2, Class<T> cls) {
        T[] tArr3 = (T[]) i(cls, tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    static Object[] g(Object[] objArr, int i7, int i8) {
        com.google.common.base.e0.f0(i7, i7 + i8, objArr.length);
        if (i8 == 0) {
            return new Object[0];
        }
        Object[] objArr2 = new Object[i8];
        System.arraycopy(objArr, i7, objArr2, 0, i8);
        return objArr2;
    }

    @u1.a
    private static Object[] h(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            objArr[i7] = it.next();
            i7++;
        }
        return objArr;
    }

    @s1.c
    public static <T> T[] i(Class<T> cls, int i7) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i7));
    }

    public static <T> T[] j(T[] tArr, int i7) {
        return (T[]) vd.b(tArr, i7);
    }

    static void k(Object[] objArr, int i7, int i8) {
        Object obj = objArr[i7];
        objArr[i7] = objArr[i8];
        objArr[i8] = obj;
    }

    static Object[] l(Collection<?> collection) {
        return h(collection, new Object[collection.size()]);
    }

    static <T> T[] m(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) j(tArr, size);
        }
        h(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    static <T> T[] n(Object[] objArr, int i7, int i8, T[] tArr) {
        com.google.common.base.e0.f0(i7, i7 + i8, objArr.length);
        if (tArr.length < i8) {
            tArr = (T[]) j(tArr, i8);
        } else if (tArr.length > i8) {
            tArr[i8] = null;
        }
        System.arraycopy(objArr, i7, tArr, 0, i8);
        return tArr;
    }
}
