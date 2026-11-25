package kotlinx.coroutines.channels;

import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
final class b0<E> extends d<E> implements kotlinx.coroutines.selects.e<E, m0<? super E>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private kotlin.coroutines.d<? super l2> f35568d;

    public b0(@a7.d kotlin.coroutines.g gVar, @a7.d n<E> nVar, @a7.d i5.p<? super f<E>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        super(gVar, nVar, false);
        this.f35568d = kotlin.coroutines.intrinsics.c.c(pVar, this, this);
    }

    @Override // kotlinx.coroutines.channels.o, kotlinx.coroutines.channels.m0
    /* JADX INFO: renamed from: B */
    public boolean e(@a7.e Throwable th) {
        boolean zE = super.e(th);
        start();
        return zE;
    }

    @Override // kotlinx.coroutines.channels.o, kotlinx.coroutines.channels.m0
    @a7.d
    public Object Q(E e8) {
        start();
        return super.Q(e8);
    }

    @Override // kotlinx.coroutines.channels.o, kotlinx.coroutines.channels.m0
    @a7.e
    public Object R(E e8, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        start();
        Object objR = super.R(e8, dVar);
        return objR == kotlin.coroutines.intrinsics.d.h() ? objR : l2.f34958a;
    }

    @Override // kotlinx.coroutines.w2
    protected void j1() throws Throwable {
        r5.a.e(this.f35568d, this);
    }

    @Override // kotlinx.coroutines.channels.o, kotlinx.coroutines.channels.m0
    public boolean offer(E e8) {
        start();
        return super.offer(e8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.e
    public <R> void y(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, E e8, @a7.d i5.p<? super m0<? super E>, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        start();
        super.z().y(fVar, e8, pVar);
    }

    @Override // kotlinx.coroutines.channels.o, kotlinx.coroutines.channels.m0
    @a7.d
    public kotlinx.coroutines.selects.e<E, m0<E>> z() {
        return this;
    }
}
