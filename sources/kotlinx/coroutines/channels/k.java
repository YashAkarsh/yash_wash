package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.b1;
import kotlin.l2;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.p2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w2;

/* JADX INFO: loaded from: classes2.dex */
class k<E> extends kotlinx.coroutines.a<l2> implements g0<E>, i<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final i<E> f35606c;

    public k(@a7.d kotlin.coroutines.g gVar, @a7.d i<E> iVar, boolean z7) {
        super(gVar, false, z7);
        this.f35606c = iVar;
        R0((o2) gVar.get(o2.f37103s0));
    }

    @Override // kotlinx.coroutines.channels.m0
    /* JADX INFO: renamed from: B */
    public boolean e(@a7.e Throwable th) {
        boolean zE = this.f35606c.e(th);
        start();
        return zE;
    }

    @Override // kotlinx.coroutines.a
    protected void C1(@a7.d Throwable th, boolean z7) {
        if (this.f35606c.e(th) || z7) {
            return;
        }
        r0.b(d(), th);
    }

    @a7.d
    protected final i<E> F1() {
        return this.f35606c;
    }

    @a7.d
    public i0<E> G() {
        return this.f35606c.G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.a
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public void D1(@a7.d l2 l2Var) {
        m0.a.a(this.f35606c, null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.m0
    @d2
    public void M(@a7.d i5.l<? super Throwable, l2> lVar) {
        this.f35606c.M(lVar);
    }

    @Override // kotlinx.coroutines.channels.m0
    @a7.d
    public Object Q(E e8) {
        return this.f35606c.Q(e8);
    }

    @Override // kotlinx.coroutines.channels.m0
    @a7.e
    public Object R(E e8, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return this.f35606c.R(e8, dVar);
    }

    @Override // kotlinx.coroutines.channels.m0
    public boolean S() {
        return this.f35606c.S();
    }

    @Override // kotlinx.coroutines.channels.g0
    @a7.d
    public m0<E> a() {
        return this;
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.w2, kotlinx.coroutines.o2
    public boolean b() {
        return super.b();
    }

    @Override // kotlinx.coroutines.w2, kotlinx.coroutines.o2
    public final void c(@a7.e CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new p2(m0(), null, this);
        }
        f0(cancellationException);
    }

    @Override // kotlinx.coroutines.w2, kotlinx.coroutines.o2
    @kotlin.k(level = kotlin.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean e(Throwable th) {
        if (th == null) {
            th = new p2(m0(), null, this);
        }
        f0(th);
        return true;
    }

    @Override // kotlinx.coroutines.w2
    public void f0(@a7.d Throwable th) {
        CancellationException cancellationExceptionT1 = w2.t1(this, th, null, 1, null);
        this.f35606c.c(cancellationExceptionT1);
        d0(cancellationExceptionT1);
    }

    @Override // kotlinx.coroutines.channels.m0
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @b1(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e8) {
        return this.f35606c.offer(e8);
    }

    @Override // kotlinx.coroutines.channels.m0
    @a7.d
    public kotlinx.coroutines.selects.e<E, m0<E>> z() {
        return this.f35606c.z();
    }
}
