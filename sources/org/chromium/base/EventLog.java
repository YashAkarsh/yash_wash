package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
public class EventLog {
    @CalledByNative
    public static void writeEvent(int i7, int i8) {
        android.util.EventLog.writeEvent(i7, i8);
    }
}
