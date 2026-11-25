package com.haier.uhome.ble.hal.a.a;

import android.os.Bundle;
import com.haier.uhome.usdk.base.api.ICallback;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, com.haier.uhome.ble.hal.a.a.a> f28238a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f28239a = new c();

        private a() {
        }
    }

    public static c a() {
        return a.f28239a;
    }

    public void b(String str, ICallback<Bundle> iCallback) {
        a(str).b(iCallback);
    }

    public void c(String str, String str2, String str3, ICallback<Bundle> iCallback) {
        a(str).c(str2, str3, iCallback);
    }

    private c() {
        this.f28238a = new HashMap<>();
    }

    private com.haier.uhome.ble.hal.a.a.a a(String str) {
        com.haier.uhome.ble.hal.a.a.a aVarA = this.f28238a.get(str);
        if (aVarA == null) {
            synchronized (this) {
                aVarA = this.f28238a.get(str);
                if (aVarA == null) {
                    aVarA = com.haier.uhome.ble.hal.a.a.a.a(str);
                    this.f28238a.put(str, aVarA);
                }
            }
        }
        return aVarA;
    }

    public void b(String str, String str2, String str3, byte[] bArr, ICallback<Bundle> iCallback) {
        a(str).b(str2, str3, bArr, iCallback);
    }

    public void b(String str, String str2, String str3, ICallback<Bundle> iCallback) {
        a(str).b(str2, str3, iCallback);
    }

    public void a(String str, ICallback<Bundle> iCallback) {
        a(str).a(iCallback);
    }

    public void a(String str, String str2, String str3, byte[] bArr, ICallback<Bundle> iCallback) {
        a(str).a(str2, str3, bArr, iCallback);
    }

    public void a(String str, String str2, String str3, ICallback<Bundle> iCallback) {
        a(str).a(str2, str3, iCallback);
    }

    public void a(String str, String str2, String str3, String str4, byte[] bArr, ICallback<Bundle> iCallback) {
        a(str).a(str2, str3, str4, bArr, iCallback);
    }

    public void a(String str, String str2, String str3, String str4, ICallback<Bundle> iCallback) {
        a(str).a(str2, str3, str4, iCallback);
    }
}
