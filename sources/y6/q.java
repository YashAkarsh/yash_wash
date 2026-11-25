package y6;

import android.annotation.TargetApi;
import android.net.LinkProperties;
import org.chromium.base.annotations.DoNotInline;

/* JADX INFO: loaded from: classes3.dex */
@DoNotInline
@TargetApi(28)
public final class q {
    private q() {
    }

    public static String a(LinkProperties linkProperties) {
        return linkProperties.getPrivateDnsServerName();
    }

    public static boolean b(LinkProperties linkProperties) {
        return linkProperties.isPrivateDnsActive();
    }
}
