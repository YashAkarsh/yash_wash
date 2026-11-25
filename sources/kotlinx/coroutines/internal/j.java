package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements kotlinx.coroutines.v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.g f36992a;

    public j(@a7.d kotlin.coroutines.g gVar) {
        this.f36992a = gVar;
    }

    @Override // kotlinx.coroutines.v0
    @a7.d
    public kotlin.coroutines.g D() {
        return this.f36992a;
    }

    @a7.d
    public String toString() {
        return "CoroutineScope(coroutineContext=" + D() + ')';
    }
}
