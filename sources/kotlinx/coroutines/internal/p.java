package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f37014a;

    static {
        Object objB;
        try {
            kotlin.d1.a aVar = kotlin.d1.f34719b;
            objB = kotlin.d1.b(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            kotlin.d1.a aVar2 = kotlin.d1.f34719b;
            objB = kotlin.d1.b(kotlin.e1.a(th));
        }
        f37014a = kotlin.d1.j(objB);
    }

    public static final boolean a() {
        return f37014a;
    }
}
