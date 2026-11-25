package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
@j2
public interface f1 {

    public static final class a {
        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        @a7.e
        public static Object a(@a7.d f1 f1Var, long j7, @a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
            if (j7 <= 0) {
                return kotlin.l2.f34958a;
            }
            r rVar = new r(kotlin.coroutines.intrinsics.c.d(dVar), 1);
            rVar.O();
            f1Var.s(j7, rVar);
            Object objZ = rVar.z();
            if (objZ == kotlin.coroutines.intrinsics.d.h()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objZ == kotlin.coroutines.intrinsics.d.h() ? objZ : kotlin.l2.f34958a;
        }

        @a7.d
        public static q1 b(@a7.d f1 f1Var, long j7, @a7.d Runnable runnable, @a7.d kotlin.coroutines.g gVar) {
            return c1.a().p0(j7, runnable, gVar);
        }
    }

    @a7.d
    q1 p0(long j7, @a7.d Runnable runnable, @a7.d kotlin.coroutines.g gVar);

    void s(long j7, @a7.d q<? super kotlin.l2> qVar);

    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @a7.e
    Object s0(long j7, @a7.d kotlin.coroutines.d<? super kotlin.l2> dVar);
}
