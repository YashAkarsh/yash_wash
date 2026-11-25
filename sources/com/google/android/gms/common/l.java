package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.internal.l1;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@com.google.android.gms.common.internal.y
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c1.a
    @Deprecated
    public static final int f15857a = 12451000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c1.a
    @c.m0
    @Deprecated
    public static final String f15858b = "com.google.android.gms";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c1.a
    @c.m0
    public static final String f15859c = "com.google.android.play.games";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c1.a
    @c.m0
    public static final String f15860d = "com.android.vending";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c1.a
    static final int f15861e = 39789;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c1.a
    static final int f15862f = 10436;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f15864h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g1.d0
    static boolean f15865i = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g1.d0
    @c1.a
    static final AtomicBoolean f15863g = new AtomicBoolean();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicBoolean f15866j = new AtomicBoolean();

    @c1.a
    l() {
    }

    @c1.a
    @Deprecated
    public static void a(@c.m0 Context context) {
        if (f15863g.getAndSet(true)) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(f15862f);
            }
        } catch (SecurityException unused) {
        }
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    public static void b() {
        f15866j.set(true);
    }

    @c1.a
    @Deprecated
    public static void c(@c.m0 Context context, int i7) throws i, j {
        int iK = h.i().k(context, i7);
        if (iK != 0) {
            Intent intentE = h.i().e(context, iK, "e");
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(iK);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (intentE != null) {
                throw new j(iK, "Google Play Services not available", intentE);
            }
            throw new i(iK);
        }
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    @Deprecated
    public static int d(@c.m0 Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    @Deprecated
    public static int e(@c.m0 Context context) {
        com.google.android.gms.common.internal.u.q(true);
        return g1.e.a(context, context.getPackageName());
    }

    @c.o0
    @c1.a
    @Deprecated
    public static PendingIntent f(int i7, @c.m0 Context context, int i8) {
        return h.i().f(context, i7, i8);
    }

    @g1.d0
    @c.m0
    @Deprecated
    @c1.a
    public static String g(int i7) {
        return ConnectionResult.x0(i7);
    }

    @c.o0
    @Deprecated
    @c1.a
    @com.google.android.gms.common.internal.y
    public static Intent h(int i7) {
        return h.i().e(null, i7, null);
    }

    @c.o0
    @c1.a
    public static Context i(@c.m0 Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @c.o0
    @c1.a
    public static Resources j(@c.m0 Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    public static boolean k(@c.m0 Context context) {
        try {
            if (!f15865i) {
                PackageInfo packageInfoF = com.google.android.gms.common.wrappers.d.a(context).f("com.google.android.gms", 64);
                m.a(context);
                if (packageInfoF == null || m.f(packageInfoF, false) || !m.f(packageInfoF, true)) {
                    f15864h = false;
                } else {
                    f15864h = true;
                }
            }
        } catch (PackageManager.NameNotFoundException e8) {
            Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e8);
        } finally {
            f15865i = true;
        }
        return f15864h || !g1.l.j();
    }

    @com.google.android.gms.common.internal.l
    @c1.a
    @Deprecated
    public static int l(@c.m0 Context context) {
        return m(context, f15857a);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00de  */
    /* JADX WARN: Code duplicated, block: B:53:0x0110  */
    /* JADX WARN: Code duplicated, block: B:61:0x012c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x012e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @c1.a
    @Deprecated
    public static int m(@c.m0 Context context, int i7) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f15866j.get()) {
            int iA = l1.a(context);
            if (iA == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            }
            if (iA != f15857a) {
                throw new GooglePlayServicesIncorrectManifestValueException(iA);
            }
        }
        boolean z7 = (g1.l.l(context) || g1.l.n(context)) ? false : true;
        com.google.android.gms.common.internal.u.a(i7 >= 0);
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (z7) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused2) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
            }
        } else {
            packageInfo = null;
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            m.a(context);
            if (!m.f(packageInfo2, true)) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
            } else {
                if (!z7) {
                    if (z7) {
                    }
                    if (g1.f0.a(packageInfo2.versionCode) < g1.f0.a(i7)) {
                        applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        }
                        if (applicationInfo.enabled) {
                            return 0;
                        }
                        return 3;
                    }
                    int i8 = packageInfo2.versionCode;
                    StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 82);
                    sb.append("Google Play services out of date for ");
                    sb.append(packageName);
                    sb.append(".  Requires ");
                    sb.append(i7);
                    sb.append(" but found ");
                    sb.append(i8);
                    Log.w("GooglePlayServicesUtil", sb.toString());
                    return 2;
                }
                com.google.android.gms.common.internal.u.k(packageInfo);
                if (!m.f(packageInfo, true)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                } else {
                    if (z7 || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                        if (g1.f0.a(packageInfo2.versionCode) < g1.f0.a(i7)) {
                            applicationInfo = packageInfo2.applicationInfo;
                            if (applicationInfo == null) {
                                try {
                                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                                } catch (PackageManager.NameNotFoundException e8) {
                                    Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e8);
                                    return 1;
                                }
                            }
                            if (applicationInfo.enabled) {
                                return 3;
                            }
                            return 0;
                        }
                        int i9 = packageInfo2.versionCode;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 82);
                        sb2.append("Google Play services out of date for ");
                        sb2.append(packageName);
                        sb2.append(".  Requires ");
                        sb2.append(i7);
                        sb2.append(" but found ");
                        sb2.append(i9);
                        Log.w("GooglePlayServicesUtil", sb2.toString());
                        return 2;
                    }
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                }
            }
            return 9;
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
            return 1;
        }
    }

    @c1.a
    @Deprecated
    public static boolean n(@c.m0 Context context, int i7) {
        return g1.c0.a(context, i7);
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    @Deprecated
    public static boolean o(@c.m0 Context context, int i7) {
        if (i7 == 18) {
            return true;
        }
        if (i7 == 1) {
            return u(context, "com.google.android.gms");
        }
        return false;
    }

    @c1.a
    @com.google.android.gms.common.internal.y
    @Deprecated
    public static boolean p(@c.m0 Context context, int i7) {
        if (i7 == 9) {
            return u(context, "com.android.vending");
        }
        return false;
    }

    @c1.a
    @TargetApi(18)
    public static boolean q(@c.m0 Context context) {
        if (!g1.v.g()) {
            return false;
        }
        Object systemService = context.getSystemService("user");
        com.google.android.gms.common.internal.u.k(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @g1.d0
    @Deprecated
    @c1.a
    @com.google.android.gms.common.internal.y
    public static boolean r(@c.m0 Context context) {
        return g1.l.f(context);
    }

    @c1.a
    @Deprecated
    public static boolean s(int i7) {
        return i7 == 1 || i7 == 2 || i7 == 3 || i7 == 9;
    }

    @c1.a
    @TargetApi(19)
    @Deprecated
    public static boolean t(@c.m0 Context context, int i7, @c.m0 String str) {
        return g1.c0.b(context, i7, str);
    }

    @TargetApi(21)
    static boolean u(Context context, String str) {
        boolean zEquals = str.equals("com.google.android.gms");
        if (g1.v.j()) {
            try {
                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (zEquals) {
                return applicationInfo.enabled;
            }
            return applicationInfo.enabled && !q(context);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }
}
