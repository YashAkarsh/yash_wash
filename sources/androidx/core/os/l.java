package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6091a = "HandlerCompat";

    @c.t0(28)
    private static class a {
        private a() {
        }

        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }

        public static Handler b(Looper looper, Handler.Callback callback) {
            return Handler.createAsync(looper, callback);
        }

        public static boolean c(Handler handler, Runnable runnable, Object obj, long j7) {
            return handler.postDelayed(runnable, obj, j7);
        }
    }

    @c.t0(29)
    private static class b {
        private b() {
        }

        public static boolean a(Handler handler, Runnable runnable) {
            return handler.hasCallbacks(runnable);
        }
    }

    private l() {
    }

    @c.m0
    public static Handler a(@c.m0 Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException e8) {
            e = e8;
            Log.w(f6091a, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (InstantiationException e9) {
            e = e9;
            Log.w(f6091a, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (NoSuchMethodException e10) {
            e = e10;
            Log.w(f6091a, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    @c.m0
    public static Handler b(@c.m0 Looper looper, @c.m0 Handler.Callback callback) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.b(looper, callback);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, callback, Boolean.TRUE);
        } catch (IllegalAccessException e8) {
            e = e8;
            Log.w(f6091a, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper, callback);
        } catch (InstantiationException e9) {
            e = e9;
            Log.w(f6091a, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper, callback);
        } catch (NoSuchMethodException e10) {
            e = e10;
            Log.w(f6091a, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
            return new Handler(looper, callback);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    @c.t0(16)
    public static boolean c(@c.m0 Handler handler, @c.m0 Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 29) {
            return b.a(handler, runnable);
        }
        try {
            return ((Boolean) Handler.class.getMethod("hasCallbacks", Runnable.class).invoke(handler, runnable)).booleanValue();
        } catch (IllegalAccessException e8) {
            e = e8;
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
        } catch (NoSuchMethodException e9) {
            e = e9;
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
        } catch (NullPointerException e10) {
            e = e10;
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static boolean d(@c.m0 Handler handler, @c.m0 Runnable runnable, @c.o0 Object obj, long j7) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.c(handler, runnable, obj, j7);
        }
        Message messageObtain = Message.obtain(handler, runnable);
        messageObtain.obj = obj;
        return handler.sendMessageDelayed(messageObtain, j7);
    }
}
