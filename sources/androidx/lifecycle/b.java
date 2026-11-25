package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class b extends k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private Application f8250d;

    public b(@c.m0 Application application) {
        this.f8250d = application;
    }

    @c.m0
    public <T extends Application> T g() {
        return (T) this.f8250d;
    }
}
