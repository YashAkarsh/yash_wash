package com.haier.uhome.control.base.d;

import com.haier.uhome.control.base.api.DeviceStatus;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: com.haier.uhome.control.base.d.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f28980a;

        static {
            int[] iArr = new int[DeviceStatus.values().length];
            f28980a = iArr;
            try {
                iArr[DeviceStatus.STATUS_READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28980a[DeviceStatus.STATUS_CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28980a[DeviceStatus.STATUS_CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28980a[DeviceStatus.STATUS_UNCONNECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28980a[DeviceStatus.STATUS_OFFLINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String a(DeviceStatus deviceStatus) {
        int i7 = AnonymousClass1.f28980a[deviceStatus.ordinal()];
        if (i7 == 1) {
            return "DevReady";
        }
        if (i7 == 2) {
            return "DevConnected";
        }
        if (i7 == 3) {
            return "DevConnecting";
        }
        if (i7 == 4) {
            return "DevUnconnect";
        }
        if (i7 != 5) {
            return null;
        }
        return "DevOffline";
    }
}
