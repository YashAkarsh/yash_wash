package kotlinx.coroutines.channels;

import kotlin.d1;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes2.dex */
public class n0<E> extends l0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final E f35631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    @h5.e
    public final kotlinx.coroutines.q<l2> f35632e;

    /* JADX WARN: Multi-variable type inference failed */
    public n0(E e8, @a7.d kotlinx.coroutines.q<? super l2> qVar) {
        this.f35631d = e8;
        this.f35632e = qVar;
    }

    @Override // kotlinx.coroutines.channels.l0
    public void V0() {
        this.f35632e.t0(kotlinx.coroutines.s.f37123d);
    }

    @Override // kotlinx.coroutines.channels.l0
    public E W0() {
        return this.f35631d;
    }

    @Override // kotlinx.coroutines.channels.l0
    public void X0(@a7.d w<?> wVar) {
        kotlinx.coroutines.q<l2> qVar = this.f35632e;
        d1.a aVar = d1.f34719b;
        qVar.w(d1.b(e1.a(wVar.d1())));
    }

    @Override // kotlinx.coroutines.channels.l0
    @a7.e
    public r0 Y0(@a7.e kotlinx.coroutines.internal.y.d dVar) {
        if (this.f35632e.t(l2.f34958a, dVar == null ? null : dVar.f37053c) == null) {
            return null;
        }
        if (dVar != null) {
            dVar.d();
        }
        return kotlinx.coroutines.s.f37123d;
    }

    @Override // kotlinx.coroutines.internal.y
    @a7.d
    public String toString() {
        return a1.a(this) + '@' + a1.b(this) + '(' + W0() + ')';
    }
}
