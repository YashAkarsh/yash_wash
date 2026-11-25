package com.google.android.gms.common.data;

import c.m0;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.net.impl.CronetUrlRequest;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    @m0
    public static <T, E extends j<T>> ArrayList<T> a(@m0 ArrayList<E> arrayList) {
        CronetUrlRequest.j jVar = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            jVar.add(arrayList.get(i7).b());
        }
        return jVar;
    }

    @m0
    public static <T, E extends j<T>> ArrayList<T> b(@m0 E[] eArr) {
        CronetUrlRequest.j jVar = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e8 : eArr) {
            jVar.add(e8.b());
        }
        return jVar;
    }

    @m0
    public static <T, E extends j<T>> ArrayList<T> c(@m0 Iterable<E> iterable) {
        CronetUrlRequest.j jVar = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            jVar.add(it.next().b());
        }
        return jVar;
    }
}
