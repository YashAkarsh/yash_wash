package org.chromium.base.metrics;

import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.s0;
import x6.c;

/* JADX INFO: loaded from: classes3.dex */
@c("base::android")
public class RecordUserAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Throwable f38839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f38840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f38841c = false;

    public interface UserActionCallback {
        @CalledByNative("UserActionCallback")
        void onActionRecorded(String str);
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f38842a;

        a(String str) {
            this.f38842a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecordUserAction.nativeRecordUserAction(this.f38842a);
        }
    }

    public static void b(String str) {
        if (f38839a != null) {
            return;
        }
        if (ThreadUtils.o()) {
            nativeRecordUserAction(str);
        } else {
            ThreadUtils.k(new a(str));
        }
    }

    public static void c() {
        nativeRemoveActionCallbackForTesting(f38840b);
        f38840b = 0L;
    }

    public static void d(UserActionCallback userActionCallback) {
        f38840b = nativeAddActionCallbackForTesting(userActionCallback);
    }

    @s0
    public static void e(boolean z7) {
        if (z7 && f38839a != null) {
            throw new IllegalStateException("UserActions are already disabled.", f38839a);
        }
        f38839a = z7 ? new Throwable() : null;
    }

    private static native long nativeAddActionCallbackForTesting(UserActionCallback userActionCallback);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRecordUserAction(String str);

    private static native void nativeRemoveActionCallbackForTesting(long j7);
}
