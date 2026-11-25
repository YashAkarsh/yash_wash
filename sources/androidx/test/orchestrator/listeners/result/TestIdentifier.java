package androidx.test.orchestrator.listeners.result;

/* JADX INFO: loaded from: classes.dex */
public class TestIdentifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10299b;

    public TestIdentifier(String className, String testName) {
        if (className == null || testName == null) {
            throw new IllegalArgumentException("className and testName must be non-null");
        }
        this.f10298a = className;
        this.f10299b = testName;
    }

    public String a() {
        return this.f10298a;
    }

    public String b() {
        return this.f10299b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TestIdentifier testIdentifier = (TestIdentifier) obj;
        String str = this.f10298a;
        if (str == null) {
            if (testIdentifier.f10298a != null) {
                return false;
            }
        } else if (!str.equals(testIdentifier.f10298a)) {
            return false;
        }
        String str2 = this.f10299b;
        if (str2 == null) {
            if (testIdentifier.f10299b != null) {
                return false;
            }
        } else if (!str2.equals(testIdentifier.f10299b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f10298a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f10299b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return String.format("%s#%s", a(), b());
    }
}
