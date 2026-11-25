package androidx.test.internal.util;

import android.os.Looper;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.ThreadChecker;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Checks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadChecker f10240a;

    static {
        List listA = ServiceLoaderWrapper.a(ThreadChecker.class);
        if (listA.isEmpty()) {
            f10240a = new ThreadChecker() { // from class: androidx.test.internal.util.Checks.1
                @Override // androidx.test.internal.platform.ThreadChecker
                public void a() {
                    Checks.k(!Thread.currentThread().equals(Looper.getMainLooper().getThread()), "Method cannot be called on the main application thread (on: %s)", Thread.currentThread().getName());
                }

                @Override // androidx.test.internal.platform.ThreadChecker
                public void b() {
                    Checks.k(Thread.currentThread().equals(Looper.getMainLooper().getThread()), "Method cannot be called off the main application thread (on: %s)", Thread.currentThread().getName());
                }
            };
        } else {
            if (listA.size() != 1) {
                throw new IllegalStateException(String.format("Found more than one %s implementations.", ThreadChecker.class.getName()));
            }
            f10240a = (ThreadChecker) listA.get(0);
        }
    }

    private Checks() {
    }

    public static void a(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void c(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalArgumentException(l(errorMessageTemplate, errorMessageArgs));
        }
    }

    public static void d() {
        f10240a.b();
    }

    public static void e() {
        f10240a.a();
    }

    public static <T> T f(T reference) {
        reference.getClass();
        return reference;
    }

    public static <T> T g(T reference, Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    public static <T> T h(T reference, String errorMessageTemplate, Object... errorMessageArgs) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(l(errorMessageTemplate, errorMessageArgs));
    }

    public static void i(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    public static void j(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    public static void k(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalStateException(l(errorMessageTemplate, errorMessageArgs));
        }
    }

    private static String l(String template, Object... args) {
        int iIndexOf;
        String strValueOf = String.valueOf(template);
        StringBuilder sb = new StringBuilder(strValueOf.length() + (args.length * 16));
        int i7 = 0;
        int i8 = 0;
        while (i7 < args.length && (iIndexOf = strValueOf.indexOf("%s", i8)) != -1) {
            sb.append(strValueOf.substring(i8, iIndexOf));
            sb.append(args[i7]);
            i8 = iIndexOf + 2;
            i7++;
        }
        sb.append(strValueOf.substring(i8));
        if (i7 < args.length) {
            sb.append(" [");
            sb.append(args[i7]);
            for (int i9 = i7 + 1; i9 < args.length; i9++) {
                sb.append(", ");
                sb.append(args[i9]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
