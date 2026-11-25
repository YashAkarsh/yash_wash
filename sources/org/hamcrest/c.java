package org.hamcrest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0526c<Object> f39703a = new C0526c<>();

    private static final class b<T> extends c<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f39704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final g f39705c;

        @Override // org.hamcrest.c
        public <U> c<U> a(d<? super T, U> dVar) {
            return dVar.a(this.f39704b, this.f39705c);
        }

        @Override // org.hamcrest.c
        public boolean d(k<T> kVar, String str) {
            if (kVar.c(this.f39704b)) {
                return true;
            }
            this.f39705c.d(str);
            kVar.a(this.f39704b, this.f39705c);
            return false;
        }

        private b(T t7, g gVar) {
            super();
            this.f39704b = t7;
            this.f39705c = gVar;
        }
    }

    /* JADX INFO: renamed from: org.hamcrest.c$c, reason: collision with other inner class name */
    private static final class C0526c<T> extends c<T> {
        private C0526c() {
            super();
        }

        @Override // org.hamcrest.c
        public <U> c<U> a(d<? super T, U> dVar) {
            return c.e();
        }

        @Override // org.hamcrest.c
        public boolean d(k<T> kVar, String str) {
            return false;
        }
    }

    public interface d<I, O> {
        c<O> a(I i7, g gVar);
    }

    public static <T> c<T> b(T t7, g gVar) {
        return new b(t7, gVar);
    }

    public static <T> c<T> e() {
        return f39703a;
    }

    public abstract <U> c<U> a(d<? super T, U> dVar);

    public final boolean c(k<T> kVar) {
        return d(kVar, "");
    }

    public abstract boolean d(k<T> kVar, String str);

    public final <U> c<U> f(d<? super T, U> dVar) {
        return a(dVar);
    }

    private c() {
    }
}
