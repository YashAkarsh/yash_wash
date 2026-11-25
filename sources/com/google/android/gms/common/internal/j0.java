package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.base.R;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("sCache")
    private static final androidx.collection.i<String, String> f15752a = new androidx.collection.i<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    @GuardedBy("sCache")
    private static Locale f15753b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return com.google.android.gms.common.wrappers.d.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    @c.m0
    public static String c(Context context, int i7) {
        Resources resources = context.getResources();
        if (i7 == 1) {
            return resources.getString(R.string.common_google_play_services_install_button);
        }
        if (i7 != 2) {
            return i7 != 3 ? resources.getString(android.R.string.ok) : resources.getString(R.string.common_google_play_services_enable_button);
        }
        return resources.getString(R.string.common_google_play_services_update_button);
    }

    @c.m0
    public static String d(Context context, int i7) {
        Resources resources = context.getResources();
        String strA = a(context);
        if (i7 == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, strA);
        }
        if (i7 == 2) {
            return g1.l.l(context) ? resources.getString(R.string.common_google_play_services_wear_update_text) : resources.getString(R.string.common_google_play_services_update_text, strA);
        }
        if (i7 == 3) {
            return resources.getString(R.string.common_google_play_services_enable_text, strA);
        }
        if (i7 == 5) {
            return h(context, "common_google_play_services_invalid_account_text", strA);
        }
        if (i7 == 7) {
            return h(context, "common_google_play_services_network_error_text", strA);
        }
        if (i7 == 9) {
            return resources.getString(R.string.common_google_play_services_unsupported_text, strA);
        }
        if (i7 == 20) {
            return h(context, "common_google_play_services_restricted_profile_text", strA);
        }
        switch (i7) {
            case 16:
                return h(context, "common_google_play_services_api_unavailable_text", strA);
            case 17:
                return h(context, "common_google_play_services_sign_in_failed_text", strA);
            case 18:
                return resources.getString(R.string.common_google_play_services_updating_text, strA);
            default:
                return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, strA);
        }
    }

    @c.m0
    public static String e(Context context, int i7) {
        return (i7 == 6 || i7 == 19) ? h(context, "common_google_play_services_resolution_required_text", a(context)) : d(context, i7);
    }

    @c.m0
    public static String f(Context context, int i7) {
        String strI = i7 == 6 ? i(context, "common_google_play_services_resolution_required_title") : g(context, i7);
        return strI == null ? context.getResources().getString(R.string.common_google_play_services_notification_ticker) : strI;
    }

    @c.o0
    public static String g(Context context, int i7) {
        Resources resources = context.getResources();
        switch (i7) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return i(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return i(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i7);
                Log.e("GoogleApiAvailability", sb.toString());
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return i(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return i(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String h(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strI = i(context, str);
        if (strI == null) {
            strI = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strI, str2);
    }

    @c.o0
    private static String i(Context context, String str) {
        androidx.collection.i<String, String> iVar = f15752a;
        synchronized (iVar) {
            Locale localeD = androidx.core.os.f.a(context.getResources().getConfiguration()).d(0);
            if (!localeD.equals(f15753b)) {
                iVar.clear();
                f15753b = localeD;
            }
            String str2 = iVar.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources resourcesJ = com.google.android.gms.common.k.j(context);
            if (resourcesJ == null) {
                return null;
            }
            int identifier = resourcesJ.getIdentifier(str, androidx.constraintlayout.core.motion.utils.w.b.f3030e, "com.google.android.gms");
            if (identifier == 0) {
                Log.w("GoogleApiAvailability", str.length() != 0 ? "Missing resource: ".concat(str) : new String("Missing resource: "));
                return null;
            }
            String string = resourcesJ.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                Log.w("GoogleApiAvailability", str.length() != 0 ? "Got empty resource: ".concat(str) : new String("Got empty resource: "));
                return null;
            }
            iVar.put(str, string);
            return string;
        }
    }
}
