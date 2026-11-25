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
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f22339a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @s1.c
    static final Pattern f22340b = i();

    @s1.b
    private static class a extends AbstractList<Double> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22341d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final double[] f22342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f22343b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f22344c;

        a(double[] dArr) {
            this(dArr, 0, dArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return Double.valueOf(this.f22342a[this.f22343b + i7]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double set(int i7, Double d8) {
            com.google.common.base.e0.C(i7, size());
            double[] dArr = this.f22342a;
            int i8 = this.f22343b;
            double d9 = dArr[i8 + i7];
            dArr[i8 + i7] = ((Double) com.google.common.base.e0.E(d8)).doubleValue();
            return Double.valueOf(d9);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Double) && e.l(this.f22342a, ((Double) obj).doubleValue(), this.f22343b, this.f22344c) != -1;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Spliterator.OfDouble spliterator() {
            return Spliterators.spliterator(this.f22342a, this.f22343b, this.f22344c, 0);
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
                if (this.f22342a[this.f22343b + i7] != aVar.f22342a[aVar.f22343b + i7]) {
                    return false;
                }
            }
            return true;
        }

        double[] f() {
            return Arrays.copyOfRange(this.f22342a, this.f22343b, this.f22344c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iJ = 1;
            for (int i7 = this.f22343b; i7 < this.f22344c; i7++) {
                iJ = (iJ * 31) + e.j(this.f22342a[i7]);
            }
            return iJ;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iL;
            if (!(obj instanceof Double) || (iL = e.l(this.f22342a, ((Double) obj).doubleValue(), this.f22343b, this.f22344c)) < 0) {
                return -1;
            }
            return iL - this.f22343b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iQ;
            if (!(obj instanceof Double) || (iQ = e.q(this.f22342a, ((Double) obj).doubleValue(), this.f22343b, this.f22344c)) < 0) {
                return -1;
            }
            return iQ - this.f22343b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f22344c - this.f22343b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, size());
            if (i7 == i8) {
                return Collections.emptyList();
            }
            double[] dArr = this.f22342a;
            int i9 = this.f22343b;
            return new a(dArr, i7 + i9, i9 + i8);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
            sb.append('[');
            sb.append(this.f22342a[this.f22343b]);
            int i7 = this.f22343b;
            while (true) {
                i7++;
                if (i7 >= this.f22344c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f22342a[i7]);
            }
        }

        a(double[] dArr, int i7, int i8) {
            this.f22342a = dArr;
            this.f22343b = i7;
            this.f22344c = i8;
        }
    }

    private static final class b extends com.google.common.base.i<String, Double> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final b f22345c = new b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22346d = 1;

        private b() {
        }

        private Object readResolve() {
            return f22345c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public String g(Double d8) {
            return d8.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Double h(String str) {
            return Double.valueOf(str);
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }
    }

    private enum c implements Comparator<double[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(double[] dArr, double[] dArr2) {
            int iMin = Math.min(dArr.length, dArr2.length);
            for (int i7 = 0; i7 < iMin; i7++) {
                int iCompare = Double.compare(dArr[i7], dArr2[i7]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return dArr.length - dArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }
    }

    private e() {
    }

    @s1.a
    @s1.c
    public static Double A(String str) {
        if (!f22340b.matcher(str).matches()) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static List<Double> c(double... dArr) {
        return dArr.length == 0 ? Collections.emptyList() : new a(dArr);
    }

    public static int d(double d8, double d9) {
        return Double.compare(d8, d9);
    }

    public static double[] e(double[]... dArr) {
        int length = 0;
        for (double[] dArr2 : dArr) {
            length += dArr2.length;
        }
        double[] dArr3 = new double[length];
        int length2 = 0;
        for (double[] dArr4 : dArr) {
            System.arraycopy(dArr4, 0, dArr3, length2, dArr4.length);
            length2 += dArr4.length;
        }
        return dArr3;
    }

    @s1.a
    public static double f(double d8, double d9, double d10) {
        com.google.common.base.e0.y(d9 <= d10, "min (%s) must be less than or equal to max (%s)", Double.valueOf(d9), Double.valueOf(d10));
        return Math.min(Math.max(d8, d9), d10);
    }

    public static boolean g(double[] dArr, double d8) {
        for (double d9 : dArr) {
            if (d9 == d8) {
                return true;
            }
        }
        return false;
    }

    public static double[] h(double[] dArr, int i7, int i8) {
        com.google.common.base.e0.k(i7 >= 0, "Invalid minLength: %s", i7);
        com.google.common.base.e0.k(i8 >= 0, "Invalid padding: %s", i8);
        return dArr.length < i7 ? Arrays.copyOf(dArr, i7 + i8) : dArr;
    }

    @s1.c
    private static Pattern i() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + ")").replace("#", "+"));
    }

    public static int j(double d8) {
        return Double.valueOf(d8).hashCode();
    }

    public static int k(double[] dArr, double d8) {
        return l(dArr, d8, 0, dArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(double[] dArr, double d8, int i7, int i8) {
        while (i7 < i8) {
            if (dArr[i7] == d8) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static int m(double[] dArr, double[] dArr2) {
        com.google.common.base.e0.F(dArr, "array");
        com.google.common.base.e0.F(dArr2, androidx.constraintlayout.core.motion.utils.w.a.M);
        if (dArr2.length == 0) {
            return 0;
        }
        for (int i7 = 0; i7 < (dArr.length - dArr2.length) + 1; i7++) {
            for (int i8 = 0; i8 < dArr2.length; i8++) {
                if (dArr[i7 + i8] != dArr2[i8]) {
                }
            }
            return i7;
        }
        return -1;
    }

    public static boolean n(double d8) {
        return Double.NEGATIVE_INFINITY < d8 && d8 < Double.POSITIVE_INFINITY;
    }

    public static String o(String str, double... dArr) {
        com.google.common.base.e0.E(str);
        if (dArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(dArr.length * 12);
        sb.append(dArr[0]);
        for (int i7 = 1; i7 < dArr.length; i7++) {
            sb.append(str);
            sb.append(dArr[i7]);
        }
        return sb.toString();
    }

    public static int p(double[] dArr, double d8) {
        return q(dArr, d8, 0, dArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(double[] dArr, double d8, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            if (dArr[i9] == d8) {
                return i9;
            }
        }
        return -1;
    }

    public static Comparator<double[]> r() {
        return c.INSTANCE;
    }

    public static double s(double... dArr) {
        com.google.common.base.e0.d(dArr.length > 0);
        double dMax = dArr[0];
        for (int i7 = 1; i7 < dArr.length; i7++) {
            dMax = Math.max(dMax, dArr[i7]);
        }
        return dMax;
    }

    public static double t(double... dArr) {
        com.google.common.base.e0.d(dArr.length > 0);
        double dMin = dArr[0];
        for (int i7 = 1; i7 < dArr.length; i7++) {
            dMin = Math.min(dMin, dArr[i7]);
        }
        return dMin;
    }

    public static void u(double[] dArr) {
        com.google.common.base.e0.E(dArr);
        v(dArr, 0, dArr.length);
    }

    public static void v(double[] dArr, int i7, int i8) {
        com.google.common.base.e0.E(dArr);
        com.google.common.base.e0.f0(i7, i8, dArr.length);
        for (int i9 = i8 - 1; i7 < i9; i9--) {
            double d8 = dArr[i7];
            dArr[i7] = dArr[i9];
            dArr[i9] = d8;
            i7++;
        }
    }

    public static void w(double[] dArr) {
        com.google.common.base.e0.E(dArr);
        x(dArr, 0, dArr.length);
    }

    public static void x(double[] dArr, int i7, int i8) {
        com.google.common.base.e0.E(dArr);
        com.google.common.base.e0.f0(i7, i8, dArr.length);
        Arrays.sort(dArr, i7, i8);
        v(dArr, i7, i8);
    }

    @s1.a
    public static com.google.common.base.i<String, Double> y() {
        return b.f22345c;
    }

    public static double[] z(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).f();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i7 = 0; i7 < length; i7++) {
            dArr[i7] = ((Number) com.google.common.base.e0.E(array[i7])).doubleValue();
        }
        return dArr;
    }
}
