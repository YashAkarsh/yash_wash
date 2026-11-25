package org.hamcrest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j<T, U> extends o<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final org.hamcrest.internal.b f39735f = new org.hamcrest.internal.b("featureValueOf", 1, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k<? super U> f39736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f39737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f39738e;

    public j(k<? super U> kVar, String str, String str2) {
        super(f39735f);
        this.f39736c = kVar;
        this.f39737d = str;
        this.f39738e = str2;
    }

    @Override // org.hamcrest.m
    public final void b(g gVar) {
        gVar.d(this.f39737d).d(" ").b(this.f39736c);
    }

    @Override // org.hamcrest.o
    protected boolean e(T t7, g gVar) {
        U uF = f(t7);
        if (this.f39736c.c(uF)) {
            return true;
        }
        gVar.d(this.f39738e).d(" ");
        this.f39736c.a(uF, gVar);
        return false;
    }

    protected abstract U f(T t7);
}
