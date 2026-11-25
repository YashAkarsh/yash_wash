package kotlinx.coroutines.channels;

import kotlin.d1;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.x0;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", i = {0, 0}, l = {153}, m = "awaitClose", n = {"$this$awaitClose", "block"}, s = {"L$0", "L$1"})
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f35582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35583e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f35584f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f35585g;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35584f = obj;
            this.f35585g |= Integer.MIN_VALUE;
            return e0.a(null, null, this);
        }
    }

    static final class b extends kotlin.jvm.internal.n0 implements i5.a<l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f35586a = new b();

        b() {
            super(0);
        }

        public final void b() {
        }

        @Override // i5.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            b();
            return l2.f34958a;
        }
    }

    static final class c extends kotlin.jvm.internal.n0 implements i5.l<Throwable, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.q<l2> f35587a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(kotlinx.coroutines.q<? super l2> qVar) {
            super(1);
            this.f35587a = qVar;
        }

        public final void b(@a7.e Throwable th) {
            kotlinx.coroutines.q<l2> qVar = this.f35587a;
            d1.a aVar = d1.f34719b;
            qVar.w(d1.b(l2.f34958a));
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Throwable th) {
            b(th);
            return l2.f34958a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final Object a(@a7.d g0<?> g0Var, @a7.d i5.a<l2> aVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        a aVar2;
        if (dVar instanceof a) {
            aVar2 = (a) dVar;
            int i7 = aVar2.f35585g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar2.f35585g = i7 - Integer.MIN_VALUE;
            } else {
                aVar2 = new a(dVar);
            }
        } else {
            aVar2 = new a(dVar);
        }
        Object obj = aVar2.f35584f;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar2.f35585g;
        try {
            if (i8 == 0) {
                e1.n(obj);
                if (!(aVar2.d().get(o2.f37103s0) == g0Var)) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
                }
                aVar2.f35582d = g0Var;
                aVar2.f35583e = aVar;
                aVar2.f35585g = 1;
                kotlinx.coroutines.r rVar = new kotlinx.coroutines.r(kotlin.coroutines.intrinsics.c.d(aVar2), 1);
                rVar.O();
                g0Var.M(new c(rVar));
                Object objZ = rVar.z();
                if (objZ == kotlin.coroutines.intrinsics.d.h()) {
                    kotlin.coroutines.jvm.internal.h.c(aVar2);
                }
                if (objZ == objH) {
                    return objH;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (i5.a) aVar2.f35583e;
                e1.n(obj);
            }
            aVar.invoke();
            return l2.f34958a;
        } catch (Throwable th) {
            aVar.invoke();
            throw th;
        }
    }

    public static /* synthetic */ Object b(g0 g0Var, i5.a aVar, kotlin.coroutines.d dVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            aVar = b.f35586a;
        }
        return a(g0Var, aVar, dVar);
    }

    @a7.d
    @d2
    public static final <E> i0<E> c(@a7.d v0 v0Var, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d @kotlin.b i5.p<? super g0<? super E>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return e(v0Var, gVar, i7, m.SUSPEND, x0.DEFAULT, null, pVar);
    }

    @a7.d
    @j2
    public static final <E> i0<E> d(@a7.d v0 v0Var, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d x0 x0Var, @a7.e i5.l<? super Throwable, l2> lVar, @a7.d @kotlin.b i5.p<? super g0<? super E>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        return e(v0Var, gVar, i7, m.SUSPEND, x0Var, lVar, pVar);
    }

    @a7.d
    public static final <E> i0<E> e(@a7.d v0 v0Var, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d m mVar, @a7.d x0 x0Var, @a7.e i5.l<? super Throwable, l2> lVar, @a7.d @kotlin.b i5.p<? super g0<? super E>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        f0 f0Var = new f0(kotlinx.coroutines.n0.e(v0Var, gVar), q.d(i7, mVar, null, 4, null));
        if (lVar != null) {
            f0Var.g0(lVar);
        }
        f0Var.E1(x0Var, f0Var, pVar);
        return f0Var;
    }

    public static /* synthetic */ i0 f(v0 v0Var, kotlin.coroutines.g gVar, int i7, i5.p pVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            gVar = kotlin.coroutines.i.f34682a;
        }
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        return c(v0Var, gVar, i7, pVar);
    }

    public static /* synthetic */ i0 g(v0 v0Var, kotlin.coroutines.g gVar, int i7, x0 x0Var, i5.l lVar, i5.p pVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            gVar = kotlin.coroutines.i.f34682a;
        }
        kotlin.coroutines.g gVar2 = gVar;
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        int i9 = i7;
        if ((i8 & 4) != 0) {
            x0Var = x0.DEFAULT;
        }
        x0 x0Var2 = x0Var;
        if ((i8 & 8) != 0) {
            lVar = null;
        }
        return d(v0Var, gVar2, i9, x0Var2, lVar, pVar);
    }

    public static /* synthetic */ i0 h(v0 v0Var, kotlin.coroutines.g gVar, int i7, m mVar, x0 x0Var, i5.l lVar, i5.p pVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            gVar = kotlin.coroutines.i.f34682a;
        }
        kotlin.coroutines.g gVar2 = gVar;
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        int i9 = i7;
        if ((i8 & 4) != 0) {
            mVar = m.SUSPEND;
        }
        m mVar2 = mVar;
        if ((i8 & 8) != 0) {
            x0Var = x0.DEFAULT;
        }
        x0 x0Var2 = x0Var;
        if ((i8 & 16) != 0) {
            lVar = null;
        }
        return e(v0Var, gVar2, i9, mVar2, x0Var2, lVar, pVar);
    }
}
