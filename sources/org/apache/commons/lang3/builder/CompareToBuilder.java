package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: loaded from: classes3.dex */
public class CompareToBuilder implements Builder<Integer> {
    private int comparison = 0;

    private static void reflectionAppend(Object obj, Object obj2, Class<?> cls, CompareToBuilder compareToBuilder, boolean z7, String[] strArr) {
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (int i7 = 0; i7 < declaredFields.length && compareToBuilder.comparison == 0; i7++) {
            Field field = declaredFields[i7];
            if (!ArrayUtils.contains(strArr, field.getName()) && field.getName().indexOf(36) == -1 && ((z7 || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                try {
                    compareToBuilder.append(field.get(obj), field.get(obj2));
                } catch (IllegalAccessException unused) {
                    throw new InternalError("Unexpected IllegalAccessException");
                }
            }
        }
    }

    public static int reflectionCompare(Object obj, Object obj2) {
        return reflectionCompare(obj, obj2, false, null, new String[0]);
    }

    public CompareToBuilder append(Object obj, Object obj2) {
        return append(obj, obj2, (Comparator<?>) null);
    }

    public CompareToBuilder appendSuper(int i7) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = i7;
        return this;
    }

    public int toComparison() {
        return this.comparison;
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z7) {
        return reflectionCompare(obj, obj2, z7, null, new String[0]);
    }

    public CompareToBuilder append(Object obj, Object obj2, Comparator<?> comparator) {
        if (this.comparison != 0 || obj == obj2) {
            return this;
        }
        if (obj == null) {
            this.comparison = -1;
            return this;
        }
        if (obj2 == null) {
            this.comparison = 1;
            return this;
        }
        if (obj.getClass().isArray()) {
            if (obj instanceof long[]) {
                append((long[]) obj, (long[]) obj2);
            } else if (obj instanceof int[]) {
                append((int[]) obj, (int[]) obj2);
            } else if (obj instanceof short[]) {
                append((short[]) obj, (short[]) obj2);
            } else if (obj instanceof char[]) {
                append((char[]) obj, (char[]) obj2);
            } else if (obj instanceof byte[]) {
                append((byte[]) obj, (byte[]) obj2);
            } else if (obj instanceof double[]) {
                append((double[]) obj, (double[]) obj2);
            } else if (obj instanceof float[]) {
                append((float[]) obj, (float[]) obj2);
            } else if (obj instanceof boolean[]) {
                append((boolean[]) obj, (boolean[]) obj2);
            } else {
                append((Object[]) obj, (Object[]) obj2, comparator);
            }
        } else if (comparator == null) {
            this.comparison = ((Comparable) obj).compareTo(obj2);
        } else {
            this.comparison = comparator.compare(obj, obj2);
        }
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.lang3.builder.Builder
    public Integer build() {
        return Integer.valueOf(toComparison());
    }

    public static int reflectionCompare(Object obj, Object obj2, Collection<String> collection) {
        return reflectionCompare(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public static int reflectionCompare(Object obj, Object obj2, String... strArr) {
        return reflectionCompare(obj, obj2, false, null, strArr);
    }

    public static int reflectionCompare(Object obj, Object obj2, boolean z7, Class<?> cls, String... strArr) {
        if (obj == obj2) {
            return 0;
        }
        if (obj != null && obj2 != null) {
            Class<?> superclass = obj.getClass();
            if (superclass.isInstance(obj2)) {
                CompareToBuilder compareToBuilder = new CompareToBuilder();
                reflectionAppend(obj, obj2, superclass, compareToBuilder, z7, strArr);
                while (superclass.getSuperclass() != null && superclass != cls) {
                    superclass = superclass.getSuperclass();
                    reflectionAppend(obj, obj2, superclass, compareToBuilder, z7, strArr);
                }
                return compareToBuilder.toComparison();
            }
            throw new ClassCastException();
        }
        throw null;
    }

    public CompareToBuilder append(long j7, long j8) {
        int i7;
        if (this.comparison != 0) {
            return this;
        }
        if (j7 < j8) {
            i7 = -1;
        } else {
            i7 = j7 > j8 ? 1 : 0;
        }
        this.comparison = i7;
        return this;
    }

    public CompareToBuilder append(int i7, int i8) {
        int i9;
        if (this.comparison != 0) {
            return this;
        }
        if (i7 < i8) {
            i9 = -1;
        } else {
            i9 = i7 > i8 ? 1 : 0;
        }
        this.comparison = i9;
        return this;
    }

    public CompareToBuilder append(short s7, short s8) {
        int i7;
        if (this.comparison != 0) {
            return this;
        }
        if (s7 < s8) {
            i7 = -1;
        } else {
            i7 = s7 > s8 ? 1 : 0;
        }
        this.comparison = i7;
        return this;
    }

    public CompareToBuilder append(char c8, char c9) {
        int i7;
        if (this.comparison != 0) {
            return this;
        }
        if (c8 < c9) {
            i7 = -1;
        } else {
            i7 = c8 > c9 ? 1 : 0;
        }
        this.comparison = i7;
        return this;
    }

    public CompareToBuilder append(byte b8, byte b9) {
        int i7;
        if (this.comparison != 0) {
            return this;
        }
        if (b8 < b9) {
            i7 = -1;
        } else {
            i7 = b8 > b9 ? 1 : 0;
        }
        this.comparison = i7;
        return this;
    }

    public CompareToBuilder append(double d8, double d9) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Double.compare(d8, d9);
        return this;
    }

    public CompareToBuilder append(float f8, float f9) {
        if (this.comparison != 0) {
            return this;
        }
        this.comparison = Float.compare(f8, f9);
        return this;
    }

    public CompareToBuilder append(boolean z7, boolean z8) {
        if (this.comparison != 0 || z7 == z8) {
            return this;
        }
        if (!z7) {
            this.comparison = -1;
        } else {
            this.comparison = 1;
        }
        return this;
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2) {
        return append(objArr, objArr2, (Comparator<?>) null);
    }

    public CompareToBuilder append(Object[] objArr, Object[] objArr2, Comparator<?> comparator) {
        if (this.comparison != 0 || objArr == objArr2) {
            return this;
        }
        if (objArr == null) {
            this.comparison = -1;
            return this;
        }
        if (objArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (objArr.length != objArr2.length) {
            this.comparison = objArr.length >= objArr2.length ? 1 : -1;
            return this;
        }
        for (int i7 = 0; i7 < objArr.length && this.comparison == 0; i7++) {
            append(objArr[i7], objArr2[i7], comparator);
        }
        return this;
    }

    public CompareToBuilder append(long[] jArr, long[] jArr2) {
        if (this.comparison != 0 || jArr == jArr2) {
            return this;
        }
        if (jArr == null) {
            this.comparison = -1;
            return this;
        }
        if (jArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (jArr.length != jArr2.length) {
            this.comparison = jArr.length >= jArr2.length ? 1 : -1;
            return this;
        }
        for (int i7 = 0; i7 < jArr.length && this.comparison == 0; i7++) {
            append(jArr[i7], jArr2[i7]);
        }
        return this;
    }

    public CompareToBuilder append(int[] iArr, int[] iArr2) {
        if (this.comparison != 0 || iArr == iArr2) {
            return this;
        }
        if (iArr == null) {
            this.comparison = -1;
            return this;
        }
        if (iArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (iArr.length != iArr2.length) {
            this.comparison = iArr.length >= iArr2.length ? 1 : -1;
            return this;
        }
        for (int i7 = 0; i7 < iArr.length && this.comparison == 0; i7++) {
            append(iArr[i7], iArr2[i7]);
        }
        return this;
    }

    public CompareToBuilder append(short[] sArr, short[] sArr2) {
        if (this.comparison != 0 || sArr == sArr2) {
            return this;
        }
        if (sArr == null) {
            this.comparison = -1;
            return this;
        }
        if (sArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (sArr.length != sArr2.length) {
            this.comparison = sArr.length >= sArr2.length ? 1 : -1;
            return this;
        }
        for (int i7 = 0; i7 < sArr.length && this.comparison == 0; i7++) {
            append(sArr[i7], sArr2[i7]);
        }
        return this;
    }

    public CompareToBuilder append(char[] cArr, char[] cArr2) {
        if (this.comparison != 0 || cArr == cArr2) {
            return this;
        }
        if (cArr == null) {
            this.comparison = -1;
            return this;
        }
        if (cArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (cArr.length != cArr2.length) {
            this.comparison = cArr.length >= cArr2.length ? 1 : -1;
            return this;
        }
        for (int i7 = 0; i7 < cArr.length && this.comparison == 0; i7++) {
            append(cArr[i7], cArr2[i7]);
        }
        return this;
    }

    public CompareToBuilder append(byte[] bArr, byte[] bArr2) {
        if (this.comparison != 0 || bArr == bArr2) {
            return this;
        }
        if (bArr == null) {
            this.comparison = -1;
            return this;
        }
        if (bArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (bArr.length != bArr2.length) {
            this.comparison = bArr.length >= bArr2.length ? 1 : -1;
            return this;
        }
        for (int i7 = 0; i7 < bArr.length && this.comparison == 0; i7++) {
            append(bArr[i7], bArr2[i7]);
        }
        return this;
    }

    public CompareToBuilder append(double[] dArr, double[] dArr2) {
        if (this.comparison != 0 || dArr == dArr2) {
            return this;
        }
        if (dArr == null) {
            this.comparison = -1;
            return this;
        }
        if (dArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (dArr.length != dArr2.length) {
            this.comparison = dArr.length >= dArr2.length ? 1 : -1;
            return this;
        }
        for (int i7 = 0; i7 < dArr.length && this.comparison == 0; i7++) {
            append(dArr[i7], dArr2[i7]);
        }
        return this;
    }

    public CompareToBuilder append(float[] fArr, float[] fArr2) {
        if (this.comparison != 0 || fArr == fArr2) {
            return this;
        }
        if (fArr == null) {
            this.comparison = -1;
            return this;
        }
        if (fArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (fArr.length != fArr2.length) {
            this.comparison = fArr.length >= fArr2.length ? 1 : -1;
            return this;
        }
        for (int i7 = 0; i7 < fArr.length && this.comparison == 0; i7++) {
            append(fArr[i7], fArr2[i7]);
        }
        return this;
    }

    public CompareToBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (this.comparison != 0 || zArr == zArr2) {
            return this;
        }
        if (zArr == null) {
            this.comparison = -1;
            return this;
        }
        if (zArr2 == null) {
            this.comparison = 1;
            return this;
        }
        if (zArr.length != zArr2.length) {
            this.comparison = zArr.length >= zArr2.length ? 1 : -1;
            return this;
        }
        for (int i7 = 0; i7 < zArr.length && this.comparison == 0; i7++) {
            append(zArr[i7], zArr2[i7]);
        }
        return this;
    }
}
