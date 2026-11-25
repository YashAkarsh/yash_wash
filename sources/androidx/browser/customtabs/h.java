package androidx.browser.customtabs;

import android.content.Context;
import android.net.Uri;
import androidx.core.app.r;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2210a = "android.support.customtabs.extra.LAUNCH_AS_TRUSTED_WEB_ACTIVITY";

    private h() {
    }

    public static void a(@m0 Context context, @m0 c cVar, @m0 Uri uri) {
        if (r.a(cVar.f2190a.getExtras(), c.f2167d) == null) {
            throw new IllegalArgumentException("Given CustomTabsIntent should be associated with a valid CustomTabsSession");
        }
        cVar.f2190a.putExtra(f2210a, true);
        cVar.b(context, uri);
    }
}
