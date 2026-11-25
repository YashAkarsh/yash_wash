package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class z {
    public static final String A = "ConstraintOverride";
    public static final String B = "CustomAttribute";
    public static final String C = "CustomMethod";
    private static final int D = -1;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 3;
    public static final int H = 4;
    public static final int I = 5;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    static final int f4329J = 0;
    static final int K = 1;
    static final int L = 2;
    private static final int M = -1;
    private static final int N = -2;
    static final int O = 0;
    static final int P = 1;
    static final int Q = 2;
    static final int R = 3;
    static final int S = 4;
    static final int T = 5;
    static final int U = 6;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static String f4330x = "ViewTransition";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f4331y = "ViewTransition";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f4332z = "KeyFrameSet";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    androidx.constraintlayout.widget.d f4333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4334b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f4338f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    i f4339g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    androidx.constraintlayout.widget.d.a f4340h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4343k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f4344l;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Context f4348p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4335c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4336d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4337e = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4341i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4342j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f4345m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f4346n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f4347o = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f4349q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f4350r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f4351s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f4352t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4353u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4354v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4355w = -1;

    class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.constraintlayout.core.motion.utils.d f4356a;

        a(final z this$0, final androidx.constraintlayout.core.motion.utils.d val$easing) {
            this.f4356a = val$easing;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float v7) {
            return (float) this.f4356a.a(v7);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f4358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f4359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        o f4360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f4361e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f4362f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        a0 f4364h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Interpolator f4365i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f4367k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f4368l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f4369m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f4371o;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        androidx.constraintlayout.core.motion.utils.g f4363g = new androidx.constraintlayout.core.motion.utils.g();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f4366j = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Rect f4370n = new Rect();

        b(a0 controller, o motionController, int duration, int upDuration, int mode, Interpolator interpolator, int setTag, int clearTag) {
            this.f4371o = false;
            this.f4364h = controller;
            this.f4360d = motionController;
            this.f4361e = duration;
            this.f4362f = upDuration;
            long jNanoTime = System.nanoTime();
            this.f4359c = jNanoTime;
            this.f4369m = jNanoTime;
            this.f4364h.c(this);
            this.f4365i = interpolator;
            this.f4357a = setTag;
            this.f4358b = clearTag;
            if (mode == 3) {
                this.f4371o = true;
            }
            this.f4368l = duration == 0 ? Float.MAX_VALUE : 1.0f / duration;
            a();
        }

        void a() {
            if (this.f4366j) {
                c();
            } else {
                b();
            }
        }

        void b() {
            long jNanoTime = System.nanoTime();
            long j7 = jNanoTime - this.f4369m;
            this.f4369m = jNanoTime;
            float f8 = this.f4367k + (((float) (j7 * 1.0E-6d)) * this.f4368l);
            this.f4367k = f8;
            if (f8 >= 1.0f) {
                this.f4367k = 1.0f;
            }
            Interpolator interpolator = this.f4365i;
            float interpolation = interpolator == null ? this.f4367k : interpolator.getInterpolation(this.f4367k);
            o oVar = this.f4360d;
            boolean zL = oVar.L(oVar.f4154b, interpolation, jNanoTime, this.f4363g);
            if (this.f4367k >= 1.0f) {
                if (this.f4357a != -1) {
                    this.f4360d.J().setTag(this.f4357a, Long.valueOf(System.nanoTime()));
                }
                if (this.f4358b != -1) {
                    this.f4360d.J().setTag(this.f4358b, null);
                }
                if (!this.f4371o) {
                    this.f4364h.k(this);
                }
            }
            if (this.f4367k < 1.0f || zL) {
                this.f4364h.g();
            }
        }

        void c() {
            long jNanoTime = System.nanoTime();
            long j7 = jNanoTime - this.f4369m;
            this.f4369m = jNanoTime;
            float f8 = this.f4367k - (((float) (j7 * 1.0E-6d)) * this.f4368l);
            this.f4367k = f8;
            if (f8 < 0.0f) {
                this.f4367k = 0.0f;
            }
            Interpolator interpolator = this.f4365i;
            float interpolation = interpolator == null ? this.f4367k : interpolator.getInterpolation(this.f4367k);
            o oVar = this.f4360d;
            boolean zL = oVar.L(oVar.f4154b, interpolation, jNanoTime, this.f4363g);
            if (this.f4367k <= 0.0f) {
                if (this.f4357a != -1) {
                    this.f4360d.J().setTag(this.f4357a, Long.valueOf(System.nanoTime()));
                }
                if (this.f4358b != -1) {
                    this.f4360d.J().setTag(this.f4358b, null);
                }
                this.f4364h.k(this);
            }
            if (this.f4367k > 0.0f || zL) {
                this.f4364h.g();
            }
        }

        public void d(int action, float x7, float y7) {
            if (action == 1) {
                if (this.f4366j) {
                    return;
                }
                e(true);
            } else {
                if (action != 2) {
                    return;
                }
                this.f4360d.J().getHitRect(this.f4370n);
                if (this.f4370n.contains((int) x7, (int) y7) || this.f4366j) {
                    return;
                }
                e(true);
            }
        }

        void e(boolean dir) {
            int i7;
            this.f4366j = dir;
            if (dir && (i7 = this.f4362f) != -1) {
                this.f4368l = i7 == 0 ? Float.MAX_VALUE : 1.0f / i7;
            }
            this.f4364h.g();
            this.f4369m = System.nanoTime();
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007f  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    z(Context context, XmlPullParser parser) {
        byte b8;
        this.f4348p = context;
        try {
            int eventType = parser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = parser.getName();
                    switch (name.hashCode()) {
                        case -1962203927:
                            if (!name.equals(A)) {
                                b8 = -1;
                            } else {
                                b8 = 2;
                            }
                            break;
                        case -1239391468:
                            if (!name.equals(f4332z)) {
                                b8 = -1;
                            } else {
                                b8 = 1;
                            }
                            break;
                        case 61998586:
                            if (!name.equals(f4331y)) {
                                b8 = -1;
                            } else {
                                b8 = 0;
                            }
                            break;
                        case 366511058:
                            if (!name.equals(C)) {
                                b8 = -1;
                            } else {
                                b8 = 4;
                            }
                            break;
                        case 1791837707:
                            if (!name.equals(B)) {
                                b8 = -1;
                            } else {
                                b8 = 3;
                            }
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    if (b8 == 0) {
                        n(context, parser);
                    } else if (b8 == 1) {
                        this.f4339g = new i(context, parser);
                    } else if (b8 == 2) {
                        this.f4340h = androidx.constraintlayout.widget.d.w(context, parser);
                    } else if (b8 == 3 || b8 == 4) {
                        androidx.constraintlayout.widget.a.q(context, parser, this.f4340h.f4771g);
                    } else {
                        Log.e(f4330x, c.f() + " unknown tag " + name);
                        Log.e(f4330x, ".xml:" + parser.getLineNumber());
                    }
                } else if (eventType == 3 && f4331y.equals(parser.getName())) {
                    return;
                }
                eventType = parser.next();
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        } catch (XmlPullParserException e9) {
            e9.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View[] viewArr) {
        if (this.f4349q != -1) {
            for (View view : viewArr) {
                view.setTag(this.f4349q, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.f4350r != -1) {
            for (View view2 : viewArr) {
                view2.setTag(this.f4350r, null);
            }
        }
    }

    private void n(Context context, XmlPullParser parser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.ViewTransition);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i7 = 0; i7 < indexCount; i7++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i7);
            if (index == R.styleable.ViewTransition_android_id) {
                this.f4334b = typedArrayObtainStyledAttributes.getResourceId(index, this.f4334b);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.W1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f4343k);
                    this.f4343k = resourceId;
                    if (resourceId == -1) {
                        this.f4344l = typedArrayObtainStyledAttributes.getString(index);
                    }
                } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                    this.f4344l = typedArrayObtainStyledAttributes.getString(index);
                } else {
                    this.f4343k = typedArrayObtainStyledAttributes.getResourceId(index, this.f4343k);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.f4335c = typedArrayObtainStyledAttributes.getInt(index, this.f4335c);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.f4336d = typedArrayObtainStyledAttributes.getBoolean(index, this.f4336d);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.f4337e = typedArrayObtainStyledAttributes.getInt(index, this.f4337e);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.f4341i = typedArrayObtainStyledAttributes.getInt(index, this.f4341i);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.f4342j = typedArrayObtainStyledAttributes.getInt(index, this.f4342j);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.f4338f = typedArrayObtainStyledAttributes.getInt(index, this.f4338f);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                int i8 = typedArrayObtainStyledAttributes.peekValue(index).type;
                if (i8 == 1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    this.f4347o = resourceId2;
                    if (resourceId2 != -1) {
                        this.f4345m = -2;
                    }
                } else if (i8 == 3) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f4346n = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.f4345m = -1;
                    } else {
                        this.f4347o = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.f4345m = -2;
                    }
                } else {
                    this.f4345m = typedArrayObtainStyledAttributes.getInteger(index, this.f4345m);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.f4349q = typedArrayObtainStyledAttributes.getResourceId(index, this.f4349q);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.f4350r = typedArrayObtainStyledAttributes.getResourceId(index, this.f4350r);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.f4351s = typedArrayObtainStyledAttributes.getResourceId(index, this.f4351s);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.f4352t = typedArrayObtainStyledAttributes.getResourceId(index, this.f4352t);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.f4354v = typedArrayObtainStyledAttributes.getResourceId(index, this.f4354v);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.f4353u = typedArrayObtainStyledAttributes.getInteger(index, this.f4353u);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void v(s.b transition, View view) {
        int i7 = this.f4341i;
        if (i7 != -1) {
            transition.O(i7);
        }
        transition.V(this.f4337e);
        transition.R(this.f4345m, this.f4346n, this.f4347o);
        int id = view.getId();
        i iVar = this.f4339g;
        if (iVar != null) {
            ArrayList<f> arrayListD = iVar.d(-1);
            i iVar2 = new i();
            Iterator<f> it = arrayListD.iterator();
            while (it.hasNext()) {
                iVar2.c(it.next().clone().k(id));
            }
            transition.t(iVar2);
        }
    }

    void b(a0 controller, MotionLayout motionLayout, View view) {
        o oVar = new o(view);
        oVar.R(view);
        this.f4339g.a(oVar);
        oVar.a0(motionLayout.getWidth(), motionLayout.getHeight(), this.f4341i, System.nanoTime());
        new b(controller, oVar, this.f4341i, this.f4342j, this.f4335c, f(motionLayout.getContext()), this.f4349q, this.f4350r);
    }

    void c(a0 controller, MotionLayout layout, int fromId, androidx.constraintlayout.widget.d current, final View... views) {
        if (this.f4336d) {
            return;
        }
        int i7 = this.f4338f;
        if (i7 == 2) {
            b(controller, layout, views[0]);
            return;
        }
        if (i7 == 1) {
            for (int i8 : layout.getConstraintSetIds()) {
                if (i8 != fromId) {
                    androidx.constraintlayout.widget.d dVarZ0 = layout.z0(i8);
                    for (View view : views) {
                        androidx.constraintlayout.widget.d.a aVarK0 = dVarZ0.k0(view.getId());
                        androidx.constraintlayout.widget.d.a aVar = this.f4340h;
                        if (aVar != null) {
                            aVar.h(aVarK0);
                            aVarK0.f4771g.putAll(this.f4340h.f4771g);
                        }
                    }
                }
            }
        }
        androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
        dVar.I(current);
        for (View view2 : views) {
            androidx.constraintlayout.widget.d.a aVarK1 = dVar.k0(view2.getId());
            androidx.constraintlayout.widget.d.a aVar2 = this.f4340h;
            if (aVar2 != null) {
                aVar2.h(aVarK1);
                aVarK1.f4771g.putAll(this.f4340h.f4771g);
            }
        }
        layout.h1(fromId, dVar);
        layout.h1(R.id.view_transition, current);
        layout.setState(R.id.view_transition, -1, -1);
        s.b bVar = new s.b(-1, layout.I, R.id.view_transition, fromId);
        for (View view3 : views) {
            v(bVar, view3);
        }
        layout.setTransition(bVar);
        layout.a1(new Runnable() { // from class: androidx.constraintlayout.motion.widget.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f4327a.l(views);
            }
        });
    }

    boolean d(View view) {
        int i7 = this.f4351s;
        boolean z7 = i7 == -1 || view.getTag(i7) != null;
        int i8 = this.f4352t;
        return z7 && (i8 == -1 || view.getTag(i8) == null);
    }

    int e() {
        return this.f4334b;
    }

    Interpolator f(Context context) {
        int i7 = this.f4345m;
        if (i7 == -2) {
            return AnimationUtils.loadInterpolator(context, this.f4347o);
        }
        if (i7 == -1) {
            return new a(this, androidx.constraintlayout.core.motion.utils.d.c(this.f4346n));
        }
        if (i7 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i7 == 1) {
            return new AccelerateInterpolator();
        }
        if (i7 == 2) {
            return new DecelerateInterpolator();
        }
        if (i7 == 4) {
            return new BounceInterpolator();
        }
        if (i7 == 5) {
            return new OvershootInterpolator();
        }
        if (i7 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public int g() {
        return this.f4353u;
    }

    public int h() {
        return this.f4355w;
    }

    public int i() {
        return this.f4354v;
    }

    public int j() {
        return this.f4335c;
    }

    boolean k() {
        return !this.f4336d;
    }

    boolean m(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.f4343k == -1 && this.f4344l == null) || !d(view)) {
            return false;
        }
        if (view.getId() == this.f4343k) {
            return true;
        }
        return this.f4344l != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).f4523c0) != null && str.matches(this.f4344l);
    }

    void o(boolean enable) {
        this.f4336d = !enable;
    }

    void p(int id) {
        this.f4334b = id;
    }

    public void q(int sharedValue) {
        this.f4353u = sharedValue;
    }

    public void r(int sharedValueCurrent) {
        this.f4355w = sharedValueCurrent;
    }

    public void s(int sharedValueID) {
        this.f4354v = sharedValueID;
    }

    public void t(int stateTransition) {
        this.f4335c = stateTransition;
    }

    public String toString() {
        return "ViewTransition(" + c.i(this.f4348p, this.f4334b) + ")";
    }

    boolean u(int action) {
        int i7 = this.f4335c;
        if (i7 == 1) {
            return action == 0;
        }
        if (i7 == 2) {
            return action == 1;
        }
        return i7 == 3 && action == 0;
    }
}
