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
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f22318a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f22319b = 1073741824;

    @s1.b
    private static class a extends AbstractList<Integer> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22320d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f22321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f22322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f22323c;

        a(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return Integer.valueOf(this.f22321a[this.f22322b + i7]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer set(int i7, Integer num) {
            com.google.common.base.e0.C(i7, size());
            int[] iArr = this.f22321a;
            int i8 = this.f22322b;
            int i9 = iArr[i8 + i7];
            iArr[i8 + i7] = ((Integer) com.google.common.base.e0.E(num)).intValue();
            return Integer.valueOf(i9);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && c0.n(this.f22321a, ((Integer) obj).intValue(), this.f22322b, this.f22323c) != -1;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Spliterator.OfInt spliterator() {
            return Spliterators.spliterator(this.f22321a, this.f22322b, this.f22323c, 0);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i7 = 0; i7 < size; i7++) {
                if (this.f22321a[this.f22322b + i7] != aVar.f22321a[aVar.f22322b + i7]) {
                    return false;
                }
            }
            return true;
        }

        int[] f() {
            return Arrays.copyOfRange(this.f22321a, this.f22322b, this.f22323c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iL = 1;
            for (int i7 = this.f22322b; i7 < this.f22323c; i7++) {
                iL = (iL * 31) + c0.l(this.f22321a[i7]);
            }
            return iL;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iN;
            if (!(obj instanceof Integer) || (iN = c0.n(this.f22321a, ((Integer) obj).intValue(), this.f22322b, this.f22323c)) < 0) {
                return -1;
            }
            return iN - this.f22322b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iR;
            if (!(obj instanceof Integer) || (iR = c0.r(this.f22321a, ((Integer) obj).intValue(), this.f22322b, this.f22323c)) < 0) {
                return -1;
            }
            return iR - this.f22322b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f22323c - this.f22322b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, size());
            if (i7 == i8) {
                return Collections.emptyList();
            }
            int[] iArr = this.f22321a;
            int i9 = this.f22322b;
            return new a(iArr, i7 + i9, i9 + i8);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.f22321a[this.f22322b]);
            int i7 = this.f22322b;
            while (true) {
                i7++;
                if (i7 >= this.f22323c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f22321a[i7]);
            }
        }

        a(int[] iArr, int i7, int i8) {
            this.f22321a = iArr;
            this.f22322b = i7;
            this.f22323c = i8;
        }
    }

    private static final class b extends com.google.common.base.i<String, Integer> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final b f22324c = new b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22325d = 1;

        private b() {
        }

        private Object readResolve() {
            return f22324c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public String g(Integer num) {
            return num.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Integer h(String str) {
            return Integer.decode(str);
        }

        public String toString() {
            return "Ints.stringConverter()";
        }
    }

    private enum c implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            int iMin = Math.min(iArr.length, iArr2.length);
            for (int i7 = 0; i7 < iMin; i7++) {
                int iE = c0.e(iArr[i7], iArr2[i7]);
                if (iE != 0) {
                    return iE;
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Ints.lexicographicalComparator()";
        }
    }

    private c0() {
    }

    @s1.a
    public static com.google.common.base.i<String, Integer> A() {
        return b.f22324c;
    }

    public static int[] B(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).f();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = ((Number) com.google.common.base.e0.E(array[i7])).intValue();
        }
        return iArr;
    }

    public static byte[] C(int i7) {
        return new byte[]{(byte) (i7 >> 24), (byte) (i7 >> 16), (byte) (i7 >> 8), (byte) i7};
    }

    @s1.a
    public static Integer D(String str) {
        return E(str, 10);
    }

    @s1.a
    public static Integer E(String str, int i7) {
        Long lC = d0.C(str, i7);
        if (lC == null || lC.longValue() != lC.intValue()) {
            return null;
        }
        return Integer.valueOf(lC.intValue());
    }

    public static List<Integer> c(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new a(iArr);
    }

    public static int d(long j7) {
        int i7 = (int) j7;
        com.google.common.base.e0.p(((long) i7) == j7, "Out of range: %s", j7);
        return i7;
    }

    public static int e(int i7, int i8) {
        if (i7 < i8) {
            return -1;
        }
        return i7 > i8 ? 1 : 0;
    }

    public static int[] f(int[]... iArr) {
        int length = 0;
        for (int[] iArr2 : iArr) {
            length += iArr2.length;
        }
        int[] iArr3 = new int[length];
        int length2 = 0;
        for (int[] iArr4 : iArr) {
            System.arraycopy(iArr4, 0, iArr3, length2, iArr4.length);
            length2 += iArr4.length;
        }
        return iArr3;
    }

    @s1.a
    public static int g(int i7, int i8, int i9) {
        com.google.common.base.e0.m(i8 <= i9, "min (%s) must be less than or equal to max (%s)", i8, i9);
        return Math.min(Math.max(i7, i8), i9);
    }

    public static boolean h(int[] iArr, int i7) {
        for (int i8 : iArr) {
            if (i8 == i7) {
                return true;
            }
        }
        return false;
    }

    public static int[] i(int[] iArr, int i7, int i8) {
        com.google.common.base.e0.k(i7 >= 0, "Invalid minLength: %s", i7);
        com.google.common.base.e0.k(i8 >= 0, "Invalid padding: %s", i8);
        return iArr.length < i7 ? Arrays.copyOf(iArr, i7 + i8) : iArr;
    }

    public static int j(byte[] bArr) {
        com.google.common.base.e0.m(bArr.length >= 4, "array too small: %s < %s", bArr.length, 4);
        return k(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int k(byte b8, byte b9, byte b10, byte b11) {
        return (b8 << com.google.common.base.c.B) | ((b9 & 255) << 16) | ((b10 & 255) << 8) | (b11 & 255);
    }

    public static int l(int i7) {
        return i7;
    }

    public static int m(int[] iArr, int i7) {
        return n(iArr, i7, 0, iArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(int[] iArr, int i7, int i8, int i9) {
        while (i8 < i9) {
            if (iArr[i8] == i7) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public static int o(int[] iArr, int[] iArr2) {
        com.google.common.base.e0.F(iArr, "array");
        com.google.common.base.e0.F(iArr2, androidx.constraintlayout.core.motion.utils.w.a.M);
        if (iArr2.length == 0) {
            return 0;
        }
        for (int i7 = 0; i7 < (iArr.length - iArr2.length) + 1; i7++) {
            for (int i8 = 0; i8 < iArr2.length; i8++) {
                if (iArr[i7 + i8] != iArr2[i8]) {
                }
            }
            return i7;
        }
        return -1;
    }

    public static String p(String str, int... iArr) {
        com.google.common.base.e0.E(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(iArr[0]);
        for (int i7 = 1; i7 < iArr.length; i7++) {
            sb.append(str);
            sb.append(iArr[i7]);
        }
        return sb.toString();
    }

    public static int q(int[] iArr, int i7) {
        return r(iArr, i7, 0, iArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(int[] iArr, int i7, int i8, int i9) {
        for (int i10 = i9 - 1; i10 >= i8; i10--) {
            if (iArr[i10] == i7) {
                return i10;
            }
        }
        return -1;
    }

    public static Comparator<int[]> s() {
        return c.INSTANCE;
    }

    public static int t(int... iArr) {
        com.google.common.base.e0.d(iArr.length > 0);
        int i7 = iArr[0];
        for (int i8 = 1; i8 < iArr.length; i8++) {
            int i9 = iArr[i8];
            if (i9 > i7) {
                i7 = i9;
            }
        }
        return i7;
    }

    public static int u(int... iArr) {
        com.google.common.base.e0.d(iArr.length > 0);
        int i7 = iArr[0];
        for (int i8 = 1; i8 < iArr.length; i8++) {
            int i9 = iArr[i8];
            if (i9 < i7) {
                i7 = i9;
            }
        }
        return i7;
    }

    public static void v(int[] iArr) {
        com.google.common.base.e0.E(iArr);
        w(iArr, 0, iArr.length);
    }

    public static void w(int[] iArr, int i7, int i8) {
        com.google.common.base.e0.E(iArr);
        com.google.common.base.e0.f0(i7, i8, iArr.length);
        for (int i9 = i8 - 1; i7 < i9; i9--) {
            int i10 = iArr[i7];
            iArr[i7] = iArr[i9];
            iArr[i9] = i10;
            i7++;
        }
    }

    public static int x(long j7) {
        if (j7 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j7 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j7;
    }

    public static void y(int[] iArr) {
        com.google.common.base.e0.E(iArr);
        z(iArr, 0, iArr.length);
    }

    public static void z(int[] iArr, int i7, int i8) {
        com.google.common.base.e0.E(iArr);
        com.google.common.base.e0.f0(i7, i8, iArr.length);
        Arrays.sort(iArr, i7, i8);
        w(iArr, i7, i8);
    }
}
