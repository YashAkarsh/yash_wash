package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.l2;
import kotlin.q2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class n1 extends m1 {
    @kotlin.g1(version = i2.a.f34096f)
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <E> Set<E> i(int i7, @kotlin.b i5.l<? super Set<E>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        Set setE = m1.e(i7);
        builderAction.z(setE);
        return m1.a(setE);
    }

    @kotlin.g1(version = i2.a.f34096f)
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <E> Set<E> j(@kotlin.b i5.l<? super Set<E>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        Set setD = m1.d();
        builderAction.z(setD);
        return m1.a(setD);
    }

    @a7.d
    public static <T> Set<T> k() {
        return l0.f34558a;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <T> HashSet<T> l() {
        return new HashSet<>();
    }

    @a7.d
    public static final <T> HashSet<T> m(@a7.d T... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return (HashSet) p.Py(elements, new HashSet(b1.j(elements.length)));
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <T> LinkedHashSet<T> n() {
        return new LinkedHashSet<>();
    }

    @a7.d
    public static final <T> LinkedHashSet<T> o(@a7.d T... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return (LinkedHashSet) p.Py(elements, new LinkedHashSet(b1.j(elements.length)));
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <T> Set<T> p() {
        return new LinkedHashSet();
    }

    @a7.d
    public static final <T> Set<T> q(@a7.d T... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return (Set) p.Py(elements, new LinkedHashSet(b1.j(elements.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static <T> Set<T> r(@a7.d Set<? extends T> set) {
        kotlin.jvm.internal.l0.p(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : m1.f(set.iterator().next());
        }
        return k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final <T> Set<T> s(Set<? extends T> set) {
        return set == 0 ? k() : set;
    }

    @kotlin.internal.f
    private static final <T> Set<T> t() {
        return k();
    }

    @a7.d
    public static final <T> Set<T> u(@a7.d T... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return elements.length > 0 ? p.Mz(elements) : k();
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <T> Set<T> v(@a7.e T t7) {
        return t7 != null ? m1.f(t7) : k();
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <T> Set<T> w(@a7.d T... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return (Set) p.vb(elements, new LinkedHashSet());
    }
}
