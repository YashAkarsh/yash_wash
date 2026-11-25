package com.google.common.primitives;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.j
@s1.b
public final class j implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final j f22387d = new j(new double[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[] f22388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient int f22389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22390c;

    static class b extends AbstractList<Double> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f22391a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double get(int i7) {
            return Double.valueOf(this.f22391a.p(i7));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f22391a.equals(((b) obj).f22391a);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i7 = this.f22391a.f22389b;
            for (Object obj2 : list) {
                if (obj2 instanceof Double) {
                    int i8 = i7 + 1;
                    if (j.f(this.f22391a.f22388a[i7], ((Double) obj2).doubleValue())) {
                        i7 = i8;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.f22391a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Double) {
                return this.f22391a.q(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return this.f22391a.u(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f22391a.v();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Double> spliterator() {
            return this.f22391a.E();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i7, int i8) {
            return this.f22391a.H(i7, i8).g();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.f22391a.toString();
        }

        private b(j jVar) {
            this.f22391a = jVar;
        }
    }

    @u1.a
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double[] f22392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f22393b = 0;

        c(int i7) {
            this.f22392a = new double[i7];
        }

        private void h(int i7) {
            int i8 = this.f22393b + i7;
            double[] dArr = this.f22392a;
            if (i8 > dArr.length) {
                double[] dArr2 = new double[i(dArr.length, i8)];
                System.arraycopy(this.f22392a, 0, dArr2, 0, this.f22393b);
                this.f22392a = dArr2;
            }
        }

        private static int i(int i7, int i8) {
            if (i8 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i7 + (i7 >> 1) + 1;
            if (iHighestOneBit < i8) {
                iHighestOneBit = Integer.highestOneBit(i8 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        public c a(double d8) {
            h(1);
            double[] dArr = this.f22392a;
            int i7 = this.f22393b;
            dArr[i7] = d8;
            this.f22393b = i7 + 1;
            return this;
        }

        public c b(j jVar) {
            h(jVar.v());
            System.arraycopy(jVar.f22388a, jVar.f22389b, this.f22392a, this.f22393b, jVar.v());
            this.f22393b += jVar.v();
            return this;
        }

        public c c(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return d((Collection) iterable);
            }
            Iterator<Double> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next().doubleValue());
            }
            return this;
        }

        public c d(Collection<Double> collection) {
            h(collection.size());
            for (Double d8 : collection) {
                double[] dArr = this.f22392a;
                int i7 = this.f22393b;
                this.f22393b = i7 + 1;
                dArr[i7] = d8.doubleValue();
            }
            return this;
        }

        public c e(DoubleStream doubleStream) {
            Spliterator.OfDouble ofDoubleSpliterator = doubleStream.spliterator();
            long exactSizeIfKnown = ofDoubleSpliterator.getExactSizeIfKnown();
            if (exactSizeIfKnown > 0) {
                h(c0.x(exactSizeIfKnown));
            }
            ofDoubleSpliterator.forEachRemaining(new DoubleConsumer() { // from class: com.google.common.primitives.m
                @Override // java.util.function.DoubleConsumer
                public final void accept(double d8) {
                    this.f22406a.a(d8);
                }
            });
            return this;
        }

        public c f(double[] dArr) {
            h(dArr.length);
            System.arraycopy(dArr, 0, this.f22392a, this.f22393b, dArr.length);
            this.f22393b += dArr.length;
            return this;
        }

        @u1.b
        public j g() {
            if (this.f22393b == 0) {
                return j.f22387d;
            }
            return new j(this.f22392a, 0, this.f22393b);
        }
    }

    public static j A(double d8, double d9, double d10, double d11) {
        return new j(new double[]{d8, d9, d10, d11});
    }

    public static j B(double d8, double d9, double d10, double d11, double d12) {
        return new j(new double[]{d8, d9, d10, d11, d12});
    }

    public static j C(double d8, double d9, double d10, double d11, double d12, double d13) {
        return new j(new double[]{d8, d9, d10, d11, d12, d13});
    }

    public static j D(double d8, double... dArr) {
        com.google.common.base.e0.e(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[dArr.length + 1];
        dArr2[0] = d8;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new j(dArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Spliterator.OfDouble E() {
        return Spliterators.spliterator(this.f22388a, this.f22389b, this.f22390c, 1040);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(double d8, double d9) {
        return Double.doubleToLongBits(d8) == Double.doubleToLongBits(d9);
    }

    public static c h() {
        return new c(10);
    }

    public static c i(int i7) {
        com.google.common.base.e0.k(i7 >= 0, "Invalid initialCapacity: %s", i7);
        return new c(i7);
    }

    public static j k(Iterable<Double> iterable) {
        return iterable instanceof Collection ? l((Collection) iterable) : h().c(iterable).g();
    }

    public static j l(Collection<Double> collection) {
        return collection.isEmpty() ? f22387d : new j(e.z(collection));
    }

    public static j m(DoubleStream doubleStream) {
        double[] array = doubleStream.toArray();
        return array.length == 0 ? f22387d : new j(array);
    }

    public static j n(double[] dArr) {
        return dArr.length == 0 ? f22387d : new j(Arrays.copyOf(dArr, dArr.length));
    }

    private boolean t() {
        return this.f22389b > 0 || this.f22390c < this.f22388a.length;
    }

    public static j w() {
        return f22387d;
    }

    public static j x(double d8) {
        return new j(new double[]{d8});
    }

    public static j y(double d8, double d9) {
        return new j(new double[]{d8, d9});
    }

    public static j z(double d8, double d9, double d10) {
        return new j(new double[]{d8, d9, d10});
    }

    public DoubleStream F() {
        return Arrays.stream(this.f22388a, this.f22389b, this.f22390c);
    }

    public j H(int i7, int i8) {
        com.google.common.base.e0.f0(i7, i8, v());
        if (i7 == i8) {
            return f22387d;
        }
        double[] dArr = this.f22388a;
        int i9 = this.f22389b;
        return new j(dArr, i7 + i9, i9 + i8);
    }

    public double[] I() {
        return Arrays.copyOfRange(this.f22388a, this.f22389b, this.f22390c);
    }

    public j J() {
        return t() ? new j(I()) : this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (v() != jVar.v()) {
            return false;
        }
        for (int i7 = 0; i7 < v(); i7++) {
            if (!f(p(i7), jVar.p(i7))) {
                return false;
            }
        }
        return true;
    }

    public List<Double> g() {
        return new b();
    }

    public int hashCode() {
        int iJ = 1;
        for (int i7 = this.f22389b; i7 < this.f22390c; i7++) {
            iJ = (iJ * 31) + e.j(this.f22388a[i7]);
        }
        return iJ;
    }

    public boolean j(double d8) {
        return q(d8) >= 0;
    }

    public void o(DoubleConsumer doubleConsumer) {
        com.google.common.base.e0.E(doubleConsumer);
        for (int i7 = this.f22389b; i7 < this.f22390c; i7++) {
            doubleConsumer.accept(this.f22388a[i7]);
        }
    }

    public double p(int i7) {
        com.google.common.base.e0.C(i7, v());
        return this.f22388a[this.f22389b + i7];
    }

    public int q(double d8) {
        for (int i7 = this.f22389b; i7 < this.f22390c; i7++) {
            if (f(this.f22388a[i7], d8)) {
                return i7 - this.f22389b;
            }
        }
        return -1;
    }

    public boolean r() {
        return this.f22390c == this.f22389b;
    }

    Object readResolve() {
        return r() ? f22387d : this;
    }

    public String toString() {
        if (r()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(v() * 5);
        sb.append('[');
        sb.append(this.f22388a[this.f22389b]);
        int i7 = this.f22389b;
        while (true) {
            i7++;
            if (i7 >= this.f22390c) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.f22388a[i7]);
        }
    }

    public int u(double d8) {
        int i7 = this.f22390c;
        do {
            i7--;
            if (i7 < this.f22389b) {
                return -1;
            }
        } while (!f(this.f22388a[i7], d8));
        return i7 - this.f22389b;
    }

    public int v() {
        return this.f22390c - this.f22389b;
    }

    Object writeReplace() {
        return J();
    }

    private j(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    private j(double[] dArr, int i7, int i8) {
        this.f22388a = dArr;
        this.f22389b = i7;
        this.f22390c = i8;
    }
}
