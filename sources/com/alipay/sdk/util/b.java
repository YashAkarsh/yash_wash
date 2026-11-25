package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f13767d = "00:00:00:00:00:00";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static b f13768e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13771c;

    private b(Context context) {
        try {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                f(telephonyManager.getDeviceId());
                c(telephonyManager.getSubscriberId());
                String macAddress = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
                this.f13771c = macAddress;
                if (!TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (Exception e8) {
                e8.printStackTrace();
                if (!TextUtils.isEmpty(this.f13771c)) {
                    return;
                }
            }
            this.f13771c = f13767d;
        } catch (Throwable th) {
            if (TextUtils.isEmpty(this.f13771c)) {
                this.f13771c = f13767d;
            }
            throw th;
        }
    }

    public static b a(Context context) {
        if (f13768e == null) {
            f13768e = new b(context);
        }
        return f13768e;
    }

    public static e d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
                return (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) ? e.NONE : e.WIFI;
            }
            return e.b(activeNetworkInfo.getSubtype());
        } catch (Exception unused) {
            return e.NONE;
        }
    }

    public static String h(Context context) {
        return a(context).g().substring(0, 8);
    }

    public static String j(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f13769a)) {
            this.f13769a = "000000000000000";
        }
        return this.f13769a;
    }

    public void c(String str) {
        if (str != null) {
            str = (str + "000000000000000").substring(0, 15);
        }
        this.f13769a = str;
    }

    public String e() {
        if (TextUtils.isEmpty(this.f13770b)) {
            this.f13770b = "000000000000000";
        }
        return this.f13770b;
    }

    public void f(String str) {
        if (str != null) {
            byte[] bytes = str.getBytes();
            for (int i7 = 0; i7 < bytes.length; i7++) {
                byte b8 = bytes[i7];
                if (b8 < 48 || b8 > 57) {
                    bytes[i7] = 48;
                }
            }
            str = (new String(bytes) + "000000000000000").substring(0, 15);
        }
        this.f13770b = str;
    }

    public String g() {
        String str = e() + "|";
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return str + "000000000000000";
        }
        return str + strB;
    }

    public String i() {
        return this.f13771c;
    }
}
