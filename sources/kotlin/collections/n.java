package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.b2;
import kotlin.h2;
import kotlin.x1;

/* JADX INFO: loaded from: classes2.dex */
class n extends m {
    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.g1(version = "1.3")
    @h5.h(name = "contentDeepEquals")
    @kotlin.a1
    public static final <T> boolean g(@a7.e T[] tArr, @a7.e T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            Object[] objArr = tArr[i7];
            Object[] objArr2 = tArr2[i7];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!g(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof kotlin.t1) && (objArr2 instanceof kotlin.t1)) {
                    if (!kotlin.collections.unsigned.c.V0(((kotlin.t1) objArr).x(), ((kotlin.t1) objArr2).x())) {
                        return false;
                    }
                } else if ((objArr instanceof h2) && (objArr2 instanceof h2)) {
                    if (!kotlin.collections.unsigned.c.S0(((h2) objArr).x(), ((h2) objArr2).x())) {
                        return false;
                    }
                } else if ((objArr instanceof x1) && (objArr2 instanceof x1)) {
                    if (!kotlin.collections.unsigned.c.T0(((x1) objArr).x(), ((x1) objArr2).x())) {
                        return false;
                    }
                } else if ((objArr instanceof b2) && (objArr2 instanceof b2)) {
                    if (!kotlin.collections.unsigned.c.X0(((b2) objArr).x(), ((b2) objArr2).x())) {
                        return false;
                    }
                } else if (!kotlin.jvm.internal.l0.g(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @kotlin.g1(version = "1.3")
    @h5.h(name = "contentDeepToString")
    @a7.d
    @kotlin.a1
    public static final <T> String h(@a7.e T[] tArr) {
        if (tArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder((kotlin.ranges.q.u(tArr.length, 429496729) * 5) + 2);
        i(tArr, sb, new ArrayList());
        String string = sb.toString();
        kotlin.jvm.internal.l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void i(T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (i7 != 0) {
                sb.append(", ");
            }
            Object[] objArr = tArr[i7];
            if (objArr == 0) {
                sb.append("null");
            } else if (objArr instanceof Object[]) {
                i(objArr, sb, list);
            } else if (objArr instanceof byte[]) {
                String string = Arrays.toString((byte[]) objArr);
                kotlin.jvm.internal.l0.o(string, "toString(this)");
                sb.append(string);
            } else if (objArr instanceof short[]) {
                String string2 = Arrays.toString((short[]) objArr);
                kotlin.jvm.internal.l0.o(string2, "toString(this)");
                sb.append(string2);
            } else if (objArr instanceof int[]) {
                String string3 = Arrays.toString((int[]) objArr);
                kotlin.jvm.internal.l0.o(string3, "toString(this)");
                sb.append(string3);
            } else if (objArr instanceof long[]) {
                String string4 = Arrays.toString((long[]) objArr);
                kotlin.jvm.internal.l0.o(string4, "toString(this)");
                sb.append(string4);
            } else if (objArr instanceof float[]) {
                String string5 = Arrays.toString((float[]) objArr);
                kotlin.jvm.internal.l0.o(string5, "toString(this)");
                sb.append(string5);
            } else if (objArr instanceof double[]) {
                String string6 = Arrays.toString((double[]) objArr);
                kotlin.jvm.internal.l0.o(string6, "toString(this)");
                sb.append(string6);
            } else if (objArr instanceof char[]) {
                String string7 = Arrays.toString((char[]) objArr);
                kotlin.jvm.internal.l0.o(string7, "toString(this)");
                sb.append(string7);
            } else if (objArr instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) objArr);
                kotlin.jvm.internal.l0.o(string8, "toString(this)");
                sb.append(string8);
            } else if (objArr instanceof kotlin.t1) {
                sb.append(kotlin.collections.unsigned.c.j1(((kotlin.t1) objArr).x()));
            } else if (objArr instanceof h2) {
                sb.append(kotlin.collections.unsigned.c.n1(((h2) objArr).x()));
            } else if (objArr instanceof x1) {
                sb.append(kotlin.collections.unsigned.c.m1(((x1) objArr).x()));
            } else if (objArr instanceof b2) {
                sb.append(kotlin.collections.unsigned.c.p1(((b2) objArr).x()));
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(']');
        list.remove(y.H(list));
    }

    @a7.d
    public static final <T> List<T> j(@a7.d T[][] tArr) {
        kotlin.jvm.internal.l0.p(tArr, "<this>");
        int length = 0;
        for (T[] tArr2 : tArr) {
            length += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(length);
        for (T[] tArr3 : tArr) {
            d0.q0(arrayList, tArr3);
        }
        return arrayList;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Li5/a<+TR;>;)TR; */
    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final Object k(Object[] objArr, i5.a defaultValue) {
        kotlin.jvm.internal.l0.p(defaultValue, "defaultValue");
        return objArr.length == 0 ? defaultValue.invoke() : objArr;
    }

    @kotlin.g1(version = "1.3")
    @kotlin.internal.f
    private static final boolean l(Object[] objArr) {
        if (objArr != null) {
            return objArr.length == 0;
        }
        return true;
    }

    @a7.d
    public static final <T, R> kotlin.u0<List<T>, List<R>> m(@a7.d kotlin.u0<? extends T, ? extends R>[] u0VarArr) {
        kotlin.jvm.internal.l0.p(u0VarArr, "<this>");
        ArrayList arrayList = new ArrayList(u0VarArr.length);
        ArrayList arrayList2 = new ArrayList(u0VarArr.length);
        for (kotlin.u0<? extends T, ? extends R> u0Var : u0VarArr) {
            arrayList.add(u0Var.e());
            arrayList2.add(u0Var.f());
        }
        return kotlin.p1.a(arrayList, arrayList2);
    }
}
