package kotlinx.coroutines.debug.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements kotlin.coroutines.jvm.internal.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final kotlin.coroutines.jvm.internal.e f35978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final StackTraceElement f35979b;

    public m(@a7.e kotlin.coroutines.jvm.internal.e eVar, @a7.d StackTraceElement stackTraceElement) {
        this.f35978a = eVar;
        this.f35979b = stackTraceElement;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.d
    public StackTraceElement I() {
        return this.f35979b;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public kotlin.coroutines.jvm.internal.e i() {
        return this.f35978a;
    }
}
