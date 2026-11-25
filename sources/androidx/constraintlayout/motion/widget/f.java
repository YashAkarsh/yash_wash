package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static final String A = "motionProgress";
    public static final String B = "transitionEasing";
    public static final String C = "visibility";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f3951f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f3952g = "alpha";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f3953h = "elevation";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f3954i = "rotation";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f3955j = "rotationX";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f3956k = "rotationY";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f3957l = "transformPivotX";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f3958m = "transformPivotY";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f3959n = "transitionPathRotate";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f3960o = "scaleX";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f3961p = "scaleY";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f3962q = "wavePeriod";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f3963r = "waveOffset";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f3964s = "wavePhase";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f3965t = "waveVariesBy";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f3966u = "translationX";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f3967v = "translationY";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f3968w = "translationZ";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f3969x = "progress";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f3970y = "CUSTOM";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f3971z = "curveFit";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f3972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f3974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f3975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    HashMap<String, androidx.constraintlayout.widget.a> f3976e;

    public f() {
        int i7 = f3951f;
        this.f3972a = i7;
        this.f3973b = i7;
        this.f3974c = null;
    }

    public abstract void a(HashMap<String, androidx.constraintlayout.motion.utils.d> splines);

    @Override // 
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract f clone();

    public f c(f src) {
        this.f3972a = src.f3972a;
        this.f3973b = src.f3973b;
        this.f3974c = src.f3974c;
        this.f3975d = src.f3975d;
        this.f3976e = src.f3976e;
        return this;
    }

    abstract void d(HashSet<String> attributes);

    public int e() {
        return this.f3972a;
    }

    abstract void f(Context context, AttributeSet attrs);

    boolean g(String constraintTag) {
        String str = this.f3974c;
        if (str == null || constraintTag == null) {
            return false;
        }
        return constraintTag.matches(str);
    }

    public void h(int pos) {
        this.f3972a = pos;
    }

    public void i(HashMap<String, Integer> interpolation) {
    }

    public abstract void j(String tag, Object value);

    public f k(int id) {
        this.f3973b = id;
        return this;
    }

    boolean l(Object value) {
        return value instanceof Boolean ? ((Boolean) value).booleanValue() : Boolean.parseBoolean(value.toString());
    }

    float m(Object value) {
        return value instanceof Float ? ((Float) value).floatValue() : Float.parseFloat(value.toString());
    }

    int n(Object value) {
        return value instanceof Integer ? ((Integer) value).intValue() : Integer.parseInt(value.toString());
    }
}
