package kotlinx.coroutines.channels;

import kotlin.b1;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.v0;

/* JADX INFO: loaded from: classes2.dex */
@f3
public interface f<E> extends v0, i0<E> {

    public static final class a {
        @a7.d
        public static <E> kotlinx.coroutines.selects.d<E> b(@a7.d f<E> fVar) {
            return i0.a.d(fVar);
        }

        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @b1(expression = "tryReceive().getOrNull()", imports = {}))
        @a7.e
        public static <E> E c(@a7.d f<E> fVar) {
            return (E) i0.a.h(fVar);
        }

        @kotlin.internal.h
        @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @b1(expression = "receiveCatching().getOrNull()", imports = {}))
        @a7.e
        public static <E> Object d(@a7.d f<E> fVar, @a7.d kotlin.coroutines.d<? super E> dVar) {
            return i0.a.i(fVar, dVar);
        }
    }

    @a7.d
    n<E> a();
}
