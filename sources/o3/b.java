package o3;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = "bindCode")
    private Long f37578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g3.b(name = "sessionKey")
    private String f37579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g3.b(name = "factor")
    private String f37580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g3.b(name = com.paytm.pgsdk.d.R)
    private String f37581d;

    public Long a() {
        return this.f37578a;
    }

    public String b() {
        return this.f37580c;
    }

    public String c() {
        return this.f37579b;
    }

    public String d() {
        return this.f37581d;
    }

    public void e(Long l7) {
        this.f37578a = l7;
    }

    public void f(String str) {
        this.f37580c = str;
    }

    public void g(String str) {
        this.f37579b = str;
    }

    public void h(String str) {
        this.f37581d = str;
    }

    public String toString() {
        return "BindInfoDTO{bindCode=" + this.f37578a + ", sessionKey='" + this.f37579b + "', factor='" + this.f37580c + "', token='" + this.f37581d + "'}";
    }
}
