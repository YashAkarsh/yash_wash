package kotlinx.coroutines.debug.internal;

import com.google.common.util.concurrent.h2;
import com.haier.uhome.account.api.RetInfoContent;
import i5.p;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.w;
import kotlin.l2;
import kotlin.ranges.q;
import kotlin.y;

/* JADX INFO: loaded from: classes2.dex */
public final class b<K, V> extends kotlin.collections.g<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f35898b = AtomicIntegerFieldUpdater.newUpdater(b.class, "_size");

    @a7.d
    private volatile /* synthetic */ int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final ReferenceQueue<K> f35899a;

    @a7.d
    volatile /* synthetic */ Object core;

    private final class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f35900g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f35901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f35903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        /* synthetic */ AtomicReferenceArray f35904d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @a7.d
        /* synthetic */ AtomicReferenceArray f35905e;

        @a7.d
        private volatile /* synthetic */ int load = 0;

        /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.b$a$a, reason: collision with other inner class name */
        private final class C0451a<E> implements Iterator<E>, j5.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @a7.d
            private final p<K, V, E> f35907a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f35908b = -1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private K f35909c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private V f35910d;

            /* JADX WARN: Multi-variable type inference failed */
            public C0451a(p<? super K, ? super V, ? extends E> pVar) {
                this.f35907a = pVar;
                a();
            }

            private final void a() {
                while (true) {
                    int i7 = this.f35908b + 1;
                    this.f35908b = i7;
                    if (i7 >= ((a) a.this).f35901a) {
                        return;
                    }
                    k kVar = (k) a.this.f35904d.get(this.f35908b);
                    K k7 = kVar == null ? null : (K) kVar.get();
                    if (k7 != null) {
                        this.f35909c = k7;
                        Object obj = (V) a.this.f35905e.get(this.f35908b);
                        if (obj instanceof l) {
                            obj = (V) ((l) obj).f35977a;
                        }
                        if (obj != null) {
                            this.f35910d = (V) obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            @a7.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Void remove() {
                kotlinx.coroutines.debug.internal.c.e();
                throw new y();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f35908b < ((a) a.this).f35901a;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.util.Iterator
            public E next() {
                if (this.f35908b >= ((a) a.this).f35901a) {
                    throw new NoSuchElementException();
                }
                p<K, V, E> pVar = this.f35907a;
                K k7 = this.f35909c;
                if (k7 == false) {
                    l0.S(RetInfoContent.BindKEY_ISNULL);
                    k7 = (K) l2.f34958a;
                }
                V v7 = this.f35910d;
                if (v7 == false) {
                    l0.S("value");
                    v7 = (V) l2.f34958a;
                }
                E e8 = (E) pVar.a0(k7, v7);
                a();
                return e8;
            }
        }

        public a(int i7) {
            this.f35901a = i7;
            this.f35902b = Integer.numberOfLeadingZeros(i7) + 1;
            this.f35903c = (i7 * 2) / 3;
            this.f35904d = new AtomicReferenceArray(i7);
            this.f35905e = new AtomicReferenceArray(i7);
        }

        private final int d(int i7) {
            return (i7 * (-1640531527)) >>> this.f35902b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object g(a aVar, Object obj, Object obj2, k kVar, int i7, Object obj3) {
            if ((i7 & 4) != 0) {
                kVar = null;
            }
            return aVar.f(obj, obj2, kVar);
        }

        private final void i(int i7) {
            Object obj;
            do {
                obj = this.f35905e.get(i7);
                if (obj == null || (obj instanceof l)) {
                    return;
                }
            } while (!h2.a(this.f35905e, i7, obj, null));
            b.this.k();
        }

        public final void b(@a7.d k<?> kVar) {
            int iD = d(kVar.f35976a);
            while (true) {
                k<?> kVar2 = (k) this.f35904d.get(iD);
                if (kVar2 == null) {
                    return;
                }
                if (kVar2 == kVar) {
                    i(iD);
                    return;
                } else {
                    if (iD == 0) {
                        iD = this.f35901a;
                    }
                    iD--;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @a7.e
        public final V c(@a7.d K k7) {
            int iD = d(k7.hashCode());
            while (true) {
                k kVar = (k) this.f35904d.get(iD);
                if (kVar == null) {
                    return null;
                }
                T t7 = kVar.get();
                if (l0.g(k7, t7)) {
                    V v7 = (V) this.f35905e.get(iD);
                    return v7 instanceof l ? (V) ((l) v7).f35977a : v7;
                }
                if (t7 == 0) {
                    i(iD);
                }
                if (iD == 0) {
                    iD = this.f35901a;
                }
                iD--;
            }
        }

        @a7.d
        public final <E> Iterator<E> e(@a7.d p<? super K, ? super V, ? extends E> pVar) {
            return new C0451a(pVar);
        }

        @a7.e
        public final Object f(@a7.d K k7, @a7.e V v7, @a7.e k<K> kVar) {
            int i7;
            Object obj;
            int iD = d(k7.hashCode());
            boolean z7 = false;
            while (true) {
                k kVar2 = (k) this.f35904d.get(iD);
                if (kVar2 != null) {
                    T t7 = kVar2.get();
                    if (l0.g(k7, t7)) {
                        if (!z7) {
                            break;
                        }
                        f35900g.decrementAndGet(this);
                        break;
                    }
                    if (t7 == 0) {
                        i(iD);
                    }
                    if (iD == 0) {
                        iD = this.f35901a;
                    }
                    iD--;
                } else {
                    if (v7 == null) {
                        return null;
                    }
                    if (!z7) {
                        do {
                            i7 = this.load;
                            if (i7 >= this.f35903c) {
                                return kotlinx.coroutines.debug.internal.c.f35920c;
                            }
                        } while (!f35900g.compareAndSet(this, i7, i7 + 1));
                        z7 = true;
                    }
                    if (kVar == null) {
                        kVar = new k<>(k7, ((b) b.this).f35899a);
                    }
                    if (h2.a(this.f35904d, iD, null, kVar)) {
                        break;
                    }
                }
            }
            do {
                obj = this.f35905e.get(iD);
                if (obj instanceof l) {
                    return kotlinx.coroutines.debug.internal.c.f35920c;
                }
            } while (!h2.a(this.f35905e, iD, obj, v7));
            return obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @a7.d
        public final b<K, V>.a h() {
            Object obj;
            while (true) {
                b<K, V>.a aVar = (b<K, V>.a) b.this.new a(Integer.highestOneBit(q.n(b.this.size(), 4)) * 4);
                int i7 = this.f35901a;
                int i8 = 0;
                while (i8 < i7) {
                    int i9 = i8 + 1;
                    k kVar = (k) this.f35904d.get(i8);
                    Object obj2 = kVar == null ? null : kVar.get();
                    if (kVar != null && obj2 == null) {
                        i(i8);
                    }
                    do {
                        obj = this.f35905e.get(i8);
                        if (obj instanceof l) {
                            obj = ((l) obj).f35977a;
                            break;
                        }
                    } while (!h2.a(this.f35905e, i8, obj, kotlinx.coroutines.debug.internal.c.d(obj)));
                    if (obj2 == null || obj == null || aVar.f(obj2, obj, kVar) != kotlinx.coroutines.debug.internal.c.f35920c) {
                        i8 = i9;
                    }
                }
                return aVar;
            }
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.b$b, reason: collision with other inner class name */
    private static final class C0452b<K, V> implements Map.Entry<K, V>, j5.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f35912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final V f35913b;

        public C0452b(K k7, V v7) {
            this.f35912a = k7;
            this.f35913b = v7;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f35912a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f35913b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            kotlinx.coroutines.debug.internal.c.e();
            throw new y();
        }
    }

    private final class c<E> extends kotlin.collections.h<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final p<K, V, E> f35914a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(p<? super K, ? super V, ? extends E> pVar) {
            this.f35914a = pVar;
        }

        @Override // kotlin.collections.h
        public int a() {
            return b.this.size();
        }

        @Override // kotlin.collections.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e8) {
            kotlinx.coroutines.debug.internal.c.e();
            throw new y();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        @a7.d
        public Iterator<E> iterator() {
            return ((a) b.this.core).e(this.f35914a);
        }
    }

    static final class d extends n0 implements p<K, V, Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f35916a = new d();

        d() {
            super(2);
        }

        @Override // i5.p
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map.Entry<K, V> a0(@a7.d K k7, @a7.d V v7) {
            return new C0452b(k7, v7);
        }
    }

    static final class e extends n0 implements p<K, V, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f35917a = new e();

        e() {
            super(2);
        }

        @Override // i5.p
        @a7.d
        public final K a0(@a7.d K k7, @a7.d V v7) {
            return k7;
        }
    }

    public b() {
        this(false, 1, null);
    }

    private final void i(k<?> kVar) {
        ((a) this.core).b(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        f35898b.decrementAndGet(this);
    }

    private final synchronized V l(K k7, V v7) {
        V v8;
        a aVarH = (a) this.core;
        while (true) {
            v8 = (V) a.g(aVarH, k7, v7, null, 4, null);
            if (v8 == kotlinx.coroutines.debug.internal.c.f35920c) {
                aVarH = aVarH.h();
                this.core = aVarH;
            }
        }
        return v8;
    }

    @Override // kotlin.collections.g
    @a7.d
    public Set<Map.Entry<K, V>> a() {
        return new c(d.f35916a);
    }

    @Override // kotlin.collections.g
    @a7.d
    public Set<K> b() {
        return new c(e.f35917a);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // kotlin.collections.g
    public int d() {
        return this._size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @a7.e
    public V get(@a7.e Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((a) this.core).c(obj);
    }

    public final void m() {
        if (!(this.f35899a != null)) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                Reference<? extends K> referenceRemove = this.f35899a.remove();
                if (referenceRemove == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
                }
                i((k) referenceRemove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    @Override // kotlin.collections.g, java.util.AbstractMap, java.util.Map
    @a7.e
    public V put(@a7.d K k7, @a7.d V v7) {
        V vL = (V) a.g((a) this.core, k7, v7, null, 4, null);
        if (vL == kotlinx.coroutines.debug.internal.c.f35920c) {
            vL = l(k7, v7);
        }
        if (vL == null) {
            f35898b.incrementAndGet(this);
        }
        return vL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @a7.e
    public V remove(@a7.e Object obj) {
        if (obj == 0) {
            return null;
        }
        V vL = (V) a.g((a) this.core, obj, null, null, 4, null);
        if (vL == kotlinx.coroutines.debug.internal.c.f35920c) {
            vL = l(obj, null);
        }
        if (vL != null) {
            f35898b.decrementAndGet(this);
        }
        return vL;
    }

    public /* synthetic */ b(boolean z7, int i7, w wVar) {
        this((i7 & 1) != 0 ? false : z7);
    }

    public b(boolean z7) {
        this._size = 0;
        this.core = new a(16);
        this.f35899a = z7 ? new ReferenceQueue<>() : null;
    }
}
