package org.hamcrest.core;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends org.hamcrest.p<String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final String f39724c;

    protected r(String str) {
        this.f39724c = str;
    }

    @Override // org.hamcrest.m
    public void b(org.hamcrest.g gVar) {
        gVar.d("a string ").d(j()).d(" ").e(this.f39724c);
    }

    @Override // org.hamcrest.p
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(String str, org.hamcrest.g gVar) {
        gVar.d("was \"").d(str).d("\"");
    }

    protected abstract boolean h(String str);

    @Override // org.hamcrest.p
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean f(String str) {
        return h(str);
    }

    protected abstract String j();
}
