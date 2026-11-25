package androidx.test.internal.runner.listener;

import android.os.Bundle;
import android.util.Log;
import c.g1;
import com.alibaba.android.arouter.utils.b;
import java.io.PrintStream;
import org.junit.runner.c;
import org.junit.runner.j;
import org.junit.runner.notification.a;

/* JADX INFO: loaded from: classes.dex */
public class InstrumentationResultPrinter extends InstrumentationRunListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f10174h = "InstrumentationResultPrinter";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g1
    static final int f10175i = 32768;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f10176j = "AndroidJUnitRunner";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10177k = "numtests";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10178l = "current";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f10179m = "class";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f10180n = "test";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f10181o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f10182p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Deprecated
    public static final int f10183q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f10184r = -2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f10185s = -3;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f10186t = -4;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f10187u = "stack";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f10188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g1
    Bundle f10189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f10190d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f10191e = -999;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f10192f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f10193g = c.f39958h;

    public InstrumentationResultPrinter() {
        Bundle bundle = new Bundle();
        this.f10188b = bundle;
        this.f10189c = new Bundle(bundle);
    }

    private void m(a failure) {
        String strE = failure.e();
        if (strE.length() > 32768) {
            Log.w(f10174h, String.format("Stack trace too long, trimmed to first %s characters.", 32768));
            strE = String.valueOf(strE.substring(0, 32768)).concat("\n");
        }
        this.f10189c.putString(f10187u, strE);
        this.f10189c.putString("stream", String.format("\nError in %s:\n%s", failure.a().o(), failure.e()));
    }

    @Override // org.junit.runner.notification.b
    public void a(a failure) {
        this.f10191e = -4;
        this.f10189c.putString(f10187u, failure.e());
    }

    @Override // org.junit.runner.notification.b
    public void b(a failure) throws Exception {
        boolean z7;
        if (this.f10193g.equals(c.f39958h) && this.f10190d == 0 && this.f10192f == null) {
            g(failure.a());
            z7 = true;
        } else {
            z7 = false;
        }
        this.f10191e = -2;
        m(failure);
        if (z7) {
            c(failure.a());
        }
    }

    @Override // org.junit.runner.notification.b
    public void c(c description) throws Exception {
        if (this.f10191e == 0) {
            this.f10189c.putString("stream", b.f12515h);
        }
        j(this.f10191e, this.f10189c);
    }

    @Override // org.junit.runner.notification.b
    public void d(c description) throws Exception {
        g(description);
        this.f10191e = -3;
        c(description);
    }

    @Override // org.junit.runner.notification.b
    public void f(c description) throws Exception {
        this.f10188b.putString("id", f10176j);
        this.f10188b.putInt(f10177k, description.w());
    }

    @Override // org.junit.runner.notification.b
    public void g(c description) throws Exception {
        this.f10193g = description;
        String strN = description.n();
        String strP = description.p();
        Bundle bundle = new Bundle(this.f10188b);
        this.f10189c = bundle;
        bundle.putString(f10179m, strN);
        this.f10189c.putString(f10180n, strP);
        Bundle bundle2 = this.f10189c;
        int i7 = this.f10190d + 1;
        this.f10190d = i7;
        bundle2.putInt(f10178l, i7);
        if (strN == null || strN.equals(this.f10192f)) {
            this.f10189c.putString("stream", "");
        } else {
            this.f10189c.putString("stream", String.format("\n%s:", strN));
            this.f10192f = strN;
        }
        j(1, this.f10189c);
        this.f10191e = 0;
    }

    @Override // androidx.test.internal.runner.listener.InstrumentationRunListener
    public void i(PrintStream streamResult, Bundle resultBundle, j junitResults) {
        new org.junit.internal.j(streamResult).e(junitResults);
    }

    public void n(Throwable t7) {
        try {
            this.f10191e = -2;
            a aVar = new a(this.f10193g, t7);
            this.f10189c.putString(f10187u, aVar.e());
            this.f10189c.putString("stream", String.format("\nProcess crashed while executing %s:\n%s", this.f10193g.o(), aVar.e()));
            c(this.f10193g);
        } catch (Exception unused) {
            c cVar = this.f10193g;
            if (cVar == null) {
                Log.e(f10174h, "Failed to initialize test before process crash");
                return;
            }
            String strO = cVar.o();
            StringBuilder sb = new StringBuilder(String.valueOf(strO).length() + 52);
            sb.append("Failed to mark test ");
            sb.append(strO);
            sb.append(" as finished after process crash");
            Log.e(f10174h, sb.toString());
        }
    }
}
