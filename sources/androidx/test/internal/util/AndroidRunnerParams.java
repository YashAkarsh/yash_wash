package androidx.test.internal.util;

import android.app.Instrumentation;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class AndroidRunnerParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Instrumentation f10235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f10236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f10238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f10239e;

    @Deprecated
    public AndroidRunnerParams(Instrumentation instrumentation, Bundle bundle, boolean skipExecution, long perTestTimeout, boolean ignoreSuiteMethods) {
        this.f10235a = instrumentation;
        this.f10236b = bundle;
        this.f10237c = skipExecution;
        this.f10238d = perTestTimeout;
        this.f10239e = ignoreSuiteMethods;
    }

    public Bundle a() {
        return this.f10236b;
    }

    public Instrumentation b() {
        return this.f10235a;
    }

    public long c() {
        return this.f10238d;
    }

    public boolean d() {
        return this.f10239e;
    }

    @Deprecated
    public boolean e() {
        return this.f10237c;
    }

    public AndroidRunnerParams(Instrumentation instrumentation, Bundle bundle, long perTestTimeout, boolean ignoreSuiteMethods) {
        this.f10235a = instrumentation;
        this.f10236b = bundle;
        this.f10237c = false;
        this.f10238d = perTestTimeout;
        this.f10239e = ignoreSuiteMethods;
    }
}
