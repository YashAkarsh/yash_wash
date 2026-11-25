package kotlin.collections.builders;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    @a7.d
    public static final <E> E[] d(int i7) {
        if (i7 >= 0) {
            return (E[]) new Object[i7];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    @a7.d
    public static final <T> T[] e(@a7.d T[] tArr, int i7) {
        l0.p(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i7);
        l0.o(tArr2, "copyOf(this, newSize)");
        l0.n(tArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilderKt.copyOfUninitializedElements>");
        return tArr2;
    }

    public static final <E> void f(@a7.d E[] eArr, int i7) {
        l0.p(eArr, "<this>");
        eArr[i7] = null;
    }

    public static final <E> void g(@a7.d E[] eArr, int i7, int i8) {
        l0.p(eArr, "<this>");
        while (i7 < i8) {
            f(eArr, i7);
            i7++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean h(T[] tArr, int i7, int i8, List<?> list) {
        if (i8 != list.size()) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (!l0.g(tArr[i7 + i9], list.get(i9))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int i(T[] tArr, int i7, int i8) {
        int iHashCode = 1;
        for (int i9 = 0; i9 < i8; i9++) {
            T t7 = tArr[i7 + i9];
            iHashCode = (iHashCode * 31) + (t7 != null ? t7.hashCode() : 0);
        }
        return iHashCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String j(T[] tArr, int i7, int i8) {
        StringBuilder sb = new StringBuilder((i8 * 3) + 2);
        sb.append("[");
        for (int i9 = 0; i9 < i8; i9++) {
            if (i9 > 0) {
                sb.append(", ");
            }
            sb.append(tArr[i7 + i9]);
        }
        sb.append("]");
        String string = sb.toString();
        l0.o(string, "sb.toString()");
        return string;
    }
}
