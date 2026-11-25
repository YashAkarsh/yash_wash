package kotlinx.coroutines.flow;

import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
class f<T> extends kotlinx.coroutines.flow.internal.e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final i5.p<kotlinx.coroutines.channels.g0<? super T>, kotlin.coroutines.d<? super l2>, Object> f36245d;

    public /* synthetic */ f(i5.p pVar, kotlin.coroutines.g gVar, int i7, kotlinx.coroutines.channels.m mVar, int i8, kotlin.jvm.internal.w wVar) {
        this(pVar, (i8 & 2) != 0 ? kotlin.coroutines.i.f34682a : gVar, (i8 & 4) != 0 ? -2 : i7, (i8 & 8) != 0 ? kotlinx.coroutines.channels.m.SUSPEND : mVar);
    }

    static /* synthetic */ Object p(f fVar, kotlinx.coroutines.channels.g0 g0Var, kotlin.coroutines.d dVar) {
        Object objA0 = fVar.f36245d.a0(g0Var, dVar);
        return objA0 == kotlin.coroutines.intrinsics.d.h() ? objA0 : l2.f34958a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.e
    protected Object h(@a7.d kotlinx.coroutines.channels.g0<? super T> g0Var, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return p(this, g0Var, dVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    protected kotlinx.coroutines.flow.internal.e<T> i(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return new f(this.f36245d, gVar, i7, mVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    public String toString() {
        return "block[" + this.f36245d + "] -> " + super.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@a7.d i5.p<? super kotlinx.coroutines.channels.g0<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        super(gVar, i7, mVar);
        this.f36245d = pVar;
    }
}
