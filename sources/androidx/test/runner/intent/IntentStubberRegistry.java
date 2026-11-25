package androidx.test.runner.intent;

import android.os.Looper;
import androidx.test.internal.util.Checks;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class IntentStubberRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static IntentStubber f10474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f10475b = new AtomicBoolean();

    private IntentStubberRegistry() {
    }

    private static void a() {
        Checks.j(Looper.myLooper() == Looper.getMainLooper(), "Must be called on main thread.");
    }

    public static IntentStubber b() {
        a();
        Checks.j(f10474a != null, "No intent monitor registered! Are you running under an Instrumentation which registers intent monitors?");
        return f10474a;
    }

    public static boolean c() {
        return f10475b.get();
    }

    public static void d(IntentStubber intentStubber) {
        Checks.g(intentStubber, "IntentStubber cannot be null!");
        Checks.j(!f10475b.getAndSet(true), "Intent stubber already registered! Multiple stubbers are notallowedAre you running under an ");
        f10474a = intentStubber;
    }

    public static synchronized void e() {
        f10474a = null;
        f10475b.set(false);
    }
}
