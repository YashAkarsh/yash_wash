package kotlin.time;

import kotlin.g1;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
@k
public interface q {

    public static final class a {
        public static boolean a(@a7.d q qVar) {
            return d.a0(qVar.c());
        }

        public static boolean b(@a7.d q qVar) {
            return !d.a0(qVar.c());
        }

        @a7.d
        public static q c(@a7.d q qVar, long j7) {
            return qVar.e(d.t0(j7));
        }

        @a7.d
        public static q d(@a7.d q qVar, long j7) {
            return new c(qVar, j7, null);
        }
    }

    boolean a();

    @a7.d
    q b(long j7);

    long c();

    boolean d();

    @a7.d
    q e(long j7);
}
