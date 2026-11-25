package kotlin.coroutines;

import i5.p;
import java.io.Serializable;
import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
public final class i implements g, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final i f34682a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f34683b = 0;

    private i() {
    }

    private final Object readResolve() {
        return f34682a;
    }

    @Override // kotlin.coroutines.g
    public <R> R fold(R r7, @a7.d p<? super R, ? super g.b, ? extends R> operation) {
        l0.p(operation, "operation");
        return r7;
    }

    @Override // kotlin.coroutines.g
    @a7.e
    public <E extends g.b> E get(@a7.d g.c<E> key) {
        l0.p(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.g
    @a7.d
    public g minusKey(@a7.d g.c<?> key) {
        l0.p(key, "key");
        return this;
    }

    @Override // kotlin.coroutines.g
    @a7.d
    public g plus(@a7.d g context) {
        l0.p(context, "context");
        return context;
    }

    @a7.d
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
