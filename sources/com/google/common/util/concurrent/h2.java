package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h2 {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i7, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i7, obj, obj2)) {
            if (atomicReferenceArray.get(i7) != obj) {
                return false;
            }
        }
        return true;
    }
}
