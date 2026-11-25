package com.haier.uhome.ble.hal.jni;

/* JADX INFO: loaded from: classes2.dex */
public final class BleHalJNI {
    private BleHalJNI() {
    }

    public static native void btStateNotifyResp(int i7, long j7, long j8);

    public static native void connectResp(int i7, String str, String str2, long j7, long j8);

    public static native void devConnectStatusResp(int i7, String str, long j7, long j8);

    public static native void disconnectResp(int i7, String str, long j7, long j8);

    public static void enableBtStatusListener(long j7, long j8) {
        a.a().b(j7, j8);
    }

    public static void enableCharacteristicNotification(String str, String str2, String str3, long j7, long j8) {
        a.a().b(str, str2, str3, j7, j8);
    }

    public static native void init();

    public static native void notifyCharacteristicResp(String str, String str2, String str3, byte[] bArr, long j7, long j8);

    public static void onConnect(String str, long j7, long j8) {
        a.a().a(str, j7, j8);
    }

    public static void onDisconnect(String str, long j7, long j8) {
        a.a().b(str, j7, j8);
    }

    public static void onGattRead(String str, String str2, String str3, long j7, long j8) {
        a.a().a(str, str2, str3, j7, j8);
    }

    public static void onGattWrite(String str, String str2, String str3, byte[] bArr, long j7, long j8) {
        a.a().a(str, str2, str3, bArr, j7, j8);
    }

    public static void onSearch(long j7, long j8) {
        a.a().a(j7, j8);
    }

    public static int onSetDevConnectStatusListener(String str, long j7, long j8) {
        return a.a().c(str, j7, j8);
    }

    public static void onStopSearch() {
        a.a().c();
    }

    public static native void readResp(int i7, String str, String str2, String str3, byte[] bArr, long j7, long j8);

    public static native void searchResp(int i7, String str, String str2, int i8, byte[] bArr, long j7, long j8);

    public static native void writeResp(int i7, String str, String str2, String str3, long j7, long j8);
}
