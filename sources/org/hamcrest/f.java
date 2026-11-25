package org.hamcrest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f<T> extends p<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f39726c;

    public f(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Description must be non null!");
        }
        this.f39726c = str;
    }

    @Override // org.hamcrest.m
    public final void b(g gVar) {
        gVar.d(this.f39726c);
    }
}
