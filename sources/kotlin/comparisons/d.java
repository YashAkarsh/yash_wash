package kotlin.comparisons;

import java.util.Comparator;
import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
class d extends c {
    @g1(version = "1.1")
    public static final <T> T p0(T t7, T t8, T t9, @a7.d Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return (T) q0(t7, q0(t8, t9, comparator), comparator);
    }

    @g1(version = "1.1")
    public static final <T> T q0(T t7, T t8, @a7.d Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return comparator.compare(t7, t8) >= 0 ? t7 : t8;
    }

    @g1(version = "1.4")
    public static final <T> T r0(T t7, @a7.d T[] other, @a7.d Comparator<? super T> comparator) {
        l0.p(other, "other");
        l0.p(comparator, "comparator");
        for (T t8 : other) {
            if (comparator.compare(t7, t8) < 0) {
                t7 = t8;
            }
        }
        return t7;
    }

    @g1(version = "1.1")
    public static final <T> T s0(T t7, T t8, T t9, @a7.d Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return (T) t0(t7, t0(t8, t9, comparator), comparator);
    }

    @g1(version = "1.1")
    public static final <T> T t0(T t7, T t8, @a7.d Comparator<? super T> comparator) {
        l0.p(comparator, "comparator");
        return comparator.compare(t7, t8) <= 0 ? t7 : t8;
    }

    @g1(version = "1.4")
    public static final <T> T u0(T t7, @a7.d T[] other, @a7.d Comparator<? super T> comparator) {
        l0.p(other, "other");
        l0.p(comparator, "comparator");
        for (T t8 : other) {
            if (comparator.compare(t7, t8) > 0) {
                t7 = t8;
            }
        }
        return t7;
    }
}
