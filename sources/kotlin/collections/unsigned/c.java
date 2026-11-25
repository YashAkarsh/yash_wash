package kotlin.collections.unsigned;

import a7.e;
import h5.h;
import i5.l;
import i5.p;
import i5.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.a2;
import kotlin.b1;
import kotlin.b2;
import kotlin.collections.d0;
import kotlin.collections.f0;
import kotlin.collections.g0;
import kotlin.collections.o;
import kotlin.collections.r0;
import kotlin.collections.s0;
import kotlin.collections.u0;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.collections.z;
import kotlin.g1;
import kotlin.g2;
import kotlin.h2;
import kotlin.internal.f;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;
import kotlin.o2;
import kotlin.p1;
import kotlin.q2;
import kotlin.ranges.k;
import kotlin.s;
import kotlin.s1;
import kotlin.t;
import kotlin.t0;
import kotlin.t1;
import kotlin.w1;
import kotlin.x1;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class c extends kotlin.collections.unsigned.b {

    static final class a extends n0 implements i5.a<Iterator<? extends w1>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f34626a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int[] iArr) {
            super(0);
            this.f34626a = iArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<w1> invoke() {
            return x1.t(this.f34626a);
        }
    }

    static final class b extends n0 implements i5.a<Iterator<? extends a2>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f34627a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long[] jArr) {
            super(0);
            this.f34627a = jArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<a2> invoke() {
            return b2.t(this.f34627a);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.unsigned.c$c, reason: collision with other inner class name */
    static final class C0427c extends n0 implements i5.a<Iterator<? extends s1>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f34628a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0427c(byte[] bArr) {
            super(0);
            this.f34628a = bArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<s1> invoke() {
            return t1.t(this.f34628a);
        }
    }

    static final class d extends n0 implements i5.a<Iterator<? extends g2>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ short[] f34629a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(short[] sArr) {
            super(0);
            this.f34629a = sArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<g2> invoke() {
            return h2.t(this.f34629a);
        }
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long A0(long[] component1) {
        l0.p(component1, "$this$component1");
        return b2.m(component1, 0);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte[] A1(byte[] copyOf, int i7) {
        l0.p(copyOf, "$this$copyOf");
        byte[] bArrCopyOf = Arrays.copyOf(copyOf, i7);
        l0.o(bArrCopyOf, "copyOf(this, newSize)");
        return t1.f(bArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<a2> A2(long[] filterIndexed, p<? super Integer, ? super a2, Boolean> predicate) {
        l0.p(filterIndexed, "$this$filterIndexed");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = b2.o(filterIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            long jM = b2.m(filterIndexed, i7);
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), a2.b(jM)).booleanValue()) {
                arrayList.add(a2.b(jM));
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R, C extends Collection<? super R>> C A3(byte[] flatMapIndexedTo, C destination, p<? super Integer, ? super s1, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapIndexedTo, "$this$flatMapIndexedTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = t1.o(flatMapIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), s1.b(t1.m(flatMapIndexedTo, i7))));
            i7++;
            i8++;
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @e
    public static final w1 A4(@a7.d int[] getOrNull, int i7) {
        l0.p(getOrNull, "$this$getOrNull");
        if (i7 < 0 || i7 > kotlin.collections.p.Ve(getOrNull)) {
            return null;
        }
        return w1.b(x1.m(getOrNull, i7));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> A5(int[] map, l<? super w1, ? extends R> transform) {
        l0.p(map, "$this$map");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(x1.o(map));
        int iO = x1.o(map);
        for (int i7 = 0; i7 < iO; i7++) {
            arrayList.add(transform.z(w1.b(x1.m(map, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R A6(short[] maxOfWithOrNull, Comparator<? super R> comparator, l<? super g2, ? extends R> selector) {
        l0.p(maxOfWithOrNull, "$this$maxOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (h2.s(maxOfWithOrNull)) {
            return null;
        }
        R rZ = selector.z(g2.b(h2.m(maxOfWithOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Ye(maxOfWithOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(g2.b(h2.m(maxOfWithOrNull, it.b())));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R A7(short[] minOfWith, Comparator<? super R> comparator, l<? super g2, ? extends R> selector) {
        l0.p(minOfWith, "$this$minOfWith");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (h2.s(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(g2.b(h2.m(minOfWith, 0)));
        u0 it = new k(1, kotlin.collections.p.Ye(minOfWith)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(g2.b(h2.m(minOfWith, it.b())));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte A8(byte[] random) {
        l0.p(random, "$this$random");
        return D8(random, kotlin.random.f.f34998a);
    }

    @g1(version = "1.4")
    @t
    @f
    private static final void A9(int[] reverse, int i7, int i8) {
        l0.p(reverse, "$this$reverse");
        kotlin.collections.p.zr(reverse, i7, i8);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final s1 Aa(byte[] singleOrNull, l<? super s1, Boolean> predicate) {
        l0.p(singleOrNull, "$this$singleOrNull");
        l0.p(predicate, "predicate");
        int iO = t1.o(singleOrNull);
        s1 s1VarB = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(singleOrNull, i7);
            if (predicate.z(s1.b(bM)).booleanValue()) {
                if (z7) {
                    return null;
                }
                s1VarB = s1.b(bM);
                z7 = true;
            }
        }
        if (z7) {
            return s1VarB;
        }
        return null;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final long[] Ab(@a7.d long[] sortedArrayDescending) {
        l0.p(sortedArrayDescending, "$this$sortedArrayDescending");
        if (b2.s(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        l0.o(jArrCopyOf, "copyOf(this, size)");
        long[] jArrF = b2.f(jArrCopyOf);
        nb(jArrF);
        return jArrF;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<w1> Ac(int[] takeLastWhile, l<? super w1, Boolean> predicate) {
        l0.p(takeLastWhile, "$this$takeLastWhile");
        l0.p(predicate, "predicate");
        for (int iVe = kotlin.collections.p.Ve(takeLastWhile); -1 < iVe; iVe--) {
            if (!predicate.z(w1.b(x1.m(takeLastWhile, iVe))).booleanValue()) {
                return Q1(takeLastWhile, iVe + 1);
            }
        }
        return g0.Q5(x1.b(takeLastWhile));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short B0(short[] component1) {
        l0.p(component1, "$this$component1");
        return h2.m(component1, 0);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long[] B1(long[] copyOf) {
        l0.p(copyOf, "$this$copyOf");
        long[] jArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        l0.o(jArrCopyOf, "copyOf(this, size)");
        return b2.f(jArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<g2> B2(short[] filterIndexed, p<? super Integer, ? super g2, Boolean> predicate) {
        l0.p(filterIndexed, "$this$filterIndexed");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = h2.o(filterIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            short sM = h2.m(filterIndexed, i7);
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), g2.b(sM)).booleanValue()) {
                arrayList.add(g2.b(sM));
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R, C extends Collection<? super R>> C B3(long[] flatMapIndexedTo, C destination, p<? super Integer, ? super a2, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapIndexedTo, "$this$flatMapIndexedTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = b2.o(flatMapIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), a2.b(b2.m(flatMapIndexedTo, i7))));
            i7++;
            i8++;
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @e
    public static final a2 B4(@a7.d long[] getOrNull, int i7) {
        l0.p(getOrNull, "$this$getOrNull");
        if (i7 < 0 || i7 > kotlin.collections.p.We(getOrNull)) {
            return null;
        }
        return a2.b(b2.m(getOrNull, i7));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> B5(short[] map, l<? super g2, ? extends R> transform) {
        l0.p(map, "$this$map");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(h2.o(map));
        int iO = h2.o(map);
        for (int i7 = 0; i7 < iO; i7++) {
            arrayList.add(transform.z(g2.b(h2.m(map, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R B6(int[] maxOfWithOrNull, Comparator<? super R> comparator, l<? super w1, ? extends R> selector) {
        l0.p(maxOfWithOrNull, "$this$maxOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (x1.s(maxOfWithOrNull)) {
            return null;
        }
        R rZ = selector.z(w1.b(x1.m(maxOfWithOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Ve(maxOfWithOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(w1.b(x1.m(maxOfWithOrNull, it.b())));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R B7(int[] minOfWith, Comparator<? super R> comparator, l<? super w1, ? extends R> selector) {
        l0.p(minOfWith, "$this$minOfWith");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (x1.s(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(w1.b(x1.m(minOfWith, 0)));
        u0 it = new k(1, kotlin.collections.p.Ve(minOfWith)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(w1.b(x1.m(minOfWith, it.b())));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    public static final long B8(@a7.d long[] random, @a7.d kotlin.random.f random2) {
        l0.p(random, "$this$random");
        l0.p(random2, "random");
        if (b2.s(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return b2.m(random, random2.m(b2.o(random)));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void B9(short[] reverse) {
        l0.p(reverse, "$this$reverse");
        kotlin.collections.p.Er(reverse);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final a2 Ba(long[] singleOrNull, l<? super a2, Boolean> predicate) {
        l0.p(singleOrNull, "$this$singleOrNull");
        l0.p(predicate, "predicate");
        int iO = b2.o(singleOrNull);
        a2 a2VarB = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(singleOrNull, i7);
            if (predicate.z(a2.b(jM)).booleanValue()) {
                if (z7) {
                    return null;
                }
                a2VarB = a2.b(jM);
                z7 = true;
            }
        }
        if (z7) {
            return a2VarB;
        }
        return null;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final short[] Bb(@a7.d short[] sortedArrayDescending) {
        l0.p(sortedArrayDescending, "$this$sortedArrayDescending");
        if (h2.s(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        l0.o(sArrCopyOf, "copyOf(this, size)");
        short[] sArrF = h2.f(sArrCopyOf);
        pb(sArrF);
        return sArrF;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<g2> Bc(short[] takeLastWhile, l<? super g2, Boolean> predicate) {
        l0.p(takeLastWhile, "$this$takeLastWhile");
        l0.p(predicate, "predicate");
        for (int iYe = kotlin.collections.p.Ye(takeLastWhile); -1 < iYe; iYe--) {
            if (!predicate.z(g2.b(h2.m(takeLastWhile, iYe))).booleanValue()) {
                return P1(takeLastWhile, iYe + 1);
            }
        }
        return g0.Q5(h2.b(takeLastWhile));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int C0(int[] component2) {
        l0.p(component2, "$this$component2");
        return x1.m(component2, 1);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short[] C1(short[] copyOf, int i7) {
        l0.p(copyOf, "$this$copyOf");
        short[] sArrCopyOf = Arrays.copyOf(copyOf, i7);
        l0.o(sArrCopyOf, "copyOf(this, newSize)");
        return h2.f(sArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super w1>> C C2(int[] filterIndexedTo, C destination, p<? super Integer, ? super w1, Boolean> predicate) {
        l0.p(filterIndexedTo, "$this$filterIndexedTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = x1.o(filterIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            int iM = x1.m(filterIndexedTo, i7);
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), w1.b(iM)).booleanValue()) {
                destination.add(w1.b(iM));
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C C3(long[] flatMapTo, C destination, l<? super a2, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapTo, "$this$flatMapTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = b2.o(flatMapTo);
        for (int i7 = 0; i7 < iO; i7++) {
            d0.o0(destination, transform.z(a2.b(b2.m(flatMapTo, i7))));
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K, V> Map<K, List<V>> C4(long[] groupBy, l<? super a2, ? extends K> keySelector, l<? super a2, ? extends V> valueTransform) {
        l0.p(groupBy, "$this$groupBy");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = b2.o(groupBy);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(groupBy, i7);
            K kZ = keySelector.z(a2.b(jM));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(a2.b(jM)));
        }
        return linkedHashMap;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> C5(byte[] mapIndexed, p<? super Integer, ? super s1, ? extends R> transform) {
        l0.p(mapIndexed, "$this$mapIndexed");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(t1.o(mapIndexed));
        int iO = t1.o(mapIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            arrayList.add(transform.a0(Integer.valueOf(i8), s1.b(t1.m(mapIndexed, i7))));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final w1 C6(@a7.d int[] maxOrNull) {
        l0.p(maxOrNull, "$this$maxOrNull");
        if (x1.s(maxOrNull)) {
            return null;
        }
        int iM = x1.m(maxOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(maxOrNull)).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(maxOrNull, it.b());
            if (o2.c(iM, iM2) < 0) {
                iM = iM2;
            }
        }
        return w1.b(iM);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R C7(long[] minOfWithOrNull, Comparator<? super R> comparator, l<? super a2, ? extends R> selector) {
        l0.p(minOfWithOrNull, "$this$minOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (b2.s(minOfWithOrNull)) {
            return null;
        }
        R rZ = selector.z(a2.b(b2.m(minOfWithOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.We(minOfWithOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(a2.b(b2.m(minOfWithOrNull, it.b())));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long C8(long[] random) {
        l0.p(random, "$this$random");
        return B8(random, kotlin.random.f.f34998a);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<w1> C9(@a7.d int[] reversed) {
        l0.p(reversed, "$this$reversed");
        if (x1.s(reversed)) {
            return y.F();
        }
        List<w1> listT5 = g0.T5(x1.b(reversed));
        f0.m1(listT5);
        return listT5;
    }

    @g1(version = "1.3")
    @t
    @e
    public static final a2 Ca(@a7.d long[] singleOrNull) {
        l0.p(singleOrNull, "$this$singleOrNull");
        if (b2.o(singleOrNull) == 1) {
            return a2.b(b2.m(singleOrNull, 0));
        }
        return null;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<w1> Cb(@a7.d int[] sortedDescending) {
        l0.p(sortedDescending, "$this$sortedDescending");
        int[] iArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        l0.o(iArrCopyOf, "copyOf(this, size)");
        int[] iArrF = x1.f(iArrCopyOf);
        Wa(iArrF);
        return C9(iArrF);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<s1> Cc(byte[] takeWhile, l<? super s1, Boolean> predicate) {
        l0.p(takeWhile, "$this$takeWhile");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = t1.o(takeWhile);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(takeWhile, i7);
            if (!predicate.z(s1.b(bM)).booleanValue()) {
                break;
            }
            arrayList.add(s1.b(bM));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte D0(byte[] component2) {
        l0.p(component2, "$this$component2");
        return t1.m(component2, 1);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int[] D1(int[] copyOf, int i7) {
        l0.p(copyOf, "$this$copyOf");
        int[] iArrCopyOf = Arrays.copyOf(copyOf, i7);
        l0.o(iArrCopyOf, "copyOf(this, newSize)");
        return x1.f(iArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super g2>> C D2(short[] filterIndexedTo, C destination, p<? super Integer, ? super g2, Boolean> predicate) {
        l0.p(filterIndexedTo, "$this$filterIndexedTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = h2.o(filterIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            short sM = h2.m(filterIndexedTo, i7);
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), g2.b(sM)).booleanValue()) {
                destination.add(g2.b(sM));
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C D3(short[] flatMapTo, C destination, l<? super g2, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapTo, "$this$flatMapTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = h2.o(flatMapTo);
        for (int i7 = 0; i7 < iO; i7++) {
            d0.o0(destination, transform.z(g2.b(h2.m(flatMapTo, i7))));
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K, V> Map<K, List<V>> D4(short[] groupBy, l<? super g2, ? extends K> keySelector, l<? super g2, ? extends V> valueTransform) {
        l0.p(groupBy, "$this$groupBy");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = h2.o(groupBy);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(groupBy, i7);
            K kZ = keySelector.z(g2.b(sM));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(g2.b(sM)));
        }
        return linkedHashMap;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> D5(int[] mapIndexed, p<? super Integer, ? super w1, ? extends R> transform) {
        l0.p(mapIndexed, "$this$mapIndexed");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(x1.o(mapIndexed));
        int iO = x1.o(mapIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            arrayList.add(transform.a0(Integer.valueOf(i8), w1.b(x1.m(mapIndexed, i7))));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final s1 D6(@a7.d byte[] maxOrNull) {
        l0.p(maxOrNull, "$this$maxOrNull");
        if (t1.s(maxOrNull)) {
            return null;
        }
        byte bM = t1.m(maxOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Re(maxOrNull)).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(maxOrNull, it.b());
            if (l0.t(bM & 255, bM2 & 255) < 0) {
                bM = bM2;
            }
        }
        return s1.b(bM);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R D7(byte[] minOfWithOrNull, Comparator<? super R> comparator, l<? super s1, ? extends R> selector) {
        l0.p(minOfWithOrNull, "$this$minOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (t1.s(minOfWithOrNull)) {
            return null;
        }
        R rZ = selector.z(s1.b(t1.m(minOfWithOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Re(minOfWithOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(s1.b(t1.m(minOfWithOrNull, it.b())));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    public static final byte D8(@a7.d byte[] random, @a7.d kotlin.random.f random2) {
        l0.p(random, "$this$random");
        l0.p(random2, "random");
        if (t1.s(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return t1.m(random, random2.m(t1.o(random)));
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<s1> D9(@a7.d byte[] reversed) {
        l0.p(reversed, "$this$reversed");
        if (t1.s(reversed)) {
            return y.F();
        }
        List<s1> listT5 = g0.T5(t1.b(reversed));
        f0.m1(listT5);
        return listT5;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final w1 Da(int[] singleOrNull, l<? super w1, Boolean> predicate) {
        l0.p(singleOrNull, "$this$singleOrNull");
        l0.p(predicate, "predicate");
        int iO = x1.o(singleOrNull);
        w1 w1VarB = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(singleOrNull, i7);
            if (predicate.z(w1.b(iM)).booleanValue()) {
                if (z7) {
                    return null;
                }
                w1VarB = w1.b(iM);
                z7 = true;
            }
        }
        if (z7) {
            return w1VarB;
        }
        return null;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<s1> Db(@a7.d byte[] sortedDescending) {
        l0.p(sortedDescending, "$this$sortedDescending");
        byte[] bArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        l0.o(bArrCopyOf, "copyOf(this, size)");
        byte[] bArrF = t1.f(bArrCopyOf);
        db(bArrF);
        return D9(bArrF);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<a2> Dc(long[] takeWhile, l<? super a2, Boolean> predicate) {
        l0.p(takeWhile, "$this$takeWhile");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = b2.o(takeWhile);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(takeWhile, i7);
            if (!predicate.z(a2.b(jM)).booleanValue()) {
                break;
            }
            arrayList.add(a2.b(jM));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long E0(long[] component2) {
        l0.p(component2, "$this$component2");
        return b2.m(component2, 1);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long[] E1(long[] copyOf, int i7) {
        l0.p(copyOf, "$this$copyOf");
        long[] jArrCopyOf = Arrays.copyOf(copyOf, i7);
        l0.o(jArrCopyOf, "copyOf(this, newSize)");
        return b2.f(jArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super s1>> C E2(byte[] filterIndexedTo, C destination, p<? super Integer, ? super s1, Boolean> predicate) {
        l0.p(filterIndexedTo, "$this$filterIndexedTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = t1.o(filterIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            byte bM = t1.m(filterIndexedTo, i7);
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), s1.b(bM)).booleanValue()) {
                destination.add(s1.b(bM));
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C E3(int[] flatMapTo, C destination, l<? super w1, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapTo, "$this$flatMapTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = x1.o(flatMapTo);
        for (int i7 = 0; i7 < iO; i7++) {
            d0.o0(destination, transform.z(w1.b(x1.m(flatMapTo, i7))));
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K> Map<K, List<s1>> E4(byte[] groupBy, l<? super s1, ? extends K> keySelector) {
        l0.p(groupBy, "$this$groupBy");
        l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = t1.o(groupBy);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(groupBy, i7);
            K kZ = keySelector.z(s1.b(bM));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(s1.b(bM));
        }
        return linkedHashMap;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> E5(long[] mapIndexed, p<? super Integer, ? super a2, ? extends R> transform) {
        l0.p(mapIndexed, "$this$mapIndexed");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(b2.o(mapIndexed));
        int iO = b2.o(mapIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            arrayList.add(transform.a0(Integer.valueOf(i8), a2.b(b2.m(mapIndexed, i7))));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final a2 E6(@a7.d long[] maxOrNull) {
        l0.p(maxOrNull, "$this$maxOrNull");
        if (b2.s(maxOrNull)) {
            return null;
        }
        long jM = b2.m(maxOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.We(maxOrNull)).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(maxOrNull, it.b());
            if (o2.g(jM, jM2) < 0) {
                jM = jM2;
            }
        }
        return a2.b(jM);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R E7(short[] minOfWithOrNull, Comparator<? super R> comparator, l<? super g2, ? extends R> selector) {
        l0.p(minOfWithOrNull, "$this$minOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (h2.s(minOfWithOrNull)) {
            return null;
        }
        R rZ = selector.z(g2.b(h2.m(minOfWithOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Ye(minOfWithOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(g2.b(h2.m(minOfWithOrNull, it.b())));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short E8(short[] random) {
        l0.p(random, "$this$random");
        return F8(random, kotlin.random.f.f34998a);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<a2> E9(@a7.d long[] reversed) {
        l0.p(reversed, "$this$reversed");
        if (b2.s(reversed)) {
            return y.F();
        }
        List<a2> listT5 = g0.T5(b2.b(reversed));
        f0.m1(listT5);
        return listT5;
    }

    @g1(version = "1.3")
    @t
    @e
    public static final g2 Ea(@a7.d short[] singleOrNull) {
        l0.p(singleOrNull, "$this$singleOrNull");
        if (h2.o(singleOrNull) == 1) {
            return g2.b(h2.m(singleOrNull, 0));
        }
        return null;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<a2> Eb(@a7.d long[] sortedDescending) {
        l0.p(sortedDescending, "$this$sortedDescending");
        long[] jArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        l0.o(jArrCopyOf, "copyOf(this, size)");
        long[] jArrF = b2.f(jArrCopyOf);
        eb(jArrF);
        return E9(jArrF);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<w1> Ec(int[] takeWhile, l<? super w1, Boolean> predicate) {
        l0.p(takeWhile, "$this$takeWhile");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = x1.o(takeWhile);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(takeWhile, i7);
            if (!predicate.z(w1.b(iM)).booleanValue()) {
                break;
            }
            arrayList.add(w1.b(iM));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short F0(short[] component2) {
        l0.p(component2, "$this$component2");
        return h2.m(component2, 1);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short[] F1(short[] copyOf) {
        l0.p(copyOf, "$this$copyOf");
        short[] sArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        l0.o(sArrCopyOf, "copyOf(this, size)");
        return h2.f(sArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super a2>> C F2(long[] filterIndexedTo, C destination, p<? super Integer, ? super a2, Boolean> predicate) {
        l0.p(filterIndexedTo, "$this$filterIndexedTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = b2.o(filterIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            long jM = b2.m(filterIndexedTo, i7);
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), a2.b(jM)).booleanValue()) {
                destination.add(a2.b(jM));
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C F3(byte[] flatMapTo, C destination, l<? super s1, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapTo, "$this$flatMapTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = t1.o(flatMapTo);
        for (int i7 = 0; i7 < iO; i7++) {
            d0.o0(destination, transform.z(s1.b(t1.m(flatMapTo, i7))));
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K, V> Map<K, List<V>> F4(int[] groupBy, l<? super w1, ? extends K> keySelector, l<? super w1, ? extends V> valueTransform) {
        l0.p(groupBy, "$this$groupBy");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = x1.o(groupBy);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(groupBy, i7);
            K kZ = keySelector.z(w1.b(iM));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(w1.b(iM)));
        }
        return linkedHashMap;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> F5(short[] mapIndexed, p<? super Integer, ? super g2, ? extends R> transform) {
        l0.p(mapIndexed, "$this$mapIndexed");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(h2.o(mapIndexed));
        int iO = h2.o(mapIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            arrayList.add(transform.a0(Integer.valueOf(i8), g2.b(h2.m(mapIndexed, i7))));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final g2 F6(@a7.d short[] maxOrNull) {
        l0.p(maxOrNull, "$this$maxOrNull");
        if (h2.s(maxOrNull)) {
            return null;
        }
        short sM = h2.m(maxOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(maxOrNull)).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(maxOrNull, it.b());
            if (l0.t(sM & g2.f34732d, 65535 & sM2) < 0) {
                sM = sM2;
            }
        }
        return g2.b(sM);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R F7(int[] minOfWithOrNull, Comparator<? super R> comparator, l<? super w1, ? extends R> selector) {
        l0.p(minOfWithOrNull, "$this$minOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (x1.s(minOfWithOrNull)) {
            return null;
        }
        R rZ = selector.z(w1.b(x1.m(minOfWithOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Ve(minOfWithOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(w1.b(x1.m(minOfWithOrNull, it.b())));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    public static final short F8(@a7.d short[] random, @a7.d kotlin.random.f random2) {
        l0.p(random, "$this$random");
        l0.p(random2, "random");
        if (h2.s(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return h2.m(random, random2.m(h2.o(random)));
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<g2> F9(@a7.d short[] reversed) {
        l0.p(reversed, "$this$reversed");
        if (h2.s(reversed)) {
            return y.F();
        }
        List<g2> listT5 = g0.T5(h2.b(reversed));
        f0.m1(listT5);
        return listT5;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final g2 Fa(short[] singleOrNull, l<? super g2, Boolean> predicate) {
        l0.p(singleOrNull, "$this$singleOrNull");
        l0.p(predicate, "predicate");
        int iO = h2.o(singleOrNull);
        g2 g2VarB = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(singleOrNull, i7);
            if (predicate.z(g2.b(sM)).booleanValue()) {
                if (z7) {
                    return null;
                }
                g2VarB = g2.b(sM);
                z7 = true;
            }
        }
        if (z7) {
            return g2VarB;
        }
        return null;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<g2> Fb(@a7.d short[] sortedDescending) {
        l0.p(sortedDescending, "$this$sortedDescending");
        short[] sArrCopyOf = Arrays.copyOf(sortedDescending, sortedDescending.length);
        l0.o(sArrCopyOf, "copyOf(this, size)");
        short[] sArrF = h2.f(sArrCopyOf);
        hb(sArrF);
        return F9(sArrF);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<g2> Fc(short[] takeWhile, l<? super g2, Boolean> predicate) {
        l0.p(takeWhile, "$this$takeWhile");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = h2.o(takeWhile);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(takeWhile, i7);
            if (!predicate.z(g2.b(sM)).booleanValue()) {
                break;
            }
            arrayList.add(g2.b(sM));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int G0(int[] component3) {
        l0.p(component3, "$this$component3");
        return x1.m(component3, 2);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long[] G1(long[] copyOfRange, int i7, int i8) {
        l0.p(copyOfRange, "$this$copyOfRange");
        return b2.f(o.L1(copyOfRange, i7, i8));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<s1> G2(byte[] filterNot, l<? super s1, Boolean> predicate) {
        l0.p(filterNot, "$this$filterNot");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = t1.o(filterNot);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(filterNot, i7);
            if (!predicate.z(s1.b(bM)).booleanValue()) {
                arrayList.add(s1.b(bM));
            }
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R G3(long[] fold, R r7, p<? super R, ? super a2, ? extends R> operation) {
        l0.p(fold, "$this$fold");
        l0.p(operation, "operation");
        int iO = b2.o(fold);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, a2.b(b2.m(fold, i7)));
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K> Map<K, List<a2>> G4(long[] groupBy, l<? super a2, ? extends K> keySelector) {
        l0.p(groupBy, "$this$groupBy");
        l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = b2.o(groupBy);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(groupBy, i7);
            K kZ = keySelector.z(a2.b(jM));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(a2.b(jM));
        }
        return linkedHashMap;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C G5(int[] mapIndexedTo, C destination, p<? super Integer, ? super w1, ? extends R> transform) {
        l0.p(mapIndexedTo, "$this$mapIndexedTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = x1.o(mapIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            destination.add(transform.a0(Integer.valueOf(i8), w1.b(x1.m(mapIndexedTo, i7))));
            i7++;
            i8++;
        }
        return destination;
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxOrThrow-U")
    public static final byte G6(@a7.d byte[] max) {
        l0.p(max, "$this$max");
        if (t1.s(max)) {
            throw new NoSuchElementException();
        }
        byte bM = t1.m(max, 0);
        u0 it = new k(1, kotlin.collections.p.Re(max)).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(max, it.b());
            if (l0.t(bM & 255, bM2 & 255) < 0) {
                bM = bM2;
            }
        }
        return bM;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final w1 G7(@a7.d int[] minOrNull) {
        l0.p(minOrNull, "$this$minOrNull");
        if (x1.s(minOrNull)) {
            return null;
        }
        int iM = x1.m(minOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(minOrNull)).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(minOrNull, it.b());
            if (o2.c(iM, iM2) > 0) {
                iM = iM2;
            }
        }
        return w1.b(iM);
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final w1 G8(int[] randomOrNull) {
        l0.p(randomOrNull, "$this$randomOrNull");
        return H8(randomOrNull, kotlin.random.f.f34998a);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int[] G9(int[] reversedArray) {
        l0.p(reversedArray, "$this$reversedArray");
        return x1.f(kotlin.collections.p.Vr(reversedArray));
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<a2> Ga(@a7.d long[] slice, @a7.d Iterable<Integer> indices) {
        l0.p(slice, "$this$slice");
        l0.p(indices, "indices");
        int iZ = z.Z(indices, 10);
        if (iZ == 0) {
            return y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(a2.b(b2.m(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int Gb(int[] sum) {
        l0.p(sum, "$this$sum");
        return w1.h(kotlin.collections.p.Bw(sum));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte[] Gc(byte[] toByteArray) {
        l0.p(toByteArray, "$this$toByteArray");
        byte[] bArrCopyOf = Arrays.copyOf(toByteArray, toByteArray.length);
        l0.o(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte H0(byte[] component3) {
        l0.p(component3, "$this$component3");
        return t1.m(component3, 2);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte[] H1(byte[] copyOfRange, int i7, int i8) {
        l0.p(copyOfRange, "$this$copyOfRange");
        return t1.f(o.G1(copyOfRange, i7, i8));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<a2> H2(long[] filterNot, l<? super a2, Boolean> predicate) {
        l0.p(filterNot, "$this$filterNot");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = b2.o(filterNot);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(filterNot, i7);
            if (!predicate.z(a2.b(jM)).booleanValue()) {
                arrayList.add(a2.b(jM));
            }
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R H3(byte[] fold, R r7, p<? super R, ? super s1, ? extends R> operation) {
        l0.p(fold, "$this$fold");
        l0.p(operation, "operation");
        int iO = t1.o(fold);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, s1.b(t1.m(fold, i7)));
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K, V> Map<K, List<V>> H4(byte[] groupBy, l<? super s1, ? extends K> keySelector, l<? super s1, ? extends V> valueTransform) {
        l0.p(groupBy, "$this$groupBy");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = t1.o(groupBy);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(groupBy, i7);
            K kZ = keySelector.z(s1.b(bM));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(s1.b(bM)));
        }
        return linkedHashMap;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C H5(short[] mapIndexedTo, C destination, p<? super Integer, ? super g2, ? extends R> transform) {
        l0.p(mapIndexedTo, "$this$mapIndexedTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = h2.o(mapIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            destination.add(transform.a0(Integer.valueOf(i8), g2.b(h2.m(mapIndexedTo, i7))));
            i7++;
            i8++;
        }
        return destination;
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxOrThrow-U")
    public static final int H6(@a7.d int[] max) {
        l0.p(max, "$this$max");
        if (x1.s(max)) {
            throw new NoSuchElementException();
        }
        int iM = x1.m(max, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(max)).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(max, it.b());
            if (o2.c(iM, iM2) < 0) {
                iM = iM2;
            }
        }
        return iM;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final s1 H7(@a7.d byte[] minOrNull) {
        l0.p(minOrNull, "$this$minOrNull");
        if (t1.s(minOrNull)) {
            return null;
        }
        byte bM = t1.m(minOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Re(minOrNull)).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(minOrNull, it.b());
            if (l0.t(bM & 255, bM2 & 255) > 0) {
                bM = bM2;
            }
        }
        return s1.b(bM);
    }

    @g1(version = "1.4")
    @t
    @e
    @q2(markerClass = {s.class})
    public static final w1 H8(@a7.d int[] randomOrNull, @a7.d kotlin.random.f random) {
        l0.p(randomOrNull, "$this$randomOrNull");
        l0.p(random, "random");
        if (x1.s(randomOrNull)) {
            return null;
        }
        return w1.b(x1.m(randomOrNull, random.m(x1.o(randomOrNull))));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte[] H9(byte[] reversedArray) {
        l0.p(reversedArray, "$this$reversedArray");
        return t1.f(kotlin.collections.p.Rr(reversedArray));
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<w1> Ha(@a7.d int[] slice, @a7.d Iterable<Integer> indices) {
        l0.p(slice, "$this$slice");
        l0.p(indices, "indices");
        int iZ = z.Z(indices, 10);
        if (iZ == 0) {
            return y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(w1.b(x1.m(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int Hb(byte[] sum) {
        l0.p(sum, "$this$sum");
        int iH = w1.h(0);
        int iO = t1.o(sum);
        for (int i7 = 0; i7 < iO; i7++) {
            iH = w1.h(iH + w1.h(t1.m(sum, i7) & 255));
        }
        return iH;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int[] Hc(int[] toIntArray) {
        l0.p(toIntArray, "$this$toIntArray");
        int[] iArrCopyOf = Arrays.copyOf(toIntArray, toIntArray.length);
        l0.o(iArrCopyOf, "copyOf(this, size)");
        return iArrCopyOf;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long I0(long[] component3) {
        l0.p(component3, "$this$component3");
        return b2.m(component3, 2);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short[] I1(short[] copyOfRange, int i7, int i8) {
        l0.p(copyOfRange, "$this$copyOfRange");
        return h2.f(o.N1(copyOfRange, i7, i8));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<w1> I2(int[] filterNot, l<? super w1, Boolean> predicate) {
        l0.p(filterNot, "$this$filterNot");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = x1.o(filterNot);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(filterNot, i7);
            if (!predicate.z(w1.b(iM)).booleanValue()) {
                arrayList.add(w1.b(iM));
            }
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R I3(int[] fold, R r7, p<? super R, ? super w1, ? extends R> operation) {
        l0.p(fold, "$this$fold");
        l0.p(operation, "operation");
        int iO = x1.o(fold);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, w1.b(x1.m(fold, i7)));
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K> Map<K, List<w1>> I4(int[] groupBy, l<? super w1, ? extends K> keySelector) {
        l0.p(groupBy, "$this$groupBy");
        l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = x1.o(groupBy);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(groupBy, i7);
            K kZ = keySelector.z(w1.b(iM));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(w1.b(iM));
        }
        return linkedHashMap;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C I5(byte[] mapIndexedTo, C destination, p<? super Integer, ? super s1, ? extends R> transform) {
        l0.p(mapIndexedTo, "$this$mapIndexedTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = t1.o(mapIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            destination.add(transform.a0(Integer.valueOf(i8), s1.b(t1.m(mapIndexedTo, i7))));
            i7++;
            i8++;
        }
        return destination;
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxOrThrow-U")
    public static final long I6(@a7.d long[] max) {
        l0.p(max, "$this$max");
        if (b2.s(max)) {
            throw new NoSuchElementException();
        }
        long jM = b2.m(max, 0);
        u0 it = new k(1, kotlin.collections.p.We(max)).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(max, it.b());
            if (o2.g(jM, jM2) < 0) {
                jM = jM2;
            }
        }
        return jM;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final a2 I7(@a7.d long[] minOrNull) {
        l0.p(minOrNull, "$this$minOrNull");
        if (b2.s(minOrNull)) {
            return null;
        }
        long jM = b2.m(minOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.We(minOrNull)).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(minOrNull, it.b());
            if (o2.g(jM, jM2) > 0) {
                jM = jM2;
            }
        }
        return a2.b(jM);
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final s1 I8(byte[] randomOrNull) {
        l0.p(randomOrNull, "$this$randomOrNull");
        return L8(randomOrNull, kotlin.random.f.f34998a);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long[] I9(long[] reversedArray) {
        l0.p(reversedArray, "$this$reversedArray");
        return b2.f(kotlin.collections.p.Wr(reversedArray));
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<g2> Ia(@a7.d short[] slice, @a7.d Iterable<Integer> indices) {
        l0.p(slice, "$this$slice");
        l0.p(indices, "indices");
        int iZ = z.Z(indices, 10);
        if (iZ == 0) {
            return y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(g2.b(h2.m(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long Ib(long[] sum) {
        l0.p(sum, "$this$sum");
        return a2.h(kotlin.collections.p.Dw(sum));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long[] Ic(long[] toLongArray) {
        l0.p(toLongArray, "$this$toLongArray");
        long[] jArrCopyOf = Arrays.copyOf(toLongArray, toLongArray.length);
        l0.o(jArrCopyOf, "copyOf(this, size)");
        return jArrCopyOf;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short J0(short[] component3) {
        l0.p(component3, "$this$component3");
        return h2.m(component3, 2);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int[] J1(int[] copyOfRange, int i7, int i8) {
        l0.p(copyOfRange, "$this$copyOfRange");
        return x1.f(o.K1(copyOfRange, i7, i8));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<g2> J2(short[] filterNot, l<? super g2, Boolean> predicate) {
        l0.p(filterNot, "$this$filterNot");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = h2.o(filterNot);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(filterNot, i7);
            if (!predicate.z(g2.b(sM)).booleanValue()) {
                arrayList.add(g2.b(sM));
            }
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R J3(short[] fold, R r7, p<? super R, ? super g2, ? extends R> operation) {
        l0.p(fold, "$this$fold");
        l0.p(operation, "operation");
        int iO = h2.o(fold);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, g2.b(h2.m(fold, i7)));
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K> Map<K, List<g2>> J4(short[] groupBy, l<? super g2, ? extends K> keySelector) {
        l0.p(groupBy, "$this$groupBy");
        l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int iO = h2.o(groupBy);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(groupBy, i7);
            K kZ = keySelector.z(g2.b(sM));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(g2.b(sM));
        }
        return linkedHashMap;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C J5(long[] mapIndexedTo, C destination, p<? super Integer, ? super a2, ? extends R> transform) {
        l0.p(mapIndexedTo, "$this$mapIndexedTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = b2.o(mapIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            destination.add(transform.a0(Integer.valueOf(i8), a2.b(b2.m(mapIndexedTo, i7))));
            i7++;
            i8++;
        }
        return destination;
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxOrThrow-U")
    public static final short J6(@a7.d short[] max) {
        l0.p(max, "$this$max");
        if (h2.s(max)) {
            throw new NoSuchElementException();
        }
        short sM = h2.m(max, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(max)).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(max, it.b());
            if (l0.t(sM & g2.f34732d, 65535 & sM2) < 0) {
                sM = sM2;
            }
        }
        return sM;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final g2 J7(@a7.d short[] minOrNull) {
        l0.p(minOrNull, "$this$minOrNull");
        if (h2.s(minOrNull)) {
            return null;
        }
        short sM = h2.m(minOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(minOrNull)).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(minOrNull, it.b());
            if (l0.t(sM & g2.f34732d, 65535 & sM2) > 0) {
                sM = sM2;
            }
        }
        return g2.b(sM);
    }

    @g1(version = "1.4")
    @t
    @e
    @q2(markerClass = {s.class})
    public static final a2 J8(@a7.d long[] randomOrNull, @a7.d kotlin.random.f random) {
        l0.p(randomOrNull, "$this$randomOrNull");
        l0.p(random, "random");
        if (b2.s(randomOrNull)) {
            return null;
        }
        return a2.b(b2.m(randomOrNull, random.m(b2.o(randomOrNull))));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short[] J9(short[] reversedArray) {
        l0.p(reversedArray, "$this$reversedArray");
        return h2.f(kotlin.collections.p.Yr(reversedArray));
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<s1> Ja(@a7.d byte[] slice, @a7.d Iterable<Integer> indices) {
        l0.p(slice, "$this$slice");
        l0.p(indices, "indices");
        int iZ = z.Z(indices, 10);
        if (iZ == 0) {
            return y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(s1.b(t1.m(slice, it.next().intValue())));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int Jb(short[] sum) {
        l0.p(sum, "$this$sum");
        int iH = w1.h(0);
        int iO = h2.o(sum);
        for (int i7 = 0; i7 < iO; i7++) {
            iH = w1.h(iH + w1.h(h2.m(sum, i7) & g2.f34732d));
        }
        return iH;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short[] Jc(short[] toShortArray) {
        l0.p(toShortArray, "$this$toShortArray");
        short[] sArrCopyOf = Arrays.copyOf(toShortArray, toShortArray.length);
        l0.o(sArrCopyOf, "copyOf(this, size)");
        return sArrCopyOf;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int K0(int[] component4) {
        l0.p(component4, "$this$component4");
        return x1.m(component4, 3);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int K1(byte[] count, l<? super s1, Boolean> predicate) {
        l0.p(count, "$this$count");
        l0.p(predicate, "predicate");
        int iO = t1.o(count);
        int i7 = 0;
        for (int i8 = 0; i8 < iO; i8++) {
            if (predicate.z(s1.b(t1.m(count, i8))).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super a2>> C K2(long[] filterNotTo, C destination, l<? super a2, Boolean> predicate) {
        l0.p(filterNotTo, "$this$filterNotTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = b2.o(filterNotTo);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(filterNotTo, i7);
            if (!predicate.z(a2.b(jM)).booleanValue()) {
                destination.add(a2.b(jM));
            }
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R K3(byte[] foldIndexed, R r7, q<? super Integer, ? super R, ? super s1, ? extends R> operation) {
        l0.p(foldIndexed, "$this$foldIndexed");
        l0.p(operation, "operation");
        int iO = t1.o(foldIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            r7 = operation.v(Integer.valueOf(i8), r7, s1.b(t1.m(foldIndexed, i7)));
            i7++;
            i8++;
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K, M extends Map<? super K, List<w1>>> M K4(int[] groupByTo, M destination, l<? super w1, ? extends K> keySelector) {
        l0.p(groupByTo, "$this$groupByTo");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        int iO = x1.o(groupByTo);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(groupByTo, i7);
            K kZ = keySelector.z(w1.b(iM));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(w1.b(iM));
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C K5(long[] mapTo, C destination, l<? super a2, ? extends R> transform) {
        l0.p(mapTo, "$this$mapTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = b2.o(mapTo);
        for (int i7 = 0; i7 < iO; i7++) {
            destination.add(transform.z(a2.b(b2.m(mapTo, i7))));
        }
        return destination;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final s1 K6(@a7.d byte[] maxWithOrNull, @a7.d Comparator<? super s1> comparator) {
        l0.p(maxWithOrNull, "$this$maxWithOrNull");
        l0.p(comparator, "comparator");
        if (t1.s(maxWithOrNull)) {
            return null;
        }
        byte bM = t1.m(maxWithOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Re(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(maxWithOrNull, it.b());
            if (comparator.compare(s1.b(bM), s1.b(bM2)) < 0) {
                bM = bM2;
            }
        }
        return s1.b(bM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "minOrThrow-U")
    public static final byte K7(@a7.d byte[] min) {
        l0.p(min, "$this$min");
        if (t1.s(min)) {
            throw new NoSuchElementException();
        }
        byte bM = t1.m(min, 0);
        u0 it = new k(1, kotlin.collections.p.Re(min)).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(min, it.b());
            if (l0.t(bM & 255, bM2 & 255) > 0) {
                bM = bM2;
            }
        }
        return bM;
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final a2 K8(long[] randomOrNull) {
        l0.p(randomOrNull, "$this$randomOrNull");
        return J8(randomOrNull, kotlin.random.f.f34998a);
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R> List<R> K9(long[] runningFold, R r7, p<? super R, ? super a2, ? extends R> operation) {
        l0.p(runningFold, "$this$runningFold");
        l0.p(operation, "operation");
        if (b2.s(runningFold)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(b2.o(runningFold) + 1);
        arrayList.add(r7);
        int iO = b2.o(runningFold);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, a2.b(b2.m(runningFold, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<g2> Ka(@a7.d short[] slice, @a7.d k indices) {
        l0.p(slice, "$this$slice");
        l0.p(indices, "indices");
        return indices.isEmpty() ? y.F() : kotlin.collections.unsigned.b.d(h2.f(o.N1(slice, indices.d().intValue(), indices.f().intValue() + 1)));
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @t
    @f
    private static final int Kb(byte[] sumBy, l<? super s1, w1> selector) {
        l0.p(sumBy, "$this$sumBy");
        l0.p(selector, "selector");
        int iO = t1.o(sumBy);
        int iH = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            iH = w1.h(iH + selector.z(s1.b(t1.m(sumBy, i7))).g0());
        }
        return iH;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final w1[] Kc(@a7.d int[] toTypedArray) {
        l0.p(toTypedArray, "$this$toTypedArray");
        int iO = x1.o(toTypedArray);
        w1[] w1VarArr = new w1[iO];
        for (int i7 = 0; i7 < iO; i7++) {
            w1VarArr[i7] = w1.b(x1.m(toTypedArray, i7));
        }
        return w1VarArr;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte L0(byte[] component4) {
        l0.p(component4, "$this$component4");
        return t1.m(component4, 3);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int L1(long[] count, l<? super a2, Boolean> predicate) {
        l0.p(count, "$this$count");
        l0.p(predicate, "predicate");
        int iO = b2.o(count);
        int i7 = 0;
        for (int i8 = 0; i8 < iO; i8++) {
            if (predicate.z(a2.b(b2.m(count, i8))).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super g2>> C L2(short[] filterNotTo, C destination, l<? super g2, Boolean> predicate) {
        l0.p(filterNotTo, "$this$filterNotTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = h2.o(filterNotTo);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(filterNotTo, i7);
            if (!predicate.z(g2.b(sM)).booleanValue()) {
                destination.add(g2.b(sM));
            }
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R L3(short[] foldIndexed, R r7, q<? super Integer, ? super R, ? super g2, ? extends R> operation) {
        l0.p(foldIndexed, "$this$foldIndexed");
        l0.p(operation, "operation");
        int iO = h2.o(foldIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            r7 = operation.v(Integer.valueOf(i8), r7, g2.b(h2.m(foldIndexed, i7)));
            i7++;
            i8++;
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K, M extends Map<? super K, List<s1>>> M L4(byte[] groupByTo, M destination, l<? super s1, ? extends K> keySelector) {
        l0.p(groupByTo, "$this$groupByTo");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        int iO = t1.o(groupByTo);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(groupByTo, i7);
            K kZ = keySelector.z(s1.b(bM));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(s1.b(bM));
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C L5(short[] mapTo, C destination, l<? super g2, ? extends R> transform) {
        l0.p(mapTo, "$this$mapTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = h2.o(mapTo);
        for (int i7 = 0; i7 < iO; i7++) {
            destination.add(transform.z(g2.b(h2.m(mapTo, i7))));
        }
        return destination;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final w1 L6(@a7.d int[] maxWithOrNull, @a7.d Comparator<? super w1> comparator) {
        l0.p(maxWithOrNull, "$this$maxWithOrNull");
        l0.p(comparator, "comparator");
        if (x1.s(maxWithOrNull)) {
            return null;
        }
        int iM = x1.m(maxWithOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(maxWithOrNull, it.b());
            if (comparator.compare(w1.b(iM), w1.b(iM2)) < 0) {
                iM = iM2;
            }
        }
        return w1.b(iM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "minOrThrow-U")
    public static final int L7(@a7.d int[] min) {
        l0.p(min, "$this$min");
        if (x1.s(min)) {
            throw new NoSuchElementException();
        }
        int iM = x1.m(min, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(min)).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(min, it.b());
            if (o2.c(iM, iM2) > 0) {
                iM = iM2;
            }
        }
        return iM;
    }

    @g1(version = "1.4")
    @t
    @e
    @q2(markerClass = {s.class})
    public static final s1 L8(@a7.d byte[] randomOrNull, @a7.d kotlin.random.f random) {
        l0.p(randomOrNull, "$this$randomOrNull");
        l0.p(random, "random");
        if (t1.s(randomOrNull)) {
            return null;
        }
        return s1.b(t1.m(randomOrNull, random.m(t1.o(randomOrNull))));
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R> List<R> L9(byte[] runningFold, R r7, p<? super R, ? super s1, ? extends R> operation) {
        l0.p(runningFold, "$this$runningFold");
        l0.p(operation, "operation");
        if (t1.s(runningFold)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(t1.o(runningFold) + 1);
        arrayList.add(r7);
        int iO = t1.o(runningFold);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, s1.b(t1.m(runningFold, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<a2> La(@a7.d long[] slice, @a7.d k indices) {
        l0.p(slice, "$this$slice");
        l0.p(indices, "indices");
        return indices.isEmpty() ? y.F() : kotlin.collections.unsigned.b.c(b2.f(o.L1(slice, indices.d().intValue(), indices.f().intValue() + 1)));
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @t
    @f
    private static final int Lb(long[] sumBy, l<? super a2, w1> selector) {
        l0.p(sumBy, "$this$sumBy");
        l0.p(selector, "selector");
        int iO = b2.o(sumBy);
        int iH = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            iH = w1.h(iH + selector.z(a2.b(b2.m(sumBy, i7))).g0());
        }
        return iH;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final s1[] Lc(@a7.d byte[] toTypedArray) {
        l0.p(toTypedArray, "$this$toTypedArray");
        int iO = t1.o(toTypedArray);
        s1[] s1VarArr = new s1[iO];
        for (int i7 = 0; i7 < iO; i7++) {
            s1VarArr[i7] = s1.b(t1.m(toTypedArray, i7));
        }
        return s1VarArr;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long M0(long[] component4) {
        l0.p(component4, "$this$component4");
        return b2.m(component4, 3);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int M1(int[] count, l<? super w1, Boolean> predicate) {
        l0.p(count, "$this$count");
        l0.p(predicate, "predicate");
        int iO = x1.o(count);
        int i7 = 0;
        for (int i8 = 0; i8 < iO; i8++) {
            if (predicate.z(w1.b(x1.m(count, i8))).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super w1>> C M2(int[] filterNotTo, C destination, l<? super w1, Boolean> predicate) {
        l0.p(filterNotTo, "$this$filterNotTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = x1.o(filterNotTo);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(filterNotTo, i7);
            if (!predicate.z(w1.b(iM)).booleanValue()) {
                destination.add(w1.b(iM));
            }
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R M3(long[] foldIndexed, R r7, q<? super Integer, ? super R, ? super a2, ? extends R> operation) {
        l0.p(foldIndexed, "$this$foldIndexed");
        l0.p(operation, "operation");
        int iO = b2.o(foldIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            r7 = operation.v(Integer.valueOf(i8), r7, a2.b(b2.m(foldIndexed, i7)));
            i7++;
            i8++;
        }
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.3")
    @t
    @f
    private static final <K, V, M extends Map<? super K, List<V>>> M M4(int[] groupByTo, M destination, l<? super w1, ? extends K> keySelector, l<? super w1, ? extends V> valueTransform) {
        l0.p(groupByTo, "$this$groupByTo");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        int iO = x1.o(groupByTo);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(groupByTo, i7);
            K kZ = keySelector.z(w1.b(iM));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(w1.b(iM)));
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C M5(int[] mapTo, C destination, l<? super w1, ? extends R> transform) {
        l0.p(mapTo, "$this$mapTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = x1.o(mapTo);
        for (int i7 = 0; i7 < iO; i7++) {
            destination.add(transform.z(w1.b(x1.m(mapTo, i7))));
        }
        return destination;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final g2 M6(@a7.d short[] maxWithOrNull, @a7.d Comparator<? super g2> comparator) {
        l0.p(maxWithOrNull, "$this$maxWithOrNull");
        l0.p(comparator, "comparator");
        if (h2.s(maxWithOrNull)) {
            return null;
        }
        short sM = h2.m(maxWithOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(maxWithOrNull, it.b());
            if (comparator.compare(g2.b(sM), g2.b(sM2)) < 0) {
                sM = sM2;
            }
        }
        return g2.b(sM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "minOrThrow-U")
    public static final long M7(@a7.d long[] min) {
        l0.p(min, "$this$min");
        if (b2.s(min)) {
            throw new NoSuchElementException();
        }
        long jM = b2.m(min, 0);
        u0 it = new k(1, kotlin.collections.p.We(min)).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(min, it.b());
            if (o2.g(jM, jM2) > 0) {
                jM = jM2;
            }
        }
        return jM;
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final g2 M8(short[] randomOrNull) {
        l0.p(randomOrNull, "$this$randomOrNull");
        return N8(randomOrNull, kotlin.random.f.f34998a);
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R> List<R> M9(int[] runningFold, R r7, p<? super R, ? super w1, ? extends R> operation) {
        l0.p(runningFold, "$this$runningFold");
        l0.p(operation, "operation");
        if (x1.s(runningFold)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(x1.o(runningFold) + 1);
        arrayList.add(r7);
        int iO = x1.o(runningFold);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, w1.b(x1.m(runningFold, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<s1> Ma(@a7.d byte[] slice, @a7.d k indices) {
        l0.p(slice, "$this$slice");
        l0.p(indices, "indices");
        return indices.isEmpty() ? y.F() : kotlin.collections.unsigned.b.b(t1.f(o.G1(slice, indices.d().intValue(), indices.f().intValue() + 1)));
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @t
    @f
    private static final int Mb(int[] sumBy, l<? super w1, w1> selector) {
        l0.p(sumBy, "$this$sumBy");
        l0.p(selector, "selector");
        int iO = x1.o(sumBy);
        int iH = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            iH = w1.h(iH + selector.z(w1.b(x1.m(sumBy, i7))).g0());
        }
        return iH;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final a2[] Mc(@a7.d long[] toTypedArray) {
        l0.p(toTypedArray, "$this$toTypedArray");
        int iO = b2.o(toTypedArray);
        a2[] a2VarArr = new a2[iO];
        for (int i7 = 0; i7 < iO; i7++) {
            a2VarArr[i7] = a2.b(b2.m(toTypedArray, i7));
        }
        return a2VarArr;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short N0(short[] component4) {
        l0.p(component4, "$this$component4");
        return h2.m(component4, 3);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int N1(short[] count, l<? super g2, Boolean> predicate) {
        l0.p(count, "$this$count");
        l0.p(predicate, "predicate");
        int iO = h2.o(count);
        int i7 = 0;
        for (int i8 = 0; i8 < iO; i8++) {
            if (predicate.z(g2.b(h2.m(count, i8))).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super s1>> C N2(byte[] filterNotTo, C destination, l<? super s1, Boolean> predicate) {
        l0.p(filterNotTo, "$this$filterNotTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = t1.o(filterNotTo);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(filterNotTo, i7);
            if (!predicate.z(s1.b(bM)).booleanValue()) {
                destination.add(s1.b(bM));
            }
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R N3(int[] foldIndexed, R r7, q<? super Integer, ? super R, ? super w1, ? extends R> operation) {
        l0.p(foldIndexed, "$this$foldIndexed");
        l0.p(operation, "operation");
        int iO = x1.o(foldIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            r7 = operation.v(Integer.valueOf(i8), r7, w1.b(x1.m(foldIndexed, i7)));
            i7++;
            i8++;
        }
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.3")
    @t
    @f
    private static final <K, V, M extends Map<? super K, List<V>>> M N4(long[] groupByTo, M destination, l<? super a2, ? extends K> keySelector, l<? super a2, ? extends V> valueTransform) {
        l0.p(groupByTo, "$this$groupByTo");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        int iO = b2.o(groupByTo);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(groupByTo, i7);
            K kZ = keySelector.z(a2.b(jM));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(a2.b(jM)));
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, C extends Collection<? super R>> C N5(byte[] mapTo, C destination, l<? super s1, ? extends R> transform) {
        l0.p(mapTo, "$this$mapTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = t1.o(mapTo);
        for (int i7 = 0; i7 < iO; i7++) {
            destination.add(transform.z(s1.b(t1.m(mapTo, i7))));
        }
        return destination;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final a2 N6(@a7.d long[] maxWithOrNull, @a7.d Comparator<? super a2> comparator) {
        l0.p(maxWithOrNull, "$this$maxWithOrNull");
        l0.p(comparator, "comparator");
        if (b2.s(maxWithOrNull)) {
            return null;
        }
        long jM = b2.m(maxWithOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.We(maxWithOrNull)).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(maxWithOrNull, it.b());
            if (comparator.compare(a2.b(jM), a2.b(jM2)) < 0) {
                jM = jM2;
            }
        }
        return a2.b(jM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "minOrThrow-U")
    public static final short N7(@a7.d short[] min) {
        l0.p(min, "$this$min");
        if (h2.s(min)) {
            throw new NoSuchElementException();
        }
        short sM = h2.m(min, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(min)).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(min, it.b());
            if (l0.t(sM & g2.f34732d, 65535 & sM2) > 0) {
                sM = sM2;
            }
        }
        return sM;
    }

    @g1(version = "1.4")
    @t
    @e
    @q2(markerClass = {s.class})
    public static final g2 N8(@a7.d short[] randomOrNull, @a7.d kotlin.random.f random) {
        l0.p(randomOrNull, "$this$randomOrNull");
        l0.p(random, "random");
        if (h2.s(randomOrNull)) {
            return null;
        }
        return g2.b(h2.m(randomOrNull, random.m(h2.o(randomOrNull))));
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R> List<R> N9(short[] runningFold, R r7, p<? super R, ? super g2, ? extends R> operation) {
        l0.p(runningFold, "$this$runningFold");
        l0.p(operation, "operation");
        if (h2.s(runningFold)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(h2.o(runningFold) + 1);
        arrayList.add(r7);
        int iO = h2.o(runningFold);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, g2.b(h2.m(runningFold, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<w1> Na(@a7.d int[] slice, @a7.d k indices) {
        l0.p(slice, "$this$slice");
        l0.p(indices, "indices");
        return indices.isEmpty() ? y.F() : kotlin.collections.unsigned.b.a(x1.f(o.K1(slice, indices.d().intValue(), indices.f().intValue() + 1)));
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @t
    @f
    private static final int Nb(short[] sumBy, l<? super g2, w1> selector) {
        l0.p(sumBy, "$this$sumBy");
        l0.p(selector, "selector");
        int iO = h2.o(sumBy);
        int iH = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            iH = w1.h(iH + selector.z(g2.b(h2.m(sumBy, i7))).g0());
        }
        return iH;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final g2[] Nc(@a7.d short[] toTypedArray) {
        l0.p(toTypedArray, "$this$toTypedArray");
        int iO = h2.o(toTypedArray);
        g2[] g2VarArr = new g2[iO];
        for (int i7 = 0; i7 < iO; i7++) {
            g2VarArr[i7] = g2.b(h2.m(toTypedArray, i7));
        }
        return g2VarArr;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int O0(int[] component5) {
        l0.p(component5, "$this$component5");
        return x1.m(component5, 4);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<s1> O1(@a7.d byte[] drop, int i7) {
        l0.p(drop, "$this$drop");
        if (i7 >= 0) {
            return uc(drop, kotlin.ranges.q.n(t1.o(drop) - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super a2>> C O2(long[] filterTo, C destination, l<? super a2, Boolean> predicate) {
        l0.p(filterTo, "$this$filterTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = b2.o(filterTo);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(filterTo, i7);
            if (predicate.z(a2.b(jM)).booleanValue()) {
                destination.add(a2.b(jM));
            }
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R O3(long[] foldRight, R r7, p<? super a2, ? super R, ? extends R> operation) {
        l0.p(foldRight, "$this$foldRight");
        l0.p(operation, "operation");
        for (int iWe = kotlin.collections.p.We(foldRight); iWe >= 0; iWe--) {
            r7 = operation.a0(a2.b(b2.m(foldRight, iWe)), r7);
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K, M extends Map<? super K, List<a2>>> M O4(long[] groupByTo, M destination, l<? super a2, ? extends K> keySelector) {
        l0.p(groupByTo, "$this$groupByTo");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        int iO = b2.o(groupByTo);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(groupByTo, i7);
            K kZ = keySelector.z(a2.b(jM));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(a2.b(jM));
        }
        return destination;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R extends Comparable<? super R>> s1 O5(byte[] maxByOrNull, l<? super s1, ? extends R> selector) {
        l0.p(maxByOrNull, "$this$maxByOrNull");
        l0.p(selector, "selector");
        if (t1.s(maxByOrNull)) {
            return null;
        }
        byte bM = t1.m(maxByOrNull, 0);
        int iRe = kotlin.collections.p.Re(maxByOrNull);
        if (iRe == 0) {
            return s1.b(bM);
        }
        R rZ = selector.z(s1.b(bM));
        u0 it = new k(1, iRe).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(maxByOrNull, it.b());
            R rZ2 = selector.z(s1.b(bM2));
            if (rZ.compareTo(rZ2) < 0) {
                bM = bM2;
                rZ = rZ2;
            }
        }
        return s1.b(bM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxWithOrThrow-U")
    public static final byte O6(@a7.d byte[] maxWith, @a7.d Comparator<? super s1> comparator) {
        l0.p(maxWith, "$this$maxWith");
        l0.p(comparator, "comparator");
        if (t1.s(maxWith)) {
            throw new NoSuchElementException();
        }
        byte bM = t1.m(maxWith, 0);
        u0 it = new k(1, kotlin.collections.p.Re(maxWith)).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(maxWith, it.b());
            if (comparator.compare(s1.b(bM), s1.b(bM2)) < 0) {
                bM = bM2;
            }
        }
        return bM;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final s1 O7(@a7.d byte[] minWithOrNull, @a7.d Comparator<? super s1> comparator) {
        l0.p(minWithOrNull, "$this$minWithOrNull");
        l0.p(comparator, "comparator");
        if (t1.s(minWithOrNull)) {
            return null;
        }
        byte bM = t1.m(minWithOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Re(minWithOrNull)).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(minWithOrNull, it.b());
            if (comparator.compare(s1.b(bM), s1.b(bM2)) > 0) {
                bM = bM2;
            }
        }
        return s1.b(bM);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte O8(byte[] reduce, p<? super s1, ? super s1, s1> operation) {
        l0.p(reduce, "$this$reduce");
        l0.p(operation, "operation");
        if (t1.s(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM = t1.m(reduce, 0);
        u0 it = new k(1, kotlin.collections.p.Re(reduce)).iterator();
        while (it.hasNext()) {
            bM = operation.a0(s1.b(bM), s1.b(t1.m(reduce, it.b()))).e0();
        }
        return bM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R> List<R> O9(byte[] runningFoldIndexed, R r7, q<? super Integer, ? super R, ? super s1, ? extends R> operation) {
        l0.p(runningFoldIndexed, "$this$runningFoldIndexed");
        l0.p(operation, "operation");
        if (t1.s(runningFoldIndexed)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(t1.o(runningFoldIndexed) + 1);
        arrayList.add(r7);
        int iO = t1.o(runningFoldIndexed);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, s1.b(t1.m(runningFoldIndexed, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final int[] Oa(@a7.d int[] sliceArray, @a7.d Collection<Integer> indices) {
        l0.p(sliceArray, "$this$sliceArray");
        l0.p(indices, "indices");
        return x1.f(kotlin.collections.p.Fu(sliceArray, indices));
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @t
    @f
    private static final double Ob(byte[] sumByDouble, l<? super s1, Double> selector) {
        l0.p(sumByDouble, "$this$sumByDouble");
        l0.p(selector, "selector");
        int iO = t1.o(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i7 = 0; i7 < iO; i7++) {
            dDoubleValue += selector.z(s1.b(t1.m(sumByDouble, i7))).doubleValue();
        }
        return dDoubleValue;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte[] Oc(byte[] bArr) {
        l0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        l0.o(bArrCopyOf, "copyOf(this, size)");
        return t1.f(bArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte P0(byte[] component5) {
        l0.p(component5, "$this$component5");
        return t1.m(component5, 4);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<g2> P1(@a7.d short[] drop, int i7) {
        l0.p(drop, "$this$drop");
        if (i7 >= 0) {
            return vc(drop, kotlin.ranges.q.n(h2.o(drop) - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super g2>> C P2(short[] filterTo, C destination, l<? super g2, Boolean> predicate) {
        l0.p(filterTo, "$this$filterTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = h2.o(filterTo);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(filterTo, i7);
            if (predicate.z(g2.b(sM)).booleanValue()) {
                destination.add(g2.b(sM));
            }
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R P3(byte[] foldRight, R r7, p<? super s1, ? super R, ? extends R> operation) {
        l0.p(foldRight, "$this$foldRight");
        l0.p(operation, "operation");
        for (int iRe = kotlin.collections.p.Re(foldRight); iRe >= 0; iRe--) {
            r7 = operation.a0(s1.b(t1.m(foldRight, iRe)), r7);
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <K, M extends Map<? super K, List<g2>>> M P4(short[] groupByTo, M destination, l<? super g2, ? extends K> keySelector) {
        l0.p(groupByTo, "$this$groupByTo");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        int iO = h2.o(groupByTo);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(groupByTo, i7);
            K kZ = keySelector.z(g2.b(sM));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(g2.b(sM));
        }
        return destination;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R extends Comparable<? super R>> a2 P5(long[] maxByOrNull, l<? super a2, ? extends R> selector) {
        l0.p(maxByOrNull, "$this$maxByOrNull");
        l0.p(selector, "selector");
        if (b2.s(maxByOrNull)) {
            return null;
        }
        long jM = b2.m(maxByOrNull, 0);
        int iWe = kotlin.collections.p.We(maxByOrNull);
        if (iWe == 0) {
            return a2.b(jM);
        }
        R rZ = selector.z(a2.b(jM));
        u0 it = new k(1, iWe).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(maxByOrNull, it.b());
            R rZ2 = selector.z(a2.b(jM2));
            if (rZ.compareTo(rZ2) < 0) {
                jM = jM2;
                rZ = rZ2;
            }
        }
        return a2.b(jM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxWithOrThrow-U")
    public static final int P6(@a7.d int[] maxWith, @a7.d Comparator<? super w1> comparator) {
        l0.p(maxWith, "$this$maxWith");
        l0.p(comparator, "comparator");
        if (x1.s(maxWith)) {
            throw new NoSuchElementException();
        }
        int iM = x1.m(maxWith, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(maxWith)).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(maxWith, it.b());
            if (comparator.compare(w1.b(iM), w1.b(iM2)) < 0) {
                iM = iM2;
            }
        }
        return iM;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final w1 P7(@a7.d int[] minWithOrNull, @a7.d Comparator<? super w1> comparator) {
        l0.p(minWithOrNull, "$this$minWithOrNull");
        l0.p(comparator, "comparator");
        if (x1.s(minWithOrNull)) {
            return null;
        }
        int iM = x1.m(minWithOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(minWithOrNull)).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(minWithOrNull, it.b());
            if (comparator.compare(w1.b(iM), w1.b(iM2)) > 0) {
                iM = iM2;
            }
        }
        return w1.b(iM);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int P8(int[] reduce, p<? super w1, ? super w1, w1> operation) {
        l0.p(reduce, "$this$reduce");
        l0.p(operation, "operation");
        if (x1.s(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM = x1.m(reduce, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(reduce)).iterator();
        while (it.hasNext()) {
            iM = operation.a0(w1.b(iM), w1.b(x1.m(reduce, it.b()))).g0();
        }
        return iM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R> List<R> P9(short[] runningFoldIndexed, R r7, q<? super Integer, ? super R, ? super g2, ? extends R> operation) {
        l0.p(runningFoldIndexed, "$this$runningFoldIndexed");
        l0.p(operation, "operation");
        if (h2.s(runningFoldIndexed)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(h2.o(runningFoldIndexed) + 1);
        arrayList.add(r7);
        int iO = h2.o(runningFoldIndexed);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, g2.b(h2.m(runningFoldIndexed, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final short[] Pa(@a7.d short[] sliceArray, @a7.d k indices) {
        l0.p(sliceArray, "$this$sliceArray");
        l0.p(indices, "indices");
        return h2.f(kotlin.collections.p.Mu(sliceArray, indices));
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @t
    @f
    private static final double Pb(long[] sumByDouble, l<? super a2, Double> selector) {
        l0.p(sumByDouble, "$this$sumByDouble");
        l0.p(selector, "selector");
        int iO = b2.o(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i7 = 0; i7 < iO; i7++) {
            dDoubleValue += selector.z(a2.b(b2.m(sumByDouble, i7))).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final byte[] Pc(@a7.d s1[] s1VarArr) {
        l0.p(s1VarArr, "<this>");
        int length = s1VarArr.length;
        byte[] bArr = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            bArr[i7] = s1VarArr[i7].e0();
        }
        return t1.f(bArr);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long Q0(long[] component5) {
        l0.p(component5, "$this$component5");
        return b2.m(component5, 4);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<w1> Q1(@a7.d int[] drop, int i7) {
        l0.p(drop, "$this$drop");
        if (i7 >= 0) {
            return wc(drop, kotlin.ranges.q.n(x1.o(drop) - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super w1>> C Q2(int[] filterTo, C destination, l<? super w1, Boolean> predicate) {
        l0.p(filterTo, "$this$filterTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = x1.o(filterTo);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(filterTo, i7);
            if (predicate.z(w1.b(iM)).booleanValue()) {
                destination.add(w1.b(iM));
            }
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R Q3(int[] foldRight, R r7, p<? super w1, ? super R, ? extends R> operation) {
        l0.p(foldRight, "$this$foldRight");
        l0.p(operation, "operation");
        for (int iVe = kotlin.collections.p.Ve(foldRight); iVe >= 0; iVe--) {
            r7 = operation.a0(w1.b(x1.m(foldRight, iVe)), r7);
        }
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.3")
    @t
    @f
    private static final <K, V, M extends Map<? super K, List<V>>> M Q4(short[] groupByTo, M destination, l<? super g2, ? extends K> keySelector, l<? super g2, ? extends V> valueTransform) {
        l0.p(groupByTo, "$this$groupByTo");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        int iO = h2.o(groupByTo);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(groupByTo, i7);
            K kZ = keySelector.z(g2.b(sM));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(g2.b(sM)));
        }
        return destination;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R extends Comparable<? super R>> w1 Q5(int[] maxByOrNull, l<? super w1, ? extends R> selector) {
        l0.p(maxByOrNull, "$this$maxByOrNull");
        l0.p(selector, "selector");
        if (x1.s(maxByOrNull)) {
            return null;
        }
        int iM = x1.m(maxByOrNull, 0);
        int iVe = kotlin.collections.p.Ve(maxByOrNull);
        if (iVe == 0) {
            return w1.b(iM);
        }
        R rZ = selector.z(w1.b(iM));
        u0 it = new k(1, iVe).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(maxByOrNull, it.b());
            R rZ2 = selector.z(w1.b(iM2));
            if (rZ.compareTo(rZ2) < 0) {
                iM = iM2;
                rZ = rZ2;
            }
        }
        return w1.b(iM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxWithOrThrow-U")
    public static final long Q6(@a7.d long[] maxWith, @a7.d Comparator<? super a2> comparator) {
        l0.p(maxWith, "$this$maxWith");
        l0.p(comparator, "comparator");
        if (b2.s(maxWith)) {
            throw new NoSuchElementException();
        }
        long jM = b2.m(maxWith, 0);
        u0 it = new k(1, kotlin.collections.p.We(maxWith)).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(maxWith, it.b());
            if (comparator.compare(a2.b(jM), a2.b(jM2)) < 0) {
                jM = jM2;
            }
        }
        return jM;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final g2 Q7(@a7.d short[] minWithOrNull, @a7.d Comparator<? super g2> comparator) {
        l0.p(minWithOrNull, "$this$minWithOrNull");
        l0.p(comparator, "comparator");
        if (h2.s(minWithOrNull)) {
            return null;
        }
        short sM = h2.m(minWithOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(minWithOrNull)).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(minWithOrNull, it.b());
            if (comparator.compare(g2.b(sM), g2.b(sM2)) > 0) {
                sM = sM2;
            }
        }
        return g2.b(sM);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long Q8(long[] reduce, p<? super a2, ? super a2, a2> operation) {
        l0.p(reduce, "$this$reduce");
        l0.p(operation, "operation");
        if (b2.s(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM = b2.m(reduce, 0);
        u0 it = new k(1, kotlin.collections.p.We(reduce)).iterator();
        while (it.hasNext()) {
            jM = operation.a0(a2.b(jM), a2.b(b2.m(reduce, it.b()))).g0();
        }
        return jM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R> List<R> Q9(long[] runningFoldIndexed, R r7, q<? super Integer, ? super R, ? super a2, ? extends R> operation) {
        l0.p(runningFoldIndexed, "$this$runningFoldIndexed");
        l0.p(operation, "operation");
        if (b2.s(runningFoldIndexed)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(b2.o(runningFoldIndexed) + 1);
        arrayList.add(r7);
        int iO = b2.o(runningFoldIndexed);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, a2.b(b2.m(runningFoldIndexed, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final long[] Qa(@a7.d long[] sliceArray, @a7.d k indices) {
        l0.p(sliceArray, "$this$sliceArray");
        l0.p(indices, "indices");
        return b2.f(kotlin.collections.p.Iu(sliceArray, indices));
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @t
    @f
    private static final double Qb(int[] sumByDouble, l<? super w1, Double> selector) {
        l0.p(sumByDouble, "$this$sumByDouble");
        l0.p(selector, "selector");
        int iO = x1.o(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i7 = 0; i7 < iO; i7++) {
            dDoubleValue += selector.z(w1.b(x1.m(sumByDouble, i7))).doubleValue();
        }
        return dDoubleValue;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int[] Qc(int[] iArr) {
        l0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        l0.o(iArrCopyOf, "copyOf(this, size)");
        return x1.f(iArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short R0(short[] component5) {
        l0.p(component5, "$this$component5");
        return h2.m(component5, 4);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<a2> R1(@a7.d long[] drop, int i7) {
        l0.p(drop, "$this$drop");
        if (i7 >= 0) {
            return xc(drop, kotlin.ranges.q.n(b2.o(drop) - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <C extends Collection<? super s1>> C R2(byte[] filterTo, C destination, l<? super s1, Boolean> predicate) {
        l0.p(filterTo, "$this$filterTo");
        l0.p(destination, "destination");
        l0.p(predicate, "predicate");
        int iO = t1.o(filterTo);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(filterTo, i7);
            if (predicate.z(s1.b(bM)).booleanValue()) {
                destination.add(s1.b(bM));
            }
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R R3(short[] foldRight, R r7, p<? super g2, ? super R, ? extends R> operation) {
        l0.p(foldRight, "$this$foldRight");
        l0.p(operation, "operation");
        for (int iYe = kotlin.collections.p.Ye(foldRight); iYe >= 0; iYe--) {
            r7 = operation.a0(g2.b(h2.m(foldRight, iYe)), r7);
        }
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.3")
    @t
    @f
    private static final <K, V, M extends Map<? super K, List<V>>> M R4(byte[] groupByTo, M destination, l<? super s1, ? extends K> keySelector, l<? super s1, ? extends V> valueTransform) {
        l0.p(groupByTo, "$this$groupByTo");
        l0.p(destination, "destination");
        l0.p(keySelector, "keySelector");
        l0.p(valueTransform, "valueTransform");
        int iO = t1.o(groupByTo);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(groupByTo, i7);
            K kZ = keySelector.z(s1.b(bM));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(s1.b(bM)));
        }
        return destination;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R extends Comparable<? super R>> g2 R5(short[] maxByOrNull, l<? super g2, ? extends R> selector) {
        l0.p(maxByOrNull, "$this$maxByOrNull");
        l0.p(selector, "selector");
        if (h2.s(maxByOrNull)) {
            return null;
        }
        short sM = h2.m(maxByOrNull, 0);
        int iYe = kotlin.collections.p.Ye(maxByOrNull);
        if (iYe == 0) {
            return g2.b(sM);
        }
        R rZ = selector.z(g2.b(sM));
        u0 it = new k(1, iYe).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(maxByOrNull, it.b());
            R rZ2 = selector.z(g2.b(sM2));
            if (rZ.compareTo(rZ2) < 0) {
                sM = sM2;
                rZ = rZ2;
            }
        }
        return g2.b(sM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxWithOrThrow-U")
    public static final short R6(@a7.d short[] maxWith, @a7.d Comparator<? super g2> comparator) {
        l0.p(maxWith, "$this$maxWith");
        l0.p(comparator, "comparator");
        if (h2.s(maxWith)) {
            throw new NoSuchElementException();
        }
        short sM = h2.m(maxWith, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(maxWith)).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(maxWith, it.b());
            if (comparator.compare(g2.b(sM), g2.b(sM2)) < 0) {
                sM = sM2;
            }
        }
        return sM;
    }

    @g1(version = "1.4")
    @t
    @e
    public static final a2 R7(@a7.d long[] minWithOrNull, @a7.d Comparator<? super a2> comparator) {
        l0.p(minWithOrNull, "$this$minWithOrNull");
        l0.p(comparator, "comparator");
        if (b2.s(minWithOrNull)) {
            return null;
        }
        long jM = b2.m(minWithOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.We(minWithOrNull)).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(minWithOrNull, it.b());
            if (comparator.compare(a2.b(jM), a2.b(jM2)) > 0) {
                jM = jM2;
            }
        }
        return a2.b(jM);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short R8(short[] reduce, p<? super g2, ? super g2, g2> operation) {
        l0.p(reduce, "$this$reduce");
        l0.p(operation, "operation");
        if (h2.s(reduce)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM = h2.m(reduce, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(reduce)).iterator();
        while (it.hasNext()) {
            sM = operation.a0(g2.b(sM), g2.b(h2.m(reduce, it.b()))).e0();
        }
        return sM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R> List<R> R9(int[] runningFoldIndexed, R r7, q<? super Integer, ? super R, ? super w1, ? extends R> operation) {
        l0.p(runningFoldIndexed, "$this$runningFoldIndexed");
        l0.p(operation, "operation");
        if (x1.s(runningFoldIndexed)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(x1.o(runningFoldIndexed) + 1);
        arrayList.add(r7);
        int iO = x1.o(runningFoldIndexed);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, w1.b(x1.m(runningFoldIndexed, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final byte[] Ra(@a7.d byte[] sliceArray, @a7.d k indices) {
        l0.p(sliceArray, "$this$sliceArray");
        l0.p(indices, "indices");
        return t1.f(kotlin.collections.p.yu(sliceArray, indices));
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use sumOf instead.", replaceWith = @b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    @t
    @f
    private static final double Rb(short[] sumByDouble, l<? super g2, Double> selector) {
        l0.p(sumByDouble, "$this$sumByDouble");
        l0.p(selector, "selector");
        int iO = h2.o(sumByDouble);
        double dDoubleValue = 0.0d;
        for (int i7 = 0; i7 < iO; i7++) {
            dDoubleValue += selector.z(g2.b(h2.m(sumByDouble, i7))).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final int[] Rc(@a7.d w1[] w1VarArr) {
        l0.p(w1VarArr, "<this>");
        int length = w1VarArr.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = w1VarArr[i7].g0();
        }
        return x1.f(iArr);
    }

    @g1(version = "1.4")
    @t
    public static boolean S0(@e short[] sArr, @e short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<s1> S1(@a7.d byte[] dropLast, int i7) {
        l0.p(dropLast, "$this$dropLast");
        if (i7 >= 0) {
            return qc(dropLast, kotlin.ranges.q.n(t1.o(dropLast) - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @g1(version = "1.3")
    @t
    @f
    private static final s1 S2(byte[] find, l<? super s1, Boolean> predicate) {
        l0.p(find, "$this$find");
        l0.p(predicate, "predicate");
        int iO = t1.o(find);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(find, i7);
            if (predicate.z(s1.b(bM)).booleanValue()) {
                return s1.b(bM);
            }
        }
        return null;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R S3(byte[] foldRightIndexed, R r7, q<? super Integer, ? super s1, ? super R, ? extends R> operation) {
        l0.p(foldRightIndexed, "$this$foldRightIndexed");
        l0.p(operation, "operation");
        for (int iRe = kotlin.collections.p.Re(foldRightIndexed); iRe >= 0; iRe--) {
            r7 = operation.v(Integer.valueOf(iRe), s1.b(t1.m(foldRightIndexed, iRe)), r7);
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int S4(long[] indexOf, long j7) {
        l0.p(indexOf, "$this$indexOf");
        return kotlin.collections.p.ig(indexOf, j7);
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxByOrThrow-U")
    @f
    private static final <R extends Comparable<? super R>> byte S5(byte[] maxBy, l<? super s1, ? extends R> selector) {
        l0.p(maxBy, "$this$maxBy");
        l0.p(selector, "selector");
        if (t1.s(maxBy)) {
            throw new NoSuchElementException();
        }
        byte bM = t1.m(maxBy, 0);
        int iRe = kotlin.collections.p.Re(maxBy);
        if (iRe == 0) {
            return bM;
        }
        R rZ = selector.z(s1.b(bM));
        u0 it = new k(1, iRe).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(maxBy, it.b());
            R rZ2 = selector.z(s1.b(bM2));
            if (rZ.compareTo(rZ2) < 0) {
                bM = bM2;
                rZ = rZ2;
            }
        }
        return bM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R extends Comparable<? super R>> s1 S6(byte[] minByOrNull, l<? super s1, ? extends R> selector) {
        l0.p(minByOrNull, "$this$minByOrNull");
        l0.p(selector, "selector");
        if (t1.s(minByOrNull)) {
            return null;
        }
        byte bM = t1.m(minByOrNull, 0);
        int iRe = kotlin.collections.p.Re(minByOrNull);
        if (iRe == 0) {
            return s1.b(bM);
        }
        R rZ = selector.z(s1.b(bM));
        u0 it = new k(1, iRe).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(minByOrNull, it.b());
            R rZ2 = selector.z(s1.b(bM2));
            if (rZ.compareTo(rZ2) > 0) {
                bM = bM2;
                rZ = rZ2;
            }
        }
        return s1.b(bM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "minWithOrThrow-U")
    public static final byte S7(@a7.d byte[] minWith, @a7.d Comparator<? super s1> comparator) {
        l0.p(minWith, "$this$minWith");
        l0.p(comparator, "comparator");
        if (t1.s(minWith)) {
            throw new NoSuchElementException();
        }
        byte bM = t1.m(minWith, 0);
        u0 it = new k(1, kotlin.collections.p.Re(minWith)).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(minWith, it.b());
            if (comparator.compare(s1.b(bM), s1.b(bM2)) > 0) {
                bM = bM2;
            }
        }
        return bM;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int S8(int[] reduceIndexed, q<? super Integer, ? super w1, ? super w1, w1> operation) {
        l0.p(reduceIndexed, "$this$reduceIndexed");
        l0.p(operation, "operation");
        if (x1.s(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM = x1.m(reduceIndexed, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(reduceIndexed)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            iM = operation.v(Integer.valueOf(iB), w1.b(iM), w1.b(x1.m(reduceIndexed, iB))).g0();
        }
        return iM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final List<s1> S9(byte[] runningReduce, p<? super s1, ? super s1, s1> operation) {
        l0.p(runningReduce, "$this$runningReduce");
        l0.p(operation, "operation");
        if (t1.s(runningReduce)) {
            return y.F();
        }
        byte bM = t1.m(runningReduce, 0);
        ArrayList arrayList = new ArrayList(t1.o(runningReduce));
        arrayList.add(s1.b(bM));
        int iO = t1.o(runningReduce);
        for (int i7 = 1; i7 < iO; i7++) {
            bM = operation.a0(s1.b(bM), s1.b(t1.m(runningReduce, i7))).e0();
            arrayList.add(s1.b(bM));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final long[] Sa(@a7.d long[] sliceArray, @a7.d Collection<Integer> indices) {
        l0.p(sliceArray, "$this$sliceArray");
        l0.p(indices, "indices");
        return b2.f(kotlin.collections.p.Hu(sliceArray, indices));
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfDouble")
    @t0
    @f
    private static final double Sb(byte[] sumOf, l<? super s1, Double> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = t1.o(sumOf);
        double dDoubleValue = 0.0d;
        for (int i7 = 0; i7 < iO; i7++) {
            dDoubleValue += selector.z(s1.b(t1.m(sumOf, i7))).doubleValue();
        }
        return dDoubleValue;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long[] Sc(long[] jArr) {
        l0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        l0.o(jArrCopyOf, "copyOf(this, size)");
        return b2.f(jArrCopyOf);
    }

    @g1(version = "1.4")
    @t
    public static boolean T0(@e int[] iArr, @e int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<g2> T1(@a7.d short[] dropLast, int i7) {
        l0.p(dropLast, "$this$dropLast");
        if (i7 >= 0) {
            return rc(dropLast, kotlin.ranges.q.n(h2.o(dropLast) - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @g1(version = "1.3")
    @t
    @f
    private static final a2 T2(long[] find, l<? super a2, Boolean> predicate) {
        l0.p(find, "$this$find");
        l0.p(predicate, "predicate");
        int iO = b2.o(find);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(find, i7);
            if (predicate.z(a2.b(jM)).booleanValue()) {
                return a2.b(jM);
            }
        }
        return null;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R T3(short[] foldRightIndexed, R r7, q<? super Integer, ? super g2, ? super R, ? extends R> operation) {
        l0.p(foldRightIndexed, "$this$foldRightIndexed");
        l0.p(operation, "operation");
        for (int iYe = kotlin.collections.p.Ye(foldRightIndexed); iYe >= 0; iYe--) {
            r7 = operation.v(Integer.valueOf(iYe), g2.b(h2.m(foldRightIndexed, iYe)), r7);
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int T4(short[] indexOf, short s7) {
        l0.p(indexOf, "$this$indexOf");
        return kotlin.collections.p.kg(indexOf, s7);
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxByOrThrow-U")
    @f
    private static final <R extends Comparable<? super R>> int T5(int[] maxBy, l<? super w1, ? extends R> selector) {
        l0.p(maxBy, "$this$maxBy");
        l0.p(selector, "selector");
        if (x1.s(maxBy)) {
            throw new NoSuchElementException();
        }
        int iM = x1.m(maxBy, 0);
        int iVe = kotlin.collections.p.Ve(maxBy);
        if (iVe == 0) {
            return iM;
        }
        R rZ = selector.z(w1.b(iM));
        u0 it = new k(1, iVe).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(maxBy, it.b());
            R rZ2 = selector.z(w1.b(iM2));
            if (rZ.compareTo(rZ2) < 0) {
                iM = iM2;
                rZ = rZ2;
            }
        }
        return iM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R extends Comparable<? super R>> a2 T6(long[] minByOrNull, l<? super a2, ? extends R> selector) {
        l0.p(minByOrNull, "$this$minByOrNull");
        l0.p(selector, "selector");
        if (b2.s(minByOrNull)) {
            return null;
        }
        long jM = b2.m(minByOrNull, 0);
        int iWe = kotlin.collections.p.We(minByOrNull);
        if (iWe == 0) {
            return a2.b(jM);
        }
        R rZ = selector.z(a2.b(jM));
        u0 it = new k(1, iWe).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(minByOrNull, it.b());
            R rZ2 = selector.z(a2.b(jM2));
            if (rZ.compareTo(rZ2) > 0) {
                jM = jM2;
                rZ = rZ2;
            }
        }
        return a2.b(jM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "minWithOrThrow-U")
    public static final int T7(@a7.d int[] minWith, @a7.d Comparator<? super w1> comparator) {
        l0.p(minWith, "$this$minWith");
        l0.p(comparator, "comparator");
        if (x1.s(minWith)) {
            throw new NoSuchElementException();
        }
        int iM = x1.m(minWith, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(minWith)).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(minWith, it.b());
            if (comparator.compare(w1.b(iM), w1.b(iM2)) > 0) {
                iM = iM2;
            }
        }
        return iM;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte T8(byte[] reduceIndexed, q<? super Integer, ? super s1, ? super s1, s1> operation) {
        l0.p(reduceIndexed, "$this$reduceIndexed");
        l0.p(operation, "operation");
        if (t1.s(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM = t1.m(reduceIndexed, 0);
        u0 it = new k(1, kotlin.collections.p.Re(reduceIndexed)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            bM = operation.v(Integer.valueOf(iB), s1.b(bM), s1.b(t1.m(reduceIndexed, iB))).e0();
        }
        return bM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final List<w1> T9(int[] runningReduce, p<? super w1, ? super w1, w1> operation) {
        l0.p(runningReduce, "$this$runningReduce");
        l0.p(operation, "operation");
        if (x1.s(runningReduce)) {
            return y.F();
        }
        int iM = x1.m(runningReduce, 0);
        ArrayList arrayList = new ArrayList(x1.o(runningReduce));
        arrayList.add(w1.b(iM));
        int iO = x1.o(runningReduce);
        for (int i7 = 1; i7 < iO; i7++) {
            iM = operation.a0(w1.b(iM), w1.b(x1.m(runningReduce, i7))).g0();
            arrayList.add(w1.b(iM));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final short[] Ta(@a7.d short[] sliceArray, @a7.d Collection<Integer> indices) {
        l0.p(sliceArray, "$this$sliceArray");
        l0.p(indices, "indices");
        return h2.f(kotlin.collections.p.Lu(sliceArray, indices));
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfDouble")
    @t0
    @f
    private static final double Tb(int[] sumOf, l<? super w1, Double> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = x1.o(sumOf);
        double dDoubleValue = 0.0d;
        for (int i7 = 0; i7 < iO; i7++) {
            dDoubleValue += selector.z(w1.b(x1.m(sumOf, i7))).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final long[] Tc(@a7.d a2[] a2VarArr) {
        l0.p(a2VarArr, "<this>");
        int length = a2VarArr.length;
        long[] jArr = new long[length];
        for (int i7 = 0; i7 < length; i7++) {
            jArr[i7] = a2VarArr[i7].g0();
        }
        return b2.f(jArr);
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ boolean U0(int[] contentEquals, int[] other) {
        l0.p(contentEquals, "$this$contentEquals");
        l0.p(other, "other");
        return T0(contentEquals, other);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<w1> U1(@a7.d int[] dropLast, int i7) {
        l0.p(dropLast, "$this$dropLast");
        if (i7 >= 0) {
            return sc(dropLast, kotlin.ranges.q.n(x1.o(dropLast) - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @g1(version = "1.3")
    @t
    @f
    private static final w1 U2(int[] find, l<? super w1, Boolean> predicate) {
        l0.p(find, "$this$find");
        l0.p(predicate, "predicate");
        int iO = x1.o(find);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(find, i7);
            if (predicate.z(w1.b(iM)).booleanValue()) {
                return w1.b(iM);
            }
        }
        return null;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R U3(long[] foldRightIndexed, R r7, q<? super Integer, ? super a2, ? super R, ? extends R> operation) {
        l0.p(foldRightIndexed, "$this$foldRightIndexed");
        l0.p(operation, "operation");
        for (int iWe = kotlin.collections.p.We(foldRightIndexed); iWe >= 0; iWe--) {
            r7 = operation.v(Integer.valueOf(iWe), a2.b(b2.m(foldRightIndexed, iWe)), r7);
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int U4(byte[] indexOf, byte b8) {
        l0.p(indexOf, "$this$indexOf");
        return kotlin.collections.p.dg(indexOf, b8);
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxByOrThrow-U")
    @f
    private static final <R extends Comparable<? super R>> long U5(long[] maxBy, l<? super a2, ? extends R> selector) {
        l0.p(maxBy, "$this$maxBy");
        l0.p(selector, "selector");
        if (b2.s(maxBy)) {
            throw new NoSuchElementException();
        }
        long jM = b2.m(maxBy, 0);
        int iWe = kotlin.collections.p.We(maxBy);
        if (iWe == 0) {
            return jM;
        }
        R rZ = selector.z(a2.b(jM));
        u0 it = new k(1, iWe).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(maxBy, it.b());
            R rZ2 = selector.z(a2.b(jM2));
            if (rZ.compareTo(rZ2) < 0) {
                jM = jM2;
                rZ = rZ2;
            }
        }
        return jM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R extends Comparable<? super R>> w1 U6(int[] minByOrNull, l<? super w1, ? extends R> selector) {
        l0.p(minByOrNull, "$this$minByOrNull");
        l0.p(selector, "selector");
        if (x1.s(minByOrNull)) {
            return null;
        }
        int iM = x1.m(minByOrNull, 0);
        int iVe = kotlin.collections.p.Ve(minByOrNull);
        if (iVe == 0) {
            return w1.b(iM);
        }
        R rZ = selector.z(w1.b(iM));
        u0 it = new k(1, iVe).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(minByOrNull, it.b());
            R rZ2 = selector.z(w1.b(iM2));
            if (rZ.compareTo(rZ2) > 0) {
                iM = iM2;
                rZ = rZ2;
            }
        }
        return w1.b(iM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "minWithOrThrow-U")
    public static final long U7(@a7.d long[] minWith, @a7.d Comparator<? super a2> comparator) {
        l0.p(minWith, "$this$minWith");
        l0.p(comparator, "comparator");
        if (b2.s(minWith)) {
            throw new NoSuchElementException();
        }
        long jM = b2.m(minWith, 0);
        u0 it = new k(1, kotlin.collections.p.We(minWith)).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(minWith, it.b());
            if (comparator.compare(a2.b(jM), a2.b(jM2)) > 0) {
                jM = jM2;
            }
        }
        return jM;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short U8(short[] reduceIndexed, q<? super Integer, ? super g2, ? super g2, g2> operation) {
        l0.p(reduceIndexed, "$this$reduceIndexed");
        l0.p(operation, "operation");
        if (h2.s(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM = h2.m(reduceIndexed, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(reduceIndexed)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            sM = operation.v(Integer.valueOf(iB), g2.b(sM), g2.b(h2.m(reduceIndexed, iB))).e0();
        }
        return sM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final List<a2> U9(long[] runningReduce, p<? super a2, ? super a2, a2> operation) {
        l0.p(runningReduce, "$this$runningReduce");
        l0.p(operation, "operation");
        if (b2.s(runningReduce)) {
            return y.F();
        }
        long jM = b2.m(runningReduce, 0);
        ArrayList arrayList = new ArrayList(b2.o(runningReduce));
        arrayList.add(a2.b(jM));
        int iO = b2.o(runningReduce);
        for (int i7 = 1; i7 < iO; i7++) {
            jM = operation.a0(a2.b(jM), a2.b(b2.m(runningReduce, i7))).g0();
            arrayList.add(a2.b(jM));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final int[] Ua(@a7.d int[] sliceArray, @a7.d k indices) {
        l0.p(sliceArray, "$this$sliceArray");
        l0.p(indices, "indices");
        return x1.f(kotlin.collections.p.Gu(sliceArray, indices));
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfDouble")
    @t0
    @f
    private static final double Ub(long[] sumOf, l<? super a2, Double> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = b2.o(sumOf);
        double dDoubleValue = 0.0d;
        for (int i7 = 0; i7 < iO; i7++) {
            dDoubleValue += selector.z(a2.b(b2.m(sumOf, i7))).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final short[] Uc(@a7.d g2[] g2VarArr) {
        l0.p(g2VarArr, "<this>");
        int length = g2VarArr.length;
        short[] sArr = new short[length];
        for (int i7 = 0; i7 < length; i7++) {
            sArr[i7] = g2VarArr[i7].e0();
        }
        return h2.f(sArr);
    }

    @g1(version = "1.4")
    @t
    public static boolean V0(@e byte[] bArr, @e byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<a2> V1(@a7.d long[] dropLast, int i7) {
        l0.p(dropLast, "$this$dropLast");
        if (i7 >= 0) {
            return tc(dropLast, kotlin.ranges.q.n(b2.o(dropLast) - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @g1(version = "1.3")
    @t
    @f
    private static final g2 V2(short[] find, l<? super g2, Boolean> predicate) {
        l0.p(find, "$this$find");
        l0.p(predicate, "predicate");
        int iO = h2.o(find);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(find, i7);
            if (predicate.z(g2.b(sM)).booleanValue()) {
                return g2.b(sM);
            }
        }
        return null;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> R V3(int[] foldRightIndexed, R r7, q<? super Integer, ? super w1, ? super R, ? extends R> operation) {
        l0.p(foldRightIndexed, "$this$foldRightIndexed");
        l0.p(operation, "operation");
        for (int iVe = kotlin.collections.p.Ve(foldRightIndexed); iVe >= 0; iVe--) {
            r7 = operation.v(Integer.valueOf(iVe), w1.b(x1.m(foldRightIndexed, iVe)), r7);
        }
        return r7;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int V4(int[] indexOf, int i7) {
        l0.p(indexOf, "$this$indexOf");
        return kotlin.collections.p.hg(indexOf, i7);
    }

    @g1(version = "1.7")
    @t
    @h(name = "maxByOrThrow-U")
    @f
    private static final <R extends Comparable<? super R>> short V5(short[] maxBy, l<? super g2, ? extends R> selector) {
        l0.p(maxBy, "$this$maxBy");
        l0.p(selector, "selector");
        if (h2.s(maxBy)) {
            throw new NoSuchElementException();
        }
        short sM = h2.m(maxBy, 0);
        int iYe = kotlin.collections.p.Ye(maxBy);
        if (iYe == 0) {
            return sM;
        }
        R rZ = selector.z(g2.b(sM));
        u0 it = new k(1, iYe).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(maxBy, it.b());
            R rZ2 = selector.z(g2.b(sM2));
            if (rZ.compareTo(rZ2) < 0) {
                sM = sM2;
                rZ = rZ2;
            }
        }
        return sM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <R extends Comparable<? super R>> g2 V6(short[] minByOrNull, l<? super g2, ? extends R> selector) {
        l0.p(minByOrNull, "$this$minByOrNull");
        l0.p(selector, "selector");
        if (h2.s(minByOrNull)) {
            return null;
        }
        short sM = h2.m(minByOrNull, 0);
        int iYe = kotlin.collections.p.Ye(minByOrNull);
        if (iYe == 0) {
            return g2.b(sM);
        }
        R rZ = selector.z(g2.b(sM));
        u0 it = new k(1, iYe).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(minByOrNull, it.b());
            R rZ2 = selector.z(g2.b(sM2));
            if (rZ.compareTo(rZ2) > 0) {
                sM = sM2;
                rZ = rZ2;
            }
        }
        return g2.b(sM);
    }

    @g1(version = "1.7")
    @t
    @h(name = "minWithOrThrow-U")
    public static final short V7(@a7.d short[] minWith, @a7.d Comparator<? super g2> comparator) {
        l0.p(minWith, "$this$minWith");
        l0.p(comparator, "comparator");
        if (h2.s(minWith)) {
            throw new NoSuchElementException();
        }
        short sM = h2.m(minWith, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(minWith)).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(minWith, it.b());
            if (comparator.compare(g2.b(sM), g2.b(sM2)) > 0) {
                sM = sM2;
            }
        }
        return sM;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long V8(long[] reduceIndexed, q<? super Integer, ? super a2, ? super a2, a2> operation) {
        l0.p(reduceIndexed, "$this$reduceIndexed");
        l0.p(operation, "operation");
        if (b2.s(reduceIndexed)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM = b2.m(reduceIndexed, 0);
        u0 it = new k(1, kotlin.collections.p.We(reduceIndexed)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            jM = operation.v(Integer.valueOf(iB), a2.b(jM), a2.b(b2.m(reduceIndexed, iB))).g0();
        }
        return jM;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final List<g2> V9(short[] runningReduce, p<? super g2, ? super g2, g2> operation) {
        l0.p(runningReduce, "$this$runningReduce");
        l0.p(operation, "operation");
        if (h2.s(runningReduce)) {
            return y.F();
        }
        short sM = h2.m(runningReduce, 0);
        ArrayList arrayList = new ArrayList(h2.o(runningReduce));
        arrayList.add(g2.b(sM));
        int iO = h2.o(runningReduce);
        for (int i7 = 1; i7 < iO; i7++) {
            sM = operation.a0(g2.b(sM), g2.b(h2.m(runningReduce, i7))).e0();
            arrayList.add(g2.b(sM));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final byte[] Va(@a7.d byte[] sliceArray, @a7.d Collection<Integer> indices) {
        l0.p(sliceArray, "$this$sliceArray");
        l0.p(indices, "indices");
        return t1.f(kotlin.collections.p.xu(sliceArray, indices));
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfDouble")
    @t0
    @f
    private static final double Vb(short[] sumOf, l<? super g2, Double> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = h2.o(sumOf);
        double dDoubleValue = 0.0d;
        for (int i7 = 0; i7 < iO; i7++) {
            dDoubleValue += selector.z(g2.b(h2.m(sumOf, i7))).doubleValue();
        }
        return dDoubleValue;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short[] Vc(short[] sArr) {
        l0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        l0.o(sArrCopyOf, "copyOf(this, size)");
        return h2.f(sArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean W(byte[] all, l<? super s1, Boolean> predicate) {
        l0.p(all, "$this$all");
        l0.p(predicate, "predicate");
        int iO = t1.o(all);
        for (int i7 = 0; i7 < iO; i7++) {
            if (!predicate.z(s1.b(t1.m(all, i7))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ boolean W0(byte[] contentEquals, byte[] other) {
        l0.p(contentEquals, "$this$contentEquals");
        l0.p(other, "other");
        return V0(contentEquals, other);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<s1> W1(byte[] dropLastWhile, l<? super s1, Boolean> predicate) {
        l0.p(dropLastWhile, "$this$dropLastWhile");
        l0.p(predicate, "predicate");
        for (int iRe = kotlin.collections.p.Re(dropLastWhile); -1 < iRe; iRe--) {
            if (!predicate.z(s1.b(t1.m(dropLastWhile, iRe))).booleanValue()) {
                return qc(dropLastWhile, iRe + 1);
            }
        }
        return y.F();
    }

    @g1(version = "1.3")
    @t
    @f
    private static final s1 W2(byte[] findLast, l<? super s1, Boolean> predicate) {
        l0.p(findLast, "$this$findLast");
        l0.p(predicate, "predicate");
        int iO = t1.o(findLast) - 1;
        if (iO >= 0) {
            while (true) {
                int i7 = iO - 1;
                byte bM = t1.m(findLast, iO);
                if (predicate.z(s1.b(bM)).booleanValue()) {
                    return s1.b(bM);
                }
                if (i7 >= 0) {
                    iO = i7;
                }
            }
        }
        return null;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void W3(byte[] forEach, l<? super s1, l2> action) {
        l0.p(forEach, "$this$forEach");
        l0.p(action, "action");
        int iO = t1.o(forEach);
        for (int i7 = 0; i7 < iO; i7++) {
            action.z(s1.b(t1.m(forEach, i7)));
        }
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int W4(byte[] indexOfFirst, l<? super s1, Boolean> predicate) {
        l0.p(indexOfFirst, "$this$indexOfFirst");
        l0.p(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(s1.b(s1.h(indexOfFirst[i7]))).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final double W5(byte[] maxOf, l<? super s1, Double> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (t1.s(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(s1.b(t1.m(maxOf, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Re(maxOf)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(s1.b(t1.m(maxOf, it.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @g1(version = "1.7")
    @t
    @h(name = "minByOrThrow-U")
    @f
    private static final <R extends Comparable<? super R>> byte W6(byte[] minBy, l<? super s1, ? extends R> selector) {
        l0.p(minBy, "$this$minBy");
        l0.p(selector, "selector");
        if (t1.s(minBy)) {
            throw new NoSuchElementException();
        }
        byte bM = t1.m(minBy, 0);
        int iRe = kotlin.collections.p.Re(minBy);
        if (iRe == 0) {
            return bM;
        }
        R rZ = selector.z(s1.b(bM));
        u0 it = new k(1, iRe).iterator();
        while (it.hasNext()) {
            byte bM2 = t1.m(minBy, it.b());
            R rZ2 = selector.z(s1.b(bM2));
            if (rZ.compareTo(rZ2) > 0) {
                bM = bM2;
                rZ = rZ2;
            }
        }
        return bM;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean W7(int[] none) {
        l0.p(none, "$this$none");
        return x1.s(none);
    }

    @g1(version = "1.4")
    @t
    @f
    private static final w1 W8(int[] reduceIndexedOrNull, q<? super Integer, ? super w1, ? super w1, w1> operation) {
        l0.p(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        l0.p(operation, "operation");
        if (x1.s(reduceIndexedOrNull)) {
            return null;
        }
        int iM = x1.m(reduceIndexedOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(reduceIndexedOrNull)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            iM = operation.v(Integer.valueOf(iB), w1.b(iM), w1.b(x1.m(reduceIndexedOrNull, iB))).g0();
        }
        return w1.b(iM);
    }

    @g1(version = "1.4")
    @t
    @f
    private static final List<w1> W9(int[] runningReduceIndexed, q<? super Integer, ? super w1, ? super w1, w1> operation) {
        l0.p(runningReduceIndexed, "$this$runningReduceIndexed");
        l0.p(operation, "operation");
        if (x1.s(runningReduceIndexed)) {
            return y.F();
        }
        int iM = x1.m(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(x1.o(runningReduceIndexed));
        arrayList.add(w1.b(iM));
        int iO = x1.o(runningReduceIndexed);
        for (int i7 = 1; i7 < iO; i7++) {
            iM = operation.v(Integer.valueOf(i7), w1.b(iM), w1.b(x1.m(runningReduceIndexed, i7))).g0();
            arrayList.add(w1.b(iM));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    public static final void Wa(@a7.d int[] sort) {
        l0.p(sort, "$this$sort");
        if (x1.o(sort) > 1) {
            kotlin.collections.t1.l(sort, 0, x1.o(sort));
        }
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfInt")
    @t0
    @f
    private static final int Wb(byte[] sumOf, l<? super s1, Integer> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = t1.o(sumOf);
        int iIntValue = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            iIntValue += selector.z(s1.b(t1.m(sumOf, i7))).intValue();
        }
        return iIntValue;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final Iterable<r0<w1>> Wc(@a7.d int[] withIndex) {
        l0.p(withIndex, "$this$withIndex");
        return new s0(new a(withIndex));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean X(long[] all, l<? super a2, Boolean> predicate) {
        l0.p(all, "$this$all");
        l0.p(predicate, "predicate");
        int iO = b2.o(all);
        for (int i7 = 0; i7 < iO; i7++) {
            if (!predicate.z(a2.b(b2.m(all, i7))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @g1(version = "1.4")
    @t
    public static boolean X0(@e long[] jArr, @e long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<a2> X1(long[] dropLastWhile, l<? super a2, Boolean> predicate) {
        l0.p(dropLastWhile, "$this$dropLastWhile");
        l0.p(predicate, "predicate");
        for (int iWe = kotlin.collections.p.We(dropLastWhile); -1 < iWe; iWe--) {
            if (!predicate.z(a2.b(b2.m(dropLastWhile, iWe))).booleanValue()) {
                return tc(dropLastWhile, iWe + 1);
            }
        }
        return y.F();
    }

    @g1(version = "1.3")
    @t
    @f
    private static final a2 X2(long[] findLast, l<? super a2, Boolean> predicate) {
        l0.p(findLast, "$this$findLast");
        l0.p(predicate, "predicate");
        int iO = b2.o(findLast) - 1;
        if (iO >= 0) {
            while (true) {
                int i7 = iO - 1;
                long jM = b2.m(findLast, iO);
                if (predicate.z(a2.b(jM)).booleanValue()) {
                    return a2.b(jM);
                }
                if (i7 >= 0) {
                    iO = i7;
                }
            }
        }
        return null;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void X3(long[] forEach, l<? super a2, l2> action) {
        l0.p(forEach, "$this$forEach");
        l0.p(action, "action");
        int iO = b2.o(forEach);
        for (int i7 = 0; i7 < iO; i7++) {
            action.z(a2.b(b2.m(forEach, i7)));
        }
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int X4(long[] indexOfFirst, l<? super a2, Boolean> predicate) {
        l0.p(indexOfFirst, "$this$indexOfFirst");
        l0.p(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(a2.b(a2.h(indexOfFirst[i7]))).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final float X5(byte[] maxOf, l<? super s1, Float> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (t1.s(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(s1.b(t1.m(maxOf, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Re(maxOf)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(s1.b(t1.m(maxOf, it.b()))).floatValue());
        }
        return fFloatValue;
    }

    @g1(version = "1.7")
    @t
    @h(name = "minByOrThrow-U")
    @f
    private static final <R extends Comparable<? super R>> int X6(int[] minBy, l<? super w1, ? extends R> selector) {
        l0.p(minBy, "$this$minBy");
        l0.p(selector, "selector");
        if (x1.s(minBy)) {
            throw new NoSuchElementException();
        }
        int iM = x1.m(minBy, 0);
        int iVe = kotlin.collections.p.Ve(minBy);
        if (iVe == 0) {
            return iM;
        }
        R rZ = selector.z(w1.b(iM));
        u0 it = new k(1, iVe).iterator();
        while (it.hasNext()) {
            int iM2 = x1.m(minBy, it.b());
            R rZ2 = selector.z(w1.b(iM2));
            if (rZ.compareTo(rZ2) > 0) {
                iM = iM2;
                rZ = rZ2;
            }
        }
        return iM;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean X7(byte[] none) {
        l0.p(none, "$this$none");
        return t1.s(none);
    }

    @g1(version = "1.4")
    @t
    @f
    private static final s1 X8(byte[] reduceIndexedOrNull, q<? super Integer, ? super s1, ? super s1, s1> operation) {
        l0.p(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        l0.p(operation, "operation");
        if (t1.s(reduceIndexedOrNull)) {
            return null;
        }
        byte bM = t1.m(reduceIndexedOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Re(reduceIndexedOrNull)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            bM = operation.v(Integer.valueOf(iB), s1.b(bM), s1.b(t1.m(reduceIndexedOrNull, iB))).e0();
        }
        return s1.b(bM);
    }

    @g1(version = "1.4")
    @t
    @f
    private static final List<s1> X9(byte[] runningReduceIndexed, q<? super Integer, ? super s1, ? super s1, s1> operation) {
        l0.p(runningReduceIndexed, "$this$runningReduceIndexed");
        l0.p(operation, "operation");
        if (t1.s(runningReduceIndexed)) {
            return y.F();
        }
        byte bM = t1.m(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(t1.o(runningReduceIndexed));
        arrayList.add(s1.b(bM));
        int iO = t1.o(runningReduceIndexed);
        for (int i7 = 1; i7 < iO; i7++) {
            bM = operation.v(Integer.valueOf(i7), s1.b(bM), s1.b(t1.m(runningReduceIndexed, i7))).e0();
            arrayList.add(s1.b(bM));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    public static final void Xa(@a7.d long[] sort, int i7, int i8) {
        l0.p(sort, "$this$sort");
        kotlin.collections.c.f34509a.d(i7, i8, b2.o(sort));
        kotlin.collections.t1.i(sort, i7, i8);
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfInt")
    @t0
    @f
    private static final int Xb(int[] sumOf, l<? super w1, Integer> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = x1.o(sumOf);
        int iIntValue = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            iIntValue += selector.z(w1.b(x1.m(sumOf, i7))).intValue();
        }
        return iIntValue;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final Iterable<r0<s1>> Xc(@a7.d byte[] withIndex) {
        l0.p(withIndex, "$this$withIndex");
        return new s0(new C0427c(withIndex));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean Y(int[] all, l<? super w1, Boolean> predicate) {
        l0.p(all, "$this$all");
        l0.p(predicate, "predicate");
        int iO = x1.o(all);
        for (int i7 = 0; i7 < iO; i7++) {
            if (!predicate.z(w1.b(x1.m(all, i7))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ boolean Y0(short[] contentEquals, short[] other) {
        l0.p(contentEquals, "$this$contentEquals");
        l0.p(other, "other");
        return S0(contentEquals, other);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<w1> Y1(int[] dropLastWhile, l<? super w1, Boolean> predicate) {
        l0.p(dropLastWhile, "$this$dropLastWhile");
        l0.p(predicate, "predicate");
        for (int iVe = kotlin.collections.p.Ve(dropLastWhile); -1 < iVe; iVe--) {
            if (!predicate.z(w1.b(x1.m(dropLastWhile, iVe))).booleanValue()) {
                return sc(dropLastWhile, iVe + 1);
            }
        }
        return y.F();
    }

    @g1(version = "1.3")
    @t
    @f
    private static final w1 Y2(int[] findLast, l<? super w1, Boolean> predicate) {
        l0.p(findLast, "$this$findLast");
        l0.p(predicate, "predicate");
        int iO = x1.o(findLast) - 1;
        if (iO >= 0) {
            while (true) {
                int i7 = iO - 1;
                int iM = x1.m(findLast, iO);
                if (predicate.z(w1.b(iM)).booleanValue()) {
                    return w1.b(iM);
                }
                if (i7 >= 0) {
                    iO = i7;
                }
            }
        }
        return null;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void Y3(int[] forEach, l<? super w1, l2> action) {
        l0.p(forEach, "$this$forEach");
        l0.p(action, "action");
        int iO = x1.o(forEach);
        for (int i7 = 0; i7 < iO; i7++) {
            action.z(w1.b(x1.m(forEach, i7)));
        }
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int Y4(int[] indexOfFirst, l<? super w1, Boolean> predicate) {
        l0.p(indexOfFirst, "$this$indexOfFirst");
        l0.p(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(w1.b(w1.h(indexOfFirst[i7]))).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R Y5(byte[] maxOf, l<? super s1, ? extends R> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (t1.s(maxOf)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(s1.b(t1.m(maxOf, 0)));
        u0 it = new k(1, kotlin.collections.p.Re(maxOf)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(s1.b(t1.m(maxOf, it.b())));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.7")
    @t
    @h(name = "minByOrThrow-U")
    @f
    private static final <R extends Comparable<? super R>> long Y6(long[] minBy, l<? super a2, ? extends R> selector) {
        l0.p(minBy, "$this$minBy");
        l0.p(selector, "selector");
        if (b2.s(minBy)) {
            throw new NoSuchElementException();
        }
        long jM = b2.m(minBy, 0);
        int iWe = kotlin.collections.p.We(minBy);
        if (iWe == 0) {
            return jM;
        }
        R rZ = selector.z(a2.b(jM));
        u0 it = new k(1, iWe).iterator();
        while (it.hasNext()) {
            long jM2 = b2.m(minBy, it.b());
            R rZ2 = selector.z(a2.b(jM2));
            if (rZ.compareTo(rZ2) > 0) {
                jM = jM2;
                rZ = rZ2;
            }
        }
        return jM;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean Y7(byte[] none, l<? super s1, Boolean> predicate) {
        l0.p(none, "$this$none");
        l0.p(predicate, "predicate");
        int iO = t1.o(none);
        for (int i7 = 0; i7 < iO; i7++) {
            if (predicate.z(s1.b(t1.m(none, i7))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final g2 Y8(short[] reduceIndexedOrNull, q<? super Integer, ? super g2, ? super g2, g2> operation) {
        l0.p(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        l0.p(operation, "operation");
        if (h2.s(reduceIndexedOrNull)) {
            return null;
        }
        short sM = h2.m(reduceIndexedOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(reduceIndexedOrNull)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            sM = operation.v(Integer.valueOf(iB), g2.b(sM), g2.b(h2.m(reduceIndexedOrNull, iB))).e0();
        }
        return g2.b(sM);
    }

    @g1(version = "1.4")
    @t
    @f
    private static final List<g2> Y9(short[] runningReduceIndexed, q<? super Integer, ? super g2, ? super g2, g2> operation) {
        l0.p(runningReduceIndexed, "$this$runningReduceIndexed");
        l0.p(operation, "operation");
        if (h2.s(runningReduceIndexed)) {
            return y.F();
        }
        short sM = h2.m(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(h2.o(runningReduceIndexed));
        arrayList.add(g2.b(sM));
        int iO = h2.o(runningReduceIndexed);
        for (int i7 = 1; i7 < iO; i7++) {
            sM = operation.v(Integer.valueOf(i7), g2.b(sM), g2.b(h2.m(runningReduceIndexed, i7))).e0();
            arrayList.add(g2.b(sM));
        }
        return arrayList;
    }

    public static /* synthetic */ void Ya(long[] jArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = b2.o(jArr);
        }
        Xa(jArr, i7, i8);
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfInt")
    @t0
    @f
    private static final int Yb(long[] sumOf, l<? super a2, Integer> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = b2.o(sumOf);
        int iIntValue = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            iIntValue += selector.z(a2.b(b2.m(sumOf, i7))).intValue();
        }
        return iIntValue;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final Iterable<r0<a2>> Yc(@a7.d long[] withIndex) {
        l0.p(withIndex, "$this$withIndex");
        return new s0(new b(withIndex));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean Z(short[] all, l<? super g2, Boolean> predicate) {
        l0.p(all, "$this$all");
        l0.p(predicate, "predicate");
        int iO = h2.o(all);
        for (int i7 = 0; i7 < iO; i7++) {
            if (!predicate.z(g2.b(h2.m(all, i7))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ boolean Z0(long[] contentEquals, long[] other) {
        l0.p(contentEquals, "$this$contentEquals");
        l0.p(other, "other");
        return X0(contentEquals, other);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<g2> Z1(short[] dropLastWhile, l<? super g2, Boolean> predicate) {
        l0.p(dropLastWhile, "$this$dropLastWhile");
        l0.p(predicate, "predicate");
        for (int iYe = kotlin.collections.p.Ye(dropLastWhile); -1 < iYe; iYe--) {
            if (!predicate.z(g2.b(h2.m(dropLastWhile, iYe))).booleanValue()) {
                return rc(dropLastWhile, iYe + 1);
            }
        }
        return y.F();
    }

    @g1(version = "1.3")
    @t
    @f
    private static final g2 Z2(short[] findLast, l<? super g2, Boolean> predicate) {
        l0.p(findLast, "$this$findLast");
        l0.p(predicate, "predicate");
        int iO = h2.o(findLast) - 1;
        if (iO >= 0) {
            while (true) {
                int i7 = iO - 1;
                short sM = h2.m(findLast, iO);
                if (predicate.z(g2.b(sM)).booleanValue()) {
                    return g2.b(sM);
                }
                if (i7 >= 0) {
                    iO = i7;
                }
            }
        }
        return null;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void Z3(short[] forEach, l<? super g2, l2> action) {
        l0.p(forEach, "$this$forEach");
        l0.p(action, "action");
        int iO = h2.o(forEach);
        for (int i7 = 0; i7 < iO; i7++) {
            action.z(g2.b(h2.m(forEach, i7)));
        }
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int Z4(short[] indexOfFirst, l<? super g2, Boolean> predicate) {
        l0.p(indexOfFirst, "$this$indexOfFirst");
        l0.p(predicate, "predicate");
        int length = indexOfFirst.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(g2.b(g2.h(indexOfFirst[i7]))).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final double Z5(long[] maxOf, l<? super a2, Double> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (b2.s(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(a2.b(b2.m(maxOf, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.We(maxOf)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(a2.b(b2.m(maxOf, it.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @g1(version = "1.7")
    @t
    @h(name = "minByOrThrow-U")
    @f
    private static final <R extends Comparable<? super R>> short Z6(short[] minBy, l<? super g2, ? extends R> selector) {
        l0.p(minBy, "$this$minBy");
        l0.p(selector, "selector");
        if (h2.s(minBy)) {
            throw new NoSuchElementException();
        }
        short sM = h2.m(minBy, 0);
        int iYe = kotlin.collections.p.Ye(minBy);
        if (iYe == 0) {
            return sM;
        }
        R rZ = selector.z(g2.b(sM));
        u0 it = new k(1, iYe).iterator();
        while (it.hasNext()) {
            short sM2 = h2.m(minBy, it.b());
            R rZ2 = selector.z(g2.b(sM2));
            if (rZ.compareTo(rZ2) > 0) {
                sM = sM2;
                rZ = rZ2;
            }
        }
        return sM;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean Z7(long[] none, l<? super a2, Boolean> predicate) {
        l0.p(none, "$this$none");
        l0.p(predicate, "predicate");
        int iO = b2.o(none);
        for (int i7 = 0; i7 < iO; i7++) {
            if (predicate.z(a2.b(b2.m(none, i7))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final a2 Z8(long[] reduceIndexedOrNull, q<? super Integer, ? super a2, ? super a2, a2> operation) {
        l0.p(reduceIndexedOrNull, "$this$reduceIndexedOrNull");
        l0.p(operation, "operation");
        if (b2.s(reduceIndexedOrNull)) {
            return null;
        }
        long jM = b2.m(reduceIndexedOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.We(reduceIndexedOrNull)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            jM = operation.v(Integer.valueOf(iB), a2.b(jM), a2.b(b2.m(reduceIndexedOrNull, iB))).g0();
        }
        return a2.b(jM);
    }

    @g1(version = "1.4")
    @t
    @f
    private static final List<a2> Z9(long[] runningReduceIndexed, q<? super Integer, ? super a2, ? super a2, a2> operation) {
        l0.p(runningReduceIndexed, "$this$runningReduceIndexed");
        l0.p(operation, "operation");
        if (b2.s(runningReduceIndexed)) {
            return y.F();
        }
        long jM = b2.m(runningReduceIndexed, 0);
        ArrayList arrayList = new ArrayList(b2.o(runningReduceIndexed));
        arrayList.add(a2.b(jM));
        int iO = b2.o(runningReduceIndexed);
        for (int i7 = 1; i7 < iO; i7++) {
            jM = operation.v(Integer.valueOf(i7), a2.b(jM), a2.b(b2.m(runningReduceIndexed, i7))).g0();
            arrayList.add(a2.b(jM));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    public static final void Za(@a7.d byte[] sort, int i7, int i8) {
        l0.p(sort, "$this$sort");
        kotlin.collections.c.f34509a.d(i7, i8, t1.o(sort));
        kotlin.collections.t1.j(sort, i7, i8);
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfInt")
    @t0
    @f
    private static final int Zb(short[] sumOf, l<? super g2, Integer> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = h2.o(sumOf);
        int iIntValue = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            iIntValue += selector.z(g2.b(h2.m(sumOf, i7))).intValue();
        }
        return iIntValue;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final Iterable<r0<g2>> Zc(@a7.d short[] withIndex) {
        l0.p(withIndex, "$this$withIndex");
        return new s0(new d(withIndex));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean a0(int[] any) {
        l0.p(any, "$this$any");
        return kotlin.collections.p.M5(any);
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ int a1(int[] contentHashCode) {
        l0.p(contentHashCode, "$this$contentHashCode");
        return e1(contentHashCode);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<s1> a2(byte[] dropWhile, l<? super s1, Boolean> predicate) {
        l0.p(dropWhile, "$this$dropWhile");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = t1.o(dropWhile);
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(dropWhile, i7);
            if (z7) {
                arrayList.add(s1.b(bM));
            } else if (!predicate.z(s1.b(bM)).booleanValue()) {
                arrayList.add(s1.b(bM));
                z7 = true;
            }
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int a3(int[] first) {
        l0.p(first, "$this$first");
        return w1.h(kotlin.collections.p.oc(first));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void a4(byte[] forEachIndexed, p<? super Integer, ? super s1, l2> action) {
        l0.p(forEachIndexed, "$this$forEachIndexed");
        l0.p(action, "action");
        int iO = t1.o(forEachIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            action.a0(Integer.valueOf(i8), s1.b(t1.m(forEachIndexed, i7)));
            i7++;
            i8++;
        }
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int a5(byte[] indexOfLast, l<? super s1, Boolean> predicate) {
        l0.p(indexOfLast, "$this$indexOfLast");
        l0.p(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i7 = length - 1;
            if (predicate.z(s1.b(s1.h(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i7 < 0) {
                return -1;
            }
            length = i7;
        }
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final float a6(long[] maxOf, l<? super a2, Float> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (b2.s(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(a2.b(b2.m(maxOf, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.We(maxOf)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(a2.b(b2.m(maxOf, it.b()))).floatValue());
        }
        return fFloatValue;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final double a7(byte[] minOf, l<? super s1, Double> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (t1.s(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(s1.b(t1.m(minOf, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Re(minOf)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(s1.b(t1.m(minOf, it.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean a8(long[] none) {
        l0.p(none, "$this$none");
        return b2.s(none);
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final s1 a9(byte[] reduceOrNull, p<? super s1, ? super s1, s1> operation) {
        l0.p(reduceOrNull, "$this$reduceOrNull");
        l0.p(operation, "operation");
        if (t1.s(reduceOrNull)) {
            return null;
        }
        byte bM = t1.m(reduceOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Re(reduceOrNull)).iterator();
        while (it.hasNext()) {
            bM = operation.a0(s1.b(bM), s1.b(t1.m(reduceOrNull, it.b()))).e0();
        }
        return s1.b(bM);
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final <R> List<R> aa(long[] scan, R r7, p<? super R, ? super a2, ? extends R> operation) {
        l0.p(scan, "$this$scan");
        l0.p(operation, "operation");
        if (b2.s(scan)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(b2.o(scan) + 1);
        arrayList.add(r7);
        int iO = b2.o(scan);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, a2.b(b2.m(scan, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    public static /* synthetic */ void ab(byte[] bArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = t1.o(bArr);
        }
        Za(bArr, i7, i8);
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfLong")
    @t0
    @f
    private static final long ac(byte[] sumOf, l<? super s1, Long> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = t1.o(sumOf);
        long jLongValue = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            jLongValue += selector.z(s1.b(t1.m(sumOf, i7))).longValue();
        }
        return jLongValue;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, V> List<V> ad(int[] zip, Iterable<? extends R> other, p<? super w1, ? super R, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iO = x1.o(zip);
        ArrayList arrayList = new ArrayList(Math.min(z.Z(other, 10), iO));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= iO) {
                break;
            }
            arrayList.add(transform.a0(w1.b(x1.m(zip, i7)), r7));
            i7++;
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean b0(byte[] any) {
        l0.p(any, "$this$any");
        return kotlin.collections.p.E5(any);
    }

    @g1(version = "1.4")
    @t
    public static final int b1(@e byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<a2> b2(long[] dropWhile, l<? super a2, Boolean> predicate) {
        l0.p(dropWhile, "$this$dropWhile");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = b2.o(dropWhile);
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(dropWhile, i7);
            if (z7) {
                arrayList.add(a2.b(jM));
            } else if (!predicate.z(a2.b(jM)).booleanValue()) {
                arrayList.add(a2.b(jM));
                z7 = true;
            }
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte b3(byte[] first) {
        l0.p(first, "$this$first");
        return s1.h(kotlin.collections.p.gc(first));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void b4(int[] forEachIndexed, p<? super Integer, ? super w1, l2> action) {
        l0.p(forEachIndexed, "$this$forEachIndexed");
        l0.p(action, "action");
        int iO = x1.o(forEachIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            action.a0(Integer.valueOf(i8), w1.b(x1.m(forEachIndexed, i7)));
            i7++;
            i8++;
        }
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int b5(long[] indexOfLast, l<? super a2, Boolean> predicate) {
        l0.p(indexOfLast, "$this$indexOfLast");
        l0.p(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i7 = length - 1;
            if (predicate.z(a2.b(a2.h(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i7 < 0) {
                return -1;
            }
            length = i7;
        }
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R b6(long[] maxOf, l<? super a2, ? extends R> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (b2.s(maxOf)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(a2.b(b2.m(maxOf, 0)));
        u0 it = new k(1, kotlin.collections.p.We(maxOf)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(a2.b(b2.m(maxOf, it.b())));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final float b7(byte[] minOf, l<? super s1, Float> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (t1.s(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(s1.b(t1.m(minOf, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Re(minOf)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(s1.b(t1.m(minOf, it.b()))).floatValue());
        }
        return fFloatValue;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean b8(int[] none, l<? super w1, Boolean> predicate) {
        l0.p(none, "$this$none");
        l0.p(predicate, "predicate");
        int iO = x1.o(none);
        for (int i7 = 0; i7 < iO; i7++) {
            if (predicate.z(w1.b(x1.m(none, i7))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final w1 b9(int[] reduceOrNull, p<? super w1, ? super w1, w1> operation) {
        l0.p(reduceOrNull, "$this$reduceOrNull");
        l0.p(operation, "operation");
        if (x1.s(reduceOrNull)) {
            return null;
        }
        int iM = x1.m(reduceOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ve(reduceOrNull)).iterator();
        while (it.hasNext()) {
            iM = operation.a0(w1.b(iM), w1.b(x1.m(reduceOrNull, it.b()))).g0();
        }
        return w1.b(iM);
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final <R> List<R> ba(byte[] scan, R r7, p<? super R, ? super s1, ? extends R> operation) {
        l0.p(scan, "$this$scan");
        l0.p(operation, "operation");
        if (t1.s(scan)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(t1.o(scan) + 1);
        arrayList.add(r7);
        int iO = t1.o(scan);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, s1.b(t1.m(scan, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    public static final void bb(@a7.d short[] sort, int i7, int i8) {
        l0.p(sort, "$this$sort");
        kotlin.collections.c.f34509a.d(i7, i8, h2.o(sort));
        kotlin.collections.t1.k(sort, i7, i8);
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfLong")
    @t0
    @f
    private static final long bc(int[] sumOf, l<? super w1, Long> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = x1.o(sumOf);
        long jLongValue = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            jLongValue += selector.z(w1.b(x1.m(sumOf, i7))).longValue();
        }
        return jLongValue;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, V> List<V> bd(long[] zip, R[] other, p<? super a2, ? super R, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iMin = Math.min(b2.o(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(a2.b(b2.m(zip, i7)), other[i7]));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean c0(byte[] any, l<? super s1, Boolean> predicate) {
        l0.p(any, "$this$any");
        l0.p(predicate, "predicate");
        int iO = t1.o(any);
        for (int i7 = 0; i7 < iO; i7++) {
            if (predicate.z(s1.b(t1.m(any, i7))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ int c1(byte[] contentHashCode) {
        l0.p(contentHashCode, "$this$contentHashCode");
        return b1(contentHashCode);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<w1> c2(int[] dropWhile, l<? super w1, Boolean> predicate) {
        l0.p(dropWhile, "$this$dropWhile");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = x1.o(dropWhile);
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(dropWhile, i7);
            if (z7) {
                arrayList.add(w1.b(iM));
            } else if (!predicate.z(w1.b(iM)).booleanValue()) {
                arrayList.add(w1.b(iM));
                z7 = true;
            }
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte c3(byte[] first, l<? super s1, Boolean> predicate) {
        l0.p(first, "$this$first");
        l0.p(predicate, "predicate");
        int iO = t1.o(first);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(first, i7);
            if (predicate.z(s1.b(bM)).booleanValue()) {
                return bM;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void c4(long[] forEachIndexed, p<? super Integer, ? super a2, l2> action) {
        l0.p(forEachIndexed, "$this$forEachIndexed");
        l0.p(action, "action");
        int iO = b2.o(forEachIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            action.a0(Integer.valueOf(i8), a2.b(b2.m(forEachIndexed, i7)));
            i7++;
            i8++;
        }
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int c5(int[] indexOfLast, l<? super w1, Boolean> predicate) {
        l0.p(indexOfLast, "$this$indexOfLast");
        l0.p(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i7 = length - 1;
            if (predicate.z(w1.b(w1.h(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i7 < 0) {
                return -1;
            }
            length = i7;
        }
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final double c6(int[] maxOf, l<? super w1, Double> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (x1.s(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(w1.b(x1.m(maxOf, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Ve(maxOf)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(w1.b(x1.m(maxOf, it.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R c7(byte[] minOf, l<? super s1, ? extends R> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (t1.s(minOf)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(s1.b(t1.m(minOf, 0)));
        u0 it = new k(1, kotlin.collections.p.Re(minOf)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(s1.b(t1.m(minOf, it.b())));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean c8(short[] none) {
        l0.p(none, "$this$none");
        return h2.s(none);
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final a2 c9(long[] reduceOrNull, p<? super a2, ? super a2, a2> operation) {
        l0.p(reduceOrNull, "$this$reduceOrNull");
        l0.p(operation, "operation");
        if (b2.s(reduceOrNull)) {
            return null;
        }
        long jM = b2.m(reduceOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.We(reduceOrNull)).iterator();
        while (it.hasNext()) {
            jM = operation.a0(a2.b(jM), a2.b(b2.m(reduceOrNull, it.b()))).g0();
        }
        return a2.b(jM);
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final <R> List<R> ca(int[] scan, R r7, p<? super R, ? super w1, ? extends R> operation) {
        l0.p(scan, "$this$scan");
        l0.p(operation, "operation");
        if (x1.s(scan)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(x1.o(scan) + 1);
        arrayList.add(r7);
        int iO = x1.o(scan);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, w1.b(x1.m(scan, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    public static /* synthetic */ void cb(short[] sArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = h2.o(sArr);
        }
        bb(sArr, i7, i8);
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfLong")
    @t0
    @f
    private static final long cc(long[] sumOf, l<? super a2, Long> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = b2.o(sumOf);
        long jLongValue = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            jLongValue += selector.z(a2.b(b2.m(sumOf, i7))).longValue();
        }
        return jLongValue;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final <R> List<kotlin.u0<w1, R>> cd(@a7.d int[] zip, @a7.d R[] other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iMin = Math.min(x1.o(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            int iM = x1.m(zip, i7);
            arrayList.add(p1.a(w1.b(iM), other[i7]));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean d0(long[] any, l<? super a2, Boolean> predicate) {
        l0.p(any, "$this$any");
        l0.p(predicate, "predicate");
        int iO = b2.o(any);
        for (int i7 = 0; i7 < iO; i7++) {
            if (predicate.z(a2.b(b2.m(any, i7))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ int d1(long[] contentHashCode) {
        l0.p(contentHashCode, "$this$contentHashCode");
        return h1(contentHashCode);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<g2> d2(short[] dropWhile, l<? super g2, Boolean> predicate) {
        l0.p(dropWhile, "$this$dropWhile");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = h2.o(dropWhile);
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(dropWhile, i7);
            if (z7) {
                arrayList.add(g2.b(sM));
            } else if (!predicate.z(g2.b(sM)).booleanValue()) {
                arrayList.add(g2.b(sM));
                z7 = true;
            }
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long d3(long[] first, l<? super a2, Boolean> predicate) {
        l0.p(first, "$this$first");
        l0.p(predicate, "predicate");
        int iO = b2.o(first);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(first, i7);
            if (predicate.z(a2.b(jM)).booleanValue()) {
                return jM;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void d4(short[] forEachIndexed, p<? super Integer, ? super g2, l2> action) {
        l0.p(forEachIndexed, "$this$forEachIndexed");
        l0.p(action, "action");
        int iO = h2.o(forEachIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            action.a0(Integer.valueOf(i8), g2.b(h2.m(forEachIndexed, i7)));
            i7++;
            i8++;
        }
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int d5(short[] indexOfLast, l<? super g2, Boolean> predicate) {
        l0.p(indexOfLast, "$this$indexOfLast");
        l0.p(predicate, "predicate");
        int length = indexOfLast.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i7 = length - 1;
            if (predicate.z(g2.b(g2.h(indexOfLast[length]))).booleanValue()) {
                return length;
            }
            if (i7 < 0) {
                return -1;
            }
            length = i7;
        }
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final float d6(int[] maxOf, l<? super w1, Float> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (x1.s(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(w1.b(x1.m(maxOf, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Ve(maxOf)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(w1.b(x1.m(maxOf, it.b()))).floatValue());
        }
        return fFloatValue;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final double d7(long[] minOf, l<? super a2, Double> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (b2.s(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(a2.b(b2.m(minOf, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.We(minOf)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(a2.b(b2.m(minOf, it.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean d8(short[] none, l<? super g2, Boolean> predicate) {
        l0.p(none, "$this$none");
        l0.p(predicate, "predicate");
        int iO = h2.o(none);
        for (int i7 = 0; i7 < iO; i7++) {
            if (predicate.z(g2.b(h2.m(none, i7))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final g2 d9(short[] reduceOrNull, p<? super g2, ? super g2, g2> operation) {
        l0.p(reduceOrNull, "$this$reduceOrNull");
        l0.p(operation, "operation");
        if (h2.s(reduceOrNull)) {
            return null;
        }
        short sM = h2.m(reduceOrNull, 0);
        u0 it = new k(1, kotlin.collections.p.Ye(reduceOrNull)).iterator();
        while (it.hasNext()) {
            sM = operation.a0(g2.b(sM), g2.b(h2.m(reduceOrNull, it.b()))).e0();
        }
        return g2.b(sM);
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final <R> List<R> da(short[] scan, R r7, p<? super R, ? super g2, ? extends R> operation) {
        l0.p(scan, "$this$scan");
        l0.p(operation, "operation");
        if (h2.s(scan)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(h2.o(scan) + 1);
        arrayList.add(r7);
        int iO = h2.o(scan);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.a0(r7, g2.b(h2.m(scan, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    public static final void db(@a7.d byte[] sort) {
        l0.p(sort, "$this$sort");
        if (t1.o(sort) > 1) {
            kotlin.collections.t1.j(sort, 0, t1.o(sort));
        }
    }

    @g1(version = "1.4")
    @t
    @h(name = "sumOfLong")
    @t0
    @f
    private static final long dc(short[] sumOf, l<? super g2, Long> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iO = h2.o(sumOf);
        long jLongValue = 0;
        for (int i7 = 0; i7 < iO; i7++) {
            jLongValue += selector.z(g2.b(h2.m(sumOf, i7))).longValue();
        }
        return jLongValue;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final <R> List<kotlin.u0<a2, R>> dd(@a7.d long[] zip, @a7.d Iterable<? extends R> other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iO = b2.o(zip);
        ArrayList arrayList = new ArrayList(Math.min(z.Z(other, 10), iO));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= iO) {
                break;
            }
            arrayList.add(p1.a(a2.b(b2.m(zip, i7)), r7));
            i7++;
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean e0(long[] any) {
        l0.p(any, "$this$any");
        return kotlin.collections.p.O5(any);
    }

    @g1(version = "1.4")
    @t
    public static final int e1(@e int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short e2(short[] elementAtOrElse, int i7, l<? super Integer, g2> defaultValue) {
        l0.p(elementAtOrElse, "$this$elementAtOrElse");
        l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > kotlin.collections.p.Ye(elementAtOrElse)) ? defaultValue.z(Integer.valueOf(i7)).e0() : h2.m(elementAtOrElse, i7);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long e3(long[] first) {
        l0.p(first, "$this$first");
        return a2.h(kotlin.collections.p.qc(first));
    }

    @a7.d
    public static final k e4(@a7.d int[] indices) {
        l0.p(indices, "$this$indices");
        return kotlin.collections.p.Me(indices);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int e5(int[] last) {
        l0.p(last, "$this$last");
        return w1.h(kotlin.collections.p.Xh(last));
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R e6(int[] maxOf, l<? super w1, ? extends R> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (x1.s(maxOf)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(w1.b(x1.m(maxOf, 0)));
        u0 it = new k(1, kotlin.collections.p.Ve(maxOf)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(w1.b(x1.m(maxOf, it.b())));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final float e7(long[] minOf, l<? super a2, Float> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (b2.s(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(a2.b(b2.m(minOf, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.We(minOf)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(a2.b(b2.m(minOf, it.b()))).floatValue());
        }
        return fFloatValue;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final byte[] e8(byte[] onEach, l<? super s1, l2> action) {
        l0.p(onEach, "$this$onEach");
        l0.p(action, "action");
        int iO = t1.o(onEach);
        for (int i7 = 0; i7 < iO; i7++) {
            action.z(s1.b(t1.m(onEach, i7)));
        }
        return onEach;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte e9(byte[] reduceRight, p<? super s1, ? super s1, s1> operation) {
        l0.p(reduceRight, "$this$reduceRight");
        l0.p(operation, "operation");
        int iRe = kotlin.collections.p.Re(reduceRight);
        if (iRe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM = t1.m(reduceRight, iRe);
        for (int i7 = iRe - 1; i7 >= 0; i7--) {
            bM = operation.a0(s1.b(t1.m(reduceRight, i7)), s1.b(bM)).e0();
        }
        return bM;
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final <R> List<R> ea(byte[] scanIndexed, R r7, q<? super Integer, ? super R, ? super s1, ? extends R> operation) {
        l0.p(scanIndexed, "$this$scanIndexed");
        l0.p(operation, "operation");
        if (t1.s(scanIndexed)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(t1.o(scanIndexed) + 1);
        arrayList.add(r7);
        int iO = t1.o(scanIndexed);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, s1.b(t1.m(scanIndexed, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    public static final void eb(@a7.d long[] sort) {
        l0.p(sort, "$this$sort");
        if (b2.o(sort) > 1) {
            kotlin.collections.t1.i(sort, 0, b2.o(sort));
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @h(name = "sumOfUByte")
    public static final int ec(@a7.d s1[] s1VarArr) {
        l0.p(s1VarArr, "<this>");
        int iH = 0;
        for (s1 s1Var : s1VarArr) {
            iH = w1.h(iH + w1.h(s1Var.e0() & 255));
        }
        return iH;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final <R> List<kotlin.u0<w1, R>> ed(@a7.d int[] zip, @a7.d Iterable<? extends R> other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iO = x1.o(zip);
        ArrayList arrayList = new ArrayList(Math.min(z.Z(other, 10), iO));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= iO) {
                break;
            }
            arrayList.add(p1.a(w1.b(x1.m(zip, i7)), r7));
            i7++;
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean f0(int[] any, l<? super w1, Boolean> predicate) {
        l0.p(any, "$this$any");
        l0.p(predicate, "predicate");
        int iO = x1.o(any);
        for (int i7 = 0; i7 < iO; i7++) {
            if (predicate.z(w1.b(x1.m(any, i7))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @g1(version = "1.4")
    @t
    public static final int f1(@e short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int f2(int[] elementAtOrElse, int i7, l<? super Integer, w1> defaultValue) {
        l0.p(elementAtOrElse, "$this$elementAtOrElse");
        l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > kotlin.collections.p.Ve(elementAtOrElse)) ? defaultValue.z(Integer.valueOf(i7)).g0() : x1.m(elementAtOrElse, i7);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int f3(int[] first, l<? super w1, Boolean> predicate) {
        l0.p(first, "$this$first");
        l0.p(predicate, "predicate");
        int iO = x1.o(first);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(first, i7);
            if (predicate.z(w1.b(iM)).booleanValue()) {
                return iM;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @g1(version = "1.3")
    @t
    public static /* synthetic */ void f4(int[] iArr) {
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte f5(byte[] last) {
        l0.p(last, "$this$last");
        return s1.h(kotlin.collections.p.Ph(last));
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final double f6(short[] maxOf, l<? super g2, Double> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (h2.s(maxOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(g2.b(h2.m(maxOf, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Ye(maxOf)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(g2.b(h2.m(maxOf, it.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R f7(long[] minOf, l<? super a2, ? extends R> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (b2.s(minOf)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(a2.b(b2.m(minOf, 0)));
        u0 it = new k(1, kotlin.collections.p.We(minOf)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(a2.b(b2.m(minOf, it.b())));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final long[] f8(long[] onEach, l<? super a2, l2> action) {
        l0.p(onEach, "$this$onEach");
        l0.p(action, "action");
        int iO = b2.o(onEach);
        for (int i7 = 0; i7 < iO; i7++) {
            action.z(a2.b(b2.m(onEach, i7)));
        }
        return onEach;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int f9(int[] reduceRight, p<? super w1, ? super w1, w1> operation) {
        l0.p(reduceRight, "$this$reduceRight");
        l0.p(operation, "operation");
        int iVe = kotlin.collections.p.Ve(reduceRight);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM = x1.m(reduceRight, iVe);
        for (int i7 = iVe - 1; i7 >= 0; i7--) {
            iM = operation.a0(w1.b(x1.m(reduceRight, i7)), w1.b(iM)).g0();
        }
        return iM;
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final <R> List<R> fa(short[] scanIndexed, R r7, q<? super Integer, ? super R, ? super g2, ? extends R> operation) {
        l0.p(scanIndexed, "$this$scanIndexed");
        l0.p(operation, "operation");
        if (h2.s(scanIndexed)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(h2.o(scanIndexed) + 1);
        arrayList.add(r7);
        int iO = h2.o(scanIndexed);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, g2.b(h2.m(scanIndexed, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    public static final void fb(@a7.d int[] sort, int i7, int i8) {
        l0.p(sort, "$this$sort");
        kotlin.collections.c.f34509a.d(i7, i8, x1.o(sort));
        kotlin.collections.t1.l(sort, i7, i8);
    }

    @g1(version = "1.5")
    @t
    @h(name = "sumOfUInt")
    @t0
    @q2(markerClass = {t.class})
    @f
    private static final int fc(byte[] sumOf, l<? super s1, w1> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iH = w1.h(0);
        int iO = t1.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            iH = w1.h(iH + selector.z(s1.b(t1.m(sumOf, i7))).g0());
        }
        return iH;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <V> List<V> fd(byte[] zip, byte[] other, p<? super s1, ? super s1, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iMin = Math.min(t1.o(zip), t1.o(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(s1.b(t1.m(zip, i7)), s1.b(t1.m(other, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean g0(short[] any) {
        l0.p(any, "$this$any");
        return kotlin.collections.p.S5(any);
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ int g1(short[] contentHashCode) {
        l0.p(contentHashCode, "$this$contentHashCode");
        return f1(contentHashCode);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long g2(long[] elementAtOrElse, int i7, l<? super Integer, a2> defaultValue) {
        l0.p(elementAtOrElse, "$this$elementAtOrElse");
        l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > kotlin.collections.p.We(elementAtOrElse)) ? defaultValue.z(Integer.valueOf(i7)).g0() : b2.m(elementAtOrElse, i7);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short g3(short[] first) {
        l0.p(first, "$this$first");
        return g2.h(kotlin.collections.p.uc(first));
    }

    @a7.d
    public static final k g4(@a7.d byte[] indices) {
        l0.p(indices, "$this$indices");
        return kotlin.collections.p.Ie(indices);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte g5(byte[] last, l<? super s1, Boolean> predicate) {
        l0.p(last, "$this$last");
        l0.p(predicate, "predicate");
        int iO = t1.o(last) - 1;
        if (iO >= 0) {
            while (true) {
                int i7 = iO - 1;
                byte bM = t1.m(last, iO);
                if (predicate.z(s1.b(bM)).booleanValue()) {
                    return bM;
                }
                if (i7 >= 0) {
                    iO = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final float g6(short[] maxOf, l<? super g2, Float> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (h2.s(maxOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(g2.b(h2.m(maxOf, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Ye(maxOf)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(g2.b(h2.m(maxOf, it.b()))).floatValue());
        }
        return fFloatValue;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final double g7(int[] minOf, l<? super w1, Double> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (x1.s(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(w1.b(x1.m(minOf, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Ve(minOf)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(w1.b(x1.m(minOf, it.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final int[] g8(int[] onEach, l<? super w1, l2> action) {
        l0.p(onEach, "$this$onEach");
        l0.p(action, "action");
        int iO = x1.o(onEach);
        for (int i7 = 0; i7 < iO; i7++) {
            action.z(w1.b(x1.m(onEach, i7)));
        }
        return onEach;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long g9(long[] reduceRight, p<? super a2, ? super a2, a2> operation) {
        l0.p(reduceRight, "$this$reduceRight");
        l0.p(operation, "operation");
        int iWe = kotlin.collections.p.We(reduceRight);
        if (iWe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM = b2.m(reduceRight, iWe);
        for (int i7 = iWe - 1; i7 >= 0; i7--) {
            jM = operation.a0(a2.b(b2.m(reduceRight, i7)), a2.b(jM)).g0();
        }
        return jM;
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final <R> List<R> ga(long[] scanIndexed, R r7, q<? super Integer, ? super R, ? super a2, ? extends R> operation) {
        l0.p(scanIndexed, "$this$scanIndexed");
        l0.p(operation, "operation");
        if (b2.s(scanIndexed)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(b2.o(scanIndexed) + 1);
        arrayList.add(r7);
        int iO = b2.o(scanIndexed);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, a2.b(b2.m(scanIndexed, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    public static /* synthetic */ void gb(int[] iArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = x1.o(iArr);
        }
        fb(iArr, i7, i8);
    }

    @g1(version = "1.5")
    @t
    @h(name = "sumOfUInt")
    @t0
    @q2(markerClass = {t.class})
    @f
    private static final int gc(int[] sumOf, l<? super w1, w1> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iH = w1.h(0);
        int iO = x1.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            iH = w1.h(iH + selector.z(w1.b(x1.m(sumOf, i7))).g0());
        }
        return iH;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final <R> List<kotlin.u0<g2, R>> gd(@a7.d short[] zip, @a7.d Iterable<? extends R> other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iO = h2.o(zip);
        ArrayList arrayList = new ArrayList(Math.min(z.Z(other, 10), iO));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= iO) {
                break;
            }
            arrayList.add(p1.a(g2.b(h2.m(zip, i7)), r7));
            i7++;
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final boolean h0(short[] any, l<? super g2, Boolean> predicate) {
        l0.p(any, "$this$any");
        l0.p(predicate, "predicate");
        int iO = h2.o(any);
        for (int i7 = 0; i7 < iO; i7++) {
            if (predicate.z(g2.b(h2.m(any, i7))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @g1(version = "1.4")
    @t
    public static final int h1(@e long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte h2(byte[] elementAtOrElse, int i7, l<? super Integer, s1> defaultValue) {
        l0.p(elementAtOrElse, "$this$elementAtOrElse");
        l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > kotlin.collections.p.Re(elementAtOrElse)) ? defaultValue.z(Integer.valueOf(i7)).e0() : t1.m(elementAtOrElse, i7);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short h3(short[] first, l<? super g2, Boolean> predicate) {
        l0.p(first, "$this$first");
        l0.p(predicate, "predicate");
        int iO = h2.o(first);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(first, i7);
            if (predicate.z(g2.b(sM)).booleanValue()) {
                return sM;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @g1(version = "1.3")
    @t
    public static /* synthetic */ void h4(byte[] bArr) {
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long h5(long[] last, l<? super a2, Boolean> predicate) {
        l0.p(last, "$this$last");
        l0.p(predicate, "predicate");
        int iO = b2.o(last) - 1;
        if (iO >= 0) {
            while (true) {
                int i7 = iO - 1;
                long jM = b2.m(last, iO);
                if (predicate.z(a2.b(jM)).booleanValue()) {
                    return jM;
                }
                if (i7 >= 0) {
                    iO = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R h6(short[] maxOf, l<? super g2, ? extends R> selector) {
        l0.p(maxOf, "$this$maxOf");
        l0.p(selector, "selector");
        if (h2.s(maxOf)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(g2.b(h2.m(maxOf, 0)));
        u0 it = new k(1, kotlin.collections.p.Ye(maxOf)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(g2.b(h2.m(maxOf, it.b())));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final float h7(int[] minOf, l<? super w1, Float> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (x1.s(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(w1.b(x1.m(minOf, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Ve(minOf)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(w1.b(x1.m(minOf, it.b()))).floatValue());
        }
        return fFloatValue;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final short[] h8(short[] onEach, l<? super g2, l2> action) {
        l0.p(onEach, "$this$onEach");
        l0.p(action, "action");
        int iO = h2.o(onEach);
        for (int i7 = 0; i7 < iO; i7++) {
            action.z(g2.b(h2.m(onEach, i7)));
        }
        return onEach;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short h9(short[] reduceRight, p<? super g2, ? super g2, g2> operation) {
        l0.p(reduceRight, "$this$reduceRight");
        l0.p(operation, "operation");
        int iYe = kotlin.collections.p.Ye(reduceRight);
        if (iYe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM = h2.m(reduceRight, iYe);
        for (int i7 = iYe - 1; i7 >= 0; i7--) {
            sM = operation.a0(g2.b(h2.m(reduceRight, i7)), g2.b(sM)).e0();
        }
        return sM;
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final <R> List<R> ha(int[] scanIndexed, R r7, q<? super Integer, ? super R, ? super w1, ? extends R> operation) {
        l0.p(scanIndexed, "$this$scanIndexed");
        l0.p(operation, "operation");
        if (x1.s(scanIndexed)) {
            return x.l(r7);
        }
        ArrayList arrayList = new ArrayList(x1.o(scanIndexed) + 1);
        arrayList.add(r7);
        int iO = x1.o(scanIndexed);
        for (int i7 = 0; i7 < iO; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, w1.b(x1.m(scanIndexed, i7)));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    public static final void hb(@a7.d short[] sort) {
        l0.p(sort, "$this$sort");
        if (h2.o(sort) > 1) {
            kotlin.collections.t1.k(sort, 0, h2.o(sort));
        }
    }

    @g1(version = "1.5")
    @t
    @h(name = "sumOfUInt")
    @t0
    @q2(markerClass = {t.class})
    @f
    private static final int hc(long[] sumOf, l<? super a2, w1> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iH = w1.h(0);
        int iO = b2.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            iH = w1.h(iH + selector.z(a2.b(b2.m(sumOf, i7))).g0());
        }
        return iH;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final <R> List<kotlin.u0<s1, R>> hd(@a7.d byte[] zip, @a7.d Iterable<? extends R> other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iO = t1.o(zip);
        ArrayList arrayList = new ArrayList(Math.min(z.Z(other, 10), iO));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= iO) {
                break;
            }
            arrayList.add(p1.a(s1.b(t1.m(zip, i7)), r7));
            i7++;
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte[] i0(byte[] asByteArray) {
        l0.p(asByteArray, "$this$asByteArray");
        return asByteArray;
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ String i1(int[] contentToString) {
        l0.p(contentToString, "$this$contentToString");
        return m1(contentToString);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final s1 i2(byte[] elementAtOrNull, int i7) {
        l0.p(elementAtOrNull, "$this$elementAtOrNull");
        return y4(elementAtOrNull, i7);
    }

    @g1(version = "1.3")
    @t
    @e
    public static final w1 i3(@a7.d int[] firstOrNull) {
        l0.p(firstOrNull, "$this$firstOrNull");
        if (x1.s(firstOrNull)) {
            return null;
        }
        return w1.b(x1.m(firstOrNull, 0));
    }

    @a7.d
    public static final k i4(@a7.d long[] indices) {
        l0.p(indices, "$this$indices");
        return kotlin.collections.p.Ne(indices);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long i5(long[] last) {
        l0.p(last, "$this$last");
        return a2.h(kotlin.collections.p.Zh(last));
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R i6(byte[] maxOfOrNull, l<? super s1, ? extends R> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (t1.s(maxOfOrNull)) {
            return null;
        }
        R rZ = selector.z(s1.b(t1.m(maxOfOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Re(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(s1.b(t1.m(maxOfOrNull, it.b())));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R i7(int[] minOf, l<? super w1, ? extends R> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (x1.s(minOf)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(w1.b(x1.m(minOf, 0)));
        u0 it = new k(1, kotlin.collections.p.Ve(minOf)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(w1.b(x1.m(minOf, it.b())));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final byte[] i8(byte[] onEachIndexed, p<? super Integer, ? super s1, l2> action) {
        l0.p(onEachIndexed, "$this$onEachIndexed");
        l0.p(action, "action");
        int iO = t1.o(onEachIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            action.a0(Integer.valueOf(i8), s1.b(t1.m(onEachIndexed, i7)));
            i7++;
            i8++;
        }
        return onEachIndexed;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int i9(int[] reduceRightIndexed, q<? super Integer, ? super w1, ? super w1, w1> operation) {
        l0.p(reduceRightIndexed, "$this$reduceRightIndexed");
        l0.p(operation, "operation");
        int iVe = kotlin.collections.p.Ve(reduceRightIndexed);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM = x1.m(reduceRightIndexed, iVe);
        for (int i7 = iVe - 1; i7 >= 0; i7--) {
            iM = operation.v(Integer.valueOf(i7), w1.b(x1.m(reduceRightIndexed, i7)), w1.b(iM)).g0();
        }
        return iM;
    }

    @g1(version = "1.4")
    @t
    public static final void ia(@a7.d int[] shuffle) {
        l0.p(shuffle, "$this$shuffle");
        ja(shuffle, kotlin.random.f.f34998a);
    }

    @g1(version = "1.3")
    @t
    public static final void ib(@a7.d int[] sortDescending) {
        l0.p(sortDescending, "$this$sortDescending");
        if (x1.o(sortDescending) > 1) {
            Wa(sortDescending);
            kotlin.collections.p.yr(sortDescending);
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @h(name = "sumOfUInt")
    public static final int ic(@a7.d w1[] w1VarArr) {
        l0.p(w1VarArr, "<this>");
        int iH = 0;
        for (w1 w1Var : w1VarArr) {
            iH = w1.h(iH + w1Var.g0());
        }
        return iH;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <V> List<V> id(int[] zip, int[] other, p<? super w1, ? super w1, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iMin = Math.min(x1.o(zip), x1.o(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(w1.b(x1.m(zip, i7)), w1.b(x1.m(other, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int[] j0(int[] asIntArray) {
        l0.p(asIntArray, "$this$asIntArray");
        return asIntArray;
    }

    @a7.d
    @g1(version = "1.4")
    @t
    public static String j1(@e byte[] bArr) {
        String strH3;
        return (bArr == null || (strH3 = g0.h3(t1.b(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strH3;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final g2 j2(short[] elementAtOrNull, int i7) {
        l0.p(elementAtOrNull, "$this$elementAtOrNull");
        return z4(elementAtOrNull, i7);
    }

    @g1(version = "1.3")
    @t
    @e
    public static final s1 j3(@a7.d byte[] firstOrNull) {
        l0.p(firstOrNull, "$this$firstOrNull");
        if (t1.s(firstOrNull)) {
            return null;
        }
        return s1.b(t1.m(firstOrNull, 0));
    }

    @g1(version = "1.3")
    @t
    public static /* synthetic */ void j4(long[] jArr) {
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int j5(int[] last, l<? super w1, Boolean> predicate) {
        l0.p(last, "$this$last");
        l0.p(predicate, "predicate");
        int iO = x1.o(last) - 1;
        if (iO >= 0) {
            while (true) {
                int i7 = iO - 1;
                int iM = x1.m(last, iO);
                if (predicate.z(w1.b(iM)).booleanValue()) {
                    return iM;
                }
                if (i7 >= 0) {
                    iO = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Double j6(byte[] maxOfOrNull, l<? super s1, Double> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (t1.s(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.z(s1.b(t1.m(maxOfOrNull, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Re(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(s1.b(t1.m(maxOfOrNull, it.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final double j7(short[] minOf, l<? super g2, Double> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (h2.s(minOf)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(g2.b(h2.m(minOf, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Ye(minOf)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(g2.b(h2.m(minOf, it.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final int[] j8(int[] onEachIndexed, p<? super Integer, ? super w1, l2> action) {
        l0.p(onEachIndexed, "$this$onEachIndexed");
        l0.p(action, "action");
        int iO = x1.o(onEachIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            action.a0(Integer.valueOf(i8), w1.b(x1.m(onEachIndexed, i7)));
            i7++;
            i8++;
        }
        return onEachIndexed;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte j9(byte[] reduceRightIndexed, q<? super Integer, ? super s1, ? super s1, s1> operation) {
        l0.p(reduceRightIndexed, "$this$reduceRightIndexed");
        l0.p(operation, "operation");
        int iRe = kotlin.collections.p.Re(reduceRightIndexed);
        if (iRe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM = t1.m(reduceRightIndexed, iRe);
        for (int i7 = iRe - 1; i7 >= 0; i7--) {
            bM = operation.v(Integer.valueOf(i7), s1.b(t1.m(reduceRightIndexed, i7)), s1.b(bM)).e0();
        }
        return bM;
    }

    @g1(version = "1.4")
    @t
    public static final void ja(@a7.d int[] shuffle, @a7.d kotlin.random.f random) {
        l0.p(shuffle, "$this$shuffle");
        l0.p(random, "random");
        for (int iVe = kotlin.collections.p.Ve(shuffle); iVe > 0; iVe--) {
            int iM = random.m(iVe + 1);
            int iM2 = x1.m(shuffle, iVe);
            x1.u(shuffle, iVe, x1.m(shuffle, iM));
            x1.u(shuffle, iM, iM2);
        }
    }

    @g1(version = "1.4")
    @t
    public static final void jb(@a7.d long[] sortDescending, int i7, int i8) {
        l0.p(sortDescending, "$this$sortDescending");
        Xa(sortDescending, i7, i8);
        kotlin.collections.p.Br(sortDescending, i7, i8);
    }

    @g1(version = "1.5")
    @t
    @h(name = "sumOfUInt")
    @t0
    @q2(markerClass = {t.class})
    @f
    private static final int jc(short[] sumOf, l<? super g2, w1> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        int iH = w1.h(0);
        int iO = h2.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            iH = w1.h(iH + selector.z(g2.b(h2.m(sumOf, i7))).g0());
        }
        return iH;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, V> List<V> jd(byte[] zip, R[] other, p<? super s1, ? super R, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iMin = Math.min(t1.o(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(s1.b(t1.m(zip, i7)), other[i7]));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long[] k0(long[] asLongArray) {
        l0.p(asLongArray, "$this$asLongArray");
        return asLongArray;
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ String k1(byte[] contentToString) {
        l0.p(contentToString, "$this$contentToString");
        return j1(contentToString);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final w1 k2(int[] elementAtOrNull, int i7) {
        l0.p(elementAtOrNull, "$this$elementAtOrNull");
        return A4(elementAtOrNull, i7);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final s1 k3(byte[] firstOrNull, l<? super s1, Boolean> predicate) {
        l0.p(firstOrNull, "$this$firstOrNull");
        l0.p(predicate, "predicate");
        int iO = t1.o(firstOrNull);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(firstOrNull, i7);
            if (predicate.z(s1.b(bM)).booleanValue()) {
                return s1.b(bM);
            }
        }
        return null;
    }

    @a7.d
    public static final k k4(@a7.d short[] indices) {
        l0.p(indices, "$this$indices");
        return kotlin.collections.p.Pe(indices);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short k5(short[] last) {
        l0.p(last, "$this$last");
        return g2.h(kotlin.collections.p.di(last));
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Float k6(byte[] maxOfOrNull, l<? super s1, Float> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (t1.s(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.z(s1.b(t1.m(maxOfOrNull, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Re(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(s1.b(t1.m(maxOfOrNull, it.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final float k7(short[] minOf, l<? super g2, Float> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (h2.s(minOf)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(g2.b(h2.m(minOf, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Ye(minOf)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(g2.b(h2.m(minOf, it.b()))).floatValue());
        }
        return fFloatValue;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final long[] k8(long[] onEachIndexed, p<? super Integer, ? super a2, l2> action) {
        l0.p(onEachIndexed, "$this$onEachIndexed");
        l0.p(action, "action");
        int iO = b2.o(onEachIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            action.a0(Integer.valueOf(i8), a2.b(b2.m(onEachIndexed, i7)));
            i7++;
            i8++;
        }
        return onEachIndexed;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short k9(short[] reduceRightIndexed, q<? super Integer, ? super g2, ? super g2, g2> operation) {
        l0.p(reduceRightIndexed, "$this$reduceRightIndexed");
        l0.p(operation, "operation");
        int iYe = kotlin.collections.p.Ye(reduceRightIndexed);
        if (iYe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM = h2.m(reduceRightIndexed, iYe);
        for (int i7 = iYe - 1; i7 >= 0; i7--) {
            sM = operation.v(Integer.valueOf(i7), g2.b(h2.m(reduceRightIndexed, i7)), g2.b(sM)).e0();
        }
        return sM;
    }

    @g1(version = "1.4")
    @t
    public static final void ka(@a7.d byte[] shuffle) {
        l0.p(shuffle, "$this$shuffle");
        na(shuffle, kotlin.random.f.f34998a);
    }

    @g1(version = "1.4")
    @t
    public static final void kb(@a7.d byte[] sortDescending, int i7, int i8) {
        l0.p(sortDescending, "$this$sortDescending");
        Za(sortDescending, i7, i8);
        kotlin.collections.p.rr(sortDescending, i7, i8);
    }

    @g1(version = "1.5")
    @t
    @h(name = "sumOfULong")
    @t0
    @q2(markerClass = {t.class})
    @f
    private static final long kc(byte[] sumOf, l<? super s1, a2> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        long jH = a2.h(0L);
        int iO = t1.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            jH = a2.h(jH + selector.z(s1.b(t1.m(sumOf, i7))).g0());
        }
        return jH;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <V> List<V> kd(long[] zip, long[] other, p<? super a2, ? super a2, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iMin = Math.min(b2.o(zip), b2.o(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(a2.b(b2.m(zip, i7)), a2.b(b2.m(other, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short[] l0(short[] asShortArray) {
        l0.p(asShortArray, "$this$asShortArray");
        return asShortArray;
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ String l1(long[] contentToString) {
        l0.p(contentToString, "$this$contentToString");
        return p1(contentToString);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final a2 l2(long[] elementAtOrNull, int i7) {
        l0.p(elementAtOrNull, "$this$elementAtOrNull");
        return B4(elementAtOrNull, i7);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final a2 l3(long[] firstOrNull, l<? super a2, Boolean> predicate) {
        l0.p(firstOrNull, "$this$firstOrNull");
        l0.p(predicate, "predicate");
        int iO = b2.o(firstOrNull);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(firstOrNull, i7);
            if (predicate.z(a2.b(jM)).booleanValue()) {
                return a2.b(jM);
            }
        }
        return null;
    }

    @g1(version = "1.3")
    @t
    public static /* synthetic */ void l4(short[] sArr) {
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short l5(short[] last, l<? super g2, Boolean> predicate) {
        l0.p(last, "$this$last");
        l0.p(predicate, "predicate");
        int iO = h2.o(last) - 1;
        if (iO >= 0) {
            while (true) {
                int i7 = iO - 1;
                short sM = h2.m(last, iO);
                if (predicate.z(g2.b(sM)).booleanValue()) {
                    return sM;
                }
                if (i7 >= 0) {
                    iO = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R l6(long[] maxOfOrNull, l<? super a2, ? extends R> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (b2.s(maxOfOrNull)) {
            return null;
        }
        R rZ = selector.z(a2.b(b2.m(maxOfOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.We(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(a2.b(b2.m(maxOfOrNull, it.b())));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R l7(short[] minOf, l<? super g2, ? extends R> selector) {
        l0.p(minOf, "$this$minOf");
        l0.p(selector, "selector");
        if (h2.s(minOf)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(g2.b(h2.m(minOf, 0)));
        u0 it = new k(1, kotlin.collections.p.Ye(minOf)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(g2.b(h2.m(minOf, it.b())));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final short[] l8(short[] onEachIndexed, p<? super Integer, ? super g2, l2> action) {
        l0.p(onEachIndexed, "$this$onEachIndexed");
        l0.p(action, "action");
        int iO = h2.o(onEachIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            action.a0(Integer.valueOf(i8), g2.b(h2.m(onEachIndexed, i7)));
            i7++;
            i8++;
        }
        return onEachIndexed;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long l9(long[] reduceRightIndexed, q<? super Integer, ? super a2, ? super a2, a2> operation) {
        l0.p(reduceRightIndexed, "$this$reduceRightIndexed");
        l0.p(operation, "operation");
        int iWe = kotlin.collections.p.We(reduceRightIndexed);
        if (iWe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM = b2.m(reduceRightIndexed, iWe);
        for (int i7 = iWe - 1; i7 >= 0; i7--) {
            jM = operation.v(Integer.valueOf(i7), a2.b(b2.m(reduceRightIndexed, i7)), a2.b(jM)).g0();
        }
        return jM;
    }

    @g1(version = "1.4")
    @t
    public static final void la(@a7.d long[] shuffle, @a7.d kotlin.random.f random) {
        l0.p(shuffle, "$this$shuffle");
        l0.p(random, "random");
        for (int iWe = kotlin.collections.p.We(shuffle); iWe > 0; iWe--) {
            int iM = random.m(iWe + 1);
            long jM = b2.m(shuffle, iWe);
            b2.u(shuffle, iWe, b2.m(shuffle, iM));
            b2.u(shuffle, iM, jM);
        }
    }

    @g1(version = "1.4")
    @t
    public static final void lb(@a7.d short[] sortDescending, int i7, int i8) {
        l0.p(sortDescending, "$this$sortDescending");
        bb(sortDescending, i7, i8);
        kotlin.collections.p.Fr(sortDescending, i7, i8);
    }

    @g1(version = "1.5")
    @t
    @h(name = "sumOfULong")
    @t0
    @q2(markerClass = {t.class})
    @f
    private static final long lc(int[] sumOf, l<? super w1, a2> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        long jH = a2.h(0L);
        int iO = x1.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            jH = a2.h(jH + selector.z(w1.b(x1.m(sumOf, i7))).g0());
        }
        return jH;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, V> List<V> ld(long[] zip, Iterable<? extends R> other, p<? super a2, ? super R, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iO = b2.o(zip);
        ArrayList arrayList = new ArrayList(Math.min(z.Z(other, 10), iO));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= iO) {
                break;
            }
            arrayList.add(transform.a0(a2.b(b2.m(zip, i7)), r7));
            i7++;
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte[] m0(byte[] bArr) {
        l0.p(bArr, "<this>");
        return t1.f(bArr);
    }

    @a7.d
    @g1(version = "1.4")
    @t
    public static String m1(@e int[] iArr) {
        String strH3;
        return (iArr == null || (strH3 = g0.h3(x1.b(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strH3;
    }

    @g1(version = "1.3")
    @t
    public static final void m2(@a7.d int[] fill, int i7, int i8, int i9) {
        l0.p(fill, "$this$fill");
        o.l2(fill, i7, i8, i9);
    }

    @g1(version = "1.3")
    @t
    @e
    public static final a2 m3(@a7.d long[] firstOrNull) {
        l0.p(firstOrNull, "$this$firstOrNull");
        if (b2.s(firstOrNull)) {
            return null;
        }
        return a2.b(b2.m(firstOrNull, 0));
    }

    public static final int m4(@a7.d int[] lastIndex) {
        l0.p(lastIndex, "$this$lastIndex");
        return kotlin.collections.p.Ve(lastIndex);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int m5(long[] lastIndexOf, long j7) {
        l0.p(lastIndexOf, "$this$lastIndexOf");
        return kotlin.collections.p.mi(lastIndexOf, j7);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Double m6(long[] maxOfOrNull, l<? super a2, Double> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (b2.s(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.z(a2.b(b2.m(maxOfOrNull, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.We(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(a2.b(b2.m(maxOfOrNull, it.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R m7(byte[] minOfOrNull, l<? super s1, ? extends R> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (t1.s(minOfOrNull)) {
            return null;
        }
        R rZ = selector.z(s1.b(t1.m(minOfOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Re(minOfOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(s1.b(t1.m(minOfOrNull, it.b())));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long[] m8(long[] plus, long j7) {
        l0.p(plus, "$this$plus");
        return b2.f(o.U3(plus, j7));
    }

    @g1(version = "1.4")
    @t
    @f
    private static final w1 m9(int[] reduceRightIndexedOrNull, q<? super Integer, ? super w1, ? super w1, w1> operation) {
        l0.p(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        l0.p(operation, "operation");
        int iVe = kotlin.collections.p.Ve(reduceRightIndexedOrNull);
        if (iVe < 0) {
            return null;
        }
        int iM = x1.m(reduceRightIndexedOrNull, iVe);
        for (int i7 = iVe - 1; i7 >= 0; i7--) {
            iM = operation.v(Integer.valueOf(i7), w1.b(x1.m(reduceRightIndexedOrNull, i7)), w1.b(iM)).g0();
        }
        return w1.b(iM);
    }

    @g1(version = "1.4")
    @t
    public static final void ma(@a7.d long[] shuffle) {
        l0.p(shuffle, "$this$shuffle");
        la(shuffle, kotlin.random.f.f34998a);
    }

    @g1(version = "1.3")
    @t
    public static final void mb(@a7.d byte[] sortDescending) {
        l0.p(sortDescending, "$this$sortDescending");
        if (t1.o(sortDescending) > 1) {
            db(sortDescending);
            kotlin.collections.p.qr(sortDescending);
        }
    }

    @g1(version = "1.5")
    @t
    @h(name = "sumOfULong")
    @t0
    @q2(markerClass = {t.class})
    @f
    private static final long mc(long[] sumOf, l<? super a2, a2> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        long jH = a2.h(0L);
        int iO = b2.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            jH = a2.h(jH + selector.z(a2.b(b2.m(sumOf, i7))).g0());
        }
        return jH;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, V> List<V> md(byte[] zip, Iterable<? extends R> other, p<? super s1, ? super R, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iO = t1.o(zip);
        ArrayList arrayList = new ArrayList(Math.min(z.Z(other, 10), iO));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= iO) {
                break;
            }
            arrayList.add(transform.a0(s1.b(t1.m(zip, i7)), r7));
            i7++;
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int[] n0(int[] iArr) {
        l0.p(iArr, "<this>");
        return x1.f(iArr);
    }

    @a7.d
    @g1(version = "1.4")
    @t
    public static String n1(@e short[] sArr) {
        String strH3;
        return (sArr == null || (strH3 = g0.h3(h2.b(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strH3;
    }

    public static /* synthetic */ void n2(int[] iArr, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = x1.o(iArr);
        }
        m2(iArr, i7, i8, i9);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final w1 n3(int[] firstOrNull, l<? super w1, Boolean> predicate) {
        l0.p(firstOrNull, "$this$firstOrNull");
        l0.p(predicate, "predicate");
        int iO = x1.o(firstOrNull);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(firstOrNull, i7);
            if (predicate.z(w1.b(iM)).booleanValue()) {
                return w1.b(iM);
            }
        }
        return null;
    }

    @g1(version = "1.3")
    @t
    public static /* synthetic */ void n4(int[] iArr) {
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int n5(short[] lastIndexOf, short s7) {
        l0.p(lastIndexOf, "$this$lastIndexOf");
        return kotlin.collections.p.oi(lastIndexOf, s7);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Float n6(long[] maxOfOrNull, l<? super a2, Float> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (b2.s(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.z(a2.b(b2.m(maxOfOrNull, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.We(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(a2.b(b2.m(maxOfOrNull, it.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Double n7(byte[] minOfOrNull, l<? super s1, Double> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (t1.s(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.z(s1.b(t1.m(minOfOrNull, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Re(minOfOrNull)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(s1.b(t1.m(minOfOrNull, it.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final int[] n8(@a7.d int[] plus, @a7.d Collection<w1> elements) {
        l0.p(plus, "$this$plus");
        l0.p(elements, "elements");
        int iO = x1.o(plus);
        int[] iArrCopyOf = Arrays.copyOf(plus, x1.o(plus) + elements.size());
        l0.o(iArrCopyOf, "copyOf(this, newSize)");
        Iterator<w1> it = elements.iterator();
        while (it.hasNext()) {
            iArrCopyOf[iO] = it.next().g0();
            iO++;
        }
        return x1.f(iArrCopyOf);
    }

    @g1(version = "1.4")
    @t
    @f
    private static final s1 n9(byte[] reduceRightIndexedOrNull, q<? super Integer, ? super s1, ? super s1, s1> operation) {
        l0.p(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        l0.p(operation, "operation");
        int iRe = kotlin.collections.p.Re(reduceRightIndexedOrNull);
        if (iRe < 0) {
            return null;
        }
        byte bM = t1.m(reduceRightIndexedOrNull, iRe);
        for (int i7 = iRe - 1; i7 >= 0; i7--) {
            bM = operation.v(Integer.valueOf(i7), s1.b(t1.m(reduceRightIndexedOrNull, i7)), s1.b(bM)).e0();
        }
        return s1.b(bM);
    }

    @g1(version = "1.4")
    @t
    public static final void na(@a7.d byte[] shuffle, @a7.d kotlin.random.f random) {
        l0.p(shuffle, "$this$shuffle");
        l0.p(random, "random");
        for (int iRe = kotlin.collections.p.Re(shuffle); iRe > 0; iRe--) {
            int iM = random.m(iRe + 1);
            byte bM = t1.m(shuffle, iRe);
            t1.u(shuffle, iRe, t1.m(shuffle, iM));
            t1.u(shuffle, iM, bM);
        }
    }

    @g1(version = "1.3")
    @t
    public static final void nb(@a7.d long[] sortDescending) {
        l0.p(sortDescending, "$this$sortDescending");
        if (b2.o(sortDescending) > 1) {
            eb(sortDescending);
            kotlin.collections.p.Ar(sortDescending);
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @h(name = "sumOfULong")
    public static final long nc(@a7.d a2[] a2VarArr) {
        l0.p(a2VarArr, "<this>");
        long jH = 0;
        for (a2 a2Var : a2VarArr) {
            jH = a2.h(jH + a2Var.g0());
        }
        return jH;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, V> List<V> nd(int[] zip, R[] other, p<? super w1, ? super R, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iMin = Math.min(x1.o(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(w1.b(x1.m(zip, i7)), other[i7]));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long[] o0(long[] jArr) {
        l0.p(jArr, "<this>");
        return b2.f(jArr);
    }

    @g1(version = "1.3")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @t
    public static final /* synthetic */ String o1(short[] contentToString) {
        l0.p(contentToString, "$this$contentToString");
        return n1(contentToString);
    }

    @g1(version = "1.3")
    @t
    public static final void o2(@a7.d short[] fill, short s7, int i7, int i8) {
        l0.p(fill, "$this$fill");
        o.o2(fill, s7, i7, i8);
    }

    @g1(version = "1.3")
    @t
    @e
    public static final g2 o3(@a7.d short[] firstOrNull) {
        l0.p(firstOrNull, "$this$firstOrNull");
        if (h2.s(firstOrNull)) {
            return null;
        }
        return g2.b(h2.m(firstOrNull, 0));
    }

    public static final int o4(@a7.d byte[] lastIndex) {
        l0.p(lastIndex, "$this$lastIndex");
        return kotlin.collections.p.Re(lastIndex);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int o5(byte[] lastIndexOf, byte b8) {
        l0.p(lastIndexOf, "$this$lastIndexOf");
        return kotlin.collections.p.hi(lastIndexOf, b8);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R o6(int[] maxOfOrNull, l<? super w1, ? extends R> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (x1.s(maxOfOrNull)) {
            return null;
        }
        R rZ = selector.z(w1.b(x1.m(maxOfOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Ve(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(w1.b(x1.m(maxOfOrNull, it.b())));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Float o7(byte[] minOfOrNull, l<? super s1, Float> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (t1.s(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.z(s1.b(t1.m(minOfOrNull, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Re(minOfOrNull)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(s1.b(t1.m(minOfOrNull, it.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short[] o8(short[] plus, short s7) {
        l0.p(plus, "$this$plus");
        return h2.f(o.b4(plus, s7));
    }

    @g1(version = "1.4")
    @t
    @f
    private static final g2 o9(short[] reduceRightIndexedOrNull, q<? super Integer, ? super g2, ? super g2, g2> operation) {
        l0.p(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        l0.p(operation, "operation");
        int iYe = kotlin.collections.p.Ye(reduceRightIndexedOrNull);
        if (iYe < 0) {
            return null;
        }
        short sM = h2.m(reduceRightIndexedOrNull, iYe);
        for (int i7 = iYe - 1; i7 >= 0; i7--) {
            sM = operation.v(Integer.valueOf(i7), g2.b(h2.m(reduceRightIndexedOrNull, i7)), g2.b(sM)).e0();
        }
        return g2.b(sM);
    }

    @g1(version = "1.4")
    @t
    public static final void oa(@a7.d short[] shuffle) {
        l0.p(shuffle, "$this$shuffle");
        pa(shuffle, kotlin.random.f.f34998a);
    }

    @g1(version = "1.4")
    @t
    public static final void ob(@a7.d int[] sortDescending, int i7, int i8) {
        l0.p(sortDescending, "$this$sortDescending");
        fb(sortDescending, i7, i8);
        kotlin.collections.p.zr(sortDescending, i7, i8);
    }

    @g1(version = "1.5")
    @t
    @h(name = "sumOfULong")
    @t0
    @q2(markerClass = {t.class})
    @f
    private static final long oc(short[] sumOf, l<? super g2, a2> selector) {
        l0.p(sumOf, "$this$sumOf");
        l0.p(selector, "selector");
        long jH = a2.h(0L);
        int iO = h2.o(sumOf);
        for (int i7 = 0; i7 < iO; i7++) {
            jH = a2.h(jH + selector.z(g2.b(h2.m(sumOf, i7))).g0());
        }
        return jH;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<kotlin.u0<w1, w1>> od(@a7.d int[] zip, @a7.d int[] other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iMin = Math.min(x1.o(zip), x1.o(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(p1.a(w1.b(x1.m(zip, i7)), w1.b(x1.m(other, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short[] p0(short[] sArr) {
        l0.p(sArr, "<this>");
        return h2.f(sArr);
    }

    @a7.d
    @g1(version = "1.4")
    @t
    public static String p1(@e long[] jArr) {
        String strH3;
        return (jArr == null || (strH3 = g0.h3(b2.b(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? "null" : strH3;
    }

    public static /* synthetic */ void p2(short[] sArr, short s7, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = h2.o(sArr);
        }
        o2(sArr, s7, i7, i8);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final g2 p3(short[] firstOrNull, l<? super g2, Boolean> predicate) {
        l0.p(firstOrNull, "$this$firstOrNull");
        l0.p(predicate, "predicate");
        int iO = h2.o(firstOrNull);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(firstOrNull, i7);
            if (predicate.z(g2.b(sM)).booleanValue()) {
                return g2.b(sM);
            }
        }
        return null;
    }

    @g1(version = "1.3")
    @t
    public static /* synthetic */ void p4(byte[] bArr) {
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int p5(int[] lastIndexOf, int i7) {
        l0.p(lastIndexOf, "$this$lastIndexOf");
        return kotlin.collections.p.li(lastIndexOf, i7);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Double p6(int[] maxOfOrNull, l<? super w1, Double> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (x1.s(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.z(w1.b(x1.m(maxOfOrNull, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Ve(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(w1.b(x1.m(maxOfOrNull, it.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R p7(long[] minOfOrNull, l<? super a2, ? extends R> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (b2.s(minOfOrNull)) {
            return null;
        }
        R rZ = selector.z(a2.b(b2.m(minOfOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.We(minOfOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(a2.b(b2.m(minOfOrNull, it.b())));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int[] p8(int[] plus, int[] elements) {
        l0.p(plus, "$this$plus");
        l0.p(elements, "elements");
        return x1.f(o.T3(plus, elements));
    }

    @g1(version = "1.4")
    @t
    @f
    private static final a2 p9(long[] reduceRightIndexedOrNull, q<? super Integer, ? super a2, ? super a2, a2> operation) {
        l0.p(reduceRightIndexedOrNull, "$this$reduceRightIndexedOrNull");
        l0.p(operation, "operation");
        int iWe = kotlin.collections.p.We(reduceRightIndexedOrNull);
        if (iWe < 0) {
            return null;
        }
        long jM = b2.m(reduceRightIndexedOrNull, iWe);
        for (int i7 = iWe - 1; i7 >= 0; i7--) {
            jM = operation.v(Integer.valueOf(i7), a2.b(b2.m(reduceRightIndexedOrNull, i7)), a2.b(jM)).g0();
        }
        return a2.b(jM);
    }

    @g1(version = "1.4")
    @t
    public static final void pa(@a7.d short[] shuffle, @a7.d kotlin.random.f random) {
        l0.p(shuffle, "$this$shuffle");
        l0.p(random, "random");
        for (int iYe = kotlin.collections.p.Ye(shuffle); iYe > 0; iYe--) {
            int iM = random.m(iYe + 1);
            short sM = h2.m(shuffle, iYe);
            h2.u(shuffle, iYe, h2.m(shuffle, iM));
            h2.u(shuffle, iM, sM);
        }
    }

    @g1(version = "1.3")
    @t
    public static final void pb(@a7.d short[] sortDescending) {
        l0.p(sortDescending, "$this$sortDescending");
        if (h2.o(sortDescending) > 1) {
            hb(sortDescending);
            kotlin.collections.p.Er(sortDescending);
        }
    }

    @g1(version = "1.5")
    @q2(markerClass = {t.class})
    @h(name = "sumOfUShort")
    public static final int pc(@a7.d g2[] g2VarArr) {
        l0.p(g2VarArr, "<this>");
        int iH = 0;
        for (g2 g2Var : g2VarArr) {
            iH = w1.h(iH + w1.h(g2Var.e0() & g2.f34732d));
        }
        return iH;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, V> List<V> pd(short[] zip, R[] other, p<? super g2, ? super R, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iMin = Math.min(h2.o(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(g2.b(h2.m(zip, i7)), other[i7]));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <V> Map<s1, V> q0(byte[] associateWith, l<? super s1, ? extends V> valueSelector) {
        l0.p(associateWith, "$this$associateWith");
        l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(kotlin.collections.b1.j(t1.o(associateWith)), 16));
        int iO = t1.o(associateWith);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(associateWith, i7);
            linkedHashMap.put(s1.b(bM), valueSelector.z(s1.b(bM)));
        }
        return linkedHashMap;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long[] q1(long[] copyInto, long[] destination, int i7, int i8, int i9) {
        l0.p(copyInto, "$this$copyInto");
        l0.p(destination, "destination");
        o.b1(copyInto, destination, i7, i8, i9);
        return destination;
    }

    @g1(version = "1.3")
    @t
    public static final void q2(@a7.d long[] fill, long j7, int i7, int i8) {
        l0.p(fill, "$this$fill");
        o.m2(fill, j7, i7, i8);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> q3(byte[] flatMap, l<? super s1, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMap, "$this$flatMap");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = t1.o(flatMap);
        for (int i7 = 0; i7 < iO; i7++) {
            d0.o0(arrayList, transform.z(s1.b(t1.m(flatMap, i7))));
        }
        return arrayList;
    }

    public static final int q4(@a7.d long[] lastIndex) {
        l0.p(lastIndex, "$this$lastIndex");
        return kotlin.collections.p.We(lastIndex);
    }

    @g1(version = "1.3")
    @t
    @e
    public static final w1 q5(@a7.d int[] lastOrNull) {
        l0.p(lastOrNull, "$this$lastOrNull");
        if (x1.s(lastOrNull)) {
            return null;
        }
        return w1.b(x1.m(lastOrNull, x1.o(lastOrNull) - 1));
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Float q6(int[] maxOfOrNull, l<? super w1, Float> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (x1.s(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.z(w1.b(x1.m(maxOfOrNull, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Ve(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(w1.b(x1.m(maxOfOrNull, it.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Double q7(long[] minOfOrNull, l<? super a2, Double> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (b2.s(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.z(a2.b(b2.m(minOfOrNull, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.We(minOfOrNull)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(a2.b(b2.m(minOfOrNull, it.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte[] q8(byte[] plus, byte b8) {
        l0.p(plus, "$this$plus");
        return t1.f(o.F3(plus, b8));
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final s1 q9(byte[] reduceRightOrNull, p<? super s1, ? super s1, s1> operation) {
        l0.p(reduceRightOrNull, "$this$reduceRightOrNull");
        l0.p(operation, "operation");
        int iRe = kotlin.collections.p.Re(reduceRightOrNull);
        if (iRe < 0) {
            return null;
        }
        byte bM = t1.m(reduceRightOrNull, iRe);
        for (int i7 = iRe - 1; i7 >= 0; i7--) {
            bM = operation.a0(s1.b(t1.m(reduceRightOrNull, i7)), s1.b(bM)).e0();
        }
        return s1.b(bM);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int qa(int[] single) {
        l0.p(single, "$this$single");
        return w1.h(kotlin.collections.p.Dt(single));
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<w1> qb(@a7.d int[] sorted) {
        l0.p(sorted, "$this$sorted");
        int[] iArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        l0.o(iArrCopyOf, "copyOf(this, size)");
        int[] iArrF = x1.f(iArrCopyOf);
        Wa(iArrF);
        return kotlin.collections.unsigned.b.a(iArrF);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<s1> qc(@a7.d byte[] take, int i7) {
        l0.p(take, "$this$take");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return y.F();
        }
        if (i7 >= t1.o(take)) {
            return g0.Q5(t1.b(take));
        }
        if (i7 == 1) {
            return x.l(s1.b(t1.m(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i7);
        int iO = t1.o(take);
        int i8 = 0;
        for (int i9 = 0; i9 < iO; i9++) {
            arrayList.add(s1.b(t1.m(take, i9)));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final <R> List<kotlin.u0<a2, R>> qd(@a7.d long[] zip, @a7.d R[] other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iMin = Math.min(b2.o(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            long jM = b2.m(zip, i7);
            arrayList.add(p1.a(a2.b(jM), other[i7]));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <V> Map<a2, V> r0(long[] associateWith, l<? super a2, ? extends V> valueSelector) {
        l0.p(associateWith, "$this$associateWith");
        l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(kotlin.collections.b1.j(b2.o(associateWith)), 16));
        int iO = b2.o(associateWith);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(associateWith, i7);
            linkedHashMap.put(a2.b(jM), valueSelector.z(a2.b(jM)));
        }
        return linkedHashMap;
    }

    static /* synthetic */ long[] r1(long[] copyInto, long[] destination, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = b2.o(copyInto);
        }
        l0.p(copyInto, "$this$copyInto");
        l0.p(destination, "destination");
        o.b1(copyInto, destination, i7, i8, i9);
        return destination;
    }

    public static /* synthetic */ void r2(long[] jArr, long j7, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = b2.o(jArr);
        }
        q2(jArr, j7, i7, i8);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> r3(long[] flatMap, l<? super a2, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMap, "$this$flatMap");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = b2.o(flatMap);
        for (int i7 = 0; i7 < iO; i7++) {
            d0.o0(arrayList, transform.z(a2.b(b2.m(flatMap, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    public static /* synthetic */ void r4(long[] jArr) {
    }

    @g1(version = "1.3")
    @t
    @e
    public static final s1 r5(@a7.d byte[] lastOrNull) {
        l0.p(lastOrNull, "$this$lastOrNull");
        if (t1.s(lastOrNull)) {
            return null;
        }
        return s1.b(t1.m(lastOrNull, t1.o(lastOrNull) - 1));
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R r6(short[] maxOfOrNull, l<? super g2, ? extends R> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (h2.s(maxOfOrNull)) {
            return null;
        }
        R rZ = selector.z(g2.b(h2.m(maxOfOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Ye(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(g2.b(h2.m(maxOfOrNull, it.b())));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Float r7(long[] minOfOrNull, l<? super a2, Float> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (b2.s(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.z(a2.b(b2.m(minOfOrNull, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.We(minOfOrNull)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(a2.b(b2.m(minOfOrNull, it.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte[] r8(byte[] plus, byte[] elements) {
        l0.p(plus, "$this$plus");
        l0.p(elements, "elements");
        return t1.f(o.H3(plus, elements));
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final w1 r9(int[] reduceRightOrNull, p<? super w1, ? super w1, w1> operation) {
        l0.p(reduceRightOrNull, "$this$reduceRightOrNull");
        l0.p(operation, "operation");
        int iVe = kotlin.collections.p.Ve(reduceRightOrNull);
        if (iVe < 0) {
            return null;
        }
        int iM = x1.m(reduceRightOrNull, iVe);
        for (int i7 = iVe - 1; i7 >= 0; i7--) {
            iM = operation.a0(w1.b(x1.m(reduceRightOrNull, i7)), w1.b(iM)).g0();
        }
        return w1.b(iM);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte ra(byte[] single) {
        l0.p(single, "$this$single");
        return s1.h(kotlin.collections.p.vt(single));
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<s1> rb(@a7.d byte[] sorted) {
        l0.p(sorted, "$this$sorted");
        byte[] bArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        l0.o(bArrCopyOf, "copyOf(this, size)");
        byte[] bArrF = t1.f(bArrCopyOf);
        db(bArrF);
        return kotlin.collections.unsigned.b.b(bArrF);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<g2> rc(@a7.d short[] take, int i7) {
        l0.p(take, "$this$take");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return y.F();
        }
        if (i7 >= h2.o(take)) {
            return g0.Q5(h2.b(take));
        }
        if (i7 == 1) {
            return x.l(g2.b(h2.m(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i7);
        int iO = h2.o(take);
        int i8 = 0;
        for (int i9 = 0; i9 < iO; i9++) {
            arrayList.add(g2.b(h2.m(take, i9)));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <V> List<V> rd(short[] zip, short[] other, p<? super g2, ? super g2, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iMin = Math.min(h2.o(zip), h2.o(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(g2.b(h2.m(zip, i7)), g2.b(h2.m(other, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <V> Map<w1, V> s0(int[] associateWith, l<? super w1, ? extends V> valueSelector) {
        l0.p(associateWith, "$this$associateWith");
        l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(kotlin.collections.b1.j(x1.o(associateWith)), 16));
        int iO = x1.o(associateWith);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(associateWith, i7);
            linkedHashMap.put(w1.b(iM), valueSelector.z(w1.b(iM)));
        }
        return linkedHashMap;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short[] s1(short[] copyInto, short[] destination, int i7, int i8, int i9) {
        l0.p(copyInto, "$this$copyInto");
        l0.p(destination, "destination");
        o.d1(copyInto, destination, i7, i8, i9);
        return destination;
    }

    @g1(version = "1.3")
    @t
    public static final void s2(@a7.d byte[] fill, byte b8, int i7, int i8) {
        l0.p(fill, "$this$fill");
        o.h2(fill, b8, i7, i8);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> s3(int[] flatMap, l<? super w1, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMap, "$this$flatMap");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = x1.o(flatMap);
        for (int i7 = 0; i7 < iO; i7++) {
            d0.o0(arrayList, transform.z(w1.b(x1.m(flatMap, i7))));
        }
        return arrayList;
    }

    public static final int s4(@a7.d short[] lastIndex) {
        l0.p(lastIndex, "$this$lastIndex");
        return kotlin.collections.p.Ye(lastIndex);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final s1 s5(byte[] lastOrNull, l<? super s1, Boolean> predicate) {
        l0.p(lastOrNull, "$this$lastOrNull");
        l0.p(predicate, "predicate");
        int iO = t1.o(lastOrNull) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i7 = iO - 1;
            byte bM = t1.m(lastOrNull, iO);
            if (predicate.z(s1.b(bM)).booleanValue()) {
                return s1.b(bM);
            }
            if (i7 < 0) {
                return null;
            }
            iO = i7;
        }
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Double s6(short[] maxOfOrNull, l<? super g2, Double> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (h2.s(maxOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.z(g2.b(h2.m(maxOfOrNull, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Ye(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(g2.b(h2.m(maxOfOrNull, it.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R s7(int[] minOfOrNull, l<? super w1, ? extends R> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (x1.s(minOfOrNull)) {
            return null;
        }
        R rZ = selector.z(w1.b(x1.m(minOfOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Ve(minOfOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(w1.b(x1.m(minOfOrNull, it.b())));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final long[] s8(@a7.d long[] plus, @a7.d Collection<a2> elements) {
        l0.p(plus, "$this$plus");
        l0.p(elements, "elements");
        int iO = b2.o(plus);
        long[] jArrCopyOf = Arrays.copyOf(plus, b2.o(plus) + elements.size());
        l0.o(jArrCopyOf, "copyOf(this, newSize)");
        Iterator<a2> it = elements.iterator();
        while (it.hasNext()) {
            jArrCopyOf[iO] = it.next().g0();
            iO++;
        }
        return b2.f(jArrCopyOf);
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final a2 s9(long[] reduceRightOrNull, p<? super a2, ? super a2, a2> operation) {
        l0.p(reduceRightOrNull, "$this$reduceRightOrNull");
        l0.p(operation, "operation");
        int iWe = kotlin.collections.p.We(reduceRightOrNull);
        if (iWe < 0) {
            return null;
        }
        long jM = b2.m(reduceRightOrNull, iWe);
        for (int i7 = iWe - 1; i7 >= 0; i7--) {
            jM = operation.a0(a2.b(b2.m(reduceRightOrNull, i7)), a2.b(jM)).g0();
        }
        return a2.b(jM);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte sa(byte[] single, l<? super s1, Boolean> predicate) {
        l0.p(single, "$this$single");
        l0.p(predicate, "predicate");
        int iO = t1.o(single);
        s1 s1VarB = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(single, i7);
            if (predicate.z(s1.b(bM)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                s1VarB = s1.b(bM);
                z7 = true;
            }
        }
        if (z7) {
            return s1VarB.e0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<a2> sb(@a7.d long[] sorted) {
        l0.p(sorted, "$this$sorted");
        long[] jArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        l0.o(jArrCopyOf, "copyOf(this, size)");
        long[] jArrF = b2.f(jArrCopyOf);
        eb(jArrF);
        return kotlin.collections.unsigned.b.c(jArrF);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<w1> sc(@a7.d int[] take, int i7) {
        l0.p(take, "$this$take");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return y.F();
        }
        if (i7 >= x1.o(take)) {
            return g0.Q5(x1.b(take));
        }
        if (i7 == 1) {
            return x.l(w1.b(x1.m(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i7);
        int iO = x1.o(take);
        int i8 = 0;
        for (int i9 = 0; i9 < iO; i9++) {
            arrayList.add(w1.b(x1.m(take, i9)));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R, V> List<V> sd(short[] zip, Iterable<? extends R> other, p<? super g2, ? super R, ? extends V> transform) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        l0.p(transform, "transform");
        int iO = h2.o(zip);
        ArrayList arrayList = new ArrayList(Math.min(z.Z(other, 10), iO));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= iO) {
                break;
            }
            arrayList.add(transform.a0(g2.b(h2.m(zip, i7)), r7));
            i7++;
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <V> Map<g2, V> t0(short[] associateWith, l<? super g2, ? extends V> valueSelector) {
        l0.p(associateWith, "$this$associateWith");
        l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(kotlin.collections.b1.j(h2.o(associateWith)), 16));
        int iO = h2.o(associateWith);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(associateWith, i7);
            linkedHashMap.put(g2.b(sM), valueSelector.z(g2.b(sM)));
        }
        return linkedHashMap;
    }

    static /* synthetic */ short[] t1(short[] copyInto, short[] destination, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = h2.o(copyInto);
        }
        l0.p(copyInto, "$this$copyInto");
        l0.p(destination, "destination");
        o.d1(copyInto, destination, i7, i8, i9);
        return destination;
    }

    public static /* synthetic */ void t2(byte[] bArr, byte b8, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = t1.o(bArr);
        }
        s2(bArr, b8, i7, i8);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> t3(short[] flatMap, l<? super g2, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMap, "$this$flatMap");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = h2.o(flatMap);
        for (int i7 = 0; i7 < iO; i7++) {
            d0.o0(arrayList, transform.z(g2.b(h2.m(flatMap, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    public static /* synthetic */ void t4(short[] sArr) {
    }

    @g1(version = "1.3")
    @t
    @f
    private static final a2 t5(long[] lastOrNull, l<? super a2, Boolean> predicate) {
        l0.p(lastOrNull, "$this$lastOrNull");
        l0.p(predicate, "predicate");
        int iO = b2.o(lastOrNull) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i7 = iO - 1;
            long jM = b2.m(lastOrNull, iO);
            if (predicate.z(a2.b(jM)).booleanValue()) {
                return a2.b(jM);
            }
            if (i7 < 0) {
                return null;
            }
            iO = i7;
        }
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Float t6(short[] maxOfOrNull, l<? super g2, Float> selector) {
        l0.p(maxOfOrNull, "$this$maxOfOrNull");
        l0.p(selector, "selector");
        if (h2.s(maxOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.z(g2.b(h2.m(maxOfOrNull, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Ye(maxOfOrNull)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(g2.b(h2.m(maxOfOrNull, it.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Double t7(int[] minOfOrNull, l<? super w1, Double> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (x1.s(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.z(w1.b(x1.m(minOfOrNull, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Ve(minOfOrNull)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(w1.b(x1.m(minOfOrNull, it.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short[] t8(short[] plus, short[] elements) {
        l0.p(plus, "$this$plus");
        l0.p(elements, "elements");
        return h2.f(o.c4(plus, elements));
    }

    @g1(version = "1.4")
    @t
    @q2(markerClass = {s.class})
    @f
    private static final g2 t9(short[] reduceRightOrNull, p<? super g2, ? super g2, g2> operation) {
        l0.p(reduceRightOrNull, "$this$reduceRightOrNull");
        l0.p(operation, "operation");
        int iYe = kotlin.collections.p.Ye(reduceRightOrNull);
        if (iYe < 0) {
            return null;
        }
        short sM = h2.m(reduceRightOrNull, iYe);
        for (int i7 = iYe - 1; i7 >= 0; i7--) {
            sM = operation.a0(g2.b(h2.m(reduceRightOrNull, i7)), g2.b(sM)).e0();
        }
        return g2.b(sM);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long ta(long[] single, l<? super a2, Boolean> predicate) {
        l0.p(single, "$this$single");
        l0.p(predicate, "predicate");
        int iO = b2.o(single);
        a2 a2VarB = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(single, i7);
            if (predicate.z(a2.b(jM)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                a2VarB = a2.b(jM);
                z7 = true;
            }
        }
        if (z7) {
            return a2VarB.g0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<g2> tb(@a7.d short[] sorted) {
        l0.p(sorted, "$this$sorted");
        short[] sArrCopyOf = Arrays.copyOf(sorted, sorted.length);
        l0.o(sArrCopyOf, "copyOf(this, size)");
        short[] sArrF = h2.f(sArrCopyOf);
        hb(sArrF);
        return kotlin.collections.unsigned.b.d(sArrF);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<a2> tc(@a7.d long[] take, int i7) {
        l0.p(take, "$this$take");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return y.F();
        }
        if (i7 >= b2.o(take)) {
            return g0.Q5(b2.b(take));
        }
        if (i7 == 1) {
            return x.l(a2.b(b2.m(take, 0)));
        }
        ArrayList arrayList = new ArrayList(i7);
        int iO = b2.o(take);
        int i8 = 0;
        for (int i9 = 0; i9 < iO; i9++) {
            arrayList.add(a2.b(b2.m(take, i9)));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<kotlin.u0<s1, s1>> td(@a7.d byte[] zip, @a7.d byte[] other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iMin = Math.min(t1.o(zip), t1.o(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(p1.a(s1.b(t1.m(zip, i7)), s1.b(t1.m(other, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <V, M extends Map<? super w1, ? super V>> M u0(int[] associateWithTo, M destination, l<? super w1, ? extends V> valueSelector) {
        l0.p(associateWithTo, "$this$associateWithTo");
        l0.p(destination, "destination");
        l0.p(valueSelector, "valueSelector");
        int iO = x1.o(associateWithTo);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(associateWithTo, i7);
            destination.put(w1.b(iM), valueSelector.z(w1.b(iM)));
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte[] u1(byte[] copyInto, byte[] destination, int i7, int i8, int i9) {
        l0.p(copyInto, "$this$copyInto");
        l0.p(destination, "destination");
        o.W0(copyInto, destination, i7, i8, i9);
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<s1> u2(byte[] filter, l<? super s1, Boolean> predicate) {
        l0.p(filter, "$this$filter");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = t1.o(filter);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(filter, i7);
            if (predicate.z(s1.b(bM)).booleanValue()) {
                arrayList.add(s1.b(bM));
            }
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> List<R> u3(byte[] flatMapIndexed, p<? super Integer, ? super s1, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapIndexed, "$this$flatMapIndexed");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = t1.o(flatMapIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), s1.b(t1.m(flatMapIndexed, i7))));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short u4(short[] getOrElse, int i7, l<? super Integer, g2> defaultValue) {
        l0.p(getOrElse, "$this$getOrElse");
        l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > kotlin.collections.p.Ye(getOrElse)) ? defaultValue.z(Integer.valueOf(i7)).e0() : h2.m(getOrElse, i7);
    }

    @g1(version = "1.3")
    @t
    @e
    public static final a2 u5(@a7.d long[] lastOrNull) {
        l0.p(lastOrNull, "$this$lastOrNull");
        if (b2.s(lastOrNull)) {
            return null;
        }
        return a2.b(b2.m(lastOrNull, b2.o(lastOrNull) - 1));
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R u6(long[] maxOfWith, Comparator<? super R> comparator, l<? super a2, ? extends R> selector) {
        l0.p(maxOfWith, "$this$maxOfWith");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (b2.s(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(a2.b(b2.m(maxOfWith, 0)));
        u0 it = new k(1, kotlin.collections.p.We(maxOfWith)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(a2.b(b2.m(maxOfWith, it.b())));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Float u7(int[] minOfOrNull, l<? super w1, Float> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (x1.s(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.z(w1.b(x1.m(minOfOrNull, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Ve(minOfOrNull)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(w1.b(x1.m(minOfOrNull, it.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final short[] u8(@a7.d short[] plus, @a7.d Collection<g2> elements) {
        l0.p(plus, "$this$plus");
        l0.p(elements, "elements");
        int iO = h2.o(plus);
        short[] sArrCopyOf = Arrays.copyOf(plus, h2.o(plus) + elements.size());
        l0.o(sArrCopyOf, "copyOf(this, newSize)");
        Iterator<g2> it = elements.iterator();
        while (it.hasNext()) {
            sArrCopyOf[iO] = it.next().e0();
            iO++;
        }
        return h2.f(sArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void u9(int[] reverse) {
        l0.p(reverse, "$this$reverse");
        kotlin.collections.p.yr(reverse);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long ua(long[] single) {
        l0.p(single, "$this$single");
        return a2.h(kotlin.collections.p.Ft(single));
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final int[] ub(@a7.d int[] sortedArray) {
        l0.p(sortedArray, "$this$sortedArray");
        if (x1.s(sortedArray)) {
            return sortedArray;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        l0.o(iArrCopyOf, "copyOf(this, size)");
        int[] iArrF = x1.f(iArrCopyOf);
        Wa(iArrF);
        return iArrF;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<s1> uc(@a7.d byte[] takeLast, int i7) {
        l0.p(takeLast, "$this$takeLast");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return y.F();
        }
        int iO = t1.o(takeLast);
        if (i7 >= iO) {
            return g0.Q5(t1.b(takeLast));
        }
        if (i7 == 1) {
            return x.l(s1.b(t1.m(takeLast, iO - 1)));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = iO - i7; i8 < iO; i8++) {
            arrayList.add(s1.b(t1.m(takeLast, i8)));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<kotlin.u0<g2, g2>> ud(@a7.d short[] zip, @a7.d short[] other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iMin = Math.min(h2.o(zip), h2.o(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(p1.a(g2.b(h2.m(zip, i7)), g2.b(h2.m(other, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <V, M extends Map<? super s1, ? super V>> M v0(byte[] associateWithTo, M destination, l<? super s1, ? extends V> valueSelector) {
        l0.p(associateWithTo, "$this$associateWithTo");
        l0.p(destination, "destination");
        l0.p(valueSelector, "valueSelector");
        int iO = t1.o(associateWithTo);
        for (int i7 = 0; i7 < iO; i7++) {
            byte bM = t1.m(associateWithTo, i7);
            destination.put(s1.b(bM), valueSelector.z(s1.b(bM)));
        }
        return destination;
    }

    static /* synthetic */ byte[] v1(byte[] copyInto, byte[] destination, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = t1.o(copyInto);
        }
        l0.p(copyInto, "$this$copyInto");
        l0.p(destination, "destination");
        o.W0(copyInto, destination, i7, i8, i9);
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<a2> v2(long[] filter, l<? super a2, Boolean> predicate) {
        l0.p(filter, "$this$filter");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = b2.o(filter);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(filter, i7);
            if (predicate.z(a2.b(jM)).booleanValue()) {
                arrayList.add(a2.b(jM));
            }
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> List<R> v3(int[] flatMapIndexed, p<? super Integer, ? super w1, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapIndexed, "$this$flatMapIndexed");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = x1.o(flatMapIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), w1.b(x1.m(flatMapIndexed, i7))));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int v4(int[] getOrElse, int i7, l<? super Integer, w1> defaultValue) {
        l0.p(getOrElse, "$this$getOrElse");
        l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > kotlin.collections.p.Ve(getOrElse)) ? defaultValue.z(Integer.valueOf(i7)).g0() : x1.m(getOrElse, i7);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final w1 v5(int[] lastOrNull, l<? super w1, Boolean> predicate) {
        l0.p(lastOrNull, "$this$lastOrNull");
        l0.p(predicate, "predicate");
        int iO = x1.o(lastOrNull) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i7 = iO - 1;
            int iM = x1.m(lastOrNull, iO);
            if (predicate.z(w1.b(iM)).booleanValue()) {
                return w1.b(iM);
            }
            if (i7 < 0) {
                return null;
            }
            iO = i7;
        }
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R v6(byte[] maxOfWith, Comparator<? super R> comparator, l<? super s1, ? extends R> selector) {
        l0.p(maxOfWith, "$this$maxOfWith");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (t1.s(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(s1.b(t1.m(maxOfWith, 0)));
        u0 it = new k(1, kotlin.collections.p.Re(maxOfWith)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(s1.b(t1.m(maxOfWith, it.b())));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R extends Comparable<? super R>> R v7(short[] minOfOrNull, l<? super g2, ? extends R> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (h2.s(minOfOrNull)) {
            return null;
        }
        R rZ = selector.z(g2.b(h2.m(minOfOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Ye(minOfOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(g2.b(h2.m(minOfOrNull, it.b())));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int[] v8(int[] plus, int i7) {
        l0.p(plus, "$this$plus");
        return x1.f(o.R3(plus, i7));
    }

    @g1(version = "1.4")
    @t
    @f
    private static final void v9(long[] reverse, int i7, int i8) {
        l0.p(reverse, "$this$reverse");
        kotlin.collections.p.Br(reverse, i7, i8);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int va(int[] single, l<? super w1, Boolean> predicate) {
        l0.p(single, "$this$single");
        l0.p(predicate, "predicate");
        int iO = x1.o(single);
        w1 w1VarB = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(single, i7);
            if (predicate.z(w1.b(iM)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                w1VarB = w1.b(iM);
                z7 = true;
            }
        }
        if (z7) {
            return w1VarB.g0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final byte[] vb(@a7.d byte[] sortedArray) {
        l0.p(sortedArray, "$this$sortedArray");
        if (t1.s(sortedArray)) {
            return sortedArray;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        l0.o(bArrCopyOf, "copyOf(this, size)");
        byte[] bArrF = t1.f(bArrCopyOf);
        db(bArrF);
        return bArrF;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<g2> vc(@a7.d short[] takeLast, int i7) {
        l0.p(takeLast, "$this$takeLast");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return y.F();
        }
        int iO = h2.o(takeLast);
        if (i7 >= iO) {
            return g0.Q5(h2.b(takeLast));
        }
        if (i7 == 1) {
            return x.l(g2.b(h2.m(takeLast, iO - 1)));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = iO - i7; i8 < iO; i8++) {
            arrayList.add(g2.b(h2.m(takeLast, i8)));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final <R> List<kotlin.u0<s1, R>> vd(@a7.d byte[] zip, @a7.d R[] other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iMin = Math.min(t1.o(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            byte bM = t1.m(zip, i7);
            arrayList.add(p1.a(s1.b(bM), other[i7]));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <V, M extends Map<? super a2, ? super V>> M w0(long[] associateWithTo, M destination, l<? super a2, ? extends V> valueSelector) {
        l0.p(associateWithTo, "$this$associateWithTo");
        l0.p(destination, "destination");
        l0.p(valueSelector, "valueSelector");
        int iO = b2.o(associateWithTo);
        for (int i7 = 0; i7 < iO; i7++) {
            long jM = b2.m(associateWithTo, i7);
            destination.put(a2.b(jM), valueSelector.z(a2.b(jM)));
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int[] w1(int[] copyInto, int[] destination, int i7, int i8, int i9) {
        l0.p(copyInto, "$this$copyInto");
        l0.p(destination, "destination");
        o.a1(copyInto, destination, i7, i8, i9);
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<w1> w2(int[] filter, l<? super w1, Boolean> predicate) {
        l0.p(filter, "$this$filter");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = x1.o(filter);
        for (int i7 = 0; i7 < iO; i7++) {
            int iM = x1.m(filter, i7);
            if (predicate.z(w1.b(iM)).booleanValue()) {
                arrayList.add(w1.b(iM));
            }
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> List<R> w3(long[] flatMapIndexed, p<? super Integer, ? super a2, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapIndexed, "$this$flatMapIndexed");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = b2.o(flatMapIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), a2.b(b2.m(flatMapIndexed, i7))));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long w4(long[] getOrElse, int i7, l<? super Integer, a2> defaultValue) {
        l0.p(getOrElse, "$this$getOrElse");
        l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > kotlin.collections.p.We(getOrElse)) ? defaultValue.z(Integer.valueOf(i7)).g0() : b2.m(getOrElse, i7);
    }

    @g1(version = "1.3")
    @t
    @e
    public static final g2 w5(@a7.d short[] lastOrNull) {
        l0.p(lastOrNull, "$this$lastOrNull");
        if (h2.s(lastOrNull)) {
            return null;
        }
        return g2.b(h2.m(lastOrNull, h2.o(lastOrNull) - 1));
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R w6(short[] maxOfWith, Comparator<? super R> comparator, l<? super g2, ? extends R> selector) {
        l0.p(maxOfWith, "$this$maxOfWith");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (h2.s(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(g2.b(h2.m(maxOfWith, 0)));
        u0 it = new k(1, kotlin.collections.p.Ye(maxOfWith)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(g2.b(h2.m(maxOfWith, it.b())));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Double w7(short[] minOfOrNull, l<? super g2, Double> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (h2.s(minOfOrNull)) {
            return null;
        }
        double dDoubleValue = selector.z(g2.b(h2.m(minOfOrNull, 0))).doubleValue();
        u0 it = new k(1, kotlin.collections.p.Ye(minOfOrNull)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(g2.b(h2.m(minOfOrNull, it.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final long[] w8(long[] plus, long[] elements) {
        l0.p(plus, "$this$plus");
        l0.p(elements, "elements");
        return b2.f(o.W3(plus, elements));
    }

    @g1(version = "1.4")
    @t
    @f
    private static final void w9(byte[] reverse, int i7, int i8) {
        l0.p(reverse, "$this$reverse");
        kotlin.collections.p.rr(reverse, i7, i8);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short wa(short[] single) {
        l0.p(single, "$this$single");
        return g2.h(kotlin.collections.p.Jt(single));
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final long[] wb(@a7.d long[] sortedArray) {
        l0.p(sortedArray, "$this$sortedArray");
        if (b2.s(sortedArray)) {
            return sortedArray;
        }
        long[] jArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        l0.o(jArrCopyOf, "copyOf(this, size)");
        long[] jArrF = b2.f(jArrCopyOf);
        eb(jArrF);
        return jArrF;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<w1> wc(@a7.d int[] takeLast, int i7) {
        l0.p(takeLast, "$this$takeLast");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return y.F();
        }
        int iO = x1.o(takeLast);
        if (i7 >= iO) {
            return g0.Q5(x1.b(takeLast));
        }
        if (i7 == 1) {
            return x.l(w1.b(x1.m(takeLast, iO - 1)));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = iO - i7; i8 < iO; i8++) {
            arrayList.add(w1.b(x1.m(takeLast, i8)));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final <R> List<kotlin.u0<g2, R>> wd(@a7.d short[] zip, @a7.d R[] other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iMin = Math.min(h2.o(zip), other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            short sM = h2.m(zip, i7);
            arrayList.add(p1.a(g2.b(sM), other[i7]));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @f
    private static final <V, M extends Map<? super g2, ? super V>> M x0(short[] associateWithTo, M destination, l<? super g2, ? extends V> valueSelector) {
        l0.p(associateWithTo, "$this$associateWithTo");
        l0.p(destination, "destination");
        l0.p(valueSelector, "valueSelector");
        int iO = h2.o(associateWithTo);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(associateWithTo, i7);
            destination.put(g2.b(sM), valueSelector.z(g2.b(sM)));
        }
        return destination;
    }

    static /* synthetic */ int[] x1(int[] copyInto, int[] destination, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = x1.o(copyInto);
        }
        l0.p(copyInto, "$this$copyInto");
        l0.p(destination, "destination");
        o.a1(copyInto, destination, i7, i8, i9);
        return destination;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<g2> x2(short[] filter, l<? super g2, Boolean> predicate) {
        l0.p(filter, "$this$filter");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = h2.o(filter);
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(filter, i7);
            if (predicate.z(g2.b(sM)).booleanValue()) {
                arrayList.add(g2.b(sM));
            }
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> List<R> x3(short[] flatMapIndexed, p<? super Integer, ? super g2, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapIndexed, "$this$flatMapIndexed");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int iO = h2.o(flatMapIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), g2.b(h2.m(flatMapIndexed, i7))));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte x4(byte[] getOrElse, int i7, l<? super Integer, s1> defaultValue) {
        l0.p(getOrElse, "$this$getOrElse");
        l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > kotlin.collections.p.Re(getOrElse)) ? defaultValue.z(Integer.valueOf(i7)).e0() : t1.m(getOrElse, i7);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final g2 x5(short[] lastOrNull, l<? super g2, Boolean> predicate) {
        l0.p(lastOrNull, "$this$lastOrNull");
        l0.p(predicate, "predicate");
        int iO = h2.o(lastOrNull) - 1;
        if (iO < 0) {
            return null;
        }
        while (true) {
            int i7 = iO - 1;
            short sM = h2.m(lastOrNull, iO);
            if (predicate.z(g2.b(sM)).booleanValue()) {
                return g2.b(sM);
            }
            if (i7 < 0) {
                return null;
            }
            iO = i7;
        }
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R x6(int[] maxOfWith, Comparator<? super R> comparator, l<? super w1, ? extends R> selector) {
        l0.p(maxOfWith, "$this$maxOfWith");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (x1.s(maxOfWith)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(w1.b(x1.m(maxOfWith, 0)));
        u0 it = new k(1, kotlin.collections.p.Ve(maxOfWith)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(w1.b(x1.m(maxOfWith, it.b())));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final Float x7(short[] minOfOrNull, l<? super g2, Float> selector) {
        l0.p(minOfOrNull, "$this$minOfOrNull");
        l0.p(selector, "selector");
        if (h2.s(minOfOrNull)) {
            return null;
        }
        float fFloatValue = selector.z(g2.b(h2.m(minOfOrNull, 0))).floatValue();
        u0 it = new k(1, kotlin.collections.p.Ye(minOfOrNull)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(g2.b(h2.m(minOfOrNull, it.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final byte[] x8(@a7.d byte[] plus, @a7.d Collection<s1> elements) {
        l0.p(plus, "$this$plus");
        l0.p(elements, "elements");
        int iO = t1.o(plus);
        byte[] bArrCopyOf = Arrays.copyOf(plus, t1.o(plus) + elements.size());
        l0.o(bArrCopyOf, "copyOf(this, newSize)");
        Iterator<s1> it = elements.iterator();
        while (it.hasNext()) {
            bArrCopyOf[iO] = it.next().e0();
            iO++;
        }
        return t1.f(bArrCopyOf);
    }

    @g1(version = "1.4")
    @t
    @f
    private static final void x9(short[] reverse, int i7, int i8) {
        l0.p(reverse, "$this$reverse");
        kotlin.collections.p.Fr(reverse, i7, i8);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final short xa(short[] single, l<? super g2, Boolean> predicate) {
        l0.p(single, "$this$single");
        l0.p(predicate, "predicate");
        int iO = h2.o(single);
        g2 g2VarB = null;
        boolean z7 = false;
        for (int i7 = 0; i7 < iO; i7++) {
            short sM = h2.m(single, i7);
            if (predicate.z(g2.b(sM)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                g2VarB = g2.b(sM);
                z7 = true;
            }
        }
        if (z7) {
            return g2VarB.e0();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final short[] xb(@a7.d short[] sortedArray) {
        l0.p(sortedArray, "$this$sortedArray");
        if (h2.s(sortedArray)) {
            return sortedArray;
        }
        short[] sArrCopyOf = Arrays.copyOf(sortedArray, sortedArray.length);
        l0.o(sArrCopyOf, "copyOf(this, size)");
        short[] sArrF = h2.f(sArrCopyOf);
        hb(sArrF);
        return sArrF;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<a2> xc(@a7.d long[] takeLast, int i7) {
        l0.p(takeLast, "$this$takeLast");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return y.F();
        }
        int iO = b2.o(takeLast);
        if (i7 >= iO) {
            return g0.Q5(b2.b(takeLast));
        }
        if (i7 == 1) {
            return x.l(a2.b(b2.m(takeLast, iO - 1)));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = iO - i7; i8 < iO; i8++) {
            arrayList.add(a2.b(b2.m(takeLast, i8)));
        }
        return arrayList;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final List<kotlin.u0<a2, a2>> xd(@a7.d long[] zip, @a7.d long[] other) {
        l0.p(zip, "$this$zip");
        l0.p(other, "other");
        int iMin = Math.min(b2.o(zip), b2.o(other));
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(p1.a(a2.b(b2.m(zip, i7)), a2.b(b2.m(other, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int y0(int[] component1) {
        l0.p(component1, "$this$component1");
        return x1.m(component1, 0);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int[] y1(int[] copyOf) {
        l0.p(copyOf, "$this$copyOf");
        int[] iArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        l0.o(iArrCopyOf, "copyOf(this, size)");
        return x1.f(iArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<s1> y2(byte[] filterIndexed, p<? super Integer, ? super s1, Boolean> predicate) {
        l0.p(filterIndexed, "$this$filterIndexed");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = t1.o(filterIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            byte bM = t1.m(filterIndexed, i7);
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), s1.b(bM)).booleanValue()) {
                arrayList.add(s1.b(bM));
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R, C extends Collection<? super R>> C y3(int[] flatMapIndexedTo, C destination, p<? super Integer, ? super w1, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapIndexedTo, "$this$flatMapIndexedTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = x1.o(flatMapIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), w1.b(x1.m(flatMapIndexedTo, i7))));
            i7++;
            i8++;
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @e
    public static final s1 y4(@a7.d byte[] getOrNull, int i7) {
        l0.p(getOrNull, "$this$getOrNull");
        if (i7 < 0 || i7 > kotlin.collections.p.Re(getOrNull)) {
            return null;
        }
        return s1.b(t1.m(getOrNull, i7));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> y5(byte[] map, l<? super s1, ? extends R> transform) {
        l0.p(map, "$this$map");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(t1.o(map));
        int iO = t1.o(map);
        for (int i7 = 0; i7 < iO; i7++) {
            arrayList.add(transform.z(s1.b(t1.m(map, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R y6(long[] maxOfWithOrNull, Comparator<? super R> comparator, l<? super a2, ? extends R> selector) {
        l0.p(maxOfWithOrNull, "$this$maxOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (b2.s(maxOfWithOrNull)) {
            return null;
        }
        R rZ = selector.z(a2.b(b2.m(maxOfWithOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.We(maxOfWithOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(a2.b(b2.m(maxOfWithOrNull, it.b())));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R y7(long[] minOfWith, Comparator<? super R> comparator, l<? super a2, ? extends R> selector) {
        l0.p(minOfWith, "$this$minOfWith");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (b2.s(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(a2.b(b2.m(minOfWith, 0)));
        u0 it = new k(1, kotlin.collections.p.We(minOfWith)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(a2.b(b2.m(minOfWith, it.b())));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final int y8(int[] random) {
        l0.p(random, "$this$random");
        return z8(random, kotlin.random.f.f34998a);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void y9(byte[] reverse) {
        l0.p(reverse, "$this$reverse");
        kotlin.collections.p.qr(reverse);
    }

    @g1(version = "1.3")
    @t
    @e
    public static final w1 ya(@a7.d int[] singleOrNull) {
        l0.p(singleOrNull, "$this$singleOrNull");
        if (x1.o(singleOrNull) == 1) {
            return w1.b(x1.m(singleOrNull, 0));
        }
        return null;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final int[] yb(@a7.d int[] sortedArrayDescending) {
        l0.p(sortedArrayDescending, "$this$sortedArrayDescending");
        if (x1.s(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        int[] iArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        l0.o(iArrCopyOf, "copyOf(this, size)");
        int[] iArrF = x1.f(iArrCopyOf);
        ib(iArrF);
        return iArrF;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<s1> yc(byte[] takeLastWhile, l<? super s1, Boolean> predicate) {
        l0.p(takeLastWhile, "$this$takeLastWhile");
        l0.p(predicate, "predicate");
        for (int iRe = kotlin.collections.p.Re(takeLastWhile); -1 < iRe; iRe--) {
            if (!predicate.z(s1.b(t1.m(takeLastWhile, iRe))).booleanValue()) {
                return O1(takeLastWhile, iRe + 1);
            }
        }
        return g0.Q5(t1.b(takeLastWhile));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte z0(byte[] component1) {
        l0.p(component1, "$this$component1");
        return t1.m(component1, 0);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final byte[] z1(byte[] copyOf) {
        l0.p(copyOf, "$this$copyOf");
        byte[] bArrCopyOf = Arrays.copyOf(copyOf, copyOf.length);
        l0.o(bArrCopyOf, "copyOf(this, size)");
        return t1.f(bArrCopyOf);
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<w1> z2(int[] filterIndexed, p<? super Integer, ? super w1, Boolean> predicate) {
        l0.p(filterIndexed, "$this$filterIndexed");
        l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int iO = x1.o(filterIndexed);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            int iM = x1.m(filterIndexed, i7);
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), w1.b(iM)).booleanValue()) {
                arrayList.add(w1.b(iM));
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R, C extends Collection<? super R>> C z3(short[] flatMapIndexedTo, C destination, p<? super Integer, ? super g2, ? extends Iterable<? extends R>> transform) {
        l0.p(flatMapIndexedTo, "$this$flatMapIndexedTo");
        l0.p(destination, "destination");
        l0.p(transform, "transform");
        int iO = h2.o(flatMapIndexedTo);
        int i7 = 0;
        int i8 = 0;
        while (i7 < iO) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), g2.b(h2.m(flatMapIndexedTo, i7))));
            i7++;
            i8++;
        }
        return destination;
    }

    @g1(version = "1.3")
    @t
    @e
    public static final g2 z4(@a7.d short[] getOrNull, int i7) {
        l0.p(getOrNull, "$this$getOrNull");
        if (i7 < 0 || i7 > kotlin.collections.p.Ye(getOrNull)) {
            return null;
        }
        return g2.b(h2.m(getOrNull, i7));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final <R> List<R> z5(long[] map, l<? super a2, ? extends R> transform) {
        l0.p(map, "$this$map");
        l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(b2.o(map));
        int iO = b2.o(map);
        for (int i7 = 0; i7 < iO; i7++) {
            arrayList.add(transform.z(a2.b(b2.m(map, i7))));
        }
        return arrayList;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R z6(byte[] maxOfWithOrNull, Comparator<? super R> comparator, l<? super s1, ? extends R> selector) {
        l0.p(maxOfWithOrNull, "$this$maxOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (t1.s(maxOfWithOrNull)) {
            return null;
        }
        R rZ = selector.z(s1.b(t1.m(maxOfWithOrNull, 0)));
        u0 it = new k(1, kotlin.collections.p.Re(maxOfWithOrNull)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(s1.b(t1.m(maxOfWithOrNull, it.b())));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.4")
    @t
    @t0
    @f
    private static final <R> R z7(byte[] minOfWith, Comparator<? super R> comparator, l<? super s1, ? extends R> selector) {
        l0.p(minOfWith, "$this$minOfWith");
        l0.p(comparator, "comparator");
        l0.p(selector, "selector");
        if (t1.s(minOfWith)) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(s1.b(t1.m(minOfWith, 0)));
        u0 it = new k(1, kotlin.collections.p.Re(minOfWith)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(s1.b(t1.m(minOfWith, it.b())));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @g1(version = "1.3")
    @t
    public static final int z8(@a7.d int[] random, @a7.d kotlin.random.f random2) {
        l0.p(random, "$this$random");
        l0.p(random2, "random");
        if (x1.s(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return x1.m(random, random2.m(x1.o(random)));
    }

    @g1(version = "1.3")
    @t
    @f
    private static final void z9(long[] reverse) {
        l0.p(reverse, "$this$reverse");
        kotlin.collections.p.Ar(reverse);
    }

    @g1(version = "1.3")
    @t
    @e
    public static final s1 za(@a7.d byte[] singleOrNull) {
        l0.p(singleOrNull, "$this$singleOrNull");
        if (t1.o(singleOrNull) == 1) {
            return s1.b(t1.m(singleOrNull, 0));
        }
        return null;
    }

    @a7.d
    @g1(version = "1.3")
    @t
    public static final byte[] zb(@a7.d byte[] sortedArrayDescending) {
        l0.p(sortedArrayDescending, "$this$sortedArrayDescending");
        if (t1.s(sortedArrayDescending)) {
            return sortedArrayDescending;
        }
        byte[] bArrCopyOf = Arrays.copyOf(sortedArrayDescending, sortedArrayDescending.length);
        l0.o(bArrCopyOf, "copyOf(this, size)");
        byte[] bArrF = t1.f(bArrCopyOf);
        mb(bArrF);
        return bArrF;
    }

    @g1(version = "1.3")
    @t
    @f
    private static final List<a2> zc(long[] takeLastWhile, l<? super a2, Boolean> predicate) {
        l0.p(takeLastWhile, "$this$takeLastWhile");
        l0.p(predicate, "predicate");
        for (int iWe = kotlin.collections.p.We(takeLastWhile); -1 < iWe; iWe--) {
            if (!predicate.z(a2.b(b2.m(takeLastWhile, iWe))).booleanValue()) {
                return R1(takeLastWhile, iWe + 1);
            }
        }
        return g0.Q5(b2.b(takeLastWhile));
    }
}
