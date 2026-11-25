package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.i;
import androidx.core.app.r;
import c.l;
import c.m0;
import c.o0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final String A = "android.support.customtabs.customaction.ID";
    public static final int B = 0;
    private static final int C = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f2166c = "android.support.customtabs.extra.user_opt_out";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f2167d = "android.support.customtabs.extra.SESSION";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f2168e = "android.support.customtabs.extra.TOOLBAR_COLOR";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f2169f = "android.support.customtabs.extra.ENABLE_URLBAR_HIDING";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f2170g = "android.support.customtabs.extra.CLOSE_BUTTON_ICON";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f2171h = "android.support.customtabs.extra.TITLE_VISIBILITY";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f2172i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f2173j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f2174k = "android.support.customtabs.extra.ACTION_BUTTON_BUNDLE";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f2175l = "android.support.customtabs.extra.TOOLBAR_ITEMS";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f2176m = "android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f2177n = "android.support.customtabs.customaction.ICON";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f2178o = "android.support.customtabs.customaction.DESCRIPTION";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f2179p = "android.support.customtabs.customaction.PENDING_INTENT";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f2180q = "android.support.customtabs.extra.TINT_ACTION_BUTTON";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f2181r = "android.support.customtabs.extra.MENU_ITEMS";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f2182s = "android.support.customtabs.customaction.MENU_ITEM_TITLE";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f2183t = "android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f2184u = "android.support.customtabs.extra.SHARE_MENU_ITEM";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f2185v = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f2186w = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f2187x = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f2188y = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_CLICKED_ID";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f2189z = "android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    public final Intent f2190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    public final Bundle f2191b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f2192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<Bundle> f2193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bundle f2194c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ArrayList<Bundle> f2195d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2196e;

        public a() {
            this(null);
        }

        public a a() {
            this.f2192a.putExtra(c.f2184u, true);
            return this;
        }

        public a b(@m0 String str, @m0 PendingIntent pendingIntent) {
            if (this.f2193b == null) {
                this.f2193b = new ArrayList<>();
            }
            Bundle bundle = new Bundle();
            bundle.putString(c.f2182s, str);
            bundle.putParcelable(c.f2179p, pendingIntent);
            this.f2193b.add(bundle);
            return this;
        }

        @Deprecated
        public a c(int i7, @m0 Bitmap bitmap, @m0 String str, PendingIntent pendingIntent) throws IllegalStateException {
            if (this.f2195d == null) {
                this.f2195d = new ArrayList<>();
            }
            if (this.f2195d.size() >= 5) {
                throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
            }
            Bundle bundle = new Bundle();
            bundle.putInt(c.A, i7);
            bundle.putParcelable(c.f2177n, bitmap);
            bundle.putString(c.f2178o, str);
            bundle.putParcelable(c.f2179p, pendingIntent);
            this.f2195d.add(bundle);
            return this;
        }

        public c d() {
            ArrayList<Bundle> arrayList = this.f2193b;
            if (arrayList != null) {
                this.f2192a.putParcelableArrayListExtra(c.f2181r, arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f2195d;
            if (arrayList2 != null) {
                this.f2192a.putParcelableArrayListExtra(c.f2175l, arrayList2);
            }
            this.f2192a.putExtra(c.f2189z, this.f2196e);
            return new c(this.f2192a, this.f2194c);
        }

        public a e() {
            this.f2192a.putExtra(c.f2169f, true);
            return this;
        }

        public a f(@m0 Bitmap bitmap, @m0 String str, @m0 PendingIntent pendingIntent) {
            return g(bitmap, str, pendingIntent, false);
        }

        public a g(@m0 Bitmap bitmap, @m0 String str, @m0 PendingIntent pendingIntent, boolean z7) {
            Bundle bundle = new Bundle();
            bundle.putInt(c.A, 0);
            bundle.putParcelable(c.f2177n, bitmap);
            bundle.putString(c.f2178o, str);
            bundle.putParcelable(c.f2179p, pendingIntent);
            this.f2192a.putExtra(c.f2174k, bundle);
            this.f2192a.putExtra(c.f2180q, z7);
            return this;
        }

        public a h(@m0 Bitmap bitmap) {
            this.f2192a.putExtra(c.f2170g, bitmap);
            return this;
        }

        public a i(@m0 Context context, @c.a int i7, @c.a int i8) {
            this.f2192a.putExtra(c.f2183t, i.d(context, i7, i8).l());
            return this;
        }

        public a j(boolean z7) {
            this.f2196e = z7;
            return this;
        }

        public a k(@l int i7) {
            this.f2192a.putExtra(c.f2176m, i7);
            return this;
        }

        public a l(@m0 RemoteViews remoteViews, @o0 int[] iArr, @o0 PendingIntent pendingIntent) {
            this.f2192a.putExtra(c.f2185v, remoteViews);
            this.f2192a.putExtra(c.f2186w, iArr);
            this.f2192a.putExtra(c.f2187x, pendingIntent);
            return this;
        }

        public a m(boolean z7) {
            this.f2192a.putExtra(c.f2171h, z7 ? 1 : 0);
            return this;
        }

        public a n(@m0 Context context, @c.a int i7, @c.a int i8) {
            this.f2194c = i.d(context, i7, i8).l();
            return this;
        }

        public a o(@l int i7) {
            this.f2192a.putExtra(c.f2168e, i7);
            return this;
        }

        public a(@o0 e eVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.f2192a = intent;
            this.f2193b = null;
            this.f2194c = null;
            this.f2195d = null;
            this.f2196e = true;
            if (eVar != null) {
                intent.setPackage(eVar.c().getPackageName());
            }
            Bundle bundle = new Bundle();
            r.b(bundle, c.f2167d, eVar != null ? eVar.b() : null);
            intent.putExtras(bundle);
        }
    }

    c(Intent intent, Bundle bundle) {
        this.f2190a = intent;
        this.f2191b = bundle;
    }

    public static int a() {
        return 5;
    }

    public static Intent c(Intent intent) {
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW");
        }
        intent.addFlags(268435456);
        intent.putExtra(f2166c, true);
        return intent;
    }

    public static boolean d(Intent intent) {
        return intent.getBooleanExtra(f2166c, false) && (intent.getFlags() & 268435456) != 0;
    }

    public void b(Context context, Uri uri) {
        this.f2190a.setData(uri);
        androidx.core.content.d.t(context, this.f2190a, this.f2191b);
    }
}
