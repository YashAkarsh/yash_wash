package com.realsil.sdk.core.bluetooth.scanner.compat;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import c.o0;
import c.t0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class CompatScanFilter implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    public final String f33224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    public final String f33225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    public final ParcelUuid f33226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    public final ParcelUuid f33227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    public final ParcelUuid f33228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    public final byte[] f33229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    public final byte[] f33230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f33231h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    public final byte[] f33232i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    public final byte[] f33233j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CompatScanFilter f33223k = new b().a();
    public static final Parcelable.Creator<CompatScanFilter> CREATOR = new a();

    public static class a implements Parcelable.Creator<CompatScanFilter> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CompatScanFilter createFromParcel(Parcel parcel) {
            b bVar = new b();
            if (parcel.readInt() == 1) {
                bVar.c(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                bVar.b(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                bVar.h(parcelUuid);
                if (parcel.readInt() == 1) {
                    bVar.i(parcelUuid, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (parcel.readInt() == 1) {
                    byte[] bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    if (parcel.readInt() == 0) {
                        bVar.f(parcelUuid2, bArr);
                    } else {
                        byte[] bArr2 = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr2);
                        bVar.g(parcelUuid2, bArr, bArr2);
                    }
                }
            }
            int i7 = parcel.readInt();
            if (parcel.readInt() == 1) {
                byte[] bArr3 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr3);
                if (parcel.readInt() == 0) {
                    bVar.d(i7, bArr3);
                } else {
                    byte[] bArr4 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr4);
                    bVar.e(i7, bArr3, bArr4);
                }
            }
            return bVar.a();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompatScanFilter[] newArray(int i7) {
            return new CompatScanFilter[i7];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f33235b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ParcelUuid f33236c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ParcelUuid f33237d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ParcelUuid f33238e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte[] f33239f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f33240g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f33241h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f33242i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte[] f33243j;

        public CompatScanFilter a() {
            return new CompatScanFilter(this.f33234a, this.f33235b, this.f33236c, this.f33237d, this.f33238e, this.f33239f, this.f33240g, this.f33241h, this.f33242i, this.f33243j, null);
        }

        public b b(String str) {
            if (str == null || BluetoothAdapter.checkBluetoothAddress(str)) {
                this.f33235b = str;
                return this;
            }
            throw new IllegalArgumentException("invalid device address " + str);
        }

        public b c(String str) {
            this.f33234a = str;
            return this;
        }

        public b d(int i7, byte[] bArr) {
            if (bArr != null && i7 < 0) {
                throw new IllegalArgumentException("invalid manufacture id");
            }
            this.f33241h = i7;
            this.f33242i = bArr;
            this.f33243j = null;
            return this;
        }

        public b e(int i7, byte[] bArr, byte[] bArr2) {
            if (bArr != null && i7 < 0) {
                throw new IllegalArgumentException("invalid manufacture id");
            }
            byte[] bArr3 = this.f33243j;
            if (bArr3 != null) {
                byte[] bArr4 = this.f33242i;
                if (bArr4 == null) {
                    throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                }
                if (bArr4.length != bArr3.length) {
                    throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                }
            }
            this.f33241h = i7;
            this.f33242i = bArr;
            this.f33243j = bArr2;
            return this;
        }

        public b f(ParcelUuid parcelUuid, byte[] bArr) {
            if (parcelUuid == null) {
                throw new IllegalArgumentException("serviceDataUuid is null");
            }
            this.f33238e = parcelUuid;
            this.f33239f = bArr;
            this.f33240g = null;
            return this;
        }

        public b g(ParcelUuid parcelUuid, byte[] bArr, byte[] bArr2) {
            if (parcelUuid == null) {
                throw new IllegalArgumentException("serviceDataUuid is null");
            }
            byte[] bArr3 = this.f33240g;
            if (bArr3 != null) {
                byte[] bArr4 = this.f33239f;
                if (bArr4 == null) {
                    throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                }
                if (bArr4.length != bArr3.length) {
                    throw new IllegalArgumentException("size mismatch for service data and service data mask");
                }
            }
            this.f33238e = parcelUuid;
            this.f33239f = bArr;
            this.f33240g = bArr2;
            return this;
        }

        public b h(ParcelUuid parcelUuid) {
            this.f33236c = parcelUuid;
            this.f33237d = null;
            return this;
        }

        public b i(ParcelUuid parcelUuid, ParcelUuid parcelUuid2) {
            if (this.f33237d != null && this.f33236c == null) {
                throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
            }
            this.f33236c = parcelUuid;
            this.f33237d = parcelUuid2;
            return this;
        }
    }

    public /* synthetic */ CompatScanFilter(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i7, byte[] bArr3, byte[] bArr4, a aVar) {
        this(str, str2, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i7, bArr3, bArr4);
    }

    public static boolean a(UUID uuid, UUID uuid2, UUID uuid3) {
        return i4.a.m(uuid3, uuid, uuid2);
    }

    public static boolean p(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 == null || bArr3.length < bArr.length) {
            return false;
        }
        if (bArr2 == null) {
            for (int i7 = 0; i7 < bArr.length; i7++) {
                if (bArr3[i7] != bArr[i7]) {
                    return false;
                }
            }
            return true;
        }
        for (int i8 = 0; i8 < bArr.length; i8++) {
            byte b8 = bArr2[i8];
            if ((bArr3[i8] & b8) != (b8 & bArr[i8])) {
                return false;
            }
        }
        return true;
    }

    public static boolean s(ParcelUuid parcelUuid, ParcelUuid parcelUuid2, List<ParcelUuid> list) {
        if (parcelUuid == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        Iterator<ParcelUuid> it = list.iterator();
        while (it.hasNext()) {
            if (a(parcelUuid.getUuid(), parcelUuid2 == null ? null : parcelUuid2.getUuid(), it.next().getUuid())) {
                return true;
            }
        }
        return false;
    }

    @o0
    public String b() {
        return this.f33225b;
    }

    @o0
    public String d() {
        return this.f33224a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @o0
    public byte[] e() {
        return this.f33232i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CompatScanFilter.class != obj.getClass()) {
            return false;
        }
        CompatScanFilter compatScanFilter = (CompatScanFilter) obj;
        return Objects.equals(this.f33224a, compatScanFilter.f33224a) && Objects.equals(this.f33225b, compatScanFilter.f33225b) && this.f33231h == compatScanFilter.f33231h && Objects.deepEquals(this.f33232i, compatScanFilter.f33232i) && Objects.deepEquals(this.f33233j, compatScanFilter.f33233j) && Objects.equals(this.f33228e, compatScanFilter.f33228e) && Objects.deepEquals(this.f33229f, compatScanFilter.f33229f) && Objects.deepEquals(this.f33230g, compatScanFilter.f33230g) && Objects.equals(this.f33226c, compatScanFilter.f33226c) && Objects.equals(this.f33227d, compatScanFilter.f33227d);
    }

    @o0
    public byte[] f() {
        return this.f33233j;
    }

    public int g() {
        return this.f33231h;
    }

    @o0
    public byte[] h() {
        return this.f33229f;
    }

    public int hashCode() {
        return Objects.hash(this.f33224a, this.f33225b, Integer.valueOf(this.f33231h), Integer.valueOf(Arrays.hashCode(this.f33232i)), Integer.valueOf(Arrays.hashCode(this.f33233j)), this.f33228e, Integer.valueOf(Arrays.hashCode(this.f33229f)), Integer.valueOf(Arrays.hashCode(this.f33230g)), this.f33226c, this.f33227d);
    }

    @o0
    public byte[] i() {
        return this.f33230g;
    }

    @o0
    public ParcelUuid j() {
        return this.f33228e;
    }

    @o0
    public ParcelUuid k() {
        return this.f33226c;
    }

    @o0
    public ParcelUuid l() {
        return this.f33227d;
    }

    public boolean n() {
        return f33223k.equals(this);
    }

    @t0(api = 21)
    public boolean o(ScanResult scanResult) {
        if (scanResult == null) {
            return false;
        }
        BluetoothDevice device = scanResult.getDevice();
        String str = this.f33225b;
        if (str != null && (device == null || !str.equals(device.getAddress()))) {
            return false;
        }
        ScanRecord scanRecord = scanResult.getScanRecord();
        if (scanRecord == null && (this.f33224a != null || this.f33226c != null || this.f33232i != null || this.f33229f != null)) {
            return false;
        }
        String str2 = this.f33224a;
        if (str2 != null && !str2.equals(scanRecord.getDeviceName())) {
            return false;
        }
        ParcelUuid parcelUuid = this.f33226c;
        if (parcelUuid != null && !s(parcelUuid, this.f33227d, scanRecord.getServiceUuids())) {
            return false;
        }
        ParcelUuid parcelUuid2 = this.f33228e;
        if (parcelUuid2 != null && !p(this.f33229f, this.f33230g, scanRecord.getServiceData(parcelUuid2))) {
            return false;
        }
        int i7 = this.f33231h;
        return i7 < 0 || p(this.f33232i, this.f33233j, scanRecord.getManufacturerSpecificData(i7));
    }

    public String toString() {
        return "BluetoothLeScanFilter [mDeviceName=" + this.f33224a + ", mDeviceAddress=" + this.f33225b + ", mUuid=" + this.f33226c + ", mUuidMask=" + this.f33227d + ", mServiceDataUuid=" + Objects.toString(this.f33228e) + ", mServiceData=" + Arrays.toString(this.f33229f) + ", mServiceDataMask=" + Arrays.toString(this.f33230g) + ", mManufacturerId=" + this.f33231h + ", mManufacturerData=" + Arrays.toString(this.f33232i) + ", mManufacturerDataMask=" + Arrays.toString(this.f33233j) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f33224a == null ? 0 : 1);
        String str = this.f33224a;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.f33225b == null ? 0 : 1);
        String str2 = this.f33225b;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        parcel.writeInt(this.f33226c == null ? 0 : 1);
        ParcelUuid parcelUuid = this.f33226c;
        if (parcelUuid != null) {
            parcel.writeParcelable(parcelUuid, i7);
            parcel.writeInt(this.f33227d == null ? 0 : 1);
            ParcelUuid parcelUuid2 = this.f33227d;
            if (parcelUuid2 != null) {
                parcel.writeParcelable(parcelUuid2, i7);
            }
        }
        parcel.writeInt(this.f33228e == null ? 0 : 1);
        ParcelUuid parcelUuid3 = this.f33228e;
        if (parcelUuid3 != null) {
            parcel.writeParcelable(parcelUuid3, i7);
            parcel.writeInt(this.f33229f == null ? 0 : 1);
            byte[] bArr = this.f33229f;
            if (bArr != null) {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.f33229f);
                parcel.writeInt(this.f33230g == null ? 0 : 1);
                byte[] bArr2 = this.f33230g;
                if (bArr2 != null) {
                    parcel.writeInt(bArr2.length);
                    parcel.writeByteArray(this.f33230g);
                }
            }
        }
        parcel.writeInt(this.f33231h);
        parcel.writeInt(this.f33232i == null ? 0 : 1);
        byte[] bArr3 = this.f33232i;
        if (bArr3 != null) {
            parcel.writeInt(bArr3.length);
            parcel.writeByteArray(this.f33232i);
            parcel.writeInt(this.f33233j != null ? 1 : 0);
            byte[] bArr4 = this.f33233j;
            if (bArr4 != null) {
                parcel.writeInt(bArr4.length);
                parcel.writeByteArray(this.f33233j);
            }
        }
    }

    public CompatScanFilter(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i7, byte[] bArr3, byte[] bArr4) {
        this.f33224a = str;
        this.f33226c = parcelUuid;
        this.f33227d = parcelUuid2;
        this.f33225b = str2;
        this.f33228e = parcelUuid3;
        this.f33229f = bArr;
        this.f33230g = bArr2;
        this.f33231h = i7;
        this.f33232i = bArr3;
        this.f33233j = bArr4;
    }
}
