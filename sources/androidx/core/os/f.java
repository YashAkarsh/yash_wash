package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    @c.t0(24)
    static class a {
        private a() {
        }

        @c.t
        static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }
    }

    private f() {
    }

    @c.m0
    public static p a(@c.m0 Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? p.n(a.a(configuration)) : p.a(configuration.locale);
    }
}
