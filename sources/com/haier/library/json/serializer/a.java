package com.haier.library.json.serializer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<m> f26783a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<Character> f26784b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Character f26785c = ',';

    final char d(m mVar, Object obj, char c8) {
        ThreadLocal<m> threadLocal = f26783a;
        threadLocal.set(mVar);
        ThreadLocal<Character> threadLocal2 = f26784b;
        threadLocal2.set(Character.valueOf(c8));
        e(obj);
        threadLocal.set(null);
        return threadLocal2.get().charValue();
    }

    public abstract void e(Object obj);

    protected final void f(String str, Object obj) {
        m mVar = f26783a.get();
        ThreadLocal<Character> threadLocal = f26784b;
        char cCharValue = threadLocal.get().charValue();
        mVar.A(cCharValue, str, obj);
        if (cCharValue != ',') {
            threadLocal.set(f26785c);
        }
    }
}
