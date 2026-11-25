package com.google.common.collect;

import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class ib {

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class a<E> extends g<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f20415b = 0;

        a(List list) {
            super(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i7) {
            return this.f20417a.listIterator(i7);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class b<E> extends c<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f20416b = 0;

        b(List list) {
            super(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i7) {
            return this.f20417a.listIterator(i7);
        }
    }

    private static class c<E> extends AbstractList<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<E> f20417a;

        c(List<E> list) {
            this.f20417a = (List) com.google.common.base.e0.E(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i7, E e8) {
            this.f20417a.add(i7, e8);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i7, Collection<? extends E> collection) {
            return this.f20417a.addAll(i7, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.f20417a.contains(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i7) {
            return this.f20417a.get(i7);
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int i7) {
            return this.f20417a.remove(i7);
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i7, E e8) {
            return this.f20417a.set(i7, e8);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f20417a.size();
        }
    }

    private static final class d extends AbstractList<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CharSequence f20418a;

        d(CharSequence charSequence) {
            this.f20418a = charSequence;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return Character.valueOf(this.f20418a.charAt(i7));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f20418a.length();
        }
    }

    private static class e<E> extends AbstractList<E> implements Serializable, RandomAccess {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f20419c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final E f20420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final E[] f20421b;

        e(E e8, E[] eArr) {
            this.f20420a = e8;
            this.f20421b = (E[]) ((Object[]) com.google.common.base.e0.E(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return i7 == 0 ? this.f20420a : this.f20421b[i7 - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.d.t(this.f20421b.length, 1);
        }
    }

    private static class f<T> extends AbstractList<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<T> f20422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f20423b;

        f(List<T> list, int i7) {
            this.f20422a = list;
            this.f20423b = i7;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> get(int i7) {
            com.google.common.base.e0.C(i7, size());
            int i8 = this.f20423b;
            int i9 = i7 * i8;
            return this.f20422a.subList(i9, Math.min(i8 + i9, this.f20422a.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f20422a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.d.g(this.f20422a.size(), this.f20423b, RoundingMode.CEILING);
        }
    }

    private static class g<E> extends c<E> implements RandomAccess {
        g(List<E> list) {
            super(list);
        }
    }

    private static class h<T> extends f<T> implements RandomAccess {
        h(List<T> list, int i7) {
            super(list, i7);
        }
    }

    private static class i<T> extends j<T> implements RandomAccess {
        i(List<T> list) {
            super(list);
        }
    }

    private static class j<T> extends AbstractList<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<T> f20424a;

        class a implements ListIterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f20425a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ListIterator f20426b;

            a(ListIterator listIterator) {
                this.f20426b = listIterator;
            }

            @Override // java.util.ListIterator
            public void add(T t7) {
                this.f20426b.add(t7);
                this.f20426b.previous();
                this.f20425a = false;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f20426b.hasPrevious();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f20426b.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f20425a = true;
                return (T) this.f20426b.previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return j.this.f(this.f20426b.nextIndex());
            }

            @Override // java.util.ListIterator
            public T previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.f20425a = true;
                return (T) this.f20426b.next();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return nextIndex() - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                f2.e(this.f20425a);
                this.f20426b.remove();
                this.f20425a = false;
            }

            @Override // java.util.ListIterator
            public void set(T t7) {
                com.google.common.base.e0.g0(this.f20425a);
                this.f20426b.set(t7);
            }
        }

        j(List<T> list) {
            this.f20424a = (List) com.google.common.base.e0.E(list);
        }

        private int d(int i7) {
            int size = size();
            com.google.common.base.e0.C(i7, size);
            return (size - 1) - i7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int f(int i7) {
            int size = size();
            com.google.common.base.e0.d0(i7, size);
            return size - i7;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i7, T t7) {
            this.f20424a.add(f(i7), t7);
        }

        List<T> b() {
            return this.f20424a;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f20424a.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i7) {
            return this.f20424a.get(d(i7));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i7) {
            return new a(this.f20424a.listIterator(f(i7)));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i7) {
            return this.f20424a.remove(d(i7));
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i7, int i8) {
            subList(i7, i8).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T set(int i7, T t7) {
            return this.f20424a.set(d(i7), t7);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f20424a.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, size());
            return ib.B(this.f20424a.subList(f(i8), f(i7)));
        }
    }

    private static final class k extends d7<Character> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f20428c;

        k(String str) {
            this.f20428c = str;
        }

        @Override // com.google.common.collect.d7, java.util.List
        /* JADX INFO: renamed from: T */
        public d7<Character> subList(int i7, int i8) {
            com.google.common.base.e0.f0(i7, i8, size());
            return ib.g(this.f20428c.substring(i7, i8));
        }

        @Override // java.util.List
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public Character get(int i7) {
            com.google.common.base.e0.C(i7, size());
            return Character.valueOf(this.f20428c.charAt(i7));
        }

        @Override // com.google.common.collect.x6
        boolean h() {
            return false;
        }

        @Override // com.google.common.collect.d7, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Character) {
                return this.f20428c.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // com.google.common.collect.d7, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return this.f20428c.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f20428c.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class l<F, T> extends AbstractList<T> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f20429c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<F> f20430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.google.common.base.s<? super F, ? extends T> f20431b;

        class a extends vj<F, T> {
            a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.uj
            T a(F f8) {
                return l.this.f20431b.apply(f8);
            }
        }

        l(List<F> list, com.google.common.base.s<? super F, ? extends T> sVar) {
            this.f20430a = (List) com.google.common.base.e0.E(list);
            this.f20431b = (com.google.common.base.s) com.google.common.base.e0.E(sVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean b(Predicate predicate, Object obj) {
            return predicate.test(this.f20431b.apply(obj));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f20430a.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i7) {
            return this.f20431b.apply(this.f20430a.get(i7));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f20430a.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i7) {
            return new a(this.f20430a.listIterator(i7));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i7) {
            return this.f20431b.apply(this.f20430a.remove(i7));
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super T> predicate) {
            com.google.common.base.e0.E(predicate);
            return this.f20430a.removeIf(new Predicate() { // from class: com.google.common.collect.kb
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f20553a.b(predicate, obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f20430a.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class m<F, T> extends AbstractSequentialList<T> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f20433c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<F> f20434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.google.common.base.s<? super F, ? extends T> f20435b;

        class a extends vj<F, T> {
            a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.uj
            T a(F f8) {
                return m.this.f20435b.apply(f8);
            }
        }

        m(List<F> list, com.google.common.base.s<? super F, ? extends T> sVar) {
            this.f20434a = (List) com.google.common.base.e0.E(list);
            this.f20435b = (com.google.common.base.s) com.google.common.base.e0.E(sVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean b(Predicate predicate, Object obj) {
            return predicate.test(this.f20435b.apply(obj));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f20434a.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i7) {
            return new a(this.f20434a.listIterator(i7));
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super T> predicate) {
            com.google.common.base.e0.E(predicate);
            return this.f20434a.removeIf(new Predicate() { // from class: com.google.common.collect.lb
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f20588a.b(predicate, obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f20434a.size();
        }
    }

    private static class n<E> extends AbstractList<E> implements Serializable, RandomAccess {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f20437d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final E f20438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final E f20439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final E[] f20440c;

        n(E e8, E e9, E[] eArr) {
            this.f20438a = e8;
            this.f20439b = e9;
            this.f20440c = (E[]) ((Object[]) com.google.common.base.e0.E(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i7) {
            if (i7 == 0) {
                return this.f20438a;
            }
            if (i7 == 1) {
                return this.f20439b;
            }
            com.google.common.base.e0.C(i7, size());
            return this.f20440c[i7 - 2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.d.t(this.f20440c.length, 2);
        }
    }

    private ib() {
    }

    public static <T> List<List<T>> A(List<T> list, int i7) {
        com.google.common.base.e0.E(list);
        com.google.common.base.e0.d(i7 > 0);
        return list instanceof RandomAccess ? new h(list, i7) : new f(list, i7);
    }

    public static <T> List<T> B(List<T> list) {
        if (list instanceof d7) {
            return ((d7) list).O();
        }
        if (list instanceof j) {
            return ((j) list).b();
        }
        return list instanceof RandomAccess ? new i(list) : new j(list);
    }

    static <E> List<E> C(List<E> list, int i7, int i8) {
        return (list instanceof RandomAccess ? new a(list) : new b(list)).subList(i7, i8);
    }

    public static <F, T> List<T> D(List<F> list, com.google.common.base.s<? super F, ? extends T> sVar) {
        return list instanceof RandomAccess ? new l(list, sVar) : new m(list, sVar);
    }

    static <E> boolean a(List<E> list, int i7, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = list.listIterator(i7);
        Iterator<? extends E> it = iterable.iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            listIterator.add(it.next());
            z7 = true;
        }
        return z7;
    }

    public static <E> List<E> b(E e8, E e9, E[] eArr) {
        return new n(e8, e9, eArr);
    }

    public static <E> List<E> c(E e8, E[] eArr) {
        return new e(e8, eArr);
    }

    public static <B> List<List<B>> d(List<? extends List<? extends B>> list) {
        return u0.d(list);
    }

    @SafeVarargs
    public static <B> List<List<B>> e(List<? extends B>... listArr) {
        return d(Arrays.asList(listArr));
    }

    static <T> List<T> f(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static d7<Character> g(String str) {
        return new k((String) com.google.common.base.e0.E(str));
    }

    @s1.a
    public static List<Character> h(CharSequence charSequence) {
        return new d((CharSequence) com.google.common.base.e0.E(charSequence));
    }

    @s1.d
    static int i(int i7) {
        f2.b(i7, "arraySize");
        return com.google.common.primitives.c0.x(((long) i7) + 5 + ((long) (i7 / 10)));
    }

    static boolean j(List<?> list, Object obj) {
        if (obj == com.google.common.base.e0.E(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return ua.t(list.iterator(), list2.iterator());
        }
        for (int i7 = 0; i7 < size; i7++) {
            if (!com.google.common.base.y.a(list.get(i7), list2.get(i7))) {
                return false;
            }
        }
        return true;
    }

    static int k(List<?> list) {
        Iterator<?> it = list.iterator();
        int i7 = 1;
        while (it.hasNext()) {
            Object next = it.next();
            i7 = ~(~((i7 * 31) + (next == null ? 0 : next.hashCode())));
        }
        return i7;
    }

    static int l(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return m(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (com.google.common.base.y.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int m(List<?> list, Object obj) {
        int size = list.size();
        int i7 = 0;
        if (obj == null) {
            while (i7 < size) {
                if (list.get(i7) == null) {
                    return i7;
                }
                i7++;
            }
            return -1;
        }
        while (i7 < size) {
            if (obj.equals(list.get(i7))) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    static int n(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return o(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (com.google.common.base.y.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int o(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    static <E> ListIterator<E> p(List<E> list, int i7) {
        return new c(list).listIterator(i7);
    }

    @s1.b(serializable = true)
    public static <E> ArrayList<E> q() {
        return new ArrayList<>();
    }

    @s1.b(serializable = true)
    @u1.a
    public static <E> ArrayList<E> r(Iterable<? extends E> iterable) {
        com.google.common.base.e0.E(iterable);
        return iterable instanceof Collection ? new ArrayList<>(h3.b(iterable)) : s(iterable.iterator());
    }

    @s1.b(serializable = true)
    @u1.a
    public static <E> ArrayList<E> s(Iterator<? extends E> it) {
        ArrayList<E> arrayListQ = q();
        ua.a(arrayListQ, it);
        return arrayListQ;
    }

    @SafeVarargs
    @s1.b(serializable = true)
    @u1.a
    public static <E> ArrayList<E> t(E... eArr) {
        com.google.common.base.e0.E(eArr);
        ArrayList<E> arrayList = new ArrayList<>(i(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @s1.b(serializable = true)
    public static <E> ArrayList<E> u(int i7) {
        f2.b(i7, "initialArraySize");
        return new ArrayList<>(i7);
    }

    @s1.b(serializable = true)
    public static <E> ArrayList<E> v(int i7) {
        return new ArrayList<>(i(i7));
    }

    @s1.c
    public static <E> CopyOnWriteArrayList<E> w() {
        return new CopyOnWriteArrayList<>();
    }

    @s1.c
    public static <E> CopyOnWriteArrayList<E> x(Iterable<? extends E> iterable) {
        return new CopyOnWriteArrayList<>(iterable instanceof Collection ? h3.b(iterable) : r(iterable));
    }

    @s1.b(serializable = true)
    public static <E> LinkedList<E> y() {
        return new LinkedList<>();
    }

    @s1.b(serializable = true)
    public static <E> LinkedList<E> z(Iterable<? extends E> iterable) {
        LinkedList<E> linkedListY = y();
        ma.a(linkedListY, iterable);
        return linkedListY;
    }
}
