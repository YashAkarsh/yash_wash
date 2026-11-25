package com.google.zxing.aztec.encoder;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final f f23389e = new f(g.f23394b, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f23391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23393d;

    private f(g gVar, int i7, int i8, int i9) {
        this.f23391b = gVar;
        this.f23390a = i7;
        this.f23392c = i8;
        this.f23393d = i9;
    }

    f a(int i7) {
        int i8;
        g gVarA = this.f23391b;
        int i9 = this.f23390a;
        int i10 = this.f23393d;
        if (i9 == 4 || i9 == 2) {
            int i11 = d.f23382h[i9][0];
            int i12 = 65535 & i11;
            int i13 = i11 >> 16;
            gVarA = gVarA.a(i12, i13);
            i10 += i13;
            i9 = 0;
        }
        int i14 = this.f23392c;
        if (i14 == 0 || i14 == 31) {
            i8 = 18;
        } else {
            i8 = i14 == 62 ? 9 : 8;
        }
        f fVar = new f(gVarA, i9, i14 + 1, i10 + i8);
        return fVar.f23392c == 2078 ? fVar.b(i7 + 1) : fVar;
    }

    f b(int i7) {
        int i8 = this.f23392c;
        return i8 == 0 ? this : new f(this.f23391b.b(i7 - i8, i8), this.f23390a, 0, this.f23393d);
    }

    int c() {
        return this.f23392c;
    }

    int d() {
        return this.f23393d;
    }

    int e() {
        return this.f23390a;
    }

    g f() {
        return this.f23391b;
    }

    boolean g(f fVar) {
        int i7;
        int i8 = this.f23393d + (d.f23382h[this.f23390a][fVar.f23390a] >> 16);
        int i9 = fVar.f23392c;
        if (i9 > 0 && ((i7 = this.f23392c) == 0 || i7 > i9)) {
            i8 += 10;
        }
        return i8 <= fVar.f23393d;
    }

    f h(int i7, int i8) {
        int i9 = this.f23393d;
        g gVarA = this.f23391b;
        int i10 = this.f23390a;
        if (i7 != i10) {
            int i11 = d.f23382h[i10][i7];
            int i12 = 65535 & i11;
            int i13 = i11 >> 16;
            gVarA = gVarA.a(i12, i13);
            i9 += i13;
        }
        int i14 = i7 == 2 ? 4 : 5;
        return new f(gVarA.a(i8, i14), i7, 0, i9 + i14);
    }

    f i(int i7, int i8) {
        g gVar = this.f23391b;
        int i9 = this.f23390a;
        int i10 = i9 == 2 ? 4 : 5;
        return new f(gVar.a(d.f23384j[i9][i7], i10).a(i8, 5), this.f23390a, 0, this.f23393d + i10 + 5);
    }

    com.google.zxing.common.a j(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (g gVarD = b(bArr.length).f23391b; gVarD != null; gVarD = gVarD.d()) {
            linkedList.addFirst(gVarD);
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.f23376b[this.f23390a], Integer.valueOf(this.f23393d), Integer.valueOf(this.f23392c));
    }
}
