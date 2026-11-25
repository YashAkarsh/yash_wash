package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public final class md {

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class a<E> extends n<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ hd f20626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ hd f20627d;

        /* JADX INFO: renamed from: com.google.common.collect.md$a$a, reason: collision with other inner class name */
        class C0249a extends com.google.common.collect.e<hd.a<E>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f20628c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Iterator f20629d;

            C0249a(Iterator it, Iterator it2) {
                this.f20628c = it;
                this.f20629d = it2;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public hd.a<E> a() {
                if (this.f20628c.hasNext()) {
                    hd.a aVar = (hd.a) this.f20628c.next();
                    Object element = aVar.getElement();
                    return md.m(element, Math.max(aVar.getCount(), a.this.f20627d.l0(element)));
                }
                while (this.f20629d.hasNext()) {
                    hd.a aVar2 = (hd.a) this.f20629d.next();
                    Object element2 = aVar2.getElement();
                    if (!a.this.f20626c.contains(element2)) {
                        return md.m(element2, aVar2.getCount());
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(hd hdVar, hd hdVar2) {
            super(null);
            this.f20626c = hdVar;
            this.f20627d = hdVar2;
        }

        @Override // com.google.common.collect.y
        Set<E> a() {
            return af.O(this.f20626c.e(), this.f20627d.e());
        }

        @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
        public boolean contains(Object obj) {
            return this.f20626c.contains(obj) || this.f20627d.contains(obj);
        }

        @Override // com.google.common.collect.y
        Iterator<E> f() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.y
        Iterator<hd.a<E>> g() {
            return new C0249a(this.f20626c.entrySet().iterator(), this.f20627d.entrySet().iterator());
        }

        @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f20626c.isEmpty() && this.f20627d.isEmpty();
        }

        @Override // com.google.common.collect.hd
        public int l0(Object obj) {
            return Math.max(this.f20626c.l0(obj), this.f20627d.l0(obj));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class b<E> extends n<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ hd f20631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ hd f20632d;

        class a extends com.google.common.collect.e<hd.a<E>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f20633c;

            a(Iterator it) {
                this.f20633c = it;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public hd.a<E> a() {
                while (this.f20633c.hasNext()) {
                    hd.a aVar = (hd.a) this.f20633c.next();
                    Object element = aVar.getElement();
                    int iMin = Math.min(aVar.getCount(), b.this.f20632d.l0(element));
                    if (iMin > 0) {
                        return md.m(element, iMin);
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(hd hdVar, hd hdVar2) {
            super(null);
            this.f20631c = hdVar;
            this.f20632d = hdVar2;
        }

        @Override // com.google.common.collect.y
        Set<E> a() {
            return af.n(this.f20631c.e(), this.f20632d.e());
        }

        @Override // com.google.common.collect.y
        Iterator<E> f() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.y
        Iterator<hd.a<E>> g() {
            return new a(this.f20631c.entrySet().iterator());
        }

        @Override // com.google.common.collect.hd
        public int l0(Object obj) {
            int iL0 = this.f20631c.l0(obj);
            if (iL0 == 0) {
                return 0;
            }
            return Math.min(iL0, this.f20632d.l0(obj));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class c<E> extends n<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ hd f20635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ hd f20636d;

        class a extends com.google.common.collect.e<hd.a<E>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f20637c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Iterator f20638d;

            a(Iterator it, Iterator it2) {
                this.f20637c = it;
                this.f20638d = it2;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public hd.a<E> a() {
                if (this.f20637c.hasNext()) {
                    hd.a aVar = (hd.a) this.f20637c.next();
                    Object element = aVar.getElement();
                    return md.m(element, aVar.getCount() + c.this.f20636d.l0(element));
                }
                while (this.f20638d.hasNext()) {
                    hd.a aVar2 = (hd.a) this.f20638d.next();
                    Object element2 = aVar2.getElement();
                    if (!c.this.f20635c.contains(element2)) {
                        return md.m(element2, aVar2.getCount());
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(hd hdVar, hd hdVar2) {
            super(null);
            this.f20635c = hdVar;
            this.f20636d = hdVar2;
        }

        @Override // com.google.common.collect.y
        Set<E> a() {
            return af.O(this.f20635c.e(), this.f20636d.e());
        }

        @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
        public boolean contains(Object obj) {
            return this.f20635c.contains(obj) || this.f20636d.contains(obj);
        }

        @Override // com.google.common.collect.y
        Iterator<E> f() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.y
        Iterator<hd.a<E>> g() {
            return new a(this.f20635c.entrySet().iterator(), this.f20636d.entrySet().iterator());
        }

        @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f20635c.isEmpty() && this.f20636d.isEmpty();
        }

        @Override // com.google.common.collect.hd
        public int l0(Object obj) {
            return this.f20635c.l0(obj) + this.f20636d.l0(obj);
        }

        @Override // com.google.common.collect.md.n, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
        public int size() {
            return com.google.common.math.d.t(this.f20635c.size(), this.f20636d.size());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class d<E> extends n<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ hd f20640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ hd f20641d;

        class a extends com.google.common.collect.e<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f20642c;

            a(Iterator it) {
                this.f20642c = it;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.google.common.collect.e
            protected E a() {
                while (this.f20642c.hasNext()) {
                    hd.a aVar = (hd.a) this.f20642c.next();
                    E e8 = (E) aVar.getElement();
                    if (aVar.getCount() > d.this.f20641d.l0(e8)) {
                        return e8;
                    }
                }
                return b();
            }
        }

        class b extends com.google.common.collect.e<hd.a<E>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Iterator f20644c;

            b(Iterator it) {
                this.f20644c = it;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public hd.a<E> a() {
                while (this.f20644c.hasNext()) {
                    hd.a aVar = (hd.a) this.f20644c.next();
                    Object element = aVar.getElement();
                    int count = aVar.getCount() - d.this.f20641d.l0(element);
                    if (count > 0) {
                        return md.m(element, count);
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(hd hdVar, hd hdVar2) {
            super(null);
            this.f20640c = hdVar;
            this.f20641d = hdVar2;
        }

        @Override // com.google.common.collect.md.n, com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.md.n, com.google.common.collect.y
        int d() {
            return ua.Z(g());
        }

        @Override // com.google.common.collect.y
        Iterator<E> f() {
            return new a(this.f20640c.entrySet().iterator());
        }

        @Override // com.google.common.collect.y
        Iterator<hd.a<E>> g() {
            return new b(this.f20640c.entrySet().iterator());
        }

        @Override // com.google.common.collect.hd
        public int l0(Object obj) {
            int iL0 = this.f20640c.l0(obj);
            if (iL0 == 0) {
                return 0;
            }
            return Math.max(0, iL0 - this.f20641d.l0(obj));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    static class e<E> extends uj<hd.a<E>, E> {
        e(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.uj
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(hd.a<E> aVar) {
            return aVar.getElement();
        }
    }

    static abstract class f<E> implements hd.a<E> {
        f() {
        }

        @Override // com.google.common.collect.hd.a
        public boolean equals(Object obj) {
            if (!(obj instanceof hd.a)) {
                return false;
            }
            hd.a aVar = (hd.a) obj;
            return getCount() == aVar.getCount() && com.google.common.base.y.a(getElement(), aVar.getElement());
        }

        @Override // com.google.common.collect.hd.a
        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.hd.a
        public String toString() {
            String strValueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            return strValueOf + " x " + count;
        }
    }

    private static final class g implements Comparator<hd.a<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final g f20646a = new g();

        private g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(hd.a<?> aVar, hd.a<?> aVar2) {
            return aVar2.getCount() - aVar.getCount();
        }
    }

    static abstract class h<E> extends af.l<E> {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return g().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return g().containsAll(collection);
        }

        abstract hd<E> g();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return g().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public abstract Iterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return g().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g().entrySet().size();
        }
    }

    static abstract class i<E> extends af.l<hd.a<E>> {
        i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof hd.a)) {
                return false;
            }
            hd.a aVar = (hd.a) obj;
            return aVar.getCount() > 0 && g().l0(aVar.getElement()) == aVar.getCount();
        }

        abstract hd<E> g();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof hd.a) {
                hd.a aVar = (hd.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return g().E(element, count, 0);
                }
            }
            return false;
        }
    }

    private static final class j<E> extends n<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final hd<E> f20647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final com.google.common.base.g0<? super E> f20648d;

        class a implements com.google.common.base.g0<hd.a<E>> {
            a() {
            }

            @Override // com.google.common.base.g0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(hd.a<E> aVar) {
                return j.this.f20648d.apply(aVar.getElement());
            }

            @Override // com.google.common.base.g0, java.util.function.Predicate
            public /* synthetic */ boolean test(Object obj) {
                return com.google.common.base.f0.a(this, obj);
            }
        }

        j(hd<E> hdVar, com.google.common.base.g0<? super E> g0Var) {
            super(null);
            this.f20647c = (hd) com.google.common.base.e0.E(hdVar);
            this.f20648d = (com.google.common.base.g0) com.google.common.base.e0.E(g0Var);
        }

        @Override // com.google.common.collect.y
        Set<E> a() {
            return af.i(this.f20647c.e(), this.f20648d);
        }

        @Override // com.google.common.collect.y, com.google.common.collect.hd
        public int add(E e8, int i7) {
            com.google.common.base.e0.y(this.f20648d.apply(e8), "Element %s does not match predicate %s", e8, this.f20648d);
            return this.f20647c.add(e8, i7);
        }

        @Override // com.google.common.collect.y
        Set<hd.a<E>> b() {
            return af.i(this.f20647c.entrySet(), new a());
        }

        @Override // com.google.common.collect.y
        Iterator<E> f() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.y
        Iterator<hd.a<E>> g() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.md.n, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.hd
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public ck<E> iterator() {
            return ua.x(this.f20647c.iterator(), this.f20648d);
        }

        @Override // com.google.common.collect.hd
        public int l0(Object obj) {
            int iL0 = this.f20647c.l0(obj);
            if (iL0 <= 0 || !this.f20648d.apply(obj)) {
                return 0;
            }
            return iL0;
        }

        @Override // com.google.common.collect.y, com.google.common.collect.hd
        public int remove(Object obj, int i7) {
            f2.b(i7, "occurrences");
            if (i7 == 0) {
                return l0(obj);
            }
            if (contains(obj)) {
                return this.f20647c.remove(obj, i7);
            }
            return 0;
        }
    }

    static class k<E> extends f<E> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f20650c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final E f20651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f20652b;

        k(E e8, int i7) {
            this.f20651a = e8;
            this.f20652b = i7;
            f2.b(i7, "count");
        }

        public k<E> a() {
            return null;
        }

        @Override // com.google.common.collect.hd.a
        public final int getCount() {
            return this.f20652b;
        }

        @Override // com.google.common.collect.hd.a
        public final E getElement() {
            return this.f20651a;
        }
    }

    static final class l<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final hd<E> f20653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterator<hd.a<E>> f20654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private hd.a<E> f20655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20657e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f20658f;

        l(hd<E> hdVar, Iterator<hd.a<E>> it) {
            this.f20653a = hdVar;
            this.f20654b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20656d > 0 || this.f20654b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (this.f20656d == 0) {
                hd.a<E> next = this.f20654b.next();
                this.f20655c = next;
                int count = next.getCount();
                this.f20656d = count;
                this.f20657e = count;
            }
            this.f20656d--;
            this.f20658f = true;
            return this.f20655c.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f20658f);
            if (this.f20657e == 1) {
                this.f20654b.remove();
            } else {
                this.f20653a.remove(this.f20655c.getElement());
            }
            this.f20657e--;
            this.f20658f = false;
        }
    }

    static class m<E> extends x5<E> implements Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f20659d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final hd<? extends E> f20660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        transient Set<E> f20661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        transient Set<hd.a<E>> f20662c;

        m(hd<? extends E> hdVar) {
            this.f20660a = hdVar;
        }

        @Override // com.google.common.collect.x5, com.google.common.collect.hd
        public boolean E(E e8, int i7, int i8) {
            throw new UnsupportedOperationException();
        }

        Set<E> F0() {
            return Collections.unmodifiableSet(this.f20660a.e());
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean add(E e8) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x5, com.google.common.collect.hd
        public Set<E> e() {
            Set<E> set = this.f20661b;
            if (set != null) {
                return set;
            }
            Set<E> setF0 = F0();
            this.f20661b = setF0;
            return setF0;
        }

        @Override // com.google.common.collect.x5, com.google.common.collect.hd
        public Set<hd.a<E>> entrySet() {
            Set<hd.a<E>> set = this.f20662c;
            if (set != null) {
                return set;
            }
            Set<hd.a<E>> setUnmodifiableSet = Collections.unmodifiableSet(this.f20660a.entrySet());
            this.f20662c = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Iterator<E> iterator() {
            return ua.f0(this.f20660a.iterator());
        }

        @Override // com.google.common.collect.j5, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.j5, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x5, com.google.common.collect.hd
        public int setCount(E e8, int i7) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.x5, com.google.common.collect.j5
        /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
        public hd<E> c0() {
            return this.f20660a;
        }

        @Override // com.google.common.collect.x5, com.google.common.collect.hd
        public int add(E e8, int i7) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.x5, com.google.common.collect.hd
        public int remove(Object obj, int i7) {
            throw new UnsupportedOperationException();
        }
    }

    private static abstract class n<E> extends y<E> {
        private n() {
        }

        @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            e().clear();
        }

        @Override // com.google.common.collect.y
        int d() {
            return e().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.hd
        public Iterator<E> iterator() {
            return md.p(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
        public int size() {
            return md.t(this);
        }

        /* synthetic */ n(a aVar) {
            this();
        }
    }

    private md() {
    }

    static <E> int A(hd<E> hdVar, E e8, int i7) {
        f2.b(i7, "count");
        int iL0 = hdVar.l0(e8);
        int i8 = i7 - iL0;
        if (i8 > 0) {
            hdVar.add(e8, i8);
        } else if (i8 < 0) {
            hdVar.remove(e8, -i8);
        }
        return iL0;
    }

    static <E> boolean B(hd<E> hdVar, E e8, int i7, int i8) {
        f2.b(i7, "oldCount");
        f2.b(i8, "newCount");
        if (hdVar.l0(e8) != i7) {
            return false;
        }
        hdVar.setCount(e8, i8);
        return true;
    }

    static <E> Spliterator<E> C(hd<E> hdVar) {
        Spliterator spliterator = hdVar.entrySet().spliterator();
        return q2.b(spliterator, new Function() { // from class: com.google.common.collect.kd
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return md.q((hd.a) obj);
            }
        }, (spliterator.characteristics() & 1296) | 64, hdVar.size());
    }

    @s1.a
    public static <E> hd<E> D(hd<? extends E> hdVar, hd<? extends E> hdVar2) {
        com.google.common.base.e0.E(hdVar);
        com.google.common.base.e0.E(hdVar2);
        return new c(hdVar, hdVar2);
    }

    public static <T, E, M extends hd<E>> Collector<T, ?, M> E(final Function<? super T, E> function, final ToIntFunction<? super T> toIntFunction, Supplier<M> supplier) {
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(toIntFunction);
        com.google.common.base.e0.E(supplier);
        return Collector.of(supplier, new BiConsumer() { // from class: com.google.common.collect.id
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                md.r(function, toIntFunction, (hd) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.jd
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return md.s((hd) obj, (hd) obj2);
            }
        }, new Collector.Characteristics[0]);
    }

    @s1.a
    public static <E> hd<E> F(hd<? extends E> hdVar, hd<? extends E> hdVar2) {
        com.google.common.base.e0.E(hdVar);
        com.google.common.base.e0.E(hdVar2);
        return new a(hdVar, hdVar2);
    }

    @Deprecated
    public static <E> hd<E> G(p8<E> p8Var) {
        return (hd) com.google.common.base.e0.E(p8Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> hd<E> H(hd<? extends E> hdVar) {
        return ((hdVar instanceof m) || (hdVar instanceof p8)) ? hdVar : new m((hd) com.google.common.base.e0.E(hdVar));
    }

    @s1.a
    public static <E> wf<E> I(wf<E> wfVar) {
        return new ek((wf) com.google.common.base.e0.E(wfVar));
    }

    private static <E> boolean d(final hd<E> hdVar, hd<? extends E> hdVar2) {
        if (hdVar2.isEmpty()) {
            return false;
        }
        hdVar.getClass();
        hdVar2.h0(new ObjIntConsumer() { // from class: com.google.common.collect.ld
            @Override // java.util.function.ObjIntConsumer
            public final void accept(Object obj, int i7) {
                hdVar.add(obj, i7);
            }
        });
        return true;
    }

    static <E> boolean e(hd<E> hdVar, Collection<? extends E> collection) {
        com.google.common.base.e0.E(hdVar);
        com.google.common.base.e0.E(collection);
        if (collection instanceof hd) {
            return d(hdVar, f(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return ua.a(hdVar, collection.iterator());
    }

    static <T> hd<T> f(Iterable<T> iterable) {
        return (hd) iterable;
    }

    @u1.a
    public static boolean g(hd<?> hdVar, hd<?> hdVar2) {
        com.google.common.base.e0.E(hdVar);
        com.google.common.base.e0.E(hdVar2);
        for (hd.a<?> aVar : hdVar2.entrySet()) {
            if (hdVar.l0(aVar.getElement()) < aVar.getCount()) {
                return false;
            }
        }
        return true;
    }

    @s1.a
    public static <E> p8<E> h(hd<E> hdVar) {
        hd.a[] aVarArr = (hd.a[]) hdVar.entrySet().toArray(new hd.a[0]);
        Arrays.sort(aVarArr, g.f20646a);
        return p8.r(Arrays.asList(aVarArr));
    }

    @s1.a
    public static <E> hd<E> i(hd<E> hdVar, hd<?> hdVar2) {
        com.google.common.base.e0.E(hdVar);
        com.google.common.base.e0.E(hdVar2);
        return new d(hdVar, hdVar2);
    }

    static <E> Iterator<E> j(Iterator<hd.a<E>> it) {
        return new e(it);
    }

    static boolean k(hd<?> hdVar, Object obj) {
        if (obj == hdVar) {
            return true;
        }
        if (obj instanceof hd) {
            hd hdVar2 = (hd) obj;
            if (hdVar.size() == hdVar2.size() && hdVar.entrySet().size() == hdVar2.entrySet().size()) {
                for (hd.a aVar : hdVar2.entrySet()) {
                    if (hdVar.l0(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @s1.a
    public static <E> hd<E> l(hd<E> hdVar, com.google.common.base.g0<? super E> g0Var) {
        if (!(hdVar instanceof j)) {
            return new j(hdVar, g0Var);
        }
        j jVar = (j) hdVar;
        return new j(jVar.f20647c, com.google.common.base.h0.d(jVar.f20648d, g0Var));
    }

    public static <E> hd.a<E> m(E e8, int i7) {
        return new k(e8, i7);
    }

    static int n(Iterable<?> iterable) {
        if (iterable instanceof hd) {
            return ((hd) iterable).e().size();
        }
        return 11;
    }

    public static <E> hd<E> o(hd<E> hdVar, hd<?> hdVar2) {
        com.google.common.base.e0.E(hdVar);
        com.google.common.base.e0.E(hdVar2);
        return new b(hdVar, hdVar2);
    }

    static <E> Iterator<E> p(hd<E> hdVar) {
        return new l(hdVar, hdVar.entrySet().iterator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator q(hd.a aVar) {
        return Collections.nCopies(aVar.getCount(), aVar.getElement()).spliterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(Function function, ToIntFunction toIntFunction, hd hdVar, Object obj) {
        hdVar.add(function.apply(obj), toIntFunction.applyAsInt(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ hd s(hd hdVar, hd hdVar2) {
        hdVar.addAll(hdVar2);
        return hdVar;
    }

    static int t(hd<?> hdVar) {
        Iterator<hd.a<?>> it = hdVar.entrySet().iterator();
        long count = 0;
        while (it.hasNext()) {
            count += (long) it.next().getCount();
        }
        return com.google.common.primitives.c0.x(count);
    }

    static boolean u(hd<?> hdVar, Collection<?> collection) {
        if (collection instanceof hd) {
            collection = ((hd) collection).e();
        }
        return hdVar.e().removeAll(collection);
    }

    @u1.a
    public static boolean v(hd<?> hdVar, hd<?> hdVar2) {
        com.google.common.base.e0.E(hdVar);
        com.google.common.base.e0.E(hdVar2);
        Iterator<hd.a<?>> it = hdVar.entrySet().iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            hd.a<?> next = it.next();
            int iL0 = hdVar2.l0(next.getElement());
            if (iL0 >= next.getCount()) {
                it.remove();
            } else if (iL0 > 0) {
                hdVar.remove(next.getElement(), iL0);
            }
            z7 = true;
        }
        return z7;
    }

    @u1.a
    public static boolean w(hd<?> hdVar, Iterable<?> iterable) {
        if (iterable instanceof hd) {
            return v(hdVar, (hd) iterable);
        }
        com.google.common.base.e0.E(hdVar);
        com.google.common.base.e0.E(iterable);
        Iterator<?> it = iterable.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= hdVar.remove(it.next());
        }
        return zRemove;
    }

    static boolean x(hd<?> hdVar, Collection<?> collection) {
        com.google.common.base.e0.E(collection);
        if (collection instanceof hd) {
            collection = ((hd) collection).e();
        }
        return hdVar.e().retainAll(collection);
    }

    @u1.a
    public static boolean y(hd<?> hdVar, hd<?> hdVar2) {
        return z(hdVar, hdVar2);
    }

    private static <E> boolean z(hd<E> hdVar, hd<?> hdVar2) {
        com.google.common.base.e0.E(hdVar);
        com.google.common.base.e0.E(hdVar2);
        Iterator<hd.a<E>> it = hdVar.entrySet().iterator();
        boolean z7 = false;
        while (it.hasNext()) {
            hd.a<E> next = it.next();
            int iL0 = hdVar2.l0(next.getElement());
            if (iL0 == 0) {
                it.remove();
            } else if (iL0 < next.getCount()) {
                hdVar.setCount(next.getElement(), iL0);
            }
            z7 = true;
        }
        return z7;
    }
}
