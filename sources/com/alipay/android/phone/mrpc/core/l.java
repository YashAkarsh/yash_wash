package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class l implements ab {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static l f13446b;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ThreadFactory f13447i = new n();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f13448a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ThreadPoolExecutor f13449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f13450d = b.a("android");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f13451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f13452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f13453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13454h;

    private l(Context context) {
        this.f13448a = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f13447i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f13449c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f13448a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    private static final synchronized l b(Context context) {
        l lVar = f13446b;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(context);
        f13446b = lVar2;
        return lVar2;
    }

    public final b a() {
        return this.f13450d;
    }

    public final void c(long j7) {
        this.f13453g += j7;
    }

    public static final l a(Context context) {
        l lVar = f13446b;
        return lVar != null ? lVar : b(context);
    }

    public final void b(long j7) {
        this.f13452f += j7;
        this.f13454h++;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t tVar) {
        if (s.a(this.f13448a)) {
            String str = com.haier.globalwasher.mvp_api.volley.myvolley.d.f24867f + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.f13449c.getActiveCount());
            objArr[1] = Long.valueOf(this.f13449c.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.f13449c.getTaskCount());
            long j7 = this.f13453g;
            objArr[3] = Long.valueOf(j7 == 0 ? 0L : ((this.f13451e * 1000) / j7) >> 10);
            int i7 = this.f13454h;
            objArr[4] = Long.valueOf(i7 != 0 ? this.f13452f / ((long) i7) : 0L);
            objArr[5] = Long.valueOf(this.f13451e);
            objArr[6] = Long.valueOf(this.f13452f);
            objArr[7] = Long.valueOf(this.f13453g);
            objArr[8] = Integer.valueOf(this.f13454h);
            String.format(str, objArr);
        }
        q qVar = new q(this, (o) tVar);
        m mVar = new m(this, qVar, qVar);
        this.f13449c.execute(mVar);
        return mVar;
    }

    public final void a(long j7) {
        this.f13451e += j7;
    }
}
