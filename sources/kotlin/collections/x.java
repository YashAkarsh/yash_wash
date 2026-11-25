package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import kotlin.l2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class x {
    public static final boolean a() {
        return v.f34631b;
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.a1
    public static <E> List<E> b(@a7.d List<E> builder) {
        kotlin.jvm.internal.l0.p(builder, "builder");
        return ((kotlin.collections.builders.b) builder).k();
    }

    @kotlin.g1(version = "1.3")
    @kotlin.a1
    @kotlin.internal.f
    private static final <E> List<E> c(int i7, i5.l<? super List<E>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        List listK = k(i7);
        builderAction.z(listK);
        return b(listK);
    }

    @kotlin.g1(version = "1.3")
    @kotlin.a1
    @kotlin.internal.f
    private static final <E> List<E> d(i5.l<? super List<E>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        List listJ = j();
        builderAction.z(listJ);
        return b(listJ);
    }

    @kotlin.g1(version = "1.3")
    @kotlin.a1
    @kotlin.internal.f
    private static final int e(int i7) {
        if (i7 < 0) {
            if (!kotlin.internal.m.a(1, 3, 0)) {
                throw new ArithmeticException("Count overflow has happened.");
            }
            y.W();
        }
        return i7;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.a1
    @kotlin.internal.f
    private static final int f(int i7) {
        if (i7 < 0) {
            if (!kotlin.internal.m.a(1, 3, 0)) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            y.X();
        }
        return i7;
    }

    @kotlin.internal.f
    private static final Object[] g(Collection<?> collection) {
        kotlin.jvm.internal.l0.p(collection, "collection");
        return kotlin.jvm.internal.v.a(collection);
    }

    @kotlin.internal.f
    private static final <T> T[] h(Collection<?> collection, T[] array) {
        kotlin.jvm.internal.l0.p(collection, "collection");
        kotlin.jvm.internal.l0.p(array, "array");
        T[] tArr = (T[]) kotlin.jvm.internal.v.b(collection, array);
        kotlin.jvm.internal.l0.n(tArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt__CollectionsJVMKt.copyToArrayImpl>");
        return tArr;
    }

    @a7.d
    public static final <T> Object[] i(@a7.d T[] tArr, boolean z7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (z7 && kotlin.jvm.internal.l0.g(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.l0.o(objArrCopyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.a1
    public static <E> List<E> j() {
        return new kotlin.collections.builders.b();
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.a1
    public static <E> List<E> k(int i7) {
        return new kotlin.collections.builders.b(i7);
    }

    @a7.d
    public static <T> List<T> l(T t7) {
        List<T> listSingletonList = Collections.singletonList(t7);
        kotlin.jvm.internal.l0.o(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }

    @a7.d
    @kotlin.g1(version = "1.2")
    public static final <T> List<T> m(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        List<T> listS5 = g0.S5(iterable);
        Collections.shuffle(listS5);
        return listS5;
    }

    @a7.d
    @kotlin.g1(version = "1.2")
    public static final <T> List<T> n(@a7.d Iterable<? extends T> iterable, @a7.d Random random) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        List<T> listS5 = g0.S5(iterable);
        Collections.shuffle(listS5, random);
        return listS5;
    }

    @kotlin.internal.f
    private static final <T> List<T> o(Enumeration<T> enumeration) {
        kotlin.jvm.internal.l0.p(enumeration, "<this>");
        ArrayList list = Collections.list(enumeration);
        kotlin.jvm.internal.l0.o(list, "list(this)");
        return list;
    }
}
