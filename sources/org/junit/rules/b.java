package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class b extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Throwable> f39916a = new ArrayList();

    class a implements Callable<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f39917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f39918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ org.hamcrest.k f39919c;

        a(String str, Object obj, org.hamcrest.k kVar) {
            this.f39917a = str;
            this.f39918b = obj;
            this.f39919c = kVar;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            org.junit.c.X(this.f39917a, this.f39918b, this.f39919c);
            return this.f39918b;
        }
    }

    @Override // org.junit.rules.p
    protected void b() throws Exception {
        org.junit.runners.model.f.a(this.f39916a);
    }

    public void c(Throwable th) {
        this.f39916a.add(th);
    }

    public <T> T d(Callable<T> callable) {
        try {
            return callable.call();
        } catch (Throwable th) {
            c(th);
            return null;
        }
    }

    public <T> void e(T t7, org.hamcrest.k<T> kVar) {
        f("", t7, kVar);
    }

    public <T> void f(String str, T t7, org.hamcrest.k<T> kVar) {
        d(new a(str, t7, kVar));
    }
}
