package y5;

import androidx.constraintlayout.core.motion.utils.w;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public enum a {
    GENERAL(null, "bBhHsS"),
    CHAR(new Class[]{Character.class, Byte.class, Short.class, Integer.class}, "cC"),
    INT(new Class[]{Byte.class, Short.class, Integer.class, Long.class, BigInteger.class}, "doxX"),
    FLOAT(new Class[]{Float.class, Double.class, BigDecimal.class}, "eEfgGaA"),
    TIME(new Class[]{Long.class, Calendar.class, Date.class}, "tT"),
    CHAR_AND_INT(new Class[]{Byte.class, Short.class, Integer.class}, null),
    INT_AND_TIME(new Class[]{Long.class}, null),
    NULL(new Class[0], null),
    UNUSED(null, null);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends Object>[] f40651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40652b;

    a(Class[] clsArr, String str) {
        this.f40651a = clsArr;
        this.f40652b = str;
    }

    private static <E> Set<E> a(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    private String b(Class<?> cls) {
        if (cls == Boolean.class) {
            return w.b.f3031f;
        }
        if (cls == Character.class) {
            return "char";
        }
        if (cls == Byte.class) {
            return "byte";
        }
        if (cls == Short.class) {
            return "short";
        }
        if (cls == Integer.class) {
            return "int";
        }
        if (cls == Long.class) {
            return "long";
        }
        if (cls == Float.class) {
            return w.b.f3028c;
        }
        return cls == Double.class ? "double" : cls.getSimpleName();
    }

    public static a c(char c8) {
        a[] aVarArr = {GENERAL, CHAR, INT, FLOAT, TIME};
        for (int i7 = 0; i7 < 5; i7++) {
            a aVar = aVarArr[i7];
            if (aVar.f40652b.contains(String.valueOf(c8))) {
                return aVar;
            }
        }
        throw new IllegalArgumentException();
    }

    public static a d(a aVar, a aVar2) {
        a aVar3 = UNUSED;
        if (aVar == aVar3) {
            return aVar2;
        }
        if (aVar2 == aVar3) {
            return aVar;
        }
        a aVar4 = GENERAL;
        if (aVar == aVar4) {
            return aVar2;
        }
        if (aVar2 == aVar4) {
            return aVar;
        }
        Set setA = a(aVar.f40651a);
        setA.retainAll(a(aVar2.f40651a));
        a[] aVarArr = {CHAR, INT, FLOAT, TIME, CHAR_AND_INT, INT_AND_TIME, NULL};
        for (int i7 = 0; i7 < 7; i7++) {
            a aVar5 = aVarArr[i7];
            if (a(aVar5.f40651a).equals(setA)) {
                return aVar5;
            }
        }
        throw new RuntimeException();
    }

    public static boolean e(a aVar, a aVar2) {
        return d(aVar, aVar2) == aVar;
    }

    public static a f(a aVar, a aVar2) {
        a aVar3;
        a aVar4 = UNUSED;
        if (aVar == aVar4 || aVar2 == aVar4 || aVar == (aVar4 = GENERAL) || aVar2 == aVar4) {
            return aVar4;
        }
        a aVar5 = CHAR_AND_INT;
        if ((aVar == aVar5 && aVar2 == INT_AND_TIME) || (aVar == (aVar3 = INT_AND_TIME) && aVar2 == aVar5)) {
            return INT;
        }
        Set setA = a(aVar.f40651a);
        setA.addAll(a(aVar2.f40651a));
        a[] aVarArr = {NULL, aVar5, aVar3, CHAR, INT, FLOAT, TIME};
        for (int i7 = 0; i7 < 7; i7++) {
            a aVar6 = aVarArr[i7];
            if (a(aVar6.f40651a).equals(setA)) {
                return aVar6;
            }
        }
        return GENERAL;
    }

    @Override // java.lang.Enum
    @u6.b
    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        sb.append(" conversion category (one of: ");
        Class<? extends Object>[] clsArr = this.f40651a;
        int length = clsArr.length;
        boolean z7 = true;
        int i7 = 0;
        while (i7 < length) {
            Class<? extends Object> cls = clsArr[i7];
            if (!z7) {
                sb.append(", ");
            }
            sb.append(b(cls));
            i7++;
            z7 = false;
        }
        sb.append(")");
        return sb.toString();
    }
}
