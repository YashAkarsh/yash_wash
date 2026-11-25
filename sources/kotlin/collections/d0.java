package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.q2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class d0 extends c0 {
    @kotlin.internal.f
    private static final <T> void A0(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        q0(collection, elements);
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Use removeAt(index) instead.", replaceWith = @kotlin.b1(expression = "removeAt(index)", imports = {}))
    @kotlin.internal.f
    private static final <T> T B0(List<T> list, int i7) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return list.remove(i7);
    }

    @kotlin.internal.f
    private static final <T> boolean C0(Collection<? extends T> collection, T t7) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        return kotlin.jvm.internal.t1.a(collection).remove(t7);
    }

    public static final <T> boolean D0(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        return r0(iterable, predicate, true);
    }

    public static final <T> boolean E0(@a7.d Collection<? super T> collection, @a7.d Iterable<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        return kotlin.jvm.internal.t1.a(collection).removeAll(s.d(elements, collection));
    }

    @kotlin.internal.f
    private static final <T> boolean F0(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        return kotlin.jvm.internal.t1.a(collection).removeAll(elements);
    }

    public static final <T> boolean G0(@a7.d Collection<? super T> collection, @a7.d kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        Collection<?> collectionB = s.b(elements);
        return (collectionB.isEmpty() ^ true) && collection.removeAll(collectionB);
    }

    public static final <T> boolean H0(@a7.d Collection<? super T> collection, @a7.d T[] elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        return ((elements.length == 0) ^ true) && collection.removeAll(s.c(elements));
    }

    public static final <T> boolean I0(@a7.d List<T> list, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        return s0(list, predicate, true);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <T> T J0(@a7.d List<T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final <T> T K0(@a7.d List<T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static <T> T L0(@a7.d List<T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(y.H(list));
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final <T> T M0(@a7.d List<T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(y.H(list));
    }

    public static <T> boolean N0(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        return r0(iterable, predicate, false);
    }

    public static final <T> boolean O0(@a7.d Collection<? super T> collection, @a7.d Iterable<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        return kotlin.jvm.internal.t1.a(collection).retainAll(s.d(elements, collection));
    }

    @kotlin.internal.f
    private static final <T> boolean P0(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        return kotlin.jvm.internal.t1.a(collection).retainAll(elements);
    }

    public static final <T> boolean Q0(@a7.d Collection<? super T> collection, @a7.d kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        Collection<?> collectionB = s.b(elements);
        return collectionB.isEmpty() ^ true ? collection.retainAll(collectionB) : T0(collection);
    }

    public static final <T> boolean R0(@a7.d Collection<? super T> collection, @a7.d T[] elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        return (elements.length == 0) ^ true ? collection.retainAll(s.c(elements)) : T0(collection);
    }

    public static final <T> boolean S0(@a7.d List<T> list, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        return s0(list, predicate, false);
    }

    private static final boolean T0(Collection<?> collection) {
        boolean z7 = !collection.isEmpty();
        collection.clear();
        return z7;
    }

    public static <T> boolean o0(@a7.d Collection<? super T> collection, @a7.d Iterable<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z7 = true;
            }
        }
        return z7;
    }

    public static <T> boolean p0(@a7.d Collection<? super T> collection, @a7.d kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        Iterator<? extends T> it = elements.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z7 = true;
            }
        }
        return z7;
    }

    public static <T> boolean q0(@a7.d Collection<? super T> collection, @a7.d T[] elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        return collection.addAll(o.t(elements));
    }

    private static final <T> boolean r0(Iterable<? extends T> iterable, i5.l<? super T, Boolean> lVar, boolean z7) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z8 = false;
        while (it.hasNext()) {
            if (lVar.z(it.next()).booleanValue() == z7) {
                it.remove();
                z8 = true;
            }
        }
        return z8;
    }

    private static final <T> boolean s0(List<T> list, i5.l<? super T, Boolean> lVar, boolean z7) {
        if (!(list instanceof RandomAccess)) {
            kotlin.jvm.internal.l0.n(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return r0(kotlin.jvm.internal.t1.c(list), lVar, z7);
        }
        u0 it = new kotlin.ranges.k(0, y.H(list)).iterator();
        int i7 = 0;
        while (it.hasNext()) {
            int iB = it.b();
            T t7 = list.get(iB);
            if (lVar.z(t7).booleanValue() != z7) {
                if (i7 != iB) {
                    list.set(i7, t7);
                }
                i7++;
            }
        }
        if (i7 >= list.size()) {
            return false;
        }
        int iH = y.H(list);
        if (i7 > iH) {
            return true;
        }
        while (true) {
            list.remove(iH);
            if (iH == i7) {
                return true;
            }
            iH--;
        }
    }

    @kotlin.internal.f
    private static final <T> void t0(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        E0(collection, elements);
    }

    @kotlin.internal.f
    private static final <T> void u0(Collection<? super T> collection, T t7) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        collection.remove(t7);
    }

    @kotlin.internal.f
    private static final <T> void v0(Collection<? super T> collection, kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        G0(collection, elements);
    }

    @kotlin.internal.f
    private static final <T> void w0(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        H0(collection, elements);
    }

    @kotlin.internal.f
    private static final <T> void x0(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        o0(collection, elements);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final <T> void y0(Collection<? super T> collection, T t7) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        collection.add(t7);
    }

    @kotlin.internal.f
    private static final <T> void z0(Collection<? super T> collection, kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        p0(collection, elements);
    }
}
