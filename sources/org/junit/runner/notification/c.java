package org.junit.runner.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.runner.j;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<org.junit.runner.notification.b> f39998a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f39999b = false;

    class a extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.c f40000c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(org.junit.runner.c cVar) throws Exception {
            super(c.this);
            this.f40000c = cVar;
        }

        @Override // org.junit.runner.notification.c.h
        protected void a(org.junit.runner.notification.b bVar) throws Exception {
            bVar.f(this.f40000c);
        }
    }

    class b extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f40002c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(j jVar) throws Exception {
            super(c.this);
            this.f40002c = jVar;
        }

        @Override // org.junit.runner.notification.c.h
        protected void a(org.junit.runner.notification.b bVar) throws Exception {
            bVar.e(this.f40002c);
        }
    }

    /* JADX INFO: renamed from: org.junit.runner.notification.c$c, reason: collision with other inner class name */
    class C0541c extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.c f40004c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0541c(org.junit.runner.c cVar) throws Exception {
            super(c.this);
            this.f40004c = cVar;
        }

        @Override // org.junit.runner.notification.c.h
        protected void a(org.junit.runner.notification.b bVar) throws Exception {
            bVar.g(this.f40004c);
        }
    }

    class d extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f40006c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, List list2) throws Exception {
            super(list);
            this.f40006c = list2;
        }

        @Override // org.junit.runner.notification.c.h
        protected void a(org.junit.runner.notification.b bVar) throws Exception {
            Iterator it = this.f40006c.iterator();
            while (it.hasNext()) {
                bVar.b((org.junit.runner.notification.a) it.next());
            }
        }
    }

    class e extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.notification.a f40008c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(org.junit.runner.notification.a aVar) {
            super(c.this);
            this.f40008c = aVar;
        }

        @Override // org.junit.runner.notification.c.h
        protected void a(org.junit.runner.notification.b bVar) throws Exception {
            bVar.a(this.f40008c);
        }
    }

    class f extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.c f40010c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(org.junit.runner.c cVar) throws Exception {
            super(c.this);
            this.f40010c = cVar;
        }

        @Override // org.junit.runner.notification.c.h
        protected void a(org.junit.runner.notification.b bVar) throws Exception {
            bVar.d(this.f40010c);
        }
    }

    class g extends h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ org.junit.runner.c f40012c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(org.junit.runner.c cVar) throws Exception {
            super(c.this);
            this.f40012c = cVar;
        }

        @Override // org.junit.runner.notification.c.h
        protected void a(org.junit.runner.notification.b bVar) throws Exception {
            bVar.c(this.f40012c);
        }
    }

    private abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<org.junit.runner.notification.b> f40014a;

        h(c cVar) {
            this(cVar.f39998a);
        }

        protected abstract void a(org.junit.runner.notification.b bVar) throws Exception;

        void b() {
            int size = this.f40014a.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (org.junit.runner.notification.b bVar : this.f40014a) {
                try {
                    a(bVar);
                    arrayList.add(bVar);
                } catch (Exception e8) {
                    arrayList2.add(new org.junit.runner.notification.a(org.junit.runner.c.f39959i, e8));
                }
            }
            c.this.g(arrayList, arrayList2);
        }

        h(List<org.junit.runner.notification.b> list) {
            this.f40014a = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<org.junit.runner.notification.b> list, List<org.junit.runner.notification.a> list2) {
        if (list2.isEmpty()) {
            return;
        }
        new d(list, list2).b();
    }

    public void c(org.junit.runner.notification.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Cannot add a null listener");
        }
        this.f39998a.add(0, o(bVar));
    }

    public void d(org.junit.runner.notification.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Cannot add a null listener");
        }
        this.f39998a.add(o(bVar));
    }

    public void e(org.junit.runner.notification.a aVar) {
        new e(aVar).b();
    }

    public void f(org.junit.runner.notification.a aVar) {
        g(this.f39998a, Arrays.asList(aVar));
    }

    public void h(org.junit.runner.c cVar) {
        new g(cVar).b();
    }

    public void i(org.junit.runner.c cVar) {
        new f(cVar).b();
    }

    public void j(j jVar) {
        new b(jVar).b();
    }

    public void k(org.junit.runner.c cVar) {
        new a(cVar).b();
    }

    public void l(org.junit.runner.c cVar) throws org.junit.runner.notification.d {
        if (this.f39999b) {
            throw new org.junit.runner.notification.d();
        }
        new C0541c(cVar).b();
    }

    public void m() {
        this.f39999b = true;
    }

    public void n(org.junit.runner.notification.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Cannot remove a null listener");
        }
        this.f39998a.remove(o(bVar));
    }

    org.junit.runner.notification.b o(org.junit.runner.notification.b bVar) {
        return bVar.getClass().isAnnotationPresent(org.junit.runner.notification.b.a.class) ? bVar : new org.junit.runner.notification.e(bVar, this);
    }
}
