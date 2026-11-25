package com.haier.uhome.ble.hal.a.a.a;

import android.os.Bundle;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f28204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f28207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f28209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ICallback<Bundle> f28210g;

    public enum a {
        SEARCH,
        SEARCH_STOP,
        CONNECT,
        DISCONNECT,
        READ_CHARACTERISTIC,
        WRITE_CHARACTERISTIC,
        WRITE_CHARACTERISTIC_NO_RSP,
        READ_DESCRIPTOR,
        WRITE_DESCRIPTOR,
        ENABLE_NOTIFICATION,
        ENABLE_INDICATION,
        DISABLE_NOTIFICATION,
        DISABLE_INDICATION
    }

    private f(a aVar, ICallback<Bundle> iCallback) {
        this(aVar, null, null, null, iCallback);
    }

    public static f a(ICallback<Bundle> iCallback) {
        return new f(a.SEARCH, iCallback);
    }

    public static f b(ICallback<Bundle> iCallback) {
        return new f(a.SEARCH_STOP, iCallback);
    }

    public static f c(String str, String str2, String str3, ICallback<Bundle> iCallback) {
        return new f(a.ENABLE_INDICATION, str, str2, str3, iCallback);
    }

    public static f d(String str, String str2, String str3, ICallback<Bundle> iCallback) {
        return new f(a.DISABLE_NOTIFICATION, str, str2, str3, iCallback);
    }

    public static f e(String str, String str2, String str3, ICallback<Bundle> iCallback) {
        return new f(a.DISABLE_INDICATION, str, str2, str3, iCallback);
    }

    public byte[] f() {
        return this.f28209f;
    }

    public ICallback<Bundle> g() {
        return this.f28210g;
    }

    public String toString() {
        return "BleRequestMode{type=" + this.f28204a + ", address=" + this.f28205b + ", service=" + this.f28206c + ", character=" + this.f28207d + ", descriptor=" + this.f28208e + '}';
    }

    private f(a aVar, String str, String str2, String str3, ICallback<Bundle> iCallback) {
        this(aVar, str, str2, str3, null, null, iCallback);
    }

    public static f a(String str, ICallback<Bundle> iCallback) {
        return new f(a.CONNECT, str, null, null, iCallback);
    }

    public static f b(String str, ICallback<Bundle> iCallback) {
        return new f(a.DISCONNECT, str, null, null, iCallback);
    }

    public String c() {
        return this.f28206c;
    }

    public String d() {
        return this.f28207d;
    }

    public String e() {
        return this.f28208e;
    }

    private f(a aVar, String str, String str2, String str3, byte[] bArr, ICallback<Bundle> iCallback) {
        this(aVar, str, str2, str3, null, bArr, iCallback);
    }

    public static f a(String str, String str2, String str3, ICallback<Bundle> iCallback) {
        return new f(a.READ_CHARACTERISTIC, str, str2, str3, iCallback);
    }

    public static f b(String str, String str2, String str3, byte[] bArr, ICallback<Bundle> iCallback) {
        return new f(a.WRITE_CHARACTERISTIC_NO_RSP, str, str2, str3, bArr, iCallback);
    }

    private f(a aVar, String str, String str2, String str3, String str4, byte[] bArr, ICallback<Bundle> iCallback) {
        e3.a.d("BLE", com.haier.uhome.ble.a.f28128b, "BleRequestMode init(%s,%s)", aVar, str);
        this.f28204a = aVar;
        this.f28205b = str;
        this.f28206c = str2;
        this.f28207d = str3;
        this.f28208e = str4;
        this.f28209f = bArr;
        this.f28210g = iCallback;
    }

    public static f a(String str, String str2, String str3, byte[] bArr, ICallback<Bundle> iCallback) {
        return new f(a.WRITE_CHARACTERISTIC, str, str2, str3, bArr, iCallback);
    }

    public static f b(String str, String str2, String str3, ICallback<Bundle> iCallback) {
        return new f(a.ENABLE_NOTIFICATION, str, str2, str3, iCallback);
    }

    public static f a(String str, String str2, String str3, String str4, ICallback<Bundle> iCallback) {
        return new f(a.READ_DESCRIPTOR, str, str2, str3, str4, null, iCallback);
    }

    public String b() {
        return this.f28205b;
    }

    public static f a(String str, String str2, String str3, String str4, byte[] bArr, ICallback<Bundle> iCallback) {
        return new f(a.WRITE_CHARACTERISTIC, str, str2, str3, str4, bArr, iCallback);
    }

    public a a() {
        return this.f28204a;
    }
}
