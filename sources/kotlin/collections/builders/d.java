package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.o;
import kotlin.collections.u0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.ranges.k;
import kotlin.ranges.q;

/* JADX INFO: loaded from: classes2.dex */
public final class d<K, V> implements Map<K, V>, Serializable, j5.g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @a7.d
    private static final a f34474m = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Deprecated
    private static final int f34475n = -1640531527;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Deprecated
    private static final int f34476o = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Deprecated
    private static final int f34477p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Deprecated
    private static final int f34478q = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private K[] f34479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private V[] f34480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private int[] f34481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private int[] f34482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f34483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f34484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f34485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f34486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @a7.e
    private kotlin.collections.builders.f<K> f34487i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @a7.e
    private g<V> f34488j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @a7.e
    private kotlin.collections.builders.e<K, V> f34489k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f34490l;

    private static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i7) {
            return Integer.highestOneBit(q.n(i7, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i7) {
            return Integer.numberOfLeadingZeros(i7) + 1;
        }

        private a() {
        }
    }

    public static final class b<K, V> extends C0422d<K, V> implements Iterator<Map.Entry<K, V>>, j5.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@a7.d d<K, V> map) {
            super(map);
            l0.p(map, "map");
        }

        @Override // java.util.Iterator
        @a7.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public c<K, V> next() {
            if (a() >= ((d) d()).f34484f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            c<K, V> cVar = new c<>(d(), b());
            e();
            return cVar;
        }

        public final void i(@a7.d StringBuilder sb) {
            l0.p(sb, "sb");
            if (a() >= ((d) d()).f34484f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            Object obj = ((d) d()).f34479a[b()];
            if (l0.g(obj, d())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = ((d) d()).f34480b;
            l0.m(objArr);
            Object obj2 = objArr[b()];
            if (l0.g(obj2, d())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            e();
        }

        public final int j() {
            if (a() >= ((d) d()).f34484f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            Object obj = ((d) d()).f34479a[b()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = ((d) d()).f34480b;
            l0.m(objArr);
            Object obj2 = objArr[b()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            e();
            return iHashCode2;
        }
    }

    public static final class c<K, V> implements Map.Entry<K, V>, j5.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final d<K, V> f34491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f34492b;

        public c(@a7.d d<K, V> map, int i7) {
            l0.p(map, "map");
            this.f34491a = map;
            this.f34492b = i7;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@a7.e Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (l0.g(entry.getKey(), getKey()) && l0.g(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((d) this.f34491a).f34479a[this.f34492b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((d) this.f34491a).f34480b;
            l0.m(objArr);
            return (V) objArr[this.f34492b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            this.f34491a.m();
            Object[] objArrK = this.f34491a.k();
            int i7 = this.f34492b;
            V v8 = (V) objArrK[i7];
            objArrK[i7] = v7;
            return v8;
        }

        @a7.d
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.builders.d$d, reason: collision with other inner class name */
    public static class C0422d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final d<K, V> f34493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f34495c;

        public C0422d(@a7.d d<K, V> map) {
            l0.p(map, "map");
            this.f34493a = map;
            this.f34495c = -1;
            e();
        }

        public final int a() {
            return this.f34494b;
        }

        public final int b() {
            return this.f34495c;
        }

        @a7.d
        public final d<K, V> d() {
            return this.f34493a;
        }

        public final void e() {
            while (this.f34494b < ((d) this.f34493a).f34484f) {
                int[] iArr = ((d) this.f34493a).f34481c;
                int i7 = this.f34494b;
                if (iArr[i7] >= 0) {
                    return;
                } else {
                    this.f34494b = i7 + 1;
                }
            }
        }

        public final void f(int i7) {
            this.f34494b = i7;
        }

        public final void g(int i7) {
            this.f34495c = i7;
        }

        public final boolean hasNext() {
            return this.f34494b < ((d) this.f34493a).f34484f;
        }

        public final void remove() {
            if (!(this.f34495c != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.f34493a.m();
            this.f34493a.X(this.f34495c);
            this.f34495c = -1;
        }
    }

    public static final class e<K, V> extends C0422d<K, V> implements Iterator<K>, j5.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@a7.d d<K, V> map) {
            super(map);
            l0.p(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (a() >= ((d) d()).f34484f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            K k7 = (K) ((d) d()).f34479a[b()];
            e();
            return k7;
        }
    }

    public static final class f<K, V> extends C0422d<K, V> implements Iterator<V>, j5.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@a7.d d<K, V> map) {
            super(map);
            l0.p(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (a() >= ((d) d()).f34484f) {
                throw new NoSuchElementException();
            }
            int iA = a();
            f(iA + 1);
            g(iA);
            Object[] objArr = ((d) d()).f34480b;
            l0.m(objArr);
            V v7 = (V) objArr[b()];
            e();
            return v7;
        }
    }

    private d(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i7, int i8) {
        this.f34479a = kArr;
        this.f34480b = vArr;
        this.f34481c = iArr;
        this.f34482d = iArr2;
        this.f34483e = i7;
        this.f34484f = i8;
        this.f34485g = f34474m.d(D());
    }

    private final int B() {
        return this.f34479a.length;
    }

    private final int D() {
        return this.f34482d.length;
    }

    private final int J(K k7) {
        return ((k7 != null ? k7.hashCode() : 0) * f34475n) >>> this.f34485g;
    }

    private final boolean M(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z7 = false;
        if (collection.isEmpty()) {
            return false;
        }
        u(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = collection.iterator();
        while (it.hasNext()) {
            if (N(it.next())) {
                z7 = true;
            }
        }
        return z7;
    }

    private final boolean N(Map.Entry<? extends K, ? extends V> entry) {
        int i7 = i(entry.getKey());
        V[] vArrK = k();
        if (i7 >= 0) {
            vArrK[i7] = entry.getValue();
            return true;
        }
        int i8 = (-i7) - 1;
        if (l0.g(entry.getValue(), vArrK[i8])) {
            return false;
        }
        vArrK[i8] = entry.getValue();
        return true;
    }

    private final boolean O(int i7) {
        int iJ = J(this.f34479a[i7]);
        int i8 = this.f34483e;
        while (true) {
            int[] iArr = this.f34482d;
            if (iArr[iJ] == 0) {
                iArr[iJ] = i7 + 1;
                this.f34481c[i7] = iJ;
                return true;
            }
            i8--;
            if (i8 < 0) {
                return false;
            }
            iJ = iJ == 0 ? D() - 1 : iJ - 1;
        }
    }

    private final void P(int i7) {
        if (this.f34484f > size()) {
            n();
        }
        int i8 = 0;
        if (i7 != D()) {
            this.f34482d = new int[i7];
            this.f34485g = f34474m.d(i7);
        } else {
            o.l2(this.f34482d, 0, 0, D());
        }
        while (i8 < this.f34484f) {
            int i9 = i8 + 1;
            if (!O(i8)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i8 = i9;
        }
    }

    private final void S(int i7) {
        int iU = q.u(this.f34483e * 2, D() / 2);
        int i8 = 0;
        int i9 = i7;
        do {
            i7 = i7 == 0 ? D() - 1 : i7 - 1;
            i8++;
            if (i8 > this.f34483e) {
                this.f34482d[i9] = 0;
                return;
            }
            int[] iArr = this.f34482d;
            int i10 = iArr[i7];
            if (i10 == 0) {
                iArr[i9] = 0;
                return;
            }
            if (i10 < 0) {
                iArr[i9] = -1;
            } else {
                int i11 = i10 - 1;
                if (((J(this.f34479a[i11]) - i7) & (D() - 1)) >= i8) {
                    this.f34482d[i9] = i10;
                    this.f34481c[i11] = i9;
                }
                iU--;
            }
            i9 = i7;
            i8 = 0;
            iU--;
        } while (iU >= 0);
        this.f34482d[i9] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(int i7) {
        kotlin.collections.builders.c.f(this.f34479a, i7);
        S(this.f34481c[i7]);
        this.f34481c[i7] = -1;
        this.f34486h = size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] k() {
        V[] vArr = this.f34480b;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) kotlin.collections.builders.c.d(B());
        this.f34480b = vArr2;
        return vArr2;
    }

    private final void n() {
        int i7;
        V[] vArr = this.f34480b;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i7 = this.f34484f;
            if (i8 >= i7) {
                break;
            }
            if (this.f34481c[i8] >= 0) {
                K[] kArr = this.f34479a;
                kArr[i9] = kArr[i8];
                if (vArr != null) {
                    vArr[i9] = vArr[i8];
                }
                i9++;
            }
            i8++;
        }
        kotlin.collections.builders.c.g(this.f34479a, i9, i7);
        if (vArr != null) {
            kotlin.collections.builders.c.g(vArr, i9, this.f34484f);
        }
        this.f34484f = i9;
    }

    private final boolean r(Map<?, ?> map) {
        return size() == map.size() && o(map.entrySet());
    }

    private final void t(int i7) {
        if (i7 < 0) {
            throw new OutOfMemoryError();
        }
        if (i7 <= B()) {
            if ((this.f34484f + i7) - size() > B()) {
                P(D());
                return;
            }
            return;
        }
        int iB = (B() * 3) / 2;
        if (i7 <= iB) {
            i7 = iB;
        }
        this.f34479a = (K[]) kotlin.collections.builders.c.e(this.f34479a, i7);
        V[] vArr = this.f34480b;
        this.f34480b = vArr != null ? (V[]) kotlin.collections.builders.c.e(vArr, i7) : null;
        int[] iArrCopyOf = Arrays.copyOf(this.f34481c, i7);
        l0.o(iArrCopyOf, "copyOf(this, newSize)");
        this.f34481c = iArrCopyOf;
        int iC = f34474m.c(i7);
        if (iC > D()) {
            P(iC);
        }
    }

    private final void u(int i7) {
        t(this.f34484f + i7);
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.f34490l) {
            return new i(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    private final int y(K k7) {
        int iJ = J(k7);
        int i7 = this.f34483e;
        while (true) {
            int i8 = this.f34482d[iJ];
            if (i8 == 0) {
                return -1;
            }
            if (i8 > 0) {
                int i9 = i8 - 1;
                if (l0.g(this.f34479a[i9], k7)) {
                    return i9;
                }
            }
            i7--;
            if (i7 < 0) {
                return -1;
            }
            iJ = iJ == 0 ? D() - 1 : iJ - 1;
        }
    }

    private final int z(V v7) {
        int i7 = this.f34484f;
        while (true) {
            i7--;
            if (i7 < 0) {
                return -1;
            }
            if (this.f34481c[i7] >= 0) {
                V[] vArr = this.f34480b;
                l0.m(vArr);
                if (l0.g(vArr[i7], v7)) {
                    return i7;
                }
            }
        }
    }

    @a7.d
    public Set<Map.Entry<K, V>> C() {
        kotlin.collections.builders.e<K, V> eVar = this.f34489k;
        if (eVar != null) {
            return eVar;
        }
        kotlin.collections.builders.e<K, V> eVar2 = new kotlin.collections.builders.e<>(this);
        this.f34489k = eVar2;
        return eVar2;
    }

    @a7.d
    public Set<K> E() {
        kotlin.collections.builders.f<K> fVar = this.f34487i;
        if (fVar != null) {
            return fVar;
        }
        kotlin.collections.builders.f<K> fVar2 = new kotlin.collections.builders.f<>(this);
        this.f34487i = fVar2;
        return fVar2;
    }

    public int H() {
        return this.f34486h;
    }

    @a7.d
    public Collection<V> I() {
        g<V> gVar = this.f34488j;
        if (gVar != null) {
            return gVar;
        }
        g<V> gVar2 = new g<>(this);
        this.f34488j = gVar2;
        return gVar2;
    }

    public final boolean K() {
        return this.f34490l;
    }

    @a7.d
    public final e<K, V> L() {
        return new e<>(this);
    }

    public final boolean R(@a7.d Map.Entry<? extends K, ? extends V> entry) {
        l0.p(entry, "entry");
        m();
        int iY = y(entry.getKey());
        if (iY < 0) {
            return false;
        }
        V[] vArr = this.f34480b;
        l0.m(vArr);
        if (!l0.g(vArr[iY], entry.getValue())) {
            return false;
        }
        X(iY);
        return true;
    }

    public final int W(K k7) {
        m();
        int iY = y(k7);
        if (iY < 0) {
            return -1;
        }
        X(iY);
        return iY;
    }

    public final boolean Y(V v7) {
        m();
        int iZ = z(v7);
        if (iZ < 0) {
            return false;
        }
        X(iZ);
        return true;
    }

    @a7.d
    public final f<K, V> Z() {
        return new f<>(this);
    }

    @Override // java.util.Map
    public void clear() {
        m();
        u0 it = new k(0, this.f34484f - 1).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            int[] iArr = this.f34481c;
            int i7 = iArr[iB];
            if (i7 >= 0) {
                this.f34482d[i7] = 0;
                iArr[iB] = -1;
            }
        }
        kotlin.collections.builders.c.g(this.f34479a, 0, this.f34484f);
        V[] vArr = this.f34480b;
        if (vArr != null) {
            kotlin.collections.builders.c.g(vArr, 0, this.f34484f);
        }
        this.f34486h = 0;
        this.f34484f = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return y(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return z(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return C();
    }

    @Override // java.util.Map
    public boolean equals(@a7.e Object obj) {
        return obj == this || ((obj instanceof Map) && r((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @a7.e
    public V get(Object obj) {
        int iY = y(obj);
        if (iY < 0) {
            return null;
        }
        V[] vArr = this.f34480b;
        l0.m(vArr);
        return vArr[iY];
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarW = w();
        int iJ = 0;
        while (bVarW.hasNext()) {
            iJ += bVarW.j();
        }
        return iJ;
    }

    public final int i(K k7) {
        m();
        while (true) {
            int iJ = J(k7);
            int iU = q.u(this.f34483e * 2, D() / 2);
            int i7 = 0;
            while (true) {
                int i8 = this.f34482d[iJ];
                if (i8 <= 0) {
                    if (this.f34484f >= B()) {
                        u(1);
                        break;
                    }
                    int i9 = this.f34484f;
                    int i10 = i9 + 1;
                    this.f34484f = i10;
                    this.f34479a[i9] = k7;
                    this.f34481c[i9] = iJ;
                    this.f34482d[iJ] = i10;
                    this.f34486h = size() + 1;
                    if (i7 > this.f34483e) {
                        this.f34483e = i7;
                    }
                    return i9;
                }
                if (l0.g(this.f34479a[i8 - 1], k7)) {
                    return -i8;
                }
                i7++;
                if (i7 > iU) {
                    P(D() * 2);
                    break;
                }
                iJ = iJ == 0 ? D() - 1 : iJ - 1;
            }
        }
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return E();
    }

    @a7.d
    public final Map<K, V> l() {
        m();
        this.f34490l = true;
        return this;
    }

    public final void m() {
        if (this.f34490l) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean o(@a7.d Collection<?> m7) {
        l0.p(m7, "m");
        for (Object obj : m7) {
            if (obj != null) {
                try {
                    if (!q((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    @a7.e
    public V put(K k7, V v7) {
        m();
        int i7 = i(k7);
        V[] vArrK = k();
        if (i7 >= 0) {
            vArrK[i7] = v7;
            return null;
        }
        int i8 = (-i7) - 1;
        V v8 = vArrK[i8];
        vArrK[i8] = v7;
        return v8;
    }

    @Override // java.util.Map
    public void putAll(@a7.d Map<? extends K, ? extends V> from) {
        l0.p(from, "from");
        m();
        M(from.entrySet());
    }

    public final boolean q(@a7.d Map.Entry<? extends K, ? extends V> entry) {
        l0.p(entry, "entry");
        int iY = y(entry.getKey());
        if (iY < 0) {
            return false;
        }
        V[] vArr = this.f34480b;
        l0.m(vArr);
        return l0.g(vArr[iY], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @a7.e
    public V remove(Object obj) {
        int iW = W(obj);
        if (iW < 0) {
            return null;
        }
        V[] vArr = this.f34480b;
        l0.m(vArr);
        V v7 = vArr[iW];
        kotlin.collections.builders.c.f(vArr, iW);
        return v7;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return H();
    }

    @a7.d
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b<K, V> bVarW = w();
        int i7 = 0;
        while (bVarW.hasNext()) {
            if (i7 > 0) {
                sb.append(", ");
            }
            bVarW.i(sb);
            i7++;
        }
        sb.append(com.alipay.sdk.util.j.f13808d);
        String string = sb.toString();
        l0.o(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return I();
    }

    @a7.d
    public final b<K, V> w() {
        return new b<>(this);
    }

    public d() {
        this(8);
    }

    public d(int i7) {
        this(kotlin.collections.builders.c.d(i7), null, new int[i7], new int[f34474m.c(i7)], 2, 0);
    }
}
