package kotlin;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "TuplesKt")
public final class p1 {
    @a7.d
    public static final <A, B> u0<A, B> a(A a8, B b8) {
        return new u0<>(a8, b8);
    }

    @a7.d
    public static final <T> List<T> b(@a7.d u0<? extends T, ? extends T> u0Var) {
        kotlin.jvm.internal.l0.p(u0Var, "<this>");
        return kotlin.collections.y.M(u0Var.e(), u0Var.f());
    }

    @a7.d
    public static final <T> List<T> c(@a7.d o1<? extends T, ? extends T, ? extends T> o1Var) {
        kotlin.jvm.internal.l0.p(o1Var, "<this>");
        return kotlin.collections.y.M(o1Var.f(), o1Var.g(), o1Var.h());
    }
}
