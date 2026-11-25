package kotlinx.coroutines.channels;

import kotlin.b1;
import kotlinx.coroutines.v0;

/* JADX INFO: loaded from: classes2.dex */
public interface g0<E> extends v0, m0<E> {

    public static final class a {
        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @b1(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean a(@a7.d g0<? super E> g0Var, E e8) {
            return m0.a.c(g0Var, e8);
        }
    }

    @a7.d
    m0<E> a();
}
