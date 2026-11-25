package s4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ReentrantLock f40330b = new ReentrantLock();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Semaphore f40331a = new Semaphore(1, true);

    public static boolean a() {
        try {
            f40330b.lock();
            return true;
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public static boolean e() {
        try {
            f40330b.unlock();
            return true;
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public boolean b() {
        boolean zC = c();
        this.f40331a = null;
        return zC;
    }

    public boolean c() {
        try {
            this.f40331a.release();
            return true;
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public boolean d(int i7) {
        try {
            this.f40331a.tryAcquire(i7, TimeUnit.MILLISECONDS);
            return true;
        } catch (InterruptedException e8) {
            e8.printStackTrace();
            return false;
        }
    }
}
