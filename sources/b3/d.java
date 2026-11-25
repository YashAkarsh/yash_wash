package b3;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static boolean a(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static String b(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    public static String c() {
        return TimeZone.getDefault().getDisplayName(false, 0);
    }
}
