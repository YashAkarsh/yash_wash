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
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.j
@s1.b
public final class r implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final r f22413d = new r(new int[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f22414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient int f22415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22416c;

    static class b extends AbstractList<Integer> implements RandomAccess, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f22417a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(int i7) {
            return Integer.valueOf(this.f22417a.n(i7));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f22417a.equals(((b) obj).f22417a);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i7 = this.f22417a.f22415b;
            for (Object obj2 : list) {
                if (obj2 instanceof Integer) {
                    int i8 = i7 + 1;
                    if (this.f22417a.f22414a[i7] == ((Integer) obj2).intValue()) {
                        i7 = i8;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.f22417a.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.f22417a.o(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.f22417a.r(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f22417a.t();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.List
        public Spliterator<Integer> spliterator() {
            return this.f22417a.C();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i7, int i8) {
            return this.f22417a.E(i7, i8).e();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.f22417a.toString();
        }

        private b(r rVar) {
            this.f22417a = rVar;
        }
    }

    @u1.a
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f22418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f22419b = 0;

        c(int i7) {
            this.f22418a = new int[i7];
        }

        private void h(int i7) {
            int i8 = this.f22419b + i7;
            int[] iArr = this.f22418a;
            if (i8 > iArr.length) {
                int[] iArr2 = new int[i(iArr.length, i8)];
                System.arraycopy(this.f22418a, 0, iArr2, 0, this.f22419b);
                this.f22418a = iArr2;
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

        public c a(int i7) {
            h(1);
            int[] iArr = this.f22418a;
            int i8 = this.f22419b;
            iArr[i8] = i7;
            this.f22419b = i8 + 1;
            return this;
        }

        public c b(r rVar) {
            h(rVar.t());
            System.arraycopy(rVar.f22414a, rVar.f22415b, this.f22418a, this.f22419b, rVar.t());
            this.f22419b += rVar.t();
            return this;
        }

        public c c(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return d((Collection) iterable);
            }
            Iterator<Integer> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next().intValue());
            }
            return this;
        }

        public c d(Collection<Integer> collection) {
            h(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.f22418a;
                int i7 = this.f22419b;
                this.f22419b = i7 + 1;
                iArr[i7] = num.intValue();
            }
            return this;
        }

        public c e(IntStream intStream) {
            Spliterator.OfInt ofIntSpliterator = intStream.spliterator();
            long exactSizeIfKnown = ofIntSpliterator.getExactSizeIfKnown();
            if (exactSizeIfKnown > 0) {
                h(c0.x(exactSizeIfKnown));
            }
            ofIntSpliterator.forEachRemaining(new IntConsumer() { // from class: com.google.common.primitives.t
                @Override // java.util.function.IntConsumer
                public final void accept(int i7) {
                    this.f22420a.a(i7);
                }
            });
            return this;
        }

        public c f(int[] iArr) {
            h(iArr.length);
            System.arraycopy(iArr, 0, this.f22418a, this.f22419b, iArr.length);
            this.f22419b += iArr.length;
            return this;
        }

        @u1.b
        public r g() {
            if (this.f22419b == 0) {
                return r.f22413d;
            }
            return new r(this.f22418a, 0, this.f22419b);
        }
    }

    public static r A(int i7, int i8, int i9, int i10, int i11, int i12) {
        return new r(new int[]{i7, i8, i9, i10, i11, i12});
    }

    public static r B(int i7, int... iArr) {
        com.google.common.base.e0.e(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[0] = i7;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new r(iArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Spliterator.OfInt C() {
        return Spliterators.spliterator(this.f22414a, this.f22415b, this.f22416c, 1040);
    }

    public static c f() {
        return new c(10);
    }

    public static c g(int i7) {
        com.google.common.base.e0.k(i7 >= 0, "Invalid initialCapacity: %s", i7);
        return new c(i7);
    }

    public static r i(Iterable<Integer> iterable) {
        return iterable instanceof Collection ? j((Collection) iterable) : f().c(iterable).g();
    }

    public static r j(Collection<Integer> collection) {
        return collection.isEmpty() ? f22413d : new r(c0.B(collection));
    }

    public static r k(IntStream intStream) {
        int[] array = intStream.toArray();
        return array.length == 0 ? f22413d : new r(array);
    }

    public static r l(int[] iArr) {
        return iArr.length == 0 ? f22413d : new r(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean q() {
        return this.f22415b > 0 || this.f22416c < this.f22414a.length;
    }

    public static r u() {
        return f22413d;
    }

    public static r v(int i7) {
        return new r(new int[]{i7});
    }

    public static r w(int i7, int i8) {
        return new r(new int[]{i7, i8});
    }

    public static r x(int i7, int i8, int i9) {
        return new r(new int[]{i7, i8, i9});
    }

    public static r y(int i7, int i8, int i9, int i10) {
        return new r(new int[]{i7, i8, i9, i10});
    }

    public static r z(int i7, int i8, int i9, int i10, int i11) {
        return new r(new int[]{i7, i8, i9, i10, i11});
    }

    public IntStream D() {
        return Arrays.stream(this.f22414a, this.f22415b, this.f22416c);
    }

    public r E(int i7, int i8) {
        com.google.common.base.e0.f0(i7, i8, t());
        if (i7 == i8) {
            return f22413d;
        }
        int[] iArr = this.f22414a;
        int i9 = this.f22415b;
        return new r(iArr, i7 + i9, i9 + i8);
    }

    public int[] F() {
        return Arrays.copyOfRange(this.f22414a, this.f22415b, this.f22416c);
    }

    public r H() {
        return q() ? new r(F()) : this;
    }

    public List<Integer> e() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (t() != rVar.t()) {
            return false;
        }
        for (int i7 = 0; i7 < t(); i7++) {
            if (n(i7) != rVar.n(i7)) {
                return false;
            }
        }
        return true;
    }

    public boolean h(int i7) {
        return o(i7) >= 0;
    }

    public int hashCode() {
        int iL = 1;
        for (int i7 = this.f22415b; i7 < this.f22416c; i7++) {
            iL = (iL * 31) + c0.l(this.f22414a[i7]);
        }
        return iL;
    }

    public void m(IntConsumer intConsumer) {
        com.google.common.base.e0.E(intConsumer);
        for (int i7 = this.f22415b; i7 < this.f22416c; i7++) {
            intConsumer.accept(this.f22414a[i7]);
        }
    }

    public int n(int i7) {
        com.google.common.base.e0.C(i7, t());
        return this.f22414a[this.f22415b + i7];
    }

    public int o(int i7) {
        for (int i8 = this.f22415b; i8 < this.f22416c; i8++) {
            if (this.f22414a[i8] == i7) {
                return i8 - this.f22415b;
            }
        }
        return -1;
    }

    public boolean p() {
        return this.f22416c == this.f22415b;
    }

    public int r(int i7) {
        int i8;
        int i9 = this.f22416c;
        do {
            i9--;
            i8 = this.f22415b;
            if (i9 < i8) {
                return -1;
            }
        } while (this.f22414a[i9] != i7);
        return i9 - i8;
    }

    Object readResolve() {
        return p() ? f22413d : this;
    }

    public int t() {
        return this.f22416c - this.f22415b;
    }

    public String toString() {
        if (p()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(t() * 5);
        sb.append('[');
        sb.append(this.f22414a[this.f22415b]);
        int i7 = this.f22415b;
        while (true) {
            i7++;
            if (i7 >= this.f22416c) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.f22414a[i7]);
        }
    }

    Object writeReplace() {
        return H();
    }

    private r(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    private r(int[] iArr, int i7, int i8) {
        this.f22414a = iArr;
        this.f22415b = i7;
        this.f22416c = i8;
    }
}
