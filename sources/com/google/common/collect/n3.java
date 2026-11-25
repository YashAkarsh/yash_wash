package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
class n3<E> extends AbstractSet<E> implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f20693h = 1073741824;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f20694i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f20695j = 4294967295L;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f20696k = -4294967296L;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f20697l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f20698m = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient int[] f20699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient long[] f20700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient Object[] f20701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient float f20702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    transient int f20703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int f20704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient int f20705g;

    class a implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f20707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f20708c = -1;

        a() {
            this.f20706a = n3.this.f20703e;
            this.f20707b = n3.this.l();
        }

        private void a() {
            if (n3.this.f20703e != this.f20706a) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20707b >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i7 = this.f20707b;
            this.f20708c = i7;
            n3 n3Var = n3.this;
            E e8 = (E) n3Var.f20701c[i7];
            this.f20707b = n3Var.o(i7);
            return e8;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            f2.e(this.f20708c >= 0);
            this.f20706a++;
            n3 n3Var = n3.this;
            n3Var.remove(n3Var.f20701c[this.f20708c], n3.m(n3Var.f20700b[this.f20708c]));
            this.f20707b = n3.this.f(this.f20707b, this.f20708c);
            this.f20708c = -1;
        }
    }

    n3() {
        r(3, 1.0f);
    }

    private void A(int i7) {
        if (this.f20699a.length >= 1073741824) {
            this.f20704f = Integer.MAX_VALUE;
            return;
        }
        int i8 = ((int) (i7 * this.f20702d)) + 1;
        int[] iArrW = w(i7);
        long[] jArr = this.f20700b;
        int length = iArrW.length - 1;
        for (int i9 = 0; i9 < this.f20705g; i9++) {
            int iM = m(jArr[i9]);
            int i10 = iM & length;
            int i11 = iArrW[i10];
            iArrW[i10] = i9;
            jArr[i9] = (((long) iM) << 32) | (((long) i11) & f20695j);
        }
        this.f20704f = i8;
        this.f20699a = iArrW;
    }

    private static long B(long j7, int i7) {
        return (j7 & f20696k) | (f20695j & ((long) i7));
    }

    public static <E> n3<E> g() {
        return new n3<>();
    }

    public static <E> n3<E> h(Collection<? extends E> collection) {
        n3<E> n3VarK = k(collection.size());
        n3VarK.addAll(collection);
        return n3VarK;
    }

    public static <E> n3<E> j(E... eArr) {
        n3<E> n3VarK = k(eArr.length);
        Collections.addAll(n3VarK, eArr);
        return n3VarK;
    }

    public static <E> n3<E> k(int i7) {
        return new n3<>(i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(long j7) {
        return (int) (j7 >>> 32);
    }

    private static int n(long j7) {
        return (int) j7;
    }

    private int p() {
        return this.f20699a.length - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        r(3, 1.0f);
        int i7 = objectInputStream.readInt();
        while (true) {
            i7--;
            if (i7 < 0) {
                return;
            } else {
                add(objectInputStream.readObject());
            }
        }
    }

    private static long[] v(int i7) {
        long[] jArr = new long[i7];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] w(int i7) {
        int[] iArr = new int[i7];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f20705g);
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    private void z(int i7) {
        int length = this.f20700b.length;
        if (i7 > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            if (iMax != length) {
                x(iMax);
            }
        }
    }

    public void D() {
        int i7 = this.f20705g;
        if (i7 < this.f20700b.length) {
            x(i7);
        }
        int iMax = Math.max(1, Integer.highestOneBit((int) (i7 / this.f20702d)));
        if (iMax < 1073741824 && ((double) i7) / ((double) iMax) > this.f20702d) {
            iMax <<= 1;
        }
        if (iMax < this.f20699a.length) {
            A(iMax);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @u1.a
    public boolean add(E e8) {
        long[] jArr = this.f20700b;
        Object[] objArr = this.f20701c;
        int iD = s6.d(e8);
        int iP = p() & iD;
        int i7 = this.f20705g;
        int[] iArr = this.f20699a;
        int i8 = iArr[iP];
        if (i8 == -1) {
            iArr[iP] = i7;
        } else {
            while (true) {
                long j7 = jArr[i8];
                if (m(j7) == iD && com.google.common.base.y.a(e8, objArr[i8])) {
                    return false;
                }
                int iN = n(j7);
                if (iN == -1) {
                    jArr[i8] = B(j7, i7);
                    break;
                }
                i8 = iN;
            }
        }
        if (i7 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i9 = i7 + 1;
        z(i9);
        t(i7, e8, iD);
        this.f20705g = i9;
        if (i7 >= this.f20704f) {
            A(this.f20699a.length * 2);
        }
        this.f20703e++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f20703e++;
        Arrays.fill(this.f20701c, 0, this.f20705g, (Object) null);
        Arrays.fill(this.f20699a, -1);
        Arrays.fill(this.f20700b, -1L);
        this.f20705g = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        int iD = s6.d(obj);
        int iN = this.f20699a[p() & iD];
        while (iN != -1) {
            long j7 = this.f20700b[iN];
            if (m(j7) == iD && com.google.common.base.y.a(obj, this.f20701c[iN])) {
                return true;
            }
            iN = n(j7);
        }
        return false;
    }

    int f(int i7, int i8) {
        return i7 - 1;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        com.google.common.base.e0.E(consumer);
        for (int i7 = 0; i7 < this.f20705g; i7++) {
            consumer.accept(this.f20701c[i7]);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f20705g == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new a();
    }

    int l() {
        return isEmpty() ? -1 : 0;
    }

    int o(int i7) {
        int i8 = i7 + 1;
        if (i8 < this.f20705g) {
            return i8;
        }
        return -1;
    }

    void r(int i7, float f8) {
        com.google.common.base.e0.e(i7 >= 0, "Initial capacity must be non-negative");
        com.google.common.base.e0.e(f8 > 0.0f, "Illegal load factor");
        int iA = s6.a(i7, f8);
        this.f20699a = w(iA);
        this.f20702d = f8;
        this.f20701c = new Object[i7];
        this.f20700b = v(i7);
        this.f20704f = Math.max(1, (int) (iA * f8));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @u1.a
    public boolean remove(Object obj) {
        return remove(obj, s6.d(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f20705g;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.f20701c, 0, this.f20705g, 17);
    }

    void t(int i7, E e8, int i8) {
        this.f20700b[i7] = (((long) i8) << 32) | f20695j;
        this.f20701c[i7] = e8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.f20701c, this.f20705g);
    }

    void u(int i7) {
        int size = size() - 1;
        if (i7 >= size) {
            this.f20701c[i7] = null;
            this.f20700b[i7] = -1;
            return;
        }
        Object[] objArr = this.f20701c;
        objArr[i7] = objArr[size];
        objArr[size] = null;
        long[] jArr = this.f20700b;
        long j7 = jArr[size];
        jArr[i7] = j7;
        jArr[size] = -1;
        int iM = m(j7) & p();
        int[] iArr = this.f20699a;
        int i8 = iArr[iM];
        if (i8 == size) {
            iArr[iM] = i7;
            return;
        }
        while (true) {
            long j8 = this.f20700b[i8];
            int iN = n(j8);
            if (iN == size) {
                this.f20700b[i8] = B(j8, i7);
                return;
            }
            i8 = iN;
        }
    }

    void x(int i7) {
        this.f20701c = Arrays.copyOf(this.f20701c, i7);
        long[] jArr = this.f20700b;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i7);
        if (i7 > length) {
            Arrays.fill(jArrCopyOf, length, i7, -1L);
        }
        this.f20700b = jArrCopyOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @u1.a
    public boolean remove(Object obj, int i7) {
        int iP = p() & i7;
        int i8 = this.f20699a[iP];
        if (i8 == -1) {
            return false;
        }
        int i9 = -1;
        while (true) {
            if (m(this.f20700b[i8]) == i7 && com.google.common.base.y.a(obj, this.f20701c[i8])) {
                if (i9 == -1) {
                    this.f20699a[iP] = n(this.f20700b[i8]);
                } else {
                    long[] jArr = this.f20700b;
                    jArr[i9] = B(jArr[i9], n(jArr[i8]));
                }
                u(i8);
                this.f20705g--;
                this.f20703e++;
                return true;
            }
            int iN = n(this.f20700b[i8]);
            if (iN == -1) {
                return false;
            }
            i9 = i8;
            i8 = iN;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @u1.a
    public <T> T[] toArray(T[] tArr) {
        return (T[]) sd.n(this.f20701c, 0, this.f20705g, tArr);
    }

    n3(int i7) {
        r(i7, 1.0f);
    }
}
