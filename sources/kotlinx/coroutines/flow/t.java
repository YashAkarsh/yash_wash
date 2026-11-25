package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import easypay.appinvoke.manager.Constants;
import kotlin.a1;
import kotlin.e1;
import kotlin.jvm.internal.k1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class t {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", f = "Emitters.kt", i = {0}, l = {216}, m = "invokeSafely$FlowKt__EmittersKt", n = {"cause"}, s = {"L$0"})
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36622e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36623f;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36622e = obj;
            this.f36623f |= Integer.MIN_VALUE;
            return t.c(null, null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f36624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.q f36625b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 1, 2}, l = {114, Constants.OTP_VIEW_GONE, 128}, m = "collect", n = {"this", "$this$onCompletion_u24lambda_u2d2", "e", "sc"}, s = {"L$0", "L$1", "L$0", "L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36626d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36627e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36629g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36630h;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36626d = obj;
                this.f36627e |= Integer.MIN_VALUE;
                return b.this.a(null, this);
            }
        }

        public b(i iVar, i5.q qVar) {
            this.f36624a = iVar;
            this.f36625b = qVar;
        }

        /* JADX WARN: Code duplicated, block: B:34:0x0086 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x0087  */
        /* JADX WARN: Code duplicated, block: B:46:0x00ab A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) throws Throwable {
            a aVar;
            b<T> bVar;
            z0 z0Var;
            i5.q qVar;
            kotlinx.coroutines.flow.internal.v vVar;
            Throwable th;
            kotlinx.coroutines.flow.internal.v vVar2;
            Object objV;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36627e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36627e = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36626d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36627e;
            if (i8 == 0) {
                e1.n(obj);
                try {
                    i iVar = this.f36624a;
                    aVar.f36629g = this;
                    aVar.f36630h = jVar;
                    aVar.f36627e = 1;
                    if (iVar.a(jVar, aVar) == objH) {
                        return objH;
                    }
                    bVar = this;
                    vVar = new kotlinx.coroutines.flow.internal.v(jVar, aVar.d());
                    i5.q qVar2 = bVar.f36625b;
                    aVar.f36629g = vVar;
                    aVar.f36630h = null;
                    aVar.f36627e = 3;
                    kotlin.jvm.internal.i0.e(6);
                    objV = qVar2.v(vVar, null, aVar);
                    kotlin.jvm.internal.i0.e(7);
                    if (objV == objH) {
                        return objH;
                    }
                    vVar2 = vVar;
                    vVar2.V();
                    return l2.f34958a;
                } catch (Throwable th2) {
                    th = th2;
                    bVar = this;
                    z0Var = new z0(th);
                    qVar = bVar.f36625b;
                    aVar.f36629g = th;
                    aVar.f36630h = null;
                    aVar.f36627e = 2;
                    if (t.c(z0Var, qVar, th, aVar) == objH) {
                        return objH;
                    }
                    throw th;
                }
            }
            if (i8 != 1) {
                if (i8 == 2) {
                    Throwable th3 = (Throwable) aVar.f36629g;
                    e1.n(obj);
                    throw th3;
                }
                if (i8 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                vVar2 = (kotlinx.coroutines.flow.internal.v) aVar.f36629g;
                try {
                    e1.n(obj);
                    vVar2.V();
                    return l2.f34958a;
                } catch (Throwable th4) {
                    th = th4;
                    vVar2.V();
                    throw th;
                }
            }
            jVar = (j) aVar.f36630h;
            bVar = (b) aVar.f36629g;
            try {
                e1.n(obj);
                vVar = new kotlinx.coroutines.flow.internal.v(jVar, aVar.d());
                try {
                    i5.q qVar3 = bVar.f36625b;
                    aVar.f36629g = vVar;
                    aVar.f36630h = null;
                    aVar.f36627e = 3;
                    kotlin.jvm.internal.i0.e(6);
                    objV = qVar3.v(vVar, null, aVar);
                    kotlin.jvm.internal.i0.e(7);
                    if (objV == objH) {
                        return objH;
                    }
                    vVar2 = vVar;
                    vVar2.V();
                    return l2.f34958a;
                } catch (Throwable th5) {
                    th = th5;
                    vVar2 = vVar;
                    vVar2.V();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                z0Var = new z0(th);
                qVar = bVar.f36625b;
                aVar.f36629g = th;
                aVar.f36630h = null;
                aVar.f36627e = 2;
                if (t.c(z0Var, qVar, th, aVar) == objH) {
                    return objH;
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f36631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.p f36632b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0, 1}, l = {114, 122}, m = "collect", n = {"this", "$this$onEmpty_u24lambda_u2d3", "isEmpty", "collector"}, s = {"L$0", "L$1", "L$2", "L$0"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36633d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36634e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36636g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36637h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            Object f36638i;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36633d = obj;
                this.f36634e |= Integer.MIN_VALUE;
                return c.this.a(null, this);
            }
        }

        public c(i iVar, i5.p pVar) {
            this.f36631a = iVar;
            this.f36632b = pVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.flow.j] */
        /* JADX WARN: Type inference failed for: r2v9 */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, kotlinx.coroutines.flow.j, kotlinx.coroutines.flow.j<? super T>] */
        /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.flow.internal.v] */
        /* JADX WARN: Type inference failed for: r7v15 */
        /* JADX WARN: Type inference failed for: r7v16 */
        /* JADX WARN: Type inference failed for: r7v7, types: [kotlinx.coroutines.flow.internal.v] */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            c<T> cVar;
            ?? r7;
            k1.a aVar2;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36634e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36634e = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36633d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36634e;
            try {
                if (i8 != 0) {
                    if (i8 == 1) {
                        aVar2 = (k1.a) aVar.f36638i;
                        j jVar2 = (j) aVar.f36637h;
                        cVar = (c) aVar.f36636g;
                        e1.n(obj);
                        r7 = jVar2;
                    } else {
                        if (i8 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlinx.coroutines.flow.internal.v vVar = (kotlinx.coroutines.flow.internal.v) aVar.f36636g;
                        e1.n(obj);
                        jVar = vVar;
                    }
                    ((kotlinx.coroutines.flow.internal.v) jVar).V();
                    return l2.f34958a;
                }
                e1.n(obj);
                k1.a aVar3 = new k1.a();
                aVar3.f34865a = true;
                i iVar = this.f36631a;
                d dVar2 = new d(aVar3, jVar);
                aVar.f36636g = this;
                aVar.f36637h = jVar;
                aVar.f36638i = aVar3;
                aVar.f36634e = 1;
                if (iVar.a(dVar2, aVar) == objH) {
                    return objH;
                }
                cVar = this;
                r7 = jVar;
                aVar2 = aVar3;
                if (aVar2.f34865a) {
                    kotlinx.coroutines.flow.internal.v vVar2 = new kotlinx.coroutines.flow.internal.v(r7, aVar.d());
                    i5.p pVar = cVar.f36632b;
                    aVar.f36636g = vVar2;
                    aVar.f36637h = null;
                    aVar.f36638i = null;
                    aVar.f36634e = 2;
                    kotlin.jvm.internal.i0.e(6);
                    Object objA0 = pVar.a0(vVar2, aVar);
                    kotlin.jvm.internal.i0.e(7);
                    jVar = vVar2;
                    if (objA0 == objH) {
                        return objH;
                    }
                    ((kotlinx.coroutines.flow.internal.v) jVar).V();
                }
                return l2.f34958a;
            } catch (Throwable th) {
                jVar.V();
                throw th;
            }
        }
    }

    static final class d<T> implements j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.a f36639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j<T> f36640b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1", f = "Emitters.kt", i = {}, l = {com.alibaba.fastjson.asm.j.Z}, m = "emit", n = {}, s = {})
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36641d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ d<T> f36642e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36643f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(d<? super T> dVar, kotlin.coroutines.d<? super a> dVar2) {
                super(dVar2);
                this.f36642e = dVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36641d = obj;
                this.f36643f |= Integer.MIN_VALUE;
                return this.f36642e.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        d(k1.a aVar, j<? super T> jVar) {
            this.f36639a = aVar;
            this.f36640b = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36643f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36643f = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.f36641d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36643f;
            if (i8 == 0) {
                e1.n(obj);
                this.f36639a.f34865a = false;
                j<T> jVar = this.f36640b;
                aVar.f36643f = 1;
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
    public static final class e<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p f36644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f36645b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0}, l = {116, 120}, m = "collect", n = {"this", "$this$onStart_u24lambda_u2d1", "safeCollector"}, s = {"L$0", "L$1", "L$2"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36646d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36647e;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f36649g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36650h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            Object f36651i;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36646d = obj;
                this.f36647e |= Integer.MIN_VALUE;
                return e.this.a(null, this);
            }
        }

        public e(i5.p pVar, i iVar) {
            this.f36644a = pVar;
            this.f36645b = iVar;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0082 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) throws Throwable {
            a aVar;
            Throwable th;
            kotlinx.coroutines.flow.internal.v vVar;
            e<T> eVar;
            j<? super T> jVar2;
            i iVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36647e;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36647e = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object obj = aVar.f36646d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36647e;
            if (i8 == 0) {
                e1.n(obj);
                kotlinx.coroutines.flow.internal.v vVar2 = new kotlinx.coroutines.flow.internal.v(jVar, aVar.d());
                try {
                    i5.p pVar = this.f36644a;
                    aVar.f36649g = this;
                    aVar.f36650h = jVar;
                    aVar.f36651i = vVar2;
                    aVar.f36647e = 1;
                    kotlin.jvm.internal.i0.e(6);
                    Object objA0 = pVar.a0(vVar2, aVar);
                    kotlin.jvm.internal.i0.e(7);
                    if (objA0 == objH) {
                        return objH;
                    }
                    eVar = this;
                    jVar2 = jVar;
                    vVar = vVar2;
                    vVar.V();
                    iVar = eVar.f36645b;
                    aVar.f36649g = null;
                    aVar.f36650h = null;
                    aVar.f36651i = null;
                    aVar.f36647e = 2;
                    if (iVar.a(jVar2, aVar) == objH) {
                        return objH;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    vVar = vVar2;
                    vVar.V();
                    throw th;
                }
            } else if (i8 == 1) {
                vVar = (kotlinx.coroutines.flow.internal.v) aVar.f36651i;
                jVar2 = (j) aVar.f36650h;
                eVar = (e) aVar.f36649g;
                try {
                    e1.n(obj);
                    vVar.V();
                    iVar = eVar.f36645b;
                    aVar.f36649g = null;
                    aVar.f36650h = null;
                    aVar.f36651i = null;
                    aVar.f36647e = 2;
                    if (iVar.a(jVar2, aVar) == objH) {
                        return objH;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    vVar.V();
                    throw th;
                }
            } else {
                if (i8 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    public static final class f<R> extends kotlin.coroutines.jvm.internal.o implements i5.p<j<? super R>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36652e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36653f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i<T> f36654g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i5.q<j<? super R>, T, kotlin.coroutines.d<? super l2>, Object> f36655h;

        public static final class a<T> implements j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i5.q<j<? super R>, T, kotlin.coroutines.d<? super l2>, Object> f36656a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ j<R> f36657b;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.t$f$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1", f = "Emitters.kt", i = {}, l = {42}, m = "emit", n = {}, s = {})
            public static final class C0481a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36658d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ a<T> f36659e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                int f36660f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0481a(a<? super T> aVar, kotlin.coroutines.d<? super C0481a> dVar) {
                    super(dVar);
                    this.f36659e = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36658d = obj;
                    this.f36660f |= Integer.MIN_VALUE;
                    return this.f36659e.f(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a(i5.q<? super j<? super R>, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, j<? super R> jVar) {
                this.f36656a = qVar;
                this.f36657b = jVar;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @a7.e
            public final Object a(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                kotlin.jvm.internal.i0.e(4);
                new C0481a(this, dVar);
                kotlin.jvm.internal.i0.e(5);
                this.f36656a.v((j<? super R>) this.f36657b, t7, dVar);
                return l2.f34958a;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlinx.coroutines.flow.j
            @a7.e
            public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                C0481a c0481a;
                if (dVar instanceof C0481a) {
                    c0481a = (C0481a) dVar;
                    int i7 = c0481a.f36660f;
                    if ((i7 & Integer.MIN_VALUE) != 0) {
                        c0481a.f36660f = i7 - Integer.MIN_VALUE;
                    } else {
                        c0481a = new C0481a(this, dVar);
                    }
                } else {
                    c0481a = new C0481a(this, dVar);
                }
                Object obj = c0481a.f36658d;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i8 = c0481a.f36660f;
                if (i8 == 0) {
                    e1.n(obj);
                    i5.q<j<? super R>, T, kotlin.coroutines.d<? super l2>, Object> qVar = this.f36656a;
                    j<R> jVar = this.f36657b;
                    c0481a.f36660f = 1;
                    if (qVar.v((j<? super R>) jVar, t7, c0481a) == objH) {
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
        public f(i<? extends T> iVar, i5.q<? super j<? super R>, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, kotlin.coroutines.d<? super f> dVar) {
            super(2, dVar);
            this.f36654g = iVar;
            this.f36655h = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            f fVar = new f(this.f36654g, this.f36655h, dVar);
            fVar.f36653f = obj;
            return fVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.d to kotlinx.coroutines.flow.t$f<R> for r5v1 'this'  kotlin.coroutines.d
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
                int r1 = r5.f36652e
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.e1.n(r6)
                goto L30
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L17:
                kotlin.e1.n(r6)
                java.lang.Object r6 = r5.f36653f
                kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) r6
                kotlinx.coroutines.flow.i<T> r1 = r5.f36654g
                kotlinx.coroutines.flow.t$f$a r3 = new kotlinx.coroutines.flow.t$f$a
                i5.q<kotlinx.coroutines.flow.j<? super R>, T, kotlin.coroutines.d<? super kotlin.l2>, java.lang.Object> r4 = r5.f36655h
                r3.<init>(r4, r6)
                r5.f36652e = r2
                java.lang.Object r6 = r1.a(r3, r5)
                if (r6 != r0) goto L30
                return r0
            L30:
                kotlin.l2 r6 = kotlin.l2.f34958a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.t.f.R(java.lang.Object):java.lang.Object");
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d j<? super R> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((f) D(jVar, dVar)).R(l2.f34958a);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.d to kotlinx.coroutines.flow.t$f<R> for r3v1 'this'  kotlin.coroutines.d
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @a7.e
        public final java.lang.Object g0(@a7.d java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r4 = r3.f36653f
                kotlinx.coroutines.flow.j r4 = (kotlinx.coroutines.flow.j) r4
                kotlinx.coroutines.flow.i<T> r0 = r3.f36654g
                kotlinx.coroutines.flow.t$f$a r1 = new kotlinx.coroutines.flow.t$f$a
                i5.q<kotlinx.coroutines.flow.j<? super R>, T, kotlin.coroutines.d<? super kotlin.l2>, java.lang.Object> r2 = r3.f36655h
                r1.<init>(r2, r4)
                r4 = 0
                kotlin.jvm.internal.i0.e(r4)
                r0.a(r1, r3)
                r4 = 1
                kotlin.jvm.internal.i0.e(r4)
                kotlin.l2 r4 = kotlin.l2.f34958a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.t.f.g0(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    public static final class g<R> implements i<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f36661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.q f36662b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36663d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f36664e;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36663d = obj;
                this.f36664e |= Integer.MIN_VALUE;
                return g.this.a(null, this);
            }
        }

        public g(i iVar, i5.q qVar) {
            this.f36661a = iVar;
            this.f36662b = qVar;
        }

        @Override // kotlinx.coroutines.flow.i
        @a7.e
        public Object a(@a7.d j<? super R> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objA = this.f36661a.a(new h(this.f36662b, jVar), dVar);
            return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
        }

        @a7.e
        public Object d(@a7.d j jVar, @a7.d kotlin.coroutines.d dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(dVar);
            kotlin.jvm.internal.i0.e(5);
            i iVar = this.f36661a;
            h hVar = new h(this.f36662b, jVar);
            kotlin.jvm.internal.i0.e(0);
            iVar.a(hVar, dVar);
            kotlin.jvm.internal.i0.e(1);
            return l2.f34958a;
        }
    }

    public static final class h<T> implements j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.q<j<? super R>, T, kotlin.coroutines.d<? super l2>, Object> f36666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j<R> f36667b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1", f = "Emitters.kt", i = {}, l = {ConstraintLayout.LayoutParams.a.f4571b0}, m = "emit", n = {}, s = {})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36668d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ h<T> f36669e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36670f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(h<? super T> hVar, kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
                this.f36669e = hVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36668d = obj;
                this.f36670f |= Integer.MIN_VALUE;
                return this.f36669e.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public h(i5.q<? super j<? super R>, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, j<? super R> jVar) {
            this.f36666a = qVar;
            this.f36667b = jVar;
        }

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
        @a7.e
        public final Object a(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(this, dVar);
            kotlin.jvm.internal.i0.e(5);
            this.f36666a.v(this.f36667b, t7, dVar);
            return l2.f34958a;
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
            a aVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36670f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36670f = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.f36668d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36670f;
            if (i8 == 0) {
                e1.n(obj);
                i5.q<j<? super R>, T, kotlin.coroutines.d<? super l2>, Object> qVar = this.f36666a;
                Object obj2 = this.f36667b;
                aVar.f36670f = 1;
                if (qVar.v(obj2, t7, aVar) == objH) {
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

    public static final void b(@a7.d j<?> jVar) {
        if (jVar instanceof z0) {
            throw ((z0) jVar).f36923a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object c(j<? super T> jVar, i5.q<? super j<? super T>, ? super Throwable, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, Throwable th, kotlin.coroutines.d<? super l2> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i7 = aVar.f36623f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar.f36623f = i7 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.f36622e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar.f36623f;
        try {
            if (i8 == 0) {
                e1.n(obj);
                aVar.f36621d = th;
                aVar.f36623f = 1;
                if (qVar.v(jVar, th, aVar) == objH) {
                    return objH;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) aVar.f36621d;
                e1.n(obj);
            }
            return l2.f34958a;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                kotlin.p.a(th2, th);
            }
            throw th2;
        }
    }

    @a7.d
    public static final <T> i<T> d(@a7.d i<? extends T> iVar, @a7.d i5.q<? super j<? super T>, ? super Throwable, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        return new b(iVar, qVar);
    }

    @a7.d
    public static final <T> i<T> e(@a7.d i<? extends T> iVar, @a7.d i5.p<? super j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return new c(iVar, pVar);
    }

    @a7.d
    public static final <T> i<T> f(@a7.d i<? extends T> iVar, @a7.d i5.p<? super j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return new e(pVar, iVar);
    }

    @a7.d
    public static final <T, R> i<R> g(@a7.d i<? extends T> iVar, @a7.d @kotlin.b i5.q<? super j<? super R>, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        return k.I0(new f(iVar, qVar, null));
    }

    @a7.d
    @a1
    public static final <T, R> i<R> h(@a7.d i<? extends T> iVar, @a7.d @kotlin.b i5.q<? super j<? super R>, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
        return new g(iVar, qVar);
    }
}
