package kotlinx.coroutines.flow;

import easypay.appinvoke.manager.Constants;
import kotlin.e1;
import kotlin.jvm.internal.k1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class a0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36008b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.a0$a$a, reason: collision with other inner class name */
        public static final class C0455a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36009d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36010e;

            public C0455a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36009d = obj;
                this.f36010e |= Integer.MIN_VALUE;
                return a.this.a(null, this);
            }
        }

        public static final class b<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f36012a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i5.p f36013b;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.a0$a$b$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {223, 223}, m = "emit", n = {"value", "$this$filter_u24lambda_u2d0"}, s = {"L$0", "L$1"})
            public static final class C0456a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36014d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f36015e;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                Object f36017g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                Object f36018h;

                public C0456a(kotlin.coroutines.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36014d = obj;
                    this.f36015e |= Integer.MIN_VALUE;
                    return b.this.f(null, this);
                }
            }

            public b(kotlinx.coroutines.flow.j jVar, i5.p pVar) {
                this.f36012a = jVar;
                this.f36013b = pVar;
            }

            @a7.e
            public final Object a(Object obj, @a7.d kotlin.coroutines.d dVar) {
                kotlin.jvm.internal.i0.e(4);
                new C0456a(dVar);
                kotlin.jvm.internal.i0.e(5);
                kotlinx.coroutines.flow.j jVar = this.f36012a;
                if (((Boolean) this.f36013b.a0(obj, dVar)).booleanValue()) {
                    kotlin.jvm.internal.i0.e(0);
                    jVar.f(obj, dVar);
                    kotlin.jvm.internal.i0.e(1);
                }
                return l2.f34958a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                C0456a c0456a;
                Object obj;
                kotlinx.coroutines.flow.j jVar;
                if (dVar instanceof C0456a) {
                    c0456a = (C0456a) dVar;
                    int i7 = c0456a.f36015e;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0456a.f36015e = i7 - Integer.MIN_VALUE;
                    } else {
                        c0456a = new C0456a(dVar);
                    }
                } else {
                    c0456a = new C0456a(dVar);
                }
                Object obj2 = c0456a.f36014d;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = c0456a.f36015e;
                if (i8 != 0) {
                    if (i8 == 1) {
                        kotlinx.coroutines.flow.j jVar2 = (kotlinx.coroutines.flow.j) c0456a.f36018h;
                        obj = c0456a.f36017g;
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
                kotlinx.coroutines.flow.j jVar3 = this.f36012a;
                i5.p pVar = this.f36013b;
                c0456a.f36017g = t7;
                c0456a.f36018h = jVar3;
                c0456a.f36015e = 1;
                Object objA0 = pVar.a0(t7, c0456a);
                if (objA0 == objH) {
                    return objH;
                }
                obj = t7;
                jVar = jVar3;
                obj2 = objA0;
                if (((Boolean) obj2).booleanValue()) {
                    c0456a.f36017g = null;
                    c0456a.f36018h = null;
                    c0456a.f36015e = 2;
                    if (jVar.f(obj, c0456a) == objH) {
                        return objH;
                    }
                }
                return l2.f34958a;
            }
        }

        public a(kotlinx.coroutines.flow.i iVar, i5.p pVar) {
            this.f36007a = iVar;
            this.f36008b = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            Object objA = this.f36007a.a(new b(jVar, this.f36008b), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }

        @a7.e
        public Object d(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            kotlin.jvm.internal.i0.e(4);
            new C0455a(dVar);
            kotlin.jvm.internal.i0.e(5);
            kotlinx.coroutines.flow.i iVar = this.f36007a;
            b bVar = new b(jVar, this.f36008b);
            kotlin.jvm.internal.i0.e(0);
            iVar.a(bVar, dVar);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    public static final class b implements kotlinx.coroutines.flow.i<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36019a;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36020d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36021e;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36020d = obj;
                this.f36021e |= Integer.MIN_VALUE;
                return b.this.a(null, this);
            }
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.a0$b$b, reason: collision with other inner class name */
        public static final class C0457b<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f36023a;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.a0$b$b$a */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2", f = "Transform.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
            public static final class a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36024d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f36025e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                Object f36026f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                Object f36027g;

                public a(kotlin.coroutines.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36024d = obj;
                    this.f36025e |= Integer.MIN_VALUE;
                    return C0457b.this.f(null, this);
                }
            }

            public C0457b(kotlinx.coroutines.flow.j jVar) {
                this.f36023a = jVar;
            }

            @a7.e
            public final Object a(Object obj, @a7.d kotlin.coroutines.d dVar) {
                kotlin.jvm.internal.i0.e(4);
                new a(dVar);
                kotlin.jvm.internal.i0.e(5);
                kotlinx.coroutines.flow.j jVar = this.f36023a;
                kotlin.jvm.internal.l0.y(3, "R");
                if (obj instanceof Object) {
                    kotlin.jvm.internal.i0.e(0);
                    jVar.f(obj, dVar);
                    kotlin.jvm.internal.i0.e(1);
                }
                return l2.f34958a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(Object obj, @a7.d kotlin.coroutines.d dVar) {
                a aVar;
                if (dVar instanceof a) {
                    aVar = (a) dVar;
                    int i7 = aVar.f36025e;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        aVar.f36025e = i7 - Integer.MIN_VALUE;
                    } else {
                        aVar = new a(dVar);
                    }
                } else {
                    aVar = new a(dVar);
                }
                Object obj2 = aVar.f36024d;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = aVar.f36025e;
                if (i8 == 0) {
                    e1.n(obj2);
                    kotlinx.coroutines.flow.j jVar = this.f36023a;
                    kotlin.jvm.internal.l0.y(3, "R");
                    if (obj instanceof Object) {
                        aVar.f36025e = 1;
                        if (jVar.f(obj, aVar) == objH) {
                            return objH;
                        }
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj2);
                }
                return l2.f34958a;
            }
        }

        public b(kotlinx.coroutines.flow.i iVar) {
            this.f36019a = iVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super Object> jVar, @a7.d kotlin.coroutines.d dVar) {
            kotlinx.coroutines.flow.i iVar = this.f36019a;
            kotlin.jvm.internal.l0.w();
            Object objA = iVar.a(new C0457b(jVar), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }

        @a7.e
        public Object d(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(dVar);
            kotlin.jvm.internal.i0.e(5);
            kotlinx.coroutines.flow.i iVar = this.f36019a;
            kotlin.jvm.internal.l0.w();
            C0457b c0457b = new C0457b(jVar);
            kotlin.jvm.internal.i0.e(0);
            iVar.a(c0457b, dVar);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36030b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36031d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36032e;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36031d = obj;
                this.f36032e |= Integer.MIN_VALUE;
                return c.this.a(null, this);
            }
        }

        public static final class b<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f36034a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i5.p f36035b;

            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {223, 223}, m = "emit", n = {"value", "$this$filterNot_u24lambda_u2d1"}, s = {"L$0", "L$1"})
            public static final class a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36036d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f36037e;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                Object f36039g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                Object f36040h;

                public a(kotlin.coroutines.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36036d = obj;
                    this.f36037e |= Integer.MIN_VALUE;
                    return b.this.f(null, this);
                }
            }

            public b(kotlinx.coroutines.flow.j jVar, i5.p pVar) {
                this.f36034a = jVar;
                this.f36035b = pVar;
            }

            @a7.e
            public final Object a(Object obj, @a7.d kotlin.coroutines.d dVar) {
                kotlin.jvm.internal.i0.e(4);
                new a(dVar);
                kotlin.jvm.internal.i0.e(5);
                kotlinx.coroutines.flow.j jVar = this.f36034a;
                if (!((Boolean) this.f36035b.a0(obj, dVar)).booleanValue()) {
                    kotlin.jvm.internal.i0.e(0);
                    jVar.f(obj, dVar);
                    kotlin.jvm.internal.i0.e(1);
                }
                return l2.f34958a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                a aVar;
                Object obj;
                kotlinx.coroutines.flow.j jVar;
                if (dVar instanceof a) {
                    aVar = (a) dVar;
                    int i7 = aVar.f36037e;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        aVar.f36037e = i7 - Integer.MIN_VALUE;
                    } else {
                        aVar = new a(dVar);
                    }
                } else {
                    aVar = new a(dVar);
                }
                Object obj2 = aVar.f36036d;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = aVar.f36037e;
                if (i8 != 0) {
                    if (i8 == 1) {
                        kotlinx.coroutines.flow.j jVar2 = (kotlinx.coroutines.flow.j) aVar.f36040h;
                        obj = aVar.f36039g;
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
                kotlinx.coroutines.flow.j jVar3 = this.f36034a;
                i5.p pVar = this.f36035b;
                aVar.f36039g = t7;
                aVar.f36040h = jVar3;
                aVar.f36037e = 1;
                Object objA0 = pVar.a0(t7, aVar);
                if (objA0 == objH) {
                    return objH;
                }
                obj = t7;
                jVar = jVar3;
                obj2 = objA0;
                if (!((Boolean) obj2).booleanValue()) {
                    aVar.f36039g = null;
                    aVar.f36040h = null;
                    aVar.f36037e = 2;
                    if (jVar.f(obj, aVar) == objH) {
                        return objH;
                    }
                }
                return l2.f34958a;
            }
        }

        public c(kotlinx.coroutines.flow.i iVar, i5.p pVar) {
            this.f36029a = iVar;
            this.f36030b = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            Object objA = this.f36029a.a(new b(jVar, this.f36030b), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }

        @a7.e
        public Object d(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(dVar);
            kotlin.jvm.internal.i0.e(5);
            kotlinx.coroutines.flow.i iVar = this.f36029a;
            b bVar = new b(jVar, this.f36030b);
            kotlin.jvm.internal.i0.e(0);
            iVar.a(bVar, dVar);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36041a;

        public static final class a<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f36042a;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.a0$d$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
            public static final class C0458a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36043d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f36044e;

                public C0458a(kotlin.coroutines.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36043d = obj;
                    this.f36044e |= Integer.MIN_VALUE;
                    return a.this.f(null, this);
                }
            }

            public a(kotlinx.coroutines.flow.j jVar) {
                this.f36042a = jVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                C0458a c0458a;
                if (dVar instanceof C0458a) {
                    c0458a = (C0458a) dVar;
                    int i7 = c0458a.f36044e;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0458a.f36044e = i7 - Integer.MIN_VALUE;
                    } else {
                        c0458a = new C0458a(dVar);
                    }
                } else {
                    c0458a = new C0458a(dVar);
                }
                Object obj = c0458a.f36043d;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = c0458a.f36044e;
                if (i8 == 0) {
                    e1.n(obj);
                    kotlinx.coroutines.flow.j jVar = this.f36042a;
                    if (t7 != null) {
                        c0458a.f36044e = 1;
                        if (jVar.f(t7, c0458a) == objH) {
                            return objH;
                        }
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

        public d(kotlinx.coroutines.flow.i iVar) {
            this.f36041a = iVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            Object objA = this.f36041a.a(new a(jVar), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class e<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36047b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36048d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36049e;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36048d = obj;
                this.f36049e |= Integer.MIN_VALUE;
                return e.this.a(null, this);
            }
        }

        public static final class b<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f36051a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i5.p f36052b;

            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {}, l = {223, 223}, m = "emit", n = {}, s = {})
            public static final class a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36053d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f36054e;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                Object f36056g;

                public a(kotlin.coroutines.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36053d = obj;
                    this.f36054e |= Integer.MIN_VALUE;
                    return b.this.f(null, this);
                }
            }

            public b(kotlinx.coroutines.flow.j jVar, i5.p pVar) {
                this.f36051a = jVar;
                this.f36052b = pVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @a7.e
            public final Object a(Object obj, @a7.d kotlin.coroutines.d dVar) {
                kotlin.jvm.internal.i0.e(4);
                new a(dVar);
                kotlin.jvm.internal.i0.e(5);
                kotlinx.coroutines.flow.j jVar = this.f36051a;
                Object objA0 = this.f36052b.a0(obj, dVar);
                kotlin.jvm.internal.i0.e(0);
                jVar.f(objA0, dVar);
                kotlin.jvm.internal.i0.e(1);
                return l2.f34958a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                a aVar;
                kotlinx.coroutines.flow.j jVar;
                if (dVar instanceof a) {
                    aVar = (a) dVar;
                    int i7 = aVar.f36054e;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        aVar.f36054e = i7 - Integer.MIN_VALUE;
                    } else {
                        aVar = new a(dVar);
                    }
                } else {
                    aVar = new a(dVar);
                }
                Object obj = aVar.f36053d;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = aVar.f36054e;
                if (i8 != 0) {
                    if (i8 == 1) {
                        kotlinx.coroutines.flow.j jVar2 = (kotlinx.coroutines.flow.j) aVar.f36056g;
                        e1.n(obj);
                        jVar = jVar2;
                    } else {
                        if (i8 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj);
                    }
                    return l2.f34958a;
                }
                e1.n(obj);
                kotlinx.coroutines.flow.j jVar3 = this.f36051a;
                i5.p pVar = this.f36052b;
                aVar.f36056g = jVar3;
                aVar.f36054e = 1;
                Object objA0 = pVar.a0(t7, aVar);
                if (objA0 == objH) {
                    return objH;
                }
                obj = objA0;
                jVar = jVar3;
                aVar.f36056g = null;
                aVar.f36054e = 2;
                if (jVar.f(obj, aVar) == objH) {
                    return objH;
                }
                return l2.f34958a;
            }
        }

        public e(kotlinx.coroutines.flow.i iVar, i5.p pVar) {
            this.f36046a = iVar;
            this.f36047b = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            Object objA = this.f36046a.a(new b(jVar, this.f36047b), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }

        @a7.e
        public Object d(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(dVar);
            kotlin.jvm.internal.i0.e(5);
            kotlinx.coroutines.flow.i iVar = this.f36046a;
            b bVar = new b(jVar, this.f36047b);
            kotlin.jvm.internal.i0.e(0);
            iVar.a(bVar, dVar);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class f<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36058b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36059d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36060e;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36059d = obj;
                this.f36060e |= Integer.MIN_VALUE;
                return f.this.a(null, this);
            }
        }

        public static final class b<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f36062a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i5.p f36063b;

            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0}, l = {223, 224}, m = "emit", n = {"$this$mapNotNull_u24lambda_u2d5"}, s = {"L$0"})
            public static final class a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36064d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f36065e;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                Object f36067g;

                public a(kotlin.coroutines.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36064d = obj;
                    this.f36065e |= Integer.MIN_VALUE;
                    return b.this.f(null, this);
                }
            }

            public b(kotlinx.coroutines.flow.j jVar, i5.p pVar) {
                this.f36062a = jVar;
                this.f36063b = pVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @a7.e
            public final Object a(Object obj, @a7.d kotlin.coroutines.d dVar) {
                kotlin.jvm.internal.i0.e(4);
                new a(dVar);
                kotlin.jvm.internal.i0.e(5);
                kotlinx.coroutines.flow.j jVar = this.f36062a;
                Object objA0 = this.f36063b.a0(obj, dVar);
                if (objA0 != null) {
                    kotlin.jvm.internal.i0.e(0);
                    jVar.f(objA0, dVar);
                    kotlin.jvm.internal.i0.e(1);
                }
                return l2.f34958a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                a aVar;
                kotlinx.coroutines.flow.j jVar;
                kotlinx.coroutines.flow.j jVar2;
                if (dVar instanceof a) {
                    aVar = (a) dVar;
                    int i7 = aVar.f36065e;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        aVar.f36065e = i7 - Integer.MIN_VALUE;
                    } else {
                        aVar = new a(dVar);
                    }
                } else {
                    aVar = new a(dVar);
                }
                Object obj = aVar.f36064d;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = aVar.f36065e;
                if (i8 != 0) {
                    if (i8 == 1) {
                        jVar2 = (kotlinx.coroutines.flow.j) aVar.f36067g;
                        e1.n(obj);
                    } else {
                        if (i8 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        e1.n(obj);
                    }
                    jVar = jVar2;
                    jVar = jVar2;
                    return l2.f34958a;
                }
                e1.n(obj);
                kotlinx.coroutines.flow.j jVar3 = this.f36062a;
                i5.p pVar = this.f36063b;
                aVar.f36067g = jVar3;
                aVar.f36065e = 1;
                Object objA0 = pVar.a0(t7, aVar);
                if (objA0 == objH) {
                    return objH;
                }
                obj = objA0;
                jVar = jVar3;
                if (obj != null) {
                    aVar.f36067g = null;
                    aVar.f36065e = 2;
                    if (jVar.f(obj, aVar) == objH) {
                        jVar = jVar2;
                        return objH;
                    }
                }
                jVar = jVar2;
                jVar = jVar2;
                return l2.f34958a;
            }
        }

        public f(kotlinx.coroutines.flow.i iVar, i5.p pVar) {
            this.f36057a = iVar;
            this.f36058b = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            Object objA = this.f36057a.a(new b(jVar, this.f36058b), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }

        @a7.e
        public Object d(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(dVar);
            kotlin.jvm.internal.i0.e(5);
            kotlinx.coroutines.flow.i iVar = this.f36057a;
            b bVar = new b(jVar, this.f36058b);
            kotlin.jvm.internal.i0.e(0);
            iVar.a(bVar, dVar);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class g<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36069b;

        public static final class a<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f36070a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i5.p f36071b;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.a0$g$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {223, 224}, m = "emit", n = {"value", "$this$onEach_u24lambda_u2d7"}, s = {"L$0", "L$1"})
            public static final class C0459a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36072d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                int f36073e;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                Object f36075g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                Object f36076h;

                public C0459a(kotlin.coroutines.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36072d = obj;
                    this.f36073e |= Integer.MIN_VALUE;
                    return a.this.f(null, this);
                }
            }

            public a(kotlinx.coroutines.flow.j jVar, i5.p pVar) {
                this.f36070a = jVar;
                this.f36071b = pVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                C0459a c0459a;
                Object obj;
                kotlinx.coroutines.flow.j jVar;
                if (dVar instanceof C0459a) {
                    c0459a = (C0459a) dVar;
                    int i7 = c0459a.f36073e;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0459a.f36073e = i7 - Integer.MIN_VALUE;
                    } else {
                        c0459a = new C0459a(dVar);
                    }
                } else {
                    c0459a = new C0459a(dVar);
                }
                Object obj2 = c0459a.f36072d;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = c0459a.f36073e;
                if (i8 != 0) {
                    if (i8 == 1) {
                        kotlinx.coroutines.flow.j jVar2 = (kotlinx.coroutines.flow.j) c0459a.f36076h;
                        obj = c0459a.f36075g;
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
                kotlinx.coroutines.flow.j jVar3 = this.f36070a;
                i5.p pVar = this.f36071b;
                c0459a.f36075g = t7;
                c0459a.f36076h = jVar3;
                c0459a.f36073e = 1;
                kotlin.jvm.internal.i0.e(6);
                Object objA0 = pVar.a0(t7, c0459a);
                kotlin.jvm.internal.i0.e(7);
                if (objA0 == objH) {
                    return objH;
                }
                obj = t7;
                jVar = jVar3;
                c0459a.f36075g = null;
                c0459a.f36076h = null;
                c0459a.f36073e = 2;
                if (jVar.f(obj, c0459a) == objH) {
                    return objH;
                }
                return l2.f34958a;
            }
        }

        public g(kotlinx.coroutines.flow.i iVar, i5.p pVar) {
            this.f36068a = iVar;
            this.f36069b = pVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j jVar, @a7.d kotlin.coroutines.d dVar) {
            Object objA = this.f36068a.a(new a(jVar, this.f36069b), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class h<R> implements kotlinx.coroutines.flow.i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f36077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.q f36079c;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", f = "Transform.kt", i = {0, 0, 0}, l = {114, 115}, m = "collect", n = {"this", "$this$runningFold_u24lambda_u2d8", "accumulator"}, s = {"L$0", "L$1", "L$2"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36080d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36081e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36083g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36084h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            Object f36085i;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36080d = obj;
                this.f36081e |= Integer.MIN_VALUE;
                return h.this.a(null, this);
            }
        }

        public h(Object obj, kotlinx.coroutines.flow.i iVar, i5.q qVar) {
            this.f36077a = obj;
            this.f36078b = iVar;
            this.f36079c = qVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super R> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            h<R> hVar;
            kotlinx.coroutines.flow.j jVar2;
            k1.h hVar2;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36081e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36081e = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36080d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36081e;
            if (i8 != 0) {
                if (i8 == 1) {
                    hVar2 = (k1.h) aVar.f36085i;
                    kotlinx.coroutines.flow.j jVar3 = (kotlinx.coroutines.flow.j) aVar.f36084h;
                    hVar = (h) aVar.f36083g;
                    e1.n(obj);
                    jVar2 = jVar3;
                } else {
                    if (i8 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj);
                }
                return l2.f34958a;
            }
            e1.n(obj);
            k1.h hVar3 = new k1.h();
            ?? r7 = this.f36077a;
            hVar3.f34872a = r7;
            aVar.f36083g = this;
            aVar.f36084h = jVar;
            aVar.f36085i = hVar3;
            aVar.f36081e = 1;
            if (jVar.f(r7, aVar) == objH) {
                return objH;
            }
            hVar = this;
            jVar2 = jVar;
            hVar2 = hVar3;
            kotlinx.coroutines.flow.i iVar = hVar.f36078b;
            i iVar2 = new i(hVar2, hVar.f36079c, jVar2);
            aVar.f36083g = null;
            aVar.f36084h = null;
            aVar.f36085i = null;
            aVar.f36081e = 2;
            if (iVar.a(iVar2, aVar) == objH) {
                return objH;
            }
            return l2.f34958a;
        }
    }

    static final class i<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.h<R> f36086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.q<R, T, kotlin.coroutines.d<? super R>, Object> f36087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<R> f36088c;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1", f = "Transform.kt", i = {0}, l = {Constants.ACTION_SUBMIT_BTN_USER_PWD_NB, 104}, m = "emit", n = {"this"}, s = {"L$0"})
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36089d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f36090e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            /* synthetic */ Object f36091f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ i<T> f36092g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            int f36093h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(i<? super T> iVar, kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
                this.f36092g = iVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36091f = obj;
                this.f36093h |= Integer.MIN_VALUE;
                return this.f36092g.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        i(k1.h<R> hVar, i5.q<? super R, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar, kotlinx.coroutines.flow.j<? super R> jVar) {
            this.f36086a = hVar;
            this.f36087b = qVar;
            this.f36088c = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            i<T> iVar;
            k1.h hVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36093h;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36093h = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.f36091f;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36093h;
            if (i8 != 0) {
                if (i8 == 1) {
                    hVar = (k1.h) aVar.f36090e;
                    iVar = (i) aVar.f36089d;
                    e1.n(obj);
                } else {
                    if (i8 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj);
                }
                return l2.f34958a;
            }
            e1.n(obj);
            k1.h hVar2 = this.f36086a;
            i5.q<R, T, kotlin.coroutines.d<? super R>, Object> qVar = this.f36087b;
            T t8 = hVar2.f34872a;
            aVar.f36089d = this;
            aVar.f36090e = hVar2;
            aVar.f36093h = 1;
            Object objV = qVar.v((R) t8, t7, aVar);
            if (objV == objH) {
                return objH;
            }
            iVar = this;
            obj = (T) objV;
            hVar = hVar2;
            hVar.f34872a = (T) obj;
            kotlinx.coroutines.flow.j<R> jVar = iVar.f36088c;
            T t9 = iVar.f36086a.f34872a;
            aVar.f36089d = null;
            aVar.f36090e = null;
            aVar.f36093h = 2;
            if (jVar.f((R) t9, aVar) == objH) {
                return objH;
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class j<T> implements kotlinx.coroutines.flow.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.q f36095b;

        public j(kotlinx.coroutines.flow.i iVar, i5.q qVar) {
            this.f36094a = iVar;
            this.f36095b = qVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            k1.h hVar = new k1.h();
            hVar.f34872a = (T) kotlinx.coroutines.flow.internal.u.f36394a;
            Object objA = this.f36094a.a(new k(hVar, this.f36095b, jVar), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    static final class k<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.h<Object> f36096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.q<T, T, kotlin.coroutines.d<? super T>, Object> f36097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<T> f36098c;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1", f = "Transform.kt", i = {0}, l = {125, 127}, m = "emit", n = {"this"}, s = {"L$0"})
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36099d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f36100e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            /* synthetic */ Object f36101f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ k<T> f36102g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            int f36103h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(k<? super T> kVar, kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
                this.f36102g = kVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36101f = obj;
                this.f36103h |= Integer.MIN_VALUE;
                return this.f36102g.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        k(k1.h<Object> hVar, i5.q<? super T, ? super T, ? super kotlin.coroutines.d<? super T>, ? extends Object> qVar, kotlinx.coroutines.flow.j<? super T> jVar) {
            this.f36096a = hVar;
            this.f36097b = qVar;
            this.f36098c = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0078 A[RETURN] */
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
            k1.h<Object> hVar;
            k<T> kVar;
            k1.h<Object> hVar2;
            kotlinx.coroutines.flow.j<T> jVar;
            T t8;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36103h;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36103h = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.f36101f;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36103h;
            if (i8 != 0) {
                if (i8 == 1) {
                    hVar2 = (k1.h) aVar.f36100e;
                    kVar = (k) aVar.f36099d;
                    e1.n(obj);
                } else {
                    if (i8 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj);
                }
                return l2.f34958a;
            }
            e1.n(obj);
            hVar = this.f36096a;
            Object obj2 = hVar.f34872a;
            if (obj2 == kotlinx.coroutines.flow.internal.u.f36394a) {
                kVar = this;
            } else {
                i5.q<T, T, kotlin.coroutines.d<? super T>, Object> qVar = this.f36097b;
                aVar.f36099d = this;
                aVar.f36100e = hVar;
                aVar.f36103h = 1;
                Object objV = qVar.v((T) obj2, t7, aVar);
                if (objV == objH) {
                    return objH;
                }
                kVar = this;
                obj = objV;
                hVar2 = hVar;
            }
            hVar.f34872a = t7;
            jVar = kVar.f36098c;
            t8 = kVar.f36096a.f34872a;
            aVar.f36099d = null;
            aVar.f36100e = null;
            aVar.f36103h = 2;
            if (jVar.f(t8, aVar) == objH) {
                return objH;
            }
            return l2.f34958a;
            Object obj3 = obj;
            hVar = hVar2;
            t7 = (T) obj3;
            hVar.f34872a = t7;
            jVar = kVar.f36098c;
            t8 = kVar.f36096a.f34872a;
            aVar.f36099d = null;
            aVar.f36100e = null;
            aVar.f36103h = 2;
            if (jVar.f(t8, aVar) == objH) {
                return objH;
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class l<T> implements kotlinx.coroutines.flow.i<kotlin.collections.r0<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f36104a;

        public l(kotlinx.coroutines.flow.i iVar) {
            this.f36104a = iVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d kotlinx.coroutines.flow.j<? super kotlin.collections.r0<? extends T>> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objA = this.f36104a.a(new m(jVar, new k1.f()), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }
    }

    static final class m<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<kotlin.collections.r0<? extends T>> f36105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k1.f f36106b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$1$1", f = "Transform.kt", i = {}, l = {65}, m = "emit", n = {}, s = {})
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36107d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ m<T> f36108e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36109f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(m<? super T> mVar, kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
                this.f36108e = mVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36107d = obj;
                this.f36109f |= Integer.MIN_VALUE;
                return this.f36108e.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        m(kotlinx.coroutines.flow.j<? super kotlin.collections.r0<? extends T>> jVar, k1.f fVar) {
            this.f36105a = jVar;
            this.f36106b = fVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36109f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36109f = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.f36107d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36109f;
            if (i8 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.j<kotlin.collections.r0<? extends T>> jVar = this.f36105a;
                k1.f fVar = this.f36106b;
                int i9 = fVar.f34870a;
                fVar.f34870a = i9 + 1;
                if (i9 < 0) {
                    throw new ArithmeticException("Index overflow has happened");
                }
                kotlin.collections.r0<? extends T> r0Var = new kotlin.collections.r0<>(i9, t7);
                aVar.f36109f = 1;
                if (jVar.f(r0Var, aVar) == objH) {
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

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> a(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return new a(iVar, pVar);
    }

    public static final /* synthetic */ <R> kotlinx.coroutines.flow.i<R> b(kotlinx.coroutines.flow.i<?> iVar) {
        kotlin.jvm.internal.l0.w();
        return new b(iVar);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> c(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return new c(iVar, pVar);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> d(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar) {
        return new d(iVar);
    }

    @a7.d
    public static final <T, R> kotlinx.coroutines.flow.i<R> e(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        return new e(iVar, pVar);
    }

    @a7.d
    public static final <T, R> kotlinx.coroutines.flow.i<R> f(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        return new f(iVar, pVar);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> g(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return new g(iVar, pVar);
    }

    @a7.d
    public static final <T, R> kotlinx.coroutines.flow.i<R> h(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, R r7, @a7.d @kotlin.b i5.q<? super R, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return new h(r7, iVar, qVar);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<T> i(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.q<? super T, ? super T, ? super kotlin.coroutines.d<? super T>, ? extends Object> qVar) {
        return new j(iVar, qVar);
    }

    @a7.d
    public static final <T, R> kotlinx.coroutines.flow.i<R> j(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, R r7, @a7.d @kotlin.b i5.q<? super R, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return kotlinx.coroutines.flow.k.y1(iVar, r7, qVar);
    }

    @a7.d
    public static final <T> kotlinx.coroutines.flow.i<kotlin.collections.r0<T>> k(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar) {
        return new l(iVar);
    }
}
