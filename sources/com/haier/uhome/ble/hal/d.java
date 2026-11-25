package com.haier.uhome.ble.hal;

import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.haier.uhome.ble.hal.a.a, com.haier.uhome.ble.hal.a.a.e, com.haier.uhome.ble.hal.a.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.haier.uhome.ble.hal.b f28330a = com.haier.uhome.ble.hal.b.a();

    private static class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f28367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f28368b;

        a(long j7, long j8) {
            this.f28367a = j7;
            this.f28368b = j8;
        }

        private int a(int i7) {
            switch (i7) {
                case 10:
                    return 1;
                case 11:
                    return 4;
                case 12:
                    return 2;
                case 13:
                    return 3;
                default:
                    return 0;
            }
        }

        @Override // com.haier.uhome.ble.hal.g
        public void a(int i7, int i8) {
            e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "IBleStateListener onStateChanged <%d -> %d>", Integer.valueOf(i7), Integer.valueOf(i8));
            com.haier.uhome.ble.hal.jni.a.a().a(a(i8), this.f28367a, this.f28368b);
        }
    }

    private static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f28369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f28370b;

        b(long j7, long j8) {
            this.f28369a = j7;
            this.f28370b = j8;
        }

        private int a(int i7) {
            if (i7 != 2) {
                return i7 != 19 ? 1 : 2;
            }
            return 0;
        }

        @Override // com.haier.uhome.ble.hal.c
        public void a(String str, int i7) {
            e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "IBleConnectStateListener <%s> onConnectState <%d>", str, Integer.valueOf(i7));
            com.haier.uhome.ble.hal.jni.a.a().b(a(i7), str, this.f28369a, this.f28370b);
        }
    }

    d() {
    }

    @Override // com.haier.uhome.ble.hal.a.b.d
    public void a(final long j7, final long j8) {
        this.f28330a.a(new f() { // from class: com.haier.uhome.ble.hal.i
            @Override // com.haier.uhome.ble.hal.f
            public final void onResp(int i7, String str, String str2, int i8, byte[] bArr) {
                d.a(j7, j8, i7, str, str2, i8, bArr);
            }
        });
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void c(String str, String str2, String str3, long j7, long j8) {
        this.f28330a.b(str, str2, str3, new e<Void>() { // from class: com.haier.uhome.ble.hal.d.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "enableIndication onSuccess", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "disableNotification onFailure <%s>", usdkerror);
            }

            @Override // com.haier.uhome.ble.hal.e
            public void a(String str4, String str5, String str6, byte[] bArr) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "enableIndication <%s> onNotify <%s>", str4, str6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(long j7, long j8, int i7, String str, String str2, int i8, byte[] bArr) {
        com.haier.uhome.ble.hal.jni.a.a().a(i7, str, str2, i8, bArr, j7, j8);
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void b(final String str, final long j7, final long j8) {
        this.f28330a.b(str, new ICallback<Void>() { // from class: com.haier.uhome.ble.hal.d.6
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r11) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "disconnect <%s> onSuccess", str);
                com.haier.uhome.ble.hal.jni.a.a().a(0, str, j7, j8);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "disconnect <%s> onFailure <%s>", str, usdkerror);
                com.haier.uhome.ble.hal.jni.a.a().a(usdkerror.getCode(), str, j7, j8);
            }
        });
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void c(String str, long j7, long j8) {
        this.f28330a.a(str, (0 == j7 && 0 == j8) ? null : new b(j7, j8));
    }

    @Override // com.haier.uhome.ble.hal.a.b.d
    public void a() {
        this.f28330a.a(new ICallback<Void>() { // from class: com.haier.uhome.ble.hal.d.1
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "searchStop onSuccess", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "searchStop onFailure <%s>", usdkerror);
            }
        });
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void b(final String str, String str2, final String str3, byte[] bArr, long j7, long j8) {
        this.f28330a.b(str, str2, str3, bArr, new ICallback<Void>() { // from class: com.haier.uhome.ble.hal.d.9
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "writeCharacteristicNoRsp <%s> character <%s> onSuccess", str, str3);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "writeCharacteristicNoRsp <%s> character <%s> onFailure <%s>", str, str3, usdkerror);
            }
        });
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void a(final String str, final long j7, final long j8) {
        this.f28330a.a(str, new ICallback<String>() { // from class: com.haier.uhome.ble.hal.d.5
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str2) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "connect <%s> onSuccess p = <%s>", str, str2);
                com.haier.uhome.ble.hal.jni.a.a().a(0, str, str2, j7, j8);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "connect <%s> onFailure <%s>", str, usdkerror);
                com.haier.uhome.ble.hal.jni.a.a().a(usdkerror.getCode(), str, (String) null, j7, j8);
            }
        });
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void b(String str, String str2, String str3, final long j7, final long j8) {
        this.f28330a.a(str, str2, str3, new e<Void>() { // from class: com.haier.uhome.ble.hal.d.12
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "enableNotification onSuccess", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "enableNotification onFailure <%s>", usdkerror);
            }

            @Override // com.haier.uhome.ble.hal.e
            public void a(String str4, String str5, String str6, byte[] bArr) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "enableNotification <%s> onNotify <%s>", str4, str6);
                com.haier.uhome.ble.hal.jni.a.a().b(str4, str5, str6, bArr, j7, j8);
            }
        });
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void a(final String str, final String str2, final String str3, final long j7, final long j8) {
        this.f28330a.a(str, str2, str3, new ICallback<byte[]>() { // from class: com.haier.uhome.ble.hal.d.7
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(byte[] bArr) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "readCharacteristic <%s> character <%s> onSuccess", str, str3);
                com.haier.uhome.ble.hal.jni.a.a().a(0, str, str2, str3, bArr, j7, j8);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "readCharacteristic <%s> character <%s> onFailure <%s>", str, str3, usdkerror);
                com.haier.uhome.ble.hal.jni.a.a().a(usdkerror.getCode(), str, str2, str3, (byte[]) null, j7, j8);
            }
        });
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void b(String str, String str2, String str3) {
        this.f28330a.c(str, str2, str3, new ICallback<Void>() { // from class: com.haier.uhome.ble.hal.d.4
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "disableIndication onSuccess", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "disableIndication onFailure <%s>", usdkerror);
            }
        });
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void a(final String str, final String str2, final String str3, byte[] bArr, final long j7, final long j8) {
        this.f28330a.a(str, str2, str3, bArr, new ICallback<Void>() { // from class: com.haier.uhome.ble.hal.d.8
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r13) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "writeCharacteristic <%s> character <%s> onSuccess", str, str3);
                com.haier.uhome.ble.hal.jni.a.a().a(0, str, str2, str3, j7, j8);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "writeCharacteristic <%s> character <%s> onFailure <%s>", str, str3, usdkerror);
                com.haier.uhome.ble.hal.jni.a.a().a(usdkerror.getCode(), str, str2, str3, j7, j8);
            }
        });
    }

    @Override // com.haier.uhome.ble.hal.a.a
    public void b(long j7, long j8) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "registerBleStateListener", new Object[0]);
        this.f28330a.a((0 == j7 && 0 == j8) ? null : new a(j7, j8));
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void a(final String str, String str2, String str3, final String str4, long j7, long j8) {
        this.f28330a.a(str, str2, str3, str4, new ICallback<byte[]>() { // from class: com.haier.uhome.ble.hal.d.10
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(byte[] bArr) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "readDescriptor <%s> descriptor <%s> onSuccess", str, str4);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "readDescriptor <%s> descriptor <%s> onFailure <%s>", str, str4, usdkerror);
            }
        });
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void a(final String str, String str2, String str3, final String str4, byte[] bArr, long j7, long j8) {
        this.f28330a.a(str, str2, str3, str4, bArr, new ICallback<byte[]>() { // from class: com.haier.uhome.ble.hal.d.11
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(byte[] bArr2) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "writeDescriptor <%s> descriptor <%s> onSuccess", str, str4);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "writeDescriptor <%s> descriptor <%s> onFailure <%s>", str, str4, usdkerror);
            }
        });
    }

    @Override // com.haier.uhome.ble.hal.a.a.e
    public void a(String str, String str2, String str3) {
        this.f28330a.b(str, str2, str3, new ICallback<Void>() { // from class: com.haier.uhome.ble.hal.d.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "disableNotification onSuccess", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "disableNotification onFailure <%s>", usdkerror);
            }
        });
    }
}
