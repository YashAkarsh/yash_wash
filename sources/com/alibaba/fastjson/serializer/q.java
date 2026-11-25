package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public abstract class q implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<n0> f13163a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<Character> f13164b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Character f13165c = ',';

    final char f(n0 n0Var, Object obj, char c8) {
        ThreadLocal<n0> threadLocal = f13163a;
        threadLocal.set(n0Var);
        ThreadLocal<Character> threadLocal2 = f13164b;
        threadLocal2.set(Character.valueOf(c8));
        g(obj);
        threadLocal.set(null);
        return threadLocal2.get().charValue();
    }

    public abstract void g(Object obj);

    protected final void h(String str, Object obj) {
        n0 n0Var = f13163a.get();
        ThreadLocal<Character> threadLocal = f13164b;
        char cCharValue = threadLocal.get().charValue();
        n0Var.U(cCharValue, str, obj);
        if (cCharValue != ',') {
            threadLocal.set(f13165c);
        }
    }
}
