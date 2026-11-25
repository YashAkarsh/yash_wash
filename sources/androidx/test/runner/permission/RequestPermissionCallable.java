package androidx.test.runner.permission;

import android.content.Context;
import android.text.TextUtils;
import androidx.test.internal.util.Checks;
import c.g1;
import c.m0;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
@g1
public abstract class RequestPermissionCallable implements Callable<Result> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ShellCommand f10501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f10502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10504d;

    public enum Result {
        SUCCESS,
        FAILURE
    }

    public RequestPermissionCallable(@m0 ShellCommand shellCommand, @m0 Context targetContext, String permission) {
        this.f10501a = (ShellCommand) Checks.g(shellCommand, "shellCommand cannot be null!");
        Context context = (Context) Checks.g(targetContext, "targetContext cannot be null!");
        this.f10502b = context;
        String packageName = context.getPackageName();
        Checks.j(!TextUtils.isEmpty(packageName), "targetPackage cannot be empty or null!");
        this.f10503c = packageName;
        this.f10504d = permission;
    }

    protected String a() {
        return this.f10504d;
    }

    protected ShellCommand b() {
        return this.f10501a;
    }

    protected boolean c() {
        return this.f10502b.checkCallingOrSelfPermission(this.f10504d) == 0;
    }

    public boolean equals(Object o7) {
        if (this == o7) {
            return true;
        }
        if (o7 == null || getClass() != o7.getClass()) {
            return false;
        }
        RequestPermissionCallable requestPermissionCallable = (RequestPermissionCallable) o7;
        return Objects.equals(this.f10503c, requestPermissionCallable.f10503c) && Objects.equals(this.f10504d, requestPermissionCallable.f10504d);
    }

    public int hashCode() {
        return Objects.hash(this.f10503c, this.f10504d);
    }
}
