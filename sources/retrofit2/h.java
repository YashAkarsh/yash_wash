package retrofit2;

/* JADX INFO: loaded from: classes3.dex */
public class h extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f40173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f40174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient r<?> f40175c;

    public h(r<?> rVar) {
        super(b(rVar));
        this.f40173a = rVar.b();
        this.f40174b = rVar.h();
        this.f40175c = rVar;
    }

    private static String b(r<?> rVar) {
        u.b(rVar, "response == null");
        return "HTTP " + rVar.b() + " " + rVar.h();
    }

    public int a() {
        return this.f40173a;
    }

    public String c() {
        return this.f40174b;
    }

    public r<?> d() {
        return this.f40175c;
    }
}
