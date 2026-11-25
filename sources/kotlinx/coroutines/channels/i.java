package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.b1;
import kotlinx.coroutines.f3;

/* JADX INFO: loaded from: classes2.dex */
@f3
public interface i<E> extends m0<E> {

    public static final class a {
        public static /* synthetic */ void a(i iVar, CancellationException cancellationException, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i7 & 1) != 0) {
                cancellationException = null;
            }
            iVar.c(cancellationException);
        }

        public static /* synthetic */ boolean b(i iVar, Throwable th, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i7 & 1) != 0) {
                th = null;
            }
            return iVar.e(th);
        }

        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @b1(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean c(@a7.d i<E> iVar, E e8) {
            return m0.a.c(iVar, e8);
        }
    }

    @a7.d
    i0<E> G();

    void c(@a7.e CancellationException cancellationException);

    @kotlin.k(level = kotlin.m.HIDDEN, message = "Binary compatibility only")
    /* synthetic */ boolean e(Throwable th);
}
