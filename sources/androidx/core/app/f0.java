package androidx.core.app;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Configuration f5125b;

    public f0(boolean z7) {
        this.f5124a = z7;
        this.f5125b = null;
    }

    @c.t0(26)
    @c.m0
    public Configuration a() {
        Configuration configuration = this.f5125b;
        if (configuration != null) {
            return configuration;
        }
        throw new IllegalStateException("MultiWindowModeChangedInfo must be constructed with the constructor that takes a Configuration to call getNewConfig(). Are you running on an API 26 or higher device that makes this information available?");
    }

    public boolean b() {
        return this.f5124a;
    }

    @c.t0(26)
    public f0(boolean z7, @c.m0 Configuration configuration) {
        this.f5124a = z7;
        this.f5125b = configuration;
    }
}
