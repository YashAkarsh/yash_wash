package kotlinx.coroutines.flow.internal;

import kotlin.e1;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import kotlinx.coroutines.channels.e0;
import kotlinx.coroutines.channels.g0;
import kotlinx.coroutines.channels.i0;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class g<T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final kotlinx.coroutines.flow.i<kotlinx.coroutines.flow.i<T>> f36283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f36284e;

    static final class a<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o2 f36285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.sync.f f36286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g0<T> f36287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ y<T> f36288d;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.g$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {f4.d.f33916f}, m = "invokeSuspend", n = {}, s = {})
        static final class C0463a extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36289e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i<T> f36290f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ y<T> f36291g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.sync.f f36292h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0463a(kotlinx.coroutines.flow.i<? extends T> iVar, y<T> yVar, kotlinx.coroutines.sync.f fVar, kotlin.coroutines.d<? super C0463a> dVar) {
                super(2, dVar);
                this.f36290f = iVar;
                this.f36291g = yVar;
                this.f36292h = fVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                return new C0463a(this.f36290f, this.f36291g, this.f36292h, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36289e;
                try {
                    if (i7 == 0) {
                        e1.n(obj);
                        kotlinx.coroutines.flow.i<T> iVar = this.f36290f;
                        y<T> yVar = this.f36291g;
                        this.f36289e = 1;
                        if (iVar.a(yVar, this) == objH) {
                            return objH;
                        }
                    } else {
                        if (i7 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj);
                    }
                    this.f36292h.i();
                    return l2.f34958a;
                } catch (Throwable th) {
                    this.f36292h.i();
                    throw th;
                }
            }

            @Override // i5.p
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object a0(@a7.d v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                return ((C0463a) D(v0Var, dVar)).R(l2.f34958a);
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2", f = "Merge.kt", i = {0, 0}, l = {66}, m = "emit", n = {"this", "inner"}, s = {"L$0", "L$1"})
        static final class b extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36293d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f36294e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            /* synthetic */ Object f36295f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ a<T> f36296g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            int f36297h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(a<? super T> aVar, kotlin.coroutines.d<? super b> dVar) {
                super(dVar);
                this.f36296g = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36295f = obj;
                this.f36297h |= Integer.MIN_VALUE;
                return this.f36296g.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(o2 o2Var, kotlinx.coroutines.sync.f fVar, g0<? super T> g0Var, y<T> yVar) {
            this.f36285a = o2Var;
            this.f36286b = fVar;
            this.f36287c = g0Var;
            this.f36288d = yVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object f(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            b bVar;
            a<T> aVar;
            if (dVar instanceof b) {
                bVar = (b) dVar;
                int i7 = bVar.f36297h;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    bVar.f36297h = i7 - Integer.MIN_VALUE;
                } else {
                    bVar = new b(this, dVar);
                }
            } else {
                bVar = new b(this, dVar);
            }
            Object obj = bVar.f36295f;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = bVar.f36297h;
            if (i8 == 0) {
                e1.n(obj);
                o2 o2Var = this.f36285a;
                if (o2Var != null) {
                    s2.A(o2Var);
                }
                kotlinx.coroutines.sync.f fVar = this.f36286b;
                bVar.f36293d = this;
                bVar.f36294e = iVar;
                bVar.f36297h = 1;
                if (fVar.b(bVar) == objH) {
                    return objH;
                }
                aVar = this;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                iVar = (kotlinx.coroutines.flow.i) bVar.f36294e;
                aVar = (a) bVar.f36293d;
                e1.n(obj);
            }
            kotlinx.coroutines.l.f(aVar.f36287c, null, null, new C0463a(iVar, aVar.f36288d, aVar.f36286b, null), 3, null);
            return l2.f34958a;
        }
    }

    public /* synthetic */ g(kotlinx.coroutines.flow.i iVar, int i7, kotlin.coroutines.g gVar, int i8, kotlinx.coroutines.channels.m mVar, int i9, kotlin.jvm.internal.w wVar) {
        this(iVar, i7, (i9 & 4) != 0 ? kotlin.coroutines.i.f34682a : gVar, (i9 & 8) != 0 ? -2 : i8, (i9 & 16) != 0 ? kotlinx.coroutines.channels.m.SUSPEND : mVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    protected String d() {
        return l0.C("concurrency=", Integer.valueOf(this.f36284e));
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.e
    protected Object h(@a7.d g0<? super T> g0Var, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objA = this.f36283d.a(new a((o2) dVar.d().get(o2.f37103s0), kotlinx.coroutines.sync.h.b(this.f36284e, 0, 2, null), g0Var, new y(g0Var)), dVar);
        return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    protected e<T> i(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return new g(this.f36283d, this.f36284e, gVar, i7, mVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    public i0<T> o(@a7.d v0 v0Var) {
        return e0.c(v0Var, this.f36273a, this.f36274b, l());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@a7.d kotlinx.coroutines.flow.i<? extends kotlinx.coroutines.flow.i<? extends T>> iVar, int i7, @a7.d kotlin.coroutines.g gVar, int i8, @a7.d kotlinx.coroutines.channels.m mVar) {
        super(gVar, i8, mVar);
        this.f36283d = iVar;
        this.f36284e = i7;
    }
}
