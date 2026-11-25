package y6;

import android.annotation.TargetApi;
import android.view.Window;
import org.chromium.base.annotations.DoNotInline;

/* JADX INFO: loaded from: classes3.dex */
@DoNotInline
@TargetApi(27)
public final class n {
    private n() {
    }

    public static boolean a(Window window) {
        return window.isWideColorGamut();
    }
}
