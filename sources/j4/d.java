package j4;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import androidx.core.view.q1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final UUID f34285g = UUID.fromString("0000180d-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final UUID f34286h = UUID.fromString("00002a37-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final UUID f34287i = UUID.fromString(d4.f.f33494r);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattService f34288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattCharacteristic f34289b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f34291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f34292e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f34290c = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BluetoothGattCallback f34293f = new a();

    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (d.this.f34289b != null && d.f34286h.equals(bluetoothGattCharacteristic.getUuid())) {
                k4.b.e("HRP DATA: " + Arrays.toString(value));
                d.this.f34290c = (value[1] & 255) | ((value[0] << 8) & q1.f6813f);
                if (d.this.f34291d != null) {
                    d.this.f34291d.a(d.this.f34290c);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i7) {
            if (i7 != 0) {
                k4.b.s("Descriptor write error: " + i7);
                return;
            }
            if (d.this.f34289b != null && d.f34286h.equals(bluetoothGattDescriptor.getCharacteristic().getUuid()) && d.f34287i.equals(bluetoothGattDescriptor.getUuid())) {
                k4.b.e("Descriptor write ok.");
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i7) {
            if (i7 == 0) {
                d.this.f34288a = bluetoothGatt.getService(d.f34285g);
                if (d.this.f34288a == null) {
                    k4.b.s("HEART_RATE_SERVICE not supported");
                    return;
                }
                d dVar = d.this;
                dVar.f34289b = dVar.f34288a.getCharacteristic(d.f34286h);
                if (d.this.f34289b == null) {
                    k4.b.s("HEART_RATE_MEASUREMENT_CHARACTERISTIC not supported");
                    return;
                }
                k4.b.p("find HEART_RATE_MEASUREMENT_CHARACTERISTIC : " + d.f34286h);
                List<BluetoothGattDescriptor> descriptors = d.this.f34289b.getDescriptors();
                if (descriptors == null || descriptors.size() <= 0) {
                    return;
                }
                Iterator<BluetoothGattDescriptor> it = descriptors.iterator();
                while (it.hasNext()) {
                    k4.b.e("descriptor : " + it.next().getUuid().toString());
                }
            }
        }
    }

    public interface b {
        void a(int i7);
    }

    public d(String str, b bVar) {
        this.f34291d = bVar;
        this.f34292e = str;
        e();
    }

    public static boolean o(byte[] bArr, byte[] bArr2, int i7) {
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

    public final void e() {
        d4.f.y().H(this.f34292e, this.f34293f);
    }

    public void j() {
        d4.f.y().O(this.f34292e, this.f34293f);
    }

    public boolean l(boolean z7) {
        return d4.f.y().M(this.f34292e, this.f34289b, f34287i, z7);
    }

    public int m() {
        return this.f34290c;
    }

    public boolean n() {
        byte[] value = this.f34289b.getDescriptor(f34287i).getValue();
        k4.b.p("data: " + Arrays.toString(value));
        return o(value, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, 2);
    }
}
