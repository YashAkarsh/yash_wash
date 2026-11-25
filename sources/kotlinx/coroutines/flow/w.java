package kotlinx.coroutines.flow;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.e2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f36778a = kotlinx.coroutines.internal.t0.b(k.f36433a, 16, 1, Integer.MAX_VALUE);

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class a<R> implements i<i<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f36779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36780b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.w$a$a, reason: collision with other inner class name */
        public static final class C0484a<T> implements j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ j f36781a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i5.p f36782b;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.w$a$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
            public static final class C0485a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36783d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f36784e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                Object f36785f;

                public C0485a(kotlin.coroutines.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36783d = obj;
                    this.f36784e |= Integer.MIN_VALUE;
                    return C0484a.this.f(null, this);
                }
            }

            public C0484a(j jVar, i5.p pVar) {
                this.f36781a = jVar;
                this.f36782b = pVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(Object obj, @a7.d kotlin.coroutines.d dVar) {
                C0485a c0485a;
                j jVar;
                if (dVar instanceof C0485a) {
                    c0485a = (C0485a) dVar;
                    int i7 = c0485a.f36784e;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0485a.f36784e = i7 - Integer.MIN_VALUE;
                    } else {
                        c0485a = new C0485a(dVar);
                    }
                } else {
                    c0485a = new C0485a(dVar);
                }
                Object obj2 = c0485a.f36783d;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = c0485a.f36784e;
                if (i8 != 0) {
                    if (i8 == 1) {
                        j jVar2 = (j) c0485a.f36785f;
                        e1.n(obj2);
                        jVar = jVar2;
                    } else {
                        if (i8 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj2);
                    }
                    return l2.f34958a;
                }
                e1.n(obj2);
                j jVar3 = this.f36781a;
                i5.p pVar = this.f36782b;
                c0485a.f36785f = jVar3;
                c0485a.f36784e = 1;
                Object objA0 = pVar.a0(obj, c0485a);
                if (objA0 == objH) {
                    return objH;
                }
                obj2 = objA0;
                jVar = jVar3;
                c0485a.f36785f = null;
                c0485a.f36784e = 2;
                if (jVar.f(obj2, c0485a) == objH) {
                    return objH;
                }
                return l2.f34958a;
            }
        }

        public a(i iVar, i5.p pVar) {
            this.f36779a = iVar;
            this.f36780b = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d j jVar, @a7.d kotlin.coroutines.d dVar) {
            Object objA = this.f36779a.a(new C0484a(jVar, this.f36780b), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", i = {}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN, FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend", n = {}, s = {})
    public static final class b<R, T> extends kotlin.coroutines.jvm.internal.o implements i5.q<j<? super R>, T, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36787e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36788f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f36789g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.p<T, kotlin.coroutines.d<? super i<? extends R>>, Object> f36790h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(i5.p<? super T, ? super kotlin.coroutines.d<? super i<? extends R>>, ? extends Object> pVar, kotlin.coroutines.d<? super b> dVar) {
            super(3, dVar);
            this.f36790h = pVar;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.w$b<R, T> for r5v1 'this'  java.lang.Object
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
                int r1 = r5.f36787e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.e1.n(r6)
                goto L47
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                java.lang.Object r1 = r5.f36788f
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                kotlin.e1.n(r6)
                goto L39
            L22:
                kotlin.e1.n(r6)
                java.lang.Object r6 = r5.f36788f
                r1 = r6
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                java.lang.Object r6 = r5.f36789g
                i5.p<T, kotlin.coroutines.d<? super kotlinx.coroutines.flow.i<? extends R>>, java.lang.Object> r4 = r5.f36790h
                r5.f36788f = r1
                r5.f36787e = r3
                java.lang.Object r6 = r4.a0(r6, r5)
                if (r6 != r0) goto L39
                return r0
            L39:
                kotlinx.coroutines.flow.i r6 = (kotlinx.coroutines.flow.i) r6
                r3 = 0
                r5.f36788f = r3
                r5.f36787e = r2
                java.lang.Object r6 = kotlinx.coroutines.flow.k.m0(r1, r6, r5)
                if (r6 != r0) goto L47
                return r0
            L47:
                kotlin.l2 r6 = kotlin.l2.f34958a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.w.b.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.q
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object v(@a7.d j<? super R> jVar, T t7, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            b bVar = new b(this.f36790h, dVar);
            bVar.f36788f = jVar;
            bVar.f36789g = t7;
            return bVar.R(l2.f34958a);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.w$b<R, T> for r2v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @a7.e
        public final java.lang.Object g0(@a7.d java.lang.Object r3) {
            /*
                r2 = this;
                java.lang.Object r3 = r2.f36788f
                kotlinx.coroutines.flow.j r3 = (kotlinx.coroutines.flow.j) r3
                java.lang.Object r0 = r2.f36789g
                i5.p<T, kotlin.coroutines.d<? super kotlinx.coroutines.flow.i<? extends R>>, java.lang.Object> r1 = r2.f36790h
                java.lang.Object r0 = r1.a0(r0, r2)
                kotlinx.coroutines.flow.i r0 = (kotlinx.coroutines.flow.i) r0
                r1 = 0
                kotlin.jvm.internal.i0.e(r1)
                kotlinx.coroutines.flow.k.m0(r3, r0, r2)
                r3 = 1
                kotlin.jvm.internal.i0.e(r3)
                kotlin.l2 r3 = kotlin.l2.f34958a
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.w.b.g0(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class c<R> implements i<i<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f36791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36792b;

        public static final class a<T> implements j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ j f36793a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i5.p f36794b;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.w$c$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", f = "Merge.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
            public static final class C0486a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36795d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f36796e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                Object f36797f;

                public C0486a(kotlin.coroutines.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36795d = obj;
                    this.f36796e |= Integer.MIN_VALUE;
                    return a.this.f(null, this);
                }
            }

            public a(j jVar, i5.p pVar) {
                this.f36793a = jVar;
                this.f36794b = pVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(Object obj, @a7.d kotlin.coroutines.d dVar) {
                C0486a c0486a;
                j jVar;
                if (dVar instanceof C0486a) {
                    c0486a = (C0486a) dVar;
                    int i7 = c0486a.f36796e;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0486a.f36796e = i7 - Integer.MIN_VALUE;
                    } else {
                        c0486a = new C0486a(dVar);
                    }
                } else {
                    c0486a = new C0486a(dVar);
                }
                Object obj2 = c0486a.f36795d;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = c0486a.f36796e;
                if (i8 != 0) {
                    if (i8 == 1) {
                        j jVar2 = (j) c0486a.f36797f;
                        e1.n(obj2);
                        jVar = jVar2;
                    } else {
                        if (i8 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj2);
                    }
                    return l2.f34958a;
                }
                e1.n(obj2);
                j jVar3 = this.f36793a;
                i5.p pVar = this.f36794b;
                c0486a.f36797f = jVar3;
                c0486a.f36796e = 1;
                Object objA0 = pVar.a0(obj, c0486a);
                if (objA0 == objH) {
                    return objH;
                }
                obj2 = objA0;
                jVar = jVar3;
                c0486a.f36797f = null;
                c0486a.f36796e = 2;
                if (jVar.f(obj2, c0486a) == objH) {
                    return objH;
                }
                return l2.f34958a;
            }
        }

        public c(i iVar, i5.p pVar) {
            this.f36791a = iVar;
            this.f36792b = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d j jVar, @a7.d kotlin.coroutines.d dVar) {
            Object objA = this.f36791a.a(new a(jVar, this.f36792b), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f36799a;

        public d(i iVar) {
            this.f36799a = iVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objA = this.f36799a.a(new e(jVar), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    static final class e<T> implements j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<T> f36800a;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$1$1", f = "Merge.kt", i = {}, l = {80}, m = "emit", n = {}, s = {})
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36801d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ e<T> f36802e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36803f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(e<? super T> eVar, kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
                this.f36802e = eVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36801d = obj;
                this.f36803f |= Integer.MIN_VALUE;
                return this.f36802e.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        e(j<? super T> jVar) {
            this.f36800a = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object f(@a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36803f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36803f = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.f36801d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36803f;
            if (i8 == 0) {
                e1.n(obj);
                j<T> jVar = this.f36800a;
                aVar.f36803f = 1;
                if (k.m0(jVar, iVar, aVar) == objH) {
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

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", i = {}, l = {214, 214}, m = "invokeSuspend", n = {}, s = {})
    static final class f<R, T> extends kotlin.coroutines.jvm.internal.o implements i5.q<j<? super R>, T, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36804e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36805f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f36806g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.p<T, kotlin.coroutines.d<? super R>, Object> f36807h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(i5.p<? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, kotlin.coroutines.d<? super f> dVar) {
            super(3, dVar);
            this.f36807h = pVar;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.w$f<R, T> for r5v1 'this'  java.lang.Object
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
                int r1 = r5.f36804e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.e1.n(r6)
                goto L45
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                java.lang.Object r1 = r5.f36805f
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                kotlin.e1.n(r6)
                goto L39
            L22:
                kotlin.e1.n(r6)
                java.lang.Object r6 = r5.f36805f
                r1 = r6
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                java.lang.Object r6 = r5.f36806g
                i5.p<T, kotlin.coroutines.d<? super R>, java.lang.Object> r4 = r5.f36807h
                r5.f36805f = r1
                r5.f36804e = r3
                java.lang.Object r6 = r4.a0(r6, r5)
                if (r6 != r0) goto L39
                return r0
            L39:
                r3 = 0
                r5.f36805f = r3
                r5.f36804e = r2
                java.lang.Object r6 = r1.f(r6, r5)
                if (r6 != r0) goto L45
                return r0
            L45:
                kotlin.l2 r6 = kotlin.l2.f34958a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.w.f.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.q
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object v(@a7.d j<? super R> jVar, T t7, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            f fVar = new f(this.f36807h, dVar);
            fVar.f36805f = jVar;
            fVar.f36806g = t7;
            return fVar.R(l2.f34958a);
        }
    }

    @a7.d
    @e2
    public static final <T, R> i<R> a(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super i<? extends R>>, ? extends Object> pVar) {
        return k.F0(new a(iVar, pVar));
    }

    @a7.d
    @d2
    public static final <T, R> i<R> b(@a7.d i<? extends T> iVar, @a7.d @kotlin.b i5.p<? super T, ? super kotlin.coroutines.d<? super i<? extends R>>, ? extends Object> pVar) {
        return k.b2(iVar, new b(pVar, null));
    }

    @a7.d
    @e2
    public static final <T, R> i<R> c(@a7.d i<? extends T> iVar, int i7, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super i<? extends R>>, ? extends Object> pVar) {
        return k.G0(new c(iVar, pVar), i7);
    }

    public static /* synthetic */ i d(i iVar, int i7, i5.p pVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = f36778a;
        }
        return k.C0(iVar, i7, pVar);
    }

    @a7.d
    @e2
    public static final <T> i<T> e(@a7.d i<? extends i<? extends T>> iVar) {
        return new d(iVar);
    }

    @a7.d
    @e2
    public static final <T> i<T> f(@a7.d i<? extends i<? extends T>> iVar, int i7) {
        if (i7 > 0) {
            return i7 == 1 ? k.F0(iVar) : new kotlinx.coroutines.flow.internal.g(iVar, i7, null, 0, null, 28, null);
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.l0.C("Expected positive concurrency level, but had ", Integer.valueOf(i7)).toString());
    }

    public static /* synthetic */ i g(i iVar, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = f36778a;
        }
        return k.G0(iVar, i7);
    }

    public static final int h() {
        return f36778a;
    }

    @e2
    public static /* synthetic */ void i() {
    }

    @e2
    public static /* synthetic */ void j() {
    }

    @a7.d
    @d2
    public static final <T, R> i<R> k(@a7.d i<? extends T> iVar, @a7.d @kotlin.b i5.p<? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        return k.b2(iVar, new f(pVar, null));
    }

    @a7.d
    public static final <T> i<T> l(@a7.d Iterable<? extends i<? extends T>> iterable) {
        return new kotlinx.coroutines.flow.internal.k(iterable, null, 0, null, 14, null);
    }

    @a7.d
    public static final <T> i<T> m(@a7.d i<? extends T>... iVarArr) {
        return k.Y0(kotlin.collections.p.c6(iVarArr));
    }

    @a7.d
    @d2
    public static final <T, R> i<R> n(@a7.d i<? extends T> iVar, @a7.d @kotlin.b i5.q<? super j<? super R>, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        return new kotlinx.coroutines.flow.internal.j(qVar, iVar, null, 0, null, 28, null);
    }
}
