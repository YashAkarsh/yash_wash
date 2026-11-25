package com.haier.uhome.ble.hal.jni;

import com.haier.library.common.util.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f28375a;

    /* JADX INFO: renamed from: com.haier.uhome.ble.hal.jni.a$a, reason: collision with other inner class name */
    private static class C0366a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f28376a = new a();

        private C0366a() {
        }
    }

    public static a a() {
        return C0366a.f28376a;
    }

    public void b() {
        if (this.f28375a.compareAndSet(false, true)) {
            BleHalJNI.init();
        }
    }

    public void c() {
        e3.a.n("BLE", com.haier.uhome.ble.a.f28128b, "onStopSearch", new Object[0]);
        com.haier.uhome.ble.hal.a.a().b();
    }

    private a() {
        this.f28375a = new AtomicBoolean(false);
    }

    public void a(long j7, long j8) {
        e3.a.n("BLE", com.haier.uhome.ble.a.f28128b, "onSearch", new Object[0]);
        com.haier.uhome.ble.hal.a.a().a(j7, j8);
    }

    public void b(String str, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "onDisconnect address = %s,respFunc = %d, ctx = %d", str, Long.valueOf(j7), Long.valueOf(j8));
        com.haier.uhome.ble.hal.a.a().b(str, j7, j8);
    }

    public int c(String str, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "onSetDevConnectStateListener %s-%d-%d", str, Long.valueOf(j7), Long.valueOf(j8));
        com.haier.uhome.ble.hal.a.a().c(str, j7, j8);
        return 0;
    }

    public void a(int i7, String str, String str2, int i8, byte[] bArr, long j7, long j8) {
        BleHalJNI.searchResp(i7, str, str2, i8, bArr, j7, j8);
    }

    private String a(int i7) {
        if (i7 == 1) {
            return "1:STARTED";
        }
        if (i7 == 2) {
            return "2:STOPPED";
        }
        if (i7 == 3) {
            return "3:CANCELED";
        }
        if (i7 == 4) {
            return "4:FOUNDED";
        }
        if (i7 == 5) {
            return "5:START_FAIL";
        }
        return i7 + ":Unknown";
    }

    private String c(int i7) {
        if (i7 == 1) {
            return "1:CLOSED";
        }
        if (i7 == 2) {
            return "2:OPENED";
        }
        if (i7 == 3) {
            return "3:CLOSING";
        }
        if (i7 == 4) {
            return "4:OPENING";
        }
        return i7 + ":UnKnown";
    }

    public void b(int i7, String str, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "devConnectStateResp address = %s,state = %s,func = %s", str, b(i7), Long.valueOf(j7));
        if (str == null) {
            str = "";
        }
        BleHalJNI.devConnectStatusResp(i7, str, j7, j8);
    }

    public void a(String str, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "onConnect address = %s,respFunc = %d, ctx = %d", str, Long.valueOf(j7), Long.valueOf(j8));
        com.haier.uhome.ble.hal.a.a().a(str, j7, j8);
    }

    private String b(int i7) {
        if (i7 == 0) {
            return "0:CONNECTED";
        }
        if (i7 == 1) {
            return "1:DISCONNECTED";
        }
        return i7 + ":UnKnown";
    }

    public void a(int i7, String str, String str2, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "sendConnectResp address = %s, func = %s, code = %d", str, Long.valueOf(j7), Integer.valueOf(i7));
        BleHalJNI.connectResp(i7, str == null ? "" : str, str2 == null ? "" : str2, j7, j8);
    }

    public void b(String str, String str2, String str3, long j7, long j8) {
        e3.a.n("BLE", com.haier.uhome.ble.a.f28128b, "onEnableCharacteristicNotification address = %s,character = %s", str, str3);
        if (0 == j7 && 0 == j8) {
            com.haier.uhome.ble.hal.a.a().a(str, str2, str3);
        } else {
            com.haier.uhome.ble.hal.a.a().b(str, str2, str3, j7, j8);
        }
    }

    public void a(int i7, String str, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "sendDisconnectResp address = %s, func = %s, code = %d", str, Long.valueOf(j7), Integer.valueOf(i7));
        if (str == null) {
            str = "";
        }
        BleHalJNI.disconnectResp(i7, str, j7, j8);
    }

    public void b(String str, String str2, String str3, byte[] bArr, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "characteristicNotificationResp %s (%s) = %s", str, str3, c.o(bArr));
        BleHalJNI.notifyCharacteristicResp(str == null ? "" : str, str2 == null ? "" : str2, str3 == null ? "" : str3, bArr, j7, j8);
    }

    public void a(String str, String str2, String str3, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "onReadCharacteristic address = %s,character = %s,respFunc = %d, ctx = %d", str, str3, Long.valueOf(j7), Long.valueOf(j8));
        com.haier.uhome.ble.hal.a.a().a(str, str2, str3, j7, j8);
    }

    public int b(long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "onRegisterBtStateListener %d-%d", Long.valueOf(j7), Long.valueOf(j8));
        com.haier.uhome.ble.hal.a.a().b(j7, j8);
        return 0;
    }

    public void a(int i7, String str, String str2, String str3, byte[] bArr, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "sendReadResp address = %s,character = %s,func = %s, code = %d, data = %s", str, str3, Long.valueOf(j7), Integer.valueOf(i7), c.o(bArr));
        BleHalJNI.readResp(i7, str == null ? "" : str, str2 == null ? "" : str2, str3 == null ? "" : str3, bArr == null ? new byte[0] : bArr, j7, j8);
    }

    public void a(String str, String str2, String str3, byte[] bArr, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "onWriteCharacteristic address = %s,character = %s,respFunc = %d, ctx = %d, data = %s", str, str3, Long.valueOf(j7), Long.valueOf(j8), c.o(bArr));
        com.haier.uhome.ble.hal.a.a().a(str, str2, str3, bArr, j7, j8);
    }

    public void a(int i7, String str, String str2, String str3, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "sendWriteResp address = %s,character = %s,func = %s, code = %d", str, str3, Long.valueOf(j7), Integer.valueOf(i7));
        BleHalJNI.writeResp(i7, str == null ? "" : str, str2 == null ? "" : str2, str3 == null ? "" : str3, j7, j8);
    }

    public void a(int i7, long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "btStateNotifyResp state = %s,func = %s", c(i7), Long.valueOf(j7));
        BleHalJNI.btStateNotifyResp(i7, j7, j8);
    }
}
