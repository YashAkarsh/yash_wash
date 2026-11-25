package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public abstract class q9<E> extends r9<E> implements wf<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @v1.b
    transient q9<E> f20977e;

    public static class a<E> extends p8.b<E> {
        public a(Comparator<? super E> comparator) {
            super(yj.A((Comparator) com.google.common.base.e0.E(comparator)));
        }

        @Override // com.google.common.collect.p8.b
        @u1.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e8) {
            super.a(e8);
            return this;
        }

        @Override // com.google.common.collect.p8.b
        @u1.a
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a<E> b(E... eArr) {
            super.b(eArr);
            return this;
        }

        @Override // com.google.common.collect.p8.b
        @u1.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public a<E> c(Iterable<? extends E> iterable) {
            super.c(iterable);
            return this;
        }

        @Override // com.google.common.collect.p8.b
        @u1.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public a<E> d(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        @Override // com.google.common.collect.p8.b
        @u1.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public a<E> l(E e8, int i7) {
            super.l(e8, i7);
            return this;
        }

        @Override // com.google.common.collect.p8.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public q9<E> e() {
            return q9.p0((wf) this.f20888b);
        }

        @Override // com.google.common.collect.p8.b
        @u1.a
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public a<E> p(E e8, int i7) {
            super.p(e8, i7);
            return this;
        }
    }

    private static final class b<E> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Comparator<? super E> f20978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final E[] f20979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int[] f20980c;

        b(wf<E> wfVar) {
            this.f20978a = wfVar.comparator();
            int size = wfVar.entrySet().size();
            this.f20979b = (E[]) new Object[size];
            this.f20980c = new int[size];
            int i7 = 0;
            for (hd.a<E> aVar : wfVar.entrySet()) {
                this.f20979b[i7] = aVar.getElement();
                this.f20980c[i7] = aVar.getCount();
                i7++;
            }
        }

        Object readResolve() {
            int length = this.f20979b.length;
            a aVar = new a(this.f20978a);
            for (int i7 = 0; i7 < length; i7++) {
                aVar.l(this.f20979b[i7], this.f20980c[i7]);
            }
            return aVar.e();
        }
    }

    q9() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ hd A0(hd hdVar, hd hdVar2) {
        hdVar.addAll(hdVar2);
        return hdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ q9 B0(Comparator comparator, hd hdVar) {
        return q0(comparator, hdVar.entrySet());
    }

    public static <E extends Comparable<?>> a<E> C0() {
        return new a<>(td.A());
    }

    public static <E> q9<E> D0() {
        return (q9<E>) le.f20592k;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/q9<TE;>; */
    public static q9 E0(Comparable comparable) {
        return new le((me) s9.u0(comparable), new long[]{0, 1}, 0, 1);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/q9<TE;>; */
    public static q9 F0(Comparable comparable, Comparable comparable2) {
        return j0(td.A(), Arrays.asList(comparable, comparable2));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/q9<TE;>; */
    public static q9 G0(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return j0(td.A(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/q9<TE;>; */
    public static q9 H0(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return j0(td.A(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/q9<TE;>; */
    public static q9 I0(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return j0(td.A(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/q9<TE;>; */
    public static q9 J0(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList arrayListU = ib.u(comparableArr.length + 6);
        Collections.addAll(arrayListU, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(arrayListU, comparableArr);
        return j0(td.A(), arrayListU);
    }

    public static <E> a<E> K0(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    public static <E extends Comparable<?>> a<E> L0() {
        return new a<>(td.A().F());
    }

    @s1.a
    public static <E> Collector<E, ?, q9<E>> O0(Comparator<? super E> comparator) {
        return P0(comparator, Function.identity(), new ToIntFunction() { // from class: com.google.common.collect.l9
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return q9.x0(obj);
            }
        });
    }

    public static <T, E> Collector<T, ?, q9<E>> P0(final Comparator<? super E> comparator, final Function<? super T, ? extends E> function, final ToIntFunction<? super T> toIntFunction) {
        com.google.common.base.e0.E(comparator);
        com.google.common.base.e0.E(function);
        com.google.common.base.e0.E(toIntFunction);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.m9
            @Override // java.util.function.Supplier
            public final Object get() {
                return yj.A(comparator);
            }
        }, new BiConsumer() { // from class: com.google.common.collect.n9
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                q9.z0(function, toIntFunction, (hd) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.o9
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return q9.A0((hd) obj, (hd) obj2);
            }
        }, new Function() { // from class: com.google.common.collect.p9
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return q9.B0(comparator, (hd) obj);
            }
        }, new Collector.Characteristics[0]);
    }

    public static <E> q9<E> i0(Iterable<? extends E> iterable) {
        return j0(td.A(), iterable);
    }

    public static <E> q9<E> j0(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof q9) {
            q9<E> q9Var = (q9) iterable;
            if (comparator.equals(q9Var.comparator())) {
                return q9Var.h() ? q0(comparator, q9Var.entrySet().a()) : q9Var;
            }
        }
        ArrayList arrayListR = ib.r(iterable);
        yj yjVarA = yj.A((Comparator) com.google.common.base.e0.E(comparator));
        ma.a(yjVarA, arrayListR);
        return q0(comparator, yjVarA.entrySet());
    }

    public static <E> q9<E> k0(Comparator<? super E> comparator, Iterator<? extends E> it) {
        com.google.common.base.e0.E(comparator);
        return new a(comparator).d(it).e();
    }

    public static <E> q9<E> m0(Iterator<? extends E> it) {
        return k0(td.A(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/q9<TE;>; */
    public static q9 n0(Comparable[] comparableArr) {
        return j0(td.A(), Arrays.asList(comparableArr));
    }

    public static <E> q9<E> p0(wf<E> wfVar) {
        return q0(wfVar.comparator(), ib.r(wfVar.entrySet()));
    }

    private static <E> q9<E> q0(Comparator<? super E> comparator, Collection<hd.a<E>> collection) {
        if (collection.isEmpty()) {
            return u0(comparator);
        }
        d7.b bVar = new d7.b(collection.size());
        long[] jArr = new long[collection.size() + 1];
        int i7 = 0;
        for (hd.a<E> aVar : collection) {
            bVar.a(aVar.getElement());
            int i8 = i7 + 1;
            jArr[i8] = jArr[i7] + ((long) aVar.getCount());
            i7 = i8;
        }
        return new le(new me(bVar.e(), comparator), jArr, 0, collection.size());
    }

    static <E> q9<E> u0(Comparator<? super E> comparator) {
        return td.A().equals(comparator) ? (q9<E>) le.f20592k : new le(comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int x0(Object obj) {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void z0(Function function, ToIntFunction toIntFunction, hd hdVar, Object obj) {
        hdVar.add(com.google.common.base.e0.E(function.apply(obj)), toIntFunction.applyAsInt(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.wf
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public q9<E> v0(E e8, s0 s0Var, E e9, s0 s0Var2) {
        com.google.common.base.e0.y(comparator().compare(e8, e9) <= 0, "Expected lowerBound <= upperBound but %s > %s", e8, e9);
        return o0(e8, s0Var).g0(e9, s0Var2);
    }

    @Override // com.google.common.collect.wf
    /* JADX INFO: renamed from: N0 */
    public abstract q9<E> o0(E e8, s0 s0Var);

    @Override // com.google.common.collect.wf, com.google.common.collect.qf
    public final Comparator<? super E> comparator() {
        return e().comparator();
    }

    @Override // com.google.common.collect.wf
    @u1.a
    @Deprecated
    public final hd.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.wf
    @u1.a
    @Deprecated
    public final hd.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.wf
    /* JADX INFO: renamed from: s0 */
    public q9<E> C() {
        q9<E> q9VarU0 = this.f20977e;
        if (q9VarU0 == null) {
            q9VarU0 = isEmpty() ? u0(td.i(comparator()).F()) : new m4<>(this);
            this.f20977e = q9VarU0;
        }
        return q9VarU0;
    }

    @Override // com.google.common.collect.p8
    /* JADX INFO: renamed from: t0 */
    public abstract s9<E> e();

    @Override // com.google.common.collect.wf
    /* JADX INFO: renamed from: w0 */
    public abstract q9<E> g0(E e8, s0 s0Var);

    @Override // com.google.common.collect.p8, com.google.common.collect.x6
    Object writeReplace() {
        return new b(this);
    }
}
