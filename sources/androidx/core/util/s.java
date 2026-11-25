package androidx.core.util;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class s<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f6387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f6388b;

    public s(F f8, S s7) {
        this.f6387a = f8;
        this.f6388b = s7;
    }

    @m0
    public static <A, B> s<A, B> a(A a8, B b8) {
        return new s<>(a8, b8);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return r.a(sVar.f6387a, this.f6387a) && r.a(sVar.f6388b, this.f6388b);
    }

    public int hashCode() {
        F f8 = this.f6387a;
        int iHashCode = f8 == null ? 0 : f8.hashCode();
        S s7 = this.f6388b;
        return iHashCode ^ (s7 != null ? s7.hashCode() : 0);
    }

    @m0
    public String toString() {
        return "Pair{" + this.f6387a + " " + this.f6388b + com.alipay.sdk.util.j.f13808d;
    }
}
