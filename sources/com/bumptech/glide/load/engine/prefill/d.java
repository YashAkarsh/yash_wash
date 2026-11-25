package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Bitmap.Config f14451e = Bitmap.Config.RGB_565;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bitmap.Config f14454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14455d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f14458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f14459d;

        public a(int i7) {
            this(i7, i7);
        }

        d a() {
            return new d(this.f14456a, this.f14457b, this.f14458c, this.f14459d);
        }

        Bitmap.Config b() {
            return this.f14458c;
        }

        public a c(Bitmap.Config config) {
            this.f14458c = config;
            return this;
        }

        public a d(int i7) {
            if (i7 <= 0) {
                throw new IllegalArgumentException("Weight must be > 0");
            }
            this.f14459d = i7;
            return this;
        }

        public a(int i7, int i8) {
            this.f14459d = 1;
            if (i7 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i8 <= 0) {
                throw new IllegalArgumentException("Height must be > 0");
            }
            this.f14456a = i7;
            this.f14457b = i8;
        }
    }

    d(int i7, int i8, Bitmap.Config config, int i9) {
        if (config == null) {
            throw new NullPointerException("Config must not be null");
        }
        this.f14452a = i7;
        this.f14453b = i8;
        this.f14454c = config;
        this.f14455d = i9;
    }

    Bitmap.Config a() {
        return this.f14454c;
    }

    int b() {
        return this.f14453b;
    }

    int c() {
        return this.f14455d;
    }

    int d() {
        return this.f14452a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f14453b == dVar.f14453b && this.f14452a == dVar.f14452a && this.f14455d == dVar.f14455d && this.f14454c == dVar.f14454c;
    }

    public int hashCode() {
        return (((((this.f14452a * 31) + this.f14453b) * 31) + this.f14454c.hashCode()) * 31) + this.f14455d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f14452a + ", height=" + this.f14453b + ", config=" + this.f14454c + ", weight=" + this.f14455d + '}';
    }
}
