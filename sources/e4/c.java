package e4;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class c extends e4.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final UUID f33562t = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f33563u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f33564v = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f33565m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f33566n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public UUID f33567o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f33568p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public C0406c f33569q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f33570r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f33571s;

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BluetoothServerSocket f33572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f33573b;

        public a(boolean z7) {
            this.f33573b = z7 ? "Secure" : "Insecure";
            this.f33572a = a(z7);
            c.this.b(257);
        }

        public final BluetoothServerSocket a(boolean z7) {
            BluetoothServerSocket bluetoothServerSocketListenUsingInsecureRfcommWithServiceRecord;
            try {
                if (z7) {
                    c cVar = c.this;
                    bluetoothServerSocketListenUsingInsecureRfcommWithServiceRecord = cVar.f33559d.listenUsingRfcommWithServiceRecord("RealtekSppChannelSecure", cVar.f33567o);
                } else {
                    c cVar2 = c.this;
                    bluetoothServerSocketListenUsingInsecureRfcommWithServiceRecord = cVar2.f33559d.listenUsingInsecureRfcommWithServiceRecord("RealtekSppChannelInsecure", cVar2.f33567o);
                }
                return bluetoothServerSocketListenUsingInsecureRfcommWithServiceRecord;
            } catch (IOException e8) {
                k4.b.h("Socket Type: " + this.f33573b + " listen() failed: " + e8.toString());
                return null;
            }
        }

        public void b() throws IOException {
            k4.b.p("cancel AcceptThread");
            try {
                BluetoothServerSocket bluetoothServerSocket = this.f33572a;
                if (bluetoothServerSocket != null) {
                    bluetoothServerSocket.close();
                }
            } catch (IOException e8) {
                k4.b.h("close() of server failed： " + e8);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            k4.b.p("Socket Type: " + this.f33573b + "BEGIN mAcceptThread");
            setName("AcceptThread:SppChannel");
            while (c.this.f33560e != 512) {
                try {
                    BluetoothSocket bluetoothSocketAccept = this.f33572a.accept();
                    if (bluetoothSocketAccept != null) {
                        synchronized (c.this) {
                            c cVar = c.this;
                            int i7 = cVar.f33560e;
                            if (i7 == 0 || i7 == 512) {
                                try {
                                    bluetoothSocketAccept.close();
                                } catch (IOException e8) {
                                    k4.b.h("Could not close unwanted socket： " + e8);
                                }
                            } else if (i7 == 256 || i7 == 257) {
                                cVar.f33571s = bluetoothSocketAccept.getConnectionType();
                                c.this.n(bluetoothSocketAccept, bluetoothSocketAccept.getRemoteDevice(), this.f33573b);
                            }
                        }
                    }
                } catch (IOException e9) {
                    k4.b.h("accept() failed" + e9);
                    c.this.b(0);
                }
            }
            k4.b.e("END AcceptThread");
        }
    }

    /* JADX INFO: renamed from: e4.c$c, reason: collision with other inner class name */
    public class C0406c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BluetoothSocket f33579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BufferedInputStream f33580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public BufferedOutputStream f33581c;

        public C0406c(BluetoothSocket bluetoothSocket, String str) {
            BufferedInputStream bufferedInputStream;
            BufferedOutputStream bufferedOutputStream = null;
            this.f33580b = null;
            this.f33581c = null;
            k4.b.e("create ConnectedThread");
            this.f33579a = bluetoothSocket;
            try {
                bufferedInputStream = new BufferedInputStream(bluetoothSocket.getInputStream());
                try {
                    bufferedOutputStream = new BufferedOutputStream(bluetoothSocket.getOutputStream());
                } catch (IOException e8) {
                    e = e8;
                    k4.b.h("temp sockets not created: " + e);
                }
            } catch (IOException e9) {
                e = e9;
                bufferedInputStream = null;
            }
            this.f33580b = bufferedInputStream;
            this.f33581c = bufferedOutputStream;
        }

        public void a() throws IOException {
            BluetoothSocket bluetoothSocket = this.f33579a;
            if (bluetoothSocket == null) {
                return;
            }
            try {
                bluetoothSocket.close();
            } catch (IOException e8) {
                k4.b.h("close socket failed: " + e8);
            }
        }

        public boolean b(byte[] bArr) {
            if (this.f33581c == null) {
                return false;
            }
            try {
                if (c.this.f33565m) {
                    k4.b.p(String.format(Locale.US, "<< (%d) %s", Integer.valueOf(bArr.length), m4.a.a(bArr)));
                }
                this.f33581c.write(bArr);
                this.f33581c.flush();
                return true;
            } catch (IOException e8) {
                k4.b.h("Exception during write： " + e8);
                return false;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            k4.b.e("BEGIN mConnectedThread");
            byte[] bArr = new byte[1024];
            c.this.b(512);
            while (c.this.f33560e == 512) {
                try {
                    int i7 = this.f33580b.read(bArr);
                    if (i7 > 0) {
                        byte[] bArr2 = new byte[i7];
                        System.arraycopy(bArr, 0, bArr2, 0, i7);
                        if (c.this.f33565m) {
                            k4.b.p("[RX >>] (" + i7 + ") " + m4.a.b(bArr2));
                        }
                        e4.b bVar = c.this.f33556a;
                        if (bVar != null) {
                            bVar.b(bArr2);
                        }
                    }
                } catch (IOException e8) {
                    k4.b.h(e8.toString());
                    c.this.j();
                    return;
                }
            }
        }
    }

    public c(e4.b bVar) {
        this(1, f33562t, bVar);
    }

    public final void i() {
        k4.b.p("connectionFailed");
        this.f33561f = null;
        b(0);
        r();
    }

    public final void j() {
        k4.b.p("connectionLost");
        this.f33561f = null;
        b(0);
        r();
    }

    public synchronized boolean l(BluetoothDevice bluetoothDevice) {
        b bVar;
        if (bluetoothDevice == null) {
            return false;
        }
        if (!this.f33557b) {
            a();
        }
        this.f33561f = bluetoothDevice;
        if (this.f33560e == 256 && (bVar = this.f33568p) != null) {
            bVar.b();
            this.f33568p = null;
        }
        C0406c c0406c = this.f33569q;
        if (c0406c != null) {
            c0406c.a();
            this.f33569q = null;
        }
        b bVar2 = new b(this, bluetoothDevice);
        this.f33568p = bVar2;
        bVar2.start();
        return true;
    }

    public synchronized boolean m(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket) {
        if (!this.f33557b) {
            a();
        }
        if (bluetoothSocket != null) {
            n(bluetoothSocket, bluetoothDevice, "Secure");
            return true;
        }
        return l(bluetoothDevice);
    }

    public synchronized void n(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice, String str) {
        k4.b.p("BluetoothSocket connected, Socket Type: " + str);
        this.f33561f = bluetoothDevice;
        b bVar = this.f33568p;
        if (bVar != null) {
            bVar.b();
            this.f33568p = null;
        }
        C0406c c0406c = this.f33569q;
        if (c0406c != null) {
            c0406c.a();
            this.f33569q = null;
        }
        a aVar = this.f33570r;
        if (aVar != null) {
            aVar.b();
            this.f33570r = null;
        }
        C0406c c0406c2 = new C0406c(bluetoothSocket, str);
        this.f33569q = c0406c2;
        c0406c2.start();
    }

    public synchronized void p() {
        this.f33556a = null;
        t();
    }

    public synchronized void r() {
        s(true);
    }

    public synchronized void s(boolean z7) {
        k4.b.p("start secure: " + z7);
        b bVar = this.f33568p;
        if (bVar != null) {
            bVar.b();
            this.f33568p = null;
        }
        C0406c c0406c = this.f33569q;
        if (c0406c != null) {
            c0406c.a();
            this.f33569q = null;
        }
        if ((this.f33566n & 2) == 2 && this.f33570r == null) {
            a aVar = new a(z7);
            this.f33570r = aVar;
            aVar.start();
        }
    }

    public synchronized void t() throws IOException {
        k4.b.p("stop");
        this.f33561f = null;
        if (this.f33560e == 512) {
            b(768);
        }
        b bVar = this.f33568p;
        if (bVar != null) {
            bVar.b();
            this.f33568p = null;
        }
        C0406c c0406c = this.f33569q;
        if (c0406c != null) {
            c0406c.a();
            this.f33569q = null;
        }
        a aVar = this.f33570r;
        if (aVar != null) {
            aVar.b();
            this.f33570r = null;
        }
    }

    public boolean u(byte[] bArr) {
        synchronized (this) {
            if (this.f33560e != 512) {
                k4.b.e("not connected");
                return false;
            }
            C0406c c0406c = this.f33569q;
            if (c0406c != null) {
                return c0406c.b(bArr);
            }
            k4.b.e("ConnectedThread not created");
            return false;
        }
    }

    public c(UUID uuid, e4.b bVar) {
        this(1, uuid, bVar);
    }

    public c(int i7, UUID uuid, e4.b bVar) {
        super(bVar);
        this.f33565m = false;
        this.f33571s = -1;
        this.f33566n = i7;
        this.f33567o = uuid;
        this.f33560e = 0;
        this.f33565m = b4.d.f11317b;
        a();
    }

    public class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BluetoothSocket f33575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BluetoothDevice f33576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f33577c;

        public b(BluetoothDevice bluetoothDevice, boolean z7) {
            this.f33576b = bluetoothDevice;
            this.f33575a = a(bluetoothDevice, z7);
            c.this.b(256);
        }

        public final BluetoothSocket a(BluetoothDevice bluetoothDevice, boolean z7) {
            BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord;
            this.f33577c = z7 ? "Secure" : "Insecure";
            try {
                bluetoothSocketCreateRfcommSocketToServiceRecord = z7 ? bluetoothDevice.createRfcommSocketToServiceRecord(c.this.f33567o) : bluetoothDevice.createInsecureRfcommSocketToServiceRecord(c.this.f33567o);
            } catch (IOException e8) {
                k4.b.h("Socket Type: " + this.f33577c + "create() failed: " + e8.toString());
                bluetoothSocketCreateRfcommSocketToServiceRecord = null;
            }
            if (bluetoothSocketCreateRfcommSocketToServiceRecord != null) {
                c.this.f33571s = bluetoothSocketCreateRfcommSocketToServiceRecord.getConnectionType();
            }
            return bluetoothSocketCreateRfcommSocketToServiceRecord;
        }

        public void b() throws IOException {
            try {
                BluetoothSocket bluetoothSocket = this.f33575a;
                if (bluetoothSocket != null) {
                    bluetoothSocket.close();
                }
            } catch (IOException e8) {
                k4.b.h("close socket failed: " + e8);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            k4.b.e("BEGIN mConnectThread SocketType:" + this.f33577c + ", mSocketConnectionType: " + c.this.f33571s);
            setName("ConnectThread:SppChannel");
            if (this.f33575a == null) {
                k4.b.s("get BluetoothSocket fail, connect fail");
                c.this.b(0);
                return;
            }
            BluetoothAdapter bluetoothAdapter = c.this.f33559d;
            if (bluetoothAdapter != null) {
                bluetoothAdapter.cancelDiscovery();
            }
            try {
                if (this.f33575a.isConnected()) {
                    k4.b.e("socket already connected");
                } else {
                    k4.b.e("connect socket ...");
                    this.f33575a.connect();
                }
                synchronized (c.this) {
                    c.this.f33568p = null;
                }
                c.this.n(this.f33575a, this.f33576b, this.f33577c);
            } catch (IOException e8) {
                k4.b.h(e8.toString());
                try {
                    this.f33575a.close();
                } catch (IOException e9) {
                    k4.b.h("unable to close socket during connection failure: " + e9);
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
                c.this.i();
            }
        }

        public b(c cVar, BluetoothDevice bluetoothDevice) {
            this(bluetoothDevice, true);
        }
    }
}
