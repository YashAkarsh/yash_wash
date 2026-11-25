package kotlinx.coroutines.channels;

import kotlin.b1;
import kotlin.l2;
import kotlinx.coroutines.d2;

/* JADX INFO: loaded from: classes2.dex */
public interface m0<E> {

    public static final class a {
        public static /* synthetic */ boolean a(m0 m0Var, Throwable th, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i7 & 1) != 0) {
                th = null;
            }
            return m0Var.B(th);
        }

        @d2
        public static /* synthetic */ void b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @b1(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@a7.d m0<? super E> m0Var, E e8) throws Throwable {
            Object objQ = m0Var.Q(e8);
            if (r.m(objQ)) {
                return true;
            }
            Throwable thF = r.f(objQ);
            if (thF == null) {
                return false;
            }
            throw kotlinx.coroutines.internal.q0.p(thF);
        }
    }

    boolean B(@a7.e Throwable th);

    @d2
    void M(@a7.d i5.l<? super Throwable, l2> lVar);

    @a7.d
    Object Q(E e8);

    @a7.e
    Object R(E e8, @a7.d kotlin.coroutines.d<? super l2> dVar);

    boolean S();

    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @b1(expression = "trySend(element).isSuccess", imports = {}))
    boolean offer(E e8);

    @a7.d
    kotlinx.coroutines.selects.e<E, m0<E>> z();
}
