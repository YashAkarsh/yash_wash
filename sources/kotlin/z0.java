package kotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 {
    @g1(version = "1.4")
    @kotlin.internal.f
    private static final <V> V a(kotlin.reflect.p<? extends V> pVar, Object obj, kotlin.reflect.o<?> property) {
        kotlin.jvm.internal.l0.p(pVar, "<this>");
        kotlin.jvm.internal.l0.p(property, "property");
        return pVar.get();
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final <T, V> V b(kotlin.reflect.q<T, ? extends V> qVar, T t7, kotlin.reflect.o<?> property) {
        kotlin.jvm.internal.l0.p(qVar, "<this>");
        kotlin.jvm.internal.l0.p(property, "property");
        return qVar.get(t7);
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final <V> void c(kotlin.reflect.k<V> kVar, Object obj, kotlin.reflect.o<?> property, V v7) {
        kotlin.jvm.internal.l0.p(kVar, "<this>");
        kotlin.jvm.internal.l0.p(property, "property");
        kVar.set(v7);
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final <T, V> void d(kotlin.reflect.l<T, V> lVar, T t7, kotlin.reflect.o<?> property, V v7) {
        kotlin.jvm.internal.l0.p(lVar, "<this>");
        kotlin.jvm.internal.l0.p(property, "property");
        lVar.U(t7, v7);
    }
}
