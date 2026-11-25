package g4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import java.lang.String;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<CN extends String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BluetoothManager f34023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothAdapter f34024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f34025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<b> f34026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CN f34027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Class f34028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BluetoothProfile f34029g;

    public a(Context context) {
        this.f34025c = context.getApplicationContext();
        d();
    }

    public void a(b bVar) {
        if (this.f34026d == null) {
            this.f34026d = new CopyOnWriteArrayList();
        }
        if (this.f34026d.contains(bVar)) {
            return;
        }
        this.f34026d.add(bVar);
    }

    public CN b() {
        return this.f34027e;
    }

    public int c(BluetoothDevice bluetoothDevice) {
        BluetoothAdapter bluetoothAdapter = this.f34024b;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            k4.b.s("BT not enabled");
            return -1;
        }
        Class cls = this.f34028f;
        if (cls == null) {
            k4.b.s("not supported > " + this.f34028f.getName());
            return -1;
        }
        try {
            Method method = cls.getMethod("getConnectionState", BluetoothDevice.class);
            if (method != null) {
                Integer num = (Integer) method.invoke(this.f34029g, bluetoothDevice);
                k4.b.e("result: " + num);
                return num.intValue();
            }
        } catch (Exception e8) {
            k4.b.h("An exception occured,  " + e8.toString());
        }
        return -1;
    }

    public boolean d() {
        if (this.f34023a == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) this.f34025c.getSystemService("bluetooth");
            this.f34023a = bluetoothManager;
            if (bluetoothManager == null) {
                k4.b.s("Unable to initialize BluetoothManager.");
                return false;
            }
        }
        if (this.f34024b != null) {
            return true;
        }
        BluetoothAdapter adapter = this.f34023a.getAdapter();
        this.f34024b = adapter;
        if (adapter != null) {
            return true;
        }
        k4.b.s("Unable to obtain a BluetoothAdapter.");
        return false;
    }

    public boolean e() {
        return this.f34028f != null;
    }

    public void f(b bVar) {
        List<b> list = this.f34026d;
        if (list != null) {
            list.remove(bVar);
        }
    }

    public void g(CN cn) {
        this.f34027e = cn;
    }
}
