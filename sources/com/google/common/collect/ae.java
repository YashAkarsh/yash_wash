package com.google.common.collect;

import java.lang.Comparable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ae<C extends Comparable> {
    public static void a(be beVar, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            beVar.h((xd) it.next());
        }
    }

    public static boolean b(be beVar, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (!beVar.k((xd) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static void c(be beVar, Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            beVar.b((xd) it.next());
        }
    }
}
