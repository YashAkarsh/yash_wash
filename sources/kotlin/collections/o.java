package kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class o extends n {

    public static final class a extends kotlin.collections.c<Byte> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ byte[] f34560b;

        a(byte[] bArr) {
            this.f34560b = bArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return this.f34560b.length;
        }

        public boolean b(byte b8) {
            return p.N8(this.f34560b, b8);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return b(((Number) obj).byteValue());
            }
            return false;
        }

        @Override // kotlin.collections.c, java.util.List
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Byte get(int i7) {
            return Byte.valueOf(this.f34560b[i7]);
        }

        public int f(byte b8) {
            return p.dg(this.f34560b, b8);
        }

        public int g(byte b8) {
            return p.hi(this.f34560b, b8);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return f(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return this.f34560b.length == 0;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return g(((Number) obj).byteValue());
            }
            return -1;
        }
    }

    public static final class b extends kotlin.collections.c<Short> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ short[] f34561b;

        b(short[] sArr) {
            this.f34561b = sArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return this.f34561b.length;
        }

        public boolean b(short s7) {
            return p.U8(this.f34561b, s7);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Short) {
                return b(((Number) obj).shortValue());
            }
            return false;
        }

        @Override // kotlin.collections.c, java.util.List
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Short get(int i7) {
            return Short.valueOf(this.f34561b[i7]);
        }

        public int f(short s7) {
            return p.kg(this.f34561b, s7);
        }

        public int g(short s7) {
            return p.oi(this.f34561b, s7);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Short) {
                return f(((Number) obj).shortValue());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return this.f34561b.length == 0;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Short) {
                return g(((Number) obj).shortValue());
            }
            return -1;
        }
    }

    public static final class c extends kotlin.collections.c<Integer> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int[] f34562b;

        c(int[] iArr) {
            this.f34562b = iArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return this.f34562b.length;
        }

        public boolean b(int i7) {
            return p.R8(this.f34562b, i7);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return b(((Number) obj).intValue());
            }
            return false;
        }

        @Override // kotlin.collections.c, java.util.List
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Integer get(int i7) {
            return Integer.valueOf(this.f34562b[i7]);
        }

        public int f(int i7) {
            return p.hg(this.f34562b, i7);
        }

        public int g(int i7) {
            return p.li(this.f34562b, i7);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return f(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return this.f34562b.length == 0;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return g(((Number) obj).intValue());
            }
            return -1;
        }
    }

    public static final class d extends kotlin.collections.c<Long> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long[] f34563b;

        d(long[] jArr) {
            this.f34563b = jArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return this.f34563b.length;
        }

        public boolean b(long j7) {
            return p.S8(this.f34563b, j7);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Long) {
                return b(((Number) obj).longValue());
            }
            return false;
        }

        @Override // kotlin.collections.c, java.util.List
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Long get(int i7) {
            return Long.valueOf(this.f34563b[i7]);
        }

        public int f(long j7) {
            return p.ig(this.f34563b, j7);
        }

        public int g(long j7) {
            return p.mi(this.f34563b, j7);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Long) {
                return f(((Number) obj).longValue());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return this.f34563b.length == 0;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return g(((Number) obj).longValue());
            }
            return -1;
        }
    }

    public static final class e extends kotlin.collections.c<Float> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float[] f34564b;

        e(float[] fArr) {
            this.f34564b = fArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return this.f34564b.length;
        }

        public boolean b(float f8) {
            for (float f9 : this.f34564b) {
                if (Float.floatToIntBits(f9) == Float.floatToIntBits(f8)) {
                    return true;
                }
            }
            return false;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Float) {
                return b(((Number) obj).floatValue());
            }
            return false;
        }

        @Override // kotlin.collections.c, java.util.List
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float get(int i7) {
            return Float.valueOf(this.f34564b[i7]);
        }

        public int f(float f8) {
            float[] fArr = this.f34564b;
            int length = fArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                if (Float.floatToIntBits(fArr[i7]) == Float.floatToIntBits(f8)) {
                    return i7;
                }
            }
            return -1;
        }

        public int g(float f8) {
            float[] fArr = this.f34564b;
            int length = fArr.length - 1;
            if (length < 0) {
                return -1;
            }
            while (true) {
                int i7 = length - 1;
                if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f8)) {
                    return length;
                }
                if (i7 < 0) {
                    return -1;
                }
                length = i7;
            }
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Float) {
                return f(((Number) obj).floatValue());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return this.f34564b.length == 0;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Float) {
                return g(((Number) obj).floatValue());
            }
            return -1;
        }
    }

    public static final class f extends kotlin.collections.c<Double> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ double[] f34565b;

        f(double[] dArr) {
            this.f34565b = dArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return this.f34565b.length;
        }

        public boolean b(double d8) {
            for (double d9 : this.f34565b) {
                if (Double.doubleToLongBits(d9) == Double.doubleToLongBits(d8)) {
                    return true;
                }
            }
            return false;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Double) {
                return b(((Number) obj).doubleValue());
            }
            return false;
        }

        @Override // kotlin.collections.c, java.util.List
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Double get(int i7) {
            return Double.valueOf(this.f34565b[i7]);
        }

        public int f(double d8) {
            double[] dArr = this.f34565b;
            int length = dArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                if (Double.doubleToLongBits(dArr[i7]) == Double.doubleToLongBits(d8)) {
                    return i7;
                }
            }
            return -1;
        }

        public int g(double d8) {
            double[] dArr = this.f34565b;
            int length = dArr.length - 1;
            if (length < 0) {
                return -1;
            }
            while (true) {
                int i7 = length - 1;
                if (Double.doubleToLongBits(dArr[length]) == Double.doubleToLongBits(d8)) {
                    return length;
                }
                if (i7 < 0) {
                    return -1;
                }
                length = i7;
            }
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Double) {
                return f(((Number) obj).doubleValue());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return this.f34565b.length == 0;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return g(((Number) obj).doubleValue());
            }
            return -1;
        }
    }

    public static final class g extends kotlin.collections.c<Boolean> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean[] f34566b;

        g(boolean[] zArr) {
            this.f34566b = zArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return this.f34566b.length;
        }

        public boolean b(boolean z7) {
            return p.V8(this.f34566b, z7);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Boolean) {
                return b(((Boolean) obj).booleanValue());
            }
            return false;
        }

        @Override // kotlin.collections.c, java.util.List
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean get(int i7) {
            return Boolean.valueOf(this.f34566b[i7]);
        }

        public int f(boolean z7) {
            return p.lg(this.f34566b, z7);
        }

        public int g(boolean z7) {
            return p.pi(this.f34566b, z7);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Boolean) {
                return f(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return this.f34566b.length == 0;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Boolean) {
                return g(((Boolean) obj).booleanValue());
            }
            return -1;
        }
    }

    public static final class h extends kotlin.collections.c<Character> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ char[] f34567b;

        h(char[] cArr) {
            this.f34567b = cArr;
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int a() {
            return this.f34567b.length;
        }

        public boolean b(char c8) {
            return p.O8(this.f34567b, c8);
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Character) {
                return b(((Character) obj).charValue());
            }
            return false;
        }

        @Override // kotlin.collections.c, java.util.List
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Character get(int i7) {
            return Character.valueOf(this.f34567b[i7]);
        }

        public int f(char c8) {
            return p.eg(this.f34567b, c8);
        }

        public int g(char c8) {
            return p.ii(this.f34567b, c8);
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Character) {
                return f(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return this.f34567b.length == 0;
        }

        @Override // kotlin.collections.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return g(((Character) obj).charValue());
            }
            return -1;
        }
    }

    public static final int A(@a7.d int[] iArr, int i7, int i8, int i9) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return Arrays.binarySearch(iArr, i8, i9, i7);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentHashCodeNullable")
    @kotlin.internal.f
    private static final int A0(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    @kotlin.internal.f
    private static final <T> T[] A1(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.l0.o(tArr2, "copyOf(this, size)");
        return tArr2;
    }

    @a7.d
    public static final <C extends Collection<? super R>, R> C A2(@a7.d Object[] objArr, @a7.d C destination, @a7.d Class<R> klass) {
        kotlin.jvm.internal.l0.p(objArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(klass, "klass");
        for (Object obj : objArr) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Float A3(float[] fArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.eo(fArr, comparator);
    }

    public static /* synthetic */ void A4(char[] cArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = cArr.length;
        }
        k4(cArr, i7, i8);
    }

    public static final int B(@a7.d long[] jArr, long j7, int i7, int i8) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return Arrays.binarySearch(jArr, i7, i8, j7);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentHashCodeNullable")
    @kotlin.internal.f
    private static final <T> int B0(T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    @kotlin.internal.f
    private static final <T> T[] B1(T[] tArr, int i7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i7);
        kotlin.jvm.internal.l0.o(tArr2, "copyOf(this, newSize)");
        return tArr2;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Byte B2(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return p.il(bArr);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Integer B3(int[] iArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.fo(iArr, comparator);
    }

    public static /* synthetic */ void B4(double[] dArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = dArr.length;
        }
        m4(dArr, i7, i8);
    }

    public static final <T> int C(@a7.d T[] tArr, T t7, int i7, int i8) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return Arrays.binarySearch(tArr, i7, i8, t7);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentHashCodeNullable")
    @kotlin.internal.f
    private static final int C0(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @kotlin.internal.f
    private static final short[] C1(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.l0.o(sArrCopyOf, "copyOf(this, size)");
        return sArrCopyOf;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Character C2(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return p.jl(cArr);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Long C3(long[] jArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.go(jArr, comparator);
    }

    public static /* synthetic */ void C4(float[] fArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = fArr.length;
        }
        o4(fArr, i7, i8);
    }

    public static final <T> int D(@a7.d T[] tArr, T t7, @a7.d Comparator<? super T> comparator, int i7, int i8) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return Arrays.binarySearch(tArr, i7, i8, t7, comparator);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentHashCodeNullable")
    @kotlin.internal.f
    private static final int D0(boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    @kotlin.internal.f
    private static final short[] D1(short[] sArr, int i7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, i7);
        kotlin.jvm.internal.l0.o(sArrCopyOf, "copyOf(this, newSize)");
        return sArrCopyOf;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Comparable D2(Comparable[] comparableArr) {
        kotlin.jvm.internal.l0.p(comparableArr, "<this>");
        return p.kl(comparableArr);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Object D3(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(objArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.ho(objArr, comparator);
    }

    public static /* synthetic */ void D4(int[] iArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = iArr.length;
        }
        q4(iArr, i7, i8);
    }

    public static final int E(@a7.d short[] sArr, short s7, int i7, int i8) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return Arrays.binarySearch(sArr, i7, i8, s7);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ String E0(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        String string = Arrays.toString(bArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @kotlin.internal.f
    private static final boolean[] E1(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, zArr.length);
        kotlin.jvm.internal.l0.o(zArrCopyOf, "copyOf(this, size)");
        return zArrCopyOf;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Double E2(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return p.ll(dArr);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Short E3(short[] sArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.io(sArr, comparator);
    }

    public static /* synthetic */ void E4(long[] jArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = jArr.length;
        }
        s4(jArr, i7, i8);
    }

    public static /* synthetic */ int F(byte[] bArr, byte b8, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = bArr.length;
        }
        return w(bArr, b8, i7, i8);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ String F0(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        String string = Arrays.toString(cArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @kotlin.internal.f
    private static final boolean[] F1(boolean[] zArr, int i7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, i7);
        kotlin.jvm.internal.l0.o(zArrCopyOf, "copyOf(this, newSize)");
        return zArrCopyOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Double F2(Double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return p.ml(dArr);
    }

    @a7.d
    public static byte[] F3(@a7.d byte[] bArr, byte b8) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        int length = bArr.length;
        byte[] result = Arrays.copyOf(bArr, length + 1);
        result[length] = b8;
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    public static /* synthetic */ void F4(Comparable[] comparableArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = comparableArr.length;
        }
        u4(comparableArr, i7, i8);
    }

    public static /* synthetic */ int G(char[] cArr, char c8, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = cArr.length;
        }
        return x(cArr, c8, i7, i8);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ String G0(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        String string = Arrays.toString(dArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @kotlin.g1(version = "1.3")
    @h5.h(name = "copyOfRange")
    @a7.d
    @kotlin.a1
    public static byte[] G1(@a7.d byte[] bArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        m.c(i8, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i7, i8);
        kotlin.jvm.internal.l0.o(bArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Float G2(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return p.nl(fArr);
    }

    @a7.d
    public static final byte[] G3(@a7.d byte[] bArr, @a7.d Collection<Byte> elements) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = bArr.length;
        byte[] result = Arrays.copyOf(bArr, elements.size() + length);
        Iterator<Byte> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().byteValue();
            length++;
        }
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    public static /* synthetic */ void G4(Object[] objArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = objArr.length;
        }
        w4(objArr, i7, i8);
    }

    public static /* synthetic */ int H(double[] dArr, double d8, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = dArr.length;
        }
        return y(dArr, d8, i7, i8);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ String H0(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        String string = Arrays.toString(fArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @kotlin.g1(version = "1.3")
    @h5.h(name = "copyOfRange")
    @a7.d
    @kotlin.a1
    public static final char[] H1(@a7.d char[] cArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        m.c(i8, cArr.length);
        char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i7, i8);
        kotlin.jvm.internal.l0.o(cArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return cArrCopyOfRange;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Float H2(Float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return p.ol(fArr);
    }

    @a7.d
    public static byte[] H3(@a7.d byte[] bArr, @a7.d byte[] elements) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] result = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    public static /* synthetic */ void H4(short[] sArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = sArr.length;
        }
        y4(sArr, i7, i8);
    }

    public static /* synthetic */ int I(float[] fArr, float f8, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = fArr.length;
        }
        return z(fArr, f8, i7, i8);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ String I0(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        String string = Arrays.toString(iArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @kotlin.g1(version = "1.3")
    @h5.h(name = "copyOfRange")
    @a7.d
    @kotlin.a1
    public static final double[] I1(@a7.d double[] dArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        m.c(i8, dArr.length);
        double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i7, i8);
        kotlin.jvm.internal.l0.o(dArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return dArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Integer I2(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return p.pl(iArr);
    }

    @a7.d
    public static final char[] I3(@a7.d char[] cArr, char c8) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        int length = cArr.length;
        char[] result = Arrays.copyOf(cArr, length + 1);
        result[length] = c8;
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    public static final <T> void I4(@a7.d T[] tArr, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static /* synthetic */ int J(int[] iArr, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = iArr.length;
        }
        return A(iArr, i7, i8, i9);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ String J0(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        String string = Arrays.toString(jArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @kotlin.g1(version = "1.3")
    @h5.h(name = "copyOfRange")
    @a7.d
    @kotlin.a1
    public static final float[] J1(@a7.d float[] fArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        m.c(i8, fArr.length);
        float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i7, i8);
        kotlin.jvm.internal.l0.o(fArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return fArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Long J2(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return p.ql(jArr);
    }

    @a7.d
    public static final char[] J3(@a7.d char[] cArr, @a7.d Collection<Character> elements) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = cArr.length;
        char[] result = Arrays.copyOf(cArr, elements.size() + length);
        Iterator<Character> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().charValue();
            length++;
        }
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    public static final <T> void J4(@a7.d T[] tArr, @a7.d Comparator<? super T> comparator, int i7, int i8) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        Arrays.sort(tArr, i7, i8, comparator);
    }

    public static /* synthetic */ int K(long[] jArr, long j7, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = jArr.length;
        }
        return B(jArr, j7, i7, i8);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ <T> String K0(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        String string = Arrays.toString(tArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @kotlin.g1(version = "1.3")
    @h5.h(name = "copyOfRange")
    @a7.d
    @kotlin.a1
    public static int[] K1(@a7.d int[] iArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        m.c(i8, iArr.length);
        int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i7, i8);
        kotlin.jvm.internal.l0.o(iArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return iArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Short K2(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return p.rl(sArr);
    }

    @a7.d
    public static final char[] K3(@a7.d char[] cArr, @a7.d char[] elements) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = cArr.length;
        int length2 = elements.length;
        char[] result = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    public static /* synthetic */ void K4(Object[] objArr, Comparator comparator, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = objArr.length;
        }
        J4(objArr, comparator, i7, i8);
    }

    public static /* synthetic */ int L(Object[] objArr, Object obj, int i7, int i8, int i9, Object obj2) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = objArr.length;
        }
        return C(objArr, obj, i7, i8);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ String L0(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        String string = Arrays.toString(sArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @kotlin.g1(version = "1.3")
    @h5.h(name = "copyOfRange")
    @a7.d
    @kotlin.a1
    public static long[] L1(@a7.d long[] jArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        m.c(i8, jArr.length);
        long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i7, i8);
        kotlin.jvm.internal.l0.o(jArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return jArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean L2(boolean[] zArr, i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z7 = zArr[0];
        int iZe = p.Ze(zArr);
        if (iZe == 0) {
            return Boolean.valueOf(z7);
        }
        R rZ = selector.z(Boolean.valueOf(z7));
        u0 u0VarK = new kotlin.ranges.k(1, iZe).iterator();
        while (u0VarK.hasNext()) {
            boolean z8 = zArr[u0VarK.b()];
            R rZ2 = selector.z(Boolean.valueOf(z8));
            if (rZ.compareTo(rZ2) < 0) {
                z7 = z8;
                rZ = rZ2;
            }
        }
        return Boolean.valueOf(z7);
    }

    @a7.d
    public static final double[] L3(@a7.d double[] dArr, double d8) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        int length = dArr.length;
        double[] result = Arrays.copyOf(dArr, length + 1);
        result[length] = d8;
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigDecimal L4(byte[] bArr, i5.l<? super Byte, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (byte b8 : bArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(Byte.valueOf(b8)));
            kotlin.jvm.internal.l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    public static /* synthetic */ int M(Object[] objArr, Object obj, Comparator comparator, int i7, int i8, int i9, Object obj2) {
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = objArr.length;
        }
        return D(objArr, obj, comparator, i7, i8);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ String M0(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        String string = Arrays.toString(zArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @kotlin.g1(version = "1.3")
    @h5.h(name = "copyOfRange")
    @a7.d
    @kotlin.a1
    public static <T> T[] M1(@a7.d T[] tArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        m.c(i8, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i7, i8);
        kotlin.jvm.internal.l0.o(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte M2(byte[] bArr, i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b8 = bArr[0];
        int iRe = p.Re(bArr);
        if (iRe == 0) {
            return Byte.valueOf(b8);
        }
        R rZ = selector.z(Byte.valueOf(b8));
        u0 u0VarK = new kotlin.ranges.k(1, iRe).iterator();
        while (u0VarK.hasNext()) {
            byte b9 = bArr[u0VarK.b()];
            R rZ2 = selector.z(Byte.valueOf(b9));
            if (rZ.compareTo(rZ2) < 0) {
                b8 = b9;
                rZ = rZ2;
            }
        }
        return Byte.valueOf(b8);
    }

    @a7.d
    public static final double[] M3(@a7.d double[] dArr, @a7.d Collection<Double> elements) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = dArr.length;
        double[] result = Arrays.copyOf(dArr, elements.size() + length);
        Iterator<Double> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().doubleValue();
            length++;
        }
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigDecimal M4(char[] cArr, i5.l<? super Character, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (char c8 : cArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(Character.valueOf(c8)));
            kotlin.jvm.internal.l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    public static /* synthetic */ int N(short[] sArr, short s7, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = sArr.length;
        }
        return E(sArr, s7, i7, i8);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentToStringNullable")
    @kotlin.internal.f
    private static final String N0(byte[] bArr) {
        String string = Arrays.toString(bArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @kotlin.g1(version = "1.3")
    @h5.h(name = "copyOfRange")
    @a7.d
    @kotlin.a1
    public static short[] N1(@a7.d short[] sArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        m.c(i8, sArr.length);
        short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i7, i8);
        kotlin.jvm.internal.l0.o(sArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return sArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character N2(char[] cArr, i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c8 = cArr[0];
        int iSe = p.Se(cArr);
        if (iSe == 0) {
            return Character.valueOf(c8);
        }
        R rZ = selector.z(Character.valueOf(c8));
        u0 u0VarK = new kotlin.ranges.k(1, iSe).iterator();
        while (u0VarK.hasNext()) {
            char c9 = cArr[u0VarK.b()];
            R rZ2 = selector.z(Character.valueOf(c9));
            if (rZ.compareTo(rZ2) < 0) {
                c8 = c9;
                rZ = rZ2;
            }
        }
        return Character.valueOf(c8);
    }

    @a7.d
    public static final double[] N3(@a7.d double[] dArr, @a7.d double[] elements) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = dArr.length;
        int length2 = elements.length;
        double[] result = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigDecimal N4(double[] dArr, i5.l<? super Double, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (double d8 : dArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(Double.valueOf(d8)));
            kotlin.jvm.internal.l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.h
    @h5.h(name = "contentDeepEqualsInline")
    @kotlin.internal.f
    private static final <T> boolean O(T[] tArr, T[] other) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        return n.g(tArr, other);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentToStringNullable")
    @kotlin.internal.f
    private static final String O0(char[] cArr) {
        String string = Arrays.toString(cArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @kotlin.g1(version = "1.3")
    @h5.h(name = "copyOfRange")
    @a7.d
    @kotlin.a1
    public static final boolean[] O1(@a7.d boolean[] zArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        m.c(i8, zArr.length);
        boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i7, i8);
        kotlin.jvm.internal.l0.o(zArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return zArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Double O2(double[] dArr, i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d8 = dArr[0];
        int iTe = p.Te(dArr);
        if (iTe == 0) {
            return Double.valueOf(d8);
        }
        R rZ = selector.z(Double.valueOf(d8));
        u0 u0VarK = new kotlin.ranges.k(1, iTe).iterator();
        while (u0VarK.hasNext()) {
            double d9 = dArr[u0VarK.b()];
            R rZ2 = selector.z(Double.valueOf(d9));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
                d8 = d9;
            }
        }
        return Double.valueOf(d8);
    }

    @a7.d
    public static final float[] O3(@a7.d float[] fArr, float f8) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        int length = fArr.length;
        float[] result = Arrays.copyOf(fArr, length + 1);
        result[length] = f8;
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigDecimal O4(float[] fArr, i5.l<? super Float, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (float f8 : fArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(Float.valueOf(f8)));
            kotlin.jvm.internal.l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentDeepEqualsNullable")
    @kotlin.internal.f
    private static final <T> boolean P(T[] tArr, T[] tArr2) {
        return kotlin.internal.m.a(1, 3, 0) ? n.g(tArr, tArr2) : Arrays.deepEquals(tArr, tArr2);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentToStringNullable")
    @kotlin.internal.f
    private static final String P0(double[] dArr) {
        String string = Arrays.toString(dArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @h5.h(name = "copyOfRangeInline")
    @kotlin.internal.f
    private static final byte[] P1(byte[] bArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (kotlin.internal.m.a(1, 3, 0)) {
            return G1(bArr, i7, i8);
        }
        if (i8 <= bArr.length) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i7, i8);
            kotlin.jvm.internal.l0.o(bArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return bArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i8 + ", size: " + bArr.length);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Float P2(float[] fArr, i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f8 = fArr[0];
        int iUe = p.Ue(fArr);
        if (iUe == 0) {
            return Float.valueOf(f8);
        }
        R rZ = selector.z(Float.valueOf(f8));
        u0 u0VarK = new kotlin.ranges.k(1, iUe).iterator();
        while (u0VarK.hasNext()) {
            float f9 = fArr[u0VarK.b()];
            R rZ2 = selector.z(Float.valueOf(f9));
            if (rZ.compareTo(rZ2) < 0) {
                f8 = f9;
                rZ = rZ2;
            }
        }
        return Float.valueOf(f8);
    }

    @a7.d
    public static final float[] P3(@a7.d float[] fArr, @a7.d Collection<Float> elements) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = fArr.length;
        float[] result = Arrays.copyOf(fArr, elements.size() + length);
        Iterator<Float> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().floatValue();
            length++;
        }
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigDecimal P4(int[] iArr, i5.l<? super Integer, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (int i7 : iArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(Integer.valueOf(i7)));
            kotlin.jvm.internal.l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.h
    @h5.h(name = "contentDeepHashCodeInline")
    @kotlin.internal.f
    private static final <T> int Q(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return m.b(tArr);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentToStringNullable")
    @kotlin.internal.f
    private static final String Q0(float[] fArr) {
        String string = Arrays.toString(fArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @h5.h(name = "copyOfRangeInline")
    @kotlin.internal.f
    private static final char[] Q1(char[] cArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (kotlin.internal.m.a(1, 3, 0)) {
            return H1(cArr, i7, i8);
        }
        if (i8 <= cArr.length) {
            char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i7, i8);
            kotlin.jvm.internal.l0.o(cArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return cArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i8 + ", size: " + cArr.length);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer Q2(int[] iArr, i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i7 = iArr[0];
        int iVe = p.Ve(iArr);
        if (iVe == 0) {
            return Integer.valueOf(i7);
        }
        R rZ = selector.z(Integer.valueOf(i7));
        u0 u0VarK = new kotlin.ranges.k(1, iVe).iterator();
        while (u0VarK.hasNext()) {
            int i8 = iArr[u0VarK.b()];
            R rZ2 = selector.z(Integer.valueOf(i8));
            if (rZ.compareTo(rZ2) < 0) {
                i7 = i8;
                rZ = rZ2;
            }
        }
        return Integer.valueOf(i7);
    }

    @a7.d
    public static final float[] Q3(@a7.d float[] fArr, @a7.d float[] elements) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = fArr.length;
        int length2 = elements.length;
        float[] result = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigDecimal Q4(long[] jArr, i5.l<? super Long, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (long j7 : jArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(Long.valueOf(j7)));
            kotlin.jvm.internal.l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentDeepHashCodeNullable")
    @kotlin.internal.f
    private static final <T> int R(T[] tArr) {
        return kotlin.internal.m.a(1, 3, 0) ? m.b(tArr) : Arrays.deepHashCode(tArr);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentToStringNullable")
    @kotlin.internal.f
    private static final String R0(int[] iArr) {
        String string = Arrays.toString(iArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @h5.h(name = "copyOfRangeInline")
    @kotlin.internal.f
    private static final double[] R1(double[] dArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (kotlin.internal.m.a(1, 3, 0)) {
            return I1(dArr, i7, i8);
        }
        if (i8 <= dArr.length) {
            double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i7, i8);
            kotlin.jvm.internal.l0.o(dArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return dArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i8 + ", size: " + dArr.length);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Long R2(long[] jArr, i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j7 = jArr[0];
        int iWe = p.We(jArr);
        if (iWe == 0) {
            return Long.valueOf(j7);
        }
        R rZ = selector.z(Long.valueOf(j7));
        u0 u0VarK = new kotlin.ranges.k(1, iWe).iterator();
        while (u0VarK.hasNext()) {
            long j8 = jArr[u0VarK.b()];
            R rZ2 = selector.z(Long.valueOf(j8));
            if (rZ.compareTo(rZ2) < 0) {
                rZ = rZ2;
                j7 = j8;
            }
        }
        return Long.valueOf(j7);
    }

    @a7.d
    public static int[] R3(@a7.d int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        int length = iArr.length;
        int[] result = Arrays.copyOf(iArr, length + 1);
        result[length] = i7;
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T> BigDecimal R4(T[] tArr, i5.l<? super T, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (T t7 : tArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(t7));
            kotlin.jvm.internal.l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.internal.h
    @h5.h(name = "contentDeepToStringInline")
    @kotlin.internal.f
    private static final <T> String S(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return n.h(tArr);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentToStringNullable")
    @kotlin.internal.f
    private static final String S0(long[] jArr) {
        String string = Arrays.toString(jArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @h5.h(name = "copyOfRangeInline")
    @kotlin.internal.f
    private static final float[] S1(float[] fArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (kotlin.internal.m.a(1, 3, 0)) {
            return J1(fArr, i7, i8);
        }
        if (i8 <= fArr.length) {
            float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i7, i8);
            kotlin.jvm.internal.l0.o(fArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return fArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i8 + ", size: " + fArr.length);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T S2(T[] tArr, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t7 = tArr[0];
        int iXe = p.Xe(tArr);
        if (iXe != 0) {
            R rZ = selector.z(t7);
            u0 u0VarK = new kotlin.ranges.k(1, iXe).iterator();
            while (u0VarK.hasNext()) {
                T t8 = tArr[u0VarK.b()];
                R rZ2 = selector.z(t8);
                if (rZ.compareTo(rZ2) < 0) {
                    t7 = t8;
                    rZ = rZ2;
                }
            }
        }
        return t7;
    }

    @a7.d
    public static final int[] S3(@a7.d int[] iArr, @a7.d Collection<Integer> elements) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = iArr.length;
        int[] result = Arrays.copyOf(iArr, elements.size() + length);
        Iterator<Integer> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().intValue();
            length++;
        }
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigDecimal S4(short[] sArr, i5.l<? super Short, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (short s7 : sArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(Short.valueOf(s7)));
            kotlin.jvm.internal.l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentDeepToStringNullable")
    @kotlin.internal.f
    private static final <T> String T(T[] tArr) {
        if (kotlin.internal.m.a(1, 3, 0)) {
            return n.h(tArr);
        }
        String strDeepToString = Arrays.deepToString(tArr);
        kotlin.jvm.internal.l0.o(strDeepToString, "deepToString(this)");
        return strDeepToString;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentToStringNullable")
    @kotlin.internal.f
    private static final <T> String T0(T[] tArr) {
        String string = Arrays.toString(tArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @h5.h(name = "copyOfRangeInline")
    @kotlin.internal.f
    private static final int[] T1(int[] iArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (kotlin.internal.m.a(1, 3, 0)) {
            return K1(iArr, i7, i8);
        }
        if (i8 <= iArr.length) {
            int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i7, i8);
            kotlin.jvm.internal.l0.o(iArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return iArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i8 + ", size: " + iArr.length);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Short T2(short[] sArr, i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s7 = sArr[0];
        int iYe = p.Ye(sArr);
        if (iYe == 0) {
            return Short.valueOf(s7);
        }
        R rZ = selector.z(Short.valueOf(s7));
        u0 u0VarK = new kotlin.ranges.k(1, iYe).iterator();
        while (u0VarK.hasNext()) {
            short s8 = sArr[u0VarK.b()];
            R rZ2 = selector.z(Short.valueOf(s8));
            if (rZ.compareTo(rZ2) < 0) {
                s7 = s8;
                rZ = rZ2;
            }
        }
        return Short.valueOf(s7);
    }

    @a7.d
    public static int[] T3(@a7.d int[] iArr, @a7.d int[] elements) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] result = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigDecimal")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigDecimal T4(boolean[] zArr, i5.l<? super Boolean, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (boolean z7 : zArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.z(Boolean.valueOf(z7)));
            kotlin.jvm.internal.l0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ boolean U(byte[] bArr, byte[] other) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        return Arrays.equals(bArr, other);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentToStringNullable")
    @kotlin.internal.f
    private static final String U0(short[] sArr) {
        String string = Arrays.toString(sArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @h5.h(name = "copyOfRangeInline")
    @kotlin.internal.f
    private static final long[] U1(long[] jArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (kotlin.internal.m.a(1, 3, 0)) {
            return L1(jArr, i7, i8);
        }
        if (i8 <= jArr.length) {
            long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i7, i8);
            kotlin.jvm.internal.l0.o(jArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return jArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i8 + ", size: " + jArr.length);
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Boolean U2(boolean[] zArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.Cl(zArr, comparator);
    }

    @a7.d
    public static long[] U3(@a7.d long[] jArr, long j7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        int length = jArr.length;
        long[] result = Arrays.copyOf(jArr, length + 1);
        result[length] = j7;
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigInteger U4(byte[] bArr, i5.l<? super Byte, ? extends BigInteger> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (byte b8 : bArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(Byte.valueOf(b8)));
            kotlin.jvm.internal.l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ boolean V(char[] cArr, char[] other) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        return Arrays.equals(cArr, other);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentToStringNullable")
    @kotlin.internal.f
    private static final String V0(boolean[] zArr) {
        String string = Arrays.toString(zArr);
        kotlin.jvm.internal.l0.o(string, "toString(this)");
        return string;
    }

    @h5.h(name = "copyOfRangeInline")
    @kotlin.internal.f
    private static final <T> T[] V1(T[] tArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (kotlin.internal.m.a(1, 3, 0)) {
            return (T[]) M1(tArr, i7, i8);
        }
        if (i8 <= tArr.length) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i7, i8);
            kotlin.jvm.internal.l0.o(tArr2, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return tArr2;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i8 + ", size: " + tArr.length);
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Byte V2(byte[] bArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.Dl(bArr, comparator);
    }

    @a7.d
    public static final long[] V3(@a7.d long[] jArr, @a7.d Collection<Long> elements) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = jArr.length;
        long[] result = Arrays.copyOf(jArr, elements.size() + length);
        Iterator<Long> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().longValue();
            length++;
        }
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigInteger V4(char[] cArr, i5.l<? super Character, ? extends BigInteger> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (char c8 : cArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(Character.valueOf(c8)));
            kotlin.jvm.internal.l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ boolean W(double[] dArr, double[] other) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        return Arrays.equals(dArr, other);
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static byte[] W0(@a7.d byte[] bArr, @a7.d byte[] destination, int i7, int i8, int i9) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        System.arraycopy(bArr, i8, destination, i7, i9 - i8);
        return destination;
    }

    @h5.h(name = "copyOfRangeInline")
    @kotlin.internal.f
    private static final short[] W1(short[] sArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (kotlin.internal.m.a(1, 3, 0)) {
            return N1(sArr, i7, i8);
        }
        if (i8 <= sArr.length) {
            short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i7, i8);
            kotlin.jvm.internal.l0.o(sArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return sArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i8 + ", size: " + sArr.length);
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Character W2(char[] cArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.El(cArr, comparator);
    }

    @a7.d
    public static long[] W3(@a7.d long[] jArr, @a7.d long[] elements) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = jArr.length;
        int length2 = elements.length;
        long[] result = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigInteger W4(double[] dArr, i5.l<? super Double, ? extends BigInteger> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (double d8 : dArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(Double.valueOf(d8)));
            kotlin.jvm.internal.l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ boolean X(float[] fArr, float[] other) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        return Arrays.equals(fArr, other);
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static final char[] X0(@a7.d char[] cArr, @a7.d char[] destination, int i7, int i8, int i9) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        System.arraycopy(cArr, i8, destination, i7, i9 - i8);
        return destination;
    }

    @h5.h(name = "copyOfRangeInline")
    @kotlin.internal.f
    private static final boolean[] X1(boolean[] zArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        if (kotlin.internal.m.a(1, 3, 0)) {
            return O1(zArr, i7, i8);
        }
        if (i8 <= zArr.length) {
            boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i7, i8);
            kotlin.jvm.internal.l0.o(zArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return zArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i8 + ", size: " + zArr.length);
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Double X2(double[] dArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.Fl(dArr, comparator);
    }

    @a7.d
    public static <T> T[] X3(@a7.d T[] tArr, T t7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        int length = tArr.length;
        T[] result = (T[]) Arrays.copyOf(tArr, length + 1);
        result[length] = t7;
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigInteger X4(float[] fArr, i5.l<? super Float, ? extends BigInteger> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (float f8 : fArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(Float.valueOf(f8)));
            kotlin.jvm.internal.l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ boolean Y(int[] iArr, int[] other) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        return Arrays.equals(iArr, other);
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static final double[] Y0(@a7.d double[] dArr, @a7.d double[] destination, int i7, int i8, int i9) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        System.arraycopy(dArr, i8, destination, i7, i9 - i8);
        return destination;
    }

    @kotlin.internal.f
    private static final byte Y1(byte[] bArr, int i7) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return bArr[i7];
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Float Y2(float[] fArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.Gl(fArr, comparator);
    }

    @a7.d
    public static final <T> T[] Y3(@a7.d T[] tArr, @a7.d Collection<? extends T> elements) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = tArr.length;
        T[] result = (T[]) Arrays.copyOf(tArr, elements.size() + length);
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next();
            length++;
        }
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigInteger Y4(int[] iArr, i5.l<? super Integer, ? extends BigInteger> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (int i7 : iArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(Integer.valueOf(i7)));
            kotlin.jvm.internal.l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ boolean Z(long[] jArr, long[] other) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        return Arrays.equals(jArr, other);
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static final float[] Z0(@a7.d float[] fArr, @a7.d float[] destination, int i7, int i8, int i9) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        System.arraycopy(fArr, i8, destination, i7, i9 - i8);
        return destination;
    }

    @kotlin.internal.f
    private static final char Z1(char[] cArr, int i7) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return cArr[i7];
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Integer Z2(int[] iArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.Hl(iArr, comparator);
    }

    @a7.d
    public static final <T> T[] Z3(@a7.d T[] tArr, @a7.d T[] elements) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] result = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigInteger Z4(long[] jArr, i5.l<? super Long, ? extends BigInteger> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (long j7 : jArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(Long.valueOf(j7)));
            kotlin.jvm.internal.l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ <T> boolean a0(T[] tArr, T[] other) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        return Arrays.equals(tArr, other);
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static int[] a1(@a7.d int[] iArr, @a7.d int[] destination, int i7, int i8, int i9) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        System.arraycopy(iArr, i8, destination, i7, i9 - i8);
        return destination;
    }

    @kotlin.internal.f
    private static final double a2(double[] dArr, int i7) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return dArr[i7];
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Long a3(long[] jArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.Il(jArr, comparator);
    }

    @a7.d
    public static final short[] a4(@a7.d short[] sArr, @a7.d Collection<Short> elements) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = sArr.length;
        short[] result = Arrays.copyOf(sArr, elements.size() + length);
        Iterator<Short> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().shortValue();
            length++;
        }
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @kotlin.t0
    @kotlin.internal.f
    private static final <T> BigInteger a5(T[] tArr, i5.l<? super T, ? extends BigInteger> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (T t7 : tArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(t7));
            kotlin.jvm.internal.l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ boolean b0(short[] sArr, short[] other) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        return Arrays.equals(sArr, other);
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static long[] b1(@a7.d long[] jArr, @a7.d long[] destination, int i7, int i8, int i9) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        System.arraycopy(jArr, i8, destination, i7, i9 - i8);
        return destination;
    }

    @kotlin.internal.f
    private static final float b2(float[] fArr, int i7) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return fArr[i7];
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Object b3(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(objArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.Jl(objArr, comparator);
    }

    @a7.d
    public static short[] b4(@a7.d short[] sArr, short s7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        int length = sArr.length;
        short[] result = Arrays.copyOf(sArr, length + 1);
        result[length] = s7;
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigInteger b5(short[] sArr, i5.l<? super Short, ? extends BigInteger> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (short s7 : sArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(Short.valueOf(s7)));
            kotlin.jvm.internal.l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ boolean c0(boolean[] zArr, boolean[] other) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        return Arrays.equals(zArr, other);
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static <T> T[] c1(@a7.d T[] tArr, @a7.d T[] destination, int i7, int i8, int i9) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        System.arraycopy(tArr, i8, destination, i7, i9 - i8);
        return destination;
    }

    @kotlin.internal.f
    private static final int c2(int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return iArr[i7];
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Short c3(short[] sArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.Kl(sArr, comparator);
    }

    @a7.d
    public static short[] c4(@a7.d short[] sArr, @a7.d short[] elements) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = sArr.length;
        int length2 = elements.length;
        short[] result = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "sumOfBigInteger")
    @kotlin.t0
    @kotlin.internal.f
    private static final BigInteger c5(boolean[] zArr, i5.l<? super Boolean, ? extends BigInteger> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (boolean z7 : zArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.z(Boolean.valueOf(z7)));
            kotlin.jvm.internal.l0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentEqualsNullable")
    @kotlin.internal.f
    private static final boolean d0(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static short[] d1(@a7.d short[] sArr, @a7.d short[] destination, int i7, int i8, int i9) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        System.arraycopy(sArr, i8, destination, i7, i9 - i8);
        return destination;
    }

    @kotlin.internal.f
    private static final long d2(long[] jArr, int i7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return jArr[i7];
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Byte d3(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return p.Gn(bArr);
    }

    @a7.d
    public static final boolean[] d4(@a7.d boolean[] zArr, @a7.d Collection<Boolean> elements) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = zArr.length;
        boolean[] result = Arrays.copyOf(zArr, elements.size() + length);
        Iterator<Boolean> it = elements.iterator();
        while (it.hasNext()) {
            result[length] = it.next().booleanValue();
            length++;
        }
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @a7.d
    public static final SortedSet<Byte> d5(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return (SortedSet) p.Jy(bArr, new TreeSet());
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentEqualsNullable")
    @kotlin.internal.f
    private static final boolean e0(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    @a7.d
    @kotlin.g1(version = "1.3")
    public static final boolean[] e1(@a7.d boolean[] zArr, @a7.d boolean[] destination, int i7, int i8, int i9) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        System.arraycopy(zArr, i8, destination, i7, i9 - i8);
        return destination;
    }

    @kotlin.internal.f
    private static final <T> T e2(T[] tArr, int i7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return tArr[i7];
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Character e3(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return p.Hn(cArr);
    }

    @a7.d
    public static final boolean[] e4(@a7.d boolean[] zArr, boolean z7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        int length = zArr.length;
        boolean[] result = Arrays.copyOf(zArr, length + 1);
        result[length] = z7;
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @a7.d
    public static final SortedSet<Character> e5(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return (SortedSet) p.Ky(cArr, new TreeSet());
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentEqualsNullable")
    @kotlin.internal.f
    private static final boolean f0(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    public static /* synthetic */ byte[] f1(byte[] bArr, byte[] bArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = bArr.length;
        }
        return W0(bArr, bArr2, i7, i8, i9);
    }

    @kotlin.internal.f
    private static final short f2(short[] sArr, int i7) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return sArr[i7];
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Comparable f3(Comparable[] comparableArr) {
        kotlin.jvm.internal.l0.p(comparableArr, "<this>");
        return p.In(comparableArr);
    }

    @a7.d
    public static final boolean[] f4(@a7.d boolean[] zArr, @a7.d boolean[] elements) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(elements, "elements");
        int length = zArr.length;
        int length2 = elements.length;
        boolean[] result = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.l0.o(result, "result");
        return result;
    }

    @a7.d
    public static final SortedSet<Double> f5(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return (SortedSet) p.Ly(dArr, new TreeSet());
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentEqualsNullable")
    @kotlin.internal.f
    private static final boolean g0(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    public static /* synthetic */ char[] g1(char[] cArr, char[] cArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = cArr.length;
        }
        return X0(cArr, cArr2, i7, i8, i9);
    }

    @kotlin.internal.f
    private static final boolean g2(boolean[] zArr, int i7) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return zArr[i7];
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Double g3(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return p.Jn(dArr);
    }

    @kotlin.internal.f
    private static final <T> T[] g4(T[] tArr, T t7) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return (T[]) X3(tArr, t7);
    }

    @a7.d
    public static final SortedSet<Float> g5(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return (SortedSet) p.My(fArr, new TreeSet());
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentEqualsNullable")
    @kotlin.internal.f
    private static final boolean h0(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    public static /* synthetic */ double[] h1(double[] dArr, double[] dArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = dArr.length;
        }
        return Y0(dArr, dArr2, i7, i8, i9);
    }

    public static void h2(@a7.d byte[] bArr, byte b8, int i7, int i8) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        Arrays.fill(bArr, i7, i8, b8);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Double h3(Double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return p.Kn(dArr);
    }

    public static final void h4(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    @a7.d
    public static final SortedSet<Integer> h5(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return (SortedSet) p.Ny(iArr, new TreeSet());
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentEqualsNullable")
    @kotlin.internal.f
    private static final boolean i0(long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    public static /* synthetic */ float[] i1(float[] fArr, float[] fArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = fArr.length;
        }
        return Z0(fArr, fArr2, i7, i8, i9);
    }

    public static final void i2(@a7.d char[] cArr, char c8, int i7, int i8) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        Arrays.fill(cArr, i7, i8, c8);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Float i3(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return p.Ln(fArr);
    }

    public static final void i4(@a7.d byte[] bArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        Arrays.sort(bArr, i7, i8);
    }

    @a7.d
    public static final SortedSet<Long> i5(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return (SortedSet) p.Oy(jArr, new TreeSet());
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentEqualsNullable")
    @kotlin.internal.f
    private static final <T> boolean j0(T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    public static /* synthetic */ int[] j1(int[] iArr, int[] iArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = iArr.length;
        }
        return a1(iArr, iArr2, i7, i8, i9);
    }

    public static final void j2(@a7.d double[] dArr, double d8, int i7, int i8) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        Arrays.fill(dArr, i7, i8, d8);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Float j3(Float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return p.Mn(fArr);
    }

    public static final void j4(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    @a7.d
    public static final <T extends Comparable<? super T>> SortedSet<T> j5(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return (SortedSet) p.Py(tArr, new TreeSet());
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentEqualsNullable")
    @kotlin.internal.f
    private static final boolean k0(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    public static /* synthetic */ long[] k1(long[] jArr, long[] jArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = jArr.length;
        }
        return b1(jArr, jArr2, i7, i8, i9);
    }

    public static final void k2(@a7.d float[] fArr, float f8, int i7, int i8) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        Arrays.fill(fArr, i7, i8, f8);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Integer k3(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return p.Nn(iArr);
    }

    public static final void k4(@a7.d char[] cArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        Arrays.sort(cArr, i7, i8);
    }

    @a7.d
    public static final <T> SortedSet<T> k5(@a7.d T[] tArr, @a7.d Comparator<? super T> comparator) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return (SortedSet) p.Py(tArr, new TreeSet(comparator));
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentEqualsNullable")
    @kotlin.internal.f
    private static final boolean l0(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    public static /* synthetic */ Object[] l1(Object[] objArr, Object[] objArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = objArr.length;
        }
        return c1(objArr, objArr2, i7, i8, i9);
    }

    public static void l2(@a7.d int[] iArr, int i7, int i8, int i9) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        Arrays.fill(iArr, i8, i9, i7);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Long l3(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return p.On(jArr);
    }

    public static final void l4(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    @a7.d
    public static final SortedSet<Short> l5(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return (SortedSet) p.Qy(sArr, new TreeSet());
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ int m0(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return Arrays.hashCode(bArr);
    }

    public static /* synthetic */ short[] m1(short[] sArr, short[] sArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = sArr.length;
        }
        return d1(sArr, sArr2, i7, i8, i9);
    }

    public static void m2(@a7.d long[] jArr, long j7, int i7, int i8) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        Arrays.fill(jArr, i7, i8, j7);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Short m3(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return p.Pn(sArr);
    }

    public static final void m4(@a7.d double[] dArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        Arrays.sort(dArr, i7, i8);
    }

    @a7.d
    public static final SortedSet<Boolean> m5(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return (SortedSet) p.Ry(zArr, new TreeSet());
    }

    @a7.d
    public static final List<Byte> n(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return new a(bArr);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ int n0(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return Arrays.hashCode(cArr);
    }

    public static /* synthetic */ boolean[] n1(boolean[] zArr, boolean[] zArr2, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = zArr.length;
        }
        return e1(zArr, zArr2, i7, i8, i9);
    }

    public static <T> void n2(@a7.d T[] tArr, T t7, int i7, int i8) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        Arrays.fill(tArr, i7, i8, t7);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean n3(boolean[] zArr, i5.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z7 = zArr[0];
        int iZe = p.Ze(zArr);
        if (iZe == 0) {
            return Boolean.valueOf(z7);
        }
        R rZ = selector.z(Boolean.valueOf(z7));
        u0 u0VarK = new kotlin.ranges.k(1, iZe).iterator();
        while (u0VarK.hasNext()) {
            boolean z8 = zArr[u0VarK.b()];
            R rZ2 = selector.z(Boolean.valueOf(z8));
            if (rZ.compareTo(rZ2) > 0) {
                z7 = z8;
                rZ = rZ2;
            }
        }
        return Boolean.valueOf(z7);
    }

    public static final void n4(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    @a7.d
    public static final Boolean[] n5(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            boolArr[i7] = Boolean.valueOf(zArr[i7]);
        }
        return boolArr;
    }

    @a7.d
    public static final List<Character> o(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return new h(cArr);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ int o0(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return Arrays.hashCode(dArr);
    }

    @kotlin.internal.f
    private static final byte[] o1(byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.l0.o(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public static void o2(@a7.d short[] sArr, short s7, int i7, int i8) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        Arrays.fill(sArr, i7, i8, s7);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte o3(byte[] bArr, i5.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b8 = bArr[0];
        int iRe = p.Re(bArr);
        if (iRe == 0) {
            return Byte.valueOf(b8);
        }
        R rZ = selector.z(Byte.valueOf(b8));
        u0 u0VarK = new kotlin.ranges.k(1, iRe).iterator();
        while (u0VarK.hasNext()) {
            byte b9 = bArr[u0VarK.b()];
            R rZ2 = selector.z(Byte.valueOf(b9));
            if (rZ.compareTo(rZ2) > 0) {
                b8 = b9;
                rZ = rZ2;
            }
        }
        return Byte.valueOf(b8);
    }

    public static final void o4(@a7.d float[] fArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        Arrays.sort(fArr, i7, i8);
    }

    @a7.d
    public static final Byte[] o5(@a7.d byte[] bArr) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            bArr2[i7] = Byte.valueOf(bArr[i7]);
        }
        return bArr2;
    }

    @a7.d
    public static List<Double> p(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return new f(dArr);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ int p0(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return Arrays.hashCode(fArr);
    }

    @kotlin.internal.f
    private static final byte[] p1(byte[] bArr, int i7) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i7);
        kotlin.jvm.internal.l0.o(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }

    public static final void p2(@a7.d boolean[] zArr, boolean z7, int i7, int i8) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        Arrays.fill(zArr, i7, i8, z7);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character p3(char[] cArr, i5.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c8 = cArr[0];
        int iSe = p.Se(cArr);
        if (iSe == 0) {
            return Character.valueOf(c8);
        }
        R rZ = selector.z(Character.valueOf(c8));
        u0 u0VarK = new kotlin.ranges.k(1, iSe).iterator();
        while (u0VarK.hasNext()) {
            char c9 = cArr[u0VarK.b()];
            R rZ2 = selector.z(Character.valueOf(c9));
            if (rZ.compareTo(rZ2) > 0) {
                c8 = c9;
                rZ = rZ2;
            }
        }
        return Character.valueOf(c8);
    }

    public static final void p4(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    @a7.d
    public static final Character[] p5(@a7.d char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            chArr[i7] = Character.valueOf(cArr[i7]);
        }
        return chArr;
    }

    @a7.d
    public static final List<Float> q(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return new e(fArr);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ int q0(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return Arrays.hashCode(iArr);
    }

    @kotlin.internal.f
    private static final char[] q1(char[] cArr) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.l0.o(cArrCopyOf, "copyOf(this, size)");
        return cArrCopyOf;
    }

    public static /* synthetic */ void q2(byte[] bArr, byte b8, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = bArr.length;
        }
        h2(bArr, b8, i7, i8);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Double q3(double[] dArr, i5.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d8 = dArr[0];
        int iTe = p.Te(dArr);
        if (iTe == 0) {
            return Double.valueOf(d8);
        }
        R rZ = selector.z(Double.valueOf(d8));
        u0 u0VarK = new kotlin.ranges.k(1, iTe).iterator();
        while (u0VarK.hasNext()) {
            double d9 = dArr[u0VarK.b()];
            R rZ2 = selector.z(Double.valueOf(d9));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
                d8 = d9;
            }
        }
        return Double.valueOf(d8);
    }

    public static final void q4(@a7.d int[] iArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        Arrays.sort(iArr, i7, i8);
    }

    @a7.d
    public static final Double[] q5(@a7.d double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            dArr2[i7] = Double.valueOf(dArr[i7]);
        }
        return dArr2;
    }

    @a7.d
    public static List<Integer> r(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        return new c(iArr);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ int r0(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return Arrays.hashCode(jArr);
    }

    @kotlin.internal.f
    private static final char[] r1(char[] cArr, int i7) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, i7);
        kotlin.jvm.internal.l0.o(cArrCopyOf, "copyOf(this, newSize)");
        return cArrCopyOf;
    }

    public static /* synthetic */ void r2(char[] cArr, char c8, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = cArr.length;
        }
        i2(cArr, c8, i7, i8);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Float r3(float[] fArr, i5.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f8 = fArr[0];
        int iUe = p.Ue(fArr);
        if (iUe == 0) {
            return Float.valueOf(f8);
        }
        R rZ = selector.z(Float.valueOf(f8));
        u0 u0VarK = new kotlin.ranges.k(1, iUe).iterator();
        while (u0VarK.hasNext()) {
            float f9 = fArr[u0VarK.b()];
            R rZ2 = selector.z(Float.valueOf(f9));
            if (rZ.compareTo(rZ2) > 0) {
                f8 = f9;
                rZ = rZ2;
            }
        }
        return Float.valueOf(f8);
    }

    public static final void r4(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    @a7.d
    public static final Float[] r5(@a7.d float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            fArr2[i7] = Float.valueOf(fArr[i7]);
        }
        return fArr2;
    }

    @a7.d
    public static List<Long> s(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        return new d(jArr);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ <T> int s0(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        return Arrays.hashCode(tArr);
    }

    @kotlin.internal.f
    private static final double[] s1(double[] dArr) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.l0.o(dArrCopyOf, "copyOf(this, size)");
        return dArrCopyOf;
    }

    public static /* synthetic */ void s2(double[] dArr, double d8, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = dArr.length;
        }
        j2(dArr, d8, i7, i8);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer s3(int[] iArr, i5.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i7 = iArr[0];
        int iVe = p.Ve(iArr);
        if (iVe == 0) {
            return Integer.valueOf(i7);
        }
        R rZ = selector.z(Integer.valueOf(i7));
        u0 u0VarK = new kotlin.ranges.k(1, iVe).iterator();
        while (u0VarK.hasNext()) {
            int i8 = iArr[u0VarK.b()];
            R rZ2 = selector.z(Integer.valueOf(i8));
            if (rZ.compareTo(rZ2) > 0) {
                i7 = i8;
                rZ = rZ2;
            }
        }
        return Integer.valueOf(i7);
    }

    public static final void s4(@a7.d long[] jArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        Arrays.sort(jArr, i7, i8);
    }

    @a7.d
    public static final Integer[] s5(@a7.d int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            numArr[i7] = Integer.valueOf(iArr[i7]);
        }
        return numArr;
    }

    @a7.d
    public static <T> List<T> t(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        List<T> listA = q.a(tArr);
        kotlin.jvm.internal.l0.o(listA, "asList(this)");
        return listA;
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ int t0(short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return Arrays.hashCode(sArr);
    }

    @kotlin.internal.f
    private static final double[] t1(double[] dArr, int i7) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, i7);
        kotlin.jvm.internal.l0.o(dArrCopyOf, "copyOf(this, newSize)");
        return dArrCopyOf;
    }

    public static /* synthetic */ void t2(float[] fArr, float f8, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = fArr.length;
        }
        k2(fArr, f8, i7, i8);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Long t3(long[] jArr, i5.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j7 = jArr[0];
        int iWe = p.We(jArr);
        if (iWe == 0) {
            return Long.valueOf(j7);
        }
        R rZ = selector.z(Long.valueOf(j7));
        u0 u0VarK = new kotlin.ranges.k(1, iWe).iterator();
        while (u0VarK.hasNext()) {
            long j8 = jArr[u0VarK.b()];
            R rZ2 = selector.z(Long.valueOf(j8));
            if (rZ.compareTo(rZ2) > 0) {
                rZ = rZ2;
                j7 = j8;
            }
        }
        return Long.valueOf(j7);
    }

    @kotlin.internal.f
    private static final <T extends Comparable<? super T>> void t4(T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        v4(tArr);
    }

    @a7.d
    public static final Long[] t5(@a7.d long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            lArr[i7] = Long.valueOf(jArr[i7]);
        }
        return lArr;
    }

    @a7.d
    public static final List<Short> u(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        return new b(sArr);
    }

    @kotlin.g1(version = "1.1")
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    @kotlin.internal.f
    private static final /* synthetic */ int u0(boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return Arrays.hashCode(zArr);
    }

    @kotlin.internal.f
    private static final float[] u1(float[] fArr) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.l0.o(fArrCopyOf, "copyOf(this, size)");
        return fArrCopyOf;
    }

    public static /* synthetic */ void u2(int[] iArr, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            i9 = iArr.length;
        }
        l2(iArr, i7, i8, i9);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T u3(T[] tArr, i5.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t7 = tArr[0];
        int iXe = p.Xe(tArr);
        if (iXe != 0) {
            R rZ = selector.z(t7);
            u0 u0VarK = new kotlin.ranges.k(1, iXe).iterator();
            while (u0VarK.hasNext()) {
                T t8 = tArr[u0VarK.b()];
                R rZ2 = selector.z(t8);
                if (rZ.compareTo(rZ2) > 0) {
                    t7 = t8;
                    rZ = rZ2;
                }
            }
        }
        return t7;
    }

    @kotlin.g1(version = "1.4")
    public static final <T extends Comparable<? super T>> void u4(@a7.d T[] tArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        Arrays.sort(tArr, i7, i8);
    }

    @a7.d
    public static final Short[] u5(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            shArr[i7] = Short.valueOf(sArr[i7]);
        }
        return shArr;
    }

    @a7.d
    public static final List<Boolean> v(@a7.d boolean[] zArr) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        return new g(zArr);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentHashCodeNullable")
    @kotlin.internal.f
    private static final int v0(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @kotlin.internal.f
    private static final float[] v1(float[] fArr, int i7) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, i7);
        kotlin.jvm.internal.l0.o(fArrCopyOf, "copyOf(this, newSize)");
        return fArrCopyOf;
    }

    public static /* synthetic */ void v2(long[] jArr, long j7, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = jArr.length;
        }
        m2(jArr, j7, i7, i8);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Short v3(short[] sArr, i5.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        kotlin.jvm.internal.l0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s7 = sArr[0];
        int iYe = p.Ye(sArr);
        if (iYe == 0) {
            return Short.valueOf(s7);
        }
        R rZ = selector.z(Short.valueOf(s7));
        u0 u0VarK = new kotlin.ranges.k(1, iYe).iterator();
        while (u0VarK.hasNext()) {
            short s8 = sArr[u0VarK.b()];
            R rZ2 = selector.z(Short.valueOf(s8));
            if (rZ.compareTo(rZ2) > 0) {
                s7 = s8;
                rZ = rZ2;
            }
        }
        return Short.valueOf(s7);
    }

    public static final <T> void v4(@a7.d T[] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final int w(@a7.d byte[] bArr, byte b8, int i7, int i8) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        return Arrays.binarySearch(bArr, i7, i8, b8);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentHashCodeNullable")
    @kotlin.internal.f
    private static final int w0(char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    @kotlin.internal.f
    private static final int[] w1(int[] iArr) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.l0.o(iArrCopyOf, "copyOf(this, size)");
        return iArrCopyOf;
    }

    public static /* synthetic */ void w2(Object[] objArr, Object obj, int i7, int i8, int i9, Object obj2) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = objArr.length;
        }
        n2(objArr, obj, i7, i8);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Boolean w3(boolean[] zArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(zArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.ao(zArr, comparator);
    }

    public static final <T> void w4(@a7.d T[] tArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        Arrays.sort(tArr, i7, i8);
    }

    public static final int x(@a7.d char[] cArr, char c8, int i7, int i8) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        return Arrays.binarySearch(cArr, i7, i8, c8);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentHashCodeNullable")
    @kotlin.internal.f
    private static final int x0(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    @kotlin.internal.f
    private static final int[] x1(int[] iArr, int i7) {
        kotlin.jvm.internal.l0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, i7);
        kotlin.jvm.internal.l0.o(iArrCopyOf, "copyOf(this, newSize)");
        return iArrCopyOf;
    }

    public static /* synthetic */ void x2(short[] sArr, short s7, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = sArr.length;
        }
        o2(sArr, s7, i7, i8);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Byte x3(byte[] bArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(bArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.bo(bArr, comparator);
    }

    public static final void x4(@a7.d short[] sArr) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    public static final int y(@a7.d double[] dArr, double d8, int i7, int i8) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        return Arrays.binarySearch(dArr, i7, i8, d8);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentHashCodeNullable")
    @kotlin.internal.f
    private static final int y0(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    @kotlin.internal.f
    private static final long[] y1(long[] jArr) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.l0.o(jArrCopyOf, "copyOf(this, size)");
        return jArrCopyOf;
    }

    public static /* synthetic */ void y2(boolean[] zArr, boolean z7, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            i8 = zArr.length;
        }
        p2(zArr, z7, i7, i8);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Character y3(char[] cArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(cArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.co(cArr, comparator);
    }

    public static final void y4(@a7.d short[] sArr, int i7, int i8) {
        kotlin.jvm.internal.l0.p(sArr, "<this>");
        Arrays.sort(sArr, i7, i8);
    }

    public static final int z(@a7.d float[] fArr, float f8, int i7, int i8) {
        kotlin.jvm.internal.l0.p(fArr, "<this>");
        return Arrays.binarySearch(fArr, i7, i8, f8);
    }

    @kotlin.g1(version = "1.4")
    @h5.h(name = "contentHashCodeNullable")
    @kotlin.internal.f
    private static final int z0(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @kotlin.internal.f
    private static final long[] z1(long[] jArr, int i7) {
        kotlin.jvm.internal.l0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, i7);
        kotlin.jvm.internal.l0.o(jArrCopyOf, "copyOf(this, newSize)");
        return jArrCopyOf;
    }

    @a7.d
    public static final <R> List<R> z2(@a7.d Object[] objArr, @a7.d Class<R> klass) {
        kotlin.jvm.internal.l0.p(objArr, "<this>");
        kotlin.jvm.internal.l0.p(klass, "klass");
        return (List) A2(objArr, new ArrayList(), klass);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.b1(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = i2.a.f34096f, warningSince = "1.4")
    public static final /* synthetic */ Double z3(double[] dArr, Comparator comparator) {
        kotlin.jvm.internal.l0.p(dArr, "<this>");
        kotlin.jvm.internal.l0.p(comparator, "comparator");
        return p.m0do(dArr, comparator);
    }

    public static /* synthetic */ void z4(byte[] bArr, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = bArr.length;
        }
        i4(bArr, i7, i8);
    }
}
