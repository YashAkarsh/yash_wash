package o3;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37586b;

    public String a() {
        return this.f37585a;
    }

    public String b() {
        return this.f37586b;
    }

    public void c(String str) {
        this.f37585a = str;
    }

    public void d(String str) {
        this.f37586b = str;
    }

    public String toString() {
        return "{devId='" + this.f37585a + "', wifiType='" + this.f37586b + "'}";
    }
}
