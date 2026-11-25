package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes3.dex */
public class HashCodeBuilder implements Builder<Integer> {
    private static final int DEFAULT_INITIAL_VALUE = 17;
    private static final int DEFAULT_MULTIPLIER_VALUE = 37;
    private static final ThreadLocal<Set<IDKey>> REGISTRY = new ThreadLocal<>();
    private final int iConstant;
    private int iTotal;

    public HashCodeBuilder() {
        this.iConstant = 37;
        this.iTotal = 17;
    }

    static Set<IDKey> getRegistry() {
        return REGISTRY.get();
    }

    static boolean isRegistered(Object obj) {
        Set<IDKey> registry = getRegistry();
        return registry != null && registry.contains(new IDKey(obj));
    }

    private static void reflectionAppend(Object obj, Class<?> cls, HashCodeBuilder hashCodeBuilder, boolean z7, String[] strArr) {
        if (isRegistered(obj)) {
            return;
        }
        try {
            register(obj);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                if (!ArrayUtils.contains(strArr, field.getName()) && field.getName().indexOf(36) == -1 && ((z7 || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()))) {
                    try {
                        hashCodeBuilder.append(field.get(obj));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
            unregister(obj);
        } catch (Throwable th) {
            unregister(obj);
            throw th;
        }
    }

    public static int reflectionHashCode(int i7, int i8, Object obj) {
        return reflectionHashCode(i7, i8, obj, false, null, new String[0]);
    }

    static void register(Object obj) {
        synchronized (HashCodeBuilder.class) {
            if (getRegistry() == null) {
                REGISTRY.set(new HashSet());
            }
        }
        getRegistry().add(new IDKey(obj));
    }

    static void unregister(Object obj) {
        Set<IDKey> registry = getRegistry();
        if (registry != null) {
            registry.remove(new IDKey(obj));
            synchronized (HashCodeBuilder.class) {
                Set<IDKey> registry2 = getRegistry();
                if (registry2 != null && registry2.isEmpty()) {
                    REGISTRY.remove();
                }
            }
        }
    }

    public HashCodeBuilder append(boolean z7) {
        this.iTotal = (this.iTotal * this.iConstant) + (!z7 ? 1 : 0);
        return this;
    }

    public HashCodeBuilder appendSuper(int i7) {
        this.iTotal = (this.iTotal * this.iConstant) + i7;
        return this;
    }

    public int hashCode() {
        return toHashCode();
    }

    public int toHashCode() {
        return this.iTotal;
    }

    public static int reflectionHashCode(int i7, int i8, Object obj, boolean z7) {
        return reflectionHashCode(i7, i8, obj, z7, null, new String[0]);
    }

    public HashCodeBuilder append(boolean[] zArr) {
        if (zArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (boolean z7 : zArr) {
                append(z7);
            }
        }
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.lang3.builder.Builder
    public Integer build() {
        return Integer.valueOf(toHashCode());
    }

    public static <T> int reflectionHashCode(int i7, int i8, T t7, boolean z7, Class<? super T> cls, String... strArr) {
        if (t7 != null) {
            HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(i7, i8);
            Class<?> superclass = t7.getClass();
            reflectionAppend(t7, superclass, hashCodeBuilder, z7, strArr);
            while (superclass.getSuperclass() != null && superclass != cls) {
                superclass = superclass.getSuperclass();
                reflectionAppend(t7, superclass, hashCodeBuilder, z7, strArr);
            }
            return hashCodeBuilder.toHashCode();
        }
        throw new IllegalArgumentException("The object to build a hash code for must not be null");
    }

    public HashCodeBuilder(int i7, int i8) {
        this.iTotal = 0;
        Validate.isTrue(i7 % 2 != 0, "HashCodeBuilder requires an odd initial value", new Object[0]);
        Validate.isTrue(i8 % 2 != 0, "HashCodeBuilder requires an odd multiplier", new Object[0]);
        this.iConstant = i8;
        this.iTotal = i7;
    }

    public HashCodeBuilder append(byte b8) {
        this.iTotal = (this.iTotal * this.iConstant) + b8;
        return this;
    }

    public HashCodeBuilder append(byte[] bArr) {
        if (bArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (byte b8 : bArr) {
                append(b8);
            }
        }
        return this;
    }

    public HashCodeBuilder append(char c8) {
        this.iTotal = (this.iTotal * this.iConstant) + c8;
        return this;
    }

    public HashCodeBuilder append(char[] cArr) {
        if (cArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (char c8 : cArr) {
                append(c8);
            }
        }
        return this;
    }

    public static int reflectionHashCode(Object obj, boolean z7) {
        return reflectionHashCode(17, 37, obj, z7, null, new String[0]);
    }

    public static int reflectionHashCode(Object obj, Collection<String> collection) {
        return reflectionHashCode(obj, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public static int reflectionHashCode(Object obj, String... strArr) {
        return reflectionHashCode(17, 37, obj, false, null, strArr);
    }

    public HashCodeBuilder append(double d8) {
        return append(Double.doubleToLongBits(d8));
    }

    public HashCodeBuilder append(double[] dArr) {
        if (dArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (double d8 : dArr) {
                append(d8);
            }
        }
        return this;
    }

    public HashCodeBuilder append(float f8) {
        this.iTotal = (this.iTotal * this.iConstant) + Float.floatToIntBits(f8);
        return this;
    }

    public HashCodeBuilder append(float[] fArr) {
        if (fArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (float f8 : fArr) {
                append(f8);
            }
        }
        return this;
    }

    public HashCodeBuilder append(int i7) {
        this.iTotal = (this.iTotal * this.iConstant) + i7;
        return this;
    }

    public HashCodeBuilder append(int[] iArr) {
        if (iArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (int i7 : iArr) {
                append(i7);
            }
        }
        return this;
    }

    public HashCodeBuilder append(long j7) {
        this.iTotal = (this.iTotal * this.iConstant) + ((int) (j7 ^ (j7 >> 32)));
        return this;
    }

    public HashCodeBuilder append(long[] jArr) {
        if (jArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (long j7 : jArr) {
                append(j7);
            }
        }
        return this;
    }

    public HashCodeBuilder append(Object obj) {
        if (obj == null) {
            this.iTotal *= this.iConstant;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof long[]) {
                append((long[]) obj);
            } else if (obj instanceof int[]) {
                append((int[]) obj);
            } else if (obj instanceof short[]) {
                append((short[]) obj);
            } else if (obj instanceof char[]) {
                append((char[]) obj);
            } else if (obj instanceof byte[]) {
                append((byte[]) obj);
            } else if (obj instanceof double[]) {
                append((double[]) obj);
            } else if (obj instanceof float[]) {
                append((float[]) obj);
            } else if (obj instanceof boolean[]) {
                append((boolean[]) obj);
            } else {
                append((Object[]) obj);
            }
        } else {
            this.iTotal = (this.iTotal * this.iConstant) + obj.hashCode();
        }
        return this;
    }

    public HashCodeBuilder append(Object[] objArr) {
        if (objArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (Object obj : objArr) {
                append(obj);
            }
        }
        return this;
    }

    public HashCodeBuilder append(short s7) {
        this.iTotal = (this.iTotal * this.iConstant) + s7;
        return this;
    }

    public HashCodeBuilder append(short[] sArr) {
        if (sArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (short s7 : sArr) {
                append(s7);
            }
        }
        return this;
    }
}
