package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.n2;
import c.g1;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@g1
class k extends RecyclerView.n implements RecyclerView.r {
    private static final int D = 0;
    private static final int E = 1;
    private static final int F = 2;
    private static final int G = 0;
    private static final int H = 1;
    private static final int I = 2;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final int f9560J = 0;
    private static final int K = 1;
    private static final int L = 2;
    private static final int M = 3;
    private static final int N = 500;
    private static final int O = 1500;
    private static final int P = 1200;
    private static final int Q = 500;
    private static final int R = 255;
    private static final int[] S = {R.attr.state_pressed};
    private static final int[] T = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.s C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final StateListDrawable f9563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Drawable f9564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final StateListDrawable f9567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Drawable f9568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f9569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f9570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g1
    int f9571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @g1
    int f9572l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g1
    float f9573m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g1
    int f9574n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @g1
    int f9575o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g1
    float f9576p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private RecyclerView f9579s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    final ValueAnimator f9586z;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9577q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f9578r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f9580t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f9581u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f9582v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f9583w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int[] f9584x = new int[2];

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final int[] f9585y = new int[2];

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.w(500);
        }
    }

    class b extends RecyclerView.s {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(RecyclerView recyclerView, int i7, int i8) {
            k.this.J(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    private class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9589a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f9589a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f9589a) {
                this.f9589a = false;
                return;
            }
            if (((Float) k.this.f9586z.getAnimatedValue()).floatValue() == 0.0f) {
                k kVar = k.this;
                kVar.A = 0;
                kVar.G(0);
            } else {
                k kVar2 = k.this;
                kVar2.A = 2;
                kVar2.D();
            }
        }
    }

    private class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            k.this.f9563c.setAlpha(iFloatValue);
            k.this.f9564d.setAlpha(iFloatValue);
            k.this.D();
        }
    }

    k(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i7, int i8, int i9) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f9586z = valueAnimatorOfFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.f9563c = stateListDrawable;
        this.f9564d = drawable;
        this.f9567g = stateListDrawable2;
        this.f9568h = drawable2;
        this.f9565e = Math.max(i7, stateListDrawable.getIntrinsicWidth());
        this.f9566f = Math.max(i7, drawable.getIntrinsicWidth());
        this.f9569i = Math.max(i7, stateListDrawable2.getIntrinsicWidth());
        this.f9570j = Math.max(i7, drawable2.getIntrinsicWidth());
        this.f9561a = i8;
        this.f9562b = i9;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new d());
        l(recyclerView);
    }

    private void E(int i7) {
        m();
        this.f9579s.postDelayed(this.B, i7);
    }

    private int F(float f8, float f9, int[] iArr, int i7, int i8, int i9) {
        int i10 = iArr[1] - iArr[0];
        if (i10 == 0) {
            return 0;
        }
        int i11 = i7 - i9;
        int i12 = (int) (((f9 - f8) / i10) * i11);
        int i13 = i8 + i12;
        if (i13 >= i11 || i13 < 0) {
            return 0;
        }
        return i12;
    }

    private void H() {
        this.f9579s.n(this);
        this.f9579s.q(this);
        this.f9579s.r(this.C);
    }

    private void K(float f8) {
        int[] iArrT = t();
        float fMax = Math.max(iArrT[0], Math.min(iArrT[1], f8));
        if (Math.abs(this.f9572l - fMax) < 2.0f) {
            return;
        }
        int iF = F(this.f9573m, fMax, iArrT, this.f9579s.computeVerticalScrollRange(), this.f9579s.computeVerticalScrollOffset(), this.f9578r);
        if (iF != 0) {
            this.f9579s.scrollBy(0, iF);
        }
        this.f9573m = fMax;
    }

    private void m() {
        this.f9579s.removeCallbacks(this.B);
    }

    private void n() {
        this.f9579s.p1(this);
        this.f9579s.s1(this);
        this.f9579s.t1(this.C);
        m();
    }

    private void o(Canvas canvas) {
        int i7 = this.f9578r;
        int i8 = this.f9569i;
        int i9 = i7 - i8;
        int i10 = this.f9575o;
        int i11 = this.f9574n;
        int i12 = i10 - (i11 / 2);
        this.f9567g.setBounds(0, 0, i11, i8);
        this.f9568h.setBounds(0, 0, this.f9577q, this.f9570j);
        canvas.translate(0.0f, i9);
        this.f9568h.draw(canvas);
        canvas.translate(i12, 0.0f);
        this.f9567g.draw(canvas);
        canvas.translate(-i12, -i9);
    }

    private void p(Canvas canvas) {
        int i7 = this.f9577q;
        int i8 = this.f9565e;
        int i9 = i7 - i8;
        int i10 = this.f9572l;
        int i11 = this.f9571k;
        int i12 = i10 - (i11 / 2);
        this.f9563c.setBounds(0, 0, i8, i11);
        this.f9564d.setBounds(0, 0, this.f9566f, this.f9578r);
        if (!z()) {
            canvas.translate(i9, 0.0f);
            this.f9564d.draw(canvas);
            canvas.translate(0.0f, i12);
            this.f9563c.draw(canvas);
            canvas.translate(-i9, -i12);
            return;
        }
        this.f9564d.draw(canvas);
        canvas.translate(this.f9565e, i12);
        canvas.scale(-1.0f, 1.0f);
        this.f9563c.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.f9565e, -i12);
    }

    private int[] q() {
        int[] iArr = this.f9585y;
        int i7 = this.f9562b;
        iArr[0] = i7;
        iArr[1] = this.f9577q - i7;
        return iArr;
    }

    private int[] t() {
        int[] iArr = this.f9584x;
        int i7 = this.f9562b;
        iArr[0] = i7;
        iArr[1] = this.f9578r - i7;
        return iArr;
    }

    private void x(float f8) {
        int[] iArrQ = q();
        float fMax = Math.max(iArrQ[0], Math.min(iArrQ[1], f8));
        if (Math.abs(this.f9575o - fMax) < 2.0f) {
            return;
        }
        int iF = F(this.f9576p, fMax, iArrQ, this.f9579s.computeHorizontalScrollRange(), this.f9579s.computeHorizontalScrollOffset(), this.f9577q);
        if (iF != 0) {
            this.f9579s.scrollBy(iF, 0);
        }
        this.f9576p = fMax;
    }

    private boolean z() {
        return n2.Z(this.f9579s) == 1;
    }

    @g1
    boolean A(float f8, float f9) {
        if (f9 >= this.f9578r - this.f9569i) {
            int i7 = this.f9575o;
            int i8 = this.f9574n;
            if (f8 >= i7 - (i8 / 2) && f8 <= i7 + (i8 / 2)) {
                return true;
            }
        }
        return false;
    }

    @g1
    boolean B(float f8, float f9) {
        if (!z() ? f8 >= this.f9577q - this.f9565e : f8 <= this.f9565e / 2) {
            int i7 = this.f9572l;
            int i8 = this.f9571k;
            if (f9 >= i7 - (i8 / 2) && f9 <= i7 + (i8 / 2)) {
                return true;
            }
        }
        return false;
    }

    @g1
    boolean C() {
        return this.f9582v == 1;
    }

    void D() {
        this.f9579s.invalidate();
    }

    void G(int i7) {
        if (i7 == 2 && this.f9582v != 2) {
            this.f9563c.setState(S);
            m();
        }
        if (i7 == 0) {
            D();
        } else {
            I();
        }
        if (this.f9582v == 2 && i7 != 2) {
            this.f9563c.setState(T);
            E(P);
        } else if (i7 == 1) {
            E(1500);
        }
        this.f9582v = i7;
    }

    public void I() {
        int i7 = this.A;
        if (i7 != 0) {
            if (i7 != 3) {
                return;
            } else {
                this.f9586z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f9586z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f9586z.setDuration(500L);
        this.f9586z.setStartDelay(0L);
        this.f9586z.start();
    }

    void J(int i7, int i8) {
        int iComputeVerticalScrollRange = this.f9579s.computeVerticalScrollRange();
        int i9 = this.f9578r;
        this.f9580t = iComputeVerticalScrollRange - i9 > 0 && i9 >= this.f9561a;
        int iComputeHorizontalScrollRange = this.f9579s.computeHorizontalScrollRange();
        int i10 = this.f9577q;
        boolean z7 = iComputeHorizontalScrollRange - i10 > 0 && i10 >= this.f9561a;
        this.f9581u = z7;
        boolean z8 = this.f9580t;
        if (!z8 && !z7) {
            if (this.f9582v != 0) {
                G(0);
                return;
            }
            return;
        }
        if (z8) {
            float f8 = i9;
            this.f9572l = (int) ((f8 * (i8 + (f8 / 2.0f))) / iComputeVerticalScrollRange);
            this.f9571k = Math.min(i9, (i9 * i9) / iComputeVerticalScrollRange);
        }
        if (this.f9581u) {
            float f9 = i10;
            this.f9575o = (int) ((f9 * (i7 + (f9 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f9574n = Math.min(i10, (i10 * i10) / iComputeHorizontalScrollRange);
        }
        int i11 = this.f9582v;
        if (i11 == 0 || i11 == 1) {
            G(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void a(@m0 RecyclerView recyclerView, @m0 MotionEvent motionEvent) {
        if (this.f9582v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zB = B(motionEvent.getX(), motionEvent.getY());
            boolean zA = A(motionEvent.getX(), motionEvent.getY());
            if (zB || zA) {
                if (zA) {
                    this.f9583w = 1;
                    this.f9576p = (int) motionEvent.getX();
                } else if (zB) {
                    this.f9583w = 2;
                    this.f9573m = (int) motionEvent.getY();
                }
                G(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f9582v == 2) {
            this.f9573m = 0.0f;
            this.f9576p = 0.0f;
            G(1);
            this.f9583w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f9582v == 2) {
            I();
            if (this.f9583w == 1) {
                x(motionEvent.getX());
            }
            if (this.f9583w == 2) {
                K(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean c(@m0 RecyclerView recyclerView, @m0 MotionEvent motionEvent) {
        int i7 = this.f9582v;
        if (i7 == 1) {
            boolean zB = B(motionEvent.getX(), motionEvent.getY());
            boolean zA = A(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zB && !zA) {
                return false;
            }
            if (zA) {
                this.f9583w = 1;
                this.f9576p = (int) motionEvent.getX();
            } else if (zB) {
                this.f9583w = 2;
                this.f9573m = (int) motionEvent.getY();
            }
            G(2);
        } else if (i7 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void e(boolean z7) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.f9577q != this.f9579s.getWidth() || this.f9578r != this.f9579s.getHeight()) {
            this.f9577q = this.f9579s.getWidth();
            this.f9578r = this.f9579s.getHeight();
            G(0);
        } else if (this.A != 0) {
            if (this.f9580t) {
                p(canvas);
            }
            if (this.f9581u) {
                o(canvas);
            }
        }
    }

    public void l(@o0 RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f9579s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            n();
        }
        this.f9579s = recyclerView;
        if (recyclerView != null) {
            H();
        }
    }

    @g1
    Drawable r() {
        return this.f9567g;
    }

    @g1
    Drawable s() {
        return this.f9568h;
    }

    @g1
    Drawable u() {
        return this.f9563c;
    }

    @g1
    Drawable v() {
        return this.f9564d;
    }

    @g1
    void w(int i7) {
        int i8 = this.A;
        if (i8 == 1) {
            this.f9586z.cancel();
        } else if (i8 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f9586z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f9586z.setDuration(i7);
        this.f9586z.start();
    }

    public boolean y() {
        return this.f9582v == 2;
    }
}
