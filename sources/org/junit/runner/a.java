package org.junit.runner;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: org.junit.runner.a$a, reason: collision with other inner class name */
    class C0539a extends org.junit.runners.model.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ org.junit.runners.model.h f39954b;

        C0539a(org.junit.runners.model.h hVar) throws Throwable {
            this.f39954b = hVar;
        }

        @Override // org.junit.runners.model.h
        public l c(Class<?> cls) throws Throwable {
            return a.this.a(this.f39954b, cls);
        }
    }

    public static a c() {
        return new a();
    }

    protected l a(org.junit.runners.model.h hVar, Class<?> cls) throws Throwable {
        return hVar.c(cls);
    }

    public l b(org.junit.runners.model.h hVar, Class<?>[] clsArr) throws org.junit.runners.model.e {
        return new org.junit.runners.g(new C0539a(hVar), clsArr);
    }
}
