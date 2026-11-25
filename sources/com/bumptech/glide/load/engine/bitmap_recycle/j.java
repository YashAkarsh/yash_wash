package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public class j implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f14280d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f14281e = {Bitmap.Config.ARGB_8888, null};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Bitmap.Config[] f14282f = {Bitmap.Config.RGB_565};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Bitmap.Config[] f14283g = {Bitmap.Config.ARGB_4444};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Bitmap.Config[] f14284h = {Bitmap.Config.ALPHA_8};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f14285a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<b, Bitmap> f14286b = new e<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f14287c = new HashMap();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14288a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f14288a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14288a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14288a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14288a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static class c extends com.bumptech.glide.load.engine.bitmap_recycle.b<b> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b e(int i7, Bitmap.Config config) {
            b bVarB = b();
            bVarB.c(i7, config);
            return bVarB;
        }
    }

    private void g(Integer num, Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMapK = k(config);
        Integer num2 = navigableMapK.get(num);
        if (num2.intValue() == 1) {
            navigableMapK.remove(num);
        } else {
            navigableMapK.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private b h(b bVar, int i7, Bitmap.Config config) {
        for (Bitmap.Config config2 : j(config)) {
            Integer numCeilingKey = k(config2).ceilingKey(Integer.valueOf(i7));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i7 * 8) {
                if (numCeilingKey.intValue() == i7) {
                    if (config2 == null) {
                        if (config == null) {
                            return bVar;
                        }
                    } else if (config2.equals(config)) {
                        return bVar;
                    }
                }
                this.f14285a.c(bVar);
                return this.f14285a.e(numCeilingKey.intValue(), config2);
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(int i7, Bitmap.Config config) {
        return "[" + i7 + "](" + config + ")";
    }

    private static Bitmap.Config[] j(Bitmap.Config config) {
        int i7 = a.f14288a[config.ordinal()];
        if (i7 == 1) {
            return f14281e;
        }
        if (i7 == 2) {
            return f14282f;
        }
        if (i7 != 3) {
            return i7 != 4 ? new Bitmap.Config[]{config} : f14284h;
        }
        return f14283g;
    }

    private NavigableMap<Integer, Integer> k(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f14287c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f14287c.put(config, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public String a(int i7, int i8, Bitmap.Config config) {
        return i(com.bumptech.glide.util.i.e(i7, i8, config), config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public void b(Bitmap bitmap) {
        b bVarE = this.f14285a.e(com.bumptech.glide.util.i.f(bitmap), bitmap.getConfig());
        this.f14286b.d(bVarE, bitmap);
        NavigableMap<Integer, Integer> navigableMapK = k(bitmap.getConfig());
        Integer num = navigableMapK.get(Integer.valueOf(bVarE.f14290b));
        navigableMapK.put(Integer.valueOf(bVarE.f14290b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.util.i.f(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public Bitmap d(int i7, int i8, Bitmap.Config config) {
        int iE = com.bumptech.glide.util.i.e(i7, i8, config);
        Bitmap bitmapA = this.f14286b.a(h(this.f14285a.e(iE, config), iE, config));
        if (bitmapA != null) {
            g(Integer.valueOf(com.bumptech.glide.util.i.f(bitmapA)), bitmapA.getConfig());
            bitmapA.reconfigure(i7, i8, bitmapA.getConfig() != null ? bitmapA.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return bitmapA;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public String e(Bitmap bitmap) {
        return i(com.bumptech.glide.util.i.f(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.g
    public Bitmap removeLast() {
        Bitmap bitmapF = this.f14286b.f();
        if (bitmapF != null) {
            g(Integer.valueOf(com.bumptech.glide.util.i.f(bitmapF)), bitmapF.getConfig());
        }
        return bitmapF;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f14286b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f14287c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f14287c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f14289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f14291c;

        public b(c cVar) {
            this.f14289a = cVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.h
        public void a() {
            this.f14289a.c(this);
        }

        public void c(int i7, Bitmap.Config config) {
            this.f14290b = i7;
            this.f14291c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f14290b != bVar.f14290b) {
                return false;
            }
            Bitmap.Config config = this.f14291c;
            Bitmap.Config config2 = bVar.f14291c;
            if (config == null) {
                if (config2 != null) {
                    return false;
                }
            } else if (!config.equals(config2)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i7 = this.f14290b * 31;
            Bitmap.Config config = this.f14291c;
            return i7 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return j.i(this.f14290b, this.f14291c);
        }

        b(c cVar, int i7, Bitmap.Config config) {
            this(cVar);
            c(i7, config);
        }
    }
}
