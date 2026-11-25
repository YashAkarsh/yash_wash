package o3;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = "gatewayId")
    private String f37582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g3.b(name = "limit")
    private int f37583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g3.b(name = "cursor")
    private int f37584c;

    public int a() {
        return this.f37584c;
    }

    public String b() {
        return this.f37582a;
    }

    public int c() {
        return this.f37583b;
    }

    public void d(int i7) {
        this.f37584c = i7;
    }

    public void e(String str) {
        this.f37582a = str;
    }

    public void f(int i7) {
        this.f37583b = i7;
    }

    public String toString() {
        return "LocalSceneList{gatewayId='" + this.f37582a + "', limit=" + this.f37583b + ", cursor=" + this.f37584c + '}';
    }
}
