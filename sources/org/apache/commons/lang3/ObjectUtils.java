package org.apache.commons.lang3;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;

/* JADX INFO: loaded from: classes3.dex */
public class ObjectUtils {
    public static final Null NULL = new Null();

    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        Null() {
        }

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    public static byte CONST(byte b8) {
        return b8;
    }

    public static byte CONST_BYTE(int i7) throws IllegalArgumentException {
        if (i7 >= -128 && i7 <= 127) {
            return (byte) i7;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + i7 + "]");
    }

    public static short CONST_SHORT(int i7) throws IllegalArgumentException {
        if (i7 >= -32768 && i7 <= 32767) {
            return (short) i7;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + i7 + "]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T clone(T t7) {
        if (!(t7 instanceof Cloneable)) {
            return null;
        }
        if (!t7.getClass().isArray()) {
            try {
                return (T) t7.getClass().getMethod("clone", new Class[0]).invoke(t7, new Object[0]);
            } catch (IllegalAccessException e8) {
                throw new CloneFailedException("Cannot clone Cloneable type " + t7.getClass().getName(), e8);
            } catch (NoSuchMethodException e9) {
                throw new CloneFailedException("Cloneable type " + t7.getClass().getName() + " has no clone method", e9);
            } catch (InvocationTargetException e10) {
                throw new CloneFailedException("Exception cloning Cloneable type " + t7.getClass().getName(), e10.getCause());
            }
        }
        Class<?> componentType = t7.getClass().getComponentType();
        if (!componentType.isPrimitive()) {
            return (T) ((Object[]) t7).clone();
        }
        int length = Array.getLength(t7);
        T t8 = (T) Array.newInstance(componentType, length);
        while (true) {
            int i7 = length - 1;
            if (length <= 0) {
                return t8;
            }
            Array.set(t8, i7, Array.get(t7, i7));
            length = i7;
        }
    }

    public static <T> T cloneIfPossible(T t7) {
        T t8 = (T) clone(t7);
        return t8 == null ? t7 : t8;
    }

    public static <T extends Comparable<? super T>> int compare(T t7, T t8) {
        return compare(t7, t8, false);
    }

    public static <T> T defaultIfNull(T t7, T t8) {
        return t7 != null ? t7 : t8;
    }

    @Deprecated
    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static <T> T firstNonNull(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t7 : tArr) {
            if (t7 != null) {
                return t7;
            }
        }
        return null;
    }

    @Deprecated
    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Deprecated
    public static int hashCodeMulti(Object... objArr) {
        int iHashCode = 1;
        if (objArr != null) {
            for (Object obj : objArr) {
                iHashCode = (iHashCode * 31) + hashCode(obj);
            }
        }
        return iHashCode;
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        identityToString(sb, obj);
        return sb.toString();
    }

    public static <T extends Comparable<? super T>> T max(T... tArr) {
        T t7 = null;
        if (tArr != null) {
            for (T t8 : tArr) {
                if (compare(t8, t7, false) > 0) {
                    t7 = t8;
                }
            }
        }
        return t7;
    }

    public static <T extends Comparable<? super T>> T median(T... tArr) {
        Validate.notEmpty(tArr);
        Validate.noNullElements(tArr);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static <T extends Comparable<? super T>> T min(T... tArr) {
        T t7 = null;
        if (tArr != null) {
            for (T t8 : tArr) {
                if (compare(t8, t7, true) < 0) {
                    t7 = t8;
                }
            }
        }
        return t7;
    }

    public static <T> T mode(T... tArr) {
        if (!ArrayUtils.isNotEmpty(tArr)) {
            return null;
        }
        HashMap map = new HashMap(tArr.length);
        int i7 = 0;
        for (T t7 : tArr) {
            MutableInt mutableInt = (MutableInt) map.get(t7);
            if (mutableInt == null) {
                map.put(t7, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        while (true) {
            T t8 = null;
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue = ((MutableInt) entry.getValue()).intValue();
                if (iIntValue != i7) {
                    if (iIntValue > i7) {
                        t8 = (T) entry.getKey();
                        i7 = iIntValue;
                    }
                }
            }
            return t8;
        }
    }

    public static boolean notEqual(Object obj, Object obj2) {
        return !equals(obj, obj2);
    }

    @Deprecated
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static char CONST(char c8) {
        return c8;
    }

    public static <T extends Comparable<? super T>> int compare(T t7, T t8, boolean z7) {
        if (t7 == t8) {
            return 0;
        }
        if (t7 == null) {
            return z7 ? 1 : -1;
        }
        if (t8 == null) {
            return z7 ? -1 : 1;
        }
        return t7.compareTo(t8);
    }

    @Deprecated
    public static String toString(Object obj, String str) {
        return obj == null ? str : obj.toString();
    }

    public static double CONST(double d8) {
        return d8;
    }

    public static float CONST(float f8) {
        return f8;
    }

    public static void identityToString(Appendable appendable, Object obj) throws IOException {
        if (obj != null) {
            appendable.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }

    public static int CONST(int i7) {
        return i7;
    }

    public static long CONST(long j7) {
        return j7;
    }

    public static void identityToString(StrBuilder strBuilder, Object obj) {
        if (obj != null) {
            strBuilder.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }

    public static <T> T median(Comparator<T> comparator, T... tArr) {
        Validate.notEmpty(tArr, "null/empty items", new Object[0]);
        Validate.noNullElements(tArr);
        Validate.notNull(comparator, "null comparator", new Object[0]);
        TreeSet treeSet = new TreeSet(comparator);
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static <T> T CONST(T t7) {
        return t7;
    }

    public static short CONST(short s7) {
        return s7;
    }

    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        if (obj != null) {
            stringBuffer.append(obj.getClass().getName());
            stringBuffer.append('@');
            stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }

    public static boolean CONST(boolean z7) {
        return z7;
    }

    public static void identityToString(StringBuilder sb, Object obj) {
        if (obj != null) {
            sb.append(obj.getClass().getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
        throw new NullPointerException("Cannot get the toString of a null identity");
    }
}
