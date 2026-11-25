package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class o1 extends n1 {
    @a7.d
    public static final <T> Set<T> A(@a7.d Set<? extends T> set, @a7.d T[] elements) {
        kotlin.jvm.internal.l0.p(set, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        d0.H0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @kotlin.internal.f
    private static final <T> Set<T> B(Set<? extends T> set, T t7) {
        kotlin.jvm.internal.l0.p(set, "<this>");
        return y(set, t7);
    }

    @a7.d
    public static <T> Set<T> C(@a7.d Set<? extends T> set, @a7.d Iterable<? extends T> elements) {
        int size;
        kotlin.jvm.internal.l0.p(set, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        Integer numA0 = z.a0(elements);
        if (numA0 != null) {
            size = set.size() + numA0.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.j(size));
        linkedHashSet.addAll(set);
        d0.o0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @a7.d
    public static final <T> Set<T> D(@a7.d Set<? extends T> set, T t7) {
        kotlin.jvm.internal.l0.p(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.j(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t7);
        return linkedHashSet;
    }

    @a7.d
    public static final <T> Set<T> E(@a7.d Set<? extends T> set, @a7.d kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.l0.p(set, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.j(set.size() * 2));
        linkedHashSet.addAll(set);
        d0.p0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @a7.d
    public static final <T> Set<T> F(@a7.d Set<? extends T> set, @a7.d T[] elements) {
        kotlin.jvm.internal.l0.p(set, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.j(set.size() + elements.length));
        linkedHashSet.addAll(set);
        d0.q0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @kotlin.internal.f
    private static final <T> Set<T> G(Set<? extends T> set, T t7) {
        kotlin.jvm.internal.l0.p(set, "<this>");
        return D(set, t7);
    }

    @a7.d
    public static final <T> Set<T> x(@a7.d Set<? extends T> set, @a7.d Iterable<? extends T> elements) {
        kotlin.jvm.internal.l0.p(set, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        Collection<?> collectionD = s.d(elements, set);
        if (collectionD.isEmpty()) {
            return g0.V5(set);
        }
        if (!(collectionD instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionD);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (T t7 : set) {
            if (!collectionD.contains(t7)) {
                linkedHashSet2.add(t7);
            }
        }
        return linkedHashSet2;
    }

    @a7.d
    public static final <T> Set<T> y(@a7.d Set<? extends T> set, T t7) {
        kotlin.jvm.internal.l0.p(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(b1.j(set.size()));
        boolean z7 = false;
        for (T t8 : set) {
            boolean z8 = true;
            if (!z7 && kotlin.jvm.internal.l0.g(t8, t7)) {
                z7 = true;
                z8 = false;
            }
            if (z8) {
                linkedHashSet.add(t8);
            }
        }
        return linkedHashSet;
    }

    @a7.d
    public static final <T> Set<T> z(@a7.d Set<? extends T> set, @a7.d kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.l0.p(set, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        d0.G0(linkedHashSet, elements);
        return linkedHashSet;
    }
}
