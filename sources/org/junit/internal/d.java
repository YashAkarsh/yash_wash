package org.junit.internal;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    private int b(Object obj, Object obj2, String str) {
        if (obj == null) {
            org.junit.c.d0(str + "expected array was null");
        }
        if (obj2 == null) {
            org.junit.c.d0(str + "actual array was null");
        }
        int length = Array.getLength(obj2);
        int length2 = Array.getLength(obj);
        if (length != length2) {
            org.junit.c.d0(str + "array lengths differed, expected.length=" + length2 + " actual.length=" + length);
        }
        return length2;
    }

    private boolean d(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    public void a(String str, Object obj, Object obj2) throws a {
        if (obj != obj2) {
            if (Arrays.deepEquals(new Object[]{obj}, new Object[]{obj2})) {
                return;
            }
            String str2 = str == null ? "" : str + ": ";
            int iB = b(obj, obj2, str2);
            for (int i7 = 0; i7 < iB; i7++) {
                Object obj3 = Array.get(obj, i7);
                Object obj4 = Array.get(obj2, i7);
                if (d(obj3) && d(obj4)) {
                    try {
                        a(str, obj3, obj4);
                    } catch (a e8) {
                        e8.a(i7);
                        throw e8;
                    }
                } else {
                    try {
                        c(obj3, obj4);
                    } catch (AssertionError e9) {
                        throw new a(str2, e9, i7);
                    }
                }
            }
        }
    }

    protected abstract void c(Object obj, Object obj2);
}
