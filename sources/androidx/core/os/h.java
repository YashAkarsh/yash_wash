package androidx.core.os;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6087a = "EnvironmentCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6088b = "unknown";

    @c.t0(19)
    static class a {
        private a() {
        }

        @c.t
        static String a(File file) {
            return Environment.getStorageState(file);
        }
    }

    @c.t0(21)
    static class b {
        private b() {
        }

        @c.t
        static String a(File file) {
            return Environment.getExternalStorageState(file);
        }
    }

    private h() {
    }

    @c.m0
    public static String a(@c.m0 File file) {
        return b.a(file);
    }
}
