package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* JADX INFO: loaded from: classes.dex */
public class a1 {

    @c.t0(24)
    static class a {
        private a() {
        }

        @c.t
        static boolean a(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    private a1() {
    }

    public static boolean a(@c.m0 Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(context);
        }
        return true;
    }
}
