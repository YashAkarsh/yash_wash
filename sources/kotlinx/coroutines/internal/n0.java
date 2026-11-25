package kotlinx.coroutines.internal;

import kotlinx.coroutines.o2;

/* JADX INFO: loaded from: classes3.dex */
public class n0<T> extends kotlinx.coroutines.a<T> implements kotlin.coroutines.jvm.internal.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @h5.e
    public final kotlin.coroutines.d<T> f37009c;

    /* JADX WARN: Multi-variable type inference failed */
    public n0(@a7.d kotlin.coroutines.g gVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        super(gVar, true, true);
        this.f37009c = dVar;
    }

    @Override // kotlinx.coroutines.a
    protected void A1(@a7.e Object obj) {
        kotlin.coroutines.d<T> dVar = this.f37009c;
        dVar.w(kotlinx.coroutines.k0.a(obj, dVar));
    }

    @a7.e
    public final o2 F1() {
        kotlinx.coroutines.w wVarM0 = M0();
        if (wVarM0 == null) {
            return null;
        }
        return wVarM0.getParent();
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public final StackTraceElement I() {
        return null;
    }

    @Override // kotlinx.coroutines.w2
    protected final boolean U0() {
        return true;
    }

    @Override // kotlinx.coroutines.w2
    protected void Z(@a7.e Object obj) {
        m.g(kotlin.coroutines.intrinsics.c.d(this.f37009c), kotlinx.coroutines.k0.a(obj, this.f37009c), null, 2, null);
    }

    @Override // kotlin.coroutines.jvm.internal.e
    @a7.e
    public final kotlin.coroutines.jvm.internal.e i() {
        kotlin.coroutines.d<T> dVar = this.f37009c;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }
}
