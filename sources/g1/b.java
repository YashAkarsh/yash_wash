package g1;

import c.m0;
import c.o0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@d0
@c1.a
public final class b {
    private b() {
    }

    @c1.a
    @m0
    public static <T> T[] a(@m0 T[]... tArr) {
        if (tArr.length == 0) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass(), 0));
        }
        int length = 0;
        for (T[] tArr2 : tArr) {
            length += tArr2.length;
        }
        T[] tArr3 = (T[]) Arrays.copyOf(tArr[0], length);
        int length2 = tArr[0].length;
        for (int i7 = 1; i7 < tArr.length; i7++) {
            T[] tArr4 = tArr[i7];
            int length3 = tArr4.length;
            System.arraycopy(tArr4, 0, tArr3, length2, length3);
            length2 += length3;
        }
        return tArr3;
    }

    @c1.a
    @m0
    public static byte[] b(@m0 byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr[0], length);
        int length2 = bArr[0].length;
        for (int i7 = 1; i7 < bArr.length; i7++) {
            byte[] bArr3 = bArr[i7];
            int length3 = bArr3.length;
            System.arraycopy(bArr3, 0, bArrCopyOf, length2, length3);
            length2 += length3;
        }
        return bArrCopyOf;
    }

    @c1.a
    public static boolean c(@m0 int[] iArr, int i7) {
        if (iArr == null) {
            return false;
        }
        for (int i8 : iArr) {
            if (i8 == i7) {
                return true;
            }
        }
        return false;
    }

    @c1.a
    public static <T> boolean d(@m0 T[] tArr, @m0 T t7) {
        int length = tArr != null ? tArr.length : 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (com.google.android.gms.common.internal.s.b(tArr[i7], t7)) {
                if (i7 >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @c1.a
    @m0
    public static <T> ArrayList<T> e() {
        return new ArrayList<>();
    }

    @o0
    @c1.a
    public static <T> T[] f(@m0 T[] tArr, @m0 T... tArr2) {
        int length;
        int i7;
        if (tArr == null) {
            return null;
        }
        if (tArr2 == null || (length = tArr2.length) == 0) {
            return (T[]) Arrays.copyOf(tArr, tArr.length);
        }
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length));
        if (length == 1) {
            i7 = 0;
            for (T t7 : tArr) {
                if (!com.google.android.gms.common.internal.s.b(tArr2[0], t7)) {
                    tArr3[i7] = t7;
                    i7++;
                }
            }
        } else {
            int i8 = 0;
            for (T t8 : tArr) {
                if (!d(tArr2, t8)) {
                    tArr3[i8] = t8;
                    i8++;
                }
            }
            i7 = i8;
        }
        if (tArr3 == null) {
            return null;
        }
        return i7 == tArr3.length ? tArr3 : (T[]) Arrays.copyOf(tArr3, i7);
    }

    @c1.a
    @m0
    public static <T> ArrayList<T> g(@m0 T[] tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t7 : tArr) {
            arrayList.add(t7);
        }
        return arrayList;
    }

    @c1.a
    @m0
    public static int[] h(@m0 Collection<Integer> collection) {
        int i7 = 0;
        if (collection == null || collection.size() == 0) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            iArr[i7] = it.next().intValue();
            i7++;
        }
        return iArr;
    }

    @o0
    @c1.a
    public static Integer[] i(@m0 int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i7 = 0; i7 < length; i7++) {
            numArr[i7] = Integer.valueOf(iArr[i7]);
        }
        return numArr;
    }

    @c1.a
    public static void j(@m0 StringBuilder sb, @m0 double[] dArr) {
        int length = dArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (i7 != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(dArr[i7]));
        }
    }

    @c1.a
    public static void k(@m0 StringBuilder sb, @m0 float[] fArr) {
        int length = fArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (i7 != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(fArr[i7]));
        }
    }

    @c1.a
    public static void l(@m0 StringBuilder sb, @m0 int[] iArr) {
        int length = iArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (i7 != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(iArr[i7]));
        }
    }

    @c1.a
    public static void m(@m0 StringBuilder sb, @m0 long[] jArr) {
        int length = jArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (i7 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(jArr[i7]));
        }
    }

    @c1.a
    public static <T> void n(@m0 StringBuilder sb, @m0 T[] tArr) {
        int length = tArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (i7 != 0) {
                sb.append(",");
            }
            sb.append(tArr[i7]);
        }
    }

    @c1.a
    public static void o(@m0 StringBuilder sb, @m0 boolean[] zArr) {
        int length = zArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (i7 != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(zArr[i7]));
        }
    }

    @c1.a
    public static void p(@m0 StringBuilder sb, @m0 String[] strArr) {
        int length = strArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (i7 != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i7]);
            sb.append("\"");
        }
    }
}
