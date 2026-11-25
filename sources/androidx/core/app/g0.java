package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5127a = "NavUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5128b = "android.support.PARENT_ACTIVITY";

    @c.t0(16)
    static class a {
        private a() {
        }

        @c.t
        static Intent a(Activity activity) {
            return activity.getParentActivityIntent();
        }

        @c.t
        static boolean b(Activity activity, Intent intent) {
            return activity.navigateUpTo(intent);
        }

        @c.t
        static boolean c(Activity activity, Intent intent) {
            return activity.shouldUpRecreateTask(intent);
        }
    }

    private g0() {
    }

    @c.o0
    public static Intent a(@c.m0 Activity activity) {
        Intent intentA = a.a(activity);
        if (intentA != null) {
            return intentA;
        }
        String strD = d(activity);
        if (strD == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, strD);
        try {
            return e(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(f5127a, "getParentActivityIntent: bad parentActivityName '" + strD + "' in manifest");
            return null;
        }
    }

    @c.o0
    public static Intent b(@c.m0 Context context, @c.m0 ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strE = e(context, componentName);
        if (strE == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strE);
        return e(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    @c.o0
    public static Intent c(@c.m0 Context context, @c.m0 Class<?> cls) throws PackageManager.NameNotFoundException {
        String strE = e(context, new ComponentName(context, cls));
        if (strE == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(context, strE);
        return e(context, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
    }

    @c.o0
    public static String d(@c.m0 Activity activity) {
        try {
            return e(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    @c.o0
    public static String e(@c.m0 Context context, @c.m0 ComponentName componentName) throws PackageManager.NameNotFoundException {
        int i7;
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            i7 = 269222528;
        } else {
            i7 = i8 >= 24 ? 787072 : 640;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i7);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString(f5128b)) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static void f(@c.m0 Activity activity) {
        Intent intentA = a(activity);
        if (intentA != null) {
            g(activity, intentA);
            return;
        }
        throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void g(@c.m0 Activity activity, @c.m0 Intent intent) {
        a.b(activity, intent);
    }

    public static boolean h(@c.m0 Activity activity, @c.m0 Intent intent) {
        return a.c(activity, intent);
    }
}
