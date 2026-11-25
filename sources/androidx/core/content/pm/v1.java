package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.graphics.drawable.IconCompat;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5640a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5641b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5642c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5643d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.g1
    static final String f5644e = "com.android.launcher.action.INSTALL_SHORTCUT";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.g1
    static final String f5645f = "com.android.launcher.permission.INSTALL_SHORTCUT";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f5646g = 96;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f5647h = 48;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f5648i = "android.intent.extra.shortcut.ID";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile y0<?> f5649j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile List<l> f5650k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f5651l = "androidx.core.content.pm.SHORTCUT_LISTENER";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f5652m = "androidx.core.content.pm.shortcut_listener_impl";

    class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IntentSender f5653a;

        a(IntentSender intentSender) {
            this.f5653a = intentSender;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                this.f5653a.sendIntent(context, 0, null, null, null);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    @c.t0(25)
    private static class b {
        private b() {
        }

        static String a(@c.m0 List<ShortcutInfo> list) {
            Iterator<ShortcutInfo> it = list.iterator();
            int rank = -1;
            String id = null;
            while (it.hasNext()) {
                ShortcutInfo shortcutInfoA = w.a(it.next());
                if (shortcutInfoA.getRank() > rank) {
                    id = shortcutInfoA.getId();
                    rank = shortcutInfoA.getRank();
                }
            }
            return id;
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    private v1() {
    }

    @c.g1
    static void A(List<l> list) {
        f5650k = list;
    }

    @c.g1
    static void B(y0<Void> y0Var) {
        f5649j = y0Var;
    }

    public static boolean C(@c.m0 Context context, @c.m0 List<x0> list) {
        List<x0> listW = w(list, 1);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 <= 29) {
            c(context, listW);
        }
        if (i7 >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator<x0> it = listW.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().H());
            }
            if (!z0.a(context.getSystemService(ShortcutManager.class)).updateShortcuts(arrayList)) {
                return false;
            }
        }
        o(context).a(listW);
        Iterator<l> it2 = n(context).iterator();
        while (it2.hasNext()) {
            it2.next().d(list);
        }
        return true;
    }

    public static boolean a(@c.m0 Context context, @c.m0 List<x0> list) {
        List<x0> listW = w(list, 1);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 <= 29) {
            c(context, listW);
        }
        if (i7 >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator<x0> it = listW.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().H());
            }
            if (!z0.a(context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        o(context).a(listW);
        Iterator<l> it2 = n(context).iterator();
        while (it2.hasNext()) {
            it2.next().b(list);
        }
        return true;
    }

    @c.g1
    static boolean b(@c.m0 Context context, @c.m0 x0 x0Var) {
        Bitmap bitmapDecodeStream;
        IconCompat iconCompat = x0Var.f5668i;
        if (iconCompat == null) {
            return false;
        }
        int i7 = iconCompat.f5800a;
        if (i7 != 6 && i7 != 4) {
            return true;
        }
        InputStream inputStreamF = iconCompat.F(context);
        if (inputStreamF == null || (bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamF)) == null) {
            return false;
        }
        x0Var.f5668i = i7 == 6 ? IconCompat.p(bitmapDecodeStream) : IconCompat.s(bitmapDecodeStream);
        return true;
    }

    @c.g1
    static void c(@c.m0 Context context, @c.m0 List<x0> list) {
        for (x0 x0Var : new ArrayList(list)) {
            if (!b(context, x0Var)) {
                list.remove(x0Var);
            }
        }
    }

    @c.m0
    public static Intent d(@c.m0 Context context, @c.m0 x0 x0Var) {
        Intent intentCreateShortcutResultIntent = Build.VERSION.SDK_INT >= 26 ? z0.a(context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(x0Var.H()) : null;
        if (intentCreateShortcutResultIntent == null) {
            intentCreateShortcutResultIntent = new Intent();
        }
        return x0Var.a(intentCreateShortcutResultIntent);
    }

    public static void e(@c.m0 Context context, @c.m0 List<String> list, @c.o0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 25) {
            z0.a(context.getSystemService(ShortcutManager.class)).disableShortcuts(list, charSequence);
        }
        o(context).d(list);
        Iterator<l> it = n(context).iterator();
        while (it.hasNext()) {
            it.next().c(list);
        }
    }

    public static void f(@c.m0 Context context, @c.m0 List<x0> list) {
        List<x0> listW = w(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<x0> it = listW.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f5661b);
            }
            z0.a(context.getSystemService(ShortcutManager.class)).enableShortcuts(arrayList);
        }
        o(context).a(listW);
        Iterator<l> it2 = n(context).iterator();
        while (it2.hasNext()) {
            it2.next().b(list);
        }
    }

    @c.m0
    public static List<x0> g(@c.m0 Context context) {
        if (Build.VERSION.SDK_INT < 25) {
            try {
                return o(context).b();
            } catch (Exception unused) {
                return new ArrayList();
            }
        }
        List dynamicShortcuts = z0.a(context.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
        ArrayList arrayList = new ArrayList(dynamicShortcuts.size());
        Iterator it = dynamicShortcuts.iterator();
        while (it.hasNext()) {
            arrayList.add(new x0.a(context, w.a(it.next())).c());
        }
        return arrayList;
    }

    private static int h(@c.m0 Context context, boolean z7) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        int iMax = Math.max(1, activityManager == null || activityManager.isLowRamDevice() ? 48 : 96);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (iMax * ((z7 ? displayMetrics.xdpi : displayMetrics.ydpi) / 160.0f));
    }

    public static int i(@c.m0 Context context) {
        androidx.core.util.w.l(context);
        return Build.VERSION.SDK_INT >= 25 ? z0.a(context.getSystemService(ShortcutManager.class)).getIconMaxHeight() : h(context, false);
    }

    public static int j(@c.m0 Context context) {
        androidx.core.util.w.l(context);
        return Build.VERSION.SDK_INT >= 25 ? z0.a(context.getSystemService(ShortcutManager.class)).getIconMaxWidth() : h(context, true);
    }

    public static int k(@c.m0 Context context) {
        androidx.core.util.w.l(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return z0.a(context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
        }
        return 5;
    }

    @c.g1
    static List<l> l() {
        return f5650k;
    }

    private static String m(@c.m0 List<x0> list) {
        int iV = -1;
        String strK = null;
        for (x0 x0Var : list) {
            if (x0Var.v() > iV) {
                strK = x0Var.k();
                iV = x0Var.v();
            }
        }
        return strK;
    }

    private static List<l> n(Context context) {
        Bundle bundle;
        String string;
        if (f5650k == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(f5651l);
            intent.setPackage(context.getPackageName());
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 128).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.metaData) != null && (string = bundle.getString(f5652m)) != null) {
                    try {
                        arrayList.add((l) Class.forName(string, false, v1.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                    } catch (Exception unused) {
                    }
                }
            }
            if (f5650k == null) {
                f5650k = arrayList;
            }
        }
        return f5650k;
    }

    private static y0<?> o(Context context) {
        if (f5649j == null) {
            try {
                f5649j = (y0) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, v1.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
            } catch (Exception unused) {
            }
            if (f5649j == null) {
                f5649j = new y0.a();
            }
        }
        return f5649j;
    }

    @c.m0
    public static List<x0> p(@c.m0 Context context, int i7) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 30) {
            return x0.c(context, z0.a(context.getSystemService(ShortcutManager.class)).getShortcuts(i7));
        }
        if (i8 < 25) {
            if ((i7 & 2) != 0) {
                try {
                    return o(context).b();
                } catch (Exception unused) {
                }
            }
            return Collections.emptyList();
        }
        ShortcutManager shortcutManagerA = z0.a(context.getSystemService(ShortcutManager.class));
        ArrayList arrayList = new ArrayList();
        if ((i7 & 1) != 0) {
            arrayList.addAll(shortcutManagerA.getManifestShortcuts());
        }
        if ((i7 & 2) != 0) {
            arrayList.addAll(shortcutManagerA.getDynamicShortcuts());
        }
        if ((i7 & 4) != 0) {
            arrayList.addAll(shortcutManagerA.getPinnedShortcuts());
        }
        return x0.c(context, arrayList);
    }

    public static boolean q(@c.m0 Context context) {
        androidx.core.util.w.l(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return z0.a(context.getSystemService(ShortcutManager.class)).isRateLimitingActive();
        }
        return p(context, 3).size() == k(context);
    }

    public static boolean r(@c.m0 Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return z0.a(context.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
        }
        if (androidx.core.content.d.a(context, f5645f) != 0) {
            return false;
        }
        Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(new Intent(f5644e), 0).iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.permission;
            if (TextUtils.isEmpty(str) || f5645f.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean s(@c.m0 Context context, @c.m0 x0 x0Var) {
        androidx.core.util.w.l(context);
        androidx.core.util.w.l(x0Var);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 <= 31 && x0Var.E(1)) {
            Iterator<l> it = n(context).iterator();
            while (it.hasNext()) {
                it.next().b(Collections.singletonList(x0Var));
            }
            return true;
        }
        int iK = k(context);
        if (iK == 0) {
            return false;
        }
        if (i7 <= 29) {
            b(context, x0Var);
        }
        if (i7 >= 30) {
            z0.a(context.getSystemService(ShortcutManager.class)).pushDynamicShortcut(x0Var.H());
        } else if (i7 >= 25) {
            ShortcutManager shortcutManagerA = z0.a(context.getSystemService(ShortcutManager.class));
            if (shortcutManagerA.isRateLimitingActive()) {
                return false;
            }
            List dynamicShortcuts = shortcutManagerA.getDynamicShortcuts();
            if (dynamicShortcuts.size() >= iK) {
                shortcutManagerA.removeDynamicShortcuts(Arrays.asList(b.a(dynamicShortcuts)));
            }
            shortcutManagerA.addDynamicShortcuts(Arrays.asList(x0Var.H()));
        }
        y0<?> y0VarO = o(context);
        try {
            List<x0> listB = y0VarO.b();
            if (listB.size() >= iK) {
                y0VarO.d(Arrays.asList(m(listB)));
            }
            y0VarO.a(Arrays.asList(x0Var));
            return true;
        } catch (Exception unused) {
            return false;
        } finally {
            Iterator<l> it2 = n(context).iterator();
            while (it2.hasNext()) {
                it2.next().b(Collections.singletonList(x0Var));
            }
            x(context, x0Var.k());
        }
    }

    public static void t(@c.m0 Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            z0.a(context.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        }
        o(context).c();
        Iterator<l> it = n(context).iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public static void u(@c.m0 Context context, @c.m0 List<String> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            z0.a(context.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(list);
        }
        o(context).d(list);
        Iterator<l> it = n(context).iterator();
        while (it.hasNext()) {
            it.next().c(list);
        }
    }

    public static void v(@c.m0 Context context, @c.m0 List<String> list) {
        if (Build.VERSION.SDK_INT < 30) {
            u(context, list);
            return;
        }
        z0.a(context.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(list);
        o(context).d(list);
        Iterator<l> it = n(context).iterator();
        while (it.hasNext()) {
            it.next().c(list);
        }
    }

    @c.m0
    private static List<x0> w(@c.m0 List<x0> list, int i7) {
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 31) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        for (x0 x0Var : list) {
            if (x0Var.E(i7)) {
                arrayList.remove(x0Var);
            }
        }
        return arrayList;
    }

    public static void x(@c.m0 Context context, @c.m0 String str) {
        androidx.core.util.w.l(context);
        androidx.core.util.w.l(str);
        if (Build.VERSION.SDK_INT >= 25) {
            z0.a(context.getSystemService(ShortcutManager.class)).reportShortcutUsed(str);
        }
        Iterator<l> it = n(context).iterator();
        while (it.hasNext()) {
            it.next().e(Collections.singletonList(str));
        }
    }

    public static boolean y(@c.m0 Context context, @c.m0 x0 x0Var, @c.o0 IntentSender intentSender) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 <= 31 && x0Var.E(1)) {
            return false;
        }
        if (i7 >= 26) {
            return z0.a(context.getSystemService(ShortcutManager.class)).requestPinShortcut(x0Var.H(), intentSender);
        }
        if (!r(context)) {
            return false;
        }
        Intent intentA = x0Var.a(new Intent(f5644e));
        if (intentSender == null) {
            context.sendBroadcast(intentA);
            return true;
        }
        context.sendOrderedBroadcast(intentA, null, new a(intentSender), null, -1, null, null);
        return true;
    }

    public static boolean z(@c.m0 Context context, @c.m0 List<x0> list) {
        androidx.core.util.w.l(context);
        androidx.core.util.w.l(list);
        List<x0> listW = w(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(listW.size());
            Iterator<x0> it = listW.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().H());
            }
            if (!z0.a(context.getSystemService(ShortcutManager.class)).setDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        o(context).c();
        o(context).a(listW);
        for (l lVar : n(context)) {
            lVar.a();
            lVar.b(list);
        }
        return true;
    }
}
