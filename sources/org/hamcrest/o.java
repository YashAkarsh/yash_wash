package org.hamcrest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o<T> extends b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final org.hamcrest.internal.b f39740b = new org.hamcrest.internal.b("matchesSafely", 2, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f39741a;

    protected o(Class<?> cls) {
        this.f39741a = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.b, org.hamcrest.k
    public final void a(Object obj, g gVar) {
        if (obj == 0 || !this.f39741a.isInstance(obj)) {
            super.a(obj, gVar);
        } else {
            e(obj, gVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.k
    public final boolean c(Object obj) {
        return obj != 0 && this.f39741a.isInstance(obj) && e(obj, new g.a());
    }

    protected abstract boolean e(T t7, g gVar);

    protected o(org.hamcrest.internal.b bVar) {
        this.f39741a = bVar.c(getClass());
    }

    protected o() {
        this(f39740b);
    }
}
