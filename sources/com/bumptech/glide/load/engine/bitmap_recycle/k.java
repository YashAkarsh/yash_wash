package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
class k implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f14292d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f14293a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<a, Bitmap> f14294b = new e<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TreeMap<Integer, Integer> f14295c = new i();

    static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f14296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14297b;

        a(b bVar) {
            this.f14296a = bVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.h
        public void a() {
            this.f14296a.c(this);
        }

        public void c(int i7) {
            this.f14297b = i7;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f14297b == ((a) obj).f14297b;
        }

        public int hashCode() {
            return this.f14297b;
        }

        public String toString() {
            return k.h(this.f14297b);
        }
    }

    static class b extends com.bumptech.glide.load.engine.bitmap_recycle.b<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a e(int i7) {
            a aVarB = b();
            aVarB.c(i7);
            return aVarB;
        }
    }

    k() {
    }

    private void g(Integer num) {
        Integer num2 = this.f14295c.get(num);
        if (num2.intValue() == 1) {
            this.f14295c.remove(num);
        } else {
            this.f14295c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(int i7) {
        return "[" + i7 + "]";
    }

    private static String i(Bitmap bitmap) {
        return h(com.bumptech.glide.util.i.f(bitmap));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public String a(int i7, int i8, Bitmap.Config config) {
        return h(com.bumptech.glide.util.i.e(i7, i8, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public void b(Bitmap bitmap) {
        a aVarE = this.f14293a.e(com.bumptech.glide.util.i.f(bitmap));
        this.f14294b.d(aVarE, bitmap);
        Integer num = this.f14295c.get(Integer.valueOf(aVarE.f14297b));
        this.f14295c.put(Integer.valueOf(aVarE.f14297b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.util.i.f(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public Bitmap d(int i7, int i8, Bitmap.Config config) {
        int iE = com.bumptech.glide.util.i.e(i7, i8, config);
        a aVarE = this.f14293a.e(iE);
        Integer numCeilingKey = this.f14295c.ceilingKey(Integer.valueOf(iE));
        if (numCeilingKey != null && numCeilingKey.intValue() != iE && numCeilingKey.intValue() <= iE * 8) {
            this.f14293a.c(aVarE);
            aVarE = this.f14293a.e(numCeilingKey.intValue());
        }
        Bitmap bitmapA = this.f14294b.a(aVarE);
        if (bitmapA != null) {
            bitmapA.reconfigure(i7, i8, config);
            g(numCeilingKey);
        }
        return bitmapA;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public String e(Bitmap bitmap) {
        return i(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public Bitmap removeLast() {
        Bitmap bitmapF = this.f14294b.f();
        if (bitmapF != null) {
            g(Integer.valueOf(com.bumptech.glide.util.i.f(bitmapF)));
        }
        return bitmapF;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.f14294b + "\n  SortedSizes" + this.f14295c;
    }
}
