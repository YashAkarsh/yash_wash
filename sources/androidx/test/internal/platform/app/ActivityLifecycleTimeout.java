package androidx.test.internal.platform.app;

import androidx.test.internal.platform.util.InstrumentationParameterUtil;

/* JADX INFO: loaded from: classes.dex */
public class ActivityLifecycleTimeout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9918a = "activityLifecycleChangeTimeoutMillis";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f9919b = 45000;

    public static long a() {
        return InstrumentationParameterUtil.a(f9918a, 45000L);
    }
}
