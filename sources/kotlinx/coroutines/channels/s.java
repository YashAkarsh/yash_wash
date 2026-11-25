package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a1;
import kotlin.b1;
import kotlin.l2;
import kotlin.u0;
import kotlinx.coroutines.f3;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final String f35660a = "Channel was closed";

    @a7.d
    @a1
    public static final <E, R> i0<R> J(@a7.d i0<? extends E> i0Var, @a7.d kotlin.coroutines.g gVar, @a7.d i5.p<? super E, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        return v.E(i0Var, gVar, pVar);
    }

    @a7.d
    @a1
    public static final <E, R> i0<R> L(@a7.d i0<? extends E> i0Var, @a7.d kotlin.coroutines.g gVar, @a7.d i5.q<? super Integer, ? super E, ? super kotlin.coroutines.d<? super R>, ? extends Object> qVar) {
        return v.G(i0Var, gVar, qVar);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final <E> kotlinx.coroutines.selects.d<E> U(@a7.d i0<? extends E> i0Var) {
        return u.h(i0Var);
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @b1(expression = "receiveCatching().getOrNull()", imports = {}))
    @a7.e
    public static final <E> Object V(@a7.d i0<? extends E> i0Var, @a7.d kotlin.coroutines.d<? super E> dVar) {
        return u.i(i0Var, dVar);
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @b1(expression = "trySendBlocking(element)", imports = {}))
    public static final <E> void X(@a7.d m0<? super E> m0Var, E e8) throws InterruptedException {
        t.a(m0Var, e8);
    }

    @a1
    public static final void b(@a7.d i0<?> i0Var, @a7.e Throwable th) {
        u.a(i0Var, th);
    }

    @f3
    public static final <E, R> R c(@a7.d i<E> iVar, @a7.d i5.l<? super i0<? extends E>, ? extends R> lVar) {
        return (R) u.b(iVar, lVar);
    }

    public static final <E, R> R d(@a7.d i0<? extends E> i0Var, @a7.d i5.l<? super i0<? extends E>, ? extends R> lVar) {
        return (R) u.c(i0Var, lVar);
    }

    @a7.e
    @f3
    public static final <E> Object e(@a7.d i<E> iVar, @a7.d i5.l<? super E, l2> lVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return u.d(iVar, lVar, dVar);
    }

    @a7.e
    @a1
    public static final <E, C extends m0<? super E>> Object e0(@a7.d i0<? extends E> i0Var, @a7.d C c8, @a7.d kotlin.coroutines.d<? super C> dVar) {
        return v.W(i0Var, c8, dVar);
    }

    @a7.e
    public static final <E> Object f(@a7.d i0<? extends E> i0Var, @a7.d i5.l<? super E, l2> lVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        return u.e(i0Var, lVar, dVar);
    }

    @a7.e
    @a1
    public static final <E, C extends Collection<? super E>> Object f0(@a7.d i0<? extends E> i0Var, @a7.d C c8, @a7.d kotlin.coroutines.d<? super C> dVar) {
        return v.X(i0Var, c8, dVar);
    }

    @a7.d
    @a1
    public static final i5.l<Throwable, l2> g(@a7.d i0<?> i0Var) {
        return v.b(i0Var);
    }

    @a7.e
    public static final <E> Object g0(@a7.d i0<? extends E> i0Var, @a7.d kotlin.coroutines.d<? super List<? extends E>> dVar) {
        return u.j(i0Var, dVar);
    }

    @a7.d
    @a1
    public static final i5.l<Throwable, l2> h(@a7.d i0<?>... i0VarArr) {
        return v.c(i0VarArr);
    }

    @a7.e
    @a1
    public static final <K, V, M extends Map<? super K, ? super V>> Object h0(@a7.d i0<? extends u0<? extends K, ? extends V>> i0Var, @a7.d M m7, @a7.d kotlin.coroutines.d<? super M> dVar) {
        return v.Y(i0Var, m7, dVar);
    }

    @a7.d
    @a1
    public static final <E, K> i0<E> k(@a7.d i0<? extends E> i0Var, @a7.d kotlin.coroutines.g gVar, @a7.d i5.p<? super E, ? super kotlin.coroutines.d<? super K>, ? extends Object> pVar) {
        return v.f(i0Var, gVar, pVar);
    }

    @a7.e
    @a1
    public static final <E> Object k0(@a7.d i0<? extends E> i0Var, @a7.d kotlin.coroutines.d<? super Set<E>> dVar) {
        return v.b0(i0Var, dVar);
    }

    @a7.d
    public static final <E> Object m0(@a7.d m0<? super E> m0Var, E e8) {
        return t.b(m0Var, e8);
    }

    @a7.d
    @a1
    public static final <E, R, V> i0<V> q0(@a7.d i0<? extends E> i0Var, @a7.d i0<? extends R> i0Var2, @a7.d kotlin.coroutines.g gVar, @a7.d i5.p<? super E, ? super R, ? extends V> pVar) {
        return v.g0(i0Var, i0Var2, gVar, pVar);
    }

    @a7.d
    @a1
    public static final <E> i0<E> s(@a7.d i0<? extends E> i0Var, @a7.d kotlin.coroutines.g gVar, @a7.d i5.p<? super E, ? super kotlin.coroutines.d<? super Boolean>, ? extends Object> pVar) {
        return v.n(i0Var, gVar, pVar);
    }

    @a7.d
    @a1
    public static final <E> i0<E> y(@a7.d i0<? extends E> i0Var) {
        return v.t(i0Var);
    }
}
