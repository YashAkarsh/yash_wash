package kotlinx.coroutines.flow;

import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.s2;

/* JADX INFO: loaded from: classes3.dex */
final class d<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final i<T> f36237a;

    static final class a<T> implements j, kotlin.coroutines.jvm.internal.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j<T> f36238a;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.d$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.CancellableFlowImpl$collect$2", f = "Context.kt", i = {}, l = {275}, m = "emit", n = {}, s = {})
        static final class C0461a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f36239d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ a<T> f36240e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f36241f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0461a(a<? super T> aVar, kotlin.coroutines.d<? super C0461a> dVar) {
                super(dVar);
                this.f36240e = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @a7.e
            public final Object R(@a7.d Object obj) {
                this.f36239d = obj;
                this.f36241f |= Integer.MIN_VALUE;
                return this.f36240e.f(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(j<? super T> jVar) {
            this.f36238a = jVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.j
        @a7.e
        public final Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
            C0461a c0461a;
            if (dVar instanceof C0461a) {
                c0461a = (C0461a) dVar;
                int i7 = c0461a.f36241f;
                if ((i7 & Integer.MIN_VALUE) != 0) {
                    c0461a.f36241f = i7 - Integer.MIN_VALUE;
                } else {
                    c0461a = new C0461a(this, dVar);
                }
            } else {
                c0461a = new C0461a(this, dVar);
            }
            Object obj = c0461a.f36239d;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i8 = c0461a.f36241f;
            if (i8 == 0) {
                e1.n(obj);
                s2.z(c0461a.d());
                j<T> jVar = this.f36238a;
                c0461a.f36241f = 1;
                if (jVar.f(t7, c0461a) == objH) {
                    return objH;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            return l2.f34958a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@a7.d i<? extends T> iVar) {
        this.f36237a = iVar;
    }

    @Override // kotlinx.coroutines.flow.i
    @a7.e
    public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objA = this.f36237a.a(new a(jVar), dVar);
        return objA == kotlin.coroutines.intrinsics.d.h() ? objA : l2.f34958a;
    }
}
