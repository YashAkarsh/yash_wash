package kotlinx.coroutines.flow;

import kotlin.e1;
import kotlin.jvm.internal.k1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class v {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0}, l = {137}, m = "collectWhile", n = {"collector"}, s = {"L$0"})
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36713e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36714f;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36713e = obj;
            this.f36714f |= Integer.MIN_VALUE;
            return v.b(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p<T, kotlin.coroutines.d<? super Boolean>, Object> f36715a;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1", f = "Limit.kt", i = {0}, l = {131}, m = "emit", n = {"this"}, s = {"L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36716d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f36717e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            int f36719g;

            public a(kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36717e = obj;
                this.f36719g |= Integer.MIN_VALUE;
                return b.this.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
            this.f36715a = pVar;
        }

        @a7.e
        public Object a(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(dVar);
            kotlin.jvm.internal.i0.e(5);
            if (((Boolean) this.f36715a.a0(t7, dVar)).booleanValue()) {
                return l2.f34958a;
            }
            throw new kotlinx.coroutines.flow.internal.a(this);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            b<T> bVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36719g;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36719g = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object objA0 = aVar.f36717e;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36719g;
            if (i8 == 0) {
                e1.n(objA0);
                i5.p<T, kotlin.coroutines.d<? super Boolean>, Object> pVar = this.f36715a;
                aVar.f36716d = this;
                aVar.f36719g = 1;
                objA0 = pVar.a0(t7, aVar);
                if (objA0 == objH) {
                    return objH;
                }
                bVar = this;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar = (b) aVar.f36716d;
                e1.n(objA0);
            }
            if (((Boolean) objA0).booleanValue()) {
                return l2.f34958a;
            }
            throw new kotlinx.coroutines.flow.internal.a(bVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f36721b;

        public c(kotlinx.coroutines.flow.i iVar, int i7) {
            this.f36720a = iVar;
            this.f36721b = i7;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objA = this.f36720a.a(new d(new k1.f(), this.f36721b, jVar), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    static final class d<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.f f36722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f36723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<T> f36724c;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1", f = "Limit.kt", i = {}, l = {25}, m = "emit", n = {}, s = {})
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36725d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ d<T> f36726e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36727f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(d<? super T> dVar, kotlin.coroutines.d<? super a> dVar2) {
                super(dVar2);
                this.f36726e = dVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36725d = obj;
                this.f36727f |= Integer.MIN_VALUE;
                return this.f36726e.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        d(k1.f fVar, int i7, kotlinx.coroutines.flow.j<? super T> jVar) {
            this.f36722a = fVar;
            this.f36723b = i7;
            this.f36724c = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36727f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36727f = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.f36725d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36727f;
            if (i8 == 0) {
                e1.n(obj);
                k1.f fVar = this.f36722a;
                int i9 = fVar.f34870a;
                if (i9 < this.f36723b) {
                    fVar.f34870a = i9 + 1;
                    return l2.f34958a;
                }
                kotlinx.coroutines.flow.j<T> jVar = this.f36724c;
                aVar.f36727f = 1;
                if (jVar.f(t7, aVar) == objH) {
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

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class e<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36729b;

        public e(kotlinx.coroutines.flow.i iVar, i5.p pVar) {
            this.f36728a = iVar;
            this.f36729b = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objA = this.f36728a.a(new f(new k1.a(), jVar, this.f36729b), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    static final class f<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.a f36730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<T> f36731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.p<T, kotlin.coroutines.d<? super Boolean>, Object> f36732c;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", i = {1, 1}, l = {37, 38, 40}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36733d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f36734e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            /* synthetic */ Object f36735f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ f<T> f36736g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            int f36737h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(f<? super T> fVar, kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
                this.f36736g = fVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36735f = obj;
                this.f36737h |= Integer.MIN_VALUE;
                return this.f36736g.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        f(k1.a aVar, kotlinx.coroutines.flow.j<? super T> jVar, i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
            this.f36730a = aVar;
            this.f36731b = jVar;
            this.f36732c = pVar;
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0074  */
        /* JADX WARN: Code duplicated, block: B:33:0x0087 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:36:0x008b  */
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
            a aVar;
            f<T> fVar;
            kotlinx.coroutines.flow.j<T> jVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36737h;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36737h = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object objA0 = aVar.f36735f;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36737h;
            if (i8 == 0) {
                e1.n(objA0);
                if (this.f36730a.f34865a) {
                    kotlinx.coroutines.flow.j<T> jVar2 = this.f36731b;
                    aVar.f36737h = 1;
                    if (jVar2.f(t7, aVar) == objH) {
                        return objH;
                    }
                    return l2.f34958a;
                }
                i5.p<T, kotlin.coroutines.d<? super Boolean>, Object> pVar = this.f36732c;
                aVar.f36733d = this;
                aVar.f36734e = t7;
                aVar.f36737h = 2;
                objA0 = pVar.a0(t7, aVar);
                if (objA0 == objH) {
                    return objH;
                }
                fVar = this;
                if (!((Boolean) objA0).booleanValue()) {
                    return l2.f34958a;
                }
                fVar.f36730a.f34865a = true;
                jVar = fVar.f36731b;
                aVar.f36733d = null;
                aVar.f36734e = null;
                aVar.f36737h = 3;
                if (jVar.f(t7, aVar) == objH) {
                    return objH;
                }
            } else {
                if (i8 == 1) {
                    e1.n(objA0);
                    return l2.f34958a;
                }
                if (i8 == 2) {
                    t7 = (T) aVar.f36734e;
                    fVar = (f) aVar.f36733d;
                    e1.n(objA0);
                    if (!((Boolean) objA0).booleanValue()) {
                        return l2.f34958a;
                    }
                    fVar.f36730a.f34865a = true;
                    jVar = fVar.f36731b;
                    aVar.f36733d = null;
                    aVar.f36734e = null;
                    aVar.f36737h = 3;
                    if (jVar.f(t7, aVar) == objH) {
                        return objH;
                    }
                } else {
                    if (i8 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(objA0);
                }
            }
            return l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", i = {0}, l = {f4.d.f33917g}, m = "emitAbort$FlowKt__LimitKt", n = {"$this$emitAbort"}, s = {"L$0"})
    static final class g<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36739e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36740f;

        g(kotlin.coroutines.d<? super g> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36739e = obj;
            this.f36740f |= Integer.MIN_VALUE;
            return v.f(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class h<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f36742b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1", f = "Limit.kt", i = {0}, l = {115}, m = "collect", n = {"$this$take_u24lambda_u2d4"}, s = {"L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36743d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36744e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36746g;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36743d = obj;
                this.f36744e |= Integer.MIN_VALUE;
                return h.this.a(null, this);
            }
        }

        public h(kotlinx.coroutines.flow.i iVar, int i7) {
            this.f36741a = iVar;
            this.f36742b = i7;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, kotlinx.coroutines.flow.j, kotlinx.coroutines.flow.j<? super T>] */
        /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.flow.j] */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v9 */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36744e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36744e = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36743d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36744e;
            try {
                if (i8 == 0) {
                    e1.n(obj);
                    k1.f fVar = new k1.f();
                    kotlinx.coroutines.flow.i iVar = this.f36741a;
                    i iVar2 = new i(fVar, this.f36742b, jVar);
                    aVar.f36746g = jVar;
                    aVar.f36744e = 1;
                    Object objA = iVar.a(iVar2, aVar);
                    jVar = objA;
                    if (objA == objH) {
                        return objH;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z7 = (kotlinx.coroutines.flow.j<? super T>) ((kotlinx.coroutines.flow.j) aVar.f36746g);
                    e1.n(obj);
                    jVar = z7;
                }
            } catch (kotlinx.coroutines.flow.internal.a e8) {
                kotlinx.coroutines.flow.internal.q.b(e8, jVar);
            }
            return l2.f34958a;
        }
    }

    static final class i<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.f f36747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f36748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<T> f36749c;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1", f = "Limit.kt", i = {}, l = {kotlinx.coroutines.internal.b0.f36952q, androidx.core.text.f.f6258k}, m = "emit", n = {}, s = {})
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36750d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ i<T> f36751e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36752f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(i<? super T> iVar, kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
                this.f36751e = iVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36750d = obj;
                this.f36752f |= Integer.MIN_VALUE;
                return this.f36751e.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        i(k1.f fVar, int i7, kotlinx.coroutines.flow.j<? super T> jVar) {
            this.f36747a = fVar;
            this.f36748b = i7;
            this.f36749c = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36752f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36752f = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.f36750d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36752f;
            if (i8 != 0) {
                if (i8 == 1) {
                    e1.n(obj);
                    return l2.f34958a;
                }
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
                return l2.f34958a;
            }
            e1.n(obj);
            k1.f fVar = this.f36747a;
            int i9 = fVar.f34870a + 1;
            fVar.f34870a = i9;
            if (i9 < this.f36748b) {
                kotlinx.coroutines.flow.j<T> jVar = this.f36749c;
                aVar.f36752f = 1;
                if (jVar.f(t7, aVar) == objH) {
                    return objH;
                }
                return l2.f34958a;
            }
            kotlinx.coroutines.flow.j<T> jVar2 = this.f36749c;
            aVar.f36752f = 2;
            if (v.f(jVar2, t7, aVar) == objH) {
                return objH;
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class j<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36754b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1", f = "Limit.kt", i = {0}, l = {124}, m = "collect", n = {"collector$iv"}, s = {"L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36755d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36756e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36758g;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36755d = obj;
                this.f36756e |= Integer.MIN_VALUE;
                return j.this.a(null, this);
            }
        }

        public j(kotlinx.coroutines.flow.i iVar, i5.p pVar) {
            this.f36753a = iVar;
            this.f36754b = pVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            k kVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36756e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36756e = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36755d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36756e;
            if (i8 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.i iVar = this.f36753a;
                k kVar2 = new k(this.f36754b, jVar);
                try {
                    aVar.f36758g = kVar2;
                    aVar.f36756e = 1;
                    if (iVar.a(kVar2, aVar) == objH) {
                        return objH;
                    }
                } catch (kotlinx.coroutines.flow.internal.a e8) {
                    e = e8;
                    kVar = kVar2;
                    kotlinx.coroutines.flow.internal.q.b(e, kVar);
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kVar = (k) aVar.f36758g;
                try {
                    e1.n(obj);
                } catch (kotlinx.coroutines.flow.internal.a e9) {
                    e = e9;
                    kotlinx.coroutines.flow.internal.q.b(e, kVar);
                }
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class k<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p f36759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j f36760b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda-6$$inlined$collectWhile$1", f = "Limit.kt", i = {0, 0, 1}, l = {143, 144}, m = "emit", n = {"this", "value", "this"}, s = {"L$0", "L$1", "L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36761d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f36762e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36763f;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36765h;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36762e = obj;
                this.f36763f |= Integer.MIN_VALUE;
                return k.this.f(null, this);
            }
        }

        public k(i5.p pVar, kotlinx.coroutines.flow.j jVar) {
            this.f36759a = pVar;
            this.f36760b = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x007e  */
        /* JADX WARN: Code duplicated, block: B:29:0x0081  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            Object obj;
            Object obj2;
            k<T> kVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36763f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36763f = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj3 = aVar.f36762e;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36763f;
            boolean z7 = true;
            if (i8 != 0) {
                if (i8 == 1) {
                    Object obj4 = aVar.f36765h;
                    k<T> kVar2 = (k) aVar.f36761d;
                    e1.n(obj3);
                    obj2 = obj4;
                    kVar = kVar2;
                    obj = obj3;
                } else {
                    if (i8 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kVar = (k) aVar.f36761d;
                    e1.n(obj3);
                }
                if (z7) {
                    return l2.f34958a;
                }
                throw new kotlinx.coroutines.flow.internal.a(kVar);
            }
            e1.n(obj3);
            i5.p pVar = this.f36759a;
            aVar.f36761d = this;
            aVar.f36765h = t7;
            aVar.f36763f = 1;
            kotlin.jvm.internal.i0.e(6);
            Object objA0 = pVar.a0(t7, aVar);
            kotlin.jvm.internal.i0.e(7);
            if (objA0 == objH) {
                return objH;
            }
            obj = objA0;
            obj2 = t7;
            kVar = this;
            if (((Boolean) obj).booleanValue()) {
                kotlinx.coroutines.flow.j jVar = kVar.f36760b;
                aVar.f36761d = kVar;
                aVar.f36765h = null;
                aVar.f36763f = 2;
                if (jVar.f(obj2, aVar) == objH) {
                    return objH;
                }
            } else {
                z7 = false;
            }
            if (z7) {
                return l2.f34958a;
            }
            throw new kotlinx.coroutines.flow.internal.a(kVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", i = {0}, l = {153}, m = "invokeSuspend", n = {"collector$iv"}, s = {"L$0"})
    static final class l<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.flow.j<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36766e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36767f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i<T> f36768g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.q<kotlinx.coroutines.flow.j<? super R>, T, kotlin.coroutines.d<? super Boolean>, Object> f36769h;

        /* JADX INFO: Add missing generic type declarations: [T] */
        public static final class a<T> implements kotlinx.coroutines.flow.j<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i5.q f36770a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f36771b;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.v$l$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1", f = "Limit.kt", i = {0}, l = {143}, m = "emit", n = {"this"}, s = {"L$0"})
            public static final class C0483a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                Object f36772d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                /* synthetic */ Object f36773e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                int f36774f;

                public C0483a(kotlin.coroutines.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36773e = obj;
                    this.f36774f |= Integer.MIN_VALUE;
                    return a.this.f(null, this);
                }
            }

            public a(i5.q qVar, kotlinx.coroutines.flow.j jVar) {
                this.f36770a = qVar;
                this.f36771b = jVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                C0483a c0483a;
                a<T> aVar;
                if (dVar instanceof C0483a) {
                    c0483a = (C0483a) dVar;
                    int i7 = c0483a.f36774f;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0483a.f36774f = i7 - Integer.MIN_VALUE;
                    } else {
                        c0483a = new C0483a(dVar);
                    }
                } else {
                    c0483a = new C0483a(dVar);
                }
                Object objV = c0483a.f36773e;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = c0483a.f36774f;
                if (i8 == 0) {
                    e1.n(objV);
                    i5.q qVar = this.f36770a;
                    kotlinx.coroutines.flow.j jVar = this.f36771b;
                    c0483a.f36772d = this;
                    c0483a.f36774f = 1;
                    kotlin.jvm.internal.i0.e(6);
                    objV = qVar.v(jVar, t7, c0483a);
                    kotlin.jvm.internal.i0.e(7);
                    if (objV == objH) {
                        return objH;
                    }
                    aVar = this;
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (a) c0483a.f36772d;
                    e1.n(objV);
                }
                if (((Boolean) objV).booleanValue()) {
                    return l2.f34958a;
                }
                throw new kotlinx.coroutines.flow.internal.a(aVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        l(kotlinx.coroutines.flow.i<? extends T> iVar, i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> qVar, kotlin.coroutines.d<? super l> dVar) {
            super(2, dVar);
            this.f36768g = iVar;
            this.f36769h = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            l lVar = new l(this.f36768g, this.f36769h, dVar);
            lVar.f36767f = obj;
            return lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.d to kotlinx.coroutines.flow.v$l<R> for r5v1 'this'  kotlin.coroutines.d
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
                int r1 = r5.f36766e
                r2 = 1
                if (r1 == 0) goto L1d
                if (r1 != r2) goto L15
                java.lang.Object r0 = r5.f36767f
                kotlinx.coroutines.flow.v$l$a r0 = (kotlinx.coroutines.flow.v.l.a) r0
                kotlin.e1.n(r6)     // Catch: kotlinx.coroutines.flow.internal.a -> L13
                goto L3d
            L13:
                r6 = move-exception
                goto L3a
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1d:
                kotlin.e1.n(r6)
                java.lang.Object r6 = r5.f36767f
                kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) r6
                kotlinx.coroutines.flow.i<T> r1 = r5.f36768g
                i5.q<kotlinx.coroutines.flow.j<? super R>, T, kotlin.coroutines.d<? super java.lang.Boolean>, java.lang.Object> r3 = r5.f36769h
                kotlinx.coroutines.flow.v$l$a r4 = new kotlinx.coroutines.flow.v$l$a
                r4.<init>(r3, r6)
                r5.f36767f = r4     // Catch: kotlinx.coroutines.flow.internal.a -> L38
                r5.f36766e = r2     // Catch: kotlinx.coroutines.flow.internal.a -> L38
                java.lang.Object r6 = r1.a(r4, r5)     // Catch: kotlinx.coroutines.flow.internal.a -> L38
                if (r6 != r0) goto L3d
                return r0
            L38:
                r6 = move-exception
                r0 = r4
            L3a:
                kotlinx.coroutines.flow.internal.q.b(r6, r0)
            L3d:
                kotlin.l2 r6 = kotlin.l2.f34958a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.v.l.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((l) D(jVar, dVar)).R(l2.f34958a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object b(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        a aVar;
        kotlinx.coroutines.flow.j<? super Object> jVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i7 = aVar.f36714f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar.f36714f = i7 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.f36713e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar.f36714f;
        if (i8 == 0) {
            e1.n(obj);
            kotlinx.coroutines.flow.j<? super Object> bVar = new b<>(pVar);
            try {
                aVar.f36712d = bVar;
                aVar.f36714f = 1;
                if (iVar.a(bVar, aVar) == objH) {
                    return objH;
                }
            } catch (kotlinx.coroutines.flow.internal.a e8) {
                e = e8;
                jVar = bVar;
                kotlinx.coroutines.flow.internal.q.b(e, jVar);
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (b) aVar.f36712d;
            try {
                e1.n(obj);
            } catch (kotlinx.coroutines.flow.internal.a e9) {
                e = e9;
                kotlinx.coroutines.flow.internal.q.b(e, jVar);
            }
        }
        return l2.f34958a;
    }

    private static final <T> Object c(kotlinx.coroutines.flow.i<? extends T> iVar, i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.d<? super l2> dVar) {
        b bVar = new b(pVar);
        try {
            kotlin.jvm.internal.i0.e(0);
            iVar.a(bVar, dVar);
            kotlin.jvm.internal.i0.e(1);
        } catch (kotlinx.coroutines.flow.internal.a e8) {
            kotlinx.coroutines.flow.internal.q.b(e8, bVar);
        }
        return l2.f34958a;
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> d(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, int i7) {
        if (i7 >= 0) {
            return new c(iVar, i7);
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.l0.C("Drop count should be non-negative, but had ", Integer.valueOf(i7)).toString());
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> e(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return new e(iVar, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object f(kotlinx.coroutines.flow.j<? super T> jVar, T t7, kotlin.coroutines.d<? super l2> dVar) {
        g gVar;
        if (dVar instanceof g) {
            gVar = (g) dVar;
            int i7 = gVar.f36740f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                gVar.f36740f = i7 - Integer.MIN_VALUE;
            } else {
                gVar = new g(dVar);
            }
        } else {
            gVar = new g(dVar);
        }
        Object obj = gVar.f36739e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = gVar.f36740f;
        if (i8 == 0) {
            e1.n(obj);
            gVar.f36738d = jVar;
            gVar.f36740f = 1;
            if (jVar.f(t7, gVar) == objH) {
                return objH;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (kotlinx.coroutines.flow.j) gVar.f36738d;
            e1.n(obj);
        }
        throw new kotlinx.coroutines.flow.internal.a(jVar);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> g(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, int i7) {
        if (i7 > 0) {
            return new h(iVar, i7);
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " should be positive").toString());
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> h(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return new j(iVar, pVar);
    }

    @a7.d
    public static final <T, R> kotlinx.coroutines.flow.i<R> i(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d @kotlin.b i5.q<? super kotlinx.coroutines.flow.j<? super R>, ? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> qVar) {
        return kotlinx.coroutines.flow.k.I0(new l(iVar, qVar, null));
    }
}
