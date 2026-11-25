package s4;

import com.realsil.sdk.mesh.CoreMesh;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Map<Integer, c> f40332h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f40333i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScheduledExecutorService f40335b = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f40336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f40337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f40338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f40339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Future f40340g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f40341a;

        public a(long j7) {
            this.f40341a = j7;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f40341a);
        }
    }

    public c(int i7, int i8, boolean z7, long j7) {
        this.f40336c = i7;
        this.f40337d = i8;
        this.f40338e = z7;
        this.f40339f = new a(j7);
        f40332h.put(Integer.valueOf(f40333i), this);
        int i9 = f40333i;
        this.f40334a = i9;
        f40333i = i9 + 1;
    }

    public static int d(int i7) {
        return f40332h.get(Integer.valueOf(i7)).c();
    }

    public final void a(long j7) {
        if (j7 == 0) {
            return;
        }
        CoreMesh.OsTimerCallback(j7, this.f40334a);
    }

    public int c() {
        return this.f40336c;
    }

    public boolean e() {
        try {
            ScheduledExecutorService scheduledExecutorService = this.f40335b;
            if (scheduledExecutorService == null) {
                return true;
            }
            scheduledExecutorService.shutdown();
            return true;
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public boolean f(int i7) {
        k4.b.e(this.f40334a + " os_timer_restart");
        g();
        return true;
    }

    public boolean g() {
        i();
        k4.b.e(this.f40334a + " os_timer_start");
        try {
            if (!this.f40338e) {
                this.f40340g = this.f40335b.schedule(this.f40339f, this.f40337d, TimeUnit.MILLISECONDS);
                return true;
            }
            ScheduledExecutorService scheduledExecutorService = this.f40335b;
            Runnable runnable = this.f40339f;
            int i7 = this.f40337d;
            this.f40340g = scheduledExecutorService.scheduleAtFixedRate(runnable, i7, i7, TimeUnit.MILLISECONDS);
            return true;
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public int h() {
        Future future = this.f40340g;
        return (future == null || !future.isDone()) ? 1 : 0;
    }

    public boolean i() {
        try {
            Future future = this.f40340g;
            if (future != null) {
                future.cancel(true);
                k4.b.e(this.f40334a + " os_timer_stop:" + this.f40340g.isCancelled());
            }
            return true;
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public void j(Runnable runnable) {
        this.f40339f = runnable;
    }
}
