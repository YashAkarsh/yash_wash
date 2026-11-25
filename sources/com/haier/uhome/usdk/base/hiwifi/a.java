package com.haier.uhome.usdk.base.hiwifi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f31281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f31283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SharedPreferences f31284d;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.base.hiwifi.a$a, reason: collision with other inner class name */
    private static class C0380a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f31285a = new a();

        private C0380a() {
        }
    }

    public a() {
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB != null) {
            a(com.haier.library.common.util.f.w(contextB));
            a(contextB.getSharedPreferences("iot", 0));
        }
    }

    public static a a() {
        return C0380a.f31285a;
    }

    public String b() {
        return "697328247";
    }

    public String c() {
        return "iot-haier";
    }

    public String d() {
        return "srtc97c6f198c5185e8dc272696315dc";
    }

    public String e() {
        return this.f31281a;
    }

    public String f() {
        return this.f31282b;
    }

    public synchronized String g() {
        Map<String, String> map = this.f31283c;
        if (map == null) {
            return null;
        }
        return map.get(this.f31282b);
    }

    public void a(String str) {
        this.f31281a = str;
    }

    public void b(String str) {
        e3.a.e("save router mac <%s>", str);
        this.f31282b = str;
    }

    @SuppressLint({"ApplySharedPref"})
    public synchronized void c(String str) {
        if (this.f31283c == null) {
            this.f31283c = new HashMap();
        }
        if (TextUtils.isEmpty(str)) {
            this.f31283c.remove(this.f31282b);
            this.f31284d.edit().remove(this.f31282b).commit();
        } else {
            this.f31283c.put(this.f31282b, str);
            this.f31284d.edit().putString(this.f31282b, str).commit();
        }
    }

    public void a(SharedPreferences sharedPreferences) {
        this.f31284d = sharedPreferences;
        this.f31283c = sharedPreferences.getAll();
    }
}
