package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public class fb<K, V> extends x<K, V> implements hb<K, V>, Serializable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @s1.c
    private static final long f20230k = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient g<K, V> f20231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient g<K, V> f20232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient Map<K, f<K, V>> f20233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient int f20234i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient int f20235j;

    class a extends AbstractSequentialList<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f20236a;

        a(Object obj) {
            this.f20236a = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i7) {
            return new i(this.f20236a, i7);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) fb.this.f20233h.get(this.f20236a);
            if (fVar == null) {
                return 0;
            }
            return fVar.f20250c;
        }
    }

    class b extends AbstractSequentialList<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
            com.google.common.base.e0.E(consumer);
            for (g<K, V> gVar = fb.this.f20231f; gVar != null; gVar = gVar.f20253c) {
                consumer.accept(gVar);
            }
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i7) {
            return new h(i7);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return fb.this.f20234i;
        }
    }

    class c extends af.l<K> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return fb.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new e(fb.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return !fb.this.a(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return fb.this.f20233h.size();
        }
    }

    class d extends AbstractSequentialList<V> {

        class a extends vj<Map.Entry<K, V>, V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ h f20241b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ListIterator listIterator, h hVar) {
                super(listIterator);
                this.f20241b = hVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.uj
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // com.google.common.collect.vj, java.util.ListIterator
            public void set(V v7) {
                this.f20241b.f(v7);
            }
        }

        d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i7) {
            h hVar = new h(i7);
            return new a(hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return fb.this.f20234i;
        }
    }

    private static class f<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g<K, V> f20248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g<K, V> f20249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f20250c;

        f(g<K, V> gVar) {
            this.f20248a = gVar;
            this.f20249b = gVar;
            gVar.f20256f = null;
            gVar.f20255e = null;
            this.f20250c = 1;
        }
    }

    private static final class g<K, V> extends v<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f20251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        V f20252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        g<K, V> f20253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        g<K, V> f20254d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        g<K, V> f20255e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        g<K, V> f20256f;

        g(K k7, V v7) {
            this.f20251a = k7;
            this.f20252b = v7;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public K getKey() {
            return this.f20251a;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public V getValue() {
            return this.f20252b;
        }

        @Override // com.google.common.collect.v, java.util.Map.Entry
        public V setValue(V v7) {
            V v8 = this.f20252b;
            this.f20252b = v7;
            return v8;
        }
    }

    private class h implements ListIterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g<K, V> f20258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        g<K, V> f20259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        g<K, V> f20260d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f20261e;

        h(int i7) {
            this.f20261e = fb.this.f20235j;
            int size = fb.this.size();
            com.google.common.base.e0.d0(i7, size);
            if (i7 < size / 2) {
                this.f20258b = fb.this.f20231f;
                while (true) {
                    int i8 = i7 - 1;
                    if (i7 <= 0) {
                        break;
                    }
                    next();
                    i7 = i8;
                }
            } else {
                this.f20260d = fb.this.f20232g;
                this.f20257a = size;
                while (true) {
                    int i9 = i7 + 1;
                    if (i7 >= size) {
                        break;
                    }
                    previous();
                    i7 = i9;
                }
            }
            this.f20259c = null;
        }

        private void b() {
            if (fb.this.f20235j != this.f20261e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @u1.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public g<K, V> next() {
            b();
            fb.x(this.f20258b);
            g<K, V> gVar = this.f20258b;
            this.f20259c = gVar;
            this.f20260d = gVar;
            this.f20258b = gVar.f20253c;
            this.f20257a++;
            return gVar;
        }

        @Override // java.util.ListIterator
        @u1.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public g<K, V> previous() {
            b();
            fb.x(this.f20260d);
            g<K, V> gVar = this.f20260d;
            this.f20259c = gVar;
            this.f20258b = gVar;
            this.f20260d = gVar.f20254d;
            this.f20257a--;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        void f(V v7) {
            com.google.common.base.e0.g0(this.f20259c != null);
            this.f20259c.f20252b = v7;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f20258b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f20260d != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f20257a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f20257a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            f2.e(this.f20259c != null);
            g<K, V> gVar = this.f20259c;
            if (gVar != this.f20258b) {
                this.f20260d = gVar.f20254d;
                this.f20257a--;
            } else {
                this.f20258b = gVar.f20253c;
            }
            fb.this.J(gVar);
            this.f20259c = null;
            this.f20261e = fb.this.f20235j;
        }
    }

    fb() {
        this(12);
    }

    public static <K, V> fb<K, V> A(tc<? extends K, ? extends V> tcVar) {
        return new fb<>(tcVar);
    }

    private List<V> F(Object obj) {
        return Collections.unmodifiableList(ib.s(new i(obj)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Object obj) {
        ua.h(new i(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f20254d;
        if (gVar2 != null) {
            gVar2.f20253c = gVar.f20253c;
        } else {
            this.f20231f = gVar.f20253c;
        }
        g<K, V> gVar3 = gVar.f20253c;
        if (gVar3 != null) {
            gVar3.f20254d = gVar2;
        } else {
            this.f20232g = gVar2;
        }
        if (gVar.f20256f == null && gVar.f20255e == null) {
            this.f20233h.remove(gVar.f20251a).f20250c = 0;
            this.f20235j++;
        } else {
            f<K, V> fVar = this.f20233h.get(gVar.f20251a);
            fVar.f20250c--;
            g<K, V> gVar4 = gVar.f20256f;
            if (gVar4 == null) {
                fVar.f20248a = gVar.f20255e;
            } else {
                gVar4.f20255e = gVar.f20255e;
            }
            g<K, V> gVar5 = gVar.f20255e;
            if (gVar5 == null) {
                fVar.f20249b = gVar4;
            } else {
                gVar5.f20256f = gVar4;
            }
        }
        this.f20234i--;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f20233h = wb.m0();
        int i7 = objectInputStream.readInt();
        for (int i8 = 0; i8 < i7; i8++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @u1.a
    public g<K, V> w(K k7, V v7, g<K, V> gVar) {
        g<K, V> gVar2 = new g<>(k7, v7);
        if (this.f20231f == null) {
            this.f20232g = gVar2;
            this.f20231f = gVar2;
            this.f20233h.put(k7, new f<>(gVar2));
            this.f20235j++;
        } else if (gVar == null) {
            g<K, V> gVar3 = this.f20232g;
            gVar3.f20253c = gVar2;
            gVar2.f20254d = gVar3;
            this.f20232g = gVar2;
            f<K, V> fVar = this.f20233h.get(k7);
            if (fVar == null) {
                this.f20233h.put(k7, new f<>(gVar2));
                this.f20235j++;
            } else {
                fVar.f20250c++;
                g<K, V> gVar4 = fVar.f20249b;
                gVar4.f20255e = gVar2;
                gVar2.f20256f = gVar4;
                fVar.f20249b = gVar2;
            }
        } else {
            this.f20233h.get(k7).f20250c++;
            gVar2.f20254d = gVar.f20254d;
            gVar2.f20256f = gVar.f20256f;
            gVar2.f20253c = gVar;
            gVar2.f20255e = gVar;
            g<K, V> gVar5 = gVar.f20256f;
            if (gVar5 == null) {
                this.f20233h.get(k7).f20248a = gVar2;
            } else {
                gVar5.f20255e = gVar2;
            }
            g<K, V> gVar6 = gVar.f20254d;
            if (gVar6 == null) {
                this.f20231f = gVar2;
            } else {
                gVar6.f20253c = gVar2;
            }
            gVar.f20254d = gVar2;
            gVar.f20256f = gVar2;
        }
        this.f20234i++;
        return gVar2;
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : y()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    public static <K, V> fb<K, V> y() {
        return new fb<>();
    }

    public static <K, V> fb<K, V> z(int i7) {
        return new fb<>(i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.x
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public List<Map.Entry<K, V>> e() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.x
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public List<V> h() {
        return new d();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public List<Map.Entry<K, V>> y() {
        return (List) super.y();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean H(tc tcVar) {
        return super.H(tcVar);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public List<V> values() {
        return (List) super.values();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean W(Object obj, Object obj2) {
        return super.W(obj, obj2);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.x
    Map<K, Collection<V>> c() {
        return new cd.a(this);
    }

    @Override // com.google.common.collect.tc
    public void clear() {
        this.f20231f = null;
        this.f20232g = null;
        this.f20233h.clear();
        this.f20234i = 0;
        this.f20235j++;
    }

    @Override // com.google.common.collect.tc
    public boolean containsKey(Object obj) {
        return this.f20233h.containsKey(obj);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.x
    Set<K> f() {
        return new c();
    }

    @Override // com.google.common.collect.x
    hd<K> g() {
        return new cd.g(this);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.x
    Iterator<Map.Entry<K, V>> i() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public boolean isEmpty() {
        return this.f20231f == null;
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ hd keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public boolean put(K k7, V v7) {
        w(k7, v7, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.tc
    public int size() {
        return this.f20234i;
    }

    @Override // com.google.common.collect.x
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private fb(int i7) {
        this.f20233h = vd.c(i7);
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public List<V> a(Object obj) {
        List<V> listF = F(obj);
        I(obj);
        return listF;
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public List<V> b(K k7, Iterable<? extends V> iterable) {
        List<V> listF = F(k7);
        i iVar = new i(k7);
        Iterator<? extends V> it = iterable.iterator();
        while (iVar.hasNext() && it.hasNext()) {
            iVar.next();
            iVar.set(it.next());
        }
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
        while (it.hasNext()) {
            iVar.add(it.next());
        }
        return listF;
    }

    @Override // com.google.common.collect.tc, com.google.common.collect.hb
    public List<V> get(K k7) {
        return new a(k7);
    }

    private class e implements Iterator<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Set<K> f20243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g<K, V> f20244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        g<K, V> f20245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f20246d;

        private e() {
            this.f20243a = af.y(fb.this.keySet().size());
            this.f20244b = fb.this.f20231f;
            this.f20246d = fb.this.f20235j;
        }

        private void a() {
            if (fb.this.f20235j != this.f20246d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f20244b != null;
        }

        @Override // java.util.Iterator
        public K next() {
            g<K, V> gVar;
            a();
            fb.x(this.f20244b);
            g<K, V> gVar2 = this.f20244b;
            this.f20245c = gVar2;
            this.f20243a.add(gVar2.f20251a);
            do {
                gVar = this.f20244b.f20253c;
                this.f20244b = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.f20243a.add(gVar.f20251a));
            return this.f20245c.f20251a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            f2.e(this.f20245c != null);
            fb.this.I(this.f20245c.f20251a);
            this.f20245c = null;
            this.f20246d = fb.this.f20235j;
        }

        /* synthetic */ e(fb fbVar, a aVar) {
            this();
        }
    }

    private class i implements ListIterator<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f20263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f20264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        g<K, V> f20265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        g<K, V> f20266d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        g<K, V> f20267e;

        i(Object obj) {
            this.f20263a = obj;
            f fVar = (f) fb.this.f20233h.get(obj);
            this.f20265c = fVar == null ? null : fVar.f20248a;
        }

        @Override // java.util.ListIterator
        public void add(V v7) {
            this.f20267e = fb.this.w(this.f20263a, v7, this.f20265c);
            this.f20264b++;
            this.f20266d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f20265c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f20267e != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @u1.a
        public V next() {
            fb.x(this.f20265c);
            g<K, V> gVar = this.f20265c;
            this.f20266d = gVar;
            this.f20267e = gVar;
            this.f20265c = gVar.f20255e;
            this.f20264b++;
            return gVar.f20252b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f20264b;
        }

        @Override // java.util.ListIterator
        @u1.a
        public V previous() {
            fb.x(this.f20267e);
            g<K, V> gVar = this.f20267e;
            this.f20266d = gVar;
            this.f20265c = gVar;
            this.f20267e = gVar.f20256f;
            this.f20264b--;
            return gVar.f20252b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f20264b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            f2.e(this.f20266d != null);
            g<K, V> gVar = this.f20266d;
            if (gVar != this.f20265c) {
                this.f20267e = gVar.f20256f;
                this.f20264b--;
            } else {
                this.f20265c = gVar.f20255e;
            }
            fb.this.J(gVar);
            this.f20266d = null;
        }

        @Override // java.util.ListIterator
        public void set(V v7) {
            com.google.common.base.e0.g0(this.f20266d != null);
            this.f20266d.f20252b = v7;
        }

        public i(Object obj, int i7) {
            f fVar = (f) fb.this.f20233h.get(obj);
            int i8 = fVar == null ? 0 : fVar.f20250c;
            com.google.common.base.e0.d0(i7, i8);
            if (i7 >= i8 / 2) {
                this.f20267e = fVar == null ? null : fVar.f20249b;
                this.f20264b = i8;
                while (true) {
                    int i9 = i7 + 1;
                    if (i7 >= i8) {
                        break;
                    }
                    previous();
                    i7 = i9;
                }
            } else {
                this.f20265c = fVar == null ? null : fVar.f20248a;
                while (true) {
                    int i10 = i7 - 1;
                    if (i7 <= 0) {
                        break;
                    }
                    next();
                    i7 = i10;
                }
            }
            this.f20263a = obj;
            this.f20266d = null;
        }
    }

    private fb(tc<? extends K, ? extends V> tcVar) {
        this(tcVar.keySet().size());
        H(tcVar);
    }
}
