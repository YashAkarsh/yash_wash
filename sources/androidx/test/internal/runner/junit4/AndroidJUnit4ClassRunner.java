package androidx.test.internal.runner.junit4;

import androidx.test.internal.runner.RunnerArgs;
import androidx.test.internal.runner.junit4.statement.RunAfters;
import androidx.test.internal.runner.junit4.statement.RunBefores;
import androidx.test.internal.runner.junit4.statement.UiThreadStatement;
import androidx.test.internal.util.AndroidRunnerParams;
import androidx.test.platform.app.InstrumentationRegistry;
import java.util.List;
import org.junit.a;
import org.junit.f;
import org.junit.internal.runners.statements.c;
import org.junit.m;
import org.junit.runners.b;
import org.junit.runners.model.d;
import org.junit.runners.model.e;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
public class AndroidJUnit4ClassRunner extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AndroidRunnerParams f10139g;

    public AndroidJUnit4ClassRunner(Class<?> klass, AndroidRunnerParams runnerParams) throws e {
        super(klass);
        this.f10139g = runnerParams;
    }

    private long N(m annotation) {
        if (annotation == null) {
            return 0L;
        }
        return annotation.timeout();
    }

    private static AndroidRunnerParams k0() {
        return new AndroidRunnerParams(InstrumentationRegistry.b(), InstrumentationRegistry.a(), new RunnerArgs.Builder().F(InstrumentationRegistry.b(), InstrumentationRegistry.a()).E().f10006l, false);
    }

    @Override // org.junit.runners.b
    protected j R(d method, Object test) {
        return UiThreadStatement.g(method) ? new UiThreadStatement(super.R(method, test), true) : super.R(method, test);
    }

    @Override // org.junit.runners.b
    protected j e0(d method, Object target, j statement) {
        List<d> listI = t().i(a.class);
        return listI.isEmpty() ? statement : new RunAfters(method, statement, listI, target);
    }

    @Override // org.junit.runners.b
    protected j f0(d method, Object target, j statement) {
        List<d> listI = t().i(f.class);
        return listI.isEmpty() ? statement : new RunBefores(method, statement, listI, target);
    }

    @Override // org.junit.runners.b
    protected j h0(d method, Object test, j next) {
        long jN = N((m) method.getAnnotation(m.class));
        if (jN <= 0 && this.f10139g.c() > 0) {
            jN = this.f10139g.c();
        }
        return jN <= 0 ? next : new c(next, jN);
    }

    public AndroidJUnit4ClassRunner(Class<?> klass) throws e {
        this(klass, k0());
    }
}
