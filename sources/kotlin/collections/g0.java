package kotlin.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.a2;
import kotlin.l2;
import kotlin.q2;
import kotlin.w1;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class g0 extends f0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements kotlin.sequences.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f34527a;

        public a(Iterable iterable) {
            this.f34527a = iterable;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            return this.f34527a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class b<T> extends kotlin.jvm.internal.n0 implements i5.l<Integer, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f34528a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i7) {
            super(1);
            this.f34528a = i7;
        }

        public final T b(int i7) {
            throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.f34528a + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ Object z(Integer num) {
            return b(num.intValue());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    public static final class c<K, T> implements n0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable<T> f34529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<T, K> f34530b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Iterable<? extends T> iterable, i5.l<? super T, ? extends K> lVar) {
            this.f34529a = iterable;
            this.f34530b = lVar;
        }

        @Override // kotlin.collections.n0
        public K a(T t7) {
            return this.f34530b.z(t7);
        }

        @Override // kotlin.collections.n0
        @a7.d
        public Iterator<T> b() {
            return this.f34529a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class d<T> extends kotlin.jvm.internal.n0 implements i5.a<Iterator<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable<T> f34531a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Iterable<? extends T> iterable) {
            super(0);
            this.f34531a = iterable;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<T> invoke() {
            return this.f34531a.iterator();
        }
    }

    @a7.d
    public static final <T, K, V, M extends Map<? super K, ? super V>> M A1(@a7.d Iterable<? extends T> iterable, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (T t7 : iterable) {
            destination.put(keySelector.z(t7), valueTransform.z(t7));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @a7.e
    public static final <T> T A2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : iterable) {
            if (predicate.z(t7).booleanValue()) {
                return t7;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <T, R extends Comparable<? super R>> T A3(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rZ = selector.z(next);
        do {
            T next2 = it.next();
            R rZ2 = selector.z(next2);
            next = next;
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @a7.d
    public static final <T> List<T> A4(@a7.d Collection<? extends T> collection, @a7.d kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        d0.p0(arrayList, elements);
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T> long A5(Iterable<? extends T> iterable, i5.l<? super T, Long> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += selector.z(it.next()).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final <T, K, V, M extends Map<? super K, ? super V>> M B1(@a7.d Iterable<? extends T> iterable, @a7.d M destination, @a7.d i5.l<? super T, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(it.next());
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @a7.e
    public static <T> T B2(@a7.d List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T B3(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rZ = selector.z(next);
        do {
            T next2 = it.next();
            R rZ2 = selector.z(next2);
            next = next;
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @a7.d
    public static final <T> List<T> B4(@a7.d Collection<? extends T> collection, @a7.d T[] elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + elements.length);
        arrayList.addAll(collection);
        d0.q0(arrayList, elements);
        return arrayList;
    }

    @h5.h(name = "sumOfShort")
    public static final int B5(@a7.d Iterable<Short> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        int iShortValue = 0;
        while (it.hasNext()) {
            iShortValue += it.next().shortValue();
        }
        return iShortValue;
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static final <K, V> Map<K, V> C1(@a7.d Iterable<? extends K> iterable, @a7.d i5.l<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(z.Z(iterable, 10)), 16));
        for (K k7 : iterable) {
            linkedHashMap.put(k7, valueSelector.z(k7));
        }
        return linkedHashMap;
    }

    @a7.d
    public static final <T, R> List<R> C2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            d0.o0(arrayList, transform.z(it.next()));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> double C3(Iterable<? extends T> iterable, i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.internal.f
    private static final <T> List<T> C4(Iterable<? extends T> iterable, T t7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return v4(iterable, t7);
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final <T> int C5(Iterable<? extends T> iterable, i5.l<? super T, w1> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iH = w1.h(0);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            iH = w1.h(iH + selector.z(it.next()).g0());
        }
        return iH;
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static final <K, V, M extends Map<? super K, ? super V>> M D1(@a7.d Iterable<? extends K> iterable, @a7.d M destination, @a7.d i5.l<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        for (K k7 : iterable) {
            destination.put(k7, valueSelector.z(k7));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T, R> List<R> D2(Iterable<? extends T> iterable, i5.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            d0.o0(arrayList, transform.a0(Integer.valueOf(i7), t7));
            i7 = i8;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> float D3(Iterable<? extends T> iterable, i5.l<? super T, Float> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(it.next()).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.internal.f
    private static final <T> List<T> D4(Collection<? extends T> collection, T t7) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        return z4(collection, t7);
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final <T> long D5(Iterable<? extends T> iterable, i5.l<? super T, a2> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jH = a2.h(0L);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            jH = a2.h(jH + selector.z(it.next()).g0());
        }
        return jH;
    }

    @h5.h(name = "averageOfByte")
    public static final double E1(@a7.d Iterable<Byte> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        double dByteValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dByteValue += (double) it.next().byteValue();
            i7++;
            if (i7 < 0) {
                y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i7);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T, R, C extends Collection<? super R>> C E2(Iterable<? extends T> iterable, C destination, i5.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            d0.o0(destination, transform.a0(Integer.valueOf(i7), t7));
            i7 = i8;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R extends Comparable<? super R>> R E3(Iterable<? extends T> iterable, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> T E4(Collection<? extends T> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        return (T) F4(collection, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final <T> List<T> E5(@a7.d Iterable<? extends T> iterable, int i7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        int i8 = 0;
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return y.F();
        }
        if (iterable instanceof Collection) {
            if (i7 >= ((Collection) iterable).size()) {
                return Q5(iterable);
            }
            if (i7 == 1) {
                return x.l(u2(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i7);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return y.R(arrayList);
    }

    @h5.h(name = "averageOfDouble")
    public static final double F1(@a7.d Iterable<Double> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
            i7++;
            if (i7 < 0) {
                y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i7);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedSequence")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T, R> List<R> F2(Iterable<? extends T> iterable, i5.p<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            d0.p0(arrayList, transform.a0(Integer.valueOf(i7), t7));
            i7 = i8;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R extends Comparable<? super R>> R F3(Iterable<? extends T> iterable, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.3")
    public static final <T> T F4(@a7.d Collection<? extends T> collection, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return (T) b2(collection, random.m(collection.size()));
    }

    @a7.d
    public static final <T> List<T> F5(@a7.d List<? extends T> list, int i7) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return y.F();
        }
        int size = list.size();
        if (i7 >= size) {
            return Q5(list);
        }
        if (i7 == 1) {
            return x.l(k3(list));
        }
        ArrayList arrayList = new ArrayList(i7);
        if (list instanceof RandomAccess) {
            for (int i8 = size - i7; i8 < size; i8++) {
                arrayList.add(list.get(i8));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i7);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    @h5.h(name = "averageOfFloat")
    public static final double G1(@a7.d Iterable<Float> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        double dFloatValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dFloatValue += (double) it.next().floatValue();
            i7++;
            if (i7 < 0) {
                y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i7);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedSequenceTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T, R, C extends Collection<? super R>> C G2(Iterable<? extends T> iterable, C destination, i5.p<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            d0.p0(destination, transform.a0(Integer.valueOf(i7), t7));
            i7 = i8;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> Double G3(Iterable<? extends T> iterable, i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = selector.z(it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <T> T G4(Collection<? extends T> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        return (T) H4(collection, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final <T> List<T> G5(@a7.d List<? extends T> list, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        if (list.isEmpty()) {
            return y.F();
        }
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (!predicate.z(listIterator.previous()).booleanValue()) {
                listIterator.next();
                int size = list.size() - listIterator.nextIndex();
                if (size == 0) {
                    return y.F();
                }
                ArrayList arrayList = new ArrayList(size);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
                return arrayList;
            }
        }
        return Q5(list);
    }

    @h5.h(name = "averageOfInt")
    public static final double H1(@a7.d Iterable<Integer> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        double dIntValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dIntValue += (double) it.next().intValue();
            i7++;
            if (i7 < 0) {
                y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i7);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapSequence")
    @kotlin.t0
    @a7.d
    public static final <T, R> List<R> H2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            d0.p0(arrayList, transform.z(it.next()));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> Float H3(Iterable<? extends T> iterable, i5.l<? super T, Float> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = selector.z(it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final <T> T H4(@a7.d Collection<? extends T> collection, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) b2(collection, random.m(collection.size()));
    }

    @a7.d
    public static final <T> List<T> H5(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t7 : iterable) {
            if (!predicate.z(t7).booleanValue()) {
                break;
            }
            arrayList.add(t7);
        }
        return arrayList;
    }

    @h5.h(name = "averageOfLong")
    public static final double I1(@a7.d Iterable<Long> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        double dLongValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dLongValue += it.next().longValue();
            i7++;
            if (i7 < 0) {
                y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i7);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapSequenceTo")
    @kotlin.t0
    @a7.d
    public static final <T, R, C extends Collection<? super R>> C I2(@a7.d Iterable<? extends T> iterable, @a7.d C destination, @a7.d i5.l<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            d0.p0(destination, transform.z(it.next()));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R> R I3(Iterable<? extends T> iterable, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final <S, T extends S> S I4(@a7.d Iterable<? extends T> iterable, @a7.d i5.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.a0(next, it.next());
        }
        return next;
    }

    @a7.d
    public static final boolean[] I5(@a7.d Collection<Boolean> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            zArr[i7] = it.next().booleanValue();
            i7++;
        }
        return zArr;
    }

    @h5.h(name = "averageOfShort")
    public static final double J1(@a7.d Iterable<Short> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        double dShortValue = 0.0d;
        int i7 = 0;
        while (it.hasNext()) {
            dShortValue += (double) it.next().shortValue();
            i7++;
            if (i7 < 0) {
                y.W();
            }
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i7);
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C J2(@a7.d Iterable<? extends T> iterable, @a7.d C destination, @a7.d i5.l<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            d0.o0(destination, transform.z(it.next()));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R> R J3(Iterable<? extends T> iterable, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final <S, T extends S> S J4(@a7.d Iterable<? extends T> iterable, @a7.d i5.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        S next = it.next();
        int i7 = 1;
        while (it.hasNext()) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            next = operation.v(Integer.valueOf(i7), next, it.next());
            i7 = i8;
        }
        return next;
    }

    @a7.d
    public static final byte[] J5(@a7.d Collection<Byte> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator<Byte> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            bArr[i7] = it.next().byteValue();
            i7++;
        }
        return bArr;
    }

    @a7.d
    @kotlin.g1(version = "1.2")
    public static final <T> List<List<T>> K1(@a7.d Iterable<? extends T> iterable, int i7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return Y5(iterable, i7, i7, true);
    }

    public static final <T, R> R K2(@a7.d Iterable<? extends T> iterable, R r7, @a7.d i5.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r7 = operation.a0(r7, it.next());
        }
        return r7;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <T extends Comparable<? super T>> T K3(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <S, T extends S> S K4(@a7.d Iterable<? extends T> iterable, @a7.d i5.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        int i7 = 1;
        while (it.hasNext()) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            next = operation.v(Integer.valueOf(i7), next, it.next());
            i7 = i8;
        }
        return next;
    }

    @a7.d
    public static final char[] K5(@a7.d Collection<Character> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        char[] cArr = new char[collection.size()];
        Iterator<Character> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            cArr[i7] = it.next().charValue();
            i7++;
        }
        return cArr;
    }

    @a7.d
    @kotlin.g1(version = "1.2")
    public static final <T, R> List<R> L1(@a7.d Iterable<? extends T> iterable, int i7, @a7.d i5.l<? super List<? extends T>, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        return Z5(iterable, i7, i7, true, transform);
    }

    public static final <T, R> R L2(@a7.d Iterable<? extends T> iterable, R r7, @a7.d i5.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            r7 = operation.v(Integer.valueOf(i7), r7, t7);
            i7 = i8;
        }
        return r7;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Double L3(@a7.d Iterable<Double> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final <S, T extends S> S L4(@a7.d Iterable<? extends T> iterable, @a7.d i5.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.a0(next, it.next());
        }
        return next;
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C L5(@a7.d Iterable<? extends T> iterable, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    @kotlin.internal.f
    private static final <T> T M1(List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return list.get(0);
    }

    public static final <T, R> R M2(@a7.d List<? extends T> list, R r7, @a7.d i5.p<? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r7 = operation.a0(listIterator.previous(), r7);
            }
        }
        return r7;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Float M3(@a7.d Iterable<Float> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static final <S, T extends S> S M4(@a7.d List<? extends T> list, @a7.d i5.p<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = operation.a0(listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @a7.d
    public static final double[] M5(@a7.d Collection<Double> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        double[] dArr = new double[collection.size()];
        Iterator<Double> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            dArr[i7] = it.next().doubleValue();
            i7++;
        }
        return dArr;
    }

    @kotlin.internal.f
    private static final <T> T N1(List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return list.get(1);
    }

    public static final <T, R> R N2(@a7.d List<? extends T> list, R r7, @a7.d i5.q<? super Integer, ? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r7 = operation.v(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), r7);
            }
        }
        return r7;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final double N3(@a7.d Iterable<Double> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    public static final <S, T extends S> S N4(@a7.d List<? extends T> list, @a7.d i5.q<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            throw new UnsupportedOperationException("Empty list can't be reduced.");
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = operation.v(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @a7.d
    public static final float[] N5(@a7.d Collection<Float> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            fArr[i7] = it.next().floatValue();
            i7++;
        }
        return fArr;
    }

    @kotlin.internal.f
    private static final <T> T O1(List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return list.get(2);
    }

    @kotlin.internal.e
    public static final <T> void O2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, l2> action) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            action.z(it.next());
        }
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final float O3(@a7.d Iterable<Float> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, it.next().floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <S, T extends S> S O4(@a7.d List<? extends T> list, @a7.d i5.q<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = operation.v(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @a7.d
    public static final <T> HashSet<T> O5(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return (HashSet) L5(iterable, new HashSet(b1.j(z.Z(iterable, 12))));
    }

    @kotlin.internal.f
    private static final <T> T P1(List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return list.get(3);
    }

    public static final <T> void P2(@a7.d Iterable<? extends T> iterable, @a7.d i5.p<? super Integer, ? super T, l2> action) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            action.a0(Integer.valueOf(i7), t7);
            i7 = i8;
        }
    }

    @a7.d
    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final <T extends Comparable<? super T>> T P3(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final <S, T extends S> S P4(@a7.d List<? extends T> list, @a7.d i5.p<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S sPrevious = listIterator.previous();
        while (listIterator.hasPrevious()) {
            sPrevious = operation.a0(listIterator.previous(), sPrevious);
        }
        return sPrevious;
    }

    @a7.d
    public static final int[] P5(@a7.d Collection<Integer> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            iArr[i7] = it.next().intValue();
            i7++;
        }
        return iArr;
    }

    @kotlin.internal.f
    private static final <T> T Q1(List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return list.get(4);
    }

    @kotlin.internal.f
    private static final <T> T Q2(List<? extends T> list, int i7, i5.l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > y.H(list)) ? defaultValue.z(Integer.valueOf(i7)) : list.get(i7);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <T> T Q3(@a7.d Iterable<? extends T> iterable, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T> Iterable<T> Q4(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + iterable + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
        }
        return iterable;
    }

    @a7.d
    public static <T> List<T> Q5(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return y.R(S5(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return y.F();
        }
        if (size != 1) {
            return T5(collection);
        }
        return x.l(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> boolean R1(@a7.d Iterable<? extends T> iterable, T t7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t7);
        }
        return X2(iterable, t7) >= 0;
    }

    @a7.e
    public static final <T> T R2(@a7.d List<? extends T> list, int i7) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (i7 < 0 || i7 > y.H(list)) {
            return null;
        }
        return list.get(i7);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final <T> T R3(@a7.d Iterable<? extends T> iterable, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T> List<T> R4(@a7.d List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + list + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
        }
        return list;
    }

    @a7.d
    public static final long[] R5(@a7.d Collection<Long> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            jArr[i7] = it.next().longValue();
            i7++;
        }
        return jArr;
    }

    public static final <T> int S1(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        Iterator<? extends T> it = iterable.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            it.next();
            i7++;
            if (i7 < 0) {
                y.W();
            }
        }
        return i7;
    }

    @a7.d
    public static final <T, K> Map<K, List<T>> S2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t7 : iterable) {
            K kZ = keySelector.z(t7);
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(t7);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <T, R extends Comparable<? super R>> T S3(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rZ = selector.z(next);
        do {
            T next2 = it.next();
            R rZ2 = selector.z(next2);
            next = next;
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @a7.d
    public static final <T> List<T> S4(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return Q5(iterable);
        }
        List<T> listS5 = S5(iterable);
        f0.m1(listS5);
        return listS5;
    }

    @a7.d
    public static final <T> List<T> S5(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return iterable instanceof Collection ? T5((Collection) iterable) : (List) L5(iterable, new ArrayList());
    }

    public static final <T> int T1(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.z(it.next()).booleanValue() && (i7 = i7 + 1) < 0) {
                y.W();
            }
        }
        return i7;
    }

    @a7.d
    public static final <T, K, V> Map<K, List<V>> T2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t7 : iterable) {
            K kZ = keySelector.z(t7);
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(t7));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @kotlin.g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T T3(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R rZ = selector.z(next);
        do {
            T next2 = it.next();
            R rZ2 = selector.z(next2);
            next = next;
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <T, R> List<R> T4(@a7.d Iterable<? extends T> iterable, R r7, @a7.d i5.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iZ = z.Z(iterable, 9);
        if (iZ == 0) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(iZ + 1);
        arrayList.add(r7);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r7 = operation.a0(r7, it.next());
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    public static <T> List<T> T5(@a7.d Collection<? extends T> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        return new ArrayList(collection);
    }

    @kotlin.internal.f
    private static final <T> int U1(Collection<? extends T> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        return collection.size();
    }

    @a7.d
    public static final <T, K, M extends Map<? super K, List<T>>> M U2(@a7.d Iterable<? extends T> iterable, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (T t7 : iterable) {
            K kZ = keySelector.z(t7);
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(t7);
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> double U3(Iterable<? extends T> iterable, i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <T, R> List<R> U4(@a7.d Iterable<? extends T> iterable, R r7, @a7.d i5.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iZ = z.Z(iterable, 9);
        if (iZ == 0) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(iZ + 1);
        arrayList.add(r7);
        Iterator<? extends T> it = iterable.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            r7 = operation.v(Integer.valueOf(i7), r7, it.next());
            arrayList.add(r7);
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final <T> Set<T> U5(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) L5(iterable, new LinkedHashSet());
    }

    @a7.d
    public static final <T> List<T> V1(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return Q5(U5(iterable));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T, K, V, M extends Map<? super K, List<V>>> M V2(@a7.d Iterable<? extends T> iterable, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (T t7 : iterable) {
            K kZ = keySelector.z(t7);
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(t7));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> float V3(Iterable<? extends T> iterable, i5.l<? super T, Float> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(it.next()).floatValue());
        }
        return fFloatValue;
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <S, T extends S> List<S> V4(@a7.d Iterable<? extends T> iterable, @a7.d i5.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return y.F();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(z.Z(iterable, 10));
        arrayList.add(next);
        while (it.hasNext()) {
            next = operation.a0(next, it.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    @a7.d
    public static <T> Set<T> V5(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return n1.r((Set) L5(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return n1.k();
        }
        if (size != 1) {
            return (Set) L5(iterable, new LinkedHashSet(b1.j(collection.size())));
        }
        return m1.f(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    @a7.d
    public static final <T, K> List<T> W1(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends K> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t7 : iterable) {
            if (hashSet.add(selector.z(t7))) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <T, K> n0<T, K> W2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        return new c(iterable, keySelector);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R extends Comparable<? super R>> R W3(Iterable<? extends T> iterable, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <S, T extends S> List<S> W4(@a7.d Iterable<? extends T> iterable, @a7.d i5.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return y.F();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(z.Z(iterable, 10));
        arrayList.add(next);
        int i7 = 1;
        while (it.hasNext()) {
            next = operation.v(Integer.valueOf(i7), next, it.next());
            arrayList.add(next);
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final short[] W5(@a7.d Collection<Short> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        short[] sArr = new short[collection.size()];
        Iterator<Short> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            sArr[i7] = it.next().shortValue();
            i7++;
        }
        return sArr;
    }

    @a7.d
    public static <T> List<T> X1(@a7.d Iterable<? extends T> iterable, int i7) {
        ArrayList arrayList;
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        int i8 = 0;
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return Q5(iterable);
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - i7;
            if (size <= 0) {
                return y.F();
            }
            if (size == 1) {
                return x.l(i3(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    while (i7 < size2) {
                        arrayList.add(((List) iterable).get(i7));
                        i7++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i7);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        for (T t7 : iterable) {
            if (i8 >= i7) {
                arrayList.add(t7);
            } else {
                i8++;
            }
        }
        return y.R(arrayList);
    }

    public static final <T> int X2(@a7.d Iterable<? extends T> iterable, T t7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t7);
        }
        int i7 = 0;
        for (T t8 : iterable) {
            if (i7 < 0) {
                y.X();
            }
            if (kotlin.jvm.internal.l0.g(t7, t8)) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R extends Comparable<? super R>> R X3(Iterable<? extends T> iterable, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <T, R> List<R> X4(@a7.d Iterable<? extends T> iterable, R r7, @a7.d i5.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iZ = z.Z(iterable, 9);
        if (iZ == 0) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(iZ + 1);
        arrayList.add(r7);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r7 = operation.a0(r7, it.next());
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    public static final <T> Set<T> X5(@a7.d Iterable<? extends T> iterable, @a7.d Iterable<? extends T> other) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<T> setU5 = U5(iterable);
        d0.o0(setU5, other);
        return setU5;
    }

    @a7.d
    public static <T> List<T> Y1(@a7.d List<? extends T> list, int i7) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (i7 >= 0) {
            return E5(list, kotlin.ranges.q.n(list.size() - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    public static final <T> int Y2(@a7.d List<? extends T> list, T t7) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return list.indexOf(t7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> Double Y3(Iterable<? extends T> iterable, i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = selector.z(it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <T, R> List<R> Y4(@a7.d Iterable<? extends T> iterable, R r7, @a7.d i5.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iZ = z.Z(iterable, 9);
        if (iZ == 0) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(iZ + 1);
        arrayList.add(r7);
        Iterator<? extends T> it = iterable.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            r7 = operation.v(Integer.valueOf(i7), r7, it.next());
            arrayList.add(r7);
            i7++;
        }
        return arrayList;
    }

    @a7.d
    @kotlin.g1(version = "1.2")
    public static final <T> List<List<T>> Y5(@a7.d Iterable<? extends T> iterable, int i7, int i8, boolean z7) {
        int iU;
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        q1.a(i7, i8);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = q1.b(iterable.iterator(), i7, i8, z7, false);
            while (itB.hasNext()) {
                arrayList.add((List) itB.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i8) + (size % i8 == 0 ? 0 : 1));
        int i9 = 0;
        while (true) {
            if (!(i9 >= 0 && i9 < size) || ((iU = kotlin.ranges.q.u(i7, size - i9)) < i7 && !z7)) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(iU);
            for (int i10 = 0; i10 < iU; i10++) {
                arrayList3.add(list.get(i10 + i9));
            }
            arrayList2.add(arrayList3);
            i9 += i8;
        }
        return arrayList2;
    }

    @a7.d
    public static final <T> List<T> Z1(@a7.d List<? extends T> list, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (!predicate.z(listIterator.previous()).booleanValue()) {
                    return E5(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return y.F();
    }

    public static final <T> int Z2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        for (T t7 : iterable) {
            if (i7 < 0) {
                y.X();
            }
            if (predicate.z(t7).booleanValue()) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> Float Z3(Iterable<? extends T> iterable, i5.l<? super T, Float> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = selector.z(it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.3")
    public static final <T> void Z4(@a7.d List<T> list, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        for (int iH = y.H(list); iH > 0; iH--) {
            int iM = random.m(iH + 1);
            list.set(iM, list.set(iH, list.get(iM)));
        }
    }

    @a7.d
    @kotlin.g1(version = "1.2")
    public static final <T, R> List<R> Z5(@a7.d Iterable<? extends T> iterable, int i7, int i8, boolean z7, @a7.d i5.l<? super List<? extends T>, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        q1.a(i7, i8);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = q1.b(iterable.iterator(), i7, i8, z7, true);
            while (itB.hasNext()) {
                arrayList.add(transform.z((List) itB.next()));
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i8) + (size % i8 == 0 ? 0 : 1));
        f1 f1Var = new f1(list);
        int i9 = 0;
        while (true) {
            if (!(i9 >= 0 && i9 < size)) {
                break;
            }
            int iU = kotlin.ranges.q.u(i7, size - i9);
            if (!z7 && iU < i7) {
                break;
            }
            f1Var.b(i9, iU + i9);
            arrayList2.add(transform.z(f1Var));
            i9 += i8;
        }
        return arrayList2;
    }

    @a7.d
    public static final <T> List<T> a2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (T t7 : iterable) {
            if (z7) {
                arrayList.add(t7);
            } else if (!predicate.z(t7).booleanValue()) {
                arrayList.add(t7);
                z7 = true;
            }
        }
        return arrayList;
    }

    public static final <T> int a3(@a7.d List<? extends T> list, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Iterator<? extends T> it = list.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            if (predicate.z(it.next()).booleanValue()) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R> R a4(Iterable<? extends T> iterable, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static <T> T a5(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) c5((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static /* synthetic */ List a6(Iterable iterable, int i7, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 1;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return Y5(iterable, i7, i8, z7);
    }

    public static final <T> T b2(@a7.d Iterable<? extends T> iterable, int i7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return iterable instanceof List ? (T) ((List) iterable).get(i7) : (T) d2(iterable, i7, new b(i7));
    }

    public static final <T> int b3(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = -1;
        int i8 = 0;
        for (T t7 : iterable) {
            if (i8 < 0) {
                y.X();
            }
            if (predicate.z(t7).booleanValue()) {
                i7 = i8;
            }
            i8++;
        }
        return i7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R> R b4(Iterable<? extends T> iterable, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z(it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z(it.next());
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final <T> T b5(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        T t7 = null;
        boolean z7 = false;
        for (T t8 : iterable) {
            if (predicate.z(t8).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
                z7 = true;
                t7 = t8;
            }
        }
        if (z7) {
            return t7;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static /* synthetic */ List b6(Iterable iterable, int i7, int i8, boolean z7, i5.l lVar, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 1;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return Z5(iterable, i7, i8, z7, lVar);
    }

    @kotlin.internal.f
    private static final <T> T c2(List<? extends T> list, int i7) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return list.get(i7);
    }

    public static final <T> int c3(@a7.d List<? extends T> list, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (predicate.z(listIterator.previous()).booleanValue()) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static <T extends Comparable<? super T>> T c4(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T> T c5(@a7.d List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    @a7.d
    public static final <T> Iterable<r0<T>> c6(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return new s0(new d(iterable));
    }

    public static final <T> T d2(@a7.d Iterable<? extends T> iterable, int i7, @a7.d i5.l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i7 < 0 || i7 > y.H(list)) ? defaultValue.z(Integer.valueOf(i7)) : (T) list.get(i7);
        }
        if (i7 < 0) {
            return defaultValue.z(Integer.valueOf(i7));
        }
        int i8 = 0;
        for (T t7 : iterable) {
            int i9 = i8 + 1;
            if (i7 == i8) {
                return t7;
            }
            i8 = i9;
        }
        return defaultValue.z(Integer.valueOf(i7));
    }

    @a7.d
    public static final <T> Set<T> d3(@a7.d Iterable<? extends T> iterable, @a7.d Iterable<? extends T> other) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<T> setU5 = U5(iterable);
        d0.O0(setU5, other);
        return setU5;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Double d4(@a7.d Iterable<Double> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @a7.e
    public static final <T> T d5(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    @a7.d
    public static <T, R> List<kotlin.u0<T, R>> d6(@a7.d Iterable<? extends T> iterable, @a7.d Iterable<? extends R> other) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(z.Z(iterable, 10), z.Z(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(kotlin.p1.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final <T> T e2(List<? extends T> list, int i7, i5.l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > y.H(list)) ? defaultValue.z(Integer.valueOf(i7)) : list.get(i7);
    }

    @a7.d
    public static final <T, A extends Appendable> A e3(@a7.d Iterable<? extends T> iterable, @a7.d A buffer, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (T t7 : iterable) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            kotlin.text.t.b(buffer, t7, lVar);
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Float e4(@a7.d Iterable<Float> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @a7.e
    public static final <T> T e5(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        boolean z7 = false;
        T t7 = null;
        for (T t8 : iterable) {
            if (predicate.z(t8).booleanValue()) {
                if (z7) {
                    return null;
                }
                z7 = true;
                t7 = t8;
            }
        }
        if (z7) {
            return t7;
        }
        return null;
    }

    @a7.d
    public static final <T, R, V> List<V> e6(@a7.d Iterable<? extends T> iterable, @a7.d Iterable<? extends R> other, @a7.d i5.p<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(z.Z(iterable, 10), z.Z(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(transform.a0(it.next(), it2.next()));
        }
        return arrayList;
    }

    @a7.e
    public static final <T> T f2(@a7.d Iterable<? extends T> iterable, int i7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) R2((List) iterable, i7);
        }
        if (i7 < 0) {
            return null;
        }
        int i8 = 0;
        for (T t7 : iterable) {
            int i9 = i8 + 1;
            if (i7 == i8) {
                return t7;
            }
            i8 = i9;
        }
        return null;
    }

    public static /* synthetic */ Appendable f3(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
        return e3(iterable, appendable, (charSequence & 2) != 0 ? ", " : charSequence, (charSequence & 4) != 0 ? "" : charSequence2, (charSequence & 8) == 0 ? charSequence3 : "", (charSequence & 16) != 0 ? -1 : i7, (charSequence & 32) != 0 ? "..." : charSequence4, (charSequence & 64) != 0 ? null : lVar);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final double f4(@a7.d Iterable<Double> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, it.next().doubleValue());
        }
        return dDoubleValue;
    }

    @a7.e
    public static <T> T f5(@a7.d List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @a7.d
    public static final <T, R> List<kotlin.u0<T, R>> f6(@a7.d Iterable<? extends T> iterable, @a7.d R[] other) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(z.Z(iterable, 10), length));
        int i7 = 0;
        for (T t7 : iterable) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(kotlin.p1.a(t7, other[i7]));
            i7++;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final <T> T g2(List<? extends T> list, int i7) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return (T) R2(list, i7);
    }

    @a7.d
    public static final <T> String g3(@a7.d Iterable<? extends T> iterable, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        String string = ((StringBuilder) e3(iterable, new StringBuilder(), separator, prefix, postfix, i7, truncated, lVar)).toString();
        kotlin.jvm.internal.l0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final float g4(@a7.d Iterable<Float> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = it.next().floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, it.next().floatValue());
        }
        return fFloatValue;
    }

    @a7.d
    public static final <T> List<T> g5(@a7.d List<? extends T> list, @a7.d Iterable<Integer> indices) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        int iZ = z.Z(indices, 10);
        if (iZ == 0) {
            return y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(list.get(it.next().intValue()));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T, R, V> List<V> g6(@a7.d Iterable<? extends T> iterable, @a7.d R[] other, @a7.d i5.p<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(z.Z(iterable, 10), length));
        int i7 = 0;
        for (T t7 : iterable) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(transform.a0(t7, other[i7]));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final <T> List<T> h2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t7 : iterable) {
            if (predicate.z(t7).booleanValue()) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ String h3(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i8 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i8 & 4) == 0 ? charSequence3 : "";
        if ((i8 & 8) != 0) {
            i7 = -1;
        }
        int i9 = i7;
        if ((i8 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i8 & 32) != 0) {
            lVar = null;
        }
        return g3(iterable, charSequence, charSequence5, charSequence6, i9, charSequence7, lVar);
    }

    @a7.d
    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final <T extends Comparable<? super T>> T h4(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @a7.d
    public static final <T> List<T> h5(@a7.d List<? extends T> list, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? y.F() : Q5(list.subList(indices.d().intValue(), indices.f().intValue() + 1));
    }

    @a7.d
    @kotlin.g1(version = "1.2")
    public static final <T> List<kotlin.u0<T, T>> h6(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return y.F();
        }
        ArrayList arrayList = new ArrayList();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(kotlin.p1.a(next, next2));
            next = next2;
        }
        return arrayList;
    }

    @a7.d
    public static final <T> List<T> i2(@a7.d Iterable<? extends T> iterable, @a7.d i5.p<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            if (predicate.a0(Integer.valueOf(i7), t7).booleanValue()) {
                arrayList.add(t7);
            }
            i7 = i8;
        }
        return arrayList;
    }

    public static final <T> T i3(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) k3((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <T> T i4(@a7.d Iterable<? extends T> iterable, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T, R extends Comparable<? super R>> void i5(@a7.d List<T> list, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (list.size() > 1) {
            c0.n0(list, new kotlin.comparisons.b.C0428b(selector));
        }
    }

    @a7.d
    @kotlin.g1(version = "1.2")
    public static final <T, R> List<R> i6(@a7.d Iterable<? extends T> iterable, @a7.d i5.p<? super T, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return y.F();
        }
        ArrayList arrayList = new ArrayList();
        a1.d next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(transform.a0(next, next2));
            next = next2;
        }
        return arrayList;
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C j2(@a7.d Iterable<? extends T> iterable, @a7.d C destination, @a7.d i5.p<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            if (predicate.a0(Integer.valueOf(i7), t7).booleanValue()) {
                destination.add(t7);
            }
            i7 = i8;
        }
        return destination;
    }

    public static final <T> T j3(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        T t7 = null;
        boolean z7 = false;
        for (T t8 : iterable) {
            if (predicate.z(t8).booleanValue()) {
                z7 = true;
                t7 = t8;
            }
        }
        if (z7) {
            return t7;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final <T> T j4(@a7.d Iterable<? extends T> iterable, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T, R extends Comparable<? super R>> void j5(@a7.d List<T> list, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (list.size() > 1) {
            c0.n0(list, new kotlin.comparisons.b.d(selector));
        }
    }

    public static final /* synthetic */ <R> List<R> k2(Iterable<?> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            kotlin.jvm.internal.l0.y(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <T> T k3(@a7.d List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(y.H(list));
    }

    @a7.d
    public static final <T> List<T> k4(@a7.d Iterable<? extends T> iterable, @a7.d Iterable<? extends T> elements) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        Collection collectionD = s.d(elements, iterable);
        if (collectionD.isEmpty()) {
            return Q5(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t7 : iterable) {
            if (!collectionD.contains(t7)) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    public static final <T extends Comparable<? super T>> void k5(@a7.d List<T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        c0.n0(list, kotlin.comparisons.b.q());
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C l2(Iterable<?> iterable, C destination) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (Object obj : iterable) {
            kotlin.jvm.internal.l0.y(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public static final <T> T l3(@a7.d List<? extends T> list, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (predicate.z(tPrevious).booleanValue()) {
                return tPrevious;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    @a7.d
    public static final <T> List<T> l4(@a7.d Iterable<? extends T> iterable, T t7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList(z.Z(iterable, 10));
        boolean z7 = false;
        for (T t8 : iterable) {
            boolean z8 = true;
            if (!z7 && kotlin.jvm.internal.l0.g(t8, t7)) {
                z7 = true;
                z8 = false;
            }
            if (z8) {
                arrayList.add(t8);
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <T extends Comparable<? super T>> List<T> l5(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> listS5 = S5(iterable);
            c0.k0(listS5);
            return listS5;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return Q5(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        kotlin.jvm.internal.l0.n(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        kotlin.jvm.internal.l0.n(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt___CollectionsKt.sorted>");
        Comparable[] comparableArr = (Comparable[]) array;
        o.v4(comparableArr);
        return o.t(comparableArr);
    }

    @a7.d
    public static final <T> List<T> m2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t7 : iterable) {
            if (!predicate.z(t7).booleanValue()) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    public static final <T> int m3(@a7.d Iterable<? extends T> iterable, T t7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t7);
        }
        int i7 = -1;
        int i8 = 0;
        for (T t8 : iterable) {
            if (i8 < 0) {
                y.X();
            }
            if (kotlin.jvm.internal.l0.g(t7, t8)) {
                i7 = i8;
            }
            i8++;
        }
        return i7;
    }

    @a7.d
    public static final <T> List<T> m4(@a7.d Iterable<? extends T> iterable, @a7.d kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        Collection collectionB = s.b(elements);
        if (collectionB.isEmpty()) {
            return Q5(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t7 : iterable) {
            if (!collectionB.contains(t7)) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <T, R extends Comparable<? super R>> List<T> m5(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return p5(iterable, new kotlin.comparisons.b.C0428b(selector));
    }

    @a7.d
    public static final <T> List<T> n2(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return (List) o2(iterable, new ArrayList());
    }

    public static final <T> int n3(@a7.d List<? extends T> list, T t7) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        return list.lastIndexOf(t7);
    }

    @a7.d
    public static final <T> List<T> n4(@a7.d Iterable<? extends T> iterable, @a7.d T[] elements) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        if (elements.length == 0) {
            return Q5(iterable);
        }
        Collection collectionC = s.c(elements);
        ArrayList arrayList = new ArrayList();
        for (T t7 : iterable) {
            if (!collectionC.contains(t7)) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <T, R extends Comparable<? super R>> List<T> n5(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return p5(iterable, new kotlin.comparisons.b.d(selector));
    }

    @a7.d
    public static final <C extends Collection<? super T>, T> C o2(@a7.d Iterable<? extends T> iterable, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (T t7 : iterable) {
            if (t7 != null) {
                destination.add(t7);
            }
        }
        return destination;
    }

    @a7.e
    public static final <T> T o3(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    @kotlin.internal.f
    private static final <T> List<T> o4(Iterable<? extends T> iterable, T t7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return l4(iterable, t7);
    }

    @a7.d
    public static final <T extends Comparable<? super T>> List<T> o5(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return p5(iterable, kotlin.comparisons.b.q());
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C p2(@a7.d Iterable<? extends T> iterable, @a7.d C destination, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : iterable) {
            if (!predicate.z(t7).booleanValue()) {
                destination.add(t7);
            }
        }
        return destination;
    }

    @a7.e
    public static final <T> T p3(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        T t7 = null;
        for (T t8 : iterable) {
            if (predicate.z(t8).booleanValue()) {
                t7 = t8;
            }
        }
        return t7;
    }

    public static final <T> boolean p4(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T> List<T> p5(@a7.d Iterable<? extends T> iterable, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> listS5 = S5(iterable);
            c0.n0(listS5, comparator);
            return listS5;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return Q5(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        kotlin.jvm.internal.l0.n(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        kotlin.jvm.internal.l0.n(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt___CollectionsKt.sortedWith>");
        o.I4(array, comparator);
        return o.t(array);
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C q2(@a7.d Iterable<? extends T> iterable, @a7.d C destination, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : iterable) {
            if (predicate.z(t7).booleanValue()) {
                destination.add(t7);
            }
        }
        return destination;
    }

    @a7.e
    public static final <T> T q3(@a7.d List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static final <T> boolean q4(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.z(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    public static final <T> Set<T> q5(@a7.d Iterable<? extends T> iterable, @a7.d Iterable<? extends T> other) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<T> setU5 = U5(iterable);
        d0.E0(setU5, other);
        return setU5;
    }

    public static final <T> boolean r1(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!predicate.z(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @kotlin.internal.f
    private static final <T> T r2(Iterable<? extends T> iterable, i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : iterable) {
            if (predicate.z(t7).booleanValue()) {
                return t7;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @a7.e
    public static final <T> T r3(@a7.d List<? extends T> list, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (predicate.z(tPrevious).booleanValue()) {
                return tPrevious;
            }
        }
        return null;
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <T, C extends Iterable<? extends T>> C r4(@a7.d C c8, @a7.d i5.l<? super T, l2> action) {
        kotlin.jvm.internal.l0.p(c8, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        Iterator<T> it = c8.iterator();
        while (it.hasNext()) {
            action.z(it.next());
        }
        return c8;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> int r5(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Integer> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += selector.z(it.next()).intValue();
        }
        return iIntValue;
    }

    public static final <T> boolean s1(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return iterable instanceof Collection ? !((Collection) iterable).isEmpty() : iterable.iterator().hasNext();
    }

    @kotlin.internal.f
    private static final <T> T s2(Iterable<? extends T> iterable, i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        T t7 = null;
        for (T t8 : iterable) {
            if (predicate.z(t8).booleanValue()) {
                t7 = t8;
            }
        }
        return t7;
    }

    @a7.d
    public static final <T, R> List<R> s3(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(z.Z(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.z(it.next()));
        }
        return arrayList;
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <T, C extends Iterable<? extends T>> C s4(@a7.d C c8, @a7.d i5.p<? super Integer, ? super T, l2> action) {
        kotlin.jvm.internal.l0.p(c8, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int i7 = 0;
        for (T t7 : c8) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            action.a0(Integer.valueOf(i7), t7);
            i7 = i8;
        }
        return c8;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> double s5(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += selector.z(it.next()).doubleValue();
        }
        return dDoubleValue;
    }

    public static final <T> boolean t1(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.z(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
    @kotlin.internal.f
    private static final <T> T t2(List<? extends T> list, i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T tPrevious = listIterator.previous();
            if (predicate.z(tPrevious).booleanValue()) {
                return tPrevious;
            }
        }
        return null;
    }

    @a7.d
    public static final <T, R> List<R> t3(@a7.d Iterable<? extends T> iterable, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(z.Z(iterable, 10));
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            arrayList.add(transform.a0(Integer.valueOf(i7), t7));
            i7 = i8;
        }
        return arrayList;
    }

    @a7.d
    public static final <T> kotlin.u0<List<T>, List<T>> t4(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t7 : iterable) {
            if (predicate.z(t7).booleanValue()) {
                arrayList.add(t7);
            } else {
                arrayList2.add(t7);
            }
        }
        return new kotlin.u0<>(arrayList, arrayList2);
    }

    @h5.h(name = "sumOfByte")
    public static final int t5(@a7.d Iterable<Byte> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        int iByteValue = 0;
        while (it.hasNext()) {
            iByteValue += it.next().byteValue();
        }
        return iByteValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final <T> Iterable<T> u1(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return iterable;
    }

    public static final <T> T u2(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) w2((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @a7.d
    public static final <T, R> List<R> u3(@a7.d Iterable<? extends T> iterable, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            R rA0 = transform.a0(Integer.valueOf(i7), t7);
            if (rA0 != null) {
                arrayList.add(rA0);
            }
            i7 = i8;
        }
        return arrayList;
    }

    @a7.d
    public static final <T> List<T> u4(@a7.d Iterable<? extends T> iterable, @a7.d Iterable<? extends T> elements) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        if (iterable instanceof Collection) {
            return y4((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        d0.o0(arrayList, iterable);
        d0.o0(arrayList, elements);
        return arrayList;
    }

    @h5.h(name = "sumOfDouble")
    public static final double u5(@a7.d Iterable<Double> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += it.next().doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static <T> kotlin.sequences.m<T> v1(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return new a(iterable);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T v2(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : iterable) {
            if (predicate.z(t7).booleanValue()) {
                return t7;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C v3(@a7.d Iterable<? extends T> iterable, @a7.d C destination, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            R rA0 = transform.a0(Integer.valueOf(i7), t7);
            if (rA0 != null) {
                destination.add(rA0);
            }
            i7 = i8;
        }
        return destination;
    }

    @a7.d
    public static final <T> List<T> v4(@a7.d Iterable<? extends T> iterable, T t7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return z4((Collection) iterable, t7);
        }
        ArrayList arrayList = new ArrayList();
        d0.o0(arrayList, iterable);
        arrayList.add(t7);
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T> double v5(Iterable<? extends T> iterable, i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        double dDoubleValue = 0.0d;
        while (it.hasNext()) {
            dDoubleValue += selector.z(it.next()).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final <T, K, V> Map<K, V> w1(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(z.Z(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(it.next());
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    public static <T> T w2(@a7.d List<? extends T> list) {
        kotlin.jvm.internal.l0.p(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C w3(@a7.d Iterable<? extends T> iterable, @a7.d C destination, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int i7 = 0;
        for (T t7 : iterable) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            destination.add(transform.a0(Integer.valueOf(i7), t7));
            i7 = i8;
        }
        return destination;
    }

    @a7.d
    public static final <T> List<T> w4(@a7.d Iterable<? extends T> iterable, @a7.d kotlin.sequences.m<? extends T> elements) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        ArrayList arrayList = new ArrayList();
        d0.o0(arrayList, iterable);
        d0.p0(arrayList, elements);
        return arrayList;
    }

    @h5.h(name = "sumOfFloat")
    public static final float w5(@a7.d Iterable<Float> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        float fFloatValue = 0.0f;
        while (it.hasNext()) {
            fFloatValue += it.next().floatValue();
        }
        return fFloatValue;
    }

    @a7.d
    public static final <T, K> Map<K, T> x1(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(z.Z(iterable, 10)), 16));
        for (T t7 : iterable) {
            linkedHashMap.put(keySelector.z(t7), t7);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0022 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0023  */
    @kotlin.g1(version = "1.5")
    @kotlin.internal.f
    private static final <T, R> R x2(Iterable<? extends T> iterable, i5.l<? super T, ? extends R> transform) {
        R rZ;
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            rZ = transform.z(it.next());
            if (rZ != null) {
                if (rZ != null) {
                    return rZ;
                }
                throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
            }
        }
        rZ = null;
        if (rZ != null) {
            return rZ;
        }
        throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
    }

    @a7.d
    public static final <T, R> List<R> x3(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R rZ = transform.z(it.next());
            if (rZ != null) {
                arrayList.add(rZ);
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <T> List<T> x4(@a7.d Iterable<? extends T> iterable, @a7.d T[] elements) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        if (iterable instanceof Collection) {
            return B4((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        d0.o0(arrayList, iterable);
        d0.q0(arrayList, elements);
        return arrayList;
    }

    @h5.h(name = "sumOfInt")
    public static final int x5(@a7.d Iterable<Integer> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += it.next().intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final <T, K, V> Map<K, V> y1(@a7.d Iterable<? extends T> iterable, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(z.Z(iterable, 10)), 16));
        for (T t7 : iterable) {
            linkedHashMap.put(keySelector.z(t7), valueTransform.z(t7));
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.5")
    @kotlin.internal.f
    private static final <T, R> R y2(Iterable<? extends T> iterable, i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R rZ = transform.z(it.next());
            if (rZ != null) {
                return rZ;
            }
        }
        return null;
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C y3(@a7.d Iterable<? extends T> iterable, @a7.d C destination, @a7.d i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R rZ = transform.z(it.next());
            if (rZ != null) {
                destination.add(rZ);
            }
        }
        return destination;
    }

    @a7.d
    public static <T> List<T> y4(@a7.d Collection<? extends T> collection, @a7.d Iterable<? extends T> elements) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            d0.o0(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T> int y5(Iterable<? extends T> iterable, i5.l<? super T, Integer> selector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue += selector.z(it.next()).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final <T, K, M extends Map<? super K, ? super T>> M z1(@a7.d Iterable<? extends T> iterable, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (T t7 : iterable) {
            destination.put(keySelector.z(t7), t7);
        }
        return destination;
    }

    @a7.e
    public static final <T> T z2(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C z3(@a7.d Iterable<? extends T> iterable, @a7.d C destination, @a7.d i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(transform.z(it.next()));
        }
        return destination;
    }

    @a7.d
    public static <T> List<T> z4(@a7.d Collection<? extends T> collection, T t7) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t7);
        return arrayList;
    }

    @h5.h(name = "sumOfLong")
    public static final long z5(@a7.d Iterable<Long> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }
}
