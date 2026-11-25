package e1;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import c.m0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private b() {
    }

    public static void A(@m0 Parcel parcel, int i7, @m0 SparseArray<Float> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(sparseArray.keyAt(i8));
            parcel.writeFloat(sparseArray.valueAt(i8).floatValue());
        }
        g0(parcel, iF0);
    }

    public static void B(@m0 Parcel parcel, int i7, @m0 IBinder iBinder, boolean z7) {
        if (iBinder == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeStrongBinder(iBinder);
            g0(parcel, iF0);
        }
    }

    public static void C(@m0 Parcel parcel, int i7, @m0 IBinder[] iBinderArr, boolean z7) {
        if (iBinderArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeBinderArray(iBinderArr);
            g0(parcel, iF0);
        }
    }

    public static void D(@m0 Parcel parcel, int i7, @m0 List<IBinder> list, boolean z7) {
        if (list == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeBinderList(list);
            g0(parcel, iF0);
        }
    }

    public static void E(@m0 Parcel parcel, int i7, @m0 SparseArray<IBinder> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(sparseArray.keyAt(i8));
            parcel.writeStrongBinder(sparseArray.valueAt(i8));
        }
        g0(parcel, iF0);
    }

    public static void F(@m0 Parcel parcel, int i7, int i8) {
        h0(parcel, i7, 4);
        parcel.writeInt(i8);
    }

    public static void G(@m0 Parcel parcel, int i7, @m0 int[] iArr, boolean z7) {
        if (iArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeIntArray(iArr);
            g0(parcel, iF0);
        }
    }

    public static void H(@m0 Parcel parcel, int i7, @m0 List<Integer> list, boolean z7) {
        if (list == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = list.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(list.get(i8).intValue());
        }
        g0(parcel, iF0);
    }

    public static void I(@m0 Parcel parcel, int i7, @m0 Integer num, boolean z7) {
        if (num != null) {
            h0(parcel, i7, 4);
            parcel.writeInt(num.intValue());
        } else if (z7) {
            h0(parcel, i7, 0);
        }
    }

    public static void J(@m0 Parcel parcel, int i7, @m0 List list, boolean z7) {
        if (list == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeList(list);
            g0(parcel, iF0);
        }
    }

    public static void K(@m0 Parcel parcel, int i7, long j7) {
        h0(parcel, i7, 8);
        parcel.writeLong(j7);
    }

    public static void L(@m0 Parcel parcel, int i7, @m0 long[] jArr, boolean z7) {
        if (jArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeLongArray(jArr);
            g0(parcel, iF0);
        }
    }

    public static void M(@m0 Parcel parcel, int i7, @m0 List<Long> list, boolean z7) {
        if (list == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = list.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeLong(list.get(i8).longValue());
        }
        g0(parcel, iF0);
    }

    public static void N(@m0 Parcel parcel, int i7, @m0 Long l7, boolean z7) {
        if (l7 != null) {
            h0(parcel, i7, 8);
            parcel.writeLong(l7.longValue());
        } else if (z7) {
            h0(parcel, i7, 0);
        }
    }

    public static void O(@m0 Parcel parcel, int i7, @m0 Parcel parcel2, boolean z7) {
        if (parcel2 == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            g0(parcel, iF0);
        }
    }

    public static void P(@m0 Parcel parcel, int i7, @m0 Parcel[] parcelArr, boolean z7) {
        if (parcelArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        parcel.writeInt(parcelArr.length);
        for (Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        g0(parcel, iF0);
    }

    public static void Q(@m0 Parcel parcel, int i7, @m0 List<Parcel> list, boolean z7) {
        if (list == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = list.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            Parcel parcel2 = list.get(i8);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        g0(parcel, iF0);
    }

    public static void R(@m0 Parcel parcel, int i7, @m0 SparseArray<Parcel> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(sparseArray.keyAt(i8));
            Parcel parcelValueAt = sparseArray.valueAt(i8);
            if (parcelValueAt != null) {
                parcel.writeInt(parcelValueAt.dataSize());
                parcel.appendFrom(parcelValueAt, 0, parcelValueAt.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        g0(parcel, iF0);
    }

    public static void S(@m0 Parcel parcel, int i7, @m0 Parcelable parcelable, int i8, boolean z7) {
        if (parcelable == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcelable.writeToParcel(parcel, i8);
            g0(parcel, iF0);
        }
    }

    public static void T(@m0 Parcel parcel, int i7, @m0 PendingIntent pendingIntent, boolean z7) {
        if (pendingIntent == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            g0(parcel, iF0);
        }
    }

    public static void U(@m0 Parcel parcel, int i7, short s7) {
        h0(parcel, i7, 4);
        parcel.writeInt(s7);
    }

    public static void V(@m0 Parcel parcel, int i7, @m0 SparseBooleanArray sparseBooleanArray, boolean z7) {
        if (sparseBooleanArray == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            g0(parcel, iF0);
        }
    }

    public static void W(@m0 Parcel parcel, int i7, @m0 SparseIntArray sparseIntArray, boolean z7) {
        if (sparseIntArray == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(sparseIntArray.keyAt(i8));
            parcel.writeInt(sparseIntArray.valueAt(i8));
        }
        g0(parcel, iF0);
    }

    public static void X(@m0 Parcel parcel, int i7, @m0 SparseLongArray sparseLongArray, boolean z7) {
        if (sparseLongArray == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(sparseLongArray.keyAt(i8));
            parcel.writeLong(sparseLongArray.valueAt(i8));
        }
        g0(parcel, iF0);
    }

    public static void Y(@m0 Parcel parcel, int i7, @m0 String str, boolean z7) {
        if (str == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeString(str);
            g0(parcel, iF0);
        }
    }

    public static void Z(@m0 Parcel parcel, int i7, @m0 String[] strArr, boolean z7) {
        if (strArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeStringArray(strArr);
            g0(parcel, iF0);
        }
    }

    public static int a(@m0 Parcel parcel) {
        return f0(parcel, 20293);
    }

    public static void a0(@m0 Parcel parcel, int i7, @m0 List<String> list, boolean z7) {
        if (list == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeStringList(list);
            g0(parcel, iF0);
        }
    }

    public static void b(@m0 Parcel parcel, int i7) {
        g0(parcel, i7);
    }

    public static void b0(@m0 Parcel parcel, int i7, @m0 SparseArray<String> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(sparseArray.keyAt(i8));
            parcel.writeString(sparseArray.valueAt(i8));
        }
        g0(parcel, iF0);
    }

    public static void c(@m0 Parcel parcel, int i7, @m0 BigDecimal bigDecimal, boolean z7) {
        if (bigDecimal == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            g0(parcel, iF0);
        }
    }

    public static <T extends Parcelable> void c0(@m0 Parcel parcel, int i7, @m0 T[] tArr, int i8, boolean z7) {
        if (tArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        parcel.writeInt(tArr.length);
        for (T t7 : tArr) {
            if (t7 == null) {
                parcel.writeInt(0);
            } else {
                i0(parcel, t7, i8);
            }
        }
        g0(parcel, iF0);
    }

    public static void d(@m0 Parcel parcel, int i7, @m0 BigDecimal[] bigDecimalArr, boolean z7) {
        if (bigDecimalArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i8 = 0; i8 < length; i8++) {
            parcel.writeByteArray(bigDecimalArr[i8].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i8].scale());
        }
        g0(parcel, iF0);
    }

    public static <T extends Parcelable> void d0(@m0 Parcel parcel, int i7, @m0 List<T> list, boolean z7) {
        if (list == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = list.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            T t7 = list.get(i8);
            if (t7 == null) {
                parcel.writeInt(0);
            } else {
                i0(parcel, t7, 0);
            }
        }
        g0(parcel, iF0);
    }

    public static void e(@m0 Parcel parcel, int i7, @m0 BigInteger bigInteger, boolean z7) {
        if (bigInteger == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeByteArray(bigInteger.toByteArray());
            g0(parcel, iF0);
        }
    }

    public static <T extends Parcelable> void e0(@m0 Parcel parcel, int i7, @m0 SparseArray<T> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(sparseArray.keyAt(i8));
            T tValueAt = sparseArray.valueAt(i8);
            if (tValueAt == null) {
                parcel.writeInt(0);
            } else {
                i0(parcel, tValueAt, 0);
            }
        }
        g0(parcel, iF0);
    }

    public static void f(@m0 Parcel parcel, int i7, @m0 BigInteger[] bigIntegerArr, boolean z7) {
        if (bigIntegerArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        g0(parcel, iF0);
    }

    private static int f0(Parcel parcel, int i7) {
        parcel.writeInt(i7 | k.a.f34390c);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void g(@m0 Parcel parcel, int i7, boolean z7) {
        h0(parcel, i7, 4);
        parcel.writeInt(z7 ? 1 : 0);
    }

    private static void g0(Parcel parcel, int i7) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i7 - 4);
        parcel.writeInt(iDataPosition - i7);
        parcel.setDataPosition(iDataPosition);
    }

    public static void h(@m0 Parcel parcel, int i7, @m0 boolean[] zArr, boolean z7) {
        if (zArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeBooleanArray(zArr);
            g0(parcel, iF0);
        }
    }

    private static void h0(Parcel parcel, int i7, int i8) {
        parcel.writeInt(i7 | (i8 << 16));
    }

    public static void i(@m0 Parcel parcel, int i7, @m0 List<Boolean> list, boolean z7) {
        if (list == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = list.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(list.get(i8).booleanValue() ? 1 : 0);
        }
        g0(parcel, iF0);
    }

    private static <T extends Parcelable> void i0(Parcel parcel, T t7, int i7) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        t7.writeToParcel(parcel, i7);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }

    public static void j(@m0 Parcel parcel, int i7, @m0 Boolean bool, boolean z7) {
        if (bool != null) {
            h0(parcel, i7, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z7) {
            h0(parcel, i7, 0);
        }
    }

    public static void k(@m0 Parcel parcel, int i7, @m0 Bundle bundle, boolean z7) {
        if (bundle == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeBundle(bundle);
            g0(parcel, iF0);
        }
    }

    public static void l(@m0 Parcel parcel, int i7, byte b8) {
        h0(parcel, i7, 4);
        parcel.writeInt(b8);
    }

    public static void m(@m0 Parcel parcel, int i7, @m0 byte[] bArr, boolean z7) {
        if (bArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeByteArray(bArr);
            g0(parcel, iF0);
        }
    }

    public static void n(@m0 Parcel parcel, int i7, @m0 byte[][] bArr, boolean z7) {
        if (bArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        g0(parcel, iF0);
    }

    public static void o(@m0 Parcel parcel, int i7, @m0 SparseArray<byte[]> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(sparseArray.keyAt(i8));
            parcel.writeByteArray(sparseArray.valueAt(i8));
        }
        g0(parcel, iF0);
    }

    public static void p(@m0 Parcel parcel, int i7, char c8) {
        h0(parcel, i7, 4);
        parcel.writeInt(c8);
    }

    public static void q(@m0 Parcel parcel, int i7, @m0 char[] cArr, boolean z7) {
        if (cArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeCharArray(cArr);
            g0(parcel, iF0);
        }
    }

    public static void r(@m0 Parcel parcel, int i7, double d8) {
        h0(parcel, i7, 8);
        parcel.writeDouble(d8);
    }

    public static void s(@m0 Parcel parcel, int i7, @m0 double[] dArr, boolean z7) {
        if (dArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeDoubleArray(dArr);
            g0(parcel, iF0);
        }
    }

    public static void t(@m0 Parcel parcel, int i7, @m0 List<Double> list, boolean z7) {
        if (list == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = list.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeDouble(list.get(i8).doubleValue());
        }
        g0(parcel, iF0);
    }

    public static void u(@m0 Parcel parcel, int i7, @m0 Double d8, boolean z7) {
        if (d8 != null) {
            h0(parcel, i7, 8);
            parcel.writeDouble(d8.doubleValue());
        } else if (z7) {
            h0(parcel, i7, 0);
        }
    }

    public static void v(@m0 Parcel parcel, int i7, @m0 SparseArray<Double> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeInt(sparseArray.keyAt(i8));
            parcel.writeDouble(sparseArray.valueAt(i8).doubleValue());
        }
        g0(parcel, iF0);
    }

    public static void w(@m0 Parcel parcel, int i7, float f8) {
        h0(parcel, i7, 4);
        parcel.writeFloat(f8);
    }

    public static void x(@m0 Parcel parcel, int i7, @m0 float[] fArr, boolean z7) {
        if (fArr == null) {
            if (z7) {
                h0(parcel, i7, 0);
            }
        } else {
            int iF0 = f0(parcel, i7);
            parcel.writeFloatArray(fArr);
            g0(parcel, iF0);
        }
    }

    public static void y(@m0 Parcel parcel, int i7, @m0 List<Float> list, boolean z7) {
        if (list == null) {
            if (z7) {
                h0(parcel, i7, 0);
                return;
            }
            return;
        }
        int iF0 = f0(parcel, i7);
        int size = list.size();
        parcel.writeInt(size);
        for (int i8 = 0; i8 < size; i8++) {
            parcel.writeFloat(list.get(i8).floatValue());
        }
        g0(parcel, iF0);
    }

    public static void z(@m0 Parcel parcel, int i7, @m0 Float f8, boolean z7) {
        if (f8 != null) {
            h0(parcel, i7, 4);
            parcel.writeFloat(f8.floatValue());
        } else if (z7) {
            h0(parcel, i7, 0);
        }
    }
}
