package junit.extensions;

import junit.framework.i;
import junit.framework.j;
import junit.framework.m;
import junit.framework.n;

/* JADX INFO: loaded from: classes2.dex */
public class a extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f34333c;

    /* JADX INFO: renamed from: junit.extensions.a$a, reason: collision with other inner class name */
    class C0419a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f34334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f34335b;

        C0419a(i iVar, m mVar) {
            this.f34334a = iVar;
            this.f34335b = mVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f34334a.c(this.f34335b);
            } finally {
                a.this.u();
            }
        }
    }

    public a() {
    }

    @Override // junit.framework.n, junit.framework.i
    public void c(m mVar) {
        this.f34333c = 0;
        super.c(mVar);
        v();
    }

    @Override // junit.framework.n
    public void n(i iVar, m mVar) {
        new C0419a(iVar, mVar).start();
    }

    public synchronized void u() {
        this.f34333c++;
        notifyAll();
    }

    synchronized void v() {
        while (this.f34333c < r()) {
            try {
                wait();
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public a(Class<? extends j> cls) {
        super(cls);
    }

    public a(String str) {
        super(str);
    }

    public a(Class<? extends j> cls, String str) {
        super(cls, str);
    }
}
