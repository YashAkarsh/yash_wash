package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import c.m0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5632a = "android.intent.action.CREATE_REMINDER";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5633b = "android.intent.extra.HTML_TEXT";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5634c = "android.intent.extra.START_PLAYBACK";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f5635d = "android.intent.extra.TIME";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5636e = "android.intent.category.LEANBACK_LAUNCHER";

    @t0(15)
    static class a {
        private a() {
        }

        @c.t
        static Intent a(String str, String str2) {
            return Intent.makeMainSelectorActivity(str, str2);
        }
    }

    private l() {
    }

    @m0
    public static Intent a(@m0 Context context, @m0 String str) {
        if (!v.a(context.getPackageManager())) {
            throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", str, null));
        }
        Intent data = new Intent(v.f5767b).setData(Uri.fromParts("package", str, null));
        return i7 >= 30 ? data : data.setPackage((String) androidx.core.util.w.l(v.b(context.getPackageManager())));
    }

    @m0
    public static Intent b(@m0 String str, @m0 String str2) {
        return a.a(str, str2);
    }
}
