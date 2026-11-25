package kotlin;

/* JADX INFO: loaded from: classes2.dex */
final class j<T, R> extends i<T, R> implements kotlin.coroutines.d<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private i5.q<? super i<?, ?>, Object, ? super kotlin.coroutines.d<Object>, ? extends Object> f34811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private Object f34812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private kotlin.coroutines.d<Object> f34813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private Object f34814d;

    public static final class a implements kotlin.coroutines.d<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.g f34815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f34816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.q f34817c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.d f34818d;

        public a(kotlin.coroutines.g gVar, j jVar, i5.q qVar, kotlin.coroutines.d dVar) {
            this.f34815a = gVar;
            this.f34816b = jVar;
            this.f34817c = qVar;
            this.f34818d = dVar;
        }

        @Override // kotlin.coroutines.d
        @a7.d
        public kotlin.coroutines.g d() {
            return this.f34815a;
        }

        @Override // kotlin.coroutines.d
        public void w(@a7.d Object obj) {
            this.f34816b.f34811a = this.f34817c;
            this.f34816b.f34813c = this.f34818d;
            this.f34816b.f34814d = obj;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public j(@a7.d i5.q<? super i<T, R>, ? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> block, T t7) {
        super(null);
        kotlin.jvm.internal.l0.p(block, "block");
        this.f34811a = block;
        this.f34812b = t7;
        kotlin.jvm.internal.l0.n(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f34813c = this;
        this.f34814d = h.f34736a;
    }

    private final kotlin.coroutines.d<Object> j(i5.q<? super i<?, ?>, Object, ? super kotlin.coroutines.d<Object>, ? extends Object> qVar, kotlin.coroutines.d<Object> dVar) {
        return new a(kotlin.coroutines.i.f34682a, this, qVar, dVar);
    }

    @Override // kotlin.i
    @a7.e
    public Object a(T t7, @a7.d kotlin.coroutines.d<? super R> dVar) {
        kotlin.jvm.internal.l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f34813c = dVar;
        this.f34812b = t7;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        if (objH == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objH;
    }

    @Override // kotlin.i
    @a7.e
    public <U, S> Object c(@a7.d g<U, S> gVar, U u7, @a7.d kotlin.coroutines.d<? super S> dVar) {
        i5.q<i<U, S>, U, kotlin.coroutines.d<? super S>, Object> qVarA = gVar.a();
        kotlin.jvm.internal.l0.n(qVarA, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>{ kotlin.DeepRecursiveKt.DeepRecursiveFunctionBlock }");
        i5.q<? super i<?, ?>, Object, ? super kotlin.coroutines.d<Object>, ? extends Object> qVar = this.f34811a;
        if (qVarA != qVar) {
            this.f34811a = qVarA;
            kotlin.jvm.internal.l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f34813c = j(qVar, dVar);
        } else {
            kotlin.jvm.internal.l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f34813c = dVar;
        }
        this.f34812b = u7;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        if (objH == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objH;
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public kotlin.coroutines.g d() {
        return kotlin.coroutines.i.f34682a;
    }

    public final R k() {
        while (true) {
            R r7 = (R) this.f34814d;
            kotlin.coroutines.d<Object> dVar = this.f34813c;
            if (dVar == null) {
                e1.n(r7);
                return r7;
            }
            if (d1.d(h.f34736a, r7)) {
                try {
                    i5.q<? super i<?, ?>, Object, ? super kotlin.coroutines.d<Object>, ? extends Object> qVar = this.f34811a;
                    Object obj = this.f34812b;
                    kotlin.jvm.internal.l0.n(qVar, "null cannot be cast to non-null type kotlin.Function3<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn, P of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn>, kotlin.Any?>");
                    Object objV = ((i5.q) kotlin.jvm.internal.t1.q(qVar, 3)).v(this, obj, dVar);
                    if (objV != kotlin.coroutines.intrinsics.d.h()) {
                        d1.a aVar = d1.f34719b;
                        dVar.w(d1.b(objV));
                    }
                } catch (Throwable th) {
                    d1.a aVar2 = d1.f34719b;
                    dVar.w(d1.b(e1.a(th)));
                }
            } else {
                this.f34814d = h.f34736a;
                dVar.w(r7);
            }
        }
    }

    @Override // kotlin.coroutines.d
    public void w(@a7.d Object obj) {
        this.f34813c = null;
        this.f34814d = obj;
    }
}
