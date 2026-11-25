package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f24249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f24250b;

    public t(float f8, float f9) {
        this.f24249a = f8;
        this.f24250b = f9;
    }

    private static float a(t tVar, t tVar2, t tVar3) {
        float f8 = tVar2.f24249a;
        float f9 = tVar2.f24250b;
        return ((tVar3.f24249a - f8) * (tVar.f24250b - f9)) - ((tVar3.f24250b - f9) * (tVar.f24249a - f8));
    }

    public static float b(t tVar, t tVar2) {
        return a2.a.a(tVar.f24249a, tVar.f24250b, tVar2.f24249a, tVar2.f24250b);
    }

    public static void e(t[] tVarArr) {
        t tVar;
        t tVar2;
        t tVar3;
        float fB = b(tVarArr[0], tVarArr[1]);
        float fB2 = b(tVarArr[1], tVarArr[2]);
        float fB3 = b(tVarArr[0], tVarArr[2]);
        if (fB2 >= fB && fB2 >= fB3) {
            tVar = tVarArr[0];
            tVar2 = tVarArr[1];
            tVar3 = tVarArr[2];
        } else if (fB3 < fB2 || fB3 < fB) {
            tVar = tVarArr[2];
            tVar2 = tVarArr[0];
            tVar3 = tVarArr[1];
        } else {
            tVar = tVarArr[1];
            tVar2 = tVarArr[0];
            tVar3 = tVarArr[2];
        }
        if (a(tVar2, tVar, tVar3) < 0.0f) {
            t tVar4 = tVar3;
            tVar3 = tVar2;
            tVar2 = tVar4;
        }
        tVarArr[0] = tVar2;
        tVarArr[1] = tVar;
        tVarArr[2] = tVar3;
    }

    public final float c() {
        return this.f24249a;
    }

    public final float d() {
        return this.f24250b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f24249a == tVar.f24249a && this.f24250b == tVar.f24250b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f24249a) * 31) + Float.floatToIntBits(this.f24250b);
    }

    public final String toString() {
        return "(" + this.f24249a + ',' + this.f24250b + ')';
    }
}
