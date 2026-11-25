package com.google.common.collect;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class ri {

    /* JADX INFO: Add missing generic type declarations: [R] */
    static class a<R> extends Spliterators.AbstractSpliterator<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f21004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterator f21005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BiFunction f21006c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j7, int i7, Iterator it, Iterator it2, BiFunction biFunction) {
            super(j7, i7);
            this.f21004a = it;
            this.f21005b = it2;
            this.f21006c = biFunction;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            if (!this.f21004a.hasNext() || !this.f21005b.hasNext()) {
                return false;
            }
            consumer.accept(this.f21006c.apply(this.f21004a.next(), this.f21005b.next()));
            return true;
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f21007a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        T f21008b = null;

        b() {
        }

        T a() {
            com.google.common.base.e0.g0(this.f21007a);
            return this.f21008b;
        }

        void b(T t7) {
            this.f21007a = true;
            this.f21008b = t7;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    class c<R, T> extends o<Spliterator<T>, R, c> implements Consumer<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f21009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ l f21010d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT (r4 I:com.google.common.collect.ri$l), (r0 I:com.google.common.collect.ri$c) (LINE:1) com.google.common.collect.ri.c.d com.google.common.collect.ri$l, block:B:2:0x0000 */
        c(Spliterator spliterator, Spliterator<T> spliterator2, long j7) {
            l lVar;
            super(spliterator, spliterator2);
            this.f21010d = lVar;
        }

        @Override // java.util.function.Consumer
        public void accept(T t7) {
            this.f21009c = t7;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ri.o
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public c a(Spliterator<T> spliterator, long j7) {
            return new c(spliterator, j7, this.f21010d);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            if (!this.f21029a.tryAdvance(this)) {
                return false;
            }
            try {
                l lVar = this.f21010d;
                T t7 = this.f21009c;
                long j7 = this.f21030b;
                this.f21030b = 1 + j7;
                consumer.accept(lVar.a(t7, j7));
                return true;
            } finally {
                this.f21009c = null;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    static class d<R> extends Spliterators.AbstractSpliterator<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f21011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterator f21012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f21013c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j7, int i7, Iterator it, l lVar) {
            super(j7, i7);
            this.f21012b = it;
            this.f21013c = lVar;
            this.f21011a = 0L;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            if (!this.f21012b.hasNext()) {
                return false;
            }
            l lVar = this.f21013c;
            Object next = this.f21012b.next();
            long j7 = this.f21011a;
            this.f21011a = 1 + j7;
            consumer.accept(lVar.a(next, j7));
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    class e<R> extends o<Spliterator.OfInt, R, e> implements IntConsumer, Spliterator<R> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21014c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ m f21015d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT (r4 I:com.google.common.collect.ri$m), (r0 I:com.google.common.collect.ri$e) (LINE:1) com.google.common.collect.ri.e.d com.google.common.collect.ri$m, block:B:2:0x0000 */
        e(Spliterator.OfInt ofInt, Spliterator.OfInt ofInt2, long j7) {
            m mVar;
            super(ofInt, ofInt2);
            this.f21015d = mVar;
        }

        @Override // com.google.common.collect.ri.o
        /* bridge */ /* synthetic */ o a(Spliterator spliterator, long j7) {
            return c(si.a(spliterator), j7);
        }

        @Override // java.util.function.IntConsumer
        public void accept(int i7) {
            this.f21014c = i7;
        }

        e c(Spliterator.OfInt ofInt, long j7) {
            return new e(ofInt, j7, this.f21015d);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            if (!si.a(this.f21029a).tryAdvance((IntConsumer) this)) {
                return false;
            }
            m mVar = this.f21015d;
            int i7 = this.f21014c;
            long j7 = this.f21030b;
            this.f21030b = 1 + j7;
            consumer.accept(mVar.a(i7, j7));
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    static class f<R> extends Spliterators.AbstractSpliterator<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f21016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrimitiveIterator.OfInt f21017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ m f21018c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(long j7, int i7, PrimitiveIterator.OfInt ofInt, m mVar) {
            super(j7, i7);
            this.f21017b = ofInt;
            this.f21018c = mVar;
            this.f21016a = 0L;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            if (!this.f21017b.hasNext()) {
                return false;
            }
            m mVar = this.f21018c;
            int iNextInt = this.f21017b.nextInt();
            long j7 = this.f21016a;
            this.f21016a = 1 + j7;
            consumer.accept(mVar.a(iNextInt, j7));
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    class g<R> extends o<Spliterator.OfLong, R, g> implements LongConsumer, Spliterator<R> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f21019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ n f21020d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT (r4 I:com.google.common.collect.ri$n), (r0 I:com.google.common.collect.ri$g) (LINE:1) com.google.common.collect.ri.g.d com.google.common.collect.ri$n, block:B:2:0x0000 */
        g(Spliterator.OfLong ofLong, Spliterator.OfLong ofLong2, long j7) {
            n nVar;
            super(ofLong, ofLong2);
            this.f21020d = nVar;
        }

        @Override // com.google.common.collect.ri.o
        /* bridge */ /* synthetic */ o a(Spliterator spliterator, long j7) {
            return c(vi.a(spliterator), j7);
        }

        @Override // java.util.function.LongConsumer
        public void accept(long j7) {
            this.f21019c = j7;
        }

        g c(Spliterator.OfLong ofLong, long j7) {
            return new g(ofLong, j7, this.f21020d);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            if (!vi.a(this.f21029a).tryAdvance((LongConsumer) this)) {
                return false;
            }
            n nVar = this.f21020d;
            long j7 = this.f21019c;
            long j8 = this.f21030b;
            this.f21030b = 1 + j8;
            consumer.accept(nVar.a(j7, j8));
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    static class h<R> extends Spliterators.AbstractSpliterator<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f21021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrimitiveIterator.OfLong f21022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n f21023c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j7, int i7, PrimitiveIterator.OfLong ofLong, n nVar) {
            super(j7, i7);
            this.f21022b = ofLong;
            this.f21023c = nVar;
            this.f21021a = 0L;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            if (!this.f21022b.hasNext()) {
                return false;
            }
            n nVar = this.f21023c;
            long jNextLong = this.f21022b.nextLong();
            long j7 = this.f21021a;
            this.f21021a = 1 + j7;
            consumer.accept(nVar.a(jNextLong, j7));
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    class i<R> extends o<Spliterator.OfDouble, R, i> implements DoubleConsumer, Spliterator<R> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        double f21024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f21025d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT (r4 I:com.google.common.collect.ri$k), (r0 I:com.google.common.collect.ri$i) (LINE:1) com.google.common.collect.ri.i.d com.google.common.collect.ri$k, block:B:2:0x0000 */
        i(Spliterator.OfDouble ofDouble, Spliterator.OfDouble ofDouble2, long j7) {
            k kVar;
            super(ofDouble, ofDouble2);
            this.f21025d = kVar;
        }

        @Override // com.google.common.collect.ri.o
        /* bridge */ /* synthetic */ o a(Spliterator spliterator, long j7) {
            return c(zi.a(spliterator), j7);
        }

        @Override // java.util.function.DoubleConsumer
        public void accept(double d8) {
            this.f21024c = d8;
        }

        i c(Spliterator.OfDouble ofDouble, long j7) {
            return new i(ofDouble, j7, this.f21025d);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            if (!zi.a(this.f21029a).tryAdvance((DoubleConsumer) this)) {
                return false;
            }
            k kVar = this.f21025d;
            double d8 = this.f21024c;
            long j7 = this.f21030b;
            this.f21030b = 1 + j7;
            consumer.accept(kVar.a(d8, j7));
            return true;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    static class j<R> extends Spliterators.AbstractSpliterator<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f21026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PrimitiveIterator.OfDouble f21027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f21028c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(long j7, int i7, PrimitiveIterator.OfDouble ofDouble, k kVar) {
            super(j7, i7);
            this.f21027b = ofDouble;
            this.f21028c = kVar;
            this.f21026a = 0L;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            if (!this.f21027b.hasNext()) {
                return false;
            }
            k kVar = this.f21028c;
            double dNextDouble = this.f21027b.nextDouble();
            long j7 = this.f21026a;
            this.f21026a = 1 + j7;
            consumer.accept(kVar.a(dNextDouble, j7));
            return true;
        }
    }

    @s1.a
    public interface k<R> {
        R a(double d8, long j7);
    }

    @s1.a
    public interface l<T, R> {
        R a(T t7, long j7);
    }

    @s1.a
    public interface m<R> {
        R a(int i7, long j7);
    }

    @s1.a
    public interface n<R> {
        R a(long j7, long j8);
    }

    private static abstract class o<F extends Spliterator<?>, R, S extends o<F, R, S>> implements Spliterator<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final F f21029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f21030b;

        o(F f8, long j7) {
            this.f21029a = f8;
            this.f21030b = j7;
        }

        abstract S a(F f8, long j7);

        @Override // java.util.Spliterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public S trySplit() {
            Spliterator spliteratorTrySplit = this.f21029a.trySplit();
            if (spliteratorTrySplit == null) {
                return null;
            }
            S s7 = (S) a(spliteratorTrySplit, this.f21030b);
            this.f21030b += spliteratorTrySplit.getExactSizeIfKnown();
            return s7;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f21029a.characteristics() & 16464;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f21029a.estimateSize();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class p<A, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final A f21031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final B f21032b;

        p(A a8, B b8) {
            this.f21031a = a8;
            this.f21032b = b8;
        }
    }

    private ri() {
    }

    public static IntStream A(OptionalInt optionalInt) {
        return optionalInt.isPresent() ? IntStream.of(optionalInt.getAsInt()) : IntStream.empty();
    }

    public static LongStream B(OptionalLong optionalLong) {
        return optionalLong.isPresent() ? LongStream.of(optionalLong.getAsLong()) : LongStream.empty();
    }

    public static <T> Stream<T> C(com.google.common.base.a0<T> a0Var) {
        return a0Var.f() ? Stream.of(a0Var.e()) : Stream.of(new Object[0]);
    }

    public static <T> Stream<T> D(Iterable<T> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).stream() : StreamSupport.stream(iterable.spliterator(), false);
    }

    @Deprecated
    public static <T> Stream<T> E(Collection<T> collection) {
        return collection.stream();
    }

    public static <T> Stream<T> F(Iterator<T> it) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 0), false);
    }

    public static <T> Stream<T> G(Optional<T> optional) {
        return optional.isPresent() ? Stream.of(optional.get()) : Stream.of(new Object[0]);
    }

    public static <A, B, R> Stream<R> H(final Stream<A> stream, final Stream<B> stream2, BiFunction<? super A, ? super B, R> biFunction) {
        com.google.common.base.e0.E(stream);
        com.google.common.base.e0.E(stream2);
        com.google.common.base.e0.E(biFunction);
        boolean z7 = stream.isParallel() || stream2.isParallel();
        Spliterator spliterator = stream.spliterator();
        Spliterator spliterator2 = stream2.spliterator();
        Stream stream3 = StreamSupport.stream(new a(Math.min(spliterator.estimateSize(), spliterator2.estimateSize()), spliterator.characteristics() & spliterator2.characteristics() & 80, Spliterators.iterator(spliterator), Spliterators.iterator(spliterator2), biFunction), z7);
        stream.getClass();
        Stream streamA = f7.a(stream3.onClose(new Runnable() { // from class: com.google.common.collect.zh
            @Override // java.lang.Runnable
            public final void run() {
                stream.close();
            }
        }));
        stream2.getClass();
        return f7.a(streamA.onClose(new Runnable() { // from class: com.google.common.collect.ai
            @Override // java.lang.Runnable
            public final void run() {
                stream2.close();
            }
        }));
    }

    public static DoubleStream g(DoubleStream... doubleStreamArr) {
        return Stream.of((Object[]) doubleStreamArr).flatMapToDouble(new Function() { // from class: com.google.common.collect.ni
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ri.t((DoubleStream) obj);
            }
        });
    }

    public static IntStream h(IntStream... intStreamArr) {
        return Stream.of((Object[]) intStreamArr).flatMapToInt(new Function() { // from class: com.google.common.collect.oi
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ri.r((IntStream) obj);
            }
        });
    }

    public static LongStream i(LongStream... longStreamArr) {
        return Stream.of((Object[]) longStreamArr).flatMapToLong(new Function() { // from class: com.google.common.collect.ei
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ri.s((LongStream) obj);
            }
        });
    }

    @SafeVarargs
    public static <T> Stream<T> j(final Stream<? extends T>... streamArr) {
        d7.b bVar = new d7.b(streamArr.length);
        long jW = 0;
        int iCharacteristics = 336;
        boolean zIsParallel = false;
        for (Stream<? extends T> stream : streamArr) {
            zIsParallel |= stream.isParallel();
            Spliterator spliterator = stream.spliterator();
            bVar.a(spliterator);
            iCharacteristics &= spliterator.characteristics();
            jW = com.google.common.math.f.w(jW, spliterator.estimateSize());
        }
        return f7.a(StreamSupport.stream(q2.b(bVar.e().spliterator(), new Function() { // from class: com.google.common.collect.ji
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ri.p((Spliterator) obj);
            }
        }, iCharacteristics, jW), zIsParallel).onClose(new Runnable() { // from class: com.google.common.collect.ki
            @Override // java.lang.Runnable
            public final void run() {
                ri.q(streamArr);
            }
        }));
    }

    public static <T> Optional<T> k(Stream<T> stream) {
        Spliterator spliteratorTrySplit;
        final b bVar = new b();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.addLast(stream.spliterator());
        while (!arrayDeque.isEmpty()) {
            Spliterator spliteratorA = r2.a(arrayDeque.removeLast());
            if (spliteratorA.getExactSizeIfKnown() != 0) {
                if (spliteratorA.hasCharacteristics(16384)) {
                    do {
                        spliteratorTrySplit = spliteratorA.trySplit();
                        if (spliteratorTrySplit == null || spliteratorTrySplit.getExactSizeIfKnown() == 0) {
                        }
                        spliteratorA.forEachRemaining(new Consumer() { // from class: com.google.common.collect.di
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                bVar.b(obj);
                            }
                        });
                        return Optional.of(bVar.a());
                    } while (spliteratorA.getExactSizeIfKnown() != 0);
                    spliteratorA = spliteratorTrySplit;
                    spliteratorA.forEachRemaining(new Consumer() { // from class: com.google.common.collect.di
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            bVar.b(obj);
                        }
                    });
                    return Optional.of(bVar.a());
                }
                Spliterator spliteratorTrySplit2 = spliteratorA.trySplit();
                if (spliteratorTrySplit2 == null || spliteratorTrySplit2.getExactSizeIfKnown() == 0) {
                    spliteratorA.forEachRemaining(new Consumer() { // from class: com.google.common.collect.di
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            bVar.b(obj);
                        }
                    });
                    if (bVar.f21007a) {
                        return Optional.of(bVar.a());
                    }
                } else {
                    arrayDeque.addLast(spliteratorTrySplit2);
                    arrayDeque.addLast(spliteratorA);
                }
            }
        }
        return Optional.empty();
    }

    public static OptionalDouble l(DoubleStream doubleStream) {
        Optional optionalK = k(doubleStream.boxed());
        return optionalK.isPresent() ? OptionalDouble.of(((Double) optionalK.get()).doubleValue()) : OptionalDouble.empty();
    }

    public static OptionalInt m(IntStream intStream) {
        Optional optionalK = k(intStream.boxed());
        return optionalK.isPresent() ? OptionalInt.of(((Integer) optionalK.get()).intValue()) : OptionalInt.empty();
    }

    public static OptionalLong n(LongStream longStream) {
        Optional optionalK = k(longStream.boxed());
        return optionalK.isPresent() ? OptionalLong.of(((Long) optionalK.get()).longValue()) : OptionalLong.empty();
    }

    public static <A, B> void o(Stream<A> stream, Stream<B> stream2, final BiConsumer<? super A, ? super B> biConsumer) {
        com.google.common.base.e0.E(biConsumer);
        if (stream.isParallel() || stream2.isParallel()) {
            H(stream, stream2, new BiFunction() { // from class: com.google.common.collect.bi
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return new ri.p(obj, obj2);
                }
            }).forEach(new Consumer() { // from class: com.google.common.collect.ci
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ri.u(biConsumer, (ri.p) obj);
                }
            });
            return;
        }
        Iterator it = stream.iterator();
        Iterator it2 = stream2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            biConsumer.accept(it.next(), it2.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator p(Spliterator spliterator) {
        return spliterator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(Stream[] streamArr) {
        for (Stream stream : streamArr) {
            stream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IntStream r(IntStream intStream) {
        return intStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LongStream s(LongStream longStream) {
        return longStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DoubleStream t(DoubleStream doubleStream) {
        return doubleStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(BiConsumer biConsumer, p pVar) {
        biConsumer.accept(pVar.f21031a, pVar.f21032b);
    }

    public static <R> Stream<R> v(final DoubleStream doubleStream, k<R> kVar) {
        com.google.common.base.e0.E(doubleStream);
        com.google.common.base.e0.E(kVar);
        boolean zIsParallel = doubleStream.isParallel();
        Spliterator.OfDouble ofDoubleSpliterator = doubleStream.spliterator();
        if (ofDoubleSpliterator.hasCharacteristics(16384)) {
            Stream stream = StreamSupport.stream(new i(ofDoubleSpliterator, 0L, kVar), zIsParallel);
            doubleStream.getClass();
            return f7.a(stream.onClose(new Runnable() { // from class: com.google.common.collect.fi
                @Override // java.lang.Runnable
                public final void run() {
                    doubleStream.close();
                }
            }));
        }
        Stream stream2 = StreamSupport.stream(new j(ofDoubleSpliterator.estimateSize(), ofDoubleSpliterator.characteristics() & 80, Spliterators.iterator(ofDoubleSpliterator), kVar), zIsParallel);
        doubleStream.getClass();
        return f7.a(stream2.onClose(new Runnable() { // from class: com.google.common.collect.gi
            @Override // java.lang.Runnable
            public final void run() {
                doubleStream.close();
            }
        }));
    }

    public static <R> Stream<R> w(final IntStream intStream, m<R> mVar) {
        com.google.common.base.e0.E(intStream);
        com.google.common.base.e0.E(mVar);
        boolean zIsParallel = intStream.isParallel();
        Spliterator.OfInt ofIntSpliterator = intStream.spliterator();
        if (ofIntSpliterator.hasCharacteristics(16384)) {
            Stream stream = StreamSupport.stream(new e(ofIntSpliterator, 0L, mVar), zIsParallel);
            intStream.getClass();
            return f7.a(stream.onClose(new Runnable() { // from class: com.google.common.collect.hi
                @Override // java.lang.Runnable
                public final void run() {
                    intStream.close();
                }
            }));
        }
        Stream stream2 = StreamSupport.stream(new f(ofIntSpliterator.estimateSize(), ofIntSpliterator.characteristics() & 80, Spliterators.iterator(ofIntSpliterator), mVar), zIsParallel);
        intStream.getClass();
        return f7.a(stream2.onClose(new Runnable() { // from class: com.google.common.collect.ii
            @Override // java.lang.Runnable
            public final void run() {
                intStream.close();
            }
        }));
    }

    public static <R> Stream<R> x(final LongStream longStream, n<R> nVar) {
        com.google.common.base.e0.E(longStream);
        com.google.common.base.e0.E(nVar);
        boolean zIsParallel = longStream.isParallel();
        Spliterator.OfLong ofLongSpliterator = longStream.spliterator();
        if (ofLongSpliterator.hasCharacteristics(16384)) {
            Stream stream = StreamSupport.stream(new g(ofLongSpliterator, 0L, nVar), zIsParallel);
            longStream.getClass();
            return f7.a(stream.onClose(new Runnable() { // from class: com.google.common.collect.pi
                @Override // java.lang.Runnable
                public final void run() {
                    longStream.close();
                }
            }));
        }
        Stream stream2 = StreamSupport.stream(new h(ofLongSpliterator.estimateSize(), ofLongSpliterator.characteristics() & 80, Spliterators.iterator(ofLongSpliterator), nVar), zIsParallel);
        longStream.getClass();
        return f7.a(stream2.onClose(new Runnable() { // from class: com.google.common.collect.qi
            @Override // java.lang.Runnable
            public final void run() {
                longStream.close();
            }
        }));
    }

    public static <T, R> Stream<R> y(final Stream<T> stream, l<? super T, ? extends R> lVar) {
        com.google.common.base.e0.E(stream);
        com.google.common.base.e0.E(lVar);
        boolean zIsParallel = stream.isParallel();
        Spliterator spliterator = stream.spliterator();
        if (spliterator.hasCharacteristics(16384)) {
            Stream stream2 = StreamSupport.stream(new c(spliterator, 0L, lVar), zIsParallel);
            stream.getClass();
            return f7.a(stream2.onClose(new Runnable() { // from class: com.google.common.collect.li
                @Override // java.lang.Runnable
                public final void run() {
                    stream.close();
                }
            }));
        }
        Stream stream3 = StreamSupport.stream(new d(spliterator.estimateSize(), spliterator.characteristics() & 80, Spliterators.iterator(spliterator), lVar), zIsParallel);
        stream.getClass();
        return f7.a(stream3.onClose(new Runnable() { // from class: com.google.common.collect.mi
            @Override // java.lang.Runnable
            public final void run() {
                stream.close();
            }
        }));
    }

    public static DoubleStream z(OptionalDouble optionalDouble) {
        return optionalDouble.isPresent() ? DoubleStream.of(optionalDouble.getAsDouble()) : DoubleStream.empty();
    }
}
