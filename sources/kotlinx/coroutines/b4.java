package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class b4 {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", i = {0, 0, 0}, l = {100}, m = "withTimeoutOrNull", n = {"block", "coroutine", "timeMillis"}, s = {"L$0", "L$1", "J$0"})
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f35527d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f35528e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f35529f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f35530g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f35531h;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f35530g = obj;
            this.f35531h |= Integer.MIN_VALUE;
            return b4.e(0L, null, this);
        }
    }

    @a7.d
    public static final z3 a(long j7, @a7.d o2 o2Var) {
        return new z3("Timed out waiting for " + j7 + " ms", o2Var);
    }

    private static final <U, T extends U> Object b(a4<U, ? super T> a4Var, i5.p<? super v0, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar) {
        s2.y(a4Var, g1.d(a4Var.f37009c.d()).p0(a4Var.f35502d, a4Var, a4Var.d()));
        return r5.b.g(a4Var, a4Var, pVar);
    }

    @a7.e
    public static final <T> Object c(long j7, @a7.d i5.p<? super v0, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        if (j7 <= 0) {
            throw new z3("Timed out immediately");
        }
        Object objB = b(new a4(j7, dVar), pVar);
        if (objB == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objB;
    }

    @a7.e
    public static final <T> Object d(long j7, @a7.d i5.p<? super v0, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return c(g1.e(j7), pVar, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.a4] */
    @a7.e
    public static final <T> Object e(long j7, @a7.d i5.p<? super v0, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        a aVar;
        kotlin.jvm.internal.k1.h hVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i7 = aVar.f35531h;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar.f35531h = i7 - Integer.MIN_VALUE;
            } else {
                aVar = new a(dVar);
            }
        } else {
            aVar = new a(dVar);
        }
        Object obj = aVar.f35530g;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar.f35531h;
        if (i8 == 0) {
            kotlin.e1.n(obj);
            if (j7 <= 0) {
                return null;
            }
            kotlin.jvm.internal.k1.h hVar2 = new kotlin.jvm.internal.k1.h();
            try {
                aVar.f35528e = pVar;
                aVar.f35529f = hVar2;
                aVar.f35527d = j7;
                aVar.f35531h = 1;
                ?? r7 = (T) new a4(j7, aVar);
                hVar2.f34872a = r7;
                Object objB = b(r7, pVar);
                if (objB == kotlin.coroutines.intrinsics.d.h()) {
                    kotlin.coroutines.jvm.internal.h.c(aVar);
                }
                return objB == objH ? objH : objB;
            } catch (z3 e8) {
                e = e8;
                hVar = hVar2;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = (kotlin.jvm.internal.k1.h) aVar.f35529f;
            try {
                kotlin.e1.n(obj);
                return obj;
            } catch (z3 e9) {
                e = e9;
            }
        }
        if (e.f37397a == hVar.f34872a) {
            return null;
        }
        throw e;
    }

    @a7.e
    public static final <T> Object f(long j7, @a7.d i5.p<? super v0, ? super kotlin.coroutines.d<? super T>, ? extends Object> pVar, @a7.d kotlin.coroutines.d<? super T> dVar) {
        return e(g1.e(j7), pVar, dVar);
    }
}
