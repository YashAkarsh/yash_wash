package com.haier.uhome.ble.hal.a.a.a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Bundle;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f28200f;

    public d(String str, String str2, ICallback<Bundle> iCallback) {
        super(iCallback);
        this.f28199e = str;
        this.f28200f = str2;
    }

    private void m() {
        if (b(this.f28199e, this.f28200f)) {
            k();
        } else {
            a(ErrorConst.ERR_INTERNAL);
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a, com.haier.uhome.ble.hal.a.a.f
    public synchronized void a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7, byte[] bArr) {
        l();
        if (i7 == 0) {
            a(com.haier.uhome.ble.a.f28147u, bArr);
            a(ErrorConst.RET_USDK_OK);
        } else {
            a(ErrorConst.getErrorConstById(i7));
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
        return "BleReadCharacterReq{service=" + this.f28199e + ", character=" + this.f28200f + '}';
    }
}
