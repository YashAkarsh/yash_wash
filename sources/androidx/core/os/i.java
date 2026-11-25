package androidx.core.os;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    private static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f6089a;

        a(@c.m0 Handler handler) {
            this.f6089a = (Handler) androidx.core.util.w.l(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@c.m0 Runnable runnable) {
            if (this.f6089a.post((Runnable) androidx.core.util.w.l(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f6089a + " is shutting down");
        }
    }

    private i() {
    }

    @c.m0
    public static Executor a(@c.m0 Handler handler) {
        return new a(handler);
    }
}
