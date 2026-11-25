package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.e1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final class y0<T> implements i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final i0<T> f36898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.p<j<? super T>, kotlin.coroutines.d<? super l2>, Object> f36899b;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.SubscribedSharedFlow", f = "Share.kt", i = {}, l = {409}, m = "collect", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f36900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ y0<T> f36901e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f36902f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(y0<T> y0Var, kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
            this.f36901e = y0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36900d = obj;
            this.f36902f |= Integer.MIN_VALUE;
            return this.f36901e.a(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y0(@a7.d i0<? extends T> i0Var, @a7.d i5.p<? super j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        this.f36898a = i0Var;
        this.f36899b = pVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.i0, kotlinx.coroutines.flow.i
    @a7.e
    public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<?> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i7 = aVar.f36902f;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar.f36902f = i7 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, dVar);
            }
        } else {
            aVar = new a(this, dVar);
        }
        Object obj = aVar.f36900d;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar.f36902f;
        if (i8 == 0) {
            e1.n(obj);
            i0<T> i0Var = this.f36898a;
            x0 x0Var = new x0(jVar, this.f36899b);
            aVar.f36902f = 1;
            if (i0Var.a(x0Var, aVar) == objH) {
                return objH;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e1.n(obj);
        }
        throw new kotlin.y();
    }

    @Override // kotlinx.coroutines.flow.i0
    @a7.d
    public List<T> b() {
        return this.f36898a.b();
    }
}
