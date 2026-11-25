package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.l2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class m1 {
    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.a1
    public static <E> Set<E> a(@a7.d Set<E> builder) {
        kotlin.jvm.internal.l0.p(builder, "builder");
        return ((kotlin.collections.builders.j) builder).b();
    }

    @kotlin.g1(version = "1.3")
    @kotlin.a1
    @kotlin.internal.f
    private static final <E> Set<E> b(int i7, i5.l<? super Set<E>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        Set setE = e(i7);
        builderAction.z(setE);
        return a(setE);
    }

    @kotlin.g1(version = "1.3")
    @kotlin.a1
    @kotlin.internal.f
    private static final <E> Set<E> c(i5.l<? super Set<E>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        Set setD = d();
        builderAction.z(setD);
        return a(setD);
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.a1
    public static final <E> Set<E> d() {
        return new kotlin.collections.builders.j();
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.a1
    public static <E> Set<E> e(int i7) {
        return new kotlin.collections.builders.j(i7);
    }

    @a7.d
    public static <T> Set<T> f(T t7) {
        Set<T> setSingleton = Collections.singleton(t7);
        kotlin.jvm.internal.l0.o(setSingleton, "singleton(element)");
        return setSingleton;
    }

    @a7.d
    public static final <T> TreeSet<T> g(@a7.d Comparator<? super T> comparator, @a7.d T... elements) {
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(elements, "elements");
        return (TreeSet) p.Py(elements, new TreeSet(comparator));
    }

    @a7.d
    public static final <T> TreeSet<T> h(@a7.d T... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return (TreeSet) p.Py(elements, new TreeSet());
    }
}
