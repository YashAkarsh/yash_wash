package com.google.zxing.oned.rss.expanded.decoders;

import kotlin.text.h0;
import kotlinx.coroutines.internal.b0;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.zxing.common.a f23967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f23968b = new m();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StringBuilder f23969c = new StringBuilder();

    s(com.google.zxing.common.a aVar) {
        this.f23967a = aVar;
    }

    private n b(int i7) {
        char c8;
        int iF = f(i7, 5);
        if (iF == 15) {
            return new n(i7 + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new n(i7 + 5, (char) ((iF + 48) - 5));
        }
        int iF2 = f(i7, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new n(i7 + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case com.alibaba.fastjson.asm.j.f12628v /* 58 */:
                c8 = '*';
                break;
            case 59:
                c8 = ',';
                break;
            case 60:
                c8 = '-';
                break;
            case b0.f36952q /* 61 */:
                c8 = ClassUtils.PACKAGE_SEPARATOR_CHAR;
                break;
            case 62:
                c8 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iF2)));
        }
        return new n(i7 + 6, c8);
    }

    private n d(int i7) throws com.google.zxing.h {
        char c8;
        int iF = f(i7, 5);
        if (iF == 15) {
            return new n(i7 + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new n(i7 + 5, (char) ((iF + 48) - 5));
        }
        int iF2 = f(i7, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new n(i7 + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new n(i7 + 7, (char) (iF2 + 7));
        }
        switch (f(i7, 8)) {
            case 232:
                c8 = '!';
                break;
            case 233:
                c8 = h0.f35376b;
                break;
            case 234:
                c8 = '%';
                break;
            case 235:
                c8 = h0.f35378d;
                break;
            case 236:
                c8 = '\'';
                break;
            case 237:
                c8 = '(';
                break;
            case 238:
                c8 = ')';
                break;
            case 239:
                c8 = '*';
                break;
            case 240:
                c8 = '+';
                break;
            case 241:
                c8 = ',';
                break;
            case 242:
                c8 = '-';
                break;
            case 243:
                c8 = ClassUtils.PACKAGE_SEPARATOR_CHAR;
                break;
            case 244:
                c8 = '/';
                break;
            case 245:
                c8 = ':';
                break;
            case 246:
                c8 = ';';
                break;
            case 247:
                c8 = h0.f35379e;
                break;
            case 248:
                c8 = '=';
                break;
            case 249:
                c8 = h0.f35380f;
                break;
            case androidx.recyclerview.widget.m.f.f9644c /* 250 */:
                c8 = '?';
                break;
            case 251:
                c8 = '_';
                break;
            case 252:
                c8 = ' ';
                break;
            default:
                throw com.google.zxing.h.a();
        }
        return new n(i7 + 8, c8);
    }

    private p e(int i7) throws com.google.zxing.h {
        int i8 = i7 + 7;
        if (i8 > this.f23967a.o()) {
            int iF = f(i7, 4);
            return iF == 0 ? new p(this.f23967a.o(), 10, 10) : new p(this.f23967a.o(), iF - 1, 10);
        }
        int iF2 = f(i7, 7) - 8;
        return new p(i8, iF2 / 11, iF2 % 11);
    }

    static int g(com.google.zxing.common.a aVar, int i7, int i8) {
        int i9 = 0;
        for (int i10 = 0; i10 < i8; i10++) {
            if (aVar.k(i7 + i10)) {
                i9 |= 1 << ((i8 - i10) - 1);
            }
        }
        return i9;
    }

    private boolean h(int i7) {
        int i8 = i7 + 3;
        if (i8 > this.f23967a.o()) {
            return false;
        }
        while (i7 < i8) {
            if (this.f23967a.k(i7)) {
                return false;
            }
            i7++;
        }
        return true;
    }

    private boolean i(int i7) {
        int i8;
        if (i7 + 1 > this.f23967a.o()) {
            return false;
        }
        for (int i9 = 0; i9 < 5 && (i8 = i9 + i7) < this.f23967a.o(); i9++) {
            if (i9 == 2) {
                if (!this.f23967a.k(i7 + 2)) {
                    return false;
                }
            } else if (this.f23967a.k(i8)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(int i7) {
        int i8;
        if (i7 + 1 > this.f23967a.o()) {
            return false;
        }
        for (int i9 = 0; i9 < 4 && (i8 = i9 + i7) < this.f23967a.o(); i9++) {
            if (this.f23967a.k(i8)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i7) {
        int iF;
        if (i7 + 5 > this.f23967a.o()) {
            return false;
        }
        int iF2 = f(i7, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i7 + 6 <= this.f23967a.o() && (iF = f(i7, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    private boolean l(int i7) {
        int iF;
        if (i7 + 5 > this.f23967a.o()) {
            return false;
        }
        int iF2 = f(i7, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i7 + 7 > this.f23967a.o()) {
            return false;
        }
        int iF3 = f(i7, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i7 + 8 <= this.f23967a.o() && (iF = f(i7, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    private boolean m(int i7) {
        if (i7 + 7 > this.f23967a.o()) {
            return i7 + 4 <= this.f23967a.o();
        }
        int i8 = i7;
        while (true) {
            int i9 = i7 + 3;
            if (i8 >= i9) {
                return this.f23967a.k(i9);
            }
            if (this.f23967a.k(i8)) {
                return true;
            }
            i8++;
        }
    }

    private l n() {
        while (k(this.f23968b.a())) {
            n nVarB = b(this.f23968b.a());
            this.f23968b.i(nVarB.a());
            if (nVarB.c()) {
                return new l(new o(this.f23968b.a(), this.f23969c.toString()), true);
            }
            this.f23969c.append(nVarB.b());
        }
        if (h(this.f23968b.a())) {
            this.f23968b.b(3);
            this.f23968b.h();
        } else if (i(this.f23968b.a())) {
            if (this.f23968b.a() + 5 < this.f23967a.o()) {
                this.f23968b.b(5);
            } else {
                this.f23968b.i(this.f23967a.o());
            }
            this.f23968b.g();
        }
        return new l(false);
    }

    private o o() throws com.google.zxing.h {
        l lVarQ;
        boolean zB;
        do {
            int iA = this.f23968b.a();
            if (this.f23968b.c()) {
                lVarQ = n();
                zB = lVarQ.b();
            } else if (this.f23968b.d()) {
                lVarQ = p();
                zB = lVarQ.b();
            } else {
                lVarQ = q();
                zB = lVarQ.b();
            }
            if (!(iA != this.f23968b.a()) && !zB) {
                break;
            }
        } while (!zB);
        return lVarQ.a();
    }

    private l p() throws com.google.zxing.h {
        while (l(this.f23968b.a())) {
            n nVarD = d(this.f23968b.a());
            this.f23968b.i(nVarD.a());
            if (nVarD.c()) {
                return new l(new o(this.f23968b.a(), this.f23969c.toString()), true);
            }
            this.f23969c.append(nVarD.b());
        }
        if (h(this.f23968b.a())) {
            this.f23968b.b(3);
            this.f23968b.h();
        } else if (i(this.f23968b.a())) {
            if (this.f23968b.a() + 5 < this.f23967a.o()) {
                this.f23968b.b(5);
            } else {
                this.f23968b.i(this.f23967a.o());
            }
            this.f23968b.f();
        }
        return new l(false);
    }

    private l q() throws com.google.zxing.h {
        while (m(this.f23968b.a())) {
            p pVarE = e(this.f23968b.a());
            this.f23968b.i(pVarE.a());
            if (pVarE.f()) {
                return new l(pVarE.g() ? new o(this.f23968b.a(), this.f23969c.toString()) : new o(this.f23968b.a(), this.f23969c.toString(), pVarE.c()), true);
            }
            this.f23969c.append(pVarE.b());
            if (pVarE.g()) {
                return new l(new o(this.f23968b.a(), this.f23969c.toString()), true);
            }
            this.f23969c.append(pVarE.c());
        }
        if (j(this.f23968b.a())) {
            this.f23968b.f();
            this.f23968b.b(4);
        }
        return new l(false);
    }

    String a(StringBuilder sb, int i7) throws com.google.zxing.m, com.google.zxing.h {
        String str = null;
        while (true) {
            o oVarC = c(i7, str);
            String strA = r.a(oVarC.b());
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = oVarC.d() ? String.valueOf(oVarC.c()) : null;
            if (i7 == oVarC.a()) {
                return sb.toString();
            }
            i7 = oVarC.a();
            str = strValueOf;
        }
    }

    o c(int i7, String str) throws com.google.zxing.h {
        this.f23969c.setLength(0);
        if (str != null) {
            this.f23969c.append(str);
        }
        this.f23968b.i(i7);
        o oVarO = o();
        return (oVarO == null || !oVarO.d()) ? new o(this.f23968b.a(), this.f23969c.toString()) : new o(this.f23968b.a(), this.f23969c.toString(), oVarO.c());
    }

    int f(int i7, int i8) {
        return g(this.f23967a, i7, i8);
    }
}
