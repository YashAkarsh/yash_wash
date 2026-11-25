package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class af {

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class a<E> extends n<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f19869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f19870b;

        /* JADX INFO: renamed from: com.google.common.collect.af$a$a, reason: collision with other inner class name */
        class C0234a extends com.google.common.collect.e<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final Iterator<? extends E> f19871c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final Iterator<? extends E> f19872d;

            C0234a() {
                this.f19871c = a.this.f19869a.iterator();
                this.f19872d = a.this.f19870b.iterator();
            }

            @Override // com.google.common.collect.e
            protected E a() {
                if (this.f19871c.hasNext()) {
                    return this.f19871c.next();
                }
                while (this.f19872d.hasNext()) {
                    E next = this.f19872d.next();
                    if (!a.this.f19869a.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Set set, Set set2) {
            super(null);
            this.f19869a = set;
            this.f19870b = set2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean g(Set set, Object obj) {
            return !set.contains(obj);
        }

        @Override // com.google.common.collect.af.n
        public <S extends Set<E>> S a(S s7) {
            s7.addAll(this.f19869a);
            s7.addAll(this.f19870b);
            return s7;
        }

        @Override // com.google.common.collect.af.n
        public u8<E> b() {
            return new u8.a().c(this.f19869a).c(this.f19870b).e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f19869a.contains(obj) || this.f19870b.contains(obj);
        }

        @Override // com.google.common.collect.af.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ck<E> iterator() {
            return new C0234a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f19869a.isEmpty() && this.f19870b.isEmpty();
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return f7.a(stream().parallel());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.f19869a.size();
            Iterator<E> it = this.f19870b.iterator();
            while (it.hasNext()) {
                if (!this.f19869a.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            Stream stream = this.f19869a.stream();
            Stream stream2 = this.f19870b.stream();
            final Set set = this.f19869a;
            return Stream.concat(stream, stream2.filter(new Predicate() { // from class: com.google.common.collect.ze
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return af.a.g(set, obj);
                }
            }));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class b<E> extends n<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f19874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f19875b;

        class a extends com.google.common.collect.e<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final Iterator<E> f19876c;

            a() {
                this.f19876c = b.this.f19874a.iterator();
            }

            @Override // com.google.common.collect.e
            protected E a() {
                while (this.f19876c.hasNext()) {
                    E next = this.f19876c.next();
                    if (b.this.f19875b.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Set set, Set set2) {
            super(null);
            this.f19874a = set;
            this.f19875b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f19874a.contains(obj) && this.f19875b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f19874a.containsAll(collection) && this.f19875b.containsAll(collection);
        }

        @Override // com.google.common.collect.af.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: d */
        public ck<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.f19874a, this.f19875b);
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            Stream streamParallelStream = this.f19874a.parallelStream();
            Set set = this.f19875b;
            set.getClass();
            return streamParallelStream.filter(new cf(set));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f19874a.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                if (this.f19875b.contains(it.next())) {
                    i7++;
                }
            }
            return i7;
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            Stream stream = this.f19874a.stream();
            Set set = this.f19875b;
            set.getClass();
            return stream.filter(new cf(set));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class c<E> extends n<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f19878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f19879b;

        class a extends com.google.common.collect.e<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final Iterator<E> f19880c;

            a() {
                this.f19880c = c.this.f19878a.iterator();
            }

            @Override // com.google.common.collect.e
            protected E a() {
                while (this.f19880c.hasNext()) {
                    E next = this.f19880c.next();
                    if (!c.this.f19879b.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Set set, Set set2) {
            super(null);
            this.f19878a = set;
            this.f19879b = set2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean h(Set set, Object obj) {
            return !set.contains(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean j(Set set, Object obj) {
            return !set.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f19878a.contains(obj) && !this.f19879b.contains(obj);
        }

        @Override // com.google.common.collect.af.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: d */
        public ck<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f19879b.containsAll(this.f19878a);
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            Stream streamParallelStream = this.f19878a.parallelStream();
            final Set set = this.f19879b;
            return streamParallelStream.filter(new Predicate() { // from class: com.google.common.collect.df
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return af.c.h(set, obj);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f19878a.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                if (!this.f19879b.contains(it.next())) {
                    i7++;
                }
            }
            return i7;
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            Stream stream = this.f19878a.stream();
            final Set set = this.f19879b;
            return stream.filter(new Predicate() { // from class: com.google.common.collect.ef
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return af.c.j(set, obj);
                }
            });
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class d<E> extends n<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f19882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f19883b;

        class a extends com.google.common.collect.e<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f19884c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Iterator f19885d;

            a(Iterator it, Iterator it2) {
                this.f19884c = it;
                this.f19885d = it2;
            }

            @Override // com.google.common.collect.e
            public E a() {
                while (this.f19884c.hasNext()) {
                    E e8 = (E) this.f19884c.next();
                    if (!d.this.f19883b.contains(e8)) {
                        return e8;
                    }
                }
                while (this.f19885d.hasNext()) {
                    E e9 = (E) this.f19885d.next();
                    if (!d.this.f19882a.contains(e9)) {
                        return e9;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Set set, Set set2) {
            super(null);
            this.f19882a = set;
            this.f19883b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f19883b.contains(obj) ^ this.f19882a.contains(obj);
        }

        @Override // com.google.common.collect.af.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: d */
        public ck<E> iterator() {
            return new a(this.f19882a.iterator(), this.f19883b.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f19882a.equals(this.f19883b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f19882a.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                if (!this.f19883b.contains(it.next())) {
                    i7++;
                }
            }
            Iterator<E> it2 = this.f19883b.iterator();
            while (it2.hasNext()) {
                if (!this.f19882a.contains(it2.next())) {
                    i7++;
                }
            }
            return i7;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class e<E> extends AbstractSet<Set<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f19887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ v7 f19888b;

        class a extends com.google.common.collect.e<Set<E>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final BitSet f19889c;

            /* JADX INFO: renamed from: com.google.common.collect.af$e$a$a, reason: collision with other inner class name */
            class C0235a extends AbstractSet<E> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ BitSet f19891a;

                /* JADX INFO: renamed from: com.google.common.collect.af$e$a$a$a, reason: collision with other inner class name */
                class C0236a extends com.google.common.collect.e<E> {

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    int f19893c = -1;

                    C0236a() {
                    }

                    @Override // com.google.common.collect.e
                    protected E a() {
                        int iNextSetBit = C0235a.this.f19891a.nextSetBit(this.f19893c + 1);
                        this.f19893c = iNextSetBit;
                        return iNextSetBit == -1 ? b() : e.this.f19888b.keySet().a().get(this.f19893c);
                    }
                }

                C0235a(BitSet bitSet) {
                    this.f19891a = bitSet;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    Integer num = (Integer) e.this.f19888b.get(obj);
                    return num != null && this.f19891a.get(num.intValue());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<E> iterator() {
                    return new C0236a();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return e.this.f19887a;
                }
            }

            a() {
                this.f19889c = new BitSet(e.this.f19888b.size());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Set<E> a() {
                if (this.f19889c.isEmpty()) {
                    this.f19889c.set(0, e.this.f19887a);
                } else {
                    int iNextSetBit = this.f19889c.nextSetBit(0);
                    int iNextClearBit = this.f19889c.nextClearBit(iNextSetBit);
                    if (iNextClearBit == e.this.f19888b.size()) {
                        return b();
                    }
                    int i7 = (iNextClearBit - iNextSetBit) - 1;
                    this.f19889c.set(0, i7);
                    this.f19889c.clear(i7, iNextClearBit);
                    this.f19889c.set(iNextClearBit);
                }
                return new C0235a((BitSet) this.f19889c.clone());
            }
        }

        e(int i7, v7 v7Var) {
            this.f19887a = i7;
            this.f19888b = v7Var;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            return set.size() == this.f19887a && this.f19888b.keySet().containsAll(set);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.math.d.a(this.f19888b.size(), this.f19887a);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "Sets.combinations(" + this.f19888b.keySet() + ", " + this.f19887a + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class f<E extends Enum<E>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Collector<Enum<?>, ?, u8<? extends Enum<?>>> f19895b = Collector.of(new Supplier() { // from class: com.google.common.collect.ff
            @Override // java.util.function.Supplier
            public final Object get() {
                return af.f.a();
            }
        }, new BiConsumer() { // from class: com.google.common.collect.gf
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((af.f) obj).b((Enum) obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.hf
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((af.f) obj).c((af.f) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.if
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((af.f) obj).d();
            }
        }, Collector.Characteristics.UNORDERED);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private EnumSet<E> f19896a;

        private f() {
        }

        public static /* synthetic */ f a() {
            return new f();
        }

        void b(E e8) {
            EnumSet<E> enumSet = this.f19896a;
            if (enumSet == null) {
                this.f19896a = EnumSet.of((Enum) e8);
            } else {
                enumSet.add(e8);
            }
        }

        f<E> c(f<E> fVar) {
            EnumSet<E> enumSet = this.f19896a;
            if (enumSet == null) {
                return fVar;
            }
            EnumSet<E> enumSet2 = fVar.f19896a;
            if (enumSet2 == null) {
                return this;
            }
            enumSet.addAll(enumSet2);
            return this;
        }

        u8<E> d() {
            EnumSet<E> enumSet = this.f19896a;
            return enumSet == null ? u8.A() : b7.M(enumSet);
        }
    }

    private static final class g<E> extends j5<List<E>> implements Set<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final transient d7<u8<E>> f19897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final transient u0<E> f19898b;

        static class a extends d7<List<E>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ d7 f19899c;

            a(d7 d7Var) {
                this.f19899c = d7Var;
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
            public List<E> get(int i7) {
                return ((u8) this.f19899c.get(i7)).a();
            }

            @Override // com.google.common.collect.x6
            boolean h() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return this.f19899c.size();
            }
        }

        private g(d7<u8<E>> d7Var, u0<E> u0Var) {
            this.f19897a = d7Var;
            this.f19898b = u0Var;
        }

        static <E> Set<List<E>> w0(List<? extends Set<? extends E>> list) {
            d7.b bVar = new d7.b(list.size());
            Iterator<? extends Set<? extends E>> it = list.iterator();
            while (it.hasNext()) {
                u8 u8VarP = u8.p(it.next());
                if (u8VarP.isEmpty()) {
                    return u8.A();
                }
                bVar.a(u8VarP);
            }
            d7<E> d7VarL = bVar.e();
            return new g(d7VarL, new u0(new a(d7VarL)));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.j5, com.google.common.collect.b6
        /* JADX INFO: renamed from: d0 */
        public Collection<List<E>> c0() {
            return this.f19898b;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return obj instanceof g ? this.f19897a.equals(((g) obj).f19897a) : super.equals(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int i7 = 1;
            int size = size() - 1;
            for (int i8 = 0; i8 < this.f19897a.size(); i8++) {
                size = ~(~(size * 31));
            }
            ck<u8<E>> ckVarJ = this.f19897a.iterator();
            while (ckVarJ.hasNext()) {
                u8<E> next = ckVarJ.next();
                i7 = ~(~((i7 * 31) + ((size() / next.size()) * next.hashCode())));
            }
            return ~(~(i7 + size));
        }
    }

    @s1.c
    static class h<E> extends a6<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableSet<E> f19900a;

        h(NavigableSet<E> navigableSet) {
            this.f19900a = navigableSet;
        }

        private static <T> td<T> O0(Comparator<T> comparator) {
            return td.i(comparator).F();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.a6, com.google.common.collect.h6
        /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<E> w0() {
            return this.f19900a;
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public E ceiling(E e8) {
            return this.f19900a.floor(e8);
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator = this.f19900a.comparator();
            return comparator == null ? td.A().F() : O0(comparator);
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return this.f19900a.iterator();
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return this.f19900a;
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet
        public E first() {
            return this.f19900a.last();
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public E floor(E e8) {
            return this.f19900a.ceiling(e8);
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public NavigableSet<E> headSet(E e8, boolean z7) {
            return this.f19900a.tailSet(e8, z7).descendingSet();
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public E higher(E e8) {
            return this.f19900a.lower(e8);
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Iterator<E> iterator() {
            return this.f19900a.descendingIterator();
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet
        public E last() {
            return this.f19900a.first();
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public E lower(E e8) {
            return this.f19900a.higher(e8);
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public E pollFirst() {
            return this.f19900a.pollLast();
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public E pollLast() {
            return this.f19900a.pollFirst();
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public NavigableSet<E> subSet(E e8, boolean z7, E e9, boolean z8) {
            return this.f19900a.subSet(e9, z8, e8, z7).descendingSet();
        }

        @Override // com.google.common.collect.a6, java.util.NavigableSet
        public NavigableSet<E> tailSet(E e8, boolean z7) {
            return this.f19900a.headSet(e8, z7).descendingSet();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return q0();
        }

        @Override // com.google.common.collect.b6
        public String toString() {
            return u0();
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E e8) {
            return G0(e8);
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E e8, E e9) {
            return A0(e8, e9);
        }

        @Override // com.google.common.collect.h6, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E e8) {
            return N0(e8);
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) t0(tArr);
        }
    }

    @s1.c
    private static class i<E> extends k<E> implements NavigableSet<E> {
        i(NavigableSet<E> navigableSet, com.google.common.base.g0<? super E> g0Var) {
            super(navigableSet, g0Var);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e8) {
            return (E) ma.r(k().tailSet(e8, true), this.f20349b, null);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return ua.x(k().descendingIterator(), this.f20349b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return af.h(k().descendingSet(), this.f20349b);
        }

        @Override // java.util.NavigableSet
        public E floor(E e8) {
            return (E) ua.A(k().headSet(e8, true).descendingIterator(), this.f20349b, null);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e8, boolean z7) {
            return af.h(k().headSet(e8, z7), this.f20349b);
        }

        @Override // java.util.NavigableSet
        public E higher(E e8) {
            return (E) ma.r(k().tailSet(e8, false), this.f20349b, null);
        }

        NavigableSet<E> k() {
            return (NavigableSet) this.f20348a;
        }

        @Override // com.google.common.collect.af.k, java.util.SortedSet
        public E last() {
            return (E) ua.z(k().descendingIterator(), this.f20349b);
        }

        @Override // java.util.NavigableSet
        public E lower(E e8) {
            return (E) ua.A(k().headSet(e8, false).descendingIterator(), this.f20349b, null);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) ma.I(k(), this.f20349b);
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) ma.I(k().descendingSet(), this.f20349b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e8, boolean z7, E e9, boolean z8) {
            return af.h(k().subSet(e8, z7, e9, z8), this.f20349b);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e8, boolean z7) {
            return af.h(k().tailSet(e8, z7), this.f20349b);
        }
    }

    private static class j<E> extends h3.a<E> implements Set<E> {
        j(Set<E> set, com.google.common.base.g0<? super E> g0Var) {
            super(set, g0Var);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return af.g(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return af.k(this);
        }
    }

    private static class k<E> extends j<E> implements SortedSet<E> {
        k(SortedSet<E> sortedSet, com.google.common.base.g0<? super E> g0Var) {
            super(sortedSet, g0Var);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.f20348a).comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) ua.z(this.f20348a.iterator(), this.f20349b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e8) {
            return new k(((SortedSet) this.f20348a).headSet(e8), this.f20349b);
        }

        public E last() {
            SortedSet sortedSetHeadSet = (SortedSet) this.f20348a;
            while (true) {
                E e8 = (Object) sortedSetHeadSet.last();
                if (this.f20349b.apply(e8)) {
                    return e8;
                }
                sortedSetHeadSet = sortedSetHeadSet.headSet(e8);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e8, E e9) {
            return new k(((SortedSet) this.f20348a).subSet(e8, e9), this.f20349b);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e8) {
            return new k(((SortedSet) this.f20348a).tailSet(e8), this.f20349b);
        }
    }

    static abstract class l<E> extends AbstractSet<E> {
        l() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return af.I(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) com.google.common.base.e0.E(collection));
        }
    }

    private static final class m<E> extends AbstractSet<Set<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final v7<E, Integer> f19901a;

        class a extends com.google.common.collect.d<Set<E>> {
            a(int i7) {
                super(i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Set<E> a(int i7) {
                return new o(m.this.f19901a, i7);
            }
        }

        m(Set<E> set) {
            com.google.common.base.e0.k(set.size() <= 30, "Too many elements to create power set: %s > 30", set.size());
            this.f19901a = wb.V(set);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            return this.f19901a.keySet().containsAll((Set) obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return obj instanceof m ? this.f19901a.equals(((m) obj).f19901a) : super.equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f19901a.keySet().hashCode() << (this.f19901a.size() - 1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            return new a(size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1 << this.f19901a.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "powerSet(" + this.f19901a + ")";
        }
    }

    public static abstract class n<E> extends AbstractSet<E> {
        /* synthetic */ n(a aVar) {
            this();
        }

        @u1.a
        public <S extends Set<E>> S a(S s7) {
            s7.addAll(this);
            return s7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @u1.a
        @Deprecated
        public final boolean add(E e8) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @u1.a
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public u8<E> b() {
            return u8.p(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: d */
        public abstract ck<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @u1.a
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @u1.a
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        @u1.a
        @Deprecated
        public final boolean removeIf(Predicate<? super E> predicate) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @u1.a
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        private n() {
        }
    }

    private static final class o<E> extends AbstractSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v7<E, Integer> f19903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f19904b;

        class a extends ck<E> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final d7<E> f19905a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f19906b;

            a() {
                this.f19905a = o.this.f19903a.keySet().a();
                this.f19906b = o.this.f19904b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f19906b != 0;
            }

            @Override // java.util.Iterator
            public E next() {
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(this.f19906b);
                if (iNumberOfTrailingZeros == 32) {
                    throw new NoSuchElementException();
                }
                this.f19906b &= ~(1 << iNumberOfTrailingZeros);
                return this.f19905a.get(iNumberOfTrailingZeros);
            }
        }

        o(v7<E, Integer> v7Var, int i7) {
            this.f19903a = v7Var;
            this.f19904b = i7;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Integer num = this.f19903a.get(obj);
            if (num != null) {
                if (((1 << num.intValue()) & this.f19904b) != 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Integer.bitCount(this.f19904b);
        }
    }

    static final class p<E> extends h6<E> implements NavigableSet<E>, Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f19908d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableSet<E> f19909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SortedSet<E> f19910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private transient p<E> f19911c;

        p(NavigableSet<E> navigableSet) {
            this.f19909a = (NavigableSet) com.google.common.base.e0.E(navigableSet);
            this.f19910b = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e8) {
            return this.f19909a.ceiling(e8);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return ua.f0(this.f19909a.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            p<E> pVar = this.f19911c;
            if (pVar != null) {
                return pVar;
            }
            p<E> pVar2 = new p<>(this.f19909a.descendingSet());
            this.f19911c = pVar2;
            pVar2.f19911c = this;
            return pVar2;
        }

        @Override // java.util.NavigableSet
        public E floor(E e8) {
            return this.f19909a.floor(e8);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            this.f19909a.forEach(consumer);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e8, boolean z7) {
            return af.P(this.f19909a.headSet(e8, z7));
        }

        @Override // java.util.NavigableSet
        public E higher(E e8) {
            return this.f19909a.higher(e8);
        }

        @Override // java.util.NavigableSet
        public E lower(E e8) {
            return this.f19909a.lower(e8);
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return this.f19909a.parallelStream();
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> predicate) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return this.f19909a.stream();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e8, boolean z7, E e9, boolean z8) {
            return af.P(this.f19909a.subSet(e8, z7, e9, z8));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e8, boolean z7) {
            return af.P(this.f19909a.tailSet(e8, z7));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.h6, com.google.common.collect.d6
        /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public SortedSet<E> c0() {
            return this.f19910b;
        }
    }

    private af() {
    }

    public static <E> LinkedHashSet<E> A() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> B(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet<>(h3.b(iterable));
        }
        LinkedHashSet<E> linkedHashSetA = A();
        ma.a(linkedHashSetA, iterable);
        return linkedHashSetA;
    }

    public static <E> LinkedHashSet<E> C(int i7) {
        return new LinkedHashSet<>(wb.t(i7));
    }

    @Deprecated
    public static <E> Set<E> D(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E extends Comparable> TreeSet<E> E() {
        return new TreeSet<>();
    }

    public static <E extends Comparable> TreeSet<E> F(Iterable<? extends E> iterable) {
        TreeSet<E> treeSetE = E();
        ma.a(treeSetE, iterable);
        return treeSetE;
    }

    public static <E> TreeSet<E> G(Comparator<? super E> comparator) {
        return new TreeSet<>((Comparator) com.google.common.base.e0.E(comparator));
    }

    @s1.b(serializable = false)
    public static <E> Set<Set<E>> H(Set<E> set) {
        return new m(set);
    }

    static boolean I(Set<?> set, Collection<?> collection) {
        com.google.common.base.e0.E(collection);
        if (collection instanceof hd) {
            collection = ((hd) collection).e();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? J(set, collection.iterator()) : ua.V(set.iterator(), collection);
    }

    static boolean J(Set<?> set, Iterator<?> it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s1.a
    @s1.c
    public static <K extends Comparable<? super K>> NavigableSet<K> K(NavigableSet<K> navigableSet, xd<K> xdVar) {
        if (navigableSet.comparator() != null && navigableSet.comparator() != td.A() && xdVar.r() && xdVar.t()) {
            com.google.common.base.e0.e(navigableSet.comparator().compare(xdVar.A(), xdVar.M()) <= 0, "set is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (xdVar.r() && xdVar.t()) {
            Comparable comparableA = xdVar.A();
            s0 s0VarZ = xdVar.z();
            s0 s0Var = s0.CLOSED;
            return navigableSet.subSet(comparableA, s0VarZ == s0Var, xdVar.M(), xdVar.L() == s0Var);
        }
        if (xdVar.r()) {
            return navigableSet.tailSet(xdVar.A(), xdVar.z() == s0.CLOSED);
        }
        if (xdVar.t()) {
            return navigableSet.headSet(xdVar.M(), xdVar.L() == s0.CLOSED);
        }
        return (NavigableSet) com.google.common.base.e0.E(navigableSet);
    }

    public static <E> n<E> L(Set<? extends E> set, Set<? extends E> set2) {
        com.google.common.base.e0.F(set, "set1");
        com.google.common.base.e0.F(set2, "set2");
        return new d(set, set2);
    }

    @s1.c
    public static <E> NavigableSet<E> M(NavigableSet<E> navigableSet) {
        return dj.q(navigableSet);
    }

    @s1.a
    public static <E extends Enum<E>> Collector<E, ?, u8<E>> N() {
        return (Collector<E, ?, u8<E>>) f.f19895b;
    }

    public static <E> n<E> O(Set<? extends E> set, Set<? extends E> set2) {
        com.google.common.base.e0.F(set, "set1");
        com.google.common.base.e0.F(set2, "set2");
        return new a(set, set2);
    }

    public static <E> NavigableSet<E> P(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof x6) || (navigableSet instanceof p)) ? navigableSet : new p(navigableSet);
    }

    public static <B> Set<List<B>> a(List<? extends Set<? extends B>> list) {
        return g.w0(list);
    }

    @SafeVarargs
    public static <B> Set<List<B>> b(Set<? extends B>... setArr) {
        return a(Arrays.asList(setArr));
    }

    @s1.a
    public static <E> Set<Set<E>> c(Set<E> set, int i7) {
        v7 v7VarV = wb.V(set);
        f2.b(i7, "size");
        com.google.common.base.e0.m(i7 <= v7VarV.size(), "size (%s) must be <= set.size() (%s)", i7, v7VarV.size());
        if (i7 == 0) {
            return u8.B(u8.A());
        }
        return i7 == v7VarV.size() ? u8.B(v7VarV.keySet()) : new e(i7, v7VarV);
    }

    public static <E extends Enum<E>> EnumSet<E> d(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        com.google.common.base.e0.e(!collection.isEmpty(), "collection is empty; use the other version of this method");
        return o(collection, collection.iterator().next().getDeclaringClass());
    }

    public static <E extends Enum<E>> EnumSet<E> e(Collection<E> collection, Class<E> cls) {
        com.google.common.base.e0.E(collection);
        return collection instanceof EnumSet ? EnumSet.complementOf((EnumSet) collection) : o(collection, cls);
    }

    public static <E> n<E> f(Set<E> set, Set<?> set2) {
        com.google.common.base.e0.F(set, "set1");
        com.google.common.base.e0.F(set2, "set2");
        return new c(set, set2);
    }

    static boolean g(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s1.c
    public static <E> NavigableSet<E> h(NavigableSet<E> navigableSet, com.google.common.base.g0<? super E> g0Var) {
        if (!(navigableSet instanceof j)) {
            return new i((NavigableSet) com.google.common.base.e0.E(navigableSet), (com.google.common.base.g0) com.google.common.base.e0.E(g0Var));
        }
        j jVar = (j) navigableSet;
        return new i((NavigableSet) jVar.f20348a, com.google.common.base.h0.d(jVar.f20349b, g0Var));
    }

    public static <E> Set<E> i(Set<E> set, com.google.common.base.g0<? super E> g0Var) {
        if (set instanceof SortedSet) {
            return j((SortedSet) set, g0Var);
        }
        if (!(set instanceof j)) {
            return new j((Set) com.google.common.base.e0.E(set), (com.google.common.base.g0) com.google.common.base.e0.E(g0Var));
        }
        j jVar = (j) set;
        return new j((Set) jVar.f20348a, com.google.common.base.h0.d(jVar.f20349b, g0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> j(SortedSet<E> sortedSet, com.google.common.base.g0<? super E> g0Var) {
        if (!(sortedSet instanceof j)) {
            return new k((SortedSet) com.google.common.base.e0.E(sortedSet), (com.google.common.base.g0) com.google.common.base.e0.E(g0Var));
        }
        j jVar = (j) sortedSet;
        return new k((SortedSet) jVar.f20348a, com.google.common.base.h0.d(jVar.f20349b, g0Var));
    }

    static int k(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i7 = ~(~(i7 + (next != null ? next.hashCode() : 0)));
        }
        return i7;
    }

    @s1.b(serializable = true)
    public static <E extends Enum<E>> u8<E> l(E e8, E... eArr) {
        return b7.M(EnumSet.of((Enum) e8, (Enum[]) eArr));
    }

    @s1.b(serializable = true)
    public static <E extends Enum<E>> u8<E> m(Iterable<E> iterable) {
        if (iterable instanceof b7) {
            return (b7) iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return collection.isEmpty() ? u8.A() : b7.M(EnumSet.copyOf(collection));
        }
        Iterator<E> it = iterable.iterator();
        if (!it.hasNext()) {
            return u8.A();
        }
        EnumSet enumSetOf = EnumSet.of((Enum) it.next());
        ua.a(enumSetOf, it);
        return b7.M(enumSetOf);
    }

    public static <E> n<E> n(Set<E> set, Set<?> set2) {
        com.google.common.base.e0.F(set, "set1");
        com.google.common.base.e0.F(set2, "set2");
        return new b(set, set2);
    }

    private static <E extends Enum<E>> EnumSet<E> o(Collection<E> collection, Class<E> cls) {
        EnumSet<E> enumSetAllOf = EnumSet.allOf(cls);
        enumSetAllOf.removeAll(collection);
        return enumSetAllOf;
    }

    public static <E> Set<E> p() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> Set<E> q(Iterable<? extends E> iterable) {
        Set<E> setP = p();
        ma.a(setP, iterable);
        return setP;
    }

    @s1.c
    public static <E> CopyOnWriteArraySet<E> r() {
        return new CopyOnWriteArraySet<>();
    }

    @s1.c
    public static <E> CopyOnWriteArraySet<E> s(Iterable<? extends E> iterable) {
        return new CopyOnWriteArraySet<>(iterable instanceof Collection ? h3.b(iterable) : ib.r(iterable));
    }

    public static <E extends Enum<E>> EnumSet<E> t(Iterable<E> iterable, Class<E> cls) {
        EnumSet<E> enumSetNoneOf = EnumSet.noneOf(cls);
        ma.a(enumSetNoneOf, iterable);
        return enumSetNoneOf;
    }

    public static <E> HashSet<E> u() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> v(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? new HashSet<>(h3.b(iterable)) : w(iterable.iterator());
    }

    public static <E> HashSet<E> w(Iterator<? extends E> it) {
        HashSet<E> hashSetU = u();
        ua.a(hashSetU, it);
        return hashSetU;
    }

    public static <E> HashSet<E> x(E... eArr) {
        HashSet<E> hashSetY = y(eArr.length);
        Collections.addAll(hashSetY, eArr);
        return hashSetY;
    }

    public static <E> HashSet<E> y(int i7) {
        return new HashSet<>(wb.t(i7));
    }

    public static <E> Set<E> z() {
        return Collections.newSetFromMap(wb.l0());
    }
}
