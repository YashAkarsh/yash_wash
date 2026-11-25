package com.google.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@s1.b(emulated = true)
public final class h0 {

    private static class b<T> implements g0<T>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19387b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<? extends g0<? super T>> f19388a;

        @Override // com.google.common.base.g0
        public boolean apply(T t7) {
            for (int i7 = 0; i7 < this.f19388a.size(); i7++) {
                if (!this.f19388a.get(i7).apply(t7)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.base.g0
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f19388a.equals(((b) obj).f19388a);
            }
            return false;
        }

        public int hashCode() {
            return this.f19388a.hashCode() + 306654252;
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }

        public String toString() {
            return h0.w("and", this.f19388a);
        }

        private b(List<? extends g0<? super T>> list) {
            this.f19388a = list;
        }
    }

    private static class c<A, B> implements g0<A>, Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f19389c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g0<B> f19390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final s<A, ? extends B> f19391b;

        @Override // com.google.common.base.g0
        public boolean apply(A a8) {
            return this.f19390a.apply(this.f19391b.apply(a8));
        }

        @Override // com.google.common.base.g0
        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f19391b.equals(cVar.f19391b) && this.f19390a.equals(cVar.f19390a);
        }

        public int hashCode() {
            return this.f19391b.hashCode() ^ this.f19390a.hashCode();
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }

        public String toString() {
            return this.f19390a + "(" + this.f19391b + ")";
        }

        private c(g0<B> g0Var, s<A, ? extends B> sVar) {
            this.f19390a = (g0) e0.E(g0Var);
            this.f19391b = (s) e0.E(sVar);
        }
    }

    @s1.c
    private static class d extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f19392c = 0;

        d(String str) {
            super(d0.a(str));
        }

        @Override // com.google.common.base.h0.e
        public String toString() {
            return "Predicates.containsPattern(" + this.f19394a.e() + ")";
        }
    }

    @s1.c
    private static class e implements g0<CharSequence>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19393b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.google.common.base.h f19394a;

        e(com.google.common.base.h hVar) {
            this.f19394a = (com.google.common.base.h) e0.E(hVar);
        }

        @Override // com.google.common.base.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(CharSequence charSequence) {
            return this.f19394a.d(charSequence).b();
        }

        @Override // com.google.common.base.g0
        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return y.a(this.f19394a.e(), eVar.f19394a.e()) && this.f19394a.b() == eVar.f19394a.b();
        }

        public int hashCode() {
            return y.b(this.f19394a.e(), Integer.valueOf(this.f19394a.b()));
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }

        public String toString() {
            return "Predicates.contains(" + x.c(this.f19394a).f("pattern", this.f19394a.e()).d("pattern.flags", this.f19394a.b()).toString() + ")";
        }
    }

    private static class f<T> implements g0<T>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19395b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Collection<?> f19396a;

        @Override // com.google.common.base.g0
        public boolean apply(T t7) {
            try {
                return this.f19396a.contains(t7);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.g0
        public boolean equals(Object obj) {
            if (obj instanceof f) {
                return this.f19396a.equals(((f) obj).f19396a);
            }
            return false;
        }

        public int hashCode() {
            return this.f19396a.hashCode();
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }

        public String toString() {
            return "Predicates.in(" + this.f19396a + ")";
        }

        private f(Collection<?> collection) {
            this.f19396a = (Collection) e0.E(collection);
        }
    }

    @s1.c
    private static class g implements g0<Object>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19397b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<?> f19398a;

        @Override // com.google.common.base.g0
        public boolean apply(Object obj) {
            return this.f19398a.isInstance(obj);
        }

        @Override // com.google.common.base.g0
        public boolean equals(Object obj) {
            return (obj instanceof g) && this.f19398a == ((g) obj).f19398a;
        }

        public int hashCode() {
            return this.f19398a.hashCode();
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.f19398a.getName() + ")";
        }

        private g(Class<?> cls) {
            this.f19398a = (Class) e0.E(cls);
        }
    }

    private static class h<T> implements g0<T>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19399b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f19400a;

        @Override // com.google.common.base.g0
        public boolean apply(T t7) {
            return this.f19400a.equals(t7);
        }

        @Override // com.google.common.base.g0
        public boolean equals(Object obj) {
            if (obj instanceof h) {
                return this.f19400a.equals(((h) obj).f19400a);
            }
            return false;
        }

        public int hashCode() {
            return this.f19400a.hashCode();
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }

        public String toString() {
            return "Predicates.equalTo(" + this.f19400a + ")";
        }

        private h(T t7) {
            this.f19400a = t7;
        }
    }

    private static class i<T> implements g0<T>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19401b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g0<T> f19402a;

        i(g0<T> g0Var) {
            this.f19402a = (g0) e0.E(g0Var);
        }

        @Override // com.google.common.base.g0
        public boolean apply(T t7) {
            return !this.f19402a.apply(t7);
        }

        @Override // com.google.common.base.g0
        public boolean equals(Object obj) {
            if (obj instanceof i) {
                return this.f19402a.equals(((i) obj).f19402a);
            }
            return false;
        }

        public int hashCode() {
            return ~this.f19402a.hashCode();
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }

        public String toString() {
            return "Predicates.not(" + this.f19402a + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static abstract class j implements g0<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f19403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j f19404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final j f19405c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final j f19406d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ j[] f19407e;

        static enum a extends j {
            a(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.base.g0
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        static enum b extends j {
            b(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.base.g0
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        static enum c extends j {
            c(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.base.g0
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        static enum d extends j {
            d(String str, int i7) {
                super(str, i7);
            }

            @Override // com.google.common.base.g0
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        static {
            a aVar = new a("ALWAYS_TRUE", 0);
            f19403a = aVar;
            b bVar = new b("ALWAYS_FALSE", 1);
            f19404b = bVar;
            c cVar = new c("IS_NULL", 2);
            f19405c = cVar;
            d dVar = new d("NOT_NULL", 3);
            f19406d = dVar;
            f19407e = new j[]{aVar, bVar, cVar, dVar};
        }

        private j(String str, int i7) {
            super(str, i7);
        }

        public static j valueOf(String str) {
            return (j) Enum.valueOf(j.class, str);
        }

        public static j[] values() {
            return (j[]) f19407e.clone();
        }

        <T> g0<T> a() {
            return this;
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }
    }

    private static class k<T> implements g0<T>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19408b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<? extends g0<? super T>> f19409a;

        @Override // com.google.common.base.g0
        public boolean apply(T t7) {
            for (int i7 = 0; i7 < this.f19409a.size(); i7++) {
                if (this.f19409a.get(i7).apply(t7)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.base.g0
        public boolean equals(Object obj) {
            if (obj instanceof k) {
                return this.f19409a.equals(((k) obj).f19409a);
            }
            return false;
        }

        public int hashCode() {
            return this.f19409a.hashCode() + 87855567;
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }

        public String toString() {
            return h0.w("or", this.f19409a);
        }

        private k(List<? extends g0<? super T>> list) {
            this.f19409a = list;
        }
    }

    @s1.c
    private static class l implements g0<Class<?>>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19410b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<?> f19411a;

        @Override // com.google.common.base.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(Class<?> cls) {
            return this.f19411a.isAssignableFrom(cls);
        }

        @Override // com.google.common.base.g0
        public boolean equals(Object obj) {
            return (obj instanceof l) && this.f19411a == ((l) obj).f19411a;
        }

        public int hashCode() {
            return this.f19411a.hashCode();
        }

        @Override // com.google.common.base.g0, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return f0.a(this, obj);
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.f19411a.getName() + ")";
        }

        private l(Class<?> cls) {
            this.f19411a = (Class) e0.E(cls);
        }
    }

    private h0() {
    }

    @s1.b(serializable = true)
    public static <T> g0<T> b() {
        return j.f19404b.a();
    }

    @s1.b(serializable = true)
    public static <T> g0<T> c() {
        return j.f19403a.a();
    }

    public static <T> g0<T> d(g0<? super T> g0Var, g0<? super T> g0Var2) {
        return new b(g((g0) e0.E(g0Var), (g0) e0.E(g0Var2)));
    }

    public static <T> g0<T> e(Iterable<? extends g0<? super T>> iterable) {
        return new b(k(iterable));
    }

    @SafeVarargs
    public static <T> g0<T> f(g0<? super T>... g0VarArr) {
        return new b(l(g0VarArr));
    }

    private static <T> List<g0<? super T>> g(g0<? super T> g0Var, g0<? super T> g0Var2) {
        return Arrays.asList(g0Var, g0Var2);
    }

    public static <A, B> g0<A> h(g0<B> g0Var, s<A, ? extends B> sVar) {
        return new c(g0Var, sVar);
    }

    @s1.c("java.util.regex.Pattern")
    public static g0<CharSequence> i(Pattern pattern) {
        return new e(new v(pattern));
    }

    @s1.c
    public static g0<CharSequence> j(String str) {
        return new d(str);
    }

    static <T> List<T> k(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(e0.E(it.next()));
        }
        return arrayList;
    }

    private static <T> List<T> l(T... tArr) {
        return k(Arrays.asList(tArr));
    }

    public static <T> g0<T> m(T t7) {
        return t7 == null ? p() : new h(t7);
    }

    public static <T> g0<T> n(Collection<? extends T> collection) {
        return new f(collection);
    }

    @s1.c
    public static g0<Object> o(Class<?> cls) {
        return new g(cls);
    }

    @s1.b(serializable = true)
    public static <T> g0<T> p() {
        return j.f19405c.a();
    }

    public static <T> g0<T> q(g0<T> g0Var) {
        return new i(g0Var);
    }

    @s1.b(serializable = true)
    public static <T> g0<T> r() {
        return j.f19406d.a();
    }

    public static <T> g0<T> s(g0<? super T> g0Var, g0<? super T> g0Var2) {
        return new k(g((g0) e0.E(g0Var), (g0) e0.E(g0Var2)));
    }

    public static <T> g0<T> t(Iterable<? extends g0<? super T>> iterable) {
        return new k(k(iterable));
    }

    @SafeVarargs
    public static <T> g0<T> u(g0<? super T>... g0VarArr) {
        return new k(l(g0VarArr));
    }

    @s1.a
    @s1.c
    public static g0<Class<?>> v(Class<?> cls) {
        return new l(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String w(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z7 = true;
        for (Object obj : iterable) {
            if (!z7) {
                sb.append(',');
            }
            sb.append(obj);
            z7 = false;
        }
        sb.append(')');
        return sb.toString();
    }
}
