package org.chromium.base;

import android.os.StrictMode;
import java.util.TimeZone;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
@x6.e
class TimezoneUtils {
    private TimezoneUtils() {
    }

    @CalledByNative
    private static String getDefaultTimeZoneId() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String id = TimeZone.getDefault().getID();
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        return id;
    }
}
