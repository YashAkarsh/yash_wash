package com.haier.library.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f26557a = "yyyy-MM-dd HH:mm:ss.SSS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f26558b = "yyyy-MM-dd HH:mm:ss";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f26559c = "yyyy-MM-dd";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f26560d = "yyyyMMddHHmmss";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ScheduledExecutorService f26561e = new ScheduledThreadPoolExecutor(1, new com.haier.library.common.thread.i.b().b("schedule-timer-%d").h());

    private a0() {
    }

    public static b0 a(long j7, TimeUnit timeUnit, Runnable runnable) {
        return new b0(f26561e.schedule(runnable, j7, timeUnit));
    }

    public static String b() {
        return new SimpleDateFormat(f26557a, Locale.getDefault()).format(new Date());
    }

    public static String c(long j7) {
        return new SimpleDateFormat(f26560d, Locale.getDefault()).format(Long.valueOf(j7));
    }

    public static int d(long j7) {
        try {
            Thread.sleep(j7);
            return 0;
        } catch (InterruptedException e8) {
            e3.a.h("TimeUtil sleep error:%s", e8.getMessage());
            Thread.currentThread().interrupt();
            return -1;
        }
    }

    public static String e() {
        return new SimpleDateFormat(f26559c, Locale.getDefault()).format(new Date());
    }

    public static String f() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
    }
}
