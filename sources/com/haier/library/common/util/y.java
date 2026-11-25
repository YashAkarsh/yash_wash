package com.haier.library.common.util;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f26637d = "uSDK_common_share_store";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static y f26638e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f26640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences.Editor f26641c;

    private y(Context context, String str, int i7) {
        this.f26639a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, i7);
        this.f26640b = sharedPreferences;
        this.f26641c = sharedPreferences.edit();
    }

    public static synchronized y a(Context context) {
        if (f26638e == null) {
            f26638e = new y(context.getApplicationContext(), f26637d, 0);
        }
        return f26638e;
    }

    public void b() {
        this.f26641c.clear().commit();
    }

    public void c(String str) {
        this.f26641c.remove(str);
    }

    public void d(String str, float f8) {
        this.f26641c.putFloat(str, f8).commit();
    }

    public void e(String str, int i7) {
        this.f26641c.putInt(str, i7).commit();
    }

    public void f(String str, long j7) {
        this.f26641c.putLong(str, j7).commit();
    }

    public void g(String str, String str2) {
        this.f26641c.putString(str, str2).commit();
    }

    public void h(String str, boolean z7) {
        this.f26641c.putBoolean(str, z7).commit();
    }

    public float i(String str, float f8) {
        return this.f26640b.getFloat(str, f8);
    }

    public int j(String str, int i7) {
        return this.f26640b.getInt(str, i7);
    }

    public long k(String str, long j7) {
        return this.f26640b.getLong(str, j7);
    }

    public String l(String str, String str2) {
        return this.f26640b.getString(str, str2);
    }

    public boolean m(String str, boolean z7) {
        return this.f26640b.getBoolean(str, z7);
    }
}
