package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import c.b1;
import c.e0;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class j extends Drawable implements androidx.core.graphics.drawable.r, s {
    public static final int A = 1;
    public static final int B = 2;
    private static final Paint C = new Paint(1);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f18227w = "j";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final float f18228x = 0.75f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final float f18229y = 0.25f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f18230z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f18231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q.i[] f18232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q.i[] f18233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BitSet f18234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Matrix f18236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f18237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Path f18238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RectF f18239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f18240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Region f18241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Region f18242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private o f18243m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Paint f18244n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Paint f18245o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final com.google.android.material.shadow.b f18246p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @m0
    private final p.b f18247q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final p f18248r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @o0
    private PorterDuffColorFilter f18249s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @o0
    private PorterDuffColorFilter f18250t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @m0
    private final RectF f18251u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f18252v;

    class a implements p.b {
        a() {
        }

        @Override // com.google.android.material.shape.p.b
        public void a(@m0 q qVar, Matrix matrix, int i7) {
            j.this.f18234d.set(i7, qVar.e());
            j.this.f18232b[i7] = qVar.f(matrix);
        }

        @Override // com.google.android.material.shape.p.b
        public void b(@m0 q qVar, Matrix matrix, int i7) {
            j.this.f18234d.set(i7 + 4, qVar.e());
            j.this.f18233c[i7] = qVar.f(matrix);
        }
    }

    class b implements o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f18254a;

        b(float f8) {
            this.f18254a = f8;
        }

        @Override // com.google.android.material.shape.o.c
        @m0
        public com.google.android.material.shape.d a(@m0 com.google.android.material.shape.d dVar) {
            return dVar instanceof m ? dVar : new com.google.android.material.shape.b(this.f18254a, dVar);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    /* synthetic */ j(d dVar, a aVar) {
        this(dVar);
    }

    private boolean L0(int[] iArr) {
        boolean z7;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f18231a.f18259d == null || color2 == (colorForState2 = this.f18231a.f18259d.getColorForState(iArr, (color2 = this.f18244n.getColor())))) {
            z7 = false;
        } else {
            this.f18244n.setColor(colorForState2);
            z7 = true;
        }
        if (this.f18231a.f18260e == null || color == (colorForState = this.f18231a.f18260e.getColorForState(iArr, (color = this.f18245o.getColor())))) {
            return z7;
        }
        this.f18245o.setColor(colorForState);
        return true;
    }

    private boolean M0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f18249s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f18250t;
        d dVar = this.f18231a;
        this.f18249s = k(dVar.f18262g, dVar.f18263h, this.f18244n, true);
        d dVar2 = this.f18231a;
        this.f18250t = k(dVar2.f18261f, dVar2.f18263h, this.f18245o, false);
        d dVar3 = this.f18231a;
        if (dVar3.f18276u) {
            this.f18246p.d(dVar3.f18262g.getColorForState(getState(), 0));
        }
        return (androidx.core.util.r.a(porterDuffColorFilter, this.f18249s) && androidx.core.util.r.a(porterDuffColorFilter2, this.f18250t)) ? false : true;
    }

    private float N() {
        if (X()) {
            return this.f18245o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private void N0() {
        float fU = U();
        this.f18231a.f18273r = (int) Math.ceil(0.75f * fU);
        this.f18231a.f18274s = (int) Math.ceil(fU * f18229y);
        M0();
        Z();
    }

    private boolean V() {
        d dVar = this.f18231a;
        int i7 = dVar.f18272q;
        return i7 != 1 && dVar.f18273r > 0 && (i7 == 2 || i0());
    }

    private boolean W() {
        Paint.Style style = this.f18231a.f18277v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean X() {
        Paint.Style style = this.f18231a.f18277v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f18245o.getStrokeWidth() > 0.0f;
    }

    private void Z() {
        super.invalidateSelf();
    }

    @o0
    private PorterDuffColorFilter f(@m0 Paint paint, boolean z7) {
        int color;
        int iL;
        if (!z7 || (iL = l((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
    }

    private void f0(@m0 Canvas canvas) {
        if (V()) {
            canvas.save();
            h0(canvas);
            if (!this.f18252v) {
                o(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f18251u.width() - getBounds().width());
            int iHeight = (int) (this.f18251u.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f18251u.width()) + (this.f18231a.f18273r * 2) + iWidth, ((int) this.f18251u.height()) + (this.f18231a.f18273r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f8 = (getBounds().left - this.f18231a.f18273r) - iWidth;
            float f9 = (getBounds().top - this.f18231a.f18273r) - iHeight;
            canvas2.translate(-f8, -f9);
            o(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f8, f9, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    private void g(@m0 RectF rectF, @m0 Path path) {
        h(rectF, path);
        if (this.f18231a.f18265j != 1.0f) {
            this.f18236f.reset();
            Matrix matrix = this.f18236f;
            float f8 = this.f18231a.f18265j;
            matrix.setScale(f8, f8, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f18236f);
        }
        path.computeBounds(this.f18251u, true);
    }

    private static int g0(int i7, int i8) {
        return (i7 * (i8 + (i8 >>> 7))) >>> 8;
    }

    private void h0(@m0 Canvas canvas) {
        canvas.translate(H(), I());
    }

    private void i() {
        o oVarY = getShapeAppearanceModel().y(new b(-N()));
        this.f18243m = oVarY;
        this.f18248r.d(oVarY, this.f18231a.f18266k, w(), this.f18238h);
    }

    @m0
    private PorterDuffColorFilter j(@m0 ColorStateList colorStateList, @m0 PorterDuff.Mode mode, boolean z7) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z7) {
            colorForState = l(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @m0
    private PorterDuffColorFilter k(@o0 ColorStateList colorStateList, @o0 PorterDuff.Mode mode, @m0 Paint paint, boolean z7) {
        return (colorStateList == null || mode == null) ? f(paint, z7) : j(colorStateList, mode, z7);
    }

    @m0
    public static j m(Context context) {
        return n(context, 0.0f);
    }

    @m0
    public static j n(Context context, float f8) {
        int iC = k1.a.c(context, R.attr.colorSurface, j.class.getSimpleName());
        j jVar = new j();
        jVar.Y(context);
        jVar.n0(ColorStateList.valueOf(iC));
        jVar.m0(f8);
        return jVar;
    }

    private void o(@m0 Canvas canvas) {
        if (this.f18234d.cardinality() > 0) {
            Log.w(f18227w, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f18231a.f18274s != 0) {
            canvas.drawPath(this.f18237g, this.f18246p.c());
        }
        for (int i7 = 0; i7 < 4; i7++) {
            this.f18232b[i7].b(this.f18246p, this.f18231a.f18273r, canvas);
            this.f18233c[i7].b(this.f18246p, this.f18231a.f18273r, canvas);
        }
        if (this.f18252v) {
            int iH = H();
            int I = I();
            canvas.translate(-iH, -I);
            canvas.drawPath(this.f18237g, C);
            canvas.translate(iH, I);
        }
    }

    private void p(@m0 Canvas canvas) {
        r(canvas, this.f18244n, this.f18237g, this.f18231a.f18256a, v());
    }

    private void r(@m0 Canvas canvas, @m0 Paint paint, @m0 Path path, @m0 o oVar, @m0 RectF rectF) {
        if (!oVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = oVar.t().a(rectF) * this.f18231a.f18266k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    private void s(@m0 Canvas canvas) {
        r(canvas, this.f18245o, this.f18238h, this.f18243m, w());
    }

    @m0
    private RectF w() {
        this.f18240j.set(v());
        float fN = N();
        this.f18240j.inset(fN, fN);
        return this.f18240j;
    }

    public Paint.Style A() {
        return this.f18231a.f18277v;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void A0(int i7) {
        d dVar = this.f18231a;
        if (dVar.f18274s != i7) {
            dVar.f18274s = i7;
            Z();
        }
    }

    public float B() {
        return this.f18231a.f18269n;
    }

    @Deprecated
    public void B0(@m0 r rVar) {
        setShapeAppearanceModel(rVar);
    }

    @Deprecated
    public void C(int i7, int i8, @m0 Path path) {
        h(new RectF(0.0f, 0.0f, i7, i8), path);
    }

    public void C0(float f8, @c.l int i7) {
        H0(f8);
        E0(ColorStateList.valueOf(i7));
    }

    public float D() {
        return this.f18231a.f18265j;
    }

    public void D0(float f8, @o0 ColorStateList colorStateList) {
        H0(f8);
        E0(colorStateList);
    }

    public int E() {
        return this.f18231a.f18275t;
    }

    public void E0(@o0 ColorStateList colorStateList) {
        d dVar = this.f18231a;
        if (dVar.f18260e != colorStateList) {
            dVar.f18260e = colorStateList;
            onStateChange(getState());
        }
    }

    public int F() {
        return this.f18231a.f18272q;
    }

    public void F0(@c.l int i7) {
        G0(ColorStateList.valueOf(i7));
    }

    @Deprecated
    public int G() {
        return (int) x();
    }

    public void G0(ColorStateList colorStateList) {
        this.f18231a.f18261f = colorStateList;
        M0();
        Z();
    }

    public int H() {
        d dVar = this.f18231a;
        return (int) (((double) dVar.f18274s) * Math.sin(Math.toRadians(dVar.f18275t)));
    }

    public void H0(float f8) {
        this.f18231a.f18267l = f8;
        invalidateSelf();
    }

    public int I() {
        d dVar = this.f18231a;
        return (int) (((double) dVar.f18274s) * Math.cos(Math.toRadians(dVar.f18275t)));
    }

    public void I0(float f8) {
        d dVar = this.f18231a;
        if (dVar.f18271p != f8) {
            dVar.f18271p = f8;
            N0();
        }
    }

    public int J() {
        return this.f18231a.f18273r;
    }

    public void J0(boolean z7) {
        d dVar = this.f18231a;
        if (dVar.f18276u != z7) {
            dVar.f18276u = z7;
            invalidateSelf();
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    public int K() {
        return this.f18231a.f18274s;
    }

    public void K0(float f8) {
        I0(f8 - x());
    }

    @o0
    @Deprecated
    public r L() {
        o shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof r) {
            return (r) shapeAppearanceModel;
        }
        return null;
    }

    @o0
    public ColorStateList M() {
        return this.f18231a.f18260e;
    }

    @o0
    public ColorStateList O() {
        return this.f18231a.f18261f;
    }

    public float P() {
        return this.f18231a.f18267l;
    }

    @o0
    public ColorStateList Q() {
        return this.f18231a.f18262g;
    }

    public float R() {
        return this.f18231a.f18256a.r().a(v());
    }

    public float S() {
        return this.f18231a.f18256a.t().a(v());
    }

    public float T() {
        return this.f18231a.f18271p;
    }

    public float U() {
        return x() + T();
    }

    public void Y(Context context) {
        this.f18231a.f18257b = new n1.a(context);
        N0();
    }

    public boolean a0() {
        n1.a aVar = this.f18231a.f18257b;
        return aVar != null && aVar.l();
    }

    public boolean b0() {
        return this.f18231a.f18257b != null;
    }

    public boolean c0(int i7, int i8) {
        return getTransparentRegion().contains(i7, i8);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public boolean d0() {
        return this.f18231a.f18256a.u(v());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        this.f18244n.setColorFilter(this.f18249s);
        int alpha = this.f18244n.getAlpha();
        this.f18244n.setAlpha(g0(alpha, this.f18231a.f18268m));
        this.f18245o.setColorFilter(this.f18250t);
        this.f18245o.setStrokeWidth(this.f18231a.f18267l);
        int alpha2 = this.f18245o.getAlpha();
        this.f18245o.setAlpha(g0(alpha2, this.f18231a.f18268m));
        if (this.f18235e) {
            i();
            g(v(), this.f18237g);
            this.f18235e = false;
        }
        f0(canvas);
        if (W()) {
            p(canvas);
        }
        if (X()) {
            s(canvas);
        }
        this.f18244n.setAlpha(alpha);
        this.f18245o.setAlpha(alpha2);
    }

    @Deprecated
    public boolean e0() {
        int i7 = this.f18231a.f18272q;
        return i7 == 0 || i7 == 2;
    }

    @Override // android.graphics.drawable.Drawable
    @o0
    public Drawable.ConstantState getConstantState() {
        return this.f18231a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@m0 Outline outline) {
        if (this.f18231a.f18272q == 2) {
            return;
        }
        if (d0()) {
            outline.setRoundRect(getBounds(), R() * this.f18231a.f18266k);
            return;
        }
        g(v(), this.f18237g);
        if (this.f18237g.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f18237g);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@m0 Rect rect) {
        Rect rect2 = this.f18231a.f18264i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // com.google.android.material.shape.s
    @m0
    public o getShapeAppearanceModel() {
        return this.f18231a.f18256a;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f18241k.set(getBounds());
        g(v(), this.f18237g);
        this.f18242l.setPath(this.f18237g, this.f18241k);
        this.f18241k.op(this.f18242l, Region.Op.DIFFERENCE);
        return this.f18241k;
    }

    @x0({x0.a.LIBRARY_GROUP})
    protected final void h(@m0 RectF rectF, @m0 Path path) {
        p pVar = this.f18248r;
        d dVar = this.f18231a;
        pVar.e(dVar.f18256a, dVar.f18266k, rectF, this.f18247q, path);
    }

    public boolean i0() {
        return (d0() || this.f18237g.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f18235e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f18231a.f18262g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f18231a.f18261f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f18231a.f18260e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f18231a.f18259d) != null && colorStateList4.isStateful())));
    }

    public void j0(float f8) {
        setShapeAppearanceModel(this.f18231a.f18256a.w(f8));
    }

    public void k0(@m0 com.google.android.material.shape.d dVar) {
        setShapeAppearanceModel(this.f18231a.f18256a.x(dVar));
    }

    @x0({x0.a.LIBRARY_GROUP})
    @c.l
    protected int l(@c.l int i7) {
        float fU = U() + B();
        n1.a aVar = this.f18231a.f18257b;
        return aVar != null ? aVar.e(i7, fU) : i7;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void l0(boolean z7) {
        this.f18248r.n(z7);
    }

    public void m0(float f8) {
        d dVar = this.f18231a;
        if (dVar.f18270o != f8) {
            dVar.f18270o = f8;
            N0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    @m0
    public Drawable mutate() {
        this.f18231a = new d(this.f18231a);
        return this;
    }

    public void n0(@o0 ColorStateList colorStateList) {
        d dVar = this.f18231a;
        if (dVar.f18259d != colorStateList) {
            dVar.f18259d = colorStateList;
            onStateChange(getState());
        }
    }

    public void o0(float f8) {
        d dVar = this.f18231a;
        if (dVar.f18266k != f8) {
            dVar.f18266k = f8;
            this.f18235e = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f18235e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.k.b
    protected boolean onStateChange(int[] iArr) {
        boolean z7 = L0(iArr) || M0();
        if (z7) {
            invalidateSelf();
        }
        return z7;
    }

    public void p0(int i7, int i8, int i9, int i10) {
        d dVar = this.f18231a;
        if (dVar.f18264i == null) {
            dVar.f18264i = new Rect();
        }
        this.f18231a.f18264i.set(i7, i8, i9, i10);
        invalidateSelf();
    }

    @x0({x0.a.LIBRARY_GROUP})
    protected void q(@m0 Canvas canvas, @m0 Paint paint, @m0 Path path, @m0 RectF rectF) {
        r(canvas, paint, path, this.f18231a.f18256a, rectF);
    }

    public void q0(Paint.Style style) {
        this.f18231a.f18277v = style;
        Z();
    }

    public void r0(float f8) {
        d dVar = this.f18231a;
        if (dVar.f18269n != f8) {
            dVar.f18269n = f8;
            N0();
        }
    }

    public void s0(float f8) {
        d dVar = this.f18231a;
        if (dVar.f18265j != f8) {
            dVar.f18265j = f8;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@e0(from = 0, to = 255) int i7) {
        d dVar = this.f18231a;
        if (dVar.f18268m != i7) {
            dVar.f18268m = i7;
            Z();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@o0 ColorFilter colorFilter) {
        this.f18231a.f18258c = colorFilter;
        Z();
    }

    @Override // com.google.android.material.shape.s
    public void setShapeAppearanceModel(@m0 o oVar) {
        this.f18231a.f18256a = oVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTint(@c.l int i7) {
        setTintList(ColorStateList.valueOf(i7));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintList(@o0 ColorStateList colorStateList) {
        this.f18231a.f18262g = colorStateList;
        M0();
        Z();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintMode(@o0 PorterDuff.Mode mode) {
        d dVar = this.f18231a;
        if (dVar.f18263h != mode) {
            dVar.f18263h = mode;
            M0();
            Z();
        }
    }

    public float t() {
        return this.f18231a.f18256a.j().a(v());
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void t0(boolean z7) {
        this.f18252v = z7;
    }

    public float u() {
        return this.f18231a.f18256a.l().a(v());
    }

    public void u0(int i7) {
        this.f18246p.d(i7);
        this.f18231a.f18276u = false;
        Z();
    }

    @m0
    protected RectF v() {
        this.f18239i.set(getBounds());
        return this.f18239i;
    }

    public void v0(int i7) {
        d dVar = this.f18231a;
        if (dVar.f18275t != i7) {
            dVar.f18275t = i7;
            Z();
        }
    }

    public void w0(int i7) {
        d dVar = this.f18231a;
        if (dVar.f18272q != i7) {
            dVar.f18272q = i7;
            Z();
        }
    }

    public float x() {
        return this.f18231a.f18270o;
    }

    @Deprecated
    public void x0(int i7) {
        m0(i7);
    }

    @o0
    public ColorStateList y() {
        return this.f18231a.f18259d;
    }

    @Deprecated
    public void y0(boolean z7) {
        w0(!z7 ? 1 : 0);
    }

    public float z() {
        return this.f18231a.f18266k;
    }

    @Deprecated
    public void z0(int i7) {
        this.f18231a.f18273r = i7;
    }

    public j() {
        this(new o());
    }

    public j(@m0 Context context, @o0 AttributeSet attributeSet, @c.f int i7, @b1 int i8) {
        this(o.e(context, attributeSet, i7, i8).m());
    }

    @Deprecated
    public j(@m0 r rVar) {
        this((o) rVar);
    }

    public j(@m0 o oVar) {
        this(new d(oVar, null));
    }

    private j(@m0 d dVar) {
        this.f18232b = new q.i[4];
        this.f18233c = new q.i[4];
        this.f18234d = new BitSet(8);
        this.f18236f = new Matrix();
        this.f18237g = new Path();
        this.f18238h = new Path();
        this.f18239i = new RectF();
        this.f18240j = new RectF();
        this.f18241k = new Region();
        this.f18242l = new Region();
        Paint paint = new Paint(1);
        this.f18244n = paint;
        Paint paint2 = new Paint(1);
        this.f18245o = paint2;
        this.f18246p = new com.google.android.material.shadow.b();
        this.f18248r = Looper.getMainLooper().getThread() == Thread.currentThread() ? p.k() : new p();
        this.f18251u = new RectF();
        this.f18252v = true;
        this.f18231a = dVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = C;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        M0();
        L0(getState());
        this.f18247q = new a();
    }

    static final class d extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        public o f18256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @o0
        public n1.a f18257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        public ColorFilter f18258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @o0
        public ColorStateList f18259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @o0
        public ColorStateList f18260e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @o0
        public ColorStateList f18261f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @o0
        public ColorStateList f18262g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @o0
        public PorterDuff.Mode f18263h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @o0
        public Rect f18264i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f18265j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f18266k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f18267l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18268m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f18269n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f18270o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f18271p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f18272q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f18273r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f18274s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f18275t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f18276u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Paint.Style f18277v;

        public d(o oVar, n1.a aVar) {
            this.f18259d = null;
            this.f18260e = null;
            this.f18261f = null;
            this.f18262g = null;
            this.f18263h = PorterDuff.Mode.SRC_IN;
            this.f18264i = null;
            this.f18265j = 1.0f;
            this.f18266k = 1.0f;
            this.f18268m = 255;
            this.f18269n = 0.0f;
            this.f18270o = 0.0f;
            this.f18271p = 0.0f;
            this.f18272q = 0;
            this.f18273r = 0;
            this.f18274s = 0;
            this.f18275t = 0;
            this.f18276u = false;
            this.f18277v = Paint.Style.FILL_AND_STROKE;
            this.f18256a = oVar;
            this.f18257b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @m0
        public Drawable newDrawable() {
            j jVar = new j(this, null);
            jVar.f18235e = true;
            return jVar;
        }

        public d(@m0 d dVar) {
            this.f18259d = null;
            this.f18260e = null;
            this.f18261f = null;
            this.f18262g = null;
            this.f18263h = PorterDuff.Mode.SRC_IN;
            this.f18264i = null;
            this.f18265j = 1.0f;
            this.f18266k = 1.0f;
            this.f18268m = 255;
            this.f18269n = 0.0f;
            this.f18270o = 0.0f;
            this.f18271p = 0.0f;
            this.f18272q = 0;
            this.f18273r = 0;
            this.f18274s = 0;
            this.f18275t = 0;
            this.f18276u = false;
            this.f18277v = Paint.Style.FILL_AND_STROKE;
            this.f18256a = dVar.f18256a;
            this.f18257b = dVar.f18257b;
            this.f18267l = dVar.f18267l;
            this.f18258c = dVar.f18258c;
            this.f18259d = dVar.f18259d;
            this.f18260e = dVar.f18260e;
            this.f18263h = dVar.f18263h;
            this.f18262g = dVar.f18262g;
            this.f18268m = dVar.f18268m;
            this.f18265j = dVar.f18265j;
            this.f18274s = dVar.f18274s;
            this.f18272q = dVar.f18272q;
            this.f18276u = dVar.f18276u;
            this.f18266k = dVar.f18266k;
            this.f18269n = dVar.f18269n;
            this.f18270o = dVar.f18270o;
            this.f18271p = dVar.f18271p;
            this.f18273r = dVar.f18273r;
            this.f18275t = dVar.f18275t;
            this.f18261f = dVar.f18261f;
            this.f18277v = dVar.f18277v;
            if (dVar.f18264i != null) {
                this.f18264i = new Rect(dVar.f18264i);
            }
        }
    }
}
