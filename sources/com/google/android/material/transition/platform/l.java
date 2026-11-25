package com.google.android.material.transition.platform;

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
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.view.n2;
import c.b0;
import c.b1;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
public final class l extends Transition {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 0;
    public static final int D = 1;
    public static final int E = 2;
    public static final int F = 3;
    public static final int G = 0;
    public static final int H = 1;
    public static final int I = 2;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final String f19037J = "l";
    private static final f O;
    private static final f Q;
    private static final float R = -1.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f19038z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f19039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f19040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b0
    private int f19043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b0
    private int f19044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @b0
    private int f19045g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c.l
    private int f19046h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @c.l
    private int f19047i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c.l
    private int f19048j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c.l
    private int f19049k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f19050l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f19051m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f19052n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @o0
    private View f19053o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    private View f19054p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @o0
    private com.google.android.material.shape.o f19055q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @o0
    private com.google.android.material.shape.o f19056r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @o0
    private e f19057s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @o0
    private e f19058t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @o0
    private e f19059u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @o0
    private e f19060v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f19061w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f19062x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f19063y;
    private static final String K = "materialContainerTransition:bounds";
    private static final String L = "materialContainerTransition:shapeAppearance";
    private static final String[] M = {K, L};
    private static final f N = new f(new e(0.0f, 0.25f), new e(0.0f, 1.0f), new e(0.0f, 1.0f), new e(0.0f, 0.75f), null);
    private static final f P = new f(new e(0.1f, 0.4f), new e(0.1f, 1.0f), new e(0.1f, 1.0f), new e(0.1f, 0.9f), null);

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f19064a;

