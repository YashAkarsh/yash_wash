package androidx.test;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class InstrumentationRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<Instrumentation> f9916a = new AtomicReference<>(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReference<Bundle> f9917b = new AtomicReference<>(null);

    private InstrumentationRegistry() {
    }

    @Deprecated
    public static Bundle a() {
        Bundle bundle = f9917b.get();
        if (bundle != null) {
            return new Bundle(bundle);
        }
        throw new IllegalStateException("No instrumentation arguments registered! Are you running under an Instrumentation which registers arguments?");
    }

    @Deprecated
    public static Context b() {
        return c().getContext();
    }

    @Deprecated
    public static Instrumentation c() {
        Instrumentation instrumentation = f9916a.get();
        if (instrumentation != null) {
            return instrumentation;
        }
        throw new IllegalStateException("No instrumentation registered! Must run under a registering instrumentation.");
    }

    @Deprecated
    public static Context d() {
        return c().getTargetContext();
    }

    @Deprecated
    public static void e(Instrumentation instrumentation, Bundle arguments) {
        f9916a.set(instrumentation);
        f9917b.set(new Bundle(arguments));
    }
}
