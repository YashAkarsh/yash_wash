package com.google.common.primitives;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.p1;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f22362a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final short f22363b = 16384;

    private enum a implements Comparator<short[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(short[] sArr, short[] sArr2) {
            int iMin = Math.min(sArr.length, sArr2.length);
            for (int i7 = 0; i7 < iMin; i7++) {
                int iE = g0.e(sArr[i7], sArr2[i7]);
                if (iE != 0) {
                    return iE;
                }
            }
            return sArr.length - sArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }
    }

    @s1.b
    private static class b extends AbstractList<Short> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22366d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final short[] f22367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f22368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f22369c;

        b(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return Short.valueOf(this.f22367a[this.f22368b + i7]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short set(int i7, Short sh) {
            com.google.common.base.e0.C(i7, size());
            short[] sArr = this.f22367a;
            int i8 = this.f22368b;
            short s7 = sArr[i8 + i7];
            sArr[i8 + i7] = ((Short) com.google.common.base.e0.E(sh)).shortValue();
            return Short.valueOf(s7);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Short) && g0.n(this.f22367a, ((Short) obj).shortValue(), this.f22368b, this.f22369c) != -1;
        }

        short[] d() {
            return Arrays.copyOfRange(this.f22367a, this.f22368b, this.f22369c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return super.equals(obj);
            }
            b bVar = (b) obj;
            int size = size();
            if (bVar.size() != size) {
                return false;
            }
            for (int i7 = 0; i7 < size; i7++) {
                if (this.f22367a[this.f22368b + i7] != bVar.f22367a[bVar.f22368b + i7]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iL = 1;
            for (int i7 = this.f22368b; i7 < this.f22369c; i7++) {
                iL = (iL * 31) + g0.l(this.f22367a[i7]);
            }
            return iL;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iN;
            if (!(obj instanceof Short) || (iN = g0.n(this.f22367a, ((Short) obj).shortValue(), this.f22368b, this.f22369c)) < 0) {
                return -1;
            }
            return iN - this.f22368b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iR;
            if (!(obj instanceof Short) || (iR = g0.r(this.f22367a, ((Short) obj).shortValue(), this.f22368b, this.f22369c)) < 0) {
                return -1;
            }
            return iR - this.f22368b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f22369c - this.f22368b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, size());
            if (i7 == i8) {
                return Collections.emptyList();
            }
            short[] sArr = this.f22367a;
            int i9 = this.f22368b;
            return new b(sArr, i7 + i9, i9 + i8);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 6);
            sb.append('[');
            sb.append((int) this.f22367a[this.f22368b]);
            int i7 = this.f22368b;
            while (true) {
                i7++;
                if (i7 >= this.f22369c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append((int) this.f22367a[i7]);
            }
        }

        b(short[] sArr, int i7, int i8) {
            this.f22367a = sArr;
            this.f22368b = i7;
            this.f22369c = i8;
        }
    }

    private static final class c extends com.google.common.base.i<String, Short> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final c f22370c = new c();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22371d = 1;

        private c() {
        }

        private Object readResolve() {
            return f22370c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public String g(Short sh) {
            return sh.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Short h(String str) {
            return Short.decode(str);
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }
    }

    private g0() {
    }

    @s1.a
    public static com.google.common.base.i<String, Short> A() {
        return c.f22370c;
    }

    public static short[] B(Collection<? extends Number> collection) {
        if (collection instanceof b) {
            return ((b) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i7 = 0; i7 < length; i7++) {
            sArr[i7] = ((Number) com.google.common.base.e0.E(array[i7])).shortValue();
        }
        return sArr;
    }

    @s1.c
    public static byte[] C(short s7) {
        return new byte[]{(byte) (s7 >> 8), (byte) s7};
    }

    public static List<Short> c(short... sArr) {
        return sArr.length == 0 ? Collections.emptyList() : new b(sArr);
    }

    public static short d(long j7) {
        short s7 = (short) j7;
        com.google.common.base.e0.p(((long) s7) == j7, "Out of range: %s", j7);
        return s7;
    }

    public static int e(short s7, short s8) {
        return s7 - s8;
    }

    public static short[] f(short[]... sArr) {
        int length = 0;
        for (short[] sArr2 : sArr) {
            length += sArr2.length;
        }
        short[] sArr3 = new short[length];
        int length2 = 0;
        for (short[] sArr4 : sArr) {
            System.arraycopy(sArr4, 0, sArr3, length2, sArr4.length);
            length2 += sArr4.length;
        }
        return sArr3;
    }

    @s1.a
    public static short g(short s7, short s8, short s9) {
        com.google.common.base.e0.m(s8 <= s9, "min (%s) must be less than or equal to max (%s)", s8, s9);
        if (s7 < s8) {
            return s8;
        }
        return s7 < s9 ? s7 : s9;
    }

    public static boolean h(short[] sArr, short s7) {
        for (short s8 : sArr) {
            if (s8 == s7) {
                return true;
            }
        }
        return false;
    }

    public static short[] i(short[] sArr, int i7, int i8) {
        com.google.common.base.e0.k(i7 >= 0, "Invalid minLength: %s", i7);
        com.google.common.base.e0.k(i8 >= 0, "Invalid padding: %s", i8);
        return sArr.length < i7 ? Arrays.copyOf(sArr, i7 + i8) : sArr;
    }

    @s1.c
    public static short j(byte[] bArr) {
        com.google.common.base.e0.m(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return k(bArr[0], bArr[1]);
    }

    @s1.c
    public static short k(byte b8, byte b9) {
        return (short) ((b8 << 8) | (b9 & 255));
    }

    public static int l(short s7) {
        return s7;
    }

    public static int m(short[] sArr, short s7) {
        return n(sArr, s7, 0, sArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(short[] sArr, short s7, int i7, int i8) {
        while (i7 < i8) {
            if (sArr[i7] == s7) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static int o(short[] sArr, short[] sArr2) {
        com.google.common.base.e0.F(sArr, "array");
        com.google.common.base.e0.F(sArr2, androidx.constraintlayout.core.motion.utils.w.a.M);
        if (sArr2.length == 0) {
            return 0;
        }
        for (int i7 = 0; i7 < (sArr.length - sArr2.length) + 1; i7++) {
            for (int i8 = 0; i8 < sArr2.length; i8++) {
                if (sArr[i7 + i8] != sArr2[i8]) {
                }
            }
            return i7;
        }
        return -1;
    }

    public static String p(String str, short... sArr) {
        com.google.common.base.e0.E(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(sArr.length * 6);
        sb.append((int) sArr[0]);
        for (int i7 = 1; i7 < sArr.length; i7++) {
            sb.append(str);
            sb.append((int) sArr[i7]);
        }
        return sb.toString();
    }

    public static int q(short[] sArr, short s7) {
        return r(sArr, s7, 0, sArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(short[] sArr, short s7, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            if (sArr[i9] == s7) {
                return i9;
            }
        }
        return -1;
    }

    public static Comparator<short[]> s() {
        return a.INSTANCE;
    }

    public static short t(short... sArr) {
        com.google.common.base.e0.d(sArr.length > 0);
        short s7 = sArr[0];
        for (int i7 = 1; i7 < sArr.length; i7++) {
            short s8 = sArr[i7];
            if (s8 > s7) {
                s7 = s8;
            }
        }
        return s7;
    }

    public static short u(short... sArr) {
        com.google.common.base.e0.d(sArr.length > 0);
        short s7 = sArr[0];
        for (int i7 = 1; i7 < sArr.length; i7++) {
            short s8 = sArr[i7];
            if (s8 < s7) {
                s7 = s8;
            }
        }
        return s7;
    }

    public static void v(short[] sArr) {
        com.google.common.base.e0.E(sArr);
        w(sArr, 0, sArr.length);
    }

    public static void w(short[] sArr, int i7, int i8) {
        com.google.common.base.e0.E(sArr);
        com.google.common.base.e0.f0(i7, i8, sArr.length);
        for (int i9 = i8 - 1; i7 < i9; i9--) {
            short s7 = sArr[i7];
            sArr[i7] = sArr[i9];
            sArr[i9] = s7;
            i7++;
        }
    }

    public static short x(long j7) {
        if (j7 > 32767) {
            return p1.f34890c;
        }
        return j7 < -32768 ? p1.f34889b : (short) j7;
    }

    public static void y(short[] sArr) {
        com.google.common.base.e0.E(sArr);
        z(sArr, 0, sArr.length);
    }

    public static void z(short[] sArr, int i7, int i8) {
        com.google.common.base.e0.E(sArr);
        com.google.common.base.e0.f0(i7, i8, sArr.length);
        Arrays.sort(sArr, i7, i8);
        w(sArr, i7, i8);
    }
}
