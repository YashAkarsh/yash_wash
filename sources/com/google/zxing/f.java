package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23723b;

    public f(int i7, int i8) {
        if (i7 < 0 || i8 < 0) {
            throw new IllegalArgumentException();
        }
        this.f23722a = i7;
        this.f23723b = i8;
    }

    public int a() {
        return this.f23723b;
    }

    public int b() {
        return this.f23722a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f23722a == fVar.f23722a && this.f23723b == fVar.f23723b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f23722a * 32713) + this.f23723b;
    }

    public String toString() {
        return this.f23722a + "x" + this.f23723b;
    }
}
