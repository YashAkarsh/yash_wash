package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.view.n0;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class a {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private static final String f17756k0 = "CollapsingTextHelper";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private static final String f17757l0 = "…";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private static final float f17758m0 = 0.5f;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private static final boolean f17759n0 = false;
    private com.google.android.material.resources.a A;

    @o0
    private CharSequence B;

    @o0
    private CharSequence C;
    private boolean D;
    private boolean F;

    @o0
    private Bitmap G;
    private Paint H;
    private float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f17761J;
    private int[] K;
    private boolean L;

    @m0
    private final TextPaint M;

    @m0
    private final TextPaint N;
    private TimeInterpolator O;
    private TimeInterpolator P;
    private float Q;
    private float R;
    private float S;
    private ColorStateList T;
    private float U;
    private float V;
    private float W;
    private ColorStateList X;
    private float Y;
    private float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f17762a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private StaticLayout f17763a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f17764b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f17765b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f17766c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private float f17767c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17768d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f17769d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f17770e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private CharSequence f17771e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f17772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17774g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @m0
    private final Rect f17776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @m0
    private final Rect f17778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @m0
    private final RectF f17780j;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ColorStateList f17785o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ColorStateList f17786p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f17787q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f17788r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f17789s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f17790t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f17791u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f17792v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Typeface f17793w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Typeface f17794x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Typeface f17795y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private com.google.android.material.resources.a f17796z;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final boolean f17755j0 = false;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @m0
    private static final Paint f17760o0 = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f17781k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f17782l = 16;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f17783m = 15.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f17784n = 15.0f;
    private boolean E = true;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f17773f0 = 1;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private float f17775g0 = 0.0f;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f17777h0 = 1.0f;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private int f17779i0 = j.f17852n;

    /* JADX INFO: renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    class C0199a implements com.google.android.material.resources.a.InterfaceC0202a {
        C0199a() {
        }

        @Override // com.google.android.material.resources.a.InterfaceC0202a
        public void a(Typeface typeface) {
            a.this.i0(typeface);
        }
    }

    class b implements com.google.android.material.resources.a.InterfaceC0202a {
        b() {
        }

        @Override // com.google.android.material.resources.a.InterfaceC0202a
        public void a(Typeface typeface) {
            a.this.s0(typeface);
        }
    }

    public a(View view) {
        this.f17762a = view;
        TextPaint textPaint = new TextPaint(129);
        this.M = textPaint;
        this.N = new TextPaint(textPaint);
        this.f17778i = new Rect();
        this.f17776h = new Rect();
        this.f17780j = new RectF();
        this.f17772f = f();
    }

    private boolean I0() {
        return this.f17773f0 > 1 && (!this.D || this.f17768d) && !this.F;
    }

    private void O(@m0 TextPaint textPaint) {
        textPaint.setTextSize(this.f17784n);
        textPaint.setTypeface(this.f17793w);
        textPaint.setLetterSpacing(this.Y);
    }

    private void P(@m0 TextPaint textPaint) {
        textPaint.setTextSize(this.f17783m);
        textPaint.setTypeface(this.f17794x);
        textPaint.setLetterSpacing(this.Z);
    }

    private void Q(float f8) {
        if (this.f17768d) {
            this.f17780j.set(f8 < this.f17772f ? this.f17776h : this.f17778i);
            return;
        }
        this.f17780j.left = W(this.f17776h.left, this.f17778i.left, f8, this.O);
        this.f17780j.top = W(this.f17787q, this.f17788r, f8, this.O);
        this.f17780j.right = W(this.f17776h.right, this.f17778i.right, f8, this.O);
        this.f17780j.bottom = W(this.f17776h.bottom, this.f17778i.bottom, f8, this.O);
    }

    private static boolean R(float f8, float f9) {
        return Math.abs(f8 - f9) < 0.001f;
    }

    private boolean S() {
        return n2.Z(this.f17762a) == 1;
    }

    private boolean V(@m0 CharSequence charSequence, boolean z7) {
        return (z7 ? androidx.core.text.o0.f6283d : androidx.core.text.o0.f6282c).b(charSequence, 0, charSequence.length());
    }

    private static float W(float f8, float f9, float f10, @o0 TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f10 = timeInterpolator.getInterpolation(f10);
        }
        return com.google.android.material.animation.a.a(f8, f9, f10);
    }

    private static int a(int i7, int i8, float f8) {
        float f9 = 1.0f - f8;
        return Color.argb((int) ((Color.alpha(i7) * f9) + (Color.alpha(i8) * f8)), (int) ((Color.red(i7) * f9) + (Color.red(i8) * f8)), (int) ((Color.green(i7) * f9) + (Color.green(i8) * f8)), (int) ((Color.blue(i7) * f9) + (Color.blue(i8) * f8)));
    }

    private static boolean a0(@m0 Rect rect, int i7, int i8, int i9, int i10) {
        return rect.left == i7 && rect.top == i8 && rect.right == i9 && rect.bottom == i10;
    }

    private void b(boolean z7) {
        StaticLayout staticLayout;
        float f8 = this.f17761J;
        j(this.f17784n, z7);
        CharSequence charSequence = this.C;
        if (charSequence != null && (staticLayout = this.f17763a0) != null) {
            this.f17771e0 = TextUtils.ellipsize(charSequence, this.M, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.f17771e0;
        float lineStart = 0.0f;
        float fMeasureText = charSequence2 != null ? this.M.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int iD = n0.d(this.f17782l, this.D ? 1 : 0);
        int i7 = iD & 112;
        if (i7 == 48) {
            this.f17788r = this.f17778i.top;
        } else if (i7 != 80) {
            this.f17788r = this.f17778i.centerY() - ((this.M.descent() - this.M.ascent()) / 2.0f);
        } else {
            this.f17788r = this.f17778i.bottom + this.M.ascent();
        }
        int i8 = iD & n0.f6719d;
        if (i8 == 1) {
            this.f17790t = this.f17778i.centerX() - (fMeasureText / 2.0f);
        } else if (i8 != 5) {
            this.f17790t = this.f17778i.left;
        } else {
            this.f17790t = this.f17778i.right - fMeasureText;
        }
        j(this.f17783m, z7);
        StaticLayout staticLayout2 = this.f17763a0;
        float height = staticLayout2 != null ? staticLayout2.getHeight() : 0.0f;
        CharSequence charSequence3 = this.C;
        float fMeasureText2 = charSequence3 != null ? this.M.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout3 = this.f17763a0;
        if (staticLayout3 != null && this.f17773f0 > 1) {
            fMeasureText2 = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.f17763a0;
        if (staticLayout4 != null) {
            lineStart = this.f17773f0 > 1 ? staticLayout4.getLineStart(0) : staticLayout4.getLineLeft(0);
        }
        this.f17769d0 = lineStart;
        int iD2 = n0.d(this.f17781k, this.D ? 1 : 0);
        int i9 = iD2 & 112;
        if (i9 == 48) {
            this.f17787q = this.f17776h.top;
        } else if (i9 != 80) {
            this.f17787q = this.f17776h.centerY() - (height / 2.0f);
        } else {
            this.f17787q = (this.f17776h.bottom - height) + this.M.descent();
        }
        int i10 = iD2 & n0.f6719d;
        if (i10 == 1) {
            this.f17789s = this.f17776h.centerX() - (fMeasureText2 / 2.0f);
        } else if (i10 != 5) {
            this.f17789s = this.f17776h.left;
        } else {
            this.f17789s = this.f17776h.right - fMeasureText2;
        }
        k();
        y0(f8);
    }

    private void d() {
        h(this.f17766c);
    }

    private float e(@c.v(from = 0.0d, to = 1.0d) float f8) {
        float f9 = this.f17772f;
        return f8 <= f9 ? com.google.android.material.animation.a.b(1.0f, 0.0f, this.f17770e, f9, f8) : com.google.android.material.animation.a.b(0.0f, 1.0f, f9, 1.0f, f8);
    }

    private void e0(float f8) {
        this.f17765b0 = f8;
        n2.n1(this.f17762a);
    }

    private float f() {
        float f8 = this.f17770e;
        return f8 + ((1.0f - f8) * 0.5f);
    }

    private boolean g(@m0 CharSequence charSequence) {
        boolean zS = S();
        return this.E ? V(charSequence, zS) : zS;
    }

    private void h(float f8) {
        float f9;
        Q(f8);
        if (!this.f17768d) {
            this.f17791u = W(this.f17789s, this.f17790t, f8, this.O);
            this.f17792v = W(this.f17787q, this.f17788r, f8, this.O);
            y0(W(this.f17783m, this.f17784n, f8, this.P));
            f9 = f8;
        } else if (f8 < this.f17772f) {
            this.f17791u = this.f17789s;
            this.f17792v = this.f17787q;
            y0(this.f17783m);
            f9 = 0.0f;
        } else {
            this.f17791u = this.f17790t;
            this.f17792v = this.f17788r - Math.max(0, this.f17774g);
            y0(this.f17784n);
            f9 = 1.0f;
        }
        TimeInterpolator timeInterpolator = com.google.android.material.animation.a.f16847b;
        e0(1.0f - W(0.0f, 1.0f, 1.0f - f8, timeInterpolator));
        o0(W(1.0f, 0.0f, f8, timeInterpolator));
        if (this.f17786p != this.f17785o) {
            this.M.setColor(a(z(), x(), f9));
        } else {
            this.M.setColor(x());
        }
        float f10 = this.Y;
        float f11 = this.Z;
        if (f10 != f11) {
            this.M.setLetterSpacing(W(f11, f10, f8, timeInterpolator));
        } else {
            this.M.setLetterSpacing(f10);
        }
        this.M.setShadowLayer(W(this.U, this.Q, f8, null), W(this.V, this.R, f8, null), W(this.W, this.S, f8, null), a(y(this.X), y(this.T), f8));
        if (this.f17768d) {
            this.M.setAlpha((int) (e(f8) * 255.0f));
        }
        n2.n1(this.f17762a);
    }

    private void i(float f8) {
        j(f8, false);
    }

    private void j(float f8, boolean z7) {
        boolean z8;
        float f9;
        boolean z9;
        if (this.B == null) {
            return;
        }
        float fWidth = this.f17778i.width();
        float fWidth2 = this.f17776h.width();
        if (R(f8, this.f17784n)) {
            f9 = this.f17784n;
            this.I = 1.0f;
            Typeface typeface = this.f17795y;
            Typeface typeface2 = this.f17793w;
            if (typeface != typeface2) {
                this.f17795y = typeface2;
                z9 = true;
            } else {
                z9 = false;
            }
        } else {
            float f10 = this.f17783m;
            Typeface typeface3 = this.f17795y;
            Typeface typeface4 = this.f17794x;
            if (typeface3 != typeface4) {
                this.f17795y = typeface4;
                z8 = true;
            } else {
                z8 = false;
            }
            if (R(f8, f10)) {
                this.I = 1.0f;
            } else {
                this.I = f8 / this.f17783m;
            }
            float f11 = this.f17784n / this.f17783m;
            fWidth = (!z7 && fWidth2 * f11 > fWidth) ? Math.min(fWidth / f11, fWidth2) : fWidth2;
            f9 = f10;
            z9 = z8;
        }
        if (fWidth > 0.0f) {
            z9 = this.f17761J != f9 || this.L || z9;
            this.f17761J = f9;
            this.L = false;
        }
        if (this.C == null || z9) {
            this.M.setTextSize(this.f17761J);
            this.M.setTypeface(this.f17795y);
            this.M.setLinearText(this.I != 1.0f);
            this.D = g(this.B);
            StaticLayout staticLayoutL = l(I0() ? this.f17773f0 : 1, fWidth, this.D);
            this.f17763a0 = staticLayoutL;
            this.C = staticLayoutL.getText();
        }
    }

    private boolean j0(Typeface typeface) {
        com.google.android.material.resources.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f17793w == typeface) {
            return false;
        }
        this.f17793w = typeface;
        return true;
    }

    private void k() {
        Bitmap bitmap = this.G;
        if (bitmap != null) {
            bitmap.recycle();
            this.G = null;
        }
    }

    private StaticLayout l(int i7, float f8, boolean z7) {
        StaticLayout staticLayoutA;
        try {
            staticLayoutA = j.c(this.B, this.M, (int) f8).e(TextUtils.TruncateAt.END).i(z7).d(Layout.Alignment.ALIGN_NORMAL).h(false).k(i7).j(this.f17775g0, this.f17777h0).g(this.f17779i0).a();
        } catch (j.a e8) {
            Log.e(f17756k0, e8.getCause().getMessage(), e8);
            staticLayoutA = null;
        }
        return (StaticLayout) androidx.core.util.w.l(staticLayoutA);
    }

    private void n(@m0 Canvas canvas, float f8, float f9) {
        int alpha = this.M.getAlpha();
        canvas.translate(f8, f9);
        float f10 = alpha;
        this.M.setAlpha((int) (this.f17767c0 * f10));
        this.f17763a0.draw(canvas);
        this.M.setAlpha((int) (this.f17765b0 * f10));
        int lineBaseline = this.f17763a0.getLineBaseline(0);
        CharSequence charSequence = this.f17771e0;
        float f11 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f11, this.M);
        if (this.f17768d) {
            return;
        }
        String strTrim = this.f17771e0.toString().trim();
        if (strTrim.endsWith(f17757l0)) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.M.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f17763a0.getLineEnd(0), str.length()), 0.0f, f11, (Paint) this.M);
    }

    private void o() {
        if (this.G != null || this.f17776h.isEmpty() || TextUtils.isEmpty(this.C)) {
            return;
        }
        h(0.0f);
        int width = this.f17763a0.getWidth();
        int height = this.f17763a0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.G = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f17763a0.draw(new Canvas(this.G));
        if (this.H == null) {
            this.H = new Paint(3);
        }
    }

    private void o0(float f8) {
        this.f17767c0 = f8;
        n2.n1(this.f17762a);
    }

    private float t(int i7, int i8) {
        if (i8 == 17 || (i8 & 7) == 1) {
            return (i7 / 2.0f) - (c() / 2.0f);
        }
        if ((i8 & n0.f6718c) == 8388613 || (i8 & 5) == 5) {
            return this.D ? this.f17778i.left : this.f17778i.right - c();
        }
        return this.D ? this.f17778i.right - c() : this.f17778i.left;
    }

    private boolean t0(Typeface typeface) {
        com.google.android.material.resources.a aVar = this.f17796z;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f17794x == typeface) {
            return false;
        }
        this.f17794x = typeface;
        return true;
    }

    private float u(@m0 RectF rectF, int i7, int i8) {
        if (i8 == 17 || (i8 & 7) == 1) {
            return (i7 / 2.0f) + (c() / 2.0f);
        }
        if ((i8 & n0.f6718c) == 8388613 || (i8 & 5) == 5) {
            return this.D ? rectF.left + c() : this.f17778i.right;
        }
        return this.D ? this.f17778i.right : rectF.left + c();
    }

    @c.l
    private int y(@o0 ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.K;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private void y0(float f8) {
        i(f8);
        boolean z7 = f17755j0 && this.I != 1.0f;
        this.F = z7;
        if (z7) {
            o();
        }
        n2.n1(this.f17762a);
    }

    @c.l
    private int z() {
        return y(this.f17785o);
    }

    public ColorStateList A() {
        return this.f17785o;
    }

    @t0(23)
    public void A0(@c.v(from = 0.0d) float f8) {
        this.f17777h0 = f8;
    }

    public float B() {
        P(this.N);
        return (-this.N.ascent()) + this.N.descent();
    }

    public void B0(int i7) {
        if (i7 != this.f17773f0) {
            this.f17773f0 = i7;
            k();
            Y();
        }
    }

    public int C() {
        return this.f17781k;
    }

    public void C0(TimeInterpolator timeInterpolator) {
        this.O = timeInterpolator;
        Y();
    }

    public float D() {
        P(this.N);
        return -this.N.ascent();
    }

    public void D0(boolean z7) {
        this.E = z7;
    }

    public float E() {
        return this.f17783m;
    }

    public final boolean E0(int[] iArr) {
        this.K = iArr;
        if (!U()) {
            return false;
        }
        Y();
        return true;
    }

    public Typeface F() {
        Typeface typeface = this.f17794x;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void F0(@o0 CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.B, charSequence)) {
            this.B = charSequence;
            this.C = null;
            k();
            Y();
        }
    }

    public float G() {
        return this.f17766c;
    }

    public void G0(TimeInterpolator timeInterpolator) {
        this.P = timeInterpolator;
        Y();
    }

    public float H() {
        return this.f17772f;
    }

    public void H0(Typeface typeface) {
        boolean zJ0 = j0(typeface);
        boolean zT0 = t0(typeface);
        if (zJ0 || zT0) {
            Y();
        }
    }

    @t0(23)
    public int I() {
        return this.f17779i0;
    }

    public int J() {
        StaticLayout staticLayout = this.f17763a0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    @t0(23)
    public float K() {
        return this.f17763a0.getSpacingAdd();
    }

    @t0(23)
    public float L() {
        return this.f17763a0.getSpacingMultiplier();
    }

    public int M() {
        return this.f17773f0;
    }

    @o0
    public CharSequence N() {
        return this.B;
    }

    public boolean T() {
        return this.E;
    }

    public final boolean U() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f17786p;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f17785o) != null && colorStateList.isStateful());
    }

    void X() {
        this.f17764b = this.f17778i.width() > 0 && this.f17778i.height() > 0 && this.f17776h.width() > 0 && this.f17776h.height() > 0;
    }

    public void Y() {
        Z(false);
    }

    public void Z(boolean z7) {
        if ((this.f17762a.getHeight() <= 0 || this.f17762a.getWidth() <= 0) && !z7) {
            return;
        }
        b(z7);
        d();
    }

    public void b0(int i7, int i8, int i9, int i10) {
        if (a0(this.f17778i, i7, i8, i9, i10)) {
            return;
        }
        this.f17778i.set(i7, i8, i9, i10);
        this.L = true;
        X();
    }

    public float c() {
        if (this.B == null) {
            return 0.0f;
        }
        O(this.N);
        TextPaint textPaint = this.N;
        CharSequence charSequence = this.B;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void c0(@m0 Rect rect) {
        b0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void d0(int i7) {
        com.google.android.material.resources.d dVar = new com.google.android.material.resources.d(this.f17762a.getContext(), i7);
        ColorStateList colorStateList = dVar.f18138a;
        if (colorStateList != null) {
            this.f17786p = colorStateList;
        }
        float f8 = dVar.f18151n;
        if (f8 != 0.0f) {
            this.f17784n = f8;
        }
        ColorStateList colorStateList2 = dVar.f18141d;
        if (colorStateList2 != null) {
            this.T = colorStateList2;
        }
        this.R = dVar.f18146i;
        this.S = dVar.f18147j;
        this.Q = dVar.f18148k;
        this.Y = dVar.f18150m;
        com.google.android.material.resources.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        this.A = new com.google.android.material.resources.a(new C0199a(), dVar.e());
        dVar.h(this.f17762a.getContext(), this.A);
        Y();
    }

    public void f0(ColorStateList colorStateList) {
        if (this.f17786p != colorStateList) {
            this.f17786p = colorStateList;
            Y();
        }
    }

    public void g0(int i7) {
        if (this.f17782l != i7) {
            this.f17782l = i7;
            Y();
        }
    }

    public void h0(float f8) {
        if (this.f17784n != f8) {
            this.f17784n = f8;
            Y();
        }
    }

    public void i0(Typeface typeface) {
        if (j0(typeface)) {
            Y();
        }
    }

    public void k0(int i7) {
        this.f17774g = i7;
    }

    public void l0(int i7, int i8, int i9, int i10) {
        if (a0(this.f17776h, i7, i8, i9, i10)) {
            return;
        }
        this.f17776h.set(i7, i8, i9, i10);
        this.L = true;
        X();
    }

    public void m(@m0 Canvas canvas) {
        int iSave = canvas.save();
        if (this.C == null || !this.f17764b) {
            return;
        }
        float lineStart = (this.f17791u + (this.f17773f0 > 1 ? this.f17763a0.getLineStart(0) : this.f17763a0.getLineLeft(0))) - (this.f17769d0 * 2.0f);
        this.M.setTextSize(this.f17761J);
        float f8 = this.f17791u;
        float f9 = this.f17792v;
        boolean z7 = this.F && this.G != null;
        float f10 = this.I;
        if (f10 != 1.0f && !this.f17768d) {
            canvas.scale(f10, f10, f8, f9);
        }
        if (z7) {
            canvas.drawBitmap(this.G, f8, f9, this.H);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!I0() || (this.f17768d && this.f17766c <= this.f17772f)) {
            canvas.translate(f8, f9);
            this.f17763a0.draw(canvas);
        } else {
            n(canvas, lineStart, f9);
        }
        canvas.restoreToCount(iSave);
    }

    public void m0(@m0 Rect rect) {
        l0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void n0(int i7) {
        com.google.android.material.resources.d dVar = new com.google.android.material.resources.d(this.f17762a.getContext(), i7);
        ColorStateList colorStateList = dVar.f18138a;
        if (colorStateList != null) {
            this.f17785o = colorStateList;
        }
        float f8 = dVar.f18151n;
        if (f8 != 0.0f) {
            this.f17783m = f8;
        }
        ColorStateList colorStateList2 = dVar.f18141d;
        if (colorStateList2 != null) {
            this.X = colorStateList2;
        }
        this.V = dVar.f18146i;
        this.W = dVar.f18147j;
        this.U = dVar.f18148k;
        this.Z = dVar.f18150m;
        com.google.android.material.resources.a aVar = this.f17796z;
        if (aVar != null) {
            aVar.c();
        }
        this.f17796z = new com.google.android.material.resources.a(new b(), dVar.e());
        dVar.h(this.f17762a.getContext(), this.f17796z);
        Y();
    }

    public void p(@m0 RectF rectF, int i7, int i8) {
        this.D = g(this.B);
        rectF.left = t(i7, i8);
        rectF.top = this.f17778i.top;
        rectF.right = u(rectF, i7, i8);
        rectF.bottom = this.f17778i.top + s();
    }

    public void p0(ColorStateList colorStateList) {
        if (this.f17785o != colorStateList) {
            this.f17785o = colorStateList;
            Y();
        }
    }

    public ColorStateList q() {
        return this.f17786p;
    }

    public void q0(int i7) {
        if (this.f17781k != i7) {
            this.f17781k = i7;
            Y();
        }
    }

    public int r() {
        return this.f17782l;
    }

    public void r0(float f8) {
        if (this.f17783m != f8) {
            this.f17783m = f8;
            Y();
        }
    }

    public float s() {
        O(this.N);
        return -this.N.ascent();
    }

    public void s0(Typeface typeface) {
        if (t0(typeface)) {
            Y();
        }
    }

    public void u0(float f8) {
        float fD = m.a.d(f8, 0.0f, 1.0f);
        if (fD != this.f17766c) {
            this.f17766c = fD;
            d();
        }
    }

    public float v() {
        return this.f17784n;
    }

    public void v0(boolean z7) {
        this.f17768d = z7;
    }

    public Typeface w() {
        Typeface typeface = this.f17793w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void w0(float f8) {
        this.f17770e = f8;
        this.f17772f = f();
    }

    @c.l
    public int x() {
        return y(this.f17786p);
    }

    @t0(23)
    public void x0(int i7) {
        this.f17779i0 = i7;
    }

    @t0(23)
    public void z0(float f8) {
        this.f17775g0 = f8;
    }
}
