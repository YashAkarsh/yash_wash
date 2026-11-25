package androidx.test.internal.runner.filters;

import java.util.regex.Pattern;
import org.junit.runner.c;

/* JADX INFO: loaded from: classes.dex */
public final class TestsRegExFilter extends ParentFilter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Pattern f10109b = null;

    @Override // org.junit.runner.manipulation.a
    public String b() {
        return "tests filter";
    }

    @Override // androidx.test.internal.runner.filters.ParentFilter
    protected boolean f(c description) {
        if (this.f10109b == null) {
            return true;
        }
        return this.f10109b.matcher(String.format("%s#%s", description.n(), description.p())).find();
    }

    public void g(String patternString) {
        this.f10109b = Pattern.compile(patternString);
    }
}
