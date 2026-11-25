package t4;

import android.content.Context;
import android.os.ParcelUuid;
import c.m0;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.ScannerPresenter;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import h4.h;
import h4.j;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f40379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScannerParams f40380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScannerPresenter f40381c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t4.a f40383e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f40382d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f40384f = new a();

    public class a extends h {
        public a() {
        }

        @Override // h4.h
        public void b(h4.b bVar) {
            super.b(bVar);
            k4.b.p("onNewDevice scanType = " + c.this.f40382d);
            j jVar = bVar.f34054h;
            k4.b.p("onNewDevice bluetoothDevice address = " + bVar.f34047a.getAddress());
            if (jVar.j() == null) {
                return;
            }
            if (c.this.f40382d != 0) {
                if (c.this.f40382d != 1) {
                    if (c.this.f40383e != null) {
                        c.this.f40383e.onBroadcastDeviceFound(bVar);
                        return;
                    }
                    return;
                }
                byte[] bArrI = jVar.i(new ParcelUuid(q4.a.f40118o));
                if (bArrI == null) {
                    return;
                }
                k4.b.p("UnProvision Device UUID+OOB is = " + m4.a.b(bArrI));
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrI, 0, 16);
                k4.b.p("UnProvision Device UUID is = " + m4.a.b(bArrCopyOfRange));
                if (c.this.f40383e != null) {
                    c.this.f40383e.onProvDeviceFound(bVar, bArrCopyOfRange);
                    return;
                }
                return;
            }
            byte[] bArrI2 = jVar.i(new ParcelUuid(q4.a.f40121r));
            if (bArrI2 == null || bArrI2.length < 9) {
                return;
            }
            if (n4.b.F().I() != null) {
                k4.b.p(String.format("proxy device mScanFilter.MeshPreferences.getNetIdForHome()=%s", m4.a.a(n4.b.F().I())));
            }
            if (bArrI2.length != 9) {
                if (bArrI2.length == 17) {
                    byte b8 = bArrI2[0];
                    byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArrI2, 1, 9);
                    byte[] bArrCopyOfRange3 = Arrays.copyOfRange(bArrI2, 9, 17);
                    k4.b.p(String.format("find identity device: networkType=0x%02X, mHash=%s, mRandom=%s", Byte.valueOf(b8), m4.a.a(bArrCopyOfRange2), m4.a.a(bArrCopyOfRange3)));
                    if (c.this.f40383e != null) {
                        c.this.f40383e.onIdentityDeviceFound(bVar, bArrCopyOfRange2, bArrCopyOfRange3);
                        return;
                    }
                    return;
                }
                return;
            }
            byte b9 = bArrI2[0];
            byte[] bArrCopyOfRange4 = Arrays.copyOfRange(bArrI2, 1, 9);
            if (n4.b.F().I() != null && !Arrays.equals(n4.b.F().I(), bArrCopyOfRange4)) {
                k4.b.p(String.format("ignore proxy device: networkType=0x%02X, networkId=%s", Byte.valueOf(b9), m4.a.a(bArrCopyOfRange4)));
                return;
            }
            k4.b.p(String.format("find proxy device: networkType=0x%02X, networkId=%s", Byte.valueOf(b9), m4.a.a(bArrCopyOfRange4)));
            if (c.this.f40383e != null) {
                c.this.f40383e.onProxyDeviceFound(bVar, bArrCopyOfRange4);
            }
        }

        @Override // h4.h
        public void c(int i7) {
            super.c(i7);
            k4.b.p("onScanStateChanged i = " + i7);
            boolean z7 = i7 == 2;
            if (c.this.f40383e != null) {
                c.this.f40383e.onScanStateChanged(z7);
            }
        }
    }

    public c(Context context, long j7) {
        this.f40379a = context;
        new b.a().a();
        ScannerParams scannerParams = new ScannerParams(17);
        this.f40380b = scannerParams;
        scannerParams.F(15000L);
        this.f40380b.s(true);
        this.f40380b.t(j7);
        ScannerPresenter scannerPresenter = new ScannerPresenter(this.f40379a, this.f40380b, this.f40384f);
        this.f40381c = scannerPresenter;
        scannerPresenter.q();
    }

    public void c() {
        k4.b.s("onDestory()");
        ScannerPresenter scannerPresenter = this.f40381c;
        if (scannerPresenter != null) {
            scannerPresenter.v();
        }
    }

    public boolean d(int i7, t4.a aVar) {
        this.f40382d = i7;
        this.f40383e = aVar;
        ArrayList arrayList = new ArrayList();
        if (i7 == 1) {
            k4.b.e("ENTER TO SCAN_PROV");
            arrayList.add(new CompatScanFilter.b().h(new ParcelUuid(q4.a.f40118o)).a());
        } else if (i7 == 0) {
            k4.b.e("ENTER TO SCAN_PROXY");
            arrayList.add(new CompatScanFilter.b().h(new ParcelUuid(q4.a.f40121r)).a());
        } else if (i7 == 2) {
            k4.b.p("ENTER TO SCAN_BROADCAST_FIRST");
        }
        this.f40380b.B(arrayList);
        this.f40381c.D(this.f40380b);
        return this.f40381c.x(true);
    }

    public boolean e(t4.a aVar) {
        k4.b.e("scanProxy scanType = " + this.f40382d);
        return d(this.f40382d, aVar);
    }

    public boolean f(t4.a aVar) {
        k4.b.e("scanProv");
        return d(1, aVar);
    }

    public boolean g(t4.a aVar) {
        k4.b.e("scanProxy");
        return d(0, aVar);
    }

    public void h(@m0 b bVar) {
        this.f40382d = bVar.a();
    }

    public boolean i() {
        this.f40383e = null;
        this.f40380b.s(false);
        this.f40381c.D(this.f40380b);
        return this.f40381c.x(false);
    }
}
