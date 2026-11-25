package h4;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.ParcelUuid;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
public class c extends com.realsil.sdk.core.bluetooth.scanner.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BluetoothAdapter.LeScanCallback f34057f;

    public class a implements BluetoothAdapter.LeScanCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i7, byte[] bArr) {
            c.this.c(bluetoothDevice, i7, bArr);
        }
    }

    public c(Context context) {
        super(context);
        this.f34057f = new a();
        k4.b.p("LeScannerV19 init");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007a  */
    @Override // com.realsil.sdk.core.bluetooth.scanner.a
    public boolean i(ScannerParams scannerParams) {
        UUID[] uuidArr;
        if (!super.i(scannerParams)) {
            return false;
        }
        List<CompatScanFilter> listG = scannerParams.g();
        if (listG == null || listG.size() <= 0) {
            uuidArr = null;
        } else {
            k4.b.p("contains " + listG.size() + " filters");
            ArrayList arrayList = new ArrayList();
            for (CompatScanFilter compatScanFilter : listG) {
                k4.b.p(compatScanFilter.toString());
                if (compatScanFilter.k() != null) {
                    arrayList.add(compatScanFilter.k());
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                uuidArr = new UUID[size];
                for (int i7 = 0; i7 < size; i7++) {
                    if (arrayList.get(i7) != null) {
                        uuidArr[i7] = ((ParcelUuid) arrayList.get(i7)).getUuid();
                    }
                }
            } else {
                uuidArr = null;
            }
        }
        return this.f33218b.startLeScan(uuidArr, this.f34057f);
    }

    @Override // com.realsil.sdk.core.bluetooth.scanner.a
    public boolean j() {
        super.j();
        BluetoothAdapter bluetoothAdapter = this.f33218b;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            k4.b.s("BT Adapter is not turned ON");
            return true;
        }
        this.f33218b.stopLeScan(this.f34057f);
        return true;
    }
}
