package kotlin.streams.jdk8;

import h5.h;
import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.collections.o;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.sequences.m;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "StreamsKt")
public final class d {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Stream f35275a;

        public a(Stream stream) {
            this.f35275a = stream;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<T> iterator() {
            Iterator<T> it = this.f35275a.iterator();
            l0.o(it, "iterator()");
            return it;
        }
    }

    public static final class b implements m<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IntStream f35276a;

        public b(IntStream intStream) {
            this.f35276a = intStream;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Integer> iterator() {
            PrimitiveIterator.OfInt it = this.f35276a.iterator();
            l0.o(it, "iterator()");
            return it;
        }
    }

    public static final class c implements m<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LongStream f35277a;

        public c(LongStream longStream) {
            this.f35277a = longStream;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Long> iterator() {
            PrimitiveIterator.OfLong it = this.f35277a.iterator();
            l0.o(it, "iterator()");
            return it;
        }
    }

    /* JADX INFO: renamed from: kotlin.streams.jdk8.d$d, reason: collision with other inner class name */
    public static final class C0439d implements m<Double> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DoubleStream f35278a;

        public C0439d(DoubleStream doubleStream) {
            this.f35278a = doubleStream;
        }

        @Override // kotlin.sequences.m
        @a7.d
        public Iterator<Double> iterator() {
            PrimitiveIterator.OfDouble it = this.f35278a.iterator();
            l0.o(it, "iterator()");
            return it;
        }
    }

    @a7.d
    @g1(version = "1.2")
    public static final m<Double> b(@a7.d DoubleStream doubleStream) {
        l0.p(doubleStream, "<this>");
        return new C0439d(doubleStream);
    }

    @a7.d
    @g1(version = "1.2")
    public static final m<Integer> c(@a7.d IntStream intStream) {
        l0.p(intStream, "<this>");
        return new b(intStream);
    }

    @a7.d
    @g1(version = "1.2")
    public static final m<Long> d(@a7.d LongStream longStream) {
        l0.p(longStream, "<this>");
        return new c(longStream);
    }

    @a7.d
    @g1(version = "1.2")
    public static final <T> m<T> e(@a7.d Stream<T> stream) {
        l0.p(stream, "<this>");
        return new a(stream);
    }

    @a7.d
    @g1(version = "1.2")
    public static final <T> Stream<T> f(@a7.d final m<? extends T> mVar) {
        l0.p(mVar, "<this>");
        Stream<T> stream = StreamSupport.stream(new Supplier() { // from class: kotlin.streams.jdk8.c
            @Override // java.util.function.Supplier
            public final Object get() {
                return d.g(mVar);
            }
        }, 16, false);
        l0.o(stream, "stream({ Spliterators.sp…literator.ORDERED, false)");
        return stream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Spliterator g(m this_asStream) {
        l0.p(this_asStream, "$this_asStream");
        return Spliterators.spliteratorUnknownSize(this_asStream.iterator(), 16);
    }

    @a7.d
    @g1(version = "1.2")
    public static final List<Double> h(@a7.d DoubleStream doubleStream) {
        l0.p(doubleStream, "<this>");
        double[] array = doubleStream.toArray();
        l0.o(array, "toArray()");
        return o.p(array);
    }

    @a7.d
    @g1(version = "1.2")
    public static final List<Integer> i(@a7.d IntStream intStream) {
        l0.p(intStream, "<this>");
        int[] array = intStream.toArray();
        l0.o(array, "toArray()");
        return o.r(array);
    }

    @a7.d
    @g1(version = "1.2")
    public static final List<Long> j(@a7.d LongStream longStream) {
        l0.p(longStream, "<this>");
        long[] array = longStream.toArray();
        l0.o(array, "toArray()");
        return o.s(array);
    }

    @a7.d
    @g1(version = "1.2")
    public static final <T> List<T> k(@a7.d Stream<T> stream) {
        l0.p(stream, "<this>");
        Object objCollect = stream.collect(Collectors.toList());
        l0.o(objCollect, "collect(Collectors.toList<T>())");
        return (List) objCollect;
    }
}
