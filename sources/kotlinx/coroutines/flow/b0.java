package kotlinx.coroutines.flow;

import kotlin.e1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class b0 {

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class a<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i[] f36115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.r f36116b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.b0$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", i = {}, l = {333, 333}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0460a extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, Object[], kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36117e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36118f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36119g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i5.r f36120h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0460a(kotlin.coroutines.d dVar, i5.r rVar) {
                super(3, dVar);
                this.f36120h = rVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                kotlinx.coroutines.flow.j jVar;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36117e;
                if (i7 != 0) {
                    if (i7 == 1) {
                        jVar = (kotlinx.coroutines.flow.j) this.f36118f;
                        e1.n(obj);
                    } else {
                        if (i7 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj);
                    }
                    return l2.f34958a;
                }
                e1.n(obj);
                jVar = (kotlinx.coroutines.flow.j) this.f36118f;
                Object[] objArr = (Object[]) this.f36119g;
                i5.r rVar = this.f36120h;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                this.f36118f = jVar;
                this.f36117e = 1;
                kotlin.jvm.internal.i0.e(6);
                obj = rVar.K(obj2, obj3, obj4, this);
                kotlin.jvm.internal.i0.e(7);
                if (obj == objH) {
                    return objH;
                }
                this.f36118f = null;
                this.f36117e = 2;
                if (jVar.f(obj, this) == objH) {
                    return objH;
                }
                return l2.f34958a;
            }

            @Override // i5.q
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d Object[] objArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                C0460a c0460a = new C0460a(dVar, this.f36120h);
                c0460a.f36118f = jVar;
                c0460a.f36119g = objArr;
                return c0460a.R(l2.f34958a);
            }
        }

        public a(kotlinx.coroutines.flow.i[] iVarArr, i5.r rVar) {
            this.f36115a = iVarArr;
            this.f36116b = rVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            Object objA = kotlinx.coroutines.flow.internal.m.a(jVar, this.f36115a, b0.r(), new C0460a(null, this.f36116b), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class b<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i[] f36121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.s f36122b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", i = {}, l = {333, 333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, Object[], kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36123e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36124f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36125g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i5.s f36126h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(kotlin.coroutines.d dVar, i5.s sVar) {
                super(3, dVar);
                this.f36126h = sVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                kotlinx.coroutines.flow.j jVar;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36123e;
                if (i7 != 0) {
                    if (i7 == 1) {
                        jVar = (kotlinx.coroutines.flow.j) this.f36124f;
                        e1.n(obj);
                    } else {
                        if (i7 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj);
                    }
                    return l2.f34958a;
                }
                e1.n(obj);
                jVar = (kotlinx.coroutines.flow.j) this.f36124f;
                Object[] objArr = (Object[]) this.f36125g;
                i5.s sVar = this.f36126h;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                this.f36124f = jVar;
                this.f36123e = 1;
                kotlin.jvm.internal.i0.e(6);
                obj = sVar.d0(obj2, obj3, obj4, obj5, this);
                kotlin.jvm.internal.i0.e(7);
                if (obj == objH) {
                    return objH;
                }
                this.f36124f = null;
                this.f36123e = 2;
                if (jVar.f(obj, this) == objH) {
                    return objH;
                }
                return l2.f34958a;
            }

            @Override // i5.q
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d Object[] objArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                a aVar = new a(dVar, this.f36126h);
                aVar.f36124f = jVar;
                aVar.f36125g = objArr;
                return aVar.R(l2.f34958a);
            }
        }

        public b(kotlinx.coroutines.flow.i[] iVarArr, i5.s sVar) {
            this.f36121a = iVarArr;
            this.f36122b = sVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            Object objA = kotlinx.coroutines.flow.internal.m.a(jVar, this.f36121a, b0.r(), new a(null, this.f36122b), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class c<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i[] f36127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.t f36128b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", f = "Zip.kt", i = {}, l = {333, 333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, Object[], kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36129e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36130f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36131g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i5.t f36132h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(kotlin.coroutines.d dVar, i5.t tVar) {
                super(3, dVar);
                this.f36132h = tVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                kotlinx.coroutines.flow.j jVar;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36129e;
                if (i7 != 0) {
                    if (i7 == 1) {
                        jVar = (kotlinx.coroutines.flow.j) this.f36130f;
                        e1.n(obj);
                    } else {
                        if (i7 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj);
                    }
                    return l2.f34958a;
                }
                e1.n(obj);
                jVar = (kotlinx.coroutines.flow.j) this.f36130f;
                Object[] objArr = (Object[]) this.f36131g;
                i5.t tVar = this.f36132h;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                this.f36130f = jVar;
                this.f36129e = 1;
                kotlin.jvm.internal.i0.e(6);
                obj = tVar.W(obj2, obj3, obj4, obj5, obj6, this);
                kotlin.jvm.internal.i0.e(7);
                if (obj == objH) {
                    return objH;
                }
                this.f36130f = null;
                this.f36129e = 2;
                if (jVar.f(obj, this) == objH) {
                    return objH;
                }
                return l2.f34958a;
            }

            @Override // i5.q
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d Object[] objArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                a aVar = new a(dVar, this.f36132h);
                aVar.f36130f = jVar;
                aVar.f36131g = objArr;
                return aVar.R(l2.f34958a);
            }
        }

        public c(kotlinx.coroutines.flow.i[] iVarArr, i5.t tVar) {
            this.f36127a = iVarArr;
            this.f36128b = tVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            Object objA = kotlinx.coroutines.flow.internal.m.a(jVar, this.f36127a, b0.r(), new a(null, this.f36128b), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class d<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.q f36135c;

        public d(kotlinx.coroutines.flow.i iVar, kotlinx.coroutines.flow.i iVar2, i5.q qVar) {
            this.f36133a = iVar;
            this.f36134b = iVar2;
            this.f36135c = qVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objA = kotlinx.coroutines.flow.internal.m.a(jVar, new kotlinx.coroutines.flow.i[]{this.f36133a, this.f36134b}, b0.r(), new g(this.f36135c, null), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class e<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i[] f36136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36137b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36138d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36139e;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36138d = obj;
                this.f36139e |= Integer.MIN_VALUE;
                return e.this.a(null, this);
            }
        }

        public e(kotlinx.coroutines.flow.i[] iVarArr, i5.p pVar) {
            this.f36136a = iVarArr;
            this.f36137b = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            kotlinx.coroutines.flow.i[] iVarArr = this.f36136a;
            kotlin.jvm.internal.l0.w();
            h hVar = new h(this.f36136a);
            kotlin.jvm.internal.l0.w();
            Object objA = kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, hVar, new i(this.f36137b, null), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }

        @a7.e
        public Object d(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(dVar);
            kotlin.jvm.internal.i0.e(5);
            kotlinx.coroutines.flow.i[] iVarArr = this.f36136a;
            kotlin.jvm.internal.l0.w();
            h hVar = new h(this.f36136a);
            kotlin.jvm.internal.l0.w();
            i iVar = new i(this.f36137b, null);
            kotlin.jvm.internal.i0.e(0);
            kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, hVar, iVar, dVar);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class f<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i[] f36141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36142b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36143d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36144e;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36143d = obj;
                this.f36144e |= Integer.MIN_VALUE;
                return f.this.a(null, this);
            }
        }

        public f(kotlinx.coroutines.flow.i[] iVarArr, i5.p pVar) {
            this.f36141a = iVarArr;
            this.f36142b = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            kotlinx.coroutines.flow.i[] iVarArr = this.f36141a;
            kotlin.jvm.internal.l0.w();
            j jVar2 = new j(this.f36141a);
            kotlin.jvm.internal.l0.w();
            Object objA = kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, jVar2, new k(this.f36142b, null), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }

        @a7.e
        public Object d(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(dVar);
            kotlin.jvm.internal.i0.e(5);
            kotlinx.coroutines.flow.i[] iVarArr = this.f36141a;
            kotlin.jvm.internal.l0.w();
            j jVar2 = new j(this.f36141a);
            kotlin.jvm.internal.l0.w();
            k kVar = new k(this.f36142b, null);
            kotlin.jvm.internal.i0.e(0);
            kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, jVar2, kVar, dVar);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", i = {}, l = {33, 33}, m = "invokeSuspend", n = {}, s = {})
    static final class g<R> extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, Object[], kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36146e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36147f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f36148g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.q<T1, T2, kotlin.coroutines.d<? super R>, Object> f36149h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g(i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar, kotlin.coroutines.d<? super g> dVar) {
            super(3, dVar);
            this.f36149h = qVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.b0$g<R> for r6v1 'this'  java.lang.Object
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
                int r1 = r6.f36146e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.e1.n(r7)
                goto L4c
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                java.lang.Object r1 = r6.f36147f
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                kotlin.e1.n(r7)
                goto L40
            L22:
                kotlin.e1.n(r7)
                java.lang.Object r7 = r6.f36147f
                r1 = r7
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1
                java.lang.Object r7 = r6.f36148g
                java.lang.Object[] r7 = (java.lang.Object[]) r7
                i5.q<T1, T2, kotlin.coroutines.d<? super R>, java.lang.Object> r4 = r6.f36149h
                r5 = 0
                r5 = r7[r5]
                r7 = r7[r3]
                r6.f36147f = r1
                r6.f36146e = r3
                java.lang.Object r7 = r4.v(r5, r7, r6)
                if (r7 != r0) goto L40
                return r0
            L40:
                r3 = 0
                r6.f36147f = r3
                r6.f36146e = r2
                java.lang.Object r7 = r1.f(r7, r6)
                if (r7 != r0) goto L4c
                return r0
            L4c:
                kotlin.l2 r7 = kotlin.l2.f34958a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.b0.g.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.q
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d Object[] objArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            g gVar = new g(this.f36149h, dVar);
            gVar.f36147f = jVar;
            gVar.f36148g = objArr;
            return gVar.R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class h<T> extends kotlin.jvm.internal.n0 implements i5.a<T[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T>[] f36150a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public h(kotlinx.coroutines.flow.i<? extends T>[] iVarArr) {
            super(0);
            this.f36150a = iVarArr;
        }

        @Override // i5.a
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final T[] invoke() {
            int length = this.f36150a.length;
            kotlin.jvm.internal.l0.y(0, "T?");
            return (T[]) new Object[length];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$5$2", f = "Zip.kt", i = {}, l = {238, 238}, m = "invokeSuspend", n = {}, s = {})
    public static final class i<R, T> extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36151e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36152f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f36153g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.p<T[], kotlin.coroutines.d<? super R>, Object> f36154h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public i(i5.p<? super T[], ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, kotlin.coroutines.d<? super i> dVar) {
            super(3, dVar);
            this.f36154h = pVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlinx.coroutines.flow.j jVar;
            kotlinx.coroutines.flow.j jVar2;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36151e;
            if (i7 != 0) {
                if (i7 == 1) {
                    kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) this.f36152f;
                    e1.n(obj);
                    jVar2 = jVar3;
                } else {
                    if (i7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj);
                }
                return l2.f34958a;
            }
            e1.n(obj);
            jVar = (kotlinx.coroutines.flow.j) this.f36152f;
            Object[] objArr = (Object[]) this.f36153g;
            i5.p<T[], kotlin.coroutines.d<? super R>, Object> pVar = this.f36154h;
            this.f36152f = jVar;
            this.f36151e = 1;
            obj = pVar.a0(objArr, this);
            if (obj == objH) {
                jVar2 = jVar;
                return objH;
            }
            jVar2 = jVar;
            this.f36152f = null;
            this.f36151e = 2;
            if (jVar2.f(obj, this) == objH) {
                return objH;
            }
            return l2.f34958a;
        }

        @Override // i5.q
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d T[] tArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            i iVar = new i(this.f36154h, dVar);
            iVar.f36152f = jVar;
            iVar.f36153g = tArr;
            return iVar.R(l2.f34958a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @a7.e
        public final Object g0(@a7.d Object obj) {
            kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36152f;
            Object objA0 = this.f36154h.a0((Object[]) this.f36153g, this);
            kotlin.jvm.internal.i0.e(0);
            jVar.f(objA0, this);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class j<T> extends kotlin.jvm.internal.n0 implements i5.a<T[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T>[] f36155a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(kotlinx.coroutines.flow.i<T>[] iVarArr) {
            super(0);
            this.f36155a = iVarArr;
        }

        @Override // i5.a
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final T[] invoke() {
            int length = this.f36155a.length;
            kotlin.jvm.internal.l0.y(0, "T?");
            return (T[]) new Object[length];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2", f = "Zip.kt", i = {}, l = {292, 292}, m = "invokeSuspend", n = {}, s = {})
    public static final class k<R, T> extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36156e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36157f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f36158g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.p<T[], kotlin.coroutines.d<? super R>, Object> f36159h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public k(i5.p<? super T[], ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, kotlin.coroutines.d<? super k> dVar) {
            super(3, dVar);
            this.f36159h = pVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlinx.coroutines.flow.j jVar;
            kotlinx.coroutines.flow.j jVar2;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36156e;
            if (i7 != 0) {
                if (i7 == 1) {
                    kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) this.f36157f;
                    e1.n(obj);
                    jVar2 = jVar3;
                } else {
                    if (i7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj);
                }
                return l2.f34958a;
            }
            e1.n(obj);
            jVar = (kotlinx.coroutines.flow.j) this.f36157f;
            Object[] objArr = (Object[]) this.f36158g;
            i5.p<T[], kotlin.coroutines.d<? super R>, Object> pVar = this.f36159h;
            this.f36157f = jVar;
            this.f36156e = 1;
            obj = pVar.a0(objArr, this);
            if (obj == objH) {
                jVar2 = jVar;
                return objH;
            }
            jVar2 = jVar;
            this.f36157f = null;
            this.f36156e = 2;
            if (jVar2.f(obj, this) == objH) {
                return objH;
            }
            return l2.f34958a;
        }

        @Override // i5.q
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d T[] tArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            k kVar = new k(this.f36159h, dVar);
            kVar.f36157f = jVar;
            kVar.f36158g = tArr;
            return kVar.R(l2.f34958a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @a7.e
        public final Object g0(@a7.d Object obj) {
            kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36157f;
            Object objA0 = this.f36159h.a0((Object[]) this.f36158g, this);
            kotlin.jvm.internal.i0.e(0);
            jVar.f(objA0, this);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class l<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36161f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i[] f36162g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.r f36163h;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, Object[], kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36164e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36165f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36166g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i5.r f36167h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(kotlin.coroutines.d dVar, i5.r rVar) {
                super(3, dVar);
                this.f36167h = rVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36164e;
                if (i7 == 0) {
                    e1.n(obj);
                    kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36165f;
                    Object[] objArr = (Object[]) this.f36166g;
                    i5.r rVar = this.f36167h;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    this.f36164e = 1;
                    kotlin.jvm.internal.i0.e(6);
                    Object objK = rVar.K(jVar, obj2, obj3, this);
                    kotlin.jvm.internal.i0.e(7);
                    if (objK == objH) {
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

            @Override // i5.q
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d Object[] objArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                a aVar = new a(dVar, this.f36167h);
                aVar.f36165f = jVar;
                aVar.f36166g = objArr;
                return aVar.R(l2.f34958a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(kotlinx.coroutines.flow.i[] iVarArr, kotlin.coroutines.d dVar, i5.r rVar) {
            super(2, dVar);
            this.f36162g = iVarArr;
            this.f36163h = rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            l lVar = new l(this.f36162g, dVar, this.f36163h);
            lVar.f36161f = obj;
            return lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36160e;
            if (i7 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36161f;
                kotlinx.coroutines.flow.i[] iVarArr = this.f36162g;
                i5.a aVarR = b0.r();
                a aVar = new a(null, this.f36163h);
                this.f36160e = 1;
                if (kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVarR, aVar, this) == objH) {
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
        public final Object a0(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((l) D(jVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class m<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36168e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36169f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i[] f36170g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.r f36171h;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$2$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, Object[], kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36172e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36173f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36174g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i5.r f36175h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(kotlin.coroutines.d dVar, i5.r rVar) {
                super(3, dVar);
                this.f36175h = rVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36172e;
                if (i7 == 0) {
                    e1.n(obj);
                    kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36173f;
                    Object[] objArr = (Object[]) this.f36174g;
                    i5.r rVar = this.f36175h;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    this.f36172e = 1;
                    kotlin.jvm.internal.i0.e(6);
                    Object objK = rVar.K(jVar, obj2, obj3, this);
                    kotlin.jvm.internal.i0.e(7);
                    if (objK == objH) {
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

            @Override // i5.q
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d Object[] objArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                a aVar = new a(dVar, this.f36175h);
                aVar.f36173f = jVar;
                aVar.f36174g = objArr;
                return aVar.R(l2.f34958a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(kotlinx.coroutines.flow.i[] iVarArr, kotlin.coroutines.d dVar, i5.r rVar) {
            super(2, dVar);
            this.f36170g = iVarArr;
            this.f36171h = rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            m mVar = new m(this.f36170g, dVar, this.f36171h);
            mVar.f36169f = obj;
            return mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36168e;
            if (i7 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36169f;
                kotlinx.coroutines.flow.i[] iVarArr = this.f36170g;
                i5.a aVarR = b0.r();
                a aVar = new a(null, this.f36171h);
                this.f36168e = 1;
                if (kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVarR, aVar, this) == objH) {
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
        public final Object a0(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((m) D(jVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class n<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36176e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36177f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i[] f36178g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.s f36179h;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, Object[], kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36180e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36181f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36182g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i5.s f36183h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(kotlin.coroutines.d dVar, i5.s sVar) {
                super(3, dVar);
                this.f36183h = sVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36180e;
                if (i7 == 0) {
                    e1.n(obj);
                    kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36181f;
                    Object[] objArr = (Object[]) this.f36182g;
                    i5.s sVar = this.f36183h;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    this.f36180e = 1;
                    kotlin.jvm.internal.i0.e(6);
                    Object objD0 = sVar.d0(jVar, obj2, obj3, obj4, this);
                    kotlin.jvm.internal.i0.e(7);
                    if (objD0 == objH) {
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

            @Override // i5.q
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d Object[] objArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                a aVar = new a(dVar, this.f36183h);
                aVar.f36181f = jVar;
                aVar.f36182g = objArr;
                return aVar.R(l2.f34958a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(kotlinx.coroutines.flow.i[] iVarArr, kotlin.coroutines.d dVar, i5.s sVar) {
            super(2, dVar);
            this.f36178g = iVarArr;
            this.f36179h = sVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            n nVar = new n(this.f36178g, dVar, this.f36179h);
            nVar.f36177f = obj;
            return nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36176e;
            if (i7 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36177f;
                kotlinx.coroutines.flow.i[] iVarArr = this.f36178g;
                i5.a aVarR = b0.r();
                a aVar = new a(null, this.f36179h);
                this.f36176e = 1;
                if (kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVarR, aVar, this) == objH) {
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
        public final Object a0(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((n) D(jVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class o<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36184e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36185f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i[] f36186g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.t f36187h;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$4$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, Object[], kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36188e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36189f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36190g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i5.t f36191h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(kotlin.coroutines.d dVar, i5.t tVar) {
                super(3, dVar);
                this.f36191h = tVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36188e;
                if (i7 == 0) {
                    e1.n(obj);
                    kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36189f;
                    Object[] objArr = (Object[]) this.f36190g;
                    i5.t tVar = this.f36191h;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    Object obj5 = objArr[3];
                    this.f36188e = 1;
                    kotlin.jvm.internal.i0.e(6);
                    Object objW = tVar.W(jVar, obj2, obj3, obj4, obj5, this);
                    kotlin.jvm.internal.i0.e(7);
                    if (objW == objH) {
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

            @Override // i5.q
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d Object[] objArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                a aVar = new a(dVar, this.f36191h);
                aVar.f36189f = jVar;
                aVar.f36190g = objArr;
                return aVar.R(l2.f34958a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(kotlinx.coroutines.flow.i[] iVarArr, kotlin.coroutines.d dVar, i5.t tVar) {
            super(2, dVar);
            this.f36186g = iVarArr;
            this.f36187h = tVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            o oVar = new o(this.f36186g, dVar, this.f36187h);
            oVar.f36185f = obj;
            return oVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36184e;
            if (i7 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36185f;
                kotlinx.coroutines.flow.i[] iVarArr = this.f36186g;
                i5.a aVarR = b0.r();
                a aVar = new a(null, this.f36187h);
                this.f36184e = 1;
                if (kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVarR, aVar, this) == objH) {
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
        public final Object a0(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((o) D(jVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class p<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36192e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36193f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i[] f36194g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.u f36195h;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5$1", f = "Zip.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, Object[], kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36196e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36197f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36198g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i5.u f36199h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(kotlin.coroutines.d dVar, i5.u uVar) {
                super(3, dVar);
                this.f36199h = uVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36196e;
                if (i7 == 0) {
                    e1.n(obj);
                    kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36197f;
                    Object[] objArr = (Object[]) this.f36198g;
                    i5.u uVar = this.f36199h;
                    Object obj2 = objArr[0];
                    Object obj3 = objArr[1];
                    Object obj4 = objArr[2];
                    Object obj5 = objArr[3];
                    Object obj6 = objArr[4];
                    this.f36196e = 1;
                    kotlin.jvm.internal.i0.e(6);
                    Object objH0 = uVar.h0(jVar, obj2, obj3, obj4, obj5, obj6, this);
                    kotlin.jvm.internal.i0.e(7);
                    if (objH0 == objH) {
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

            @Override // i5.q
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d Object[] objArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                a aVar = new a(dVar, this.f36199h);
                aVar.f36197f = jVar;
                aVar.f36198g = objArr;
                return aVar.R(l2.f34958a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(kotlinx.coroutines.flow.i[] iVarArr, kotlin.coroutines.d dVar, i5.u uVar) {
            super(2, dVar);
            this.f36194g = iVarArr;
            this.f36195h = uVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            p pVar = new p(this.f36194g, dVar, this.f36195h);
            pVar.f36193f = obj;
            return pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36192e;
            if (i7 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36193f;
                kotlinx.coroutines.flow.i[] iVarArr = this.f36194g;
                i5.a aVarR = b0.r();
                a aVar = new a(null, this.f36195h);
                this.f36192e = 1;
                if (kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVarR, aVar, this) == objH) {
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
        public final Object a0(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((p) D(jVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", f = "Zip.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    public static final class q<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36200e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36201f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T>[] f36202g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> f36203h;

        /* JADX INFO: Add missing generic type declarations: [T] */
        public static final class a<T> extends kotlin.jvm.internal.n0 implements i5.a<T[]> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i<T>[] f36204a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(kotlinx.coroutines.flow.i<? extends T>[] iVarArr) {
                super(0);
                this.f36204a = iVarArr;
            }

            @Override // i5.a
            @a7.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final T[] invoke() {
                int length = this.f36204a.length;
                kotlin.jvm.internal.l0.y(0, "T?");
                return (T[]) new Object[length];
            }
        }

        /* JADX INFO: Add missing generic type declarations: [T] */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", f = "Zip.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
        public static final class b<T> extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36205e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36206f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36207g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> f36208h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, kotlin.coroutines.d<? super b> dVar) {
                super(3, dVar);
                this.f36208h = qVar;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36205e;
                if (i7 == 0) {
                    e1.n(obj);
                    kotlinx.coroutines.flow.j<? super R> jVar = (kotlinx.coroutines.flow.j) this.f36206f;
                    Object[] objArr = (Object[]) this.f36207g;
                    i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> qVar = this.f36208h;
                    this.f36206f = null;
                    this.f36205e = 1;
                    if (qVar.v(jVar, objArr, this) == objH) {
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

            @Override // i5.q
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d T[] tArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                b bVar = new b(this.f36208h, dVar);
                bVar.f36206f = jVar;
                bVar.f36207g = tArr;
                return bVar.R(l2.f34958a);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @a7.e
            public final Object g0(@a7.d Object obj) {
                this.f36208h.v((kotlinx.coroutines.flow.j) this.f36206f, (Object[]) this.f36207g, this);
                return l2.f34958a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public q(kotlinx.coroutines.flow.i<? extends T>[] iVarArr, i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, kotlin.coroutines.d<? super q> dVar) {
            super(2, dVar);
            this.f36202g = iVarArr;
            this.f36203h = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            q qVar = new q(this.f36202g, this.f36203h, dVar);
            qVar.f36201f = obj;
            return qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36200e;
            if (i7 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36201f;
                kotlinx.coroutines.flow.i<T>[] iVarArr = this.f36202g;
                kotlin.jvm.internal.l0.w();
                a aVar = new a(this.f36202g);
                kotlin.jvm.internal.l0.w();
                b bVar = new b(this.f36203h, null);
                this.f36200e = 1;
                if (kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVar, bVar, this) == objH) {
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
        public final Object a0(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((q) D(jVar, dVar)).R(l2.f34958a);
        }

        @a7.e
        public final Object g0(@a7.d Object obj) {
            kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36201f;
            kotlinx.coroutines.flow.i<T>[] iVarArr = this.f36202g;
            kotlin.jvm.internal.l0.w();
            a aVar = new a(this.f36202g);
            kotlin.jvm.internal.l0.w();
            b bVar = new b(this.f36203h, null);
            kotlin.jvm.internal.i0.e(0);
            kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVar, bVar, this);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
    public static final class r<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36209e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36210f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T>[] f36211g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> f36212h;

        /* JADX INFO: Add missing generic type declarations: [T] */
        public static final class a<T> extends kotlin.jvm.internal.n0 implements i5.a<T[]> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i<T>[] f36213a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(kotlinx.coroutines.flow.i<T>[] iVarArr) {
                super(0);
                this.f36213a = iVarArr;
            }

            @Override // i5.a
            @a7.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final T[] invoke() {
                int length = this.f36213a.length;
                kotlin.jvm.internal.l0.y(0, "T?");
                return (T[]) new Object[length];
            }
        }

        /* JADX INFO: Add missing generic type declarations: [T] */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
        public static final class b<T> extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36214e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36215f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36216g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> f36217h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, kotlin.coroutines.d<? super b> dVar) {
                super(3, dVar);
                this.f36217h = qVar;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36214e;
                if (i7 == 0) {
                    e1.n(obj);
                    kotlinx.coroutines.flow.j<? super R> jVar = (kotlinx.coroutines.flow.j) this.f36215f;
                    Object[] objArr = (Object[]) this.f36216g;
                    i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> qVar = this.f36217h;
                    this.f36215f = null;
                    this.f36214e = 1;
                    if (qVar.v(jVar, objArr, this) == objH) {
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

            @Override // i5.q
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d T[] tArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                b bVar = new b(this.f36217h, dVar);
                bVar.f36215f = jVar;
                bVar.f36216g = tArr;
                return bVar.R(l2.f34958a);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @a7.e
            public final Object g0(@a7.d Object obj) {
                this.f36217h.v((kotlinx.coroutines.flow.j) this.f36215f, (Object[]) this.f36216g, this);
                return l2.f34958a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public r(kotlinx.coroutines.flow.i<T>[] iVarArr, i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, kotlin.coroutines.d<? super r> dVar) {
            super(2, dVar);
            this.f36211g = iVarArr;
            this.f36212h = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            r rVar = new r(this.f36211g, this.f36212h, dVar);
            rVar.f36210f = obj;
            return rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36209e;
            if (i7 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36210f;
                kotlinx.coroutines.flow.i<T>[] iVarArr = this.f36211g;
                kotlin.jvm.internal.l0.w();
                a aVar = new a(this.f36211g);
                kotlin.jvm.internal.l0.w();
                b bVar = new b(this.f36212h, null);
                this.f36209e = 1;
                if (kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVar, bVar, this) == objH) {
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
        public final Object a0(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((r) D(jVar, dVar)).R(l2.f34958a);
        }

        @a7.e
        public final Object g0(@a7.d Object obj) {
            kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36210f;
            kotlinx.coroutines.flow.i<T>[] iVarArr = this.f36211g;
            kotlin.jvm.internal.l0.w();
            a aVar = new a(this.f36211g);
            kotlin.jvm.internal.l0.w();
            b bVar = new b(this.f36212h, null);
            kotlin.jvm.internal.i0.e(0);
            kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVar, bVar, this);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    public static final class s<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36218e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36219f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T>[] f36220g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> f36221h;

        /* JADX INFO: Add missing generic type declarations: [T] */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1", f = "Zip.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
        public static final class a<T> extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36222e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private /* synthetic */ Object f36223f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f36224g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> f36225h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, kotlin.coroutines.d<? super a> dVar) {
                super(3, dVar);
                this.f36225h = qVar;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i7 = this.f36222e;
                if (i7 == 0) {
                    e1.n(obj);
                    kotlinx.coroutines.flow.j<? super R> jVar = (kotlinx.coroutines.flow.j) this.f36223f;
                    Object[] objArr = (Object[]) this.f36224g;
                    i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> qVar = this.f36225h;
                    this.f36223f = null;
                    this.f36222e = 1;
                    if (qVar.v(jVar, objArr, this) == objH) {
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

            @Override // i5.q
            @a7.e
            /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
            public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d T[] tArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
                a aVar = new a(this.f36225h, dVar);
                aVar.f36223f = jVar;
                aVar.f36224g = tArr;
                return aVar.R(l2.f34958a);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @a7.e
            public final Object g0(@a7.d Object obj) {
                this.f36225h.v((kotlinx.coroutines.flow.j) this.f36223f, (Object[]) this.f36224g, this);
                return l2.f34958a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public s(kotlinx.coroutines.flow.i<? extends T>[] iVarArr, i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, kotlin.coroutines.d<? super s> dVar) {
            super(2, dVar);
            this.f36220g = iVarArr;
            this.f36221h = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            s sVar = new s(this.f36220g, this.f36221h, dVar);
            sVar.f36219f = obj;
            return sVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36218e;
            if (i7 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36219f;
                kotlinx.coroutines.flow.i<T>[] iVarArr = this.f36220g;
                i5.a aVarR = b0.r();
                kotlin.jvm.internal.l0.w();
                a aVar = new a(this.f36221h, null);
                this.f36218e = 1;
                if (kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVarR, aVar, this) == objH) {
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
        public final Object a0(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((s) D(jVar, dVar)).R(l2.f34958a);
        }

        @a7.e
        public final Object g0(@a7.d Object obj) {
            kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36219f;
            kotlinx.coroutines.flow.i<T>[] iVarArr = this.f36220g;
            i5.a aVarR = b0.r();
            kotlin.jvm.internal.l0.w();
            a aVar = new a(this.f36221h, null);
            kotlin.jvm.internal.i0.e(0);
            kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVarR, aVar, this);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class t<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i[] f36226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36227b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36228d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36229e;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36228d = obj;
                this.f36229e |= Integer.MIN_VALUE;
                return t.this.a(null, this);
            }
        }

        public t(kotlinx.coroutines.flow.i[] iVarArr, i5.p pVar) {
            this.f36226a = iVarArr;
            this.f36227b = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            kotlinx.coroutines.flow.i[] iVarArr = this.f36226a;
            i5.a aVarR = b0.r();
            kotlin.jvm.internal.l0.w();
            Object objA = kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVarR, new u(this.f36227b, null), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }

        @a7.e
        public Object d(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(dVar);
            kotlin.jvm.internal.i0.e(5);
            kotlinx.coroutines.flow.i[] iVarArr = this.f36226a;
            i5.a aVarR = b0.r();
            kotlin.jvm.internal.l0.w();
            u uVar = new u(this.f36227b, null);
            kotlin.jvm.internal.i0.e(0);
            kotlinx.coroutines.flow.internal.m.a(jVar, iVarArr, aVarR, uVar, dVar);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$1$1", f = "Zip.kt", i = {}, l = {262, 262}, m = "invokeSuspend", n = {}, s = {})
    public static final class u<R, T> extends kotlin.coroutines.jvm.internal.o implements i5.q<kotlinx.coroutines.flow.j<? super R>, T[], kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36231e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36232f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f36233g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.p<T[], kotlin.coroutines.d<? super R>, Object> f36234h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public u(i5.p<? super T[], ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar, kotlin.coroutines.d<? super u> dVar) {
            super(3, dVar);
            this.f36234h = pVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlinx.coroutines.flow.j jVar;
            kotlinx.coroutines.flow.j jVar2;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36231e;
            if (i7 != 0) {
                if (i7 == 1) {
                    kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) this.f36232f;
                    e1.n(obj);
                    jVar2 = jVar3;
                } else {
                    if (i7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj);
                }
                return l2.f34958a;
            }
            e1.n(obj);
            jVar = (kotlinx.coroutines.flow.j) this.f36232f;
            Object[] objArr = (Object[]) this.f36233g;
            i5.p<T[], kotlin.coroutines.d<? super R>, Object> pVar = this.f36234h;
            this.f36232f = jVar;
            this.f36231e = 1;
            obj = pVar.a0(objArr, this);
            if (obj == objH) {
                jVar2 = jVar;
                return objH;
            }
            jVar2 = jVar;
            this.f36232f = null;
            this.f36231e = 2;
            if (jVar2.f(obj, this) == objH) {
                return objH;
            }
            return l2.f34958a;
        }

        @Override // i5.q
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object v(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d T[] tArr, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            u uVar = new u(this.f36234h, dVar);
            uVar.f36232f = jVar;
            uVar.f36233g = tArr;
            return uVar.R(l2.f34958a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @a7.e
        public final Object g0(@a7.d Object obj) {
            kotlinx.coroutines.flow.j jVar = (kotlinx.coroutines.flow.j) this.f36232f;
            Object objA0 = this.f36234h.a0((Object[]) this.f36233g, this);
            kotlin.jvm.internal.i0.e(0);
            jVar.f(objA0, this);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    static final class v extends kotlin.jvm.internal.n0 implements i5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f36235a = new v();

        v() {
            super(0);
        }

        @Override // i5.a
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke() {
            return null;
        }
    }

    public static final /* synthetic */ <T, R> kotlinx.coroutines.flow.i<R> b(Iterable<? extends kotlinx.coroutines.flow.i<? extends T>> iterable, i5.p<? super T[], ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        Object[] array = kotlin.collections.g0.Q5(iterable).toArray(new kotlinx.coroutines.flow.i[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        kotlin.jvm.internal.l0.w();
        return new f((kotlinx.coroutines.flow.i[]) array, pVar);
    }

    @a7.d
    public static final <T1, T2, R> kotlinx.coroutines.flow.i<R> c(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return kotlinx.coroutines.flow.k.J0(iVar, iVar2, qVar);
    }

    @a7.d
    public static final <T1, T2, T3, R> kotlinx.coroutines.flow.i<R> d(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d kotlinx.coroutines.flow.i<? extends T3> iVar3, @a7.d @kotlin.b i5.r<? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.d<? super R>, ? extends Object> rVar) {
        return new a(new kotlinx.coroutines.flow.i[]{iVar, iVar2, iVar3}, rVar);
    }

    @a7.d
    public static final <T1, T2, T3, T4, R> kotlinx.coroutines.flow.i<R> e(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d kotlinx.coroutines.flow.i<? extends T3> iVar3, @a7.d kotlinx.coroutines.flow.i<? extends T4> iVar4, @a7.d i5.s<? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.d<? super R>, ? extends Object> sVar) {
        return new b(new kotlinx.coroutines.flow.i[]{iVar, iVar2, iVar3, iVar4}, sVar);
    }

    @a7.d
    public static final <T1, T2, T3, T4, T5, R> kotlinx.coroutines.flow.i<R> f(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d kotlinx.coroutines.flow.i<? extends T3> iVar3, @a7.d kotlinx.coroutines.flow.i<? extends T4> iVar4, @a7.d kotlinx.coroutines.flow.i<? extends T5> iVar5, @a7.d i5.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.d<? super R>, ? extends Object> tVar) {
        return new c(new kotlinx.coroutines.flow.i[]{iVar, iVar2, iVar3, iVar4, iVar5}, tVar);
    }

    public static final /* synthetic */ <T, R> kotlinx.coroutines.flow.i<R> g(kotlinx.coroutines.flow.i<? extends T>[] iVarArr, i5.p<? super T[], ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        kotlin.jvm.internal.l0.w();
        return new e(iVarArr, pVar);
    }

    public static final /* synthetic */ <T, R> kotlinx.coroutines.flow.i<R> h(Iterable<? extends kotlinx.coroutines.flow.i<? extends T>> iterable, @kotlin.b i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        Object[] array = kotlin.collections.g0.Q5(iterable).toArray(new kotlinx.coroutines.flow.i[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        kotlin.jvm.internal.l0.w();
        return kotlinx.coroutines.flow.k.I0(new r((kotlinx.coroutines.flow.i[]) array, qVar, null));
    }

    @a7.d
    public static final <T1, T2, R> kotlinx.coroutines.flow.i<R> i(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d @kotlin.b i5.r<? super kotlinx.coroutines.flow.j<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.d<? super l2>, ? extends Object> rVar) {
        return kotlinx.coroutines.flow.k.I0(new m(new kotlinx.coroutines.flow.i[]{iVar, iVar2}, null, rVar));
    }

    @a7.d
    public static final <T1, T2, T3, R> kotlinx.coroutines.flow.i<R> j(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d kotlinx.coroutines.flow.i<? extends T3> iVar3, @a7.d @kotlin.b i5.s<? super kotlinx.coroutines.flow.j<? super R>, ? super T1, ? super T2, ? super T3, ? super kotlin.coroutines.d<? super l2>, ? extends Object> sVar) {
        return kotlinx.coroutines.flow.k.I0(new n(new kotlinx.coroutines.flow.i[]{iVar, iVar2, iVar3}, null, sVar));
    }

    @a7.d
    public static final <T1, T2, T3, T4, R> kotlinx.coroutines.flow.i<R> k(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d kotlinx.coroutines.flow.i<? extends T3> iVar3, @a7.d kotlinx.coroutines.flow.i<? extends T4> iVar4, @a7.d @kotlin.b i5.t<? super kotlinx.coroutines.flow.j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super kotlin.coroutines.d<? super l2>, ? extends Object> tVar) {
        return kotlinx.coroutines.flow.k.I0(new o(new kotlinx.coroutines.flow.i[]{iVar, iVar2, iVar3, iVar4}, null, tVar));
    }

    @a7.d
    public static final <T1, T2, T3, T4, T5, R> kotlinx.coroutines.flow.i<R> l(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d kotlinx.coroutines.flow.i<? extends T3> iVar3, @a7.d kotlinx.coroutines.flow.i<? extends T4> iVar4, @a7.d kotlinx.coroutines.flow.i<? extends T5> iVar5, @a7.d @kotlin.b i5.u<? super kotlinx.coroutines.flow.j<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super kotlin.coroutines.d<? super l2>, ? extends Object> uVar) {
        return kotlinx.coroutines.flow.k.I0(new p(new kotlinx.coroutines.flow.i[]{iVar, iVar2, iVar3, iVar4, iVar5}, null, uVar));
    }

    public static final /* synthetic */ <T, R> kotlinx.coroutines.flow.i<R> m(kotlinx.coroutines.flow.i<? extends T>[] iVarArr, @kotlin.b i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        kotlin.jvm.internal.l0.w();
        return kotlinx.coroutines.flow.k.I0(new q(iVarArr, qVar, null));
    }

    private static final /* synthetic */ <T, R> kotlinx.coroutines.flow.i<R> n(kotlinx.coroutines.flow.i<? extends T>[] iVarArr, @kotlin.b i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T[], ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        kotlin.jvm.internal.l0.w();
        return kotlinx.coroutines.flow.k.I0(new s(iVarArr, qVar, null));
    }

    private static final /* synthetic */ <T, R> kotlinx.coroutines.flow.i<R> o(kotlinx.coroutines.flow.i<? extends T>[] iVarArr, i5.p<? super T[], ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        kotlin.jvm.internal.l0.w();
        return new t(iVarArr, pVar);
    }

    @a7.d
    @h5.h(name = "flowCombine")
    public static final <T1, T2, R> kotlinx.coroutines.flow.i<R> p(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return new d(iVar, iVar2, qVar);
    }

    @a7.d
    @h5.h(name = "flowCombineTransform")
    public static final <T1, T2, R> kotlinx.coroutines.flow.i<R> q(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d @kotlin.b i5.r<? super kotlinx.coroutines.flow.j<? super R>, ? super T1, ? super T2, ? super kotlin.coroutines.d<? super l2>, ? extends Object> rVar) {
        return kotlinx.coroutines.flow.k.I0(new l(new kotlinx.coroutines.flow.i[]{iVar, iVar2}, null, rVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> i5.a<T[]> r() {
        return v.f36235a;
    }

    @a7.d
    public static final <T1, T2, R> kotlinx.coroutines.flow.i<R> s(@a7.d kotlinx.coroutines.flow.i<? extends T1> iVar, @a7.d kotlinx.coroutines.flow.i<? extends T2> iVar2, @a7.d i5.q<? super T1, ? super T2, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return kotlinx.coroutines.flow.internal.m.b(iVar, iVar2, qVar);
    }
}
