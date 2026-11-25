package androidx.test.runner.permission;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.test.annotation.Beta;
import androidx.test.internal.platform.content.PermissionGranter;
import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import c.g1;
import c.m0;
import java.util.HashSet;
import java.util.Iterator;
import junit.framework.a;

/* JADX INFO: loaded from: classes.dex */
@Beta
@TargetApi(23)
public class PermissionRequester implements PermissionGranter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10497d = "PermissionRequester";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final Context f10499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g1
    final HashSet<RequestPermissionCallable> f10500c;

    public PermissionRequester() {
        this(InstrumentationRegistry.b().getTargetContext());
    }

    private boolean c() {
        boolean z7 = d() >= 23;
        if (!z7) {
            Log.w(f10497d, "Permissions can only be granted on devices running Android M (API 23) orhigher. This rule is ignored.");
        }
        return z7;
    }

    private int d() {
        return this.f10498a;
    }

    @Override // androidx.test.internal.platform.content.PermissionGranter
    public void a() {
        if (c()) {
            Iterator<RequestPermissionCallable> it = this.f10500c.iterator();
            while (it.hasNext()) {
                try {
                    if (RequestPermissionCallable.Result.FAILURE == it.next().call()) {
                        a.J("Failed to grant permissions, see logcat for details");
                        return;
                    }
                } catch (Exception e8) {
                    Log.e(f10497d, "An Exception was thrown while granting permission", e8);
                    a.J("Failed to grant permissions, see logcat for details");
                    return;
                }
            }
        }
    }

    @Override // androidx.test.internal.platform.content.PermissionGranter
    public void b(@m0 String... permissions) {
        Checks.g(permissions, "permissions cannot be null!");
        if (c()) {
            for (String str : permissions) {
                a.w("Permission String is empty or null!", TextUtils.isEmpty(str));
                Checks.i(this.f10500c.add(new GrantPermissionCallable(new UiAutomationShellCommand(this.f10499b.getPackageName(), str, UiAutomationShellCommand.PmCommand.GRANT_PERMISSION), this.f10499b, str)));
            }
        }
    }

    @g1
    protected void e(int sdkInt) {
        this.f10498a = sdkInt;
    }

    @g1
    PermissionRequester(@m0 Context targetContext) {
        this.f10498a = Build.VERSION.SDK_INT;
        this.f10500c = new HashSet<>();
        this.f10499b = (Context) Checks.g(targetContext, "targetContext cannot be null!");
    }
}
