package com.haier.globalwasher.view.custom_view.wave_imageview;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class WaveFunctionView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Path f25947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f25948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f25949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PointF f25950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PointF f25951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ValueAnimator f25952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ValueAnimator f25953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f25954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f25955i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f25956j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f25957k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f25958l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f25959m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f25960n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Boolean f25961o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Boolean f25962p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f25963q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f25964r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f25965s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f25966t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Double f25967u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f25968v;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveFunctionView.this.f25959m = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveFunctionView.this.f25956j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
    }

    public WaveFunctionView(Context context) {
        super(context);
        this.f25957k = 15.0f;
        this.f25958l = 20.0f;
        this.f25959m = 20.0f;
        this.f25960n = 0.0f;
        Boolean bool = Boolean.TRUE;
        this.f25961o = bool;
        this.f25962p = bool;
        this.f25963q = "#4194f0";
        this.f25964r = "#0000FF";
        this.f25965s = Color.parseColor("#4194f0");
        this.f25966t = Color.parseColor(this.f25963q);
        this.f25967u = Double.valueOf(0.017453292519943295d);
        this.f25968v = 0;
        d();
    }

    @SuppressLint({"ResourceAsColor"})
    private void d() {
        this.f25947a = new Path();
        Paint paint = new Paint();
        this.f25948b = paint;
        paint.setColor(this.f25965s);
        this.f25948b.setAntiAlias(this.f25962p.booleanValue());
        this.f25948b.setStyle(Paint.Style.FILL);
        this.f25948b.setAlpha(255);
        Paint paint2 = new Paint();
        this.f25949c = paint2;
        paint2.setAntiAlias(this.f25962p.booleanValue());
        this.f25949c.setStyle(Paint.Style.FILL);
        this.f25949c.setColor(this.f25966t);
        this.f25949c.setAlpha(100);
        this.f25950d = new PointF(0.0f, 0.0f);
        this.f25951e = new PointF(0.0f, 0.0f);
    }

    public void c(int i7) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f25957k, this.f25958l);
        this.f25952f = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.f25952f.setInterpolator(new LinearInterpolator());
        this.f25952f.addUpdateListener(new a());
        this.f25952f.setRepeatMode(2);
        this.f25952f.setRepeatCount(1);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.f25956j, (this.f25955i * (10 - i7)) / 10.0f);
        this.f25953g = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setDuration(com.haier.uhome.ble.hal.a.b.a.f28246a);
        this.f25953g.setInterpolator(new DecelerateInterpolator());
        this.f25953g.addUpdateListener(new b());
        this.f25952f.start();
        this.f25953g.start();
    }

    public void e(Boolean bool) {
        this.f25961o = bool;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f25961o.booleanValue()) {
            this.f25947a.reset();
            Path path = this.f25947a;
            float f8 = this.f25960n;
            path.addCircle(f8, f8, f8, Path.Direction.CW);
            canvas.clipPath(this.f25947a);
        }
        this.f25950d.x = 0.0f;
        Double dValueOf = Double.valueOf(((double) this.f25968v) * 0.39269908169872414d);
        int i7 = this.f25968v;
        if (i7 == 16) {
            this.f25968v = 0;
        } else {
            this.f25968v = i7 + 1;
        }
        while (true) {
            PointF pointF = this.f25950d;
            float f9 = pointF.x;
            if (f9 >= this.f25954h) {
                postInvalidateDelayed(17L);
                return;
            }
            pointF.y = (float) (((double) this.f25956j) - (((double) this.f25959m) * Math.sin((((double) f9) * this.f25967u.doubleValue()) - dValueOf.doubleValue())));
            this.f25951e.y = (float) (((double) this.f25956j) - (((double) this.f25959m) * Math.sin(((((double) this.f25950d.x) * this.f25967u.doubleValue()) - dValueOf.doubleValue()) - 1.5707963267948966d)));
            float f10 = this.f25950d.x;
            canvas.drawLine(f10, this.f25951e.y, f10, this.f25955i, this.f25949c);
            PointF pointF2 = this.f25950d;
            float f11 = pointF2.x;
            canvas.drawLine(f11, pointF2.y, f11, this.f25955i, this.f25948b);
            this.f25950d.x += 1.0f;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        float f8 = i7;
        this.f25954h = f8;
        float f9 = i8;
        this.f25955i = f9;
        if (f8 > f9) {
            this.f25960n = f9 / 2.0f;
            if (this.f25961o.booleanValue()) {
                this.f25954h = this.f25955i;
            }
        } else {
            this.f25960n = f8 / 2.0f;
            if (this.f25961o.booleanValue()) {
                this.f25955i = this.f25954h;
            }
        }
        this.f25956j = this.f25955i;
        c(5);
        super.onSizeChanged(i7, i8, i9, i10);
    }

    public void setAntiAlias(Boolean bool) {
        this.f25962p = bool;
        this.f25948b.setAntiAlias(bool.booleanValue());
        this.f25949c.setAntiAlias(bool.booleanValue());
    }

    public void setMainWaveColor(int i7) {
        this.f25965s = i7;
        this.f25948b.setColor(i7);
    }

    public void setSecondaryWaveColor(int i7) {
        this.f25966t = i7;
        this.f25949c.setColor(i7);
    }

    public WaveFunctionView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f25957k = 15.0f;
        this.f25958l = 20.0f;
        this.f25959m = 20.0f;
        this.f25960n = 0.0f;
        Boolean bool = Boolean.TRUE;
        this.f25961o = bool;
        this.f25962p = bool;
        this.f25963q = "#4194f0";
        this.f25964r = "#0000FF";
        this.f25965s = Color.parseColor("#4194f0");
        this.f25966t = Color.parseColor(this.f25963q);
        this.f25967u = Double.valueOf(0.017453292519943295d);
        this.f25968v = 0;
        d();
    }

    public WaveFunctionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25957k = 15.0f;
        this.f25958l = 20.0f;
        this.f25959m = 20.0f;
        this.f25960n = 0.0f;
        Boolean bool = Boolean.TRUE;
        this.f25961o = bool;
        this.f25962p = bool;
        this.f25963q = "#4194f0";
        this.f25964r = "#0000FF";
        this.f25965s = Color.parseColor("#4194f0");
        this.f25966t = Color.parseColor(this.f25963q);
        this.f25967u = Double.valueOf(0.017453292519943295d);
        this.f25968v = 0;
        d();
    }
}
