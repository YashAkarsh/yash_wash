package com.airbnb.lottie.value;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f12377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f12378b;

    public k(float f8, float f9) {
        this.f12377a = f8;
        this.f12378b = f9;
    }

    public boolean a(float f8, float f9) {
        return this.f12377a == f8 && this.f12378b == f9;
    }

    public float b() {
        return this.f12377a;
    }

    public float c() {
        return this.f12378b;
    }

    public void d(float f8, float f9) {
        this.f12377a = f8;
        this.f12378b = f9;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public k() {
        this(1.0f, 1.0f);
    }
}
