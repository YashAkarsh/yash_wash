package com.haier.library.json.serializer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<m> f26816a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<Character> f26817b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Character f26818c = ',';

    final char d(m mVar, Object obj, char c8) {
        ThreadLocal<m> threadLocal = f26816a;
        threadLocal.set(mVar);
        ThreadLocal<Character> threadLocal2 = f26817b;
        threadLocal2.set(Character.valueOf(c8));
        e(obj);
        threadLocal.set(null);
        return threadLocal2.get().charValue();
    }

    public abstract void e(Object obj);

    protected final void f(String str, Object obj) {
        m mVar = f26816a.get();
        ThreadLocal<Character> threadLocal = f26817b;
        char cCharValue = threadLocal.get().charValue();
        mVar.A(cCharValue, str, obj);
        if (cCharValue != ',') {
            threadLocal.set(f26818c);
        }
    }
}
