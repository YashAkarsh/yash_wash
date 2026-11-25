package com.haier.library.a;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class y {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f26329h = 8192;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int f26330i = 1024;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f26331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f26332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f26333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f26334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f26335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    y f26336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    y f26337g;

    y() {
        this.f26331a = new byte[8192];
        this.f26335e = true;
        this.f26334d = false;
    }

    final y a() {
        this.f26334d = true;
        return new y(this.f26331a, this.f26332b, this.f26333c, true, false);
    }

    public final y b(int i7) {
        y yVarA;
        if (i7 <= 0 || i7 > this.f26333c - this.f26332b) {
            throw new IllegalArgumentException();
        }
        if (i7 >= 1024) {
            yVarA = a();
        } else {
            yVarA = z.a();
            System.arraycopy(this.f26331a, this.f26332b, yVarA.f26331a, 0, i7);
        }
        yVarA.f26333c = yVarA.f26332b + i7;
        this.f26332b += i7;
        this.f26337g.c(yVarA);
        return yVarA;
    }

    public final y c(y yVar) {
        yVar.f26337g = this;
        yVar.f26336f = this.f26336f;
        this.f26336f.f26337g = yVar;
        this.f26336f = yVar;
        return yVar;
    }

    public final void d(y yVar, int i7) {
        if (!yVar.f26335e) {
            throw new IllegalArgumentException();
        }
        int i8 = yVar.f26333c;
        if (i8 + i7 > 8192) {
            if (yVar.f26334d) {
                throw new IllegalArgumentException();
            }
            int i9 = yVar.f26332b;
            if ((i8 + i7) - i9 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = yVar.f26331a;
            System.arraycopy(bArr, i9, bArr, 0, i8 - i9);
            yVar.f26333c -= yVar.f26332b;
            yVar.f26332b = 0;
        }
        System.arraycopy(this.f26331a, this.f26332b, yVar.f26331a, yVar.f26333c, i7);
        yVar.f26333c += i7;
        this.f26332b += i7;
    }

    final y e() {
        return new y((byte[]) this.f26331a.clone(), this.f26332b, this.f26333c, false, true);
    }

    @Nullable
    public final y f() {
        y yVar = this.f26336f;
        y yVar2 = yVar != this ? yVar : null;
        y yVar3 = this.f26337g;
        yVar3.f26336f = yVar;
        this.f26336f.f26337g = yVar3;
        this.f26336f = null;
        this.f26337g = null;
        return yVar2;
    }

    public final void g() {
        y yVar = this.f26337g;
        if (yVar == this) {
            throw new IllegalStateException();
        }
        if (yVar.f26335e) {
            int i7 = this.f26333c - this.f26332b;
            if (i7 > (8192 - yVar.f26333c) + (yVar.f26334d ? 0 : yVar.f26332b)) {
                return;
            }
            d(yVar, i7);
            f();
            z.b(this);
        }
    }

    y(byte[] bArr, int i7, int i8, boolean z7, boolean z8) {
        this.f26331a = bArr;
        this.f26332b = i7;
        this.f26333c = i8;
        this.f26334d = z7;
        this.f26335e = z8;
    }
}
