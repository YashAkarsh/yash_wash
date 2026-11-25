package kotlinx.coroutines.flow;

import kotlin.e1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class x0<T> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final j<T> f36823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.p<j<? super T>, kotlin.coroutines.d<? super l2>, Object> f36824b;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", i = {0, 0}, l = {419, androidx.constraintlayout.core.motion.utils.w.c.f3063u}, m = "onSubscription", n = {"this", "safeCollector"}, s = {"L$0", "L$1"})
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f36826e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f36827f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ x0<T> f36828g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f36829h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(x0<T> x0Var, kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
            this.f36828g = x0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36827f = obj;
            this.f36829h |= Integer.MIN_VALUE;
            return this.f36828g.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x0(@a7.d j<? super T> jVar, @a7.d i5.p<? super j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        this.f36823a = jVar;
        this.f36824b = pVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.v] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    @a7.e
    public final Object a(@a7.d kotlin.coroutines.d<? super l2> dVar) {
        a aVar;
        kotlinx.coroutines.flow.internal.v vVar;
        x0<T> x0Var;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i7 = aVar.f36829h;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar.f36829h = i7 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, dVar);
            }
        } else {
            aVar = new a(this, dVar);
        }
        Object obj = aVar.f36827f;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        ?? r7 = aVar.f36829h;
        try {
            if (r7 != 0) {
                if (r7 == 1) {
                    vVar = (kotlinx.coroutines.flow.internal.v) aVar.f36826e;
                    x0Var = (x0) aVar.f36825d;
                    e1.n(obj);
                } else {
                    if (r7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e1.n(obj);
                }
                return l2.f34958a;
            }
            e1.n(obj);
            vVar = new kotlinx.coroutines.flow.internal.v(this.f36823a, aVar.d());
            i5.p<j<? super T>, kotlin.coroutines.d<? super l2>, Object> pVar = this.f36824b;
            aVar.f36825d = this;
            aVar.f36826e = vVar;
            aVar.f36829h = 1;
            if (pVar.a0(vVar, aVar) == objH) {
                return objH;
            }
            x0Var = this;
            vVar.V();
            j<T> jVar = x0Var.f36823a;
            r7 = jVar instanceof x0;
            if (r7 == 0) {
                return l2.f34958a;
            }
            aVar.f36825d = null;
            aVar.f36826e = null;
            aVar.f36829h = 2;
            if (((x0) jVar).a(aVar) == objH) {
                return objH;
            }
            return l2.f34958a;
        } catch (Throwable th) {
            r7.V();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.flow.j
    @a7.e
    public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return this.f36823a.f(t7, dVar);
    }
}
