package com.haier.globalwasher.modle.utils;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class g0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f24599g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f24600h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f24601i = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f24602a = "TimerUtil_TAG";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f24604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Thread f24606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f24607f;

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                g0 g0Var = g0.this;
                int i7 = g0Var.f24603b;
                if (i7 < -1) {
                    return;
                }
                try {
                    Handler handler = g0Var.f24604c;
                    if (handler != null) {
                        if (i7 >= 0) {
                            if (g0Var.f24605d) {
                                handler.obtainMessage(1).sendToTarget();
                                return;
                            }
                            handler.obtainMessage(0, Integer.valueOf(i7)).sendToTarget();
                        } else if (i7 == -1) {
                            handler.obtainMessage(2, Integer.valueOf(i7)).sendToTarget();
                            return;
                        }
                    }
                    g0.this.f24603b--;
                    Thread.sleep(1000L);
                } catch (InterruptedException e8) {
                    e8.printStackTrace();
                    return;
                }
            }
        }
    }

    public g0(Handler handler, int i7) {
        new a();
        this.f24604c = handler;
        this.f24603b = i7;
    }

    public String a() {
        return this.f24602a;
    }

    public void b(int i7) {
        this.f24603b = i7;
    }

    public void c(String str) {
        this.f24602a = str;
    }

    public int d() {
        Thread thread = new Thread(new b());
        this.f24606e = thread;
        thread.start();
        return this.f24603b;
    }

    public int e() {
        try {
            this.f24606e.interrupt();
        } catch (Exception unused) {
        }
        return this.f24603b;
    }

    public void f() {
        q.a(this.f24602a, "enter the unexStopTimer");
        this.f24605d = true;
    }
}
