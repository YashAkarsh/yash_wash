package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.e1;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.channels.e0;
import kotlinx.coroutines.channels.g0;
import kotlinx.coroutines.channels.i0;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.v0;
import kotlinx.coroutines.w0;
import kotlinx.coroutines.x0;

/* JADX INFO: loaded from: classes3.dex */
@j2
public abstract class e<T> implements r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public final kotlin.coroutines.g f36273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @h5.e
    public final int f36274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @h5.e
    public final kotlinx.coroutines.channels.m f36275c;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.o implements i5.p<v0, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36276e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36277f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<T> f36278g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e<T> f36279h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.flow.j<? super T> jVar, e<T> eVar, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f36278g = jVar;
            this.f36279h = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            a aVar = new a(this.f36278g, this.f36279h, dVar);
            aVar.f36277f = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36276e;
            if (i7 == 0) {
                e1.n(obj);
                v0 v0Var = (v0) this.f36277f;
                kotlinx.coroutines.flow.j<T> jVar = this.f36278g;
                i0<T> i0VarO = this.f36279h.o(v0Var);
                this.f36276e = 1;
                if (kotlinx.coroutines.flow.k.l0(jVar, i0VarO, this) == objH) {
                    return objH;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d v0 v0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(v0Var, dVar)).R(l2.f34958a);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends kotlin.coroutines.jvm.internal.o implements i5.p<g0<? super T>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36280e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f36281f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e<T> f36282g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e<T> eVar, kotlin.coroutines.d<? super b> dVar) {
            super(2, dVar);
            this.f36282g = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            b bVar = new b(this.f36282g, dVar);
            bVar.f36281f = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36280e;
            if (i7 == 0) {
                e1.n(obj);
                g0<? super T> g0Var = (g0) this.f36281f;
                e<T> eVar = this.f36282g;
                this.f36280e = 1;
                if (eVar.h(g0Var, this) == objH) {
                    return objH;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d g0<? super T> g0Var, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((b) D(g0Var, dVar)).R(l2.f34958a);
        }
    }

    public e(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        this.f36273a = gVar;
        this.f36274b = i7;
        this.f36275c = mVar;
    }

    static /* synthetic */ Object e(e eVar, kotlinx.coroutines.flow.j jVar, kotlin.coroutines.d dVar) {
        Object objG = w0.g(new a(jVar, eVar, null), dVar);
        return objG == kotlin.coroutines.intrinsics.d.h() ? objG : l2.f34958a;
    }

    @Override // kotlinx.coroutines.flow.i
    @a7.e
    public Object a(@a7.d kotlinx.coroutines.flow.j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return e(this, jVar, dVar);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013 A[PHI: r4
      0x0013: PHI (r4v5 int) = (r4v2 int), (r4v2 int), (r4v4 int) binds: [B:8:0x0011, B:13:0x0019, B:16:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlinx.coroutines.flow.internal.r
    @a7.d
    public kotlinx.coroutines.flow.i<T> c(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        kotlin.coroutines.g gVarPlus = gVar.plus(this.f36273a);
        if (mVar == kotlinx.coroutines.channels.m.SUSPEND) {
            int i8 = this.f36274b;
            if (i8 != -3) {
                if (i7 == -3) {
                    i7 = i8;
                } else if (i8 != -2) {
                    if (i7 != -2 && (i8 = i8 + i7) < 0) {
                        i7 = Integer.MAX_VALUE;
                    } else {
                        i7 = i8;
                    }
                }
            }
            mVar = this.f36275c;
        }
        return (l0.g(gVarPlus, this.f36273a) && i7 == this.f36274b && mVar == this.f36275c) ? this : i(gVarPlus, i7, mVar);
    }

    @a7.e
    protected String d() {
        return null;
    }

    @a7.e
    protected abstract Object h(@a7.d g0<? super T> g0Var, @a7.d kotlin.coroutines.d<? super l2> dVar);

    @a7.d
    protected abstract e<T> i(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar);

    @a7.e
    public kotlinx.coroutines.flow.i<T> k() {
        return null;
    }

    @a7.d
    public final i5.p<g0<? super T>, kotlin.coroutines.d<? super l2>, Object> l() {
        return new b(this, null);
    }

    public final int n() {
        int i7 = this.f36274b;
        if (i7 == -3) {
            return -2;
        }
        return i7;
    }

    @a7.d
    public i0<T> o(@a7.d v0 v0Var) {
        return e0.h(v0Var, this.f36273a, n(), this.f36275c, x0.ATOMIC, null, l(), 16, null);
    }

    @a7.d
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strD = d();
        if (strD != null) {
            arrayList.add(strD);
        }
        kotlin.coroutines.g gVar = this.f36273a;
        if (gVar != kotlin.coroutines.i.f34682a) {
            arrayList.add(l0.C("context=", gVar));
        }
        int i7 = this.f36274b;
        if (i7 != -3) {
            arrayList.add(l0.C("capacity=", Integer.valueOf(i7)));
        }
        kotlinx.coroutines.channels.m mVar = this.f36275c;
        if (mVar != kotlinx.coroutines.channels.m.SUSPEND) {
            arrayList.add(l0.C("onBufferOverflow=", mVar));
        }
        return a1.a(this) + '[' + kotlin.collections.g0.h3(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
