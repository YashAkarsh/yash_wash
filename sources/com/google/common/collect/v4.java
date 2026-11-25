package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class v4<E extends Enum<E>> extends y<E> implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @s1.c
    private static final long f21251h = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Class<E> f21252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient E[] f21253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient int[] f21254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int f21255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient long f21256g;

    class a extends v4<E>.c<E> {
        a() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.v4.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(int i7) {
            return (E) v4.this.f21253d[i7];
        }
    }

    class b extends v4<E>.c<hd.a<E>> {

        class a extends md.f<E> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f21259a;

            a(int i7) {
                this.f21259a = i7;
            }

            @Override // com.google.common.collect.hd.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public E getElement() {
                return (E) v4.this.f21253d[this.f21259a];
            }

            @Override // com.google.common.collect.hd.a
            public int getCount() {
                return v4.this.f21254e[this.f21259a];
            }
        }

        b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.v4.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public hd.a<E> a(int i7) {
            return new a(i7);
        }
    }

    abstract class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21261a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f21262b = -1;

        c() {
        }

        abstract T a(int i7);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.f21261a < v4.this.f21253d.length) {
                int[] iArr = v4.this.f21254e;
                int i7 = this.f21261a;
                if (iArr[i7] > 0) {
                    return true;
                }
                this.f21261a = i7 + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tA = a(this.f21261a);
            int i7 = this.f21261a;
            this.f21262b = i7;
            this.f21261a = i7 + 1;
            return tA;
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f21262b >= 0);
            if (v4.this.f21254e[this.f21262b] > 0) {
                v4.k(v4.this);
                v4.this.f21256g -= (long) v4.this.f21254e[this.f21262b];
                v4.this.f21254e[this.f21262b] = 0;
            }
            this.f21262b = -1;
        }
    }

    private v4(Class<E> cls) {
        this.f21252c = cls;
        com.google.common.base.e0.d(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.f21253d = enumConstants;
        this.f21254e = new int[enumConstants.length];
    }

    static /* synthetic */ int k(v4 v4Var) {
        int i7 = v4Var.f21255f;
        v4Var.f21255f = i7 - 1;
        return i7;
    }

    public static <E extends Enum<E>> v4<E> p(Class<E> cls) {
        return new v4<>(cls);
    }

    public static <E extends Enum<E>> v4<E> r(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        com.google.common.base.e0.e(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        v4<E> v4Var = new v4<>(it.next().getDeclaringClass());
        ma.a(v4Var, iterable);
        return v4Var;
    }

    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.f21252c = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.f21253d = enumConstants;
        this.f21254e = new int[enumConstants.length];
        se.f(this, objectInputStream);
    }

    public static <E extends Enum<E>> v4<E> t(Iterable<E> iterable, Class<E> cls) {
        v4<E> v4VarP = p(cls);
        ma.a(v4VarP, iterable);
        return v4VarP;
    }

    private boolean u(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r7 = (Enum) obj;
        int iOrdinal = r7.ordinal();
        E[] eArr = this.f21253d;
        return iOrdinal < eArr.length && eArr[iOrdinal] == r7;
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f21252c);
        se.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.f21254e, 0);
        this.f21256g = 0L;
        this.f21255f = 0;
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.y
    int d() {
        return this.f21255f;
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ Set e() {
        return super.e();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.y
    Iterator<E> f() {
        return new a();
    }

    @Override // com.google.common.collect.y
    Iterator<hd.a<E>> g() {
        return new b();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    public void h0(ObjIntConsumer<? super E> objIntConsumer) {
        com.google.common.base.e0.E(objIntConsumer);
        int i7 = 0;
        while (true) {
            E[] eArr = this.f21253d;
            if (i7 >= eArr.length) {
                return;
            }
            int i8 = this.f21254e[i7];
            if (i8 > 0) {
                objIntConsumer.accept(eArr[i7], i8);
            }
            i7++;
        }
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.hd
    public Iterator<E> iterator() {
        return md.p(this);
    }

    @Override // com.google.common.collect.hd
    public int l0(Object obj) {
        if (obj == null || !u(obj)) {
            return 0;
        }
        return this.f21254e[((Enum) obj).ordinal()];
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int add(E e8, int i7) {
        o(e8);
        f2.b(i7, "occurrences");
        if (i7 == 0) {
            return l0(e8);
        }
        int iOrdinal = e8.ordinal();
        int i8 = this.f21254e[iOrdinal];
        long j7 = i7;
        long j8 = ((long) i8) + j7;
        com.google.common.base.e0.p(j8 <= 2147483647L, "too many occurrences: %s", j8);
        this.f21254e[iOrdinal] = (int) j8;
        if (i8 == 0) {
            this.f21255f++;
        }
        this.f21256g += j7;
        return i8;
    }

    void o(Object obj) {
        com.google.common.base.e0.E(obj);
        if (u(obj)) {
            return;
        }
        throw new ClassCastException("Expected an " + this.f21252c + " but got " + obj);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public int remove(Object obj, int i7) {
        if (obj == null || !u(obj)) {
            return 0;
        }
        Enum r7 = (Enum) obj;
        f2.b(i7, "occurrences");
        if (i7 == 0) {
            return l0(obj);
        }
        int iOrdinal = r7.ordinal();
        int[] iArr = this.f21254e;
        int i8 = iArr[iOrdinal];
        if (i8 == 0) {
            return 0;
        }
        if (i8 <= i7) {
            iArr[iOrdinal] = 0;
            this.f21255f--;
            this.f21256g -= (long) i8;
        } else {
            iArr[iOrdinal] = i8 - i7;
            this.f21256g -= (long) i7;
        }
        return i8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public int size() {
        return com.google.common.primitives.c0.x(this.f21256g);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int setCount(E e8, int i7) {
        o(e8);
        f2.b(i7, "count");
        int iOrdinal = e8.ordinal();
        int[] iArr = this.f21254e;
        int i8 = iArr[iOrdinal];
        iArr[iOrdinal] = i7;
        this.f21256g += (long) (i7 - i8);
        if (i8 == 0 && i7 > 0) {
            this.f21255f++;
        } else if (i8 > 0 && i7 == 0) {
            this.f21255f--;
        }
        return i8;
    }
}
