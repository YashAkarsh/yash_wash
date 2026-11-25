package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public abstract class uc<K0, V0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f21226a = 8;

    static class a extends k<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f21227b;

        a(int i7) {
            this.f21227b = i7;
        }

        @Override // com.google.common.collect.uc.k
        <K, V> Map<K, Collection<V>> c() {
            return vd.c(this.f21227b);
        }
    }

    static class b extends k<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f21228b;

        b(int i7) {
            this.f21228b = i7;
        }

        @Override // com.google.common.collect.uc.k
        <K, V> Map<K, Collection<V>> c() {
            return vd.e(this.f21228b);
        }
    }

    static class c extends k<K0> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Comparator f21229b;

        c(Comparator comparator) {
            this.f21229b = comparator;
        }

        @Override // com.google.common.collect.uc.k
        <K extends K0, V> Map<K, Collection<V>> c() {
            return new TreeMap(this.f21229b);
        }
    }

    static class d extends k<K0> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f21230b;

        d(Class cls) {
            this.f21230b = cls;
        }

        @Override // com.google.common.collect.uc.k
        <K extends K0, V> Map<K, Collection<V>> c() {
            return new EnumMap(this.f21230b);
        }
    }

    private static final class e<V> implements com.google.common.base.p0<List<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f21231a;

        e(int i7) {
            this.f21231a = f2.b(i7, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<V> get() {
            return new ArrayList(this.f21231a);
        }
    }

    private static final class f<V extends Enum<V>> implements com.google.common.base.p0<Set<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<V> f21232a;

        f(Class<V> cls) {
            this.f21232a = (Class) com.google.common.base.e0.E(cls);
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set<V> get() {
            return EnumSet.noneOf(this.f21232a);
        }
    }

    private static final class g<V> implements com.google.common.base.p0<Set<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f21233a;

        g(int i7) {
            this.f21233a = f2.b(i7, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set<V> get() {
            return vd.d(this.f21233a);
        }
    }

    private static final class h<V> implements com.google.common.base.p0<Set<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f21234a;

        h(int i7) {
            this.f21234a = f2.b(i7, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set<V> get() {
            return vd.f(this.f21234a);
        }
    }

    private enum i implements com.google.common.base.p0<List<Object>> {
        INSTANCE;

        public static <V> com.google.common.base.p0<List<V>> b() {
            return INSTANCE;
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<Object> get() {
            return new LinkedList();
        }
    }

    public static abstract class j<K0, V0> extends uc<K0, V0> {
        j() {
            super(null);
        }

        @Override // com.google.common.collect.uc
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public abstract <K extends K0, V extends V0> hb<K, V> a();

        @Override // com.google.common.collect.uc
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public <K extends K0, V extends V0> hb<K, V> b(tc<? extends K, ? extends V> tcVar) {
            return (hb) super.b(tcVar);
        }
    }

    public static abstract class k<K0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f21237a = 2;

        class a extends j<K0, Object> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f21238b;

            a(int i7) {
                this.f21238b = i7;
            }

            @Override // com.google.common.collect.uc.j, com.google.common.collect.uc
            /* JADX INFO: renamed from: j */
            public <K extends K0, V> hb<K, V> a() {
                return cd.D(k.this.c(), new e(this.f21238b));
            }
        }

        class b extends j<K0, Object> {
            b() {
            }

            @Override // com.google.common.collect.uc.j, com.google.common.collect.uc
            /* JADX INFO: renamed from: j */
            public <K extends K0, V> hb<K, V> a() {
                return cd.D(k.this.c(), i.b());
            }
        }

        class c extends l<K0, Object> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f21241b;

            c(int i7) {
                this.f21241b = i7;
            }

            @Override // com.google.common.collect.uc.l, com.google.common.collect.uc
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public <K extends K0, V> ue<K, V> a() {
                return cd.F(k.this.c(), new g(this.f21241b));
            }
        }

        class d extends l<K0, Object> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f21243b;

            d(int i7) {
                this.f21243b = i7;
            }

            @Override // com.google.common.collect.uc.l, com.google.common.collect.uc
            /* JADX INFO: renamed from: j */
            public <K extends K0, V> ue<K, V> a() {
                return cd.F(k.this.c(), new h(this.f21243b));
            }
        }

        class e extends m<K0, V0> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Comparator f21245b;

            e(Comparator comparator) {
                this.f21245b = comparator;
            }

            @Override // com.google.common.collect.uc.m, com.google.common.collect.uc.l
            /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
            public <K extends K0, V extends V0> bg<K, V> a() {
                return cd.G(k.this.c(), new n(this.f21245b));
            }
        }

        class f extends l<K0, V0> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Class f21247b;

            f(Class cls) {
                this.f21247b = cls;
            }

            @Override // com.google.common.collect.uc.l, com.google.common.collect.uc
            /* JADX INFO: renamed from: j */
            public <K extends K0, V extends V0> ue<K, V> a() {
                return cd.F(k.this.c(), new f(this.f21247b));
            }
        }

        k() {
        }

        public j<K0, Object> a() {
            return b(2);
        }

        public j<K0, Object> b(int i7) {
            f2.b(i7, "expectedValuesPerKey");
            return new a(i7);
        }

        abstract <K extends K0, V> Map<K, Collection<V>> c();

        public <V0 extends Enum<V0>> l<K0, V0> d(Class<V0> cls) {
            com.google.common.base.e0.F(cls, "valueClass");
            return new f(cls);
        }

        public l<K0, Object> e() {
            return f(2);
        }

        public l<K0, Object> f(int i7) {
            f2.b(i7, "expectedValuesPerKey");
            return new c(i7);
        }

        public l<K0, Object> g() {
            return h(2);
        }

        public l<K0, Object> h(int i7) {
            f2.b(i7, "expectedValuesPerKey");
            return new d(i7);
        }

        public j<K0, Object> i() {
            return new b();
        }

        public m<K0, Comparable> j() {
            return k(td.A());
        }

        public <V0> m<K0, V0> k(Comparator<V0> comparator) {
            com.google.common.base.e0.F(comparator, "comparator");
            return new e(comparator);
        }
    }

    public static abstract class l<K0, V0> extends uc<K0, V0> {
        l() {
            super(null);
        }

        @Override // com.google.common.collect.uc
        /* JADX INFO: renamed from: j */
        public abstract <K extends K0, V extends V0> ue<K, V> a();

        @Override // com.google.common.collect.uc
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public <K extends K0, V extends V0> ue<K, V> b(tc<? extends K, ? extends V> tcVar) {
            return (ue) super.b(tcVar);
        }
    }

    public static abstract class m<K0, V0> extends l<K0, V0> {
        m() {
        }

        @Override // com.google.common.collect.uc.l
        /* JADX INFO: renamed from: l */
        public abstract <K extends K0, V extends V0> bg<K, V> a();

        @Override // com.google.common.collect.uc.l
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public <K extends K0, V extends V0> bg<K, V> b(tc<? extends K, ? extends V> tcVar) {
            return (bg) super.b(tcVar);
        }
    }

    private static final class n<V> implements com.google.common.base.p0<SortedSet<V>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Comparator<? super V> f21249a;

        n(Comparator<? super V> comparator) {
            this.f21249a = (Comparator) com.google.common.base.e0.E(comparator);
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SortedSet<V> get() {
            return new TreeSet(this.f21249a);
        }
    }

    /* synthetic */ uc(a aVar) {
        this();
    }

    public static <K0 extends Enum<K0>> k<K0> c(Class<K0> cls) {
        com.google.common.base.e0.E(cls);
        return new d(cls);
    }

    public static k<Object> d() {
        return e(8);
    }

    public static k<Object> e(int i7) {
        f2.b(i7, "expectedKeys");
        return new a(i7);
    }

    public static k<Object> f() {
        return g(8);
    }

    public static k<Object> g(int i7) {
        f2.b(i7, "expectedKeys");
        return new b(i7);
    }

    public static k<Comparable> h() {
        return i(td.A());
    }

    public static <K0> k<K0> i(Comparator<K0> comparator) {
        com.google.common.base.e0.E(comparator);
        return new c(comparator);
    }

    public abstract <K extends K0, V extends V0> tc<K, V> a();

    public <K extends K0, V extends V0> tc<K, V> b(tc<? extends K, ? extends V> tcVar) {
        tc<K, V> tcVarA = a();
        tcVarA.H(tcVar);
        return tcVarA;
    }

    private uc() {
    }
}
