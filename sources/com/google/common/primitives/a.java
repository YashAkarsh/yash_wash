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
@s1.b
public final class a {

    /* JADX INFO: renamed from: com.google.common.primitives.a$a, reason: collision with other inner class name */
    @s1.b
    private static class C0284a extends AbstractList<Boolean> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22295d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean[] f22296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f22297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f22298c;

        C0284a(boolean[] zArr) {
            this(zArr, 0, zArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return Boolean.valueOf(this.f22296a[this.f22297b + i7]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean set(int i7, Boolean bool) {
            com.google.common.base.e0.C(i7, size());
            boolean[] zArr = this.f22296a;
            int i8 = this.f22297b;
            boolean z7 = zArr[i8 + i7];
            zArr[i8 + i7] = ((Boolean) com.google.common.base.e0.E(bool)).booleanValue();
            return Boolean.valueOf(z7);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Boolean) && a.l(this.f22296a, ((Boolean) obj).booleanValue(), this.f22297b, this.f22298c) != -1;
        }

        boolean[] d() {
            return Arrays.copyOfRange(this.f22296a, this.f22297b, this.f22298c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0284a)) {
                return super.equals(obj);
            }
            C0284a c0284a = (C0284a) obj;
            int size = size();
            if (c0284a.size() != size) {
                return false;
            }
            for (int i7 = 0; i7 < size; i7++) {
                if (this.f22296a[this.f22297b + i7] != c0284a.f22296a[c0284a.f22297b + i7]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iJ = 1;
            for (int i7 = this.f22297b; i7 < this.f22298c; i7++) {
                iJ = (iJ * 31) + a.j(this.f22296a[i7]);
            }
            return iJ;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iL;
            if (!(obj instanceof Boolean) || (iL = a.l(this.f22296a, ((Boolean) obj).booleanValue(), this.f22297b, this.f22298c)) < 0) {
                return -1;
            }
            return iL - this.f22297b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iP;
            if (!(obj instanceof Boolean) || (iP = a.p(this.f22296a, ((Boolean) obj).booleanValue(), this.f22297b, this.f22298c)) < 0) {
                return -1;
            }
            return iP - this.f22297b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f22298c - this.f22297b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Boolean> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, size());
            if (i7 == i8) {
                return Collections.emptyList();
            }
            boolean[] zArr = this.f22296a;
            int i9 = this.f22297b;
            return new C0284a(zArr, i7 + i9, i9 + i8);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 7);
            sb.append(this.f22296a[this.f22297b] ? "[true" : "[false");
            int i7 = this.f22297b;
            while (true) {
                i7++;
                if (i7 >= this.f22298c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(this.f22296a[i7] ? ", true" : ", false");
            }
        }

        C0284a(boolean[] zArr, int i7, int i8) {
            this.f22296a = zArr;
            this.f22297b = i7;
            this.f22298c = i8;
        }
    }

    private enum b implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f22302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f22303b;

        b(int i7, String str) {
            this.f22302a = i7;
            this.f22303b = str;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Boolean bool, Boolean bool2) {
            return (bool2.booleanValue() ? this.f22302a : 0) - (bool.booleanValue() ? this.f22302a : 0);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f22303b;
        }
    }

    private enum c implements Comparator<boolean[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(boolean[] zArr, boolean[] zArr2) {
            int iMin = Math.min(zArr.length, zArr2.length);
            for (int i7 = 0; i7 < iMin; i7++) {
                int iD = a.d(zArr[i7], zArr2[i7]);
                if (iD != 0) {
                    return iD;
                }
            }
            return zArr.length - zArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }
    }

    private a() {
    }

    public static List<Boolean> c(boolean... zArr) {
        return zArr.length == 0 ? Collections.emptyList() : new C0284a(zArr);
    }

    public static int d(boolean z7, boolean z8) {
        if (z7 == z8) {
            return 0;
        }
        return z7 ? 1 : -1;
    }

    public static boolean[] e(boolean[]... zArr) {
        int length = 0;
        for (boolean[] zArr2 : zArr) {
            length += zArr2.length;
        }
        boolean[] zArr3 = new boolean[length];
        int length2 = 0;
        for (boolean[] zArr4 : zArr) {
            System.arraycopy(zArr4, 0, zArr3, length2, zArr4.length);
            length2 += zArr4.length;
        }
        return zArr3;
    }

    public static boolean f(boolean[] zArr, boolean z7) {
        for (boolean z8 : zArr) {
            if (z8 == z7) {
                return true;
            }
        }
        return false;
    }

    @s1.a
    public static int g(boolean... zArr) {
        int i7 = 0;
        for (boolean z7 : zArr) {
            if (z7) {
                i7++;
            }
        }
        return i7;
    }

    public static boolean[] h(boolean[] zArr, int i7, int i8) {
        com.google.common.base.e0.k(i7 >= 0, "Invalid minLength: %s", i7);
        com.google.common.base.e0.k(i8 >= 0, "Invalid padding: %s", i8);
        return zArr.length < i7 ? Arrays.copyOf(zArr, i7 + i8) : zArr;
    }

    @s1.a
    public static Comparator<Boolean> i() {
        return b.FALSE_FIRST;
    }

    public static int j(boolean z7) {
        return z7 ? 1231 : 1237;
    }

    public static int k(boolean[] zArr, boolean z7) {
        return l(zArr, z7, 0, zArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(boolean[] zArr, boolean z7, int i7, int i8) {
        while (i7 < i8) {
            if (zArr[i7] == z7) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static int m(boolean[] zArr, boolean[] zArr2) {
        com.google.common.base.e0.F(zArr, "array");
        com.google.common.base.e0.F(zArr2, androidx.constraintlayout.core.motion.utils.w.a.M);
        if (zArr2.length == 0) {
            return 0;
        }
        for (int i7 = 0; i7 < (zArr.length - zArr2.length) + 1; i7++) {
            for (int i8 = 0; i8 < zArr2.length; i8++) {
                if (zArr[i7 + i8] != zArr2[i8]) {
                }
            }
            return i7;
        }
        return -1;
    }

    public static String n(String str, boolean... zArr) {
        com.google.common.base.e0.E(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append(zArr[0]);
        for (int i7 = 1; i7 < zArr.length; i7++) {
            sb.append(str);
            sb.append(zArr[i7]);
        }
        return sb.toString();
    }

    public static int o(boolean[] zArr, boolean z7) {
        return p(zArr, z7, 0, zArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(boolean[] zArr, boolean z7, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            if (zArr[i9] == z7) {
                return i9;
            }
        }
        return -1;
    }

    public static Comparator<boolean[]> q() {
        return c.INSTANCE;
    }

    public static void r(boolean[] zArr) {
        com.google.common.base.e0.E(zArr);
        s(zArr, 0, zArr.length);
    }

    public static void s(boolean[] zArr, int i7, int i8) {
        com.google.common.base.e0.E(zArr);
        com.google.common.base.e0.f0(i7, i8, zArr.length);
        for (int i9 = i8 - 1; i7 < i9; i9--) {
            boolean z7 = zArr[i7];
            zArr[i7] = zArr[i9];
            zArr[i9] = z7;
            i7++;
        }
    }

    public static boolean[] t(Collection<Boolean> collection) {
        if (collection instanceof C0284a) {
            return ((C0284a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i7 = 0; i7 < length; i7++) {
            zArr[i7] = ((Boolean) com.google.common.base.e0.E(array[i7])).booleanValue();
        }
        return zArr;
    }

    @s1.a
    public static Comparator<Boolean> u() {
        return b.TRUE_FIRST;
    }
}
