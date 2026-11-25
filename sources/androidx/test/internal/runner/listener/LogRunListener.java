package androidx.test.internal.runner.listener;

import android.util.Log;
import org.junit.runner.c;
import org.junit.runner.j;
import org.junit.runner.notification.a;
import org.junit.runner.notification.b;

/* JADX INFO: loaded from: classes.dex */
public class LogRunListener extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10195a = "TestRunner";

    @Override // org.junit.runner.notification.b
    public void a(a failure) {
        String strValueOf = String.valueOf(failure.a().o());
        Log.e(f10195a, strValueOf.length() != 0 ? "assumption failed: ".concat(strValueOf) : new String("assumption failed: "));
        Log.e(f10195a, "----- begin exception -----");
        Log.e(f10195a, failure.e());
        Log.e(f10195a, "----- end exception -----");
    }

    @Override // org.junit.runner.notification.b
    public void b(a failure) throws Exception {
        String strValueOf = String.valueOf(failure.a().o());
        Log.e(f10195a, strValueOf.length() != 0 ? "failed: ".concat(strValueOf) : new String("failed: "));
        Log.e(f10195a, "----- begin exception -----");
        Log.e(f10195a, failure.e());
        Log.e(f10195a, "----- end exception -----");
    }

    @Override // org.junit.runner.notification.b
    public void c(c description) throws Exception {
        String strValueOf = String.valueOf(description.o());
        Log.i(f10195a, strValueOf.length() != 0 ? "finished: ".concat(strValueOf) : new String("finished: "));
    }

    @Override // org.junit.runner.notification.b
    public void d(c description) throws Exception {
        String strValueOf = String.valueOf(description.o());
        Log.i(f10195a, strValueOf.length() != 0 ? "ignored: ".concat(strValueOf) : new String("ignored: "));
    }

    @Override // org.junit.runner.notification.b
    public void e(j result) throws Exception {
        Log.i(f10195a, String.format("run finished: %d tests, %d failed, %d ignored", Integer.valueOf(result.j()), Integer.valueOf(result.g()), Integer.valueOf(result.i())));
    }

    @Override // org.junit.runner.notification.b
    public void f(c description) throws Exception {
        Log.i(f10195a, String.format("run started: %d tests", Integer.valueOf(description.w())));
    }

    @Override // org.junit.runner.notification.b
    public void g(c description) throws Exception {
        String strValueOf = String.valueOf(description.o());
        Log.i(f10195a, strValueOf.length() != 0 ? "started: ".concat(strValueOf) : new String("started: "));
    }
}
