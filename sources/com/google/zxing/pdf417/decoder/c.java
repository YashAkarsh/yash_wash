package com.google.zxing.pdf417.decoder;

import com.google.zxing.m;
import com.google.zxing.t;

/* JADX INFO: loaded from: classes2.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.b f23996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t f23997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t f23998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final t f23999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final t f24000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f24001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f24002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f24003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f24004i;

    c(com.google.zxing.common.b bVar, t tVar, t tVar2, t tVar3, t tVar4) throws m {
        boolean z7 = tVar == null || tVar2 == null;
        boolean z8 = tVar3 == null || tVar4 == null;
        if (z7 && z8) {
            throw m.a();
        }
        if (z7) {
            tVar = new t(0.0f, tVar3.d());
            tVar2 = new t(0.0f, tVar4.d());
        } else if (z8) {
            tVar3 = new t(bVar.q() - 1, tVar.d());
            tVar4 = new t(bVar.q() - 1, tVar2.d());
        }
        this.f23996a = bVar;
        this.f23997b = tVar;
        this.f23998c = tVar2;
        this.f23999d = tVar3;
        this.f24000e = tVar4;
        this.f24001f = (int) Math.min(tVar.c(), tVar2.c());
        this.f24002g = (int) Math.max(tVar3.c(), tVar4.c());
        this.f24003h = (int) Math.min(tVar.d(), tVar3.d());
        this.f24004i = (int) Math.max(tVar2.d(), tVar4.d());
    }

    static c j(c cVar, c cVar2) throws m {
        if (cVar == null) {
            return cVar2;
        }
        return cVar2 == null ? cVar : new c(cVar.f23996a, cVar.f23997b, cVar.f23998c, cVar2.f23999d, cVar2.f24000e);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x002f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0056  */
    /* JADX WARN: Code duplicated, block: B:26:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    c a(int i7, int i8, boolean z7) throws m {
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        t tVar5;
        int iD;
        t tVar6;
        t tVar7 = this.f23997b;
        t tVar8 = this.f23998c;
        t tVar9 = this.f23999d;
        t tVar10 = this.f24000e;
        if (i7 > 0) {
            t tVar11 = z7 ? tVar7 : tVar9;
            int iD2 = ((int) tVar11.d()) - i7;
            if (iD2 < 0) {
                iD2 = 0;
            }
            t tVar12 = new t(tVar11.c(), iD2);
            if (z7) {
                tVar = tVar12;
            } else {
                tVar2 = tVar12;
                tVar = tVar7;
            }
            if (i8 > 0) {
                if (z7) {
                    tVar5 = this.f23998c;
                } else {
                    tVar5 = this.f24000e;
                }
                iD = ((int) tVar5.d()) + i8;
                if (iD >= this.f23996a.m()) {
                    iD = this.f23996a.m() - 1;
                }
                tVar6 = new t(tVar5.c(), iD);
                if (z7) {
                    tVar3 = tVar6;
                } else {
                    tVar4 = tVar6;
                    tVar3 = tVar8;
                }
                return new c(this.f23996a, tVar, tVar3, tVar2, tVar4);
            }
            tVar3 = tVar8;
            tVar4 = tVar10;
            return new c(this.f23996a, tVar, tVar3, tVar2, tVar4);
        }
        tVar = tVar7;
        tVar2 = tVar9;
        if (i8 > 0) {
            if (z7) {
                tVar5 = this.f23998c;
            } else {
                tVar5 = this.f24000e;
            }
            iD = ((int) tVar5.d()) + i8;
            if (iD >= this.f23996a.m()) {
                iD = this.f23996a.m() - 1;
            }
            tVar6 = new t(tVar5.c(), iD);
            if (z7) {
                tVar3 = tVar6;
            } else {
                tVar4 = tVar6;
                tVar3 = tVar8;
            }
            return new c(this.f23996a, tVar, tVar3, tVar2, tVar4);
        }
        tVar3 = tVar8;
        tVar4 = tVar10;
        return new c(this.f23996a, tVar, tVar3, tVar2, tVar4);
    }

    t b() {
        return this.f23998c;
    }

    t c() {
        return this.f24000e;
    }

    int d() {
        return this.f24002g;
    }

    int e() {
        return this.f24004i;
    }

    int f() {
        return this.f24001f;
    }

    int g() {
        return this.f24003h;
    }

    t h() {
        return this.f23997b;
    }

    t i() {
        return this.f23999d;
    }

    c(c cVar) {
        this.f23996a = cVar.f23996a;
        this.f23997b = cVar.h();
        this.f23998c = cVar.b();
        this.f23999d = cVar.i();
        this.f24000e = cVar.c();
        this.f24001f = cVar.f();
        this.f24002g = cVar.d();
        this.f24003h = cVar.g();
        this.f24004i = cVar.e();
    }
}
