package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public class g0 extends q implements e0, kotlin.reflect.i {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f34853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @kotlin.g1(version = "1.4")
    private final int f34854i;

    public g0(int i7) {
        this(i7, q.f34893g, null, null, null, 0);
    }

    @Override // kotlin.reflect.i
    @kotlin.g1(version = "1.1")
    public boolean H() {
        return w0().H();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0) {
            g0 g0Var = (g0) obj;
            return getName().equals(g0Var.getName()) && x0().equals(g0Var.x0()) && this.f34854i == g0Var.f34854i && this.f34853h == g0Var.f34853h && l0.g(u0(), g0Var.u0()) && l0.g(v0(), g0Var.v0());
        }
        if (obj instanceof kotlin.reflect.i) {
            return obj.equals(s0());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.e0
    public int getArity() {
        return this.f34853h;
    }

    @Override // kotlin.jvm.internal.q, kotlin.reflect.c, kotlin.reflect.i
    @kotlin.g1(version = "1.1")
    public boolean h() {
        return w0().h();
    }

    public int hashCode() {
        return (((v0() == null ? 0 : v0().hashCode() * 31) + getName().hashCode()) * 31) + x0().hashCode();
    }

    @Override // kotlin.reflect.i
    @kotlin.g1(version = "1.1")
    public boolean l0() {
        return w0().l0();
    }

    @Override // kotlin.reflect.i
    @kotlin.g1(version = "1.1")
    public boolean o() {
        return w0().o();
    }

    @Override // kotlin.reflect.i
    @kotlin.g1(version = "1.1")
    public boolean q0() {
        return w0().q0();
    }

    @Override // kotlin.jvm.internal.q
    @kotlin.g1(version = "1.1")
    protected kotlin.reflect.c t0() {
        return l1.c(this);
    }

    public String toString() {
        kotlin.reflect.c cVarS0 = s0();
        if (cVarS0 != this) {
            return cVarS0.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.q
    @kotlin.g1(version = "1.1")
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.i w0() {
        return (kotlin.reflect.i) super.w0();
    }

    @kotlin.g1(version = "1.1")
    public g0(int i7, Object obj) {
        this(i7, obj, null, null, null, 0);
    }

    @kotlin.g1(version = "1.4")
    public g0(int i7, Object obj, Class cls, String str, String str2, int i8) {
        super(obj, cls, str, str2, (i8 & 1) == 1);
        this.f34853h = i7;
        this.f34854i = i8 >> 1;
    }
}
