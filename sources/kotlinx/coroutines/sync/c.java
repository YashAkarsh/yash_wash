package kotlinx.coroutines.sync;

import kotlin.k;
import kotlin.l2;
import kotlin.m;

/* JADX INFO: loaded from: classes3.dex */
public interface c {

    public static final class a {
        @k(level = m.WARNING, message = "Mutex.onLock deprecated without replacement. For additional details please refer to #2794")
        public static /* synthetic */ void a() {
        }

        public static /* synthetic */ Object b(c cVar, Object obj, kotlin.coroutines.d dVar, int i7, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
            }
            if ((i7 & 1) != 0) {
                obj = null;
            }
            return cVar.c(obj, dVar);
        }

        public static /* synthetic */ boolean c(c cVar, Object obj, int i7, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
            }
            if ((i7 & 1) != 0) {
                obj = null;
            }
            return cVar.a(obj);
        }

        public static /* synthetic */ void d(c cVar, Object obj, int i7, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
            }
            if ((i7 & 1) != 0) {
                obj = null;
            }
            cVar.d(obj);
        }
    }

    boolean a(@a7.e Object obj);

    boolean b();

    @a7.e
    Object c(@a7.e Object obj, @a7.d kotlin.coroutines.d<? super l2> dVar);

    void d(@a7.e Object obj);

    boolean e(@a7.d Object obj);

    @a7.d
    kotlinx.coroutines.selects.e<Object, c> f();
}
