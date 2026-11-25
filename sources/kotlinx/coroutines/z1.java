package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class z1 {
    @a7.d
    public static final CancellationException a(@a7.e String str, @a7.e Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static final void b(@a7.d Throwable th, @a7.d Throwable th2) {
        kotlin.p.a(th, th2);
    }
}
