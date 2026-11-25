package com.google.common.collect;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
final class q2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class a<T> implements Spliterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Spliterator f20953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function f20954b;

        a(Spliterator spliterator, Function function) {
            this.f20953a = spliterator;
            this.f20954b = function;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(Consumer consumer, Function function, Object obj) {
            consumer.accept(function.apply(obj));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(Consumer consumer, Function function, Object obj) {
            consumer.accept(function.apply(obj));
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f20953a.characteristics() & (-262);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f20953a.estimateSize();
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> consumer) {
            Spliterator spliterator = this.f20953a;
            final Function function = this.f20954b;
            spliterator.forEachRemaining(new Consumer() { // from class: com.google.common.collect.o2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    q2.a.c(consumer, function, obj);
                }
            });
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            Spliterator spliterator = this.f20953a;
            final Function function = this.f20954b;
            return spliterator.tryAdvance(new Consumer() { // from class: com.google.common.collect.p2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    q2.a.d(consumer, function, obj);
                }
            });
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator spliteratorTrySplit = this.f20953a.trySplit();
            if (spliteratorTrySplit != null) {
                return q2.e(spliteratorTrySplit, this.f20954b);
            }
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements Spliterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Spliterator<T> f20955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Spliterator<F> f20956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f20957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f20958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function f20959e;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0000: IPUT (r6 I:java.util.function.Function), (r0 I:com.google.common.collect.q2$b) (LINE:1) com.google.common.collect.q2.b.e java.util.function.Function, block:B:2:0x0000 */
        b(Spliterator spliterator, Spliterator<T> spliterator2, Spliterator<F> spliterator3, int i7, long j7) {
            Function function;
            this.f20959e = function;
            this.f20955a = spliterator;
            this.f20956b = spliterator2;
            this.f20957c = spliterator3;
            this.f20958d = i7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(Function function, Consumer consumer, Object obj) {
            r2.a(function.apply(obj)).forEachRemaining(consumer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Function function, Object obj) {
            this.f20955a = r2.a(function.apply(obj));
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f20957c;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            Spliterator<T> spliterator = this.f20955a;
            if (spliterator != null) {
                this.f20958d = Math.max(this.f20958d, spliterator.estimateSize());
            }
            return Math.max(this.f20958d, 0L);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> consumer) {
            Spliterator<T> spliterator = this.f20955a;
            if (spliterator != null) {
                spliterator.forEachRemaining(consumer);
                this.f20955a = null;
            }
            Spliterator<F> spliterator2 = this.f20956b;
            final Function function = this.f20959e;
            spliterator2.forEachRemaining(new Consumer() { // from class: com.google.common.collect.s2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    q2.b.c(function, consumer, obj);
                }
            });
            this.f20958d = 0L;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            Spliterator<F> spliterator;
            final Function function;
            do {
                Spliterator<T> spliterator2 = this.f20955a;
                if (spliterator2 != null && spliterator2.tryAdvance(consumer)) {
                    long j7 = this.f20958d;
                    if (j7 == Long.MAX_VALUE) {
                        return true;
                    }
                    this.f20958d = j7 - 1;
                    return true;
                }
                this.f20955a = null;
                spliterator = this.f20956b;
                function = this.f20959e;
            } while (spliterator.tryAdvance(new Consumer() { // from class: com.google.common.collect.t2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f21100a.d(function, obj);
                }
            }));
            return false;
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator spliteratorTrySplit = this.f20956b.trySplit();
            if (spliteratorTrySplit == null) {
                Spliterator<T> spliterator = this.f20955a;
                if (spliterator == null) {
                    return null;
                }
                this.f20955a = null;
                return spliterator;
            }
            int i7 = this.f20957c & (-65);
            long jEstimateSize = estimateSize();
            if (jEstimateSize < Long.MAX_VALUE) {
                jEstimateSize /= 2;
                this.f20958d -= jEstimateSize;
                this.f20957c = i7;
            }
            b bVar = new b(this.f20955a, spliteratorTrySplit, i7, jEstimateSize, this.f20959e);
            this.f20955a = null;
            return bVar;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class c<T> implements Spliterator<T>, Consumer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        T f20960a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Spliterator f20961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Predicate f20962c;

        c(Spliterator spliterator, Predicate predicate) {
            this.f20961b = spliterator;
            this.f20962c = predicate;
        }

        @Override // java.util.function.Consumer
        public void accept(T t7) {
            this.f20960a = t7;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f20961b.characteristics() & 277;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f20961b.estimateSize() / 2;
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            return this.f20961b.getComparator();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            while (this.f20961b.tryAdvance(this)) {
                try {
                    if (this.f20962c.test(this.f20960a)) {
                        consumer.accept(this.f20960a);
                        this.f20960a = null;
                        return true;
                    }
                    this.f20960a = null;
                } catch (Throwable th) {
                    this.f20960a = null;
                    throw th;
                }
            }
            return false;
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator spliteratorTrySplit = this.f20961b.trySplit();
            if (spliteratorTrySplit == null) {
                return null;
            }
            return q2.a(spliteratorTrySplit, this.f20962c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class d<T> implements Spliterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Spliterator.OfInt f20963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IntFunction f20964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f20965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f20966d;

        d(Spliterator.OfInt ofInt, IntFunction intFunction, int i7, Comparator comparator) {
            this.f20964b = intFunction;
            this.f20965c = i7;
            this.f20966d = comparator;
            this.f20963a = ofInt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(Consumer consumer, IntFunction intFunction, int i7) {
            consumer.accept(intFunction.apply(i7));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(Consumer consumer, IntFunction intFunction, int i7) {
            consumer.accept(intFunction.apply(i7));
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f20965c | 16464;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f20963a.estimateSize();
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> consumer) {
            Spliterator.OfInt ofInt = this.f20963a;
            final IntFunction intFunction = this.f20964b;
            ofInt.forEachRemaining(new IntConsumer() { // from class: com.google.common.collect.a3
                @Override // java.util.function.IntConsumer
                public final void accept(int i7) {
                    q2.d.c(consumer, intFunction, i7);
                }
            });
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            if (hasCharacteristics(4)) {
                return this.f20966d;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            Spliterator.OfInt ofInt = this.f20963a;
            final IntFunction intFunction = this.f20964b;
            return ofInt.tryAdvance(new IntConsumer() { // from class: com.google.common.collect.b3
                @Override // java.util.function.IntConsumer
                public final void accept(int i7) {
                    q2.d.d(consumer, intFunction, i7);
                }
            });
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator.OfInt ofIntTrySplit = this.f20963a.trySplit();
            if (ofIntTrySplit == null) {
                return null;
            }
            return new d(ofIntTrySplit, this.f20964b, this.f20965c, this.f20966d);
        }
    }

    private q2() {
    }

    static <T> Spliterator<T> a(Spliterator<T> spliterator, Predicate<? super T> predicate) {
        com.google.common.base.e0.E(spliterator);
        com.google.common.base.e0.E(predicate);
        return new c(spliterator, predicate);
    }

    static <F, T> Spliterator<T> b(Spliterator<F> spliterator, Function<? super F, Spliterator<T>> function, int i7, long j7) {
        com.google.common.base.e0.e((i7 & 16384) == 0, "flatMap does not support SUBSIZED characteristic");
        com.google.common.base.e0.e((i7 & 4) == 0, "flatMap does not support SORTED characteristic");
        com.google.common.base.e0.E(spliterator);
        com.google.common.base.e0.E(function);
        return new b(null, spliterator, i7, j7, function);
    }

    static <T> Spliterator<T> c(int i7, int i8, IntFunction<T> intFunction) {
        return d(i7, i8, intFunction, null);
    }

    static <T> Spliterator<T> d(int i7, int i8, IntFunction<T> intFunction, Comparator<? super T> comparator) {
        if (comparator != null) {
            com.google.common.base.e0.d((i8 & 4) != 0);
        }
        return new d(IntStream.range(0, i7).spliterator(), intFunction, i8, comparator);
    }

    static <F, T> Spliterator<T> e(Spliterator<F> spliterator, Function<? super F, ? extends T> function) {
        com.google.common.base.e0.E(spliterator);
        com.google.common.base.e0.E(function);
        return new a(spliterator, function);
    }
}
