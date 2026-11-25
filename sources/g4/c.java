package g4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<BP extends BluetoothProfile> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothManager f34030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothAdapter f34031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f34032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<b> f34033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BP f34034e;

    public c(Context context) {
        this.f34032c = context.getApplicationContext();
        d();
    }

    public void a(b bVar) {
        if (this.f34033d == null) {
            this.f34033d = new CopyOnWriteArrayList();
        }
        if (this.f34033d.contains(bVar)) {
            return;
        }
        this.f34033d.add(bVar);
    }

    public BP b() {
        return this.f34034e;
    }

    public int c(BluetoothDevice bluetoothDevice) {
        BluetoothAdapter bluetoothAdapter = this.f34031b;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            k4.b.s("BT not enabled");
            return -1;
        }
        if (b() != null) {
            return this.f34034e.getConnectionState(bluetoothDevice);
        }
        k4.b.s("not supported > " + this.f34034e.getClass().getName());
        return -1;
    }

    public boolean d() {
        if (this.f34030a == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) this.f34032c.getSystemService("bluetooth");
            this.f34030a = bluetoothManager;
            if (bluetoothManager == null) {
                k4.b.s("Unable to initialize BluetoothManager.");
                return false;
            }
        }
        if (this.f34031b != null) {
            return true;
        }
        BluetoothAdapter adapter = this.f34030a.getAdapter();
        this.f34031b = adapter;
        if (adapter != null) {
            return true;
        }
        k4.b.s("Unable to obtain a BluetoothAdapter.");
        return false;
    }

    public boolean e() {
        return b() != null;
    }

    public void f(b bVar) {
        List<b> list = this.f34033d;
        if (list != null) {
            list.remove(bVar);
        }
    }

    public void g(BP bp) {
        this.f34034e = bp;
    }
}
