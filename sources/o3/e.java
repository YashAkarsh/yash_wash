package o3;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = "nc")
    private String f37587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g3.b(name = "to")
    private int f37588b;

    public String a() {
        return this.f37587a;
    }

    public int b() {
        return this.f37588b;
    }

    public void c(String str) {
        this.f37587a = str;
    }

    public void d(int i7) {
        this.f37588b = i7;
    }

    public String toString() {
        return "StrategyDto{netConfig='" + this.f37587a + "', timeout=" + this.f37588b + '}';
    }
}
