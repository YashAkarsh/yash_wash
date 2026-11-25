package androidx.test.internal.runner.listener;

import android.app.Instrumentation;
import android.os.Bundle;
import java.io.PrintStream;
import org.junit.runner.j;
import org.junit.runner.notification.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class InstrumentationRunListener extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Instrumentation f10194a;

    public Instrumentation h() {
        return this.f10194a;
    }

    public void i(PrintStream streamResult, Bundle resultBundle, j junitResults) {
    }

    public void j(int code, Bundle bundle) {
        h().sendStatus(code, bundle);
    }

    public void k(String msg) {
        Bundle bundle = new Bundle();
        bundle.putString("stream", msg);
        j(0, bundle);
    }

    public void l(Instrumentation instr) {
        this.f10194a = instr;
    }
}
