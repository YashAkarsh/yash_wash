package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class c0 extends b0 {
    @kotlin.g1(version = "1.2")
    @kotlin.internal.f
    private static final <T> void h0(List<T> list, T t7) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        Collections.fill(list, t7);
    }

    @kotlin.g1(version = "1.2")
    @kotlin.internal.f
    private static final <T> void i0(List<T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        Collections.shuffle(list);
    }

    @kotlin.g1(version = "1.2")
    @kotlin.internal.f
    private static final <T> void j0(List<T> list, Random random) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        Collections.shuffle(list, random);
    }

    public static <T extends Comparable<? super T>> void k0(@a7.d List<T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @kotlin.b1(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    @kotlin.internal.f
    private static final <T> void l0(List<T> list, i5.p<? super T, ? super T, Integer> comparison) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(comparison, "comparison");
        throw new kotlin.k0(null, 1, null);
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @kotlin.b1(expression = "this.sortWith(comparator)", imports = {}))
    @kotlin.internal.f
    private static final <T> void m0(List<T> list, Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        throw new kotlin.k0(null, 1, null);
    }

    public static <T> void n0(@a7.d List<T> list, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
