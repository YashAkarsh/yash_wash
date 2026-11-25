package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    @a7.d
    public static final <T> Collection<T> a(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return v.f34631b ? g0.O5(iterable) : g0.Q5(iterable);
        }
        Collection<T> collection = (Collection) iterable;
        return e(collection) ? g0.O5(iterable) : collection;
    }

    @a7.d
    public static final <T> Collection<T> b(@a7.d kotlin.sequences.m<? extends T> mVar) {
        kotlin.jvm.internal.l0.p(mVar, "<this>");
        return v.f34631b ? kotlin.sequences.u.b3(mVar) : kotlin.sequences.u.c3(mVar);
    }

    @a7.d
    public static final <T> Collection<T> c(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return v.f34631b ? p.az(tArr) : o.t(tArr);
    }

    @a7.d
    public static final <T> Collection<T> d(@a7.d Iterable<? extends T> iterable, @a7.d Iterable<? extends T> source) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(source, "source");
        if (iterable instanceof Set) {
            return (Collection) iterable;
        }
        if (!(iterable instanceof Collection)) {
            return v.f34631b ? g0.O5(iterable) : g0.Q5(iterable);
        }
        if ((source instanceof Collection) && ((Collection) source).size() < 2) {
            return (Collection) iterable;
        }
        Collection<T> collection = (Collection) iterable;
        return e(collection) ? g0.O5(iterable) : collection;
    }

    private static final <T> boolean e(Collection<? extends T> collection) {
        return v.f34631b && collection.size() > 2 && (collection instanceof ArrayList);
    }
}
