package com.haier.uhome.ble.hal.a.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.ParcelUuid;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ParcelUuid f28261e = ParcelUuid.fromString("0000ff01-0000-1000-8000-00805f9b34fb");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f28262f = 85;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f28263g = 43;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f28264h = 2345;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f28265i = "^C(11|38|hipsea-BLE)|(CFC-0[1-5])$";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScanSettings f28266d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ScanCallback f28267j = new ScanCallback() { // from class: com.haier.uhome.ble.hal.a.b.b.1
        void a(ScanResult scanResult) {
            if (scanResult == null) {
                e3.a.e("postScanResult result is null", new Object[0]);
                return;
            }
            ScanRecord scanRecord = scanResult.getScanRecord();
            if (scanRecord == null) {
                e3.a.e("postScanResult record is null", new Object[0]);
                return;
            }
            try {
                byte[] serviceData = scanRecord.getServiceData(b.f28261e);
                byte[] manufacturerSpecificData = scanRecord.getManufacturerSpecificData(b.f28264h);
                String deviceName = scanRecord.getDeviceName();
                if (b.this.a(serviceData) || b.this.b(manufacturerSpecificData) || b.this.a(deviceName)) {
                    b.this.a(scanResult.getDevice().getAddress(), scanRecord.getDeviceName(), scanResult.getRssi(), scanRecord.getBytes());
                }
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            Iterator<ScanResult> it = list.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i7) {
            if (1 != i7) {
                b.this.a(i7);
            } else {
                b.this.c();
                b.this.b();
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i7, ScanResult scanResult) {
            a(scanResult);
        }
    };

    b() {
        ScanSettings.Builder scanMode = new ScanSettings.Builder().setScanMode(2);
        scanMode.setCallbackType(1);
        this.f28266d = scanMode.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(byte[] bArr) {
        return bArr != null;
    }

    @Override // com.haier.uhome.ble.hal.a.b.a
    protected boolean c() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "BleScannerImplLP stopScanInternal", new Object[0]);
        BluetoothAdapter bluetoothAdapterA = com.haier.uhome.usdk.base.utils.a.a();
        if (bluetoothAdapterA == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "BleScannerImplLP stopScanInternal,adapter is null", new Object[0]);
            return false;
        }
        try {
            BluetoothLeScanner bluetoothLeScanner = bluetoothAdapterA.getBluetoothLeScanner();
            if (bluetoothLeScanner == null) {
                e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "BleScannerImplLP stopScanInternal,scanner is null", new Object[0]);
                return false;
            }
            bluetoothLeScanner.stopScan(this.f28267j);
            e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "BleScannerImplLP stopScanInternal success !", new Object[0]);
            return true;
        } catch (Exception e8) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "BleScannerImplLP stopScanInternal failed , %s", e8.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(byte[] bArr) {
        return bArr != null && bArr.length >= 2 && f28262f == bArr[0] && f28263g == bArr[1];
    }

    @Override // com.haier.uhome.ble.hal.a.b.a
    protected boolean b() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "BleScannerImplLP startScanInternal", new Object[0]);
        BluetoothAdapter bluetoothAdapterA = com.haier.uhome.usdk.base.utils.a.a();
        if (bluetoothAdapterA == null) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "BleScannerImplLP startScanInternal,adapter is null", new Object[0]);
            return false;
        }
        try {
            BluetoothLeScanner bluetoothLeScanner = bluetoothAdapterA.getBluetoothLeScanner();
            if (bluetoothLeScanner == null) {
                e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "BleScannerImplLP startScanInternal,scanner is null", new Object[0]);
                return false;
            }
            bluetoothLeScanner.startScan((List<ScanFilter>) null, this.f28266d, this.f28267j);
            e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "BleScannerImplLP startScanInternal success !", new Object[0]);
            return true;
        } catch (Exception e8) {
            e3.a.f("BLE", com.haier.uhome.ble.a.f28128b, "BleScannerImplLP startScanInternal failed , %s", e8.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (com.haier.library.common.util.c.j(str)) {
            return false;
        }
        return str.matches(f28265i);
    }
}
