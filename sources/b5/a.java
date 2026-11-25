package b5;

import java.util.concurrent.CancellationException;
import kotlin.g1;
import kotlin.internal.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @g1(version = "1.4")
    @f
    private static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @g1(version = "1.4")
    @f
    private static final CancellationException b(Throwable th) {
        CancellationException cancellationException = new CancellationException(th != null ? th.toString() : null);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @g1(version = "1.4")
    public static /* synthetic */ void c() {
    }
}
