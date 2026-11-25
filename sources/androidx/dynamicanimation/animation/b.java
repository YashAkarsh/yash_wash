package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.n2;
import androidx.dynamicanimation.animation.b;
import c.v;
import c.x0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends b<T>> implements androidx.dynamicanimation.animation.a.b {
    public static final float A = 1.0f;
    public static final float B = 0.1f;
    public static final float C = 0.00390625f;
    public static final float D = 0.002f;
    private static final float E = Float.MAX_VALUE;
    private static final float F = 0.75f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final s f7384m = new g("translationX");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final s f7385n = new h("translationY");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final s f7386o = new i("translationZ");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final s f7387p = new j("scaleX");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final s f7388q = new k("scaleY");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final s f7389r = new l(androidx.constraintlayout.motion.widget.f.f3954i);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final s f7390s = new m("rotationX");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final s f7391t = new n("rotationY");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final s f7392u = new o("x");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final s f7393v = new a("y");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final s f7394w = new C0091b("z");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final s f7395x = new c("alpha");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final s f7396y = new d("scrollX");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final s f7397z = new e("scrollY");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f7398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f7399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f7400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object f7401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final androidx.dynamicanimation.animation.g f7402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f7403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f7404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f7405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f7406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f7407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ArrayList<q> f7408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ArrayList<r> f7409l;

    static class a extends s {
        a(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setY(f8);
        }
    }

    /* JADX INFO: renamed from: androidx.dynamicanimation.animation.b$b, reason: collision with other inner class name */
    static class C0091b extends s {
        C0091b(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return n2.F0(view);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            n2.B2(view, f8);
        }
    }

    static class c extends s {
        c(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setAlpha(f8);
        }
    }

    static class d extends s {
        d(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setScrollX((int) f8);
        }
    }

    static class e extends s {
        e(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setScrollY((int) f8);
        }
    }

    class f extends androidx.dynamicanimation.animation.g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.dynamicanimation.animation.h f7410b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, androidx.dynamicanimation.animation.h hVar) {
            super(str);
            this.f7410b = hVar;
        }

        @Override // androidx.dynamicanimation.animation.g
        public float b(Object obj) {
            return this.f7410b.a();
        }

        @Override // androidx.dynamicanimation.animation.g
        public void c(Object obj, float f8) {
            this.f7410b.b(f8);
        }
    }

    static class g extends s {
        g(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setTranslationX(f8);
        }
    }

    static class h extends s {
        h(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setTranslationY(f8);
        }
    }

    static class i extends s {
        i(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return n2.A0(view);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            n2.w2(view, f8);
        }
    }

    static class j extends s {
        j(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setScaleX(f8);
        }
    }

    static class k extends s {
        k(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setScaleY(f8);
        }
    }

    static class l extends s {
        l(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setRotation(f8);
        }
    }

    static class m extends s {
        m(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setRotationX(f8);
        }
    }

    static class n extends s {
        n(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setRotationY(f8);
        }
    }

    static class o extends s {
        o(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.g
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(View view, float f8) {
            view.setX(f8);
        }
    }

    static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f7412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f7413b;

        p() {
        }
    }

    public interface q {
        void a(b bVar, boolean z7, float f8, float f9);
    }

    public interface r {
        void a(b bVar, float f8, float f9);
    }

    public static abstract class s extends androidx.dynamicanimation.animation.g<View> {
        /* synthetic */ s(String str, g gVar) {
            this(str);
        }

        private s(String str) {
            super(str);
        }
    }

    b(androidx.dynamicanimation.animation.h hVar) {
        this.f7398a = 0.0f;
        this.f7399b = Float.MAX_VALUE;
        this.f7400c = false;
        this.f7403f = false;
        this.f7404g = Float.MAX_VALUE;
        this.f7405h = -Float.MAX_VALUE;
        this.f7406i = 0L;
        this.f7408k = new ArrayList<>();
        this.f7409l = new ArrayList<>();
        this.f7401d = null;
        this.f7402e = new f("FloatValueHolder", hVar);
        this.f7407j = 1.0f;
    }

    private void e(boolean z7) {
        this.f7403f = false;
        androidx.dynamicanimation.animation.a.e().h(this);
        this.f7406i = 0L;
        this.f7400c = false;
        for (int i7 = 0; i7 < this.f7408k.size(); i7++) {
            if (this.f7408k.get(i7) != null) {
                this.f7408k.get(i7).a(this, z7, this.f7399b, this.f7398a);
            }
        }
        n(this.f7408k);
    }

    private float h() {
        return this.f7402e.b(this.f7401d);
    }

    private static <T> void m(ArrayList<T> arrayList, T t7) {
        int iIndexOf = arrayList.indexOf(t7);
        if (iIndexOf >= 0) {
            arrayList.set(iIndexOf, null);
        }
    }

    private static <T> void n(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void x() {
        if (this.f7403f) {
            return;
        }
        this.f7403f = true;
        if (!this.f7400c) {
            this.f7399b = h();
        }
        float f8 = this.f7399b;
        if (f8 > this.f7404g || f8 < this.f7405h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        androidx.dynamicanimation.animation.a.e().a(this, 0L);
    }

    @Override // androidx.dynamicanimation.animation.a.b
    @x0({x0.a.LIBRARY})
    public boolean a(long j7) {
        long j8 = this.f7406i;
        if (j8 == 0) {
            this.f7406i = j7;
            s(this.f7399b);
            return false;
        }
        this.f7406i = j7;
        boolean zY = y(j7 - j8);
        float fMin = Math.min(this.f7399b, this.f7404g);
        this.f7399b = fMin;
        float fMax = Math.max(fMin, this.f7405h);
        this.f7399b = fMax;
        s(fMax);
        if (zY) {
            e(false);
        }
        return zY;
    }

    public T b(q qVar) {
        if (!this.f7408k.contains(qVar)) {
            this.f7408k.add(qVar);
        }
        return this;
    }

    public T c(r rVar) {
        if (k()) {
            throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
        }
        if (!this.f7409l.contains(rVar)) {
            this.f7409l.add(rVar);
        }
        return this;
    }

    public void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        }
        if (this.f7403f) {
            e(true);
        }
    }

    abstract float f(float f8, float f9);

    public float g() {
        return this.f7407j;
    }

    float i() {
        return this.f7407j * 0.75f;
    }

    abstract boolean j(float f8, float f9);

    public boolean k() {
        return this.f7403f;
    }

    public void l(q qVar) {
        m(this.f7408k, qVar);
    }

    public void o(r rVar) {
        m(this.f7409l, rVar);
    }

    public T p(float f8) {
        this.f7404g = f8;
        return this;
    }

    public T q(float f8) {
        this.f7405h = f8;
        return this;
    }

    public T r(@v(from = 0.0d, fromInclusive = false) float f8) {
        if (f8 <= 0.0f) {
            throw new IllegalArgumentException("Minimum visible change must be positive.");
        }
        this.f7407j = f8;
        v(f8 * 0.75f);
        return this;
    }

    void s(float f8) {
        this.f7402e.c(this.f7401d, f8);
        for (int i7 = 0; i7 < this.f7409l.size(); i7++) {
            if (this.f7409l.get(i7) != null) {
                this.f7409l.get(i7).a(this, this.f7399b, this.f7398a);
            }
        }
        n(this.f7409l);
    }

    public T t(float f8) {
        this.f7399b = f8;
        this.f7400c = true;
        return this;
    }

    public T u(float f8) {
        this.f7398a = f8;
        return this;
    }

    abstract void v(float f8);

    public void w() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f7403f) {
            return;
        }
        x();
    }

    abstract boolean y(long j7);

    <K> b(K k7, androidx.dynamicanimation.animation.g<K> gVar) {
        this.f7398a = 0.0f;
        this.f7399b = Float.MAX_VALUE;
        this.f7400c = false;
        this.f7403f = false;
        this.f7404g = Float.MAX_VALUE;
        this.f7405h = -Float.MAX_VALUE;
        this.f7406i = 0L;
        this.f7408k = new ArrayList<>();
        this.f7409l = new ArrayList<>();
        this.f7401d = k7;
        this.f7402e = gVar;
        if (gVar != f7389r && gVar != f7390s && gVar != f7391t) {
            if (gVar == f7395x) {
                this.f7407j = 0.00390625f;
                return;
            } else if (gVar != f7387p && gVar != f7388q) {
                this.f7407j = 1.0f;
                return;
            } else {
                this.f7407j = 0.00390625f;
                return;
            }
        }
        this.f7407j = 0.1f;
    }
}
