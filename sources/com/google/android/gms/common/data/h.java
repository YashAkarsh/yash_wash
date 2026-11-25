package com.google.android.gms.common.data;

import android.os.Bundle;
import c.m0;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.net.impl.CronetUrlRequest;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c1.a
    @m0
    public static final String f15560a = "next_page_token";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c1.a
    @m0
    public static final String f15561b = "prev_page_token";

    private h() {
    }

    @m0
    public static <T, E extends j<T>> ArrayList<T> a(@m0 b<E> bVar) {
        CronetUrlRequest.j jVar = (ArrayList<T>) new ArrayList(bVar.getCount());
        try {
            Iterator<E> it = bVar.iterator();
            while (it.hasNext()) {
                jVar.add(it.next().b());
            }
            bVar.close();
            return jVar;
        } catch (Throwable th) {
            bVar.close();
            throw th;
        }
    }

    public static boolean b(@m0 b<?> bVar) {
        return bVar != null && bVar.getCount() > 0;
    }

    public static boolean c(@m0 b<?> bVar) {
        Bundle bundleY = bVar.y();
        return (bundleY == null || bundleY.getString(f15560a) == null) ? false : true;
    }

    public static boolean d(@m0 b<?> bVar) {
        Bundle bundleY = bVar.y();
        return (bundleY == null || bundleY.getString(f15561b) == null) ? false : true;
    }
}
