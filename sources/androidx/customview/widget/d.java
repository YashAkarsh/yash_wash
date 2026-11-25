package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.n2;
import c.e0;
import c.m0;
import c.o0;
import c.r0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 4;
    public static final int F = 8;
    public static final int G = 15;
    public static final int H = 1;
    public static final int I = 2;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f7119J = 3;
    private static final int K = 20;
    private static final int L = 256;
    private static final int M = 600;
    private static final Interpolator N = new a();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f7120x = "ViewDragHelper";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f7121y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f7122z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7124b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f7126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f7127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f7128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f7129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int[] f7130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f7131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f7132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private VelocityTracker f7134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f7135m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f7136n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7137o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f7138p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f7139q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private OverScroller f7140r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final c f7141s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f7142t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f7143u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final ViewGroup f7144v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7125c = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Runnable f7145w = new b();

    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f8) {
            float f9 = f8 - 1.0f;
            return (f9 * f9 * f9 * f9 * f9) + 1.0f;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.R(0);
        }
    }

    public static abstract class c {
        public int a(@m0 View view, int i7, int i8) {
            return 0;
        }

        public int b(@m0 View view, int i7, int i8) {
            return 0;
        }

        public int c(int i7) {
            return i7;
        }

        public int d(@m0 View view) {
            return 0;
        }

        public int e(@m0 View view) {
            return 0;
        }

        public void f(int i7, int i8) {
        }

        public boolean g(int i7) {
            return false;
        }

        public void h(int i7, int i8) {
        }

        public void i(@m0 View view, int i7) {
        }

        public void j(int i7) {
        }

        public void k(@m0 View view, int i7, int i8, @r0 int i9, @r0 int i10) {
        }

        public void l(@m0 View view, float f8, float f9) {
        }

        public abstract boolean m(@m0 View view, int i7);
    }

    private d(@m0 Context context, @m0 ViewGroup viewGroup, @m0 c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f7144v = viewGroup;
        this.f7141s = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i7 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f7138p = i7;
        this.f7137o = i7;
        this.f7124b = viewConfiguration.getScaledTouchSlop();
        this.f7135m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f7136n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7140r = new OverScroller(context, N);
    }

    private int C(int i7, int i8) {
        int i9 = i7 < this.f7144v.getLeft() + this.f7137o ? 1 : 0;
        if (i8 < this.f7144v.getTop() + this.f7137o) {
            i9 |= 4;
        }
        if (i7 > this.f7144v.getRight() - this.f7137o) {
            i9 |= 2;
        }
        return i8 > this.f7144v.getBottom() - this.f7137o ? i9 | 8 : i9;
    }

    private boolean K(int i7) {
        if (J(i7)) {
            return true;
        }
        Log.e(f7120x, "Ignoring pointerId=" + i7 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void N() {
        this.f7134l.computeCurrentVelocity(1000, this.f7135m);
        r(i(this.f7134l.getXVelocity(this.f7125c), this.f7136n, this.f7135m), i(this.f7134l.getYVelocity(this.f7125c), this.f7136n, this.f7135m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.d$c] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void O(float f8, float f9, int i7) {
        int i8;
        boolean zE = e(f8, f9, i7, 1);
        ?? r7 = zE;
        if (e(f9, f8, i7, 4)) {
            r7 = (zE ? 1 : 0) | 4;
        }
        ?? r8 = r7;
        if (e(f8, f9, i7, 2)) {
            r8 = (r7 == true ? 1 : 0) | 2;
        }
        ?? r9 = r8;
        if (e(f9, f8, i7, 8)) {
            i8 = (r8 == true ? 1 : 0) | 8;
        }
        if (r9 == 0) {
            r9 = i8;
            return;
        }
        r9 = i8;
        int[] iArr = this.f7131i;
        iArr[i7] = (iArr[i7] | r9) == true ? 1 : 0;
        this.f7141s.f(r9, i7);
    }

    private void P(float f8, float f9, int i7) {
        u(i7);
        float[] fArr = this.f7126d;
        this.f7128f[i7] = f8;
        fArr[i7] = f8;
        float[] fArr2 = this.f7127e;
        this.f7129g[i7] = f9;
        fArr2[i7] = f9;
        this.f7130h[i7] = C((int) f8, (int) f9);
        this.f7133k |= 1 << i7;
    }

    private void Q(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i7 = 0; i7 < pointerCount; i7++) {
            int pointerId = motionEvent.getPointerId(i7);
            if (K(pointerId)) {
                float x7 = motionEvent.getX(i7);
                float y7 = motionEvent.getY(i7);
                this.f7128f[pointerId] = x7;
                this.f7129g[pointerId] = y7;
            }
        }
    }

    private boolean e(float f8, float f9, int i7, int i8) {
        float fAbs = Math.abs(f8);
        float fAbs2 = Math.abs(f9);
        if ((this.f7130h[i7] & i8) != i8 || (this.f7139q & i8) == 0 || (this.f7132j[i7] & i8) == i8 || (this.f7131i[i7] & i8) == i8) {
            return false;
        }
        int i9 = this.f7124b;
        if (fAbs <= i9 && fAbs2 <= i9) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f7141s.g(i8)) {
            return (this.f7131i[i7] & i8) == 0 && fAbs > ((float) this.f7124b);
        }
        int[] iArr = this.f7132j;
        iArr[i7] = iArr[i7] | i8;
        return false;
    }

    private boolean h(View view, float f8, float f9) {
        if (view == null) {
            return false;
        }
        boolean z7 = this.f7141s.d(view) > 0;
        boolean z8 = this.f7141s.e(view) > 0;
        if (z7 && z8) {
            float f10 = (f8 * f8) + (f9 * f9);
            int i7 = this.f7124b;
            return f10 > ((float) (i7 * i7));
        }
        if (z7) {
            return Math.abs(f8) > ((float) this.f7124b);
        }
        return z8 && Math.abs(f9) > ((float) this.f7124b);
    }

    private float i(float f8, float f9, float f10) {
        float fAbs = Math.abs(f8);
        if (fAbs < f9) {
            return 0.0f;
        }
        if (fAbs > f10) {
            return f8 > 0.0f ? f10 : -f10;
        }
        return f8;
    }

    private int j(int i7, int i8, int i9) {
        int iAbs = Math.abs(i7);
        if (iAbs < i8) {
            return 0;
        }
        if (iAbs > i9) {
            return i7 > 0 ? i9 : -i9;
        }
        return i7;
    }

    private void k() {
        float[] fArr = this.f7126d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f7127e, 0.0f);
        Arrays.fill(this.f7128f, 0.0f);
        Arrays.fill(this.f7129g, 0.0f);
        Arrays.fill(this.f7130h, 0);
        Arrays.fill(this.f7131i, 0);
        Arrays.fill(this.f7132j, 0);
        this.f7133k = 0;
    }

    private void l(int i7) {
        if (this.f7126d == null || !J(i7)) {
            return;
        }
        this.f7126d[i7] = 0.0f;
        this.f7127e[i7] = 0.0f;
        this.f7128f[i7] = 0.0f;
        this.f7129g[i7] = 0.0f;
        this.f7130h[i7] = 0;
        this.f7131i[i7] = 0;
        this.f7132j[i7] = 0;
        this.f7133k = (~(1 << i7)) & this.f7133k;
    }

    private int m(int i7, int i8, int i9) {
        if (i7 == 0) {
            return 0;
        }
        int width = this.f7144v.getWidth();
        float f8 = width / 2;
        float fS = f8 + (s(Math.min(1.0f, Math.abs(i7) / width)) * f8);
        int iAbs = Math.abs(i8);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fS / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i7) / i9) + 1.0f) * 256.0f), 600);
    }

    private int n(View view, int i7, int i8, int i9, int i10) {
        float f8;
        float f9;
        float f10;
        float f11;
        int iJ = j(i9, (int) this.f7136n, (int) this.f7135m);
        int iJ2 = j(i10, (int) this.f7136n, (int) this.f7135m);
        int iAbs = Math.abs(i7);
        int iAbs2 = Math.abs(i8);
        int iAbs3 = Math.abs(iJ);
        int iAbs4 = Math.abs(iJ2);
        int i11 = iAbs3 + iAbs4;
        int i12 = iAbs + iAbs2;
        if (iJ != 0) {
            f8 = iAbs3;
            f9 = i11;
        } else {
            f8 = iAbs;
            f9 = i12;
        }
        float f12 = f8 / f9;
        if (iJ2 != 0) {
            f10 = iAbs4;
            f11 = i11;
        } else {
            f10 = iAbs2;
            f11 = i12;
        }
        return (int) ((m(i7, iJ, this.f7141s.d(view)) * f12) + (m(i8, iJ2, this.f7141s.e(view)) * (f10 / f11)));
    }

    public static d p(@m0 ViewGroup viewGroup, float f8, @m0 c cVar) {
        d dVarQ = q(viewGroup, cVar);
        dVarQ.f7124b = (int) (dVarQ.f7124b * (1.0f / f8));
        return dVarQ;
    }

    public static d q(@m0 ViewGroup viewGroup, @m0 c cVar) {
        return new d(viewGroup.getContext(), viewGroup, cVar);
    }

    private void r(float f8, float f9) {
        this.f7143u = true;
        this.f7141s.l(this.f7142t, f8, f9);
        this.f7143u = false;
        if (this.f7123a == 1) {
            R(0);
        }
    }

    private float s(float f8) {
        return (float) Math.sin((f8 - 0.5f) * 0.47123894f);
    }

    private void t(int i7, int i8, int i9, int i10) {
        int left = this.f7142t.getLeft();
        int top = this.f7142t.getTop();
        if (i9 != 0) {
            i7 = this.f7141s.a(this.f7142t, i7, i9);
            n2.e1(this.f7142t, i7 - left);
        }
        int i11 = i7;
        if (i10 != 0) {
            i8 = this.f7141s.b(this.f7142t, i8, i10);
            n2.f1(this.f7142t, i8 - top);
        }
        int i12 = i8;
        if (i9 == 0 && i10 == 0) {
            return;
        }
        this.f7141s.k(this.f7142t, i11, i12, i11 - left, i12 - top);
    }

    private void u(int i7) {
        float[] fArr = this.f7126d;
        if (fArr == null || fArr.length <= i7) {
            int i8 = i7 + 1;
            float[] fArr2 = new float[i8];
            float[] fArr3 = new float[i8];
            float[] fArr4 = new float[i8];
            float[] fArr5 = new float[i8];
            int[] iArr = new int[i8];
            int[] iArr2 = new int[i8];
            int[] iArr3 = new int[i8];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f7127e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f7128f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f7129g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f7130h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f7131i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f7132j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f7126d = fArr2;
            this.f7127e = fArr3;
            this.f7128f = fArr4;
            this.f7129g = fArr5;
            this.f7130h = iArr;
            this.f7131i = iArr2;
            this.f7132j = iArr3;
        }
    }

    private boolean x(int i7, int i8, int i9, int i10) {
        int left = this.f7142t.getLeft();
        int top = this.f7142t.getTop();
        int i11 = i7 - left;
        int i12 = i8 - top;
        if (i11 == 0 && i12 == 0) {
            this.f7140r.abortAnimation();
            R(0);
            return false;
        }
        this.f7140r.startScroll(left, top, i11, i12, n(this.f7142t, i11, i12, i9, i10));
        R(2);
        return true;
    }

    @r0
    public int A() {
        return this.f7138p;
    }

    @r0
    public int B() {
        return this.f7137o;
    }

    public float D() {
        return this.f7136n;
    }

    @r0
    public int E() {
        return this.f7124b;
    }

    public int F() {
        return this.f7123a;
    }

    public boolean G(int i7, int i8) {
        return L(this.f7142t, i7, i8);
    }

    public boolean H(int i7) {
        int length = this.f7130h.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (I(i7, i8)) {
                return true;
            }
        }
        return false;
    }

    public boolean I(int i7, int i8) {
        return J(i8) && (i7 & this.f7130h[i8]) != 0;
    }

    public boolean J(int i7) {
        return ((1 << i7) & this.f7133k) != 0;
    }

    public boolean L(@o0 View view, int i7, int i8) {
        return view != null && i7 >= view.getLeft() && i7 < view.getRight() && i8 >= view.getTop() && i8 < view.getBottom();
    }

    public void M(@m0 MotionEvent motionEvent) {
        int i7;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            c();
        }
        if (this.f7134l == null) {
            this.f7134l = VelocityTracker.obtain();
        }
        this.f7134l.addMovement(motionEvent);
        int i8 = 0;
        if (actionMasked == 0) {
            float x7 = motionEvent.getX();
            float y7 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewV = v((int) x7, (int) y7);
            P(x7, y7, pointerId);
            Y(viewV, pointerId);
            int i9 = this.f7130h[pointerId];
            int i10 = this.f7139q;
            if ((i9 & i10) != 0) {
                this.f7141s.h(i9 & i10, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f7123a == 1) {
                N();
            }
            c();
            return;
        }
        if (actionMasked == 2) {
            if (this.f7123a == 1) {
                if (K(this.f7125c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f7125c);
                    float x8 = motionEvent.getX(iFindPointerIndex);
                    float y8 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f7128f;
                    int i11 = this.f7125c;
                    int i12 = (int) (x8 - fArr[i11]);
                    int i13 = (int) (y8 - this.f7129g[i11]);
                    t(this.f7142t.getLeft() + i12, this.f7142t.getTop() + i13, i12, i13);
                    Q(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i8 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i8);
                if (K(pointerId2)) {
                    float x9 = motionEvent.getX(i8);
                    float y9 = motionEvent.getY(i8);
                    float f8 = x9 - this.f7126d[pointerId2];
                    float f9 = y9 - this.f7127e[pointerId2];
                    O(f8, f9, pointerId2);
                    if (this.f7123a != 1) {
                        View viewV2 = v((int) x9, (int) y9);
                        if (h(viewV2, f8, f9) && Y(viewV2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i8++;
            }
            Q(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f7123a == 1) {
                r(0.0f, 0.0f);
            }
            c();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x10 = motionEvent.getX(actionIndex);
            float y10 = motionEvent.getY(actionIndex);
            P(x10, y10, pointerId3);
            if (this.f7123a != 0) {
                if (G((int) x10, (int) y10)) {
                    Y(this.f7142t, pointerId3);
                    return;
                }
                return;
            } else {
                Y(v((int) x10, (int) y10), pointerId3);
                int i14 = this.f7130h[pointerId3];
                int i15 = this.f7139q;
                if ((i14 & i15) != 0) {
                    this.f7141s.h(i14 & i15, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f7123a == 1 && pointerId4 == this.f7125c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i8 >= pointerCount2) {
                    i7 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i8);
                if (pointerId5 != this.f7125c) {
                    View viewV3 = v((int) motionEvent.getX(i8), (int) motionEvent.getY(i8));
                    View view = this.f7142t;
                    if (viewV3 == view && Y(view, pointerId5)) {
                        i7 = this.f7125c;
                        break;
                    }
                }
                i8++;
            }
            if (i7 == -1) {
                N();
            }
        }
        l(pointerId4);
    }

    void R(int i7) {
        this.f7144v.removeCallbacks(this.f7145w);
        if (this.f7123a != i7) {
            this.f7123a = i7;
            this.f7141s.j(i7);
            if (this.f7123a == 0) {
                this.f7142t = null;
            }
        }
    }

    public void S(@e0(from = 0) @r0 int i7) {
        this.f7137o = i7;
    }

    public void T(int i7) {
        this.f7139q = i7;
    }

    public void U(float f8) {
        this.f7136n = f8;
    }

    public boolean V(int i7, int i8) {
        if (this.f7143u) {
            return x(i7, i8, (int) this.f7134l.getXVelocity(this.f7125c), (int) this.f7134l.getYVelocity(this.f7125c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    public boolean W(@m0 MotionEvent motionEvent) {
        boolean z7;
        View viewV;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            c();
        }
        if (this.f7134l == null) {
            this.f7134l = VelocityTracker.obtain();
        }
        this.f7134l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                c();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    c();
                } else if (actionMasked == 5) {
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    float x7 = motionEvent.getX(actionIndex);
                    float y7 = motionEvent.getY(actionIndex);
                    P(x7, y7, pointerId);
                    int i7 = this.f7123a;
                    if (i7 == 0) {
                        int i8 = this.f7130h[pointerId];
                        int i9 = this.f7139q;
                        if ((i8 & i9) != 0) {
                            this.f7141s.h(i8 & i9, pointerId);
                        }
                    } else if (i7 == 2 && (viewV = v((int) x7, (int) y7)) == this.f7142t) {
                        Y(viewV, pointerId);
                    }
                } else if (actionMasked == 6) {
                    l(motionEvent.getPointerId(actionIndex));
                }
            } else if (this.f7126d != null && this.f7127e != null) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i10 = 0; i10 < pointerCount; i10++) {
                    int pointerId2 = motionEvent.getPointerId(i10);
                    if (K(pointerId2)) {
                        float x8 = motionEvent.getX(i10);
                        float y8 = motionEvent.getY(i10);
                        float f8 = x8 - this.f7126d[pointerId2];
                        float f9 = y8 - this.f7127e[pointerId2];
                        View viewV2 = v((int) x8, (int) y8);
                        boolean z8 = viewV2 != null && h(viewV2, f8, f9);
                        if (!z8) {
                            O(f8, f9, pointerId2);
                            if (this.f7123a != 1) {
                                break;
                            }
                        } else {
                            int left = viewV2.getLeft();
                            int i11 = (int) f8;
                            int iA = this.f7141s.a(viewV2, left + i11, i11);
                            int top = viewV2.getTop();
                            int i12 = (int) f9;
                            int iB = this.f7141s.b(viewV2, top + i12, i12);
                            int iD = this.f7141s.d(viewV2);
                            int iE = this.f7141s.e(viewV2);
                            if ((iD == 0 || (iD > 0 && iA == left)) && (iE == 0 || (iE > 0 && iB == top))) {
                                break;
                            }
                            O(f8, f9, pointerId2);
                            if (this.f7123a != 1 || (z8 && Y(viewV2, pointerId2))) {
                                break;
                            }
                        }
                    }
                }
                Q(motionEvent);
            }
            z7 = false;
        } else {
            float x9 = motionEvent.getX();
            float y9 = motionEvent.getY();
            z7 = false;
            int pointerId3 = motionEvent.getPointerId(0);
            P(x9, y9, pointerId3);
            View viewV3 = v((int) x9, (int) y9);
            if (viewV3 == this.f7142t && this.f7123a == 2) {
                Y(viewV3, pointerId3);
            }
            int i13 = this.f7130h[pointerId3];
            int i14 = this.f7139q;
            if ((i13 & i14) != 0) {
                this.f7141s.h(i13 & i14, pointerId3);
            }
        }
        if (this.f7123a == 1) {
            return true;
        }
        return z7;
    }

    public boolean X(@m0 View view, int i7, int i8) {
        this.f7142t = view;
        this.f7125c = -1;
        boolean zX = x(i7, i8, 0, 0);
        if (!zX && this.f7123a == 0 && this.f7142t != null) {
            this.f7142t = null;
        }
        return zX;
    }

    boolean Y(View view, int i7) {
        if (view == this.f7142t && this.f7125c == i7) {
            return true;
        }
        if (view == null || !this.f7141s.m(view, i7)) {
            return false;
        }
        this.f7125c = i7;
        d(view, i7);
        return true;
    }

    public void a() {
        c();
        if (this.f7123a == 2) {
            int currX = this.f7140r.getCurrX();
            int currY = this.f7140r.getCurrY();
            this.f7140r.abortAnimation();
            int currX2 = this.f7140r.getCurrX();
            int currY2 = this.f7140r.getCurrY();
            this.f7141s.k(this.f7142t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        R(0);
    }

    protected boolean b(@m0 View view, boolean z7, int i7, int i8, int i9, int i10) {
        int i11;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i12 = i9 + scrollX;
                if (i12 >= childAt.getLeft() && i12 < childAt.getRight() && (i11 = i10 + scrollY) >= childAt.getTop() && i11 < childAt.getBottom() && b(childAt, true, i7, i8, i12 - childAt.getLeft(), i11 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z7 && (view.canScrollHorizontally(-i7) || view.canScrollVertically(-i8));
    }

    public void c() {
        this.f7125c = -1;
        k();
        VelocityTracker velocityTracker = this.f7134l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f7134l = null;
        }
    }

    public void d(@m0 View view, int i7) {
        if (view.getParent() == this.f7144v) {
            this.f7142t = view;
            this.f7125c = i7;
            this.f7141s.i(view, i7);
            R(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f7144v + ")");
    }

    public boolean f(int i7) {
        int length = this.f7126d.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (g(i7, i8)) {
                return true;
            }
        }
        return false;
    }

    public boolean g(int i7, int i8) {
        if (!J(i8)) {
            return false;
        }
        boolean z7 = (i7 & 1) == 1;
        boolean z8 = (i7 & 2) == 2;
        float f8 = this.f7128f[i8] - this.f7126d[i8];
        float f9 = this.f7129g[i8] - this.f7127e[i8];
        if (z7 && z8) {
            float f10 = (f8 * f8) + (f9 * f9);
            int i9 = this.f7124b;
            return f10 > ((float) (i9 * i9));
        }
        if (z7) {
            return Math.abs(f8) > ((float) this.f7124b);
        }
        return z8 && Math.abs(f9) > ((float) this.f7124b);
    }

    public boolean o(boolean z7) {
        if (this.f7123a == 2) {
            boolean zComputeScrollOffset = this.f7140r.computeScrollOffset();
            int currX = this.f7140r.getCurrX();
            int currY = this.f7140r.getCurrY();
            int left = currX - this.f7142t.getLeft();
            int top = currY - this.f7142t.getTop();
            if (left != 0) {
                n2.e1(this.f7142t, left);
            }
            if (top != 0) {
                n2.f1(this.f7142t, top);
            }
            if (left != 0 || top != 0) {
                this.f7141s.k(this.f7142t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f7140r.getFinalX() && currY == this.f7140r.getFinalY()) {
                this.f7140r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z7) {
                    this.f7144v.post(this.f7145w);
                } else {
                    R(0);
                }
            }
        }
        return this.f7123a == 2;
    }

    @o0
    public View v(int i7, int i8) {
        for (int childCount = this.f7144v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f7144v.getChildAt(this.f7141s.c(childCount));
            if (i7 >= childAt.getLeft() && i7 < childAt.getRight() && i8 >= childAt.getTop() && i8 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void w(int i7, int i8, int i9, int i10) {
        if (!this.f7143u) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.f7140r.fling(this.f7142t.getLeft(), this.f7142t.getTop(), (int) this.f7134l.getXVelocity(this.f7125c), (int) this.f7134l.getYVelocity(this.f7125c), i7, i9, i8, i10);
        R(2);
    }

    public int y() {
        return this.f7125c;
    }

    @o0
    public View z() {
        return this.f7142t;
    }
}
