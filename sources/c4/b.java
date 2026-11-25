package c4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.preference.PreferenceManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PowerManager.WakeLock f11529c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f11530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f11531b;

    public b(Context context) {
        this.f11530a = context;
        this.f11531b = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public final SharedPreferences.Editor a() {
        if (this.f11531b == null) {
            this.f11531b = PreferenceManager.getDefaultSharedPreferences(this.f11530a);
        }
        return this.f11531b.edit();
    }

    public void b() {
        if (f11529c == null) {
            k4.b.p(this.f11530a.getClass().getCanonicalName());
            PowerManager powerManager = (PowerManager) this.f11530a.getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(6, this.f11530a.getClass().getCanonicalName());
                f11529c = wakeLockNewWakeLock;
                wakeLockNewWakeLock.acquire();
            }
        }
    }

    public void c() {
        SharedPreferences.Editor editorA = a();
        editorA.clear();
        editorA.apply();
    }

    public boolean d(String str) {
        SharedPreferences sharedPreferences = this.f11531b;
        return sharedPreferences != null && sharedPreferences.contains(str);
    }

    public boolean e(String str, boolean z7) {
        SharedPreferences sharedPreferences = this.f11531b;
        return sharedPreferences == null ? z7 : sharedPreferences.getBoolean(str, z7);
    }

    public int f(String str, int i7) {
        SharedPreferences sharedPreferences = this.f11531b;
        return sharedPreferences == null ? i7 : sharedPreferences.getInt(str, i7);
    }

    public Long g(String str, Long l7) {
        SharedPreferences sharedPreferences = this.f11531b;
        return sharedPreferences == null ? l7 : Long.valueOf(sharedPreferences.getLong(str, l7.longValue()));
    }

    public SharedPreferences h() {
        return this.f11531b;
    }

    public String i(String str, String str2) {
        SharedPreferences sharedPreferences = this.f11531b;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }

    public void j() {
        PowerManager.WakeLock wakeLock = f11529c;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        f11529c.release();
        f11529c = null;
    }

    public void k(String str, int i7) {
        SharedPreferences.Editor editorA = a();
        editorA.putInt(str, i7);
        editorA.commit();
    }

    public void l(String str, long j7) {
        SharedPreferences.Editor editorA = a();
        editorA.putLong(str, j7);
        editorA.apply();
    }

    public void m(String str, String str2) {
        SharedPreferences.Editor editorA = a();
        editorA.putString(str, str2);
        editorA.apply();
    }

    public void n(String str, boolean z7) {
        SharedPreferences.Editor editorA = a();
        editorA.putBoolean(str, z7);
        editorA.apply();
    }

    public b(Context context, String str) {
        this.f11530a = context;
        this.f11531b = context.getSharedPreferences(str, 0);
    }
}
