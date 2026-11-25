package i4;

import android.os.ParcelUuid;
import android.util.ArrayMap;
import android.util.SparseArray;
import c.o0;
import d4.c;
import h4.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f34187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    public final List<ParcelUuid> f34188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<byte[]> f34189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<ParcelUuid, byte[]> f34190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f34191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f34192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f34193g;

    public b(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i7, int i8, String str, byte[] bArr) {
        this.f34188b = list;
        this.f34189c = sparseArray;
        this.f34190d = map;
        this.f34192f = str;
        this.f34187a = i7;
        this.f34191e = i8;
        this.f34193g = bArr;
    }

    public static int a(byte[] bArr, int i7, int i8, int i9, List<ParcelUuid> list) {
        while (i8 > 0) {
            list.add(c.z(b(bArr, i7, i9)));
            i8 -= i9;
            i7 += i9;
        }
        return i7;
    }

    public static byte[] b(byte[] bArr, int i7, int i8) {
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, i7, bArr2, 0, i8);
        return bArr2;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    /* JADX WARN: Code duplicated, block: B:28:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0081  */
    /* JADX WARN: Code duplicated, block: B:30:0x0082  */
    /* JADX WARN: Code duplicated, block: B:35:0x009f  */
    public static b l(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        ArrayMap arrayMap = new ArrayMap();
        int i7 = 0;
        int i8 = -1;
        byte b8 = -2147483648;
        String str = null;
        while (i7 < bArr.length) {
            try {
                int i9 = i7 + 1;
                int i10 = bArr[i7] & 255;
                if (i10 == 0) {
                    if (arrayList.isEmpty()) {
                        arrayList = null;
                    }
                    return new b(arrayList, sparseArray, arrayMap, i8, b8, str, bArr);
                }
                int i11 = i10 - 1;
                int i12 = i9 + 1;
                int i13 = bArr[i9] & 255;
                int i14 = 16;
                if (i13 == 22) {
                    if (i13 == 32) {
                        i14 = 4;
                    } else if (i13 == 33) {
                        i14 = 2;
                    }
                    arrayMap.put(c.z(b(bArr, i12, i14)), b(bArr, i12 + i14, i11 - i14));
                } else if (i13 == 255) {
                    sparseArray.put(((bArr[i12 + 1] & 255) << 8) + (bArr[i12] & 255), b(bArr, i12 + 2, i11 - 2));
                } else if (i13 != 32 && i13 != 33) {
                    switch (i13) {
                        case 1:
                            i8 = bArr[i12] & 255;
                            break;
                        case 2:
                        case 3:
                            a(bArr, i12, i11, 2, arrayList);
                            break;
                        case 4:
                        case 5:
                            a(bArr, i12, i11, 4, arrayList);
                            break;
                        case 6:
                        case 7:
                            a(bArr, i12, i11, 16, arrayList);
                            break;
                        case 8:
                        case 9:
                            str = new String(b(bArr, i12, i11));
                            break;
                        case 10:
                            b8 = bArr[i12];
                            break;
                    }
                } else {
                    if (i13 == 32) {
                        i14 = 4;
                    } else if (i13 == 33) {
                        i14 = 2;
                    }
                    arrayMap.put(c.z(b(bArr, i12, i14)), b(bArr, i12 + i14, i11 - i14));
                }
                i7 = i11 + i12;
            } catch (Exception unused) {
                k4.b.h("unable to parse scan record: " + Arrays.toString(bArr));
                return new b(null, null, null, -1, Integer.MIN_VALUE, null, bArr);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new b(arrayList, sparseArray, arrayMap, i8, b8, str, bArr);
    }

    public int c() {
        return this.f34187a;
    }

    public byte[] d() {
        return this.f34193g;
    }

    @o0
    public String e() {
        return this.f34192f;
    }

    public SparseArray<byte[]> f() {
        return this.f34189c;
    }

    @o0
    public byte[] g(int i7) {
        SparseArray<byte[]> sparseArray = this.f34189c;
        if (sparseArray != null) {
            return sparseArray.get(i7);
        }
        return null;
    }

    public Map<ParcelUuid, byte[]> h() {
        return this.f34190d;
    }

    @o0
    public byte[] i(ParcelUuid parcelUuid) {
        if (parcelUuid == null) {
            return null;
        }
        return this.f34190d.get(parcelUuid);
    }

    public List<ParcelUuid> j() {
        return this.f34188b;
    }

    public int k() {
        return this.f34191e;
    }

    public String toString() {
        return "ScanRecord [mAdvertiseFlags=" + this.f34187a + ", mServiceUuids=" + this.f34188b + "\n, mManufacturerSpecificData=" + i.d(this.f34189c) + ", mServiceData=" + i.e(this.f34190d) + ", mTxPowerLevel=" + this.f34191e + ", mDeviceName=" + this.f34192f + "]";
    }
}
