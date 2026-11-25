package e4;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static UUID f33583f = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile d f33584g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f33586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f33587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f33588d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f33589e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<b> f33585a = new CopyOnWriteArrayList();

    public class a extends b {
        public a() {
        }

        @Override // e4.b
        public void a(BluetoothDevice bluetoothDevice, boolean z7, int i7) {
            super.a(bluetoothDevice, z7, i7);
            synchronized (d.this.f33585a) {
                if (d.this.f33585a != null && d.this.f33585a.size() > 0) {
                    Iterator it = d.this.f33585a.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).a(bluetoothDevice, z7, i7);
                    }
                }
            }
        }

        @Override // e4.b
        public void b(byte[] bArr) {
            super.b(bArr);
            synchronized (d.this.f33585a) {
                if (d.this.f33585a != null && d.this.f33585a.size() > 0) {
                    Iterator it = d.this.f33585a.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).b(bArr);
                    }
                }
            }
        }
    }

    public d() {
        a();
    }

    public static d h() {
        return f33584g;
    }

    public static synchronized void i() {
        if (f33584g == null) {
            synchronized (d.class) {
                if (f33584g == null) {
                    f33584g = new d();
                }
            }
        }
    }

    public final c a() {
        if (this.f33586b == null) {
            this.f33586b = new c(f33583f, this.f33589e);
        }
        return this.f33586b;
    }

    public synchronized boolean c(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, b bVar) {
        k(bVar);
        if (g() == 512) {
            BluetoothDevice bluetoothDeviceD = a().d();
            if (bluetoothDeviceD != null && bluetoothDeviceD.equals(bluetoothDevice)) {
                bVar.a(bluetoothDevice, true, 512);
                return true;
            }
            k4.b.e("current connected device is conflict with the connecting device");
        }
        boolean zM = a().m(bluetoothDevice, bluetoothSocket);
        if (!zM) {
            m(bVar);
        }
        return zM;
    }

    public synchronized boolean d(BluetoothDevice bluetoothDevice, b bVar) {
        k(bVar);
        if (g() == 512) {
            BluetoothDevice bluetoothDeviceD = a().d();
            if (bluetoothDeviceD != null && bluetoothDeviceD.equals(bluetoothDevice)) {
                k4.b.e("connection already connected");
                bVar.a(bluetoothDevice, true, 512);
                return true;
            }
            k4.b.e("current connected device is conflict with the connecting device");
        }
        boolean zL = a().l(bluetoothDevice);
        if (!zL) {
            m(bVar);
        }
        return zL;
    }

    public void e() throws IOException {
        synchronized (this.f33585a) {
            List<b> list = this.f33585a;
            if (list != null) {
                list.clear();
            }
        }
        f();
    }

    public void f() throws IOException {
        a().t();
    }

    public int g() {
        return a().c();
    }

    public void j() {
        synchronized (this.f33588d) {
            this.f33587c = true;
            this.f33588d.notifyAll();
        }
    }

    public void k(b bVar) {
        synchronized (this.f33585a) {
            if (this.f33585a == null) {
                this.f33585a = new CopyOnWriteArrayList();
            }
            if (!this.f33585a.contains(bVar)) {
                this.f33585a.add(bVar);
            }
            k4.b.p("callback's size=" + this.f33585a.size());
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0014 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #2 {, blocks: (B:8:0x0008, B:9:0x000a, B:11:0x0014, B:18:0x0020, B:19:0x0022, B:35:0x003d, B:20:0x0023, B:22:0x0027, B:26:0x0033, B:27:0x0035, B:30:0x0038, B:25:0x0030), top: B:42:0x0008, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x001b  */
    /* JADX WARN: Code duplicated, block: B:16:0x001e A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:18:0x0020 A[Catch: all -> 0x003e, TRY_ENTER, TryCatch #2 {, blocks: (B:8:0x0008, B:9:0x000a, B:11:0x0014, B:18:0x0020, B:19:0x0022, B:35:0x003d, B:20:0x0023, B:22:0x0027, B:26:0x0033, B:27:0x0035, B:30:0x0038, B:25:0x0030), top: B:42:0x0008, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0038 A[Catch: all -> 0x003b, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:20:0x0023, B:22:0x0027, B:26:0x0033, B:27:0x0035, B:30:0x0038, B:25:0x0030), top: B:41:0x0023, outer: #2, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:16:0x001e, please report this as an issue */
    public synchronized boolean l(byte[] bArr, boolean z7) {
        if (bArr == null) {
            return false;
        }
        if (z7) {
            if (!a().u(bArr)) {
                k4.b.s("send spp data failed");
                return false;
            }
            if (z7) {
                return true;
            }
            synchronized (this.f33588d) {
                if (!this.f33587c) {
                    return true;
                }
                this.f33588d.wait(5000L);
                return this.f33587c;
            }
        }
        this.f33587c = false;
        if (!a().u(bArr)) {
            k4.b.s("send spp data failed");
            return false;
        }
        if (z7) {
            return true;
        }
        synchronized (this.f33588d) {
            if (!this.f33587c) {
                return true;
            }
            try {
                this.f33588d.wait(5000L);
            } catch (InterruptedException e8) {
                e8.printStackTrace();
            }
            return this.f33587c;
        }
        throw th;
    }

    public void m(b bVar) {
        synchronized (this.f33585a) {
            List<b> list = this.f33585a;
            if (list != null) {
                list.remove(bVar);
            }
        }
    }

    public boolean n(byte[] bArr) {
        return a().u(bArr);
    }
}
