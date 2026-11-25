package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* JADX INFO: loaded from: classes2.dex */
class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f24059c = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f24060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d[] f24061b;

    g(c cVar) {
        this.f24060a = new c(cVar);
        this.f24061b = new d[(cVar.e() - cVar.g()) + 1];
    }

    final c a() {
        return this.f24060a;
    }

    final d b(int i7) {
        return this.f24061b[e(i7)];
    }

    final d c(int i7) {
        d dVar;
        d dVar2;
        d dVarB = b(i7);
        if (dVarB != null) {
            return dVarB;
        }
        for (int i8 = 1; i8 < 5; i8++) {
            int iE = e(i7) - i8;
            if (iE >= 0 && (dVar2 = this.f24061b[iE]) != null) {
                return dVar2;
            }
            int iE2 = e(i7) + i8;
            d[] dVarArr = this.f24061b;
            if (iE2 < dVarArr.length && (dVar = dVarArr[iE2]) != null) {
                return dVar;
            }
        }
        return null;
    }

    final d[] d() {
        return this.f24061b;
    }

    final int e(int i7) {
        return i7 - this.f24060a.g();
    }

    final void f(int i7, d dVar) {
        this.f24061b[e(i7)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i7 = 0;
            for (d dVar : this.f24061b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i7));
                    i7++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i7), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i7++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
