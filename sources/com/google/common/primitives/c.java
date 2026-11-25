package com.google.common.primitives;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f22311a = 2;

    @s1.b
    private static class a extends AbstractList<Character> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22312d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final char[] f22313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f22314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f22315c;

        a(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return Character.valueOf(this.f22313a[this.f22314b + i7]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Character set(int i7, Character ch) {
            com.google.common.base.e0.C(i7, size());
            char[] cArr = this.f22313a;
            int i8 = this.f22314b;
            char c8 = cArr[i8 + i7];
            cArr[i8 + i7] = ((Character) com.google.common.base.e0.E(ch)).charValue();
            return Character.valueOf(c8);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Character) && c.n(this.f22313a, ((Character) obj).charValue(), this.f22314b, this.f22315c) != -1;
        }

        char[] d() {
            return Arrays.copyOfRange(this.f22313a, this.f22314b, this.f22315c);
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
                if (this.f22313a[this.f22314b + i7] != aVar.f22313a[aVar.f22314b + i7]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iL = 1;
            for (int i7 = this.f22314b; i7 < this.f22315c; i7++) {
                iL = (iL * 31) + c.l(this.f22313a[i7]);
            }
            return iL;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iN;
            if (!(obj instanceof Character) || (iN = c.n(this.f22313a, ((Character) obj).charValue(), this.f22314b, this.f22315c)) < 0) {
                return -1;
            }
            return iN - this.f22314b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iR;
            if (!(obj instanceof Character) || (iR = c.r(this.f22313a, ((Character) obj).charValue(), this.f22314b, this.f22315c)) < 0) {
                return -1;
            }
            return iR - this.f22314b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f22315c - this.f22314b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Character> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, size());
            if (i7 == i8) {
                return Collections.emptyList();
            }
            char[] cArr = this.f22313a;
            int i9 = this.f22314b;
            return new a(cArr, i7 + i9, i9 + i8);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 3);
            sb.append('[');
            sb.append(this.f22313a[this.f22314b]);
            int i7 = this.f22314b;
            while (true) {
                i7++;
                if (i7 >= this.f22315c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f22313a[i7]);
            }
        }

        a(char[] cArr, int i7, int i8) {
            this.f22313a = cArr;
            this.f22314b = i7;
            this.f22315c = i8;
        }
    }

    private enum b implements Comparator<char[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(char[] cArr, char[] cArr2) {
            int iMin = Math.min(cArr.length, cArr2.length);
            for (int i7 = 0; i7 < iMin; i7++) {
                int iE = c.e(cArr[i7], cArr2[i7]);
                if (iE != 0) {
                    return iE;
                }
            }
            return cArr.length - cArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }
    }

    private c() {
    }

    public static char[] A(Collection<Character> collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i7 = 0; i7 < length; i7++) {
            cArr[i7] = ((Character) com.google.common.base.e0.E(array[i7])).charValue();
        }
        return cArr;
    }

    @s1.c
    public static byte[] B(char c8) {
        return new byte[]{(byte) (c8 >> '\b'), (byte) c8};
    }

    public static List<Character> c(char... cArr) {
        return cArr.length == 0 ? Collections.emptyList() : new a(cArr);
    }

    public static char d(long j7) {
        char c8 = (char) j7;
        com.google.common.base.e0.p(((long) c8) == j7, "Out of range: %s", j7);
        return c8;
    }

    public static int e(char c8, char c9) {
        return c8 - c9;
    }

    public static char[] f(char[]... cArr) {
        int length = 0;
        for (char[] cArr2 : cArr) {
            length += cArr2.length;
        }
        char[] cArr3 = new char[length];
        int length2 = 0;
        for (char[] cArr4 : cArr) {
            System.arraycopy(cArr4, 0, cArr3, length2, cArr4.length);
            length2 += cArr4.length;
        }
        return cArr3;
    }

    @s1.a
    public static char g(char c8, char c9, char c10) {
        com.google.common.base.e0.g(c9 <= c10, "min (%s) must be less than or equal to max (%s)", c9, c10);
        if (c8 < c9) {
            return c9;
        }
        return c8 < c10 ? c8 : c10;
    }

    public static boolean h(char[] cArr, char c8) {
        for (char c9 : cArr) {
            if (c9 == c8) {
                return true;
            }
        }
        return false;
    }

    public static char[] i(char[] cArr, int i7, int i8) {
        com.google.common.base.e0.k(i7 >= 0, "Invalid minLength: %s", i7);
        com.google.common.base.e0.k(i8 >= 0, "Invalid padding: %s", i8);
        return cArr.length < i7 ? Arrays.copyOf(cArr, i7 + i8) : cArr;
    }

    @s1.c
    public static char j(byte[] bArr) {
        com.google.common.base.e0.m(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return k(bArr[0], bArr[1]);
    }

    @s1.c
    public static char k(byte b8, byte b9) {
        return (char) ((b8 << 8) | (b9 & 255));
    }

    public static int l(char c8) {
        return c8;
    }

    public static int m(char[] cArr, char c8) {
        return n(cArr, c8, 0, cArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(char[] cArr, char c8, int i7, int i8) {
        while (i7 < i8) {
            if (cArr[i7] == c8) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static int o(char[] cArr, char[] cArr2) {
        com.google.common.base.e0.F(cArr, "array");
        com.google.common.base.e0.F(cArr2, androidx.constraintlayout.core.motion.utils.w.a.M);
        if (cArr2.length == 0) {
            return 0;
        }
        for (int i7 = 0; i7 < (cArr.length - cArr2.length) + 1; i7++) {
            for (int i8 = 0; i8 < cArr2.length; i8++) {
                if (cArr[i7 + i8] != cArr2[i8]) {
                }
            }
            return i7;
        }
        return -1;
    }

    public static String p(String str, char... cArr) {
        com.google.common.base.e0.E(str);
        int length = cArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder((str.length() * (length - 1)) + length);
        sb.append(cArr[0]);
        for (int i7 = 1; i7 < length; i7++) {
            sb.append(str);
            sb.append(cArr[i7]);
        }
        return sb.toString();
    }

    public static int q(char[] cArr, char c8) {
        return r(cArr, c8, 0, cArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int r(char[] cArr, char c8, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            if (cArr[i9] == c8) {
                return i9;
            }
        }
        return -1;
    }

    public static Comparator<char[]> s() {
        return b.INSTANCE;
    }

    public static char t(char... cArr) {
        com.google.common.base.e0.d(cArr.length > 0);
        char c8 = cArr[0];
        for (int i7 = 1; i7 < cArr.length; i7++) {
            char c9 = cArr[i7];
            if (c9 > c8) {
                c8 = c9;
            }
        }
        return c8;
    }

    public static char u(char... cArr) {
        com.google.common.base.e0.d(cArr.length > 0);
        char c8 = cArr[0];
        for (int i7 = 1; i7 < cArr.length; i7++) {
            char c9 = cArr[i7];
            if (c9 < c8) {
                c8 = c9;
            }
        }
        return c8;
    }

    public static void v(char[] cArr) {
        com.google.common.base.e0.E(cArr);
        w(cArr, 0, cArr.length);
    }

    public static void w(char[] cArr, int i7, int i8) {
        com.google.common.base.e0.E(cArr);
        com.google.common.base.e0.f0(i7, i8, cArr.length);
        for (int i9 = i8 - 1; i7 < i9; i9--) {
            char c8 = cArr[i7];
            cArr[i7] = cArr[i9];
            cArr[i9] = c8;
            i7++;
        }
    }

    public static char x(long j7) {
        if (j7 > okhttp3.internal.ws.g.f38386s) {
            return kotlin.jvm.internal.r.f34909c;
        }
        if (j7 < 0) {
            return (char) 0;
        }
        return (char) j7;
    }

    public static void y(char[] cArr) {
        com.google.common.base.e0.E(cArr);
        z(cArr, 0, cArr.length);
    }

    public static void z(char[] cArr, int i7, int i8) {
        com.google.common.base.e0.E(cArr);
        com.google.common.base.e0.f0(i7, i8, cArr.length);
        Arrays.sort(cArr, i7, i8);
        w(cArr, i7, i8);
    }
}
