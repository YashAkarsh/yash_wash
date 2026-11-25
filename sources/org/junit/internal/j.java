package org.junit.internal;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes3.dex */
public class j extends org.junit.runner.notification.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PrintStream f39844a;

    public j(g gVar) {
        this(gVar.a());
    }

    private PrintStream i() {
        return this.f39844a;
    }

    @Override // org.junit.runner.notification.b
    public void b(org.junit.runner.notification.a aVar) {
        this.f39844a.append('E');
    }

    @Override // org.junit.runner.notification.b
    public void d(org.junit.runner.c cVar) {
        this.f39844a.append('I');
    }

    @Override // org.junit.runner.notification.b
    public void e(org.junit.runner.j jVar) {
        m(jVar.k());
        k(jVar);
        l(jVar);
    }

    @Override // org.junit.runner.notification.b
    public void g(org.junit.runner.c cVar) {
        this.f39844a.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    protected String h(long j7) {
        return NumberFormat.getInstance().format(j7 / 1000.0d);
    }

    protected void j(org.junit.runner.notification.a aVar, String str) {
        i().println(str + ") " + aVar.d());
        i().print(aVar.e());
    }

    protected void k(org.junit.runner.j jVar) {
        List<org.junit.runner.notification.a> listH = jVar.h();
        if (listH.size() == 0) {
            return;
        }
        int i7 = 1;
        if (listH.size() == 1) {
            i().println("There was " + listH.size() + " failure:");
        } else {
            i().println("There were " + listH.size() + " failures:");
        }
        Iterator<org.junit.runner.notification.a> it = listH.iterator();
        while (it.hasNext()) {
            j(it.next(), "" + i7);
            i7++;
        }
    }

    protected void l(org.junit.runner.j jVar) {
        if (jVar.l()) {
            i().println();
            i().print("OK");
            PrintStream printStreamI = i();
            StringBuilder sb = new StringBuilder();
            sb.append(" (");
            sb.append(jVar.j());
            sb.append(" test");
            sb.append(jVar.j() == 1 ? "" : "s");
            sb.append(")");
            printStreamI.println(sb.toString());
        } else {
            i().println();
            i().println("FAILURES!!!");
            i().println("Tests run: " + jVar.j() + ",  Failures: " + jVar.g());
        }
        i().println();
    }

    protected void m(long j7) {
        i().println();
        i().println("Time: " + h(j7));
    }

    public j(PrintStream printStream) {
        this.f39844a = printStream;
    }
}
