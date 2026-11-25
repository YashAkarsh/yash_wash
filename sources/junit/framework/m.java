package junit.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<k> f34365a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List<k> f34366b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<l> f34367c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f34368d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f34369e = false;

    class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f34370a;

        a(j jVar) throws Throwable {
            this.f34370a = jVar;
        }

        @Override // junit.framework.h
        public void a() throws Throwable {
            this.f34370a.R();
        }
    }

    private synchronized List<l> d() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f34367c);
        return arrayList;
    }

    public synchronized void a(i iVar, Throwable th) {
        this.f34366b.add(new k(iVar, th));
        Iterator<l> it = d().iterator();
        while (it.hasNext()) {
            it.next().a(iVar, th);
        }
    }

    public synchronized void b(i iVar, b bVar) {
        this.f34365a.add(new k(iVar, bVar));
        Iterator<l> it = d().iterator();
        while (it.hasNext()) {
            it.next().b(iVar, bVar);
        }
    }

    public synchronized void c(l lVar) {
        this.f34367c.add(lVar);
    }

    public void e(i iVar) {
        Iterator<l> it = d().iterator();
        while (it.hasNext()) {
            it.next().c(iVar);
        }
    }

    public synchronized int f() {
        return this.f34366b.size();
    }

    public synchronized Enumeration<k> g() {
        return Collections.enumeration(this.f34366b);
    }

    public synchronized int h() {
        return this.f34365a.size();
    }

    public synchronized Enumeration<k> i() {
        return Collections.enumeration(this.f34365a);
    }

    public synchronized void j(l lVar) {
        this.f34367c.remove(lVar);
    }

    protected void k(j jVar) {
        o(jVar);
        m(jVar, new a(jVar));
        e(jVar);
    }

    public synchronized int l() {
        return this.f34368d;
    }

    public void m(i iVar, h hVar) {
        try {
            hVar.a();
        } catch (ThreadDeath e8) {
            throw e8;
        } catch (b e9) {
            b(iVar, e9);
        } catch (Throwable th) {
            a(iVar, th);
        }
    }

    public synchronized boolean n() {
        return this.f34369e;
    }

    public void o(i iVar) {
        int iA = iVar.a();
        synchronized (this) {
            this.f34368d += iA;
        }
        Iterator<l> it = d().iterator();
        while (it.hasNext()) {
            it.next().d(iVar);
        }
    }

    public synchronized void p() {
        this.f34369e = true;
    }

    public synchronized boolean q() {
        return h() == 0 && f() == 0;
    }
}
