package kotlinx.coroutines.flow.internal;

import easypay.appinvoke.manager.Constants;
import kotlin.e1;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import kotlinx.coroutines.channels.g0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h<S, T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    @h5.e
    protected final kotlinx.coroutines.flow.i<S> f36298d;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", i = {}, l = {Constants.ACTION_UID_VIEWER}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.flow.j<? super T>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36299e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f36300f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ h<S, T> f36301g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(h<S, T> hVar, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f36301g = hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            a aVar = new a(this.f36301g, dVar);
            aVar.f36300f = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36299e;
            if (i7 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.j<? super T> jVar = (kotlinx.coroutines.flow.j) this.f36300f;
                h<S, T> hVar = this.f36301g;
                this.f36299e = 1;
                if (hVar.u(jVar, this) == objH) {
                    return objH;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(jVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@a7.d kotlinx.coroutines.flow.i<? extends S> iVar, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        super(gVar, i7, mVar);
        this.f36298d = iVar;
    }

    static /* synthetic */ Object r(h hVar, kotlinx.coroutines.flow.j jVar, kotlin.coroutines.d dVar) {
        if (hVar.f36274b == -3) {
            kotlin.coroutines.g gVarD = dVar.d();
            kotlin.coroutines.g gVarPlus = gVarD.plus(hVar.f36273a);
            if (l0.g(gVarPlus, gVarD)) {
                Object objU = hVar.u(jVar, dVar);
                return objU == kotlin.coroutines.intrinsics.d.h() ? objU : l2.f34958a;
            }
            kotlin.coroutines.e.b bVar = kotlin.coroutines.e.f34677q0;
            if (l0.g(gVarPlus.get(bVar), gVarD.get(bVar))) {
                Object objT = hVar.t(jVar, gVarPlus, dVar);
                return objT == kotlin.coroutines.intrinsics.d.h() ? objT : l2.f34958a;
            }
        }
        Object objA = super.a(jVar, dVar);
        return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
    }

    static /* synthetic */ Object s(h hVar, g0 g0Var, kotlin.coroutines.d dVar) {
        Object objU = hVar.u(new y(g0Var), dVar);
        return objU == kotlin.coroutines.intrinsics.d.h() ? objU : l2.f34958a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t(kotlinx.coroutines.flow.j<? super T> jVar, kotlin.coroutines.g gVar, kotlin.coroutines.d<? super l2> dVar) {
        Object objD = f.d(gVar, f.e(jVar, dVar.d()), null, new a(this, null), dVar, 4, null);
        return objD == kotlin.coroutines.intrinsics.d.h() ? objD : l2.f34958a;
    }

    @Override // kotlinx.coroutines.flow.internal.e, kotlinx.coroutines.flow.i
    @a7.e
    public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return r(this, jVar, dVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.e
    protected Object h(@a7.d g0<? super T> g0Var, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return s(this, g0Var, dVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    public String toString() {
        return this.f36298d + " -> " + super.toString();
    }

    @a7.e
    protected abstract Object u(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar);
}
