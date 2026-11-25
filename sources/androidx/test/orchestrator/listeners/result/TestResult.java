package androidx.test.orchestrator.listeners.result;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TestResult {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f10302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10304e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TestStatus f10300a = TestStatus.INCOMPLETE;

    public enum TestStatus {
        FAILURE,
        PASSED,
        INCOMPLETE,
        ASSUMPTION_FAILURE,
        IGNORED
    }

    public TestResult() {
        this.f10303d = 0L;
        this.f10303d = System.currentTimeMillis();
    }

    private static boolean a(Object a8, Object b8) {
        return a8 == b8 || (a8 != null && a8.equals(b8));
    }

    public long b() {
        return this.f10304e;
    }

    public Map<String, String> c() {
        return this.f10302c;
    }

    public String d() {
        return this.f10301b;
    }

    public long e() {
        return this.f10303d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TestResult testResult = (TestResult) obj;
        return a(this.f10302c, testResult.f10302c) && a(this.f10301b, testResult.f10301b) && a(this.f10300a, testResult.f10300a);
    }

    public TestStatus f() {
        return this.f10300a;
    }

    public void g(long currentTimeMillis) {
        this.f10304e = currentTimeMillis;
    }

    public void h(Map<String, String> metrics) {
        this.f10302c = metrics;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f10302c, this.f10301b, this.f10300a});
    }

    public void i(String trace) {
        this.f10301b = trace;
    }

    public TestResult j(TestStatus status) {
        this.f10300a = status;
        return this;
    }
}
