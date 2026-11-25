package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
final class f<E> extends k0<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h<E> f16098c;

    f(h<E> hVar, int i7) {
        super(hVar.size(), i7);
        this.f16098c = hVar;
    }

    @Override // com.google.android.gms.internal.common.k0
    protected final E a(int i7) {
        return this.f16098c.get(i7);
    }
}
