package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f6084a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f6085b = true;

    @c.t0(22)
    static class a {
        private a() {
        }

        @c.t
        static boolean a(Message message) {
            return message.isAsynchronous();
        }

        @c.t
        static void b(Message message, boolean z7) {
            message.setAsynchronous(z7);
        }
    }

    private f0() {
    }

    @SuppressLint({"NewApi"})
    public static boolean a(@c.m0 Message message) {
        return a.a(message);
    }

    @SuppressLint({"NewApi"})
    public static void b(@c.m0 Message message, boolean z7) {
        a.b(message, z7);
    }
}
