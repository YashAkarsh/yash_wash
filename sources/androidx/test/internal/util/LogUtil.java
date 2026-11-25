package androidx.test.internal.util;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class LogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f10241a;

    interface Supplier<T> {
        T get();
    }

    private static boolean a(String tag, final int level) {
        if (tag.length() > 23) {
            tag = tag.substring(0, 22);
        }
        return Log.isLoggable(tag, level);
    }

    static final /* synthetic */ String b(String str) {
        return str;
    }

    static final /* synthetic */ String c(String str) {
        String strG = g();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(strG).length());
        sb.append(str);
        sb.append(" in ");
        sb.append(strG);
        return sb.toString();
    }

    private static void d(String tag, Supplier<String> msgSupplier, Object... args) {
        if (a(tag, 3)) {
            Log.d(tag, String.format(msgSupplier.get(), args));
        }
    }

    public static void e(String tag, final String message, Object... args) {
        d(tag, new Supplier(message) { // from class: androidx.test.internal.util.LogUtil$$Lambda$0

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f10242a;

            {
                this.f10242a = message;
            }

            @Override // androidx.test.internal.util.LogUtil.Supplier
            public Object get() {
                return LogUtil.b(this.f10242a);
            }
        }, args);
    }

    public static void f(String tag, final String message, Object... args) {
        d(tag, new Supplier(message) { // from class: androidx.test.internal.util.LogUtil$$Lambda$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f10243a;

            {
                this.f10243a = message;
            }

            @Override // androidx.test.internal.util.LogUtil.Supplier
            public Object get() {
                return LogUtil.c(this.f10243a);
            }
        }, args);
    }

    private static final String g() {
        String str;
        String str2 = f10241a;
        if (str2 != null) {
            return str2;
        }
        try {
            str = ProcSummary.c("self").f10249e;
        } catch (ProcSummary.SummaryException unused) {
            str = "unknown";
        }
        return (str.length() <= 64 || !str.contains("-classpath")) ? str : "robolectric";
    }
}
