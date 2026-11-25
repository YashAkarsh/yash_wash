package androidx.core.content;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.core.app.l2;
import c.m0;
import c.o0;
import c.t0;
import com.facebook.internal.ServerProtocol;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5627a = "ContextCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f5628b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f5629c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static TypedValue f5630d;

    @t0(16)
    static class a {
        private a() {
        }

        @c.t
        static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        @c.t
        static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    @t0(19)
    static class b {
        private b() {
        }

        @c.t
        static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        @c.t
        static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        @c.t
        static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    @t0(21)
    static class c {
        private c() {
        }

        @c.t
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        @c.t
        static Drawable b(Context context, int i7) {
            return context.getDrawable(i7);
        }

        @c.t
        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* JADX INFO: renamed from: androidx.core.content.d$d, reason: collision with other inner class name */
    @t0(23)
    static class C0058d {
        private C0058d() {
        }

        @c.t
        static int a(Context context, int i7) {
            return context.getColor(i7);
        }

        @c.t
        static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        @c.t
        static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    @t0(24)
    static class e {
        private e() {
        }

        @c.t
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        @c.t
        static File b(Context context) {
            return context.getDataDir();
        }

        @c.t
        static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    @t0(26)
    static class f {
        private f() {
        }

        @c.t
        static ComponentName a(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    @t0(28)
    static class g {
        private g() {
        }

        @c.t
        static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    @t0(30)
    static class h {
        private h() {
        }

        @c.t
        static String a(Context context) {
            return context.getAttributionTag();
        }
    }

    private static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<Class<?>, String> f5631a;

        static {
            HashMap<Class<?>, String> map = new HashMap<>();
            f5631a = map;
            map.put(SubscriptionManager.class, "telephony_subscription_service");
            map.put(UsageStatsManager.class, "usagestats");
            map.put(AppWidgetManager.class, "appwidget");
            map.put(BatteryManager.class, "batterymanager");
            map.put(CameraManager.class, "camera");
            map.put(JobScheduler.class, "jobscheduler");
            map.put(LauncherApps.class, "launcherapps");
            map.put(MediaProjectionManager.class, "media_projection");
            map.put(MediaSessionManager.class, "media_session");
            map.put(RestrictionsManager.class, "restrictions");
            map.put(TelecomManager.class, "telecom");
            map.put(TvInputManager.class, "tv_input");
            map.put(AppOpsManager.class, "appops");
            map.put(CaptioningManager.class, "captioning");
            map.put(ConsumerIrManager.class, "consumer_ir");
            map.put(PrintManager.class, "print");
            map.put(BluetoothManager.class, "bluetooth");
            map.put(DisplayManager.class, ServerProtocol.DIALOG_PARAM_DISPLAY);
            map.put(UserManager.class, "user");
            map.put(InputManager.class, "input");
            map.put(MediaRouter.class, "media_router");
            map.put(NsdManager.class, "servicediscovery");
            map.put(AccessibilityManager.class, "accessibility");
            map.put(AccountManager.class, "account");
            map.put(ActivityManager.class, "activity");
            map.put(AlarmManager.class, l2.f5220v0);
            map.put(AudioManager.class, "audio");
            map.put(ClipboardManager.class, "clipboard");
            map.put(ConnectivityManager.class, "connectivity");
            map.put(DevicePolicyManager.class, "device_policy");
            map.put(DownloadManager.class, "download");
            map.put(DropBoxManager.class, "dropbox");
            map.put(InputMethodManager.class, "input_method");
            map.put(KeyguardManager.class, "keyguard");
            map.put(LayoutInflater.class, "layout_inflater");
            map.put(LocationManager.class, "location");
            map.put(NfcManager.class, "nfc");
            map.put(NotificationManager.class, "notification");
            map.put(PowerManager.class, "power");
            map.put(SearchManager.class, "search");
            map.put(SensorManager.class, "sensor");
            map.put(StorageManager.class, "storage");
            map.put(TelephonyManager.class, "phone");
            map.put(TextServicesManager.class, "textservices");
            map.put(UiModeManager.class, "uimode");
            map.put(UsbManager.class, "usb");
            map.put(Vibrator.class, "vibrator");
            map.put(WallpaperManager.class, "wallpaper");
            map.put(WifiP2pManager.class, "wifip2p");
            map.put(WifiManager.class, "wifi");
            map.put(WindowManager.class, "window");
        }

        private i() {
        }
    }

    protected d() {
    }

    public static int a(@m0 Context context, @m0 String str) {
        androidx.core.util.r.e(str, "permission must be non-null");
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    @o0
    public static Context b(@m0 Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.a(context);
        }
        return null;
    }

    private static File c(File file) {
        synchronized (f5629c) {
            if (!file.exists()) {
                if (file.mkdirs()) {
                    return file;
                }
                Log.w(f5627a, "Unable to create files subdir " + file.getPath());
            }
            return file;
        }
    }

    @o0
    public static String d(@m0 Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return h.a(context);
        }
        return null;
    }

    @m0
    public static File e(@m0 Context context) {
        return c.a(context);
    }

    @c.l
    public static int f(@m0 Context context, @c.n int i7) {
        return C0058d.a(context, i7);
    }

    @o0
    public static ColorStateList g(@m0 Context context, @c.n int i7) {
        return androidx.core.content.res.i.f(context.getResources(), i7, context.getTheme());
    }

    @o0
    public static File h(@m0 Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.b(context);
        }
        String str = context.getApplicationInfo().dataDir;
        if (str != null) {
            return new File(str);
        }
        return null;
    }

    @o0
    public static Drawable i(@m0 Context context, @c.u int i7) {
        return c.b(context, i7);
    }

    @m0
    public static File[] j(@m0 Context context) {
        return b.a(context);
    }

    @m0
    public static File[] k(@m0 Context context, @o0 String str) {
        return b.b(context, str);
    }

    @m0
    public static Executor l(@m0 Context context) {
        return Build.VERSION.SDK_INT >= 28 ? g.a(context) : androidx.core.os.i.a(new Handler(context.getMainLooper()));
    }

    @o0
    public static File m(@m0 Context context) {
        return c.c(context);
    }

    @m0
    public static File[] n(@m0 Context context) {
        return b.c(context);
    }

    @o0
    public static <T> T o(@m0 Context context, @m0 Class<T> cls) {
        return (T) C0058d.b(context, cls);
    }

    @o0
    public static String p(@m0 Context context, @m0 Class<?> cls) {
        return C0058d.c(context, cls);
    }

    public static boolean q(@m0 Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.c(context);
        }
        return false;
    }

    public static boolean r(@m0 Context context, @m0 Intent[] intentArr) {
        return s(context, intentArr, null);
    }

    public static boolean s(@m0 Context context, @m0 Intent[] intentArr, @o0 Bundle bundle) {
        a.a(context, intentArr, bundle);
        return true;
    }

    public static void t(@m0 Context context, @m0 Intent intent, @o0 Bundle bundle) {
        a.b(context, intent, bundle);
    }

    public static void u(@m0 Context context, @m0 Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            f.a(context, intent);
        } else {
            context.startService(intent);
        }
    }
}
