package kotlinx.coroutines.flow.internal;

import kotlin.d1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;
import kotlinx.coroutines.s2;

/* JADX INFO: loaded from: classes3.dex */
public final class v<T> extends kotlin.coroutines.jvm.internal.d implements kotlinx.coroutines.flow.j<T>, kotlin.coroutines.jvm.internal.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    @h5.e
    public final kotlinx.coroutines.flow.j<T> f36397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    @h5.e
    public final kotlin.coroutines.g f36398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @h5.e
    public final int f36399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.e
    private kotlin.coroutines.g f36400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.e
    private kotlin.coroutines.d<? super l2> f36401h;

    static final class a extends n0 implements i5.p<Integer, kotlin.coroutines.g.b, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f36402a = new a();

        a() {
            super(2);
        }

        @Override // i5.p
        public /* bridge */ /* synthetic */ Integer a0(Integer num, kotlin.coroutines.g.b bVar) {
            return b(num.intValue(), bVar);
        }

        @a7.d
        public final Integer b(int i7, @a7.d kotlin.coroutines.g.b bVar) {
            return Integer.valueOf(i7 + 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.g gVar) {
        super(s.f36391a, kotlin.coroutines.i.f34682a);
        this.f36397d = jVar;
        this.f36398e = gVar;
        this.f36399f = ((Number) gVar.fold(0, a.f36402a)).intValue();
    }

    private final void e0(kotlin.coroutines.g gVar, kotlin.coroutines.g gVar2, T t7) {
        if (gVar2 instanceof n) {
            m0((n) gVar2, t7);
        }
        x.a(this, gVar);
    }

    private final Object g0(kotlin.coroutines.d<? super l2> dVar, T t7) {
        kotlin.coroutines.g gVarD = dVar.d();
        s2.z(gVarD);
        kotlin.coroutines.g gVar = this.f36400g;
        if (gVar != gVarD) {
            e0(gVarD, gVar, t7);
            this.f36400g = gVarD;
        }
        this.f36401h = dVar;
        Object objV = w.f36403a.v(this.f36397d, t7, this);
        if (!l0.g(objV, kotlin.coroutines.intrinsics.d.h())) {
            this.f36401h = null;
        }
        return objV;
    }

    private final void m0(n nVar, Object obj) {
        throw new IllegalStateException(kotlin.text.u.p("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + nVar.f36384a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // kotlin.coroutines.jvm.internal.a, kotlin.coroutines.jvm.internal.e
    @a7.e
    public StackTraceElement I() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @a7.d
    public Object R(@a7.d Object obj) {
        Throwable thE = d1.e(obj);
        if (thE != null) {
            this.f36400g = new n(thE, d());
        }
        kotlin.coroutines.d<? super l2> dVar = this.f36401h;
        if (dVar != null) {
            dVar.w(obj);
        }
        return kotlin.coroutines.intrinsics.d.h();
    }

    @Override // kotlin.coroutines.jvm.internal.d, kotlin.coroutines.jvm.internal.a
    public void V() {
        super.V();
    }

    @Override // kotlin.coroutines.jvm.internal.d, kotlin.coroutines.d
    @a7.d
    public kotlin.coroutines.g d() {
        kotlin.coroutines.g gVar = this.f36400g;
        return gVar == null ? kotlin.coroutines.i.f34682a : gVar;
    }

    @Override // kotlinx.coroutines.flow.j
    @a7.e
    public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        try {
            Object objG0 = g0(dVar, t7);
            if (objG0 == kotlin.coroutines.intrinsics.d.h()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objG0 == kotlin.coroutines.intrinsics.d.h() ? objG0 : l2.f34958a;
        } catch (Throwable th) {
            this.f36400g = new n(th, dVar.d());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.a, kotlin.coroutines.jvm.internal.e
    @a7.e
    public kotlin.coroutines.jvm.internal.e i() {
        kotlin.coroutines.d<? super l2> dVar = this.f36401h;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }
}
