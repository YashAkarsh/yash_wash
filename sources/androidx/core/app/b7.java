package androidx.core.app;

import android.app.Service;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class b7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5095a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5096b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5097c = 2;

    @c.t0(24)
    static class a {
        private a() {
        }

        @c.t
        static void a(Service service, int i7) {
            service.stopForeground(i7);
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    private b7() {
    }

    public static void a(@c.m0 Service service, int i7) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(service, i7);
        } else {
            service.stopForeground((i7 & 1) != 0);
        }
    }
}
