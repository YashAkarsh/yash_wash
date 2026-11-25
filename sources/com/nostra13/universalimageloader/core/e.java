package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Resources f32797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f32798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f32799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f32800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f32801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Bitmap.CompressFormat f32802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f32803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final z3.a f32804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Executor f32805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Executor f32806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f32807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final boolean f32808l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final int f32809m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final int f32810n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final com.nostra13.universalimageloader.core.assist.g f32811o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final com.nostra13.universalimageloader.cache.memory.c<String, Bitmap> f32812p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final com.nostra13.universalimageloader.cache.disc.b f32813q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final com.nostra13.universalimageloader.core.download.c f32814r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final com.nostra13.universalimageloader.core.decode.b f32815s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final c f32816t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final boolean f32817u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final com.nostra13.universalimageloader.cache.disc.b f32818v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final com.nostra13.universalimageloader.core.download.c f32819w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final com.nostra13.universalimageloader.core.download.c f32820x;

    public static class b {
        private static final String A = "discCache(), discCacheSize() and discCacheFileCount calls overlap each other";
        private static final String B = "discCache() and discCacheFileNameGenerator() calls overlap each other";
        private static final String C = "memoryCache() and memoryCacheSize() calls overlap each other";
        private static final String D = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
        public static final int E = 3;
        public static final int F = 4;
        public static final com.nostra13.universalimageloader.core.assist.g G = com.nostra13.universalimageloader.core.assist.g.FIFO;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f32821a;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private com.nostra13.universalimageloader.core.decode.b f32844x;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f32822b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f32823c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f32824d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f32825e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Bitmap.CompressFormat f32826f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f32827g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private z3.a f32828h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Executor f32829i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Executor f32830j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f32831k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f32832l = false;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f32833m = 3;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f32834n = 4;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f32835o = false;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private com.nostra13.universalimageloader.core.assist.g f32836p = G;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f32837q = 0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f32838r = 0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f32839s = 0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private com.nostra13.universalimageloader.cache.memory.c<String, Bitmap> f32840t = null;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private com.nostra13.universalimageloader.cache.disc.b f32841u = null;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private x3.a f32842v = null;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private com.nostra13.universalimageloader.core.download.c f32843w = null;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private c f32845y = null;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private boolean f32846z = false;

        public b(Context context) {
            this.f32821a = context.getApplicationContext();
        }

        private void F() {
            if (this.f32829i == null) {
                this.f32829i = com.nostra13.universalimageloader.core.a.c(this.f32833m, this.f32834n, this.f32836p);
            } else {
                this.f32831k = true;
            }
            if (this.f32830j == null) {
                this.f32830j = com.nostra13.universalimageloader.core.a.c(this.f32833m, this.f32834n, this.f32836p);
            } else {
                this.f32832l = true;
            }
            if (this.f32841u == null) {
                if (this.f32842v == null) {
                    this.f32842v = com.nostra13.universalimageloader.core.a.d();
                }
                this.f32841u = com.nostra13.universalimageloader.core.a.b(this.f32821a, this.f32842v, this.f32838r, this.f32839s);
            }
            if (this.f32840t == null) {
                this.f32840t = com.nostra13.universalimageloader.core.a.g(this.f32837q);
            }
            if (this.f32835o) {
                this.f32840t = new com.nostra13.universalimageloader.cache.memory.impl.b(this.f32840t, com.nostra13.universalimageloader.utils.e.a());
            }
            if (this.f32843w == null) {
                this.f32843w = com.nostra13.universalimageloader.core.a.f(this.f32821a);
            }
            if (this.f32844x == null) {
                this.f32844x = com.nostra13.universalimageloader.core.a.e(this.f32846z);
            }
            if (this.f32845y == null) {
                this.f32845y = c.t();
            }
        }

        public b A(int i7) {
            if (i7 <= 0) {
                throw new IllegalArgumentException("maxFileCount must be a positive number");
            }
            if (this.f32841u != null || this.f32838r > 0) {
                com.nostra13.universalimageloader.utils.d.i(A, new Object[0]);
            }
            this.f32838r = 0;
            this.f32839s = i7;
            return this;
        }

        public b B(x3.a aVar) {
            if (this.f32841u != null) {
                com.nostra13.universalimageloader.utils.d.i(B, new Object[0]);
            }
            this.f32842v = aVar;
            return this;
        }

        public b C(int i7) {
            if (i7 <= 0) {
                throw new IllegalArgumentException("maxCacheSize must be a positive number");
            }
            if (this.f32841u != null || this.f32839s > 0) {
                com.nostra13.universalimageloader.utils.d.i(A, new Object[0]);
            }
            this.f32838r = i7;
            return this;
        }

        public b D(com.nostra13.universalimageloader.core.decode.b bVar) {
            this.f32844x = bVar;
            return this;
        }

        public b E(com.nostra13.universalimageloader.core.download.c cVar) {
            this.f32843w = cVar;
            return this;
        }

        public b G(com.nostra13.universalimageloader.cache.memory.c<String, Bitmap> cVar) {
            if (this.f32837q != 0) {
                com.nostra13.universalimageloader.utils.d.i(C, new Object[0]);
            }
            this.f32840t = cVar;
            return this;
        }

        public b H(int i7, int i8) {
            this.f32822b = i7;
            this.f32823c = i8;
            return this;
        }

        public b I(int i7) {
            if (i7 <= 0) {
                throw new IllegalArgumentException("memoryCacheSize must be a positive number");
            }
            if (this.f32840t != null) {
                com.nostra13.universalimageloader.utils.d.i(C, new Object[0]);
            }
            this.f32837q = i7;
            return this;
        }

        public b J(int i7) {
            if (i7 <= 0 || i7 >= 100) {
                throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
            }
            if (this.f32840t != null) {
                com.nostra13.universalimageloader.utils.d.i(C, new Object[0]);
            }
            this.f32837q = (int) (Runtime.getRuntime().maxMemory() * (i7 / 100.0f));
            return this;
        }

        public b K(Executor executor) {
            if (this.f32833m != 3 || this.f32834n != 4 || this.f32836p != G) {
                com.nostra13.universalimageloader.utils.d.i(D, new Object[0]);
            }
            this.f32829i = executor;
            return this;
        }

        public b L(Executor executor) {
            if (this.f32833m != 3 || this.f32834n != 4 || this.f32836p != G) {
                com.nostra13.universalimageloader.utils.d.i(D, new Object[0]);
            }
            this.f32830j = executor;
            return this;
        }

        public b M(com.nostra13.universalimageloader.core.assist.g gVar) {
            if (this.f32829i != null || this.f32830j != null) {
                com.nostra13.universalimageloader.utils.d.i(D, new Object[0]);
            }
            this.f32836p = gVar;
            return this;
        }

        public b N(int i7) {
            if (this.f32829i != null || this.f32830j != null) {
                com.nostra13.universalimageloader.utils.d.i(D, new Object[0]);
            }
            this.f32833m = i7;
            return this;
        }

        public b O(int i7) {
            if (this.f32829i != null || this.f32830j != null) {
                com.nostra13.universalimageloader.utils.d.i(D, new Object[0]);
            }
            if (i7 < 1) {
                this.f32834n = 1;
            } else if (i7 > 10) {
                this.f32834n = 10;
            } else {
                this.f32834n = i7;
            }
            return this;
        }

        public b P() {
            this.f32846z = true;
            return this;
        }

        public e v() {
            F();
            return new e(this);
        }

        public b w(c cVar) {
            this.f32845y = cVar;
            return this;
        }

        public b x() {
            this.f32835o = true;
            return this;
        }

        public b y(com.nostra13.universalimageloader.cache.disc.b bVar) {
            if (this.f32838r > 0 || this.f32839s > 0) {
                com.nostra13.universalimageloader.utils.d.i(A, new Object[0]);
            }
            if (this.f32842v != null) {
                com.nostra13.universalimageloader.utils.d.i(B, new Object[0]);
            }
            this.f32841u = bVar;
            return this;
        }

        public b z(int i7, int i8, Bitmap.CompressFormat compressFormat, int i9, z3.a aVar) {
            this.f32824d = i7;
            this.f32825e = i8;
            this.f32826f = compressFormat;
            this.f32827g = i9;
            this.f32828h = aVar;
            return this;
        }
    }

    public static e a(Context context) {
        return new b(context).v();
    }

    com.nostra13.universalimageloader.core.assist.e b() {
        DisplayMetrics displayMetrics = this.f32797a.getDisplayMetrics();
        int i7 = this.f32798b;
        if (i7 <= 0) {
            i7 = displayMetrics.widthPixels;
        }
        int i8 = this.f32799c;
        if (i8 <= 0) {
            i8 = displayMetrics.heightPixels;
        }
        return new com.nostra13.universalimageloader.core.assist.e(i7, i8);
    }

    private e(b bVar) {
        this.f32797a = bVar.f32821a.getResources();
        this.f32798b = bVar.f32822b;
        this.f32799c = bVar.f32823c;
        this.f32800d = bVar.f32824d;
        this.f32801e = bVar.f32825e;
        this.f32802f = bVar.f32826f;
        this.f32803g = bVar.f32827g;
        this.f32804h = bVar.f32828h;
        this.f32805i = bVar.f32829i;
        this.f32806j = bVar.f32830j;
        this.f32809m = bVar.f32833m;
        this.f32810n = bVar.f32834n;
        this.f32811o = bVar.f32836p;
        this.f32813q = bVar.f32841u;
        this.f32812p = bVar.f32840t;
        this.f32816t = bVar.f32845y;
        this.f32817u = bVar.f32846z;
        com.nostra13.universalimageloader.core.download.c cVar = bVar.f32843w;
        this.f32814r = cVar;
        this.f32815s = bVar.f32844x;
        this.f32807k = bVar.f32831k;
        this.f32808l = bVar.f32832l;
        this.f32819w = new com.nostra13.universalimageloader.core.download.d(cVar);
        this.f32820x = new com.nostra13.universalimageloader.core.download.e(cVar);
        this.f32818v = com.nostra13.universalimageloader.core.a.h(com.nostra13.universalimageloader.utils.f.b(bVar.f32821a, false));
    }
}
