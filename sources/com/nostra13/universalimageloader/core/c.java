package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f32692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f32693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f32694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Drawable f32695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Drawable f32696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Drawable f32697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f32698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f32699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f32700i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.assist.d f32701j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final BitmapFactory.Options f32702k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f32703l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f32704m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Object f32705n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final z3.a f32706o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final z3.a f32707p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.display.a f32708q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Handler f32709r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f32710s;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f32711a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f32712b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f32713c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Drawable f32714d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Drawable f32715e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Drawable f32716f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f32717g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f32718h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f32719i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private com.nostra13.universalimageloader.core.assist.d f32720j = com.nostra13.universalimageloader.core.assist.d.IN_SAMPLE_POWER_OF_2;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private BitmapFactory.Options f32721k = new BitmapFactory.Options();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f32722l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f32723m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Object f32724n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private z3.a f32725o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private z3.a f32726p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private com.nostra13.universalimageloader.core.display.a f32727q = com.nostra13.universalimageloader.core.a.a();

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private Handler f32728r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f32729s = false;

        public b() {
            BitmapFactory.Options options = this.f32721k;
            options.inPurgeable = true;
            options.inInputShareable = true;
        }

        public b A(boolean z7) {
            this.f32723m = z7;
            return this;
        }

        public b B(BitmapFactory.Options options) {
            if (options == null) {
                throw new IllegalArgumentException("decodingOptions can't be null");
            }
            this.f32721k = options;
            return this;
        }

        public b C(int i7) {
            this.f32722l = i7;
            return this;
        }

        public b D(com.nostra13.universalimageloader.core.display.a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("displayer can't be null");
            }
            this.f32727q = aVar;
            return this;
        }

        public b E(Object obj) {
            this.f32724n = obj;
            return this;
        }

        public b F(Handler handler) {
            this.f32728r = handler;
            return this;
        }

        public b G(com.nostra13.universalimageloader.core.assist.d dVar) {
            this.f32720j = dVar;
            return this;
        }

        public b H(z3.a aVar) {
            this.f32726p = aVar;
            return this;
        }

        public b I(z3.a aVar) {
            this.f32725o = aVar;
            return this;
        }

        public b J() {
            this.f32717g = true;
            return this;
        }

        public b K(boolean z7) {
            this.f32717g = z7;
            return this;
        }

        public b L(int i7) {
            this.f32712b = i7;
            return this;
        }

        public b M(Drawable drawable) {
            this.f32715e = drawable;
            return this;
        }

        public b N(int i7) {
            this.f32713c = i7;
            return this;
        }

        public b O(Drawable drawable) {
            this.f32716f = drawable;
            return this;
        }

        public b P(int i7) {
            this.f32711a = i7;
            return this;
        }

        public b Q(Drawable drawable) {
            this.f32714d = drawable;
            return this;
        }

        @Deprecated
        public b R(int i7) {
            this.f32711a = i7;
            return this;
        }

        b S(boolean z7) {
            this.f32729s = z7;
            return this;
        }

        public b t(Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.f32721k.inPreferredConfig = config;
            return this;
        }

        public c u() {
            return new c(this);
        }

        public b v() {
            this.f32718h = true;
            return this;
        }

        public b w(boolean z7) {
            this.f32718h = z7;
            return this;
        }

        public b x() {
            this.f32719i = true;
            return this;
        }

        public b y(boolean z7) {
            this.f32719i = z7;
            return this;
        }

        public b z(c cVar) {
            this.f32711a = cVar.f32692a;
            this.f32712b = cVar.f32693b;
            this.f32713c = cVar.f32694c;
            this.f32714d = cVar.f32695d;
            this.f32715e = cVar.f32696e;
            this.f32716f = cVar.f32697f;
            this.f32717g = cVar.f32698g;
            this.f32718h = cVar.f32699h;
            this.f32719i = cVar.f32700i;
            this.f32720j = cVar.f32701j;
            this.f32721k = cVar.f32702k;
            this.f32722l = cVar.f32703l;
            this.f32723m = cVar.f32704m;
            this.f32724n = cVar.f32705n;
            this.f32725o = cVar.f32706o;
            this.f32726p = cVar.f32707p;
            this.f32727q = cVar.f32708q;
            this.f32728r = cVar.f32709r;
            this.f32729s = cVar.f32710s;
            return this;
        }
    }

    public static c t() {
        return new b().u();
    }

    public Drawable A(Resources resources) {
        int i7 = this.f32694c;
        return i7 != 0 ? resources.getDrawable(i7) : this.f32697f;
    }

    public Drawable B(Resources resources) {
        int i7 = this.f32692a;
        return i7 != 0 ? resources.getDrawable(i7) : this.f32695d;
    }

    public com.nostra13.universalimageloader.core.assist.d C() {
        return this.f32701j;
    }

    public z3.a D() {
        return this.f32707p;
    }

    public z3.a E() {
        return this.f32706o;
    }

    public boolean F() {
        return this.f32699h;
    }

    public boolean G() {
        return this.f32700i;
    }

    public boolean H() {
        return this.f32704m;
    }

    public boolean I() {
        return this.f32698g;
    }

    boolean J() {
        return this.f32710s;
    }

    public boolean K() {
        return this.f32703l > 0;
    }

    public boolean L() {
        return this.f32707p != null;
    }

    public boolean M() {
        return this.f32706o != null;
    }

    public boolean N() {
        return (this.f32696e == null && this.f32693b == 0) ? false : true;
    }

    public boolean O() {
        return (this.f32697f == null && this.f32694c == 0) ? false : true;
    }

    public boolean P() {
        return (this.f32695d == null && this.f32692a == 0) ? false : true;
    }

    public BitmapFactory.Options u() {
        return this.f32702k;
    }

    public int v() {
        return this.f32703l;
    }

    public com.nostra13.universalimageloader.core.display.a w() {
        return this.f32708q;
    }

    public Object x() {
        return this.f32705n;
    }

    public Handler y() {
        return this.f32709r;
    }

    public Drawable z(Resources resources) {
        int i7 = this.f32693b;
        return i7 != 0 ? resources.getDrawable(i7) : this.f32696e;
    }

    private c(b bVar) {
        this.f32692a = bVar.f32711a;
        this.f32693b = bVar.f32712b;
        this.f32694c = bVar.f32713c;
        this.f32695d = bVar.f32714d;
        this.f32696e = bVar.f32715e;
        this.f32697f = bVar.f32716f;
        this.f32698g = bVar.f32717g;
        this.f32699h = bVar.f32718h;
        this.f32700i = bVar.f32719i;
        this.f32701j = bVar.f32720j;
        this.f32702k = bVar.f32721k;
        this.f32703l = bVar.f32722l;
        this.f32704m = bVar.f32723m;
        this.f32705n = bVar.f32724n;
        this.f32706o = bVar.f32725o;
        this.f32707p = bVar.f32726p;
        this.f32708q = bVar.f32727q;
        this.f32709r = bVar.f32728r;
        this.f32710s = bVar.f32729s;
    }
}
