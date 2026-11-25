package com.google.android.gms.common.providers;

import com.google.android.gms.internal.common.s;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
final class b implements a.InterfaceC0184a {
    b() {
    }

    @Override // com.google.android.gms.common.providers.a.InterfaceC0184a
    public final ScheduledExecutorService a() {
        s.a();
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}
