package com.realsil.sdk.core.bluetooth.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import b4.d;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f33217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothAdapter f33218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f33219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScannerParams f33220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InterfaceC0402a f33221e;

    /* JADX INFO: renamed from: com.realsil.sdk.core.bluetooth.scanner.a$a, reason: collision with other inner class name */
    public interface InterfaceC0402a {
        void a();

        void b();

        void onLeScan(BluetoothDevice bluetoothDevice, int i7, byte[] bArr);
    }

    public a(Context context) {
        this.f33217a = false;
        this.f33217a = d.f11317b;
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        this.f33218b = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
    }

    public void a(UUID[] uuidArr) {
    }

    public boolean b() {
        return this.f33219c;
    }

    public void c(BluetoothDevice bluetoothDevice, int i7, byte[] bArr) {
        InterfaceC0402a interfaceC0402a = this.f33221e;
        if (interfaceC0402a != null) {
            interfaceC0402a.onLeScan(bluetoothDevice, i7, bArr);
        } else {
            k4.b.p("no listeners register");
        }
    }

    public void d() {
        InterfaceC0402a interfaceC0402a = this.f33221e;
        if (interfaceC0402a != null) {
            interfaceC0402a.b();
        } else {
            k4.b.p("no listeners register");
        }
    }

    public void e() {
        InterfaceC0402a interfaceC0402a = this.f33221e;
        if (interfaceC0402a != null) {
            interfaceC0402a.a();
        } else {
            k4.b.p("no listeners register");
        }
    }

    public boolean f(ScannerParams scannerParams, boolean z7) {
        if (!z7) {
            return j();
        }
        if (this.f33218b.isEnabled()) {
            return i(scannerParams);
        }
        k4.b.e("BT Adapter is not enable");
        return false;
    }

    public boolean g(boolean z7) {
        return f(null, z7);
    }

    public void h(InterfaceC0402a interfaceC0402a) {
        this.f33221e = interfaceC0402a;
    }

    public boolean i(ScannerParams scannerParams) {
        BluetoothAdapter bluetoothAdapter = this.f33218b;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            k4.b.s("BT Adapter is not turned ON");
            return false;
        }
        k4.b.p("LeScanner--startScan");
        d();
        this.f33219c = true;
        this.f33220d = scannerParams;
        return true;
    }

    public boolean j() {
        e();
        this.f33219c = false;
        return true;
    }
}
