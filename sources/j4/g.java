package j4;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final UUID f34317g = UUID.fromString("00001804-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final UUID f34318h = UUID.fromString("00002a07-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothGattService f34319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothGattCharacteristic f34320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f34321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f34322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f34323e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BluetoothGattCallback f34324f = new a();

    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (i7 != 0) {
                k4.b.s("Characteristic read error: " + i7);
                return;
            }
            if (g.f34318h.equals(bluetoothGattCharacteristic.getUuid())) {
                g.this.f34323e = value[0];
                k4.b.p("mTxPowerLevel=" + g.this.f34323e);
                if (g.this.f34321c != null) {
                    g.this.f34321c.a(g.this.f34323e);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i7) {
            if (i7 == 0) {
                g.this.f34319a = bluetoothGatt.getService(g.f34317g);
                if (g.this.f34319a == null) {
                    k4.b.s("TX_POWER_SERVICE not supported");
                    return;
                }
                g gVar = g.this;
                gVar.f34320b = gVar.f34319a.getCharacteristic(g.f34318h);
                if (g.this.f34320b == null) {
                    k4.b.s("TX_POWER_LEVEL_CHARACTERISTIC not supported");
                    return;
                }
                k4.b.e("find TX_POWER_LEVEL_CHARACTERISTIC : " + g.f34318h);
                List<BluetoothGattDescriptor> descriptors = g.this.f34320b.getDescriptors();
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

    public g(String str, b bVar) {
        this.f34321c = bVar;
        this.f34322d = str;
        e();
    }

    public static boolean l(byte[] bArr, byte[] bArr2, int i7) {
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
        d4.f.y().H(this.f34322d, this.f34324f);
    }

    public void j() {
        d4.f.y().O(this.f34322d, this.f34324f);
    }

    public boolean m() {
        if (this.f34320b != null) {
            return d4.f.y().G(this.f34322d, this.f34320b);
        }
        k4.b.s("TX_POWER_LEVEL_CHARACTERISTIC not supported");
        return false;
    }
}
