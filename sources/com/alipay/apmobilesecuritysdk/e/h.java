package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13522a = "";

    public static long a(Context context) {
        String strA = q0.a.a(context, "vkeyid_settings", "update_time_interval");
        if (!o0.a.g(strA)) {
            return DateUtils.MILLIS_PER_DAY;
        }
        try {
            return Long.parseLong(strA);
        } catch (Exception unused) {
            return DateUtils.MILLIS_PER_DAY;
        }
    }

    public static String b(Context context) {
        return q0.a.a(context, "vkeyid_settings", "last_apdid_env");
    }

    public static void c(Context context, String str) {
        a(context, "last_apdid_env", str);
    }

    public static String d(Context context) {
        return q0.a.a(context, "vkeyid_settings", "dynamic_key");
    }

    public static String e(Context context) {
        return q0.a.a(context, "vkeyid_settings", "apse_degrade");
    }

    public static String f(Context context) {
        String str;
        SharedPreferences.Editor editorEdit;
        synchronized (h.class) {
            if (o0.a.d(f13522a)) {
                String strA = q0.e.a(context, "alipay_vkey_random", "random", "");
                f13522a = strA;
                if (o0.a.d(strA)) {
                    String strA2 = p0.b.a(UUID.randomUUID().toString());
                    f13522a = strA2;
                    if (strA2 != null && (editorEdit = context.getSharedPreferences("alipay_vkey_random", 0).edit()) != null) {
                        editorEdit.putString("random", strA2);
                        editorEdit.commit();
                    }
                }
            }
            str = f13522a;
        }
        return str;
    }

    public static void g(Context context, String str) {
        a(context, "apse_degrade", str);
    }

    public static long h(Context context, String str) {
        try {
            String strA = q0.a.a(context, "vkeyid_settings", "vkey_valid" + str);
            if (o0.a.d(strA)) {
                return 0L;
            }
            return Long.parseLong(strA);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static void a(Context context, String str) {
        a(context, "update_time_interval", str);
    }

    public static void b(Context context, String str) {
        a(context, "last_machine_boot_time", str);
    }

    public static boolean c(Context context) {
        String strA = q0.a.a(context, "vkeyid_settings", "log_switch");
        return strA != null && "1".equals(strA);
    }

    public static void d(Context context, String str) {
        a(context, "agent_switch", str);
    }

    public static void e(Context context, String str) {
        a(context, "dynamic_key", str);
    }

    public static void f(Context context, String str) {
        a(context, "webrtc_url", str);
    }

    public static void a(Context context, String str, long j7) {
        q0.a.b(context, "vkeyid_settings", "vkey_valid" + str, String.valueOf(j7));
    }

    private static void a(Context context, String str, String str2) {
        q0.a.b(context, "vkeyid_settings", str, str2);
    }

    public static void a(Context context, boolean z7) {
        a(context, "log_switch", z7 ? "1" : "0");
    }
}
