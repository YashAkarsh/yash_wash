package n3;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = "productCode")
    private String f37491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g3.b(name = "selfDiscoveryInformationCode")
    private String f37492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g3.b(name = "mac")
    private String f37493c;

    public String a() {
        return this.f37493c;
    }

    public String b() {
        return this.f37491a;
    }

    public String c() {
        return this.f37492b;
    }

    public void d(String str) {
        this.f37493c = str;
    }

    public void e(String str) {
        this.f37491a = str;
    }

    public void f(String str) {
        this.f37492b = str;
    }

    public String toString() {
        return "DeviceModelInfoRequestBean{productCode='" + this.f37491a + "', selfDiscoveryInformationCode='" + this.f37492b + "', mac='" + this.f37493c + "'}";
    }
}
