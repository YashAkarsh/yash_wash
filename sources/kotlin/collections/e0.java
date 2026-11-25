package kotlin.collections;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class e0 extends d0 {
    @a7.d
    public static final <T> List<T> W0(@a7.d List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return new j1(list);
    }

    @a7.d
    @h5.h(name = "asReversedMutable")
    public static final <T> List<T> X0(@a7.d List<T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return new i1(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Y0(List<?> list, int i7) {
        if (new kotlin.ranges.k(0, y.H(list)).m(i7)) {
            return y.H(list) - i7;
        }
        throw new IndexOutOfBoundsException("Element index " + i7 + " must be in range [" + new kotlin.ranges.k(0, y.H(list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Z0(List<?> list, int i7) {
        if (new kotlin.ranges.k(0, list.size()).m(i7)) {
            return list.size() - i7;
        }
        throw new IndexOutOfBoundsException("Position index " + i7 + " must be in range [" + new kotlin.ranges.k(0, list.size()) + "].");
    }
}
