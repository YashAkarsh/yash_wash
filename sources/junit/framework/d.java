package junit.framework;

/* JADX INFO: loaded from: classes2.dex */
public class d extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f34350d = 20;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f34351e = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f34352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f34353c;

    public d(String str, String str2, String str3) {
        super(str);
        this.f34352b = str2;
        this.f34353c = str3;
    }

    public String b() {
        return this.f34353c;
    }

    public String c() {
        return this.f34352b;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return new c(20, this.f34352b, this.f34353c).b(super.getMessage());
    }
}
