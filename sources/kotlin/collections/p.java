package kotlin.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.a2;
import kotlin.l2;
import kotlin.q2;
import kotlin.w1;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class p extends kotlin.collections.o {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterable<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f34568a;

        public a(Object[] objArr) {
            this.f34568a = objArr;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.i.a(this.f34568a);
        }
    }

    static final class a0 extends kotlin.jvm.internal.n0 implements i5.a<Iterator<? extends Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f34569a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a0(boolean[] zArr) {
            super(0);
            this.f34569a = zArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<Boolean> invoke() {
            return kotlin.jvm.internal.j.a(this.f34569a);
        }
    }

    public static final class b implements Iterable<Byte>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f34570a;

        public b(byte[] bArr) {
            this.f34570a = bArr;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.j.b(this.f34570a);
        }
    }

    static final class b0 extends kotlin.jvm.internal.n0 implements i5.a<Iterator<? extends Character>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ char[] f34571a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b0(char[] cArr) {
            super(0);
            this.f34571a = cArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<Character> invoke() {
            return kotlin.jvm.internal.j.c(this.f34571a);
        }
    }

    public static final class c implements Iterable<Short>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ short[] f34572a;

        public c(short[] sArr) {
            this.f34572a = sArr;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.j.h(this.f34572a);
        }
    }

    public static final class d implements Iterable<Integer>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f34573a;

        public d(int[] iArr) {
            this.f34573a = iArr;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.j.f(this.f34573a);
        }
    }

    public static final class e implements Iterable<Long>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f34574a;

        public e(long[] jArr) {
            this.f34574a = jArr;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.j.g(this.f34574a);
        }
    }

    public static final class f implements Iterable<Float>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f34575a;

        public f(float[] fArr) {
            this.f34575a = fArr;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.j.e(this.f34575a);
        }
    }

    public static final class g implements Iterable<Double>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ double[] f34576a;

        public g(double[] dArr) {
            this.f34576a = dArr;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.j.d(this.f34576a);
        }
    }

    public static final class h implements Iterable<Boolean>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f34577a;

        public h(boolean[] zArr) {
            this.f34577a = zArr;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.j.a(this.f34577a);
        }
    }

    public static final class i implements Iterable<Character>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ char[] f34578a;

        public i(char[] cArr) {
            this.f34578a = cArr;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.j.c(this.f34578a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class j<T> implements kotlin.sequences.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object[] f34579a;

        public j(Object[] objArr) {
            this.f34579a = objArr;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            return kotlin.jvm.internal.i.a(this.f34579a);
        }
    }

    public static final class k implements kotlin.sequences.m<Byte> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f34580a;

        public k(byte[] bArr) {
            this.f34580a = bArr;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.j.b(this.f34580a);
        }
    }

    public static final class l implements kotlin.sequences.m<Short> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ short[] f34581a;

        public l(short[] sArr) {
            this.f34581a = sArr;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.j.h(this.f34581a);
        }
    }

    public static final class m implements kotlin.sequences.m<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f34582a;

        public m(int[] iArr) {
            this.f34582a = iArr;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.j.f(this.f34582a);
        }
    }

    public static final class n implements kotlin.sequences.m<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f34583a;

        public n(long[] jArr) {
            this.f34583a = jArr;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.j.g(this.f34583a);
        }
    }

    public static final class o implements kotlin.sequences.m<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f34584a;

        public o(float[] fArr) {
            this.f34584a = fArr;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.j.e(this.f34584a);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.p$p, reason: collision with other inner class name */
    public static final class C0425p implements kotlin.sequences.m<Double> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ double[] f34585a;

        public C0425p(double[] dArr) {
            this.f34585a = dArr;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.j.d(this.f34585a);
        }
    }

    public static final class q implements kotlin.sequences.m<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f34586a;

        public q(boolean[] zArr) {
            this.f34586a = zArr;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.j.a(this.f34586a);
        }
    }

    public static final class r implements kotlin.sequences.m<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ char[] f34587a;

        public r(char[] cArr) {
            this.f34587a = cArr;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.j.c(this.f34587a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    public static final class s<K, T> implements n0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ T[] f34588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.l<T, K> f34589b;

        /* JADX WARN: Multi-variable type inference failed */
        public s(T[] tArr, i5.l<? super T, ? extends K> lVar) {
            this.f34588a = tArr;
            this.f34589b = lVar;
        }

        @Override // kotlin.collections.n0
        public K a(T t7) {
            return this.f34589b.z(t7);
        }

        @Override // kotlin.collections.n0
        @a7.d
        public Iterator<T> b() {
            return kotlin.jvm.internal.i.a(this.f34588a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class t<T> extends kotlin.jvm.internal.n0 implements i5.a<Iterator<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ T[] f34590a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(T[] tArr) {
            super(0);
            this.f34590a = tArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<T> invoke() {
            return kotlin.jvm.internal.i.a(this.f34590a);
        }
    }

    static final class u extends kotlin.jvm.internal.n0 implements i5.a<Iterator<? extends Byte>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f34591a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(byte[] bArr) {
            super(0);
            this.f34591a = bArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<Byte> invoke() {
            return kotlin.jvm.internal.j.b(this.f34591a);
        }
    }

    static final class v extends kotlin.jvm.internal.n0 implements i5.a<Iterator<? extends Short>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ short[] f34592a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(short[] sArr) {
            super(0);
            this.f34592a = sArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<Short> invoke() {
            return kotlin.jvm.internal.j.h(this.f34592a);
        }
    }

    static final class w extends kotlin.jvm.internal.n0 implements i5.a<Iterator<? extends Integer>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f34593a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(int[] iArr) {
            super(0);
            this.f34593a = iArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<Integer> invoke() {
            return kotlin.jvm.internal.j.f(this.f34593a);
        }
    }

    static final class x extends kotlin.jvm.internal.n0 implements i5.a<Iterator<? extends Long>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f34594a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(long[] jArr) {
            super(0);
            this.f34594a = jArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<Long> invoke() {
            return kotlin.jvm.internal.j.g(this.f34594a);
        }
    }

    static final class y extends kotlin.jvm.internal.n0 implements i5.a<Iterator<? extends Float>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f34595a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(float[] fArr) {
            super(0);
            this.f34595a = fArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<Float> invoke() {
            return kotlin.jvm.internal.j.e(this.f34595a);
        }
    }

    static final class z extends kotlin.jvm.internal.n0 implements i5.a<Iterator<? extends Double>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ double[] f34596a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(double[] dArr) {
            super(0);
            this.f34596a = dArr;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterator<Double> invoke() {
            return kotlin.jvm.internal.j.d(this.f34596a);
        }
    }

    public static final boolean A5(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (long j7 : jArr) {
            if (!predicate.z(Long.valueOf(j7)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    public static final <K, V> Map<K, V> A6(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends K> keySelector, @a7.d i5.l<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(cArr.length), 16));
        for (char c8 : cArr) {
            linkedHashMap.put(keySelector.z(Character.valueOf(c8)), valueTransform.z(Character.valueOf(c8)));
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V, M extends Map<? super Character, ? super V>> M A7(char[] cArr, M destination, i5.l<? super Character, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        for (char c8 : cArr) {
            destination.put(Character.valueOf(c8), valueSelector.z(Character.valueOf(c8)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final long A8(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr[3];
    }

    @a7.d
    public static final <K> List<Float> A9(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends K> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f8 : fArr) {
            if (hashSet.add(selector.z(Float.valueOf(f8)))) {
                arrayList.add(Float.valueOf(f8));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <R> List<kotlin.u0<Float, R>> AA(@a7.d float[] fArr, @a7.d Iterable<? extends R> other) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(kotlin.p1.a(Float.valueOf(fArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Byte Aa(byte[] bArr, int i7) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return kf(bArr, i7);
    }

    @a7.d
    public static final <C extends Collection<? super Integer>> C Ab(@a7.d int[] iArr, @a7.d C destination, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int i7 : iArr) {
            if (!predicate.z(Integer.valueOf(i7)).booleanValue()) {
                destination.add(Integer.valueOf(i7));
            }
        }
        return destination;
    }

    @a7.e
    public static final Boolean Ac(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C Ad(@a7.d float[] fArr, @a7.d C destination, @a7.d i5.l<? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (float f8 : fArr) {
            d0.o0(destination, transform.z(Float.valueOf(f8)));
        }
        return destination;
    }

    public static final void Ae(@a7.d char[] cArr, @a7.d i5.p<? super Integer, ? super Character, l2> action) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = cArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Character.valueOf(cArr[i7]));
            i7++;
            i8++;
        }
    }

    @a7.d
    public static final <K> Map<K, List<Integer>> Af(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i7 : iArr) {
            K kZ = keySelector.z(Integer.valueOf(i7));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(Integer.valueOf(i7));
        }
        return linkedHashMap;
    }

    public static final int Ag(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (predicate.z(Long.valueOf(jArr[length])).booleanValue()) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final String Ah(@a7.d float[] fArr, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Float, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        String string = ((StringBuilder) ih(fArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, lVar)).toString();
        kotlin.jvm.internal.l0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @a7.e
    public static final Integer Ai(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Float Aj(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f8 = fArr[0];
        int iUe = Ue(fArr);
        if (iUe == 0) {
            return Float.valueOf(f8);
        }
        R rZ = selector.z(Float.valueOf(f8));
        u0 it = new kotlin.ranges.k(1, iUe).iterator();
        while (it.hasNext()) {
            float f9 = fArr[it.b()];
            R rZ2 = selector.z(Float.valueOf(f9));
            if (rZ.compareTo(rZ2) < 0) {
                f8 = f9;
                rZ = rZ2;
            }
        }
        return Float.valueOf(f8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double Ak(double[] dArr, i5.l<? super Double, Double> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Double.valueOf(dArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Double.valueOf(dArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @a7.d
    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final <T extends Comparable<? super T>> T Al(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t7 = tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            if (t7.compareTo(t8) < 0) {
                t7 = t8;
            }
        }
        return t7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float Am(long[] jArr, i5.l<? super Long, Float> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Long.valueOf(jArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Long.valueOf(jArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R An(float[] fArr, Comparator<? super R> comparator, i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Float.valueOf(fArr[0]));
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Float.valueOf(fArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean Ao(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr.length == 0;
    }

    @kotlin.g1(version = "1.3")
    public static final short Ap(@a7.d short[] sArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (sArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return sArr[random.m(sArr.length)];
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Float Aq(@a7.d float[] fArr, @a7.d i5.p<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = operation.a0(Float.valueOf(fFloatValue), Float.valueOf(fArr[it.b()])).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    public static void Ar(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        int length = (jArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iWe = We(jArr);
        u0 it = new kotlin.ranges.k(0, length).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            long j7 = jArr[iB];
            jArr[iB] = jArr[iWe];
            jArr[iWe] = j7;
            iWe--;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Boolean> As(boolean[] zArr, i5.p<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.y.F();
        }
        boolean zBooleanValue = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(zBooleanValue));
        int length = zArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            zBooleanValue = operation.a0(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i7])).booleanValue();
            arrayList.add(Boolean.valueOf(zBooleanValue));
        }
        return arrayList;
    }

    public static final double At(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Double dValueOf = null;
        boolean z7 = false;
        for (double d8 : dArr) {
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                dValueOf = Double.valueOf(d8);
                z7 = true;
            }
        }
        if (!z7) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.l0.n(dValueOf, "null cannot be cast to non-null type kotlin.Double");
        return dValueOf.doubleValue();
    }

    @a7.d
    public static final char[] Au(@a7.d char[] cArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? new char[0] : kotlin.collections.o.H1(cArr, indices.d().intValue(), indices.f().intValue() + 1);
    }

    @a7.d
    public static final float[] Av(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.l0.o(fArrCopyOf, "copyOf(this, size)");
        Xu(fArrCopyOf);
        return fArrCopyOf;
    }

    public static final int Aw(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        int i7 = 0;
        for (byte b8 : bArr) {
            i7 += b8;
        }
        return i7;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @kotlin.t0
    @kotlin.internal.f
    private static final long Ax(short[] sArr, i5.l<? super Short, Long> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jLongValue = 0;
        for (short s7 : sArr) {
            jLongValue += selector.z(Short.valueOf(s7)).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final List<Float> Ay(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f8 : fArr) {
            if (!predicate.z(Float.valueOf(f8)).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f8));
        }
        return arrayList;
    }

    @a7.d
    public static final Set<Float> Az(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return (Set) My(fArr, new LinkedHashSet(b1.j(fArr.length)));
    }

    public static final <T> boolean B5(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : tArr) {
            if (!predicate.z(t7).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    public static final <K> Map<K, Double> B6(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(dArr.length), 16));
        for (double d8 : dArr) {
            linkedHashMap.put(keySelector.z(Double.valueOf(d8)), Double.valueOf(d8));
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V, M extends Map<? super Double, ? super V>> M B7(double[] dArr, M destination, i5.l<? super Double, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        for (double d8 : dArr) {
            destination.put(Double.valueOf(d8), valueSelector.z(Double.valueOf(d8)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final <T> T B8(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr[3];
    }

    @a7.d
    public static final <K> List<Integer> B9(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends K> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i7 : iArr) {
            if (hashSet.add(selector.z(Integer.valueOf(i7)))) {
                arrayList.add(Integer.valueOf(i7));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <R, V> List<V> BA(@a7.d float[] fArr, @a7.d Iterable<? extends R> other, @a7.d i5.p<? super Float, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(transform.a0(Float.valueOf(fArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Character Ba(char[] cArr, int i7) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return lf(cArr, i7);
    }

    @a7.d
    public static final <C extends Collection<? super Long>> C Bb(@a7.d long[] jArr, @a7.d C destination, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (long j7 : jArr) {
            if (!predicate.z(Long.valueOf(j7)).booleanValue()) {
                destination.add(Long.valueOf(j7));
            }
        }
        return destination;
    }

    @a7.e
    public static final Boolean Bc(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (boolean z7 : zArr) {
            if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                return Boolean.valueOf(z7);
            }
        }
        return null;
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C Bd(@a7.d int[] iArr, @a7.d C destination, @a7.d i5.l<? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (int i7 : iArr) {
            d0.o0(destination, transform.z(Integer.valueOf(i7)));
        }
        return destination;
    }

    public static final void Be(@a7.d double[] dArr, @a7.d i5.p<? super Integer, ? super Double, l2> action) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = dArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Double.valueOf(dArr[i7]));
            i7++;
            i8++;
        }
    }

    @a7.d
    public static final <K, V> Map<K, List<V>> Bf(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends K> keySelector, @a7.d i5.l<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i7 : iArr) {
            K kZ = keySelector.z(Integer.valueOf(i7));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(Integer.valueOf(i7)));
        }
        return linkedHashMap;
    }

    public static final <T> int Bg(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (predicate.z(tArr[length]).booleanValue()) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final String Bh(@a7.d int[] iArr, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Integer, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        String string = ((StringBuilder) jh(iArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, lVar)).toString();
        kotlin.jvm.internal.l0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @a7.e
    public static final Integer Bi(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i7 = length - 1;
            int i8 = iArr[length];
            if (predicate.z(Integer.valueOf(i8)).booleanValue()) {
                return Integer.valueOf(i8);
            }
            if (i7 < 0) {
                return null;
            }
            length = i7;
        }
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Integer Bj(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i7 = iArr[0];
        int iVe = Ve(iArr);
        if (iVe == 0) {
            return Integer.valueOf(i7);
        }
        R rZ = selector.z(Integer.valueOf(i7));
        u0 it = new kotlin.ranges.k(1, iVe).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            R rZ2 = selector.z(Integer.valueOf(i8));
            if (rZ.compareTo(rZ2) < 0) {
                i7 = i8;
                rZ = rZ2;
            }
        }
        return Integer.valueOf(i7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double Bk(float[] fArr, i5.l<? super Float, Double> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Float.valueOf(fArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Float.valueOf(fArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final short Bl(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s7 = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            if (s7 < s8) {
                s7 = s8;
            }
        }
        return s7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> float Bm(T[] tArr, i5.l<? super T, Float> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(tArr[0]).floatValue();
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(tArr[it.b()]).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Bn(int[] iArr, Comparator<? super R> comparator, i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Integer.valueOf(iArr[0]));
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Integer.valueOf(iArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean Bo(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int i7 : iArr) {
            if (predicate.z(Integer.valueOf(i7)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final boolean Bp(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return Cp(zArr, kotlin.random.f.f34998a);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Integer Bq(@a7.d int[] iArr, @a7.d i5.p<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            iIntValue = operation.a0(Integer.valueOf(iIntValue), Integer.valueOf(iArr[it.b()])).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    @kotlin.g1(version = "1.4")
    public static void Br(@a7.d long[] jArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.collections.c.f34509a.d(i7, i8, jArr.length);
        int i9 = (i7 + i8) / 2;
        if (i7 == i9) {
            return;
        }
        int i10 = i8 - 1;
        while (i7 < i9) {
            long j7 = jArr[i7];
            jArr[i7] = jArr[i10];
            jArr[i10] = j7;
            i10--;
            i7++;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Byte> Bs(byte[] bArr, i5.q<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.y.F();
        }
        byte bByteValue = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(bByteValue));
        int length = bArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            bByteValue = operation.v(Integer.valueOf(i7), Byte.valueOf(bByteValue), Byte.valueOf(bArr[i7])).byteValue();
            arrayList.add(Byte.valueOf(bByteValue));
        }
        return arrayList;
    }

    public static final float Bt(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return fArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @a7.d
    public static final double[] Bu(@a7.d double[] dArr, @a7.d Collection<Integer> indices) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        double[] dArr2 = new double[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            dArr2[i7] = dArr[it.next().intValue()];
            i7++;
        }
        return dArr2;
    }

    @a7.d
    public static final int[] Bv(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.l0.o(iArrCopyOf, "copyOf(this, size)");
        Zu(iArrCopyOf);
        return iArrCopyOf;
    }

    public static int Bw(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        int i7 = 0;
        for (int i8 : iArr) {
            i7 += i8;
        }
        return i7;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @kotlin.t0
    @kotlin.internal.f
    private static final long Bx(boolean[] zArr, i5.l<? super Boolean, Long> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jLongValue = 0;
        for (boolean z7 : zArr) {
            jLongValue += selector.z(Boolean.valueOf(z7)).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final List<Integer> By(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i7 : iArr) {
            if (!predicate.z(Integer.valueOf(i7)).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i7));
        }
        return arrayList;
    }

    @a7.d
    public static final Set<Integer> Bz(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return (Set) Ny(iArr, new LinkedHashSet(b1.j(iArr.length)));
    }

    public static final boolean C5(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (short s7 : sArr) {
            if (!predicate.z(Short.valueOf(s7)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    public static final <K, V> Map<K, V> C6(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends K> keySelector, @a7.d i5.l<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(dArr.length), 16));
        for (double d8 : dArr) {
            linkedHashMap.put(keySelector.z(Double.valueOf(d8)), valueTransform.z(Double.valueOf(d8)));
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V, M extends Map<? super Float, ? super V>> M C7(float[] fArr, M destination, i5.l<? super Float, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        for (float f8 : fArr) {
            destination.put(Float.valueOf(f8), valueSelector.z(Float.valueOf(f8)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final short C8(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr[3];
    }

    @a7.d
    public static final <K> List<Long> C9(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends K> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j7 : jArr) {
            if (hashSet.add(selector.z(Long.valueOf(j7)))) {
                arrayList.add(Long.valueOf(j7));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final List<kotlin.u0<Float, Float>> CA(@a7.d float[] fArr, @a7.d float[] other) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(kotlin.p1.a(Float.valueOf(fArr[i7]), Float.valueOf(other[i7])));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Double Ca(double[] dArr, int i7) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return mf(dArr, i7);
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C Cb(@a7.d T[] tArr, @a7.d C destination, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : tArr) {
            if (!predicate.z(t7).booleanValue()) {
                destination.add(t7);
            }
        }
        return destination;
    }

    @a7.e
    public static final Byte Cc(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C Cd(@a7.d long[] jArr, @a7.d C destination, @a7.d i5.l<? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (long j7 : jArr) {
            d0.o0(destination, transform.z(Long.valueOf(j7)));
        }
        return destination;
    }

    public static final void Ce(@a7.d float[] fArr, @a7.d i5.p<? super Integer, ? super Float, l2> action) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = fArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Float.valueOf(fArr[i7]));
            i7++;
            i8++;
        }
    }

    @a7.d
    public static final <K> Map<K, List<Long>> Cf(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j7 : jArr) {
            K kZ = keySelector.z(Long.valueOf(j7));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(Long.valueOf(j7));
        }
        return linkedHashMap;
    }

    public static final int Cg(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (predicate.z(Short.valueOf(sArr[length])).booleanValue()) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final String Ch(@a7.d long[] jArr, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Long, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        String string = ((StringBuilder) kh(jArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, lVar)).toString();
        kotlin.jvm.internal.l0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @a7.e
    public static final Long Ci(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Long Cj(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j7 = jArr[0];
        int iWe = We(jArr);
        if (iWe == 0) {
            return Long.valueOf(j7);
        }
        R rZ = selector.z(Long.valueOf(j7));
        u0 it = new kotlin.ranges.k(1, iWe).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            R rZ2 = selector.z(Long.valueOf(j8));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
                j7 = j8;
            }
        }
        return Long.valueOf(j7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double Ck(int[] iArr, i5.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Integer.valueOf(iArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Integer.valueOf(iArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Boolean Cl(@a7.d boolean[] zArr, @a7.d Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z7 = zArr[0];
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            boolean z8 = zArr[it.b()];
            if (comparator.compare(Boolean.valueOf(z7), Boolean.valueOf(z8)) < 0) {
                z7 = z8;
            }
        }
        return Boolean.valueOf(z7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float Cm(short[] sArr, i5.l<? super Short, Float> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Short.valueOf(sArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Short.valueOf(sArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Cn(long[] jArr, Comparator<? super R> comparator, i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Long.valueOf(jArr[0]));
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Long.valueOf(jArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean Co(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr.length == 0;
    }

    @kotlin.g1(version = "1.3")
    public static final boolean Cp(@a7.d boolean[] zArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (zArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return zArr[random.m(zArr.length)];
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Long Cq(@a7.d long[] jArr, @a7.d i5.p<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            jLongValue = operation.a0(Long.valueOf(jLongValue), Long.valueOf(jArr[it.b()])).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public static final <T> void Cr(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iXe = Xe(tArr);
        u0 it = new kotlin.ranges.k(0, length).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            T t7 = tArr[iB];
            tArr[iB] = tArr[iXe];
            tArr[iXe] = t7;
            iXe--;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Character> Cs(char[] cArr, i5.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.y.F();
        }
        char cCharValue = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(cCharValue));
        int length = cArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            cCharValue = operation.v(Integer.valueOf(i7), Character.valueOf(cCharValue), Character.valueOf(cArr[i7])).charValue();
            arrayList.add(Character.valueOf(cCharValue));
        }
        return arrayList;
    }

    public static final float Ct(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Float fValueOf = null;
        boolean z7 = false;
        for (float f8 : fArr) {
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                fValueOf = Float.valueOf(f8);
                z7 = true;
            }
        }
        if (!z7) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.l0.n(fValueOf, "null cannot be cast to non-null type kotlin.Float");
        return fValueOf.floatValue();
    }

    @a7.d
    public static final double[] Cu(@a7.d double[] dArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? new double[0] : kotlin.collections.o.I1(dArr, indices.d().intValue(), indices.f().intValue() + 1);
    }

    @a7.d
    public static final long[] Cv(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.l0.o(jArrCopyOf, "copyOf(this, size)");
        bv(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final int Cw(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        int i7 = 0;
        for (short s7 : sArr) {
            i7 += s7;
        }
        return i7;
    }

    @h5.h(name = "sumOfShort")
    public static final int Cx(@a7.d Short[] shArr) {
        kotlin.jvm.internal.l0.p(shArr, "<this>");
        int iShortValue = 0;
        for (Short sh : shArr) {
            iShortValue += sh.shortValue();
        }
        return iShortValue;
    }

    @a7.d
    public static final List<Long> Cy(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j7 : jArr) {
            if (!predicate.z(Long.valueOf(j7)).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j7));
        }
        return arrayList;
    }

    @a7.d
    public static final Set<Long> Cz(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return (Set) Oy(jArr, new LinkedHashSet(b1.j(jArr.length)));
    }

    public static final boolean D5(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (boolean z7 : zArr) {
            if (!predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    public static final <K> Map<K, Float> D6(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(fArr.length), 16));
        for (float f8 : fArr) {
            linkedHashMap.put(keySelector.z(Float.valueOf(f8)), Float.valueOf(f8));
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V, M extends Map<? super Integer, ? super V>> M D7(int[] iArr, M destination, i5.l<? super Integer, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        for (int i7 : iArr) {
            destination.put(Integer.valueOf(i7), valueSelector.z(Integer.valueOf(i7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean D8(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr[3];
    }

    @a7.d
    public static final <T, K> List<T> D9(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends K> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t7 : tArr) {
            if (hashSet.add(selector.z(t7))) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <V> List<V> DA(@a7.d float[] fArr, @a7.d float[] other, @a7.d i5.p<? super Float, ? super Float, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Float.valueOf(fArr[i7]), Float.valueOf(other[i7])));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Float Da(float[] fArr, int i7) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return nf(fArr, i7);
    }

    @a7.d
    public static final <C extends Collection<? super Short>> C Db(@a7.d short[] sArr, @a7.d C destination, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (short s7 : sArr) {
            if (!predicate.z(Short.valueOf(s7)).booleanValue()) {
                destination.add(Short.valueOf(s7));
            }
        }
        return destination;
    }

    @a7.e
    public static final Byte Dc(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (byte b8 : bArr) {
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                return Byte.valueOf(b8);
            }
        }
        return null;
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C Dd(@a7.d T[] tArr, @a7.d C destination, @a7.d i5.l<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (T t7 : tArr) {
            d0.o0(destination, transform.z(t7));
        }
        return destination;
    }

    public static final void De(@a7.d int[] iArr, @a7.d i5.p<? super Integer, ? super Integer, l2> action) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Integer.valueOf(iArr[i7]));
            i7++;
            i8++;
        }
    }

    @a7.d
    public static final <K, V> Map<K, List<V>> Df(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends K> keySelector, @a7.d i5.l<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j7 : jArr) {
            K kZ = keySelector.z(Long.valueOf(j7));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(Long.valueOf(j7)));
        }
        return linkedHashMap;
    }

    public static final int Dg(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (predicate.z(Boolean.valueOf(zArr[length])).booleanValue()) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final <T> String Dh(@a7.d T[] tArr, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        String string = ((StringBuilder) lh(tArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, lVar)).toString();
        kotlin.jvm.internal.l0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @a7.e
    public static final Long Di(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i7 = length - 1;
            long j7 = jArr[length];
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                return Long.valueOf(j7);
            }
            if (i7 < 0) {
                return null;
            }
            length = i7;
        }
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <T, R extends Comparable<? super R>> T Dj(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t7 = tArr[0];
        int iXe = Xe(tArr);
        if (iXe == 0) {
            return t7;
        }
        R rZ = selector.z(t7);
        u0 it = new kotlin.ranges.k(1, iXe).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            R rZ2 = selector.z(t8);
            if (rZ.compareTo(rZ2) < 0) {
                t7 = t8;
                rZ = rZ2;
            }
        }
        return t7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double Dk(long[] jArr, i5.l<? super Long, Double> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Long.valueOf(jArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Long.valueOf(jArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Byte Dl(@a7.d byte[] bArr, @a7.d Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b8 = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            if (comparator.compare(Byte.valueOf(b8), Byte.valueOf(b9)) < 0) {
                b8 = b9;
            }
        }
        return Byte.valueOf(b8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float Dm(boolean[] zArr, i5.l<? super Boolean, Float> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Boolean.valueOf(zArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Boolean.valueOf(zArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R> R Dn(T[] tArr, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rZ = selector.z(tArr[0]);
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(tArr[it.b()]);
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean Do(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (long j7 : jArr) {
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Boolean Dp(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return Ep(zArr, kotlin.random.f.f34998a);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final <S, T extends S> S Dq(@a7.d T[] tArr, @a7.d i5.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S sA0 = (S) tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            sA0 = operation.a0(sA0, (Object) tArr[it.b()]);
        }
        return sA0;
    }

    @kotlin.g1(version = "1.4")
    public static final <T> void Dr(@a7.d T[] tArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.collections.c.f34509a.d(i7, i8, tArr.length);
        int i9 = (i7 + i8) / 2;
        if (i7 == i9) {
            return;
        }
        int i10 = i8 - 1;
        while (i7 < i9) {
            T t7 = tArr[i7];
            tArr[i7] = tArr[i10];
            tArr[i10] = t7;
            i10--;
            i7++;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Double> Ds(double[] dArr, i5.q<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.y.F();
        }
        double dDoubleValue = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(dDoubleValue));
        int length = dArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            dDoubleValue = operation.v(Integer.valueOf(i7), Double.valueOf(dDoubleValue), Double.valueOf(dArr[i7])).doubleValue();
            arrayList.add(Double.valueOf(dDoubleValue));
        }
        return arrayList;
    }

    public static int Dt(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return iArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @a7.d
    public static final float[] Du(@a7.d float[] fArr, @a7.d Collection<Integer> indices) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        float[] fArr2 = new float[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            fArr2[i7] = fArr[it.next().intValue()];
            i7++;
        }
        return fArr2;
    }

    @a7.d
    public static final <T extends Comparable<? super T>> T[] Dv(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.l0.o(objArrCopyOf, "copyOf(this, size)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        kotlin.collections.o.I4(tArr2, kotlin.comparisons.b.q());
        return tArr2;
    }

    public static long Dw(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        long j7 = 0;
        for (long j8 : jArr) {
            j7 += j8;
        }
        return j7;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final int Dx(byte[] bArr, i5.l<? super Byte, w1> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iH = w1.h(0);
        for (byte b8 : bArr) {
            iH = w1.h(iH + selector.z(Byte.valueOf(b8)).g0());
        }
        return iH;
    }

    @a7.d
    public static final <T> List<T> Dy(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t7 : tArr) {
            if (!predicate.z(t7).booleanValue()) {
                break;
            }
            arrayList.add(t7);
        }
        return arrayList;
    }

    @a7.d
    public static final <T> Set<T> Dz(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return (Set) Py(tArr, new LinkedHashSet(b1.j(tArr.length)));
    }

    public static boolean E5(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return !(bArr.length == 0);
    }

    @a7.d
    public static final <K, V> Map<K, V> E6(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends K> keySelector, @a7.d i5.l<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(fArr.length), 16));
        for (float f8 : fArr) {
            linkedHashMap.put(keySelector.z(Float.valueOf(f8)), valueTransform.z(Float.valueOf(f8)));
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V, M extends Map<? super Long, ? super V>> M E7(long[] jArr, M destination, i5.l<? super Long, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        for (long j7 : jArr) {
            destination.put(Long.valueOf(j7), valueSelector.z(Long.valueOf(j7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final byte E8(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr[4];
    }

    @a7.d
    public static final <K> List<Short> E9(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends K> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s7 : sArr) {
            if (hashSet.add(selector.z(Short.valueOf(s7)))) {
                arrayList.add(Short.valueOf(s7));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <R> List<kotlin.u0<Float, R>> EA(@a7.d float[] fArr, @a7.d R[] other) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            float f8 = fArr[i7];
            arrayList.add(kotlin.p1.a(Float.valueOf(f8), other[i7]));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Integer Ea(int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return of(iArr, i7);
    }

    @a7.d
    public static final <C extends Collection<? super Boolean>> C Eb(@a7.d boolean[] zArr, @a7.d C destination, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (boolean z7 : zArr) {
            if (!predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                destination.add(Boolean.valueOf(z7));
            }
        }
        return destination;
    }

    @a7.e
    public static final Character Ec(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C Ed(@a7.d short[] sArr, @a7.d C destination, @a7.d i5.l<? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (short s7 : sArr) {
            d0.o0(destination, transform.z(Short.valueOf(s7)));
        }
        return destination;
    }

    public static final void Ee(@a7.d long[] jArr, @a7.d i5.p<? super Integer, ? super Long, l2> action) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = jArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Long.valueOf(jArr[i7]));
            i7++;
            i8++;
        }
    }

    @a7.d
    public static final <T, K> Map<K, List<T>> Ef(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t7 : tArr) {
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

    @a7.d
    public static final Set<Byte> Eg(@a7.d byte[] bArr, @a7.d Iterable<Byte> other) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Byte> setXz = xz(bArr);
        d0.O0(setXz, other);
        return setXz;
    }

    @a7.d
    public static final String Eh(@a7.d short[] sArr, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Short, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        String string = ((StringBuilder) mh(sArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, lVar)).toString();
        kotlin.jvm.internal.l0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @a7.e
    public static final <T> T Ei(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Short Ej(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s7 = sArr[0];
        int iYe = Ye(sArr);
        if (iYe == 0) {
            return Short.valueOf(s7);
        }
        R rZ = selector.z(Short.valueOf(s7));
        u0 it = new kotlin.ranges.k(1, iYe).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            R rZ2 = selector.z(Short.valueOf(s8));
            if (rZ.compareTo(rZ2) < 0) {
                s7 = s8;
                rZ = rZ2;
            }
        }
        return Short.valueOf(s7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> Double Ek(T[] tArr, i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(tArr[0]).doubleValue();
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(tArr[it.b()]).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Character El(@a7.d char[] cArr, @a7.d Comparator<? super Character> comparator) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c8 = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            if (comparator.compare(Character.valueOf(c8), Character.valueOf(c9)) < 0) {
                c8 = c9;
            }
        }
        return Character.valueOf(c8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Em(byte[] bArr, i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Byte.valueOf(bArr[0]));
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Byte.valueOf(bArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R En(short[] sArr, Comparator<? super R> comparator, i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Short.valueOf(sArr[0]));
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Short.valueOf(sArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final <T> boolean Eo(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr.length == 0;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Boolean Ep(@a7.d boolean[] zArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[random.m(zArr.length)]);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Short Eq(@a7.d short[] sArr, @a7.d i5.p<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            sShortValue = operation.a0(Short.valueOf(sShortValue), Short.valueOf(sArr[it.b()])).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    public static void Er(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        int length = (sArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iYe = Ye(sArr);
        u0 it = new kotlin.ranges.k(0, length).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            short s7 = sArr[iB];
            sArr[iB] = sArr[iYe];
            sArr[iYe] = s7;
            iYe--;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Float> Es(float[] fArr, i5.q<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.y.F();
        }
        float fFloatValue = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(fFloatValue));
        int length = fArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            fFloatValue = operation.v(Integer.valueOf(i7), Float.valueOf(fFloatValue), Float.valueOf(fArr[i7])).floatValue();
            arrayList.add(Float.valueOf(fFloatValue));
        }
        return arrayList;
    }

    public static final int Et(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Integer numValueOf = null;
        boolean z7 = false;
        for (int i7 : iArr) {
            if (predicate.z(Integer.valueOf(i7)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                numValueOf = Integer.valueOf(i7);
                z7 = true;
            }
        }
        if (!z7) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.l0.n(numValueOf, "null cannot be cast to non-null type kotlin.Int");
        return numValueOf.intValue();
    }

    @a7.d
    public static final float[] Eu(@a7.d float[] fArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? new float[0] : kotlin.collections.o.J1(fArr, indices.d().intValue(), indices.f().intValue() + 1);
    }

    @a7.d
    public static final short[] Ev(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.l0.o(sArrCopyOf, "copyOf(this, size)");
        fv(sArrCopyOf);
        return sArrCopyOf;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Ew(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Integer> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (byte b8 : bArr) {
            iIntValue += selector.z(Byte.valueOf(b8)).intValue();
        }
        return iIntValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final int Ex(char[] cArr, i5.l<? super Character, w1> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iH = w1.h(0);
        for (char c8 : cArr) {
            iH = w1.h(iH + selector.z(Character.valueOf(c8)).g0());
        }
        return iH;
    }

    @a7.d
    public static final List<Short> Ey(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s7 : sArr) {
            if (!predicate.z(Short.valueOf(s7)).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s7));
        }
        return arrayList;
    }

    @a7.d
    public static final Set<Short> Ez(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return (Set) Qy(sArr, new LinkedHashSet(b1.j(sArr.length)));
    }

    public static final boolean F5(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (byte b8 : bArr) {
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final <K> Map<K, Integer> F6(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(iArr.length), 16));
        for (int i7 : iArr) {
            linkedHashMap.put(keySelector.z(Integer.valueOf(i7)), Integer.valueOf(i7));
        }
        return linkedHashMap;
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <K, V, M extends Map<? super K, ? super V>> M F7(@a7.d K[] kArr, @a7.d M destination, @a7.d i5.l<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(kArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        for (K k7 : kArr) {
            destination.put(k7, valueSelector.z(k7));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final char F8(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr[4];
    }

    @a7.d
    public static final <K> List<Boolean> F9(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends K> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z7 : zArr) {
            if (hashSet.add(selector.z(Boolean.valueOf(z7)))) {
                arrayList.add(Boolean.valueOf(z7));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <R, V> List<V> FA(@a7.d float[] fArr, @a7.d R[] other, @a7.d i5.p<? super Float, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Float.valueOf(fArr[i7]), other[i7]));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Long Fa(long[] jArr, int i7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return pf(jArr, i7);
    }

    @a7.d
    public static final <C extends Collection<? super Byte>> C Fb(@a7.d byte[] bArr, @a7.d C destination, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (byte b8 : bArr) {
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                destination.add(Byte.valueOf(b8));
            }
        }
        return destination;
    }

    @a7.e
    public static final Character Fc(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (char c8 : cArr) {
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                return Character.valueOf(c8);
            }
        }
        return null;
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C Fd(@a7.d boolean[] zArr, @a7.d C destination, @a7.d i5.l<? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (boolean z7 : zArr) {
            d0.o0(destination, transform.z(Boolean.valueOf(z7)));
        }
        return destination;
    }

    public static final <T> void Fe(@a7.d T[] tArr, @a7.d i5.p<? super Integer, ? super T, l2> action) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), tArr[i7]);
            i7++;
            i8++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T, K, V> Map<K, List<V>> Ff(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a1.c cVar : tArr) {
            K kZ = keySelector.z(cVar);
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(cVar));
        }
        return linkedHashMap;
    }

    @a7.d
    public static final Set<Character> Fg(@a7.d char[] cArr, @a7.d Iterable<Character> other) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Character> setYz = yz(cArr);
        d0.O0(setYz, other);
        return setYz;
    }

    @a7.d
    public static final String Fh(@a7.d boolean[] zArr, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Boolean, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        String string = ((StringBuilder) nh(zArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, lVar)).toString();
        kotlin.jvm.internal.l0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @a7.e
    public static final <T> T Fi(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i7 = length - 1;
            T t7 = tArr[length];
            if (predicate.z(t7).booleanValue()) {
                return t7;
            }
            if (i7 < 0) {
                return null;
            }
            length = i7;
        }
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> byte Fj(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b8 = bArr[0];
        int iRe = Re(bArr);
        if (iRe == 0) {
            return b8;
        }
        R rZ = selector.z(Byte.valueOf(b8));
        u0 it = new kotlin.ranges.k(1, iRe).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            R rZ2 = selector.z(Byte.valueOf(b9));
            if (rZ.compareTo(rZ2) < 0) {
                b8 = b9;
                rZ = rZ2;
            }
        }
        return b8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double Fk(short[] sArr, i5.l<? super Short, Double> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Short.valueOf(sArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Short.valueOf(sArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Double Fl(@a7.d double[] dArr, @a7.d Comparator<? super Double> comparator) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d8 = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            double d9 = dArr[it.b()];
            if (comparator.compare(Double.valueOf(d8), Double.valueOf(d9)) < 0) {
                d8 = d9;
            }
        }
        return Double.valueOf(d8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Fm(char[] cArr, i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Character.valueOf(cArr[0]));
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(cArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Fn(boolean[] zArr, Comparator<? super R> comparator, i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Boolean.valueOf(zArr[0]));
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Boolean.valueOf(zArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final <T> boolean Fo(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : tArr) {
            if (predicate.z(t7).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Byte Fp(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return Gp(bArr, kotlin.random.f.f34998a);
    }

    public static final byte Fq(@a7.d byte[] bArr, @a7.d i5.p<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iRe = Re(bArr);
        if (iRe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[iRe];
        for (int i7 = iRe - 1; i7 >= 0; i7--) {
            bByteValue = operation.a0(Byte.valueOf(bArr[i7]), Byte.valueOf(bByteValue)).byteValue();
        }
        return bByteValue;
    }

    @kotlin.g1(version = "1.4")
    public static void Fr(@a7.d short[] sArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.collections.c.f34509a.d(i7, i8, sArr.length);
        int i9 = (i7 + i8) / 2;
        if (i7 == i9) {
            return;
        }
        int i10 = i8 - 1;
        while (i7 < i9) {
            short s7 = sArr[i7];
            sArr[i7] = sArr[i10];
            sArr[i10] = s7;
            i10--;
            i7++;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Integer> Fs(int[] iArr, i5.q<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.y.F();
        }
        int iIntValue = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(iIntValue));
        int length = iArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            iIntValue = operation.v(Integer.valueOf(i7), Integer.valueOf(iIntValue), Integer.valueOf(iArr[i7])).intValue();
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }

    public static long Ft(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return jArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @a7.d
    public static int[] Fu(@a7.d int[] iArr, @a7.d Collection<Integer> indices) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        int[] iArr2 = new int[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            iArr2[i7] = iArr[it.next().intValue()];
            i7++;
        }
        return iArr2;
    }

    @a7.d
    public static final <T> T[] Fv(@a7.d T[] tArr, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.l0.o(tArr2, "copyOf(this, size)");
        kotlin.collections.o.I4(tArr2, comparator);
        return tArr2;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Fw(@a7.d char[] cArr, @a7.d i5.l<? super Character, Integer> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (char c8 : cArr) {
            iIntValue += selector.z(Character.valueOf(c8)).intValue();
        }
        return iIntValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final int Fx(double[] dArr, i5.l<? super Double, w1> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iH = w1.h(0);
        for (double d8 : dArr) {
            iH = w1.h(iH + selector.z(Double.valueOf(d8)).g0());
        }
        return iH;
    }

    @a7.d
    public static final List<Boolean> Fy(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z7 : zArr) {
            if (!predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z7));
        }
        return arrayList;
    }

    @a7.d
    public static final Set<Boolean> Fz(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return (Set) Ry(zArr, new LinkedHashSet(b1.j(zArr.length)));
    }

    public static final boolean G5(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return !(cArr.length == 0);
    }

    @a7.d
    public static final <K, V> Map<K, V> G6(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends K> keySelector, @a7.d i5.l<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(iArr.length), 16));
        for (int i7 : iArr) {
            linkedHashMap.put(keySelector.z(Integer.valueOf(i7)), valueTransform.z(Integer.valueOf(i7)));
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V, M extends Map<? super Short, ? super V>> M G7(short[] sArr, M destination, i5.l<? super Short, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        for (short s7 : sArr) {
            destination.put(Short.valueOf(s7), valueSelector.z(Short.valueOf(s7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final double G8(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr[4];
    }

    @a7.d
    public static final List<Byte> G9(@a7.d byte[] bArr, int i7) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (i7 >= 0) {
            return fy(bArr, kotlin.ranges.q.n(bArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R> List<kotlin.u0<Integer, R>> GA(@a7.d int[] iArr, @a7.d Iterable<? extends R> other) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(kotlin.p1.a(Integer.valueOf(iArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final <T> T Ga(T[] tArr, int i7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return (T) qf(tArr, i7);
    }

    @a7.d
    public static final <C extends Collection<? super Character>> C Gb(@a7.d char[] cArr, @a7.d C destination, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (char c8 : cArr) {
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                destination.add(Character.valueOf(c8));
            }
        }
        return destination;
    }

    @a7.e
    public static final Double Gc(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    public static final <R> R Gd(@a7.d byte[] bArr, R r7, @a7.d i5.p<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (byte b8 : bArr) {
            r7 = operation.a0(r7, Byte.valueOf(b8));
        }
        return r7;
    }

    public static final void Ge(@a7.d short[] sArr, @a7.d i5.p<? super Integer, ? super Short, l2> action) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = sArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Short.valueOf(sArr[i7]));
            i7++;
            i8++;
        }
    }

    @a7.d
    public static final <K> Map<K, List<Short>> Gf(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s7 : sArr) {
            K kZ = keySelector.z(Short.valueOf(s7));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(Short.valueOf(s7));
        }
        return linkedHashMap;
    }

    @a7.d
    public static final Set<Double> Gg(@a7.d double[] dArr, @a7.d Iterable<Double> other) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Double> setZz = zz(dArr);
        d0.O0(setZz, other);
        return setZz;
    }

    public static /* synthetic */ String Gh(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
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
        return xh(bArr, charSequence, charSequence5, charSequence6, i9, charSequence7, lVar);
    }

    @a7.e
    public static final Short Gi(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> char Gj(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c8 = cArr[0];
        int iSe = Se(cArr);
        if (iSe == 0) {
            return c8;
        }
        R rZ = selector.z(Character.valueOf(c8));
        u0 it = new kotlin.ranges.k(1, iSe).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            R rZ2 = selector.z(Character.valueOf(c9));
            if (rZ.compareTo(rZ2) < 0) {
                c8 = c9;
                rZ = rZ2;
            }
        }
        return c8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double Gk(boolean[] zArr, i5.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Boolean.valueOf(zArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Boolean.valueOf(zArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Float Gl(@a7.d float[] fArr, @a7.d Comparator<? super Float> comparator) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f8 = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            float f9 = fArr[it.b()];
            if (comparator.compare(Float.valueOf(f8), Float.valueOf(f9)) < 0) {
                f8 = f9;
            }
        }
        return Float.valueOf(f8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Gm(double[] dArr, i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Double.valueOf(dArr[0]));
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Double.valueOf(dArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Byte Gn(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b8 = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            if (b8 > b9) {
                b8 = b9;
            }
        }
        return Byte.valueOf(b8);
    }

    public static final boolean Go(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr.length == 0;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Byte Gp(@a7.d byte[] bArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[random.m(bArr.length)]);
    }

    public static final char Gq(@a7.d char[] cArr, @a7.d i5.p<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iSe = Se(cArr);
        if (iSe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[iSe];
        for (int i7 = iSe - 1; i7 >= 0; i7--) {
            cCharValue = operation.a0(Character.valueOf(cArr[i7]), Character.valueOf(cCharValue)).charValue();
        }
        return cCharValue;
    }

    public static final void Gr(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        int length = (zArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iZe = Ze(zArr);
        u0 it = new kotlin.ranges.k(0, length).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            boolean z7 = zArr[iB];
            zArr[iB] = zArr[iZe];
            zArr[iZe] = z7;
            iZe--;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Long> Gs(long[] jArr, i5.q<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.y.F();
        }
        long jLongValue = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(jLongValue));
        int length = jArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            jLongValue = operation.v(Integer.valueOf(i7), Long.valueOf(jLongValue), Long.valueOf(jArr[i7])).longValue();
            arrayList.add(Long.valueOf(jLongValue));
        }
        return arrayList;
    }

    public static final long Gt(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Long lValueOf = null;
        boolean z7 = false;
        for (long j7 : jArr) {
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                lValueOf = Long.valueOf(j7);
                z7 = true;
            }
        }
        if (!z7) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.l0.n(lValueOf, "null cannot be cast to non-null type kotlin.Long");
        return lValueOf.longValue();
    }

    @a7.d
    public static int[] Gu(@a7.d int[] iArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? new int[0] : kotlin.collections.o.K1(iArr, indices.d().intValue(), indices.f().intValue() + 1);
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Byte> Gv(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return gw(bArr, new kotlin.comparisons.b.C0428b(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Gw(@a7.d double[] dArr, @a7.d i5.l<? super Double, Integer> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (double d8 : dArr) {
            iIntValue += selector.z(Double.valueOf(d8)).intValue();
        }
        return iIntValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final int Gx(float[] fArr, i5.l<? super Float, w1> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iH = w1.h(0);
        for (float f8 : fArr) {
            iH = w1.h(iH + selector.z(Float.valueOf(f8)).g0());
        }
        return iH;
    }

    @a7.d
    public static final boolean[] Gy(@a7.d Boolean[] boolArr) {
        kotlin.jvm.internal.l0.p(boolArr, "<this>");
        int length = boolArr.length;
        boolean[] zArr = new boolean[length];
        for (int i7 = 0; i7 < length; i7++) {
            zArr[i7] = boolArr[i7].booleanValue();
        }
        return zArr;
    }

    @a7.d
    public static final Set<Byte> Gz(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            return length != 1 ? (Set) Jy(bArr, new LinkedHashSet(b1.j(bArr.length))) : m1.f(Byte.valueOf(bArr[0]));
        }
        return n1.k();
    }

    public static final boolean H5(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (char c8 : cArr) {
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final <K> Map<K, Long> H6(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(jArr.length), 16));
        for (long j7 : jArr) {
            linkedHashMap.put(keySelector.z(Long.valueOf(j7)), Long.valueOf(j7));
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V, M extends Map<? super Boolean, ? super V>> M H7(boolean[] zArr, M destination, i5.l<? super Boolean, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        for (boolean z7 : zArr) {
            destination.put(Boolean.valueOf(z7), valueSelector.z(Boolean.valueOf(z7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final float H8(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr[4];
    }

    @a7.d
    public static final List<Character> H9(@a7.d char[] cArr, int i7) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (i7 >= 0) {
            return gy(cArr, kotlin.ranges.q.n(cArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R, V> List<V> HA(@a7.d int[] iArr, @a7.d Iterable<? extends R> other, @a7.d i5.p<? super Integer, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(transform.a0(Integer.valueOf(iArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Short Ha(short[] sArr, int i7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return rf(sArr, i7);
    }

    @a7.d
    public static final <C extends Collection<? super Double>> C Hb(@a7.d double[] dArr, @a7.d C destination, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (double d8 : dArr) {
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                destination.add(Double.valueOf(d8));
            }
        }
        return destination;
    }

    @a7.e
    public static final Double Hc(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (double d8 : dArr) {
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                return Double.valueOf(d8);
            }
        }
        return null;
    }

    public static final <R> R Hd(@a7.d char[] cArr, R r7, @a7.d i5.p<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (char c8 : cArr) {
            r7 = operation.a0(r7, Character.valueOf(c8));
        }
        return r7;
    }

    public static final void He(@a7.d boolean[] zArr, @a7.d i5.p<? super Integer, ? super Boolean, l2> action) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = zArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Boolean.valueOf(zArr[i7]));
            i7++;
            i8++;
        }
    }

    @a7.d
    public static final <K, V> Map<K, List<V>> Hf(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends K> keySelector, @a7.d i5.l<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s7 : sArr) {
            K kZ = keySelector.z(Short.valueOf(s7));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(Short.valueOf(s7)));
        }
        return linkedHashMap;
    }

    @a7.d
    public static final Set<Float> Hg(@a7.d float[] fArr, @a7.d Iterable<Float> other) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Float> setAz = Az(fArr);
        d0.O0(setAz, other);
        return setAz;
    }

    public static /* synthetic */ String Hh(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
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
        return yh(cArr, charSequence, charSequence5, charSequence6, i9, charSequence7, lVar);
    }

    @a7.e
    public static final Short Hi(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i7 = length - 1;
            short s7 = sArr[length];
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                return Short.valueOf(s7);
            }
            if (i7 < 0) {
                return null;
            }
            length = i7;
        }
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> double Hj(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d8 = dArr[0];
        int iTe = Te(dArr);
        if (iTe == 0) {
            return d8;
        }
        R rZ = selector.z(Double.valueOf(d8));
        u0 it = new kotlin.ranges.k(1, iTe).iterator();
        while (it.hasNext()) {
            double d9 = dArr[it.b()];
            R rZ2 = selector.z(Double.valueOf(d9));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
                d8 = d9;
            }
        }
        return d8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float Hk(byte[] bArr, i5.l<? super Byte, Float> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Byte.valueOf(bArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Byte.valueOf(bArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Integer Hl(@a7.d int[] iArr, @a7.d Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i7 = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            if (comparator.compare(Integer.valueOf(i7), Integer.valueOf(i8)) < 0) {
                i7 = i8;
            }
        }
        return Integer.valueOf(i7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Hm(float[] fArr, i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Float.valueOf(fArr[0]));
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Float.valueOf(fArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Character Hn(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c8 = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            if (kotlin.jvm.internal.l0.t(c8, c9) > 0) {
                c8 = c9;
            }
        }
        return Character.valueOf(c8);
    }

    public static final boolean Ho(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (short s7 : sArr) {
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Character Hp(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return Ip(cArr, kotlin.random.f.f34998a);
    }

    public static final double Hq(@a7.d double[] dArr, @a7.d i5.p<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iTe = Te(dArr);
        if (iTe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[iTe];
        for (int i7 = iTe - 1; i7 >= 0; i7--) {
            dDoubleValue = operation.a0(Double.valueOf(dArr[i7]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    public static final void Hr(@a7.d boolean[] zArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.collections.c.f34509a.d(i7, i8, zArr.length);
        int i9 = (i7 + i8) / 2;
        if (i7 == i9) {
            return;
        }
        int i10 = i8 - 1;
        while (i7 < i9) {
            boolean z7 = zArr[i7];
            zArr[i7] = zArr[i10];
            zArr[i10] = z7;
            i10--;
            i7++;
        }
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <S, T extends S> List<S> Hs(@a7.d T[] tArr, @a7.d i5.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.y.F();
        }
        S sV = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(sV);
        int length = tArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            sV = operation.v(Integer.valueOf(i7), sV, (Object) tArr[i7]);
            arrayList.add(sV);
        }
        return arrayList;
    }

    public static final <T> T Ht(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @a7.d
    public static long[] Hu(@a7.d long[] jArr, @a7.d Collection<Integer> indices) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        long[] jArr2 = new long[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            jArr2[i7] = jArr[it.next().intValue()];
            i7++;
        }
        return jArr2;
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Character> Hv(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return hw(cArr, new kotlin.comparisons.b.C0428b(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Hw(@a7.d float[] fArr, @a7.d i5.l<? super Float, Integer> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (float f8 : fArr) {
            iIntValue += selector.z(Float.valueOf(f8)).intValue();
        }
        return iIntValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final int Hx(int[] iArr, i5.l<? super Integer, w1> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iH = w1.h(0);
        for (int i7 : iArr) {
            iH = w1.h(iH + selector.z(Integer.valueOf(i7)).g0());
        }
        return iH;
    }

    @a7.d
    public static final byte[] Hy(@a7.d Byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i7 = 0; i7 < length; i7++) {
            bArr2[i7] = bArr[i7].byteValue();
        }
        return bArr2;
    }

    @a7.d
    public static final Set<Character> Hz(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            return length != 1 ? (Set) Ky(cArr, new LinkedHashSet(b1.j(kotlin.ranges.q.u(cArr.length, 128)))) : m1.f(Character.valueOf(cArr[0]));
        }
        return n1.k();
    }

    public static final boolean I5(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return !(dArr.length == 0);
    }

    @a7.d
    public static final <K, V> Map<K, V> I6(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends K> keySelector, @a7.d i5.l<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(jArr.length), 16));
        for (long j7 : jArr) {
            linkedHashMap.put(keySelector.z(Long.valueOf(j7)), valueTransform.z(Long.valueOf(j7)));
        }
        return linkedHashMap;
    }

    public static final double I7(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        double d8 = 0.0d;
        int i7 = 0;
        for (byte b8 : bArr) {
            d8 += (double) b8;
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return d8 / ((double) i7);
    }

    @kotlin.internal.f
    private static final int I8(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr[4];
    }

    @a7.d
    public static final List<Double> I9(@a7.d double[] dArr, int i7) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (i7 >= 0) {
            return hy(dArr, kotlin.ranges.q.n(dArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final List<kotlin.u0<Integer, Integer>> IA(@a7.d int[] iArr, @a7.d int[] other) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(kotlin.p1.a(Integer.valueOf(iArr[i7]), Integer.valueOf(other[i7])));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Byte> Ia(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b8 : bArr) {
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                arrayList.add(Byte.valueOf(b8));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <C extends Collection<? super Float>> C Ib(@a7.d float[] fArr, @a7.d C destination, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (float f8 : fArr) {
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                destination.add(Float.valueOf(f8));
            }
        }
        return destination;
    }

    @a7.e
    public static final Float Ic(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    public static final <R> R Id(@a7.d double[] dArr, R r7, @a7.d i5.p<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (double d8 : dArr) {
            r7 = operation.a0(r7, Double.valueOf(d8));
        }
        return r7;
    }

    @a7.d
    public static kotlin.ranges.k Ie(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return new kotlin.ranges.k(0, Re(bArr));
    }

    @a7.d
    public static final <K> Map<K, List<Boolean>> If(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z7 : zArr) {
            K kZ = keySelector.z(Boolean.valueOf(z7));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(Boolean.valueOf(z7));
        }
        return linkedHashMap;
    }

    @a7.d
    public static final Set<Integer> Ig(@a7.d int[] iArr, @a7.d Iterable<Integer> other) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Integer> setBz = Bz(iArr);
        d0.O0(setBz, other);
        return setBz;
    }

    public static /* synthetic */ String Ih(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
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
        return zh(dArr, charSequence, charSequence5, charSequence6, i9, charSequence7, lVar);
    }

    @a7.d
    public static final <R> List<R> Ii(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b8 : bArr) {
            arrayList.add(transform.z(Byte.valueOf(b8)));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> float Ij(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f8 = fArr[0];
        int iUe = Ue(fArr);
        if (iUe == 0) {
            return f8;
        }
        R rZ = selector.z(Float.valueOf(f8));
        u0 it = new kotlin.ranges.k(1, iUe).iterator();
        while (it.hasNext()) {
            float f9 = fArr[it.b()];
            R rZ2 = selector.z(Float.valueOf(f9));
            if (rZ.compareTo(rZ2) < 0) {
                f8 = f9;
                rZ = rZ2;
            }
        }
        return f8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float Ik(char[] cArr, i5.l<? super Character, Float> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Character.valueOf(cArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Character.valueOf(cArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Long Il(@a7.d long[] jArr, @a7.d Comparator<? super Long> comparator) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j7 = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            if (comparator.compare(Long.valueOf(j7), Long.valueOf(j8)) < 0) {
                j7 = j8;
            }
        }
        return Long.valueOf(j7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Im(int[] iArr, i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Integer.valueOf(iArr[0]));
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Integer.valueOf(iArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <T extends Comparable<? super T>> T In(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t7 = tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            if (t7.compareTo(t8) > 0) {
                t7 = t8;
            }
        }
        return t7;
    }

    public static final boolean Io(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr.length == 0;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Character Ip(@a7.d char[] cArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[random.m(cArr.length)]);
    }

    public static final float Iq(@a7.d float[] fArr, @a7.d i5.p<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iUe = Ue(fArr);
        if (iUe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[iUe];
        for (int i7 = iUe - 1; i7 >= 0; i7--) {
            fFloatValue = operation.a0(Float.valueOf(fArr[i7]), Float.valueOf(fFloatValue)).floatValue();
        }
        return fFloatValue;
    }

    @a7.d
    public static final List<Byte> Ir(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return kotlin.collections.y.F();
        }
        List<Byte> listOz = oz(bArr);
        f0.m1(listOz);
        return listOz;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Short> Is(short[] sArr, i5.q<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.y.F();
        }
        short sShortValue = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(sShortValue));
        int length = sArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            sShortValue = operation.v(Integer.valueOf(i7), Short.valueOf(sShortValue), Short.valueOf(sArr[i7])).shortValue();
            arrayList.add(Short.valueOf(sShortValue));
        }
        return arrayList;
    }

    public static final <T> T It(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        T t7 = null;
        boolean z7 = false;
        for (T t8 : tArr) {
            if (predicate.z(t8).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                z7 = true;
                t7 = t8;
            }
        }
        if (z7) {
            return t7;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    public static long[] Iu(@a7.d long[] jArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? new long[0] : kotlin.collections.o.L1(jArr, indices.d().intValue(), indices.f().intValue() + 1);
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Double> Iv(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return iw(dArr, new kotlin.comparisons.b.C0428b(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Iw(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Integer> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (int i7 : iArr) {
            iIntValue += selector.z(Integer.valueOf(i7)).intValue();
        }
        return iIntValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final int Ix(long[] jArr, i5.l<? super Long, w1> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iH = w1.h(0);
        for (long j7 : jArr) {
            iH = w1.h(iH + selector.z(Long.valueOf(j7)).g0());
        }
        return iH;
    }

    @a7.d
    public static final char[] Iy(@a7.d Character[] chArr) {
        kotlin.jvm.internal.l0.p(chArr, "<this>");
        int length = chArr.length;
        char[] cArr = new char[length];
        for (int i7 = 0; i7 < length; i7++) {
            cArr[i7] = chArr[i7].charValue();
        }
        return cArr;
    }

    @a7.d
    public static final Set<Double> Iz(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            return length != 1 ? (Set) Ly(dArr, new LinkedHashSet(b1.j(dArr.length))) : m1.f(Double.valueOf(dArr[0]));
        }
        return n1.k();
    }

    public static final boolean J5(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (double d8 : dArr) {
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final <T, K> Map<K, T> J6(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(tArr.length), 16));
        for (T t7 : tArr) {
            linkedHashMap.put(keySelector.z(t7), t7);
        }
        return linkedHashMap;
    }

    public static final double J7(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        double d8 = 0.0d;
        int i7 = 0;
        for (double d9 : dArr) {
            d8 += d9;
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return d8 / ((double) i7);
    }

    @kotlin.internal.f
    private static final long J8(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr[4];
    }

    @a7.d
    public static final List<Float> J9(@a7.d float[] fArr, int i7) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (i7 >= 0) {
            return iy(fArr, kotlin.ranges.q.n(fArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <V> List<V> JA(@a7.d int[] iArr, @a7.d int[] other, @a7.d i5.p<? super Integer, ? super Integer, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Integer.valueOf(iArr[i7]), Integer.valueOf(other[i7])));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Character> Ja(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c8 : cArr) {
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                arrayList.add(Character.valueOf(c8));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <C extends Collection<? super Integer>> C Jb(@a7.d int[] iArr, @a7.d C destination, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int i7 : iArr) {
            if (predicate.z(Integer.valueOf(i7)).booleanValue()) {
                destination.add(Integer.valueOf(i7));
            }
        }
        return destination;
    }

    @a7.e
    public static final Float Jc(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (float f8 : fArr) {
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                return Float.valueOf(f8);
            }
        }
        return null;
    }

    public static final <R> R Jd(@a7.d float[] fArr, R r7, @a7.d i5.p<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (float f8 : fArr) {
            r7 = operation.a0(r7, Float.valueOf(f8));
        }
        return r7;
    }

    @a7.d
    public static final kotlin.ranges.k Je(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return new kotlin.ranges.k(0, Se(cArr));
    }

    @a7.d
    public static final <K, V> Map<K, List<V>> Jf(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends K> keySelector, @a7.d i5.l<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z7 : zArr) {
            K kZ = keySelector.z(Boolean.valueOf(z7));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(Boolean.valueOf(z7)));
        }
        return linkedHashMap;
    }

    @a7.d
    public static final Set<Long> Jg(@a7.d long[] jArr, @a7.d Iterable<Long> other) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Long> setCz = Cz(jArr);
        d0.O0(setCz, other);
        return setCz;
    }

    public static /* synthetic */ String Jh(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
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
        return Ah(fArr, charSequence, charSequence5, charSequence6, i9, charSequence7, lVar);
    }

    @a7.d
    public static final <R> List<R> Ji(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c8 : cArr) {
            arrayList.add(transform.z(Character.valueOf(c8)));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> int Jj(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i7 = iArr[0];
        int iVe = Ve(iArr);
        if (iVe == 0) {
            return i7;
        }
        R rZ = selector.z(Integer.valueOf(i7));
        u0 it = new kotlin.ranges.k(1, iVe).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            R rZ2 = selector.z(Integer.valueOf(i8));
            if (rZ.compareTo(rZ2) < 0) {
                i7 = i8;
                rZ = rZ2;
            }
        }
        return i7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float Jk(double[] dArr, i5.l<? super Double, Float> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Double.valueOf(dArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Double.valueOf(dArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <T> T Jl(@a7.d T[] tArr, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t7 = tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            if (comparator.compare(t7, t8) < 0) {
                t7 = t8;
            }
        }
        return t7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Jm(long[] jArr, i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Long.valueOf(jArr[0]));
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Long.valueOf(jArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Double Jn(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dMin = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            dMin = Math.min(dMin, dArr[it.b()]);
        }
        return Double.valueOf(dMin);
    }

    public static final boolean Jo(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (boolean z7 : zArr) {
            if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Double Jp(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return Kp(dArr, kotlin.random.f.f34998a);
    }

    public static final int Jq(@a7.d int[] iArr, @a7.d i5.p<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iVe = Ve(iArr);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[iVe];
        for (int i7 = iVe - 1; i7 >= 0; i7--) {
            iIntValue = operation.a0(Integer.valueOf(iArr[i7]), Integer.valueOf(iIntValue)).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final List<Character> Jr(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return kotlin.collections.y.F();
        }
        List<Character> listPz = pz(cArr);
        f0.m1(listPz);
        return listPz;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Boolean> Js(boolean[] zArr, i5.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.y.F();
        }
        boolean zBooleanValue = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(zBooleanValue));
        int length = zArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            zBooleanValue = operation.v(Integer.valueOf(i7), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[i7])).booleanValue();
            arrayList.add(Boolean.valueOf(zBooleanValue));
        }
        return arrayList;
    }

    public static short Jt(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return sArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @a7.d
    public static final <T> T[] Ju(@a7.d T[] tArr, @a7.d Collection<Integer> indices) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        T[] tArr2 = (T[]) kotlin.collections.m.a(tArr, indices.size());
        Iterator<Integer> it = indices.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            tArr2[i7] = tArr[it.next().intValue()];
            i7++;
        }
        return tArr2;
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Float> Jv(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return jw(fArr, new kotlin.comparisons.b.C0428b(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Jw(@a7.d long[] jArr, @a7.d i5.l<? super Long, Integer> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (long j7 : jArr) {
            iIntValue += selector.z(Long.valueOf(j7)).intValue();
        }
        return iIntValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final <T> int Jx(T[] tArr, i5.l<? super T, w1> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iH = w1.h(0);
        for (T t7 : tArr) {
            iH = w1.h(iH + selector.z(t7).g0());
        }
        return iH;
    }

    @a7.d
    public static final <C extends Collection<? super Byte>> C Jy(@a7.d byte[] bArr, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (byte b8 : bArr) {
            destination.add(Byte.valueOf(b8));
        }
        return destination;
    }

    @a7.d
    public static final Set<Float> Jz(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            return length != 1 ? (Set) My(fArr, new LinkedHashSet(b1.j(fArr.length))) : m1.f(Float.valueOf(fArr[0]));
        }
        return n1.k();
    }

    public static final boolean K5(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return !(fArr.length == 0);
    }

    @a7.d
    public static final <T, K, V> Map<K, V> K6(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(tArr.length), 16));
        for (T t7 : tArr) {
            linkedHashMap.put(keySelector.z(t7), valueTransform.z(t7));
        }
        return linkedHashMap;
    }

    public static final double K7(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        double d8 = 0.0d;
        int i7 = 0;
        for (float f8 : fArr) {
            d8 += (double) f8;
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return d8 / ((double) i7);
    }

    @kotlin.internal.f
    private static final <T> T K8(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr[4];
    }

    @a7.d
    public static final List<Integer> K9(@a7.d int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (i7 >= 0) {
            return jy(iArr, kotlin.ranges.q.n(iArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R> List<kotlin.u0<Integer, R>> KA(@a7.d int[] iArr, @a7.d R[] other) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            int i8 = iArr[i7];
            arrayList.add(kotlin.p1.a(Integer.valueOf(i8), other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Double> Ka(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d8 : dArr) {
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                arrayList.add(Double.valueOf(d8));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <C extends Collection<? super Long>> C Kb(@a7.d long[] jArr, @a7.d C destination, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (long j7 : jArr) {
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                destination.add(Long.valueOf(j7));
            }
        }
        return destination;
    }

    @a7.e
    public static final Integer Kc(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    public static final <R> R Kd(@a7.d int[] iArr, R r7, @a7.d i5.p<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int i7 : iArr) {
            r7 = operation.a0(r7, Integer.valueOf(i7));
        }
        return r7;
    }

    @a7.d
    public static final kotlin.ranges.k Ke(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return new kotlin.ranges.k(0, Te(dArr));
    }

    @a7.d
    public static final <K, M extends Map<? super K, List<Byte>>> M Kf(@a7.d byte[] bArr, @a7.d M destination, @a7.d i5.l<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (byte b8 : bArr) {
            K kZ = keySelector.z(Byte.valueOf(b8));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(Byte.valueOf(b8));
        }
        return destination;
    }

    @a7.d
    public static final <T> Set<T> Kg(@a7.d T[] tArr, @a7.d Iterable<? extends T> other) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<T> setDz = Dz(tArr);
        d0.O0(setDz, other);
        return setDz;
    }

    public static /* synthetic */ String Kh(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
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
        return Bh(iArr, charSequence, charSequence5, charSequence6, i9, charSequence7, lVar);
    }

    @a7.d
    public static final <R> List<R> Ki(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d8 : dArr) {
            arrayList.add(transform.z(Double.valueOf(d8)));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> long Kj(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j7 = jArr[0];
        int iWe = We(jArr);
        if (iWe == 0) {
            return j7;
        }
        R rZ = selector.z(Long.valueOf(j7));
        u0 it = new kotlin.ranges.k(1, iWe).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            R rZ2 = selector.z(Long.valueOf(j8));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
                j7 = j8;
            }
        }
        return j7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float Kk(float[] fArr, i5.l<? super Float, Float> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Float.valueOf(fArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Float.valueOf(fArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Short Kl(@a7.d short[] sArr, @a7.d Comparator<? super Short> comparator) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s7 = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            if (comparator.compare(Short.valueOf(s7), Short.valueOf(s8)) < 0) {
                s7 = s8;
            }
        }
        return Short.valueOf(s7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R extends Comparable<? super R>> R Km(T[] tArr, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(tArr[0]);
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(tArr[it.b()]);
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Double Kn(@a7.d Double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        u0 it = new kotlin.ranges.k(1, Xe(dArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, dArr[it.b()].doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final byte[] Ko(byte[] bArr, i5.l<? super Byte, l2> action) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (byte b8 : bArr) {
            action.z(Byte.valueOf(b8));
        }
        return bArr;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Double Kp(@a7.d double[] dArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[random.m(dArr.length)]);
    }

    public static final long Kq(@a7.d long[] jArr, @a7.d i5.p<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iWe = We(jArr);
        if (iWe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[iWe];
        for (int i7 = iWe - 1; i7 >= 0; i7--) {
            jLongValue = operation.a0(Long.valueOf(jArr[i7]), Long.valueOf(jLongValue)).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final List<Double> Kr(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return kotlin.collections.y.F();
        }
        List<Double> listQz = qz(dArr);
        f0.m1(listQz);
        return listQz;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Ks(byte[] bArr, R r7, i5.p<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r7);
        for (byte b8 : bArr) {
            r7 = operation.a0(r7, Byte.valueOf(b8));
            arrayList.add(r7);
        }
        return arrayList;
    }

    public static final short Kt(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Short shValueOf = null;
        boolean z7 = false;
        for (short s7 : sArr) {
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                shValueOf = Short.valueOf(s7);
                z7 = true;
            }
        }
        if (!z7) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.l0.n(shValueOf, "null cannot be cast to non-null type kotlin.Short");
        return shValueOf.shortValue();
    }

    @a7.d
    public static final <T> T[] Ku(@a7.d T[] tArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? (T[]) kotlin.collections.o.M1(tArr, 0, 0) : (T[]) kotlin.collections.o.M1(tArr, indices.d().intValue(), indices.f().intValue() + 1);
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Integer> Kv(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return kw(iArr, new kotlin.comparisons.b.C0428b(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> int Kw(@a7.d T[] tArr, @a7.d i5.l<? super T, Integer> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (T t7 : tArr) {
            iIntValue += selector.z(t7).intValue();
        }
        return iIntValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final int Kx(short[] sArr, i5.l<? super Short, w1> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iH = w1.h(0);
        for (short s7 : sArr) {
            iH = w1.h(iH + selector.z(Short.valueOf(s7)).g0());
        }
        return iH;
    }

    @a7.d
    public static final <C extends Collection<? super Character>> C Ky(@a7.d char[] cArr, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (char c8 : cArr) {
            destination.add(Character.valueOf(c8));
        }
        return destination;
    }

    @a7.d
    public static final Set<Integer> Kz(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            return length != 1 ? (Set) Ny(iArr, new LinkedHashSet(b1.j(iArr.length))) : m1.f(Integer.valueOf(iArr[0]));
        }
        return n1.k();
    }

    public static final boolean L5(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (float f8 : fArr) {
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final <K> Map<K, Short> L6(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(sArr.length), 16));
        for (short s7 : sArr) {
            linkedHashMap.put(keySelector.z(Short.valueOf(s7)), Short.valueOf(s7));
        }
        return linkedHashMap;
    }

    public static final double L7(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        double d8 = 0.0d;
        int i7 = 0;
        for (int i8 : iArr) {
            d8 += (double) i8;
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return d8 / ((double) i7);
    }

    @kotlin.internal.f
    private static final short L8(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr[4];
    }

    @a7.d
    public static final List<Long> L9(@a7.d long[] jArr, int i7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (i7 >= 0) {
            return ky(jArr, kotlin.ranges.q.n(jArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R, V> List<V> LA(@a7.d int[] iArr, @a7.d R[] other, @a7.d i5.p<? super Integer, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Integer.valueOf(iArr[i7]), other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Float> La(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f8 : fArr) {
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                arrayList.add(Float.valueOf(f8));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C Lb(@a7.d T[] tArr, @a7.d C destination, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : tArr) {
            if (predicate.z(t7).booleanValue()) {
                destination.add(t7);
            }
        }
        return destination;
    }

    @a7.e
    public static final Integer Lc(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int i7 : iArr) {
            if (predicate.z(Integer.valueOf(i7)).booleanValue()) {
                return Integer.valueOf(i7);
            }
        }
        return null;
    }

    public static final <R> R Ld(@a7.d long[] jArr, R r7, @a7.d i5.p<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (long j7 : jArr) {
            r7 = operation.a0(r7, Long.valueOf(j7));
        }
        return r7;
    }

    @a7.d
    public static final kotlin.ranges.k Le(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return new kotlin.ranges.k(0, Ue(fArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, M extends Map<? super K, List<V>>> M Lf(@a7.d byte[] bArr, @a7.d M destination, @a7.d i5.l<? super Byte, ? extends K> keySelector, @a7.d i5.l<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (byte b8 : bArr) {
            K kZ = keySelector.z(Byte.valueOf(b8));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(Byte.valueOf(b8)));
        }
        return destination;
    }

    @a7.d
    public static final Set<Short> Lg(@a7.d short[] sArr, @a7.d Iterable<Short> other) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Short> setEz = Ez(sArr);
        d0.O0(setEz, other);
        return setEz;
    }

    public static /* synthetic */ String Lh(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
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
        return Ch(jArr, charSequence, charSequence5, charSequence6, i9, charSequence7, lVar);
    }

    @a7.d
    public static final <R> List<R> Li(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f8 : fArr) {
            arrayList.add(transform.z(Float.valueOf(f8)));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T Lj(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t7 = tArr[0];
        int iXe = Xe(tArr);
        if (iXe == 0) {
            return t7;
        }
        R rZ = selector.z(t7);
        u0 it = new kotlin.ranges.k(1, iXe).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            R rZ2 = selector.z(t8);
            if (rZ.compareTo(rZ2) < 0) {
                t7 = t8;
                rZ = rZ2;
            }
        }
        return t7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float Lk(int[] iArr, i5.l<? super Integer, Float> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Integer.valueOf(iArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Integer.valueOf(iArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final byte Ll(@a7.d byte[] bArr, @a7.d Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b8 = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            if (comparator.compare(Byte.valueOf(b8), Byte.valueOf(b9)) < 0) {
                b8 = b9;
            }
        }
        return b8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Lm(short[] sArr, i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Short.valueOf(sArr[0]));
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Short.valueOf(sArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Float Ln(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fMin = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            fMin = Math.min(fMin, fArr[it.b()]);
        }
        return Float.valueOf(fMin);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final char[] Lo(char[] cArr, i5.l<? super Character, l2> action) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (char c8 : cArr) {
            action.z(Character.valueOf(c8));
        }
        return cArr;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Float Lp(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return Mp(fArr, kotlin.random.f.f34998a);
    }

    public static final <S, T extends S> S Lq(@a7.d T[] tArr, @a7.d i5.p<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iXe = Xe(tArr);
        if (iXe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sA0 = (S) tArr[iXe];
        for (int i7 = iXe - 1; i7 >= 0; i7--) {
            sA0 = operation.a0((Object) tArr[i7], sA0);
        }
        return sA0;
    }

    @a7.d
    public static final List<Float> Lr(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return kotlin.collections.y.F();
        }
        List<Float> listRz = rz(fArr);
        f0.m1(listRz);
        return listRz;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Ls(char[] cArr, R r7, i5.p<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r7);
        for (char c8 : cArr) {
            r7 = operation.a0(r7, Character.valueOf(c8));
            arrayList.add(r7);
        }
        return arrayList;
    }

    public static final boolean Lt(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return zArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @a7.d
    public static short[] Lu(@a7.d short[] sArr, @a7.d Collection<Integer> indices) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        short[] sArr2 = new short[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            sArr2[i7] = sArr[it.next().intValue()];
            i7++;
        }
        return sArr2;
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Long> Lv(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return lw(jArr, new kotlin.comparisons.b.C0428b(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Lw(@a7.d short[] sArr, @a7.d i5.l<? super Short, Integer> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (short s7 : sArr) {
            iIntValue += selector.z(Short.valueOf(s7)).intValue();
        }
        return iIntValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfUInt")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final int Lx(boolean[] zArr, i5.l<? super Boolean, w1> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iH = w1.h(0);
        for (boolean z7 : zArr) {
            iH = w1.h(iH + selector.z(Boolean.valueOf(z7)).g0());
        }
        return iH;
    }

    @a7.d
    public static final <C extends Collection<? super Double>> C Ly(@a7.d double[] dArr, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (double d8 : dArr) {
            destination.add(Double.valueOf(d8));
        }
        return destination;
    }

    @a7.d
    public static final Set<Long> Lz(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            return length != 1 ? (Set) Oy(jArr, new LinkedHashSet(b1.j(jArr.length))) : m1.f(Long.valueOf(jArr[0]));
        }
        return n1.k();
    }

    public static boolean M5(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return !(iArr.length == 0);
    }

    @a7.d
    public static final <K, V> Map<K, V> M6(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends K> keySelector, @a7.d i5.l<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(sArr.length), 16));
        for (short s7 : sArr) {
            linkedHashMap.put(keySelector.z(Short.valueOf(s7)), valueTransform.z(Short.valueOf(s7)));
        }
        return linkedHashMap;
    }

    public static final double M7(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        double d8 = 0.0d;
        int i7 = 0;
        for (long j7 : jArr) {
            d8 += j7;
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return d8 / ((double) i7);
    }

    @kotlin.internal.f
    private static final boolean M8(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr[4];
    }

    @a7.d
    public static final <T> List<T> M9(@a7.d T[] tArr, int i7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (i7 >= 0) {
            return ly(tArr, kotlin.ranges.q.n(tArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R> List<kotlin.u0<Long, R>> MA(@a7.d long[] jArr, @a7.d Iterable<? extends R> other) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(kotlin.p1.a(Long.valueOf(jArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final List<Integer> Ma(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i7 : iArr) {
            if (predicate.z(Integer.valueOf(i7)).booleanValue()) {
                arrayList.add(Integer.valueOf(i7));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <C extends Collection<? super Short>> C Mb(@a7.d short[] sArr, @a7.d C destination, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (short s7 : sArr) {
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                destination.add(Short.valueOf(s7));
            }
        }
        return destination;
    }

    @a7.e
    public static final Long Mc(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R Md(@a7.d T[] tArr, R r7, @a7.d i5.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (a1.c cVar : tArr) {
            r7 = operation.a0(r7, cVar);
        }
        return r7;
    }

    @a7.d
    public static kotlin.ranges.k Me(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return new kotlin.ranges.k(0, Ve(iArr));
    }

    @a7.d
    public static final <K, M extends Map<? super K, List<Character>>> M Mf(@a7.d char[] cArr, @a7.d M destination, @a7.d i5.l<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (char c8 : cArr) {
            K kZ = keySelector.z(Character.valueOf(c8));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(c8));
        }
        return destination;
    }

    @a7.d
    public static final Set<Boolean> Mg(@a7.d boolean[] zArr, @a7.d Iterable<Boolean> other) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Boolean> setFz = Fz(zArr);
        d0.O0(setFz, other);
        return setFz;
    }

    public static /* synthetic */ String Mh(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
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
        return Dh(objArr, charSequence, charSequence5, charSequence6, i9, charSequence7, lVar);
    }

    @a7.d
    public static final <R> List<R> Mi(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i7 : iArr) {
            arrayList.add(transform.z(Integer.valueOf(i7)));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> short Mj(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s7 = sArr[0];
        int iYe = Ye(sArr);
        if (iYe == 0) {
            return s7;
        }
        R rZ = selector.z(Short.valueOf(s7));
        u0 it = new kotlin.ranges.k(1, iYe).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            R rZ2 = selector.z(Short.valueOf(s8));
            if (rZ.compareTo(rZ2) < 0) {
                s7 = s8;
                rZ = rZ2;
            }
        }
        return s7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float Mk(long[] jArr, i5.l<? super Long, Float> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Long.valueOf(jArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Long.valueOf(jArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final char Ml(@a7.d char[] cArr, @a7.d Comparator<? super Character> comparator) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c8 = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            if (comparator.compare(Character.valueOf(c8), Character.valueOf(c9)) < 0) {
                c8 = c9;
            }
        }
        return c8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Mm(boolean[] zArr, i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Boolean.valueOf(zArr[0]));
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Boolean.valueOf(zArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Float Mn(@a7.d Float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        u0 it = new kotlin.ranges.k(1, Xe(fArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, fArr[it.b()].floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final double[] Mo(double[] dArr, i5.l<? super Double, l2> action) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (double d8 : dArr) {
            action.z(Double.valueOf(d8));
        }
        return dArr;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Float Mp(@a7.d float[] fArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[random.m(fArr.length)]);
    }

    public static final short Mq(@a7.d short[] sArr, @a7.d i5.p<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iYe = Ye(sArr);
        if (iYe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[iYe];
        for (int i7 = iYe - 1; i7 >= 0; i7--) {
            sShortValue = operation.a0(Short.valueOf(sArr[i7]), Short.valueOf(sShortValue)).shortValue();
        }
        return sShortValue;
    }

    @a7.d
    public static final List<Integer> Mr(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return kotlin.collections.y.F();
        }
        List<Integer> listSz = sz(iArr);
        f0.m1(listSz);
        return listSz;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Ms(double[] dArr, R r7, i5.p<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r7);
        for (double d8 : dArr) {
            r7 = operation.a0(r7, Double.valueOf(d8));
            arrayList.add(r7);
        }
        return arrayList;
    }

    public static final boolean Mt(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Boolean boolValueOf = null;
        boolean z7 = false;
        for (boolean z8 : zArr) {
            if (predicate.z(Boolean.valueOf(z8)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                boolValueOf = Boolean.valueOf(z8);
                z7 = true;
            }
        }
        if (!z7) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.l0.n(boolValueOf, "null cannot be cast to non-null type kotlin.Boolean");
        return boolValueOf.booleanValue();
    }

    @a7.d
    public static short[] Mu(@a7.d short[] sArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? new short[0] : kotlin.collections.o.N1(sArr, indices.d().intValue(), indices.f().intValue() + 1);
    }

    @a7.d
    public static final <T, R extends Comparable<? super R>> List<T> Mv(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return mw(tArr, new kotlin.comparisons.b.C0428b(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Mw(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Integer> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (boolean z7 : zArr) {
            iIntValue += selector.z(Boolean.valueOf(z7)).intValue();
        }
        return iIntValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final long Mx(byte[] bArr, i5.l<? super Byte, a2> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jH = a2.h(0L);
        for (byte b8 : bArr) {
            jH = a2.h(jH + selector.z(Byte.valueOf(b8)).g0());
        }
        return jH;
    }

    @a7.d
    public static final <C extends Collection<? super Float>> C My(@a7.d float[] fArr, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (float f8 : fArr) {
            destination.add(Float.valueOf(f8));
        }
        return destination;
    }

    @a7.d
    public static final <T> Set<T> Mz(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? (Set) Py(tArr, new LinkedHashSet(b1.j(tArr.length))) : m1.f(tArr[0]);
        }
        return n1.k();
    }

    public static final boolean N5(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int i7 : iArr) {
            if (predicate.z(Integer.valueOf(i7)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final <K> Map<K, Boolean> N6(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(zArr.length), 16));
        for (boolean z7 : zArr) {
            linkedHashMap.put(keySelector.z(Boolean.valueOf(z7)), Boolean.valueOf(z7));
        }
        return linkedHashMap;
    }

    public static final double N7(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        double d8 = 0.0d;
        int i7 = 0;
        for (short s7 : sArr) {
            d8 += (double) s7;
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return d8 / ((double) i7);
    }

    public static boolean N8(@a7.d byte[] bArr, byte b8) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return dg(bArr, b8) >= 0;
    }

    @a7.d
    public static final List<Short> N9(@a7.d short[] sArr, int i7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (i7 >= 0) {
            return my(sArr, kotlin.ranges.q.n(sArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R, V> List<V> NA(@a7.d long[] jArr, @a7.d Iterable<? extends R> other, @a7.d i5.p<? super Long, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(transform.a0(Long.valueOf(jArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final List<Long> Na(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j7 : jArr) {
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                arrayList.add(Long.valueOf(j7));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <C extends Collection<? super Boolean>> C Nb(@a7.d boolean[] zArr, @a7.d C destination, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (boolean z7 : zArr) {
            if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                destination.add(Boolean.valueOf(z7));
            }
        }
        return destination;
    }

    @a7.e
    public static final Long Nc(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (long j7 : jArr) {
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                return Long.valueOf(j7);
            }
        }
        return null;
    }

    public static final <R> R Nd(@a7.d short[] sArr, R r7, @a7.d i5.p<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (short s7 : sArr) {
            r7 = operation.a0(r7, Short.valueOf(s7));
        }
        return r7;
    }

    @a7.d
    public static kotlin.ranges.k Ne(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return new kotlin.ranges.k(0, We(jArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, M extends Map<? super K, List<V>>> M Nf(@a7.d char[] cArr, @a7.d M destination, @a7.d i5.l<? super Character, ? extends K> keySelector, @a7.d i5.l<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (char c8 : cArr) {
            K kZ = keySelector.z(Character.valueOf(c8));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(Character.valueOf(c8)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean Ng(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr.length == 0;
    }

    public static /* synthetic */ String Nh(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
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
        return Eh(sArr, charSequence, charSequence5, charSequence6, i9, charSequence7, lVar);
    }

    @a7.d
    public static final <R> List<R> Ni(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j7 : jArr) {
            arrayList.add(transform.z(Long.valueOf(j7)));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> boolean Nj(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z7 = zArr[0];
        int iZe = Ze(zArr);
        if (iZe == 0) {
            return z7;
        }
        R rZ = selector.z(Boolean.valueOf(z7));
        u0 it = new kotlin.ranges.k(1, iZe).iterator();
        while (it.hasNext()) {
            boolean z8 = zArr[it.b()];
            R rZ2 = selector.z(Boolean.valueOf(z8));
            if (rZ.compareTo(rZ2) < 0) {
                z7 = z8;
                rZ = rZ2;
            }
        }
        return z7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> Float Nk(T[] tArr, i5.l<? super T, Float> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(tArr[0]).floatValue();
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(tArr[it.b()]).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final double Nl(@a7.d double[] dArr, @a7.d Comparator<? super Double> comparator) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d8 = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            double d9 = dArr[it.b()];
            if (comparator.compare(Double.valueOf(d8), Double.valueOf(d9)) < 0) {
                d8 = d9;
            }
        }
        return d8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Nm(byte[] bArr, i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Byte.valueOf(bArr[0]));
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Byte.valueOf(bArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Integer Nn(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i7 = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            if (i7 > i8) {
                i7 = i8;
            }
        }
        return Integer.valueOf(i7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final float[] No(float[] fArr, i5.l<? super Float, l2> action) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (float f8 : fArr) {
            action.z(Float.valueOf(f8));
        }
        return fArr;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Integer Np(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return Op(iArr, kotlin.random.f.f34998a);
    }

    public static final boolean Nq(@a7.d boolean[] zArr, @a7.d i5.p<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iZe = Ze(zArr);
        if (iZe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[iZe];
        for (int i7 = iZe - 1; i7 >= 0; i7--) {
            zBooleanValue = operation.a0(Boolean.valueOf(zArr[i7]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return zBooleanValue;
    }

    @a7.d
    public static final List<Long> Nr(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return kotlin.collections.y.F();
        }
        List<Long> listTz = tz(jArr);
        f0.m1(listTz);
        return listTz;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Ns(float[] fArr, R r7, i5.p<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r7);
        for (float f8 : fArr) {
            r7 = operation.a0(r7, Float.valueOf(f8));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Boolean Nt(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    @a7.d
    public static final boolean[] Nu(@a7.d boolean[] zArr, @a7.d Collection<Integer> indices) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        boolean[] zArr2 = new boolean[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            zArr2[i7] = zArr[it.next().intValue()];
            i7++;
        }
        return zArr2;
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Short> Nv(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return nw(sArr, new kotlin.comparisons.b.C0428b(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Nw(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (byte b8 : bArr) {
            dDoubleValue += selector.z(Byte.valueOf(b8)).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final long Nx(char[] cArr, i5.l<? super Character, a2> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jH = a2.h(0L);
        for (char c8 : cArr) {
            jH = a2.h(jH + selector.z(Character.valueOf(c8)).g0());
        }
        return jH;
    }

    @a7.d
    public static final <C extends Collection<? super Integer>> C Ny(@a7.d int[] iArr, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (int i7 : iArr) {
            destination.add(Integer.valueOf(i7));
        }
        return destination;
    }

    @a7.d
    public static final Set<Short> Nz(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        int length = sArr.length;
        if (length != 0) {
            return length != 1 ? (Set) Qy(sArr, new LinkedHashSet(b1.j(sArr.length))) : m1.f(Short.valueOf(sArr[0]));
        }
        return n1.k();
    }

    public static boolean O5(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return !(jArr.length == 0);
    }

    @a7.d
    public static final <K, V> Map<K, V> O6(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends K> keySelector, @a7.d i5.l<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(zArr.length), 16));
        for (boolean z7 : zArr) {
            linkedHashMap.put(keySelector.z(Boolean.valueOf(z7)), valueTransform.z(Boolean.valueOf(z7)));
        }
        return linkedHashMap;
    }

    @h5.h(name = "averageOfByte")
    public static final double O7(@a7.d Byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        double dByteValue = 0.0d;
        int i7 = 0;
        for (Byte b8 : bArr) {
            dByteValue += (double) b8.byteValue();
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i7);
    }

    public static boolean O8(@a7.d char[] cArr, char c8) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return eg(cArr, c8) >= 0;
    }

    @a7.d
    public static final List<Boolean> O9(@a7.d boolean[] zArr, int i7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (i7 >= 0) {
            return ny(zArr, kotlin.ranges.q.n(zArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final List<kotlin.u0<Long, Long>> OA(@a7.d long[] jArr, @a7.d long[] other) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(kotlin.p1.a(Long.valueOf(jArr[i7]), Long.valueOf(other[i7])));
        }
        return arrayList;
    }

    @a7.d
    public static final <T> List<T> Oa(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t7 : tArr) {
            if (predicate.z(t7).booleanValue()) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Boolean Ob(boolean[] zArr, i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (boolean z7 : zArr) {
            if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                return Boolean.valueOf(z7);
            }
        }
        return null;
    }

    @a7.e
    public static final <T> T Oc(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final <R> R Od(@a7.d boolean[] zArr, R r7, @a7.d i5.p<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (boolean z7 : zArr) {
            r7 = operation.a0(r7, Boolean.valueOf(z7));
        }
        return r7;
    }

    @a7.d
    public static <T> kotlin.ranges.k Oe(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return new kotlin.ranges.k(0, Xe(tArr));
    }

    @a7.d
    public static final <K, M extends Map<? super K, List<Double>>> M Of(@a7.d double[] dArr, @a7.d M destination, @a7.d i5.l<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (double d8 : dArr) {
            K kZ = keySelector.z(Double.valueOf(d8));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(Double.valueOf(d8));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean Og(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr.length == 0;
    }

    public static /* synthetic */ String Oh(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i7, CharSequence charSequence4, i5.l lVar, int i8, Object obj) {
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
        return Fh(zArr, charSequence, charSequence5, charSequence6, i9, charSequence7, lVar);
    }

    @a7.d
    public static final <T, R> List<R> Oi(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t7 : tArr) {
            arrayList.add(transform.z(t7));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double Oj(byte[] bArr, i5.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Byte.valueOf(bArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Byte.valueOf(bArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float Ok(short[] sArr, i5.l<? super Short, Float> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Short.valueOf(sArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Short.valueOf(sArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final float Ol(@a7.d float[] fArr, @a7.d Comparator<? super Float> comparator) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f8 = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            float f9 = fArr[it.b()];
            if (comparator.compare(Float.valueOf(f8), Float.valueOf(f9)) < 0) {
                f8 = f9;
            }
        }
        return f8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Om(char[] cArr, i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Character.valueOf(cArr[0]));
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(cArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Long On(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j7 = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            if (j7 > j8) {
                j7 = j8;
            }
        }
        return Long.valueOf(j7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final int[] Oo(int[] iArr, i5.l<? super Integer, l2> action) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (int i7 : iArr) {
            action.z(Integer.valueOf(i7));
        }
        return iArr;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Integer Op(@a7.d int[] iArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[random.m(iArr.length)]);
    }

    public static final byte Oq(@a7.d byte[] bArr, @a7.d i5.q<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iRe = Re(bArr);
        if (iRe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[iRe];
        for (int i7 = iRe - 1; i7 >= 0; i7--) {
            bByteValue = operation.v(Integer.valueOf(i7), Byte.valueOf(bArr[i7]), Byte.valueOf(bByteValue)).byteValue();
        }
        return bByteValue;
    }

    @a7.d
    public static final <T> List<T> Or(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return kotlin.collections.y.F();
        }
        List<T> listUz = uz(tArr);
        f0.m1(listUz);
        return listUz;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Os(int[] iArr, R r7, i5.p<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r7);
        for (int i7 : iArr) {
            r7 = operation.a0(r7, Integer.valueOf(i7));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Boolean Ot(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Boolean boolValueOf = null;
        boolean z7 = false;
        for (boolean z8 : zArr) {
            if (predicate.z(Boolean.valueOf(z8)).booleanValue()) {
                if (z7) {
                    return null;
                }
                boolValueOf = Boolean.valueOf(z8);
                z7 = true;
            }
        }
        if (z7) {
            return boolValueOf;
        }
        return null;
    }

    @a7.d
    public static final boolean[] Ou(@a7.d boolean[] zArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? new boolean[0] : kotlin.collections.o.O1(zArr, indices.d().intValue(), indices.f().intValue() + 1);
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Boolean> Ov(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return ow(zArr, new kotlin.comparisons.b.C0428b(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Ow(@a7.d char[] cArr, @a7.d i5.l<? super Character, Double> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (char c8 : cArr) {
            dDoubleValue += selector.z(Character.valueOf(c8)).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final long Ox(double[] dArr, i5.l<? super Double, a2> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jH = a2.h(0L);
        for (double d8 : dArr) {
            jH = a2.h(jH + selector.z(Double.valueOf(d8)).g0());
        }
        return jH;
    }

    @a7.d
    public static final <C extends Collection<? super Long>> C Oy(@a7.d long[] jArr, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (long j7 : jArr) {
            destination.add(Long.valueOf(j7));
        }
        return destination;
    }

    @a7.d
    public static final Set<Boolean> Oz(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        int length = zArr.length;
        if (length != 0) {
            return length != 1 ? (Set) Ry(zArr, new LinkedHashSet(b1.j(zArr.length))) : m1.f(Boolean.valueOf(zArr[0]));
        }
        return n1.k();
    }

    public static final boolean P5(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (long j7 : jArr) {
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final <K, M extends Map<? super K, ? super Byte>> M P6(@a7.d byte[] bArr, @a7.d M destination, @a7.d i5.l<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (byte b8 : bArr) {
            destination.put(keySelector.z(Byte.valueOf(b8)), Byte.valueOf(b8));
        }
        return destination;
    }

    @h5.h(name = "averageOfDouble")
    public static final double P7(@a7.d Double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        double dDoubleValue = 0.0d;
        int i7 = 0;
        for (Double d8 : dArr) {
            dDoubleValue += d8.doubleValue();
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i7);
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.b1(expression = "any { it == element }", imports = {}))
    @kotlin.l(errorSince = i2.a.f34096f, hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ boolean P8(double[] dArr, double d8) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        for (double d9 : dArr) {
            if (d9 == d8) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final List<Byte> P9(@a7.d byte[] bArr, int i7) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (i7 >= 0) {
            return Vx(bArr, kotlin.ranges.q.n(bArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <V> List<V> PA(@a7.d long[] jArr, @a7.d long[] other, @a7.d i5.p<? super Long, ? super Long, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Long.valueOf(jArr[i7]), Long.valueOf(other[i7])));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Short> Pa(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s7 : sArr) {
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                arrayList.add(Short.valueOf(s7));
            }
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Byte Pb(byte[] bArr, i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (byte b8 : bArr) {
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                return Byte.valueOf(b8);
            }
        }
        return null;
    }

    @a7.e
    public static final <T> T Pc(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : tArr) {
            if (predicate.z(t7).booleanValue()) {
                return t7;
            }
        }
        return null;
    }

    public static final <R> R Pd(@a7.d byte[] bArr, R r7, @a7.d i5.q<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            r7 = operation.v(Integer.valueOf(i8), r7, Byte.valueOf(bArr[i7]));
            i7++;
            i8++;
        }
        return r7;
    }

    @a7.d
    public static kotlin.ranges.k Pe(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return new kotlin.ranges.k(0, Ye(sArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, M extends Map<? super K, List<V>>> M Pf(@a7.d double[] dArr, @a7.d M destination, @a7.d i5.l<? super Double, ? extends K> keySelector, @a7.d i5.l<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (double d8 : dArr) {
            K kZ = keySelector.z(Double.valueOf(d8));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(Double.valueOf(d8)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean Pg(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr.length == 0;
    }

    public static byte Ph(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return bArr[Re(bArr)];
    }

    @a7.d
    public static final <R> List<R> Pi(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s7 : sArr) {
            arrayList.add(transform.z(Short.valueOf(s7)));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double Pj(char[] cArr, i5.l<? super Character, Double> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Character.valueOf(cArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Character.valueOf(cArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float Pk(boolean[] zArr, i5.l<? super Boolean, Float> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Boolean.valueOf(zArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Boolean.valueOf(zArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final int Pl(@a7.d int[] iArr, @a7.d Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i7 = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            if (comparator.compare(Integer.valueOf(i7), Integer.valueOf(i8)) < 0) {
                i7 = i8;
            }
        }
        return i7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Pm(double[] dArr, i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Double.valueOf(dArr[0]));
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Double.valueOf(dArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Short Pn(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s7 = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            if (s7 > s8) {
                s7 = s8;
            }
        }
        return Short.valueOf(s7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final long[] Po(long[] jArr, i5.l<? super Long, l2> action) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (long j7 : jArr) {
            action.z(Long.valueOf(j7));
        }
        return jArr;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Long Pp(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return Qp(jArr, kotlin.random.f.f34998a);
    }

    public static final char Pq(@a7.d char[] cArr, @a7.d i5.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iSe = Se(cArr);
        if (iSe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[iSe];
        for (int i7 = iSe - 1; i7 >= 0; i7--) {
            cCharValue = operation.v(Integer.valueOf(i7), Character.valueOf(cArr[i7]), Character.valueOf(cCharValue)).charValue();
        }
        return cCharValue;
    }

    @a7.d
    public static final List<Short> Pr(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return kotlin.collections.y.F();
        }
        List<Short> listVz = vz(sArr);
        f0.m1(listVz);
        return listVz;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Ps(long[] jArr, R r7, i5.p<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r7);
        for (long j7 : jArr) {
            r7 = operation.a0(r7, Long.valueOf(j7));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Byte Pt(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    public static final <T, R extends Comparable<? super R>> void Pu(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length > 1) {
            kotlin.collections.o.I4(tArr, new kotlin.comparisons.b.C0428b(selector));
        }
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Byte> Pv(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return gw(bArr, new kotlin.comparisons.b.d(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Pw(@a7.d double[] dArr, @a7.d i5.l<? super Double, Double> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (double d8 : dArr) {
            dDoubleValue += selector.z(Double.valueOf(d8)).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final long Px(float[] fArr, i5.l<? super Float, a2> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jH = a2.h(0L);
        for (float f8 : fArr) {
            jH = a2.h(jH + selector.z(Float.valueOf(f8)).g0());
        }
        return jH;
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C Py(@a7.d T[] tArr, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (T t7 : tArr) {
            destination.add(t7);
        }
        return destination;
    }

    @a7.d
    public static final short[] Pz(@a7.d Short[] shArr) {
        kotlin.jvm.internal.l0.p(shArr, "<this>");
        int length = shArr.length;
        short[] sArr = new short[length];
        for (int i7 = 0; i7 < length; i7++) {
            sArr[i7] = shArr[i7].shortValue();
        }
        return sArr;
    }

    public static final <T> boolean Q5(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return !(tArr.length == 0);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M Q6(@a7.d byte[] bArr, @a7.d M destination, @a7.d i5.l<? super Byte, ? extends K> keySelector, @a7.d i5.l<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (byte b8 : bArr) {
            destination.put(keySelector.z(Byte.valueOf(b8)), valueTransform.z(Byte.valueOf(b8)));
        }
        return destination;
    }

    @h5.h(name = "averageOfFloat")
    public static final double Q7(@a7.d Float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        double dFloatValue = 0.0d;
        int i7 = 0;
        for (Float f8 : fArr) {
            dFloatValue += (double) f8.floatValue();
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i7);
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.b1(expression = "any { it == element }", imports = {}))
    @kotlin.l(errorSince = i2.a.f34096f, hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ boolean Q8(float[] fArr, float f8) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        for (float f9 : fArr) {
            if (f9 == f8) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final List<Character> Q9(@a7.d char[] cArr, int i7) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (i7 >= 0) {
            return Wx(cArr, kotlin.ranges.q.n(cArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R> List<kotlin.u0<Long, R>> QA(@a7.d long[] jArr, @a7.d R[] other) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            long j7 = jArr[i7];
            arrayList.add(kotlin.p1.a(Long.valueOf(j7), other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Boolean> Qa(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z7 : zArr) {
            if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z7));
            }
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Character Qb(char[] cArr, i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (char c8 : cArr) {
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                return Character.valueOf(c8);
            }
        }
        return null;
    }

    @a7.e
    public static final Short Qc(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    public static final <R> R Qd(@a7.d char[] cArr, R r7, @a7.d i5.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int length = cArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            r7 = operation.v(Integer.valueOf(i8), r7, Character.valueOf(cArr[i7]));
            i7++;
            i8++;
        }
        return r7;
    }

    @a7.d
    public static final kotlin.ranges.k Qe(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return new kotlin.ranges.k(0, Ze(zArr));
    }

    @a7.d
    public static final <K, M extends Map<? super K, List<Float>>> M Qf(@a7.d float[] fArr, @a7.d M destination, @a7.d i5.l<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (float f8 : fArr) {
            K kZ = keySelector.z(Float.valueOf(f8));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(Float.valueOf(f8));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean Qg(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr.length == 0;
    }

    public static final byte Qh(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                byte b8 = bArr[length];
                if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                    return b8;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    public static final <R> List<R> Qi(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z7 : zArr) {
            arrayList.add(transform.z(Boolean.valueOf(z7)));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double Qj(double[] dArr, i5.l<? super Double, Double> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Double.valueOf(dArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Double.valueOf(dArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Qk(byte[] bArr, Comparator<? super R> comparator, i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Byte.valueOf(bArr[0]));
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Byte.valueOf(bArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final long Ql(@a7.d long[] jArr, @a7.d Comparator<? super Long> comparator) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j7 = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            if (comparator.compare(Long.valueOf(j7), Long.valueOf(j8)) < 0) {
                j7 = j8;
            }
        }
        return j7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Qm(float[] fArr, i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Float.valueOf(fArr[0]));
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Float.valueOf(fArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final byte Qn(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b8 = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            if (b8 > b9) {
                b8 = b9;
            }
        }
        return b8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <T> T[] Qo(T[] tArr, i5.l<? super T, l2> action) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (T t7 : tArr) {
            action.z(t7);
        }
        return tArr;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Long Qp(@a7.d long[] jArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[random.m(jArr.length)]);
    }

    public static final double Qq(@a7.d double[] dArr, @a7.d i5.q<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iTe = Te(dArr);
        if (iTe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[iTe];
        for (int i7 = iTe - 1; i7 >= 0; i7--) {
            dDoubleValue = operation.v(Integer.valueOf(i7), Double.valueOf(dArr[i7]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final List<Boolean> Qr(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return kotlin.collections.y.F();
        }
        List<Boolean> listWz = wz(zArr);
        f0.m1(listWz);
        return listWz;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <T, R> List<R> Qs(@a7.d T[] tArr, R r7, @a7.d i5.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r7);
        for (a1.c cVar : tArr) {
            r7 = operation.a0(r7, cVar);
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Byte Qt(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Byte bValueOf = null;
        boolean z7 = false;
        for (byte b8 : bArr) {
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                if (z7) {
                    return null;
                }
                bValueOf = Byte.valueOf(b8);
                z7 = true;
            }
        }
        if (z7) {
            return bValueOf;
        }
        return null;
    }

    public static final <T, R extends Comparable<? super R>> void Qu(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length > 1) {
            kotlin.collections.o.I4(tArr, new kotlin.comparisons.b.d(selector));
        }
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Character> Qv(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return hw(cArr, new kotlin.comparisons.b.d(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Qw(@a7.d float[] fArr, @a7.d i5.l<? super Float, Double> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (float f8 : fArr) {
            dDoubleValue += selector.z(Float.valueOf(f8)).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final long Qx(int[] iArr, i5.l<? super Integer, a2> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jH = a2.h(0L);
        for (int i7 : iArr) {
            jH = a2.h(jH + selector.z(Integer.valueOf(i7)).g0());
        }
        return jH;
    }

    @a7.d
    public static final <C extends Collection<? super Short>> C Qy(@a7.d short[] sArr, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (short s7 : sArr) {
            destination.add(Short.valueOf(s7));
        }
        return destination;
    }

    @a7.d
    public static final Set<Byte> Qz(@a7.d byte[] bArr, @a7.d Iterable<Byte> other) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Byte> setXz = xz(bArr);
        d0.o0(setXz, other);
        return setXz;
    }

    public static final <T> boolean R5(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : tArr) {
            if (predicate.z(t7).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final <K, M extends Map<? super K, ? super Character>> M R6(@a7.d char[] cArr, @a7.d M destination, @a7.d i5.l<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (char c8 : cArr) {
            destination.put(keySelector.z(Character.valueOf(c8)), Character.valueOf(c8));
        }
        return destination;
    }

    @h5.h(name = "averageOfInt")
    public static final double R7(@a7.d Integer[] numArr) {
        kotlin.jvm.internal.l0.p(numArr, "<this>");
        double dIntValue = 0.0d;
        int i7 = 0;
        for (Integer num : numArr) {
            dIntValue += (double) num.intValue();
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i7);
    }

    public static boolean R8(@a7.d int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return hg(iArr, i7) >= 0;
    }

    @a7.d
    public static final List<Double> R9(@a7.d double[] dArr, int i7) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (i7 >= 0) {
            return Xx(dArr, kotlin.ranges.q.n(dArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R, V> List<V> RA(@a7.d long[] jArr, @a7.d R[] other, @a7.d i5.p<? super Long, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Long.valueOf(jArr[i7]), other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Byte> Ra(@a7.d byte[] bArr, @a7.d i5.p<? super Integer, ? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            byte b8 = bArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Byte.valueOf(b8)).booleanValue()) {
                arrayList.add(Byte.valueOf(b8));
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Double Rb(double[] dArr, i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (double d8 : dArr) {
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                return Double.valueOf(d8);
            }
        }
        return null;
    }

    @a7.e
    public static final Short Rc(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (short s7 : sArr) {
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                return Short.valueOf(s7);
            }
        }
        return null;
    }

    public static final <R> R Rd(@a7.d double[] dArr, R r7, @a7.d i5.q<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int length = dArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            r7 = operation.v(Integer.valueOf(i8), r7, Double.valueOf(dArr[i7]));
            i7++;
            i8++;
        }
        return r7;
    }

    public static int Re(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, M extends Map<? super K, List<V>>> M Rf(@a7.d float[] fArr, @a7.d M destination, @a7.d i5.l<? super Float, ? extends K> keySelector, @a7.d i5.l<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (float f8 : fArr) {
            K kZ = keySelector.z(Float.valueOf(f8));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(Float.valueOf(f8)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean Rg(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr.length == 0;
    }

    public static final char Rh(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return cArr[Se(cArr)];
    }

    @a7.d
    public static final <R> List<R> Ri(@a7.d byte[] bArr, @a7.d i5.p<? super Integer, ? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            arrayList.add(transform.a0(Integer.valueOf(i8), Byte.valueOf(bArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double Rj(float[] fArr, i5.l<? super Float, Double> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Float.valueOf(fArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Float.valueOf(fArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Rk(char[] cArr, Comparator<? super R> comparator, i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Character.valueOf(cArr[0]));
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(cArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final <T> T Rl(@a7.d T[] tArr, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t7 = tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            if (comparator.compare(t7, t8) < 0) {
                t7 = t8;
            }
        }
        return t7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Rm(int[] iArr, i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Integer.valueOf(iArr[0]));
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Integer.valueOf(iArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final char Rn(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c8 = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            if (kotlin.jvm.internal.l0.t(c8, c9) > 0) {
                c8 = c9;
            }
        }
        return c8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final short[] Ro(short[] sArr, i5.l<? super Short, l2> action) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (short s7 : sArr) {
            action.z(Short.valueOf(s7));
        }
        return sArr;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <T> T Rp(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return (T) Sp(tArr, kotlin.random.f.f34998a);
    }

    public static final float Rq(@a7.d float[] fArr, @a7.d i5.q<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iUe = Ue(fArr);
        if (iUe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[iUe];
        for (int i7 = iUe - 1; i7 >= 0; i7--) {
            fFloatValue = operation.v(Integer.valueOf(i7), Float.valueOf(fArr[i7]), Float.valueOf(fFloatValue)).floatValue();
        }
        return fFloatValue;
    }

    @a7.d
    public static byte[] Rr(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int iRe = Re(bArr);
        u0 it = new kotlin.ranges.k(0, iRe).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            bArr2[iRe - iB] = bArr[iB];
        }
        return bArr2;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Rs(short[] sArr, R r7, i5.p<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r7);
        for (short s7 : sArr) {
            r7 = operation.a0(r7, Short.valueOf(s7));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Character Rt(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    public static final void Ru(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length > 1) {
            kotlin.collections.o.h4(bArr);
            qr(bArr);
        }
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Double> Rv(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return iw(dArr, new kotlin.comparisons.b.d(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Rw(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i7 : iArr) {
            dDoubleValue += selector.z(Integer.valueOf(i7)).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final long Rx(long[] jArr, i5.l<? super Long, a2> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jH = a2.h(0L);
        for (long j7 : jArr) {
            jH = a2.h(jH + selector.z(Long.valueOf(j7)).g0());
        }
        return jH;
    }

    @a7.d
    public static final <C extends Collection<? super Boolean>> C Ry(@a7.d boolean[] zArr, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (boolean z7 : zArr) {
            destination.add(Boolean.valueOf(z7));
        }
        return destination;
    }

    @a7.d
    public static final Set<Character> Rz(@a7.d char[] cArr, @a7.d Iterable<Character> other) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Character> setYz = yz(cArr);
        d0.o0(setYz, other);
        return setYz;
    }

    public static boolean S5(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return !(sArr.length == 0);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M S6(@a7.d char[] cArr, @a7.d M destination, @a7.d i5.l<? super Character, ? extends K> keySelector, @a7.d i5.l<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (char c8 : cArr) {
            destination.put(keySelector.z(Character.valueOf(c8)), valueTransform.z(Character.valueOf(c8)));
        }
        return destination;
    }

    @h5.h(name = "averageOfLong")
    public static final double S7(@a7.d Long[] lArr) {
        kotlin.jvm.internal.l0.p(lArr, "<this>");
        double dLongValue = 0.0d;
        int i7 = 0;
        for (Long l7 : lArr) {
            dLongValue += l7.longValue();
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i7);
    }

    public static boolean S8(@a7.d long[] jArr, long j7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return ig(jArr, j7) >= 0;
    }

    @a7.d
    public static final List<Float> S9(@a7.d float[] fArr, int i7) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (i7 >= 0) {
            return Yx(fArr, kotlin.ranges.q.n(fArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <T, R> List<kotlin.u0<T, R>> SA(@a7.d T[] tArr, @a7.d Iterable<? extends R> other) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(kotlin.p1.a(tArr[i7], r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final List<Character> Sa(@a7.d char[] cArr, @a7.d i5.p<? super Integer, ? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            char c8 = cArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Character.valueOf(c8)).booleanValue()) {
                arrayList.add(Character.valueOf(c8));
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Float Sb(float[] fArr, i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (float f8 : fArr) {
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                return Float.valueOf(f8);
            }
        }
        return null;
    }

    @a7.d
    public static final <R> List<R> Sc(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b8 : bArr) {
            d0.o0(arrayList, transform.z(Byte.valueOf(b8)));
        }
        return arrayList;
    }

    public static final <R> R Sd(@a7.d float[] fArr, R r7, @a7.d i5.q<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int length = fArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            r7 = operation.v(Integer.valueOf(i8), r7, Float.valueOf(fArr[i7]));
            i7++;
            i8++;
        }
        return r7;
    }

    public static final int Se(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr.length - 1;
    }

    @a7.d
    public static final <K, M extends Map<? super K, List<Integer>>> M Sf(@a7.d int[] iArr, @a7.d M destination, @a7.d i5.l<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (int i7 : iArr) {
            K kZ = keySelector.z(Integer.valueOf(i7));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(Integer.valueOf(i7));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean Sg(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr.length == 0;
    }

    public static final char Sh(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                char c8 = cArr[length];
                if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                    return c8;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    public static final <R> List<R> Si(@a7.d char[] cArr, @a7.d i5.p<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int length = cArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            arrayList.add(transform.a0(Integer.valueOf(i8), Character.valueOf(cArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double Sj(int[] iArr, i5.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Integer.valueOf(iArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Integer.valueOf(iArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Sk(double[] dArr, Comparator<? super R> comparator, i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Double.valueOf(dArr[0]));
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Double.valueOf(dArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final short Sl(@a7.d short[] sArr, @a7.d Comparator<? super Short> comparator) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s7 = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            if (comparator.compare(Short.valueOf(s7), Short.valueOf(s8)) < 0) {
                s7 = s8;
            }
        }
        return s7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Sm(long[] jArr, i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Long.valueOf(jArr[0]));
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Long.valueOf(jArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final double Sn(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dMin = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            dMin = Math.min(dMin, dArr[it.b()]);
        }
        return dMin;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final boolean[] So(boolean[] zArr, i5.l<? super Boolean, l2> action) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (boolean z7 : zArr) {
            action.z(Boolean.valueOf(z7));
        }
        return zArr;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final <T> T Sp(@a7.d T[] tArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[random.m(tArr.length)];
    }

    public static final int Sq(@a7.d int[] iArr, @a7.d i5.q<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iVe = Ve(iArr);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[iVe];
        for (int i7 = iVe - 1; i7 >= 0; i7--) {
            iIntValue = operation.v(Integer.valueOf(i7), Integer.valueOf(iArr[i7]), Integer.valueOf(iIntValue)).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final char[] Sr(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int iSe = Se(cArr);
        u0 it = new kotlin.ranges.k(0, iSe).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            cArr2[iSe - iB] = cArr[iB];
        }
        return cArr2;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Ss(boolean[] zArr, R r7, i5.p<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r7);
        for (boolean z7 : zArr) {
            r7 = operation.a0(r7, Boolean.valueOf(z7));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Character St(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Character chValueOf = null;
        boolean z7 = false;
        for (char c8 : cArr) {
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                if (z7) {
                    return null;
                }
                chValueOf = Character.valueOf(c8);
                z7 = true;
            }
        }
        if (z7) {
            return chValueOf;
        }
        return null;
    }

    @kotlin.g1(version = "1.4")
    public static final void Su(@a7.d byte[] bArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.collections.o.i4(bArr, i7, i8);
        rr(bArr, i7, i8);
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Float> Sv(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return jw(fArr, new kotlin.comparisons.b.d(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Sw(@a7.d long[] jArr, @a7.d i5.l<? super Long, Double> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (long j7 : jArr) {
            dDoubleValue += selector.z(Long.valueOf(j7)).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final <T> long Sx(T[] tArr, i5.l<? super T, a2> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jH = a2.h(0L);
        for (T t7 : tArr) {
            jH = a2.h(jH + selector.z(t7).g0());
        }
        return jH;
    }

    @a7.d
    public static final double[] Sy(@a7.d Double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i7 = 0; i7 < length; i7++) {
            dArr2[i7] = dArr[i7].doubleValue();
        }
        return dArr2;
    }

    @a7.d
    public static final Set<Double> Sz(@a7.d double[] dArr, @a7.d Iterable<Double> other) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Double> setZz = zz(dArr);
        d0.o0(setZz, other);
        return setZz;
    }

    public static final boolean T5(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (short s7 : sArr) {
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final <K, M extends Map<? super K, ? super Double>> M T6(@a7.d double[] dArr, @a7.d M destination, @a7.d i5.l<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (double d8 : dArr) {
            destination.put(keySelector.z(Double.valueOf(d8)), Double.valueOf(d8));
        }
        return destination;
    }

    @h5.h(name = "averageOfShort")
    public static final double T7(@a7.d Short[] shArr) {
        kotlin.jvm.internal.l0.p(shArr, "<this>");
        double dShortValue = 0.0d;
        int i7 = 0;
        for (Short sh : shArr) {
            dShortValue += (double) sh.shortValue();
            i7++;
        }
        if (i7 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i7);
    }

    public static final <T> boolean T8(@a7.d T[] tArr, T t7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return jg(tArr, t7) >= 0;
    }

    @a7.d
    public static final List<Integer> T9(@a7.d int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (i7 >= 0) {
            return Zx(iArr, kotlin.ranges.q.n(iArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T, R, V> List<V> TA(@a7.d T[] tArr, @a7.d Iterable<? extends R> other, @a7.d i5.p<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(transform.a0(tArr[i7], r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final List<Double> Ta(@a7.d double[] dArr, @a7.d i5.p<? super Integer, ? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            double d8 = dArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Double.valueOf(d8)).booleanValue()) {
                arrayList.add(Double.valueOf(d8));
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Integer Tb(int[] iArr, i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int i7 : iArr) {
            if (predicate.z(Integer.valueOf(i7)).booleanValue()) {
                return Integer.valueOf(i7);
            }
        }
        return null;
    }

    @a7.d
    public static final <R> List<R> Tc(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c8 : cArr) {
            d0.o0(arrayList, transform.z(Character.valueOf(c8)));
        }
        return arrayList;
    }

    public static final <R> R Td(@a7.d int[] iArr, R r7, @a7.d i5.q<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            r7 = operation.v(Integer.valueOf(i8), r7, Integer.valueOf(iArr[i7]));
            i7++;
            i8++;
        }
        return r7;
    }

    public static final int Te(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, M extends Map<? super K, List<V>>> M Tf(@a7.d int[] iArr, @a7.d M destination, @a7.d i5.l<? super Integer, ? extends K> keySelector, @a7.d i5.l<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (int i7 : iArr) {
            K kZ = keySelector.z(Integer.valueOf(i7));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(Integer.valueOf(i7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final <T> boolean Tg(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr.length == 0;
    }

    public static final double Th(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return dArr[Te(dArr)];
    }

    @a7.d
    public static final <R> List<R> Ti(@a7.d double[] dArr, @a7.d i5.p<? super Integer, ? super Double, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int length = dArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            arrayList.add(transform.a0(Integer.valueOf(i8), Double.valueOf(dArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double Tj(long[] jArr, i5.l<? super Long, Double> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Long.valueOf(jArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Long.valueOf(jArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Tk(float[] fArr, Comparator<? super R> comparator, i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Float.valueOf(fArr[0]));
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Float.valueOf(fArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxWithOrThrow")
    public static final boolean Tl(@a7.d boolean[] zArr, @a7.d Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z7 = zArr[0];
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            boolean z8 = zArr[it.b()];
            if (comparator.compare(Boolean.valueOf(z7), Boolean.valueOf(z8)) < 0) {
                z7 = z8;
            }
        }
        return z7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R extends Comparable<? super R>> R Tm(T[] tArr, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rZ = selector.z(tArr[0]);
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(tArr[it.b()]);
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final double Tn(@a7.d Double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = dArr[0].doubleValue();
        u0 it = new kotlin.ranges.k(1, Xe(dArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, dArr[it.b()].doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final byte[] To(byte[] bArr, i5.p<? super Integer, ? super Byte, l2> action) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Byte.valueOf(bArr[i7]));
            i7++;
            i8++;
        }
        return bArr;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final Short Tp(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return Up(sArr, kotlin.random.f.f34998a);
    }

    public static final long Tq(@a7.d long[] jArr, @a7.d i5.q<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iWe = We(jArr);
        if (iWe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[iWe];
        for (int i7 = iWe - 1; i7 >= 0; i7--) {
            jLongValue = operation.v(Integer.valueOf(i7), Long.valueOf(jArr[i7]), Long.valueOf(jLongValue)).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final double[] Tr(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int iTe = Te(dArr);
        u0 it = new kotlin.ranges.k(0, iTe).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            dArr2[iTe - iB] = dArr[iB];
        }
        return dArr2;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Ts(byte[] bArr, R r7, i5.q<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r7);
        int length = bArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Byte.valueOf(bArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Double Tt(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    public static final void Tu(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length > 1) {
            kotlin.collections.o.j4(cArr);
            sr(cArr);
        }
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Integer> Tv(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return kw(iArr, new kotlin.comparisons.b.d(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final <T> double Tw(@a7.d T[] tArr, @a7.d i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (T t7 : tArr) {
            dDoubleValue += selector.z(t7).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final long Tx(short[] sArr, i5.l<? super Short, a2> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jH = a2.h(0L);
        for (short s7 : sArr) {
            jH = a2.h(jH + selector.z(Short.valueOf(s7)).g0());
        }
        return jH;
    }

    @a7.d
    public static final float[] Ty(@a7.d Float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i7 = 0; i7 < length; i7++) {
            fArr2[i7] = fArr[i7].floatValue();
        }
        return fArr2;
    }

    @a7.d
    public static final Set<Float> Tz(@a7.d float[] fArr, @a7.d Iterable<Float> other) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Float> setAz = Az(fArr);
        d0.o0(setAz, other);
        return setAz;
    }

    public static final boolean U5(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return !(zArr.length == 0);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M U6(@a7.d double[] dArr, @a7.d M destination, @a7.d i5.l<? super Double, ? extends K> keySelector, @a7.d i5.l<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (double d8 : dArr) {
            destination.put(keySelector.z(Double.valueOf(d8)), valueTransform.z(Double.valueOf(d8)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final byte U7(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr[0];
    }

    public static boolean U8(@a7.d short[] sArr, short s7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return kg(sArr, s7) >= 0;
    }

    @a7.d
    public static final List<Long> U9(@a7.d long[] jArr, int i7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (i7 >= 0) {
            return ay(jArr, kotlin.ranges.q.n(jArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <T, R> List<kotlin.u0<T, R>> UA(@a7.d T[] tArr, @a7.d R[] other) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(kotlin.p1.a(tArr[i7], other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Float> Ua(@a7.d float[] fArr, @a7.d i5.p<? super Integer, ? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            float f8 = fArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Float.valueOf(f8)).booleanValue()) {
                arrayList.add(Float.valueOf(f8));
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Long Ub(long[] jArr, i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (long j7 : jArr) {
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                return Long.valueOf(j7);
            }
        }
        return null;
    }

    @a7.d
    public static final <R> List<R> Uc(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d8 : dArr) {
            d0.o0(arrayList, transform.z(Double.valueOf(d8)));
        }
        return arrayList;
    }

    public static final <R> R Ud(@a7.d long[] jArr, R r7, @a7.d i5.q<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int length = jArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            r7 = operation.v(Integer.valueOf(i8), r7, Long.valueOf(jArr[i7]));
            i7++;
            i8++;
        }
        return r7;
    }

    public static final int Ue(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr.length - 1;
    }

    @a7.d
    public static final <K, M extends Map<? super K, List<Long>>> M Uf(@a7.d long[] jArr, @a7.d M destination, @a7.d i5.l<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (long j7 : jArr) {
            K kZ = keySelector.z(Long.valueOf(j7));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(Long.valueOf(j7));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean Ug(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr.length == 0;
    }

    public static final double Uh(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                double d8 = dArr[length];
                if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                    return d8;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    public static final <R> List<R> Ui(@a7.d float[] fArr, @a7.d i5.p<? super Integer, ? super Float, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int length = fArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            arrayList.add(transform.a0(Integer.valueOf(i8), Float.valueOf(fArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> double Uj(T[] tArr, i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(tArr[0]).doubleValue();
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(tArr[it.b()]).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Uk(int[] iArr, Comparator<? super R> comparator, i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Integer.valueOf(iArr[0]));
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Integer.valueOf(iArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Boolean Ul(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z7 = zArr[0];
        int iZe = Ze(zArr);
        if (iZe == 0) {
            return Boolean.valueOf(z7);
        }
        R rZ = selector.z(Boolean.valueOf(z7));
        u0 it = new kotlin.ranges.k(1, iZe).iterator();
        while (it.hasNext()) {
            boolean z8 = zArr[it.b()];
            R rZ2 = selector.z(Boolean.valueOf(z8));
            if (rZ.compareTo(rZ2) > 0) {
                z7 = z8;
                rZ = rZ2;
            }
        }
        return Boolean.valueOf(z7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Um(short[] sArr, i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Short.valueOf(sArr[0]));
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Short.valueOf(sArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final float Un(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fMin = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            fMin = Math.min(fMin, fArr[it.b()]);
        }
        return fMin;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final char[] Uo(char[] cArr, i5.p<? super Integer, ? super Character, l2> action) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = cArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Character.valueOf(cArr[i7]));
            i7++;
            i8++;
        }
        return cArr;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Short Up(@a7.d short[] sArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[random.m(sArr.length)]);
    }

    public static final <S, T extends S> S Uq(@a7.d T[] tArr, @a7.d i5.q<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iXe = Xe(tArr);
        if (iXe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sV = (S) tArr[iXe];
        for (int i7 = iXe - 1; i7 >= 0; i7--) {
            sV = operation.v(Integer.valueOf(i7), (Object) tArr[i7], sV);
        }
        return sV;
    }

    @a7.d
    public static final float[] Ur(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int iUe = Ue(fArr);
        u0 it = new kotlin.ranges.k(0, iUe).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            fArr2[iUe - iB] = fArr[iB];
        }
        return fArr2;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Us(char[] cArr, R r7, i5.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r7);
        int length = cArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Character.valueOf(cArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Double Ut(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Double dValueOf = null;
        boolean z7 = false;
        for (double d8 : dArr) {
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                if (z7) {
                    return null;
                }
                dValueOf = Double.valueOf(d8);
                z7 = true;
            }
        }
        if (z7) {
            return dValueOf;
        }
        return null;
    }

    @kotlin.g1(version = "1.4")
    public static final void Uu(@a7.d char[] cArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.collections.o.k4(cArr, i7, i8);
        tr(cArr, i7, i8);
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Long> Uv(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return lw(jArr, new kotlin.comparisons.b.d(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Uw(@a7.d short[] sArr, @a7.d i5.l<? super Short, Double> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (short s7 : sArr) {
            dDoubleValue += selector.z(Short.valueOf(s7)).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.5")
    @h5.h(name = "sumOfULong")
    @kotlin.t0
    @q2(markerClass = {kotlin.t.class})
    @kotlin.internal.f
    private static final long Ux(boolean[] zArr, i5.l<? super Boolean, a2> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jH = a2.h(0L);
        for (boolean z7 : zArr) {
            jH = a2.h(jH + selector.z(Boolean.valueOf(z7)).g0());
        }
        return jH;
    }

    @a7.d
    public static final HashSet<Byte> Uy(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return (HashSet) Jy(bArr, new HashSet(b1.j(bArr.length)));
    }

    @a7.d
    public static final Set<Integer> Uz(@a7.d int[] iArr, @a7.d Iterable<Integer> other) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Integer> setBz = Bz(iArr);
        d0.o0(setBz, other);
        return setBz;
    }

    public static final boolean V5(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (boolean z7 : zArr) {
            if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @a7.d
    public static final <K, M extends Map<? super K, ? super Float>> M V6(@a7.d float[] fArr, @a7.d M destination, @a7.d i5.l<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (float f8 : fArr) {
            destination.put(keySelector.z(Float.valueOf(f8)), Float.valueOf(f8));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final char V7(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr[0];
    }

    public static final boolean V8(@a7.d boolean[] zArr, boolean z7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return lg(zArr, z7) >= 0;
    }

    @a7.d
    public static final <T> List<T> V9(@a7.d T[] tArr, int i7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (i7 >= 0) {
            return cy(tArr, kotlin.ranges.q.n(tArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <T, R, V> List<V> VA(@a7.d T[] tArr, @a7.d R[] other, @a7.d i5.p<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(tArr[i7], other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Integer> Va(@a7.d int[] iArr, @a7.d i5.p<? super Integer, ? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int i9 = iArr[i7];
            int i10 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Integer.valueOf(i9)).booleanValue()) {
                arrayList.add(Integer.valueOf(i9));
            }
            i7++;
            i8 = i10;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final <T> T Vb(T[] tArr, i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : tArr) {
            if (predicate.z(t7).booleanValue()) {
                return t7;
            }
        }
        return null;
    }

    @a7.d
    public static final <R> List<R> Vc(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f8 : fArr) {
            d0.o0(arrayList, transform.z(Float.valueOf(f8)));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R Vd(@a7.d T[] tArr, R r7, @a7.d i5.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            r7 = operation.v(Integer.valueOf(i8), r7, tArr[i7]);
            i7++;
            i8++;
        }
        return r7;
    }

    public static int Ve(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, M extends Map<? super K, List<V>>> M Vf(@a7.d long[] jArr, @a7.d M destination, @a7.d i5.l<? super Long, ? extends K> keySelector, @a7.d i5.l<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (long j7 : jArr) {
            K kZ = keySelector.z(Long.valueOf(j7));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(Long.valueOf(j7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean Vg(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr.length == 0;
    }

    public static final float Vh(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return fArr[Ue(fArr)];
    }

    @a7.d
    public static final <R> List<R> Vi(@a7.d int[] iArr, @a7.d i5.p<? super Integer, ? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            arrayList.add(transform.a0(Integer.valueOf(i8), Integer.valueOf(iArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double Vj(short[] sArr, i5.l<? super Short, Double> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Short.valueOf(sArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Short.valueOf(sArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Vk(long[] jArr, Comparator<? super R> comparator, i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Long.valueOf(jArr[0]));
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Long.valueOf(jArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Byte Vl(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b8 = bArr[0];
        int iRe = Re(bArr);
        if (iRe == 0) {
            return Byte.valueOf(b8);
        }
        R rZ = selector.z(Byte.valueOf(b8));
        u0 it = new kotlin.ranges.k(1, iRe).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            R rZ2 = selector.z(Byte.valueOf(b9));
            if (rZ.compareTo(rZ2) > 0) {
                b8 = b9;
                rZ = rZ2;
            }
        }
        return Byte.valueOf(b8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R Vm(boolean[] zArr, i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Boolean.valueOf(zArr[0]));
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Boolean.valueOf(zArr[it.b()]));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final float Vn(@a7.d Float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = fArr[0].floatValue();
        u0 it = new kotlin.ranges.k(1, Xe(fArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, fArr[it.b()].floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final double[] Vo(double[] dArr, i5.p<? super Integer, ? super Double, l2> action) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = dArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Double.valueOf(dArr[i7]));
            i7++;
            i8++;
        }
        return dArr;
    }

    public static final byte Vp(@a7.d byte[] bArr, @a7.d i5.p<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (bArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            bByteValue = operation.a0(Byte.valueOf(bByteValue), Byte.valueOf(bArr[it.b()])).byteValue();
        }
        return bByteValue;
    }

    public static final short Vq(@a7.d short[] sArr, @a7.d i5.q<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iYe = Ye(sArr);
        if (iYe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[iYe];
        for (int i7 = iYe - 1; i7 >= 0; i7--) {
            sShortValue = operation.v(Integer.valueOf(i7), Short.valueOf(sArr[i7]), Short.valueOf(sShortValue)).shortValue();
        }
        return sShortValue;
    }

    @a7.d
    public static int[] Vr(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int iVe = Ve(iArr);
        u0 it = new kotlin.ranges.k(0, iVe).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            iArr2[iVe - iB] = iArr[iB];
        }
        return iArr2;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Vs(double[] dArr, R r7, i5.q<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r7);
        int length = dArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Double.valueOf(dArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Float Vt(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    public static final void Vu(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length > 1) {
            kotlin.collections.o.l4(dArr);
            ur(dArr);
        }
    }

    @a7.d
    public static final <T, R extends Comparable<? super R>> List<T> Vv(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return mw(tArr, new kotlin.comparisons.b.d(selector));
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.b1(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double Vw(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (boolean z7 : zArr) {
            dDoubleValue += selector.z(Boolean.valueOf(z7)).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final List<Byte> Vx(@a7.d byte[] bArr, int i7) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        if (i7 >= bArr.length) {
            return ez(bArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        for (byte b8 : bArr) {
            arrayList.add(Byte.valueOf(b8));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final HashSet<Character> Vy(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return (HashSet) Ky(cArr, new HashSet(b1.j(kotlin.ranges.q.u(cArr.length, 128))));
    }

    @a7.d
    public static final Set<Long> Vz(@a7.d long[] jArr, @a7.d Iterable<Long> other) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Long> setCz = Cz(jArr);
        d0.o0(setCz, other);
        return setCz;
    }

    @a7.d
    public static final Iterable<Byte> W5(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr.length == 0 ? kotlin.collections.y.F() : new b(bArr);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M W6(@a7.d float[] fArr, @a7.d M destination, @a7.d i5.l<? super Float, ? extends K> keySelector, @a7.d i5.l<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (float f8 : fArr) {
            destination.put(keySelector.z(Float.valueOf(f8)), valueTransform.z(Float.valueOf(f8)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final double W7(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr[0];
    }

    @kotlin.internal.f
    private static final int W8(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr.length;
    }

    @a7.d
    public static final List<Short> W9(@a7.d short[] sArr, int i7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (i7 >= 0) {
            return dy(sArr, kotlin.ranges.q.n(sArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R> List<kotlin.u0<Short, R>> WA(@a7.d short[] sArr, @a7.d Iterable<? extends R> other) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(kotlin.p1.a(Short.valueOf(sArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final List<Long> Wa(@a7.d long[] jArr, @a7.d i5.p<? super Integer, ? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            long j7 = jArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Long.valueOf(j7)).booleanValue()) {
                arrayList.add(Long.valueOf(j7));
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Short Wb(short[] sArr, i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (short s7 : sArr) {
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                return Short.valueOf(s7);
            }
        }
        return null;
    }

    @a7.d
    public static final <R> List<R> Wc(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i7 : iArr) {
            d0.o0(arrayList, transform.z(Integer.valueOf(i7)));
        }
        return arrayList;
    }

    public static final <R> R Wd(@a7.d short[] sArr, R r7, @a7.d i5.q<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int length = sArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            r7 = operation.v(Integer.valueOf(i8), r7, Short.valueOf(sArr[i7]));
            i7++;
            i8++;
        }
        return r7;
    }

    public static int We(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr.length - 1;
    }

    @a7.d
    public static final <T, K, M extends Map<? super K, List<T>>> M Wf(@a7.d T[] tArr, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (T t7 : tArr) {
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

    @kotlin.internal.f
    private static final boolean Wg(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return !(bArr.length == 0);
    }

    public static final float Wh(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                float f8 = fArr[length];
                if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                    return f8;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    public static final <R> List<R> Wi(@a7.d long[] jArr, @a7.d i5.p<? super Integer, ? super Long, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int length = jArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            arrayList.add(transform.a0(Integer.valueOf(i8), Long.valueOf(jArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double Wj(boolean[] zArr, i5.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Boolean.valueOf(zArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Boolean.valueOf(zArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R> R Wk(T[] tArr, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(tArr[0]);
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(tArr[it.b()]);
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Character Wl(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c8 = cArr[0];
        int iSe = Se(cArr);
        if (iSe == 0) {
            return Character.valueOf(c8);
        }
        R rZ = selector.z(Character.valueOf(c8));
        u0 it = new kotlin.ranges.k(1, iSe).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            R rZ2 = selector.z(Character.valueOf(c9));
            if (rZ.compareTo(rZ2) > 0) {
                c8 = c9;
                rZ = rZ2;
            }
        }
        return Character.valueOf(c8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double Wm(byte[] bArr, i5.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Byte.valueOf(bArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Byte.valueOf(bArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final int Wn(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i7 = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            if (i7 > i8) {
                i7 = i8;
            }
        }
        return i7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final float[] Wo(float[] fArr, i5.p<? super Integer, ? super Float, l2> action) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = fArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Float.valueOf(fArr[i7]));
            i7++;
            i8++;
        }
        return fArr;
    }

    public static final char Wp(@a7.d char[] cArr, @a7.d i5.p<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (cArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            cCharValue = operation.a0(Character.valueOf(cCharValue), Character.valueOf(cArr[it.b()])).charValue();
        }
        return cCharValue;
    }

    public static final boolean Wq(@a7.d boolean[] zArr, @a7.d i5.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iZe = Ze(zArr);
        if (iZe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[iZe];
        for (int i7 = iZe - 1; i7 >= 0; i7--) {
            zBooleanValue = operation.v(Integer.valueOf(i7), Boolean.valueOf(zArr[i7]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return zBooleanValue;
    }

    @a7.d
    public static long[] Wr(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int iWe = We(jArr);
        u0 it = new kotlin.ranges.k(0, iWe).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            jArr2[iWe - iB] = jArr[iB];
        }
        return jArr2;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Ws(float[] fArr, R r7, i5.q<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r7);
        int length = fArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Float.valueOf(fArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Float Wt(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Float fValueOf = null;
        boolean z7 = false;
        for (float f8 : fArr) {
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                if (z7) {
                    return null;
                }
                fValueOf = Float.valueOf(f8);
                z7 = true;
            }
        }
        if (z7) {
            return fValueOf;
        }
        return null;
    }

    @kotlin.g1(version = "1.4")
    public static final void Wu(@a7.d double[] dArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.collections.o.m4(dArr, i7, i8);
        vr(dArr, i7, i8);
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Short> Wv(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return nw(sArr, new kotlin.comparisons.b.d(selector));
    }

    @h5.h(name = "sumOfByte")
    public static final int Ww(@a7.d Byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        int iByteValue = 0;
        for (Byte b8 : bArr) {
            iByteValue += b8.byteValue();
        }
        return iByteValue;
    }

    @a7.d
    public static final List<Character> Wx(@a7.d char[] cArr, int i7) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        if (i7 >= cArr.length) {
            return fz(cArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Character.valueOf(cArr[0]));
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        for (char c8 : cArr) {
            arrayList.add(Character.valueOf(c8));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final HashSet<Double> Wy(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return (HashSet) Ly(dArr, new HashSet(b1.j(dArr.length)));
    }

    @a7.d
    public static final <T> Set<T> Wz(@a7.d T[] tArr, @a7.d Iterable<? extends T> other) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<T> setDz = Dz(tArr);
        d0.o0(setDz, other);
        return setDz;
    }

    @a7.d
    public static final Iterable<Character> X5(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr.length == 0 ? kotlin.collections.y.F() : new i(cArr);
    }

    @a7.d
    public static final <K, M extends Map<? super K, ? super Integer>> M X6(@a7.d int[] iArr, @a7.d M destination, @a7.d i5.l<? super Integer, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (int i7 : iArr) {
            destination.put(keySelector.z(Integer.valueOf(i7)), Integer.valueOf(i7));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final float X7(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr[0];
    }

    public static final int X8(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        for (byte b8 : bArr) {
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @a7.d
    public static final List<Boolean> X9(@a7.d boolean[] zArr, int i7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (i7 >= 0) {
            return ey(zArr, kotlin.ranges.q.n(zArr.length - i7, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    @a7.d
    public static final <R, V> List<V> XA(@a7.d short[] sArr, @a7.d Iterable<? extends R> other, @a7.d i5.p<? super Short, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(transform.a0(Short.valueOf(sArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final <T> List<T> Xa(@a7.d T[] tArr, @a7.d i5.p<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            T t7 = tArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), t7).booleanValue()) {
                arrayList.add(t7);
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Boolean Xb(boolean[] zArr, i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                boolean z7 = zArr[length];
                if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                    return Boolean.valueOf(z7);
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return null;
    }

    @a7.d
    public static final <R> List<R> Xc(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j7 : jArr) {
            d0.o0(arrayList, transform.z(Long.valueOf(j7)));
        }
        return arrayList;
    }

    public static final <R> R Xd(@a7.d boolean[] zArr, R r7, @a7.d i5.q<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int length = zArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            r7 = operation.v(Integer.valueOf(i8), r7, Boolean.valueOf(zArr[i7]));
            i7++;
            i8++;
        }
        return r7;
    }

    public static <T> int Xe(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T, K, V, M extends Map<? super K, List<V>>> M Xf(@a7.d T[] tArr, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (T t7 : tArr) {
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

    @kotlin.internal.f
    private static final boolean Xg(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return !(cArr.length == 0);
    }

    public static int Xh(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[Ve(iArr)];
    }

    @a7.d
    public static final <T, R> List<R> Xi(@a7.d T[] tArr, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            arrayList.add(transform.a0(Integer.valueOf(i8), tArr[i7]));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float Xj(byte[] bArr, i5.l<? super Byte, Float> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Byte.valueOf(bArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Byte.valueOf(bArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Xk(short[] sArr, Comparator<? super R> comparator, i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Short.valueOf(sArr[0]));
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Short.valueOf(sArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Double Xl(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d8 = dArr[0];
        int iTe = Te(dArr);
        if (iTe == 0) {
            return Double.valueOf(d8);
        }
        R rZ = selector.z(Double.valueOf(d8));
        u0 it = new kotlin.ranges.k(1, iTe).iterator();
        while (it.hasNext()) {
            double d9 = dArr[it.b()];
            R rZ2 = selector.z(Double.valueOf(d9));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
                d8 = d9;
            }
        }
        return Double.valueOf(d8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double Xm(char[] cArr, i5.l<? super Character, Double> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Character.valueOf(cArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Character.valueOf(cArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final long Xn(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j7 = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            if (j7 > j8) {
                j7 = j8;
            }
        }
        return j7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final int[] Xo(int[] iArr, i5.p<? super Integer, ? super Integer, l2> action) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Integer.valueOf(iArr[i7]));
            i7++;
            i8++;
        }
        return iArr;
    }

    public static final double Xp(@a7.d double[] dArr, @a7.d i5.p<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (dArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = operation.a0(Double.valueOf(dDoubleValue), Double.valueOf(dArr[it.b()])).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Boolean Xq(@a7.d boolean[] zArr, @a7.d i5.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iZe = Ze(zArr);
        if (iZe < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[iZe];
        for (int i7 = iZe - 1; i7 >= 0; i7--) {
            zBooleanValue = operation.v(Integer.valueOf(i7), Boolean.valueOf(zArr[i7]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    @a7.d
    public static final <T> T[] Xr(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) kotlin.collections.m.a(tArr, tArr.length);
        int iXe = Xe(tArr);
        u0 it = new kotlin.ranges.k(0, iXe).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            tArr2[iXe - iB] = tArr[iB];
        }
        return tArr2;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Xs(int[] iArr, R r7, i5.q<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r7);
        int length = iArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Integer.valueOf(iArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Integer Xt(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    public static final void Xu(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length > 1) {
            kotlin.collections.o.n4(fArr);
            wr(fArr);
        }
    }

    @a7.d
    public static final <R extends Comparable<? super R>> List<Boolean> Xv(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        return ow(zArr, new kotlin.comparisons.b.d(selector));
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @kotlin.t0
    @kotlin.internal.f
    private static final double Xw(byte[] bArr, i5.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (byte b8 : bArr) {
            dDoubleValue += selector.z(Byte.valueOf(b8)).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final List<Double> Xx(@a7.d double[] dArr, int i7) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        if (i7 >= dArr.length) {
            return gz(dArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Double.valueOf(dArr[0]));
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        for (double d8 : dArr) {
            arrayList.add(Double.valueOf(d8));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final HashSet<Float> Xy(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return (HashSet) My(fArr, new HashSet(b1.j(fArr.length)));
    }

    @a7.d
    public static final Set<Short> Xz(@a7.d short[] sArr, @a7.d Iterable<Short> other) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Short> setEz = Ez(sArr);
        d0.o0(setEz, other);
        return setEz;
    }

    @a7.d
    public static final Iterable<Double> Y5(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr.length == 0 ? kotlin.collections.y.F() : new g(dArr);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M Y6(@a7.d int[] iArr, @a7.d M destination, @a7.d i5.l<? super Integer, ? extends K> keySelector, @a7.d i5.l<? super Integer, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (int i7 : iArr) {
            destination.put(keySelector.z(Integer.valueOf(i7)), valueTransform.z(Integer.valueOf(i7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final int Y7(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr[0];
    }

    @kotlin.internal.f
    private static final int Y8(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr.length;
    }

    @a7.d
    public static final List<Byte> Y9(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iRe = Re(bArr); -1 < iRe; iRe--) {
            if (!predicate.z(Byte.valueOf(bArr[iRe])).booleanValue()) {
                return Vx(bArr, iRe + 1);
            }
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final <R> List<kotlin.u0<Short, R>> YA(@a7.d short[] sArr, @a7.d R[] other) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            short s7 = sArr[i7];
            arrayList.add(kotlin.p1.a(Short.valueOf(s7), other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Short> Ya(@a7.d short[] sArr, @a7.d i5.p<? super Integer, ? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            short s7 = sArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Short.valueOf(s7)).booleanValue()) {
                arrayList.add(Short.valueOf(s7));
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Byte Yb(byte[] bArr, i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                byte b8 = bArr[length];
                if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                    return Byte.valueOf(b8);
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return null;
    }

    @a7.d
    public static final <T, R> List<R> Yc(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t7 : tArr) {
            d0.o0(arrayList, transform.z(t7));
        }
        return arrayList;
    }

    public static final <R> R Yd(@a7.d byte[] bArr, R r7, @a7.d i5.p<? super Byte, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iRe = Re(bArr); iRe >= 0; iRe--) {
            r7 = operation.a0(Byte.valueOf(bArr[iRe]), r7);
        }
        return r7;
    }

    public static int Ye(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr.length - 1;
    }

    @a7.d
    public static final <K, M extends Map<? super K, List<Short>>> M Yf(@a7.d short[] sArr, @a7.d M destination, @a7.d i5.l<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (short s7 : sArr) {
            K kZ = keySelector.z(Short.valueOf(s7));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(Short.valueOf(s7));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean Yg(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return !(dArr.length == 0);
    }

    public static final int Yh(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                int i8 = iArr[length];
                if (predicate.z(Integer.valueOf(i8)).booleanValue()) {
                    return i8;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    public static final <R> List<R> Yi(@a7.d short[] sArr, @a7.d i5.p<? super Integer, ? super Short, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int length = sArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            arrayList.add(transform.a0(Integer.valueOf(i8), Short.valueOf(sArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float Yj(char[] cArr, i5.l<? super Character, Float> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Character.valueOf(cArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Character.valueOf(cArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Yk(boolean[] zArr, Comparator<? super R> comparator, i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Boolean.valueOf(zArr[0]));
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Boolean.valueOf(zArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Float Yl(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f8 = fArr[0];
        int iUe = Ue(fArr);
        if (iUe == 0) {
            return Float.valueOf(f8);
        }
        R rZ = selector.z(Float.valueOf(f8));
        u0 it = new kotlin.ranges.k(1, iUe).iterator();
        while (it.hasNext()) {
            float f9 = fArr[it.b()];
            R rZ2 = selector.z(Float.valueOf(f9));
            if (rZ.compareTo(rZ2) > 0) {
                f8 = f9;
                rZ = rZ2;
            }
        }
        return Float.valueOf(f8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double Ym(double[] dArr, i5.l<? super Double, Double> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Double.valueOf(dArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Double.valueOf(dArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @a7.d
    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final <T extends Comparable<? super T>> T Yn(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t7 = tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            if (t7.compareTo(t8) > 0) {
                t7 = t8;
            }
        }
        return t7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final long[] Yo(long[] jArr, i5.p<? super Integer, ? super Long, l2> action) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = jArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Long.valueOf(jArr[i7]));
            i7++;
            i8++;
        }
        return jArr;
    }

    public static final float Yp(@a7.d float[] fArr, @a7.d i5.p<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (fArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = operation.a0(Float.valueOf(fFloatValue), Float.valueOf(fArr[it.b()])).floatValue();
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Byte Yq(@a7.d byte[] bArr, @a7.d i5.q<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iRe = Re(bArr);
        if (iRe < 0) {
            return null;
        }
        byte bByteValue = bArr[iRe];
        for (int i7 = iRe - 1; i7 >= 0; i7--) {
            bByteValue = operation.v(Integer.valueOf(i7), Byte.valueOf(bArr[i7]), Byte.valueOf(bByteValue)).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @a7.d
    public static short[] Yr(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int iYe = Ye(sArr);
        u0 it = new kotlin.ranges.k(0, iYe).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            sArr2[iYe - iB] = sArr[iB];
        }
        return sArr2;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> Ys(long[] jArr, R r7, i5.q<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r7);
        int length = jArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Long.valueOf(jArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Integer Yt(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Integer numValueOf = null;
        boolean z7 = false;
        for (int i7 : iArr) {
            if (predicate.z(Integer.valueOf(i7)).booleanValue()) {
                if (z7) {
                    return null;
                }
                numValueOf = Integer.valueOf(i7);
                z7 = true;
            }
        }
        if (z7) {
            return numValueOf;
        }
        return null;
    }

    @kotlin.g1(version = "1.4")
    public static final void Yu(@a7.d float[] fArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.collections.o.o4(fArr, i7, i8);
        xr(fArr, i7, i8);
    }

    @a7.d
    public static final List<Byte> Yv(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.l0.o(bArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.h4(bArrCopyOf);
        return Ir(bArrCopyOf);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @kotlin.t0
    @kotlin.internal.f
    private static final double Yw(char[] cArr, i5.l<? super Character, Double> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (char c8 : cArr) {
            dDoubleValue += selector.z(Character.valueOf(c8)).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final List<Float> Yx(@a7.d float[] fArr, int i7) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        if (i7 >= fArr.length) {
            return hz(fArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Float.valueOf(fArr[0]));
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        for (float f8 : fArr) {
            arrayList.add(Float.valueOf(f8));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final HashSet<Integer> Yy(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return (HashSet) Ny(iArr, new HashSet(b1.j(iArr.length)));
    }

    @a7.d
    public static final Set<Boolean> Yz(@a7.d boolean[] zArr, @a7.d Iterable<Boolean> other) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Boolean> setFz = Fz(zArr);
        d0.o0(setFz, other);
        return setFz;
    }

    @a7.d
    public static final Iterable<Float> Z5(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr.length == 0 ? kotlin.collections.y.F() : new f(fArr);
    }

    @a7.d
    public static final <K, M extends Map<? super K, ? super Long>> M Z6(@a7.d long[] jArr, @a7.d M destination, @a7.d i5.l<? super Long, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (long j7 : jArr) {
            destination.put(keySelector.z(Long.valueOf(j7)), Long.valueOf(j7));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final long Z7(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr[0];
    }

    public static final int Z8(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        for (char c8 : cArr) {
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @a7.d
    public static final List<Character> Z9(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iSe = Se(cArr); -1 < iSe; iSe--) {
            if (!predicate.z(Character.valueOf(cArr[iSe])).booleanValue()) {
                return Wx(cArr, iSe + 1);
            }
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final <R, V> List<V> ZA(@a7.d short[] sArr, @a7.d R[] other, @a7.d i5.p<? super Short, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Short.valueOf(sArr[i7]), other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Boolean> Za(@a7.d boolean[] zArr, @a7.d i5.p<? super Integer, ? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            boolean z7 = zArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Boolean.valueOf(z7)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z7));
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Character Zb(char[] cArr, i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                char c8 = cArr[length];
                if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                    return Character.valueOf(c8);
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return null;
    }

    @a7.d
    public static final <R> List<R> Zc(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s7 : sArr) {
            d0.o0(arrayList, transform.z(Short.valueOf(s7)));
        }
        return arrayList;
    }

    public static final <R> R Zd(@a7.d char[] cArr, R r7, @a7.d i5.p<? super Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iSe = Se(cArr); iSe >= 0; iSe--) {
            r7 = operation.a0(Character.valueOf(cArr[iSe]), r7);
        }
        return r7;
    }

    public static final int Ze(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, M extends Map<? super K, List<V>>> M Zf(@a7.d short[] sArr, @a7.d M destination, @a7.d i5.l<? super Short, ? extends K> keySelector, @a7.d i5.l<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (short s7 : sArr) {
            K kZ = keySelector.z(Short.valueOf(s7));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(Short.valueOf(s7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean Zg(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return !(fArr.length == 0);
    }

    public static long Zh(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return jArr[We(jArr)];
    }

    @a7.d
    public static final <R> List<R> Zi(@a7.d boolean[] zArr, @a7.d i5.p<? super Integer, ? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int length = zArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            arrayList.add(transform.a0(Integer.valueOf(i8), Boolean.valueOf(zArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float Zj(double[] dArr, i5.l<? super Double, Float> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Double.valueOf(dArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Double.valueOf(dArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R Zk(byte[] bArr, Comparator<? super R> comparator, i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Byte.valueOf(bArr[0]));
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Byte.valueOf(bArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Integer Zl(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i7 = iArr[0];
        int iVe = Ve(iArr);
        if (iVe == 0) {
            return Integer.valueOf(i7);
        }
        R rZ = selector.z(Integer.valueOf(i7));
        u0 it = new kotlin.ranges.k(1, iVe).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            R rZ2 = selector.z(Integer.valueOf(i8));
            if (rZ.compareTo(rZ2) > 0) {
                i7 = i8;
                rZ = rZ2;
            }
        }
        return Integer.valueOf(i7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double Zm(float[] fArr, i5.l<? super Float, Double> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Float.valueOf(fArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Float.valueOf(fArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minOrThrow")
    public static final short Zn(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s7 = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            if (s7 > s8) {
                s7 = s8;
            }
        }
        return s7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <T> T[] Zo(T[] tArr, i5.p<? super Integer, ? super T, l2> action) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), tArr[i7]);
            i7++;
            i8++;
        }
        return tArr;
    }

    public static final int Zp(@a7.d int[] iArr, @a7.d i5.p<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (iArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            iIntValue = operation.a0(Integer.valueOf(iIntValue), Integer.valueOf(iArr[it.b()])).intValue();
        }
        return iIntValue;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Character Zq(@a7.d char[] cArr, @a7.d i5.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iSe = Se(cArr);
        if (iSe < 0) {
            return null;
        }
        char cCharValue = cArr[iSe];
        for (int i7 = iSe - 1; i7 >= 0; i7--) {
            cCharValue = operation.v(Integer.valueOf(i7), Character.valueOf(cArr[i7]), Character.valueOf(cCharValue)).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    @a7.d
    public static final boolean[] Zr(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int iZe = Ze(zArr);
        u0 it = new kotlin.ranges.k(0, iZe).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            zArr2[iZe - iB] = zArr[iB];
        }
        return zArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <T, R> List<R> Zs(@a7.d T[] tArr, R r7, @a7.d i5.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r7);
        int length = tArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, tArr[i7]);
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Long Zt(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    public static final void Zu(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length > 1) {
            kotlin.collections.o.p4(iArr);
            yr(iArr);
        }
    }

    @a7.d
    public static final List<Character> Zv(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.l0.o(cArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.j4(cArrCopyOf);
        return Jr(cArrCopyOf);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @kotlin.t0
    @kotlin.internal.f
    private static final double Zw(double[] dArr, i5.l<? super Double, Double> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (double d8 : dArr) {
            dDoubleValue += selector.z(Double.valueOf(d8)).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final List<Integer> Zx(@a7.d int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        if (i7 >= iArr.length) {
            return iz(iArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        for (int i9 : iArr) {
            arrayList.add(Integer.valueOf(i9));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final HashSet<Long> Zy(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return (HashSet) Oy(jArr, new HashSet(b1.j(jArr.length)));
    }

    @a7.d
    public static final Iterable<r0<Byte>> Zz(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return new s0(new u(bArr));
    }

    @a7.d
    public static final Iterable<Integer> a6(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr.length == 0 ? kotlin.collections.y.F() : new d(iArr);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M a7(@a7.d long[] jArr, @a7.d M destination, @a7.d i5.l<? super Long, ? extends K> keySelector, @a7.d i5.l<? super Long, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (long j7 : jArr) {
            destination.put(keySelector.z(Long.valueOf(j7)), valueTransform.z(Long.valueOf(j7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final <T> T a8(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr[0];
    }

    @kotlin.internal.f
    private static final int a9(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr.length;
    }

    @a7.d
    public static final Iterable<r0<Character>> aA(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return new s0(new b0(cArr));
    }

    @a7.d
    public static final List<kotlin.u0<Short, Short>> aB(@a7.d short[] sArr, @a7.d short[] other) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(kotlin.p1.a(Short.valueOf(sArr[i7]), Short.valueOf(other[i7])));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Double> aa(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iTe = Te(dArr); -1 < iTe; iTe--) {
            if (!predicate.z(Double.valueOf(dArr[iTe])).booleanValue()) {
                return Xx(dArr, iTe + 1);
            }
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final <C extends Collection<? super Byte>> C ab(@a7.d byte[] bArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            byte b8 = bArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Byte.valueOf(b8)).booleanValue()) {
                destination.add(Byte.valueOf(b8));
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @kotlin.internal.f
    private static final Double ac(double[] dArr, i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                double d8 = dArr[length];
                if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                    return Double.valueOf(d8);
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return null;
    }

    @a7.d
    public static final <R> List<R> ad(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean z7 : zArr) {
            d0.o0(arrayList, transform.z(Boolean.valueOf(z7)));
        }
        return arrayList;
    }

    public static final <R> R ae(@a7.d double[] dArr, R r7, @a7.d i5.p<? super Double, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iTe = Te(dArr); iTe >= 0; iTe--) {
            r7 = operation.a0(Double.valueOf(dArr[iTe]), r7);
        }
        return r7;
    }

    @kotlin.internal.f
    private static final byte af(byte[] bArr, int i7, i5.l<? super Integer, Byte> defaultValue) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Re(bArr)) ? defaultValue.z(Integer.valueOf(i7)).byteValue() : bArr[i7];
    }

    @a7.d
    public static final <K, M extends Map<? super K, List<Boolean>>> M ag(@a7.d boolean[] zArr, @a7.d M destination, @a7.d i5.l<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (boolean z7 : zArr) {
            K kZ = keySelector.z(Boolean.valueOf(z7));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(Boolean.valueOf(z7));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean ah(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return !(iArr.length == 0);
    }

    public static final long ai(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                long j7 = jArr[length];
                if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                    return j7;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    public static final <T, R> List<R> aj(@a7.d T[] tArr, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int i9 = i8 + 1;
            R rA0 = transform.a0(Integer.valueOf(i8), tArr[i7]);
            if (rA0 != null) {
                arrayList.add(rA0);
            }
            i7++;
            i8 = i9;
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float ak(float[] fArr, i5.l<? super Float, Float> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Float.valueOf(fArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Float.valueOf(fArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R al(char[] cArr, Comparator<? super R> comparator, i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Character.valueOf(cArr[0]));
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(cArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Long am(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j7 = jArr[0];
        int iWe = We(jArr);
        if (iWe == 0) {
            return Long.valueOf(j7);
        }
        R rZ = selector.z(Long.valueOf(j7));
        u0 it = new kotlin.ranges.k(1, iWe).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            R rZ2 = selector.z(Long.valueOf(j8));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
                j7 = j8;
            }
        }
        return Long.valueOf(j7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double an(int[] iArr, i5.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Integer.valueOf(iArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Integer.valueOf(iArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Boolean ao(@a7.d boolean[] zArr, @a7.d Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z7 = zArr[0];
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            boolean z8 = zArr[it.b()];
            if (comparator.compare(Boolean.valueOf(z7), Boolean.valueOf(z8)) > 0) {
                z7 = z8;
            }
        }
        return Boolean.valueOf(z7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final short[] ap(short[] sArr, i5.p<? super Integer, ? super Short, l2> action) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = sArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Short.valueOf(sArr[i7]));
            i7++;
            i8++;
        }
        return sArr;
    }

    public static final long aq(@a7.d long[] jArr, @a7.d i5.p<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (jArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            jLongValue = operation.a0(Long.valueOf(jLongValue), Long.valueOf(jArr[it.b()])).longValue();
        }
        return jLongValue;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Double ar(@a7.d double[] dArr, @a7.d i5.q<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iTe = Te(dArr);
        if (iTe < 0) {
            return null;
        }
        double dDoubleValue = dArr[iTe];
        for (int i7 = iTe - 1; i7 >= 0; i7--) {
            dDoubleValue = operation.v(Integer.valueOf(i7), Double.valueOf(dArr[i7]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> as(byte[] bArr, R r7, i5.p<? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r7);
        for (byte b8 : bArr) {
            r7 = operation.a0(r7, Byte.valueOf(b8));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> at(short[] sArr, R r7, i5.q<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r7);
        int length = sArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Short.valueOf(sArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static final Long au(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Long lValueOf = null;
        boolean z7 = false;
        for (long j7 : jArr) {
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                if (z7) {
                    return null;
                }
                lValueOf = Long.valueOf(j7);
                z7 = true;
            }
        }
        if (z7) {
            return lValueOf;
        }
        return null;
    }

    @kotlin.g1(version = "1.4")
    public static final void av(@a7.d int[] iArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.collections.o.q4(iArr, i7, i8);
        zr(iArr, i7, i8);
    }

    @a7.d
    public static final List<Double> aw(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.l0.o(dArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.l4(dArrCopyOf);
        return Kr(dArrCopyOf);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @kotlin.t0
    @kotlin.internal.f
    private static final double ax(float[] fArr, i5.l<? super Float, Double> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (float f8 : fArr) {
            dDoubleValue += selector.z(Float.valueOf(f8)).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final List<Long> ay(@a7.d long[] jArr, int i7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        if (i7 >= jArr.length) {
            return jz(jArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Long.valueOf(jArr[0]));
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        for (long j7 : jArr) {
            arrayList.add(Long.valueOf(j7));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <T> HashSet<T> az(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return (HashSet) Py(tArr, new HashSet(b1.j(tArr.length)));
    }

    @a7.d
    public static final Iterable<Long> b6(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr.length == 0 ? kotlin.collections.y.F() : new e(jArr);
    }

    @a7.d
    public static final <T, K, M extends Map<? super K, ? super T>> M b7(@a7.d T[] tArr, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (T t7 : tArr) {
            destination.put(keySelector.z(t7), t7);
        }
        return destination;
    }

    @kotlin.internal.f
    private static final short b8(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr[0];
    }

    public static final int b9(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        for (double d8 : dArr) {
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @a7.d
    public static final Iterable<r0<Double>> bA(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return new s0(new z(dArr));
    }

    @a7.d
    public static final <V> List<V> bB(@a7.d short[] sArr, @a7.d short[] other, @a7.d i5.p<? super Short, ? super Short, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Short.valueOf(sArr[i7]), Short.valueOf(other[i7])));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Float> ba(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iUe = Ue(fArr); -1 < iUe; iUe--) {
            if (!predicate.z(Float.valueOf(fArr[iUe])).booleanValue()) {
                return Yx(fArr, iUe + 1);
            }
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final <C extends Collection<? super Character>> C bb(@a7.d char[] cArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = cArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            char c8 = cArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Character.valueOf(c8)).booleanValue()) {
                destination.add(Character.valueOf(c8));
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @kotlin.internal.f
    private static final Float bc(float[] fArr, i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                float f8 = fArr[length];
                if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                    return Float.valueOf(f8);
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return null;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R> List<R> bd(byte[] bArr, i5.p<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), Byte.valueOf(bArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    public static final <R> R be(@a7.d float[] fArr, R r7, @a7.d i5.p<? super Float, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iUe = Ue(fArr); iUe >= 0; iUe--) {
            r7 = operation.a0(Float.valueOf(fArr[iUe]), r7);
        }
        return r7;
    }

    @kotlin.internal.f
    private static final char bf(char[] cArr, int i7, i5.l<? super Integer, Character> defaultValue) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Se(cArr)) ? defaultValue.z(Integer.valueOf(i7)).charValue() : cArr[i7];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <K, V, M extends Map<? super K, List<V>>> M bg(@a7.d boolean[] zArr, @a7.d M destination, @a7.d i5.l<? super Boolean, ? extends K> keySelector, @a7.d i5.l<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (boolean z7 : zArr) {
            K kZ = keySelector.z(Boolean.valueOf(z7));
            Object arrayList = destination.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kZ, arrayList);
            }
            ((List) arrayList).add(valueTransform.z(Boolean.valueOf(z7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean bh(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return !(jArr.length == 0);
    }

    public static final <T> T bi(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[Xe(tArr)];
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C bj(@a7.d T[] tArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int i9 = i8 + 1;
            R rA0 = transform.a0(Integer.valueOf(i8), tArr[i7]);
            if (rA0 != null) {
                destination.add(rA0);
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float bk(int[] iArr, i5.l<? super Integer, Float> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Integer.valueOf(iArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Integer.valueOf(iArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R bl(double[] dArr, Comparator<? super R> comparator, i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Double.valueOf(dArr[0]));
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Double.valueOf(dArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <T, R extends Comparable<? super R>> T bm(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t7 = tArr[0];
        int iXe = Xe(tArr);
        if (iXe == 0) {
            return t7;
        }
        R rZ = selector.z(t7);
        u0 it = new kotlin.ranges.k(1, iXe).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            R rZ2 = selector.z(t8);
            if (rZ.compareTo(rZ2) > 0) {
                t7 = t8;
                rZ = rZ2;
            }
        }
        return t7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double bn(long[] jArr, i5.l<? super Long, Double> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Long.valueOf(jArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Long.valueOf(jArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Byte bo(@a7.d byte[] bArr, @a7.d Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b8 = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            if (comparator.compare(Byte.valueOf(b8), Byte.valueOf(b9)) > 0) {
                b8 = b9;
            }
        }
        return Byte.valueOf(b8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final boolean[] bp(boolean[] zArr, i5.p<? super Integer, ? super Boolean, l2> action) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = zArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Boolean.valueOf(zArr[i7]));
            i7++;
            i8++;
        }
        return zArr;
    }

    public static final <S, T extends S> S bq(@a7.d T[] tArr, @a7.d i5.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sA0 = (S) tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            sA0 = operation.a0(sA0, (Object) tArr[it.b()]);
        }
        return sA0;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Float br(@a7.d float[] fArr, @a7.d i5.q<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iUe = Ue(fArr);
        if (iUe < 0) {
            return null;
        }
        float fFloatValue = fArr[iUe];
        for (int i7 = iUe - 1; i7 >= 0; i7--) {
            fFloatValue = operation.v(Integer.valueOf(i7), Float.valueOf(fArr[i7]), Float.valueOf(fFloatValue)).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> bs(char[] cArr, R r7, i5.p<? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r7);
        for (char c8 : cArr) {
            r7 = operation.a0(r7, Character.valueOf(c8));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final <R> List<R> bt(boolean[] zArr, R r7, i5.q<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r7);
        int length = zArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Boolean.valueOf(zArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.e
    public static <T> T bu(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final void bv(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length > 1) {
            kotlin.collections.o.r4(jArr);
            Ar(jArr);
        }
    }

    @a7.d
    public static final List<Float> bw(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.l0.o(fArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.n4(fArrCopyOf);
        return Lr(fArrCopyOf);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @kotlin.t0
    @kotlin.internal.f
    private static final double bx(int[] iArr, i5.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i7 : iArr) {
            dDoubleValue += selector.z(Integer.valueOf(i7)).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final HashSet<Short> bz(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return (HashSet) Qy(sArr, new HashSet(b1.j(sArr.length)));
    }

    @a7.d
    public static <T> Iterable<T> c6(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr.length == 0 ? kotlin.collections.y.F() : new a(tArr);
    }

    @a7.d
    public static final <T, K, V, M extends Map<? super K, ? super V>> M c7(@a7.d T[] tArr, @a7.d M destination, @a7.d i5.l<? super T, ? extends K> keySelector, @a7.d i5.l<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (T t7 : tArr) {
            destination.put(keySelector.z(t7), valueTransform.z(t7));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean c8(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr[0];
    }

    @kotlin.internal.f
    private static final int c9(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr.length;
    }

    @a7.d
    public static final Iterable<r0<Float>> cA(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return new s0(new y(fArr));
    }

    @a7.d
    public static final <R> List<kotlin.u0<Boolean, R>> cB(@a7.d boolean[] zArr, @a7.d Iterable<? extends R> other) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(kotlin.p1.a(Boolean.valueOf(zArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final List<Integer> ca(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iVe = Ve(iArr); -1 < iVe; iVe--) {
            if (!predicate.z(Integer.valueOf(iArr[iVe])).booleanValue()) {
                return Zx(iArr, iVe + 1);
            }
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final <C extends Collection<? super Double>> C cb(@a7.d double[] dArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = dArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            double d8 = dArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Double.valueOf(d8)).booleanValue()) {
                destination.add(Double.valueOf(d8));
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @kotlin.internal.f
    private static final Integer cc(int[] iArr, i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                int i8 = iArr[length];
                if (predicate.z(Integer.valueOf(i8)).booleanValue()) {
                    return Integer.valueOf(i8);
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return null;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R> List<R> cd(char[] cArr, i5.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), Character.valueOf(cArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    public static final <R> R ce(@a7.d int[] iArr, R r7, @a7.d i5.p<? super Integer, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iVe = Ve(iArr); iVe >= 0; iVe--) {
            r7 = operation.a0(Integer.valueOf(iArr[iVe]), r7);
        }
        return r7;
    }

    @kotlin.internal.f
    private static final double cf(double[] dArr, int i7, i5.l<? super Integer, Double> defaultValue) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Te(dArr)) ? defaultValue.z(Integer.valueOf(i7)).doubleValue() : dArr[i7];
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <T, K> n0<T, K> cg(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        return new s(tArr, keySelector);
    }

    @kotlin.internal.f
    private static final <T> boolean ch(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return !(tArr.length == 0);
    }

    public static final <T> T ci(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                T t7 = tArr[length];
                if (predicate.z(t7).booleanValue()) {
                    return t7;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C cj(@a7.d byte[] bArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            destination.add(transform.a0(Integer.valueOf(i8), Byte.valueOf(bArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float ck(long[] jArr, i5.l<? super Long, Float> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Long.valueOf(jArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Long.valueOf(jArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R cl(float[] fArr, Comparator<? super R> comparator, i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Float.valueOf(fArr[0]));
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Float.valueOf(fArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Short cm(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s7 = sArr[0];
        int iYe = Ye(sArr);
        if (iYe == 0) {
            return Short.valueOf(s7);
        }
        R rZ = selector.z(Short.valueOf(s7));
        u0 it = new kotlin.ranges.k(1, iYe).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            R rZ2 = selector.z(Short.valueOf(s8));
            if (rZ.compareTo(rZ2) > 0) {
                s7 = s8;
                rZ = rZ2;
            }
        }
        return Short.valueOf(s7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> Double cn(T[] tArr, i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(tArr[0]).doubleValue();
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(tArr[it.b()]).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Character co(@a7.d char[] cArr, @a7.d Comparator<? super Character> comparator) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c8 = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            if (comparator.compare(Character.valueOf(c8), Character.valueOf(c9)) > 0) {
                c8 = c9;
            }
        }
        return Character.valueOf(c8);
    }

    @a7.d
    public static final kotlin.u0<List<Byte>, List<Byte>> cp(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b8 : bArr) {
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                arrayList.add(Byte.valueOf(b8));
            } else {
                arrayList2.add(Byte.valueOf(b8));
            }
        }
        return new kotlin.u0<>(arrayList, arrayList2);
    }

    public static final short cq(@a7.d short[] sArr, @a7.d i5.p<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (sArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            sShortValue = operation.a0(Short.valueOf(sShortValue), Short.valueOf(sArr[it.b()])).shortValue();
        }
        return sShortValue;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Integer cr(@a7.d int[] iArr, @a7.d i5.q<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iVe = Ve(iArr);
        if (iVe < 0) {
            return null;
        }
        int iIntValue = iArr[iVe];
        for (int i7 = iVe - 1; i7 >= 0; i7--) {
            iIntValue = operation.v(Integer.valueOf(i7), Integer.valueOf(iArr[i7]), Integer.valueOf(iIntValue)).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> cs(double[] dArr, R r7, i5.p<? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r7);
        for (double d8 : dArr) {
            r7 = operation.a0(r7, Double.valueOf(d8));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void ct(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        dt(bArr, kotlin.random.f.f34998a);
    }

    @a7.e
    public static final <T> T cu(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        T t7 = null;
        boolean z7 = false;
        for (T t8 : tArr) {
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

    @kotlin.g1(version = "1.4")
    public static final void cv(@a7.d long[] jArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.collections.o.s4(jArr, i7, i8);
        Br(jArr, i7, i8);
    }

    @a7.d
    public static final List<Integer> cw(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.l0.o(iArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.p4(iArrCopyOf);
        return Mr(iArrCopyOf);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @kotlin.t0
    @kotlin.internal.f
    private static final double cx(long[] jArr, i5.l<? super Long, Double> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (long j7 : jArr) {
            dDoubleValue += selector.z(Long.valueOf(j7)).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final <T> List<T> cy(@a7.d T[] tArr, int i7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        if (i7 >= tArr.length) {
            return kz(tArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(tArr[0]);
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        for (T t7 : tArr) {
            arrayList.add(t7);
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final HashSet<Boolean> cz(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return (HashSet) Ry(zArr, new HashSet(b1.j(zArr.length)));
    }

    @a7.d
    public static final Iterable<Short> d6(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr.length == 0 ? kotlin.collections.y.F() : new c(sArr);
    }

    @a7.d
    public static final <K, M extends Map<? super K, ? super Short>> M d7(@a7.d short[] sArr, @a7.d M destination, @a7.d i5.l<? super Short, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (short s7 : sArr) {
            destination.put(keySelector.z(Short.valueOf(s7)), Short.valueOf(s7));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final byte d8(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr[1];
    }

    public static final int d9(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        for (float f8 : fArr) {
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @a7.d
    public static final Iterable<r0<Integer>> dA(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return new s0(new w(iArr));
    }

    @a7.d
    public static final <R, V> List<V> dB(@a7.d boolean[] zArr, @a7.d Iterable<? extends R> other, @a7.d i5.p<? super Boolean, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(transform.a0(Boolean.valueOf(zArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final List<Long> da(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iWe = We(jArr); -1 < iWe; iWe--) {
            if (!predicate.z(Long.valueOf(jArr[iWe])).booleanValue()) {
                return ay(jArr, iWe + 1);
            }
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final <C extends Collection<? super Float>> C db(@a7.d float[] fArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = fArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            float f8 = fArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Float.valueOf(f8)).booleanValue()) {
                destination.add(Float.valueOf(f8));
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @kotlin.internal.f
    private static final Long dc(long[] jArr, i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                long j7 = jArr[length];
                if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                    return Long.valueOf(j7);
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return null;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R> List<R> dd(double[] dArr, i5.p<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), Double.valueOf(dArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    public static final <R> R de(@a7.d long[] jArr, R r7, @a7.d i5.p<? super Long, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iWe = We(jArr); iWe >= 0; iWe--) {
            r7 = operation.a0(Long.valueOf(jArr[iWe]), r7);
        }
        return r7;
    }

    @kotlin.internal.f
    private static final float df(float[] fArr, int i7, i5.l<? super Integer, Float> defaultValue) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Ue(fArr)) ? defaultValue.z(Integer.valueOf(i7)).floatValue() : fArr[i7];
    }

    public static int dg(@a7.d byte[] bArr, byte b8) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        int length = bArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (b8 == bArr[i7]) {
                return i7;
            }
        }
        return -1;
    }

    @kotlin.internal.f
    private static final boolean dh(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return !(sArr.length == 0);
    }

    public static short di(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return sArr[Ye(sArr)];
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C dj(@a7.d char[] cArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Character, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = cArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            destination.add(transform.a0(Integer.valueOf(i8), Character.valueOf(cArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> float dk(T[] tArr, i5.l<? super T, Float> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(tArr[0]).floatValue();
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(tArr[it.b()]).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R dl(int[] iArr, Comparator<? super R> comparator, i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Integer.valueOf(iArr[0]));
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Integer.valueOf(iArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> byte dm(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b8 = bArr[0];
        int iRe = Re(bArr);
        if (iRe == 0) {
            return b8;
        }
        R rZ = selector.z(Byte.valueOf(b8));
        u0 it = new kotlin.ranges.k(1, iRe).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            R rZ2 = selector.z(Byte.valueOf(b9));
            if (rZ.compareTo(rZ2) > 0) {
                b8 = b9;
                rZ = rZ2;
            }
        }
        return b8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double dn(short[] sArr, i5.l<? super Short, Double> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Short.valueOf(sArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Short.valueOf(sArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static final Double m0do(@a7.d double[] dArr, @a7.d Comparator<? super Double> comparator) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d8 = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            double d9 = dArr[it.b()];
            if (comparator.compare(Double.valueOf(d8), Double.valueOf(d9)) > 0) {
                d8 = d9;
            }
        }
        return Double.valueOf(d8);
    }

    @a7.d
    public static final kotlin.u0<List<Character>, List<Character>> dp(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c8 : cArr) {
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                arrayList.add(Character.valueOf(c8));
            } else {
                arrayList2.add(Character.valueOf(c8));
            }
        }
        return new kotlin.u0<>(arrayList, arrayList2);
    }

    public static final boolean dq(@a7.d boolean[] zArr, @a7.d i5.p<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (zArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[0];
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            zBooleanValue = operation.a0(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[it.b()])).booleanValue();
        }
        return zBooleanValue;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Long dr(@a7.d long[] jArr, @a7.d i5.q<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iWe = We(jArr);
        if (iWe < 0) {
            return null;
        }
        long jLongValue = jArr[iWe];
        for (int i7 = iWe - 1; i7 >= 0; i7--) {
            jLongValue = operation.v(Integer.valueOf(i7), Long.valueOf(jArr[i7]), Long.valueOf(jLongValue)).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> ds(float[] fArr, R r7, i5.p<? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r7);
        for (float f8 : fArr) {
            r7 = operation.a0(r7, Float.valueOf(f8));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void dt(@a7.d byte[] bArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        for (int iRe = Re(bArr); iRe > 0; iRe--) {
            int iM = random.m(iRe + 1);
            byte b8 = bArr[iRe];
            bArr[iRe] = bArr[iM];
            bArr[iM] = b8;
        }
    }

    @a7.e
    public static final Short du(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    public static final <T extends Comparable<? super T>> void dv(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.collections.o.I4(tArr, kotlin.comparisons.b.q());
    }

    @a7.d
    public static final List<Long> dw(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.l0.o(jArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.r4(jArrCopyOf);
        return Nr(jArrCopyOf);
    }

    @h5.h(name = "sumOfDouble")
    public static final double dx(@a7.d Double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        double dDoubleValue = 0.0d;
        for (Double d8 : dArr) {
            dDoubleValue += d8.doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final List<Short> dy(@a7.d short[] sArr, int i7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        if (i7 >= sArr.length) {
            return lz(sArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Short.valueOf(sArr[0]));
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        for (short s7 : sArr) {
            arrayList.add(Short.valueOf(s7));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final int[] dz(@a7.d Integer[] numArr) {
        kotlin.jvm.internal.l0.p(numArr, "<this>");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = numArr[i7].intValue();
        }
        return iArr;
    }

    @a7.d
    public static final Iterable<Boolean> e6(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr.length == 0 ? kotlin.collections.y.F() : new h(zArr);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M e7(@a7.d short[] sArr, @a7.d M destination, @a7.d i5.l<? super Short, ? extends K> keySelector, @a7.d i5.l<? super Short, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (short s7 : sArr) {
            destination.put(keySelector.z(Short.valueOf(s7)), valueTransform.z(Short.valueOf(s7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final char e8(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr[1];
    }

    @kotlin.internal.f
    private static final int e9(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr.length;
    }

    @a7.d
    public static final Iterable<r0<Long>> eA(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return new s0(new x(jArr));
    }

    @a7.d
    public static final <R> List<kotlin.u0<Boolean, R>> eB(@a7.d boolean[] zArr, @a7.d R[] other) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            boolean z7 = zArr[i7];
            arrayList.add(kotlin.p1.a(Boolean.valueOf(z7), other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final <T> List<T> ea(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iXe = Xe(tArr); -1 < iXe; iXe--) {
            if (!predicate.z(tArr[iXe]).booleanValue()) {
                return cy(tArr, iXe + 1);
            }
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final <C extends Collection<? super Integer>> C eb(@a7.d int[] iArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int i9 = iArr[i7];
            int i10 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Integer.valueOf(i9)).booleanValue()) {
                destination.add(Integer.valueOf(i9));
            }
            i7++;
            i8 = i10;
        }
        return destination;
    }

    @kotlin.internal.f
    private static final <T> T ec(T[] tArr, i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                T t7 = tArr[length];
                if (predicate.z(t7).booleanValue()) {
                    return t7;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return null;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R> List<R> ed(float[] fArr, i5.p<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), Float.valueOf(fArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R ee(@a7.d T[] tArr, R r7, @a7.d i5.p<? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iXe = Xe(tArr); iXe >= 0; iXe--) {
            r7 = operation.a0(tArr[iXe], r7);
        }
        return r7;
    }

    @kotlin.internal.f
    private static final int ef(int[] iArr, int i7, i5.l<? super Integer, Integer> defaultValue) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Ve(iArr)) ? defaultValue.z(Integer.valueOf(i7)).intValue() : iArr[i7];
    }

    public static final int eg(@a7.d char[] cArr, char c8) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        int length = cArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (c8 == cArr[i7]) {
                return i7;
            }
        }
        return -1;
    }

    @kotlin.internal.f
    private static final boolean eh(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return !(zArr.length == 0);
    }

    public static final short ei(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                short s7 = sArr[length];
                if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                    return s7;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C ej(@a7.d double[] dArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Double, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = dArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            destination.add(transform.a0(Integer.valueOf(i8), Double.valueOf(dArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float ek(short[] sArr, i5.l<? super Short, Float> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Short.valueOf(sArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Short.valueOf(sArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R el(long[] jArr, Comparator<? super R> comparator, i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Long.valueOf(jArr[0]));
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Long.valueOf(jArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> char em(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c8 = cArr[0];
        int iSe = Se(cArr);
        if (iSe == 0) {
            return c8;
        }
        R rZ = selector.z(Character.valueOf(c8));
        u0 it = new kotlin.ranges.k(1, iSe).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            R rZ2 = selector.z(Character.valueOf(c9));
            if (rZ.compareTo(rZ2) > 0) {
                c8 = c9;
                rZ = rZ2;
            }
        }
        return c8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double en(boolean[] zArr, i5.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Boolean.valueOf(zArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Boolean.valueOf(zArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Float eo(@a7.d float[] fArr, @a7.d Comparator<? super Float> comparator) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f8 = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            float f9 = fArr[it.b()];
            if (comparator.compare(Float.valueOf(f8), Float.valueOf(f9)) > 0) {
                f8 = f9;
            }
        }
        return Float.valueOf(f8);
    }

    @a7.d
    public static final kotlin.u0<List<Double>, List<Double>> ep(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d8 : dArr) {
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                arrayList.add(Double.valueOf(d8));
            } else {
                arrayList2.add(Double.valueOf(d8));
            }
        }
        return new kotlin.u0<>(arrayList, arrayList2);
    }

    public static final byte eq(@a7.d byte[] bArr, @a7.d i5.q<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (bArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            bByteValue = operation.v(Integer.valueOf(iB), Byte.valueOf(bByteValue), Byte.valueOf(bArr[iB])).byteValue();
        }
        return bByteValue;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <S, T extends S> S er(@a7.d T[] tArr, @a7.d i5.q<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iXe = Xe(tArr);
        if (iXe < 0) {
            return null;
        }
        S sV = (S) tArr[iXe];
        for (int i7 = iXe - 1; i7 >= 0; i7--) {
            sV = operation.v(Integer.valueOf(i7), (Object) tArr[i7], sV);
        }
        return sV;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> es(int[] iArr, R r7, i5.p<? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r7);
        for (int i7 : iArr) {
            r7 = operation.a0(r7, Integer.valueOf(i7));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void et(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        ft(cArr, kotlin.random.f.f34998a);
    }

    @a7.e
    public static final Short eu(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Short shValueOf = null;
        boolean z7 = false;
        for (short s7 : sArr) {
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                if (z7) {
                    return null;
                }
                shValueOf = Short.valueOf(s7);
                z7 = true;
            }
        }
        if (z7) {
            return shValueOf;
        }
        return null;
    }

    @kotlin.g1(version = "1.4")
    public static final <T extends Comparable<? super T>> void ev(@a7.d T[] tArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.collections.o.J4(tArr, kotlin.comparisons.b.q(), i7, i8);
    }

    @a7.d
    public static final <T extends Comparable<? super T>> List<T> ew(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return mw(tArr, kotlin.comparisons.b.q());
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T> double ex(T[] tArr, i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (T t7 : tArr) {
            dDoubleValue += selector.z(t7).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final List<Boolean> ey(@a7.d boolean[] zArr, int i7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        if (i7 >= zArr.length) {
            return mz(zArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        for (boolean z7 : zArr) {
            arrayList.add(Boolean.valueOf(z7));
            i8++;
            if (i8 == i7) {
                break;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final List<Byte> ez(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            return length != 1 ? oz(bArr) : kotlin.collections.x.l(Byte.valueOf(bArr[0]));
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final kotlin.sequences.m<Byte> f6(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr.length == 0 ? kotlin.sequences.s.g() : new k(bArr);
    }

    @a7.d
    public static final <K, M extends Map<? super K, ? super Boolean>> M f7(@a7.d boolean[] zArr, @a7.d M destination, @a7.d i5.l<? super Boolean, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        for (boolean z7 : zArr) {
            destination.put(keySelector.z(Boolean.valueOf(z7)), Boolean.valueOf(z7));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final double f8(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr[1];
    }

    public static final int f9(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        for (int i8 : iArr) {
            if (predicate.z(Integer.valueOf(i8)).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @a7.d
    public static final <T> Iterable<r0<T>> fA(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return new s0(new t(tArr));
    }

    @a7.d
    public static final <R, V> List<V> fB(@a7.d boolean[] zArr, @a7.d R[] other, @a7.d i5.p<? super Boolean, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Boolean.valueOf(zArr[i7]), other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Short> fa(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iYe = Ye(sArr); -1 < iYe; iYe--) {
            if (!predicate.z(Short.valueOf(sArr[iYe])).booleanValue()) {
                return dy(sArr, iYe + 1);
            }
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final <C extends Collection<? super Long>> C fb(@a7.d long[] jArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = jArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            long j7 = jArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Long.valueOf(j7)).booleanValue()) {
                destination.add(Long.valueOf(j7));
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    @kotlin.internal.f
    private static final Short fc(short[] sArr, i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                short s7 = sArr[length];
                if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                    return Short.valueOf(s7);
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return null;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R> List<R> fd(int[] iArr, i5.p<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), Integer.valueOf(iArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    public static final <R> R fe(@a7.d short[] sArr, R r7, @a7.d i5.p<? super Short, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iYe = Ye(sArr); iYe >= 0; iYe--) {
            r7 = operation.a0(Short.valueOf(sArr[iYe]), r7);
        }
        return r7;
    }

    @kotlin.internal.f
    private static final long ff(long[] jArr, int i7, i5.l<? super Integer, Long> defaultValue) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > We(jArr)) ? defaultValue.z(Integer.valueOf(i7)).longValue() : jArr[i7];
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.b1(expression = "indexOfFirst { it == element }", imports = {}))
    @kotlin.l(errorSince = i2.a.f34096f, hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int fg(double[] dArr, double d8) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        int length = dArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (d8 == dArr[i7]) {
                return i7;
            }
        }
        return -1;
    }

    @a7.d
    public static final <A extends Appendable> A fh(@a7.d byte[] bArr, @a7.d A buffer, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Byte, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (byte b8 : bArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.z(Byte.valueOf(b8)));
            } else {
                buffer.append(String.valueOf((int) b8));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final boolean fi(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (zArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return zArr[Ze(zArr)];
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C fj(@a7.d float[] fArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Float, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = fArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            destination.add(transform.a0(Integer.valueOf(i8), Float.valueOf(fArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float fk(boolean[] zArr, i5.l<? super Boolean, Float> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Boolean.valueOf(zArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.z(Boolean.valueOf(zArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R> R fl(T[] tArr, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rZ = selector.z(tArr[0]);
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(tArr[it.b()]);
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> double fm(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d8 = dArr[0];
        int iTe = Te(dArr);
        if (iTe == 0) {
            return d8;
        }
        R rZ = selector.z(Double.valueOf(d8));
        u0 it = new kotlin.ranges.k(1, iTe).iterator();
        while (it.hasNext()) {
            double d9 = dArr[it.b()];
            R rZ2 = selector.z(Double.valueOf(d9));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
                d8 = d9;
            }
        }
        return d8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float fn(byte[] bArr, i5.l<? super Byte, Float> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Byte.valueOf(bArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Byte.valueOf(bArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Integer fo(@a7.d int[] iArr, @a7.d Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i7 = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            if (comparator.compare(Integer.valueOf(i7), Integer.valueOf(i8)) > 0) {
                i7 = i8;
            }
        }
        return Integer.valueOf(i7);
    }

    @a7.d
    public static final kotlin.u0<List<Float>, List<Float>> fp(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f8 : fArr) {
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                arrayList.add(Float.valueOf(f8));
            } else {
                arrayList2.add(Float.valueOf(f8));
            }
        }
        return new kotlin.u0<>(arrayList, arrayList2);
    }

    public static final char fq(@a7.d char[] cArr, @a7.d i5.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (cArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            cCharValue = operation.v(Integer.valueOf(iB), Character.valueOf(cCharValue), Character.valueOf(cArr[iB])).charValue();
        }
        return cCharValue;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Short fr(@a7.d short[] sArr, @a7.d i5.q<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iYe = Ye(sArr);
        if (iYe < 0) {
            return null;
        }
        short sShortValue = sArr[iYe];
        for (int i7 = iYe - 1; i7 >= 0; i7--) {
            sShortValue = operation.v(Integer.valueOf(i7), Short.valueOf(sArr[i7]), Short.valueOf(sShortValue)).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> fs(long[] jArr, R r7, i5.p<? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r7);
        for (long j7 : jArr) {
            r7 = operation.a0(r7, Long.valueOf(j7));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void ft(@a7.d char[] cArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        for (int iSe = Se(cArr); iSe > 0; iSe--) {
            int iM = random.m(iSe + 1);
            char c8 = cArr[iSe];
            cArr[iSe] = cArr[iM];
            cArr[iM] = c8;
        }
    }

    @a7.d
    public static final List<Byte> fu(@a7.d byte[] bArr, @a7.d Iterable<Integer> indices) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        int iZ = kotlin.collections.z.Z(indices, 10);
        if (iZ == 0) {
            return kotlin.collections.y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf(bArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final void fv(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length > 1) {
            kotlin.collections.o.x4(sArr);
            Er(sArr);
        }
    }

    @a7.d
    public static final List<Short> fw(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.l0.o(sArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.x4(sArrCopyOf);
        return Pr(sArrCopyOf);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @kotlin.t0
    @kotlin.internal.f
    private static final double fx(short[] sArr, i5.l<? super Short, Double> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (short s7 : sArr) {
            dDoubleValue += selector.z(Short.valueOf(s7)).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final List<Byte> fy(@a7.d byte[] bArr, int i7) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        int length = bArr.length;
        if (i7 >= length) {
            return ez(bArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Byte.valueOf(bArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = length - i7; i8 < length; i8++) {
            arrayList.add(Byte.valueOf(bArr[i8]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Character> fz(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            return length != 1 ? pz(cArr) : kotlin.collections.x.l(Character.valueOf(cArr[0]));
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final kotlin.sequences.m<Character> g6(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr.length == 0 ? kotlin.sequences.s.g() : new r(cArr);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M g7(@a7.d boolean[] zArr, @a7.d M destination, @a7.d i5.l<? super Boolean, ? extends K> keySelector, @a7.d i5.l<? super Boolean, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        for (boolean z7 : zArr) {
            destination.put(keySelector.z(Boolean.valueOf(z7)), valueTransform.z(Boolean.valueOf(z7)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final float g8(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr[1];
    }

    @kotlin.internal.f
    private static final int g9(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr.length;
    }

    @a7.d
    public static final Iterable<r0<Short>> gA(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return new s0(new v(sArr));
    }

    @a7.d
    public static final List<kotlin.u0<Boolean, Boolean>> gB(@a7.d boolean[] zArr, @a7.d boolean[] other) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(kotlin.p1.a(Boolean.valueOf(zArr[i7]), Boolean.valueOf(other[i7])));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Boolean> ga(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iZe = Ze(zArr); -1 < iZe; iZe--) {
            if (!predicate.z(Boolean.valueOf(zArr[iZe])).booleanValue()) {
                return ey(zArr, iZe + 1);
            }
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final <T, C extends Collection<? super T>> C gb(@a7.d T[] tArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            T t7 = tArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), t7).booleanValue()) {
                destination.add(t7);
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    public static byte gc(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return bArr[0];
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R> List<R> gd(long[] jArr, i5.p<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), Long.valueOf(jArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    public static final <R> R ge(@a7.d boolean[] zArr, R r7, @a7.d i5.p<? super Boolean, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iZe = Ze(zArr); iZe >= 0; iZe--) {
            r7 = operation.a0(Boolean.valueOf(zArr[iZe]), r7);
        }
        return r7;
    }

    @kotlin.internal.f
    private static final <T> T gf(T[] tArr, int i7, i5.l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Xe(tArr)) ? defaultValue.z(Integer.valueOf(i7)) : tArr[i7];
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.b1(expression = "indexOfFirst { it == element }", imports = {}))
    @kotlin.l(errorSince = i2.a.f34096f, hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int gg(float[] fArr, float f8) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        int length = fArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (f8 == fArr[i7]) {
                return i7;
            }
        }
        return -1;
    }

    @a7.d
    public static final <A extends Appendable> A gh(@a7.d char[] cArr, @a7.d A buffer, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Character, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (char c8 : cArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.z(Character.valueOf(c8)));
            } else {
                buffer.append(c8);
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final boolean gi(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                boolean z7 = zArr[length];
                if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                    return z7;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C gj(@a7.d int[] iArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            destination.add(transform.a0(Integer.valueOf(i8), Integer.valueOf(iArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R gk(byte[] bArr, i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Byte.valueOf(bArr[0]));
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Byte.valueOf(bArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R gl(short[] sArr, Comparator<? super R> comparator, i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Short.valueOf(sArr[0]));
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Short.valueOf(sArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> float gm(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f8 = fArr[0];
        int iUe = Ue(fArr);
        if (iUe == 0) {
            return f8;
        }
        R rZ = selector.z(Float.valueOf(f8));
        u0 it = new kotlin.ranges.k(1, iUe).iterator();
        while (it.hasNext()) {
            float f9 = fArr[it.b()];
            R rZ2 = selector.z(Float.valueOf(f9));
            if (rZ.compareTo(rZ2) > 0) {
                f8 = f9;
                rZ = rZ2;
            }
        }
        return f8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float gn(char[] cArr, i5.l<? super Character, Float> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Character.valueOf(cArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Character.valueOf(cArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Long go(@a7.d long[] jArr, @a7.d Comparator<? super Long> comparator) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j7 = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            if (comparator.compare(Long.valueOf(j7), Long.valueOf(j8)) > 0) {
                j7 = j8;
            }
        }
        return Long.valueOf(j7);
    }

    @a7.d
    public static final kotlin.u0<List<Integer>, List<Integer>> gp(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i7 : iArr) {
            if (predicate.z(Integer.valueOf(i7)).booleanValue()) {
                arrayList.add(Integer.valueOf(i7));
            } else {
                arrayList2.add(Integer.valueOf(i7));
            }
        }
        return new kotlin.u0<>(arrayList, arrayList2);
    }

    public static final double gq(@a7.d double[] dArr, @a7.d i5.q<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (dArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            dDoubleValue = operation.v(Integer.valueOf(iB), Double.valueOf(dDoubleValue), Double.valueOf(dArr[iB])).doubleValue();
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Boolean gr(@a7.d boolean[] zArr, @a7.d i5.p<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iZe = Ze(zArr);
        if (iZe < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[iZe];
        for (int i7 = iZe - 1; i7 >= 0; i7--) {
            zBooleanValue = operation.a0(Boolean.valueOf(zArr[i7]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <T, R> List<R> gs(@a7.d T[] tArr, R r7, @a7.d i5.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r7);
        for (a1.c cVar : tArr) {
            r7 = operation.a0(r7, cVar);
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void gt(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        ht(dArr, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final List<Byte> gu(@a7.d byte[] bArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? kotlin.collections.y.F() : kotlin.collections.o.n(kotlin.collections.o.G1(bArr, indices.d().intValue(), indices.f().intValue() + 1));
    }

    @kotlin.g1(version = "1.4")
    public static final void gv(@a7.d short[] sArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.collections.o.y4(sArr, i7, i8);
        Fr(sArr, i7, i8);
    }

    @a7.d
    public static final List<Byte> gw(@a7.d byte[] bArr, @a7.d Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Byte[] bArrO5 = kotlin.collections.o.o5(bArr);
        kotlin.collections.o.I4(bArrO5, comparator);
        return kotlin.collections.o.t(bArrO5);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfDouble")
    @kotlin.t0
    @kotlin.internal.f
    private static final double gx(boolean[] zArr, i5.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (boolean z7 : zArr) {
            dDoubleValue += selector.z(Boolean.valueOf(z7)).doubleValue();
        }
        return dDoubleValue;
    }

    @a7.d
    public static final List<Character> gy(@a7.d char[] cArr, int i7) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        int length = cArr.length;
        if (i7 >= length) {
            return fz(cArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Character.valueOf(cArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = length - i7; i8 < length; i8++) {
            arrayList.add(Character.valueOf(cArr[i8]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Double> gz(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            return length != 1 ? qz(dArr) : kotlin.collections.x.l(Double.valueOf(dArr[0]));
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final kotlin.sequences.m<Double> h6(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr.length == 0 ? kotlin.sequences.s.g() : new C0425p(dArr);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M h7(@a7.d byte[] bArr, @a7.d M destination, @a7.d i5.l<? super Byte, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (byte b8 : bArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Byte.valueOf(b8));
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @kotlin.internal.f
    private static final int h8(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr[1];
    }

    public static final int h9(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        for (long j7 : jArr) {
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @a7.d
    public static final Iterable<r0<Boolean>> hA(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return new s0(new a0(zArr));
    }

    @a7.d
    public static final <V> List<V> hB(@a7.d boolean[] zArr, @a7.d boolean[] other, @a7.d i5.p<? super Boolean, ? super Boolean, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Boolean.valueOf(zArr[i7]), Boolean.valueOf(other[i7])));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Byte> ha(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (byte b8 : bArr) {
            if (z7) {
                arrayList.add(Byte.valueOf(b8));
            } else if (!predicate.z(Byte.valueOf(b8)).booleanValue()) {
                arrayList.add(Byte.valueOf(b8));
                z7 = true;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <C extends Collection<? super Short>> C hb(@a7.d short[] sArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = sArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            short s7 = sArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Short.valueOf(s7)).booleanValue()) {
                destination.add(Short.valueOf(s7));
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    public static final byte hc(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (byte b8 : bArr) {
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                return b8;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T, R> List<R> hd(T[] tArr, i5.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), tArr[i7]));
            i7++;
            i8++;
        }
        return arrayList;
    }

    public static final <R> R he(@a7.d byte[] bArr, R r7, @a7.d i5.q<? super Integer, ? super Byte, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iRe = Re(bArr); iRe >= 0; iRe--) {
            r7 = operation.v(Integer.valueOf(iRe), Byte.valueOf(bArr[iRe]), r7);
        }
        return r7;
    }

    @kotlin.internal.f
    private static final short hf(short[] sArr, int i7, i5.l<? super Integer, Short> defaultValue) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Ye(sArr)) ? defaultValue.z(Integer.valueOf(i7)).shortValue() : sArr[i7];
    }

    public static int hg(@a7.d int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        int length = iArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (i7 == iArr[i8]) {
                return i8;
            }
        }
        return -1;
    }

    @a7.d
    public static final <A extends Appendable> A hh(@a7.d double[] dArr, @a7.d A buffer, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Double, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (double d8 : dArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.z(Double.valueOf(d8)));
            } else {
                buffer.append(String.valueOf(d8));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static int hi(@a7.d byte[] bArr, byte b8) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (b8 == bArr[length]) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C hj(@a7.d long[] jArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Long, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = jArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            destination.add(transform.a0(Integer.valueOf(i8), Long.valueOf(jArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R hk(char[] cArr, i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Character.valueOf(cArr[0]));
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(cArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R hl(boolean[] zArr, Comparator<? super R> comparator, i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Boolean.valueOf(zArr[0]));
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Boolean.valueOf(zArr[it.b()]));
            if (comparator.compare(rZ, rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> int hm(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i7 = iArr[0];
        int iVe = Ve(iArr);
        if (iVe == 0) {
            return i7;
        }
        R rZ = selector.z(Integer.valueOf(i7));
        u0 it = new kotlin.ranges.k(1, iVe).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            R rZ2 = selector.z(Integer.valueOf(i8));
            if (rZ.compareTo(rZ2) > 0) {
                i7 = i8;
                rZ = rZ2;
            }
        }
        return i7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float hn(double[] dArr, i5.l<? super Double, Float> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Double.valueOf(dArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Double.valueOf(dArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <T> T ho(@a7.d T[] tArr, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t7 = tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            if (comparator.compare(t7, t8) > 0) {
                t7 = t8;
            }
        }
        return t7;
    }

    @a7.d
    public static final kotlin.u0<List<Long>, List<Long>> hp(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j7 : jArr) {
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                arrayList.add(Long.valueOf(j7));
            } else {
                arrayList2.add(Long.valueOf(j7));
            }
        }
        return new kotlin.u0<>(arrayList, arrayList2);
    }

    public static final float hq(@a7.d float[] fArr, @a7.d i5.q<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (fArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            fFloatValue = operation.v(Integer.valueOf(iB), Float.valueOf(fFloatValue), Float.valueOf(fArr[iB])).floatValue();
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Byte hr(@a7.d byte[] bArr, @a7.d i5.p<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iRe = Re(bArr);
        if (iRe < 0) {
            return null;
        }
        byte bByteValue = bArr[iRe];
        for (int i7 = iRe - 1; i7 >= 0; i7--) {
            bByteValue = operation.a0(Byte.valueOf(bArr[i7]), Byte.valueOf(bByteValue)).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> hs(short[] sArr, R r7, i5.p<? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r7);
        for (short s7 : sArr) {
            r7 = operation.a0(r7, Short.valueOf(s7));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void ht(@a7.d double[] dArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        for (int iTe = Te(dArr); iTe > 0; iTe--) {
            int iM = random.m(iTe + 1);
            double d8 = dArr[iTe];
            dArr[iTe] = dArr[iM];
            dArr[iM] = d8;
        }
    }

    @a7.d
    public static final List<Character> hu(@a7.d char[] cArr, @a7.d Iterable<Integer> indices) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        int iZ = kotlin.collections.z.Z(indices, 10);
        if (iZ == 0) {
            return kotlin.collections.y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf(cArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Byte> hv(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        Byte[] bArrO5 = kotlin.collections.o.o5(bArr);
        Byte[] bArr2 = bArrO5;
        kotlin.jvm.internal.l0.n(bArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        kotlin.collections.o.v4(bArr2);
        return kotlin.collections.o.t(bArrO5);
    }

    @a7.d
    public static final List<Character> hw(@a7.d char[] cArr, @a7.d Comparator<? super Character> comparator) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Character[] chArrP5 = kotlin.collections.o.p5(cArr);
        kotlin.collections.o.I4(chArrP5, comparator);
        return kotlin.collections.o.t(chArrP5);
    }

    @h5.h(name = "sumOfFloat")
    public static final float hx(@a7.d Float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        float fFloatValue = 0.0f;
        for (Float f8 : fArr) {
            fFloatValue += f8.floatValue();
        }
        return fFloatValue;
    }

    @a7.d
    public static final List<Double> hy(@a7.d double[] dArr, int i7) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        int length = dArr.length;
        if (i7 >= length) {
            return gz(dArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Double.valueOf(dArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = length - i7; i8 < length; i8++) {
            arrayList.add(Double.valueOf(dArr[i8]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Float> hz(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            return length != 1 ? rz(fArr) : kotlin.collections.x.l(Float.valueOf(fArr[0]));
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final kotlin.sequences.m<Float> i6(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr.length == 0 ? kotlin.sequences.s.g() : new o(fArr);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M i7(@a7.d char[] cArr, @a7.d M destination, @a7.d i5.l<? super Character, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (char c8 : cArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Character.valueOf(c8));
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @kotlin.internal.f
    private static final long i8(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr[1];
    }

    @kotlin.internal.f
    private static final <T> int i9(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr.length;
    }

    @a7.d
    public static final <R> List<kotlin.u0<Byte, R>> iA(@a7.d byte[] bArr, @a7.d Iterable<? extends R> other) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(kotlin.p1.a(Byte.valueOf(bArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final List<Character> ia(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (char c8 : cArr) {
            if (z7) {
                arrayList.add(Character.valueOf(c8));
            } else if (!predicate.z(Character.valueOf(c8)).booleanValue()) {
                arrayList.add(Character.valueOf(c8));
                z7 = true;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <C extends Collection<? super Boolean>> C ib(@a7.d boolean[] zArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = zArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            boolean z7 = zArr[i7];
            int i9 = i8 + 1;
            if (predicate.a0(Integer.valueOf(i8), Boolean.valueOf(z7)).booleanValue()) {
                destination.add(Boolean.valueOf(z7));
            }
            i7++;
            i8 = i9;
        }
        return destination;
    }

    public static final char ic(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return cArr[0];
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R> List<R> id(short[] sArr, i5.p<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), Short.valueOf(sArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    public static final <R> R ie(@a7.d char[] cArr, R r7, @a7.d i5.q<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iSe = Se(cArr); iSe >= 0; iSe--) {
            r7 = operation.v(Integer.valueOf(iSe), Character.valueOf(cArr[iSe]), r7);
        }
        return r7;
    }

    @kotlin.internal.f
    /* JADX INFO: renamed from: if, reason: not valid java name */
    private static final boolean m1if(boolean[] zArr, int i7, i5.l<? super Integer, Boolean> defaultValue) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Ze(zArr)) ? defaultValue.z(Integer.valueOf(i7)).booleanValue() : zArr[i7];
    }

    public static int ig(@a7.d long[] jArr, long j7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        int length = jArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (j7 == jArr[i7]) {
                return i7;
            }
        }
        return -1;
    }

    @a7.d
    public static final <A extends Appendable> A ih(@a7.d float[] fArr, @a7.d A buffer, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Float, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (float f8 : fArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.z(Float.valueOf(f8)));
            } else {
                buffer.append(String.valueOf(f8));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final int ii(@a7.d char[] cArr, char c8) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (c8 == cArr[length]) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C ij(@a7.d T[] tArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            destination.add(transform.a0(Integer.valueOf(i8), tArr[i7]));
            i7++;
            i8++;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R ik(double[] dArr, i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Double.valueOf(dArr[0]));
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Double.valueOf(dArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Byte il(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b8 = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            if (b8 < b9) {
                b8 = b9;
            }
        }
        return Byte.valueOf(b8);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> long im(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j7 = jArr[0];
        int iWe = We(jArr);
        if (iWe == 0) {
            return j7;
        }
        R rZ = selector.z(Long.valueOf(j7));
        u0 it = new kotlin.ranges.k(1, iWe).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            R rZ2 = selector.z(Long.valueOf(j8));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
                j7 = j8;
            }
        }
        return j7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float in(float[] fArr, i5.l<? super Float, Float> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Float.valueOf(fArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Float.valueOf(fArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Short io(@a7.d short[] sArr, @a7.d Comparator<? super Short> comparator) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s7 = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            if (comparator.compare(Short.valueOf(s7), Short.valueOf(s8)) > 0) {
                s7 = s8;
            }
        }
        return Short.valueOf(s7);
    }

    @a7.d
    public static final <T> kotlin.u0<List<T>, List<T>> ip(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t7 : tArr) {
            if (predicate.z(t7).booleanValue()) {
                arrayList.add(t7);
            } else {
                arrayList2.add(t7);
            }
        }
        return new kotlin.u0<>(arrayList, arrayList2);
    }

    public static final int iq(@a7.d int[] iArr, @a7.d i5.q<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (iArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            iIntValue = operation.v(Integer.valueOf(iB), Integer.valueOf(iIntValue), Integer.valueOf(iArr[iB])).intValue();
        }
        return iIntValue;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Character ir(@a7.d char[] cArr, @a7.d i5.p<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iSe = Se(cArr);
        if (iSe < 0) {
            return null;
        }
        char cCharValue = cArr[iSe];
        for (int i7 = iSe - 1; i7 >= 0; i7--) {
            cCharValue = operation.a0(Character.valueOf(cArr[i7]), Character.valueOf(cCharValue)).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> is(boolean[] zArr, R r7, i5.p<? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r7);
        for (boolean z7 : zArr) {
            r7 = operation.a0(r7, Boolean.valueOf(z7));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @a7.d
    public static final List<Character> iu(@a7.d char[] cArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? kotlin.collections.y.F() : kotlin.collections.o.o(kotlin.collections.o.H1(cArr, indices.d().intValue(), indices.f().intValue() + 1));
    }

    @a7.d
    public static final List<Character> iv(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        Character[] chArrP5 = kotlin.collections.o.p5(cArr);
        Character[] chArr = chArrP5;
        kotlin.jvm.internal.l0.n(chArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        kotlin.collections.o.v4(chArr);
        return kotlin.collections.o.t(chArrP5);
    }

    @a7.d
    public static final List<Double> iw(@a7.d double[] dArr, @a7.d Comparator<? super Double> comparator) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Double[] dArrQ5 = kotlin.collections.o.q5(dArr);
        kotlin.collections.o.I4(dArrQ5, comparator);
        return kotlin.collections.o.t(dArrQ5);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @kotlin.t0
    @kotlin.internal.f
    private static final int ix(byte[] bArr, i5.l<? super Byte, Integer> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (byte b8 : bArr) {
            iIntValue += selector.z(Byte.valueOf(b8)).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final List<Float> iy(@a7.d float[] fArr, int i7) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        int length = fArr.length;
        if (i7 >= length) {
            return hz(fArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Float.valueOf(fArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = length - i7; i8 < length; i8++) {
            arrayList.add(Float.valueOf(fArr[i8]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Integer> iz(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            return length != 1 ? sz(iArr) : kotlin.collections.x.l(Integer.valueOf(iArr[0]));
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final kotlin.sequences.m<Integer> j6(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr.length == 0 ? kotlin.sequences.s.g() : new m(iArr);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M j7(@a7.d double[] dArr, @a7.d M destination, @a7.d i5.l<? super Double, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (double d8 : dArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Double.valueOf(d8));
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @kotlin.internal.f
    private static final <T> T j8(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr[1];
    }

    public static final <T> int j9(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        for (T t7 : tArr) {
            if (predicate.z(t7).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @a7.d
    public static final <R, V> List<V> jA(@a7.d byte[] bArr, @a7.d Iterable<? extends R> other, @a7.d i5.p<? super Byte, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(transform.a0(Byte.valueOf(bArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final List<Double> ja(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (double d8 : dArr) {
            if (z7) {
                arrayList.add(Double.valueOf(d8));
            } else if (!predicate.z(Double.valueOf(d8)).booleanValue()) {
                arrayList.add(Double.valueOf(d8));
                z7 = true;
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R> List<R> jb(Object[] objArr) {
        kotlin.jvm.internal.l0.p(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            kotlin.jvm.internal.l0.y(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final char jc(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (char c8 : cArr) {
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                return c8;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterable")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R> List<R> jd(boolean[] zArr, i5.p<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(arrayList, transform.a0(Integer.valueOf(i8), Boolean.valueOf(zArr[i7])));
            i7++;
            i8++;
        }
        return arrayList;
    }

    public static final <R> R je(@a7.d double[] dArr, R r7, @a7.d i5.q<? super Integer, ? super Double, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iTe = Te(dArr); iTe >= 0; iTe--) {
            r7 = operation.v(Integer.valueOf(iTe), Double.valueOf(dArr[iTe]), r7);
        }
        return r7;
    }

    @a7.e
    public static final Boolean jf(@a7.d boolean[] zArr, int i7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (i7 < 0 || i7 > Ze(zArr)) {
            return null;
        }
        return Boolean.valueOf(zArr[i7]);
    }

    public static <T> int jg(@a7.d T[] tArr, T t7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        int i7 = 0;
        if (t7 == null) {
            int length = tArr.length;
            while (i7 < length) {
                if (tArr[i7] == null) {
                    return i7;
                }
                i7++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i7 < length2) {
            if (kotlin.jvm.internal.l0.g(t7, tArr[i7])) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    @a7.d
    public static final <A extends Appendable> A jh(@a7.d int[] iArr, @a7.d A buffer, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Integer, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (int i9 : iArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.z(Integer.valueOf(i9)));
            } else {
                buffer.append(String.valueOf(i9));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.b1(expression = "indexOfLast { it == element }", imports = {}))
    @kotlin.l(errorSince = i2.a.f34096f, hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int ji(double[] dArr, double d8) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (d8 == dArr[length]) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C jj(@a7.d short[] sArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Short, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = sArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            destination.add(transform.a0(Integer.valueOf(i8), Short.valueOf(sArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R jk(float[] fArr, i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Float.valueOf(fArr[0]));
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Float.valueOf(fArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Character jl(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c8 = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            if (kotlin.jvm.internal.l0.t(c8, c9) < 0) {
                c8 = c9;
            }
        }
        return Character.valueOf(c8);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T jm(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t7 = tArr[0];
        int iXe = Xe(tArr);
        if (iXe == 0) {
            return t7;
        }
        R rZ = selector.z(t7);
        u0 it = new kotlin.ranges.k(1, iXe).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            R rZ2 = selector.z(t8);
            if (rZ.compareTo(rZ2) > 0) {
                t7 = t8;
                rZ = rZ2;
            }
        }
        return t7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float jn(int[] iArr, i5.l<? super Integer, Float> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Integer.valueOf(iArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Integer.valueOf(iArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final byte jo(@a7.d byte[] bArr, @a7.d Comparator<? super Byte> comparator) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b8 = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            if (comparator.compare(Byte.valueOf(b8), Byte.valueOf(b9)) > 0) {
                b8 = b9;
            }
        }
        return b8;
    }

    @a7.d
    public static final kotlin.u0<List<Short>, List<Short>> jp(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s7 : sArr) {
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                arrayList.add(Short.valueOf(s7));
            } else {
                arrayList2.add(Short.valueOf(s7));
            }
        }
        return new kotlin.u0<>(arrayList, arrayList2);
    }

    public static final long jq(@a7.d long[] jArr, @a7.d i5.q<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (jArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            jLongValue = operation.v(Integer.valueOf(iB), Long.valueOf(jLongValue), Long.valueOf(jArr[iB])).longValue();
        }
        return jLongValue;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Double jr(@a7.d double[] dArr, @a7.d i5.p<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iTe = Te(dArr);
        if (iTe < 0) {
            return null;
        }
        double dDoubleValue = dArr[iTe];
        for (int i7 = iTe - 1; i7 >= 0; i7--) {
            dDoubleValue = operation.a0(Double.valueOf(dArr[i7]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> js(byte[] bArr, R r7, i5.q<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r7);
        int length = bArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Byte.valueOf(bArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void jt(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kt(fArr, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final List<Double> ju(@a7.d double[] dArr, @a7.d Iterable<Integer> indices) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        int iZ = kotlin.collections.z.Z(indices, 10);
        if (iZ == 0) {
            return kotlin.collections.y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(dArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Double> jv(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        Double[] dArrQ5 = kotlin.collections.o.q5(dArr);
        Double[] dArr2 = dArrQ5;
        kotlin.jvm.internal.l0.n(dArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        kotlin.collections.o.v4(dArr2);
        return kotlin.collections.o.t(dArrQ5);
    }

    @a7.d
    public static final List<Float> jw(@a7.d float[] fArr, @a7.d Comparator<? super Float> comparator) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Float[] fArrR5 = kotlin.collections.o.r5(fArr);
        kotlin.collections.o.I4(fArrR5, comparator);
        return kotlin.collections.o.t(fArrR5);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @kotlin.t0
    @kotlin.internal.f
    private static final int jx(char[] cArr, i5.l<? super Character, Integer> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (char c8 : cArr) {
            iIntValue += selector.z(Character.valueOf(c8)).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final List<Integer> jy(@a7.d int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        int length = iArr.length;
        if (i7 >= length) {
            return iz(iArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Integer.valueOf(iArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = length - i7; i8 < length; i8++) {
            arrayList.add(Integer.valueOf(iArr[i8]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Long> jz(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            return length != 1 ? tz(jArr) : kotlin.collections.x.l(Long.valueOf(jArr[0]));
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final kotlin.sequences.m<Long> k6(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr.length == 0 ? kotlin.sequences.s.g() : new n(jArr);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M k7(@a7.d float[] fArr, @a7.d M destination, @a7.d i5.l<? super Float, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (float f8 : fArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Float.valueOf(f8));
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @kotlin.internal.f
    private static final short k8(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr[1];
    }

    @kotlin.internal.f
    private static final int k9(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr.length;
    }

    @a7.d
    public static final List<kotlin.u0<Byte, Byte>> kA(@a7.d byte[] bArr, @a7.d byte[] other) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(kotlin.p1.a(Byte.valueOf(bArr[i7]), Byte.valueOf(other[i7])));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Float> ka(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (float f8 : fArr) {
            if (z7) {
                arrayList.add(Float.valueOf(f8));
            } else if (!predicate.z(Float.valueOf(f8)).booleanValue()) {
                arrayList.add(Float.valueOf(f8));
                z7 = true;
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C kb(Object[] objArr, C destination) {
        kotlin.jvm.internal.l0.p(objArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (Object obj : objArr) {
            kotlin.jvm.internal.l0.y(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final double kc(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return dArr[0];
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R, C extends Collection<? super R>> C kd(byte[] bArr, C destination, i5.p<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), Byte.valueOf(bArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    public static final <R> R ke(@a7.d float[] fArr, R r7, @a7.d i5.q<? super Integer, ? super Float, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iUe = Ue(fArr); iUe >= 0; iUe--) {
            r7 = operation.v(Integer.valueOf(iUe), Float.valueOf(fArr[iUe]), r7);
        }
        return r7;
    }

    @a7.e
    public static final Byte kf(@a7.d byte[] bArr, int i7) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (i7 < 0 || i7 > Re(bArr)) {
            return null;
        }
        return Byte.valueOf(bArr[i7]);
    }

    public static int kg(@a7.d short[] sArr, short s7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        int length = sArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (s7 == sArr[i7]) {
                return i7;
            }
        }
        return -1;
    }

    @a7.d
    public static final <A extends Appendable> A kh(@a7.d long[] jArr, @a7.d A buffer, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Long, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (long j7 : jArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.z(Long.valueOf(j7)));
            } else {
                buffer.append(String.valueOf(j7));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @kotlin.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @kotlin.b1(expression = "indexOfLast { it == element }", imports = {}))
    @kotlin.l(errorSince = i2.a.f34096f, hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int ki(float[] fArr, float f8) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (f8 == fArr[length]) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C kj(@a7.d boolean[] zArr, @a7.d C destination, @a7.d i5.p<? super Integer, ? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = zArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            destination.add(transform.a0(Integer.valueOf(i8), Boolean.valueOf(zArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R kk(int[] iArr, i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Integer.valueOf(iArr[0]));
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Integer.valueOf(iArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <T extends Comparable<? super T>> T kl(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t7 = tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            if (t7.compareTo(t8) < 0) {
                t7 = t8;
            }
        }
        return t7;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> short km(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s7 = sArr[0];
        int iYe = Ye(sArr);
        if (iYe == 0) {
            return s7;
        }
        R rZ = selector.z(Short.valueOf(s7));
        u0 it = new kotlin.ranges.k(1, iYe).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            R rZ2 = selector.z(Short.valueOf(s8));
            if (rZ.compareTo(rZ2) > 0) {
                s7 = s8;
                rZ = rZ2;
            }
        }
        return s7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float kn(long[] jArr, i5.l<? super Long, Float> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Long.valueOf(jArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Long.valueOf(jArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final char ko(@a7.d char[] cArr, @a7.d Comparator<? super Character> comparator) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c8 = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            if (comparator.compare(Character.valueOf(c8), Character.valueOf(c9)) > 0) {
                c8 = c9;
            }
        }
        return c8;
    }

    @a7.d
    public static final kotlin.u0<List<Boolean>, List<Boolean>> kp(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z7 : zArr) {
            if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z7));
            } else {
                arrayList2.add(Boolean.valueOf(z7));
            }
        }
        return new kotlin.u0<>(arrayList, arrayList2);
    }

    public static final <S, T extends S> S kq(@a7.d T[] tArr, @a7.d i5.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sV = (S) tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            sV = operation.v(Integer.valueOf(iB), sV, (Object) tArr[iB]);
        }
        return sV;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Float kr(@a7.d float[] fArr, @a7.d i5.p<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iUe = Ue(fArr);
        if (iUe < 0) {
            return null;
        }
        float fFloatValue = fArr[iUe];
        for (int i7 = iUe - 1; i7 >= 0; i7--) {
            fFloatValue = operation.a0(Float.valueOf(fArr[i7]), Float.valueOf(fFloatValue)).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> ks(char[] cArr, R r7, i5.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r7);
        int length = cArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Character.valueOf(cArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void kt(@a7.d float[] fArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        for (int iUe = Ue(fArr); iUe > 0; iUe--) {
            int iM = random.m(iUe + 1);
            float f8 = fArr[iUe];
            fArr[iUe] = fArr[iM];
            fArr[iM] = f8;
        }
    }

    @a7.d
    public static final List<Double> ku(@a7.d double[] dArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? kotlin.collections.y.F() : kotlin.collections.o.p(kotlin.collections.o.I1(dArr, indices.d().intValue(), indices.f().intValue() + 1));
    }

    @a7.d
    public static final List<Float> kv(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        Float[] fArrR5 = kotlin.collections.o.r5(fArr);
        Float[] fArr2 = fArrR5;
        kotlin.jvm.internal.l0.n(fArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        kotlin.collections.o.v4(fArr2);
        return kotlin.collections.o.t(fArrR5);
    }

    @a7.d
    public static final List<Integer> kw(@a7.d int[] iArr, @a7.d Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Integer[] numArrS5 = kotlin.collections.o.s5(iArr);
        kotlin.collections.o.I4(numArrS5, comparator);
        return kotlin.collections.o.t(numArrS5);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @kotlin.t0
    @kotlin.internal.f
    private static final int kx(double[] dArr, i5.l<? super Double, Integer> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (double d8 : dArr) {
            iIntValue += selector.z(Double.valueOf(d8)).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final List<Long> ky(@a7.d long[] jArr, int i7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        int length = jArr.length;
        if (i7 >= length) {
            return jz(jArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Long.valueOf(jArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = length - i7; i8 < length; i8++) {
            arrayList.add(Long.valueOf(jArr[i8]));
        }
        return arrayList;
    }

    @a7.d
    public static <T> List<T> kz(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? uz(tArr) : kotlin.collections.x.l(tArr[0]);
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static <T> kotlin.sequences.m<T> l6(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr.length == 0 ? kotlin.sequences.s.g() : new j(tArr);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M l7(@a7.d int[] iArr, @a7.d M destination, @a7.d i5.l<? super Integer, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (int i7 : iArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Integer.valueOf(i7));
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @kotlin.internal.f
    private static final boolean l8(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr[1];
    }

    public static final int l9(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        for (short s7 : sArr) {
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @a7.d
    public static final <V> List<V> lA(@a7.d byte[] bArr, @a7.d byte[] other, @a7.d i5.p<? super Byte, ? super Byte, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Byte.valueOf(bArr[i7]), Byte.valueOf(other[i7])));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Integer> la(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (int i7 : iArr) {
            if (z7) {
                arrayList.add(Integer.valueOf(i7));
            } else if (!predicate.z(Integer.valueOf(i7)).booleanValue()) {
                arrayList.add(Integer.valueOf(i7));
                z7 = true;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final List<Byte> lb(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b8 : bArr) {
            if (!predicate.z(Byte.valueOf(b8)).booleanValue()) {
                arrayList.add(Byte.valueOf(b8));
            }
        }
        return arrayList;
    }

    public static final double lc(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (double d8 : dArr) {
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                return d8;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R, C extends Collection<? super R>> C ld(char[] cArr, C destination, i5.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = cArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), Character.valueOf(cArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    public static final <R> R le(@a7.d int[] iArr, R r7, @a7.d i5.q<? super Integer, ? super Integer, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iVe = Ve(iArr); iVe >= 0; iVe--) {
            r7 = operation.v(Integer.valueOf(iVe), Integer.valueOf(iArr[iVe]), r7);
        }
        return r7;
    }

    @a7.e
    public static final Character lf(@a7.d char[] cArr, int i7) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (i7 < 0 || i7 > Se(cArr)) {
            return null;
        }
        return Character.valueOf(cArr[i7]);
    }

    public static final int lg(@a7.d boolean[] zArr, boolean z7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        int length = zArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (z7 == zArr[i7]) {
                return i7;
            }
        }
        return -1;
    }

    @a7.d
    public static final <T, A extends Appendable> A lh(@a7.d T[] tArr, @a7.d A buffer, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (T t7 : tArr) {
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

    public static int li(@a7.d int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i8 = length - 1;
                if (i7 == iArr[length]) {
                    return length;
                }
                if (i8 >= 0) {
                    length = i8;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final <T, R> List<R> lj(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t7 : tArr) {
            R rZ = transform.z(t7);
            if (rZ != null) {
                arrayList.add(rZ);
            }
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R lk(long[] jArr, i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Long.valueOf(jArr[0]));
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Long.valueOf(jArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Double ll(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dMax = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            dMax = Math.max(dMax, dArr[it.b()]);
        }
        return Double.valueOf(dMax);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> boolean lm(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z7 = zArr[0];
        int iZe = Ze(zArr);
        if (iZe == 0) {
            return z7;
        }
        R rZ = selector.z(Boolean.valueOf(z7));
        u0 it = new kotlin.ranges.k(1, iZe).iterator();
        while (it.hasNext()) {
            boolean z8 = zArr[it.b()];
            R rZ2 = selector.z(Boolean.valueOf(z8));
            if (rZ.compareTo(rZ2) > 0) {
                z7 = z8;
                rZ = rZ2;
            }
        }
        return z7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> Float ln(T[] tArr, i5.l<? super T, Float> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(tArr[0]).floatValue();
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(tArr[it.b()]).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final double lo(@a7.d double[] dArr, @a7.d Comparator<? super Double> comparator) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d8 = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            double d9 = dArr[it.b()];
            if (comparator.compare(Double.valueOf(d8), Double.valueOf(d9)) > 0) {
                d8 = d9;
            }
        }
        return d8;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final byte lp(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return mp(bArr, kotlin.random.f.f34998a);
    }

    public static final short lq(@a7.d short[] sArr, @a7.d i5.q<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (sArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            sShortValue = operation.v(Integer.valueOf(iB), Short.valueOf(sShortValue), Short.valueOf(sArr[iB])).shortValue();
        }
        return sShortValue;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Integer lr(@a7.d int[] iArr, @a7.d i5.p<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iVe = Ve(iArr);
        if (iVe < 0) {
            return null;
        }
        int iIntValue = iArr[iVe];
        for (int i7 = iVe - 1; i7 >= 0; i7--) {
            iIntValue = operation.a0(Integer.valueOf(iArr[i7]), Integer.valueOf(iIntValue)).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> ls(double[] dArr, R r7, i5.q<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r7);
        int length = dArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Double.valueOf(dArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void lt(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        mt(iArr, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final List<Float> lu(@a7.d float[] fArr, @a7.d Iterable<Integer> indices) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        int iZ = kotlin.collections.z.Z(indices, 10);
        if (iZ == 0) {
            return kotlin.collections.y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(fArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Integer> lv(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        Integer[] numArrS5 = kotlin.collections.o.s5(iArr);
        Integer[] numArr = numArrS5;
        kotlin.jvm.internal.l0.n(numArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        kotlin.collections.o.v4(numArr);
        return kotlin.collections.o.t(numArrS5);
    }

    @a7.d
    public static final List<Long> lw(@a7.d long[] jArr, @a7.d Comparator<? super Long> comparator) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Long[] lArrT5 = kotlin.collections.o.t5(jArr);
        kotlin.collections.o.I4(lArrT5, comparator);
        return kotlin.collections.o.t(lArrT5);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @kotlin.t0
    @kotlin.internal.f
    private static final int lx(float[] fArr, i5.l<? super Float, Integer> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (float f8 : fArr) {
            iIntValue += selector.z(Float.valueOf(f8)).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final <T> List<T> ly(@a7.d T[] tArr, int i7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        int length = tArr.length;
        if (i7 >= length) {
            return kz(tArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = length - i7; i8 < length; i8++) {
            arrayList.add(tArr[i8]);
        }
        return arrayList;
    }

    @a7.d
    public static final List<Short> lz(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        int length = sArr.length;
        if (length != 0) {
            return length != 1 ? vz(sArr) : kotlin.collections.x.l(Short.valueOf(sArr[0]));
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final kotlin.sequences.m<Short> m6(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr.length == 0 ? kotlin.sequences.s.g() : new l(sArr);
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M m7(@a7.d long[] jArr, @a7.d M destination, @a7.d i5.l<? super Long, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (long j7 : jArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Long.valueOf(j7));
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @kotlin.internal.f
    private static final byte m8(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr[2];
    }

    @kotlin.internal.f
    private static final int m9(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr.length;
    }

    @a7.d
    public static final <R> List<kotlin.u0<Byte, R>> mA(@a7.d byte[] bArr, @a7.d R[] other) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            byte b8 = bArr[i7];
            arrayList.add(kotlin.p1.a(Byte.valueOf(b8), other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Long> ma(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (long j7 : jArr) {
            if (z7) {
                arrayList.add(Long.valueOf(j7));
            } else if (!predicate.z(Long.valueOf(j7)).booleanValue()) {
                arrayList.add(Long.valueOf(j7));
                z7 = true;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final List<Character> mb(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c8 : cArr) {
            if (!predicate.z(Character.valueOf(c8)).booleanValue()) {
                arrayList.add(Character.valueOf(c8));
            }
        }
        return arrayList;
    }

    public static final float mc(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return fArr[0];
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R, C extends Collection<? super R>> C md(double[] dArr, C destination, i5.p<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = dArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), Double.valueOf(dArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    public static final <R> R me(@a7.d long[] jArr, R r7, @a7.d i5.q<? super Integer, ? super Long, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iWe = We(jArr); iWe >= 0; iWe--) {
            r7 = operation.v(Integer.valueOf(iWe), Long.valueOf(jArr[iWe]), r7);
        }
        return r7;
    }

    @a7.e
    public static final Double mf(@a7.d double[] dArr, int i7) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (i7 < 0 || i7 > Te(dArr)) {
            return null;
        }
        return Double.valueOf(dArr[i7]);
    }

    public static final int mg(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = bArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(Byte.valueOf(bArr[i7])).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    @a7.d
    public static final <A extends Appendable> A mh(@a7.d short[] sArr, @a7.d A buffer, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Short, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (short s7 : sArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.z(Short.valueOf(s7)));
            } else {
                buffer.append(String.valueOf((int) s7));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static int mi(@a7.d long[] jArr, long j7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (j7 == jArr[length]) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C mj(@a7.d T[] tArr, @a7.d C destination, @a7.d i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (T t7 : tArr) {
            R rZ = transform.z(t7);
            if (rZ != null) {
                destination.add(rZ);
            }
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R extends Comparable<? super R>> R mk(T[] tArr, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(tArr[0]);
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(tArr[it.b()]);
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Double ml(@a7.d Double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        u0 it = new kotlin.ranges.k(1, Xe(dArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, dArr[it.b()].doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double mm(byte[] bArr, i5.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Byte.valueOf(bArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Byte.valueOf(bArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float mn(short[] sArr, i5.l<? super Short, Float> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Short.valueOf(sArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Short.valueOf(sArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final float mo(@a7.d float[] fArr, @a7.d Comparator<? super Float> comparator) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f8 = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            float f9 = fArr[it.b()];
            if (comparator.compare(Float.valueOf(f8), Float.valueOf(f9)) > 0) {
                f8 = f9;
            }
        }
        return f8;
    }

    @kotlin.g1(version = "1.3")
    public static final byte mp(@a7.d byte[] bArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (bArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return bArr[random.m(bArr.length)];
    }

    public static final boolean mq(@a7.d boolean[] zArr, @a7.d i5.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (zArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[0];
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            zBooleanValue = operation.v(Integer.valueOf(iB), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[iB])).booleanValue();
        }
        return zBooleanValue;
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Long mr(@a7.d long[] jArr, @a7.d i5.p<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iWe = We(jArr);
        if (iWe < 0) {
            return null;
        }
        long jLongValue = jArr[iWe];
        for (int i7 = iWe - 1; i7 >= 0; i7--) {
            jLongValue = operation.a0(Long.valueOf(jArr[i7]), Long.valueOf(jLongValue)).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> ms(float[] fArr, R r7, i5.q<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r7);
        int length = fArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Float.valueOf(fArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void mt(@a7.d int[] iArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        for (int iVe = Ve(iArr); iVe > 0; iVe--) {
            int iM = random.m(iVe + 1);
            int i7 = iArr[iVe];
            iArr[iVe] = iArr[iM];
            iArr[iM] = i7;
        }
    }

    @a7.d
    public static final List<Float> mu(@a7.d float[] fArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? kotlin.collections.y.F() : kotlin.collections.o.q(kotlin.collections.o.J1(fArr, indices.d().intValue(), indices.f().intValue() + 1));
    }

    @a7.d
    public static final List<Long> mv(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        Long[] lArrT5 = kotlin.collections.o.t5(jArr);
        Long[] lArr = lArrT5;
        kotlin.jvm.internal.l0.n(lArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        kotlin.collections.o.v4(lArr);
        return kotlin.collections.o.t(lArrT5);
    }

    @a7.d
    public static <T> List<T> mw(@a7.d T[] tArr, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return kotlin.collections.o.t(Fv(tArr, comparator));
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @kotlin.t0
    @kotlin.internal.f
    private static final int mx(int[] iArr, i5.l<? super Integer, Integer> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (int i7 : iArr) {
            iIntValue += selector.z(Integer.valueOf(i7)).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final List<Short> my(@a7.d short[] sArr, int i7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        int length = sArr.length;
        if (i7 >= length) {
            return lz(sArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Short.valueOf(sArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = length - i7; i8 < length; i8++) {
            arrayList.add(Short.valueOf(sArr[i8]));
        }
        return arrayList;
    }

    @a7.d
    public static final List<Boolean> mz(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        int length = zArr.length;
        if (length != 0) {
            return length != 1 ? wz(zArr) : kotlin.collections.x.l(Boolean.valueOf(zArr[0]));
        }
        return kotlin.collections.y.F();
    }

    @a7.d
    public static final kotlin.sequences.m<Boolean> n6(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr.length == 0 ? kotlin.sequences.s.g() : new q(zArr);
    }

    @a7.d
    public static final <T, K, V, M extends Map<? super K, ? super V>> M n7(@a7.d T[] tArr, @a7.d M destination, @a7.d i5.l<? super T, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (T t7 : tArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(t7);
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @kotlin.internal.f
    private static final char n8(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr[2];
    }

    public static final int n9(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int i7 = 0;
        for (boolean z7 : zArr) {
            if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    @a7.d
    public static final <R, V> List<V> nA(@a7.d byte[] bArr, @a7.d R[] other, @a7.d i5.p<? super Byte, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Byte.valueOf(bArr[i7]), other[i7]));
        }
        return arrayList;
    }

    @a7.d
    public static final <T> List<T> na(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (T t7 : tArr) {
            if (z7) {
                arrayList.add(t7);
            } else if (!predicate.z(t7).booleanValue()) {
                arrayList.add(t7);
                z7 = true;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final List<Double> nb(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d8 : dArr) {
            if (!predicate.z(Double.valueOf(d8)).booleanValue()) {
                arrayList.add(Double.valueOf(d8));
            }
        }
        return arrayList;
    }

    public static final float nc(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (float f8 : fArr) {
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                return f8;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R, C extends Collection<? super R>> C nd(float[] fArr, C destination, i5.p<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = fArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), Float.valueOf(fArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R ne(@a7.d T[] tArr, R r7, @a7.d i5.q<? super Integer, ? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iXe = Xe(tArr); iXe >= 0; iXe--) {
            r7 = operation.v(Integer.valueOf(iXe), tArr[iXe], r7);
        }
        return r7;
    }

    @a7.e
    public static final Float nf(@a7.d float[] fArr, int i7) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (i7 < 0 || i7 > Ue(fArr)) {
            return null;
        }
        return Float.valueOf(fArr[i7]);
    }

    public static final int ng(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = cArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(Character.valueOf(cArr[i7])).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    @a7.d
    public static final <A extends Appendable> A nh(@a7.d boolean[] zArr, @a7.d A buffer, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Boolean, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        buffer.append(prefix);
        int i8 = 0;
        for (boolean z7 : zArr) {
            i8++;
            if (i8 > 1) {
                buffer.append(separator);
            }
            if (i7 >= 0 && i8 > i7) {
                break;
            }
            if (lVar != null) {
                buffer.append(lVar.z(Boolean.valueOf(z7)));
            } else {
                buffer.append(String.valueOf(z7));
            }
        }
        if (i7 >= 0 && i8 > i7) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> int ni(@a7.d T[] tArr, T t7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (t7 == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i7 = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i7 >= 0) {
                        length = i7;
                    }
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i8 = length2 - 1;
                    if (kotlin.jvm.internal.l0.g(t7, tArr[length2])) {
                        return length2;
                    }
                    if (i8 < 0) {
                        break;
                    }
                    length2 = i8;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C nj(@a7.d byte[] bArr, @a7.d C destination, @a7.d i5.l<? super Byte, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (byte b8 : bArr) {
            destination.add(transform.z(Byte.valueOf(b8)));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R nk(short[] sArr, i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Short.valueOf(sArr[0]));
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Short.valueOf(sArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Float nl(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fMax = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            fMax = Math.max(fMax, fArr[it.b()]);
        }
        return Float.valueOf(fMax);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double nm(char[] cArr, i5.l<? super Character, Double> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Character.valueOf(cArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Character.valueOf(cArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Float nn(boolean[] zArr, i5.l<? super Boolean, Float> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float fFloatValue = selector.z(Boolean.valueOf(zArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Boolean.valueOf(zArr[it.b()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final int no(@a7.d int[] iArr, @a7.d Comparator<? super Integer> comparator) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i7 = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            if (comparator.compare(Integer.valueOf(i7), Integer.valueOf(i8)) > 0) {
                i7 = i8;
            }
        }
        return i7;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final char np(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return op(cArr, kotlin.random.f.f34998a);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Boolean nq(@a7.d boolean[] zArr, @a7.d i5.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            zBooleanValue = operation.v(Integer.valueOf(iB), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[iB])).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final <S, T extends S> S nr(@a7.d T[] tArr, @a7.d i5.p<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iXe = Xe(tArr);
        if (iXe < 0) {
            return null;
        }
        S sA0 = (S) tArr[iXe];
        for (int i7 = iXe - 1; i7 >= 0; i7--) {
            sA0 = operation.a0((Object) tArr[i7], sA0);
        }
        return sA0;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> ns(int[] iArr, R r7, i5.q<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r7);
        int length = iArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Integer.valueOf(iArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void nt(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        ot(jArr, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final List<Integer> nu(@a7.d int[] iArr, @a7.d Iterable<Integer> indices) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        int iZ = kotlin.collections.z.Z(indices, 10);
        if (iZ == 0) {
            return kotlin.collections.y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(iArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @a7.d
    public static final <T extends Comparable<? super T>> List<T> nv(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return kotlin.collections.o.t(vv(tArr));
    }

    @a7.d
    public static final List<Short> nw(@a7.d short[] sArr, @a7.d Comparator<? super Short> comparator) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Short[] shArrU5 = kotlin.collections.o.u5(sArr);
        kotlin.collections.o.I4(shArrU5, comparator);
        return kotlin.collections.o.t(shArrU5);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @kotlin.t0
    @kotlin.internal.f
    private static final int nx(long[] jArr, i5.l<? super Long, Integer> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (long j7 : jArr) {
            iIntValue += selector.z(Long.valueOf(j7)).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final List<Boolean> ny(@a7.d boolean[] zArr, int i7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
        }
        if (i7 == 0) {
            return kotlin.collections.y.F();
        }
        int length = zArr.length;
        if (i7 >= length) {
            return mz(zArr);
        }
        if (i7 == 1) {
            return kotlin.collections.x.l(Boolean.valueOf(zArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = length - i7; i8 < length; i8++) {
            arrayList.add(Boolean.valueOf(zArr[i8]));
        }
        return arrayList;
    }

    @a7.d
    public static final long[] nz(@a7.d Long[] lArr) {
        kotlin.jvm.internal.l0.p(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i7 = 0; i7 < length; i7++) {
            jArr[i7] = lArr[i7].longValue();
        }
        return jArr;
    }

    @a7.d
    public static final <K, V> Map<K, V> o6(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(bArr.length), 16));
        for (byte b8 : bArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Byte.valueOf(b8));
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M o7(@a7.d short[] sArr, @a7.d M destination, @a7.d i5.l<? super Short, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (short s7 : sArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Short.valueOf(s7));
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @kotlin.internal.f
    private static final double o8(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr[2];
    }

    @a7.d
    public static final List<Byte> o9(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return g0.Q5(xz(bArr));
    }

    @a7.d
    public static final <R> List<kotlin.u0<Character, R>> oA(@a7.d char[] cArr, @a7.d Iterable<? extends R> other) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(kotlin.p1.a(Character.valueOf(cArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final List<Short> oa(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (short s7 : sArr) {
            if (z7) {
                arrayList.add(Short.valueOf(s7));
            } else if (!predicate.z(Short.valueOf(s7)).booleanValue()) {
                arrayList.add(Short.valueOf(s7));
                z7 = true;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final List<Float> ob(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f8 : fArr) {
            if (!predicate.z(Float.valueOf(f8)).booleanValue()) {
                arrayList.add(Float.valueOf(f8));
            }
        }
        return arrayList;
    }

    public static int oc(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[0];
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R, C extends Collection<? super R>> C od(int[] iArr, C destination, i5.p<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = iArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), Integer.valueOf(iArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    public static final <R> R oe(@a7.d short[] sArr, R r7, @a7.d i5.q<? super Integer, ? super Short, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iYe = Ye(sArr); iYe >= 0; iYe--) {
            r7 = operation.v(Integer.valueOf(iYe), Short.valueOf(sArr[iYe]), r7);
        }
        return r7;
    }

    @a7.e
    public static final Integer of(@a7.d int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (i7 < 0 || i7 > Ve(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i7]);
    }

    public static final int og(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = dArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(Double.valueOf(dArr[i7])).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    public static int oi(@a7.d short[] sArr, short s7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (s7 == sArr[length]) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C oj(@a7.d char[] cArr, @a7.d C destination, @a7.d i5.l<? super Character, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (char c8 : cArr) {
            destination.add(transform.z(Character.valueOf(c8)));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R ok(boolean[] zArr, i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Boolean.valueOf(zArr[0]));
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Boolean.valueOf(zArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Float ol(@a7.d Float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        u0 it = new kotlin.ranges.k(1, Xe(fArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, fArr[it.b()].floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double om(double[] dArr, i5.l<? super Double, Double> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Double.valueOf(dArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Double.valueOf(dArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R on(byte[] bArr, Comparator<? super R> comparator, i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Byte.valueOf(bArr[0]));
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Byte.valueOf(bArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final long oo(@a7.d long[] jArr, @a7.d Comparator<? super Long> comparator) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j7 = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            if (comparator.compare(Long.valueOf(j7), Long.valueOf(j8)) > 0) {
                j7 = j8;
            }
        }
        return j7;
    }

    @kotlin.g1(version = "1.3")
    public static final char op(@a7.d char[] cArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (cArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return cArr[random.m(cArr.length)];
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Byte oq(@a7.d byte[] bArr, @a7.d i5.q<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            bByteValue = operation.v(Integer.valueOf(iB), Byte.valueOf(bByteValue), Byte.valueOf(bArr[iB])).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Short or(@a7.d short[] sArr, @a7.d i5.p<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        int iYe = Ye(sArr);
        if (iYe < 0) {
            return null;
        }
        short sShortValue = sArr[iYe];
        for (int i7 = iYe - 1; i7 >= 0; i7--) {
            sShortValue = operation.a0(Short.valueOf(sArr[i7]), Short.valueOf(sShortValue)).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> os(long[] jArr, R r7, i5.q<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r7);
        int length = jArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Long.valueOf(jArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void ot(@a7.d long[] jArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        for (int iWe = We(jArr); iWe > 0; iWe--) {
            int iM = random.m(iWe + 1);
            long j7 = jArr[iWe];
            jArr[iWe] = jArr[iM];
            jArr[iM] = j7;
        }
    }

    @a7.d
    public static final List<Integer> ou(@a7.d int[] iArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? kotlin.collections.y.F() : kotlin.collections.o.r(kotlin.collections.o.K1(iArr, indices.d().intValue(), indices.f().intValue() + 1));
    }

    @a7.d
    public static final List<Short> ov(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        Short[] shArrU5 = kotlin.collections.o.u5(sArr);
        Short[] shArr = shArrU5;
        kotlin.jvm.internal.l0.n(shArr, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        kotlin.collections.o.v4(shArr);
        return kotlin.collections.o.t(shArrU5);
    }

    @a7.d
    public static final List<Boolean> ow(@a7.d boolean[] zArr, @a7.d Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Boolean[] boolArrN5 = kotlin.collections.o.n5(zArr);
        kotlin.collections.o.I4(boolArrN5, comparator);
        return kotlin.collections.o.t(boolArrN5);
    }

    @h5.h(name = "sumOfInt")
    public static final int ox(@a7.d Integer[] numArr) {
        kotlin.jvm.internal.l0.p(numArr, "<this>");
        int iIntValue = 0;
        for (Integer num : numArr) {
            iIntValue += num.intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final List<Byte> oy(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iRe = Re(bArr); -1 < iRe; iRe--) {
            if (!predicate.z(Byte.valueOf(bArr[iRe])).booleanValue()) {
                return G9(bArr, iRe + 1);
            }
        }
        return ez(bArr);
    }

    @a7.d
    public static final List<Byte> oz(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b8 : bArr) {
            arrayList.add(Byte.valueOf(b8));
        }
        return arrayList;
    }

    @a7.d
    public static final <K, V> Map<K, V> p6(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(cArr.length), 16));
        for (char c8 : cArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Character.valueOf(c8));
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    @a7.d
    public static final <K, V, M extends Map<? super K, ? super V>> M p7(@a7.d boolean[] zArr, @a7.d M destination, @a7.d i5.l<? super Boolean, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (boolean z7 : zArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Boolean.valueOf(z7));
            destination.put(u0VarZ.e(), u0VarZ.f());
        }
        return destination;
    }

    @kotlin.internal.f
    private static final float p8(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr[2];
    }

    @a7.d
    public static final List<Character> p9(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return g0.Q5(yz(cArr));
    }

    @a7.d
    public static final <R, V> List<V> pA(@a7.d char[] cArr, @a7.d Iterable<? extends R> other, @a7.d i5.p<? super Character, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(transform.a0(Character.valueOf(cArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @a7.d
    public static final List<Boolean> pa(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (boolean z8 : zArr) {
            if (z7) {
                arrayList.add(Boolean.valueOf(z8));
            } else if (!predicate.z(Boolean.valueOf(z8)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z8));
                z7 = true;
            }
        }
        return arrayList;
    }

    @a7.d
    public static final List<Integer> pb(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i7 : iArr) {
            if (!predicate.z(Integer.valueOf(i7)).booleanValue()) {
                arrayList.add(Integer.valueOf(i7));
            }
        }
        return arrayList;
    }

    public static final int pc(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int i7 : iArr) {
            if (predicate.z(Integer.valueOf(i7)).booleanValue()) {
                return i7;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R, C extends Collection<? super R>> C pd(long[] jArr, C destination, i5.p<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = jArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), Long.valueOf(jArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    public static final <R> R pe(@a7.d boolean[] zArr, R r7, @a7.d i5.q<? super Integer, ? super Boolean, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        for (int iZe = Ze(zArr); iZe >= 0; iZe--) {
            r7 = operation.v(Integer.valueOf(iZe), Boolean.valueOf(zArr[iZe]), r7);
        }
        return r7;
    }

    @a7.e
    public static final Long pf(@a7.d long[] jArr, int i7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (i7 < 0 || i7 > We(jArr)) {
            return null;
        }
        return Long.valueOf(jArr[i7]);
    }

    public static final int pg(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = fArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(Float.valueOf(fArr[i7])).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    public static final int pi(@a7.d boolean[] zArr, boolean z7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (z7 == zArr[length]) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C pj(@a7.d double[] dArr, @a7.d C destination, @a7.d i5.l<? super Double, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (double d8 : dArr) {
            destination.add(transform.z(Double.valueOf(d8)));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R pk(byte[] bArr, i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Byte.valueOf(bArr[0]));
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Byte.valueOf(bArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Integer pl(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i7 = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            if (i7 < i8) {
                i7 = i8;
            }
        }
        return Integer.valueOf(i7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double pm(float[] fArr, i5.l<? super Float, Double> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Float.valueOf(fArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Float.valueOf(fArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R pn(char[] cArr, Comparator<? super R> comparator, i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Character.valueOf(cArr[0]));
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(cArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final <T> T po(@a7.d T[] tArr, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t7 = tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            T t8 = tArr[it.b()];
            if (comparator.compare(t7, t8) > 0) {
                t7 = t8;
            }
        }
        return t7;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final double pp(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return qp(dArr, kotlin.random.f.f34998a);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Character pq(@a7.d char[] cArr, @a7.d i5.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            cCharValue = operation.v(Integer.valueOf(iB), Character.valueOf(cCharValue), Character.valueOf(cArr[iB])).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    @a7.d
    public static final <T> T[] pr(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        for (T t7 : tArr) {
            if (t7 == null) {
                throw new IllegalArgumentException("null element found in " + tArr + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
        }
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <T, R> List<R> ps(@a7.d T[] tArr, R r7, @a7.d i5.q<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r7);
        int length = tArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, tArr[i7]);
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final <T> void pt(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        qt(tArr, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final List<Long> pu(@a7.d long[] jArr, @a7.d Iterable<Integer> indices) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        int iZ = kotlin.collections.z.Z(indices, 10);
        if (iZ == 0) {
            return kotlin.collections.y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(jArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @a7.d
    public static final byte[] pv(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.l0.o(bArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.h4(bArrCopyOf);
        return bArrCopyOf;
    }

    @a7.d
    public static final Set<Byte> pw(@a7.d byte[] bArr, @a7.d Iterable<Byte> other) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Byte> setXz = xz(bArr);
        d0.E0(setXz, other);
        return setXz;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T> int px(T[] tArr, i5.l<? super T, Integer> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (T t7 : tArr) {
            iIntValue += selector.z(t7).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final List<Character> py(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iSe = Se(cArr); -1 < iSe; iSe--) {
            if (!predicate.z(Character.valueOf(cArr[iSe])).booleanValue()) {
                return H9(cArr, iSe + 1);
            }
        }
        return fz(cArr);
    }

    @a7.d
    public static final List<Character> pz(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c8 : cArr) {
            arrayList.add(Character.valueOf(c8));
        }
        return arrayList;
    }

    @a7.d
    public static final <K, V> Map<K, V> q6(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(dArr.length), 16));
        for (double d8 : dArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Double.valueOf(d8));
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V> Map<Byte, V> q7(byte[] bArr, i5.l<? super Byte, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(bArr.length), 16));
        for (byte b8 : bArr) {
            linkedHashMap.put(Byte.valueOf(b8), valueSelector.z(Byte.valueOf(b8)));
        }
        return linkedHashMap;
    }

    @kotlin.internal.f
    private static final int q8(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr[2];
    }

    @a7.d
    public static final List<Double> q9(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return g0.Q5(zz(dArr));
    }

    @a7.d
    public static final List<kotlin.u0<Character, Character>> qA(@a7.d char[] cArr, @a7.d char[] other) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(kotlin.p1.a(Character.valueOf(cArr[i7]), Character.valueOf(other[i7])));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final byte qa(byte[] bArr, int i7, i5.l<? super Integer, Byte> defaultValue) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Re(bArr)) ? defaultValue.z(Integer.valueOf(i7)).byteValue() : bArr[i7];
    }

    @a7.d
    public static final List<Long> qb(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j7 : jArr) {
            if (!predicate.z(Long.valueOf(j7)).booleanValue()) {
                arrayList.add(Long.valueOf(j7));
            }
        }
        return arrayList;
    }

    public static long qc(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return jArr[0];
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T, R, C extends Collection<? super R>> C qd(T[] tArr, C destination, i5.p<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), tArr[i7]));
            i7++;
            i8++;
        }
        return destination;
    }

    public static final void qe(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, l2> action) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (byte b8 : bArr) {
            action.z(Byte.valueOf(b8));
        }
    }

    @a7.e
    public static <T> T qf(@a7.d T[] tArr, int i7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (i7 < 0 || i7 > Xe(tArr)) {
            return null;
        }
        return tArr[i7];
    }

    public static final int qg(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = iArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(Integer.valueOf(iArr[i7])).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    @a7.e
    public static final Boolean qi(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C qj(@a7.d float[] fArr, @a7.d C destination, @a7.d i5.l<? super Float, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (float f8 : fArr) {
            destination.add(transform.z(Float.valueOf(f8)));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R qk(char[] cArr, i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Character.valueOf(cArr[0]));
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(cArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Long ql(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j7 = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            if (j7 < j8) {
                j7 = j8;
            }
        }
        return Long.valueOf(j7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double qm(int[] iArr, i5.l<? super Integer, Double> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Integer.valueOf(iArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Integer.valueOf(iArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R qn(double[] dArr, Comparator<? super R> comparator, i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Double.valueOf(dArr[0]));
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Double.valueOf(dArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final short qo(@a7.d short[] sArr, @a7.d Comparator<? super Short> comparator) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s7 = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            if (comparator.compare(Short.valueOf(s7), Short.valueOf(s8)) > 0) {
                s7 = s8;
            }
        }
        return s7;
    }

    @kotlin.g1(version = "1.3")
    public static final double qp(@a7.d double[] dArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (dArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return dArr[random.m(dArr.length)];
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Double qq(@a7.d double[] dArr, @a7.d i5.q<? super Integer, ? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            dDoubleValue = operation.v(Integer.valueOf(iB), Double.valueOf(dDoubleValue), Double.valueOf(dArr[iB])).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    public static void qr(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        int length = (bArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iRe = Re(bArr);
        u0 it = new kotlin.ranges.k(0, length).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            byte b8 = bArr[iB];
            bArr[iB] = bArr[iRe];
            bArr[iRe] = b8;
            iRe--;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> qs(short[] sArr, R r7, i5.q<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r7);
        int length = sArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Short.valueOf(sArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final <T> void qt(@a7.d T[] tArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        for (int iXe = Xe(tArr); iXe > 0; iXe--) {
            int iM = random.m(iXe + 1);
            T t7 = tArr[iXe];
            tArr[iXe] = tArr[iM];
            tArr[iM] = t7;
        }
    }

    @a7.d
    public static final List<Long> qu(@a7.d long[] jArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? kotlin.collections.y.F() : kotlin.collections.o.s(kotlin.collections.o.L1(jArr, indices.d().intValue(), indices.f().intValue() + 1));
    }

    @a7.d
    public static final char[] qv(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.l0.o(cArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.j4(cArrCopyOf);
        return cArrCopyOf;
    }

    @a7.d
    public static final Set<Character> qw(@a7.d char[] cArr, @a7.d Iterable<Character> other) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Character> setYz = yz(cArr);
        d0.E0(setYz, other);
        return setYz;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @kotlin.t0
    @kotlin.internal.f
    private static final int qx(short[] sArr, i5.l<? super Short, Integer> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (short s7 : sArr) {
            iIntValue += selector.z(Short.valueOf(s7)).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final List<Double> qy(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iTe = Te(dArr); -1 < iTe; iTe--) {
            if (!predicate.z(Double.valueOf(dArr[iTe])).booleanValue()) {
                return I9(dArr, iTe + 1);
            }
        }
        return gz(dArr);
    }

    @a7.d
    public static final List<Double> qz(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d8 : dArr) {
            arrayList.add(Double.valueOf(d8));
        }
        return arrayList;
    }

    @a7.d
    public static final <K, V> Map<K, V> r6(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(fArr.length), 16));
        for (float f8 : fArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Float.valueOf(f8));
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V> Map<Character, V> r7(char[] cArr, i5.l<? super Character, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(kotlin.ranges.q.u(cArr.length, 128)), 16));
        for (char c8 : cArr) {
            linkedHashMap.put(Character.valueOf(c8), valueSelector.z(Character.valueOf(c8)));
        }
        return linkedHashMap;
    }

    @kotlin.internal.f
    private static final long r8(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr[2];
    }

    @a7.d
    public static final List<Float> r9(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return g0.Q5(Az(fArr));
    }

    @a7.d
    public static final <V> List<V> rA(@a7.d char[] cArr, @a7.d char[] other, @a7.d i5.p<? super Character, ? super Character, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Character.valueOf(cArr[i7]), Character.valueOf(other[i7])));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final char ra(char[] cArr, int i7, i5.l<? super Integer, Character> defaultValue) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Se(cArr)) ? defaultValue.z(Integer.valueOf(i7)).charValue() : cArr[i7];
    }

    @a7.d
    public static final <T> List<T> rb(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t7 : tArr) {
            if (!predicate.z(t7).booleanValue()) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    public static final long rc(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (long j7 : jArr) {
            if (predicate.z(Long.valueOf(j7)).booleanValue()) {
                return j7;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R, C extends Collection<? super R>> C rd(short[] sArr, C destination, i5.p<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = sArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), Short.valueOf(sArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    public static final void re(@a7.d char[] cArr, @a7.d i5.l<? super Character, l2> action) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (char c8 : cArr) {
            action.z(Character.valueOf(c8));
        }
    }

    @a7.e
    public static final Short rf(@a7.d short[] sArr, int i7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (i7 < 0 || i7 > Ye(sArr)) {
            return null;
        }
        return Short.valueOf(sArr[i7]);
    }

    public static final int rg(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = jArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(Long.valueOf(jArr[i7])).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    @a7.e
    public static final Boolean ri(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i7 = length - 1;
            boolean z7 = zArr[length];
            if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                return Boolean.valueOf(z7);
            }
            if (i7 < 0) {
                return null;
            }
            length = i7;
        }
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C rj(@a7.d int[] iArr, @a7.d C destination, @a7.d i5.l<? super Integer, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (int i7 : iArr) {
            destination.add(transform.z(Integer.valueOf(i7)));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R rk(double[] dArr, i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Double.valueOf(dArr[0]));
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Double.valueOf(dArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Short rl(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s7 = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            short s8 = sArr[it.b()];
            if (s7 < s8) {
                s7 = s8;
            }
        }
        return Short.valueOf(s7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double rm(long[] jArr, i5.l<? super Long, Double> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Long.valueOf(jArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Long.valueOf(jArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R rn(float[] fArr, Comparator<? super R> comparator, i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Float.valueOf(fArr[0]));
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Float.valueOf(fArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "minWithOrThrow")
    public static final boolean ro(@a7.d boolean[] zArr, @a7.d Comparator<? super Boolean> comparator) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z7 = zArr[0];
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            boolean z8 = zArr[it.b()];
            if (comparator.compare(Boolean.valueOf(z7), Boolean.valueOf(z8)) > 0) {
                z7 = z8;
            }
        }
        return z7;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final float rp(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return sp(fArr, kotlin.random.f.f34998a);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Float rq(@a7.d float[] fArr, @a7.d i5.q<? super Integer, ? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            fFloatValue = operation.v(Integer.valueOf(iB), Float.valueOf(fFloatValue), Float.valueOf(fArr[iB])).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    @kotlin.g1(version = "1.4")
    public static void rr(@a7.d byte[] bArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.collections.c.f34509a.d(i7, i8, bArr.length);
        int i9 = (i7 + i8) / 2;
        if (i7 == i9) {
            return;
        }
        int i10 = i8 - 1;
        while (i7 < i9) {
            byte b8 = bArr[i7];
            bArr[i7] = bArr[i10];
            bArr[i10] = b8;
            i10--;
            i7++;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <R> List<R> rs(boolean[] zArr, R r7, i5.q<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (zArr.length == 0) {
            return kotlin.collections.x.l(r7);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r7);
        int length = zArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            r7 = operation.v(Integer.valueOf(i7), r7, Boolean.valueOf(zArr[i7]));
            arrayList.add(r7);
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void rt(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        st(sArr, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final <T> List<T> ru(@a7.d T[] tArr, @a7.d Iterable<Integer> indices) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        int iZ = kotlin.collections.z.Z(indices, 10);
        if (iZ == 0) {
            return kotlin.collections.y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(tArr[it.next().intValue()]);
        }
        return arrayList;
    }

    @a7.d
    public static final double[] rv(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.l0.o(dArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.l4(dArrCopyOf);
        return dArrCopyOf;
    }

    @a7.d
    public static final Set<Double> rw(@a7.d double[] dArr, @a7.d Iterable<Double> other) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Double> setZz = zz(dArr);
        d0.E0(setZz, other);
        return setZz;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfInt")
    @kotlin.t0
    @kotlin.internal.f
    private static final int rx(boolean[] zArr, i5.l<? super Boolean, Integer> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        int iIntValue = 0;
        for (boolean z7 : zArr) {
            iIntValue += selector.z(Boolean.valueOf(z7)).intValue();
        }
        return iIntValue;
    }

    @a7.d
    public static final List<Float> ry(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iUe = Ue(fArr); -1 < iUe; iUe--) {
            if (!predicate.z(Float.valueOf(fArr[iUe])).booleanValue()) {
                return J9(fArr, iUe + 1);
            }
        }
        return hz(fArr);
    }

    @a7.d
    public static final List<Float> rz(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f8 : fArr) {
            arrayList.add(Float.valueOf(f8));
        }
        return arrayList;
    }

    @a7.d
    public static final <K, V> Map<K, V> s6(@a7.d int[] iArr, @a7.d i5.l<? super Integer, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(iArr.length), 16));
        for (int i7 : iArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Integer.valueOf(i7));
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V> Map<Double, V> s7(double[] dArr, i5.l<? super Double, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(dArr.length), 16));
        for (double d8 : dArr) {
            linkedHashMap.put(Double.valueOf(d8), valueSelector.z(Double.valueOf(d8)));
        }
        return linkedHashMap;
    }

    @kotlin.internal.f
    private static final <T> T s8(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr[2];
    }

    @a7.d
    public static final List<Integer> s9(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return g0.Q5(Bz(iArr));
    }

    @a7.d
    public static final <R> List<kotlin.u0<Character, R>> sA(@a7.d char[] cArr, @a7.d R[] other) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            char c8 = cArr[i7];
            arrayList.add(kotlin.p1.a(Character.valueOf(c8), other[i7]));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final double sa(double[] dArr, int i7, i5.l<? super Integer, Double> defaultValue) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Te(dArr)) ? defaultValue.z(Integer.valueOf(i7)).doubleValue() : dArr[i7];
    }

    @a7.d
    public static final List<Short> sb(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s7 : sArr) {
            if (!predicate.z(Short.valueOf(s7)).booleanValue()) {
                arrayList.add(Short.valueOf(s7));
            }
        }
        return arrayList;
    }

    public static final <T> T sc(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[0];
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedIterableTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <R, C extends Collection<? super R>> C sd(boolean[] zArr, C destination, i5.p<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = zArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.o0(destination, transform.a0(Integer.valueOf(i8), Boolean.valueOf(zArr[i7])));
            i7++;
            i8++;
        }
        return destination;
    }

    public static final void se(@a7.d double[] dArr, @a7.d i5.l<? super Double, l2> action) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (double d8 : dArr) {
            action.z(Double.valueOf(d8));
        }
    }

    @a7.d
    public static final <K> Map<K, List<Byte>> sf(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b8 : bArr) {
            K kZ = keySelector.z(Byte.valueOf(b8));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(Byte.valueOf(b8));
        }
        return linkedHashMap;
    }

    public static final <T> int sg(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = tArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(tArr[i7]).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    @a7.e
    public static final Byte si(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C sj(@a7.d long[] jArr, @a7.d C destination, @a7.d i5.l<? super Long, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (long j7 : jArr) {
            destination.add(transform.z(Long.valueOf(j7)));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R sk(float[] fArr, i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Float.valueOf(fArr[0]));
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Float.valueOf(fArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final byte sl(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b8 = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            if (b8 < b9) {
                b8 = b9;
            }
        }
        return b8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T> double sm(T[] tArr, i5.l<? super T, Double> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(tArr[0]).doubleValue();
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(tArr[it.b()]).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R sn(int[] iArr, Comparator<? super R> comparator, i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Integer.valueOf(iArr[0]));
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Integer.valueOf(iArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean so(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr.length == 0;
    }

    @kotlin.g1(version = "1.3")
    public static final float sp(@a7.d float[] fArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (fArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return fArr[random.m(fArr.length)];
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Integer sq(@a7.d int[] iArr, @a7.d i5.q<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            iIntValue = operation.v(Integer.valueOf(iB), Integer.valueOf(iIntValue), Integer.valueOf(iArr[iB])).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public static final void sr(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        int length = (cArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iSe = Se(cArr);
        u0 it = new kotlin.ranges.k(0, length).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            char c8 = cArr[iB];
            cArr[iB] = cArr[iSe];
            cArr[iSe] = c8;
            iSe--;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Byte> ss(byte[] bArr, i5.p<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (bArr.length == 0) {
            return kotlin.collections.y.F();
        }
        byte bByteValue = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(bByteValue));
        int length = bArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            bByteValue = operation.a0(Byte.valueOf(bByteValue), Byte.valueOf(bArr[i7])).byteValue();
            arrayList.add(Byte.valueOf(bByteValue));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void st(@a7.d short[] sArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        for (int iYe = Ye(sArr); iYe > 0; iYe--) {
            int iM = random.m(iYe + 1);
            short s7 = sArr[iYe];
            sArr[iYe] = sArr[iM];
            sArr[iM] = s7;
        }
    }

    @a7.d
    public static final <T> List<T> su(@a7.d T[] tArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? kotlin.collections.y.F() : kotlin.collections.o.t(kotlin.collections.o.M1(tArr, indices.d().intValue(), indices.f().intValue() + 1));
    }

    @a7.d
    public static final float[] sv(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.l0.o(fArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.n4(fArrCopyOf);
        return fArrCopyOf;
    }

    @a7.d
    public static final Set<Float> sw(@a7.d float[] fArr, @a7.d Iterable<Float> other) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Float> setAz = Az(fArr);
        d0.E0(setAz, other);
        return setAz;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @kotlin.t0
    @kotlin.internal.f
    private static final long sx(byte[] bArr, i5.l<? super Byte, Long> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jLongValue = 0;
        for (byte b8 : bArr) {
            jLongValue += selector.z(Byte.valueOf(b8)).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final List<Integer> sy(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iVe = Ve(iArr); -1 < iVe; iVe--) {
            if (!predicate.z(Integer.valueOf(iArr[iVe])).booleanValue()) {
                return K9(iArr, iVe + 1);
            }
        }
        return iz(iArr);
    }

    @a7.d
    public static final List<Integer> sz(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i7 : iArr) {
            arrayList.add(Integer.valueOf(i7));
        }
        return arrayList;
    }

    @a7.d
    public static final <K, V> Map<K, V> t6(@a7.d long[] jArr, @a7.d i5.l<? super Long, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(jArr.length), 16));
        for (long j7 : jArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Long.valueOf(j7));
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V> Map<Float, V> t7(float[] fArr, i5.l<? super Float, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(fArr.length), 16));
        for (float f8 : fArr) {
            linkedHashMap.put(Float.valueOf(f8), valueSelector.z(Float.valueOf(f8)));
        }
        return linkedHashMap;
    }

    @kotlin.internal.f
    private static final short t8(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr[2];
    }

    @a7.d
    public static final List<Long> t9(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return g0.Q5(Cz(jArr));
    }

    @a7.d
    public static final <R, V> List<V> tA(@a7.d char[] cArr, @a7.d R[] other, @a7.d i5.p<? super Character, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Character.valueOf(cArr[i7]), other[i7]));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final float ta(float[] fArr, int i7, i5.l<? super Integer, Float> defaultValue) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Ue(fArr)) ? defaultValue.z(Integer.valueOf(i7)).floatValue() : fArr[i7];
    }

    @a7.d
    public static final List<Boolean> tb(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z7 : zArr) {
            if (!predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z7));
            }
        }
        return arrayList;
    }

    public static final <T> T tc(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (T t7 : tArr) {
            if (predicate.z(t7).booleanValue()) {
                return t7;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedSequence")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T, R> List<R> td(T[] tArr, i5.p<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.p0(arrayList, transform.a0(Integer.valueOf(i8), tArr[i7]));
            i7++;
            i8++;
        }
        return arrayList;
    }

    public static final void te(@a7.d float[] fArr, @a7.d i5.l<? super Float, l2> action) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (float f8 : fArr) {
            action.z(Float.valueOf(f8));
        }
    }

    @a7.d
    public static final <K, V> Map<K, List<V>> tf(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends K> keySelector, @a7.d i5.l<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b8 : bArr) {
            K kZ = keySelector.z(Byte.valueOf(b8));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(Byte.valueOf(b8)));
        }
        return linkedHashMap;
    }

    public static final int tg(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = sArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(Short.valueOf(sArr[i7])).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    @a7.e
    public static final Byte ti(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i7 = length - 1;
            byte b8 = bArr[length];
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                return Byte.valueOf(b8);
            }
            if (i7 < 0) {
                return null;
            }
            length = i7;
        }
    }

    @a7.d
    public static final <T, R, C extends Collection<? super R>> C tj(@a7.d T[] tArr, @a7.d C destination, @a7.d i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (T t7 : tArr) {
            destination.add(transform.z(t7));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R tk(int[] iArr, i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Integer.valueOf(iArr[0]));
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Integer.valueOf(iArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final char tl(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c8 = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            if (kotlin.jvm.internal.l0.t(c8, c9) < 0) {
                c8 = c9;
            }
        }
        return c8;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double tm(short[] sArr, i5.l<? super Short, Double> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Short.valueOf(sArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Short.valueOf(sArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R tn(long[] jArr, Comparator<? super R> comparator, i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Long.valueOf(jArr[0]));
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Long.valueOf(jArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean to(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (byte b8 : bArr) {
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final int tp(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return up(iArr, kotlin.random.f.f34998a);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Long tq(@a7.d long[] jArr, @a7.d i5.q<? super Integer, ? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            jLongValue = operation.v(Integer.valueOf(iB), Long.valueOf(jLongValue), Long.valueOf(jArr[iB])).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    @kotlin.g1(version = "1.4")
    public static final void tr(@a7.d char[] cArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.collections.c.f34509a.d(i7, i8, cArr.length);
        int i9 = (i7 + i8) / 2;
        if (i7 == i9) {
            return;
        }
        int i10 = i8 - 1;
        while (i7 < i9) {
            char c8 = cArr[i7];
            cArr[i7] = cArr[i10];
            cArr[i10] = c8;
            i10--;
            i7++;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Character> ts(char[] cArr, i5.p<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (cArr.length == 0) {
            return kotlin.collections.y.F();
        }
        char cCharValue = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(cCharValue));
        int length = cArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            cCharValue = operation.a0(Character.valueOf(cCharValue), Character.valueOf(cArr[i7])).charValue();
            arrayList.add(Character.valueOf(cCharValue));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void tt(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        ut(zArr, kotlin.random.f.f34998a);
    }

    @a7.d
    public static final List<Short> tu(@a7.d short[] sArr, @a7.d Iterable<Integer> indices) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        int iZ = kotlin.collections.z.Z(indices, 10);
        if (iZ == 0) {
            return kotlin.collections.y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Short.valueOf(sArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @a7.d
    public static final int[] tv(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.l0.o(iArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.p4(iArrCopyOf);
        return iArrCopyOf;
    }

    @a7.d
    public static final Set<Integer> tw(@a7.d int[] iArr, @a7.d Iterable<Integer> other) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Integer> setBz = Bz(iArr);
        d0.E0(setBz, other);
        return setBz;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @kotlin.t0
    @kotlin.internal.f
    private static final long tx(char[] cArr, i5.l<? super Character, Long> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jLongValue = 0;
        for (char c8 : cArr) {
            jLongValue += selector.z(Character.valueOf(c8)).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final List<Long> ty(@a7.d long[] jArr, @a7.d i5.l<? super Long, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iWe = We(jArr); -1 < iWe; iWe--) {
            if (!predicate.z(Long.valueOf(jArr[iWe])).booleanValue()) {
                return L9(jArr, iWe + 1);
            }
        }
        return jz(jArr);
    }

    @a7.d
    public static final List<Long> tz(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j7 : jArr) {
            arrayList.add(Long.valueOf(j7));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T, K, V> Map<K, V> u6(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(tArr.length), 16));
        for (a1.c cVar : tArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(cVar);
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V> Map<Integer, V> u7(int[] iArr, i5.l<? super Integer, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(iArr.length), 16));
        for (int i7 : iArr) {
            linkedHashMap.put(Integer.valueOf(i7), valueSelector.z(Integer.valueOf(i7)));
        }
        return linkedHashMap;
    }

    @kotlin.internal.f
    private static final boolean u8(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr[2];
    }

    @a7.d
    public static final <T> List<T> u9(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return g0.Q5(Dz(tArr));
    }

    @a7.d
    public static final <R> List<kotlin.u0<Double, R>> uA(@a7.d double[] dArr, @a7.d Iterable<? extends R> other) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(kotlin.p1.a(Double.valueOf(dArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final int ua(int[] iArr, int i7, i5.l<? super Integer, Integer> defaultValue) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Ve(iArr)) ? defaultValue.z(Integer.valueOf(i7)).intValue() : iArr[i7];
    }

    @a7.d
    public static <T> List<T> ub(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return (List) vb(tArr, new ArrayList());
    }

    public static short uc(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return sArr[0];
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapIndexedSequenceTo")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T, R, C extends Collection<? super R>> C ud(T[] tArr, C destination, i5.p<? super Integer, ? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = tArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            d0.p0(destination, transform.a0(Integer.valueOf(i8), tArr[i7]));
            i7++;
            i8++;
        }
        return destination;
    }

    public static final void ue(@a7.d int[] iArr, @a7.d i5.l<? super Integer, l2> action) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (int i7 : iArr) {
            action.z(Integer.valueOf(i7));
        }
    }

    @a7.d
    public static final <K> Map<K, List<Character>> uf(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c8 : cArr) {
            K kZ = keySelector.z(Character.valueOf(c8));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(c8));
        }
        return linkedHashMap;
    }

    public static final int ug(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = zArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (predicate.z(Boolean.valueOf(zArr[i7])).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    @a7.e
    public static final Character ui(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C uj(@a7.d short[] sArr, @a7.d C destination, @a7.d i5.l<? super Short, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (short s7 : sArr) {
            destination.add(transform.z(Short.valueOf(s7)));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R uk(long[] jArr, i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Long.valueOf(jArr[0]));
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Long.valueOf(jArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final double ul(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dMax = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            dMax = Math.max(dMax, dArr[it.b()]);
        }
        return dMax;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final double um(boolean[] zArr, i5.l<? super Boolean, Double> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.z(Boolean.valueOf(zArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.z(Boolean.valueOf(zArr[it.b()])).doubleValue());
        }
        return dDoubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R> R un(T[] tArr, Comparator<? super R> comparator, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(tArr[0]);
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(tArr[it.b()]);
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean uo(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr.length == 0;
    }

    @kotlin.g1(version = "1.3")
    public static final int up(@a7.d int[] iArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[random.m(iArr.length)];
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <S, T extends S> S uq(@a7.d T[] tArr, @a7.d i5.q<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S sV = (S) tArr[0];
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            sV = operation.v(Integer.valueOf(iB), sV, (Object) tArr[iB]);
        }
        return sV;
    }

    public static final void ur(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        int length = (dArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iTe = Te(dArr);
        u0 it = new kotlin.ranges.k(0, length).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            double d8 = dArr[iB];
            dArr[iB] = dArr[iTe];
            dArr[iTe] = d8;
            iTe--;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Double> us(double[] dArr, i5.p<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (dArr.length == 0) {
            return kotlin.collections.y.F();
        }
        double dDoubleValue = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(dDoubleValue));
        int length = dArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            dDoubleValue = operation.a0(Double.valueOf(dDoubleValue), Double.valueOf(dArr[i7])).doubleValue();
            arrayList.add(Double.valueOf(dDoubleValue));
        }
        return arrayList;
    }

    @kotlin.g1(version = "1.4")
    public static final void ut(@a7.d boolean[] zArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        for (int iZe = Ze(zArr); iZe > 0; iZe--) {
            int iM = random.m(iZe + 1);
            boolean z7 = zArr[iZe];
            zArr[iZe] = zArr[iM];
            zArr[iM] = z7;
        }
    }

    @a7.d
    public static final List<Short> uu(@a7.d short[] sArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? kotlin.collections.y.F() : kotlin.collections.o.u(kotlin.collections.o.N1(sArr, indices.d().intValue(), indices.f().intValue() + 1));
    }

    @a7.d
    public static final long[] uv(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.l0.o(jArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.r4(jArrCopyOf);
        return jArrCopyOf;
    }

    @a7.d
    public static final Set<Long> uw(@a7.d long[] jArr, @a7.d Iterable<Long> other) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Long> setCz = Cz(jArr);
        d0.E0(setCz, other);
        return setCz;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @kotlin.t0
    @kotlin.internal.f
    private static final long ux(double[] dArr, i5.l<? super Double, Long> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jLongValue = 0;
        for (double d8 : dArr) {
            jLongValue += selector.z(Double.valueOf(d8)).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final <T> List<T> uy(@a7.d T[] tArr, @a7.d i5.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iXe = Xe(tArr); -1 < iXe; iXe--) {
            if (!predicate.z(tArr[iXe]).booleanValue()) {
                return M9(tArr, iXe + 1);
            }
        }
        return kz(tArr);
    }

    @a7.d
    public static <T> List<T> uz(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return new ArrayList(kotlin.collections.y.t(tArr));
    }

    public static final boolean v5(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (byte b8 : bArr) {
            if (!predicate.z(Byte.valueOf(b8)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    public static final <K, V> Map<K, V> v6(@a7.d short[] sArr, @a7.d i5.l<? super Short, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(sArr.length), 16));
        for (short s7 : sArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Short.valueOf(s7));
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V> Map<Long, V> v7(long[] jArr, i5.l<? super Long, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(jArr.length), 16));
        for (long j7 : jArr) {
            linkedHashMap.put(Long.valueOf(j7), valueSelector.z(Long.valueOf(j7)));
        }
        return linkedHashMap;
    }

    @kotlin.internal.f
    private static final byte v8(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr[3];
    }

    @a7.d
    public static final List<Short> v9(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return g0.Q5(Ez(sArr));
    }

    @a7.d
    public static final <R, V> List<V> vA(@a7.d double[] dArr, @a7.d Iterable<? extends R> other, @a7.d i5.p<? super Double, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(kotlin.collections.z.Z(other, 10), length));
        int i7 = 0;
        for (R r7 : other) {
            if (i7 >= length) {
                break;
            }
            arrayList.add(transform.a0(Double.valueOf(dArr[i7]), r7));
            i7++;
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final long va(long[] jArr, int i7, i5.l<? super Integer, Long> defaultValue) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > We(jArr)) ? defaultValue.z(Integer.valueOf(i7)).longValue() : jArr[i7];
    }

    @a7.d
    public static final <C extends Collection<? super T>, T> C vb(@a7.d T[] tArr, @a7.d C destination) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        for (T t7 : tArr) {
            if (t7 != null) {
                destination.add(t7);
            }
        }
        return destination;
    }

    public static final short vc(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (short s7 : sArr) {
            if (predicate.z(Short.valueOf(s7)).booleanValue()) {
                return s7;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapSequence")
    @kotlin.t0
    @a7.d
    public static final <T, R> List<R> vd(@a7.d T[] tArr, @a7.d i5.l<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t7 : tArr) {
            d0.p0(arrayList, transform.z(t7));
        }
        return arrayList;
    }

    public static final void ve(@a7.d long[] jArr, @a7.d i5.l<? super Long, l2> action) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (long j7 : jArr) {
            action.z(Long.valueOf(j7));
        }
    }

    @a7.d
    public static final <K, V> Map<K, List<V>> vf(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends K> keySelector, @a7.d i5.l<? super Character, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c8 : cArr) {
            K kZ = keySelector.z(Character.valueOf(c8));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(Character.valueOf(c8)));
        }
        return linkedHashMap;
    }

    public static final int vg(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (predicate.z(Byte.valueOf(bArr[length])).booleanValue()) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.e
    public static final Character vi(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i7 = length - 1;
            char c8 = cArr[length];
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                return Character.valueOf(c8);
            }
            if (i7 < 0) {
                return null;
            }
            length = i7;
        }
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C vj(@a7.d boolean[] zArr, @a7.d C destination, @a7.d i5.l<? super Boolean, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (boolean z7 : zArr) {
            destination.add(transform.z(Boolean.valueOf(z7)));
        }
        return destination;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <T, R extends Comparable<? super R>> R vk(T[] tArr, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rZ = selector.z(tArr[0]);
        u0 it = new kotlin.ranges.k(1, Xe(tArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(tArr[it.b()]);
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final double vl(@a7.d Double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = dArr[0].doubleValue();
        u0 it = new kotlin.ranges.k(1, Xe(dArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, dArr[it.b()].doubleValue());
        }
        return dDoubleValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float vm(byte[] bArr, i5.l<? super Byte, Float> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Byte.valueOf(bArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Byte.valueOf(bArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R vn(short[] sArr, Comparator<? super R> comparator, i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Short.valueOf(sArr[0]));
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Short.valueOf(sArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean vo(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (char c8 : cArr) {
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final long vp(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return wp(jArr, kotlin.random.f.f34998a);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final Short vq(@a7.d short[] sArr, @a7.d i5.q<? super Integer, ? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            sShortValue = operation.v(Integer.valueOf(iB), Short.valueOf(sShortValue), Short.valueOf(sArr[iB])).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    @kotlin.g1(version = "1.4")
    public static final void vr(@a7.d double[] dArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.collections.c.f34509a.d(i7, i8, dArr.length);
        int i9 = (i7 + i8) / 2;
        if (i7 == i9) {
            return;
        }
        int i10 = i8 - 1;
        while (i7 < i9) {
            double d8 = dArr[i7];
            dArr[i7] = dArr[i10];
            dArr[i10] = d8;
            i10--;
            i7++;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Float> vs(float[] fArr, i5.p<? super Float, ? super Float, Float> operation) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (fArr.length == 0) {
            return kotlin.collections.y.F();
        }
        float fFloatValue = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(fFloatValue));
        int length = fArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            fFloatValue = operation.a0(Float.valueOf(fFloatValue), Float.valueOf(fArr[i7])).floatValue();
            arrayList.add(Float.valueOf(fFloatValue));
        }
        return arrayList;
    }

    public static byte vt(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return bArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @a7.d
    public static final List<Boolean> vu(@a7.d boolean[] zArr, @a7.d Iterable<Integer> indices) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        int iZ = kotlin.collections.z.Z(indices, 10);
        if (iZ == 0) {
            return kotlin.collections.y.F();
        }
        ArrayList arrayList = new ArrayList(iZ);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(zArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @a7.d
    public static final <T extends Comparable<? super T>> T[] vv(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.l0.o(objArrCopyOf, "copyOf(this, size)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        kotlin.jvm.internal.l0.n(tArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        kotlin.collections.o.v4(tArr2);
        return tArr2;
    }

    @a7.d
    public static final <T> Set<T> vw(@a7.d T[] tArr, @a7.d Iterable<? extends T> other) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<T> setDz = Dz(tArr);
        d0.E0(setDz, other);
        return setDz;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @kotlin.t0
    @kotlin.internal.f
    private static final long vx(float[] fArr, i5.l<? super Float, Long> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jLongValue = 0;
        for (float f8 : fArr) {
            jLongValue += selector.z(Float.valueOf(f8)).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final List<Short> vy(@a7.d short[] sArr, @a7.d i5.l<? super Short, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iYe = Ye(sArr); -1 < iYe; iYe--) {
            if (!predicate.z(Short.valueOf(sArr[iYe])).booleanValue()) {
                return N9(sArr, iYe + 1);
            }
        }
        return lz(sArr);
    }

    @a7.d
    public static final List<Short> vz(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s7 : sArr) {
            arrayList.add(Short.valueOf(s7));
        }
        return arrayList;
    }

    public static final boolean w5(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (char c8 : cArr) {
            if (!predicate.z(Character.valueOf(c8)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    public static final <K, V> Map<K, V> w6(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends kotlin.u0<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(zArr.length), 16));
        for (boolean z7 : zArr) {
            kotlin.u0<? extends K, ? extends V> u0VarZ = transform.z(Boolean.valueOf(z7));
            linkedHashMap.put(u0VarZ.e(), u0VarZ.f());
        }
        return linkedHashMap;
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    public static final <K, V> Map<K, V> w7(@a7.d K[] kArr, @a7.d i5.l<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(kArr, "<this>");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(kArr.length), 16));
        for (K k7 : kArr) {
            linkedHashMap.put(k7, valueSelector.z(k7));
        }
        return linkedHashMap;
    }

    @kotlin.internal.f
    private static final char w8(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr[3];
    }

    @a7.d
    public static final List<Boolean> w9(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return g0.Q5(Fz(zArr));
    }

    @a7.d
    public static final List<kotlin.u0<Double, Double>> wA(@a7.d double[] dArr, @a7.d double[] other) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(kotlin.p1.a(Double.valueOf(dArr[i7]), Double.valueOf(other[i7])));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final <T> T wa(T[] tArr, int i7, i5.l<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Xe(tArr)) ? defaultValue.z(Integer.valueOf(i7)) : tArr[i7];
    }

    @a7.d
    public static final <C extends Collection<? super Byte>> C wb(@a7.d byte[] bArr, @a7.d C destination, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (byte b8 : bArr) {
            if (!predicate.z(Byte.valueOf(b8)).booleanValue()) {
                destination.add(Byte.valueOf(b8));
            }
        }
        return destination;
    }

    public static final boolean wc(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (zArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return zArr[0];
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "flatMapSequenceTo")
    @kotlin.t0
    @a7.d
    public static final <T, R, C extends Collection<? super R>> C wd(@a7.d T[] tArr, @a7.d C destination, @a7.d i5.l<? super T, ? extends kotlin.sequences.m<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (T t7 : tArr) {
            d0.p0(destination, transform.z(t7));
        }
        return destination;
    }

    public static final <T> void we(@a7.d T[] tArr, @a7.d i5.l<? super T, l2> action) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (T t7 : tArr) {
            action.z(t7);
        }
    }

    @a7.d
    public static final <K> Map<K, List<Double>> wf(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d8 : dArr) {
            K kZ = keySelector.z(Double.valueOf(d8));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(Double.valueOf(d8));
        }
        return linkedHashMap;
    }

    public static final int wg(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (predicate.z(Character.valueOf(cArr[length])).booleanValue()) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.e
    public static final Double wi(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Boolean wj(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z7 = zArr[0];
        int iZe = Ze(zArr);
        if (iZe == 0) {
            return Boolean.valueOf(z7);
        }
        R rZ = selector.z(Boolean.valueOf(z7));
        u0 it = new kotlin.ranges.k(1, iZe).iterator();
        while (it.hasNext()) {
            boolean z8 = zArr[it.b()];
            R rZ2 = selector.z(Boolean.valueOf(z8));
            if (rZ.compareTo(rZ2) < 0) {
                z7 = z8;
                rZ = rZ2;
            }
        }
        return Boolean.valueOf(z7);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R wk(short[] sArr, i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Short.valueOf(sArr[0]));
        u0 it = new kotlin.ranges.k(1, Ye(sArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Short.valueOf(sArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final float wl(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fMax = fArr[0];
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            fMax = Math.max(fMax, fArr[it.b()]);
        }
        return fMax;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float wm(char[] cArr, i5.l<? super Character, Float> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Character.valueOf(cArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Character.valueOf(cArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R wn(boolean[] zArr, Comparator<? super R> comparator, i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rZ = selector.z(Boolean.valueOf(zArr[0]));
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Boolean.valueOf(zArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean wo(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr.length == 0;
    }

    @kotlin.g1(version = "1.3")
    public static final long wp(@a7.d long[] jArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (jArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return jArr[random.m(jArr.length)];
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Boolean wq(@a7.d boolean[] zArr, @a7.d i5.p<? super Boolean, ? super Boolean, Boolean> operation) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            zBooleanValue = operation.a0(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[it.b()])).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final void wr(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        int length = (fArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iUe = Ue(fArr);
        u0 it = new kotlin.ranges.k(0, length).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            float f8 = fArr[iB];
            fArr[iB] = fArr[iUe];
            fArr[iUe] = f8;
            iUe--;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Integer> ws(int[] iArr, i5.p<? super Integer, ? super Integer, Integer> operation) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (iArr.length == 0) {
            return kotlin.collections.y.F();
        }
        int iIntValue = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(iIntValue));
        int length = iArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            iIntValue = operation.a0(Integer.valueOf(iIntValue), Integer.valueOf(iArr[i7])).intValue();
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }

    public static final byte wt(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Byte bValueOf = null;
        boolean z7 = false;
        for (byte b8 : bArr) {
            if (predicate.z(Byte.valueOf(b8)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                bValueOf = Byte.valueOf(b8);
                z7 = true;
            }
        }
        if (!z7) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.l0.n(bValueOf, "null cannot be cast to non-null type kotlin.Byte");
        return bValueOf.byteValue();
    }

    @a7.d
    public static final List<Boolean> wu(@a7.d boolean[] zArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? kotlin.collections.y.F() : kotlin.collections.o.v(kotlin.collections.o.O1(zArr, indices.d().intValue(), indices.f().intValue() + 1));
    }

    @a7.d
    public static final short[] wv(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.l0.o(sArrCopyOf, "copyOf(this, size)");
        kotlin.collections.o.x4(sArrCopyOf);
        return sArrCopyOf;
    }

    @a7.d
    public static final Set<Short> ww(@a7.d short[] sArr, @a7.d Iterable<Short> other) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Short> setEz = Ez(sArr);
        d0.E0(setEz, other);
        return setEz;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @kotlin.t0
    @kotlin.internal.f
    private static final long wx(int[] iArr, i5.l<? super Integer, Long> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jLongValue = 0;
        for (int i7 : iArr) {
            jLongValue += selector.z(Integer.valueOf(i7)).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final List<Boolean> wy(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int iZe = Ze(zArr); -1 < iZe; iZe--) {
            if (!predicate.z(Boolean.valueOf(zArr[iZe])).booleanValue()) {
                return O9(zArr, iZe + 1);
            }
        }
        return mz(zArr);
    }

    @a7.d
    public static final List<Boolean> wz(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z7 : zArr) {
            arrayList.add(Boolean.valueOf(z7));
        }
        return arrayList;
    }

    public static final boolean x5(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (double d8 : dArr) {
            if (!predicate.z(Double.valueOf(d8)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    public static final <K> Map<K, Byte> x6(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(bArr.length), 16));
        for (byte b8 : bArr) {
            linkedHashMap.put(keySelector.z(Byte.valueOf(b8)), Byte.valueOf(b8));
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V> Map<Short, V> x7(short[] sArr, i5.l<? super Short, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(sArr.length), 16));
        for (short s7 : sArr) {
            linkedHashMap.put(Short.valueOf(s7), valueSelector.z(Short.valueOf(s7)));
        }
        return linkedHashMap;
    }

    @kotlin.internal.f
    private static final double x8(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr[3];
    }

    @a7.d
    public static final <K> List<Byte> x9(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends K> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b8 : bArr) {
            if (hashSet.add(selector.z(Byte.valueOf(b8)))) {
                arrayList.add(Byte.valueOf(b8));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <V> List<V> xA(@a7.d double[] dArr, @a7.d double[] other, @a7.d i5.p<? super Double, ? super Double, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Double.valueOf(dArr[i7]), Double.valueOf(other[i7])));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final short xa(short[] sArr, int i7, i5.l<? super Integer, Short> defaultValue) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Ye(sArr)) ? defaultValue.z(Integer.valueOf(i7)).shortValue() : sArr[i7];
    }

    @a7.d
    public static final <C extends Collection<? super Character>> C xb(@a7.d char[] cArr, @a7.d C destination, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (char c8 : cArr) {
            if (!predicate.z(Character.valueOf(c8)).booleanValue()) {
                destination.add(Character.valueOf(c8));
            }
        }
        return destination;
    }

    public static final boolean xc(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (boolean z7 : zArr) {
            if (predicate.z(Boolean.valueOf(z7)).booleanValue()) {
                return z7;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C xd(@a7.d byte[] bArr, @a7.d C destination, @a7.d i5.l<? super Byte, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (byte b8 : bArr) {
            d0.o0(destination, transform.z(Byte.valueOf(b8)));
        }
        return destination;
    }

    public static final void xe(@a7.d short[] sArr, @a7.d i5.l<? super Short, l2> action) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (short s7 : sArr) {
            action.z(Short.valueOf(s7));
        }
    }

    @a7.d
    public static final <K, V> Map<K, List<V>> xf(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends K> keySelector, @a7.d i5.l<? super Double, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d8 : dArr) {
            K kZ = keySelector.z(Double.valueOf(d8));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(Double.valueOf(d8)));
        }
        return linkedHashMap;
    }

    public static final int xg(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (predicate.z(Double.valueOf(dArr[length])).booleanValue()) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final String xh(@a7.d byte[] bArr, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Byte, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        String string = ((StringBuilder) fh(bArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, lVar)).toString();
        kotlin.jvm.internal.l0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @a7.e
    public static final Double xi(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i7 = length - 1;
            double d8 = dArr[length];
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                return Double.valueOf(d8);
            }
            if (i7 < 0) {
                return null;
            }
            length = i7;
        }
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Byte xj(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b8 = bArr[0];
        int iRe = Re(bArr);
        if (iRe == 0) {
            return Byte.valueOf(b8);
        }
        R rZ = selector.z(Byte.valueOf(b8));
        u0 it = new kotlin.ranges.k(1, iRe).iterator();
        while (it.hasNext()) {
            byte b9 = bArr[it.b()];
            R rZ2 = selector.z(Byte.valueOf(b9));
            if (rZ.compareTo(rZ2) < 0) {
                b8 = b9;
                rZ = rZ2;
            }
        }
        return Byte.valueOf(b8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R extends Comparable<? super R>> R xk(boolean[] zArr, i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Boolean.valueOf(zArr[0]));
        u0 it = new kotlin.ranges.k(1, Ze(zArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Boolean.valueOf(zArr[it.b()]));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final float xl(@a7.d Float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = fArr[0].floatValue();
        u0 it = new kotlin.ranges.k(1, Xe(fArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, fArr[it.b()].floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float xm(double[] dArr, i5.l<? super Double, Float> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Double.valueOf(dArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Double.valueOf(dArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R xn(byte[] bArr, Comparator<? super R> comparator, i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Byte.valueOf(bArr[0]));
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Byte.valueOf(bArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean xo(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (double d8 : dArr) {
            if (predicate.z(Double.valueOf(d8)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> T xp(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return (T) yp(tArr, kotlin.random.f.f34998a);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Byte xq(@a7.d byte[] bArr, @a7.d i5.p<? super Byte, ? super Byte, Byte> operation) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            bByteValue = operation.a0(Byte.valueOf(bByteValue), Byte.valueOf(bArr[it.b()])).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @kotlin.g1(version = "1.4")
    public static final void xr(@a7.d float[] fArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.collections.c.f34509a.d(i7, i8, fArr.length);
        int i9 = (i7 + i8) / 2;
        if (i7 == i9) {
            return;
        }
        int i10 = i8 - 1;
        while (i7 < i9) {
            float f8 = fArr[i7];
            fArr[i7] = fArr[i10];
            fArr[i10] = f8;
            i10--;
            i7++;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Long> xs(long[] jArr, i5.p<? super Long, ? super Long, Long> operation) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (jArr.length == 0) {
            return kotlin.collections.y.F();
        }
        long jLongValue = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(jLongValue));
        int length = jArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            jLongValue = operation.a0(Long.valueOf(jLongValue), Long.valueOf(jArr[i7])).longValue();
            arrayList.add(Long.valueOf(jLongValue));
        }
        return arrayList;
    }

    public static char xt(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @a7.d
    public static byte[] xu(@a7.d byte[] bArr, @a7.d Collection<Integer> indices) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        byte[] bArr2 = new byte[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            bArr2[i7] = bArr[it.next().intValue()];
            i7++;
        }
        return bArr2;
    }

    @a7.d
    public static final byte[] xv(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.l0.o(bArrCopyOf, "copyOf(this, size)");
        Ru(bArrCopyOf);
        return bArrCopyOf;
    }

    @a7.d
    public static final Set<Boolean> xw(@a7.d boolean[] zArr, @a7.d Iterable<Boolean> other) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        Set<Boolean> setFz = Fz(zArr);
        d0.E0(setFz, other);
        return setFz;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @kotlin.t0
    @kotlin.internal.f
    private static final long xx(long[] jArr, i5.l<? super Long, Long> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jLongValue = 0;
        for (long j7 : jArr) {
            jLongValue += selector.z(Long.valueOf(j7)).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final List<Byte> xy(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b8 : bArr) {
            if (!predicate.z(Byte.valueOf(b8)).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b8));
        }
        return arrayList;
    }

    @a7.d
    public static final Set<Byte> xz(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return (Set) Jy(bArr, new LinkedHashSet(b1.j(bArr.length)));
    }

    public static final boolean y5(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (float f8 : fArr) {
            if (!predicate.z(Float.valueOf(f8)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    public static final <K, V> Map<K, V> y6(@a7.d byte[] bArr, @a7.d i5.l<? super Byte, ? extends K> keySelector, @a7.d i5.l<? super Byte, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(bArr.length), 16));
        for (byte b8 : bArr) {
            linkedHashMap.put(keySelector.z(Byte.valueOf(b8)), valueTransform.z(Byte.valueOf(b8)));
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V> Map<Boolean, V> y7(boolean[] zArr, i5.l<? super Boolean, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(zArr.length), 16));
        for (boolean z7 : zArr) {
            linkedHashMap.put(Boolean.valueOf(z7), valueSelector.z(Boolean.valueOf(z7)));
        }
        return linkedHashMap;
    }

    @kotlin.internal.f
    private static final float y8(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr[3];
    }

    @a7.d
    public static final <K> List<Character> y9(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends K> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c8 : cArr) {
            if (hashSet.add(selector.z(Character.valueOf(c8)))) {
                arrayList.add(Character.valueOf(c8));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <R> List<kotlin.u0<Double, R>> yA(@a7.d double[] dArr, @a7.d R[] other) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            double d8 = dArr[i7];
            arrayList.add(kotlin.p1.a(Double.valueOf(d8), other[i7]));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final boolean ya(boolean[] zArr, int i7, i5.l<? super Integer, Boolean> defaultValue) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return (i7 < 0 || i7 > Ze(zArr)) ? defaultValue.z(Integer.valueOf(i7)).booleanValue() : zArr[i7];
    }

    @a7.d
    public static final <C extends Collection<? super Double>> C yb(@a7.d double[] dArr, @a7.d C destination, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (double d8 : dArr) {
            if (!predicate.z(Double.valueOf(d8)).booleanValue()) {
                destination.add(Double.valueOf(d8));
            }
        }
        return destination;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001d  */
    /* JADX WARN: Code duplicated, block: B:9:0x001c A[RETURN] */
    @kotlin.g1(version = "1.5")
    @kotlin.internal.f
    private static final <T, R> R yc(T[] tArr, i5.l<? super T, ? extends R> transform) {
        R rZ;
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (T t7 : tArr) {
            rZ = transform.z(t7);
            if (rZ != null) {
                if (rZ != null) {
                    return rZ;
                }
                throw new NoSuchElementException("No element of the array was transformed to a non-null value.");
            }
        }
        rZ = null;
        if (rZ != null) {
            return rZ;
        }
        throw new NoSuchElementException("No element of the array was transformed to a non-null value.");
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C yd(@a7.d char[] cArr, @a7.d C destination, @a7.d i5.l<? super Character, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (char c8 : cArr) {
            d0.o0(destination, transform.z(Character.valueOf(c8)));
        }
        return destination;
    }

    public static final void ye(@a7.d boolean[] zArr, @a7.d i5.l<? super Boolean, l2> action) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        for (boolean z7 : zArr) {
            action.z(Boolean.valueOf(z7));
        }
    }

    @a7.d
    public static final <K> Map<K, List<Float>> yf(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f8 : fArr) {
            K kZ = keySelector.z(Float.valueOf(f8));
            Object arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kZ, arrayList);
            }
            ((List) arrayList).add(Float.valueOf(f8));
        }
        return linkedHashMap;
    }

    public static final int yg(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (predicate.z(Float.valueOf(fArr[length])).booleanValue()) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final String yh(@a7.d char[] cArr, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Character, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        String string = ((StringBuilder) gh(cArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, lVar)).toString();
        kotlin.jvm.internal.l0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @a7.e
    public static final Float yi(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Character yj(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c8 = cArr[0];
        int iSe = Se(cArr);
        if (iSe == 0) {
            return Character.valueOf(c8);
        }
        R rZ = selector.z(Character.valueOf(c8));
        u0 it = new kotlin.ranges.k(1, iSe).iterator();
        while (it.hasNext()) {
            char c9 = cArr[it.b()];
            R rZ2 = selector.z(Character.valueOf(c9));
            if (rZ.compareTo(rZ2) < 0) {
                c8 = c9;
                rZ = rZ2;
            }
        }
        return Character.valueOf(c8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double yk(byte[] bArr, i5.l<? super Byte, Double> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Byte.valueOf(bArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Re(bArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Byte.valueOf(bArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final int yl(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i7 = iArr[0];
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            int i8 = iArr[it.b()];
            if (i7 < i8) {
                i7 = i8;
            }
        }
        return i7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float ym(float[] fArr, i5.l<? super Float, Float> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Float.valueOf(fArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ue(fArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Float.valueOf(fArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R yn(char[] cArr, Comparator<? super R> comparator, i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Character.valueOf(cArr[0]));
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Character.valueOf(cArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean yo(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr.length == 0;
    }

    @kotlin.g1(version = "1.3")
    public static final <T> T yp(@a7.d T[] tArr, @a7.d kotlin.random.f random) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(random, "random");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[random.m(tArr.length)];
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Character yq(@a7.d char[] cArr, @a7.d i5.p<? super Character, ? super Character, Character> operation) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            cCharValue = operation.a0(Character.valueOf(cCharValue), Character.valueOf(cArr[it.b()])).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    public static void yr(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        int length = (iArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iVe = Ve(iArr);
        u0 it = new kotlin.ranges.k(0, length).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            int i7 = iArr[iB];
            iArr[iB] = iArr[iVe];
            iArr[iVe] = i7;
            iVe--;
        }
    }

    @a7.d
    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <S, T extends S> List<S> ys(@a7.d T[] tArr, @a7.d i5.p<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (tArr.length == 0) {
            return kotlin.collections.y.F();
        }
        S sA0 = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(sA0);
        int length = tArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            sA0 = operation.a0(sA0, (Object) tArr[i7]);
            arrayList.add(sA0);
        }
        return arrayList;
    }

    public static final char yt(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        Character chValueOf = null;
        boolean z7 = false;
        for (char c8 : cArr) {
            if (predicate.z(Character.valueOf(c8)).booleanValue()) {
                if (z7) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                chValueOf = Character.valueOf(c8);
                z7 = true;
            }
        }
        if (!z7) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kotlin.jvm.internal.l0.n(chValueOf, "null cannot be cast to non-null type kotlin.Char");
        return chValueOf.charValue();
    }

    @a7.d
    public static byte[] yu(@a7.d byte[] bArr, @a7.d kotlin.ranges.k indices) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        return indices.isEmpty() ? new byte[0] : kotlin.collections.o.G1(bArr, indices.d().intValue(), indices.f().intValue() + 1);
    }

    @a7.d
    public static final char[] yv(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.l0.o(cArrCopyOf, "copyOf(this, size)");
        Tu(cArrCopyOf);
        return cArrCopyOf;
    }

    public static final double yw(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        double d8 = 0.0d;
        for (double d9 : dArr) {
            d8 += d9;
        }
        return d8;
    }

    @h5.h(name = "sumOfLong")
    public static final long yx(@a7.d Long[] lArr) {
        kotlin.jvm.internal.l0.p(lArr, "<this>");
        long jLongValue = 0;
        for (Long l7 : lArr) {
            jLongValue += l7.longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final List<Character> yy(@a7.d char[] cArr, @a7.d i5.l<? super Character, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c8 : cArr) {
            if (!predicate.z(Character.valueOf(c8)).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c8));
        }
        return arrayList;
    }

    @a7.d
    public static final Set<Character> yz(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return (Set) Ky(cArr, new LinkedHashSet(b1.j(kotlin.ranges.q.u(cArr.length, 128))));
    }

    public static final boolean z5(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (int i7 : iArr) {
            if (!predicate.z(Integer.valueOf(i7)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @a7.d
    public static final <K> Map<K, Character> z6(@a7.d char[] cArr, @a7.d i5.l<? super Character, ? extends K> keySelector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.q.n(b1.j(cArr.length), 16));
        for (char c8 : cArr) {
            linkedHashMap.put(keySelector.z(Character.valueOf(c8)), Character.valueOf(c8));
        }
        return linkedHashMap;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final <V, M extends Map<? super Byte, ? super V>> M z7(byte[] bArr, M destination, i5.l<? super Byte, ? extends V> valueSelector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(valueSelector, "valueSelector");
        for (byte b8 : bArr) {
            destination.put(Byte.valueOf(b8), valueSelector.z(Byte.valueOf(b8)));
        }
        return destination;
    }

    @kotlin.internal.f
    private static final int z8(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr[3];
    }

    @a7.d
    public static final <K> List<Double> z9(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends K> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d8 : dArr) {
            if (hashSet.add(selector.z(Double.valueOf(d8)))) {
                arrayList.add(Double.valueOf(d8));
            }
        }
        return arrayList;
    }

    @a7.d
    public static final <R, V> List<V> zA(@a7.d double[] dArr, @a7.d R[] other, @a7.d i5.p<? super Double, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        kotlin.jvm.internal.l0.p(transform, "transform");
        int iMin = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i7 = 0; i7 < iMin; i7++) {
            arrayList.add(transform.a0(Double.valueOf(dArr[i7]), other[i7]));
        }
        return arrayList;
    }

    @kotlin.internal.f
    private static final Boolean za(boolean[] zArr, int i7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return jf(zArr, i7);
    }

    @a7.d
    public static final <C extends Collection<? super Float>> C zb(@a7.d float[] fArr, @a7.d C destination, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (float f8 : fArr) {
            if (!predicate.z(Float.valueOf(f8)).booleanValue()) {
                destination.add(Float.valueOf(f8));
            }
        }
        return destination;
    }

    @kotlin.g1(version = "1.5")
    @kotlin.internal.f
    private static final <T, R> R zc(T[] tArr, i5.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (T t7 : tArr) {
            R rZ = transform.z(t7);
            if (rZ != null) {
                return rZ;
            }
        }
        return null;
    }

    @a7.d
    public static final <R, C extends Collection<? super R>> C zd(@a7.d double[] dArr, @a7.d C destination, @a7.d i5.l<? super Double, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(transform, "transform");
        for (double d8 : dArr) {
            d0.o0(destination, transform.z(Double.valueOf(d8)));
        }
        return destination;
    }

    public static final void ze(@a7.d byte[] bArr, @a7.d i5.p<? super Integer, ? super Byte, l2> action) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            action.a0(Integer.valueOf(i8), Byte.valueOf(bArr[i7]));
            i7++;
            i8++;
        }
    }

    @a7.d
    public static final <K, V> Map<K, List<V>> zf(@a7.d float[] fArr, @a7.d i5.l<? super Float, ? extends K> keySelector, @a7.d i5.l<? super Float, ? extends V> valueTransform) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(keySelector, "keySelector");
        kotlin.jvm.internal.l0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f8 : fArr) {
            K kZ = keySelector.z(Float.valueOf(f8));
            List<V> arrayList = linkedHashMap.get(kZ);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kZ, arrayList);
            }
            arrayList.add(valueTransform.z(Float.valueOf(f8)));
        }
        return linkedHashMap;
    }

    public static final int zg(@a7.d int[] iArr, @a7.d i5.l<? super Integer, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i7 = length - 1;
                if (predicate.z(Integer.valueOf(iArr[length])).booleanValue()) {
                    return length;
                }
                if (i7 >= 0) {
                    length = i7;
                }
            }
        }
        return -1;
    }

    @a7.d
    public static final String zh(@a7.d double[] dArr, @a7.d CharSequence separator, @a7.d CharSequence prefix, @a7.d CharSequence postfix, int i7, @a7.d CharSequence truncated, @a7.e i5.l<? super Double, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(separator, "separator");
        kotlin.jvm.internal.l0.p(prefix, "prefix");
        kotlin.jvm.internal.l0.p(postfix, "postfix");
        kotlin.jvm.internal.l0.p(truncated, "truncated");
        String string = ((StringBuilder) hh(dArr, new StringBuilder(), separator, prefix, postfix, i7, truncated, lVar)).toString();
        kotlin.jvm.internal.l0.o(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    @a7.e
    public static final Float zi(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i7 = length - 1;
            float f8 = fArr[length];
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                return Float.valueOf(f8);
            }
            if (i7 < 0) {
                return null;
            }
            length = i7;
        }
    }

    @kotlin.g1(version = "1.4")
    @a7.e
    public static final <R extends Comparable<? super R>> Double zj(@a7.d double[] dArr, @a7.d i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d8 = dArr[0];
        int iTe = Te(dArr);
        if (iTe == 0) {
            return Double.valueOf(d8);
        }
        R rZ = selector.z(Double.valueOf(d8));
        u0 it = new kotlin.ranges.k(1, iTe).iterator();
        while (it.hasNext()) {
            double d9 = dArr[it.b()];
            R rZ2 = selector.z(Double.valueOf(d9));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
                d8 = d9;
            }
        }
        return Double.valueOf(d8);
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final Double zk(char[] cArr, i5.l<? super Character, Double> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double dDoubleValue = selector.z(Character.valueOf(cArr[0])).doubleValue();
        u0 it = new kotlin.ranges.k(1, Se(cArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.z(Character.valueOf(cArr[it.b()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.7")
    @h5.h(name = "maxOrThrow")
    public static final long zl(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j7 = jArr[0];
        u0 it = new kotlin.ranges.k(1, We(jArr)).iterator();
        while (it.hasNext()) {
            long j8 = jArr[it.b()];
            if (j7 < j8) {
                j7 = j8;
            }
        }
        return j7;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final float zm(int[] iArr, i5.l<? super Integer, Float> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.z(Integer.valueOf(iArr[0])).floatValue();
        u0 it = new kotlin.ranges.k(1, Ve(iArr)).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.z(Integer.valueOf(iArr[it.b()])).floatValue());
        }
        return fFloatValue;
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    @kotlin.t0
    private static final <R> R zn(double[] dArr, Comparator<? super R> comparator, i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rZ = selector.z(Double.valueOf(dArr[0]));
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            R rZ2 = selector.z(Double.valueOf(dArr[it.b()]));
            if (comparator.compare(rZ, rZ2) > 0) {
                rZ = rZ2;
            }
        }
        return rZ;
    }

    public static final boolean zo(@a7.d float[] fArr, @a7.d i5.l<? super Float, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        for (float f8 : fArr) {
            if (predicate.z(Float.valueOf(f8)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final short zp(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return Ap(sArr, kotlin.random.f.f34998a);
    }

    @kotlin.g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @a7.e
    public static final Double zq(@a7.d double[] dArr, @a7.d i5.p<? super Double, ? super Double, Double> operation) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        u0 it = new kotlin.ranges.k(1, Te(dArr)).iterator();
        while (it.hasNext()) {
            dDoubleValue = operation.a0(Double.valueOf(dDoubleValue), Double.valueOf(dArr[it.b()])).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    @kotlin.g1(version = "1.4")
    public static void zr(@a7.d int[] iArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.collections.c.f34509a.d(i7, i8, iArr.length);
        int i9 = (i7 + i8) / 2;
        if (i7 == i9) {
            return;
        }
        int i10 = i8 - 1;
        while (i7 < i9) {
            int i11 = iArr[i7];
            iArr[i7] = iArr[i10];
            iArr[i10] = i11;
            i10--;
            i7++;
        }
    }

    @kotlin.g1(version = "1.4")
    @kotlin.internal.f
    private static final List<Short> zs(short[] sArr, i5.p<? super Short, ? super Short, Short> operation) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        if (sArr.length == 0) {
            return kotlin.collections.y.F();
        }
        short sShortValue = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(sShortValue));
        int length = sArr.length;
        for (int i7 = 1; i7 < length; i7++) {
            sShortValue = operation.a0(Short.valueOf(sShortValue), Short.valueOf(sArr[i7])).shortValue();
            arrayList.add(Short.valueOf(sShortValue));
        }
        return arrayList;
    }

    public static final double zt(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return dArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @a7.d
    public static final char[] zu(@a7.d char[] cArr, @a7.d Collection<Integer> indices) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(indices, "indices");
        char[] cArr2 = new char[indices.size()];
        Iterator<Integer> it = indices.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            cArr2[i7] = cArr[it.next().intValue()];
            i7++;
        }
        return cArr2;
    }

    @a7.d
    public static final double[] zv(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.l0.o(dArrCopyOf, "copyOf(this, size)");
        Vu(dArrCopyOf);
        return dArrCopyOf;
    }

    public static final float zw(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        float f8 = 0.0f;
        for (float f9 : fArr) {
            f8 += f9;
        }
        return f8;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfLong")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T> long zx(T[] tArr, i5.l<? super T, Long> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        long jLongValue = 0;
        for (T t7 : tArr) {
            jLongValue += selector.z(t7).longValue();
        }
        return jLongValue;
    }

    @a7.d
    public static final List<Double> zy(@a7.d double[] dArr, @a7.d i5.l<? super Double, Boolean> predicate) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d8 : dArr) {
            if (!predicate.z(Double.valueOf(d8)).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d8));
        }
        return arrayList;
    }

    @a7.d
    public static final Set<Double> zz(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return (Set) Ly(dArr, new LinkedHashSet(b1.j(dArr.length)));
    }
}
