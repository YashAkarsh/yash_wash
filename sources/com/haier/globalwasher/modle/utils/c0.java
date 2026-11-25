package com.haier.globalwasher.modle.utils;

/* JADX INFO: loaded from: classes2.dex */
public class c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f24580b = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24581a = "SingleClickUtil";

    private class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e8) {
                e8.printStackTrace();
            }
            c0.e(true);
        }

        private a() {
        }
    }

    public static boolean d() {
        return f24580b;
    }

    public static void e(boolean z7) {
        f24580b = z7;
    }

    public void a() {
        e(true);
    }

    public void b() {
        e(false);
        new Thread(new a()).start();
        q.c(this.f24581a, "Click is over");
    }

    public void c() {
        e(false);
    }
}
