package androidx.core.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class c7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5098a = "androidx.core.app.EXTRA_CALLING_PACKAGE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5099b = "android.support.v4.app.EXTRA_CALLING_PACKAGE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5100c = "androidx.core.app.EXTRA_CALLING_ACTIVITY";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5101d = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f5102e = ".sharecompat_";

    @c.t0(16)
    private static class a {
        private a() {
        }

        @c.t
        static String a(CharSequence charSequence) {
            return Html.escapeHtml(charSequence);
        }

        @c.t
        static void b(@c.m0 Intent intent, @c.m0 ArrayList<Uri> arrayList) {
            ClipData clipData = new ClipData(null, new String[]{intent.getType()}, new ClipData.Item(intent.getCharSequenceExtra("android.intent.extra.TEXT"), intent.getStringExtra(androidx.core.content.l.f5633b), null, arrayList.get(0)));
            int size = arrayList.size();
            for (int i7 = 1; i7 < size; i7++) {
                clipData.addItem(new ClipData.Item(arrayList.get(i7)));
            }
            intent.setClipData(clipData);
            intent.addFlags(1);
        }

        @c.t
        static void c(@c.m0 Intent intent) {
            intent.setClipData(null);
            intent.setFlags(intent.getFlags() & (-2));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.m0
        private final Context f5103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c.m0
        private final Intent f5104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @c.o0
        private CharSequence f5105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @c.o0
        private ArrayList<String> f5106d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @c.o0
        private ArrayList<String> f5107e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @c.o0
        private ArrayList<String> f5108f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @c.o0
        private ArrayList<Uri> f5109g;

        public b(@c.m0 Context context) {
            Activity activity;
            this.f5103a = (Context) androidx.core.util.w.l(context);
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.f5104b = action;
            action.putExtra(c7.f5098a, context.getPackageName());
            action.putExtra(c7.f5099b, context.getPackageName());
            action.addFlags(524288);
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity != null) {
                ComponentName componentName = activity.getComponentName();
                this.f5104b.putExtra(c7.f5100c, componentName);
                this.f5104b.putExtra(c7.f5101d, componentName);
            }
        }

        private void h(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.f5104b.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[arrayList.size() + length];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.f5104b.putExtra(str, strArr);
        }

        private void i(@c.o0 String str, @c.m0 String[] strArr) {
            Intent intentM = m();
            String[] stringArrayExtra = intentM.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr2 = new String[strArr.length + length];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
            }
            System.arraycopy(strArr, 0, strArr2, length, strArr.length);
            intentM.putExtra(str, strArr2);
        }

        @c.m0
        @Deprecated
        public static b k(@c.m0 Activity activity) {
            return new b(activity);
        }

        @c.m0
        public b a(@c.m0 String str) {
            if (this.f5108f == null) {
                this.f5108f = new ArrayList<>();
            }
            this.f5108f.add(str);
            return this;
        }

        @c.m0
        public b b(@c.m0 String[] strArr) {
            i("android.intent.extra.BCC", strArr);
            return this;
        }

        @c.m0
        public b c(@c.m0 String str) {
            if (this.f5107e == null) {
                this.f5107e = new ArrayList<>();
            }
            this.f5107e.add(str);
            return this;
        }

        @c.m0
        public b d(@c.m0 String[] strArr) {
            i("android.intent.extra.CC", strArr);
            return this;
        }

        @c.m0
        public b e(@c.m0 String str) {
            if (this.f5106d == null) {
                this.f5106d = new ArrayList<>();
            }
            this.f5106d.add(str);
            return this;
        }

        @c.m0
        public b f(@c.m0 String[] strArr) {
            i("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @c.m0
        public b g(@c.m0 Uri uri) {
            if (this.f5109g == null) {
                this.f5109g = new ArrayList<>();
            }
            this.f5109g.add(uri);
            return this;
        }

        @c.m0
        public Intent j() {
            return Intent.createChooser(m(), this.f5105c);
        }

        @c.m0
        Context l() {
            return this.f5103a;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x002f  */
        @c.m0
        public Intent m() {
            boolean z7;
            ArrayList<String> arrayList = this.f5106d;
            if (arrayList != null) {
                h("android.intent.extra.EMAIL", arrayList);
                this.f5106d = null;
            }
            ArrayList<String> arrayList2 = this.f5107e;
            if (arrayList2 != null) {
                h("android.intent.extra.CC", arrayList2);
                this.f5107e = null;
            }
            ArrayList<String> arrayList3 = this.f5108f;
            if (arrayList3 != null) {
                h("android.intent.extra.BCC", arrayList3);
                this.f5108f = null;
            }
            ArrayList<Uri> arrayList4 = this.f5109g;
            if (arrayList4 != null) {
                z7 = arrayList4.size() > 1;
            }
            if (z7) {
                this.f5104b.setAction("android.intent.action.SEND_MULTIPLE");
                this.f5104b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f5109g);
                a.b(this.f5104b, this.f5109g);
            } else {
                this.f5104b.setAction("android.intent.action.SEND");
                ArrayList<Uri> arrayList5 = this.f5109g;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    this.f5104b.removeExtra("android.intent.extra.STREAM");
                    a.c(this.f5104b);
                } else {
                    this.f5104b.putExtra("android.intent.extra.STREAM", this.f5109g.get(0));
                    a.b(this.f5104b, this.f5109g);
                }
            }
            return this.f5104b;
        }

        @c.m0
        public b n(@c.a1 int i7) {
            return o(this.f5103a.getText(i7));
        }

        @c.m0
        public b o(@c.o0 CharSequence charSequence) {
            this.f5105c = charSequence;
            return this;
        }

        @c.m0
        public b p(@c.o0 String[] strArr) {
            this.f5104b.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        @c.m0
        public b q(@c.o0 String[] strArr) {
            this.f5104b.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        @c.m0
        public b r(@c.o0 String[] strArr) {
            if (this.f5106d != null) {
                this.f5106d = null;
            }
            this.f5104b.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @c.m0
        public b s(@c.o0 String str) {
            this.f5104b.putExtra(androidx.core.content.l.f5633b, str);
            if (!this.f5104b.hasExtra("android.intent.extra.TEXT")) {
                v(Html.fromHtml(str));
            }
            return this;
        }

        @c.m0
        public b t(@c.o0 Uri uri) {
            this.f5109g = null;
            if (uri != null) {
                g(uri);
            }
            return this;
        }

        @c.m0
        public b u(@c.o0 String str) {
            this.f5104b.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        @c.m0
        public b v(@c.o0 CharSequence charSequence) {
            this.f5104b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        @c.m0
        public b w(@c.o0 String str) {
            this.f5104b.setType(str);
            return this;
        }

        public void x() {
            this.f5103a.startActivity(j());
        }
    }

    public static class c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f5110f = "IntentReader";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.m0
        private final Context f5111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c.m0
        private final Intent f5112b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @c.o0
        private final String f5113c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @c.o0
        private final ComponentName f5114d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @c.o0
        private ArrayList<Uri> f5115e;

        public c(@c.m0 Activity activity) {
            this((Context) androidx.core.util.w.l(activity), activity.getIntent());
        }

        @c.m0
        @Deprecated
        public static c a(@c.m0 Activity activity) {
            return new c(activity);
        }

        private static void t(StringBuilder sb, CharSequence charSequence, int i7, int i8) {
            while (i7 < i8) {
                char cCharAt = charSequence.charAt(i7);
                if (cCharAt == '<') {
                    sb.append("&lt;");
                } else if (cCharAt == '>') {
                    sb.append("&gt;");
                } else if (cCharAt == '&') {
                    sb.append("&amp;");
                } else if (cCharAt > '~' || cCharAt < ' ') {
                    sb.append("&#");
                    sb.append((int) cCharAt);
                    sb.append(com.alipay.sdk.util.j.f13806b);
                } else if (cCharAt == ' ') {
                    while (true) {
                        int i9 = i7 + 1;
                        if (i9 >= i8 || charSequence.charAt(i9) != ' ') {
                            break;
                        }
                        sb.append("&nbsp;");
                        i7 = i9;
                    }
                    sb.append(' ');
                } else {
                    sb.append(cCharAt);
                }
                i7++;
            }
        }

        @c.o0
        public ComponentName b() {
            return this.f5114d;
        }

        @c.o0
        public Drawable c() {
            if (this.f5114d == null) {
                return null;
            }
            try {
                return this.f5111a.getPackageManager().getActivityIcon(this.f5114d);
            } catch (PackageManager.NameNotFoundException e8) {
                Log.e(f5110f, "Could not retrieve icon for calling activity", e8);
                return null;
            }
        }

        @c.o0
        public Drawable d() {
            if (this.f5113c == null) {
                return null;
            }
            try {
                return this.f5111a.getPackageManager().getApplicationIcon(this.f5113c);
            } catch (PackageManager.NameNotFoundException e8) {
                Log.e(f5110f, "Could not retrieve icon for calling application", e8);
                return null;
            }
        }

        @c.o0
        public CharSequence e() {
            if (this.f5113c == null) {
                return null;
            }
            PackageManager packageManager = this.f5111a.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f5113c, 0));
            } catch (PackageManager.NameNotFoundException e8) {
                Log.e(f5110f, "Could not retrieve label for calling application", e8);
                return null;
            }
        }

        @c.o0
        public String f() {
            return this.f5113c;
        }

        @c.o0
        public String[] g() {
            return this.f5112b.getStringArrayExtra("android.intent.extra.BCC");
        }

        @c.o0
        public String[] h() {
            return this.f5112b.getStringArrayExtra("android.intent.extra.CC");
        }

        @c.o0
        public String[] i() {
            return this.f5112b.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        @c.o0
        public String j() {
            String stringExtra = this.f5112b.getStringExtra(androidx.core.content.l.f5633b);
            if (stringExtra != null) {
                return stringExtra;
            }
            CharSequence charSequenceO = o();
            if (charSequenceO instanceof Spanned) {
                return Html.toHtml((Spanned) charSequenceO);
            }
            return charSequenceO != null ? a.a(charSequenceO) : stringExtra;
        }

        @c.o0
        public Uri k() {
            return (Uri) this.f5112b.getParcelableExtra("android.intent.extra.STREAM");
        }

        @c.o0
        public Uri l(int i7) {
            if (this.f5115e == null && q()) {
                this.f5115e = this.f5112b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.f5115e;
            if (arrayList != null) {
                return arrayList.get(i7);
            }
            if (i7 == 0) {
                return (Uri) this.f5112b.getParcelableExtra("android.intent.extra.STREAM");
            }
            throw new IndexOutOfBoundsException("Stream items available: " + m() + " index requested: " + i7);
        }

        public int m() {
            if (this.f5115e == null && q()) {
                this.f5115e = this.f5112b.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.f5115e;
            return arrayList != null ? arrayList.size() : this.f5112b.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        @c.o0
        public String n() {
            return this.f5112b.getStringExtra("android.intent.extra.SUBJECT");
        }

        @c.o0
        public CharSequence o() {
            return this.f5112b.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        @c.o0
        public String p() {
            return this.f5112b.getType();
        }

        public boolean q() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.f5112b.getAction());
        }

        public boolean r() {
            String action = this.f5112b.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean s() {
            return "android.intent.action.SEND".equals(this.f5112b.getAction());
        }

        public c(@c.m0 Context context, @c.m0 Intent intent) {
            this.f5111a = (Context) androidx.core.util.w.l(context);
            this.f5112b = (Intent) androidx.core.util.w.l(intent);
            this.f5113c = c7.f(intent);
            this.f5114d = c7.d(intent);
        }
    }

    private c7() {
    }

    @Deprecated
    public static void a(@c.m0 Menu menu, @c.b0 int i7, @c.m0 b bVar) {
        MenuItem menuItemFindItem = menu.findItem(i7);
        if (menuItemFindItem != null) {
            b(menuItemFindItem, bVar);
            return;
        }
        throw new IllegalArgumentException("Could not find menu item with id " + i7 + " in the supplied menu");
    }

    @Deprecated
    public static void b(@c.m0 MenuItem menuItem, @c.m0 b bVar) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        ShareActionProvider shareActionProvider = !(actionProvider instanceof ShareActionProvider) ? new ShareActionProvider(bVar.l()) : (ShareActionProvider) actionProvider;
        shareActionProvider.setShareHistoryFileName(f5102e + bVar.l().getClass().getName());
        shareActionProvider.setShareIntent(bVar.m());
        menuItem.setActionProvider(shareActionProvider);
    }

    @c.o0
    public static ComponentName c(@c.m0 Activity activity) {
        Intent intent = activity.getIntent();
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? d(intent) : callingActivity;
    }

    @c.o0
    static ComponentName d(@c.m0 Intent intent) {
        ComponentName componentName = (ComponentName) intent.getParcelableExtra(f5100c);
        return componentName == null ? (ComponentName) intent.getParcelableExtra(f5101d) : componentName;
    }

    @c.o0
    public static String e(@c.m0 Activity activity) {
        Intent intent = activity.getIntent();
        String callingPackage = activity.getCallingPackage();
        return (callingPackage != null || intent == null) ? callingPackage : f(intent);
    }

    @c.o0
    static String f(@c.m0 Intent intent) {
        String stringExtra = intent.getStringExtra(f5098a);
        return stringExtra == null ? intent.getStringExtra(f5099b) : stringExtra;
    }
}
