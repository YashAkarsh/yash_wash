package kotlinx.coroutines.channels;

import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class o0<E> extends n0<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    @h5.e
    public final i5.l<E, l2> f35634f;

    /* JADX WARN: Multi-variable type inference failed */
    public o0(E e8, @a7.d kotlinx.coroutines.q<? super l2> qVar, @a7.d i5.l<? super E, l2> lVar) {
        super(e8, qVar);
        this.f35634f = lVar;
    }

    @Override // kotlinx.coroutines.internal.y
    public boolean O0() {
        if (!super.O0()) {
            return false;
        }
        Z0();
        return true;
    }

    @Override // kotlinx.coroutines.channels.l0
    public void Z0() {
        kotlinx.coroutines.internal.i0.b(this.f35634f, W0(), this.f35632e.d());
    }
}
