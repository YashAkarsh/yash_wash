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
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e1.a$a, reason: collision with other inner class name */
    public static class C0405a extends RuntimeException {
        public C0405a(@m0 String str, @m0 Parcel parcel) {
            int iDataPosition = parcel.dataPosition();
            int iDataSize = parcel.dataSize();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41);
            sb.append(str);
            sb.append(" Parcel: pos=");
            sb.append(iDataPosition);
            sb.append(" size=");
            sb.append(iDataSize);
            super(sb.toString());
        }
    }

    private a() {
    }

    @m0
    public static ArrayList<Parcel> A(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        ArrayList<Parcel> arrayList = new ArrayList<>();
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = parcel.readInt();
            if (i10 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i10);
                arrayList.add(parcelObtain);
                parcel.setDataPosition(iDataPosition2 + i10);
            } else {
                arrayList.add(null);
            }
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return arrayList;
    }

    @m0
    public static SparseArray<Parcel> B(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        SparseArray<Parcel> sparseArray = new SparseArray<>();
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            if (i11 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i11);
                sparseArray.append(i10, parcelObtain);
                parcel.setDataPosition(iDataPosition2 + i11);
            } else {
                sparseArray.append(i10, null);
            }
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return sparseArray;
    }

    @m0
    public static <T extends Parcelable> T C(@m0 Parcel parcel, int i7, @m0 Parcelable.Creator<T> creator) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iG0);
        return tCreateFromParcel;
    }

    @m0
    public static SparseBooleanArray D(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray = parcel.readSparseBooleanArray();
        parcel.setDataPosition(iDataPosition + iG0);
        return sparseBooleanArray;
    }

    @m0
    public static SparseIntArray E(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        SparseIntArray sparseIntArray = new SparseIntArray();
        int i8 = parcel.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            sparseIntArray.append(parcel.readInt(), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return sparseIntArray;
    }

    @m0
    public static SparseLongArray F(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        SparseLongArray sparseLongArray = new SparseLongArray();
        int i8 = parcel.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            sparseLongArray.append(parcel.readInt(), parcel.readLong());
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return sparseLongArray;
    }

    @m0
    public static String G(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iG0);
        return string;
    }

    @m0
    public static String[] H(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iG0);
        return strArrCreateStringArray;
    }

    @m0
    public static ArrayList<String> I(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iG0);
        return arrayListCreateStringArrayList;
    }

    @m0
    public static SparseArray<String> J(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>();
        int i8 = parcel.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            sparseArray.append(parcel.readInt(), parcel.readString());
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return sparseArray;
    }

    @m0
    public static <T> T[] K(@m0 Parcel parcel, int i7, @m0 Parcelable.Creator<T> creator) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iG0);
        return tArr;
    }

    @m0
    public static <T> ArrayList<T> L(@m0 Parcel parcel, int i7, @m0 Parcelable.Creator<T> creator) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iG0);
        return arrayListCreateTypedArrayList;
    }

    @m0
    public static <T> SparseArray<T> M(@m0 Parcel parcel, int i7, @m0 Parcelable.Creator<T> creator) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        SparseArray<T> sparseArray = new SparseArray<>();
        for (int i9 = 0; i9 < i8; i9++) {
            sparseArray.append(parcel.readInt(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null);
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return sparseArray;
    }

    public static void N(@m0 Parcel parcel, int i7) {
        if (parcel.dataPosition() == i7) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i7);
        throw new C0405a(sb.toString(), parcel);
    }

    public static int O(int i7) {
        return (char) i7;
    }

    public static boolean P(@m0 Parcel parcel, int i7) {
        k0(parcel, i7, 4);
        return parcel.readInt() != 0;
    }

    @m0
    public static Boolean Q(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        if (iG0 == 0) {
            return null;
        }
        j0(parcel, i7, iG0, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte R(@m0 Parcel parcel, int i7) {
        k0(parcel, i7, 4);
        return (byte) parcel.readInt();
    }

    public static char S(@m0 Parcel parcel, int i7) {
        k0(parcel, i7, 4);
        return (char) parcel.readInt();
    }

    public static double T(@m0 Parcel parcel, int i7) {
        k0(parcel, i7, 8);
        return parcel.readDouble();
    }

    @m0
    public static Double U(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        if (iG0 == 0) {
            return null;
        }
        j0(parcel, i7, iG0, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float V(@m0 Parcel parcel, int i7) {
        k0(parcel, i7, 4);
        return parcel.readFloat();
    }

    @m0
    public static Float W(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        if (iG0 == 0) {
            return null;
        }
        j0(parcel, i7, iG0, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int X(@m0 Parcel parcel) {
        return parcel.readInt();
    }

    @m0
    public static IBinder Y(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iG0);
        return strongBinder;
    }

    public static int Z(@m0 Parcel parcel, int i7) {
        k0(parcel, i7, 4);
        return parcel.readInt();
    }

    @m0
    public static BigDecimal a(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i8 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iG0);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i8);
    }

    @m0
    public static Integer a0(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        if (iG0 == 0) {
            return null;
        }
        j0(parcel, i7, iG0, 4);
        return Integer.valueOf(parcel.readInt());
    }

    @m0
    public static BigDecimal[] b(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i9] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return bigDecimalArr;
    }

    public static void b0(@m0 Parcel parcel, int i7, @m0 List list, @m0 ClassLoader classLoader) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return;
        }
        parcel.readList(list, classLoader);
        parcel.setDataPosition(iDataPosition + iG0);
    }

    @m0
    public static BigInteger c(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iG0);
        return new BigInteger(bArrCreateByteArray);
    }

    public static long c0(@m0 Parcel parcel, int i7) {
        k0(parcel, i7, 8);
        return parcel.readLong();
    }

    @m0
    public static BigInteger[] d(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            bigIntegerArr[i9] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return bigIntegerArr;
    }

    @m0
    public static Long d0(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        if (iG0 == 0) {
            return null;
        }
        j0(parcel, i7, iG0, 8);
        return Long.valueOf(parcel.readLong());
    }

    @m0
    public static boolean[] e(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iDataPosition + iG0);
        return zArrCreateBooleanArray;
    }

    @m0
    public static PendingIntent e0(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        PendingIntent pendingIntentOrNullFromParcel = PendingIntent.readPendingIntentOrNullFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iG0);
        return pendingIntentOrNullFromParcel;
    }

    @m0
    public static ArrayList<Boolean> f(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        ArrayList<Boolean> arrayList = new ArrayList<>();
        int i8 = parcel.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            arrayList.add(Boolean.valueOf(parcel.readInt() != 0));
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return arrayList;
    }

    public static short f0(@m0 Parcel parcel, int i7) {
        k0(parcel, i7, 4);
        return (short) parcel.readInt();
    }

    @m0
    public static Bundle g(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iG0);
        return bundle;
    }

    public static int g0(@m0 Parcel parcel, int i7) {
        return (i7 & k.a.f34390c) != -65536 ? (char) (i7 >> 16) : parcel.readInt();
    }

    @m0
    public static byte[] h(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iG0);
        return bArrCreateByteArray;
    }

    public static void h0(@m0 Parcel parcel, int i7) {
        parcel.setDataPosition(parcel.dataPosition() + g0(parcel, i7));
    }

    @m0
    public static byte[][] i(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        byte[][] bArr = new byte[i8][];
        for (int i9 = 0; i9 < i8; i9++) {
            bArr[i9] = parcel.createByteArray();
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return bArr;
    }

    public static int i0(@m0 Parcel parcel) {
        int iX = X(parcel);
        int iG0 = g0(parcel, iX);
        int iDataPosition = parcel.dataPosition();
        if (O(iX) != 20293) {
            String strValueOf = String.valueOf(Integer.toHexString(iX));
            throw new C0405a(strValueOf.length() != 0 ? "Expected object header. Got 0x".concat(strValueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i7 = iG0 + iDataPosition;
        if (i7 >= iDataPosition && i7 <= parcel.dataSize()) {
            return i7;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(iDataPosition);
        sb.append(" end=");
        sb.append(i7);
        throw new C0405a(sb.toString(), parcel);
    }

    @m0
    public static SparseArray<byte[]> j(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        SparseArray<byte[]> sparseArray = new SparseArray<>(i8);
        for (int i9 = 0; i9 < i8; i9++) {
            sparseArray.append(parcel.readInt(), parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return sparseArray;
    }

    private static void j0(Parcel parcel, int i7, int i8, int i9) {
        if (i8 == i9) {
            return;
        }
        String hexString = Integer.toHexString(i8);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i9);
        sb.append(" got ");
        sb.append(i8);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new C0405a(sb.toString(), parcel);
    }

    @m0
    public static char[] k(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        char[] cArrCreateCharArray = parcel.createCharArray();
        parcel.setDataPosition(iDataPosition + iG0);
        return cArrCreateCharArray;
    }

    private static void k0(Parcel parcel, int i7, int i8) {
        int iG0 = g0(parcel, i7);
        if (iG0 == i8) {
            return;
        }
        String hexString = Integer.toHexString(iG0);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i8);
        sb.append(" got ");
        sb.append(iG0);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new C0405a(sb.toString(), parcel);
    }

    @m0
    public static double[] l(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        double[] dArrCreateDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(iDataPosition + iG0);
        return dArrCreateDoubleArray;
    }

    @m0
    public static ArrayList<Double> m(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        ArrayList<Double> arrayList = new ArrayList<>();
        int i8 = parcel.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            arrayList.add(Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return arrayList;
    }

    @m0
    public static SparseArray<Double> n(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        SparseArray<Double> sparseArray = new SparseArray<>();
        int i8 = parcel.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            sparseArray.append(parcel.readInt(), Double.valueOf(parcel.readDouble()));
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return sparseArray;
    }

    @m0
    public static float[] o(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iDataPosition + iG0);
        return fArrCreateFloatArray;
    }

    @m0
    public static ArrayList<Float> p(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        ArrayList<Float> arrayList = new ArrayList<>();
        int i8 = parcel.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            arrayList.add(Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return arrayList;
    }

    @m0
    public static SparseArray<Float> q(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        SparseArray<Float> sparseArray = new SparseArray<>();
        int i8 = parcel.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            sparseArray.append(parcel.readInt(), Float.valueOf(parcel.readFloat()));
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return sparseArray;
    }

    @m0
    public static IBinder[] r(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        IBinder[] iBinderArrCreateBinderArray = parcel.createBinderArray();
        parcel.setDataPosition(iDataPosition + iG0);
        return iBinderArrCreateBinderArray;
    }

    @m0
    public static ArrayList<IBinder> s(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        ArrayList<IBinder> arrayListCreateBinderArrayList = parcel.createBinderArrayList();
        parcel.setDataPosition(iDataPosition + iG0);
        return arrayListCreateBinderArrayList;
    }

    @m0
    public static SparseArray<IBinder> t(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        SparseArray<IBinder> sparseArray = new SparseArray<>(i8);
        for (int i9 = 0; i9 < i8; i9++) {
            sparseArray.append(parcel.readInt(), parcel.readStrongBinder());
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return sparseArray;
    }

    @m0
    public static int[] u(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iG0);
        return iArrCreateIntArray;
    }

    @m0
    public static ArrayList<Integer> v(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i8 = parcel.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return arrayList;
    }

    @m0
    public static long[] w(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iDataPosition + iG0);
        return jArrCreateLongArray;
    }

    @m0
    public static ArrayList<Long> x(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        int i8 = parcel.readInt();
        for (int i9 = 0; i9 < i8; i9++) {
            arrayList.add(Long.valueOf(parcel.readLong()));
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return arrayList;
    }

    @m0
    public static Parcel y(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, iG0);
        parcel.setDataPosition(iDataPosition + iG0);
        return parcelObtain;
    }

    @m0
    public static Parcel[] z(@m0 Parcel parcel, int i7) {
        int iG0 = g0(parcel, i7);
        int iDataPosition = parcel.dataPosition();
        if (iG0 == 0) {
            return null;
        }
        int i8 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = parcel.readInt();
            if (i10 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i10);
                parcelArr[i9] = parcelObtain;
                parcel.setDataPosition(iDataPosition2 + i10);
            } else {
                parcelArr[i9] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + iG0);
        return parcelArr;
    }
}
