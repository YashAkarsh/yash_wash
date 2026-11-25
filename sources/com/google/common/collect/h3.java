package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public final class h3 {

    static class a<E> extends AbstractCollection<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Collection<E> f20348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.google.common.base.g0<? super E> f20349b;

        a(Collection<E> collection, com.google.common.base.g0<? super E> g0Var) {
            this.f20348a = collection;
            this.f20349b = g0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Consumer consumer, Object obj) {
            if (this.f20349b.test(obj)) {
                consumer.accept(obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean h(Predicate predicate, Object obj) {
            return this.f20349b.apply(obj) && predicate.test(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean j(Collection collection, Object obj) {
            return !collection.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E e8) {
            com.google.common.base.e0.d(this.f20349b.apply(e8));
            return this.f20348a.add(e8);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                com.google.common.base.e0.d(this.f20349b.apply(it.next()));
            }
            return this.f20348a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ma.J(this.f20348a, this.f20349b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (h3.j(this.f20348a, obj)) {
                return this.f20349b.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return h3.c(this, collection);
        }

        a<E> f(com.google.common.base.g0<? super E> g0Var) {
            return new a<>(this.f20348a, com.google.common.base.h0.d(this.f20349b, g0Var));
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super E> consumer) {
            com.google.common.base.e0.E(consumer);
            this.f20348a.forEach(new Consumer() { // from class: com.google.common.collect.f3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f20224a.g(consumer, obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !ma.c(this.f20348a, this.f20349b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return ua.x(this.f20348a.iterator(), this.f20349b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return contains(obj) && this.f20348a.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(final Collection<?> collection) {
            collection.getClass();
            return removeIf(new Predicate() { // from class: com.google.common.collect.d3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return collection.contains(obj);
                }
            });
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super E> predicate) {
            com.google.common.base.e0.E(predicate);
            return this.f20348a.removeIf(new Predicate() { // from class: com.google.common.collect.g3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f20275a.h(predicate, obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(final Collection<?> collection) {
            return removeIf(new Predicate() { // from class: com.google.common.collect.e3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return h3.a.j(collection, obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> it = this.f20348a.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                if (this.f20349b.apply(it.next())) {
                    i7++;
                }
            }
            return i7;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return q2.a(this.f20348a.spliterator(), this.f20349b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return ib.s(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) ib.s(iterator()).toArray(tArr);
        }
    }

    private static final class b<E> extends AbstractCollection<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d7<E> f20350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Comparator<? super E> f20351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f20352c;

        b(Iterable<E> iterable, Comparator<? super E> comparator) {
            d7<E> d7VarS = d7.S(comparator, iterable);
            this.f20350a = d7VarS;
            this.f20351b = comparator;
            this.f20352c = a(d7VarS, comparator);
        }

        private static <E> int a(List<E> list, Comparator<? super E> comparator) {
            int i7 = 1;
            int iU = 1;
            int i8 = 1;
            while (i7 < list.size()) {
                if (comparator.compare(list.get(i7 - 1), list.get(i7)) < 0) {
                    iU = com.google.common.math.d.u(iU, com.google.common.math.d.a(i7, i8));
                    if (iU == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    i8 = 0;
                }
                i7++;
                i8++;
            }
            return com.google.common.math.d.u(iU, com.google.common.math.d.a(i7, i8));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return h3.e(this.f20350a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new c(this.f20350a, this.f20351b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f20352c;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "orderedPermutationCollection(" + this.f20350a + ")";
        }
    }

    private static final class c<E> extends com.google.common.collect.e<List<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<E> f20353c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Comparator<? super E> f20354d;

        c(List<E> list, Comparator<? super E> comparator) {
            this.f20353c = ib.r(list);
            this.f20354d = comparator;
        }

        void d() {
            int iF = f();
            if (iF == -1) {
                this.f20353c = null;
                return;
            }
            Collections.swap(this.f20353c, iF, g(iF));
            Collections.reverse(this.f20353c.subList(iF + 1, this.f20353c.size()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List<E> a() {
            List<E> list = this.f20353c;
            if (list == null) {
                return b();
            }
            d7 d7VarR = d7.r(list);
            d();
            return d7VarR;
        }

        int f() {
            for (int size = this.f20353c.size() - 2; size >= 0; size--) {
                if (this.f20354d.compare(this.f20353c.get(size), this.f20353c.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        int g(int i7) {
            E e8 = this.f20353c.get(i7);
            for (int size = this.f20353c.size() - 1; size > i7; size--) {
                if (this.f20354d.compare(e8, this.f20353c.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }
    }

    private static final class d<E> extends AbstractCollection<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d7<E> f20355a;

        d(d7<E> d7Var) {
            this.f20355a = d7Var;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return h3.e(this.f20355a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new e(this.f20355a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return com.google.common.math.d.h(this.f20355a.size());
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "permutations(" + this.f20355a + ")";
        }
    }

    private static class e<E> extends com.google.common.collect.e<List<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final List<E> f20356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int[] f20357d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int[] f20358e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f20359f;

        e(List<E> list) {
            this.f20356c = new ArrayList(list);
            int size = list.size();
            int[] iArr = new int[size];
            this.f20357d = iArr;
            int[] iArr2 = new int[size];
            this.f20358e = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 1);
            this.f20359f = Integer.MAX_VALUE;
        }

        void d() {
            int size = this.f20356c.size() - 1;
            this.f20359f = size;
            if (size == -1) {
                return;
            }
            int i7 = 0;
            while (true) {
                int[] iArr = this.f20357d;
                int i8 = this.f20359f;
                int i9 = iArr[i8];
                int i10 = this.f20358e[i8] + i9;
                if (i10 < 0) {
                    f();
                } else if (i10 != i8 + 1) {
                    Collections.swap(this.f20356c, (i8 - i9) + i7, (i8 - i10) + i7);
                    this.f20357d[this.f20359f] = i10;
                    return;
                } else {
                    if (i8 == 0) {
                        return;
                    }
                    i7++;
                    f();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List<E> a() {
            if (this.f20359f <= 0) {
                return b();
            }
            d7 d7VarR = d7.r(this.f20356c);
            d();
            return d7VarR;
        }

        void f() {
            int[] iArr = this.f20358e;
            int i7 = this.f20359f;
            iArr[i7] = -iArr[i7];
            this.f20359f = i7 - 1;
        }
    }

    static class f<F, T> extends AbstractCollection<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Collection<F> f20360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.google.common.base.s<? super F, ? extends T> f20361b;

        f(Collection<F> collection, com.google.common.base.s<? super F, ? extends T> sVar) {
            this.f20360a = (Collection) com.google.common.base.e0.E(collection);
            this.f20361b = (com.google.common.base.s) com.google.common.base.e0.E(sVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Consumer consumer, Object obj) {
            consumer.accept(this.f20361b.apply(obj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean f(Predicate predicate, Object obj) {
            return predicate.test(this.f20361b.apply(obj));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f20360a.clear();
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> consumer) {
            com.google.common.base.e0.E(consumer);
            this.f20360a.forEach(new Consumer() { // from class: com.google.common.collect.j3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f20463a.d(consumer, obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f20360a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return ua.c0(this.f20360a.iterator(), this.f20361b);
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super T> predicate) {
            com.google.common.base.e0.E(predicate);
            return this.f20360a.removeIf(new Predicate() { // from class: com.google.common.collect.i3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f20400a.f(predicate, obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f20360a.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<T> spliterator() {
            return q2.e(this.f20360a.spliterator(), this.f20361b);
        }
    }

    private h3() {
    }

    static <T> Collection<T> b(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    static boolean c(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <E> Collection<E> d(Collection<E> collection, com.google.common.base.g0<? super E> g0Var) {
        return collection instanceof a ? ((a) collection).f(g0Var) : new a((Collection) com.google.common.base.e0.E(collection), (com.google.common.base.g0) com.google.common.base.e0.E(g0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        return r6.v(list).equals(r6.v(list2));
    }

    static StringBuilder f(int i7) {
        f2.b(i7, "size");
        return new StringBuilder((int) Math.min(((long) i7) * 8, 1073741824L));
    }

    @s1.a
    public static <E extends Comparable<? super E>> Collection<List<E>> g(Iterable<E> iterable) {
        return h(iterable, td.A());
    }

    @s1.a
    public static <E> Collection<List<E>> h(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new b(iterable, comparator);
    }

    @s1.a
    public static <E> Collection<List<E>> i(Collection<E> collection) {
        return new d(d7.r(collection));
    }

    static boolean j(Collection<?> collection, Object obj) {
        com.google.common.base.e0.E(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static boolean k(Collection<?> collection, Object obj) {
        com.google.common.base.e0.E(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static String l(Collection<?> collection) {
        StringBuilder sbF = f(collection.size());
        sbF.append('[');
        boolean z7 = true;
        for (Object obj : collection) {
            if (!z7) {
                sbF.append(", ");
            }
            if (obj == collection) {
                sbF.append("(this Collection)");
            } else {
                sbF.append(obj);
            }
            z7 = false;
        }
        sbF.append(']');
        return sbF.toString();
    }

    public static <F, T> Collection<T> m(Collection<F> collection, com.google.common.base.s<? super F, T> sVar) {
        return new f(collection, sVar);
    }
}
