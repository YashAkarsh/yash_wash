package kotlinx.coroutines.flow;

import easypay.appinvoke.manager.Constants;
import kotlin.e1;
import kotlin.jvm.internal.k1;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final class r0 implements o0 {

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {Constants.ACTION_START_NB_OTP}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends kotlin.coroutines.jvm.internal.o implements i5.p<j<? super m0>, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36601e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36602f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ t0<Integer> f36603g;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.r0$a$a, reason: collision with other inner class name */
        static final class C0479a<T> implements j, kotlin.coroutines.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ k1.a f36604a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ j<m0> f36605b;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.r0$a$a$a, reason: collision with other inner class name */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StartedLazily$command$1$1", f = "SharingStarted.kt", i = {}, l = {158}, m = "emit", n = {}, s = {})
            static final class C0480a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f36606d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ C0479a<T> f36607e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                int f36608f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0480a(C0479a<? super T> c0479a, kotlin.coroutines.d<? super C0480a> dVar) {
                    super(dVar);
                    this.f36607e = c0479a;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @a7.e
                public final Object R(@a7.d Object obj) {
                    this.f36606d = obj;
                    this.f36608f |= Integer.MIN_VALUE;
                    return this.f36607e.a(0, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            C0479a(k1.a aVar, j<? super m0> jVar) {
                this.f36604a = aVar;
                this.f36605b = jVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @a7.e
            public final Object a(int i7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
                C0480a c0480a;
                if (dVar instanceof C0480a) {
                    c0480a = (C0480a) dVar;
                    int i8 = c0480a.f36608f;
                    if ((i8 & Integer.MIN_VALUE) != 0) {
                        c0480a.f36608f = i8 - Integer.MIN_VALUE;
                    } else {
                        c0480a = new C0480a(this, dVar);
                    }
                } else {
                    c0480a = new C0480a(this, dVar);
                }
                Object obj = c0480a.f36606d;
                Object objH = kotlin.coroutines.intrinsics.d.h();
                int i9 = c0480a.f36608f;
                if (i9 == 0) {
                    e1.n(obj);
                    if (i7 > 0) {
                        k1.a aVar = this.f36604a;
                        if (!aVar.f34865a) {
                            aVar.f34865a = true;
                            j<m0> jVar = this.f36605b;
                            m0 m0Var = m0.START;
                            c0480a.f36608f = 1;
                            if (jVar.f(m0Var, c0480a) == objH) {
                                return objH;
                            }
                        }
                    }
                    return l2.f34958a;
                }
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
                return l2.f34958a;
            }

            @Override // kotlinx.coroutines.flow.j
            public /* bridge */ /* synthetic */ Object f(Object obj, kotlin.coroutines.d dVar) {
                return a(((Number) obj).intValue(), dVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(t0<Integer> t0Var, kotlin.coroutines.d<? super a> dVar) {
            super(2, dVar);
            this.f36603g = t0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            a aVar = new a(this.f36603g, dVar);
            aVar.f36602f = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36601e;
            if (i7 == 0) {
                e1.n(obj);
                j jVar = (j) this.f36602f;
                k1.a aVar = new k1.a();
                t0<Integer> t0Var = this.f36603g;
                C0479a c0479a = new C0479a(aVar, jVar);
                this.f36601e = 1;
                if (t0Var.a(c0479a, this) == objH) {
                    return objH;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e1.n(obj);
            }
            throw new kotlin.y();
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d j<? super m0> jVar, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            return ((a) D(jVar, dVar)).R(l2.f34958a);
        }
    }

    @Override // kotlinx.coroutines.flow.o0
    @a7.d
    public i<m0> a(@a7.d t0<Integer> t0Var) {
        return k.I0(new a(t0Var, null));
    }

    @a7.d
    public String toString() {
        return "SharingStarted.Lazily";
    }
}
