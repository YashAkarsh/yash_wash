package kotlin.coroutines;

import i5.l;
import kotlin.coroutines.g.b;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.s;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
@s
public abstract class b<B extends g.b, E extends B> implements g.c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final l<g.b, E> f34667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final g.c<?> f34668b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.g$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [i5.l<? super kotlin.coroutines.g$b, ? extends E extends B>, i5.l<kotlin.coroutines.g$b, E extends B>, java.lang.Object] */
    public b(@a7.d g.c<B> baseKey, @a7.d l<? super g.b, ? extends E> safeCast) {
        l0.p(baseKey, "baseKey");
        l0.p(safeCast, "safeCast");
        this.f34667a = safeCast;
        this.f34668b = baseKey instanceof b ? (g.c<B>) ((b) baseKey).f34668b : baseKey;
    }

    public final boolean a(@a7.d g.c<?> key) {
        l0.p(key, "key");
        return key == this || this.f34668b == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/g$b;)TE; */
    @a7.e
    public final g.b b(@a7.d g.b element) {
        l0.p(element, "element");
        return (g.b) this.f34667a.z(element);
    }
}
