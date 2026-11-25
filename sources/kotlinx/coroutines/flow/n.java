package kotlinx.coroutines.flow;

import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.o2;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class n {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p<T, kotlin.coroutines.d<? super l2>, Object> f36516a;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.n$a$a, reason: collision with other inner class name */
        public static final class C0475a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36517d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36519f;

            public C0475a(kotlin.coroutines.d<? super C0475a> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36517d = obj;
                this.f36519f |= Integer.MIN_VALUE;
                return a.this.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
            this.f36516a = pVar;
        }

        @a7.e
        public Object a(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            kotlin.jvm.internal.i0.e(4);
            new C0475a(dVar);
            kotlin.jvm.internal.i0.e(5);
            this.f36516a.a0(t7, dVar);
            return l2.f34958a;
        }

        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            Object objA0 = this.f36516a.a0(t7, dVar);
            return objA0 == kotlin.coroutines.intrinsics.d.h() ? objA0 : l2.f34958a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f36520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i5.q<Integer, T, kotlin.coroutines.d<? super l2>, Object> f36521b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36522d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36524f;

            public a(kotlin.coroutines.d<? super a> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36522d = obj;
                this.f36524f |= Integer.MIN_VALUE;
                return b.this.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(i5.q<? super Integer, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar) {
            this.f36521b = qVar;
        }

        @a7.e
        public Object a(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            kotlin.jvm.internal.i0.e(4);
            new a(dVar);
            kotlin.jvm.internal.i0.e(5);
            i5.q<Integer, T, kotlin.coroutines.d<? super l2>, Object> qVar = this.f36521b;
            int i7 = this.f36520a;
            this.f36520a = i7 + 1;
            if (i7 < 0) {
                throw new ArithmeticException("Index overflow has happened");
            }
            qVar.v(Integer.valueOf(i7), t7, dVar);
            return l2.f34958a;
        }

        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            i5.q<Integer, T, kotlin.coroutines.d<? super l2>, Object> qVar = this.f36521b;
            int i7 = this.f36520a;
            this.f36520a = i7 + 1;
            if (i7 < 0) {
                throw new ArithmeticException("Index overflow has happened");
            }
            Object objV = qVar.v(kotlin.coroutines.jvm.internal.b.f(i7), t7, dVar);
            return objV == kotlin.coroutines.intrinsics.d.h() ? objV : l2.f34958a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends kotlin.coroutines.jvm.internal.o implements i5.p<kotlinx.coroutines.v0, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36525e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i<T> f36526f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(i<? extends T> iVar, kotlin.coroutines.d<? super c> dVar) {
            super(2, dVar);
            this.f36526f = iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            return new c(this.f36526f, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36525e;
            if (i7 == 0) {
                e1.n(obj);
                i<T> iVar = this.f36526f;
                this.f36525e = 1;
                if (k.y(iVar, this) == objH) {
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
        public final Object a0(@a7.d kotlinx.coroutines.v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((c) D(v0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final /* synthetic */ <T> Object a(i<? extends T> iVar, i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar, kotlin.coroutines.d<? super l2> dVar) {
        Object objA = iVar.a(new a(pVar), dVar);
        return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
    }

    @a7.e
    public static final Object b(@a7.d i<?> iVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objA = iVar.a(kotlinx.coroutines.flow.internal.t.f36393a, dVar);
        return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
    }

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Backwards compatibility with JS and K/N")
    private static final /* synthetic */ <T> Object c(i<? extends T> iVar, i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar, kotlin.coroutines.d<? super l2> dVar) {
        a aVar = new a(pVar);
        kotlin.jvm.internal.i0.e(0);
        iVar.a(aVar, dVar);
        kotlin.jvm.internal.i0.e(1);
        return l2.f34958a;
    }

    @a7.e
    public static final <T> Object d(@a7.d i<? extends T> iVar, @a7.d i5.q<? super Integer, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objA = iVar.a(new b(qVar), dVar);
        return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
    }

    private static final <T> Object e(i<? extends T> iVar, i5.q<? super Integer, ? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> qVar, kotlin.coroutines.d<? super l2> dVar) {
        b bVar = new b(qVar);
        kotlin.jvm.internal.i0.e(0);
        iVar.a(bVar, dVar);
        kotlin.jvm.internal.i0.e(1);
        return l2.f34958a;
    }

    @a7.e
    public static final <T> Object f(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objY = k.y(p.d(k.W0(iVar, pVar), 0, null, 2, null), dVar);
        return objY == kotlin.coroutines.intrinsics.d.h() ? objY : l2.f34958a;
    }

    @a7.e
    public static final <T> Object g(@a7.d j<? super T> jVar, @a7.d i<? extends T> iVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        k.o0(jVar);
        Object objA = iVar.a(jVar, dVar);
        return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
    }

    @a7.d
    public static final <T> o2 h(@a7.d i<? extends T> iVar, @a7.d kotlinx.coroutines.v0 v0Var) {
        return kotlinx.coroutines.l.f(v0Var, null, null, new c(iVar, null), 3, null);
    }
}
