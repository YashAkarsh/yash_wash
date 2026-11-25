package kotlin.ranges;

import kotlin.g1;
import kotlin.jvm.internal.l0;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
class p {
    public static final void a(boolean z7, @a7.d Number step) {
        l0.p(step, "step");
        if (z7) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Ljava/lang/Iterable<+TT;>;:Lkotlin/ranges/g<TT;>;>(TR;TT;)Z */
    @g1(version = "1.3")
    @kotlin.internal.f
    private static final boolean b(Iterable iterable, Object obj) {
        l0.p(iterable, "<this>");
        return obj != null && ((g) iterable).a((Comparable) obj);
    }

    @a7.d
    @g1(version = "1.1")
    public static final f<Double> c(double d8, double d9) {
        return new d(d8, d9);
    }

    @a7.d
    @g1(version = "1.1")
    public static final f<Float> d(float f8, float f9) {
        return new e(f8, f9);
    }

    @a7.d
    public static final <T extends Comparable<? super T>> g<T> e(@a7.d T t7, @a7.d T that) {
        l0.p(t7, "<this>");
        l0.p(that, "that");
        return new h(t7, that);
    }
}
