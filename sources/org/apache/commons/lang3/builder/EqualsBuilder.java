package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.Pair;

/* JADX INFO: loaded from: classes3.dex */
public class EqualsBuilder implements Builder<Boolean> {
    private static final ThreadLocal<Set<Pair<IDKey, IDKey>>> REGISTRY = new ThreadLocal<>();
    private boolean isEquals = true;

    static Pair<IDKey, IDKey> getRegisterPair(Object obj, Object obj2) {
        return Pair.of(new IDKey(obj), new IDKey(obj2));
    }

    static Set<Pair<IDKey, IDKey>> getRegistry() {
        return REGISTRY.get();
    }

    static boolean isRegistered(Object obj, Object obj2) {
        Set<Pair<IDKey, IDKey>> registry = getRegistry();
        Pair<IDKey, IDKey> registerPair = getRegisterPair(obj, obj2);
        return registry != null && (registry.contains(registerPair) || registry.contains(Pair.of(registerPair.getLeft(), registerPair.getRight())));
    }

    private static void reflectionAppend(Object obj, Object obj2, Class<?> cls, EqualsBuilder equalsBuilder, boolean z7, String[] strArr) {
        if (isRegistered(obj, obj2)) {
            return;
        }
        try {
            register(obj, obj2);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (int i7 = 0; i7 < declaredFields.length && equalsBuilder.isEquals; i7++) {
                Field field = declaredFields[i7];
                if (!ArrayUtils.contains(strArr, field.getName()) && field.getName().indexOf(36) == -1 && ((z7 || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                    try {
                        equalsBuilder.append(field.get(obj), field.get(obj2));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
            unregister(obj, obj2);
        } catch (Throwable th) {
            unregister(obj, obj2);
            throw th;
        }
    }

    public static boolean reflectionEquals(Object obj, Object obj2, Collection<String> collection) {
        return reflectionEquals(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    static void register(Object obj, Object obj2) {
        synchronized (EqualsBuilder.class) {
            if (getRegistry() == null) {
                REGISTRY.set(new HashSet());
            }
        }
        getRegistry().add(getRegisterPair(obj, obj2));
    }

    static void unregister(Object obj, Object obj2) {
        Set<Pair<IDKey, IDKey>> registry = getRegistry();
        if (registry != null) {
            registry.remove(getRegisterPair(obj, obj2));
            synchronized (EqualsBuilder.class) {
                Set<Pair<IDKey, IDKey>> registry2 = getRegistry();
                if (registry2 != null && registry2.isEmpty()) {
                    REGISTRY.remove();
                }
            }
        }
    }

    public EqualsBuilder append(Object obj, Object obj2) {
        if (!this.isEquals || obj == obj2) {
            return this;
        }
        if (obj == null || obj2 == null) {
            setEquals(false);
            return this;
        }
        if (!obj.getClass().isArray()) {
            this.isEquals = obj.equals(obj2);
        } else if (obj.getClass() != obj2.getClass()) {
            setEquals(false);
        } else if (obj instanceof long[]) {
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
            append((Object[]) obj, (Object[]) obj2);
        }
        return this;
    }

    public EqualsBuilder appendSuper(boolean z7) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = z7;
        return this;
    }

    public boolean isEquals() {
        return this.isEquals;
    }

    public void reset() {
        this.isEquals = true;
    }

    protected void setEquals(boolean z7) {
        this.isEquals = z7;
    }

    public static boolean reflectionEquals(Object obj, Object obj2, String... strArr) {
        return reflectionEquals(obj, obj2, false, null, strArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.lang3.builder.Builder
    public Boolean build() {
        return Boolean.valueOf(isEquals());
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z7) {
        return reflectionEquals(obj, obj2, z7, null, new String[0]);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0039 A[Catch: IllegalArgumentException -> 0x0061, TryCatch #0 {IllegalArgumentException -> 0x0061, blocks: (B:21:0x0033, B:23:0x0039, B:24:0x003d, B:25:0x0046, B:28:0x004e), top: B:34:0x0033 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x003d A[Catch: IllegalArgumentException -> 0x0061, TryCatch #0 {IllegalArgumentException -> 0x0061, blocks: (B:21:0x0033, B:23:0x0039, B:24:0x003d, B:25:0x0046, B:28:0x004e), top: B:34:0x0033 }] */
    public static boolean reflectionEquals(Object obj, Object obj2, boolean z7, Class<?> cls, String... strArr) {
        EqualsBuilder equalsBuilder;
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj2 != null) {
            Class<?> superclass = obj.getClass();
            Class<?> cls2 = obj2.getClass();
            if (superclass.isInstance(obj2)) {
                if (!cls2.isInstance(obj)) {
                    superclass = cls2;
                }
                equalsBuilder = new EqualsBuilder();
                try {
                    if (superclass.isArray()) {
                        equalsBuilder.append(obj, obj2);
                    } else {
                        reflectionAppend(obj, obj2, superclass, equalsBuilder, z7, strArr);
                        while (superclass.getSuperclass() != null && superclass != cls) {
                            superclass = superclass.getSuperclass();
                            reflectionAppend(obj, obj2, superclass, equalsBuilder, z7, strArr);
                        }
                    }
                    return equalsBuilder.isEquals();
                } catch (IllegalArgumentException unused) {
                }
            } else if (cls2.isInstance(obj)) {
                if (superclass.isInstance(obj2)) {
                    superclass = cls2;
                }
                equalsBuilder = new EqualsBuilder();
                if (superclass.isArray()) {
                    equalsBuilder.append(obj, obj2);
                } else {
                    reflectionAppend(obj, obj2, superclass, equalsBuilder, z7, strArr);
                    while (superclass.getSuperclass() != null) {
                        superclass = superclass.getSuperclass();
                        reflectionAppend(obj, obj2, superclass, equalsBuilder, z7, strArr);
                    }
                }
                return equalsBuilder.isEquals();
            }
        }
        return false;
    }

    public EqualsBuilder append(long j7, long j8) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = j7 == j8;
        return this;
    }

    public EqualsBuilder append(int i7, int i8) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = i7 == i8;
        return this;
    }

    public EqualsBuilder append(short s7, short s8) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = s7 == s8;
        return this;
    }

    public EqualsBuilder append(char c8, char c9) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = c8 == c9;
        return this;
    }

    public EqualsBuilder append(byte b8, byte b9) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = b8 == b9;
        return this;
    }

    public EqualsBuilder append(double d8, double d9) {
        return !this.isEquals ? this : append(Double.doubleToLongBits(d8), Double.doubleToLongBits(d9));
    }

    public EqualsBuilder append(float f8, float f9) {
        return !this.isEquals ? this : append(Float.floatToIntBits(f8), Float.floatToIntBits(f9));
    }

    public EqualsBuilder append(boolean z7, boolean z8) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = z7 == z8;
        return this;
    }

    public EqualsBuilder append(Object[] objArr, Object[] objArr2) {
        if (!this.isEquals || objArr == objArr2) {
            return this;
        }
        if (objArr != null && objArr2 != null) {
            if (objArr.length != objArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i7 = 0; i7 < objArr.length && this.isEquals; i7++) {
                append(objArr[i7], objArr2[i7]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(long[] jArr, long[] jArr2) {
        if (!this.isEquals || jArr == jArr2) {
            return this;
        }
        if (jArr != null && jArr2 != null) {
            if (jArr.length != jArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i7 = 0; i7 < jArr.length && this.isEquals; i7++) {
                append(jArr[i7], jArr2[i7]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(int[] iArr, int[] iArr2) {
        if (!this.isEquals || iArr == iArr2) {
            return this;
        }
        if (iArr != null && iArr2 != null) {
            if (iArr.length != iArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i7 = 0; i7 < iArr.length && this.isEquals; i7++) {
                append(iArr[i7], iArr2[i7]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(short[] sArr, short[] sArr2) {
        if (!this.isEquals || sArr == sArr2) {
            return this;
        }
        if (sArr != null && sArr2 != null) {
            if (sArr.length != sArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i7 = 0; i7 < sArr.length && this.isEquals; i7++) {
                append(sArr[i7], sArr2[i7]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(char[] cArr, char[] cArr2) {
        if (!this.isEquals || cArr == cArr2) {
            return this;
        }
        if (cArr != null && cArr2 != null) {
            if (cArr.length != cArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i7 = 0; i7 < cArr.length && this.isEquals; i7++) {
                append(cArr[i7], cArr2[i7]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(byte[] bArr, byte[] bArr2) {
        if (!this.isEquals || bArr == bArr2) {
            return this;
        }
        if (bArr != null && bArr2 != null) {
            if (bArr.length != bArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i7 = 0; i7 < bArr.length && this.isEquals; i7++) {
                append(bArr[i7], bArr2[i7]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(double[] dArr, double[] dArr2) {
        if (!this.isEquals || dArr == dArr2) {
            return this;
        }
        if (dArr != null && dArr2 != null) {
            if (dArr.length != dArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i7 = 0; i7 < dArr.length && this.isEquals; i7++) {
                append(dArr[i7], dArr2[i7]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(float[] fArr, float[] fArr2) {
        if (!this.isEquals || fArr == fArr2) {
            return this;
        }
        if (fArr != null && fArr2 != null) {
            if (fArr.length != fArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i7 = 0; i7 < fArr.length && this.isEquals; i7++) {
                append(fArr[i7], fArr2[i7]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }

    public EqualsBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (!this.isEquals || zArr == zArr2) {
            return this;
        }
        if (zArr != null && zArr2 != null) {
            if (zArr.length != zArr2.length) {
                setEquals(false);
                return this;
            }
            for (int i7 = 0; i7 < zArr.length && this.isEquals; i7++) {
                append(zArr[i7], zArr2[i7]);
            }
            return this;
        }
        setEquals(false);
        return this;
    }
}
