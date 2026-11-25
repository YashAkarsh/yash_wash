package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.e1;
import kotlin.l2;
import kotlinx.coroutines.g1;

/* JADX INFO: loaded from: classes3.dex */
final class s0 implements o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f36613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f36614c;

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {com.alibaba.fastjson.asm.j.T, 180, com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.asm.j.Z}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
    static final class a extends kotlin.coroutines.jvm.internal.o implements i5.q<j<? super m0>, Integer, kotlin.coroutines.d<? super l2>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36615e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private /* synthetic */ Object f36616f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ int f36617g;

        a(kotlin.coroutines.d<? super a> dVar) {
            super(3, dVar);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0070  */
        /* JADX WARN: Code duplicated, block: B:28:0x007c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x008d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x009b A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            j jVar;
            m0 m0Var;
            long j7;
            m0 m0Var2;
            Object objH = kotlin.coroutines.intrinsics.d.h();
            int i7 = this.f36615e;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 == 2) {
                        jVar = (j) this.f36616f;
                        e1.n(obj);
                        if (s0.this.f36614c > 0) {
                            m0Var = m0.STOP;
                            this.f36616f = jVar;
                            this.f36615e = 3;
                            if (jVar.f(m0Var, this) == objH) {
                                return objH;
                            }
                            j7 = s0.this.f36614c;
                            this.f36616f = jVar;
                            this.f36615e = 4;
                            if (g1.b(j7, this) == objH) {
                                return objH;
                            }
                        }
                    } else if (i7 == 3) {
                        jVar = (j) this.f36616f;
                        e1.n(obj);
                        j7 = s0.this.f36614c;
                        this.f36616f = jVar;
                        this.f36615e = 4;
                        if (g1.b(j7, this) == objH) {
                            return objH;
                        }
                    } else if (i7 == 4) {
                        jVar = (j) this.f36616f;
                        e1.n(obj);
                    } else if (i7 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    m0Var2 = m0.STOP_AND_RESET_REPLAY_CACHE;
                    this.f36616f = null;
                    this.f36615e = 5;
                    if (jVar.f(m0Var2, this) == objH) {
                        return objH;
                    }
                }
                e1.n(obj);
            } else {
                e1.n(obj);
                jVar = (j) this.f36616f;
                if (this.f36617g > 0) {
                    m0 m0Var3 = m0.START;
                    this.f36615e = 1;
                    if (jVar.f(m0Var3, this) == objH) {
                        return objH;
                    }
                } else {
                    long j8 = s0.this.f36613b;
                    this.f36616f = jVar;
                    this.f36615e = 2;
                    if (g1.b(j8, this) == objH) {
                        return objH;
                    }
                    if (s0.this.f36614c > 0) {
                        m0Var = m0.STOP;
                        this.f36616f = jVar;
                        this.f36615e = 3;
                        if (jVar.f(m0Var, this) == objH) {
                            return objH;
                        }
                        j7 = s0.this.f36614c;
                        this.f36616f = jVar;
                        this.f36615e = 4;
                        if (g1.b(j7, this) == objH) {
                            return objH;
                        }
                    }
                    m0Var2 = m0.STOP_AND_RESET_REPLAY_CACHE;
                    this.f36616f = null;
                    this.f36615e = 5;
                    if (jVar.f(m0Var2, this) == objH) {
                        return objH;
                    }
                }
            }
            return l2.f34958a;
        }

        @a7.e
        public final Object e0(@a7.d j<? super m0> jVar, int i7, @a7.e kotlin.coroutines.d<? super l2> dVar) {
            a aVar = s0.this.new a(dVar);
            aVar.f36616f = jVar;
            aVar.f36617g = i7;
            return aVar.R(l2.f34958a);
        }

        @Override // i5.q
        public /* bridge */ /* synthetic */ Object v(j<? super m0> jVar, Integer num, kotlin.coroutines.d<? super l2> dVar) {
            return e0(jVar, num.intValue(), dVar);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends kotlin.coroutines.jvm.internal.o implements i5.p<m0, kotlin.coroutines.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f36619e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f36620f;

        b(kotlin.coroutines.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.d
        public final kotlin.coroutines.d<l2> D(@a7.e Object obj, @a7.d kotlin.coroutines.d<?> dVar) {
            b bVar = new b(dVar);
            bVar.f36620f = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @a7.e
        public final Object R(@a7.d Object obj) {
            kotlin.coroutines.intrinsics.d.h();
            if (this.f36619e != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e1.n(obj);
            return kotlin.coroutines.jvm.internal.b.a(((m0) this.f36620f) != m0.START);
        }

        @Override // i5.p
        @a7.e
        /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
        public final Object a0(@a7.d m0 m0Var, @a7.e kotlin.coroutines.d<? super Boolean> dVar) {
            return ((b) D(m0Var, dVar)).R(l2.f34958a);
        }
    }

    public s0(long j7, long j8) {
        this.f36613b = j7;
        this.f36614c = j8;
        if (!(j7 >= 0)) {
            throw new IllegalArgumentException(("stopTimeout(" + j7 + " ms) cannot be negative").toString());
        }
        if (j8 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j8 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.o0
    @a7.d
    public i<m0> a(@a7.d t0<Integer> t0Var) {
        return k.g0(k.k0(k.b2(t0Var, new a(null)), new b(null)));
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof s0) {
            s0 s0Var = (s0) obj;
            if (this.f36613b == s0Var.f36613b && this.f36614c == s0Var.f36614c) {
                return true;
            }
        }
        return false;
    }

    @z6.a
    public int hashCode() {
        return (kotlinx.coroutines.s0.a(this.f36613b) * 31) + kotlinx.coroutines.s0.a(this.f36614c);
    }

    @a7.d
    public String toString() {
        List listK = kotlin.collections.x.k(2);
        if (this.f36613b > 0) {
            listK.add("stopTimeout=" + this.f36613b + "ms");
        }
        if (this.f36614c < Long.MAX_VALUE) {
            listK.add("replayExpiration=" + this.f36614c + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + kotlin.collections.g0.h3(kotlin.collections.x.b(listK), null, null, null, 0, null, null, 63, null) + ')';
    }
}
