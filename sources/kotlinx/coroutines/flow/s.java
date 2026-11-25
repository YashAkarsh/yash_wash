package kotlinx.coroutines.flow;

import kotlin.jvm.internal.t1;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final i5.l<Object, Object> f36609a = b.f36612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final i5.p<Object, Object, Boolean> f36610b = a.f36611a;

    static final class a extends kotlin.jvm.internal.n0 implements i5.p<Object, Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f36611a = new a();

        a() {
            super(2);
        }

        @Override // i5.p
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean a0(@a7.e Object obj, @a7.e Object obj2) {
            return Boolean.valueOf(kotlin.jvm.internal.l0.g(obj, obj2));
        }
    }

    static final class b extends kotlin.jvm.internal.n0 implements i5.l<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f36612a = new b();

        b() {
            super(1);
        }

        @Override // i5.l
        @a7.e
        public final Object z(@a7.e Object obj) {
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public static final <T> i<T> a(@a7.d i<? extends T> iVar) {
        return iVar instanceof t0 ? iVar : d(iVar, f36609a, f36610b);
    }

    @a7.d
    public static final <T> i<T> b(@a7.d i<? extends T> iVar, @a7.d i5.p<? super T, ? super T, Boolean> pVar) {
        return d(iVar, f36609a, (i5.p) t1.q(pVar, 2));
    }

    @a7.d
    public static final <T, K> i<T> c(@a7.d i<? extends T> iVar, @a7.d i5.l<? super T, ? extends K> lVar) {
        return d(iVar, lVar, f36610b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> i<T> d(i<? extends T> iVar, i5.l<? super T, ? extends Object> lVar, i5.p<Object, Object, Boolean> pVar) {
        if (iVar instanceof g) {
            g gVar = (g) iVar;
            if (gVar.f36249b == lVar && gVar.f36250c == pVar) {
                return iVar;
            }
        }
        return new g(iVar, lVar, pVar);
    }

    private static /* synthetic */ void e() {
    }

    private static /* synthetic */ void f() {
    }
}
