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
import java.util.function.LongConsumer;
import java.util.stream.LongStream;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.j
@s1.b
public final class y implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final y f22421d = new y(new long[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f22422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient int f22423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22424c;

    static class b extends AbstractList<Long> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final y f22425a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long get(int i7) {
            return Long.valueOf(this.f22425a.n(i7));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f22425a.equals(((b) obj).f22425a);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i7 = this.f22425a.f22423b;
            for (Object obj2 : list) {
                if (obj2 instanceof Long) {
                    int i8 = i7 + 1;
                    if (this.f22425a.f22422a[i7] == ((Long) obj2).longValue()) {
                        i7 = i8;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.f22425a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Long) {
                return this.f22425a.o(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return this.f22425a.r(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f22425a.t();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Long> spliterator() {
            return this.f22425a.C();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i7, int i8) {
            return this.f22425a.E(i7, i8).e();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.f22425a.toString();
        }

        private b(y yVar) {
            this.f22425a = yVar;
        }
    }

    @u1.a
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long[] f22426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f22427b = 0;

        c(int i7) {
            this.f22426a = new long[i7];
        }

        private void h(int i7) {
            int i8 = this.f22427b + i7;
            long[] jArr = this.f22426a;
            if (i8 > jArr.length) {
                long[] jArr2 = new long[i(jArr.length, i8)];
                System.arraycopy(this.f22426a, 0, jArr2, 0, this.f22427b);
                this.f22426a = jArr2;
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

        public c a(long j7) {
            h(1);
            long[] jArr = this.f22426a;
            int i7 = this.f22427b;
            jArr[i7] = j7;
            this.f22427b = i7 + 1;
            return this;
        }

        public c b(y yVar) {
            h(yVar.t());
            System.arraycopy(yVar.f22422a, yVar.f22423b, this.f22426a, this.f22427b, yVar.t());
            this.f22427b += yVar.t();
            return this;
        }

        public c c(Iterable<Long> iterable) {
            if (iterable instanceof Collection) {
                return d((Collection) iterable);
            }
            Iterator<Long> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next().longValue());
            }
            return this;
        }

        public c d(Collection<Long> collection) {
            h(collection.size());
            for (Long l7 : collection) {
                long[] jArr = this.f22426a;
                int i7 = this.f22427b;
                this.f22427b = i7 + 1;
                jArr[i7] = l7.longValue();
            }
            return this;
        }

        public c e(LongStream longStream) {
            Spliterator.OfLong ofLongSpliterator = longStream.spliterator();
            long exactSizeIfKnown = ofLongSpliterator.getExactSizeIfKnown();
            if (exactSizeIfKnown > 0) {
                h(c0.x(exactSizeIfKnown));
            }
            ofLongSpliterator.forEachRemaining(new LongConsumer() { // from class: com.google.common.primitives.b0
                @Override // java.util.function.LongConsumer
                public final void accept(long j7) {
                    this.f22310a.a(j7);
                }
            });
            return this;
        }

        public c f(long[] jArr) {
            h(jArr.length);
            System.arraycopy(jArr, 0, this.f22426a, this.f22427b, jArr.length);
            this.f22427b += jArr.length;
            return this;
        }

        @u1.b
        public y g() {
            if (this.f22427b == 0) {
                return y.f22421d;
            }
            return new y(this.f22426a, 0, this.f22427b);
        }
    }

    public static y A(long j7, long j8, long j9, long j10, long j11, long j12) {
        return new y(new long[]{j7, j8, j9, j10, j11, j12});
    }

    public static y B(long j7, long... jArr) {
        com.google.common.base.e0.e(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[jArr.length + 1];
        jArr2[0] = j7;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new y(jArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Spliterator.OfLong C() {
        return Spliterators.spliterator(this.f22422a, this.f22423b, this.f22424c, 1040);
    }

    public static c f() {
        return new c(10);
    }

    public static c g(int i7) {
        com.google.common.base.e0.k(i7 >= 0, "Invalid initialCapacity: %s", i7);
        return new c(i7);
    }

    public static y i(Iterable<Long> iterable) {
        return iterable instanceof Collection ? j((Collection) iterable) : f().c(iterable).g();
    }

    public static y j(Collection<Long> collection) {
        return collection.isEmpty() ? f22421d : new y(d0.z(collection));
    }

    public static y k(LongStream longStream) {
        long[] array = longStream.toArray();
        return array.length == 0 ? f22421d : new y(array);
    }

    public static y l(long[] jArr) {
        return jArr.length == 0 ? f22421d : new y(Arrays.copyOf(jArr, jArr.length));
    }

    private boolean q() {
        return this.f22423b > 0 || this.f22424c < this.f22422a.length;
    }

    public static y u() {
        return f22421d;
    }

    public static y v(long j7) {
        return new y(new long[]{j7});
    }

    public static y w(long j7, long j8) {
        return new y(new long[]{j7, j8});
    }

    public static y x(long j7, long j8, long j9) {
        return new y(new long[]{j7, j8, j9});
    }

    public static y y(long j7, long j8, long j9, long j10) {
        return new y(new long[]{j7, j8, j9, j10});
    }

    public static y z(long j7, long j8, long j9, long j10, long j11) {
        return new y(new long[]{j7, j8, j9, j10, j11});
    }

    public LongStream D() {
        return Arrays.stream(this.f22422a, this.f22423b, this.f22424c);
    }

    public y E(int i7, int i8) {
        com.google.common.base.e0.f0(i7, i8, t());
        if (i7 == i8) {
            return f22421d;
        }
        long[] jArr = this.f22422a;
        int i9 = this.f22423b;
        return new y(jArr, i7 + i9, i9 + i8);
    }

    public long[] F() {
        return Arrays.copyOfRange(this.f22422a, this.f22423b, this.f22424c);
    }

    public y H() {
        return q() ? new y(F()) : this;
    }

    public List<Long> e() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (t() != yVar.t()) {
            return false;
        }
        for (int i7 = 0; i7 < t(); i7++) {
            if (n(i7) != yVar.n(i7)) {
                return false;
            }
        }
        return true;
    }

    public boolean h(long j7) {
        return o(j7) >= 0;
    }

    public int hashCode() {
        int iK = 1;
        for (int i7 = this.f22423b; i7 < this.f22424c; i7++) {
            iK = (iK * 31) + d0.k(this.f22422a[i7]);
        }
        return iK;
    }

    public void m(LongConsumer longConsumer) {
        com.google.common.base.e0.E(longConsumer);
        for (int i7 = this.f22423b; i7 < this.f22424c; i7++) {
            longConsumer.accept(this.f22422a[i7]);
        }
    }

    public long n(int i7) {
        com.google.common.base.e0.C(i7, t());
        return this.f22422a[this.f22423b + i7];
    }

    public int o(long j7) {
        for (int i7 = this.f22423b; i7 < this.f22424c; i7++) {
            if (this.f22422a[i7] == j7) {
                return i7 - this.f22423b;
            }
        }
        return -1;
    }

    public boolean p() {
        return this.f22424c == this.f22423b;
    }

    public int r(long j7) {
        int i7;
        int i8 = this.f22424c;
        do {
            i8--;
            i7 = this.f22423b;
            if (i8 < i7) {
                return -1;
            }
        } while (this.f22422a[i8] != j7);
        return i8 - i7;
    }

    Object readResolve() {
        return p() ? f22421d : this;
    }

    public int t() {
        return this.f22424c - this.f22423b;
    }

    public String toString() {
        if (p()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(t() * 5);
        sb.append('[');
        sb.append(this.f22422a[this.f22423b]);
        int i7 = this.f22423b;
        while (true) {
            i7++;
            if (i7 >= this.f22424c) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.f22422a[i7]);
        }
    }

    Object writeReplace() {
        return H();
    }

    private y(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    private y(long[] jArr, int i7, int i8) {
        this.f22422a = jArr;
        this.f22423b = i7;
        this.f22424c = i8;
    }
}
