package com.haier.uhome.ble.hal.a.a.a;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f28197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f28198g;

    public c(String str, String str2, boolean z7, ICallback<Bundle> iCallback) {
        super(iCallback);
        this.f28196e = str;
        this.f28197f = str2;
        this.f28198g = z7;
    }

    private void m() {
        if (a(this.f28196e, this.f28197f, this.f28198g)) {
            k();
        } else {
            a(ErrorConst.ERR_INTERNAL);
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a, com.haier.uhome.ble.hal.a.a.f
    public void a(BluetoothGattDescriptor bluetoothGattDescriptor, int i7) {
        l();
        if (i7 == 0) {
            a(ErrorConst.RET_USDK_OK);
        } else {
            a(ErrorConst.getErrorConstById(i7));
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a
    public void b() {
        int i7 = i();
        if (i7 == 1 || i7 == 4) {
            m();
        } else {
            a(ErrorConst.ERR_INTERNAL);
        }
    }

    public String toString() {
        return "BleNotificationReq{character=" + this.f28197f + '}';
    }
}
