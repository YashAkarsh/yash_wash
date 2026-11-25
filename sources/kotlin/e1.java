package kotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 {
    @a7.d
    @g1(version = "1.3")
    @a1
    public static final Object a(@a7.d Throwable exception) {
        kotlin.jvm.internal.l0.p(exception, "exception");
        return new d1.b(exception);
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <R, T> R b(Object obj, i5.l<? super T, ? extends R> onSuccess, i5.l<? super Throwable, ? extends R> onFailure) {
        kotlin.jvm.internal.l0.p(onSuccess, "onSuccess");
        kotlin.jvm.internal.l0.p(onFailure, "onFailure");
        Throwable thE = d1.e(obj);
        return thE == null ? onSuccess.z(obj) : onFailure.z(thE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <R, T extends R> R c(Object obj, R r7) {
        return d1.i(obj) ? r7 : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <R, T extends R> R d(Object obj, i5.l<? super Throwable, ? extends R> onFailure) {
        kotlin.jvm.internal.l0.p(onFailure, "onFailure");
        Throwable thE = d1.e(obj);
        return thE == null ? obj : onFailure.z(thE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> T e(Object obj) {
        n(obj);
        return obj;
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <R, T> Object f(Object obj, i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(transform, "transform");
        if (!d1.j(obj)) {
            return d1.b(obj);
        }
        d1.a aVar = d1.f34719b;
        return d1.b(transform.z(obj));
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <R, T> Object g(Object obj, i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(transform, "transform");
        if (!d1.j(obj)) {
            return d1.b(obj);
        }
        try {
            d1.a aVar = d1.f34719b;
            return d1.b(transform.z(obj));
        } catch (Throwable th) {
            d1.a aVar2 = d1.f34719b;
            return d1.b(a(th));
        }
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> Object h(Object obj, i5.l<? super Throwable, l2> action) {
        kotlin.jvm.internal.l0.p(action, "action");
        Throwable thE = d1.e(obj);
        if (thE != null) {
            action.z(thE);
        }
        return obj;
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> Object i(Object obj, i5.l<? super T, l2> action) {
        kotlin.jvm.internal.l0.p(action, "action");
        if (d1.j(obj)) {
            action.z(obj);
        }
        return obj;
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <R, T extends R> Object j(Object obj, i5.l<? super Throwable, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(transform, "transform");
        Throwable thE = d1.e(obj);
        if (thE == null) {
            return obj;
        }
        d1.a aVar = d1.f34719b;
        return d1.b(transform.z(thE));
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <R, T extends R> Object k(Object obj, i5.l<? super Throwable, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(transform, "transform");
        Throwable thE = d1.e(obj);
        if (thE == null) {
            return obj;
        }
        try {
            d1.a aVar = d1.f34719b;
            return d1.b(transform.z(thE));
        } catch (Throwable th) {
            d1.a aVar2 = d1.f34719b;
            return d1.b(a(th));
        }
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <R> Object l(i5.a<? extends R> block) {
        kotlin.jvm.internal.l0.p(block, "block");
        try {
            d1.a aVar = d1.f34719b;
            return d1.b(block.invoke());
        } catch (Throwable th) {
            d1.a aVar2 = d1.f34719b;
            return d1.b(a(th));
        }
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <T, R> Object m(T t7, i5.l<? super T, ? extends R> block) {
        kotlin.jvm.internal.l0.p(block, "block");
        try {
            d1.a aVar = d1.f34719b;
            return d1.b(block.z(t7));
        } catch (Throwable th) {
            d1.a aVar2 = d1.f34719b;
            return d1.b(a(th));
        }
    }

    @g1(version = "1.3")
    @a1
    public static final void n(@a7.d Object obj) {
        if (obj instanceof d1.b) {
            throw ((d1.b) obj).f34721a;
        }
    }
}
