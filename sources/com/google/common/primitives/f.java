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
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f22351a = 4;

    @s1.b
    private static class a extends AbstractList<Float> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22352d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float[] f22353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f22354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f22355c;

        a(float[] fArr) {
            this(fArr, 0, fArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return Float.valueOf(this.f22353a[this.f22354b + i7]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float set(int i7, Float f8) {
            com.google.common.base.e0.C(i7, size());
            float[] fArr = this.f22353a;
            int i8 = this.f22354b;
            float f9 = fArr[i8 + i7];
            fArr[i8 + i7] = ((Float) com.google.common.base.e0.E(f8)).floatValue();
            return Float.valueOf(f9);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Float) && f.k(this.f22353a, ((Float) obj).floatValue(), this.f22354b, this.f22355c) != -1;
        }

        float[] d() {
            return Arrays.copyOfRange(this.f22353a, this.f22354b, this.f22355c);
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
                if (this.f22353a[this.f22354b + i7] != aVar.f22353a[aVar.f22354b + i7]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i7 = 1;
            for (int i8 = this.f22354b; i8 < this.f22355c; i8++) {
                i7 = (i7 * 31) + f.i(this.f22353a[i8]);
            }
            return i7;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iK;
            if (!(obj instanceof Float) || (iK = f.k(this.f22353a, ((Float) obj).floatValue(), this.f22354b, this.f22355c)) < 0) {
                return -1;
            }
            return iK - this.f22354b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iP;
            if (!(obj instanceof Float) || (iP = f.p(this.f22353a, ((Float) obj).floatValue(), this.f22354b, this.f22355c)) < 0) {
                return -1;
            }
            return iP - this.f22354b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f22355c - this.f22354b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, size());
            if (i7 == i8) {
                return Collections.emptyList();
            }
            float[] fArr = this.f22353a;
            int i9 = this.f22354b;
            return new a(fArr, i7 + i9, i9 + i8);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
            sb.append('[');
            sb.append(this.f22353a[this.f22354b]);
            int i7 = this.f22354b;
            while (true) {
                i7++;
                if (i7 >= this.f22355c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f22353a[i7]);
            }
        }

        a(float[] fArr, int i7, int i8) {
            this.f22353a = fArr;
            this.f22354b = i7;
            this.f22355c = i8;
        }
    }

    private static final class b extends com.google.common.base.i<String, Float> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final b f22356c = new b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f22357d = 1;

        private b() {
        }

        private Object readResolve() {
            return f22356c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public String g(Float f8) {
            return f8.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public Float h(String str) {
            return Float.valueOf(str);
        }

        public String toString() {
            return "Floats.stringConverter()";
        }
    }

    private enum c implements Comparator<float[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(float[] fArr, float[] fArr2) {
            int iMin = Math.min(fArr.length, fArr2.length);
            for (int i7 = 0; i7 < iMin; i7++) {
                int iCompare = Float.compare(fArr[i7], fArr2[i7]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return fArr.length - fArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }
    }

    private f() {
    }

    public static List<Float> c(float... fArr) {
        return fArr.length == 0 ? Collections.emptyList() : new a(fArr);
    }

    public static int d(float f8, float f9) {
        return Float.compare(f8, f9);
    }

    public static float[] e(float[]... fArr) {
        int length = 0;
        for (float[] fArr2 : fArr) {
            length += fArr2.length;
        }
        float[] fArr3 = new float[length];
        int length2 = 0;
        for (float[] fArr4 : fArr) {
            System.arraycopy(fArr4, 0, fArr3, length2, fArr4.length);
            length2 += fArr4.length;
        }
        return fArr3;
    }

    @s1.a
    public static float f(float f8, float f9, float f10) {
        com.google.common.base.e0.y(f9 <= f10, "min (%s) must be less than or equal to max (%s)", Float.valueOf(f9), Float.valueOf(f10));
        return Math.min(Math.max(f8, f9), f10);
    }

    public static boolean g(float[] fArr, float f8) {
        for (float f9 : fArr) {
            if (f9 == f8) {
                return true;
            }
        }
        return false;
    }

    public static float[] h(float[] fArr, int i7, int i8) {
        com.google.common.base.e0.k(i7 >= 0, "Invalid minLength: %s", i7);
        com.google.common.base.e0.k(i8 >= 0, "Invalid padding: %s", i8);
        return fArr.length < i7 ? Arrays.copyOf(fArr, i7 + i8) : fArr;
    }

    public static int i(float f8) {
        return Float.valueOf(f8).hashCode();
    }

    public static int j(float[] fArr, float f8) {
        return k(fArr, f8, 0, fArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(float[] fArr, float f8, int i7, int i8) {
        while (i7 < i8) {
            if (fArr[i7] == f8) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static int l(float[] fArr, float[] fArr2) {
        com.google.common.base.e0.F(fArr, "array");
        com.google.common.base.e0.F(fArr2, androidx.constraintlayout.core.motion.utils.w.a.M);
        if (fArr2.length == 0) {
            return 0;
        }
        for (int i7 = 0; i7 < (fArr.length - fArr2.length) + 1; i7++) {
            for (int i8 = 0; i8 < fArr2.length; i8++) {
                if (fArr[i7 + i8] != fArr2[i8]) {
                }
            }
            return i7;
        }
        return -1;
    }

    public static boolean m(float f8) {
        return Float.NEGATIVE_INFINITY < f8 && f8 < Float.POSITIVE_INFINITY;
    }

    public static String n(String str, float... fArr) {
        com.google.common.base.e0.E(str);
        if (fArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(fArr.length * 12);
        sb.append(fArr[0]);
        for (int i7 = 1; i7 < fArr.length; i7++) {
            sb.append(str);
            sb.append(fArr[i7]);
        }
        return sb.toString();
    }

    public static int o(float[] fArr, float f8) {
        return p(fArr, f8, 0, fArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(float[] fArr, float f8, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            if (fArr[i9] == f8) {
                return i9;
            }
        }
        return -1;
    }

    public static Comparator<float[]> q() {
        return c.INSTANCE;
    }

    public static float r(float... fArr) {
        com.google.common.base.e0.d(fArr.length > 0);
        float fMax = fArr[0];
        for (int i7 = 1; i7 < fArr.length; i7++) {
            fMax = Math.max(fMax, fArr[i7]);
        }
        return fMax;
    }

    public static float s(float... fArr) {
        com.google.common.base.e0.d(fArr.length > 0);
        float fMin = fArr[0];
        for (int i7 = 1; i7 < fArr.length; i7++) {
            fMin = Math.min(fMin, fArr[i7]);
        }
        return fMin;
    }

    public static void t(float[] fArr) {
        com.google.common.base.e0.E(fArr);
        u(fArr, 0, fArr.length);
    }

    public static void u(float[] fArr, int i7, int i8) {
        com.google.common.base.e0.E(fArr);
        com.google.common.base.e0.f0(i7, i8, fArr.length);
        for (int i9 = i8 - 1; i7 < i9; i9--) {
            float f8 = fArr[i7];
            fArr[i7] = fArr[i9];
            fArr[i9] = f8;
            i7++;
        }
    }

    public static void v(float[] fArr) {
        com.google.common.base.e0.E(fArr);
        w(fArr, 0, fArr.length);
    }

    public static void w(float[] fArr, int i7, int i8) {
        com.google.common.base.e0.E(fArr);
        com.google.common.base.e0.f0(i7, i8, fArr.length);
        Arrays.sort(fArr, i7, i8);
        u(fArr, i7, i8);
    }

    @s1.a
    public static com.google.common.base.i<String, Float> x() {
        return b.f22356c;
    }

    public static float[] y(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i7 = 0; i7 < length; i7++) {
            fArr[i7] = ((Number) com.google.common.base.e0.E(array[i7])).floatValue();
        }
        return fArr;
    }

    @s1.a
    @s1.c
    public static Float z(String str) {
        if (!e.f22340b.matcher(str).matches()) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
