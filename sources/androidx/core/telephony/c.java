package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import c.m0;
import c.o0;
import c.t;
import c.t0;
import c.w0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f6217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f6218b;

    @t0(23)
    private static class a {
        private a() {
        }

        @o0
        @w0("android.permission.READ_PHONE_STATE")
        @SuppressLint({"MissingPermission"})
        @t
        static String a(TelephonyManager telephonyManager, int i7) {
            return telephonyManager.getDeviceId(i7);
        }
    }

    @t0(26)
    private static class b {
        private b() {
        }

        @o0
        @w0("android.permission.READ_PHONE_STATE")
        @SuppressLint({"MissingPermission"})
        @t
        static String a(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    /* JADX INFO: renamed from: androidx.core.telephony.c$c, reason: collision with other inner class name */
    @t0(30)
    private static class C0071c {
        private C0071c() {
        }

        @t
        static int a(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }

    private c() {
    }

    @o0
    @w0("android.permission.READ_PHONE_STATE")
    @SuppressLint({"MissingPermission"})
    public static String a(@m0 TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 26) {
            return b.a(telephonyManager);
        }
        int iB = b(telephonyManager);
        return (iB == Integer.MAX_VALUE || iB == -1) ? telephonyManager.getDeviceId() : a.a(telephonyManager, androidx.core.telephony.b.a(iB));
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int b(@m0 TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 30) {
            return C0071c.a(telephonyManager);
        }
        try {
            if (f6218b == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);
                f6218b = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Integer num = (Integer) f6218b.invoke(telephonyManager, new Object[0]);
            if (num == null || num.intValue() == -1) {
                return Integer.MAX_VALUE;
            }
            return num.intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return Integer.MAX_VALUE;
        }
    }
}
