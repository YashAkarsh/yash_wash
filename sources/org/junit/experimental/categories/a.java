package org.junit.experimental.categories;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.runners.g;
import org.junit.runners.model.h;

/* JADX INFO: loaded from: classes3.dex */
public class a extends g {

    /* JADX INFO: renamed from: org.junit.experimental.categories.a$a, reason: collision with other inner class name */
    public static class C0529a extends org.junit.runner.manipulation.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<Class<?>> f39767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<Class<?>> f39768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f39769d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f39770e;

        protected C0529a(boolean z7, Set<Class<?>> set, boolean z8, Set<Class<?>> set2) {
            this.f39769d = z7;
            this.f39770e = z8;
            this.f39767b = h(set);
            this.f39768c = h(set2);
        }

        private static Set<Class<?>> f(org.junit.runner.c cVar) {
            HashSet hashSet = new HashSet();
            Collections.addAll(hashSet, i(cVar));
            Collections.addAll(hashSet, i(t(cVar)));
            return hashSet;
        }

        public static C0529a g(boolean z7, Set<Class<?>> set, boolean z8, Set<Class<?>> set2) {
            return new C0529a(z7, set, z8, set2);
        }

        private static Set<Class<?>> h(Set<Class<?>> set) {
            HashSet hashSet = new HashSet();
            if (set != null) {
                hashSet.addAll(set);
            }
            hashSet.remove(null);
            return hashSet;
        }

        private static Class<?>[] i(org.junit.runner.c cVar) {
            if (cVar == null) {
                return new Class[0];
            }
            org.junit.experimental.categories.b bVar = (org.junit.experimental.categories.b) cVar.k(org.junit.experimental.categories.b.class);
            return bVar == null ? new Class[0] : bVar.value();
        }

        public static C0529a j(Class<?> cls) {
            return k(true, cls);
        }

        public static C0529a k(boolean z7, Class<?>... clsArr) {
            if (n(clsArr)) {
                throw new NullPointerException("has null category");
            }
            return g(true, null, z7, a.P(clsArr));
        }

        public static C0529a l(Class<?>... clsArr) {
            return k(true, clsArr);
        }

        private boolean m(org.junit.runner.c cVar) {
            Set<Class<?>> setF = f(cVar);
            if (setF.isEmpty()) {
                return this.f39767b.isEmpty();
            }
            if (!this.f39768c.isEmpty()) {
                if (this.f39770e) {
                    if (s(setF, this.f39768c)) {
                        return false;
                    }
                } else if (r(setF, this.f39768c)) {
                    return false;
                }
            }
            if (this.f39767b.isEmpty()) {
                return true;
            }
            return this.f39769d ? s(setF, this.f39767b) : r(setF, this.f39767b);
        }

        private static boolean n(Class<?>... clsArr) {
            if (clsArr == null) {
                return false;
            }
            for (Class<?> cls : clsArr) {
                if (cls == null) {
                    return true;
                }
            }
            return false;
        }

        public static C0529a o(Class<?> cls) {
            return p(true, cls);
        }

        public static C0529a p(boolean z7, Class<?>... clsArr) {
            if (n(clsArr)) {
                throw new NullPointerException("has null category");
            }
            return g(z7, a.P(clsArr), true, null);
        }

        public static C0529a q(Class<?>... clsArr) {
            return p(true, clsArr);
        }

        private boolean r(Set<Class<?>> set, Set<Class<?>> set2) {
            Iterator<Class<?>> it = set2.iterator();
            while (it.hasNext()) {
                if (!a.S(set, it.next())) {
                    return false;
                }
            }
            return true;
        }

        private boolean s(Set<Class<?>> set, Set<Class<?>> set2) {
            Iterator<Class<?>> it = set2.iterator();
            while (it.hasNext()) {
                if (a.S(set, it.next())) {
                    return true;
                }
            }
            return false;
        }

        private static org.junit.runner.c t(org.junit.runner.c cVar) {
            Class<?> clsQ = cVar.q();
            if (clsQ == null) {
                return null;
            }
            return org.junit.runner.c.c(clsQ);
        }

        @Override // org.junit.runner.manipulation.a
        public String b() {
            return toString();
        }

        @Override // org.junit.runner.manipulation.a
        public boolean e(org.junit.runner.c cVar) {
            if (m(cVar)) {
                return true;
            }
            Iterator<org.junit.runner.c> it = cVar.m().iterator();
            while (it.hasNext()) {
                if (e(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("categories ");
            sb.append(this.f39767b.isEmpty() ? "[all]" : this.f39767b);
            if (!this.f39768c.isEmpty()) {
                sb.append(" - ");
                sb.append(this.f39768c);
            }
            return sb.toString();
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        boolean matchAny() default true;

        Class<?>[] value() default {};
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        boolean matchAny() default true;

        Class<?>[] value() default {};
    }

    public a(Class<?> cls, h hVar) throws org.junit.runners.model.e {
        super(cls, hVar);
        try {
            d(C0529a.g(U(cls), R(cls), T(cls), Q(cls)));
            M(b());
        } catch (org.junit.runner.manipulation.c e8) {
            throw new org.junit.runners.model.e(e8);
        }
    }

    private static void M(org.junit.runner.c cVar) throws org.junit.runners.model.e {
        if (!O(cVar)) {
            N(cVar);
        }
        Iterator<org.junit.runner.c> it = cVar.m().iterator();
        while (it.hasNext()) {
            M(it.next());
        }
    }

    private static void N(org.junit.runner.c cVar) throws org.junit.runners.model.e {
        for (org.junit.runner.c cVar2 : cVar.m()) {
            if (cVar2.k(org.junit.experimental.categories.b.class) != null) {
                throw new org.junit.runners.model.e("Category annotations on Parameterized classes are not supported on individual methods.");
            }
            N(cVar2);
        }
    }

    private static boolean O(org.junit.runner.c cVar) {
        Iterator<org.junit.runner.c> it = cVar.m().iterator();
        while (it.hasNext()) {
            if (it.next().q() == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<Class<?>> P(Class<?>... clsArr) {
        HashSet hashSet = new HashSet();
        if (clsArr != null) {
            Collections.addAll(hashSet, clsArr);
        }
        return hashSet;
    }

    private static Set<Class<?>> Q(Class<?> cls) {
        b bVar = (b) cls.getAnnotation(b.class);
        return P(bVar == null ? null : bVar.value());
    }

    private static Set<Class<?>> R(Class<?> cls) {
        c cVar = (c) cls.getAnnotation(c.class);
        return P(cVar == null ? null : cVar.value());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean S(Set<Class<?>> set, Class<?> cls) {
        Iterator<Class<?>> it = set.iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean T(Class<?> cls) {
        b bVar = (b) cls.getAnnotation(b.class);
        return bVar == null || bVar.matchAny();
    }

    private static boolean U(Class<?> cls) {
        c cVar = (c) cls.getAnnotation(c.class);
        return cVar == null || cVar.matchAny();
    }
}
