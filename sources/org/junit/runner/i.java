package org.junit.runner;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    static class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f39972a;

        a(l lVar) {
            this.f39972a = lVar;
        }

        @Override // org.junit.runner.i
        public l h() {
            return this.f39972a;
        }
    }

    public static i a(Class<?> cls) {
        return new d7.a(cls);
    }

    public static i b(Class<?> cls) {
        return new d7.a(cls, false);
    }

    public static i c(org.junit.runner.a aVar, Class<?>... clsArr) {
        try {
            return j(aVar.b(new org.junit.internal.builders.a(true), clsArr));
        } catch (org.junit.runners.model.e unused) {
            throw new RuntimeException("Bug in saff's brain: Suite constructor, called as above, should always complete");
        }
    }

    public static i d(Class<?>... clsArr) {
        return c(h.b(), clsArr);
    }

    public static i e(Class<?> cls, Throwable th) {
        return j(new org.junit.internal.runners.b(cls, th));
    }

    public static i i(Class<?> cls, String str) {
        return a(cls).f(c.f(cls, str));
    }

    public static i j(l lVar) {
        return new a(lVar);
    }

    public i f(c cVar) {
        return g(org.junit.runner.manipulation.a.d(cVar));
    }

    public i g(org.junit.runner.manipulation.a aVar) {
        return new d7.b(this, aVar);
    }

    public abstract l h();

    public i k(Comparator<c> comparator) {
        return new d7.c(this, comparator);
    }
}
