package kotlin.coroutines;

import i5.l;
import i5.p;
import kotlin.d1;
import kotlin.e1;
import kotlin.g1;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;
import kotlin.k0;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f34679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l<d1<? extends T>, l2> f34680b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(g gVar, l<? super d1<? extends T>, l2> lVar) {
            this.f34679a = gVar;
            this.f34680b = lVar;
        }

        @Override // kotlin.coroutines.d
        @a7.d
        public g d() {
            return this.f34679a;
        }

        @Override // kotlin.coroutines.d
        public void w(@a7.d Object obj) {
            this.f34680b.z(d1.a(obj));
        }
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> d<T> a(g context, l<? super d1<? extends T>, l2> resumeWith) {
        l0.p(context, "context");
        l0.p(resumeWith, "resumeWith");
        return new a(context, resumeWith);
    }

    @a7.d
    @g1(version = "1.3")
    public static final <T> d<l2> b(@a7.d l<? super d<? super T>, ? extends Object> lVar, @a7.d d<? super T> completion) {
        l0.p(lVar, "<this>");
        l0.p(completion, "completion");
        return new k(kotlin.coroutines.intrinsics.c.d(kotlin.coroutines.intrinsics.c.b(lVar, completion)), kotlin.coroutines.intrinsics.d.h());
    }

    @a7.d
    @g1(version = "1.3")
    public static final <R, T> d<l2> c(@a7.d p<? super R, ? super d<? super T>, ? extends Object> pVar, R r7, @a7.d d<? super T> completion) {
        l0.p(pVar, "<this>");
        l0.p(completion, "completion");
        return new k(kotlin.coroutines.intrinsics.c.d(kotlin.coroutines.intrinsics.c.c(pVar, r7, completion)), kotlin.coroutines.intrinsics.d.h());
    }

    private static final g d() {
        throw new k0("Implemented as intrinsic");
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    public static /* synthetic */ void e() {
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> void f(d<? super T> dVar, T t7) {
        l0.p(dVar, "<this>");
        d1.a aVar = d1.f34719b;
        dVar.w(d1.b(t7));
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> void g(d<? super T> dVar, Throwable exception) {
        l0.p(dVar, "<this>");
        l0.p(exception, "exception");
        d1.a aVar = d1.f34719b;
        dVar.w(d1.b(e1.a(exception)));
    }

    @g1(version = "1.3")
    public static final <T> void h(@a7.d l<? super d<? super T>, ? extends Object> lVar, @a7.d d<? super T> completion) {
        l0.p(lVar, "<this>");
        l0.p(completion, "completion");
        d dVarD = kotlin.coroutines.intrinsics.c.d(kotlin.coroutines.intrinsics.c.b(lVar, completion));
        d1.a aVar = d1.f34719b;
        dVarD.w(d1.b(l2.f34958a));
    }

    @g1(version = "1.3")
    public static final <R, T> void i(@a7.d p<? super R, ? super d<? super T>, ? extends Object> pVar, R r7, @a7.d d<? super T> completion) {
        l0.p(pVar, "<this>");
        l0.p(completion, "completion");
        d dVarD = kotlin.coroutines.intrinsics.c.d(kotlin.coroutines.intrinsics.c.c(pVar, r7, completion));
        d1.a aVar = d1.f34719b;
        dVarD.w(d1.b(l2.f34958a));
    }

    @g1(version = "1.3")
    @kotlin.internal.f
    private static final <T> Object j(l<? super d<? super T>, l2> lVar, d<? super T> dVar) throws Throwable {
        i0.e(0);
        k kVar = new k(kotlin.coroutines.intrinsics.c.d(dVar));
        lVar.z(kVar);
        Object objA = kVar.a();
        if (objA == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        i0.e(1);
        return objA;
    }
}
