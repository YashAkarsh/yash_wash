package g1;

import android.content.Context;
import android.util.Log;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f33990a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    @c1.a
    public static boolean a(@m0 Context context, @m0 Throwable th) {
        try {
            com.google.android.gms.common.internal.u.k(context);
            com.google.android.gms.common.internal.u.k(th);
            return false;
        } catch (Exception e8) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e8);
            return false;
        }
    }
}
