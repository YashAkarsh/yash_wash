package kotlinx.coroutines.internal;

import kotlinx.coroutines.t3;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final r0 f37028a = new r0("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final i5.p<Object, kotlin.coroutines.g.b, Object> f37029b = a.f37032a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private static final i5.p<t3<?>, kotlin.coroutines.g.b, t3<?>> f37030c = b.f37033a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private static final i5.p<c1, kotlin.coroutines.g.b, c1> f37031d = c.f37034a;

    static final class a extends kotlin.jvm.internal.n0 implements i5.p<Object, kotlin.coroutines.g.b, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f37032a = new a();

        a() {
            super(2);
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.e Object obj, @a7.d kotlin.coroutines.g.b bVar) {
            if (!(bVar instanceof t3)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num == null ? 1 : num.intValue();
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    static final class b extends kotlin.jvm.internal.n0 implements i5.p<t3<?>, kotlin.coroutines.g.b, t3<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f37033a = new b();

        b() {
            super(2);
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final t3<?> a0(@a7.e t3<?> t3Var, @a7.d kotlin.coroutines.g.b bVar) {
            if (t3Var != null) {
                return t3Var;
            }
            if (bVar instanceof t3) {
                return (t3) bVar;
            }
            return null;
        }
    }

    static final class c extends kotlin.jvm.internal.n0 implements i5.p<c1, kotlin.coroutines.g.b, c1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f37034a = new c();

        c() {
            super(2);
        }

        @Override // i5.p
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c1 a0(@a7.d c1 c1Var, @a7.d kotlin.coroutines.g.b bVar) {
            if (bVar instanceof t3) {
                t3<?> t3Var = (t3) bVar;
                c1Var.a(t3Var, t3Var.L0(c1Var.f36966a));
            }
            return c1Var;
        }
    }

    public static final void a(@a7.d kotlin.coroutines.g gVar, @a7.e Object obj) {
        if (obj == f37028a) {
            return;
        }
        if (obj instanceof c1) {
            ((c1) obj).b(gVar);
            return;
        }
        Object objFold = gVar.fold(null, f37030c);
        if (objFold == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((t3) objFold).v0(gVar, obj);
    }

    @a7.d
    public static final Object b(@a7.d kotlin.coroutines.g gVar) {
        Object objFold = gVar.fold(0, f37029b);
        kotlin.jvm.internal.l0.m(objFold);
        return objFold;
    }

    @a7.e
    public static final Object c(@a7.d kotlin.coroutines.g gVar, @a7.e Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        if (obj == 0) {
            return f37028a;
        }
        return obj instanceof Integer ? gVar.fold(new c1(gVar, ((Number) obj).intValue()), f37031d) : ((t3) obj).L0(gVar);
    }
}
