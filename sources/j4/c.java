package j4;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final UUID f34277f = UUID.fromString("00001812-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final UUID f34278g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattService f34279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattCharacteristic f34280b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f34282d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f34281c = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BluetoothGattCallback f34283e = new a();

    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            bluetoothGattCharacteristic.getValue();
            BluetoothGattCharacteristic unused = c.this.f34280b;
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
            bluetoothGattCharacteristic.getValue();
            if (i7 == 0) {
                return;
            }
            k4.b.s("Characteristic read error: " + i7);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i7) {
            if (i7 == 0) {
                return;
            }
            k4.b.s("Descriptor write error: " + i7);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i7) {
            if (i7 == 0) {
                c.this.f34279a = bluetoothGatt.getService(c.f34277f);
                if (c.this.f34279a == null) {
                    k4.b.s("HOGP_SERVICE_UUID not supported");
                }
            }
        }
    }

    public interface b {
        void a(int i7, boolean z7);
    }

    static {
        d4.c.e("2a4d");
        d4.c.e("2a22");
        d4.c.e("2a33");
        f34278g = UUID.fromString(d4.f.f33494r);
    }

    public c(String str, b bVar) {
        this.f34282d = str;
        c();
    }

    public static boolean h(byte[] bArr, byte[] bArr2, int i7) {
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null) {
            return false;
        }
        if (bArr == bArr2) {
            return true;
        }
        for (int i8 = 0; i8 < bArr.length && i8 < bArr2.length && i8 < i7; i8++) {
            if (bArr[i8] != bArr2[i8]) {
                return false;
            }
        }
        return true;
    }

    public final void c() {
        d4.f.y().H(this.f34282d, this.f34283e);
    }

    public void f() {
        d4.f.y().O(this.f34282d, this.f34283e);
    }

    public int g() {
        return this.f34281c;
    }

    public boolean i() {
        if (this.f34280b != null) {
            return d4.f.y().G(this.f34282d, this.f34280b);
        }
        k4.b.e("BATTERY_LEVEL_CHARACTERISTIC not supported");
        return false;
    }

    public boolean j(boolean z7) {
        if (this.f34280b != null) {
            return d4.f.y().M(this.f34282d, this.f34280b, f34278g, z7);
        }
        k4.b.e("BATTERY_LEVEL_CHARACTERISTIC not supported");
        return false;
    }
}
