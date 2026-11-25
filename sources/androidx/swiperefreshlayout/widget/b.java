package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.w;
import androidx.core.view.n2;
import c.m0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class b extends Drawable implements Animatable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f9867i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f9868j = 11.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f9869k = 3.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f9870l = 12;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f9871m = 6;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f9872n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f9873o = 7.5f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f9874p = 2.5f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f9875q = 10;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f9876r = 5;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final float f9878t = 0.75f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final float f9879u = 0.5f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f9880v = 1332;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final float f9881w = 216.0f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final float f9882x = 0.8f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final float f9883y = 0.01f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final float f9884z = 0.20999998f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f9885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f9886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Resources f9887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Animator f9888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f9889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f9890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Interpolator f9865g = new LinearInterpolator();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Interpolator f9866h = new androidx.interpolator.view.animation.b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int[] f9877s = {n2.f6743t};

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f9891a;

        a(d dVar) {
            this.f9891a = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.H(fFloatValue, this.f9891a);
            b.this.e(fFloatValue, this.f9891a, false);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.b$b, reason: collision with other inner class name */
    class C0127b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f9893a;

        C0127b(d dVar) {
            this.f9893a = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.e(1.0f, this.f9893a, true);
            this.f9893a.M();
            this.f9893a.v();
            b bVar = b.this;
            if (!bVar.f9890f) {
                bVar.f9889e += 1.0f;
                return;
            }
            bVar.f9890f = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f9893a.I(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f9889e = 0.0f;
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final RectF f9895a = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Paint f9896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Paint f9897c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Paint f9898d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f9899e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f9900f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f9901g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float f9902h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int[] f9903i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f9904j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f9905k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f9906l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        float f9907m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f9908n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Path f9909o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float f9910p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        float f9911q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f9912r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f9913s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f9914t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        int f9915u;

        d() {
            Paint paint = new Paint();
            this.f9896b = paint;
            Paint paint2 = new Paint();
            this.f9897c = paint2;
            Paint paint3 = new Paint();
            this.f9898d = paint3;
            this.f9899e = 0.0f;
            this.f9900f = 0.0f;
            this.f9901g = 0.0f;
            this.f9902h = 5.0f;
            this.f9910p = 1.0f;
            this.f9914t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        void A(int i7) {
            this.f9898d.setColor(i7);
        }

        void B(float f8) {
            this.f9911q = f8;
        }

        void C(int i7) {
            this.f9915u = i7;
        }

        void D(ColorFilter colorFilter) {
            this.f9896b.setColorFilter(colorFilter);
        }

        void E(int i7) {
            this.f9904j = i7;
            this.f9915u = this.f9903i[i7];
        }

        void F(@m0 int[] iArr) {
            this.f9903i = iArr;
            E(0);
        }

        void G(float f8) {
            this.f9900f = f8;
        }

        void H(float f8) {
            this.f9901g = f8;
        }

        void I(boolean z7) {
            if (this.f9908n != z7) {
                this.f9908n = z7;
            }
        }

        void J(float f8) {
            this.f9899e = f8;
        }

        void K(Paint.Cap cap) {
            this.f9896b.setStrokeCap(cap);
        }

        void L(float f8) {
            this.f9902h = f8;
            this.f9896b.setStrokeWidth(f8);
        }

        void M() {
            this.f9905k = this.f9899e;
            this.f9906l = this.f9900f;
            this.f9907m = this.f9901g;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f9895a;
            float f8 = this.f9911q;
            float fMin = (this.f9902h / 2.0f) + f8;
            if (f8 <= 0.0f) {
                fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f9912r * this.f9910p) / 2.0f, this.f9902h / 2.0f);
            }
            rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
            float f9 = this.f9899e;
            float f10 = this.f9901g;
            float f11 = (f9 + f10) * 360.0f;
            float f12 = ((this.f9900f + f10) * 360.0f) - f11;
            this.f9896b.setColor(this.f9915u);
            this.f9896b.setAlpha(this.f9914t);
            float f13 = this.f9902h / 2.0f;
            rectF.inset(f13, f13);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f9898d);
            float f14 = -f13;
            rectF.inset(f14, f14);
            canvas.drawArc(rectF, f11, f12, false, this.f9896b);
            b(canvas, f11, f12, rectF);
        }

        void b(Canvas canvas, float f8, float f9, RectF rectF) {
            if (this.f9908n) {
                Path path = this.f9909o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f9909o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f10 = (this.f9912r * this.f9910p) / 2.0f;
                this.f9909o.moveTo(0.0f, 0.0f);
                this.f9909o.lineTo(this.f9912r * this.f9910p, 0.0f);
                Path path3 = this.f9909o;
                float f11 = this.f9912r;
                float f12 = this.f9910p;
                path3.lineTo((f11 * f12) / 2.0f, this.f9913s * f12);
                this.f9909o.offset((fMin + rectF.centerX()) - f10, rectF.centerY() + (this.f9902h / 2.0f));
                this.f9909o.close();
                this.f9897c.setColor(this.f9915u);
                this.f9897c.setAlpha(this.f9914t);
                canvas.save();
                canvas.rotate(f8 + f9, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f9909o, this.f9897c);
                canvas.restore();
            }
        }

        int c() {
            return this.f9914t;
        }

        float d() {
            return this.f9913s;
        }

        float e() {
            return this.f9910p;
        }

        float f() {
            return this.f9912r;
        }

        int g() {
            return this.f9898d.getColor();
        }

        float h() {
            return this.f9911q;
        }

        int[] i() {
            return this.f9903i;
        }

        float j() {
            return this.f9900f;
        }

        int k() {
            return this.f9903i[l()];
        }

        int l() {
            return (this.f9904j + 1) % this.f9903i.length;
        }

        float m() {
            return this.f9901g;
        }

        boolean n() {
            return this.f9908n;
        }

        float o() {
            return this.f9899e;
        }

        int p() {
            return this.f9903i[this.f9904j];
        }

        float q() {
            return this.f9906l;
        }

        float r() {
            return this.f9907m;
        }

        float s() {
            return this.f9905k;
        }

        Paint.Cap t() {
            return this.f9896b.getStrokeCap();
        }

        float u() {
            return this.f9902h;
        }

        void v() {
            E(l());
        }

        void w() {
            this.f9905k = 0.0f;
            this.f9906l = 0.0f;
            this.f9907m = 0.0f;
            J(0.0f);
            G(0.0f);
            H(0.0f);
        }

        void x(int i7) {
            this.f9914t = i7;
        }

        void y(float f8, float f9) {
            this.f9912r = (int) f8;
            this.f9913s = (int) f9;
        }

        void z(float f8) {
            if (f8 != this.f9910p) {
                this.f9910p = f8;
            }
        }
    }

    public b(@m0 Context context) {
        this.f9887c = ((Context) w.l(context)).getResources();
        d dVar = new d();
        this.f9885a = dVar;
        dVar.F(f9877s);
        E(f9874p);
        G();
    }

    private void A(float f8) {
        this.f9886b = f8;
    }

    private void B(float f8, float f9, float f10, float f11) {
        d dVar = this.f9885a;
        float f12 = this.f9887c.getDisplayMetrics().density;
        dVar.L(f9 * f12);
        dVar.B(f8 * f12);
        dVar.E(0);
        dVar.y(f10 * f12, f11 * f12);
    }

    private void G() {
        d dVar = this.f9885a;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(dVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f9865g);
        valueAnimatorOfFloat.addListener(new C0127b(dVar));
        this.f9888d = valueAnimatorOfFloat;
    }

    private void a(float f8, d dVar) {
        H(f8, dVar);
        float fFloor = (float) (Math.floor(dVar.r() / f9882x) + 1.0d);
        dVar.J(dVar.s() + (((dVar.q() - f9883y) - dVar.s()) * f8));
        dVar.G(dVar.q());
        dVar.H(dVar.r() + ((fFloor - dVar.r()) * f8));
    }

    private int f(float f8, int i7, int i8) {
        int i9 = (i7 >> 24) & 255;
        int i10 = (i7 >> 16) & 255;
        int i11 = (i7 >> 8) & 255;
        int i12 = i7 & 255;
        return ((i9 + ((int) ((((i8 >> 24) & 255) - i9) * f8))) << 24) | ((i10 + ((int) ((((i8 >> 16) & 255) - i10) * f8))) << 16) | ((i11 + ((int) ((((i8 >> 8) & 255) - i11) * f8))) << 8) | (i12 + ((int) (f8 * ((i8 & 255) - i12))));
    }

    private float p() {
        return this.f9886b;
    }

    public void C(float f8, float f9) {
        this.f9885a.J(f8);
        this.f9885a.G(f9);
        invalidateSelf();
    }

    public void D(@m0 Paint.Cap cap) {
        this.f9885a.K(cap);
        invalidateSelf();
    }

    public void E(float f8) {
        this.f9885a.L(f8);
        invalidateSelf();
    }

    public void F(int i7) {
        if (i7 == 0) {
            B(f9868j, f9869k, 12.0f, 6.0f);
        } else {
            B(f9873o, f9874p, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    void H(float f8, d dVar) {
        if (f8 > 0.75f) {
            dVar.C(f((f8 - 0.75f) / 0.25f, dVar.p(), dVar.k()));
        } else {
            dVar.C(dVar.p());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f9886b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f9885a.a(canvas, bounds);
        canvas.restore();
    }

    void e(float f8, d dVar, boolean z7) {
        float interpolation;
        float interpolation2;
        if (this.f9890f) {
            a(f8, dVar);
            return;
        }
        if (f8 != 1.0f || z7) {
            float fR = dVar.r();
            if (f8 < 0.5f) {
                interpolation = dVar.s();
                interpolation2 = (f9866h.getInterpolation(f8 / 0.5f) * 0.79f) + f9883y + interpolation;
            } else {
                float fS = dVar.s() + 0.79f;
                interpolation = fS - (((1.0f - f9866h.getInterpolation((f8 - 0.5f) / 0.5f)) * 0.79f) + f9883y);
                interpolation2 = fS;
            }
            float f9 = fR + (f9884z * f8);
            float f10 = (f8 + this.f9889e) * f9881w;
            dVar.J(interpolation);
            dVar.G(interpolation2);
            dVar.H(f9);
            A(f10);
        }
    }

    public boolean g() {
        return this.f9885a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f9885a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        return this.f9885a.d();
    }

    public float i() {
        return this.f9885a.e();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f9888d.isRunning();
    }

    public float j() {
        return this.f9885a.f();
    }

    public int k() {
        return this.f9885a.g();
    }

    public float l() {
        return this.f9885a.h();
    }

    @m0
    public int[] m() {
        return this.f9885a.i();
    }

    public float n() {
        return this.f9885a.j();
    }

    public float o() {
        return this.f9885a.m();
    }

    public float q() {
        return this.f9885a.o();
    }

    @m0
    public Paint.Cap r() {
        return this.f9885a.t();
    }

    public float s() {
        return this.f9885a.u();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f9885a.x(i7);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9885a.D(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f9888d.cancel();
        this.f9885a.M();
        if (this.f9885a.j() != this.f9885a.o()) {
            this.f9890f = true;
            this.f9888d.setDuration(666L);
            this.f9888d.start();
        } else {
            this.f9885a.E(0);
            this.f9885a.w();
            this.f9888d.setDuration(1332L);
            this.f9888d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f9888d.cancel();
        A(0.0f);
        this.f9885a.I(false);
        this.f9885a.E(0);
        this.f9885a.w();
        invalidateSelf();
    }

    public void t(float f8, float f9) {
        this.f9885a.y(f8, f9);
        invalidateSelf();
    }

    public void u(boolean z7) {
        this.f9885a.I(z7);
        invalidateSelf();
    }

    public void v(float f8) {
        this.f9885a.z(f8);
        invalidateSelf();
    }

    public void w(int i7) {
        this.f9885a.A(i7);
        invalidateSelf();
    }

    public void x(float f8) {
        this.f9885a.B(f8);
        invalidateSelf();
    }

    public void y(@m0 int... iArr) {
        this.f9885a.F(iArr);
        this.f9885a.E(0);
        invalidateSelf();
    }

    public void z(float f8) {
        this.f9885a.H(f8);
        invalidateSelf();
    }
}
