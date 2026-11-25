package androidx.test.orchestrator.listeners.result;

import android.util.Log;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class TestRunResult implements ITestRunListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f10311j = "TestRunResult";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<TestIdentifier, TestResult> f10313b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f10314c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10315d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10316e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f10317f = new int[TestResult.TestStatus.values().length];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10318g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f10319h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f10320i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10312a = "not started";

    private void B(TestIdentifier test, TestResult.TestStatus status, String trace) {
        TestResult testResult = this.f10313b.get(test);
        if (testResult == null) {
            Log.d(f10311j, String.format("received test event without test start for %s", test));
            testResult = new TestResult();
        }
        testResult.j(status);
        testResult.i(trace);
        j(test, testResult);
    }

    private void j(TestIdentifier test, TestResult testResult) {
        this.f10318g = true;
        this.f10313b.put(test, testResult);
    }

    private String k(String existingValue, String newValue) {
        if (existingValue != null) {
            try {
                try {
                    return Long.toString(Long.valueOf(Long.parseLong(existingValue)).longValue() + Long.valueOf(Long.parseLong(newValue)).longValue());
                } catch (NumberFormatException unused) {
                }
            } catch (NumberFormatException unused2) {
                return Double.toString(Double.valueOf(Double.parseDouble(existingValue)).doubleValue() + Double.valueOf(Double.parseDouble(newValue)).doubleValue());
            }
        }
        return newValue;
    }

    public void A(boolean runComplete) {
        this.f10315d = runComplete;
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void a(String runName, int testCount) {
        this.f10312a = runName;
        this.f10315d = false;
        this.f10319h = null;
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void b(long elapsedTime) {
        this.f10316e += elapsedTime;
        this.f10315d = true;
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void c(TestIdentifier test, String trace) {
        B(test, TestResult.TestStatus.FAILURE, trace);
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void d(TestIdentifier test, String trace) {
        B(test, TestResult.TestStatus.ASSUMPTION_FAILURE, trace);
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void e(TestIdentifier test, Map<String, String> testMetrics) {
        TestResult testResult = this.f10313b.get(test);
        if (testResult == null) {
            testResult = new TestResult();
        }
        if (testResult.f().equals(TestResult.TestStatus.INCOMPLETE)) {
            testResult.j(TestResult.TestStatus.PASSED);
        }
        testResult.g(System.currentTimeMillis());
        testResult.h(testMetrics);
        j(test, testResult);
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void f(long elapsedTime, Map<String, String> runMetrics) {
        if (this.f10320i) {
            for (Map.Entry<String, String> entry : runMetrics.entrySet()) {
                this.f10314c.put(entry.getKey(), k(this.f10314c.get(entry.getKey()), entry.getValue()));
            }
        } else {
            this.f10314c.putAll(runMetrics);
        }
        this.f10316e += elapsedTime;
        this.f10315d = true;
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void g(String errorMessage) {
        this.f10319h = errorMessage;
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void h(TestIdentifier test) {
        j(test, new TestResult());
    }

    @Override // androidx.test.orchestrator.listeners.result.ITestRunListener
    public void i(TestIdentifier test) {
        B(test, TestResult.TestStatus.IGNORED, null);
    }

    public Set<TestIdentifier> l() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<TestIdentifier, TestResult> entry : u().entrySet()) {
            if (!entry.getValue().f().equals(TestResult.TestStatus.INCOMPLETE)) {
                linkedHashSet.add(entry.getKey());
            }
        }
        return linkedHashSet;
    }

    public long m() {
        return this.f10316e;
    }

    public String n() {
        return this.f10312a;
    }

    public int o() {
        return r(TestResult.TestStatus.FAILURE);
    }

    public int p() {
        return q() - r(TestResult.TestStatus.INCOMPLETE);
    }

    public int q() {
        return this.f10313b.size();
    }

    public int r(TestResult.TestStatus status) {
        if (this.f10318g) {
            int i7 = 0;
            while (true) {
                int[] iArr = this.f10317f;
                if (i7 >= iArr.length) {
                    break;
                }
                iArr[i7] = 0;
                i7++;
            }
            for (TestResult testResult : this.f10313b.values()) {
                int[] iArr2 = this.f10317f;
                int iOrdinal = testResult.f().ordinal();
                iArr2[iOrdinal] = iArr2[iOrdinal] + 1;
            }
            this.f10318g = false;
        }
        return this.f10317f[status.ordinal()];
    }

    public String s() {
        return this.f10319h;
    }

    public Map<String, String> t() {
        return this.f10314c;
    }

    public Map<TestIdentifier, TestResult> u() {
        return this.f10313b;
    }

    public String v() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Total tests %d, ", Integer.valueOf(q())));
        for (TestResult.TestStatus testStatus : TestResult.TestStatus.values()) {
            int iR = r(testStatus);
            if (iR > 0) {
                sb.append(String.format("%s %d, ", testStatus.toString().toLowerCase(), Integer.valueOf(iR)));
            }
        }
        return sb.toString();
    }

    public boolean w() {
        return o() > 0;
    }

    public boolean x() {
        return this.f10315d;
    }

    public boolean y() {
        return this.f10319h != null;
    }

    public void z(boolean metricAggregation) {
        this.f10320i = metricAggregation;
    }
}
