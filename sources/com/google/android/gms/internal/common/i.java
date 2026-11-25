package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    static Object[] a(Object[] objArr, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            if (objArr[i8] == null) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i8);
                throw new NullPointerException(sb.toString());
            }
        }
        return objArr;
    }
}
