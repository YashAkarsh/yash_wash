package kotlin.coroutines.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements kotlin.coroutines.d<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final c f34703a = new c();

    private c() {
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public kotlin.coroutines.g d() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @a7.d
    public String toString() {
        return "This continuation is already complete";
    }

    @Override // kotlin.coroutines.d
    public void w(@a7.d Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }
}
