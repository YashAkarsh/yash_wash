package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.a2;
import kotlin.b2;
import kotlin.g2;
import kotlin.h2;
import kotlin.q2;
import kotlin.w1;
import kotlin.x1;

/* JADX INFO: loaded from: classes2.dex */
class v1 {
    @kotlin.g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @h5.h(name = "sumOfUByte")
    public static final int a(@a7.d Iterable<kotlin.s1> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<kotlin.s1> it = iterable.iterator();
        int iH = 0;
        while (it.hasNext()) {
            iH = w1.h(iH + w1.h(it.next().e0() & 255));
        }
        return iH;
    }

    @kotlin.g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @h5.h(name = "sumOfUInt")
    public static final int b(@a7.d Iterable<w1> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<w1> it = iterable.iterator();
        int iH = 0;
        while (it.hasNext()) {
            iH = w1.h(iH + it.next().g0());
        }
        return iH;
    }

    @kotlin.g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @h5.h(name = "sumOfULong")
    public static final long c(@a7.d Iterable<a2> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<a2> it = iterable.iterator();
        long jH = 0;
        while (it.hasNext()) {
            jH = a2.h(jH + it.next().g0());
        }
        return jH;
    }

    @kotlin.g1(version = "1.5")
    @q2(markerClass = {kotlin.t.class})
    @h5.h(name = "sumOfUShort")
    public static final int d(@a7.d Iterable<g2> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        Iterator<g2> it = iterable.iterator();
        int iH = 0;
        while (it.hasNext()) {
            iH = w1.h(iH + w1.h(it.next().e0() & g2.f34732d));
        }
        return iH;
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.t
    public static final byte[] e(@a7.d Collection<kotlin.s1> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        byte[] bArrD = kotlin.t1.d(collection.size());
        Iterator<kotlin.s1> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            kotlin.t1.u(bArrD, i7, it.next().e0());
            i7++;
        }
        return bArrD;
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.t
    public static final int[] f(@a7.d Collection<w1> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        int[] iArrD = x1.d(collection.size());
        Iterator<w1> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            x1.u(iArrD, i7, it.next().g0());
            i7++;
        }
        return iArrD;
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.t
    public static final long[] g(@a7.d Collection<a2> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        long[] jArrD = b2.d(collection.size());
        Iterator<a2> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            b2.u(jArrD, i7, it.next().g0());
            i7++;
        }
        return jArrD;
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    @kotlin.t
    public static final short[] h(@a7.d Collection<g2> collection) {
        kotlin.jvm.internal.l0.p(collection, "<this>");
        short[] sArrD = h2.d(collection.size());
        Iterator<g2> it = collection.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            h2.u(sArrD, i7, it.next().e0());
            i7++;
        }
        return sArrD;
    }
}
