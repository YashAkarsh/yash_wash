package org.hamcrest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e<T> extends b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39725a;

    public e(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Description should be non null!");
        }
        this.f39725a = str;
    }

    @Override // org.hamcrest.m
    public final void b(g gVar) {
        gVar.d(this.f39725a);
    }
}
