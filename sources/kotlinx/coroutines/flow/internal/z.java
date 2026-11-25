package kotlinx.coroutines.flow.internal;

/* JADX INFO: loaded from: classes3.dex */
final class z<T> implements kotlin.coroutines.d<T>, kotlin.coroutines.jvm.internal.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.d<T> f36411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.g f36412b;

    /* JADX WARN: Multi-variable type inference failed */
    public z(@a7.d kotlin.coroutines.d<? super T> dVar, @a7.d kotlin.coroutines.g gVar) {
        this.f36411a = dVar;
        this.f36412b = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public StackTraceElement I() {
        return null;
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public kotlin.coroutines.g d() {
        return this.f36412b;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public kotlin.coroutines.jvm.internal.e i() {
        kotlin.coroutines.d<T> dVar = this.f36411a;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.d
    public void w(@a7.d Object obj) {
        this.f36411a.w(obj);
    }
}
