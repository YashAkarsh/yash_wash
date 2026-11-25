package org.hamcrest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p<T> extends b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final org.hamcrest.internal.b f39742b = new org.hamcrest.internal.b("matchesSafely", 1, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f39743a;

    protected p() {
        this(f39742b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.b, org.hamcrest.k
    public final void a(Object obj, g gVar) {
        if (obj == 0) {
            super.a(obj, gVar);
        } else if (this.f39743a.isInstance(obj)) {
            e(obj, gVar);
        } else {
            gVar.d("was a ").d(obj.getClass().getName()).d(" (").e(obj).d(")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.k
    public final boolean c(Object obj) {
        return obj != 0 && this.f39743a.isInstance(obj) && f(obj);
    }

    protected void e(T t7, g gVar) {
        super.a(t7, gVar);
    }

    protected abstract boolean f(T t7);

    protected p(Class<?> cls) {
        this.f39743a = cls;
    }

    protected p(org.hamcrest.internal.b bVar) {
        this.f39743a = bVar.c(getClass());
    }
}
