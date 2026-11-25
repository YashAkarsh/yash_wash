package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final class e<T> extends kotlinx.coroutines.flow.internal.e<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f36242f = AtomicIntegerFieldUpdater.newUpdater(e.class, "consumed");

    @a7.d
    private volatile /* synthetic */ int consumed;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final kotlinx.coroutines.channels.i0<T> f36243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f36244e;

    public /* synthetic */ e(kotlinx.coroutines.channels.i0 i0Var, boolean z7, kotlin.coroutines.g gVar, int i7, kotlinx.coroutines.channels.m mVar, int i8, kotlin.jvm.internal.w wVar) {
        this(i0Var, z7, (i8 & 4) != 0 ? kotlin.coroutines.i.f34682a : gVar, (i8 & 8) != 0 ? -3 : i7, (i8 & 16) != 0 ? kotlinx.coroutines.channels.m.SUSPEND : mVar);
    }

    private final void p() {
        if (this.f36244e) {
            if (!(f36242f.getAndSet(this, 1) == 0)) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.e, kotlinx.coroutines.flow.i
    @a7.e
    public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        if (this.f36274b != -3) {
            Object objA = super.a(jVar, dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
        p();
        Object objE = m.e(jVar, this.f36243d, this.f36244e, dVar);
        return objE == kotlin.coroutines.intrinsics.d.h() ? objE : l2.f34958a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    protected String d() {
        return kotlin.jvm.internal.l0.C("channel=", this.f36243d);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.e
    protected Object h(@a7.d kotlinx.coroutines.channels.g0<? super T> g0Var, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objE = m.e(new kotlinx.coroutines.flow.internal.y(g0Var), this.f36243d, this.f36244e, dVar);
        return objE == kotlin.coroutines.intrinsics.d.h() ? objE : l2.f34958a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    protected kotlinx.coroutines.flow.internal.e<T> i(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return new e(this.f36243d, this.f36244e, gVar, i7, mVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    public i<T> k() {
        return new e(this.f36243d, this.f36244e, null, 0, null, 28, null);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    public kotlinx.coroutines.channels.i0<T> o(@a7.d kotlinx.coroutines.v0 v0Var) {
        p();
        return this.f36274b == -3 ? this.f36243d : super.o(v0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@a7.d kotlinx.coroutines.channels.i0<? extends T> i0Var, boolean z7, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        super(gVar, i7, mVar);
        this.f36243d = i0Var;
        this.f36244e = z7;
        this.consumed = 0;
    }
}
