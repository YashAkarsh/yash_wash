package org.chromium.net;

import android.net.TrafficStats;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Method f39470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f39471b;

    static {
        try {
            f39470a = TrafficStats.class.getMethod("setThreadStatsUid", Integer.TYPE);
            f39471b = TrafficStats.class.getMethod("clearThreadStatsUid", new Class[0]);
        } catch (NoSuchMethodException | SecurityException e8) {
            throw new RuntimeException("Unable to get TrafficStats methods", e8);
        }
    }

    public static void a() {
        try {
            f39471b.invoke(null, new Object[0]);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e8);
        } catch (InvocationTargetException e9) {
            throw new RuntimeException("TrafficStats.clearThreadStatsUid failed", e9);
        }
    }

    public static void b(int i7) {
        try {
            f39470a.invoke(null, Integer.valueOf(i7));
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e8);
        } catch (InvocationTargetException e9) {
            throw new RuntimeException("TrafficStats.setThreadStatsUid failed", e9);
        }
    }
}
