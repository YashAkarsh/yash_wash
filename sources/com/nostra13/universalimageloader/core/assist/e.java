package com.nostra13.universalimageloader.core.assist;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f32665c = 9;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f32666d = "x";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f32667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32668b;

    public e(int i7, int i8) {
        this.f32667a = i7;
        this.f32668b = i8;
    }

    public int a() {
        return this.f32668b;
    }

    public int b() {
        return this.f32667a;
    }

    public e c(float f8) {
        return new e((int) (this.f32667a * f8), (int) (this.f32668b * f8));
    }

    public e d(int i7) {
        return new e(this.f32667a / i7, this.f32668b / i7);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.f32667a);
        sb.append(f32666d);
        sb.append(this.f32668b);
        return sb.toString();
    }

    public e(int i7, int i8, int i9) {
        if (i9 % 180 == 0) {
            this.f32667a = i7;
            this.f32668b = i8;
        } else {
            this.f32667a = i8;
            this.f32668b = i7;
        }
    }
}
