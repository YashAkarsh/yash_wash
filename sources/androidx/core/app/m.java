package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    @c.t0(19)
    static class a {
        private a() {
        }

        @c.t
        static void a(AlarmManager alarmManager, int i7, long j7, PendingIntent pendingIntent) {
            alarmManager.setExact(i7, j7, pendingIntent);
        }
    }

    @c.t0(21)
    static class b {
        private b() {
        }

        @c.t
        static AlarmManager.AlarmClockInfo a(long j7, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j7, pendingIntent);
        }

        @c.t
        static void b(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }
    }

    @c.t0(23)
    static class c {
        private c() {
        }

        @c.t
        static void a(AlarmManager alarmManager, int i7, long j7, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i7, j7, pendingIntent);
        }

        @c.t
        static void b(AlarmManager alarmManager, int i7, long j7, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i7, j7, pendingIntent);
        }
    }

    private m() {
    }

    @SuppressLint({"MissingPermission"})
    public static void a(@c.m0 AlarmManager alarmManager, long j7, @c.m0 PendingIntent pendingIntent, @c.m0 PendingIntent pendingIntent2) {
        b.b(alarmManager, b.a(j7, pendingIntent), pendingIntent2);
    }

    public static void b(@c.m0 AlarmManager alarmManager, int i7, long j7, @c.m0 PendingIntent pendingIntent) {
        c.a(alarmManager, i7, j7, pendingIntent);
    }

    public static void c(@c.m0 AlarmManager alarmManager, int i7, long j7, @c.m0 PendingIntent pendingIntent) {
        a.a(alarmManager, i7, j7, pendingIntent);
    }

    public static void d(@c.m0 AlarmManager alarmManager, int i7, long j7, @c.m0 PendingIntent pendingIntent) {
        c.b(alarmManager, i7, j7, pendingIntent);
    }
}
