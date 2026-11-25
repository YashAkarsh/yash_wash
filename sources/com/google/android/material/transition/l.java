package com.google.android.material.transition;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.util.w;
import androidx.core.view.n2;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.d0;
import c.b0;
import c.b1;
import c.m0;
import c.o0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class l extends Transition {
    public static final int V0 = 0;
    public static final int W0 = 1;
    public static final int X0 = 2;
    public static final int Y0 = 0;
    public static final int Z0 = 1;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final int f18944a1 = 2;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final int f18945b1 = 3;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final int f18946c1 = 0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final int f18947d1 = 1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final int f18948e1 = 2;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    private static final String f18949f1 = "l";

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private static final f f18954k1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private static final f f18956m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    private static final float f18957n1 = -1.0f;

    @b0
    private int A0;

    @b0
    private int B0;

    @b0
    private int C0;

    @c.l
    private int D0;

    @c.l
    private int E0;

    @c.l
    private int F0;

    @c.l
    private int G0;
    private int H0;
    private int I0;
    private int J0;

    @o0
    private View K0;

    @o0
    private View L0;

    @o0
    private com.google.android.material.shape.o M0;

    @o0
    private com.google.android.material.shape.o N0;

    @o0
    private e O0;

    @o0
    private e P0;

    @o0
    private e Q0;

    @o0
    private e R0;
    private boolean S0;
    private float T0;
    private float U0;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    private static final String f18950g1 = "materialContainerTransition:bounds";

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private static final String f18951h1 = "materialContainerTransition:shapeAppearance";

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private static final String[] f18952i1 = {f18950g1, f18951h1};

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    private static final f f18953j1 = new f(new e(0.0f, 0.25f), new e(0.0f, 1.0f), new e(0.0f, 1.0f), new e(0.0f, 0.75f), null);

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    private static final f f18955l1 = new f(new e(0.1f, 0.4f), new e(0.1f, 1.0f), new e(0.1f, 1.0f), new e(0.1f, 0.9f), null);

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f18958a;

        a(h hVar) {
            this.f18958a = hVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f18958a.o(valueAnimator.getAnimatedFraction());
        }
    }

    class b extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f18960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f18961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f18962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f18963d;

        b(View view, h hVar, View view2, View view3) {
            this.f18960a = view;
            this.f18961b = hVar;
            this.f18962c = view2;
            this.f18963d = view3;
        }

        @Override // com.google.android.material.transition.t, androidx.transition.Transition.h
        public void a(@m0 Transition transition) {
            com.google.android.material.internal.v.h(this.f18960a).a(this.f18961b);
            this.f18962c.setAlpha(0.0f);
            this.f18963d.setAlpha(0.0f);
        }

        @Override // com.google.android.material.transition.t, androidx.transition.Transition.h
        public void c(@m0 Transition transition) {
            l.this.j0(this);
            if (l.this.X) {
                return;
            }
            this.f18962c.setAlpha(1.0f);
            this.f18963d.setAlpha(1.0f);
            com.google.android.material.internal.v.h(this.f18960a).b(this.f18961b);
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.v(from = 0.0d, to = 1.0d)
        private final float f18965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c.v(from = 0.0d, to = 1.0d)
        private final float f18966b;

        public e(@c.v(from = 0.0d, to = 1.0d) float f8, @c.v(from = 0.0d, to = 1.0d) float f9) {
            this.f18965a = f8;
            this.f18966b = f9;
        }

        @c.v(from = 0.0d, to = 1.0d)
        public float c() {
            return this.f18966b;
        }

        @c.v(from = 0.0d, to = 1.0d)
        public float d() {
            return this.f18965a;
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final e f18967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        private final e f18968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m0
        private final e f18969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @m0
        private final e f18970d;

        /* synthetic */ f(e eVar, e eVar2, e eVar3, e eVar4, a aVar) {
            this(eVar, eVar2, eVar3, eVar4);
        }

        private f(@m0 e eVar, @m0 e eVar2, @m0 e eVar3, @m0 e eVar4) {
            this.f18967a = eVar;
            this.f18968b = eVar2;
            this.f18969c = eVar3;
            this.f18970d = eVar4;
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface g {
    }

    private static final class h extends Drawable {
        private static final int M = 754974720;
        private static final int N = -7829368;
        private static final float O = 0.3f;
        private static final float P = 1.5f;
        private final f A;
        private final com.google.android.material.transition.a B;
        private final com.google.android.material.transition.f C;
        private final boolean D;
        private final Paint E;
        private final Path F;
        private com.google.android.material.transition.c G;
        private com.google.android.material.transition.h H;
        private RectF I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private float f18971J;
        private float K;
        private float L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f18972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RectF f18973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.google.android.material.shape.o f18974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f18975d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final View f18976e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final RectF f18977f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final com.google.android.material.shape.o f18978g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f18979h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Paint f18980i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Paint f18981j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final Paint f18982k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Paint f18983l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Paint f18984m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final j f18985n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final PathMeasure f18986o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final float f18987p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final float[] f18988q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final boolean f18989r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final float f18990s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final float f18991t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f18992u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final com.google.android.material.shape.j f18993v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final RectF f18994w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final RectF f18995x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final RectF f18996y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private final RectF f18997z;

        class a implements u.c {
            a() {
            }

            @Override // com.google.android.material.transition.u.c
            public void a(Canvas canvas) {
                h.this.f18972a.draw(canvas);
            }
        }

        class b implements u.c {
            b() {
            }

            @Override // com.google.android.material.transition.u.c
            public void a(Canvas canvas) {
                h.this.f18976e.draw(canvas);
            }
        }

        /* synthetic */ h(PathMotion pathMotion, View view, RectF rectF, com.google.android.material.shape.o oVar, float f8, View view2, RectF rectF2, com.google.android.material.shape.o oVar2, float f9, int i7, int i8, int i9, int i10, boolean z7, boolean z8, com.google.android.material.transition.a aVar, com.google.android.material.transition.f fVar, f fVar2, boolean z9, a aVar2) {
            this(pathMotion, view, rectF, oVar, f8, view2, rectF2, oVar2, f9, i7, i8, i9, i10, z7, z8, aVar, fVar, fVar2, z9);
        }

        private static float d(RectF rectF, float f8) {
            return ((rectF.centerX() / (f8 / 2.0f)) - 1.0f) * O;
        }

        private static float e(RectF rectF, float f8) {
            return (rectF.centerY() / f8) * P;
        }

        private void f(Canvas canvas, RectF rectF, Path path, @c.l int i7) {
            PointF pointFM = m(rectF);
            if (this.L == 0.0f) {
                path.reset();
                path.moveTo(pointFM.x, pointFM.y);
            } else {
                path.lineTo(pointFM.x, pointFM.y);
                this.E.setColor(i7);
                canvas.drawPath(path, this.E);
            }
        }

        private void g(Canvas canvas, RectF rectF, @c.l int i7) {
            this.E.setColor(i7);
            canvas.drawRect(rectF, this.E);
        }

        private void h(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.f18985n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        private void i(Canvas canvas) {
            com.google.android.material.shape.j jVar = this.f18993v;
            RectF rectF = this.I;
            jVar.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.f18993v.m0(this.f18971J);
            this.f18993v.A0((int) this.K);
            this.f18993v.setShapeAppearanceModel(this.f18985n.c());
            this.f18993v.draw(canvas);
        }

        private void j(Canvas canvas) {
            com.google.android.material.shape.o oVarC = this.f18985n.c();
            if (!oVarC.u(this.I)) {
                canvas.drawPath(this.f18985n.d(), this.f18983l);
            } else {
                float fA = oVarC.r().a(this.I);
                canvas.drawRoundRect(this.I, fA, fA, this.f18983l);
            }
        }

        private void k(Canvas canvas) {
            n(canvas, this.f18982k);
            Rect bounds = getBounds();
            RectF rectF = this.f18996y;
            u.A(canvas, bounds, rectF.left, rectF.top, this.H.f18934b, this.G.f18912b, new b());
        }

        private void l(Canvas canvas) {
            n(canvas, this.f18981j);
            Rect bounds = getBounds();
            RectF rectF = this.f18994w;
            u.A(canvas, bounds, rectF.left, rectF.top, this.H.f18933a, this.G.f18911a, new a());
        }

        private static PointF m(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        private void n(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(float f8) {
            if (this.L != f8) {
                p(f8);
            }
        }

        private void p(float f8) {
            float f9;
            float f10;
            this.L = f8;
            this.f18984m.setAlpha((int) (this.f18989r ? u.n(0.0f, 255.0f, f8) : u.n(255.0f, 0.0f, f8)));
            this.f18986o.getPosTan(this.f18987p * f8, this.f18988q, null);
            float[] fArr = this.f18988q;
            float f11 = fArr[0];
            float f12 = fArr[1];
            if (f8 > 1.0f || f8 < 0.0f) {
                if (f8 > 1.0f) {
                    f10 = (f8 - 1.0f) / 0.00999999f;
                    f9 = 0.99f;
                } else {
                    f9 = 0.01f;
                    f10 = (f8 / 0.01f) * (-1.0f);
                }
                this.f18986o.getPosTan(this.f18987p * f9, fArr, null);
                float[] fArr2 = this.f18988q;
                f11 += (f11 - fArr2[0]) * f10;
                f12 += (f12 - fArr2[1]) * f10;
            }
            float f13 = f11;
            float f14 = f12;
            com.google.android.material.transition.h hVarA = this.C.a(f8, ((Float) w.l(Float.valueOf(this.A.f18968b.f18965a))).floatValue(), ((Float) w.l(Float.valueOf(this.A.f18968b.f18966b))).floatValue(), this.f18973b.width(), this.f18973b.height(), this.f18977f.width(), this.f18977f.height());
            this.H = hVarA;
            RectF rectF = this.f18994w;
            float f15 = hVarA.f18935c;
            rectF.set(f13 - (f15 / 2.0f), f14, (f15 / 2.0f) + f13, hVarA.f18936d + f14);
            RectF rectF2 = this.f18996y;
            com.google.android.material.transition.h hVar = this.H;
            float f16 = hVar.f18937e;
            rectF2.set(f13 - (f16 / 2.0f), f14, f13 + (f16 / 2.0f), hVar.f18938f + f14);
            this.f18995x.set(this.f18994w);
            this.f18997z.set(this.f18996y);
            float fFloatValue = ((Float) w.l(Float.valueOf(this.A.f18969c.f18965a))).floatValue();
            float fFloatValue2 = ((Float) w.l(Float.valueOf(this.A.f18969c.f18966b))).floatValue();
            boolean zB = this.C.b(this.H);
            RectF rectF3 = zB ? this.f18995x : this.f18997z;
            float fO = u.o(0.0f, 1.0f, fFloatValue, fFloatValue2, f8);
            if (!zB) {
                fO = 1.0f - fO;
            }
            this.C.c(rectF3, fO, this.H);
            this.I = new RectF(Math.min(this.f18995x.left, this.f18997z.left), Math.min(this.f18995x.top, this.f18997z.top), Math.max(this.f18995x.right, this.f18997z.right), Math.max(this.f18995x.bottom, this.f18997z.bottom));
            this.f18985n.b(f8, this.f18974c, this.f18978g, this.f18994w, this.f18995x, this.f18997z, this.A.f18970d);
            this.f18971J = u.n(this.f18975d, this.f18979h, f8);
            float fD = d(this.I, this.f18990s);
            float fE = e(this.I, this.f18991t);
            float f17 = this.f18971J;
            float f18 = (int) (fE * f17);
            this.K = f18;
            this.f18983l.setShadowLayer(f17, (int) (fD * f17), f18, M);
            this.G = this.B.a(f8, ((Float) w.l(Float.valueOf(this.A.f18967a.f18965a))).floatValue(), ((Float) w.l(Float.valueOf(this.A.f18967a.f18966b))).floatValue(), 0.35f);
            if (this.f18981j.getColor() != 0) {
                this.f18981j.setAlpha(this.G.f18911a);
            }
            if (this.f18982k.getColor() != 0) {
                this.f18982k.setAlpha(this.G.f18912b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@m0 Canvas canvas) {
            if (this.f18984m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f18984m);
            }
            int iSave = this.D ? canvas.save() : -1;
            if (this.f18992u && this.f18971J > 0.0f) {
                h(canvas);
            }
            this.f18985n.a(canvas);
            n(canvas, this.f18980i);
            if (this.G.f18913c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(iSave);
                f(canvas, this.f18994w, this.F, -65281);
                g(canvas, this.f18995x, androidx.core.view.o0.f6793u);
                g(canvas, this.f18994w, -16711936);
                g(canvas, this.f18997z, -16711681);
                g(canvas, this.f18996y, -16776961);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i7) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@o0 ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private h(PathMotion pathMotion, View view, RectF rectF, com.google.android.material.shape.o oVar, float f8, View view2, RectF rectF2, com.google.android.material.shape.o oVar2, float f9, @c.l int i7, @c.l int i8, @c.l int i9, int i10, boolean z7, boolean z8, com.google.android.material.transition.a aVar, com.google.android.material.transition.f fVar, f fVar2, boolean z9) {
            Paint paint = new Paint();
            this.f18980i = paint;
            Paint paint2 = new Paint();
            this.f18981j = paint2;
            Paint paint3 = new Paint();
            this.f18982k = paint3;
            this.f18983l = new Paint();
            Paint paint4 = new Paint();
            this.f18984m = paint4;
            this.f18985n = new j();
            this.f18988q = new float[]{rectF.centerX(), rectF.top};
            com.google.android.material.shape.j jVar = new com.google.android.material.shape.j();
            this.f18993v = jVar;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f18972a = view;
            this.f18973b = rectF;
            this.f18974c = oVar;
            this.f18975d = f8;
            this.f18976e = view2;
            this.f18977f = rectF2;
            this.f18978g = oVar2;
            this.f18979h = f9;
            this.f18989r = z7;
            this.f18992u = z8;
            this.B = aVar;
            this.C = fVar;
            this.A = fVar2;
            this.D = z9;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.f18990s = displayMetrics.widthPixels;
            this.f18991t = displayMetrics.heightPixels;
            paint.setColor(i7);
            paint2.setColor(i8);
            paint3.setColor(i9);
            jVar.n0(ColorStateList.valueOf(0));
            jVar.w0(2);
            jVar.t0(false);
            jVar.u0(N);
            RectF rectF3 = new RectF(rectF);
            this.f18994w = rectF3;
            this.f18995x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.f18996y = rectF4;
            this.f18997z = new RectF(rectF4);
            PointF pointFM = m(rectF);
            PointF pointFM2 = m(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.a(pointFM.x, pointFM.y, pointFM2.x, pointFM2.y), false);
            this.f18986o = pathMeasure;
            this.f18987p = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(u.c(i10));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    static {
        a aVar = null;
        f18954k1 = new f(new e(0.6f, 0.9f), new e(0.0f, 1.0f), new e(0.0f, 0.9f), new e(0.3f, 0.9f), aVar);
        f18956m1 = new f(new e(0.6f, 0.9f), new e(0.0f, 0.9f), new e(0.0f, 0.9f), new e(0.2f, 0.9f), aVar);
    }

    public l() {
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.A0 = R.id.content;
        this.B0 = -1;
        this.C0 = -1;
        this.D0 = 0;
        this.E0 = 0;
        this.F0 = 0;
        this.G0 = 1375731712;
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = 0;
        this.S0 = Build.VERSION.SDK_INT >= 28;
        this.T0 = -1.0f;
        this.U0 = -1.0f;
    }

    private f E0(boolean z7) {
        PathMotion pathMotionN = N();
        return ((pathMotionN instanceof ArcMotion) || (pathMotionN instanceof k)) ? d1(z7, f18955l1, f18956m1) : d1(z7, f18953j1, f18954k1);
    }

    private static RectF F0(View view, @o0 View view2, float f8, float f9) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF rectFI = u.i(view2);
        rectFI.offset(f8, f9);
        return rectFI;
    }

    private static com.google.android.material.shape.o G0(@m0 View view, @m0 RectF rectF, @o0 com.google.android.material.shape.o oVar) {
        return u.b(W0(view, oVar), rectF);
    }

    private static void H0(@m0 d0 d0Var, @o0 View view, @b0 int i7, @o0 com.google.android.material.shape.o oVar) {
        if (i7 != -1) {
            d0Var.f10675b = u.f(d0Var.f10675b, i7);
        } else if (view != null) {
            d0Var.f10675b = view;
        } else if (d0Var.f10675b.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof View) {
            View view2 = (View) d0Var.f10675b.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
            d0Var.f10675b.setTag(com.google.android.material.R.id.mtrl_motion_snapshot_view, null);
            d0Var.f10675b = view2;
        }
        View view3 = d0Var.f10675b;
        if (!n2.U0(view3) && view3.getWidth() == 0 && view3.getHeight() == 0) {
            return;
        }
        RectF rectFJ = view3.getParent() == null ? u.j(view3) : u.i(view3);
        d0Var.f10674a.put(f18950g1, rectFJ);
        d0Var.f10674a.put(f18951h1, G0(view3, rectFJ, oVar));
    }

    private static float K0(float f8, View view) {
        return f8 != -1.0f ? f8 : n2.R(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.google.android.material.shape.o W0(@m0 View view, @o0 com.google.android.material.shape.o oVar) {
        if (oVar != null) {
            return oVar;
        }
        if (view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof com.google.android.material.shape.o) {
            return (com.google.android.material.shape.o) view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
        }
        Context context = view.getContext();
        int iF1 = f1(context);
        if (iF1 != -1) {
            return com.google.android.material.shape.o.b(context, iF1, 0).m();
        }
        return view instanceof com.google.android.material.shape.s ? ((com.google.android.material.shape.s) view).getShapeAppearanceModel() : com.google.android.material.shape.o.a().m();
    }

    private f d1(boolean z7, f fVar, f fVar2) {
        if (!z7) {
            fVar = fVar2;
        }
        return new f((e) u.d(this.O0, fVar.f18967a), (e) u.d(this.P0, fVar.f18968b), (e) u.d(this.Q0, fVar.f18969c), (e) u.d(this.R0, fVar.f18970d), null);
    }

    @b1
    private static int f1(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean i1(@m0 RectF rectF, @m0 RectF rectF2) {
        int i7 = this.H0;
        if (i7 == 0) {
            return u.a(rectF2) > u.a(rectF);
        }
        if (i7 == 1) {
            return true;
        }
        if (i7 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid transition direction: " + this.H0);
    }

    private void k1(Context context, boolean z7) {
        u.u(this, context, com.google.android.material.R.attr.motionEasingStandard, com.google.android.material.animation.a.f16847b);
        u.t(this, context, z7 ? com.google.android.material.R.attr.motionDurationLong1 : com.google.android.material.R.attr.motionDurationMedium2);
        if (this.Y) {
            return;
        }
        u.v(this, context, com.google.android.material.R.attr.motionPath);
    }

    public void A1(@o0 e eVar) {
        this.P0 = eVar;
    }

    public void B1(@c.l int i7) {
        this.G0 = i7;
    }

    public void C1(@o0 e eVar) {
        this.R0 = eVar;
    }

    public void D1(@c.l int i7) {
        this.E0 = i7;
    }

    public void E1(float f8) {
        this.T0 = f8;
    }

    public void F1(@o0 com.google.android.material.shape.o oVar) {
        this.M0 = oVar;
    }

    public void G1(@o0 View view) {
        this.K0 = view;
    }

    public void H1(@b0 int i7) {
        this.B0 = i7;
    }

    @c.l
    public int I0() {
        return this.D0;
    }

    public void I1(int i7) {
        this.H0 = i7;
    }

    @b0
    public int J0() {
        return this.A0;
    }

    @c.l
    public int L0() {
        return this.F0;
    }

    public float M0() {
        return this.U0;
    }

    @o0
    public com.google.android.material.shape.o N0() {
        return this.N0;
    }

    @o0
    public View O0() {
        return this.L0;
    }

    @b0
    public int P0() {
        return this.C0;
    }

    public int Q0() {
        return this.I0;
    }

    @o0
    public e R0() {
        return this.O0;
    }

    public int S0() {
        return this.J0;
    }

    @o0
    public e T0() {
        return this.Q0;
    }

    @o0
    public e U0() {
        return this.P0;
    }

    @Override // androidx.transition.Transition
    @o0
    public String[] V() {
        return f18952i1;
    }

    @c.l
    public int V0() {
        return this.G0;
    }

    @o0
    public e X0() {
        return this.R0;
    }

    @c.l
    public int Y0() {
        return this.E0;
    }

    public float Z0() {
        return this.T0;
    }

    @o0
    public com.google.android.material.shape.o a1() {
        return this.M0;
    }

    @o0
    public View b1() {
        return this.K0;
    }

    @b0
    public int c1() {
        return this.B0;
    }

    public int e1() {
        return this.H0;
    }

    public boolean g1() {
        return this.W;
    }

    public boolean h1() {
        return this.S0;
    }

    public boolean j1() {
        return this.X;
    }

    @Override // androidx.transition.Transition
    public void k(@m0 d0 d0Var) {
        H0(d0Var, this.L0, this.C0, this.N0);
    }

    public void l1(@c.l int i7) {
        this.D0 = i7;
        this.E0 = i7;
        this.F0 = i7;
    }

    public void m1(@c.l int i7) {
        this.D0 = i7;
    }

    @Override // androidx.transition.Transition
    public void n(@m0 d0 d0Var) {
        H0(d0Var, this.K0, this.B0, this.M0);
    }

    public void n1(boolean z7) {
        this.W = z7;
    }

    public void o1(@b0 int i7) {
        this.A0 = i7;
    }

    public void p1(boolean z7) {
        this.S0 = z7;
    }

    public void q1(@c.l int i7) {
        this.F0 = i7;
    }

    @Override // androidx.transition.Transition
    @o0
    public Animator r(@m0 ViewGroup viewGroup, @o0 d0 d0Var, @o0 d0 d0Var2) {
        View viewE;
        View view;
        if (d0Var != null && d0Var2 != null) {
            RectF rectF = (RectF) d0Var.f10674a.get(f18950g1);
            com.google.android.material.shape.o oVar = (com.google.android.material.shape.o) d0Var.f10674a.get(f18951h1);
            if (rectF != null && oVar != null) {
                RectF rectF2 = (RectF) d0Var2.f10674a.get(f18950g1);
                com.google.android.material.shape.o oVar2 = (com.google.android.material.shape.o) d0Var2.f10674a.get(f18951h1);
                if (rectF2 == null || oVar2 == null) {
                    Log.w(f18949f1, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                    return null;
                }
                View view2 = d0Var.f10675b;
                View view3 = d0Var2.f10675b;
                View view4 = view3.getParent() != null ? view3 : view2;
                if (this.A0 == view4.getId()) {
                    viewE = (View) view4.getParent();
                    view = view4;
                } else {
                    viewE = u.e(view4, this.A0);
                    view = null;
                }
                RectF rectFI = u.i(viewE);
                float f8 = -rectFI.left;
                float f9 = -rectFI.top;
                RectF rectFF0 = F0(viewE, view, f8, f9);
                rectF.offset(f8, f9);
                rectF2.offset(f8, f9);
                boolean zI1 = i1(rectF, rectF2);
                if (!this.Z) {
                    k1(view4.getContext(), zI1);
                }
                h hVar = new h(N(), view2, rectF, oVar, K0(this.T0, view2), view3, rectF2, oVar2, K0(this.U0, view3), this.D0, this.E0, this.F0, this.G0, zI1, this.S0, com.google.android.material.transition.b.a(this.I0, zI1), com.google.android.material.transition.g.a(this.J0, zI1, rectF, rectF2), E0(zI1), this.W, null);
                hVar.setBounds(Math.round(rectFF0.left), Math.round(rectFF0.top), Math.round(rectFF0.right), Math.round(rectFF0.bottom));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new a(hVar));
                a(new b(viewE, hVar, view2, view3));
                return valueAnimatorOfFloat;
            }
            Log.w(f18949f1, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    public void r1(float f8) {
        this.U0 = f8;
    }

    public void s1(@o0 com.google.android.material.shape.o oVar) {
        this.N0 = oVar;
    }

    public void t1(@o0 View view) {
        this.L0 = view;
    }

    public void u1(@b0 int i7) {
        this.C0 = i7;
    }

    public void v1(int i7) {
        this.I0 = i7;
    }

    public void w1(@o0 e eVar) {
        this.O0 = eVar;
    }

    @Override // androidx.transition.Transition
    public void x0(@o0 PathMotion pathMotion) {
        super.x0(pathMotion);
        this.Y = true;
    }

    public void x1(int i7) {
        this.J0 = i7;
    }

    public void y1(boolean z7) {
        this.X = z7;
    }

    public void z1(@o0 e eVar) {
        this.Q0 = eVar;
    }

    public l(@m0 Context context, boolean z7) {
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.A0 = R.id.content;
        this.B0 = -1;
        this.C0 = -1;
        this.D0 = 0;
        this.E0 = 0;
        this.F0 = 0;
        this.G0 = 1375731712;
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = 0;
        this.S0 = Build.VERSION.SDK_INT >= 28;
        this.T0 = -1.0f;
        this.U0 = -1.0f;
        k1(context, z7);
        this.Z = true;
    }
}
