package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.1")
public abstract class d<K, V> implements Map<K, V>, j5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    public static final a f34516c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private volatile Set<? extends K> f34517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private volatile Collection<? extends V> f34518b;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        public final boolean a(@a7.d Map.Entry<?, ?> e8, @a7.e Object obj) {
            kotlin.jvm.internal.l0.p(e8, "e");
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return kotlin.jvm.internal.l0.g(e8.getKey(), entry.getKey()) && kotlin.jvm.internal.l0.g(e8.getValue(), entry.getValue());
        }

        public final int b(@a7.d Map.Entry<?, ?> e8) {
            kotlin.jvm.internal.l0.p(e8, "e");
            Object key = e8.getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = e8.getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @a7.d
        public final String c(@a7.d Map.Entry<?, ?> e8) {
            kotlin.jvm.internal.l0.p(e8, "e");
            StringBuilder sb = new StringBuilder();
            sb.append(e8.getKey());
            sb.append('=');
            sb.append(e8.getValue());
            return sb.toString();
        }

        private a() {
        }
    }

    public static final class b extends i<K> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d<K, V> f34519b;

        public static final class a implements Iterator<K>, j5.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterator<Map.Entry<K, V>> f34520a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f34520a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f34520a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return this.f34520a.next().getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(d<K, ? extends V> dVar) {
            this.f34519b = dVar;
        }

        @Override // kotlin.collections.a
        public int a() {
            return this.f34519b.size();
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean contains(Object obj) {
            return this.f34519b.containsKey(obj);
        }

        @Override // kotlin.collections.i, kotlin.collections.a, java.util.Collection, java.lang.Iterable
        @a7.d
        public Iterator<K> iterator() {
            return new a(this.f34519b.entrySet().iterator());
        }
    }

    static final class c extends kotlin.jvm.internal.n0 implements i5.l<Map.Entry<? extends K, ? extends V>, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d<K, V> f34521a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(d<K, ? extends V> dVar) {
            super(1);
            this.f34521a = dVar;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence z(@a7.d Map.Entry<? extends K, ? extends V> it) {
            kotlin.jvm.internal.l0.p(it, "it");
            return this.f34521a.l(it);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.d$d, reason: collision with other inner class name */
    public static final class C0424d extends kotlin.collections.a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d<K, V> f34522a;

        /* JADX INFO: renamed from: kotlin.collections.d$d$a */
        public static final class a implements Iterator<V>, j5.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterator<Map.Entry<K, V>> f34523a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f34523a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f34523a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return this.f34523a.next().getValue();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        C0424d(d<K, ? extends V> dVar) {
            this.f34522a = dVar;
        }

        @Override // kotlin.collections.a
        public int a() {
            return this.f34522a.size();
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean contains(Object obj) {
            return this.f34522a.containsValue(obj);
        }

        @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable
        @a7.d
        public Iterator<V> iterator() {
            return new a(this.f34522a.entrySet().iterator());
        }
    }

    protected d() {
    }

    private final Map.Entry<K, V> i(K k7) {
        Object next;
        Iterator<T> it = entrySet().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (kotlin.jvm.internal.l0.g(((Map.Entry) next).getKey(), k7)) {
                return (Map.Entry) next;
            }
        }
        next = null;
        return (Map.Entry) next;
    }

    private final String k(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l(Map.Entry<? extends K, ? extends V> entry) {
        return k(entry.getKey()) + '=' + k(entry.getValue());
    }

    public final boolean b(@a7.e Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        kotlin.jvm.internal.l0.n(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        V v7 = get(key);
        if (!kotlin.jvm.internal.l0.g(value, v7)) {
            return false;
        }
        if (v7 != null) {
            return true;
        }
        kotlin.jvm.internal.l0.n(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        return containsKey(key);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return i(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> setEntrySet = entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.l0.g(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Set d();

    @a7.d
    public Set<K> e() {
        if (this.f34517a == null) {
            this.f34517a = new b(this);
        }
        Set<? extends K> set = this.f34517a;
        kotlin.jvm.internal.l0.m(set);
        return set;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return d();
    }

    @Override // java.util.Map
    public boolean equals(@a7.e Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        if ((setEntrySet instanceof Collection) && setEntrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (!b((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public int f() {
        return entrySet().size();
    }

    @a7.d
    public Collection<V> g() {
        if (this.f34518b == null) {
            this.f34518b = new C0424d(this);
        }
        Collection<? extends V> collection = this.f34518b;
        kotlin.jvm.internal.l0.m(collection);
        return collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @a7.e
    public V get(Object obj) {
        Map.Entry<K, V> entryI = i(obj);
        if (entryI != null) {
            return entryI.getValue();
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return e();
    }

    @Override // java.util.Map
    public V put(K k7, V v7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return f();
    }

    @a7.d
    public String toString() {
        return g0.h3(entrySet(), ", ", "{", com.alipay.sdk.util.j.f13808d, 0, null, new c(this), 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return g();
    }
}
