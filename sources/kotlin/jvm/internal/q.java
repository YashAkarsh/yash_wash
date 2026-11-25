package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q implements kotlin.reflect.c, Serializable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @kotlin.g1(version = "1.1")
    public static final Object f34893g = a.f34900a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient kotlin.reflect.c f34894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @kotlin.g1(version = "1.1")
    protected final Object f34895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @kotlin.g1(version = "1.4")
    private final Class f34896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @kotlin.g1(version = "1.4")
    private final String f34897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @kotlin.g1(version = "1.4")
    private final String f34898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @kotlin.g1(version = "1.4")
    private final boolean f34899f;

    @kotlin.g1(version = "1.2")
    private static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f34900a = new a();

        private a() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f34900a;
        }
    }

    public q() {
        this(f34893g);
    }

    @Override // kotlin.reflect.c
    public Object O(Map map) {
        return w0().O(map);
    }

    @Override // kotlin.reflect.c
    @kotlin.g1(version = "1.1")
    public boolean b() {
        return w0().b();
    }

    @Override // kotlin.reflect.c
    @kotlin.g1(version = "1.1")
    public boolean e() {
        return w0().e();
    }

    @Override // kotlin.reflect.c
    @kotlin.g1(version = "1.1")
    public kotlin.reflect.w f() {
        return w0().f();
    }

    @Override // kotlin.reflect.c
    public kotlin.reflect.s g0() {
        return w0().g0();
    }

    @Override // kotlin.reflect.b
    public List<Annotation> getAnnotations() {
        return w0().getAnnotations();
    }

    @Override // kotlin.reflect.c
    public String getName() {
        return this.f34897d;
    }

    @Override // kotlin.reflect.c
    public List<kotlin.reflect.n> getParameters() {
        return w0().getParameters();
    }

    @Override // kotlin.reflect.c
    @kotlin.g1(version = "1.1")
    public List<kotlin.reflect.t> getTypeParameters() {
        return w0().getTypeParameters();
    }

    @Override // kotlin.reflect.c, kotlin.reflect.i
    @kotlin.g1(version = "1.3")
    public boolean h() {
        return w0().h();
    }

    @Override // kotlin.reflect.c
    @kotlin.g1(version = "1.1")
    public boolean isOpen() {
        return w0().isOpen();
    }

    @Override // kotlin.reflect.c
    public Object o0(Object... objArr) {
        return w0().o0(objArr);
    }

    @kotlin.g1(version = "1.1")
    public kotlin.reflect.c s0() {
        kotlin.reflect.c cVar = this.f34894a;
        if (cVar != null) {
            return cVar;
        }
        kotlin.reflect.c cVarT0 = t0();
        this.f34894a = cVarT0;
        return cVarT0;
    }

    protected abstract kotlin.reflect.c t0();

    @kotlin.g1(version = "1.1")
    public Object u0() {
        return this.f34895b;
    }

    public kotlin.reflect.h v0() {
        Class cls = this.f34896c;
        if (cls == null) {
            return null;
        }
        return this.f34899f ? l1.g(cls) : l1.d(cls);
    }

    @kotlin.g1(version = "1.1")
    protected kotlin.reflect.c w0() {
        kotlin.reflect.c cVarS0 = s0();
        if (cVarS0 != this) {
            return cVarS0;
        }
        throw new h5.p();
    }

    public String x0() {
        return this.f34898e;
    }

    @kotlin.g1(version = "1.1")
    protected q(Object obj) {
        this(obj, null, null, null, false);
    }

    @kotlin.g1(version = "1.4")
    protected q(Object obj, Class cls, String str, String str2, boolean z7) {
        this.f34895b = obj;
        this.f34896c = cls;
        this.f34897d = str;
        this.f34898e = str2;
        this.f34899f = z7;
    }
}
