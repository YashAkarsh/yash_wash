package h4;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class g extends com.realsil.sdk.core.bluetooth.scanner.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BluetoothLeScanner f34059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScanCallback f34060g;

    public class a extends ScanCallback {
        public a() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            super.onBatchScanResults(list);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i7) {
            super.onScanFailed(i7);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i7, ScanResult scanResult) {
            super.onScanResult(i7, scanResult);
            ScannerParams scannerParams = g.this.f33220d;
            if (scannerParams != null && scannerParams.l() && Build.VERSION.SDK_INT >= 26 && !scanResult.isConnectable()) {
                if (g.this.f33217a) {
                    k4.b.p("ignore noconnectable device >> " + scanResult.toString());
                    return;
                }
                return;
            }
            if (g.this.f33217a) {
                k4.b.p("onScanResult 2 >> " + scanResult.toString());
            }
            ScanRecord scanRecord = scanResult.getScanRecord();
            g.this.c(scanResult.getDevice(), scanResult.getRssi(), scanRecord != null ? scanRecord.getBytes() : new byte[0]);
        }
    }

    public g(Context context) {
        super(context);
        this.f34060g = new a();
        k4.b.p("LeScannerV21 init");
        BluetoothAdapter bluetoothAdapter = this.f33218b;
        if (bluetoothAdapter != null) {
            this.f34059f = bluetoothAdapter.getBluetoothLeScanner();
        }
        if (this.f34059f == null) {
            k4.b.s("mBluetoothLeScanner == null");
        }
    }

    @Override // com.realsil.sdk.core.bluetooth.scanner.a
    public boolean i(ScannerParams scannerParams) {
        if (!super.i(scannerParams)) {
            k4.b.s("startScan failed");
            return false;
        }
        if (this.f34059f == null) {
            k4.b.e("getBluetoothLeScanner...");
            this.f34059f = this.f33218b.getBluetoothLeScanner();
        }
        if (this.f34059f == null) {
            k4.b.s("mBluetoothLeScanner is null");
            j();
            return false;
        }
        ArrayList arrayList = new ArrayList();
        List<CompatScanFilter> listG = scannerParams.g();
        if (listG != null && listG.size() > 0) {
            k4.b.p("contains " + listG.size() + " filters");
            for (CompatScanFilter compatScanFilter : listG) {
                arrayList.add(new ScanFilter.Builder().setServiceUuid(compatScanFilter.k()).setDeviceAddress(compatScanFilter.b()).setDeviceName(compatScanFilter.d()).setManufacturerData(compatScanFilter.g(), compatScanFilter.e()).build());
                k4.b.p(compatScanFilter.toString());
            }
        }
        ScanSettings.Builder scanMode = new ScanSettings.Builder().setScanMode(2);
        if (Build.VERSION.SDK_INT >= 26) {
            scanMode.setPhy(scannerParams.e()).setLegacy(false);
        }
        try {
            this.f34059f.startScan(arrayList, scanMode.build(), this.f34060g);
            return true;
        } catch (Exception e8) {
            k4.b.h(e8.toString());
            return false;
        }
    }

    @Override // com.realsil.sdk.core.bluetooth.scanner.a
    public boolean j() {
        BluetoothLeScanner bluetoothLeScanner;
        super.j();
        BluetoothAdapter bluetoothAdapter = this.f33218b;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled() || (bluetoothLeScanner = this.f34059f) == null) {
            return true;
        }
        bluetoothLeScanner.stopScan(this.f34060g);
        return true;
    }
}
