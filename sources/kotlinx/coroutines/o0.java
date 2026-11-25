package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o0 extends kotlin.coroutines.a implements kotlin.coroutines.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final a f37100a = new a(null);

    @kotlin.s
    public static final class a extends kotlin.coroutines.b<kotlin.coroutines.e, o0> {

        /* JADX INFO: renamed from: kotlinx.coroutines.o0$a$a, reason: collision with other inner class name */
        static final class C0489a extends kotlin.jvm.internal.n0 implements i5.l<kotlin.coroutines.g.b, o0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0489a f37101a = new C0489a();

            C0489a() {
                super(1);
            }

            @Override // i5.l
            @a7.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final o0 z(@a7.d kotlin.coroutines.g.b bVar) {
                if (bVar instanceof o0) {
                    return (o0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        private a() {
            super(kotlin.coroutines.e.f34677q0, C0489a.f37101a);
        }
    }

    public o0() {
        super(kotlin.coroutines.e.f34677q0);
    }

    public abstract void T0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable);

    @j2
    public void V0(@a7.d kotlin.coroutines.g gVar, @a7.d Runnable runnable) {
        T0(gVar, runnable);
    }

    public boolean Y0(@a7.d kotlin.coroutines.g gVar) {
        return true;
    }

    @a7.d
    @d2
    public o0 a1(int i7) {
        kotlinx.coroutines.internal.t.a(i7);
        return new kotlinx.coroutines.internal.s(this, i7);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    public final o0 d1(@a7.d o0 o0Var) {
        return o0Var;
    }

    @Override // kotlin.coroutines.e
    public final void g(@a7.d kotlin.coroutines.d<?> dVar) {
        ((kotlinx.coroutines.internal.l) dVar).u();
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.e
    public <E extends kotlin.coroutines.g.b> E get(@a7.d kotlin.coroutines.g.c<E> cVar) {
        return (E) kotlin.coroutines.e.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.e
    @a7.d
    public final <T> kotlin.coroutines.d<T> m(@a7.d kotlin.coroutines.d<? super T> dVar) {
        return new kotlinx.coroutines.internal.l(this, dVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.d
    public kotlin.coroutines.g minusKey(@a7.d kotlin.coroutines.g.c<?> cVar) {
        return kotlin.coroutines.e.a.c(this, cVar);
    }

    @a7.d
    public String toString() {
        return a1.a(this) + '@' + a1.b(this);
    }
}
