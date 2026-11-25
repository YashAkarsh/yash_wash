package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
abstract class u<E> extends y<E> implements Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @s1.c
    private static final long f21145e = -2250766705698539974L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Map<E, j4> f21146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient long f21147d;

    class a implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map.Entry<E, j4> f21148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterator f21149b;

        a(Iterator it) {
            this.f21149b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21149b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            Map.Entry<E, j4> entry = (Map.Entry) this.f21149b.next();
            this.f21148a = entry;
            return entry.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f21148a != null);
            u.this.f21147d -= (long) this.f21148a.getValue().d(0);
            this.f21149b.remove();
            this.f21148a = null;
        }
    }

    class b implements Iterator<hd.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map.Entry<E, j4> f21151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Iterator f21152b;

        class a extends md.f<E> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Map.Entry f21154a;

            a(Map.Entry entry) {
                this.f21154a = entry;
            }

            @Override // com.google.common.collect.hd.a
            public int getCount() {
                j4 j4Var;
                j4 j4Var2 = (j4) this.f21154a.getValue();
                if ((j4Var2 == null || j4Var2.c() == 0) && (j4Var = (j4) u.this.f21146c.get(getElement())) != null) {
                    return j4Var.c();
                }
                if (j4Var2 == null) {
                    return 0;
                }
                return j4Var2.c();
            }

            @Override // com.google.common.collect.hd.a
            public E getElement() {
                return (E) this.f21154a.getKey();
            }
        }

        b(Iterator it) {
            this.f21152b = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public hd.a<E> next() {
            Map.Entry<E, j4> entry = (Map.Entry) this.f21152b.next();
            this.f21151a = entry;
            return new a(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21152b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f21151a != null);
            u.this.f21147d -= (long) this.f21151a.getValue().d(0);
            this.f21152b.remove();
            this.f21151a = null;
        }
    }

    private class c implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<E, j4>> f21156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map.Entry<E, j4> f21157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f21158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f21159d;

        c() {
            this.f21156a = u.this.f21146c.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21158c > 0 || this.f21156a.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f21158c == 0) {
                Map.Entry<E, j4> next = this.f21156a.next();
                this.f21157b = next;
                this.f21158c = next.getValue().c();
            }
            this.f21158c--;
            this.f21159d = true;
            return this.f21157b.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f21159d);
            if (this.f21157b.getValue().c() <= 0) {
                throw new ConcurrentModificationException();
            }
            if (this.f21157b.getValue().b(-1) == 0) {
                this.f21156a.remove();
            }
            u.l(u.this);
            this.f21159d = false;
        }
    }

    protected u(Map<E, j4> map) {
        com.google.common.base.e0.d(map.isEmpty());
        this.f21146c = map;
    }

    static /* synthetic */ long l(u uVar) {
        long j7 = uVar.f21147d;
        uVar.f21147d = j7 - 1;
        return j7;
    }

    private static int n(j4 j4Var, int i7) {
        if (j4Var == null) {
            return 0;
        }
        return j4Var.d(i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(ObjIntConsumer objIntConsumer, Object obj, j4 j4Var) {
        objIntConsumer.accept(obj, j4Var.c());
    }

    @s1.c
    private void p() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public int add(E e8, int i7) {
        if (i7 == 0) {
            return l0(e8);
        }
        int i8 = 0;
        com.google.common.base.e0.k(i7 > 0, "occurrences cannot be negative: %s", i7);
        j4 j4Var = this.f21146c.get(e8);
        if (j4Var == null) {
            this.f21146c.put(e8, new j4(i7));
        } else {
            int iC = j4Var.c();
            long j7 = ((long) iC) + ((long) i7);
            com.google.common.base.e0.p(j7 <= 2147483647L, "too many occurrences: %s", j7);
            j4Var.a(i7);
            i8 = iC;
        }
        this.f21147d += (long) i7;
        return i8;
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterator<j4> it = this.f21146c.values().iterator();
        while (it.hasNext()) {
            it.next().e(0);
        }
        this.f21146c.clear();
        this.f21147d = 0L;
    }

    @Override // com.google.common.collect.y
    int d() {
        return this.f21146c.size();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    public Set<hd.a<E>> entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.y
    Iterator<E> f() {
        return new a(this.f21146c.entrySet().iterator());
    }

    @Override // com.google.common.collect.y
    Iterator<hd.a<E>> g() {
        return new b(this.f21146c.entrySet().iterator());
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    public void h0(final ObjIntConsumer<? super E> objIntConsumer) {
        com.google.common.base.e0.E(objIntConsumer);
        this.f21146c.forEach(new BiConsumer() { // from class: com.google.common.collect.t
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                u.o(objIntConsumer, obj, (j4) obj2);
            }
        });
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.hd
    public Iterator<E> iterator() {
        return new c();
    }

    public int l0(Object obj) {
        j4 j4Var = (j4) wb.z0(this.f21146c, obj);
        if (j4Var == null) {
            return 0;
        }
        return j4Var.c();
    }

    void r(Map<E, j4> map) {
        this.f21146c = map;
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public int remove(Object obj, int i7) {
        if (i7 == 0) {
            return l0(obj);
        }
        com.google.common.base.e0.k(i7 > 0, "occurrences cannot be negative: %s", i7);
        j4 j4Var = this.f21146c.get(obj);
        if (j4Var == null) {
            return 0;
        }
        int iC = j4Var.c();
        if (iC <= i7) {
            this.f21146c.remove(obj);
            i7 = iC;
        }
        j4Var.a(-i7);
        this.f21147d -= (long) i7;
        return iC;
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public int setCount(E e8, int i7) {
        int iN;
        f2.b(i7, "count");
        if (i7 == 0) {
            iN = n(this.f21146c.remove(e8), i7);
        } else {
            j4 j4Var = this.f21146c.get(e8);
            int iN2 = n(j4Var, i7);
            if (j4Var == null) {
                this.f21146c.put(e8, new j4(i7));
            }
            iN = iN2;
        }
        this.f21147d += (long) (i7 - iN);
        return iN;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public int size() {
        return com.google.common.primitives.c0.x(this.f21147d);
    }
}
