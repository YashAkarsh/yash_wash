package kotlinx.coroutines.flow;

import easypay.appinvoke.manager.Constants;
import kotlin.e1;
import kotlin.jvm.internal.k1;
import kotlin.l2;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.g1;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class a<T> extends kotlin.jvm.internal.n0 implements i5.l<T, Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f36552a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j7) {
            super(1);
            this.f36552a = j7;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Long z(T t7) {
            return Long.valueOf(this.f36552a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class b<T> extends kotlin.jvm.internal.n0 implements i5.l<T, Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<T, kotlin.time.d> f36553a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(i5.l<? super T, kotlin.time.d> lVar) {
            super(1);
            this.f36553a = lVar;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Long z(T t7) {
            return Long.valueOf(g1.e(this.f36553a.z(t7).u0()));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {Constants.EASY_PAY_MAXIMIZE_ASSIST, 355}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue", "timeoutMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    static final class c<T> extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.v0, j<? super T>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36554e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f36555f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f36556g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private /* synthetic */ Object f36557h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f36558i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ i5.l<T, Long> f36559j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ i<T> f36560k;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends kotlin.coroutines.jvm.internal.o implements i5.l<kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36561e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ j<T> f36562f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ k1.h<Object> f36563g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(j<? super T> jVar, k1.h<Object> hVar, kotlin.coroutines.d<? super a> dVar) {
                super(1, dVar);
                this.f36562f = jVar;
                this.f36563g = hVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> E(@a7.d kotlin.coroutines.d<?> dVar) {
                return new a(this.f36562f, this.f36563g, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36561e;
                if (i7 == 0) {
                    e1.n(obj);
                    j<T> jVar = this.f36562f;
                    kotlinx.coroutines.internal.r0 r0Var = kotlinx.coroutines.flow.internal.u.f36394a;
                    T t7 = this.f36563g.f34872a;
                    if (t7 == r0Var) {
                        t7 = null;
                    }
                    this.f36561e = 1;
                    if (jVar.f(t7, this) == objH) {
                        return objH;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj);
                }
                this.f36563g.f34872a = null;
                return l2.f34958a;
            }

            @Override // i5.l
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object z(@a7.e kotlin.coroutines.d<? super l2> dVar) {
                return ((a) E(dVar)).R(l2.f34958a);
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {243}, m = "invokeSuspend", n = {"$this$onFailure$iv"}, s = {"L$0"})
        static final class b extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.r<? extends Object>, kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f36564e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36565f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36566g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ k1.h<Object> f36567h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ j<T> f36568i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(k1.h<Object> hVar, j<? super T> jVar, kotlin.coroutines.d<? super b> dVar) {
                super(2, dVar);
                this.f36567h = hVar;
                this.f36568i = jVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                b bVar = new b(this.f36567h, this.f36568i, dVar);
                bVar.f36566g = obj;
                return bVar;
            }

            /* JADX WARN: Type inference failed for: r7v6, types: [T, kotlinx.coroutines.internal.r0] */
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.d to kotlinx.coroutines.flow.r$c$b for r6v1 'this'  kotlin.coroutines.d
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final java.lang.Object R(@a7.d java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                    int r1 = r6.f36565f
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    java.lang.Object r0 = r6.f36564e
                    kotlin.jvm.internal.k1$h r0 = (kotlin.jvm.internal.k1.h) r0
                    kotlin.e1.n(r7)
                    goto L4f
                L13:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L1b:
                    kotlin.e1.n(r7)
                    java.lang.Object r7 = r6.f36566g
                    kotlinx.coroutines.channels.r r7 = (kotlinx.coroutines.channels.r) r7
                    java.lang.Object r7 = r7.o()
                    kotlin.jvm.internal.k1$h<java.lang.Object> r1 = r6.f36567h
                    boolean r3 = r7 instanceof kotlinx.coroutines.channels.r.c
                    if (r3 != 0) goto L2e
                    r1.f34872a = r7
                L2e:
                    kotlinx.coroutines.flow.j<T> r4 = r6.f36568i
                    if (r3 == 0) goto L56
                    java.lang.Throwable r3 = kotlinx.coroutines.channels.r.f(r7)
                    if (r3 != 0) goto L55
                    T r3 = r1.f34872a
                    if (r3 == 0) goto L50
                    kotlinx.coroutines.internal.r0 r5 = kotlinx.coroutines.flow.internal.u.f36394a
                    if (r3 != r5) goto L41
                    r3 = 0
                L41:
                    r6.f36566g = r7
                    r6.f36564e = r1
                    r6.f36565f = r2
                    java.lang.Object r7 = r4.f(r3, r6)
                    if (r7 != r0) goto L4e
                    return r0
                L4e:
                    r0 = r1
                L4f:
                    r1 = r0
                L50:
                    kotlinx.coroutines.internal.r0 r7 = kotlinx.coroutines.flow.internal.u.f36396c
                    r1.f34872a = r7
                    goto L56
                L55:
                    throw r3
                L56:
                    kotlin.l2 r7 = kotlin.l2.f34958a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.r.c.b.R(java.lang.Object):java.lang.Object");
            }

            @Override // i5.p
            public /* bridge */ /* synthetic */ Object a0(kotlinx.coroutines.channels.r<? extends Object> rVar, kotlin.coroutines.d<? super l2> dVar) {
                return e0(rVar.o(), dVar);
            }

            @a7.e
            public final Object e0(@a7.d Object obj, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                return ((b) D(kotlinx.coroutines.channels.r.b(obj), dVar)).R(l2.f34958a);
            }
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.r$c$c, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1", f = "Delay.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
        static final class C0476c extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<? super Object>, kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36569e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36570f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ i<T> f36571g;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.r$c$c$a */
            static final class a<T> implements j, kotlin.coroutines.jvm.internal.n {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.channels.g0<Object> f36572a;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.r$c$c$a$a, reason: collision with other inner class name */
                @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1$1", f = "Delay.kt", i = {}, l = {211}, m = "emit", n = {}, s = {})
                static final class C0477a extends kotlin.coroutines.jvm.internal.d {

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    /* synthetic */ Object f36573d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    final /* synthetic */ a<T> f36574e;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    int f36575f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0477a(a<? super T> aVar, kotlin.coroutines.d<? super C0477a> dVar) {
                        super(dVar);
                        this.f36574e = aVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @a7.e
                    public final Object R(@a7.d Object obj) {
                        this.f36573d = obj;
                        this.f36575f |= Integer.MIN_VALUE;
                        return this.f36574e.f(null, this);
                    }
                }

                a(kotlinx.coroutines.channels.g0<Object> g0Var) {
                    this.f36572a = g0Var;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlinx.coroutines.flow.j
                @a7.e
                public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                    C0477a c0477a;
                    if (dVar instanceof C0477a) {
                        c0477a = (C0477a) dVar;
                        int i7 = c0477a.f36575f;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            c0477a.f36575f = i7 - Integer.MIN_VALUE;
                        } else {
                            c0477a = new C0477a(this, dVar);
                        }
                    } else {
                        c0477a = new C0477a(this, dVar);
                    }
                    Object obj = c0477a.f36573d;
                    Object objH = kotlin.coroutines.intrinsics.d.h();
                    int i8 = c0477a.f36575f;
                    if (i8 == 0) {
                        e1.n(obj);
                        kotlinx.coroutines.channels.g0<Object> g0Var = this.f36572a;
                        if (t7 == null) {
                            t7 = (T) kotlinx.coroutines.flow.internal.u.f36394a;
                        }
                        c0477a.f36575f = 1;
                        if (g0Var.R(t7, c0477a) == objH) {
                            return objH;
                        }
                    } else {
                        if (i8 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj);
                    }
                    return l2.f34958a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0476c(i<? extends T> iVar, kotlin.coroutines.d<? super C0476c> dVar) {
                super(2, dVar);
                this.f36571g = iVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                C0476c c0476c = new C0476c(this.f36571g, dVar);
                c0476c.f36570f = obj;
                return c0476c;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36569e;
                if (i7 == 0) {
                    e1.n(obj);
                    kotlinx.coroutines.channels.g0 g0Var = (kotlinx.coroutines.channels.g0) this.f36570f;
                    i<T> iVar = this.f36571g;
                    a aVar = new a(g0Var);
                    this.f36569e = 1;
                    if (iVar.a(aVar, this) == objH) {
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
            public final Object a0(@a7.d kotlinx.coroutines.channels.g0<Object> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                return ((C0476c) D(g0Var, dVar)).R(l2.f34958a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(i5.l<? super T, Long> lVar, i<? extends T> iVar, kotlin.coroutines.d<? super c> dVar) {
            super(3, dVar);
            this.f36559j = lVar;
            this.f36560k = iVar;
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0075  */
        /* JADX WARN: Code duplicated, block: B:15:0x007e  */
        /* JADX WARN: Code duplicated, block: B:17:0x0084  */
        /* JADX WARN: Code duplicated, block: B:20:0x0097  */
        /* JADX WARN: Code duplicated, block: B:21:0x0099  */
        /* JADX WARN: Code duplicated, block: B:23:0x009c  */
        /* JADX WARN: Code duplicated, block: B:25:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:27:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:30:0x00b5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:38:0x00e0 A[Catch: all -> 0x00f7, TryCatch #0 {all -> 0x00f7, blocks: (B:36:0x00dc, B:38:0x00e0, B:39:0x00ea), top: B:51:0x00dc }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0105  */
        /* JADX WARN: Code duplicated, block: B:47:0x010a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:48:0x010b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x010b -> B:11:0x006f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 276
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.r.c.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.q
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object v(@a7.d kotlinx.coroutines.v0 v0Var, @a7.d j<? super T> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            c cVar = new c(this.f36559j, this.f36560k, dVar);
            cVar.f36557h = v0Var;
            cVar.f36558i = jVar;
            return cVar.R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", i = {0, 1, 2}, l = {314, androidx.constraintlayout.core.motion.utils.w.a.f3016q, androidx.constraintlayout.core.motion.utils.w.a.f3017r}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
    static final class d extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<? super l2>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f36578g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f36579h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j7, long j8, kotlin.coroutines.d<? super d> dVar) {
            super(2, dVar);
            this.f36578g = j7;
            this.f36579h = j8;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            d dVar2 = new d(this.f36578g, this.f36579h, dVar);
            dVar2.f36577f = obj;
            return dVar2;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0050 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x005d A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005b -> B:15:0x0040). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:5:0x000d
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final java.lang.Object R(@a7.d java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                int r1 = r7.f36576e
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L11
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
            L11:
                java.lang.Object r1 = r7.f36577f
                kotlinx.coroutines.channels.g0 r1 = (kotlinx.coroutines.channels.g0) r1
                kotlin.e1.n(r8)
                goto L3f
            L19:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L21:
                java.lang.Object r1 = r7.f36577f
                kotlinx.coroutines.channels.g0 r1 = (kotlinx.coroutines.channels.g0) r1
                kotlin.e1.n(r8)
                r8 = r7
                goto L51
            L2a:
                kotlin.e1.n(r8)
                java.lang.Object r8 = r7.f36577f
                r1 = r8
                kotlinx.coroutines.channels.g0 r1 = (kotlinx.coroutines.channels.g0) r1
                long r5 = r7.f36578g
                r7.f36577f = r1
                r7.f36576e = r4
                java.lang.Object r8 = kotlinx.coroutines.g1.b(r5, r7)
                if (r8 != r0) goto L3f
                return r0
            L3f:
                r8 = r7
            L40:
                kotlinx.coroutines.channels.m0 r4 = r1.a()
                kotlin.l2 r5 = kotlin.l2.f34958a
                r8.f36577f = r1
                r8.f36576e = r3
                java.lang.Object r4 = r4.R(r5, r8)
                if (r4 != r0) goto L51
                return r0
            L51:
                long r4 = r8.f36579h
                r8.f36577f = r1
                r8.f36576e = r2
                java.lang.Object r4 = kotlinx.coroutines.g1.b(r4, r8)
                if (r4 != r0) goto L40
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.r.d.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.channels.g0<? super l2> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((d) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {352}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class e<T> extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.v0, j<? super T>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36580e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f36581f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f36582g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private /* synthetic */ Object f36583h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f36584i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ long f36585j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ i<T> f36586k;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$1", f = "Delay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.r<? extends Object>, kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36587e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            /* synthetic */ Object f36588f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ k1.h<Object> f36589g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.channels.i0<l2> f36590h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(k1.h<Object> hVar, kotlinx.coroutines.channels.i0<l2> i0Var, kotlin.coroutines.d<? super a> dVar) {
                super(2, dVar);
                this.f36589g = hVar;
                this.f36590h = i0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                a aVar = new a(this.f36589g, this.f36590h, dVar);
                aVar.f36588f = obj;
                return aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.d.h();
                if (this.f36587e != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
                T t7 = (T) ((kotlinx.coroutines.channels.r) this.f36588f).o();
                k1.h<Object> hVar = this.f36589g;
                boolean z7 = t7 instanceof kotlinx.coroutines.channels.r.c;
                if (!z7) {
                    hVar.f34872a = t7;
                }
                kotlinx.coroutines.channels.i0<l2> i0Var = this.f36590h;
                if (z7) {
                    Throwable thF = kotlinx.coroutines.channels.r.f(t7);
                    if (thF != null) {
                        throw thF;
                    }
                    i0Var.c(new kotlinx.coroutines.flow.internal.l());
                    hVar.f34872a = (T) kotlinx.coroutines.flow.internal.u.f36396c;
                }
                return l2.f34958a;
            }

            @Override // i5.p
            public /* bridge */ /* synthetic */ Object a0(kotlinx.coroutines.channels.r<? extends Object> rVar, kotlin.coroutines.d<? super l2> dVar) {
                return e0(rVar.o(), dVar);
            }

            @a7.e
            public final Object e0(@a7.d Object obj, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                return ((a) D(kotlinx.coroutines.channels.r.b(obj), dVar)).R(l2.f34958a);
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2", f = "Delay.kt", i = {}, l = {300}, m = "invokeSuspend", n = {}, s = {})
        static final class b extends kotlin.coroutines.jvm.internal.o implements i5.p<l2, kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36591e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ k1.h<Object> f36592f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ j<T> f36593g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(k1.h<Object> hVar, j<? super T> jVar, kotlin.coroutines.d<? super b> dVar) {
                super(2, dVar);
                this.f36592f = hVar;
                this.f36593g = jVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                return new b(this.f36592f, this.f36593g, dVar);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.d to kotlinx.coroutines.flow.r$e$b for r5v1 'this'  kotlin.coroutines.d
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final java.lang.Object R(@a7.d java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.b.h()
                    int r1 = r5.f36591e
                    r2 = 1
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    kotlin.e1.n(r6)
                    goto L36
                Lf:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L17:
                    kotlin.e1.n(r6)
                    kotlin.jvm.internal.k1$h<java.lang.Object> r6 = r5.f36592f
                    T r1 = r6.f34872a
                    if (r1 != 0) goto L23
                    kotlin.l2 r6 = kotlin.l2.f34958a
                    return r6
                L23:
                    r3 = 0
                    r6.f34872a = r3
                    kotlinx.coroutines.flow.j<T> r6 = r5.f36593g
                    kotlinx.coroutines.internal.r0 r4 = kotlinx.coroutines.flow.internal.u.f36394a
                    if (r1 != r4) goto L2d
                    r1 = r3
                L2d:
                    r5.f36591e = r2
                    java.lang.Object r6 = r6.f(r1, r5)
                    if (r6 != r0) goto L36
                    return r0
                L36:
                    kotlin.l2 r6 = kotlin.l2.f34958a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.r.e.b.R(java.lang.Object):java.lang.Object");
            }

            @Override // i5.p
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object a0(@a7.d l2 l2Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                return ((b) D(l2Var, dVar)).R(l2.f34958a);
            }
        }

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", f = "Delay.kt", i = {}, l = {280}, m = "invokeSuspend", n = {}, s = {})
        static final class c extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.channels.g0<? super Object>, kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36594e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36595f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ i<T> f36596g;

            static final class a<T> implements j, kotlin.coroutines.jvm.internal.n {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.channels.g0<Object> f36597a;

                /* JADX INFO: renamed from: kotlinx.coroutines.flow.r$e$c$a$a, reason: collision with other inner class name */
                @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1", f = "Delay.kt", i = {}, l = {280}, m = "emit", n = {}, s = {})
                static final class C0478a extends kotlin.coroutines.jvm.internal.d {

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    /* synthetic */ Object f36598d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    final /* synthetic */ a<T> f36599e;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    int f36600f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0478a(a<? super T> aVar, kotlin.coroutines.d<? super C0478a> dVar) {
                        super(dVar);
                        this.f36599e = aVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @a7.e
                    public final Object R(@a7.d Object obj) {
                        this.f36598d = obj;
                        this.f36600f |= Integer.MIN_VALUE;
                        return this.f36599e.f(null, this);
                    }
                }

                a(kotlinx.coroutines.channels.g0<Object> g0Var) {
                    this.f36597a = g0Var;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlinx.coroutines.flow.j
                @a7.e
                public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                    C0478a c0478a;
                    if (dVar instanceof C0478a) {
                        c0478a = (C0478a) dVar;
                        int i7 = c0478a.f36600f;
                        if ((i7 & Integer.MIN_VALUE) != 0) {
                            c0478a.f36600f = i7 - Integer.MIN_VALUE;
                        } else {
                            c0478a = new C0478a(this, dVar);
                        }
                    } else {
                        c0478a = new C0478a(this, dVar);
                    }
                    Object obj = c0478a.f36598d;
                    Object objH = kotlin.coroutines.intrinsics.d.h();
                    int i8 = c0478a.f36600f;
                    if (i8 == 0) {
                        e1.n(obj);
                        kotlinx.coroutines.channels.g0<Object> g0Var = this.f36597a;
                        if (t7 == null) {
                            t7 = (T) kotlinx.coroutines.flow.internal.u.f36394a;
                        }
                        c0478a.f36600f = 1;
                        if (g0Var.R(t7, c0478a) == objH) {
                            return objH;
                        }
                    } else {
                        if (i8 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj);
                    }
                    return l2.f34958a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            c(i<? extends T> iVar, kotlin.coroutines.d<? super c> dVar) {
                super(2, dVar);
                this.f36596g = iVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.d
            public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
                c cVar = new c(this.f36596g, dVar);
                cVar.f36595f = obj;
                return cVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36594e;
                if (i7 == 0) {
                    e1.n(obj);
                    kotlinx.coroutines.channels.g0 g0Var = (kotlinx.coroutines.channels.g0) this.f36595f;
                    i<T> iVar = this.f36596g;
                    a aVar = new a(g0Var);
                    this.f36594e = 1;
                    if (iVar.a(aVar, this) == objH) {
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
            public final Object a0(@a7.d kotlinx.coroutines.channels.g0<Object> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                return ((c) D(g0Var, dVar)).R(l2.f34958a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(long j7, i<? extends T> iVar, kotlin.coroutines.d<? super e> dVar) {
            super(3, dVar);
            this.f36585j = j7;
            this.f36586k = iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            j jVar;
            kotlinx.coroutines.channels.i0 i0Var;
            k1.h hVar;
            kotlinx.coroutines.channels.i0 i0VarG;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36582g;
            if (i7 == 0) {
                e1.n(obj);
                kotlinx.coroutines.v0 v0Var = (kotlinx.coroutines.v0) this.f36583h;
                j jVar2 = (j) this.f36584i;
                kotlinx.coroutines.channels.i0 i0VarF = kotlinx.coroutines.channels.e0.f(v0Var, null, -1, new c(this.f36586k, null), 1, null);
                k1.h hVar2 = new k1.h();
                jVar = jVar2;
                i0Var = i0VarF;
                hVar = hVar2;
                i0VarG = r.g(v0Var, this.f36585j, 0L, 2, null);
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i0VarG = (kotlinx.coroutines.channels.i0) this.f36581f;
                hVar = (k1.h) this.f36580e;
                i0Var = (kotlinx.coroutines.channels.i0) this.f36584i;
                jVar = (j) this.f36583h;
                e1.n(obj);
            }
            while (hVar.f34872a != kotlinx.coroutines.flow.internal.u.f36396c) {
                this.f36583h = jVar;
                this.f36584i = i0Var;
                this.f36580e = hVar;
                this.f36581f = i0VarG;
                this.f36582g = 1;
                kotlinx.coroutines.selects.b bVar = new kotlinx.coroutines.selects.b(this);
                try {
                    bVar.m(i0Var.l(), new a(hVar, i0VarG, null));
                    bVar.m(i0VarG.k(), new b(hVar, jVar, null));
                } catch (Throwable th) {
                    bVar.e1(th);
                }
                Object objD1 = bVar.d1();
                if (objD1 == kotlin.coroutines.intrinsics.d.h()) {
                    kotlin.coroutines.jvm.internal.h.c(this);
                }
                if (objD1 == objH) {
                    return objH;
                }
            }
            return l2.f34958a;
        }

        @Override // i5.q
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object v(@a7.d kotlinx.coroutines.v0 v0Var, @a7.d j<? super T> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            e eVar = new e(this.f36585j, this.f36586k, dVar);
            eVar.f36583h = v0Var;
            eVar.f36584i = jVar;
            return eVar.R(l2.f34958a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    @e2
    public static final <T> i<T> a(@a7.d i<? extends T> iVar, long j7) {
        if (j7 >= 0) {
            return j7 == 0 ? iVar : e(iVar, new a(j7));
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    }

    @a7.d
    @kotlin.t0
    @e2
    public static final <T> i<T> b(@a7.d i<? extends T> iVar, @a7.d i5.l<? super T, Long> lVar) {
        return e(iVar, lVar);
    }

    @a7.d
    @e2
    public static final <T> i<T> c(@a7.d i<? extends T> iVar, long j7) {
        return k.a0(iVar, g1.e(j7));
    }

    @h5.h(name = "debounceDuration")
    @kotlin.t0
    @e2
    @a7.d
    public static final <T> i<T> d(@a7.d i<? extends T> iVar, @a7.d i5.l<? super T, kotlin.time.d> lVar) {
        return e(iVar, new b(lVar));
    }

    private static final <T> i<T> e(i<? extends T> iVar, i5.l<? super T, Long> lVar) {
        return kotlinx.coroutines.flow.internal.p.b(new c(lVar, iVar, null));
    }

    @a7.d
    public static final kotlinx.coroutines.channels.i0<l2> f(@a7.d kotlinx.coroutines.v0 v0Var, long j7, long j8) {
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j7 + " ms").toString());
        }
        if (j8 >= 0) {
            return kotlinx.coroutines.channels.e0.f(v0Var, null, 0, new d(j8, j7, null), 1, null);
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j8 + " ms").toString());
    }

    public static /* synthetic */ kotlinx.coroutines.channels.i0 g(kotlinx.coroutines.v0 v0Var, long j7, long j8, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            j8 = j7;
        }
        return k.x0(v0Var, j7, j8);
    }

    @a7.d
    @e2
    public static final <T> i<T> h(@a7.d i<? extends T> iVar, long j7) {
        if (j7 > 0) {
            return kotlinx.coroutines.flow.internal.p.b(new e(j7, iVar, null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    @a7.d
    @e2
    public static final <T> i<T> i(@a7.d i<? extends T> iVar, long j7) {
        return k.A1(iVar, g1.e(j7));
    }
}
