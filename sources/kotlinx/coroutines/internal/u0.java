package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f37027a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f37027a;
    }

    @a7.e
    public static final String b(@a7.d String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
