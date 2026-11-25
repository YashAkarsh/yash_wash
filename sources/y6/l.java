package y6;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.view.Display;
import android.view.View;
import org.chromium.base.annotations.DoNotInline;

/* JADX INFO: loaded from: classes3.dex */
@DoNotInline
@TargetApi(26)
public final class l {
    private l() {
    }

    public static boolean a(PackageManager packageManager) {
        return packageManager.isInstantApp();
    }

    public static boolean b(Configuration configuration) {
        return configuration.isScreenWideColorGamut();
    }

    public static boolean c(Display display) {
        return display.isWideColorGamut();
    }

    public static void d(View view, boolean z7) {
        view.setDefaultFocusHighlightEnabled(z7);
    }
}
