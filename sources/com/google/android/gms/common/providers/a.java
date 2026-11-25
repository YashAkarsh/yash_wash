package com.google.android.gms.common.providers;

import c.m0;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@Deprecated
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InterfaceC0184a f15876a;

    /* JADX INFO: renamed from: com.google.android.gms.common.providers.a$a, reason: collision with other inner class name */
    public interface InterfaceC0184a {
        @c1.a
        @m0
        @Deprecated
        ScheduledExecutorService a();
    }

    private a() {
    }

    @c1.a
    @m0
    @Deprecated
    public static synchronized InterfaceC0184a a() {
        if (f15876a == null) {
            f15876a = new b();
        }
        return f15876a;
    }
}
