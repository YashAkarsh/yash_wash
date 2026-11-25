package kotlinx.coroutines.flow;

import kotlin.e1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final class b<T> extends f<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final i5.p<kotlinx.coroutines.channels.g0<? super T>, kotlin.coroutines.d<? super l2>, Object> f36110e;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", i = {0}, l = {336}, m = "collectTo", n = {"scope"}, s = {"L$0"})
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f36111d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f36112e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b<T> f36113f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f36114g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b<T> bVar, kotlin.coroutines.d<? super a> dVar) {
            super(dVar);
            this.f36113f = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            this.f36112e = obj;
            this.f36114g |= Integer.MIN_VALUE;
            return this.f36113f.h(null, this);
        }
    }

    public /* synthetic */ b(i5.p pVar, kotlin.coroutines.g gVar, int i7, kotlinx.coroutines.channels.m mVar, int i8, kotlin.jvm.internal.w wVar) {
        this(pVar, (i8 & 2) != 0 ? kotlin.coroutines.i.f34682a : gVar, (i8 & 4) != 0 ? -2 : i7, (i8 & 8) != 0 ? kotlinx.coroutines.channels.m.SUSPEND : mVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.f, kotlinx.coroutines.flow.internal.e
    @a7.e
    protected Object h(@a7.d kotlinx.coroutines.channels.g0<? super T> g0Var, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        a aVar;
        if (dVar instanceof a) {
            aVar = (a) dVar;
            int i7 = aVar.f36114g;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                aVar.f36114g = i7 - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, dVar);
            }
        } else {
            aVar = new a(this, dVar);
        }
        Object obj = aVar.f36112e;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        int i8 = aVar.f36114g;
        if (i8 == 0) {
            e1.n(obj);
            aVar.f36111d = g0Var;
            aVar.f36114g = 1;
            if (super.h(g0Var, aVar) == objH) {
                return objH;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0Var = (kotlinx.coroutines.channels.g0) aVar.f36111d;
            e1.n(obj);
        }
        if (g0Var.S()) {
            return l2.f34958a;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }

    @Override // kotlinx.coroutines.flow.f, kotlinx.coroutines.flow.internal.e
    @a7.d
    protected kotlinx.coroutines.flow.internal.e<T> i(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return new b(this.f36110e, gVar, i7, mVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@a7.d i5.p<? super kotlinx.coroutines.channels.g0<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar, @a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        super(pVar, gVar, i7, mVar);
        this.f36110e = pVar;
    }
}
