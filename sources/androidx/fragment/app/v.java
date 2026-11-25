package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.n2;
import c.a1;
import c.b1;
import c.m0;
import c.o0;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    static final int A = 7;
    static final int B = 8;
    static final int C = 9;
    static final int D = 10;
    public static final int E = 4096;
    public static final int F = 8192;
    public static final int G = -1;
    public static final int H = 0;
    public static final int I = 4097;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f8064J = 8194;
    public static final int K = 4099;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final int f8065t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final int f8066u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final int f8067v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final int f8068w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final int f8069x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final int f8070y = 5;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final int f8071z = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f8072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassLoader f8073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList<a> f8074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f8075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f8076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f8077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f8078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f8079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f8080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f8081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    String f8082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f8083l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    CharSequence f8084m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f8085n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    CharSequence f8086o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    ArrayList<String> f8087p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ArrayList<String> f8088q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f8089r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ArrayList<Runnable> f8090s;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f8091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Fragment f8092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f8093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f8094d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f8095e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8096f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        androidx.lifecycle.m.c f8097g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        androidx.lifecycle.m.c f8098h;

        a() {
        }

        a(int i7, Fragment fragment) {
            this.f8091a = i7;
            this.f8092b = fragment;
            androidx.lifecycle.m.c cVar = androidx.lifecycle.m.c.RESUMED;
            this.f8097g = cVar;
            this.f8098h = cVar;
        }

        a(int i7, @m0 Fragment fragment, androidx.lifecycle.m.c cVar) {
            this.f8091a = i7;
            this.f8092b = fragment;
            this.f8097g = fragment.mMaxState;
            this.f8098h = cVar;
        }
    }

    @Deprecated
    public v() {
        this.f8074c = new ArrayList<>();
        this.f8081j = true;
        this.f8089r = false;
        this.f8072a = null;
        this.f8073b = null;
    }

    @m0
    private Fragment v(@m0 Class<? extends Fragment> cls, @o0 Bundle bundle) {
        g gVar = this.f8072a;
        if (gVar == null) {
            throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
        }
        ClassLoader classLoader = this.f8073b;
        if (classLoader == null) {
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        Fragment fragmentA = gVar.a(classLoader, cls.getName());
        if (bundle != null) {
            fragmentA.setArguments(bundle);
        }
        return fragmentA;
    }

    public boolean A() {
        return this.f8081j;
    }

    public boolean B() {
        return this.f8074c.isEmpty();
    }

    @m0
    public v C(@m0 Fragment fragment) {
        n(new a(3, fragment));
        return this;
    }

    @m0
    public v D(@c.b0 int i7, @m0 Fragment fragment) {
        return E(i7, fragment, null);
    }

    @m0
    public v E(@c.b0 int i7, @m0 Fragment fragment, @o0 String str) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        y(i7, fragment, str, 2);
        return this;
    }

    @m0
    public final v F(@c.b0 int i7, @m0 Class<? extends Fragment> cls, @o0 Bundle bundle) {
        return G(i7, cls, bundle, null);
    }

    @m0
    public final v G(@c.b0 int i7, @m0 Class<? extends Fragment> cls, @o0 Bundle bundle, @o0 String str) {
        return E(i7, v(cls, bundle), str);
    }

    @m0
    public v H(@m0 Runnable runnable) {
        x();
        if (this.f8090s == null) {
            this.f8090s = new ArrayList<>();
        }
        this.f8090s.add(runnable);
        return this;
    }

    @m0
    @Deprecated
    public v I(boolean z7) {
        return R(z7);
    }

    @m0
    @Deprecated
    public v J(@a1 int i7) {
        this.f8085n = i7;
        this.f8086o = null;
        return this;
    }

    @m0
    @Deprecated
    public v K(@o0 CharSequence charSequence) {
        this.f8085n = 0;
        this.f8086o = charSequence;
        return this;
    }

    @m0
    @Deprecated
    public v L(@a1 int i7) {
        this.f8083l = i7;
        this.f8084m = null;
        return this;
    }

    @m0
    @Deprecated
    public v M(@o0 CharSequence charSequence) {
        this.f8083l = 0;
        this.f8084m = charSequence;
        return this;
    }

    @m0
    public v N(@c.b @c.a int i7, @c.b @c.a int i8) {
        return O(i7, i8, 0, 0);
    }

    @m0
    public v O(@c.b @c.a int i7, @c.b @c.a int i8, @c.b @c.a int i9, @c.b @c.a int i10) {
        this.f8075d = i7;
        this.f8076e = i8;
        this.f8077f = i9;
        this.f8078g = i10;
        return this;
    }

    @m0
    public v P(@m0 Fragment fragment, @m0 androidx.lifecycle.m.c cVar) {
        n(new a(10, fragment, cVar));
        return this;
    }

    @m0
    public v Q(@o0 Fragment fragment) {
        n(new a(8, fragment));
        return this;
    }

    @m0
    public v R(boolean z7) {
        this.f8089r = z7;
        return this;
    }

    @m0
    public v S(int i7) {
        this.f8079h = i7;
        return this;
    }

    @m0
    @Deprecated
    public v T(@b1 int i7) {
        return this;
    }

    @m0
    public v U(@m0 Fragment fragment) {
        n(new a(5, fragment));
        return this;
    }

    @m0
    public v g(@c.b0 int i7, @m0 Fragment fragment) {
        y(i7, fragment, null, 1);
        return this;
    }

    @m0
    public v h(@c.b0 int i7, @m0 Fragment fragment, @o0 String str) {
        y(i7, fragment, str, 1);
        return this;
    }

    @m0
    public final v i(@c.b0 int i7, @m0 Class<? extends Fragment> cls, @o0 Bundle bundle) {
        return g(i7, v(cls, bundle));
    }

    @m0
    public final v j(@c.b0 int i7, @m0 Class<? extends Fragment> cls, @o0 Bundle bundle, @o0 String str) {
        return h(i7, v(cls, bundle), str);
    }

    v k(@m0 ViewGroup viewGroup, @m0 Fragment fragment, @o0 String str) {
        fragment.mContainer = viewGroup;
        return h(viewGroup.getId(), fragment, str);
    }

    @m0
    public v l(@m0 Fragment fragment, @o0 String str) {
        y(0, fragment, str, 1);
        return this;
    }

    @m0
    public final v m(@m0 Class<? extends Fragment> cls, @o0 Bundle bundle, @o0 String str) {
        return l(v(cls, bundle), str);
    }

    void n(a aVar) {
        this.f8074c.add(aVar);
        aVar.f8093c = this.f8075d;
        aVar.f8094d = this.f8076e;
        aVar.f8095e = this.f8077f;
        aVar.f8096f = this.f8078g;
    }

    @m0
    public v o(@m0 View view, @m0 String str) {
        if (w.D()) {
            String strX0 = n2.x0(view);
            if (strX0 == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.f8087p == null) {
                this.f8087p = new ArrayList<>();
                this.f8088q = new ArrayList<>();
            } else {
                if (this.f8088q.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                }
                if (this.f8087p.contains(strX0)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + strX0 + "' has already been added to the transaction.");
                }
            }
            this.f8087p.add(strX0);
            this.f8088q.add(str);
        }
        return this;
    }

    @m0
    public v p(@o0 String str) {
        if (!this.f8081j) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f8080i = true;
        this.f8082k = str;
        return this;
    }

    @m0
    public v q(@m0 Fragment fragment) {
        n(new a(7, fragment));
        return this;
    }

    public abstract int r();

    public abstract int s();

    public abstract void t();

    public abstract void u();

    @m0
    public v w(@m0 Fragment fragment) {
        n(new a(6, fragment));
        return this;
    }

    @m0
    public v x() {
        if (this.f8080i) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f8081j = false;
        return this;
    }

    void y(int i7, Fragment fragment, @o0 String str, int i8) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i7 != 0) {
            if (i7 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i9 = fragment.mFragmentId;
            if (i9 != 0 && i9 != i7) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i7);
            }
            fragment.mFragmentId = i7;
            fragment.mContainerId = i7;
        }
        n(new a(i8, fragment));
    }

    @m0
    public v z(@m0 Fragment fragment) {
        n(new a(4, fragment));
        return this;
    }

    v(@m0 g gVar, @o0 ClassLoader classLoader) {
        this.f8074c = new ArrayList<>();
        this.f8081j = true;
        this.f8089r = false;
        this.f8072a = gVar;
        this.f8073b = classLoader;
    }
}
