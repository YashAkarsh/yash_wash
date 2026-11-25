package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f14253a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<C0163a, Bitmap> f14254b = new e<>();

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.bitmap_recycle.a$a, reason: collision with other inner class name */
    static class C0163a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f14255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f14257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bitmap.Config f14258d;

        public C0163a(b bVar) {
            this.f14255a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.h
        public void a() {
            this.f14255a.c(this);
        }

        public void b(int i7, int i8, Bitmap.Config config) {
            this.f14256b = i7;
            this.f14257c = i8;
            this.f14258d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0163a)) {
                return false;
            }
            C0163a c0163a = (C0163a) obj;
            return this.f14256b == c0163a.f14256b && this.f14257c == c0163a.f14257c && this.f14258d == c0163a.f14258d;
        }

        public int hashCode() {
            int i7 = ((this.f14256b * 31) + this.f14257c) * 31;
            Bitmap.Config config = this.f14258d;
            return i7 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return a.g(this.f14256b, this.f14257c, this.f14258d);
        }
    }

    static class b extends com.bumptech.glide.load.engine.bitmap_recycle.b<C0163a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public C0163a a() {
            return new C0163a(this);
        }

        public C0163a e(int i7, int i8, Bitmap.Config config) {
            C0163a c0163aB = b();
            c0163aB.b(i7, i8, config);
            return c0163aB;
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(int i7, int i8, Bitmap.Config config) {
        return "[" + i7 + "x" + i8 + "], " + config;
    }

    private static String h(Bitmap bitmap) {
        return g(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public String a(int i7, int i8, Bitmap.Config config) {
        return g(i7, i8, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public void b(Bitmap bitmap) {
        this.f14254b.d(this.f14253a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.util.i.f(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public Bitmap d(int i7, int i8, Bitmap.Config config) {
        return this.f14254b.a(this.f14253a.e(i7, i8, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public String e(Bitmap bitmap) {
        return h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public Bitmap removeLast() {
        return this.f14254b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f14254b;
    }
}
