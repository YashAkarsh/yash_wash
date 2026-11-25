package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class u0<A, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f35487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f35488b;

    public u0(A a8, B b8) {
        this.f35487a = a8;
        this.f35488b = b8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ u0 d(u0 u0Var, Object obj, Object obj2, int i7, Object obj3) {
        if ((i7 & 1) != 0) {
            obj = u0Var.f35487a;
        }
        if ((i7 & 2) != 0) {
            obj2 = u0Var.f35488b;
        }
        return u0Var.c(obj, obj2);
    }

    public final A a() {
        return this.f35487a;
    }

    public final B b() {
        return this.f35488b;
    }

    @a7.d
    public final u0<A, B> c(A a8, B b8) {
        return new u0<>(a8, b8);
    }

    public final A e() {
        return this.f35487a;
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return kotlin.jvm.internal.l0.g(this.f35487a, u0Var.f35487a) && kotlin.jvm.internal.l0.g(this.f35488b, u0Var.f35488b);
    }

    public final B f() {
        return this.f35488b;
    }

    public int hashCode() {
        A a8 = this.f35487a;
        int iHashCode = (a8 == null ? 0 : a8.hashCode()) * 31;
        B b8 = this.f35488b;
        return iHashCode + (b8 != null ? b8.hashCode() : 0);
    }

    @a7.d
    public String toString() {
        return '(' + this.f35487a + ", " + this.f35488b + ')';
    }
}
