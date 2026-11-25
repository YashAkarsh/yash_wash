package kotlinx.coroutines.flow.internal;

import kotlin.e1;
import kotlin.jvm.internal.k1;
import kotlin.l2;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.w0;
import kotlinx.coroutines.x0;

/* JADX INFO: loaded from: classes3.dex */
public final class j<T, R> extends h<T, R> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final i5.q<kotlinx.coroutines.flow.j<? super R>, T, kotlin.coroutines.d<? super l2>, Object> f36302e;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36303e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36304f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ j<T, R> f36305g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<R> f36306h;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.j$a$a, reason: collision with other inner class name */
        static final class C0464a<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k1.h<o2> f36307a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ v0 f36308b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ j<T, R> f36309c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j<R> f36310d;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.j$a$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
            static final class C0465a extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super l2>, Object> {

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f36311e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ j<T, R> f36312f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.j<R> f36313g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ T f36314h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0465a(j<T, R> jVar, kotlinx.coroutines.flow.j<? super R> jVar2, T t7, kotlin.coroutines.d<? super C0465a> dVar) {
                    super(2, dVar);
                    this.f36312f = jVar;
                    this.f36313g = jVar2;
                    this.f36314h = t7;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.d
                public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                    return new C0465a(this.f36312f, this.f36313g, this.f36314h, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    Object objH = kotlin.coroutines.intrinsics.d.h();
                    int i7 = this.f36311e;
                    if (i7 == 0) {
                        e1.n(obj);
                        i5.q qVar = ((j) this.f36312f).f36302e;
                        kotlinx.coroutines.flow.j<R> jVar = this.f36313g;
                        T t7 = this.f36314h;
                        this.f36311e = 1;
                        if (qVar.v(jVar, t7, this) == objH) {
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
                public final Object a0(@a7.d v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                    return ((C0465a) D(v0Var, dVar)).R(l2.f34958a);
                }
            }

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.j$a$a$b */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", f = "Merge.kt", i = {0, 0}, l = {30}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
            static final class b extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                Object f36315d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                Object f36316e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                Object f36317f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                /* synthetic */ Object f36318g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ C0464a<T> f36319h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                int f36320i;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                b(C0464a<? super T> c0464a, kotlin.coroutines.d<? super b> dVar) {
                    super(dVar);
                    this.f36319h = c0464a;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36318g = obj;
                    this.f36320i |= Integer.MIN_VALUE;
                    return this.f36319h.f(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            C0464a(k1.h<o2> hVar, v0 v0Var, j<T, R> jVar, kotlinx.coroutines.flow.j<? super R> jVar2) {
                this.f36307a = hVar;
                this.f36308b = v0Var;
                this.f36309c = jVar;
                this.f36310d = jVar2;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                b bVar;
                C0464a<T> c0464a;
                if (dVar instanceof b) {
                    bVar = (b) dVar;
                    int i7 = bVar.f36320i;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        bVar.f36320i = i7 - Integer.MIN_VALUE;
                    } else {
                        bVar = new b(this, dVar);
                    }
                } else {
                    bVar = new b(this, dVar);
                }
                Object obj = bVar.f36318g;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = bVar.f36320i;
                if (i8 == 0) {
                    e1.n(obj);
                    o2 o2Var = this.f36307a.f34872a;
                    if (o2Var != null) {
                        o2Var.c(new l());
                        bVar.f36315d = this;
                        bVar.f36316e = t7;
                        bVar.f36317f = o2Var;
                        bVar.f36320i = 1;
                        if (o2Var.H(bVar) == objH) {
                            return objH;
                        }
                    }
                    c0464a = this;
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    t7 = (T) bVar.f36316e;
                    c0464a = (C0464a) bVar.f36315d;
                    e1.n(obj);
                }
                c0464a.f36307a.f34872a = (T) kotlinx.coroutines.l.f(c0464a.f36308b, null, x0.UNDISPATCHED, new C0465a(c0464a.f36309c, c0464a.f36310d, t7, null), 1, null);
                return l2.f34958a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(j<T, R> jVar, kotlinx.coroutines.flow.j<? super R> jVar2, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f36305g = jVar;
            this.f36306h = jVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            a aVar = new a(this.f36305g, this.f36306h, dVar);
            aVar.f36304f = obj;
            return aVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.d to kotlinx.coroutines.flow.internal.j$a for r7v1 'this'  kotlin.coroutines.d
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r7.f36303e
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.e1.n(r8)
                goto L37
            Lf:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L17:
                kotlin.e1.n(r8)
                java.lang.Object r8 = r7.f36304f
                kotlinx.coroutines.v0 r8 = (kotlinx.coroutines.v0) r8
                kotlin.jvm.internal.k1$h r1 = new kotlin.jvm.internal.k1$h
                r1.<init>()
                kotlinx.coroutines.flow.internal.j<T, R> r3 = r7.f36305g
                kotlinx.coroutines.flow.i<S> r4 = r3.f36298d
                kotlinx.coroutines.flow.internal.j$a$a r5 = new kotlinx.coroutines.flow.internal.j$a$a
                kotlinx.coroutines.flow.j<R> r6 = r7.f36306h
                r5.<init>(r1, r8, r3, r6)
                r7.f36303e = r2
                java.lang.Object r8 = r4.a(r5, r7)
                if (r8 != r0) goto L37
                return r0
            L37:
                kotlin.l2 r8 = kotlin.l2.f34958a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.j.a.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(v0Var, dVar)).R(l2.f34958a);
        }
    }

    public /* synthetic */ j(i5.q qVar, kotlinx.coroutines.flow.i iVar, kotlin.coroutines.g gVar, int i7, kotlinx.coroutines.channels.m mVar, int i8, kotlin.jvm.internal.w wVar) {
        this(qVar, iVar, (i8 & 4) != 0 ? kotlin.coroutines.i.f34682a : gVar, (i8 & 8) != 0 ? -2 : i7, (i8 & 16) != 0 ? kotlinx.coroutines.channels.m.SUSPEND : mVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @a7.d
    protected e<R> i(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return new j(this.f36302e, this.f36298d, gVar, i7, mVar);
    }

    @Override // kotlinx.coroutines.flow.internal.h
    @a7.e
    protected Object u(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objG = w0.g(new a(this, jVar, null), dVar);
        return objG == kotlin.coroutines.intrinsics.d.h() ? objG : l2.f34958a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@a7.d i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, @a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        super(iVar, gVar, i7, mVar);
        this.f36302e = qVar;
    }
}
