package com.google.common.collect;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class ua {

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class a<T> extends ck<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Enumeration f21190a;

        a(Enumeration enumeration) {
            this.f21190a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21190a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f21190a.nextElement();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class b<T> implements Enumeration<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f21191a;

        b(Iterator it) {
            this.f21191a = it;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f21191a.hasNext();
        }

        @Override // java.util.Enumeration
        public T nextElement() {
            return (T) this.f21191a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class c<T> extends ck<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f21192a;

        c(Iterator it) {
            this.f21192a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21192a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f21192a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Iterator<T> f21193a = ua.w();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterable f21194b;

        d(Iterable iterable) {
            this.f21194b = iterable;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21193a.hasNext() || this.f21194b.iterator().hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f21193a.hasNext()) {
                Iterator<T> it = this.f21194b.iterator();
                this.f21193a = it;
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
            }
            return this.f21193a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f21193a.remove();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class e<T> extends ck<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21195a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object[] f21196b;

        e(Object[] objArr) {
            this.f21196b = objArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21195a < this.f21196b.length;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object[] objArr = this.f21196b;
            int i7 = this.f21195a;
            T t7 = (T) objArr[i7];
            objArr[i7] = null;
            this.f21195a = i7 + 1;
            return t7;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class f<T> extends ck<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f21197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f21198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f21199c;

        f(Iterator it, int i7, boolean z7) {
            this.f21197a = it;
            this.f21198b = i7;
            this.f21199c = z7;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object[] objArr = new Object[this.f21198b];
            int i7 = 0;
            while (i7 < this.f21198b && this.f21197a.hasNext()) {
                objArr[i7] = this.f21197a.next();
                i7++;
            }
            for (int i8 = i7; i8 < this.f21198b; i8++) {
                objArr[i8] = null;
            }
            List<T> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
            return (this.f21199c || i7 == this.f21198b) ? listUnmodifiableList : listUnmodifiableList.subList(0, i7);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21197a.hasNext();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class g<T> extends com.google.common.collect.e<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Iterator f21200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.g0 f21201d;

        g(Iterator it, com.google.common.base.g0 g0Var) {
            this.f21200c = it;
            this.f21201d = g0Var;
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
        protected T a() {
            while (this.f21200c.hasNext()) {
                T t7 = (T) this.f21200c.next();
                if (this.f21201d.apply(t7)) {
                    return t7;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    static class h<F, T> extends uj<F, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.s f21202b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Iterator it, com.google.common.base.s sVar) {
            super(it);
            this.f21202b = sVar;
        }

        @Override // com.google.common.collect.uj
        T a(F f8) {
            return (T) this.f21202b.apply(f8);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class i<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f21203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f21204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Iterator f21205c;

        i(int i7, Iterator it) {
            this.f21204b = i7;
            this.f21205c = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21203a < this.f21204b && this.f21205c.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f21203a++;
            return (T) this.f21205c.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f21205c.remove();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class j<T> extends ck<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f21206a;

        j(Iterator it) {
            this.f21206a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21206a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            T t7 = (T) this.f21206a.next();
            this.f21206a.remove();
            return t7;
        }

        public String toString() {
            return "Iterators.consumingIterator(...)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class k<T> extends ck<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f21207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f21208b;

        k(Object obj) {
            this.f21208b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f21207a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f21207a) {
                throw new NoSuchElementException();
            }
            this.f21207a = true;
            return (T) this.f21208b;
        }
    }

    private static final class l<T> extends com.google.common.collect.d<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final dk<Object> f21209e = new l(new Object[0], 0, 0, 0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final T[] f21210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f21211d;

        l(T[] tArr, int i7, int i8, int i9) {
            super(i8, i9);
            this.f21210c = tArr;
            this.f21211d = i7;
        }

        @Override // com.google.common.collect.d
        protected T a(int i7) {
            return this.f21210c[this.f21211d + i7];
        }
    }

    private static class m<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterator<? extends T> f21212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Iterator<? extends T> f21213b = ua.u();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Iterator<? extends Iterator<? extends T>> f21214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Deque<Iterator<? extends Iterator<? extends T>>> f21215d;

        m(Iterator<? extends Iterator<? extends T>> it) {
            this.f21214c = (Iterator) com.google.common.base.e0.E(it);
        }

        private Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.f21214c;
                if (it != null && it.hasNext()) {
                    return this.f21214c;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f21215d;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.f21214c = this.f21215d.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) com.google.common.base.e0.E(this.f21213b)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> itA = a();
                this.f21214c = itA;
                if (itA == null) {
                    return false;
                }
                Iterator<? extends T> next = itA.next();
                this.f21213b = next;
                if (next instanceof m) {
                    m mVar = (m) next;
                    this.f21213b = mVar.f21213b;
                    if (this.f21215d == null) {
                        this.f21215d = new ArrayDeque();
                    }
                    this.f21215d.addFirst(this.f21214c);
                    if (mVar.f21215d != null) {
                        while (!mVar.f21215d.isEmpty()) {
                            this.f21215d.addFirst(mVar.f21215d.removeLast());
                        }
                    }
                    this.f21214c = mVar.f21214c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends T> it = this.f21213b;
            this.f21212a = it;
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f21212a != null);
            this.f21212a.remove();
            this.f21212a = null;
        }
    }

    private enum n implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(false);
        }
    }

    private static class o<T> extends ck<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Queue<ud<T>> f21218a;

        class a implements Comparator<ud<T>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Comparator f21219a;

            a(Comparator comparator) {
                this.f21219a = comparator;
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(ud<T> udVar, ud<T> udVar2) {
                return this.f21219a.compare(udVar.peek(), udVar2.peek());
            }
        }

        public o(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.f21218a = new PriorityQueue(2, new a(comparator));
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f21218a.add(ua.T(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f21218a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            ud<T> udVarRemove = this.f21218a.remove();
            T next = udVarRemove.next();
            if (udVarRemove.hasNext()) {
                this.f21218a.add(udVarRemove);
            }
            return next;
        }
    }

    private static class p<E> implements ud<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator<? extends E> f21221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f21222b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private E f21223c;

        public p(Iterator<? extends E> it) {
            this.f21221a = (Iterator) com.google.common.base.e0.E(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21222b || this.f21221a.hasNext();
        }

        @Override // com.google.common.collect.ud
        public E next() {
            if (!this.f21222b) {
                return this.f21221a.next();
            }
            E e8 = this.f21223c;
            this.f21222b = false;
            this.f21223c = null;
            return e8;
        }

        @Override // com.google.common.collect.ud
        public E peek() {
            if (!this.f21222b) {
                this.f21223c = this.f21221a.next();
                this.f21222b = true;
            }
            return this.f21223c;
        }

        @Override // com.google.common.collect.ud, java.util.Iterator
        public void remove() {
            com.google.common.base.e0.h0(!this.f21222b, "Can't remove after you've peeked at next");
            this.f21221a.remove();
        }
    }

    private ua() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    public static <T> T A(Iterator<? extends T> it, com.google.common.base.g0<? super T> g0Var, T t7) {
        com.google.common.base.e0.E(it);
        com.google.common.base.e0.E(g0Var);
        while (it.hasNext()) {
            T next = it.next();
            if (g0Var.apply(next)) {
                return next;
            }
        }
        return t7;
    }

    @SafeVarargs
    public static <T> ck<T> B(T... tArr) {
        return C(tArr, 0, tArr.length, 0);
    }

    static <T> dk<T> C(T[] tArr, int i7, int i8, int i9) {
        com.google.common.base.e0.d(i8 >= 0);
        com.google.common.base.e0.f0(i7, i7 + i8, tArr.length);
        com.google.common.base.e0.d0(i9, i8);
        return i8 == 0 ? v() : new l(tArr, i7, i8, i9);
    }

    public static <T> ck<T> D(Enumeration<T> enumeration) {
        com.google.common.base.e0.E(enumeration);
        return new a(enumeration);
    }

    public static int E(Iterator<?> it, Object obj) {
        int i7 = 0;
        while (q(it, obj)) {
            i7++;
        }
        return i7;
    }

    public static <T> T F(Iterator<T> it, int i7) {
        g(i7);
        int iB = b(it, i7);
        if (it.hasNext()) {
            return it.next();
        }
        throw new IndexOutOfBoundsException("position (" + i7 + ") must be less than the number of elements that remained (" + iB + ")");
    }

    public static <T> T G(Iterator<? extends T> it, int i7, T t7) {
        g(i7);
        b(it, i7);
        return (T) J(it, t7);
    }

    public static <T> T H(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T I(Iterator<? extends T> it, T t7) {
        return it.hasNext() ? (T) H(it) : t7;
    }

    public static <T> T J(Iterator<? extends T> it, T t7) {
        return it.hasNext() ? it.next() : t7;
    }

    @u1.a
    public static <T> T K(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i7 = 0; i7 < 4 && it.hasNext(); i7++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append(kotlin.text.h0.f35380f);
        throw new IllegalArgumentException(sb.toString());
    }

    @u1.a
    public static <T> T L(Iterator<? extends T> it, T t7) {
        return it.hasNext() ? (T) K(it) : t7;
    }

    public static <T> int M(Iterator<T> it, com.google.common.base.g0<? super T> g0Var) {
        com.google.common.base.e0.F(g0Var, "predicate");
        int i7 = 0;
        while (it.hasNext()) {
            if (g0Var.apply(it.next())) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public static <T> Iterator<T> N(Iterator<T> it, int i7) {
        com.google.common.base.e0.E(it);
        com.google.common.base.e0.e(i7 >= 0, "limit is negative");
        return new i(i7, it);
    }

    @s1.a
    public static <T> ck<T> O(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        com.google.common.base.e0.F(iterable, "iterators");
        com.google.common.base.e0.F(comparator, "comparator");
        return new o(iterable, comparator);
    }

    public static <T> ck<List<T>> P(Iterator<T> it, int i7) {
        return R(it, i7, true);
    }

    public static <T> ck<List<T>> Q(Iterator<T> it, int i7) {
        return R(it, i7, false);
    }

    private static <T> ck<List<T>> R(Iterator<T> it, int i7, boolean z7) {
        com.google.common.base.e0.E(it);
        com.google.common.base.e0.d(i7 > 0);
        return new f(it, i7, z7);
    }

    @Deprecated
    public static <T> ud<T> S(ud<T> udVar) {
        return (ud) com.google.common.base.e0.E(udVar);
    }

    public static <T> ud<T> T(Iterator<? extends T> it) {
        return it instanceof p ? (p) it : new p(it);
    }

    static <T> T U(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    @u1.a
    public static boolean V(Iterator<?> it, Collection<?> collection) {
        com.google.common.base.e0.E(collection);
        boolean z7 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    @u1.a
    public static <T> boolean W(Iterator<T> it, com.google.common.base.g0<? super T> g0Var) {
        com.google.common.base.e0.E(g0Var);
        boolean z7 = false;
        while (it.hasNext()) {
            if (g0Var.apply(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    @u1.a
    public static boolean X(Iterator<?> it, Collection<?> collection) {
        com.google.common.base.e0.E(collection);
        boolean z7 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z7 = true;
            }
        }
        return z7;
    }

    public static <T> ck<T> Y(T t7) {
        return new k(t7);
    }

    public static int Z(Iterator<?> it) {
        long j7 = 0;
        while (it.hasNext()) {
            it.next();
            j7++;
        }
        return com.google.common.primitives.c0.x(j7);
    }

    @u1.a
    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.google.common.base.e0.E(collection);
        com.google.common.base.e0.E(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    @s1.c
    public static <T> T[] a0(Iterator<? extends T> it, Class<T> cls) {
        return (T[]) ma.O(ib.s(it), cls);
    }

    @u1.a
    public static int b(Iterator<?> it, int i7) {
        com.google.common.base.e0.E(it);
        int i8 = 0;
        com.google.common.base.e0.e(i7 >= 0, "numberToAdvance must be nonnegative");
        while (i8 < i7 && it.hasNext()) {
            it.next();
            i8++;
        }
        return i8;
    }

    public static String b0(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z7 = true;
        while (it.hasNext()) {
            if (!z7) {
                sb.append(", ");
            }
            sb.append(it.next());
            z7 = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public static <T> boolean c(Iterator<T> it, com.google.common.base.g0<? super T> g0Var) {
        com.google.common.base.e0.E(g0Var);
        while (it.hasNext()) {
            if (!g0Var.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <F, T> Iterator<T> c0(Iterator<F> it, com.google.common.base.s<? super F, ? extends T> sVar) {
        com.google.common.base.e0.E(sVar);
        return new h(it, sVar);
    }

    public static <T> boolean d(Iterator<T> it, com.google.common.base.g0<? super T> g0Var) {
        return M(it, g0Var) != -1;
    }

    public static <T> com.google.common.base.a0<T> d0(Iterator<T> it, com.google.common.base.g0<? super T> g0Var) {
        com.google.common.base.e0.E(it);
        com.google.common.base.e0.E(g0Var);
        while (it.hasNext()) {
            T next = it.next();
            if (g0Var.apply(next)) {
                return com.google.common.base.a0.g(next);
            }
        }
        return com.google.common.base.a0.a();
    }

    public static <T> Enumeration<T> e(Iterator<T> it) {
        com.google.common.base.e0.E(it);
        return new b(it);
    }

    @Deprecated
    public static <T> ck<T> e0(ck<T> ckVar) {
        return (ck) com.google.common.base.e0.E(ckVar);
    }

    static <T> ListIterator<T> f(Iterator<T> it) {
        return (ListIterator) it;
    }

    public static <T> ck<T> f0(Iterator<? extends T> it) {
        com.google.common.base.e0.E(it);
        return it instanceof ck ? (ck) it : new c(it);
    }

    static void g(int i7) {
        if (i7 >= 0) {
            return;
        }
        throw new IndexOutOfBoundsException("position (" + i7 + ") must not be negative");
    }

    static void h(Iterator<?> it) {
        com.google.common.base.e0.E(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> i(Iterator<? extends Iterator<? extends T>> it) {
        return new m(it);
    }

    public static <T> Iterator<T> j(Iterator<? extends T> it, Iterator<? extends T> it2) {
        com.google.common.base.e0.E(it);
        com.google.common.base.e0.E(it2);
        return i(o(it, it2));
    }

    public static <T> Iterator<T> k(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3) {
        com.google.common.base.e0.E(it);
        com.google.common.base.e0.E(it2);
        com.google.common.base.e0.E(it3);
        return i(o(it, it2, it3));
    }

    public static <T> Iterator<T> l(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4) {
        com.google.common.base.e0.E(it);
        com.google.common.base.e0.E(it2);
        com.google.common.base.e0.E(it3);
        com.google.common.base.e0.E(it4);
        return i(o(it, it2, it3, it4));
    }

    public static <T> Iterator<T> m(Iterator<? extends T>... itArr) {
        return n((Iterator[]) Arrays.copyOf(itArr, itArr.length));
    }

    static <T> Iterator<T> n(Iterator<? extends T>... itArr) {
        for (Iterator it : (Iterator[]) com.google.common.base.e0.E(itArr)) {
            com.google.common.base.e0.E(it);
        }
        return i(o(itArr));
    }

    private static <T> Iterator<T> o(T... tArr) {
        return new e(tArr);
    }

    public static <T> Iterator<T> p(Iterator<T> it) {
        com.google.common.base.e0.E(it);
        return new j(it);
    }

    public static boolean q(Iterator<?> it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterator<T> r(Iterable<T> iterable) {
        com.google.common.base.e0.E(iterable);
        return new d(iterable);
    }

    @SafeVarargs
    public static <T> Iterator<T> s(T... tArr) {
        return r(ib.t(tArr));
    }

    public static boolean t(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.y.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    static <T> ck<T> u() {
        return v();
    }

    static <T> dk<T> v() {
        return (dk<T>) l.f21209e;
    }

    static <T> Iterator<T> w() {
        return n.INSTANCE;
    }

    public static <T> ck<T> x(Iterator<T> it, com.google.common.base.g0<? super T> g0Var) {
        com.google.common.base.e0.E(it);
        com.google.common.base.e0.E(g0Var);
        return new g(it, g0Var);
    }

    @s1.c
    public static <T> ck<T> y(Iterator<?> it, Class<T> cls) {
        return x(it, com.google.common.base.h0.o(cls));
    }

    public static <T> T z(Iterator<T> it, com.google.common.base.g0<? super T> g0Var) {
        com.google.common.base.e0.E(it);
        com.google.common.base.e0.E(g0Var);
        while (it.hasNext()) {
            T next = it.next();
            if (g0Var.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }
}
