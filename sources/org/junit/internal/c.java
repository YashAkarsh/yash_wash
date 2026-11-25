package org.junit.internal;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static Class<?> a(String str) throws ClassNotFoundException {
        return Class.forName(str, true, Thread.currentThread().getContextClassLoader());
    }
}
