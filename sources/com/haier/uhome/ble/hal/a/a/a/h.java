package com.haier.uhome.ble.hal.a.a.a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Bundle;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public class h extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f28229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f28230g;

    public h(String str, String str2, byte[] bArr, ICallback<Bundle> iCallback) {
        super(iCallback);
        this.f28228e = str;
        this.f28229f = str2;
        this.f28230g = bArr;
    }

    private void m() {
        if (a(this.f28228e, this.f28229f, this.f28230g)) {
            k();
        } else {
            a(ErrorConst.ERR_INTERNAL);
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a
    public synchronized void b() {
        int i7 = i();
        if (i7 == 1 || i7 == 4) {
            m();
        } else {
            a(ErrorConst.ERR_INTERNAL);
        }
    }

    public String toString() {
        return "BleWriteCharacterReq{service=" + this.f28228e + ", character=" + this.f28229f + '}';
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a, com.haier.uhome.ble.hal.a.a.f
    public synchronized void b(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7, byte[] bArr) {
        l();
        if (i7 == 0) {
            a(ErrorConst.RET_USDK_OK);
        } else {
            a(ErrorConst.getErrorConstById(i7));
        }
    }
}
