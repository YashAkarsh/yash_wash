package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class m extends f {
    static final String Y = "KeyTrigger";
    private static final String Z = "KeyTrigger";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f4084a0 = "viewTransitionOnCross";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f4085b0 = "viewTransitionOnPositiveCross";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f4086c0 = "viewTransitionOnNegativeCross";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f4087d0 = "postLayout";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f4088e0 = "triggerSlack";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final String f4089f0 = "triggerCollisionView";

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f4090g0 = "triggerCollisionId";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f4091h0 = "triggerID";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f4092i0 = "positiveCross";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final String f4093j0 = "negativeCross";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f4094k0 = "triggerReceiver";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f4095l0 = "CROSS";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f4096m0 = 5;
    private int D = -1;
    private String E = null;
    private int F;
    private String G;
    private String H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f4097J;
    private View K;
    float L;
    private boolean M;
    private boolean N;
    private boolean O;
    private float P;
    private float Q;
    private boolean R;
    int S;
    int T;
    int U;
    RectF V;
    RectF W;
    HashMap<String, Method> X;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f4098a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f4099b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f4100c = 4;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f4101d = 5;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f4102e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f4103f = 7;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f4104g = 8;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f4105h = 9;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f4106i = 10;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f4107j = 11;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final int f4108k = 12;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final int f4109l = 13;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int f4110m = 14;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static SparseIntArray f4111n;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4111n = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            f4111n.append(R.styleable.KeyTrigger_onCross, 4);
            f4111n.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            f4111n.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            f4111n.append(R.styleable.KeyTrigger_motionTarget, 7);
            f4111n.append(R.styleable.KeyTrigger_triggerId, 6);
            f4111n.append(R.styleable.KeyTrigger_triggerSlack, 5);
            f4111n.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f4111n.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f4111n.append(R.styleable.KeyTrigger_triggerReceiver, 11);
            f4111n.append(R.styleable.KeyTrigger_viewTransitionOnCross, 12);
            f4111n.append(R.styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            f4111n.append(R.styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        private a() {
        }

        public static void a(m c8, TypedArray a8, Context context) {
            int indexCount = a8.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = a8.getIndex(i7);
                switch (f4111n.get(index)) {
                    case 1:
                        c8.G = a8.getString(index);
                        break;
                    case 2:
                        c8.H = a8.getString(index);
                        break;
                    case 3:
                    default:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f4111n.get(index));
                        break;
                    case 4:
                        c8.E = a8.getString(index);
                        break;
                    case 5:
                        c8.L = a8.getFloat(index, c8.L);
                        break;
                    case 6:
                        c8.I = a8.getResourceId(index, c8.I);
                        break;
                    case 7:
                        if (MotionLayout.W1) {
                            int resourceId = a8.getResourceId(index, c8.f3973b);
                            c8.f3973b = resourceId;
                            if (resourceId == -1) {
                                c8.f3974c = a8.getString(index);
                            }
                        } else if (a8.peekValue(index).type == 3) {
                            c8.f3974c = a8.getString(index);
                        } else {
                            c8.f3973b = a8.getResourceId(index, c8.f3973b);
                        }
                        break;
                    case 8:
                        int integer = a8.getInteger(index, c8.f3972a);
                        c8.f3972a = integer;
                        c8.P = (integer + 0.5f) / 100.0f;
                        break;
                    case 9:
                        c8.f4097J = a8.getResourceId(index, c8.f4097J);
                        break;
                    case 10:
                        c8.R = a8.getBoolean(index, c8.R);
                        break;
                    case 11:
                        c8.F = a8.getResourceId(index, c8.F);
                        break;
                    case 12:
                        c8.U = a8.getResourceId(index, c8.U);
                        break;
                    case 13:
                        c8.S = a8.getResourceId(index, c8.S);
                        break;
                    case 14:
                        c8.T = a8.getResourceId(index, c8.T);
                        break;
                }
            }
        }
    }

    public m() {
        int i7 = f.f3951f;
        this.F = i7;
        this.G = null;
        this.H = null;
        this.I = i7;
        this.f4097J = i7;
        this.K = null;
        this.L = 0.1f;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = Float.NaN;
        this.R = false;
        this.S = i7;
        this.T = i7;
        this.U = i7;
        this.V = new RectF();
        this.W = new RectF();
        this.X = new HashMap<>();
        this.f3975d = 5;
        this.f3976e = new HashMap<>();
    }

    private void B(String str, View call) {
        Method method;
        if (str == null) {
            return;
        }
        if (str.startsWith(com.alibaba.android.arouter.utils.b.f12515h)) {
            C(str, call);
            return;
        }
        if (this.X.containsKey(str)) {
            method = this.X.get(str);
            if (method == null) {
                return;
            }
        } else {
            method = null;
        }
        if (method == null) {
            try {
                method = call.getClass().getMethod(str, new Class[0]);
                this.X.put(str, method);
            } catch (NoSuchMethodException unused) {
                this.X.put(str, null);
                Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + call.getClass().getSimpleName() + " " + c.k(call));
                return;
            }
        }
        try {
            method.invoke(call, new Object[0]);
        } catch (Exception unused2) {
            Log.e("KeyTrigger", "Exception in call \"" + this.E + "\"on class " + call.getClass().getSimpleName() + " " + c.k(call));
        }
    }

    private void C(String str, View view) {
        boolean z7 = str.length() == 1;
        if (!z7) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f3976e.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z7 || lowerCase.matches(str)) {
                androidx.constraintlayout.widget.a aVar = this.f3976e.get(str2);
                if (aVar != null) {
                    aVar.a(view);
                }
            }
        }
    }

    private void E(RectF rect, View child, boolean postLayout) {
        rect.top = child.getTop();
        rect.bottom = child.getBottom();
        rect.left = child.getLeft();
        rect.right = child.getRight();
        if (postLayout) {
            child.getMatrix().mapRect(rect);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x008c  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:58:0x00dc  */
    public void A(float pos, View child) {
        boolean z7;
        boolean z8;
        boolean z9;
        float f8;
        float f9;
        boolean z10;
        boolean z11;
        float f10;
        float f11;
        boolean z12;
        if (this.f4097J != f.f3951f) {
            if (this.K == null) {
                this.K = ((ViewGroup) child.getParent()).findViewById(this.f4097J);
            }
            E(this.V, this.K, this.R);
            E(this.W, child, this.R);
            if (this.V.intersect(this.W)) {
                if (this.M) {
                    this.M = false;
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (this.O) {
                    this.O = false;
                    z12 = true;
                } else {
                    z12 = false;
                }
                this.N = true;
                z11 = z12;
                z9 = false;
            } else {
                if (this.M) {
                    z7 = false;
                } else {
                    this.M = true;
                    z7 = true;
                }
                if (this.N) {
                    this.N = false;
                    z9 = true;
                } else {
                    z9 = false;
                }
                this.O = true;
                z11 = false;
            }
        } else {
            if (this.M) {
                float f12 = this.P;
                if ((pos - f12) * (this.Q - f12) < 0.0f) {
                    this.M = false;
                    z7 = true;
                }
                if (this.N) {
                    f10 = this.P;
                    f11 = pos - f10;
                    if ((this.Q - f10) * f11 >= 0.0f && f11 < 0.0f) {
                        this.N = false;
                        z8 = true;
                    }
                    if (this.O) {
                        f8 = this.P;
                        f9 = pos - f8;
                        if ((this.Q - f8) * f9 < 0.0f || f9 <= 0.0f) {
                            z10 = false;
                        } else {
                            this.O = false;
                            z10 = true;
                        }
                        boolean z13 = z8;
                        z11 = z10;
                        z9 = z13;
                    } else {
                        if (Math.abs(pos - this.P) > this.L) {
                            this.O = true;
                        }
                        z9 = z8;
                        z11 = false;
                    }
                } else if (Math.abs(pos - this.P) > this.L) {
                    this.N = true;
                }
                z8 = false;
                if (this.O) {
                    f8 = this.P;
                    f9 = pos - f8;
                    if ((this.Q - f8) * f9 < 0.0f) {
                        z10 = false;
                    } else {
                        z10 = false;
                    }
                    boolean z14 = z8;
                    z11 = z10;
                    z9 = z14;
                } else {
                    if (Math.abs(pos - this.P) > this.L) {
                        this.O = true;
                    }
                    z9 = z8;
                    z11 = false;
                }
            } else if (Math.abs(pos - this.P) > this.L) {
                this.M = true;
            }
            z7 = false;
            if (this.N) {
                f10 = this.P;
                f11 = pos - f10;
                if ((this.Q - f10) * f11 >= 0.0f) {
                }
                if (this.O) {
                    f8 = this.P;
                    f9 = pos - f8;
                    if ((this.Q - f8) * f9 < 0.0f) {
                        z10 = false;
                    } else {
                        z10 = false;
                    }
                    boolean z15 = z8;
                    z11 = z10;
                    z9 = z15;
                } else {
                    if (Math.abs(pos - this.P) > this.L) {
                        this.O = true;
                    }
                    z9 = z8;
                    z11 = false;
                }
            } else if (Math.abs(pos - this.P) > this.L) {
                this.N = true;
            }
            z8 = false;
            if (this.O) {
                f8 = this.P;
                f9 = pos - f8;
                if ((this.Q - f8) * f9 < 0.0f) {
                    z10 = false;
                } else {
                    z10 = false;
                }
                boolean z16 = z8;
                z11 = z10;
                z9 = z16;
            } else {
                if (Math.abs(pos - this.P) > this.L) {
                    this.O = true;
                }
                z9 = z8;
                z11 = false;
            }
        }
        this.Q = pos;
        if (z9 || z7 || z11) {
            ((MotionLayout) child.getParent()).x0(this.I, z11, pos);
        }
        View viewFindViewById = this.F == f.f3951f ? child : ((MotionLayout) child.getParent()).findViewById(this.F);
        if (z9) {
            String str = this.G;
            if (str != null) {
                B(str, viewFindViewById);
            }
            if (this.S != f.f3951f) {
                ((MotionLayout) child.getParent()).j1(this.S, viewFindViewById);
            }
        }
        if (z11) {
            String str2 = this.H;
            if (str2 != null) {
                B(str2, viewFindViewById);
            }
            if (this.T != f.f3951f) {
                ((MotionLayout) child.getParent()).j1(this.T, viewFindViewById);
            }
        }
        if (z7) {
            String str3 = this.E;
            if (str3 != null) {
                B(str3, viewFindViewById);
            }
            if (this.U != f.f3951f) {
                ((MotionLayout) child.getParent()).j1(this.U, viewFindViewById);
            }
        }
    }

    int D() {
        return this.D;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void a(HashMap<String, androidx.constraintlayout.motion.utils.d> splines) {
    }

    @Override // androidx.constraintlayout.motion.widget.f
    /* JADX INFO: renamed from: b */
    public f clone() {
        return new m().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public f c(f src) {
        super.c(src);
        m mVar = (m) src;
        this.D = mVar.D;
        this.E = mVar.E;
        this.F = mVar.F;
        this.G = mVar.G;
        this.H = mVar.H;
        this.I = mVar.I;
        this.f4097J = mVar.f4097J;
        this.K = mVar.K;
        this.L = mVar.L;
        this.M = mVar.M;
        this.N = mVar.N;
        this.O = mVar.O;
        this.P = mVar.P;
        this.Q = mVar.Q;
        this.R = mVar.R;
        this.V = mVar.V;
        this.W = mVar.W;
        this.X = mVar.X;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void d(HashSet<String> attributes) {
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void f(Context context, AttributeSet attrs) {
        a.a(this, context.obtainStyledAttributes(attrs, R.styleable.KeyTrigger), context);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.f
    public void j(String tag, Object value) {
        tag.hashCode();
        byte b8 = -1;
        switch (tag.hashCode()) {
            case -1594793529:
                if (tag.equals("positiveCross")) {
                    b8 = 0;
                }
                break;
            case -966421266:
                if (tag.equals("viewTransitionOnPositiveCross")) {
                    b8 = 1;
                }
                break;
            case -786670827:
                if (tag.equals("triggerCollisionId")) {
                    b8 = 2;
                }
                break;
            case -648752941:
                if (tag.equals("triggerID")) {
                    b8 = 3;
                }
                break;
            case -638126837:
                if (tag.equals("negativeCross")) {
                    b8 = 4;
                }
                break;
            case -76025313:
                if (tag.equals("triggerCollisionView")) {
                    b8 = 5;
                }
                break;
            case -9754574:
                if (tag.equals("viewTransitionOnNegativeCross")) {
                    b8 = 6;
                }
                break;
            case 64397344:
                if (tag.equals("CROSS")) {
                    b8 = 7;
                }
                break;
            case 364489912:
                if (tag.equals("triggerSlack")) {
                    b8 = 8;
                }
                break;
            case 1301930599:
                if (tag.equals("viewTransitionOnCross")) {
                    b8 = 9;
                }
                break;
            case 1401391082:
                if (tag.equals("postLayout")) {
                    b8 = 10;
                }
                break;
            case 1535404999:
                if (tag.equals("triggerReceiver")) {
                    b8 = com.google.common.base.c.f19313m;
                }
                break;
        }
        switch (b8) {
            case 0:
                this.H = value.toString();
                break;
            case 1:
                this.T = n(value);
                break;
            case 2:
                this.f4097J = n(value);
                break;
            case 3:
                this.I = n(value);
                break;
            case 4:
                this.G = value.toString();
                break;
            case 5:
                this.K = (View) value;
                break;
            case 6:
                this.S = n(value);
                break;
            case 7:
                this.E = value.toString();
                break;
            case 8:
                this.L = m(value);
                break;
            case 9:
                this.U = n(value);
                break;
            case 10:
                this.R = l(value);
                break;
            case 11:
                this.F = n(value);
                break;
        }
    }
}
