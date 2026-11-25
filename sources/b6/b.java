package b6;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public enum b {
    UNUSED(null, null),
    GENERAL(null, null),
    DATE(new Class[]{Date.class, Number.class}, new String[]{"date", "time"}),
    NUMBER(new Class[]{Number.class}, new String[]{"number", "choice"});


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends Object>[] f11323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f11324b;

    b(Class[] clsArr, String[] strArr) {
        this.f11323a = clsArr;
        this.f11324b = strArr;
    }

    private static <E> Set<E> a(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static b b(b bVar, b bVar2) {
        b bVar3 = UNUSED;
        if (bVar == bVar3) {
            return bVar2;
        }
        if (bVar2 == bVar3) {
            return bVar;
        }
        b bVar4 = GENERAL;
        if (bVar == bVar4) {
            return bVar2;
        }
        if (bVar2 == bVar4) {
            return bVar;
        }
        Set setA = a(bVar.f11323a);
        setA.retainAll(a(bVar2.f11323a));
        b[] bVarArr = {DATE, NUMBER};
        for (int i7 = 0; i7 < 2; i7++) {
            b bVar5 = bVarArr[i7];
            if (a(bVar5.f11323a).equals(setA)) {
                return bVar5;
            }
        }
        throw new RuntimeException();
    }

    public static boolean c(b bVar, b bVar2) {
        return b(bVar, bVar2) == bVar;
    }

    public static b d(String str) {
        String lowerCase = str.toLowerCase();
        b[] bVarArr = {DATE, NUMBER};
        for (int i7 = 0; i7 < 2; i7++) {
            b bVar = bVarArr[i7];
            for (String str2 : bVar.f11324b) {
                if (str2.equals(lowerCase)) {
                    return bVar;
                }
            }
        }
        throw new IllegalArgumentException("Invalid format type.");
    }

    public static b e(b bVar, b bVar2) {
        b bVar3 = UNUSED;
        return (bVar == bVar3 || bVar2 == bVar3 || bVar == (bVar3 = GENERAL) || bVar2 == bVar3 || bVar == (bVar3 = DATE) || bVar2 == bVar3) ? bVar3 : NUMBER;
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        if (this.f11323a == null) {
            sb.append(" conversion category (all types)");
        } else {
            sb.append(" conversion category (one of: ");
            Class<? extends Object>[] clsArr = this.f11323a;
            int length = clsArr.length;
            boolean z7 = true;
            int i7 = 0;
            while (i7 < length) {
                Class<? extends Object> cls = clsArr[i7];
                if (!z7) {
                    sb.append(", ");
                }
                sb.append(cls.getCanonicalName());
                i7++;
                z7 = false;
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
