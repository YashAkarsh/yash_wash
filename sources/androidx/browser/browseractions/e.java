package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import c.g1;
import c.m0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2092b = "BrowserActions";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f2093c = "https://www.example.com";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f2094d = "androidx.browser.browseractions.APP_ID";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f2095e = "androidx.browser.browseractions.browser_action_open";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f2096f = "androidx.browser.browseractions.ICON_ID";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f2097g = "androidx.browser.browseractions.TITLE";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f2098h = "androidx.browser.browseractions.ACTION";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f2099i = "androidx.browser.browseractions.extra.TYPE";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f2100j = "androidx.browser.browseractions.extra.MENU_ITEMS";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f2101k = "androidx.browser.browseractions.extra.SELECTED_ACTION_PENDING_INTENT";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f2102l = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f2103m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f2104n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f2105o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f2106p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f2107q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f2108r = 5;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f2109s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f2110t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f2111u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f2112v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f2113w = 3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f2114x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static a f2115y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Intent f2116a;

    @x0({x0.a.LIBRARY_GROUP})
    @g1
    interface a {
        void a();
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f2118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Uri f2119c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ArrayList<Bundle> f2121e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f2117a = new Intent(e.f2095e);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private PendingIntent f2122f = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2120d = 0;

        public d(Context context, Uri uri) {
            this.f2121e = null;
            this.f2118b = context;
            this.f2119c = uri;
            this.f2121e = new ArrayList<>();
        }

        private Bundle b(androidx.browser.browseractions.a aVar) {
            Bundle bundle = new Bundle();
            bundle.putString(e.f2097g, aVar.c());
            bundle.putParcelable(e.f2098h, aVar.a());
            if (aVar.b() != 0) {
                bundle.putInt(e.f2096f, aVar.b());
            }
            return bundle;
        }

        public e a() {
            this.f2117a.setData(this.f2119c);
            this.f2117a.putExtra(e.f2099i, this.f2120d);
            this.f2117a.putParcelableArrayListExtra(e.f2100j, this.f2121e);
            this.f2117a.putExtra(e.f2094d, PendingIntent.getActivity(this.f2118b, 0, new Intent(), 0));
            PendingIntent pendingIntent = this.f2122f;
            if (pendingIntent != null) {
                this.f2117a.putExtra(e.f2101k, pendingIntent);
            }
            return new e(this.f2117a);
        }

        public d c(ArrayList<androidx.browser.browseractions.a> arrayList) {
            if (arrayList.size() > 5) {
                throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
            }
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                if (TextUtils.isEmpty(arrayList.get(i7).c()) || arrayList.get(i7).a() == null) {
                    throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
                }
                this.f2121e.add(b(arrayList.get(i7)));
            }
            return this;
        }

        public d d(androidx.browser.browseractions.a... aVarArr) {
            return c(new ArrayList<>(Arrays.asList(aVarArr)));
        }

        public d e(PendingIntent pendingIntent) {
            this.f2122f = pendingIntent;
            return this;
        }

        public d f(int i7) {
            this.f2120d = i7;
            return this;
        }
    }

    e(@m0 Intent intent) {
        this.f2116a = intent;
    }

    private static List<ResolveInfo> a(Context context) {
        return context.getPackageManager().queryIntentActivities(new Intent(f2095e, Uri.parse(f2093c)), 131072);
    }

    public static String b(Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(f2094d);
        if (pendingIntent != null) {
            return pendingIntent.getCreatorPackage();
        }
        return null;
    }

    public static void d(Context context, Intent intent) {
        e(context, intent, a(context));
    }

    @x0({x0.a.LIBRARY_GROUP})
    @g1
    static void e(Context context, Intent intent, List<ResolveInfo> list) {
        if (list == null || list.size() == 0) {
            h(context, intent);
            return;
        }
        if (list.size() == 1) {
            intent.setPackage(list.get(0).activityInfo.packageName);
        } else {
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(f2093c)), 65536);
            if (resolveInfoResolveActivity != null) {
                String str = resolveInfoResolveActivity.activityInfo.packageName;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    if (str.equals(list.get(i7).activityInfo.packageName)) {
                        intent.setPackage(str);
                        break;
                    }
                }
            }
        }
        androidx.core.content.d.t(context, intent, null);
    }

    public static void f(Context context, Uri uri) {
        d(context, new d(context, uri).a().c());
    }

    public static void g(Context context, Uri uri, int i7, ArrayList<androidx.browser.browseractions.a> arrayList, PendingIntent pendingIntent) {
        d(context, new d(context, uri).f(i7).c(arrayList).e(pendingIntent).a().c());
    }

    private static void h(Context context, Intent intent) {
        Uri data = intent.getData();
        int intExtra = intent.getIntExtra(f2099i, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(f2100j);
        i(context, data, intExtra, parcelableArrayListExtra != null ? j(parcelableArrayListExtra) : null);
    }

    private static void i(Context context, Uri uri, int i7, List<androidx.browser.browseractions.a> list) {
        new androidx.browser.browseractions.d(context, uri, list).a();
        a aVar = f2115y;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static List<androidx.browser.browseractions.a> j(ArrayList<Bundle> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            Bundle bundle = arrayList.get(i7);
            String string = bundle.getString(f2097g);
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(f2098h);
            int i8 = bundle.getInt(f2096f);
            if (TextUtils.isEmpty(string) || pendingIntent == null) {
                throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
            }
            arrayList2.add(new androidx.browser.browseractions.a(string, pendingIntent, i8));
        }
        return arrayList2;
    }

    @x0({x0.a.LIBRARY_GROUP})
    @g1
    static void k(a aVar) {
        f2115y = aVar;
    }

    @m0
    public Intent c() {
        return this.f2116a;
    }
}
