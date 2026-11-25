package s4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BlockingQueue<byte[]> f40328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f40329b;

    public a(int i7, int i8) {
        this.f40328a = new ArrayBlockingQueue(i7);
        this.f40329b = i8;
    }

    public int a() {
        return this.f40329b;
    }

    public byte[] b(int i7) {
        byte[] bArrTake;
        InterruptedException e8;
        try {
            bArrTake = this.f40328a.take();
            try {
                k4.b.e("os_queue_receive blockingQueue is polling result = " + bArrTake);
            } catch (InterruptedException e9) {
                e8 = e9;
                e8.printStackTrace();
            }
        } catch (InterruptedException e10) {
            bArrTake = null;
            e8 = e10;
        }
        return bArrTake;
    }

    public boolean c(byte[] bArr, int i7) {
        try {
            return this.f40328a.offer(bArr, i7, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e8) {
            e8.printStackTrace();
            return false;
        }
    }
}
