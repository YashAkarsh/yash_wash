package androidx.core.net;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import c.m0;
import c.o0;
import c.t;
import c.t0;
import c.w0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6065a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6066b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f6067c = 3;

    /* JADX INFO: renamed from: androidx.core.net.a$a, reason: collision with other inner class name */
    @t0(16)
    static class C0066a {
        private C0066a() {
        }

        @w0("android.permission.ACCESS_NETWORK_STATE")
        @t
        static boolean a(ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }

    @t0(24)
    static class b {
        private b() {
        }

        @t
        static int a(ConnectivityManager connectivityManager) {
            return connectivityManager.getRestrictBackgroundStatus();
        }
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    private a() {
    }

    @o0
    @w0("android.permission.ACCESS_NETWORK_STATE")
    @SuppressLint({"ReferencesDeprecated"})
    public static NetworkInfo a(@m0 ConnectivityManager connectivityManager, @m0 Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }

    public static int b(@m0 ConnectivityManager connectivityManager) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.a(connectivityManager);
        }
        return 3;
    }

    @w0("android.permission.ACCESS_NETWORK_STATE")
    public static boolean c(@m0 ConnectivityManager connectivityManager) {
        return C0066a.a(connectivityManager);
    }
}
