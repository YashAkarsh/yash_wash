package com.bumptech.glide.request.target;

/* JADX INFO: loaded from: classes.dex */
public abstract class j<Z> extends b<Z> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14885c;

    public j() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.m
    public final void h(k kVar) {
        if (com.bumptech.glide.util.i.m(this.f14884b, this.f14885c)) {
            kVar.e(this.f14884b, this.f14885c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f14884b + " and height: " + this.f14885c + ", either provide dimensions in the constructor or call override()");
    }

    public j(int i7, int i8) {
        this.f14884b = i7;
        this.f14885c = i8;
    }
}
