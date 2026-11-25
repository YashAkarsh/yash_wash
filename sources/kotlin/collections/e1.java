package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
class e1 extends d1 {
    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V> Float A1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = selector.z((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z((Object) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V, R> R B1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z((Object) it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z((Object) it.next());
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V, R> R C1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z((Object) it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z((Object) it.next());
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = (Object) rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <K, V> Map.Entry<K, V> D1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return (Map.Entry) g0.i4(map.entrySet(), comparator);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    @kotlin.internal.f
    private static final <K, V> Map.Entry<K, V> E1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return (Map.Entry) g0.j4(map.entrySet(), comparator);
    }

    public static final <K, V> boolean F1(@a7.d Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return map.isEmpty();
    }

    public static final <K, V> boolean G1(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.z(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <K, V, M extends Map<? extends K, ? extends V>> M H1(@a7.d M m7, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, l2> action) {
        kotlin.jvm.internal.l0.p(m7, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        Iterator<Map.Entry<K, V>> it = m7.entrySet().iterator();
        while (it.hasNext()) {
            action.z(it.next());
        }
        return m7;
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <K, V, M extends Map<? extends K, ? extends V>> M I1(@a7.d M m7, @a7.d i5.p<? super Integer, ? super Map.Entry<? extends K, ? extends V>, l2> action) {
        kotlin.jvm.internal.l0.p(m7, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        Iterator<T> it = m7.entrySet().iterator();
        int i7 = 0;
        while (it.hasNext()) {
            a1.d dVar = (Object) it.next();
            int i8 = i7 + 1;
            if (i7 < 0) {
                y.X();
            }
            action.a0(Integer.valueOf(i7), dVar);
            i7 = i8;
        }
        return m7;
    }

    @a7.d
    public static final <K, V> List<kotlin.u0<K, V>> J1(@a7.d Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        if (map.size() == 0) {
            return y.F();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return y.F();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return x.l(new kotlin.u0(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new kotlin.u0(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new kotlin.u0(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    public static final <K, V> boolean P0(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!predicate.z(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean Q0(@a7.d Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return !map.isEmpty();
    }

    public static final <K, V> boolean R0(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.z(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @kotlin.internal.f
    private static final <K, V> Iterable<Map.Entry<K, V>> S0(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return map.entrySet();
    }

    @a7.d
    public static final <K, V> kotlin.sequences.m<Map.Entry<K, V>> T0(@a7.d Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return g0.v1(map.entrySet());
    }

    @kotlin.internal.f
    private static final <K, V> int U0(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        return map.size();
    }

    public static final <K, V> int V0(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        if (map.isEmpty()) {
            return 0;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.z(it.next()).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    @kotlin.g1(version = "1.5")
    @kotlin.internal.f
    private static final <K, V, R> R W0(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        R rZ;
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            rZ = transform.z(it.next());
            if (rZ != null) {
                if (rZ != null) {
                    return rZ;
                }
                throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
            }
        }
        rZ = null;
        if (rZ != null) {
            return rZ;
        }
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    @kotlin.g1(version = "1.5")
    @kotlin.internal.f
    private static final <K, V, R> R X0(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rZ = transform.z(it.next());
            if (rZ != null) {
                return rZ;
            }
        }
        return null;
    }

    @a7.d
    public static final <K, V, R> List<R> Y0(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.o0(arrayList, transform.z(it.next()));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapSequence")
    @kotlin.t0
    @a7.d
    public static final <K, V, R> List<R> Z0(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.p0(arrayList, transform.z(it.next()));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapSequenceTo")
    @kotlin.t0
    @a7.d
    public static final <K, V, R, C extends Collection<? super R>> C a1(@a7.d Map<? extends K, ? extends V> map, @a7.d C destination, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.p0(destination, transform.z(it.next()));
        }
        return destination;
    }

    @a7.d
    public static final <K, V, R, C extends Collection<? super R>> C b1(@a7.d Map<? extends K, ? extends V> map, @a7.d C destination, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            d0.o0(destination, transform.z(it.next()));
        }
        return destination;
    }

    @kotlin.internal.e
    public static final <K, V> void c1(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, l2> action) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            action.z(it.next());
        }
    }

    @a7.d
    public static final <K, V, R> List<R> d1(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(transform.z(it.next()));
        }
        return arrayList;
    }

    @a7.d
    public static final <K, V, R> List<R> e1(@a7.d Map<? extends K, ? extends V> map, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rZ = transform.z(it.next());
            if (rZ != null) {
                arrayList.add(rZ);
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <K, V, R, C extends Collection<? super R>> C f1(@a7.d Map<? extends K, ? extends V> map, @a7.d C destination, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R rZ = transform.z(it.next());
            if (rZ != null) {
                destination.add(rZ);
            }
        }
        return destination;
    }

    @a7.d
    public static final <K, V, R, C extends Collection<? super R>> C g1(@a7.d Map<? extends K, ? extends V> map, @a7.d C destination, @a7.d i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            destination.add(transform.z(it.next()));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> h1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rZ = selector.z(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rZ2 = selector.z(entry3);
                    if (rZ.compareTo(rZ2) < 0) {
                        entry2 = entry3;
                        rZ = rZ2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    @kotlin.internal.f
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> i1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Map.Entry<K, V> entry = (Object) it.next();
        if (it.hasNext()) {
            R rZ = selector.z(entry);
            do {
                Map.Entry<K, V> entry2 = (Object) it.next();
                R rZ2 = selector.z(entry2);
                if (rZ.compareTo(rZ2) < 0) {
                    entry = entry2;
                    rZ = rZ2;
                }
            } while (it.hasNext());
        }
        return entry;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V> double j1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z((Object) it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V> float k1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z((Object) it.next()).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V, R extends Comparable<? super R>> R l1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z((Object) it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z((Object) it.next());
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V, R extends Comparable<? super R>> R m1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z((Object) it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z((Object) it.next());
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V> Double n1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = selector.z((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z((Object) it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V> Float o1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = selector.z((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z((Object) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V, R> R p1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z((Object) it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z((Object) it.next());
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V, R> R q1(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z((Object) it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z((Object) it.next());
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = (Object) rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <K, V> Map.Entry<K, V> r1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return (Map.Entry) g0.Q3(map.entrySet(), comparator);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    @kotlin.internal.f
    private static final <K, V> Map.Entry<K, V> s1(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return (Map.Entry) g0.R3(map.entrySet(), comparator);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> t1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R rZ = selector.z(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R rZ2 = selector.z(entry3);
                    if (rZ.compareTo(rZ2) > 0) {
                        entry2 = entry3;
                        rZ = rZ2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        } else {
            entry = null;
        }
        return entry;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    @kotlin.internal.f
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> u1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Map.Entry<K, V> entry = (Object) it.next();
        if (it.hasNext()) {
            R rZ = selector.z(entry);
            do {
                Map.Entry<K, V> entry2 = (Object) it.next();
                R rZ2 = selector.z(entry2);
                if (rZ.compareTo(rZ2) > 0) {
                    entry = entry2;
                    rZ = rZ2;
                }
            } while (it.hasNext());
        }
        return entry;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V> double v1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z((Object) it.next()).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V> float w1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z((Object) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z((Object) it.next()).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V, R extends Comparable<? super R>> R x1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z((Object) it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z((Object) it.next());
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V, R extends Comparable<? super R>> R y1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R rZ = selector.z((Object) it.next());
        while (it.hasNext()) {
            R rZ2 = selector.z((Object) it.next());
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <K, V> Double z1(Map<? extends K, ? extends V> map, i5.l<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.l0.p(map, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double dDoubleValue = selector.z((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z((Object) it.next()).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }
}
