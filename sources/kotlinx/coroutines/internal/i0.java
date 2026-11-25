package kotlinx.coroutines.internal;

import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 {

    static final class a extends kotlin.jvm.internal.n0 implements i5.l<Throwable, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<E, l2> f36989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ E f36990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.g f36991c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(i5.l<? super E, l2> lVar, E e8, kotlin.coroutines.g gVar) {
            super(1);
            this.f36989a = lVar;
            this.f36990b = e8;
            this.f36991c = gVar;
        }

        public final void b(@a7.d Throwable th) {
            i0.b(this.f36989a, this.f36990b, this.f36991c);
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(Throwable th) {
            b(th);
            return l2.f34958a;
        }
    }

    @a7.d
    public static final <E> i5.l<Throwable, l2> a(@a7.d i5.l<? super E, l2> lVar, E e8, @a7.d kotlin.coroutines.g gVar) {
        return new a(lVar, e8, gVar);
    }

    public static final <E> void b(@a7.d i5.l<? super E, l2> lVar, E e8, @a7.d kotlin.coroutines.g gVar) {
        d1 d1VarC = c(lVar, e8, null);
        if (d1VarC == null) {
            return;
        }
        kotlinx.coroutines.r0.b(gVar, d1VarC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.e
    public static final <E> d1 c(@a7.d i5.l<? super E, l2> lVar, E e8, @a7.e d1 d1Var) {
        try {
            lVar.z(e8);
        } catch (Throwable th) {
            if (d1Var == null || d1Var.getCause() == th) {
                return new d1(kotlin.jvm.internal.l0.C("Exception in undelivered element handler for ", e8), th);
            }
            kotlin.p.a(d1Var, th);
        }
        return d1Var;
    }

    public static /* synthetic */ d1 d(i5.l lVar, Object obj, d1 d1Var, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            d1Var = null;
        }
        return c(lVar, obj, d1Var);
    }
}
