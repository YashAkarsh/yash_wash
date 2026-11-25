package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.app.r5;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class x0 {
    private static final String C = "extraPersonCount";
    private static final String D = "extraPerson_";
    private static final String E = "extraLocusId";
    private static final String F = "extraLongLived";
    private static final String G = "extraSliceUri";
    public static final int H = 1;
    int A;
    int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f5660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f5661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f5662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Intent[] f5663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ComponentName f5664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    CharSequence f5665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    CharSequence f5666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    CharSequence f5667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    IconCompat f5668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f5669j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    r5[] f5670k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Set<String> f5671l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @c.o0
    androidx.core.content.p f5672m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f5673n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f5674o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    PersistableBundle f5675p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Bundle f5676q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    long f5677r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    UserHandle f5678s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f5679t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f5680u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    boolean f5681v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    boolean f5682w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    boolean f5683x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    boolean f5684y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    boolean f5685z;

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    x0() {
    }

    @c.t0(22)
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    private PersistableBundle b() {
        if (this.f5675p == null) {
            this.f5675p = new PersistableBundle();
        }
        r5[] r5VarArr = this.f5670k;
        if (r5VarArr != null && r5VarArr.length > 0) {
            this.f5675p.putInt(C, r5VarArr.length);
            int i7 = 0;
            while (i7 < this.f5670k.length) {
                PersistableBundle persistableBundle = this.f5675p;
                StringBuilder sb = new StringBuilder();
                sb.append(D);
                int i8 = i7 + 1;
                sb.append(i8);
                persistableBundle.putPersistableBundle(sb.toString(), this.f5670k[i7].n());
                i7 = i8;
            }
        }
        androidx.core.content.p pVar = this.f5672m;
        if (pVar != null) {
            this.f5675p.putString(E, pVar.a());
        }
        this.f5675p.putBoolean(F, this.f5673n);
        return this.f5675p;
    }

    @c.t0(25)
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    static List<x0> c(@c.m0 Context context, @c.m0 List<ShortcutInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<ShortcutInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new a(context, w.a(it.next())).c());
        }
        return arrayList;
    }

    @c.o0
    @c.t0(25)
    static androidx.core.content.p p(@c.m0 ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT < 29) {
            return q(shortcutInfo.getExtras());
        }
        if (shortcutInfo.getLocusId() == null) {
            return null;
        }
        return androidx.core.content.p.d(shortcutInfo.getLocusId());
    }

    @c.o0
    @c.t0(25)
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    private static androidx.core.content.p q(@c.o0 PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString(E)) == null) {
            return null;
        }
        return new androidx.core.content.p(string);
    }

    @c.t0(25)
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @c.g1
    static boolean s(@c.o0 PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(F)) {
            return false;
        }
        return persistableBundle.getBoolean(F);
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @c.g1
    @c.t0(25)
    static r5[] u(@c.m0 PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(C)) {
            return null;
        }
        int i7 = persistableBundle.getInt(C);
        r5[] r5VarArr = new r5[i7];
        int i8 = 0;
        while (i8 < i7) {
            StringBuilder sb = new StringBuilder();
            sb.append(D);
            int i9 = i8 + 1;
            sb.append(i9);
            r5VarArr[i8] = r5.c(persistableBundle.getPersistableBundle(sb.toString()));
            i8 = i9;
        }
        return r5VarArr;
    }

    public boolean A() {
        return this.f5679t;
    }

    public boolean B() {
        return this.f5682w;
    }

    public boolean C() {
        return this.f5680u;
    }

    public boolean D() {
        return this.f5684y;
    }

    public boolean E(int i7) {
        return (i7 & this.B) != 0;
    }

    public boolean F() {
        return this.f5683x;
    }

    public boolean G() {
        return this.f5681v;
    }

    @c.t0(25)
    public ShortcutInfo H() {
        u.a();
        ShortcutInfo.Builder intents = t.a(this.f5660a, this.f5661b).setShortLabel(this.f5665f).setIntents(this.f5663d);
        IconCompat iconCompat = this.f5668i;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.M(this.f5660a));
        }
        if (!TextUtils.isEmpty(this.f5666g)) {
            intents.setLongLabel(this.f5666g);
        }
        if (!TextUtils.isEmpty(this.f5667h)) {
            intents.setDisabledMessage(this.f5667h);
        }
        ComponentName componentName = this.f5664e;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.f5671l;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.f5674o);
        PersistableBundle persistableBundle = this.f5675p;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            r5[] r5VarArr = this.f5670k;
            if (r5VarArr != null && r5VarArr.length > 0) {
                int length = r5VarArr.length;
                Person[] personArr = new Person[length];
                for (int i7 = 0; i7 < length; i7++) {
                    personArr[i7] = this.f5670k[i7].k();
                }
                intents.setPersons(personArr);
            }
            androidx.core.content.p pVar = this.f5672m;
            if (pVar != null) {
                intents.setLocusId(pVar.c());
            }
            intents.setLongLived(this.f5673n);
        } else {
            intents.setExtras(b());
        }
        return intents.build();
    }

    Intent a(Intent intent) {
        Intent[] intentArr = this.f5663d;
        intent.putExtra("android.intent.extra.shortcut.INTENT", intentArr[intentArr.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.f5665f.toString());
        if (this.f5668i != null) {
            Drawable activityIcon = null;
            if (this.f5669j) {
                PackageManager packageManager = this.f5660a.getPackageManager();
                ComponentName componentName = this.f5664e;
                if (componentName != null) {
                    try {
                        activityIcon = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (activityIcon == null) {
                    activityIcon = this.f5660a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.f5668i.i(intent, activityIcon, this.f5660a);
        }
        return intent;
    }

    @c.o0
    public ComponentName d() {
        return this.f5664e;
    }

    @c.o0
    public Set<String> e() {
        return this.f5671l;
    }

    @c.o0
    public CharSequence f() {
        return this.f5667h;
    }

    public int g() {
        return this.A;
    }

    public int h() {
        return this.B;
    }

    @c.o0
    public PersistableBundle i() {
        return this.f5675p;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public IconCompat j() {
        return this.f5668i;
    }

    @c.m0
    public String k() {
        return this.f5661b;
    }

    @c.m0
    public Intent l() {
        Intent[] intentArr = this.f5663d;
        return intentArr[intentArr.length - 1];
    }

    @c.m0
    public Intent[] m() {
        Intent[] intentArr = this.f5663d;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public long n() {
        return this.f5677r;
    }

    @c.o0
    public androidx.core.content.p o() {
        return this.f5672m;
    }

    @c.o0
    public CharSequence r() {
        return this.f5666g;
    }

    @c.m0
    public String t() {
        return this.f5662c;
    }

    public int v() {
        return this.f5674o;
    }

    @c.m0
    public CharSequence w() {
        return this.f5665f;
    }

    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public Bundle x() {
        return this.f5676q;
    }

    @c.o0
    public UserHandle y() {
        return this.f5678s;
    }

    public boolean z() {
        return this.f5685z;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x0 f5686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f5687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Set<String> f5688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Map<String, Map<String, List<String>>> f5689d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Uri f5690e;

        public a(@c.m0 Context context, @c.m0 String str) {
            x0 x0Var = new x0();
            this.f5686a = x0Var;
            x0Var.f5660a = context;
            x0Var.f5661b = str;
        }

        @c.m0
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public a a(@c.m0 String str) {
            if (this.f5688c == null) {
                this.f5688c = new HashSet();
            }
            this.f5688c.add(str);
            return this;
        }

        @c.m0
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public a b(@c.m0 String str, @c.m0 String str2, @c.m0 List<String> list) {
            a(str);
            if (!list.isEmpty()) {
                if (this.f5689d == null) {
                    this.f5689d = new HashMap();
                }
                if (this.f5689d.get(str) == null) {
                    this.f5689d.put(str, new HashMap());
                }
                this.f5689d.get(str).put(str2, list);
            }
            return this;
        }

        @c.m0
        public x0 c() {
            if (TextUtils.isEmpty(this.f5686a.f5665f)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            x0 x0Var = this.f5686a;
            Intent[] intentArr = x0Var.f5663d;
            if (intentArr == null || intentArr.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.f5687b) {
                if (x0Var.f5672m == null) {
                    x0Var.f5672m = new androidx.core.content.p(x0Var.f5661b);
                }
                this.f5686a.f5673n = true;
            }
            if (this.f5688c != null) {
                x0 x0Var2 = this.f5686a;
                if (x0Var2.f5671l == null) {
                    x0Var2.f5671l = new HashSet();
                }
                this.f5686a.f5671l.addAll(this.f5688c);
            }
            if (this.f5689d != null) {
                x0 x0Var3 = this.f5686a;
                if (x0Var3.f5675p == null) {
                    x0Var3.f5675p = new PersistableBundle();
                }
                for (String str : this.f5689d.keySet()) {
                    Map<String, List<String>> map = this.f5689d.get(str);
                    this.f5686a.f5675p.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                    for (String str2 : map.keySet()) {
                        List<String> list = map.get(str2);
                        this.f5686a.f5675p.putStringArray(str + "/" + str2, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                    }
                }
            }
            if (this.f5690e != null) {
                x0 x0Var4 = this.f5686a;
                if (x0Var4.f5675p == null) {
                    x0Var4.f5675p = new PersistableBundle();
                }
                this.f5686a.f5675p.putString(x0.G, androidx.core.net.i.a(this.f5690e));
            }
            return this.f5686a;
        }

        @c.m0
        public a d(@c.m0 ComponentName componentName) {
            this.f5686a.f5664e = componentName;
            return this;
        }

        @c.m0
        public a e() {
            this.f5686a.f5669j = true;
            return this;
        }

        @c.m0
        public a f(@c.m0 Set<String> set) {
            this.f5686a.f5671l = set;
            return this;
        }

        @c.m0
        public a g(@c.m0 CharSequence charSequence) {
            this.f5686a.f5667h = charSequence;
            return this;
        }

        @c.m0
        public a h(int i7) {
            this.f5686a.B = i7;
            return this;
        }

        @c.m0
        public a i(@c.m0 PersistableBundle persistableBundle) {
            this.f5686a.f5675p = persistableBundle;
            return this;
        }

        @c.m0
        public a j(IconCompat iconCompat) {
            this.f5686a.f5668i = iconCompat;
            return this;
        }

        @c.m0
        public a k(@c.m0 Intent intent) {
            return l(new Intent[]{intent});
        }

        @c.m0
        public a l(@c.m0 Intent[] intentArr) {
            this.f5686a.f5663d = intentArr;
            return this;
        }

        @c.m0
        public a m() {
            this.f5687b = true;
            return this;
        }

        @c.m0
        public a n(@c.o0 androidx.core.content.p pVar) {
            this.f5686a.f5672m = pVar;
            return this;
        }

        @c.m0
        public a o(@c.m0 CharSequence charSequence) {
            this.f5686a.f5666g = charSequence;
            return this;
        }

        @c.m0
        @Deprecated
        public a p() {
            this.f5686a.f5673n = true;
            return this;
        }

        @c.m0
        public a q(boolean z7) {
            this.f5686a.f5673n = z7;
            return this;
        }

        @c.m0
        public a r(@c.m0 r5 r5Var) {
            return s(new r5[]{r5Var});
        }

        @c.m0
        public a s(@c.m0 r5[] r5VarArr) {
            this.f5686a.f5670k = r5VarArr;
            return this;
        }

        @c.m0
        public a t(int i7) {
            this.f5686a.f5674o = i7;
            return this;
        }

        @c.m0
        public a u(@c.m0 CharSequence charSequence) {
            this.f5686a.f5665f = charSequence;
            return this;
        }

        @c.m0
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public a v(@c.m0 Uri uri) {
            this.f5690e = uri;
            return this;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        @c.m0
        public a w(@c.m0 Bundle bundle) {
            this.f5686a.f5676q = (Bundle) androidx.core.util.w.l(bundle);
            return this;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public a(@c.m0 x0 x0Var) {
            x0 x0Var2 = new x0();
            this.f5686a = x0Var2;
            x0Var2.f5660a = x0Var.f5660a;
            x0Var2.f5661b = x0Var.f5661b;
            x0Var2.f5662c = x0Var.f5662c;
            Intent[] intentArr = x0Var.f5663d;
            x0Var2.f5663d = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            x0Var2.f5664e = x0Var.f5664e;
            x0Var2.f5665f = x0Var.f5665f;
            x0Var2.f5666g = x0Var.f5666g;
            x0Var2.f5667h = x0Var.f5667h;
            x0Var2.A = x0Var.A;
            x0Var2.f5668i = x0Var.f5668i;
            x0Var2.f5669j = x0Var.f5669j;
            x0Var2.f5678s = x0Var.f5678s;
            x0Var2.f5677r = x0Var.f5677r;
            x0Var2.f5679t = x0Var.f5679t;
            x0Var2.f5680u = x0Var.f5680u;
            x0Var2.f5681v = x0Var.f5681v;
            x0Var2.f5682w = x0Var.f5682w;
            x0Var2.f5683x = x0Var.f5683x;
            x0Var2.f5684y = x0Var.f5684y;
            x0Var2.f5672m = x0Var.f5672m;
            x0Var2.f5673n = x0Var.f5673n;
            x0Var2.f5685z = x0Var.f5685z;
            x0Var2.f5674o = x0Var.f5674o;
            r5[] r5VarArr = x0Var.f5670k;
            if (r5VarArr != null) {
                x0Var2.f5670k = (r5[]) Arrays.copyOf(r5VarArr, r5VarArr.length);
            }
            if (x0Var.f5671l != null) {
                x0Var2.f5671l = new HashSet(x0Var.f5671l);
            }
            PersistableBundle persistableBundle = x0Var.f5675p;
            if (persistableBundle != null) {
                x0Var2.f5675p = persistableBundle;
            }
            x0Var2.B = x0Var.B;
        }

        @c.t0(25)
        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        public a(@c.m0 Context context, @c.m0 ShortcutInfo shortcutInfo) {
            x0 x0Var = new x0();
            this.f5686a = x0Var;
            x0Var.f5660a = context;
            x0Var.f5661b = shortcutInfo.getId();
            x0Var.f5662c = shortcutInfo.getPackage();
            Intent[] intents = shortcutInfo.getIntents();
            x0Var.f5663d = (Intent[]) Arrays.copyOf(intents, intents.length);
            x0Var.f5664e = shortcutInfo.getActivity();
            x0Var.f5665f = shortcutInfo.getShortLabel();
            x0Var.f5666g = shortcutInfo.getLongLabel();
            x0Var.f5667h = shortcutInfo.getDisabledMessage();
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 28) {
                x0Var.A = shortcutInfo.getDisabledReason();
            } else {
                x0Var.A = shortcutInfo.isEnabled() ? 0 : 3;
            }
            x0Var.f5671l = shortcutInfo.getCategories();
            x0Var.f5670k = x0.u(shortcutInfo.getExtras());
            x0Var.f5678s = shortcutInfo.getUserHandle();
            x0Var.f5677r = shortcutInfo.getLastChangedTimestamp();
            if (i7 >= 30) {
                x0Var.f5679t = shortcutInfo.isCached();
            }
            x0Var.f5680u = shortcutInfo.isDynamic();
            x0Var.f5681v = shortcutInfo.isPinned();
            x0Var.f5682w = shortcutInfo.isDeclaredInManifest();
            x0Var.f5683x = shortcutInfo.isImmutable();
            x0Var.f5684y = shortcutInfo.isEnabled();
            x0Var.f5685z = shortcutInfo.hasKeyFieldsOnly();
            x0Var.f5672m = x0.p(shortcutInfo);
            x0Var.f5674o = shortcutInfo.getRank();
            x0Var.f5675p = shortcutInfo.getExtras();
        }
    }
}
