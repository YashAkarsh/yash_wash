package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f34706a = 1;

    private static final void a(int i7, int i8) {
        if (i8 <= i7) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i7 + ", got " + i8 + ". Please update the Kotlin standard library.").toString());
    }

    private static final f b(a aVar) {
        return (f) aVar.getClass().getAnnotation(f.class);
    }

    private static final int c(a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @g1(version = "1.3")
    @a7.e
    @h5.h(name = "getSpilledVariableFieldMapping")
    public static final String[] d(@a7.d a aVar) {
        l0.p(aVar, "<this>");
        f fVarB = b(aVar);
        if (fVarB == null) {
            return null;
        }
        a(1, fVarB.v());
        ArrayList arrayList = new ArrayList();
        int iC = c(aVar);
        int[] iArrI = fVarB.i();
        int length = iArrI.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (iArrI[i7] == iC) {
                arrayList.add(fVarB.s()[i7]);
                arrayList.add(fVarB.n()[i7]);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        l0.n(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    @g1(version = "1.3")
    @a7.e
    @h5.h(name = "getStackTraceElement")
    public static final StackTraceElement e(@a7.d a aVar) {
        String strC;
        l0.p(aVar, "<this>");
        f fVarB = b(aVar);
        if (fVarB == null) {
            return null;
        }
        a(1, fVarB.v());
        int iC = c(aVar);
        int i7 = iC < 0 ? -1 : fVarB.l()[iC];
        String strB = i.f34707a.b(aVar);
        if (strB == null) {
            strC = fVarB.c();
        } else {
            strC = strB + '/' + fVarB.c();
        }
        return new StackTraceElement(strC, fVarB.m(), fVarB.f(), i7);
    }
}
