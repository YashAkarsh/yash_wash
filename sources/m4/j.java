package m4;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f37471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37472b = 0;

    public static j a() {
        return new j();
    }

    public void b() {
        this.f37472b++;
        long jNanoTime = (System.nanoTime() - this.f37471a) / 1000;
        this.f37471a = System.nanoTime();
    }

    public void c() {
        this.f37472b++;
        long jNanoTime = (System.nanoTime() - this.f37471a) / 1000;
        this.f37471a = System.nanoTime();
    }

    public void d() {
        this.f37471a = System.nanoTime();
        this.f37472b = 0;
    }

    public void e() {
        this.f37471a = System.nanoTime();
        this.f37472b = 0;
    }
}
