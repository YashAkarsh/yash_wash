package com.realsil.sdk.core.bluetooth.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import h4.h;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class ScannerPresenter {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f33193o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f33194p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f33195q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f33196r = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f33197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f33198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BluetoothAdapter f33199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.realsil.sdk.core.bluetooth.scanner.b f33200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f33201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ScannerParams f33202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f33203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f33204h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f33205i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.realsil.sdk.core.bluetooth.scanner.a.InterfaceC0402a f33206j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Runnable f33207k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Runnable f33208l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final BroadcastReceiver f33209m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Runnable f33210n;

    public class a implements com.realsil.sdk.core.bluetooth.scanner.a.InterfaceC0402a {
        public a() {
        }

        @Override // com.realsil.sdk.core.bluetooth.scanner.a.InterfaceC0402a
        public void a() {
            k4.b.p("onLeScanStop");
            ScannerPresenter.this.c(3);
        }

        @Override // com.realsil.sdk.core.bluetooth.scanner.a.InterfaceC0402a
        public void b() {
        }

        @Override // com.realsil.sdk.core.bluetooth.scanner.a.InterfaceC0402a
        public void onLeScan(BluetoothDevice bluetoothDevice, int i7, byte[] bArr) {
            ScannerPresenter.this.d(bluetoothDevice, i7, bArr);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis < ScannerPresenter.this.f33205i) {
                ScannerPresenter.this.f33205i = 0L;
            }
            if (ScannerPresenter.this.f33203g == 1) {
                k4.b.e("not receive scan response after start scan for 15000 ms, stop scan");
                ScannerPresenter.this.x(false);
                return;
            }
            if (ScannerPresenter.this.f33203g == 2) {
                if (timeInMillis - ScannerPresenter.this.f33205i > 15000) {
                    k4.b.e(String.format(Locale.US, "exceed %d ms , no scan response received since last time", 15000L));
                    ScannerPresenter.this.x(false);
                    return;
                } else if (ScannerPresenter.this.f33204h == null) {
                    k4.b.s("mHandler == null");
                    return;
                } else {
                    ScannerPresenter.this.f33204h.removeCallbacksAndMessages(ScannerPresenter.this.f33208l);
                    ScannerPresenter.this.f33204h.postDelayed(ScannerPresenter.this.f33208l, ScannerPresenter.this.f33202f.j());
                    return;
                }
            }
            k4.b.p("ignore state:" + ScannerPresenter.this.f33203g);
            if (ScannerPresenter.this.f33204h == null) {
                k4.b.s("mHandler == null");
            } else {
                ScannerPresenter.this.f33204h.removeCallbacksAndMessages(ScannerPresenter.this.f33208l);
                ScannerPresenter.this.f33204h.postDelayed(ScannerPresenter.this.f33208l, ScannerPresenter.this.f33202f.j());
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k4.b.p("le delay time reached");
            ScannerPresenter.this.x(false);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScannerPresenter.this.f33201e != null) {
                ScannerPresenter.this.f33201e.a();
            } else {
                k4.b.p("no callback registed");
            }
            ScannerPresenter.this.x(true);
        }
    }

    public ScannerPresenter(Context context, ScannerParams scannerParams, h hVar) {
        this(context, null, scannerParams, hVar);
    }

    public synchronized boolean A(boolean z7, boolean z8) {
        try {
            if (z7) {
                int i7 = this.f33203g;
                if (i7 != 1 && i7 != 2) {
                    c(1);
                    this.f33204h.removeCallbacks(this.f33208l);
                    this.f33204h.removeCallbacks(this.f33207k);
                    this.f33205i = 0L;
                    if (this.f33200d == null) {
                        k4.b.s("mRetkLeScannerCompat is null");
                        x(false);
                        return false;
                    }
                    k4.b.p("start le scan for " + this.f33202f.j() + "ms");
                    this.f33200d.e(this.f33206j);
                    if (!this.f33200d.c(this.f33202f, true)) {
                        x(false);
                        return false;
                    }
                    Handler handler = this.f33204h;
                    if (handler != null) {
                        handler.postDelayed(this.f33207k, 15000L);
                    } else {
                        k4.b.s("mHandler == null");
                    }
                }
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                if (timeInMillis < this.f33205i) {
                    this.f33205i = 0L;
                }
                if (timeInMillis - this.f33205i > 15000) {
                    k4.b.e(String.format(Locale.US, "exceed %d ms , no scan response received since last time", 15000L));
                    x(false);
                } else if (this.f33204h != null) {
                    k4.b.e("wait to check state:" + this.f33203g);
                    this.f33204h.removeCallbacks(this.f33207k);
                    this.f33204h.postDelayed(this.f33207k, 15000L);
                } else {
                    k4.b.s("mHandler == null");
                }
                return true;
            }
            int i8 = this.f33203g;
            if (i8 == 0 || i8 == 3) {
                k4.b.e("mState == STATE_DISCOVERY_FINISHED | STATE_IDLE");
                if (!z8) {
                    return true;
                }
                k4.b.p("force to stop scan");
            }
            this.f33204h.removeCallbacks(this.f33208l);
            if (this.f33200d != null) {
                k4.b.p("stop the le scan");
                this.f33200d.e(null);
                if (!this.f33200d.d(false)) {
                    k4.b.s("scanLeDevice failed");
                    return false;
                }
            } else {
                k4.b.s("mRetkLeScannerCompat is null");
            }
            c(0);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void B(int i7) {
        this.f33202f.E(i7);
    }

    public void C(h hVar) {
        this.f33201e = hVar;
        if (hVar == null) {
            k4.b.s("callback is null");
        }
    }

    public void D(ScannerParams scannerParams) {
        this.f33202f = scannerParams;
    }

    public final void c(int i7) {
        k4.b.p(String.format(Locale.US, "ScanState 0x%02X >> 0x%02X", Integer.valueOf(this.f33203g), Integer.valueOf(i7)));
        this.f33203g = i7;
        h hVar = this.f33201e;
        if (hVar != null) {
            hVar.c(i7);
        } else {
            k4.b.s("no callback registed");
        }
        int i8 = this.f33203g;
        if (i8 == 0 || i8 == 3) {
            this.f33204h.removeCallbacks(this.f33208l);
            this.f33204h.removeCallbacks(this.f33207k);
            this.f33204h.removeCallbacks(this.f33210n);
            if (r()) {
                k4.b.e("wait to start auto scan");
                this.f33204h.postDelayed(this.f33210n, this.f33202f.b());
            }
        }
    }

    public final void d(BluetoothDevice bluetoothDevice, int i7, byte[] bArr) {
        this.f33205i = Calendar.getInstance().getTimeInMillis();
        int i8 = this.f33203g;
        if (i8 == 1) {
            c(2);
        } else if (i8 != 2) {
            k4.b.p("ignore, mState =" + this.f33203g);
            x(false);
            return;
        }
        if (bluetoothDevice == null) {
            k4.b.e("ignore, device is null");
            return;
        }
        if (h(bluetoothDevice, i7)) {
            h4.b bVar = new h4.b(bluetoothDevice, bluetoothDevice.getName(), i7, bluetoothDevice.getBondState() == 12, false, bArr);
            h hVar = this.f33201e;
            if (hVar != null) {
                hVar.b(bVar);
            } else {
                k4.b.p("no callback registed");
            }
            if (this.f33202f.h() == 1) {
                k4.b.e("SCAN_MECHANISM_FILTER_ONE > scanDevice(false)");
                x(false);
            }
        }
    }

    public final boolean g(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        if (this.f33202f.i() == 18) {
            if (bluetoothDevice.getType() != 2) {
                return false;
            }
        } else if (this.f33202f.i() == 33 && bluetoothDevice.getType() != 1) {
            return false;
        }
        if (TextUtils.isEmpty(this.f33202f.d())) {
            if (TextUtils.isEmpty(bluetoothDevice.getName()) && !this.f33202f.n()) {
                if (this.f33197a) {
                    k4.b.p("name is null, ignore");
                }
                return false;
            }
        } else if (!Objects.equals(this.f33202f.d(), bluetoothDevice.getName())) {
            k4.b.p("name not match:" + bluetoothDevice.getName());
            return false;
        }
        if (TextUtils.isEmpty(this.f33202f.a()) || Objects.equals(this.f33202f.a(), bluetoothDevice.getAddress())) {
            return true;
        }
        if (this.f33197a) {
            k4.b.p("address not match:" + bluetoothDevice.getAddress());
        }
        return false;
    }

    public final boolean h(BluetoothDevice bluetoothDevice, int i7) {
        if (bluetoothDevice == null) {
            k4.b.s("filter, device is null");
            return false;
        }
        if (this.f33202f.f() > -1000 && this.f33202f.f() > i7) {
            k4.b.s("filter, low rssi:" + i7);
            return false;
        }
        if (this.f33202f.i() == 18) {
            if (bluetoothDevice.getType() != 2) {
                k4.b.p(String.format(Locale.US, "filter, invalid type: %d, expect type is %d", Integer.valueOf(bluetoothDevice.getType()), 2));
                return false;
            }
        } else if (this.f33202f.i() == 17) {
            if (bluetoothDevice.getType() != 2 && bluetoothDevice.getType() != 3 && bluetoothDevice.getType() != 0) {
                k4.b.p(String.format(Locale.US, "filter, invalid type: %d, expect type is %d/%d/%d", Integer.valueOf(bluetoothDevice.getType()), 0, 2, 3));
                return false;
            }
        } else if (this.f33202f.i() == 33) {
            if (bluetoothDevice.getType() != 1) {
                k4.b.p(String.format(Locale.US, "filter, invalid type: %d, expect type is %d", Integer.valueOf(bluetoothDevice.getType()), 1));
                return false;
            }
        } else if (this.f33202f.i() == 32 && bluetoothDevice.getType() != 1 && bluetoothDevice.getType() != 3 && bluetoothDevice.getType() != 0) {
            k4.b.p(String.format(Locale.US, "filter, invalid type: %d, expect type is %d/%d/%d", Integer.valueOf(bluetoothDevice.getType()), 0, 1, 3));
            return false;
        }
        if (TextUtils.isEmpty(bluetoothDevice.getName())) {
            if (!this.f33202f.n()) {
                if (this.f33197a) {
                    k4.b.p("name is null, ignore");
                }
                return false;
            }
        } else if (!TextUtils.isEmpty(this.f33202f.d()) && !m4.a.f(this.f33202f.d(), bluetoothDevice.getName())) {
            if (this.f33197a) {
                k4.b.p("name not match:" + bluetoothDevice.getName());
            }
            return false;
        }
        if (TextUtils.isEmpty(this.f33202f.a()) || m4.a.f(this.f33202f.a(), bluetoothDevice.getAddress())) {
            return true;
        }
        if (this.f33197a) {
            k4.b.p("address not match:" + bluetoothDevice.getAddress());
        }
        return false;
    }

    public BluetoothAdapter n() {
        return this.f33199c;
    }

    public List<h4.b> o() {
        if (this.f33199c == null) {
            return null;
        }
        if (!this.f33202f.o()) {
            k4.b.s("don't reuse paired device");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (BluetoothDevice bluetoothDevice : this.f33199c.getBondedDevices()) {
            if (g(bluetoothDevice)) {
                arrayList.add(new h4.b(bluetoothDevice, bluetoothDevice.getName(), -1000, bluetoothDevice.getBondState() == 12, false));
            }
        }
        return arrayList;
    }

    public int p() {
        return this.f33203g;
    }

    public void q() {
        BluetoothManager bluetoothManager;
        if (this.f33199c == null && (bluetoothManager = (BluetoothManager) this.f33198b.getSystemService("bluetooth")) != null) {
            this.f33199c = bluetoothManager.getAdapter();
        }
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        if (this.f33202f.i() == 0 || this.f33202f.i() == 32 || this.f33202f.i() == 33) {
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.NAME_CHANGED");
        }
        this.f33198b.registerReceiver(this.f33209m, intentFilter);
        if (this.f33201e == null) {
            k4.b.s("callback is null");
        }
    }

    public boolean r() {
        return this.f33202f.k();
    }

    public boolean s() {
        BluetoothAdapter bluetoothAdapter = this.f33199c;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public boolean t() {
        return this.f33199c != null;
    }

    public boolean u() {
        int i7 = this.f33203g;
        return i7 == 2 || i7 == 1;
    }

    public void v() {
        Context context = this.f33198b;
        if (context != null) {
            try {
                context.unregisterReceiver(this.f33209m);
            } catch (Exception e8) {
                k4.b.h(e8.toString());
            }
        }
        Handler handler = this.f33204h;
        if (handler != null) {
            handler.removeCallbacks(this.f33208l);
            this.f33204h.removeCallbacks(this.f33210n);
            this.f33204h.removeCallbacks(this.f33207k);
        }
        x(false);
    }

    public synchronized boolean w(boolean z7, boolean z8) {
        try {
            if (z7) {
                int i7 = this.f33203g;
                if (i7 != 1 && i7 != 2) {
                    c(1);
                    this.f33204h.removeCallbacks(this.f33208l);
                    this.f33204h.removeCallbacks(this.f33207k);
                    this.f33205i = 0L;
                    if (this.f33199c.isDiscovering()) {
                        this.f33199c.cancelDiscovery();
                    }
                    k4.b.p("startDiscovery for " + this.f33202f.j() + "ms");
                    if (!this.f33199c.startDiscovery()) {
                        x(false);
                        return false;
                    }
                    Handler handler = this.f33204h;
                    if (handler != null) {
                        handler.postDelayed(this.f33207k, 15000L);
                    } else {
                        k4.b.s("mHandler == null");
                    }
                }
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                if (timeInMillis < this.f33205i) {
                    this.f33205i = 0L;
                }
                if (timeInMillis - this.f33205i > 15000) {
                    k4.b.e(String.format(Locale.US, "exceed %d ms , no scan response received since last time", 15000L));
                    x(false);
                } else if (this.f33204h != null) {
                    k4.b.e("wait to check state:" + this.f33203g);
                    this.f33204h.removeCallbacks(this.f33207k);
                    this.f33204h.postDelayed(this.f33207k, 15000L);
                } else {
                    k4.b.s("mHandler == null");
                }
                return true;
            }
            if (this.f33199c.isDiscovering()) {
                k4.b.p("cancelDiscovery");
                this.f33199c.cancelDiscovery();
            }
            c(0);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean x(boolean z7) {
        return y(z7, false);
    }

    public synchronized boolean y(boolean z7, boolean z8) {
        if (this.f33202f.i() == 0) {
            return z(z7, z8);
        }
        if (this.f33202f.i() != 32 && this.f33202f.i() != 33) {
            if (this.f33202f.i() != 17 && this.f33202f.i() != 18) {
                return false;
            }
            return A(z7, z8);
        }
        return w(z7, z8);
    }

    public synchronized boolean z(boolean z7, boolean z8) {
        try {
            if (z7) {
                int i7 = this.f33203g;
                if (i7 != 1 && i7 != 2) {
                    c(1);
                    this.f33204h.removeCallbacks(this.f33208l);
                    this.f33204h.removeCallbacks(this.f33207k);
                    this.f33205i = 0L;
                    if (this.f33199c.isDiscovering()) {
                        this.f33199c.cancelDiscovery();
                    }
                    k4.b.p("startDiscovery for " + this.f33202f.j() + "ms");
                    boolean zStartDiscovery = this.f33199c.startDiscovery();
                    if (this.f33200d != null) {
                        k4.b.p("start le scan for " + this.f33202f.j() + "ms");
                        this.f33200d.e(this.f33206j);
                        zStartDiscovery = this.f33200d.c(this.f33202f, true);
                    }
                    if (!zStartDiscovery) {
                        x(false);
                        return false;
                    }
                    Handler handler = this.f33204h;
                    if (handler != null) {
                        handler.postDelayed(this.f33207k, 15000L);
                    } else {
                        k4.b.s("mHandler == null");
                    }
                }
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                if (timeInMillis < this.f33205i) {
                    this.f33205i = 0L;
                }
                if (timeInMillis - this.f33205i > 15000) {
                    k4.b.e(String.format(Locale.US, "exceed %d ms , no scan response received since last time", 15000L));
                    x(false);
                } else if (this.f33204h != null) {
                    k4.b.e("wait to check state:" + this.f33203g);
                    this.f33204h.removeCallbacks(this.f33207k);
                    this.f33204h.postDelayed(this.f33207k, 15000L);
                } else {
                    k4.b.s("mHandler == null");
                }
                return true;
            }
            int i8 = this.f33203g;
            if (i8 == 0 || i8 == 3) {
                k4.b.e("mState == STATE_DISCOVERY_FINISHED | STATE_IDLE");
                if (!z8) {
                    return true;
                }
                k4.b.p("force to stop scan");
            }
            if (this.f33199c.isDiscovering()) {
                k4.b.p("cancelDiscovery");
                this.f33199c.cancelDiscovery();
            }
            this.f33204h.removeCallbacks(this.f33208l);
            if (this.f33200d != null) {
                k4.b.p("stop the le scan");
                this.f33200d.e(null);
                if (!this.f33200d.d(false)) {
                    k4.b.s("scanLeDevice failed");
                    return false;
                }
            } else {
                k4.b.s("mRetkLeScannerCompat is null");
            }
            c(0);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public ScannerPresenter(Context context, Handler handler, ScannerParams scannerParams, h hVar) {
        this.f33197a = false;
        this.f33203g = 0;
        this.f33205i = 0L;
        this.f33206j = new a();
        this.f33207k = new b();
        this.f33208l = new c();
        this.f33209m = new BroadcastReceiver() { // from class: com.realsil.sdk.core.bluetooth.scanner.ScannerPresenter.4

            /* JADX INFO: renamed from: com.realsil.sdk.core.bluetooth.scanner.ScannerPresenter$4$a */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    ScannerPresenter.this.x(false);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String action = intent.getAction();
                if ("android.bluetooth.device.action.FOUND".equals(action) || "android.bluetooth.device.action.CLASS_CHANGED".equals(action) || "android.bluetooth.device.action.NAME_CHANGED".equals(action)) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) 0);
                    if (bluetoothDevice != null) {
                        k4.b.p(String.format("%s %s/%s", action, bluetoothDevice.getName(), bluetoothDevice.toString()));
                    } else {
                        k4.b.p(String.format("%s", action));
                    }
                    ScannerPresenter.this.d(bluetoothDevice, shortExtra, null);
                    return;
                }
                if ("android.bluetooth.adapter.action.DISCOVERY_STARTED".equals(action)) {
                    ScannerPresenter.this.c(2);
                    return;
                }
                if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                    ScannerPresenter.this.c(3);
                    return;
                }
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    k4.b.p(String.format(Locale.US, "[%s] %d -> %d", action, Integer.valueOf(intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1)), Integer.valueOf(intExtra)));
                    if (intExtra == 10 && ScannerPresenter.this.u()) {
                        new Thread(new a()).start();
                    }
                }
            }
        };
        this.f33210n = new d();
        this.f33197a = b4.d.f11317b;
        this.f33198b = context.getApplicationContext();
        if (handler == null) {
            HandlerThread handlerThread = new HandlerThread("ScannerPresenter");
            handlerThread.start();
            this.f33204h = new Handler(handlerThread.getLooper());
        } else {
            this.f33204h = handler;
        }
        this.f33202f = scannerParams;
        this.f33201e = hVar;
        if (hVar == null) {
            k4.b.s("callback is null");
        }
        if (this.f33202f == null) {
            k4.b.e("create new ScannerParams");
            this.f33202f = new ScannerParams();
        }
        BluetoothManager bluetoothManager = (BluetoothManager) this.f33198b.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            this.f33199c = bluetoothManager.getAdapter();
        }
        this.f33200d = new com.realsil.sdk.core.bluetooth.scanner.b(this.f33198b);
    }

    public ScannerPresenter(Context context) {
        this(context, null, null);
    }
}
