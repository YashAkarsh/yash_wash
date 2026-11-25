package com.haier.uhome.ble.hal.a.a.a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements com.haier.uhome.ble.hal.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28164a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final long f28165b = 10000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long f28166c = 5000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final long f28167d = 100;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f28168l = 9527;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.haier.uhome.ble.hal.a.a.d f28169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.haier.uhome.ble.hal.a.a.a f28170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ICallback<Bundle> f28171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f28172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f28173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Bundle f28174j = new Bundle();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.haier.uhome.usdk.base.d.d f28175k = new com.haier.uhome.usdk.base.d.d(f28164a, f28168l);

    public a(ICallback<Bundle> iCallback) {
        this.f28171g = iCallback;
    }

    private void m() {
        com.haier.uhome.usdk.base.d.c.a().a(this);
        this.f28169e.a(this);
    }

    private void n() {
        com.haier.uhome.usdk.base.d.c.a().b(this);
        this.f28169e.b(this);
    }

    public abstract void b();

    public void b(final ErrorConst errorConst) {
        if (this.f28172h) {
            return;
        }
        this.f28172h = true;
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "onResponse req = <%s>  ret = %s. ", toString(), errorConst);
        com.haier.uhome.usdk.base.d.c.a().a(new Runnable() { // from class: com.haier.uhome.ble.hal.a.a.a.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f28235a.c(errorConst);
            }
        });
    }

    public void c() {
        a();
        n();
        b(ErrorConst.getErrorConstById(99));
    }

    boolean d() {
        return this.f28169e.b();
    }

    void e() {
        this.f28169e.h();
    }

    boolean f() {
        return this.f28169e.e();
    }

    String g() {
        return this.f28169e.a();
    }

    void h() {
        this.f28169e.d();
    }

    int i() {
        return this.f28169e.f();
    }

    String j() {
        return this.f28169e.g();
    }

    void k() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "%s start timer hashcode = %d", getClass().getSimpleName(), Integer.valueOf(hashCode()));
        com.haier.uhome.usdk.base.d.c.a().a(this.f28175k, 10000L);
    }

    void l() {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "%s stop timer hashcode = %d", getClass().getSimpleName(), Integer.valueOf(hashCode()));
        com.haier.uhome.usdk.base.d.c.a().d(this.f28175k);
    }

    public void a(com.haier.uhome.ble.hal.a.a.d dVar) {
        this.f28169e = dVar;
    }

    public void a(String str, String str2) {
        this.f28174j.putString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(ErrorConst errorConst) {
        com.haier.uhome.ble.hal.a.a.a aVar;
        try {
            try {
                ICallback<Bundle> iCallback = this.f28171g;
                if (iCallback != null) {
                    if (errorConst == ErrorConst.RET_USDK_OK) {
                        iCallback.onSuccess(this.f28174j);
                    } else {
                        iCallback.onFailure(errorConst.toError());
                    }
                }
                aVar = this.f28170f;
                if (aVar == null) {
                    return;
                }
            } catch (Exception e8) {
                e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "get Exception : %s", e8);
                aVar = this.f28170f;
                if (aVar == null) {
                    return;
                }
            }
            aVar.a(this);
        } catch (Throwable th) {
            com.haier.uhome.ble.hal.a.a.a aVar2 = this.f28170f;
            if (aVar2 != null) {
                aVar2.a(this);
            }
            throw th;
        }
    }

    public void a(String str, byte[] bArr) {
        this.f28174j.putByteArray(str, bArr);
    }

    protected void a() {
        com.haier.uhome.usdk.base.d.c.a().d(this.f28175k);
    }

    boolean b(int i7) {
        return this.f28169e.c(i7);
    }

    public void a(com.haier.uhome.ble.hal.a.a.a aVar) {
        this.f28170f = aVar;
        if (!com.haier.uhome.usdk.base.utils.a.b()) {
            a(ErrorConst.ERR_USDK_NOT_SUPPORT);
        } else if (!com.haier.uhome.usdk.base.utils.a.c()) {
            a(ErrorConst.ERR_USDK_BLE_NOT_OPEN);
        } else {
            m();
            b();
        }
    }

    boolean b(String str, String str2, boolean z7) {
        try {
            return this.f28169e.b(UUID.fromString(str), UUID.fromString(str2), z7);
        } catch (Exception e8) {
            e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "setCharacteristicIndication get Exception : %s", e8);
            return false;
        }
    }

    boolean b(String str, String str2) {
        try {
            return this.f28169e.a(UUID.fromString(str), UUID.fromString(str2));
        } catch (Exception e8) {
            e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "readCharacteristic get Exception : %s", e8);
            return false;
        }
    }

    void a(ErrorConst errorConst) {
        a();
        n();
        b(errorConst);
    }

    boolean b(String str, String str2, byte[] bArr) {
        try {
            return this.f28169e.b(UUID.fromString(str), UUID.fromString(str2), bArr);
        } catch (Exception e8) {
            e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "writeCharacteristicWithNoRsp get Exception : %s", e8);
            return false;
        }
    }

    boolean a(String str, String str2, boolean z7) {
        try {
            return this.f28169e.a(UUID.fromString(str), UUID.fromString(str2), z7);
        } catch (Exception e8) {
            e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "setCharacteristicNotification get Exception : %s", e8);
            return false;
        }
    }

    public void b(com.haier.uhome.usdk.base.d.d dVar) {
        if (dVar.f31263b == f28168l) {
            this.f28173i = true;
            e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "%s invoke timer hashcode = %d", getClass().getSimpleName(), Integer.valueOf(hashCode()));
            h();
        }
    }

    boolean a(String str, String str2, byte[] bArr) {
        try {
            return this.f28169e.a(UUID.fromString(str), UUID.fromString(str2), bArr);
        } catch (Exception e8) {
            e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "writeCharacteristic get Exception : %s", e8);
            return false;
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void b(int i7, int i8) {
        throw new com.haier.uhome.usdk.base.b.c("onMtuChanged");
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void b(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7, byte[] bArr) {
        throw new com.haier.uhome.usdk.base.b.c("onCharacteristicWrite");
    }

    boolean a(String str, String str2, String str3) {
        try {
            return this.f28169e.a(UUID.fromString(str), UUID.fromString(str2), UUID.fromString(str3));
        } catch (Exception e8) {
            e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "readDescriptor get Exception : %s", e8);
            return false;
        }
    }

    boolean a(String str, String str2, String str3, byte[] bArr) {
        try {
            return this.f28169e.a(UUID.fromString(str), UUID.fromString(str2), UUID.fromString(str3), bArr);
        } catch (Exception e8) {
            e3.a.u("BLE", com.haier.uhome.ble.a.f28128b, "writeDescriptor get Exception : %s", e8);
            return false;
        }
    }

    @com.haier.uhome.usdk.base.annotation.d
    public void a(com.haier.uhome.usdk.base.d.d dVar) {
        if (dVar == null || !f28164a.equals(dVar.f31262a)) {
            return;
        }
        b(dVar);
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void a(int i7, int i8) {
        if (2 != i8) {
            a(this.f28173i ? ErrorConst.ERR_USDK_TIMEOUT : ErrorConst.getErrorConstById(i7));
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void a(int i7) {
        throw new com.haier.uhome.usdk.base.b.c("onServicesDiscovered");
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i7, byte[] bArr) {
        throw new com.haier.uhome.usdk.base.b.c("onCharacteristicRead");
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void a(BluetoothGattDescriptor bluetoothGattDescriptor, int i7) {
        throw new com.haier.uhome.usdk.base.b.c("onDescriptorWrite");
    }

    @Override // com.haier.uhome.ble.hal.a.a.f
    public void a(BluetoothGattDescriptor bluetoothGattDescriptor, int i7, byte[] bArr) {
        throw new com.haier.uhome.usdk.base.b.c("onDescriptorRead");
    }
}
