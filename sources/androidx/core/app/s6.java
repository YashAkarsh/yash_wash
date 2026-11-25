package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class s6 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5488h = "android.remoteinput.results";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f5489i = "android.remoteinput.resultsData";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f5490j = "android.remoteinput.dataTypeResultsData";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f5491k = "android.remoteinput.resultsSource";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f5492l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f5493m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5494n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f5495o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5496p = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f5498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence[] f5499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f5500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f5501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Bundle f5502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<String> f5503g;

    @c.t0(16)
    static class a {
        private a() {
        }

        @c.t
        static ClipData a(Intent intent) {
            return intent.getClipData();
        }

        @c.t
        static void b(Intent intent, ClipData clipData) {
            intent.setClipData(clipData);
        }
    }

    @c.t0(20)
    static class b {
        private b() {
        }

        @c.t
        static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(s6 s6Var) {
            Set<String> setG;
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(s6Var.o()).setLabel(s6Var.n()).setChoices(s6Var.h()).setAllowFreeFormInput(s6Var.f()).addExtras(s6Var.m());
            if (Build.VERSION.SDK_INT >= 26 && (setG = s6Var.g()) != null) {
                Iterator<String> it = setG.iterator();
                while (it.hasNext()) {
                    c.d(builderAddExtras, it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                e.b(builderAddExtras, s6Var.k());
            }
            return builderAddExtras.build();
        }

        static s6 c(Object obj) {
            Set<String> setB;
            RemoteInput remoteInput = (RemoteInput) obj;
            f fVarA = new f(remoteInput.getResultKey()).h(remoteInput.getLabel()).f(remoteInput.getChoices()).e(remoteInput.getAllowFreeFormInput()).a(remoteInput.getExtras());
            if (Build.VERSION.SDK_INT >= 26 && (setB = c.b(remoteInput)) != null) {
                Iterator<String> it = setB.iterator();
                while (it.hasNext()) {
                    fVarA.d(it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                fVarA.g(e.a(remoteInput));
            }
            return fVarA.b();
        }

        @c.t
        static Bundle d(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    @c.t0(26)
    static class c {
        private c() {
        }

        @c.t
        static void a(s6 s6Var, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(s6.c(s6Var), intent, map);
        }

        @c.t
        static Set<String> b(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        @c.t
        static Map<String, Uri> c(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }

        @c.t
        static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z7) {
            return builder.setAllowDataType(str, z7);
        }
    }

    @c.t0(28)
    static class d {
        private d() {
        }

        @c.t
        static int a(Intent intent) {
            return RemoteInput.getResultsSource(intent);
        }

        @c.t
        static void b(Intent intent, int i7) {
            RemoteInput.setResultsSource(intent, i7);
        }
    }

    @c.t0(29)
    static class e {
        private e() {
        }

        @c.t
        static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        @c.t
        static RemoteInput.Builder b(RemoteInput.Builder builder, int i7) {
            return builder.setEditChoicesBeforeSending(i7);
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5504a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f5507d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence[] f5508e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f5505b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Bundle f5506c = new Bundle();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f5509f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f5510g = 0;

        public f(@c.m0 String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f5504a = str;
        }

        @c.m0
        public f a(@c.m0 Bundle bundle) {
            if (bundle != null) {
                this.f5506c.putAll(bundle);
            }
            return this;
        }

        @c.m0
        public s6 b() {
            return new s6(this.f5504a, this.f5507d, this.f5508e, this.f5509f, this.f5510g, this.f5506c, this.f5505b);
        }

        @c.m0
        public Bundle c() {
            return this.f5506c;
        }

        @c.m0
        public f d(@c.m0 String str, boolean z7) {
            if (z7) {
                this.f5505b.add(str);
            } else {
                this.f5505b.remove(str);
            }
            return this;
        }

        @c.m0
        public f e(boolean z7) {
            this.f5509f = z7;
            return this;
        }

        @c.m0
        public f f(@c.o0 CharSequence[] charSequenceArr) {
            this.f5508e = charSequenceArr;
            return this;
        }

        @c.m0
        public f g(int i7) {
            this.f5510g = i7;
            return this;
        }

        @c.m0
        public f h(@c.o0 CharSequence charSequence) {
            this.f5507d = charSequence;
            return this;
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface g {
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface h {
    }

    s6(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z7, int i7, Bundle bundle, Set<String> set) {
        this.f5497a = str;
        this.f5498b = charSequence;
        this.f5499c = charSequenceArr;
        this.f5500d = z7;
        this.f5501e = i7;
        this.f5502f = bundle;
        this.f5503g = set;
        if (k() == 2 && !f()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static void a(@c.m0 s6 s6Var, @c.m0 Intent intent, @c.m0 Map<String, Uri> map) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.a(s6Var, intent, map);
            return;
        }
        Intent intentI = i(intent);
        if (intentI == null) {
            intentI = new Intent();
        }
        for (Map.Entry<String, Uri> entry : map.entrySet()) {
            String key = entry.getKey();
            Uri value = entry.getValue();
            if (key != null) {
                Bundle bundleExtra = intentI.getBundleExtra(l(key));
                if (bundleExtra == null) {
                    bundleExtra = new Bundle();
                }
                bundleExtra.putString(s6Var.o(), value.toString());
                intentI.putExtra(l(key), bundleExtra);
            }
        }
        a.b(intent, ClipData.newIntent(f5488h, intentI));
    }

    public static void b(@c.m0 s6[] s6VarArr, @c.m0 Intent intent, @c.m0 Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.a(d(s6VarArr), intent, bundle);
            return;
        }
        Bundle bundleP = p(intent);
        int iQ = q(intent);
        if (bundleP != null) {
            bundleP.putAll(bundle);
            bundle = bundleP;
        }
        for (s6 s6Var : s6VarArr) {
            Map<String, Uri> mapJ = j(intent, s6Var.o());
            b.a(d(new s6[]{s6Var}), intent, bundle);
            if (mapJ != null) {
                a(s6Var, intent, mapJ);
            }
        }
        s(intent, iQ);
    }

    @c.t0(20)
    static RemoteInput c(s6 s6Var) {
        return b.b(s6Var);
    }

    @c.t0(20)
    static RemoteInput[] d(s6[] s6VarArr) {
        if (s6VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[s6VarArr.length];
        for (int i7 = 0; i7 < s6VarArr.length; i7++) {
            remoteInputArr[i7] = c(s6VarArr[i7]);
        }
        return remoteInputArr;
    }

    @c.t0(20)
    static s6 e(RemoteInput remoteInput) {
        return b.c(remoteInput);
    }

    @c.t0(16)
    private static Intent i(Intent intent) {
        ClipData clipDataA = a.a(intent);
        if (clipDataA == null) {
            return null;
        }
        ClipDescription description = clipDataA.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().toString().contentEquals(f5488h)) {
            return clipDataA.getItemAt(0).getIntent();
        }
        return null;
    }

    @c.o0
    public static Map<String, Uri> j(@c.m0 Intent intent, @c.m0 String str) {
        String string;
        if (Build.VERSION.SDK_INT >= 26) {
            return c.c(intent, str);
        }
        Intent intentI = i(intent);
        if (intentI == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (String str2 : intentI.getExtras().keySet()) {
            if (str2.startsWith(f5490j)) {
                String strSubstring = str2.substring(39);
                if (!strSubstring.isEmpty() && (string = intentI.getBundleExtra(str2).getString(str)) != null && !string.isEmpty()) {
                    map.put(strSubstring, Uri.parse(string));
                }
            }
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    private static String l(String str) {
        return f5490j + str;
    }

    @c.o0
    public static Bundle p(@c.m0 Intent intent) {
        return b.d(intent);
    }

    public static int q(@c.m0 Intent intent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return d.a(intent);
        }
        Intent intentI = i(intent);
        if (intentI == null) {
            return 0;
        }
        return intentI.getExtras().getInt(f5491k, 0);
    }

    public static void s(@c.m0 Intent intent, int i7) {
        if (Build.VERSION.SDK_INT >= 28) {
            d.b(intent, i7);
            return;
        }
        Intent intentI = i(intent);
        if (intentI == null) {
            intentI = new Intent();
        }
        intentI.putExtra(f5491k, i7);
        a.b(intent, ClipData.newIntent(f5488h, intentI));
    }

    public boolean f() {
        return this.f5500d;
    }

    @c.o0
    public Set<String> g() {
        return this.f5503g;
    }

    @c.o0
    public CharSequence[] h() {
        return this.f5499c;
    }

    public int k() {
        return this.f5501e;
    }

    @c.m0
    public Bundle m() {
        return this.f5502f;
    }

    @c.o0
    public CharSequence n() {
        return this.f5498b;
    }

    @c.m0
    public String o() {
        return this.f5497a;
    }

    public boolean r() {
        return (f() || (h() != null && h().length != 0) || g() == null || g().isEmpty()) ? false : true;
    }
}
