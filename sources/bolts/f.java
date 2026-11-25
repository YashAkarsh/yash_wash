package bolts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f11358a = "al_applink_data";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f11359b = "extras";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f11360c = "target_url";

    public static Bundle a(Intent intent) {
        return intent.getBundleExtra(f11358a);
    }

    public static Bundle b(Intent intent) {
        Bundle bundleA = a(intent);
        if (bundleA == null) {
            return null;
        }
        return bundleA.getBundle(f11359b);
    }

    public static Uri c(Intent intent) {
        String string;
        Bundle bundleA = a(intent);
        return (bundleA == null || (string = bundleA.getString(f11360c)) == null) ? intent.getData() : Uri.parse(string);
    }

    public static Uri d(Context context, Intent intent) {
        String string;
        Bundle bundleA = a(intent);
        if (bundleA == null || (string = bundleA.getString(f11360c)) == null) {
            return null;
        }
        o.d(context, o.f11385h, intent, null);
        return Uri.parse(string);
    }
}
