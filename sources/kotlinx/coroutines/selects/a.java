package kotlinx.coroutines.selects;

import i5.l;
import i5.p;
import kotlinx.coroutines.d2;

/* JADX INFO: loaded from: classes3.dex */
public interface a<R> {

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.a$a, reason: collision with other inner class name */
    public static final class C0491a {
        /* JADX WARN: Multi-variable type inference failed */
        public static <R, P, Q> void a(@a7.d a<? super R> aVar, @a7.d e<? super P, ? extends Q> eVar, @a7.d p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
            aVar.g0(eVar, null, pVar);
        }
    }

    @d2
    void Q(long j7, @a7.d l<? super kotlin.coroutines.d<? super R>, ? extends Object> lVar);

    <P, Q> void V(@a7.d e<? super P, ? extends Q> eVar, @a7.d p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar);

    void f(@a7.d c cVar, @a7.d l<? super kotlin.coroutines.d<? super R>, ? extends Object> lVar);

    <P, Q> void g0(@a7.d e<? super P, ? extends Q> eVar, P p7, @a7.d p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar);

    <Q> void m(@a7.d d<? extends Q> dVar, @a7.d p<? super Q, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar);
}
