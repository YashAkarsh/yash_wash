package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public abstract class i implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<n0> f13070a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<Character> f13071b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Character f13072c = ',';

    final char f(n0 n0Var, Object obj, char c8) {
        ThreadLocal<n0> threadLocal = f13070a;
        threadLocal.set(n0Var);
        ThreadLocal<Character> threadLocal2 = f13071b;
        threadLocal2.set(Character.valueOf(c8));
        g(obj);
        threadLocal.set(null);
        return threadLocal2.get().charValue();
    }

    public abstract void g(Object obj);

    protected final void h(String str, Object obj) {
        n0 n0Var = f13070a.get();
        ThreadLocal<Character> threadLocal = f13071b;
        char cCharValue = threadLocal.get().charValue();
        n0Var.U(cCharValue, str, obj);
        if (cCharValue != ',') {
            threadLocal.set(f13072c);
        }
    }
}
