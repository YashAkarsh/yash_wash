package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.n2;
import c.o0;
import c.q;
import c.r0;
import c.v;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f18766r = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ValueAnimator f18767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f18768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f18769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f18770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<d> f18773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f18774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f18775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Paint f18776j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final RectF f18777k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @r0
    private final int f18778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f18779m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f18780n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private c f18781o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private double f18782p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f18783q;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.n(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void e(@v(from = 0.0d, to = 360.0d) float f8, boolean z7);
    }

    public interface d {
        void d(@v(from = 0.0d, to = 360.0d) float f8, boolean z7);
    }

    public ClockHandView(Context context) {
        this(context, null);
    }

    private void c(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f8 = width;
        float fCos = (this.f18783q * ((float) Math.cos(this.f18782p))) + f8;
        float f9 = height;
        float fSin = (this.f18783q * ((float) Math.sin(this.f18782p))) + f9;
        this.f18776j.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f18774h, this.f18776j);
        double dSin = Math.sin(this.f18782p);
        double dCos = Math.cos(this.f18782p);
        double d8 = this.f18783q - this.f18774h;
        this.f18776j.setStrokeWidth(this.f18778l);
        canvas.drawLine(f8, f9, width + ((int) (dCos * d8)), height + ((int) (d8 * dSin)), this.f18776j);
        canvas.drawCircle(f8, f9, this.f18775i, this.f18776j);
    }

    private int e(float f8, float f9) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f9 - (getHeight() / 2), f8 - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    private Pair<Float, Float> h(float f8) {
        float f9 = f();
        if (Math.abs(f9 - f8) > 180.0f) {
            if (f9 > 180.0f && f8 < 180.0f) {
                f8 += 360.0f;
            }
            if (f9 < 180.0f && f8 > 180.0f) {
                f9 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(f9), Float.valueOf(f8));
    }

    private boolean i(float f8, float f9, boolean z7, boolean z8, boolean z9) {
        float fE = e(f8, f9);
        boolean z10 = false;
        boolean z11 = f() != fE;
        if (z8 && z11) {
            return true;
        }
        if (!z11 && !z7) {
            return false;
        }
        if (z9 && this.f18768b) {
            z10 = true;
        }
        m(fE, z10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@v(from = 0.0d, to = 360.0d) float f8, boolean z7) {
        float f9 = f8 % 360.0f;
        this.f18779m = f9;
        this.f18782p = Math.toRadians(f9 - 90.0f);
        int height = getHeight() / 2;
        float width = (getWidth() / 2) + (this.f18783q * ((float) Math.cos(this.f18782p)));
        float fSin = height + (this.f18783q * ((float) Math.sin(this.f18782p)));
        RectF rectF = this.f18777k;
        int i7 = this.f18774h;
        rectF.set(width - i7, fSin - i7, width + i7, fSin + i7);
        Iterator<d> it = this.f18773g.iterator();
        while (it.hasNext()) {
            it.next().d(f9, z7);
        }
        invalidate();
    }

    public void b(d dVar) {
        this.f18773g.add(dVar);
    }

    public RectF d() {
        return this.f18777k;
    }

    @v(from = 0.0d, to = 360.0d)
    public float f() {
        return this.f18779m;
    }

    public int g() {
        return this.f18774h;
    }

    public void j(boolean z7) {
        this.f18768b = z7;
    }

    public void k(@q int i7) {
        this.f18783q = i7;
        invalidate();
    }

    public void l(@v(from = 0.0d, to = 360.0d) float f8) {
        m(f8, false);
    }

    public void m(@v(from = 0.0d, to = 360.0d) float f8, boolean z7) {
        ValueAnimator valueAnimator = this.f18767a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z7) {
            n(f8, false);
            return;
        }
        Pair<Float, Float> pairH = h(f8);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((Float) pairH.first).floatValue(), ((Float) pairH.second).floatValue());
        this.f18767a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.f18767a.addUpdateListener(new a());
        this.f18767a.addListener(new b());
        this.f18767a.start();
    }

    public void o(c cVar) {
        this.f18781o = cVar;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        l(f());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z7;
        boolean z8;
        boolean z9;
        c cVar;
        int actionMasked = motionEvent.getActionMasked();
        float x7 = motionEvent.getX();
        float y7 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f18769c = x7;
            this.f18770d = y7;
            this.f18771e = true;
            this.f18780n = false;
            z7 = false;
            z8 = false;
            z9 = true;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i7 = (int) (x7 - this.f18769c);
            int i8 = (int) (y7 - this.f18770d);
            this.f18771e = (i7 * i7) + (i8 * i8) > this.f18772f;
            boolean z10 = this.f18780n;
            z7 = actionMasked == 1;
            z9 = false;
            z8 = z10;
        } else {
            z7 = false;
            z8 = false;
            z9 = false;
        }
        boolean zI = i(x7, y7, z8, z9, z7) | this.f18780n;
        this.f18780n = zI;
        if (zI && z7 && (cVar = this.f18781o) != null) {
            cVar.e(e(x7, y7), this.f18771e);
        }
        return true;
    }

    public ClockHandView(Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public ClockHandView(Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f18773g = new ArrayList();
        Paint paint = new Paint();
        this.f18776j = paint;
        this.f18777k = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i7, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.f18783q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.f18774h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.f18778l = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f18775i = resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        l(0.0f);
        this.f18772f = ViewConfiguration.get(context).getScaledTouchSlop();
        n2.R1(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
