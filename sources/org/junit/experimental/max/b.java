package org.junit.experimental.max;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import junit.framework.n;
import org.junit.runner.h;
import org.junit.runner.i;
import org.junit.runner.j;
import org.junit.runner.l;
import org.junit.runners.g;
import org.junit.runners.model.e;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f39773b = "malformed JUnit 3 test class: ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f39774a;

    class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f39775a;

        /* JADX INFO: renamed from: org.junit.experimental.max.b$a$a, reason: collision with other inner class name */
        class C0530a extends g {
            C0530a(Class cls, List list) throws e {
                super((Class<?>) cls, (List<l>) list);
            }
        }

        a(List list) {
            this.f39775a = list;
        }

        @Override // org.junit.runner.i
        public l h() {
            try {
                return new C0530a(null, this.f39775a);
            } catch (e e8) {
                return new org.junit.internal.runners.b(null, e8);
            }
        }
    }

    private b(File file) {
        this.f39774a = c.b(file);
    }

    private l a(org.junit.runner.c cVar) {
        if (cVar.toString().equals("TestSuite with 0 tests")) {
            return g.H();
        }
        if (cVar.toString().startsWith(f39773b)) {
            return new org.junit.internal.runners.e(new n(f(cVar)));
        }
        Class<?> clsQ = cVar.q();
        if (clsQ != null) {
            String strP = cVar.p();
            return strP == null ? i.a(clsQ).h() : i.i(clsQ, strP).h();
        }
        throw new RuntimeException("Can't build a runner from description [" + cVar + "]");
    }

    private i b(List<org.junit.runner.c> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<org.junit.runner.c> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return new a(arrayList);
    }

    private List<org.junit.runner.c> c(i iVar) {
        ArrayList arrayList = new ArrayList();
        d(null, iVar.h().b(), arrayList);
        return arrayList;
    }

    private void d(org.junit.runner.c cVar, org.junit.runner.c cVar2, List<org.junit.runner.c> list) {
        if (!cVar2.m().isEmpty()) {
            Iterator<org.junit.runner.c> it = cVar2.m().iterator();
            while (it.hasNext()) {
                d(cVar2, it.next(), list);
            }
        } else {
            if (!cVar2.toString().equals("warning(junit.framework.TestSuite$1)")) {
                list.add(cVar2);
                return;
            }
            list.add(org.junit.runner.c.e(f39773b + cVar, new Annotation[0]));
        }
    }

    @Deprecated
    public static b e(String str) {
        return l(new File(str));
    }

    private Class<?> f(org.junit.runner.c cVar) {
        try {
            return Class.forName(cVar.toString().replace(f39773b, ""));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static b l(File file) {
        return new b(file);
    }

    public j g(Class<?> cls) {
        return h(i.a(cls));
    }

    public j h(i iVar) {
        return i(iVar, new h());
    }

    public j i(i iVar, h hVar) {
        hVar.a(this.f39774a.f());
        return hVar.i(j(iVar).h());
    }

    public i j(i iVar) {
        if (iVar instanceof d7.c) {
            return iVar;
        }
        List<org.junit.runner.c> listC = c(iVar);
        Collections.sort(listC, this.f39774a.k());
        return b(listC);
    }

    public List<org.junit.runner.c> k(i iVar) {
        return c(j(iVar));
    }
}
