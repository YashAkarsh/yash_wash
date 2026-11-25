package kotlinx.coroutines.flow;

import easypay.appinvoke.manager.Constants;
import java.util.NoSuchElementException;
import kotlin.e1;
import kotlin.jvm.internal.k1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class y {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.h f36830a;

        public a(k1.h hVar) {
            this.f36830a = hVar;
        }

        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            this.f36830a.f34872a = t7;
            throw new kotlinx.coroutines.flow.internal.a(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p f36831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k1.h f36832b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2", f = "Reduce.kt", i = {0, 0}, l = {143}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$1"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36833d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f36834e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36835f;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36837h;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36834e = obj;
                this.f36835f |= Integer.MIN_VALUE;
                return b.this.f(null, this);
            }
        }

        public b(i5.p pVar, k1.h hVar) {
            this.f36831a = pVar;
            this.f36832b = hVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            b<T> bVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36835f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36835f = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object objA0 = aVar.f36834e;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36835f;
            boolean z7 = true;
            if (i8 == 0) {
                e1.n(objA0);
                i5.p pVar = this.f36831a;
                aVar.f36833d = this;
                aVar.f36837h = t7;
                aVar.f36835f = 1;
                kotlin.jvm.internal.i0.e(6);
                objA0 = pVar.a0(t7, aVar);
                kotlin.jvm.internal.i0.e(7);
                if (objA0 == objH) {
                    return objH;
                }
                bVar = this;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t7 = (T) aVar.f36837h;
                bVar = (b) aVar.f36833d;
                e1.n(objA0);
            }
            if (((Boolean) objA0).booleanValue()) {
                bVar.f36832b.f34872a = t7;
                z7 = false;
            }
            if (z7) {
                return l2.f34958a;
            }
            throw new kotlinx.coroutines.flow.internal.a(bVar);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {com.alibaba.fastjson.asm.j.X}, m = "first", n = {com.alipay.sdk.util.m.f13818c, "collector$iv"}, s = {"L$0", "L$1"})
    static final class c<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36839e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f36840f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f36841g;

        c(kotlin.coroutines.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36840f = obj;
            this.f36841g |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.u0(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0}, l = {com.alibaba.fastjson.asm.j.X}, m = "first", n = {"predicate", com.alipay.sdk.util.m.f13818c, "collector$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class d<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36842d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36843e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f36844f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f36845g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f36846h;

        d(kotlin.coroutines.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36845g = obj;
            this.f36846h |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.t0(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class e<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.h f36847a;

        public e(k1.h hVar) {
            this.f36847a = hVar;
        }

        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            this.f36847a.f34872a = t7;
            throw new kotlinx.coroutines.flow.internal.a(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class f<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p f36848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k1.h f36849b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2", f = "Reduce.kt", i = {0, 0}, l = {143}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$1"})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36850d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f36851e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36852f;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f36854h;

            public a(kotlin.coroutines.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36851e = obj;
                this.f36852f |= Integer.MIN_VALUE;
                return f.this.f(null, this);
            }
        }

        public f(i5.p pVar, k1.h hVar) {
            this.f36848a = pVar;
            this.f36849b = hVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            f<T> fVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36852f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36852f = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(dVar);
                }
            } else {
                aVar = new a(dVar);
            }
            Object objA0 = aVar.f36851e;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36852f;
            boolean z7 = true;
            if (i8 == 0) {
                e1.n(objA0);
                i5.p pVar = this.f36848a;
                aVar.f36850d = this;
                aVar.f36854h = t7;
                aVar.f36852f = 1;
                kotlin.jvm.internal.i0.e(6);
                objA0 = pVar.a0(t7, aVar);
                kotlin.jvm.internal.i0.e(7);
                if (objA0 == objH) {
                    return objH;
                }
                fVar = this;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t7 = (T) aVar.f36854h;
                fVar = (f) aVar.f36850d;
                e1.n(objA0);
            }
            if (((Boolean) objA0).booleanValue()) {
                fVar.f36849b.f34872a = t7;
                z7 = false;
            }
            if (z7) {
                return l2.f34958a;
            }
            throw new kotlinx.coroutines.flow.internal.a(fVar);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {com.alibaba.fastjson.asm.j.X}, m = "firstOrNull", n = {com.alipay.sdk.util.m.f13818c, "collector$iv"}, s = {"L$0", "L$1"})
    static final class g<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36855d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36856e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f36857f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f36858g;

        g(kotlin.coroutines.d<? super g> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36857f = obj;
            this.f36858g |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.w0(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {com.alibaba.fastjson.asm.j.X}, m = "firstOrNull", n = {com.alipay.sdk.util.m.f13818c, "collector$iv"}, s = {"L$0", "L$1"})
    static final class h<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36859d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36860e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f36861f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f36862g;

        h(kotlin.coroutines.d<? super h> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36861f = obj;
            this.f36862g |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.v0(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {44}, m = "fold", n = {"accumulator"}, s = {"L$0"})
    static final class i<T, R> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36863d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36864e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36865f;

        i(kotlin.coroutines.d<? super i> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36864e = obj;
            this.f36865f |= Integer.MIN_VALUE;
            return y.e(null, null, null, this);
        }
    }

    public static final class j<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.h<R> f36866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.q<R, T, kotlin.coroutines.d<? super R>, Object> f36867b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2", f = "Reduce.kt", i = {}, l = {45}, m = "emit", n = {}, s = {})
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36868d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f36869e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ j<T> f36870f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            int f36871g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(j<? super T> jVar, kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
                this.f36870f = jVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36869e = obj;
                this.f36871g |= Integer.MIN_VALUE;
                return this.f36870f.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public j(k1.h<R> hVar, i5.q<? super R, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
            this.f36866a = hVar;
            this.f36867b = qVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @a7.e
        public final Object a(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(this, dVar);
            kotlin.jvm.internal.i0.e(5);
            k1.h<R> hVar = this.f36866a;
            hVar.f34872a = (T) this.f36867b.v((R) hVar.f34872a, t7, (kotlin.coroutines.d<? super R>) dVar);
            return l2.f34958a;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            a aVar;
            k1.h hVar;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36871g;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36871g = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.f36869e;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36871g;
            if (i8 == 0) {
                e1.n(obj);
                k1.h hVar2 = this.f36866a;
                i5.q<R, T, kotlin.coroutines.d<? super R>, Object> qVar = this.f36867b;
                T t8 = hVar2.f34872a;
                aVar.f36868d = hVar2;
                aVar.f36871g = 1;
                Object objV = qVar.v((R) t8, t7, aVar);
                if (objV == objH) {
                    return objH;
                }
                obj = (T) objV;
                hVar = hVar2;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                hVar = (k1.h) aVar.f36868d;
                e1.n(obj);
            }
            hVar.f34872a = (T) obj;
            return l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {Constants.ACTION_START_NB_OTP}, m = "last", n = {com.alipay.sdk.util.m.f13818c}, s = {"L$0"})
    static final class k<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36873e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36874f;

        k(kotlin.coroutines.d<? super k> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36873e = obj;
            this.f36874f |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.S0(null, this);
        }
    }

    static final class l<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.h<Object> f36875a;

        l(k1.h<Object> hVar) {
            this.f36875a = hVar;
        }

        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            this.f36875a.f34872a = t7;
            return l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {com.alibaba.fastjson.asm.j.P}, m = "lastOrNull", n = {com.alipay.sdk.util.m.f13818c}, s = {"L$0"})
    static final class m<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36876d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36877e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36878f;

        m(kotlin.coroutines.d<? super m> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36877e = obj;
            this.f36878f |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.T0(null, this);
        }
    }

    static final class n<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.h<T> f36879a;

        n(k1.h<T> hVar) {
            this.f36879a = hVar;
        }

        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            this.f36879a.f34872a = t7;
            return l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {22}, m = "reduce", n = {"accumulator"}, s = {"L$0"})
    static final class o<S, T extends S> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36880d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36881e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36882f;

        o(kotlin.coroutines.d<? super o> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36881e = obj;
            this.f36882f |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.s1(null, null, this);
        }
    }

    static final class p<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.h<Object> f36883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.q<S, T, kotlin.coroutines.d<? super S>, Object> f36884b;

        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2", f = "Reduce.kt", i = {}, l = {25}, m = "emit", n = {}, s = {})
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f36885d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f36886e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ p<T> f36887f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            int f36888g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(p<? super T> pVar, kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
                this.f36887f = pVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36886e = obj;
                this.f36888g |= Integer.MIN_VALUE;
                return this.f36887f.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        p(k1.h<Object> hVar, i5.q<? super S, ? super T, ? super kotlin.coroutines.d<? super S>, ? extends Object> qVar) {
            this.f36883a = hVar;
            this.f36884b = qVar;
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
            k1.h<Object> hVar;
            k1.h<Object> hVar2;
            if (dVar instanceof a) {
                aVar = (a) dVar;
                int i7 = aVar.f36888g;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    aVar.f36888g = i7 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, dVar);
                }
            } else {
                aVar = new a(this, dVar);
            }
            Object obj = aVar.f36886e;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = aVar.f36888g;
            if (i8 == 0) {
                e1.n(obj);
                hVar = this.f36883a;
                Object obj2 = hVar.f34872a;
                if (obj2 != kotlinx.coroutines.flow.internal.u.f36394a) {
                    i5.q<S, T, kotlin.coroutines.d<? super S>, Object> qVar = this.f36884b;
                    aVar.f36885d = hVar;
                    aVar.f36888g = 1;
                    Object objV = qVar.v((S) obj2, t7, aVar);
                    if (objV == objH) {
                        return objH;
                    }
                    obj = objV;
                    hVar2 = hVar;
                }
                hVar.f34872a = t7;
                return l2.f34958a;
            }
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar2 = (k1.h) aVar.f36885d;
            e1.n(obj);
            Object obj3 = obj;
            hVar = hVar2;
            t7 = (T) obj3;
            hVar.f34872a = t7;
            return l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {com.alibaba.fastjson.asm.j.f12627u}, m = "single", n = {com.alipay.sdk.util.m.f13818c}, s = {"L$0"})
    static final class q<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36889d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36890e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36891f;

        q(kotlin.coroutines.d<? super q> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36890e = obj;
            this.f36891f |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.H1(null, this);
        }
    }

    static final class r<T> implements kotlinx.coroutines.flow.j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.h<Object> f36892a;

        r(k1.h<Object> hVar) {
            this.f36892a = hVar;
        }

        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            k1.h<Object> hVar = this.f36892a;
            if (!(hVar.f34872a == kotlinx.coroutines.flow.internal.u.f36394a)) {
                throw new IllegalArgumentException("Flow has more than one element".toString());
            }
            hVar.f34872a = t7;
            return l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class s<T> implements kotlinx.coroutines.flow.j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k1.h f36893a;

        public s(k1.h hVar) {
            this.f36893a = hVar;
        }

        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            boolean z7;
            k1.h hVar = this.f36893a;
            T t8 = hVar.f34872a;
            T t9 = (T) kotlinx.coroutines.flow.internal.u.f36394a;
            if (t8 == t9) {
                hVar.f34872a = t7;
                z7 = true;
            } else {
                hVar.f34872a = t9;
                z7 = false;
            }
            if (z7) {
                return l2.f34958a;
            }
            throw new kotlinx.coroutines.flow.internal.a(this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {com.alibaba.fastjson.asm.j.X}, m = "singleOrNull", n = {com.alipay.sdk.util.m.f13818c, "collector$iv"}, s = {"L$0", "L$1"})
    static final class t<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36894d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36895e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f36896f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f36897g;

        t(kotlin.coroutines.d<? super t> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36896f = obj;
            this.f36897g |= Integer.MIN_VALUE;
            return kotlinx.coroutines.flow.k.I1(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object a(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        d dVar2;
        i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar2;
        k1.h hVar;
        kotlinx.coroutines.flow.internal.a e8;
        kotlinx.coroutines.flow.j<? super Object> jVar;
        if (dVar instanceof d) {
            dVar2 = (d) dVar;
            int i7 = dVar2.f36846h;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                dVar2.f36846h = i7 - Integer.MIN_VALUE;
            } else {
                dVar2 = new d(dVar);
            }
        } else {
            dVar2 = new d(dVar);
        }
        Object obj = dVar2.f36845g;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = dVar2.f36846h;
        if (i8 == 0) {
            e1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.f34872a = (T) kotlinx.coroutines.flow.internal.u.f36394a;
            kotlinx.coroutines.flow.j<? super Object> bVar = new b<>(pVar, hVar2);
            try {
                dVar2.f36842d = pVar;
                dVar2.f36843e = hVar2;
                dVar2.f36844f = bVar;
                dVar2.f36846h = 1;
                if (iVar.a(bVar, dVar2) == objH) {
                    return objH;
                }
                pVar2 = pVar;
                hVar = hVar2;
            } catch (kotlinx.coroutines.flow.internal.a e9) {
                pVar2 = pVar;
                hVar = hVar2;
                e8 = e9;
                jVar = bVar;
                kotlinx.coroutines.flow.internal.q.b(e8, jVar);
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (b) dVar2.f36844f;
            hVar = (k1.h) dVar2.f36843e;
            pVar2 = (i5.p) dVar2.f36842d;
            try {
                e1.n(obj);
            } catch (kotlinx.coroutines.flow.internal.a e10) {
                e8 = e10;
                kotlinx.coroutines.flow.internal.q.b(e8, jVar);
            }
        }
        T t7 = hVar.f34872a;
        if (t7 != kotlinx.coroutines.flow.internal.u.f36394a) {
            return t7;
        }
        throw new NoSuchElementException(kotlin.jvm.internal.l0.C("Expected at least one element matching the predicate ", pVar2));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object b(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        c cVar;
        k1.h hVar;
        kotlinx.coroutines.flow.internal.a e8;
        kotlinx.coroutines.flow.j<? super Object> jVar;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i7 = cVar.f36841g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                cVar.f36841g = i7 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj = cVar.f36840f;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = cVar.f36841g;
        if (i8 == 0) {
            e1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.f34872a = (T) kotlinx.coroutines.flow.internal.u.f36394a;
            kotlinx.coroutines.flow.j<? super Object> aVar = new a<>(hVar2);
            try {
                cVar.f36838d = hVar2;
                cVar.f36839e = aVar;
                cVar.f36841g = 1;
                if (iVar.a(aVar, cVar) == objH) {
                    return objH;
                }
                hVar = hVar2;
            } catch (kotlinx.coroutines.flow.internal.a e9) {
                hVar = hVar2;
                e8 = e9;
                jVar = aVar;
                kotlinx.coroutines.flow.internal.q.b(e8, jVar);
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (a) cVar.f36839e;
            hVar = (k1.h) cVar.f36838d;
            try {
                e1.n(obj);
            } catch (kotlinx.coroutines.flow.internal.a e10) {
                e8 = e10;
                kotlinx.coroutines.flow.internal.q.b(e8, jVar);
            }
        }
        T t7 = hVar.f34872a;
        if (t7 != kotlinx.coroutines.flow.internal.u.f36394a) {
            return t7;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object c(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        h hVar;
        k1.h hVar2;
        kotlinx.coroutines.flow.internal.a e8;
        kotlinx.coroutines.flow.j<? super Object> jVar;
        if (dVar instanceof h) {
            hVar = (h) dVar;
            int i7 = hVar.f36862g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                hVar.f36862g = i7 - Integer.MIN_VALUE;
            } else {
                hVar = new h(dVar);
            }
        } else {
            hVar = new h(dVar);
        }
        Object obj = hVar.f36861f;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = hVar.f36862g;
        if (i8 == 0) {
            e1.n(obj);
            k1.h hVar3 = new k1.h();
            kotlinx.coroutines.flow.j<? super Object> fVar = new f<>(pVar, hVar3);
            try {
                hVar.f36859d = hVar3;
                hVar.f36860e = fVar;
                hVar.f36862g = 1;
                if (iVar.a(fVar, hVar) == objH) {
                    return objH;
                }
                hVar2 = hVar3;
            } catch (kotlinx.coroutines.flow.internal.a e9) {
                hVar2 = hVar3;
                e8 = e9;
                jVar = fVar;
                kotlinx.coroutines.flow.internal.q.b(e8, jVar);
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (f) hVar.f36860e;
            hVar2 = (k1.h) hVar.f36859d;
            try {
                e1.n(obj);
            } catch (kotlinx.coroutines.flow.internal.a e10) {
                e8 = e10;
                kotlinx.coroutines.flow.internal.q.b(e8, jVar);
            }
        }
        return hVar2.f34872a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object d(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        g gVar;
        k1.h hVar;
        kotlinx.coroutines.flow.internal.a e8;
        kotlinx.coroutines.flow.j<? super Object> jVar;
        if (dVar instanceof g) {
            gVar = (g) dVar;
            int i7 = gVar.f36858g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                gVar.f36858g = i7 - Integer.MIN_VALUE;
            } else {
                gVar = new g(dVar);
            }
        } else {
            gVar = new g(dVar);
        }
        Object obj = gVar.f36857f;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = gVar.f36858g;
        if (i8 == 0) {
            e1.n(obj);
            k1.h hVar2 = new k1.h();
            kotlinx.coroutines.flow.j<? super Object> eVar = new e<>(hVar2);
            try {
                gVar.f36855d = hVar2;
                gVar.f36856e = eVar;
                gVar.f36858g = 1;
                if (iVar.a(eVar, gVar) == objH) {
                    return objH;
                }
                hVar = hVar2;
            } catch (kotlinx.coroutines.flow.internal.a e9) {
                hVar = hVar2;
                e8 = e9;
                jVar = eVar;
                kotlinx.coroutines.flow.internal.q.b(e8, jVar);
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (e) gVar.f36856e;
            hVar = (k1.h) gVar.f36855d;
            try {
                e1.n(obj);
            } catch (kotlinx.coroutines.flow.internal.a e10) {
                e8 = e10;
                kotlinx.coroutines.flow.internal.q.b(e8, jVar);
            }
        }
        return hVar.f34872a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    @a7.e
    public static final <T, R> Object e(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, R r7, @a7.d i5.q<? super R, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar, @a7.d kotlin.coroutines.d<? super R> dVar) {
        i iVar2;
        k1.h hVar;
        if (dVar instanceof i) {
            iVar2 = (i) dVar;
            int i7 = iVar2.f36865f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                iVar2.f36865f = i7 - Integer.MIN_VALUE;
            } else {
                iVar2 = new i(dVar);
            }
        } else {
            iVar2 = new i(dVar);
        }
        Object obj = iVar2.f36864e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = iVar2.f36865f;
        if (i8 == 0) {
            e1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.f34872a = r7;
            kotlinx.coroutines.flow.j<? super Object> jVar = new j<>(hVar2, qVar);
            iVar2.f36863d = hVar2;
            iVar2.f36865f = 1;
            if (iVar.a(jVar, iVar2) == objH) {
                return objH;
            }
            hVar = hVar2;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (k1.h) iVar2.f36863d;
            e1.n(obj);
        }
        return hVar.f34872a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> Object f(kotlinx.coroutines.flow.i<? extends T> iVar, R r7, i5.q<? super R, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar, kotlin.coroutines.d<? super R> dVar) {
        k1.h hVar = new k1.h();
        hVar.f34872a = r7;
        j jVar = new j(hVar, qVar);
        kotlin.jvm.internal.i0.e(0);
        iVar.a(jVar, dVar);
        kotlin.jvm.internal.i0.e(1);
        return hVar.f34872a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object g(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        k kVar;
        k1.h hVar;
        if (dVar instanceof k) {
            kVar = (k) dVar;
            int i7 = kVar.f36874f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                kVar.f36874f = i7 - Integer.MIN_VALUE;
            } else {
                kVar = new k(dVar);
            }
        } else {
            kVar = new k(dVar);
        }
        Object obj = kVar.f36873e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = kVar.f36874f;
        if (i8 == 0) {
            e1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.f34872a = (T) kotlinx.coroutines.flow.internal.u.f36394a;
            kotlinx.coroutines.flow.j<? super Object> lVar = new l<>(hVar2);
            kVar.f36872d = hVar2;
            kVar.f36874f = 1;
            if (iVar.a(lVar, kVar) == objH) {
                return objH;
            }
            hVar = hVar2;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (k1.h) kVar.f36872d;
            e1.n(obj);
        }
        T t7 = hVar.f34872a;
        if (t7 != kotlinx.coroutines.flow.internal.u.f36394a) {
            return t7;
        }
        throw new NoSuchElementException("Expected at least one element");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object h(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        m mVar;
        k1.h hVar;
        if (dVar instanceof m) {
            mVar = (m) dVar;
            int i7 = mVar.f36878f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                mVar.f36878f = i7 - Integer.MIN_VALUE;
            } else {
                mVar = new m(dVar);
            }
        } else {
            mVar = new m(dVar);
        }
        Object obj = mVar.f36877e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = mVar.f36878f;
        if (i8 == 0) {
            e1.n(obj);
            k1.h hVar2 = new k1.h();
            kotlinx.coroutines.flow.j<? super Object> nVar = new n<>(hVar2);
            mVar.f36876d = hVar2;
            mVar.f36878f = 1;
            if (iVar.a(nVar, mVar) == objH) {
                return objH;
            }
            hVar = hVar2;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (k1.h) mVar.f36876d;
            e1.n(obj);
        }
        return hVar.f34872a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.r0] */
    @a7.e
    public static final <S, T extends S> Object i(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d i5.q<? super S, ? super T, ? super kotlin.coroutines.d<? super S>, ? extends Object> qVar, @a7.d kotlin.coroutines.d<? super S> dVar) {
        o oVar;
        k1.h hVar;
        if (dVar instanceof o) {
            oVar = (o) dVar;
            int i7 = oVar.f36882f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                oVar.f36882f = i7 - Integer.MIN_VALUE;
            } else {
                oVar = new o(dVar);
            }
        } else {
            oVar = new o(dVar);
        }
        Object obj = oVar.f36881e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = oVar.f36882f;
        if (i8 == 0) {
            e1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.f34872a = kotlinx.coroutines.flow.internal.u.f36394a;
            kotlinx.coroutines.flow.j<? super Object> pVar = new p<>(hVar2, qVar);
            oVar.f36880d = hVar2;
            oVar.f36882f = 1;
            if (iVar.a(pVar, oVar) == objH) {
                return objH;
            }
            hVar = hVar2;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (k1.h) oVar.f36880d;
            e1.n(obj);
        }
        T t7 = hVar.f34872a;
        if (t7 != kotlinx.coroutines.flow.internal.u.f36394a) {
            return t7;
        }
        throw new NoSuchElementException("Empty flow can't be reduced");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object j(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        q qVar;
        k1.h hVar;
        if (dVar instanceof q) {
            qVar = (q) dVar;
            int i7 = qVar.f36891f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                qVar.f36891f = i7 - Integer.MIN_VALUE;
            } else {
                qVar = new q(dVar);
            }
        } else {
            qVar = new q(dVar);
        }
        Object obj = qVar.f36890e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = qVar.f36891f;
        if (i8 == 0) {
            e1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.f34872a = (T) kotlinx.coroutines.flow.internal.u.f36394a;
            kotlinx.coroutines.flow.j<? super Object> rVar = new r<>(hVar2);
            qVar.f36889d = hVar2;
            qVar.f36891f = 1;
            if (iVar.a(rVar, qVar) == objH) {
                return objH;
            }
            hVar = hVar2;
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (k1.h) qVar.f36889d;
            e1.n(obj);
        }
        T t7 = hVar.f34872a;
        if (t7 != kotlinx.coroutines.flow.internal.u.f36394a) {
            return t7;
        }
        throw new NoSuchElementException("Flow is empty");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final <T> Object k(@a7.d kotlinx.coroutines.flow.i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        t tVar;
        k1.h hVar;
        kotlinx.coroutines.flow.internal.a e8;
        kotlinx.coroutines.flow.j<? super Object> jVar;
        if (dVar instanceof t) {
            tVar = (t) dVar;
            int i7 = tVar.f36897g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                tVar.f36897g = i7 - Integer.MIN_VALUE;
            } else {
                tVar = new t(dVar);
            }
        } else {
            tVar = new t(dVar);
        }
        Object obj = tVar.f36896f;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = tVar.f36897g;
        if (i8 == 0) {
            e1.n(obj);
            k1.h hVar2 = new k1.h();
            hVar2.f34872a = (T) kotlinx.coroutines.flow.internal.u.f36394a;
            kotlinx.coroutines.flow.j<? super Object> sVar = new s<>(hVar2);
            try {
                tVar.f36894d = hVar2;
                tVar.f36895e = sVar;
                tVar.f36897g = 1;
                if (iVar.a(sVar, tVar) == objH) {
                    return objH;
                }
                hVar = hVar2;
            } catch (kotlinx.coroutines.flow.internal.a e9) {
                hVar = hVar2;
                e8 = e9;
                jVar = sVar;
                kotlinx.coroutines.flow.internal.q.b(e8, jVar);
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jVar = (s) tVar.f36895e;
            hVar = (k1.h) tVar.f36894d;
            try {
                e1.n(obj);
            } catch (kotlinx.coroutines.flow.internal.a e10) {
                e8 = e10;
                kotlinx.coroutines.flow.internal.q.b(e8, jVar);
            }
        }
        T t7 = hVar.f34872a;
        if (t7 == kotlinx.coroutines.flow.internal.u.f36394a) {
            return null;
        }
        return t7;
    }
}
