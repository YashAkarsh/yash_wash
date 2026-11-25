package com.haier.hailicommontlib.mvp.model.utils;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f26177b = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26178a = "SingleClickUtil";

    private class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e8) {
                e8.printStackTrace();
            }
            g.e(true);
        }

        private a() {
        }
    }

    public static boolean d() {
        return f26177b;
    }

    public static void e(boolean z7) {
        f26177b = z7;
    }

    public void a() {
        e(true);
    }

    public void b() {
        e(false);
        new Thread(new a()).start();
        b.c(this.f26178a, "Click is over");
    }

    public void c() {
        e(false);
    }
}
