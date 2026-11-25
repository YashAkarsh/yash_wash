package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected i f34363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Throwable f34364b;

    public k(i iVar, Throwable th) {
        this.f34363a = iVar;
        this.f34364b = th;
    }

    public String a() {
        return d().getMessage();
    }

    public i b() {
        return this.f34363a;
    }

    public boolean c() {
        return d() instanceof b;
    }

    public Throwable d() {
        return this.f34364b;
    }

    public String e() {
        StringWriter stringWriter = new StringWriter();
        d().printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public String toString() {
        return this.f34363a + ": " + this.f34364b.getMessage();
    }
}
