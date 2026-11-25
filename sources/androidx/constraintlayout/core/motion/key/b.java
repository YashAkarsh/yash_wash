package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.o;
import androidx.constraintlayout.core.motion.utils.w;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements w {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f2683m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f2684n = "alpha";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f2685o = "elevation";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f2686p = "rotationZ";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f2687q = "rotationX";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f2688r = "transitionPathRotate";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f2689s = "scaleX";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f2690t = "scaleY";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f2691u = "translationX";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f2692v = "translationY";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f2693w = "CUSTOM";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f2694x = "visibility";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f2696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f2697j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2698k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HashMap<String, androidx.constraintlayout.core.motion.b> f2699l;

    public b() {
        int i7 = f2683m;
        this.f2695h = i7;
        this.f2696i = i7;
        this.f2697j = null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean a(int i7, int i8) {
        if (i7 != 100) {
            return false;
        }
        this.f2695h = i8;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean b(int i7, float f8) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean c(int i7, String str) {
        if (i7 != 101) {
            return false;
        }
        this.f2697j = str;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.w
    public boolean d(int i7, boolean z7) {
        return false;
    }

    public abstract void f(HashMap<String, o> map);

    @Override // 
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public abstract b clone();

    public b h(b bVar) {
        this.f2695h = bVar.f2695h;
        this.f2696i = bVar.f2696i;
        this.f2697j = bVar.f2697j;
        this.f2698k = bVar.f2698k;
        return this;
    }

    public abstract void i(HashSet<String> hashSet);

    public int j() {
        return this.f2695h;
    }

    boolean k(String str) {
        String str2 = this.f2697j;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void l(String str, int i7, float f8) {
        this.f2699l.put(str, new androidx.constraintlayout.core.motion.b(str, i7, f8));
    }

    public void m(String str, int i7, int i8) {
        this.f2699l.put(str, new androidx.constraintlayout.core.motion.b(str, i7, i8));
    }

    public void n(String str, int i7, String str2) {
        this.f2699l.put(str, new androidx.constraintlayout.core.motion.b(str, i7, str2));
    }

    public void o(String str, int i7, boolean z7) {
        this.f2699l.put(str, new androidx.constraintlayout.core.motion.b(str, i7, z7));
    }

    public void p(int i7) {
        this.f2695h = i7;
    }

    public void q(HashMap<String, Integer> map) {
    }

    public b r(int i7) {
        this.f2696i = i7;
        return this;
    }

    boolean s(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    float t(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    int u(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
