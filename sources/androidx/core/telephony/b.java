package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import c.t;
import c.t0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@t0(22)
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f6216a;

    @t0(29)
    private static class a {
        private a() {
        }

        @t
        static int a(int i7) {
            return SubscriptionManager.getSlotIndex(i7);
        }
    }

    private b() {
    }

    public static int a(int i7) {
        if (i7 == -1) {
            return -1;
        }
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            return a.a(i7);
        }
        try {
            if (f6216a == null) {
                if (i8 >= 26) {
                    f6216a = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", Integer.TYPE);
                } else {
                    f6216a = SubscriptionManager.class.getDeclaredMethod("getSlotId", Integer.TYPE);
                }
                f6216a.setAccessible(true);
            }
            Integer num = (Integer) f6216a.invoke(null, Integer.valueOf(i7));
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }
}
