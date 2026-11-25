package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.rules.l;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f39882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f39883e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f39884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f39885g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? extends Annotation> f39886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f39887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<k> f39888c;

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<? extends Annotation> f39889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f39890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<k> f39891c;

        a d() {
            return new a(this);
        }

        b e() {
            this.f39890b = true;
            return this;
        }

        b f(k kVar) {
            this.f39891c.add(kVar);
            return this;
        }

        private b(Class<? extends Annotation> cls) {
            this.f39889a = cls;
            this.f39890b = false;
            this.f39891c = new ArrayList();
        }
    }

    private static final class c implements k {
        private c() {
        }

        private boolean b(org.junit.runners.model.c<?> cVar) {
            return Modifier.isPublic(cVar.a().getModifiers());
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (b(cVar)) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must be declared in a public class."));
        }
    }

    private static final class d implements k {
        private d() {
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (a.f(cVar)) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must implement MethodRule or TestRule."));
        }
    }

    private static final class e implements k {
        private e() {
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (a.g(cVar)) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must implement TestRule."));
        }
    }

    private static final class f implements k {
        private f() {
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            boolean zE = a.e(cVar);
            boolean z7 = cVar.getAnnotation(org.junit.h.class) != null;
            if (cVar.h()) {
                if (zE || !z7) {
                    list.add(new org.junit.internal.runners.rules.b(cVar, cls, a.e(cVar) ? "must not be static." : "must not be static or it must be annotated with @ClassRule."));
                }
            }
        }
    }

    private static final class g implements k {
        private g() {
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (cVar.e()) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must be public."));
        }
    }

    private static final class h implements k {
        private h() {
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (cVar.h()) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must be static."));
        }
    }

    private static final class i implements k {
        private i() {
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (a.f(cVar)) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must return an implementation of MethodRule or TestRule."));
        }
    }

    private static final class j implements k {
        private j() {
        }

        @Override // org.junit.internal.runners.rules.a.k
        public void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list) {
            if (a.g(cVar)) {
                return;
            }
            list.add(new org.junit.internal.runners.rules.b(cVar, cls, "must return an implementation of TestRule."));
        }
    }

    interface k {
        void a(org.junit.runners.model.c<?> cVar, Class<? extends Annotation> cls, List<Throwable> list);
    }

    static {
        f39882d = d().f(new c()).f(new h()).f(new g()).f(new e()).d();
        f39883e = h().f(new f()).f(new g()).f(new d()).d();
        f39884f = d().e().f(new c()).f(new h()).f(new g()).f(new j()).d();
        f39885g = h().e().f(new f()).f(new g()).f(new i()).d();
    }

    a(b bVar) {
        this.f39886a = bVar.f39889a;
        this.f39887b = bVar.f39890b;
        this.f39888c = bVar.f39891c;
    }

    private static b d() {
        return new b(org.junit.h.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(org.junit.runners.model.c<?> cVar) {
        return org.junit.rules.f.class.isAssignableFrom(cVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(org.junit.runners.model.c<?> cVar) {
        return e(cVar) || g(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(org.junit.runners.model.c<?> cVar) {
        return l.class.isAssignableFrom(cVar.d());
    }

    private static b h() {
        return new b(org.junit.l.class);
    }

    private void j(org.junit.runners.model.c<?> cVar, List<Throwable> list) {
        Iterator<k> it = this.f39888c.iterator();
        while (it.hasNext()) {
            it.next().a(cVar, this.f39886a, list);
        }
    }

    public void i(org.junit.runners.model.k kVar, List<Throwable> list) {
        Iterator it = (this.f39887b ? kVar.i(this.f39886a) : kVar.e(this.f39886a)).iterator();
        while (it.hasNext()) {
            j((org.junit.runners.model.c) it.next(), list);
        }
    }
}
