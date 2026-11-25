package e4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f33550g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f33551h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f33552i = 256;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f33553j = 257;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f33554k = 512;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f33555l = 768;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f33556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f33557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f33558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BluetoothAdapter f33559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f33560e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BluetoothDevice f33561f = null;

    public a(Context context, b bVar) {
        this.f33558c = context;
        this.f33556a = bVar;
    }

    public void a() {
        k4.b.p("initialize...");
        Context context = this.f33558c;
        if (context != null) {
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.f33559d = defaultAdapter;
        if (defaultAdapter == null) {
            k4.b.e("BluetoothAdapter not initialized ");
            this.f33557b = false;
        } else if (defaultAdapter.isEnabled()) {
            this.f33557b = true;
        } else {
            k4.b.e("Bluetooth is disabled ");
            this.f33557b = false;
        }
    }

    public synchronized void b(int i7) {
        k4.b.p(String.format(Locale.US, ">> ConnectionState=0x%04X > 0x%04X", Integer.valueOf(this.f33560e), Integer.valueOf(i7)));
        this.f33560e = i7;
        b bVar = this.f33556a;
        if (bVar != null) {
            bVar.a(this.f33561f, true, i7);
        } else {
            k4.b.p("no callback registered");
        }
    }

    public int c() {
        return this.f33560e;
    }

    public BluetoothDevice d() {
        return this.f33561f;
    }

    public a(b bVar) {
        this.f33556a = bVar;
    }
}
