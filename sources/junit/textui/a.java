package junit.textui;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;
import junit.framework.i;
import junit.framework.k;
import junit.framework.l;
import junit.framework.m;

/* JADX INFO: loaded from: classes2.dex */
public class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    PrintStream f34382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f34383b = 0;

    public a(PrintStream printStream) {
        this.f34382a = printStream;
    }

    @Override // junit.framework.l
    public void a(i iVar, Throwable th) {
        f().print("E");
    }

    @Override // junit.framework.l
    public void b(i iVar, junit.framework.b bVar) {
        f().print("F");
    }

    @Override // junit.framework.l
    public void c(i iVar) {
    }

    @Override // junit.framework.l
    public void d(i iVar) {
        f().print(com.alibaba.android.arouter.utils.b.f12515h);
        int i7 = this.f34383b;
        this.f34383b = i7 + 1;
        if (i7 >= 40) {
            f().println();
            this.f34383b = 0;
        }
    }

    protected String e(long j7) {
        return NumberFormat.getInstance().format(j7 / 1000.0d);
    }

    public PrintStream f() {
        return this.f34382a;
    }

    synchronized void g(m mVar, long j7) {
        o(j7);
        l(mVar);
        m(mVar);
        n(mVar);
    }

    public void h(k kVar, int i7) {
        i(kVar, i7);
        j(kVar);
    }

    protected void i(k kVar, int i7) {
        f().print(i7 + ") " + kVar.b());
    }

    protected void j(k kVar) {
        f().print(junit.runner.a.i(kVar.e()));
    }

    protected void k(Enumeration<k> enumeration, int i7, String str) {
        if (i7 == 0) {
            return;
        }
        if (i7 == 1) {
            f().println("There was " + i7 + " " + str + ":");
        } else {
            f().println("There were " + i7 + " " + str + "s:");
        }
        int i8 = 1;
        while (enumeration.hasMoreElements()) {
            h(enumeration.nextElement(), i8);
            i8++;
        }
    }

    protected void l(m mVar) {
        k(mVar.g(), mVar.f(), "error");
    }

    protected void m(m mVar) {
        k(mVar.i(), mVar.h(), "failure");
    }

    protected void n(m mVar) {
        if (mVar.q()) {
            f().println();
            f().print("OK");
            PrintStream printStreamF = f();
            StringBuilder sb = new StringBuilder();
            sb.append(" (");
            sb.append(mVar.l());
            sb.append(" test");
            sb.append(mVar.l() == 1 ? "" : "s");
            sb.append(")");
            printStreamF.println(sb.toString());
        } else {
            f().println();
            f().println("FAILURES!!!");
            f().println("Tests run: " + mVar.l() + ",  Failures: " + mVar.h() + ",  Errors: " + mVar.f());
        }
        f().println();
    }

    protected void o(long j7) {
        f().println();
        f().println("Time: " + e(j7));
    }

    void p() {
        f().println();
        f().println("<RETURN> to continue");
    }
}
