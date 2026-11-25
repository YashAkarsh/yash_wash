package com.airbnb.lottie.utils;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f12336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12337b;

    public void a(float f8) {
        float f9 = this.f12336a + f8;
        this.f12336a = f9;
        int i7 = this.f12337b + 1;
        this.f12337b = i7;
        if (i7 == Integer.MAX_VALUE) {
            this.f12336a = f9 / 2.0f;
            this.f12337b = i7 / 2;
        }
    }

    public float b() {
        int i7 = this.f12337b;
        if (i7 == 0) {
            return 0.0f;
        }
        return this.f12336a / i7;
    }
}
