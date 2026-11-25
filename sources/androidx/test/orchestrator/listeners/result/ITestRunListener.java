package androidx.test.orchestrator.listeners.result;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ITestRunListener {
    void a(String runName, int testCount);

    void b(long elapsedTime);

    void c(TestIdentifier test, String trace);

    void d(TestIdentifier test, String trace);

    void e(TestIdentifier test, Map<String, String> testMetrics);

    void f(long elapsedTime, Map<String, String> runMetrics);

    void g(String errorMessage);

    void h(TestIdentifier test);

    void i(TestIdentifier test);
}
