package org.junit.experimental.theories;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.j;
import org.junit.runners.model.k;

/* JADX INFO: loaded from: classes3.dex */
public class h extends org.junit.runners.b {

    public static class a extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final org.junit.runners.model.d f39798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final k f39799c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f39797a = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<org.junit.internal.b> f39800d = new ArrayList();

        /* JADX INFO: renamed from: org.junit.experimental.theories.h$a$a, reason: collision with other inner class name */
        class C0533a extends org.junit.runners.b {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ org.junit.experimental.theories.internal.b f39801g;

            /* JADX INFO: renamed from: org.junit.experimental.theories.h$a$a$a, reason: collision with other inner class name */
            class C0534a extends j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ j f39803a;

                C0534a(j jVar) throws Throwable {
                    this.f39803a = jVar;
                }

                @Override // org.junit.runners.model.j
                public void a() throws Throwable {
                    try {
                        this.f39803a.a();
                        a.this.f();
                    } catch (org.junit.internal.b e8) {
                        a.this.e(e8);
                    } catch (Throwable th) {
                        C0533a c0533a = C0533a.this;
                        a aVar = a.this;
                        aVar.i(th, c0533a.f39801g.g(aVar.h()));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0533a(Class cls, org.junit.experimental.theories.internal.b bVar) throws Throwable {
                super(cls);
                this.f39801g = bVar;
            }

            @Override // org.junit.runners.b
            public Object H() throws Exception {
                Object[] objArrH = this.f39801g.h();
                if (!a.this.h()) {
                    org.junit.d.e(objArrH);
                }
                return t().l().newInstance(objArrH);
            }

            @Override // org.junit.runners.b
            public j Q(org.junit.runners.model.d dVar) {
                return new C0534a(super.Q(dVar));
            }

            @Override // org.junit.runners.b
            protected j R(org.junit.runners.model.d dVar, Object obj) {
                return a.this.g(dVar, this.f39801g, obj);
            }

            @Override // org.junit.runners.b, org.junit.runners.f
            protected void l(List<Throwable> list) {
            }
        }

        class b extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ org.junit.experimental.theories.internal.b f39805a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ org.junit.runners.model.d f39806b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f39807c;

            b(org.junit.experimental.theories.internal.b bVar, org.junit.runners.model.d dVar, Object obj) throws Throwable {
                this.f39805a = bVar;
                this.f39806b = dVar;
                this.f39807c = obj;
            }

            @Override // org.junit.runners.model.j
            public void a() throws Throwable {
                Object[] objArrJ = this.f39805a.j();
                if (!a.this.h()) {
                    org.junit.d.e(objArrJ);
                }
                this.f39806b.m(this.f39807c, objArrJ);
            }
        }

        public a(org.junit.runners.model.d dVar, k kVar) {
            this.f39798b = dVar;
            this.f39799c = kVar;
        }

        private k d() {
            return this.f39799c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public j g(org.junit.runners.model.d dVar, org.junit.experimental.theories.internal.b bVar, Object obj) {
            return new b(bVar, dVar, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h() {
            i iVar = (i) this.f39798b.j().getAnnotation(i.class);
            if (iVar == null) {
                return false;
            }
            return iVar.nullsAccepted();
        }

        @Override // org.junit.runners.model.j
        public void a() throws Throwable {
            j(org.junit.experimental.theories.internal.b.a(this.f39798b.j(), d()));
            boolean z7 = this.f39798b.getAnnotation(i.class) != null;
            if (this.f39797a == 0 && z7) {
                org.junit.c.d0("Never found parameters that satisfied method assumptions.  Violated assumptions: " + this.f39800d);
            }
        }

        protected void e(org.junit.internal.b bVar) {
            this.f39800d.add(bVar);
        }

        protected void f() {
            this.f39797a++;
        }

        protected void i(Throwable th, Object... objArr) throws Throwable {
            if (objArr.length != 0) {
                throw new org.junit.experimental.theories.internal.e(th, this.f39798b.c(), objArr);
            }
            throw th;
        }

        protected void j(org.junit.experimental.theories.internal.b bVar) throws Throwable {
            if (bVar.l()) {
                k(bVar);
            } else {
                l(bVar);
            }
        }

        protected void k(org.junit.experimental.theories.internal.b bVar) throws Throwable {
            new C0533a(d().j(), bVar).Q(this.f39798b).a();
        }

        protected void l(org.junit.experimental.theories.internal.b bVar) throws Throwable {
            Iterator<g> it = bVar.n().iterator();
            while (it.hasNext()) {
                j(bVar.b(it.next()));
            }
        }
    }

    public h(Class<?> cls) throws org.junit.runners.model.e {
        super(cls);
    }

    private void k0(List<Throwable> list) {
        for (Field field : t().j().getDeclaredFields()) {
            if (field.getAnnotation(org.junit.experimental.theories.a.class) != null || field.getAnnotation(b.class) != null) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be static"));
                }
                if (!Modifier.isPublic(field.getModifiers())) {
                    list.add(new Error("DataPoint field " + field.getName() + " must be public"));
                }
            }
        }
    }

    private void l0(List<Throwable> list) {
        for (Method method : t().j().getDeclaredMethods()) {
            if (method.getAnnotation(org.junit.experimental.theories.a.class) != null || method.getAnnotation(b.class) != null) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be static"));
                }
                if (!Modifier.isPublic(method.getModifiers())) {
                    list.add(new Error("DataPoint method " + method.getName() + " must be public"));
                }
            }
        }
    }

    private void m0(Class<? extends e> cls, List<Throwable> list) {
        Constructor<?>[] constructors = cls.getConstructors();
        if (constructors.length != 1) {
            list.add(new Error("ParameterSupplier " + cls.getName() + " must have only one constructor (either empty or taking only a TestClass)"));
            return;
        }
        Class<?>[] parameterTypes = constructors[0].getParameterTypes();
        if (parameterTypes.length == 0 || parameterTypes[0].equals(k.class)) {
            return;
        }
        list.add(new Error("ParameterSupplier " + cls.getName() + " constructor must take either nothing or a single TestClass instance"));
    }

    @Override // org.junit.runners.b
    protected List<org.junit.runners.model.d> G() {
        ArrayList arrayList = new ArrayList(super.G());
        List<org.junit.runners.model.d> listI = t().i(i.class);
        arrayList.removeAll(listI);
        arrayList.addAll(listI);
        return arrayList;
    }

    @Override // org.junit.runners.b
    public j Q(org.junit.runners.model.d dVar) {
        return new a(dVar, t());
    }

    @Override // org.junit.runners.b
    protected void W(List<Throwable> list) {
        b0(list);
    }

    @Override // org.junit.runners.b
    protected void c0(List<Throwable> list) {
        for (org.junit.runners.model.d dVar : G()) {
            if (dVar.getAnnotation(i.class) != null) {
                dVar.q(false, list);
                dVar.p(list);
            } else {
                dVar.r(false, list);
            }
            Iterator<d> it = d.m(dVar.j()).iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next().e(f.class);
                if (fVar != null) {
                    m0(fVar.value(), list);
                }
            }
        }
    }

    @Override // org.junit.runners.b, org.junit.runners.f
    protected void l(List<Throwable> list) {
        super.l(list);
        k0(list);
        l0(list);
    }
}