        a(h hVar) {
            this.f19064a = hVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f19064a.o(valueAnimator.getAnimatedFraction());
        }
    }

    class b extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f19066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f19067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f19068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f19069d;

        b(View view, h hVar, View view2, View view3) {
            this.f19066a = view;
            this.f19067b = hVar;
            this.f19068c = view2;
            this.f19069d = view3;
        }

        @Override // com.google.android.material.transition.platform.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(@m0 Transition transition) {
            l.this.removeListener(this);
            if (l.this.f19040b) {
                return;
            }
            this.f19068c.setAlpha(1.0f);
            this.f19069d.setAlpha(1.0f);
            com.google.android.material.internal.v.h(this.f19066a).b(this.f19067b);
        }

        @Override // com.google.android.material.transition.platform.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(@m0 Transition transition) {
            com.google.android.material.internal.v.h(this.f19066a).a(this.f19067b);
            this.f19068c.setAlpha(0.0f);
            this.f19069d.setAlpha(0.0f);
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
        private final float f19071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c.v(from = 0.0d, to = 1.0d)
        private final float f19072b;

        public e(@c.v(from = 0.0d, to = 1.0d) float f8, @c.v(from = 0.0d, to = 1.0d) float f9) {
            this.f19071a = f8;
            this.f19072b = f9;
        }

        @c.v(from = 0.0d, to = 1.0d)
        public float c() {
            return this.f19072b;
        }

        @c.v(from = 0.0d, to = 1.0d)
        public float d() {
            return this.f19071a;
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final e f19073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        private final e f19074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m0
        private final e f19075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @m0
        private final e f19076d;

        /* synthetic */ f(e eVar, e eVar2, e eVar3, e eVar4, a aVar) {
            this(eVar, eVar2, eVar3, eVar4);
        }

        private f(@m0 e eVar, @m0 e eVar2, @m0 e eVar3, @m0 e eVar4) {
            this.f19073a = eVar;
            this.f19074b = eVar2;
            this.f19075c = eVar3;
            this.f19076d = eVar4;
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
        private final com.google.android.material.transition.platform.a B;
        private final com.google.android.material.transition.platform.f C;
        private final boolean D;
        private final Paint E;
        private final Path F;
        private com.google.android.material.transition.platform.c G;
        private com.google.android.material.transition.platform.h H;
        private RectF I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        private float f19077J;
        private float K;
        private float L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f19078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RectF f19079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.google.android.material.shape.o f19080c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f19081d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final View f19082e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final RectF f19083f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final com.google.android.material.shape.o f19084g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f19085h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Paint f19086i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Paint f19087j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final Paint f19088k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Paint f19089l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Paint f19090m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final j f19091n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final PathMeasure f19092o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final float f19093p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final float[] f19094q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final boolean f19095r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final float f19096s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final float f19097t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f19098u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final com.google.android.material.shape.j f19099v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final RectF f19100w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final RectF f19101x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final RectF f19102y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private final RectF f19103z;

        class a implements v.c {
            a() {
            }

            @Override // com.google.android.material.transition.platform.v.c
            public void a(Canvas canvas) {
                h.this.f19078a.draw(canvas);
            }
        }

        class b implements v.c {
            b() {
            }

            @Override // com.google.android.material.transition.platform.v.c
            public void a(Canvas canvas) {
                h.this.f19082e.draw(canvas);
            }
        }

        /* synthetic */ h(PathMotion pathMotion, View view, RectF rectF, com.google.android.material.shape.o oVar, float f8, View view2, RectF rectF2, com.google.android.material.shape.o oVar2, float f9, int i7, int i8, int i9, int i10, boolean z7, boolean z8, com.google.android.material.transition.platform.a aVar, com.google.android.material.transition.platform.f fVar, f fVar2, boolean z9, a aVar2) {
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
            canvas.clipPath(this.f19091n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        private void i(Canvas canvas) {
            com.google.android.material.shape.j jVar = this.f19099v;
            RectF rectF = this.I;
            jVar.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.f19099v.m0(this.f19077J);
            this.f19099v.A0((int) this.K);
            this.f19099v.setShapeAppearanceModel(this.f19091n.c());
            this.f19099v.draw(canvas);
        }

        private void j(Canvas canvas) {
            com.google.android.material.shape.o oVarC = this.f19091n.c();
            if (!oVarC.u(this.I)) {
                canvas.drawPath(this.f19091n.d(), this.f19089l);
            } else {
                float fA = oVarC.r().a(this.I);
                canvas.drawRoundRect(this.I, fA, fA, this.f19089l);
            }
        }

        private void k(Canvas canvas) {
            n(canvas, this.f19088k);
            Rect bounds = getBounds();
            RectF rectF = this.f19102y;
            v.A(canvas, bounds, rectF.left, rectF.top, this.H.f19027b, this.G.f19005b, new b());
        }

        private void l(Canvas canvas) {
            n(canvas, this.f19087j);
            Rect bounds = getBounds();
            RectF rectF = this.f19100w;
            v.A(canvas, bounds, rectF.left, rectF.top, this.H.f19026a, this.G.f19004a, new a());
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
            this.f19090m.setAlpha((int) (this.f19095r ? v.n(0.0f, 255.0f, f8) : v.n(255.0f, 0.0f, f8)));
            this.f19092o.getPosTan(this.f19093p * f8, this.f19094q, null);
            float[] fArr = this.f19094q;
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
                this.f19092o.getPosTan(this.f19093p * f9, fArr, null);
                float[] fArr2 = this.f19094q;
                f11 += (f11 - fArr2[0]) * f10;
                f12 += (f12 - fArr2[1]) * f10;
            }
            float f13 = f11;
            float f14 = f12;
            com.google.android.material.transition.platform.h hVarA = this.C.a(f8, ((Float) androidx.core.util.w.l(Float.valueOf(this.A.f19074b.f19071a))).floatValue(), ((Float) androidx.core.util.w.l(Float.valueOf(this.A.f19074b.f19072b))).floatValue(), this.f19079b.width(), this.f19079b.height(), this.f19083f.width(), this.f19083f.height());
            this.H = hVarA;
            RectF rectF = this.f19100w;
            float f15 = hVarA.f19028c;
            rectF.set(f13 - (f15 / 2.0f), f14, (f15 / 2.0f) + f13, hVarA.f19029d + f14);
            RectF rectF2 = this.f19102y;
            com.google.android.material.transition.platform.h hVar = this.H;
            float f16 = hVar.f19030e;
            rectF2.set(f13 - (f16 / 2.0f), f14, f13 + (f16 / 2.0f), hVar.f19031f + f14);
            this.f19101x.set(this.f19100w);
            this.f19103z.set(this.f19102y);
            float fFloatValue = ((Float) androidx.core.util.w.l(Float.valueOf(this.A.f19075c.f19071a))).floatValue();
            float fFloatValue2 = ((Float) androidx.core.util.w.l(Float.valueOf(this.A.f19075c.f19072b))).floatValue();
            boolean zB = this.C.b(this.H);
            RectF rectF3 = zB ? this.f19101x : this.f19103z;
            float fO = v.o(0.0f, 1.0f, fFloatValue, fFloatValue2, f8);
            if (!zB) {
                fO = 1.0f - fO;
            }
            this.C.c(rectF3, fO, this.H);
            this.I = new RectF(Math.min(this.f19101x.left, this.f19103z.left), Math.min(this.f19101x.top, this.f19103z.top), Math.max(this.f19101x.right, this.f19103z.right), Math.max(this.f19101x.bottom, this.f19103z.bottom));
            this.f19091n.b(f8, this.f19080c, this.f19084g, this.f19100w, this.f19101x, this.f19103z, this.A.f19076d);
            this.f19077J = v.n(this.f19081d, this.f19085h, f8);
            float fD = d(this.I, this.f19096s);
            float fE = e(this.I, this.f19097t);
            float f17 = this.f19077J;
            float f18 = (int) (fE * f17);
            this.K = f18;
            this.f19089l.setShadowLayer(f17, (int) (fD * f17), f18, M);
            this.G = this.B.a(f8, ((Float) androidx.core.util.w.l(Float.valueOf(this.A.f19073a.f19071a))).floatValue(), ((Float) androidx.core.util.w.l(Float.valueOf(this.A.f19073a.f19072b))).floatValue(), 0.35f);
            if (this.f19087j.getColor() != 0) {
                this.f19087j.setAlpha(this.G.f19004a);
            }
            if (this.f19088k.getColor() != 0) {
                this.f19088k.setAlpha(this.G.f19005b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@m0 Canvas canvas) {
            if (this.f19090m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f19090m);
            }
            int iSave = this.D ? canvas.save() : -1;
            if (this.f19098u && this.f19077J > 0.0f) {
                h(canvas);
            }
            this.f19091n.a(canvas);
            n(canvas, this.f19086i);
            if (this.G.f19006c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(iSave);
                f(canvas, this.f19100w, this.F, -65281);
                g(canvas, this.f19101x, androidx.core.view.o0.f6793u);
                g(canvas, this.f19100w, -16711936);
                g(canvas, this.f19103z, -16711681);
                g(canvas, this.f19102y, -16776961);
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

        private h(PathMotion pathMotion, View view, RectF rectF, com.google.android.material.shape.o oVar, float f8, View view2, RectF rectF2, com.google.android.material.shape.o oVar2, float f9, @c.l int i7, @c.l int i8, @c.l int i9, int i10, boolean z7, boolean z8, com.google.android.material.transition.platform.a aVar, com.google.android.material.transition.platform.f fVar, f fVar2, boolean z9) {
            Paint paint = new Paint();
            this.f19086i = paint;
            Paint paint2 = new Paint();
            this.f19087j = paint2;
            Paint paint3 = new Paint();
            this.f19088k = paint3;
            this.f19089l = new Paint();
            Paint paint4 = new Paint();
            this.f19090m = paint4;
            this.f19091n = new j();
            this.f19094q = new float[]{rectF.centerX(), rectF.top};
            com.google.android.material.shape.j jVar = new com.google.android.material.shape.j();
            this.f19099v = jVar;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f19078a = view;
            this.f19079b = rectF;
            this.f19080c = oVar;
            this.f19081d = f8;
            this.f19082e = view2;
            this.f19083f = rectF2;
            this.f19084g = oVar2;
            this.f19085h = f9;
            this.f19095r = z7;
            this.f19098u = z8;
            this.B = aVar;
            this.C = fVar;
            this.A = fVar2;
            this.D = z9;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.f19096s = displayMetrics.widthPixels;
            this.f19097t = displayMetrics.heightPixels;
            paint.setColor(i7);
            paint2.setColor(i8);
            paint3.setColor(i9);
            jVar.n0(ColorStateList.valueOf(0));
            jVar.w0(2);
            jVar.t0(false);
            jVar.u0(N);
            RectF rectF3 = new RectF(rectF);
            this.f19100w = rectF3;
            this.f19101x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.f19102y = rectF4;
            this.f19103z = new RectF(rectF4);
            PointF pointFM = m(rectF);
            PointF pointFM2 = m(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(pointFM.x, pointFM.y, pointFM2.x, pointFM2.y), false);
            this.f19092o = pathMeasure;
            this.f19093p = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(v.c(i10));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    static {
        a aVar = null;
        O = new f(new e(0.6f, 0.9f), new e(0.0f, 1.0f), new e(0.0f, 0.9f), new e(0.3f, 0.9f), aVar);
        Q = new f(new e(0.6f, 0.9f), new e(0.0f, 0.9f), new e(0.0f, 0.9f), new e(0.2f, 0.9f), aVar);
    }

    public l() {
        this.f19039a = false;
        this.f19040b = false;
        this.f19041c = false;
        this.f19042d = false;
        this.f19043e = R.id.content;
        this.f19044f = -1;
        this.f19045g = -1;
        this.f19046h = 0;
        this.f19047i = 0;
        this.f19048j = 0;
        this.f19049k = 1375731712;
        this.f19050l = 0;
        this.f19051m = 0;
        this.f19052n = 0;
        this.f19061w = Build.VERSION.SDK_INT >= 28;
        this.f19062x = -1.0f;
        this.f19063y = -1.0f;
    }

    private f C(boolean z7, f fVar, f fVar2) {
        if (!z7) {
            fVar = fVar2;
        }
        return new f((e) v.d(this.f19057s, fVar.f19073a), (e) v.d(this.f19058t, fVar.f19074b), (e) v.d(this.f19059u, fVar.f19075c), (e) v.d(this.f19060v, fVar.f19076d), null);
    }

    @b1
    private static int E(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean H(@m0 RectF rectF, @m0 RectF rectF2) {
        int i7 = this.f19050l;
        if (i7 == 0) {
            return v.a(rectF2) > v.a(rectF);
        }
        if (i7 == 1) {
            return true;
        }
        if (i7 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid transition direction: " + this.f19050l);
    }

    private void J(Context context, boolean z7) {
        v.u(this, context, com.google.android.material.R.attr.motionEasingStandard, com.google.android.material.animation.a.f16847b);
        v.t(this, context, z7 ? com.google.android.material.R.attr.motionDurationLong1 : com.google.android.material.R.attr.motionDurationMedium2);
        if (this.f19041c) {
            return;
        }
        v.v(this, context, com.google.android.material.R.attr.motionPath);
    }

    private f b(boolean z7) {
        PathMotion pathMotion = getPathMotion();
        return ((pathMotion instanceof ArcMotion) || (pathMotion instanceof k)) ? C(z7, P, Q) : C(z7, N, O);
    }

    private static RectF c(View view, @o0 View view2, float f8, float f9) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF rectFI = v.i(view2);
        rectFI.offset(f8, f9);
        return rectFI;
    }

    private static com.google.android.material.shape.o d(@m0 View view, @m0 RectF rectF, @o0 com.google.android.material.shape.o oVar) {
        return v.b(v(view, oVar), rectF);
    }

    private static void e(@m0 TransitionValues transitionValues, @o0 View view, @b0 int i7, @o0 com.google.android.material.shape.o oVar) {
        if (i7 != -1) {
            transitionValues.view = v.f(transitionValues.view, i7);
        } else if (view != null) {
            transitionValues.view = view;
        } else if (transitionValues.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof View) {
            View view2 = (View) transitionValues.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
            transitionValues.view.setTag(com.google.android.material.R.id.mtrl_motion_snapshot_view, null);
            transitionValues.view = view2;
        }
        View view3 = transitionValues.view;
        if (!n2.U0(view3) && view3.getWidth() == 0 && view3.getHeight() == 0) {
            return;
        }
        RectF rectFJ = view3.getParent() == null ? v.j(view3) : v.i(view3);
        transitionValues.values.put(K, rectFJ);
        transitionValues.values.put(L, d(view3, rectFJ, oVar));
    }

    private static float j(float f8, View view) {
        return f8 != -1.0f ? f8 : n2.R(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.google.android.material.shape.o v(@m0 View view, @o0 com.google.android.material.shape.o oVar) {
        if (oVar != null) {
            return oVar;
        }
        if (view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof com.google.android.material.shape.o) {
            return (com.google.android.material.shape.o) view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
        }
        Context context = view.getContext();
        int iE = E(context);
        if (iE != -1) {
            return com.google.android.material.shape.o.b(context, iE, 0).m();
        }
        return view instanceof com.google.android.material.shape.s ? ((com.google.android.material.shape.s) view).getShapeAppearanceModel() : com.google.android.material.shape.o.a().m();
    }

    @o0
    public View A() {
        return this.f19053o;
    }

    @b0
    public int B() {
        return this.f19044f;
    }

    public int D() {
        return this.f19050l;
    }

    public boolean F() {
        return this.f19039a;
    }

    public boolean G() {
        return this.f19061w;
    }

    public boolean I() {
        return this.f19040b;
    }

    public void L(@c.l int i7) {
        this.f19046h = i7;
        this.f19047i = i7;
        this.f19048j = i7;
    }

    public void M(@c.l int i7) {
        this.f19046h = i7;
    }

    public void N(boolean z7) {
        this.f19039a = z7;
    }

    public void O(@b0 int i7) {
        this.f19043e = i7;
    }

    public void P(boolean z7) {
        this.f19061w = z7;
    }

    public void Q(@c.l int i7) {
        this.f19048j = i7;
    }

    public void R(float f8) {
        this.f19063y = f8;
    }

    public void S(@o0 com.google.android.material.shape.o oVar) {
        this.f19056r = oVar;
    }

    public void T(@o0 View view) {
        this.f19054p = view;
    }

    public void U(@b0 int i7) {
        this.f19045g = i7;
    }

    public void V(int i7) {
        this.f19051m = i7;
    }

    public void W(@o0 e eVar) {
        this.f19057s = eVar;
    }

    public void X(int i7) {
        this.f19052n = i7;
    }

    public void Y(boolean z7) {
        this.f19040b = z7;
    }

    public void Z(@o0 e eVar) {
        this.f19059u = eVar;
    }

    public void a0(@o0 e eVar) {
        this.f19058t = eVar;
    }

    public void b0(@c.l int i7) {
        this.f19049k = i7;
    }

    public void c0(@o0 e eVar) {
        this.f19060v = eVar;
    }

    @Override // android.transition.Transition
    public void captureEndValues(@m0 TransitionValues transitionValues) {
        e(transitionValues, this.f19054p, this.f19045g, this.f19056r);
    }

    @Override // android.transition.Transition
    public void captureStartValues(@m0 TransitionValues transitionValues) {
        e(transitionValues, this.f19053o, this.f19044f, this.f19055q);
    }

    @Override // android.transition.Transition
    @o0
    public Animator createAnimator(@m0 ViewGroup viewGroup, @o0 TransitionValues transitionValues, @o0 TransitionValues transitionValues2) {
        View viewE;
        View view;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF = (RectF) transitionValues.values.get(K);
            com.google.android.material.shape.o oVar = (com.google.android.material.shape.o) transitionValues.values.get(L);
            if (rectF != null && oVar != null) {
                RectF rectF2 = (RectF) transitionValues2.values.get(K);
                com.google.android.material.shape.o oVar2 = (com.google.android.material.shape.o) transitionValues2.values.get(L);
                if (rectF2 == null || oVar2 == null) {
                    Log.w(f19037J, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                    return null;
                }
                View view2 = transitionValues.view;
                View view3 = transitionValues2.view;
                View view4 = view3.getParent() != null ? view3 : view2;
                if (this.f19043e == view4.getId()) {
                    viewE = (View) view4.getParent();
                    view = view4;
                } else {
                    viewE = v.e(view4, this.f19043e);
                    view = null;
                }
                RectF rectFI = v.i(viewE);
                float f8 = -rectFI.left;
                float f9 = -rectFI.top;
                RectF rectFC = c(viewE, view, f8, f9);
                rectF.offset(f8, f9);
                rectF2.offset(f8, f9);
                boolean zH = H(rectF, rectF2);
                if (!this.f19042d) {
                    J(view4.getContext(), zH);
                }
                h hVar = new h(getPathMotion(), view2, rectF, oVar, j(this.f19062x, view2), view3, rectF2, oVar2, j(this.f19063y, view3), this.f19046h, this.f19047i, this.f19048j, this.f19049k, zH, this.f19061w, com.google.android.material.transition.platform.b.a(this.f19051m, zH), com.google.android.material.transition.platform.g.a(this.f19052n, zH, rectF, rectF2), b(zH), this.f19039a, null);
                hVar.setBounds(Math.round(rectFC.left), Math.round(rectFC.top), Math.round(rectFC.right), Math.round(rectFC.bottom));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new a(hVar));
                addListener(new b(viewE, hVar, view2, view3));
                return valueAnimatorOfFloat;
            }
            Log.w(f19037J, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    public void d0(@c.l int i7) {
        this.f19047i = i7;
    }

    public void e0(float f8) {
        this.f19062x = f8;
    }

    public void f0(@o0 com.google.android.material.shape.o oVar) {
        this.f19055q = oVar;
    }

    public void g0(@o0 View view) {
        this.f19053o = view;
    }

    @Override // android.transition.Transition
    @o0
    public String[] getTransitionProperties() {
        return M;
    }

    @c.l
    public int h() {
        return this.f19046h;
    }

    public void h0(@b0 int i7) {
        this.f19044f = i7;
    }

    @b0
    public int i() {
        return this.f19043e;
    }

    public void i0(int i7) {
        this.f19050l = i7;
    }

    @c.l
    public int k() {
        return this.f19048j;
    }

    public float l() {
        return this.f19063y;
    }

    @o0
    public com.google.android.material.shape.o m() {
        return this.f19056r;
    }

    @o0
    public View n() {
        return this.f19054p;
    }

    @b0
    public int o() {
        return this.f19045g;
    }

    public int p() {
        return this.f19051m;
    }

    @o0
    public e q() {
        return this.f19057s;
    }

    public int r() {
        return this.f19052n;
    }

    @o0
    public e s() {
        return this.f19059u;
    }

    @Override // android.transition.Transition
    public void setPathMotion(@o0 PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f19041c = true;
    }

    @o0
    public e t() {
        return this.f19058t;
    }

    @c.l
    public int u() {
        return this.f19049k;
    }

    @o0
    public e w() {
        return this.f19060v;
    }

    @c.l
    public int x() {
        return this.f19047i;
    }

    public float y() {
        return this.f19062x;
    }

    @o0
    public com.google.android.material.shape.o z() {
        return this.f19055q;
    }

    public l(@m0 Context context, boolean z7) {
        this.f19039a = false;
        this.f19040b = false;
        this.f19041c = false;
        this.f19042d = false;
        this.f19043e = R.id.content;
        this.f19044f = -1;
        this.f19045g = -1;
        this.f19046h = 0;
        this.f19047i = 0;
        this.f19048j = 0;
        this.f19049k = 1375731712;
        this.f19050l = 0;
        this.f19051m = 0;
        this.f19052n = 0;
        this.f19061w = Build.VERSION.SDK_INT >= 28;
        this.f19062x = -1.0f;
        this.f19063y = -1.0f;
        J(context, z7);
        this.f19042d = true;
    }
}
