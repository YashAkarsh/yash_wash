package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.b1;
import kotlin.l2;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.p2;
import kotlinx.coroutines.w2;

/* JADX INFO: loaded from: classes2.dex */
public class o<E> extends kotlinx.coroutines.a<l2> implements n<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final n<E> f35633c;

    public o(@a7.d kotlin.coroutines.g gVar, @a7.d n<E> nVar, boolean z7, boolean z8) {
        super(gVar, z7, z8);
        this.f35633c = nVar;
    }

    @Override // kotlinx.coroutines.channels.i0
    @a7.e
    public Object A(@a7.d kotlin.coroutines.d<? super E> dVar) {
        return this.f35633c.A(dVar);
    }

    /* JADX INFO: renamed from: B */
    public boolean e(@a7.e Throwable th) {
        return this.f35633c.e(th);
    }

    @a7.d
    protected final n<E> F1() {
        return this.f35633c;
    }

    @Override // kotlinx.coroutines.channels.m0
    @d2
    public void M(@a7.d i5.l<? super Throwable, l2> lVar) {
        this.f35633c.M(lVar);
    }

    @a7.d
    public Object Q(E e8) {
        return this.f35633c.Q(e8);
    }

    @a7.e
    public Object R(E e8, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return this.f35633c.R(e8, dVar);
    }

    @Override // kotlinx.coroutines.channels.m0
    public boolean S() {
        return this.f35633c.S();
    }

    @a7.d
    public final n<E> a() {
        return this;
    }

    @Override // kotlinx.coroutines.w2, kotlinx.coroutines.o2
    public final void c(@a7.e CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new p2(m0(), null, this);
        }
        f0(cancellationException);
    }

    @Override // kotlinx.coroutines.w2, kotlinx.coroutines.o2
    public /* synthetic */ void cancel() {
        f0(new p2(m0(), null, this));
    }

    @Override // kotlinx.coroutines.w2, kotlinx.coroutines.o2
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean e(Throwable th) {
        f0(new p2(m0(), null, this));
        return true;
    }

    @Override // kotlinx.coroutines.w2
    public void f0(@a7.d Throwable th) {
        CancellationException cancellationExceptionT1 = w2.t1(this, th, null, 1, null);
        this.f35633c.c(cancellationExceptionT1);
        d0(cancellationExceptionT1);
    }

    @Override // kotlinx.coroutines.channels.i0
    public boolean isEmpty() {
        return this.f35633c.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.i0
    @a7.d
    public p<E> iterator() {
        return this.f35633c.iterator();
    }

    @Override // kotlinx.coroutines.channels.i0
    public boolean j() {
        return this.f35633c.j();
    }

    @Override // kotlinx.coroutines.channels.i0
    @a7.d
    public kotlinx.coroutines.selects.d<E> k() {
        return this.f35633c.k();
    }

    @Override // kotlinx.coroutines.channels.i0
    @a7.d
    public kotlinx.coroutines.selects.d<r<E>> l() {
        return this.f35633c.l();
    }

    @Override // kotlinx.coroutines.channels.i0
    @a7.d
    public kotlinx.coroutines.selects.d<E> n() {
        return this.f35633c.n();
    }

    @Override // kotlinx.coroutines.channels.i0
    @a7.d
    public Object o() {
        return this.f35633c.o();
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @b1(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e8) {
        return this.f35633c.offer(e8);
    }

    @Override // kotlinx.coroutines.channels.i0
    @kotlin.internal.h
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @b1(expression = "receiveCatching().getOrNull()", imports = {}))
    @a7.e
    public Object p(@a7.d kotlin.coroutines.d<? super E> dVar) {
        return this.f35633c.p(dVar);
    }

    @Override // kotlinx.coroutines.channels.i0
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @b1(expression = "tryReceive().getOrNull()", imports = {}))
    @a7.e
    public E poll() {
        return this.f35633c.poll();
    }

    @Override // kotlinx.coroutines.channels.i0
    @a7.e
    public Object s(@a7.d kotlin.coroutines.d<? super r<? extends E>> dVar) {
        Object objS = this.f35633c.s(dVar);
        kotlin.coroutines.intrinsics.d.h();
        return objS;
    }

    @a7.d
    public kotlinx.coroutines.selects.e<E, m0<E>> z() {
        return this.f35633c.z();
    }
}
