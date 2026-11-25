package org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f39435a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f39436b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f39437c;

    private v() {
    }

    private static void a(StringBuilder sb) {
        sb.append(" Cronet/");
        sb.append(i.b());
    }

    public static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append('/');
        sb.append(d(context));
        sb.append(" (Linux; U; Android ");
        sb.append(Build.VERSION.RELEASE);
        sb.append("; ");
        sb.append(Locale.getDefault().toString());
        String str = Build.MODEL;
        if (str.length() > 0) {
            sb.append("; ");
            sb.append(str);
        }
        String str2 = Build.ID;
        if (str2.length() > 0) {
            sb.append("; Build/");
            sb.append(str2);
        }
        sb.append(com.alipay.sdk.util.j.f13806b);
        a(sb);
        sb.append(')');
        return sb.toString();
    }

    static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        a(sb);
        return sb.toString();
    }

    private static int d(Context context) {
        int i7;
        synchronized (f39435a) {
            if (f39437c == 0) {
                try {
                    f39437c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new IllegalStateException("Cannot determine package version");
                }
            }
            i7 = f39437c;
        }
        return i7;
    }
}
