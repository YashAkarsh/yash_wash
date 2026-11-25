package g1;

import c.m0;
import c.o0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class h {
    private h() {
    }

    @c1.a
    public static boolean a(@o0 Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @c1.a
    @m0
    @Deprecated
    public static <T> List<T> b() {
        return Collections.emptyList();
    }

    @c1.a
    @m0
    @Deprecated
    public static <T> List<T> c(@m0 T t7) {
        return Collections.singletonList(t7);
    }

    @c1.a
    @m0
    @Deprecated
    public static <T> List<T> d(@m0 T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? Collections.unmodifiableList(Arrays.asList(tArr)) : c(tArr[0]);
        }
        return b();
    }

    @c1.a
    @m0
    public static <K, V> Map<K, V> e(@m0 K k7, @m0 V v7, @m0 K k8, @m0 V v8, @m0 K k9, @m0 V v9) {
        Map mapK = k(3, false);
        mapK.put(k7, v7);
        mapK.put(k8, v8);
        mapK.put(k9, v9);
        return Collections.unmodifiableMap(mapK);
    }

    @c1.a
    @m0
    public static <K, V> Map<K, V> f(@m0 K k7, @m0 V v7, @m0 K k8, @m0 V v8, @m0 K k9, @m0 V v9, @m0 K k10, @m0 V v10, @m0 K k11, @m0 V v11, @m0 K k12, @m0 V v12) {
        Map mapK = k(6, false);
        mapK.put(k7, v7);
        mapK.put(k8, v8);
        mapK.put(k9, v9);
        mapK.put(k10, v10);
        mapK.put(k11, v11);
        mapK.put(k12, v12);
        return Collections.unmodifiableMap(mapK);
    }

    @c1.a
    @m0
    public static <K, V> Map<K, V> g(@m0 K[] kArr, @m0 V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            StringBuilder sb = new StringBuilder(66);
            sb.append("Key and values array lengths not equal: ");
            sb.append(length);
            sb.append(" != ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (length == 0) {
            return Collections.emptyMap();
        }
        if (length == 1) {
            return Collections.singletonMap(kArr[0], vArr[0]);
        }
        Map mapK = k(length, false);
        for (int i7 = 0; i7 < kArr.length; i7++) {
            mapK.put(kArr[i7], vArr[i7]);
        }
        return Collections.unmodifiableMap(mapK);
    }

    @c1.a
    @m0
    public static <T> Set<T> h(int i7) {
        return i7 == 0 ? new androidx.collection.b() : l(i7, true);
    }

    @c1.a
    @m0
    @Deprecated
    public static <T> Set<T> i(@m0 T t7, @m0 T t8, @m0 T t9) {
        Set setL = l(3, false);
        setL.add(t7);
        setL.add(t8);
        setL.add(t9);
        return Collections.unmodifiableSet(setL);
    }

    @c1.a
    @m0
    @Deprecated
    public static <T> Set<T> j(@m0 T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t7 = tArr[0];
            T t8 = tArr[1];
            Set setL = l(2, false);
            setL.add(t7);
            setL.add(t8);
            return Collections.unmodifiableSet(setL);
        }
        if (length == 3) {
            return i(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set setL2 = l(length, false);
            Collections.addAll(setL2, tArr);
            return Collections.unmodifiableSet(setL2);
        }
        T t9 = tArr[0];
        T t10 = tArr[1];
        T t11 = tArr[2];
        T t12 = tArr[3];
        Set setL3 = l(4, false);
        setL3.add(t9);
        setL3.add(t10);
        setL3.add(t11);
        setL3.add(t12);
        return Collections.unmodifiableSet(setL3);
    }

    private static <K, V> Map<K, V> k(int i7, boolean z7) {
        return i7 <= 256 ? new androidx.collection.a(i7) : new HashMap(i7, 1.0f);
    }

    private static <T> Set<T> l(int i7, boolean z7) {
        return i7 <= (true != z7 ? 256 : 128) ? new androidx.collection.b(i7) : new HashSet(i7, true != z7 ? 1.0f : 0.75f);
    }
}
