package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class o1<A, B, C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f34977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f34978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C f34979c;

    public o1(A a8, B b8, C c8) {
        this.f34977a = a8;
        this.f34978b = b8;
        this.f34979c = c8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ o1 e(o1 o1Var, Object obj, Object obj2, Object obj3, int i7, Object obj4) {
        if ((i7 & 1) != 0) {
            obj = o1Var.f34977a;
        }
        if ((i7 & 2) != 0) {
            obj2 = o1Var.f34978b;
        }
        if ((i7 & 4) != 0) {
            obj3 = o1Var.f34979c;
        }
        return o1Var.d(obj, obj2, obj3);
    }

    public final A a() {
        return this.f34977a;
    }

    public final B b() {
        return this.f34978b;
    }

    public final C c() {
        return this.f34979c;
    }

    @a7.d
    public final o1<A, B, C> d(A a8, B b8, C c8) {
        return new o1<>(a8, b8, c8);
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return kotlin.jvm.internal.l0.g(this.f34977a, o1Var.f34977a) && kotlin.jvm.internal.l0.g(this.f34978b, o1Var.f34978b) && kotlin.jvm.internal.l0.g(this.f34979c, o1Var.f34979c);
    }

    public final A f() {
        return this.f34977a;
    }

    public final B g() {
        return this.f34978b;
    }

    public final C h() {
        return this.f34979c;
    }

    public int hashCode() {
        A a8 = this.f34977a;
        int iHashCode = (a8 == null ? 0 : a8.hashCode()) * 31;
        B b8 = this.f34978b;
        int iHashCode2 = (iHashCode + (b8 == null ? 0 : b8.hashCode())) * 31;
        C c8 = this.f34979c;
        return iHashCode2 + (c8 != null ? c8.hashCode() : 0);
    }

    @a7.d
    public String toString() {
        return '(' + this.f34977a + ", " + this.f34978b + ", " + this.f34979c + ')';
    }
}
