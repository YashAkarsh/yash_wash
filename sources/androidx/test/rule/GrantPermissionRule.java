package androidx.test.rule;

import androidx.test.annotation.Beta;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.content.PermissionGranter;
import androidx.test.internal.util.Checks;
import c.g1;
import c.m0;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.rules.l;
import org.junit.runner.c;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
@Beta
public class GrantPermissionRule implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PermissionGranter f10345a;

    private class RequestPermissionStatement extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j f10347a;

        public RequestPermissionStatement(j base) {
            this.f10347a = base;
        }

        @Override // org.junit.runners.model.j
        public void a() throws Throwable {
            GrantPermissionRule.this.f10345a.a();
            this.f10347a.a();
        }
    }

    private GrantPermissionRule() {
        this((PermissionGranter) ServiceLoaderWrapper.b(PermissionGranter.class, GrantPermissionRule$$Lambda$0.f10346a));
    }

    public static GrantPermissionRule c(String... permissions) {
        GrantPermissionRule grantPermissionRule = new GrantPermissionRule();
        grantPermissionRule.d(permissions);
        return grantPermissionRule;
    }

    private void d(String... permissions) {
        Set<String> setE = e(permissions);
        this.f10345a.b((String[]) setE.toArray(new String[setE.size()]));
    }

    @Override // org.junit.rules.l
    public final j a(final j base, c description) {
        return new RequestPermissionStatement(base);
    }

    @g1
    Set<String> e(String... permissions) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(permissions));
        if (linkedHashSet.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
            linkedHashSet.add("android.permission.READ_EXTERNAL_STORAGE");
        }
        return linkedHashSet;
    }

    @g1
    void f(PermissionGranter permissionGranter) {
        this.f10345a = (PermissionGranter) Checks.g(permissionGranter, "permissionRequester cannot be null!");
    }

    @g1
    GrantPermissionRule(@m0 PermissionGranter permissionGranter) {
        f(permissionGranter);
    }
}
