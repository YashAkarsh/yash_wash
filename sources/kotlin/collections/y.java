package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.l2;
import kotlin.q2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class y extends x {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> extends kotlin.jvm.internal.n0 implements i5.l<T, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<T, K> f34632a;

        /* JADX INFO: Incorrect field signature: TK; */
        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparable f34633b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Incorrect types in method signature: (Li5/l<-TT;+TK;>;TK;)V */
        public a(i5.l lVar, Comparable comparable) {
            super(1);
            this.f34632a = lVar;
            this.f34633b = comparable;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer z(T t7) {
            return Integer.valueOf(kotlin.comparisons.b.g((Comparable) this.f34632a.z(t7), this.f34633b));
        }
    }

    public static final <T, K extends Comparable<? super K>> int A(@a7.d List<? extends T> list, @a7.e K k7, int i7, int i8, @a7.d i5.l<? super T, ? extends K> selector) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return u(list, i7, i8, new a(selector, k7));
    }

    public static /* synthetic */ int B(List list, Comparable comparable, int i7, int i8, i5.l lVar, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = list.size();
        }
        return u(list, i7, i8, new a(lVar, comparable));
    }

    @kotlin.g1(version = i2.a.f34096f)
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <E> List<E> C(int i7, @kotlin.b i5.l<? super List<E>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        List listK = x.k(i7);
        builderAction.z(listK);
        return x.b(listK);
    }

    @kotlin.g1(version = i2.a.f34096f)
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <E> List<E> D(@kotlin.b i5.l<? super List<E>, l2> builderAction) {
        kotlin.jvm.internal.l0.p(builderAction, "builderAction");
        List listJ = x.j();
        builderAction.z(listJ);
        return x.b(listJ);
    }

    @kotlin.internal.f
    private static final <T> boolean E(Collection<? extends T> collection, Collection<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        return collection.containsAll(elements);
    }

    @a7.d
    public static <T> List<T> F() {
        return j0.f34539a;
    }

    @a7.d
    public static kotlin.ranges.k G(@a7.d Collection<?> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        return new kotlin.ranges.k(0, collection.size() - 1);
    }

    public static <T> int H(@a7.d List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return list.size() - 1;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Li5/a<+TR;>;)TR; */
    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final Object I(Collection collection, i5.a defaultValue) {
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return collection.isEmpty() ? defaultValue.invoke() : collection;
    }

    @kotlin.internal.f
    private static final <T> boolean J(Collection<? extends T> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        return !collection.isEmpty();
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> boolean K(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @kotlin.internal.f
    private static final <T> List<T> L() {
        return F();
    }

    @a7.d
    public static <T> List<T> M(@a7.d T... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return elements.length > 0 ? o.t(elements) : F();
    }

    @a7.d
    public static final <T> List<T> N(@a7.e T t7) {
        return t7 != null ? x.l(t7) : F();
    }

    @a7.d
    public static <T> List<T> O(@a7.d T... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return p.ub(elements);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <T> List<T> P() {
        return new ArrayList();
    }

    @a7.d
    public static <T> List<T> Q(@a7.d T... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new j(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static <T> List<T> R(@a7.d List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : x.l(list.get(0));
        }
        return F();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final <T> Collection<T> S(Collection<? extends T> collection) {
        return collection == 0 ? F() : collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final <T> List<T> T(List<? extends T> list) {
        return list == 0 ? F() : list;
    }

    private static final void U(int i7, int i8, int i9) {
        if (i8 > i9) {
            throw new IllegalArgumentException("fromIndex (" + i8 + ") is greater than toIndex (" + i9 + ").");
        }
        if (i8 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i8 + ") is less than zero.");
        }
        if (i9 <= i7) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i9 + ") is greater than size (" + i7 + ").");
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static final <T> List<T> V(@a7.d Iterable<? extends T> iterable, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        List<T> listS5 = g0.S5(iterable);
        g0.Z4(listS5, random);
        return listS5;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.a1
    public static void W() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @kotlin.g1(version = "1.3")
    @kotlin.a1
    public static void X() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <T> List<T> p(int i7, i5.l<? super Integer, ? extends T> init) {
        kotlin.jvm.internal.l0.p(init, "init");
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = 0; i8 < i7; i8++) {
            arrayList.add(init.z(Integer.valueOf(i8)));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <T> List<T> q(int i7, i5.l<? super Integer, ? extends T> init) {
        kotlin.jvm.internal.l0.p(init, "init");
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = 0; i8 < i7; i8++) {
            arrayList.add(init.z(Integer.valueOf(i8)));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.f
    private static final <T> ArrayList<T> r() {
        return new ArrayList<>();
    }

    @a7.d
    public static final <T> ArrayList<T> s(@a7.d T... elements) {
        kotlin.jvm.internal.l0.p(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new j(elements, true));
    }

    @a7.d
    public static final <T> Collection<T> t(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return new j(tArr, false);
    }

    public static final <T> int u(@a7.d List<? extends T> list, int i7, int i8, @a7.d i5.l<? super T, Integer> comparison) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(comparison, "comparison");
        U(list.size(), i7, i8);
        int i9 = i8 - 1;
        while (i7 <= i9) {
            int i10 = (i7 + i9) >>> 1;
            int iIntValue = comparison.z(list.get(i10)).intValue();
            if (iIntValue < 0) {
                i7 = i10 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i10;
                }
                i9 = i10 - 1;
            }
        }
        return -(i7 + 1);
    }

    public static final <T extends Comparable<? super T>> int v(@a7.d List<? extends T> list, @a7.e T t7, int i7, int i8) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        U(list.size(), i7, i8);
        int i9 = i8 - 1;
        while (i7 <= i9) {
            int i10 = (i7 + i9) >>> 1;
            int iG = kotlin.comparisons.b.g(list.get(i10), t7);
            if (iG < 0) {
                i7 = i10 + 1;
            } else {
                if (iG <= 0) {
                    return i10;
                }
                i9 = i10 - 1;
            }
        }
        return -(i7 + 1);
    }

    public static final <T> int w(@a7.d List<? extends T> list, T t7, @a7.d Comparator<? super T> comparator, int i7, int i8) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        U(list.size(), i7, i8);
        int i9 = i8 - 1;
        while (i7 <= i9) {
            int i10 = (i7 + i9) >>> 1;
            int iCompare = comparator.compare(list.get(i10), t7);
            if (iCompare < 0) {
                i7 = i10 + 1;
            } else {
                if (iCompare <= 0) {
                    return i10;
                }
                i9 = i10 - 1;
            }
        }
        return -(i7 + 1);
    }

    public static /* synthetic */ int x(List list, int i7, int i8, i5.l lVar, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = list.size();
        }
        return u(list, i7, i8, lVar);
    }

    public static /* synthetic */ int y(List list, Comparable comparable, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = list.size();
        }
        return v(list, comparable, i7, i8);
    }

    public static /* synthetic */ int z(List list, Object obj, Comparator comparator, int i7, int i8, int i9, Object obj2) {
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = list.size();
        }
        return w(list, obj, comparator, i7, i8);
    }
}
