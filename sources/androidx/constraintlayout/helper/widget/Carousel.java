package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.s;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.d;
import c.t0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Carousel extends MotionHelper {
    private static final boolean H = false;
    private static final String I = "Carousel";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f3735J = 1;
    public static final int K = 2;
    private int A;
    private int B;
    private float C;
    private int D;
    private int E;
    int F;
    Runnable G;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private b f3736n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ArrayList<View> f3737o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f3738p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f3739q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MotionLayout f3740r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f3741s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f3742t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f3743u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f3744v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f3745w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f3746x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f3747y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f3748z;

    class a implements Runnable {

        /* JADX INFO: renamed from: androidx.constraintlayout.helper.widget.Carousel$a$a, reason: collision with other inner class name */
        class RunnableC0041a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ float f3750a;

            RunnableC0041a(final float val$v) {
                this.f3750a = val$v;
            }

            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.f3740r.X0(5, 1.0f, this.f3750a);
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Carousel.this.f3740r.setProgress(0.0f);
            Carousel.this.Z();
            Carousel.this.f3736n.a(Carousel.this.f3739q);
            float velocity = Carousel.this.f3740r.getVelocity();
            if (Carousel.this.B != 2 || velocity <= Carousel.this.C || Carousel.this.f3739q >= Carousel.this.f3736n.count() - 1) {
                return;
            }
            float f8 = velocity * Carousel.this.f3747y;
            if (Carousel.this.f3739q != 0 || Carousel.this.f3738p <= Carousel.this.f3739q) {
                if (Carousel.this.f3739q != Carousel.this.f3736n.count() - 1 || Carousel.this.f3738p >= Carousel.this.f3739q) {
                    Carousel.this.f3740r.post(new RunnableC0041a(f8));
                }
            }
        }
    }

    public interface b {
        void a(int index);

        void b(View view, int index);

        int count();
    }

    public Carousel(Context context) {
        super(context);
        this.f3736n = null;
        this.f3737o = new ArrayList<>();
        this.f3738p = 0;
        this.f3739q = 0;
        this.f3741s = -1;
        this.f3742t = false;
        this.f3743u = -1;
        this.f3744v = -1;
        this.f3745w = -1;
        this.f3746x = -1;
        this.f3747y = 0.9f;
        this.f3748z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.E = 200;
        this.F = -1;
        this.G = new a();
    }

    private void S(boolean enable) {
        Iterator<s.b> it = this.f3740r.getDefinedTransitions().iterator();
        while (it.hasNext()) {
            it.next().Q(enable);
        }
    }

    private boolean T(int transitionID, boolean enable) {
        MotionLayout motionLayout;
        s.b bVarD0;
        if (transitionID == -1 || (motionLayout = this.f3740r) == null || (bVarD0 = motionLayout.D0(transitionID)) == null || enable == bVarD0.K()) {
            return false;
        }
        bVarD0.Q(enable);
        return true;
    }

    private void U(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Carousel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.Carousel_carousel_firstView) {
                    this.f3741s = typedArrayObtainStyledAttributes.getResourceId(index, this.f3741s);
                } else if (index == R.styleable.Carousel_carousel_backwardTransition) {
                    this.f3743u = typedArrayObtainStyledAttributes.getResourceId(index, this.f3743u);
                } else if (index == R.styleable.Carousel_carousel_forwardTransition) {
                    this.f3744v = typedArrayObtainStyledAttributes.getResourceId(index, this.f3744v);
                } else if (index == R.styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.A = typedArrayObtainStyledAttributes.getInt(index, this.A);
                } else if (index == R.styleable.Carousel_carousel_previousState) {
                    this.f3745w = typedArrayObtainStyledAttributes.getResourceId(index, this.f3745w);
                } else if (index == R.styleable.Carousel_carousel_nextState) {
                    this.f3746x = typedArrayObtainStyledAttributes.getResourceId(index, this.f3746x);
                } else if (index == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.f3747y = typedArrayObtainStyledAttributes.getFloat(index, this.f3747y);
                } else if (index == R.styleable.Carousel_carousel_touchUpMode) {
                    this.B = typedArrayObtainStyledAttributes.getInt(index, this.B);
                } else if (index == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.C = typedArrayObtainStyledAttributes.getFloat(index, this.C);
                } else if (index == R.styleable.Carousel_carousel_infinite) {
                    this.f3742t = typedArrayObtainStyledAttributes.getBoolean(index, this.f3742t);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        this.f3740r.setTransitionDuration(this.E);
        if (this.D < this.f3739q) {
            this.f3740r.d1(this.f3745w, this.E);
        } else {
            this.f3740r.d1(this.f3746x, this.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        b bVar = this.f3736n;
        if (bVar == null || this.f3740r == null || bVar.count() == 0) {
            return;
        }
        int size = this.f3737o.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = this.f3737o.get(i7);
            int iCount = (this.f3739q + i7) - this.f3748z;
            if (this.f3742t) {
                if (iCount < 0) {
                    int i8 = this.A;
                    if (i8 != 4) {
                        b0(view, i8);
                    } else {
                        b0(view, 0);
                    }
                    if (iCount % this.f3736n.count() == 0) {
                        this.f3736n.b(view, 0);
                    } else {
                        b bVar2 = this.f3736n;
                        bVar2.b(view, bVar2.count() + (iCount % this.f3736n.count()));
                    }
                } else if (iCount >= this.f3736n.count()) {
                    if (iCount == this.f3736n.count()) {
                        iCount = 0;
                    } else if (iCount > this.f3736n.count()) {
                        iCount %= this.f3736n.count();
                    }
                    int i9 = this.A;
                    if (i9 != 4) {
                        b0(view, i9);
                    } else {
                        b0(view, 0);
                    }
                    this.f3736n.b(view, iCount);
                } else {
                    b0(view, 0);
                    this.f3736n.b(view, iCount);
                }
            } else if (iCount < 0) {
                b0(view, this.A);
            } else if (iCount >= this.f3736n.count()) {
                b0(view, this.A);
            } else {
                b0(view, 0);
                this.f3736n.b(view, iCount);
            }
        }
        int i10 = this.D;
        if (i10 != -1 && i10 != this.f3739q) {
            this.f3740r.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3812a.W();
                }
            });
        } else if (i10 == this.f3739q) {
            this.D = -1;
        }
        if (this.f3743u == -1 || this.f3744v == -1) {
            Log.w(I, "No backward or forward transitions defined for Carousel!");
            return;
        }
        if (this.f3742t) {
            return;
        }
        int iCount2 = this.f3736n.count();
        if (this.f3739q == 0) {
            T(this.f3743u, false);
        } else {
            T(this.f3743u, true);
            this.f3740r.setTransition(this.f3743u);
        }
        if (this.f3739q == iCount2 - 1) {
            T(this.f3744v, false);
        } else {
            T(this.f3744v, true);
            this.f3740r.setTransition(this.f3744v);
        }
    }

    private boolean a0(int constraintSetId, View view, int visibility) {
        d.a aVarK0;
        d dVarZ0 = this.f3740r.z0(constraintSetId);
        if (dVarZ0 == null || (aVarK0 = dVarZ0.k0(view.getId())) == null) {
            return false;
        }
        aVarK0.f4767c.f4896c = 1;
        view.setVisibility(visibility);
        return true;
    }

    private boolean b0(View view, int visibility) {
        MotionLayout motionLayout = this.f3740r;
        if (motionLayout == null) {
            return false;
        }
        boolean zA0 = false;
        for (int i7 : motionLayout.getConstraintSetIds()) {
            zA0 |= a0(i7, view, visibility);
        }
        return zA0;
    }

    public void V(int index) {
        this.f3739q = Math.max(0, Math.min(getCount() - 1, index));
        X();
    }

    public void X() {
        int size = this.f3737o.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = this.f3737o.get(i7);
            if (this.f3736n.count() == 0) {
                b0(view, this.A);
            } else {
                b0(view, 0);
            }
        }
        this.f3740r.R0();
        Z();
    }

    public void Y(int index, int delay) {
        this.D = Math.max(0, Math.min(getCount() - 1, index));
        int iMax = Math.max(0, delay);
        this.E = iMax;
        this.f3740r.setTransitionDuration(iMax);
        if (index < this.f3739q) {
            this.f3740r.d1(this.f3745w, this.E);
        } else {
            this.f3740r.d1(this.f3746x, this.E);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.l
    public void a(MotionLayout motionLayout, int startId, int endId, float progress) {
        this.F = startId;
    }

    public int getCount() {
        b bVar = this.f3736n;
        if (bVar != null) {
            return bVar.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.f3739q;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.l
    public void k(MotionLayout motionLayout, int currentId) {
        int i7 = this.f3739q;
        this.f3738p = i7;
        if (currentId == this.f3746x) {
            this.f3739q = i7 + 1;
        } else if (currentId == this.f3745w) {
            this.f3739q = i7 - 1;
        }
        if (this.f3742t) {
            if (this.f3739q >= this.f3736n.count()) {
                this.f3739q = 0;
            }
            if (this.f3739q < 0) {
                this.f3739q = this.f3736n.count() - 1;
            }
        } else {
            if (this.f3739q >= this.f3736n.count()) {
                this.f3739q = this.f3736n.count() - 1;
            }
            if (this.f3739q < 0) {
                this.f3739q = 0;
            }
        }
        if (this.f3738p != this.f3739q) {
            this.f3740r.post(this.G);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @t0(api = 17)
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i7 = 0; i7 < this.f4480b; i7++) {
                int i8 = this.f4479a[i7];
                View viewT = motionLayout.t(i8);
                if (this.f3741s == i8) {
                    this.f3748z = i7;
                }
                this.f3737o.add(viewT);
            }
            this.f3740r = motionLayout;
            if (this.B == 2) {
                s.b bVarD0 = motionLayout.D0(this.f3744v);
                if (bVarD0 != null) {
                    bVarD0.U(5);
                }
                s.b bVarD1 = this.f3740r.D0(this.f3743u);
                if (bVarD1 != null) {
                    bVarD1.U(5);
                }
            }
            Z();
        }
    }

    public void setAdapter(b adapter) {
        this.f3736n = adapter;
    }

    public Carousel(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3736n = null;
        this.f3737o = new ArrayList<>();
        this.f3738p = 0;
        this.f3739q = 0;
        this.f3741s = -1;
        this.f3742t = false;
        this.f3743u = -1;
        this.f3744v = -1;
        this.f3745w = -1;
        this.f3746x = -1;
        this.f3747y = 0.9f;
        this.f3748z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.E = 200;
        this.F = -1;
        this.G = new a();
        U(context, attrs);
    }

    public Carousel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f3736n = null;
        this.f3737o = new ArrayList<>();
        this.f3738p = 0;
        this.f3739q = 0;
        this.f3741s = -1;
        this.f3742t = false;
        this.f3743u = -1;
        this.f3744v = -1;
        this.f3745w = -1;
        this.f3746x = -1;
        this.f3747y = 0.9f;
        this.f3748z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.E = 200;
        this.F = -1;
        this.G = new a();
        U(context, attrs);
    }
}
