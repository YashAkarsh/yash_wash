package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class g1 {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", i = {}, l = {com.alibaba.fastjson.asm.j.C}, m = "awaitCancellation", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f36924d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36925e;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36924d = obj;
            this.f36925e |= Integer.MIN_VALUE;
            return g1.a(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @a7.e
    public static final Object a(@a7.d kotlin.coroutines.d<?> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i7 = aVar.f36925e;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar.f36925e = i7 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.f36924d;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar.f36925e;
        if (i8 == 0) {
            kotlin.e1.n(obj);
            aVar.f36925e = 1;
            r rVar = new r(kotlin.coroutines.intrinsics.c.d(aVar), 1);
            rVar.O();
            Object objZ = rVar.z();
            if (objZ == kotlin.coroutines.intrinsics.d.h()) {
                kotlin.coroutines.jvm.internal.h.c(aVar);
            }
            if (objZ == objH) {
                return objH;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.e1.n(obj);
        }
        throw new kotlin.y();
    }

    @a7.e
    public static final Object b(long j7, @a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        if (j7 <= 0) {
            return kotlin.l2.f34958a;
        }
        r rVar = new r(kotlin.coroutines.intrinsics.c.d(dVar), 1);
        rVar.O();
        if (j7 < Long.MAX_VALUE) {
            d(rVar.d()).s(j7, rVar);
        }
        Object objZ = rVar.z();
        if (objZ == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == kotlin.coroutines.intrinsics.d.h() ? objZ : kotlin.l2.f34958a;
    }

    @a7.e
    public static final Object c(long j7, @a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        Object objB = b(e(j7), dVar);
        return objB == kotlin.coroutines.intrinsics.d.h() ? objB : kotlin.l2.f34958a;
    }

    @a7.d
    public static final f1 d(@a7.d kotlin.coroutines.g gVar) {
        kotlin.coroutines.g.b bVar = gVar.get(kotlin.coroutines.e.f34677q0);
        f1 f1Var = bVar instanceof f1 ? (f1) bVar : null;
        return f1Var == null ? c1.a() : f1Var;
    }

    public static final long e(long j7) {
        if (kotlin.time.d.h(j7, kotlin.time.d.f35456b.W()) > 0) {
            return kotlin.ranges.q.o(kotlin.time.d.I(j7), 1L);
        }
        return 0L;
    }
}
