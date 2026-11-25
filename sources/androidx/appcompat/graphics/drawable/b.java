package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.SparseArray;
import c.l;
import c.m0;
import c.o0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
class b extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final boolean f941m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f942n = "DrawableContainer";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final boolean f943o = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f947d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f949f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Runnable f952i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f953j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f954k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private c f955l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f948e = 255;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f950g = -1;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.graphics.drawable.b$b, reason: collision with other inner class name */
    @t0(21)
    private static class C0022b {
        private C0022b() {
        }

        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    static class c implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable.Callback f957a;

        c() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f957a;
            this.f957a = null;
            return callback;
        }

        public c b(Drawable.Callback callback) {
            this.f957a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@m0 Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable, long j7) {
            Drawable.Callback callback = this.f957a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j7);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable) {
            Drawable.Callback callback = this.f957a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static abstract class d extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Resources f959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f961d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f962e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Drawable[] f964g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f965h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f966i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f967j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Rect f968k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f969l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f970m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f971n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f972o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f973p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f974q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f975r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f976s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        boolean f977t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f978u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f979v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f980w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        boolean f981x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        boolean f982y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int f983z;

        d(d dVar, b bVar, Resources resources) {
            this.f966i = false;
            this.f969l = false;
            this.f981x = true;
            this.A = 0;
            this.B = 0;
            this.f958a = bVar;
            this.f959b = resources != null ? resources : dVar != null ? dVar.f959b : null;
            int iG = b.g(resources, dVar != null ? dVar.f960c : 0);
            this.f960c = iG;
            if (dVar == null) {
                this.f964g = new Drawable[10];
                this.f965h = 0;
                return;
            }
            this.f961d = dVar.f961d;
            this.f962e = dVar.f962e;
            this.f979v = true;
            this.f980w = true;
            this.f966i = dVar.f966i;
            this.f969l = dVar.f969l;
            this.f981x = dVar.f981x;
            this.f982y = dVar.f982y;
            this.f983z = dVar.f983z;
            this.A = dVar.A;
            this.B = dVar.B;
            this.C = dVar.C;
            this.D = dVar.D;
            this.E = dVar.E;
            this.F = dVar.F;
            this.G = dVar.G;
            this.H = dVar.H;
            this.I = dVar.I;
            if (dVar.f960c == iG) {
                if (dVar.f967j) {
                    this.f968k = dVar.f968k != null ? new Rect(dVar.f968k) : null;
                    this.f967j = true;
                }
                if (dVar.f970m) {
                    this.f971n = dVar.f971n;
                    this.f972o = dVar.f972o;
                    this.f973p = dVar.f973p;
                    this.f974q = dVar.f974q;
                    this.f970m = true;
                }
            }
            if (dVar.f975r) {
                this.f976s = dVar.f976s;
                this.f975r = true;
            }
            if (dVar.f977t) {
                this.f978u = dVar.f978u;
                this.f977t = true;
            }
            Drawable[] drawableArr = dVar.f964g;
            this.f964g = new Drawable[drawableArr.length];
            this.f965h = dVar.f965h;
            SparseArray<Drawable.ConstantState> sparseArray = dVar.f963f;
            if (sparseArray != null) {
                this.f963f = sparseArray.clone();
            } else {
                this.f963f = new SparseArray<>(this.f965h);
            }
            int i7 = this.f965h;
            for (int i8 = 0; i8 < i7; i8++) {
                Drawable drawable = drawableArr[i8];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f963f.put(i8, constantState);
                    } else {
                        this.f964g[i8] = drawableArr[i8];
                    }
                }
            }
        }

        private void f() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f963f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i7 = 0; i7 < size; i7++) {
                    this.f964g[this.f963f.keyAt(i7)] = w(this.f963f.valueAt(i7).newDrawable(this.f959b));
                }
                this.f963f = null;
            }
        }

        private Drawable w(Drawable drawable) {
            androidx.core.graphics.drawable.d.m(drawable, this.f983z);
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f958a);
            return drawableMutate;
        }

        final boolean A(int i7, int i8) {
            int i9 = this.f965h;
            Drawable[] drawableArr = this.f964g;
            boolean z7 = false;
            for (int i10 = 0; i10 < i9; i10++) {
                Drawable drawable = drawableArr[i10];
                if (drawable != null) {
                    boolean zM = androidx.core.graphics.drawable.d.m(drawable, i7);
                    if (i10 == i8) {
                        z7 = zM;
                    }
                }
            }
            this.f983z = i7;
            return z7;
        }

        public final void B(boolean z7) {
            this.f966i = z7;
        }

        final void C(Resources resources) {
            if (resources != null) {
                this.f959b = resources;
                int iG = b.g(resources, this.f960c);
                int i7 = this.f960c;
                this.f960c = iG;
                if (i7 != iG) {
                    this.f970m = false;
                    this.f967j = false;
                }
            }
        }

        public final int a(Drawable drawable) {
            int i7 = this.f965h;
            if (i7 >= this.f964g.length) {
                r(i7, i7 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f958a);
            this.f964g[i7] = drawable;
            this.f965h++;
            this.f962e = drawable.getChangingConfigurations() | this.f962e;
            s();
            this.f968k = null;
            this.f967j = false;
            this.f970m = false;
            this.f979v = false;
            return i7;
        }

        @t0(21)
        final void b(Resources.Theme theme) {
            if (theme != null) {
                f();
                int i7 = this.f965h;
                Drawable[] drawableArr = this.f964g;
                for (int i8 = 0; i8 < i7; i8++) {
                    Drawable drawable = drawableArr[i8];
                    if (drawable != null && androidx.core.graphics.drawable.d.b(drawable)) {
                        androidx.core.graphics.drawable.d.a(drawableArr[i8], theme);
                        this.f962e |= drawableArr[i8].getChangingConfigurations();
                    }
                }
                C(C0022b.c(theme));
            }
        }

        public boolean c() {
            if (this.f979v) {
                return this.f980w;
            }
            f();
            this.f979v = true;
            int i7 = this.f965h;
            Drawable[] drawableArr = this.f964g;
            for (int i8 = 0; i8 < i7; i8++) {
                if (drawableArr[i8].getConstantState() == null) {
                    this.f980w = false;
                    return false;
                }
            }
            this.f980w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @t0(21)
        public boolean canApplyTheme() {
            int i7 = this.f965h;
            Drawable[] drawableArr = this.f964g;
            for (int i8 = 0; i8 < i7; i8++) {
                Drawable drawable = drawableArr[i8];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f963f.get(i8);
                    if (constantState != null && C0022b.a(constantState)) {
                        return true;
                    }
                } else if (androidx.core.graphics.drawable.d.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        final void d() {
            this.f982y = false;
        }

        protected void e() {
            this.f970m = true;
            f();
            int i7 = this.f965h;
            Drawable[] drawableArr = this.f964g;
            this.f972o = -1;
            this.f971n = -1;
            this.f974q = 0;
            this.f973p = 0;
            for (int i8 = 0; i8 < i7; i8++) {
                Drawable drawable = drawableArr[i8];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f971n) {
                    this.f971n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f972o) {
                    this.f972o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f973p) {
                    this.f973p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f974q) {
                    this.f974q = minimumHeight;
                }
            }
        }

        final int g() {
            return this.f964g.length;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f961d | this.f962e;
        }

        public final Drawable h(int i7) {
            int iIndexOfKey;
            Drawable drawable = this.f964g[i7];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f963f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i7)) < 0) {
                return null;
            }
            Drawable drawableW = w(this.f963f.valueAt(iIndexOfKey).newDrawable(this.f959b));
            this.f964g[i7] = drawableW;
            this.f963f.removeAt(iIndexOfKey);
            if (this.f963f.size() == 0) {
                this.f963f = null;
            }
            return drawableW;
        }

        public final int i() {
            return this.f965h;
        }

        public final int j() {
            if (!this.f970m) {
                e();
            }
            return this.f972o;
        }

        public final int k() {
            if (!this.f970m) {
                e();
            }
            return this.f974q;
        }

        public final int l() {
            if (!this.f970m) {
                e();
            }
            return this.f973p;
        }

        public final Rect m() {
            Rect rect = null;
            if (this.f966i) {
                return null;
            }
            Rect rect2 = this.f968k;
            if (rect2 != null || this.f967j) {
                return rect2;
            }
            f();
            Rect rect3 = new Rect();
            int i7 = this.f965h;
            Drawable[] drawableArr = this.f964g;
            for (int i8 = 0; i8 < i7; i8++) {
                if (drawableArr[i8].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i9 = rect3.left;
                    if (i9 > rect.left) {
                        rect.left = i9;
                    }
                    int i10 = rect3.top;
                    if (i10 > rect.top) {
                        rect.top = i10;
                    }
                    int i11 = rect3.right;
                    if (i11 > rect.right) {
                        rect.right = i11;
                    }
                    int i12 = rect3.bottom;
                    if (i12 > rect.bottom) {
                        rect.bottom = i12;
                    }
                }
            }
            this.f967j = true;
            this.f968k = rect;
            return rect;
        }

        public final int n() {
            if (!this.f970m) {
                e();
            }
            return this.f971n;
        }

        public final int o() {
            return this.A;
        }

        public final int p() {
            return this.B;
        }

        public final int q() {
            if (this.f975r) {
                return this.f976s;
            }
            f();
            int i7 = this.f965h;
            Drawable[] drawableArr = this.f964g;
            int opacity = i7 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i8 = 1; i8 < i7; i8++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i8].getOpacity());
            }
            this.f976s = opacity;
            this.f975r = true;
            return opacity;
        }

        public void r(int i7, int i8) {
            Drawable[] drawableArr = new Drawable[i8];
            Drawable[] drawableArr2 = this.f964g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i7);
            }
            this.f964g = drawableArr;
        }

        void s() {
            this.f975r = false;
            this.f977t = false;
        }

        public final boolean t() {
            return this.f969l;
        }

        public final boolean u() {
            if (this.f977t) {
                return this.f978u;
            }
            f();
            int i7 = this.f965h;
            Drawable[] drawableArr = this.f964g;
            boolean z7 = false;
            for (int i8 = 0; i8 < i7; i8++) {
                if (drawableArr[i8].isStateful()) {
                    z7 = true;
                    break;
                }
            }
            this.f978u = z7;
            this.f977t = true;
            return z7;
        }

        void v() {
            int i7 = this.f965h;
            Drawable[] drawableArr = this.f964g;
            for (int i8 = 0; i8 < i7; i8++) {
                Drawable drawable = drawableArr[i8];
                if (drawable != null) {
                    drawable.mutate();
                }
            }
            this.f982y = true;
        }

        public final void x(boolean z7) {
            this.f969l = z7;
        }

        public final void y(int i7) {
            this.A = i7;
        }

        public final void z(int i7) {
            this.B = i7;
        }
    }

    b() {
    }

    private void e(Drawable drawable) {
        if (this.f955l == null) {
            this.f955l = new c();
        }
        drawable.setCallback(this.f955l.b(drawable.getCallback()));
        try {
            if (this.f944a.A <= 0 && this.f949f) {
                drawable.setAlpha(this.f948e);
            }
            d dVar = this.f944a;
            if (dVar.E) {
                drawable.setColorFilter(dVar.D);
            } else {
                if (dVar.H) {
                    androidx.core.graphics.drawable.d.o(drawable, dVar.F);
                }
                d dVar2 = this.f944a;
                if (dVar2.I) {
                    androidx.core.graphics.drawable.d.p(drawable, dVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f944a.f981x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            androidx.core.graphics.drawable.d.m(drawable, androidx.core.graphics.drawable.d.f(this));
            androidx.core.graphics.drawable.d.j(drawable, this.f944a.C);
            Rect rect = this.f945b;
            if (rect != null) {
                androidx.core.graphics.drawable.d.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f955l.a());
        }
    }

    private boolean f() {
        return isAutoMirrored() && androidx.core.graphics.drawable.d.f(this) == 1;
    }

    static int g(@o0 Resources resources, int i7) {
        if (resources != null) {
            i7 = resources.getDisplayMetrics().densityDpi;
        }
        if (i7 == 0) {
            return 160;
        }
        return i7;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003d  */
    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    /* JADX WARN: Code duplicated, block: B:18:0x0047  */
    /* JADX WARN: Code duplicated, block: B:19:0x0050  */
    /* JADX WARN: Code duplicated, block: B:20:0x0061  */
    /* JADX WARN: Code duplicated, block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    void a(boolean z7) {
        boolean z8;
        Drawable drawable;
        long j7;
        boolean z9 = true;
        this.f949f = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f946c;
        if (drawable2 != null) {
            long j8 = this.f953j;
            if (j8 != 0) {
                if (j8 <= jUptimeMillis) {
                    drawable2.setAlpha(this.f948e);
                    this.f953j = 0L;
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j8 - jUptimeMillis) * 255)) / this.f944a.A)) * this.f948e) / 255);
                    z8 = true;
                }
            }
            drawable = this.f947d;
            if (drawable != null) {
                j7 = this.f954k;
                if (j7 == 0) {
                    if (j7 <= jUptimeMillis) {
                        drawable.setVisible(false, false);
                        this.f947d = null;
                        this.f954k = 0L;
                    } else {
                        drawable.setAlpha(((((int) ((j7 - jUptimeMillis) * 255)) / this.f944a.B) * this.f948e) / 255);
                    }
                }
                if (z7 || !z9) {
                }
                scheduleSelf(this.f952i, jUptimeMillis + 16);
                return;
            }
            this.f954k = 0L;
            z9 = z8;
            if (z7) {
            }
        }
        this.f953j = 0L;
        z8 = false;
        drawable = this.f947d;
        if (drawable != null) {
            j7 = this.f954k;
            if (j7 == 0) {
                if (j7 <= jUptimeMillis) {
                    drawable.setVisible(false, false);
                    this.f947d = null;
                    this.f954k = 0L;
                } else {
                    drawable.setAlpha(((((int) ((j7 - jUptimeMillis) * 255)) / this.f944a.B) * this.f948e) / 255);
                }
            }
            if (z7) {
            }
        }
        this.f954k = 0L;
        z9 = z8;
        if (z7) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    @t0(21)
    public void applyTheme(@m0 Resources.Theme theme) {
        this.f944a.b(theme);
    }

    void b() {
        this.f944a.d();
        this.f951h = false;
    }

    d c() {
        return this.f944a;
    }

    @Override // android.graphics.drawable.Drawable
    @t0(21)
    public boolean canApplyTheme() {
        return this.f944a.canApplyTheme();
    }

    int d() {
        return this.f950g;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        Drawable drawable = this.f946c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f947d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f948e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f944a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f944a.c()) {
            return null;
        }
        this.f944a.f961d = getChangingConfigurations();
        return this.f944a;
    }

    @Override // android.graphics.drawable.Drawable
    @m0
    public Drawable getCurrent() {
        return this.f946c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@m0 Rect rect) {
        Rect rect2 = this.f945b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f944a.t()) {
            return this.f944a.j();
        }
        Drawable drawable = this.f946c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f944a.t()) {
            return this.f944a.n();
        }
        Drawable drawable = this.f946c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f944a.t()) {
            return this.f944a.k();
        }
        Drawable drawable = this.f946c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f944a.t()) {
            return this.f944a.l();
        }
        Drawable drawable = this.f946c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f946c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f944a.q();
    }

    @Override // android.graphics.drawable.Drawable
    @t0(21)
    public void getOutline(@m0 Outline outline) {
        Drawable drawable = this.f946c;
        if (drawable != null) {
            C0022b.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@m0 Rect rect) {
        boolean padding;
        Rect rectM = this.f944a.m();
        if (rectM != null) {
            rect.set(rectM);
            padding = (rectM.right | ((rectM.left | rectM.top) | rectM.bottom)) != 0;
        } else {
            Drawable drawable = this.f946c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (f()) {
            int i7 = rect.left;
            rect.left = rect.right;
            rect.right = i7;
        }
        return padding;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    boolean h(int i7) {
        if (i7 == this.f950g) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f944a.B > 0) {
            Drawable drawable = this.f947d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f946c;
            if (drawable2 != null) {
                this.f947d = drawable2;
                this.f954k = ((long) this.f944a.B) + jUptimeMillis;
            } else {
                this.f947d = null;
                this.f954k = 0L;
            }
        } else {
            Drawable drawable3 = this.f946c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i7 >= 0) {
            d dVar = this.f944a;
            if (i7 < dVar.f965h) {
                Drawable drawableH = dVar.h(i7);
                this.f946c = drawableH;
                this.f950g = i7;
                if (drawableH != null) {
                    int i8 = this.f944a.A;
                    if (i8 > 0) {
                        this.f953j = jUptimeMillis + ((long) i8);
                    }
                    e(drawableH);
                }
            } else {
                this.f946c = null;
                this.f950g = -1;
            }
        } else {
            this.f946c = null;
            this.f950g = -1;
        }
        if (this.f953j != 0 || this.f954k != 0) {
            Runnable runnable = this.f952i;
            if (runnable == null) {
                this.f952i = new a();
            } else {
                unscheduleSelf(runnable);
            }
            a(true);
        }
        invalidateSelf();
        return true;
    }

    void i(d dVar) {
        this.f944a = dVar;
        int i7 = this.f950g;
        if (i7 >= 0) {
            Drawable drawableH = dVar.h(i7);
            this.f946c = drawableH;
            if (drawableH != null) {
                e(drawableH);
            }
        }
        this.f947d = null;
    }

    public void invalidateDrawable(@m0 Drawable drawable) {
        d dVar = this.f944a;
        if (dVar != null) {
            dVar.s();
        }
        if (drawable != this.f946c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f944a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f944a.u();
    }

    void j(int i7) {
        h(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z7;
        Drawable drawable = this.f947d;
        boolean z8 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f947d = null;
            z7 = true;
        } else {
            z7 = false;
        }
        Drawable drawable2 = this.f946c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f949f) {
                this.f946c.setAlpha(this.f948e);
            }
        }
        if (this.f954k != 0) {
            this.f954k = 0L;
            z7 = true;
        }
        if (this.f953j != 0) {
            this.f953j = 0L;
        } else {
            z8 = z7;
        }
        if (z8) {
            invalidateSelf();
        }
    }

    public void k(int i7) {
        this.f944a.A = i7;
    }

    public void l(int i7) {
        this.f944a.B = i7;
    }

    final void m(Resources resources) {
        this.f944a.C(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f951h && super.mutate() == this) {
            d dVarC = c();
            dVarC.v();
            i(dVarC);
            this.f951h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f947d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f946c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i7) {
        return this.f944a.A(i7, d());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i7) {
        Drawable drawable = this.f947d;
        if (drawable != null) {
            return drawable.setLevel(i7);
        }
        Drawable drawable2 = this.f946c;
        if (drawable2 != null) {
            return drawable2.setLevel(i7);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@m0 int[] iArr) {
        Drawable drawable = this.f947d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f946c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable, long j7) {
        if (drawable != this.f946c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        if (this.f949f && this.f948e == i7) {
            return;
        }
        this.f949f = true;
        this.f948e = i7;
        Drawable drawable = this.f946c;
        if (drawable != null) {
            if (this.f953j == 0) {
                drawable.setAlpha(i7);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z7) {
        d dVar = this.f944a;
        if (dVar.C != z7) {
            dVar.C = z7;
            Drawable drawable = this.f946c;
            if (drawable != null) {
                androidx.core.graphics.drawable.d.j(drawable, z7);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f944a;
        dVar.E = true;
        if (dVar.D != colorFilter) {
            dVar.D = colorFilter;
            Drawable drawable = this.f946c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z7) {
        d dVar = this.f944a;
        if (dVar.f981x != z7) {
            dVar.f981x = z7;
            Drawable drawable = this.f946c;
            if (drawable != null) {
                drawable.setDither(z7);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f8, float f9) {
        Drawable drawable = this.f946c;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.k(drawable, f8, f9);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i7, int i8, int i9, int i10) {
        Rect rect = this.f945b;
        if (rect == null) {
            this.f945b = new Rect(i7, i8, i9, i10);
        } else {
            rect.set(i7, i8, i9, i10);
        }
        Drawable drawable = this.f946c;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.l(drawable, i7, i8, i9, i10);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTint(@l int i7) {
        setTintList(ColorStateList.valueOf(i7));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f944a;
        dVar.H = true;
        if (dVar.F != colorStateList) {
            dVar.F = colorStateList;
            androidx.core.graphics.drawable.d.o(this.f946c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintMode(@m0 PorterDuff.Mode mode) {
        d dVar = this.f944a;
        dVar.I = true;
        if (dVar.G != mode) {
            dVar.G = mode;
            androidx.core.graphics.drawable.d.p(this.f946c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        boolean visible = super.setVisible(z7, z8);
        Drawable drawable = this.f947d;
        if (drawable != null) {
            drawable.setVisible(z7, z8);
        }
        Drawable drawable2 = this.f946c;
        if (drawable2 != null) {
            drawable2.setVisible(z7, z8);
        }
        return visible;
    }

    public void unscheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable) {
        if (drawable != this.f946c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
