package com.google.common.primitives;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f22328a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f22329b = 4611686018427387904L;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final byte[] f22330a;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i7 = 0; i7 <= 9; i7++) {
                bArr[i7 + 48] = (byte) i7;
            }
            for (int i8 = 0; i8 <= 26; i8++) {
                byte b8 = (byte) (i8 + 10);
                bArr[i8 + 65] = b8;
                bArr[i8 + 97] = b8;
            }
            f22330a = bArr;
        }

        private a() {
        }

        static int a(char c8) {
            if (c8 < 128) {
                return f22330a[c8];
            }
            return -1;
        }
    }

    private enum b implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(long[] jArr, long[] jArr2) {
            int iMin = Math.min(jArr.length, jArr2.length);
            for (int i7 = 0; i7 < iMin; i7++) {
                int iD = d0.d(jArr[i7], jArr2[i7]);
                if (iD != 0) {
                    return iD;
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }
    }

    @s1.b
    private static class c extends AbstractList<Long> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22333d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long[] f22334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f22335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f22336c;

        c(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return Long.valueOf(this.f22334a[this.f22335b + i7]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long set(int i7, Long l7) {
            com.google.common.base.e0.C(i7, size());
            long[] jArr = this.f22334a;
            int i8 = this.f22335b;
            long j7 = jArr[i8 + i7];
            jArr[i8 + i7] = ((Long) com.google.common.base.e0.E(l7)).longValue();
            return Long.valueOf(j7);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Long) && d0.m(this.f22334a, ((Long) obj).longValue(), this.f22335b, this.f22336c) != -1;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Spliterator.OfLong spliterator() {
            return Spliterators.spliterator(this.f22334a, this.f22335b, this.f22336c, 0);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return super.equals(obj);
            }
            c cVar = (c) obj;
            int size = size();
            if (cVar.size() != size) {
                return false;
            }
            for (int i7 = 0; i7 < size; i7++) {
                if (this.f22334a[this.f22335b + i7] != cVar.f22334a[cVar.f22335b + i7]) {
                    return false;
                }
            }
            return true;
        }

        long[] f() {
            return Arrays.copyOfRange(this.f22334a, this.f22335b, this.f22336c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iK = 1;
            for (int i7 = this.f22335b; i7 < this.f22336c; i7++) {
                iK = (iK * 31) + d0.k(this.f22334a[i7]);
            }
            return iK;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iM;
            if (!(obj instanceof Long) || (iM = d0.m(this.f22334a, ((Long) obj).longValue(), this.f22335b, this.f22336c)) < 0) {
                return -1;
            }
            return iM - this.f22335b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iQ;
            if (!(obj instanceof Long) || (iQ = d0.q(this.f22334a, ((Long) obj).longValue(), this.f22335b, this.f22336c)) < 0) {
                return -1;
            }
            return iQ - this.f22335b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f22336c - this.f22335b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, size());
            if (i7 == i8) {
                return Collections.emptyList();
            }
            long[] jArr = this.f22334a;
            int i9 = this.f22335b;
            return new c(jArr, i7 + i9, i9 + i8);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
            sb.append('[');
            sb.append(this.f22334a[this.f22335b]);
            int i7 = this.f22335b;
            while (true) {
                i7++;
                if (i7 >= this.f22336c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f22334a[i7]);
            }
        }

        c(long[] jArr, int i7, int i8) {
            this.f22334a = jArr;
            this.f22335b = i7;
            this.f22336c = i8;
        }
    }

    private static final class d extends com.google.common.base.i<String, Long> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final d f22337c = new d();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22338d = 1;

        private d() {
        }

        private Object readResolve() {
            return f22337c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public String g(Long l7) {
            return l7.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Long h(String str) {
            return Long.decode(str);
        }

        public String toString() {
            return "Longs.stringConverter()";
        }
    }

    private d0() {
    }

    public static byte[] A(long j7) {
        byte[] bArr = new byte[8];
        for (int i7 = 7; i7 >= 0; i7--) {
            bArr[i7] = (byte) (255 & j7);
            j7 >>= 8;
        }
        return bArr;
    }

    @s1.a
    public static Long B(String str) {
        return C(str, 10);
    }

    @s1.a
    public static Long C(String str, int i7) {
        if (((String) com.google.common.base.e0.E(str)).isEmpty()) {
            return null;
        }
        if (i7 < 2 || i7 > 36) {
            throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i7);
        }
        int i8 = str.charAt(0) == '-' ? 1 : 0;
        if (i8 == str.length()) {
            return null;
        }
        int i9 = i8 + 1;
        int iA = a.a(str.charAt(i8));
        if (iA < 0 || iA >= i7) {
            return null;
        }
        long j7 = -iA;
        long j8 = i7;
        long j9 = Long.MIN_VALUE / j8;
        while (i9 < str.length()) {
            int i10 = i9 + 1;
            int iA2 = a.a(str.charAt(i9));
            if (iA2 < 0 || iA2 >= i7 || j7 < j9) {
                return null;
            }
            long j10 = j7 * j8;
            long j11 = iA2;
            if (j10 < j11 - Long.MIN_VALUE) {
                return null;
            }
            j7 = j10 - j11;
            i9 = i10;
        }
        if (i8 != 0) {
            return Long.valueOf(j7);
        }
        if (j7 == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j7);
    }

    public static List<Long> c(long... jArr) {
        return jArr.length == 0 ? Collections.emptyList() : new c(jArr);
    }

    public static int d(long j7, long j8) {
        if (j7 < j8) {
            return -1;
        }
        return j7 > j8 ? 1 : 0;
    }

    public static long[] e(long[]... jArr) {
        int length = 0;
        for (long[] jArr2 : jArr) {
            length += jArr2.length;
        }
        long[] jArr3 = new long[length];
        int length2 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, length2, jArr4.length);
            length2 += jArr4.length;
        }
        return jArr3;
    }

    @s1.a
    public static long f(long j7, long j8, long j9) {
        com.google.common.base.e0.s(j8 <= j9, "min (%s) must be less than or equal to max (%s)", j8, j9);
        return Math.min(Math.max(j7, j8), j9);
    }

    public static boolean g(long[] jArr, long j7) {
        for (long j8 : jArr) {
            if (j8 == j7) {
                return true;
            }
        }
        return false;
    }

    public static long[] h(long[] jArr, int i7, int i8) {
        com.google.common.base.e0.k(i7 >= 0, "Invalid minLength: %s", i7);
        com.google.common.base.e0.k(i8 >= 0, "Invalid padding: %s", i8);
        return jArr.length < i7 ? Arrays.copyOf(jArr, i7 + i8) : jArr;
    }

    public static long i(byte[] bArr) {
        com.google.common.base.e0.m(bArr.length >= 8, "array too small: %s < %s", bArr.length, 8);
        return j(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long j(byte b8, byte b9, byte b10, byte b11, byte b12, byte b13, byte b14, byte b15) {
        return ((((long) b9) & 255) << 48) | ((((long) b8) & 255) << 56) | ((((long) b10) & 255) << 40) | ((((long) b11) & 255) << 32) | ((((long) b12) & 255) << 24) | ((((long) b13) & 255) << 16) | ((((long) b14) & 255) << 8) | (((long) b15) & 255);
    }

    public static int k(long j7) {
        return (int) (j7 ^ (j7 >>> 32));
    }

    public static int l(long[] jArr, long j7) {
        return m(jArr, j7, 0, jArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(long[] jArr, long j7, int i7, int i8) {
        while (i7 < i8) {
            if (jArr[i7] == j7) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static int n(long[] jArr, long[] jArr2) {
        com.google.common.base.e0.F(jArr, "array");
        com.google.common.base.e0.F(jArr2, androidx.constraintlayout.core.motion.utils.w.a.M);
        if (jArr2.length == 0) {
            return 0;
        }
        for (int i7 = 0; i7 < (jArr.length - jArr2.length) + 1; i7++) {
            for (int i8 = 0; i8 < jArr2.length; i8++) {
                if (jArr[i7 + i8] != jArr2[i8]) {
                }
            }
            return i7;
        }
        return -1;
    }

    public static String o(String str, long... jArr) {
        com.google.common.base.e0.E(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 10);
        sb.append(jArr[0]);
        for (int i7 = 1; i7 < jArr.length; i7++) {
            sb.append(str);
            sb.append(jArr[i7]);
        }
        return sb.toString();
    }

    public static int p(long[] jArr, long j7) {
        return q(jArr, j7, 0, jArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(long[] jArr, long j7, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            if (jArr[i9] == j7) {
                return i9;
            }
        }
        return -1;
    }

    public static Comparator<long[]> r() {
        return b.INSTANCE;
    }

    public static long s(long... jArr) {
        com.google.common.base.e0.d(jArr.length > 0);
        long j7 = jArr[0];
        for (int i7 = 1; i7 < jArr.length; i7++) {
            long j8 = jArr[i7];
            if (j8 > j7) {
                j7 = j8;
            }
        }
        return j7;
    }

    public static long t(long... jArr) {
        com.google.common.base.e0.d(jArr.length > 0);
        long j7 = jArr[0];
        for (int i7 = 1; i7 < jArr.length; i7++) {
            long j8 = jArr[i7];
            if (j8 < j7) {
                j7 = j8;
            }
        }
        return j7;
    }

    public static void u(long[] jArr) {
        com.google.common.base.e0.E(jArr);
        v(jArr, 0, jArr.length);
    }

    public static void v(long[] jArr, int i7, int i8) {
        com.google.common.base.e0.E(jArr);
        com.google.common.base.e0.f0(i7, i8, jArr.length);
        for (int i9 = i8 - 1; i7 < i9; i9--) {
            long j7 = jArr[i7];
            jArr[i7] = jArr[i9];
            jArr[i9] = j7;
            i7++;
        }
    }

    public static void w(long[] jArr) {
        com.google.common.base.e0.E(jArr);
        x(jArr, 0, jArr.length);
    }

    public static void x(long[] jArr, int i7, int i8) {
        com.google.common.base.e0.E(jArr);
        com.google.common.base.e0.f0(i7, i8, jArr.length);
        Arrays.sort(jArr, i7, i8);
        v(jArr, i7, i8);
    }

    @s1.a
    public static com.google.common.base.i<String, Long> y() {
        return d.f22337c;
    }

    public static long[] z(Collection<? extends Number> collection) {
        if (collection instanceof c) {
            return ((c) collection).f();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i7 = 0; i7 < length; i7++) {
            jArr[i7] = ((Number) com.google.common.base.e0.E(array[i7])).longValue();
        }
        return jArr;
    }
}
