package com.haier.library.sumhttp.plugin;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l extends Thread {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f27960c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Handler f27961d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final a f27962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final b f27963b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f27964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f27965f;

    public l(a aVar, b bVar) {
        this(aVar, bVar, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i7, String str) {
        this.f27963b.a(i7, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(Object obj) {
        this.f27962a.a(obj);
    }

    protected abstract h b();

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        h hVarB;
        while (!isInterrupted() && this.f27965f) {
            try {
                try {
                    hVarB = b();
                } catch (Throwable th) {
                    e3.a.e("on doWorking error!", new Object[0]);
                    th.printStackTrace();
                    hVarB = null;
                }
                if (hVarB != null && this.f27965f) {
                    int iA = hVarB.a();
                    String strB = hVarB.b();
                    if (10002 == iA) {
                        e3.a.e("正常失败，直接结束  message:" + strB, new Object[0]);
                        a(iA, strB);
                        return;
                    }
                    if (200 == iA) {
                        e3.a.e("成功，直接结束", new Object[0]);
                        a(hVarB.c());
                        return;
                    } else if (this.f27965f) {
                        e3.a.e("请求异常  %d %s  %d秒后重试", Integer.valueOf(iA), strB, Long.valueOf(this.f27964e / 1000));
                        Thread.sleep(this.f27964e);
                    }
                }
                e3.a.e("resp is null!", new Object[0]);
                a(h.f27944a, "连接超时！");
                return;
            } catch (InterruptedException unused) {
            }
        }
        e3.a.e("连接超时", new Object[0]);
        a(h.f27944a, "连接超时！");
    }

    public l(a aVar, b bVar, long j7) {
        this.f27962a = aVar;
        this.f27963b = bVar;
        this.f27964e = j7;
        this.f27965f = true;
    }

    public void a(boolean z7) {
        this.f27965f = z7;
    }

    protected void a(final Object obj) {
        if (this.f27962a == null) {
            return;
        }
        f27961d.post(new Runnable() { // from class: com.haier.library.sumhttp.plugin.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f27955a.d(obj);
            }
        });
    }

    protected void a(final int i7, final String str) {
        if (this.f27963b == null) {
            return;
        }
        f27961d.post(new Runnable() { // from class: com.haier.library.sumhttp.plugin.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f27957a.c(i7, str);
            }
        });
    }
}
