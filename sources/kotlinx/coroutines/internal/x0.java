package kotlinx.coroutines.internal;

import kotlinx.coroutines.t3;

/* JADX INFO: loaded from: classes3.dex */
public final class x0<T> implements t3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f37040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final ThreadLocal<T> f37041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final kotlin.coroutines.g.c<?> f37042c;

    public x0(T t7, @a7.d ThreadLocal<T> threadLocal) {
        this.f37040a = t7;
        this.f37041b = threadLocal;
        this.f37042c = new y0(threadLocal);
    }

    @Override // kotlinx.coroutines.t3
    public T L0(@a7.d kotlin.coroutines.g gVar) {
        T t7 = this.f37041b.get();
        this.f37041b.set(this.f37040a);
        return t7;
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    public <R> R fold(R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
        return (R) t3.a.a(this, r7, pVar);
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.e
    public <E extends kotlin.coroutines.g.b> E get(@a7.d kotlin.coroutines.g.c<E> cVar) {
        if (kotlin.jvm.internal.l0.g(getKey(), cVar)) {
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.g.b
    @a7.d
    public kotlin.coroutines.g.c<?> getKey() {
        return this.f37042c;
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.d
    public kotlin.coroutines.g minusKey(@a7.d kotlin.coroutines.g.c<?> cVar) {
        return kotlin.jvm.internal.l0.g(getKey(), cVar) ? kotlin.coroutines.i.f34682a : this;
    }

    @Override // kotlin.coroutines.g
    @a7.d
    public kotlin.coroutines.g plus(@a7.d kotlin.coroutines.g gVar) {
        return t3.a.d(this, gVar);
    }

    @a7.d
    public String toString() {
        return "ThreadLocal(value=" + this.f37040a + ", threadLocal = " + this.f37041b + ')';
    }

    @Override // kotlinx.coroutines.t3
    public void v0(@a7.d kotlin.coroutines.g gVar, T t7) {
        this.f37041b.set(t7);
    }
}
