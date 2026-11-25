package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
public interface Callback<T> {

    public static abstract class Helper {
        @CalledByNative("Helper")
        static void onBooleanResultFromNative(Callback callback, boolean z7) {
            callback.onResult(Boolean.valueOf(z7));
        }

        @CalledByNative("Helper")
        static void onIntResultFromNative(Callback callback, int i7) {
            callback.onResult(Integer.valueOf(i7));
        }

        @CalledByNative("Helper")
        static void onObjectResultFromNative(Callback callback, Object obj) {
            callback.onResult(obj);
        }

        @CalledByNative("Helper")
        static void runRunnable(Runnable runnable) {
            runnable.run();
        }
    }

    void onResult(T t7);
}
