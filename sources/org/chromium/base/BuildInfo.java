package org.chromium.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
public class BuildInfo {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f38616m = "BuildInfo";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f38617n = 128;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static PackageInfo f38618o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static boolean f38619p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f38620q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final /* synthetic */ boolean f38621r = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f38623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f38624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f38625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f38626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f38627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f38628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f38629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f38630i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f38631j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f38632k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f38633l;

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static BuildInfo f38634a = new BuildInfo();

        private b() {
        }
    }

    public static String a() {
        return f38620q;
    }

    public static BuildInfo b() {
        return b.f38634a;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean d() {
        String str = Build.TYPE;
        return "eng".equals(str) || "userdebug".equals(str);
    }

    private static String e(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    public static void f(PackageInfo packageInfo) {
        f38618o = packageInfo;
    }

    public static void g(String str) {
        f38620q = str;
    }

    @CalledByNative
    private static String[] getAll() {
        BuildInfo buildInfoB = b();
        String packageName = o.e().getPackageName();
        String[] strArr = new String[23];
        strArr[0] = Build.BRAND;
        strArr[1] = Build.DEVICE;
        strArr[2] = Build.ID;
        strArr[3] = Build.MANUFACTURER;
        strArr[4] = Build.MODEL;
        strArr[5] = String.valueOf(Build.VERSION.SDK_INT);
        strArr[6] = Build.TYPE;
        strArr[7] = Build.BOARD;
        strArr[8] = packageName;
        strArr[9] = String.valueOf(buildInfoB.f38623b);
        strArr[10] = buildInfoB.f38622a;
        strArr[11] = buildInfoB.f38624c;
        strArr[12] = String.valueOf(buildInfoB.f38625d);
        strArr[13] = buildInfoB.f38626e;
        strArr[14] = buildInfoB.f38630i;
        strArr[15] = buildInfoB.f38628g;
        strArr[16] = buildInfoB.f38627f;
        strArr[17] = buildInfoB.f38629h;
        strArr[18] = f38620q;
        strArr[19] = buildInfoB.f38632k;
        strArr[20] = buildInfoB.f38633l;
        strArr[21] = buildInfoB.f38631j;
        strArr[22] = c() ? "1" : "0";
        return strArr;
    }

    public static boolean h() {
        return o.e().getApplicationInfo().targetSdkVersion >= 29;
    }

    private BuildInfo() {
        f38619p = true;
        try {
            Context contextE = o.e();
            String packageName = contextE.getPackageName();
            PackageManager packageManager = contextE.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            int i7 = packageInfo.versionCode;
            this.f38623b = i7;
            PackageInfo packageInfo2 = f38618o;
            PackageInfo packageInfo3 = null;
            if (packageInfo2 != null) {
                this.f38624c = packageInfo2.packageName;
                this.f38625d = packageInfo2.versionCode;
                this.f38626e = e(packageInfo2.versionName);
                f38618o = null;
            } else {
                this.f38624c = packageName;
                this.f38625d = i7;
                this.f38626e = e(packageInfo.versionName);
            }
            this.f38622a = e(packageManager.getApplicationLabel(packageInfo.applicationInfo));
            this.f38627f = e(packageManager.getInstallerPackageName(this.f38624c));
            try {
                packageInfo3 = packageManager.getPackageInfo("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            this.f38628g = packageInfo3 != null ? String.valueOf(packageInfo3.versionCode) : "gms versionCode not available.";
            String str = "true";
            try {
                packageManager.getPackageInfo("projekt.substratum", 0);
            } catch (PackageManager.NameNotFoundException unused2) {
                str = com.paytm.pgsdk.d.G;
            }
            this.f38632k = str;
            String string = "Not Enabled";
            if (l.f38819g != 0) {
                try {
                    string = o.e().getString(l.f38819g);
                } catch (Exception unused3) {
                    string = "Not found";
                }
            }
            this.f38633l = string;
            this.f38629h = TextUtils.join(", ", Build.SUPPORTED_ABIS);
            this.f38631j = String.format("@%x_%x", Integer.valueOf(this.f38625d), Long.valueOf(packageInfo.lastUpdateTime));
            String str2 = Build.FINGERPRINT;
            this.f38630i = str2.substring(0, Math.min(str2.length(), 128));
        } catch (PackageManager.NameNotFoundException e8) {
            throw new RuntimeException(e8);
        }
    }
}
