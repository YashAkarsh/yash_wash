package org.junit;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static void a(String str, boolean z7) {
        h(str, !z7);
    }

    public static void b(boolean z7) {
        i(!z7);
    }

    public static void c(String str, Throwable th) {
        g(str, th, org.hamcrest.d.L());
    }

    public static void d(Throwable th) {
        f(th, org.hamcrest.d.L());
    }

    public static void e(Object... objArr) {
        f(Arrays.asList(objArr), org.hamcrest.d.x(org.hamcrest.d.J()));
    }

    public static <T> void f(T t7, org.hamcrest.k<T> kVar) {
        if (!kVar.c(t7)) {
            throw new e(t7, kVar);
        }
    }

    public static <T> void g(String str, T t7, org.hamcrest.k<T> kVar) {
        if (!kVar.c(t7)) {
            throw new e(str, t7, kVar);
        }
    }

    public static void h(String str, boolean z7) {
        if (!z7) {
            throw new e(str);
        }
    }

    public static void i(boolean z7) {
        f(Boolean.valueOf(z7), org.hamcrest.d.E(Boolean.TRUE));
    }
}
