package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class ma {

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class a<T> implements com.google.common.base.s<Iterable<? extends T>, Iterator<? extends T>> {
        a() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Iterator<? extends T> apply(Iterable<? extends T> iterable) {
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class b<T> extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f20606b;

        b(Iterable iterable) {
            this.f20606b = iterable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Iterable U(Iterable iterable) {
            return iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return ua.r(this.f20606b);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            final Iterable iterable = this.f20606b;
            return Stream.generate(new Supplier() { // from class: com.google.common.collect.ka
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ma.b.U(iterable);
                }
            }).flatMap(new Function() { // from class: com.google.common.collect.la
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ri.D((Iterable) obj);
                }
            }).spliterator();
        }

        @Override // com.google.common.collect.h5
        public String toString() {
            return this.f20606b.toString() + " (cycled)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class c<T> extends h5<List<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f20607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f20608c;

        c(Iterable iterable, int i7) {
            this.f20607b = iterable;
            this.f20608c = i7;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return ua.Q(this.f20607b.iterator(), this.f20608c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class d<T> extends h5<List<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f20609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f20610c;

        d(Iterable iterable, int i7) {
            this.f20609b = iterable;
            this.f20610c = i7;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return ua.P(this.f20609b.iterator(), this.f20610c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class e<T> extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f20611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.g0 f20612c;

        e(Iterable iterable, com.google.common.base.g0 g0Var) {
            this.f20611b = iterable;
            this.f20612c = g0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void U(com.google.common.base.g0 g0Var, Consumer consumer, Object obj) {
            if (g0Var.test(obj)) {
                consumer.accept(obj);
            }
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> consumer) {
            com.google.common.base.e0.E(consumer);
            Iterable iterable = this.f20611b;
            final com.google.common.base.g0 g0Var = this.f20612c;
            iterable.forEach(new Consumer() { // from class: com.google.common.collect.pa
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ma.e.U(g0Var, consumer, obj);
                }
            });
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return ua.x(this.f20611b.iterator(), this.f20612c);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return q2.a(this.f20611b.spliterator(), this.f20612c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class f<T> extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f20613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.s f20614c;

        f(Iterable iterable, com.google.common.base.s sVar) {
            this.f20613b = iterable;
            this.f20614c = sVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void U(Consumer consumer, com.google.common.base.s sVar, Object obj) {
            consumer.accept(sVar.apply(obj));
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> consumer) {
            com.google.common.base.e0.E(consumer);
            Iterable iterable = this.f20613b;
            final com.google.common.base.s sVar = this.f20614c;
            iterable.forEach(new Consumer() { // from class: com.google.common.collect.qa
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ma.f.U(consumer, sVar, obj);
                }
            });
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return ua.c0(this.f20613b.iterator(), this.f20614c);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return q2.e(this.f20613b.spliterator(), this.f20614c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class g<T> extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f20615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f20616c;

        class a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f20617a = true;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Iterator f20618b;

            a(Iterator it) {
                this.f20618b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f20618b.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                T t7 = (T) this.f20618b.next();
                this.f20617a = false;
                return t7;
            }

            @Override // java.util.Iterator
            public void remove() {
                f2.e(!this.f20617a);
                this.f20618b.remove();
            }
        }

        g(Iterable iterable, int i7) {
            this.f20615b = iterable;
            this.f20616c = i7;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f20615b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.f20616c), list.size()).iterator();
            }
            Iterator<T> it = iterable.iterator();
            ua.b(it, this.f20616c);
            return new a(it);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            Iterable iterable = this.f20615b;
            if (!(iterable instanceof List)) {
                return ri.D(iterable).skip(this.f20616c).spliterator();
            }
            List list = (List) iterable;
            return list.subList(Math.min(list.size(), this.f20616c), list.size()).spliterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class h<T> extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f20620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f20621c;

        h(Iterable iterable, int i7) {
            this.f20620b = iterable;
            this.f20621c = i7;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return ua.N(this.f20620b.iterator(), this.f20621c);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return ri.D(this.f20620b).limit(this.f20621c).spliterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class i<T> extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f20622b;

        i(Iterable iterable) {
            this.f20622b = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f20622b;
            return iterable instanceof Queue ? new h4((Queue) iterable) : ua.p(iterable.iterator());
        }

        @Override // com.google.common.collect.h5
        public String toString() {
            return "Iterables.consumingIterable(...)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class j<T> extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f20623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Comparator f20624c;

        j(Iterable iterable, Comparator comparator) {
            this.f20623b = iterable;
            this.f20624c = comparator;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return ua.O(ma.S(this.f20623b, ma.Q()), this.f20624c);
        }
    }

    private static final class k<T> extends h5<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterable<? extends T> f20625b;

        /* synthetic */ k(Iterable iterable, b bVar) {
            this(iterable);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super T> consumer) {
            this.f20625b.forEach(consumer);
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return ua.f0(this.f20625b.iterator());
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return this.f20625b.spliterator();
        }

        @Override // com.google.common.collect.h5
        public String toString() {
            return this.f20625b.toString();
        }

        private k(Iterable<? extends T> iterable) {
            this.f20625b = iterable;
        }
    }

    private ma() {
    }

    public static <T> T A(Iterable<? extends T> iterable, T t7) {
        return (T) ua.L(iterable.iterator(), t7);
    }

    public static <T> int B(Iterable<T> iterable, com.google.common.base.g0<? super T> g0Var) {
        return ua.M(iterable.iterator(), g0Var);
    }

    public static boolean C(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> D(Iterable<T> iterable, int i7) {
        com.google.common.base.e0.E(iterable);
        com.google.common.base.e0.e(i7 >= 0, "limit is negative");
        return new h(iterable, i7);
    }

    @s1.a
    public static <T> Iterable<T> E(Iterable<? extends Iterable<? extends T>> iterable, Comparator<? super T> comparator) {
        com.google.common.base.e0.F(iterable, "iterables");
        com.google.common.base.e0.F(comparator, "comparator");
        return new k(new j(iterable, comparator), null);
    }

    public static <T> Iterable<List<T>> F(Iterable<T> iterable, int i7) {
        com.google.common.base.e0.E(iterable);
        com.google.common.base.e0.d(i7 > 0);
        return new d(iterable, i7);
    }

    public static <T> Iterable<List<T>> G(Iterable<T> iterable, int i7) {
        com.google.common.base.e0.E(iterable);
        com.google.common.base.e0.d(i7 > 0);
        return new c(iterable, i7);
    }

    @u1.a
    public static boolean H(Iterable<?> iterable, Collection<?> collection) {
        return iterable instanceof Collection ? ((Collection) iterable).removeAll((Collection) com.google.common.base.e0.E(collection)) : ua.V(iterable.iterator(), collection);
    }

    static <T> T I(Iterable<T> iterable, com.google.common.base.g0<? super T> g0Var) {
        com.google.common.base.e0.E(g0Var);
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (g0Var.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    @u1.a
    public static <T> boolean J(Iterable<T> iterable, com.google.common.base.g0<? super T> g0Var) {
        return iterable instanceof Collection ? ((Collection) iterable).removeIf(g0Var) : ua.W(iterable.iterator(), g0Var);
    }

    @u1.a
    public static boolean K(Iterable<?> iterable, Collection<?> collection) {
        return iterable instanceof Collection ? ((Collection) iterable).retainAll((Collection) com.google.common.base.e0.E(collection)) : ua.X(iterable.iterator(), collection);
    }

    public static int L(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : ua.Z(iterable.iterator());
    }

    public static <T> Iterable<T> M(Iterable<T> iterable, int i7) {
        com.google.common.base.e0.E(iterable);
        com.google.common.base.e0.e(i7 >= 0, "number to skip cannot be negative");
        return new g(iterable, i7);
    }

    static Object[] N(Iterable<?> iterable) {
        return d(iterable).toArray();
    }

    @s1.c
    public static <T> T[] O(Iterable<? extends T> iterable, Class<T> cls) {
        return (T[]) P(iterable, sd.i(cls, 0));
    }

    static <T> T[] P(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) d(iterable).toArray(tArr);
    }

    static <T> com.google.common.base.s<Iterable<? extends T>, Iterator<? extends T>> Q() {
        return new a();
    }

    public static String R(Iterable<?> iterable) {
        return ua.b0(iterable.iterator());
    }

    public static <F, T> Iterable<T> S(Iterable<F> iterable, com.google.common.base.s<? super F, ? extends T> sVar) {
        com.google.common.base.e0.E(iterable);
        com.google.common.base.e0.E(sVar);
        return new f(iterable, sVar);
    }

    public static <T> com.google.common.base.a0<T> T(Iterable<T> iterable, com.google.common.base.g0<? super T> g0Var) {
        return ua.d0(iterable.iterator(), g0Var);
    }

    @Deprecated
    public static <E> Iterable<E> U(x6<E> x6Var) {
        return (Iterable) com.google.common.base.e0.E(x6Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Iterable<T> V(Iterable<? extends T> iterable) {
        com.google.common.base.e0.E(iterable);
        return ((iterable instanceof k) || (iterable instanceof x6)) ? iterable : new k(iterable, null);
    }

    @u1.a
    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        return iterable instanceof Collection ? collection.addAll(h3.b(iterable)) : ua.a(collection, ((Iterable) com.google.common.base.e0.E(iterable)).iterator());
    }

    public static <T> boolean b(Iterable<T> iterable, com.google.common.base.g0<? super T> g0Var) {
        return ua.c(iterable.iterator(), g0Var);
    }

    public static <T> boolean c(Iterable<T> iterable, com.google.common.base.g0<? super T> g0Var) {
        return ua.d(iterable.iterator(), g0Var);
    }

    private static <E> Collection<E> d(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : ib.s(iterable.iterator());
    }

    public static <T> Iterable<T> e(Iterable<? extends Iterable<? extends T>> iterable) {
        return h5.g(iterable);
    }

    public static <T> Iterable<T> f(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return h5.h(iterable, iterable2);
    }

    public static <T> Iterable<T> g(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return h5.j(iterable, iterable2, iterable3);
    }

    public static <T> Iterable<T> h(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return h5.k(iterable, iterable2, iterable3, iterable4);
    }

    @SafeVarargs
    public static <T> Iterable<T> i(Iterable<? extends T>... iterableArr) {
        return h5.l(iterableArr);
    }

    public static <T> Iterable<T> j(Iterable<T> iterable) {
        com.google.common.base.e0.E(iterable);
        return new i(iterable);
    }

    public static boolean k(Iterable<?> iterable, Object obj) {
        return iterable instanceof Collection ? h3.j((Collection) iterable, obj) : ua.q(iterable.iterator(), obj);
    }

    public static <T> Iterable<T> l(Iterable<T> iterable) {
        com.google.common.base.e0.E(iterable);
        return new b(iterable);
    }

    @SafeVarargs
    public static <T> Iterable<T> m(T... tArr) {
        return l(ib.t(tArr));
    }

    public static boolean n(Iterable<?> iterable, Iterable<?> iterable2) {
        if ((iterable instanceof Collection) && (iterable2 instanceof Collection) && ((Collection) iterable).size() != ((Collection) iterable2).size()) {
            return false;
        }
        return ua.t(iterable.iterator(), iterable2.iterator());
    }

    public static <T> Iterable<T> o(Iterable<T> iterable, com.google.common.base.g0<? super T> g0Var) {
        com.google.common.base.e0.E(iterable);
        com.google.common.base.e0.E(g0Var);
        return new e(iterable, g0Var);
    }

    @s1.c
    public static <T> Iterable<T> p(Iterable<?> iterable, Class<T> cls) {
        com.google.common.base.e0.E(iterable);
        com.google.common.base.e0.E(cls);
        return o(iterable, com.google.common.base.h0.o(cls));
    }

    public static <T> T q(Iterable<T> iterable, com.google.common.base.g0<? super T> g0Var) {
        return (T) ua.z(iterable.iterator(), g0Var);
    }

    public static <T> T r(Iterable<? extends T> iterable, com.google.common.base.g0<? super T> g0Var, T t7) {
        return (T) ua.A(iterable.iterator(), g0Var, t7);
    }

    public static int s(Iterable<?> iterable, Object obj) {
        if (iterable instanceof hd) {
            return ((hd) iterable).l0(obj);
        }
        return iterable instanceof Set ? ((Set) iterable).contains(obj) ? 1 : 0 : ua.E(iterable.iterator(), obj);
    }

    public static <T> T t(Iterable<T> iterable, int i7) {
        com.google.common.base.e0.E(iterable);
        return iterable instanceof List ? (T) ((List) iterable).get(i7) : (T) ua.F(iterable.iterator(), i7);
    }

    public static <T> T u(Iterable<? extends T> iterable, int i7, T t7) {
        com.google.common.base.e0.E(iterable);
        ua.g(i7);
        if (iterable instanceof List) {
            List listF = ib.f(iterable);
            return i7 < listF.size() ? (T) listF.get(i7) : t7;
        }
        Iterator<? extends T> it = iterable.iterator();
        ua.b(it, i7);
        return (T) ua.J(it, t7);
    }

    public static <T> T v(Iterable<? extends T> iterable, T t7) {
        return (T) ua.J(iterable.iterator(), t7);
    }

    public static <T> T w(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) ua.H(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) y(list);
    }

    public static <T> T x(Iterable<? extends T> iterable, T t7) {
        if (iterable instanceof Collection) {
            if (h3.b(iterable).isEmpty()) {
                return t7;
            }
            if (iterable instanceof List) {
                return (T) y(ib.f(iterable));
            }
        }
        return (T) ua.I(iterable.iterator(), t7);
    }

    private static <T> T y(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T z(Iterable<T> iterable) {
        return (T) ua.K(iterable.iterator());
    }
}
