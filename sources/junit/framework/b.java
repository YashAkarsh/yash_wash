package junit.framework;

/* JADX INFO: loaded from: classes2.dex */
public class b extends AssertionError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f34341a = 1;

    public b() {
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    public b(String str) {
        super(a(str));
    }
}
