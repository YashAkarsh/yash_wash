package org.junit.experimental.theories.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.experimental.theories.g;
import org.junit.runners.model.k;

/* JADX INFO: loaded from: classes3.dex */
public class a extends org.junit.experimental.theories.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f39809a;

    static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final org.junit.runners.model.d f39810a;

        @Override // org.junit.experimental.theories.g
        public String b() throws g.b {
            return this.f39810a.c();
        }

        @Override // org.junit.experimental.theories.g
        public Object c() throws g.b {
            try {
                return this.f39810a.m(null, new Object[0]);
            } catch (IllegalAccessException unused) {
                throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
            } catch (IllegalArgumentException unused2) {
                throw new RuntimeException("unexpected: argument length is checked");
            } catch (Throwable th) {
                org.junit.experimental.theories.a aVar = (org.junit.experimental.theories.a) this.f39810a.getAnnotation(org.junit.experimental.theories.a.class);
                org.junit.d.i(aVar == null || !a.o(aVar.ignoredExceptions(), th));
                throw new g.b(th);
            }
        }

        private b(org.junit.runners.model.d dVar) {
            this.f39810a = dVar;
        }
    }

    public a(k kVar) {
        this.f39809a = kVar;
    }

    private void c(org.junit.experimental.theories.d dVar, String str, List<g> list, Object obj) {
        for (int i7 = 0; i7 < Array.getLength(obj); i7++) {
            Object obj2 = Array.get(obj, i7);
            if (dVar.c(obj2)) {
                list.add(g.a(str + "[" + i7 + "]", obj2));
            }
        }
    }

    private void d(Class<?> cls, org.junit.experimental.theories.d dVar, String str, List<g> list, Object obj) {
        if (cls.isArray()) {
            c(dVar, str, list, obj);
        } else if (Iterable.class.isAssignableFrom(cls)) {
            e(dVar, str, list, (Iterable) obj);
        }
    }

    private void e(org.junit.experimental.theories.d dVar, String str, List<g> list, Iterable<?> iterable) {
        int i7 = 0;
        for (Object obj : iterable) {
            if (dVar.c(obj)) {
                list.add(g.a(str + "[" + i7 + "]", obj));
            }
            i7++;
        }
    }

    private void f(org.junit.experimental.theories.d dVar, List<g> list) {
        for (Field field : j(dVar)) {
            d(field.getType(), dVar, field.getName(), list, n(field));
        }
    }

    private void g(org.junit.experimental.theories.d dVar, List<g> list) throws Throwable {
        for (org.junit.runners.model.d dVar2 : k(dVar)) {
            Class<?> clsL = dVar2.l();
            if ((clsL.isArray() && dVar.d(clsL.getComponentType())) || Iterable.class.isAssignableFrom(clsL)) {
                try {
                    d(clsL, dVar, dVar2.c(), list, dVar2.m(null, new Object[0]));
                } catch (Throwable th) {
                    org.junit.experimental.theories.b bVar = (org.junit.experimental.theories.b) dVar2.getAnnotation(org.junit.experimental.theories.b.class);
                    if (bVar == null || !o(bVar.ignoredExceptions(), th)) {
                        throw th;
                    }
                    return;
                }
            }
        }
    }

    private void h(org.junit.experimental.theories.d dVar, List<g> list) {
        for (Field field : l(dVar)) {
            Object objN = n(field);
            if (dVar.c(objN)) {
                list.add(g.a(field.getName(), objN));
            }
        }
    }

    private void i(org.junit.experimental.theories.d dVar, List<g> list) {
        for (org.junit.runners.model.d dVar2 : m(dVar)) {
            if (dVar.b(dVar2.d())) {
                list.add(new b(dVar2));
            }
        }
    }

    private Object n(Field field) {
        try {
            return field.get(null);
        } catch (IllegalAccessException unused) {
            throw new RuntimeException("unexpected: getFields returned an inaccessible field");
        } catch (IllegalArgumentException unused2) {
            throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(Class<?>[] clsArr, Object obj) {
        for (Class<?> cls : clsArr) {
            if (cls.isAssignableFrom(obj.getClass())) {
                return true;
            }
        }
        return false;
    }

    @Override // org.junit.experimental.theories.e
    public List<g> a(org.junit.experimental.theories.d dVar) throws Throwable {
        ArrayList arrayList = new ArrayList();
        h(dVar, arrayList);
        f(dVar, arrayList);
        i(dVar, arrayList);
        g(dVar, arrayList);
        return arrayList;
    }

    protected Collection<Field> j(org.junit.experimental.theories.d dVar) {
        List<org.junit.runners.model.b> listE = this.f39809a.e(org.junit.experimental.theories.b.class);
        ArrayList arrayList = new ArrayList();
        Iterator<org.junit.runners.model.b> it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().j());
        }
        return arrayList;
    }

    protected Collection<org.junit.runners.model.d> k(org.junit.experimental.theories.d dVar) {
        return this.f39809a.i(org.junit.experimental.theories.b.class);
    }

    protected Collection<Field> l(org.junit.experimental.theories.d dVar) {
        List<org.junit.runners.model.b> listE = this.f39809a.e(org.junit.experimental.theories.a.class);
        ArrayList arrayList = new ArrayList();
        Iterator<org.junit.runners.model.b> it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().j());
        }
        return arrayList;
    }

    protected Collection<org.junit.runners.model.d> m(org.junit.experimental.theories.d dVar) {
        return this.f39809a.i(org.junit.experimental.theories.a.class);
    }
}
