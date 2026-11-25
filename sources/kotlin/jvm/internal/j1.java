package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j1 extends q implements kotlin.reflect.o {
    public j1() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j1) {
            j1 j1Var = (j1) obj;
            return v0().equals(j1Var.v0()) && getName().equals(j1Var.getName()) && x0().equals(j1Var.x0()) && l0.g(u0(), j1Var.u0());
        }
        if (obj instanceof kotlin.reflect.o) {
            return obj.equals(s0());
        }
        return false;
    }

    public int hashCode() {
        return (((v0().hashCode() * 31) + getName().hashCode()) * 31) + x0().hashCode();
    }

    @Override // kotlin.reflect.o
    @kotlin.g1(version = "1.1")
    public boolean i0() {
        return w0().i0();
    }

    @Override // kotlin.reflect.o
    @kotlin.g1(version = "1.1")
    public boolean q() {
        return w0().q();
    }

    public String toString() {
        kotlin.reflect.c cVarS0 = s0();
        if (cVarS0 != this) {
            return cVarS0.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.q
    @kotlin.g1(version = "1.1")
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.o w0() {
        return (kotlin.reflect.o) super.w0();
    }

    @kotlin.g1(version = "1.1")
    public j1(Object obj) {
        super(obj);
    }

    @kotlin.g1(version = "1.4")
    public j1(Object obj, Class cls, String str, String str2, int i7) {
        super(obj, cls, str, str2, (i7 & 1) == 1);
    }
}
