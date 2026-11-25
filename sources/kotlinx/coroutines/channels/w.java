package kotlinx.coroutines.channels;

import kotlinx.coroutines.a1;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class w<E> extends l0 implements j0<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @h5.e
    @a7.e
    public final Throwable f35875d;

    public w(@a7.e Throwable th) {
        this.f35875d = th;
    }

    @Override // kotlinx.coroutines.channels.j0
    public void R(E e8) {
    }

    @Override // kotlinx.coroutines.channels.l0
    public void V0() {
    }

    @Override // kotlinx.coroutines.channels.l0
    public void X0(@a7.d w<?> wVar) {
    }

    @Override // kotlinx.coroutines.channels.l0
    @a7.d
    public r0 Y0(@a7.e kotlinx.coroutines.internal.y.d dVar) {
        r0 r0Var = kotlinx.coroutines.s.f37123d;
        if (dVar != null) {
            dVar.d();
        }
        return r0Var;
    }

    @Override // kotlinx.coroutines.channels.j0
    @a7.d
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public w<E> j() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.l0
    @a7.d
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public w<E> W0() {
        return this;
    }

    @a7.d
    public final Throwable c1() {
        Throwable th = this.f35875d;
        return th == null ? new x(s.f35660a) : th;
    }

    @a7.d
    public final Throwable d1() {
        Throwable th = this.f35875d;
        return th == null ? new y(s.f35660a) : th;
    }

    @Override // kotlinx.coroutines.channels.j0
    @a7.d
    public r0 m0(E e8, @a7.e kotlinx.coroutines.internal.y.d dVar) {
        r0 r0Var = kotlinx.coroutines.s.f37123d;
        if (dVar != null) {
            dVar.d();
        }
        return r0Var;
    }

    @Override // kotlinx.coroutines.internal.y
    @a7.d
    public String toString() {
        return "Closed@" + a1.b(this) + '[' + this.f35875d + ']';
    }
}
