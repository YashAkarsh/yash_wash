package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.core.util.w;
import c.g1;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    @x0({x0.a.LIBRARY})
    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        private static final String f7454b = "emoji2.text.DefaultEmojiConfig";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m0
        private static final String f7455c = "androidx.content.action.LOAD_EMOJI_FONT";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @m0
        private static final String f7456d = "emojicompat-emoji-font";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f7457a;

        @x0({x0.a.LIBRARY})
        public a(@o0 b bVar) {
            this.f7457a = bVar == null ? e() : bVar;
        }

        @o0
        private f.d a(@m0 Context context, @o0 androidx.core.provider.h hVar) {
            if (hVar == null) {
                return null;
            }
            return new l(context, hVar);
        }

        @m0
        private List<List<byte[]>> b(@m0 Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        @m0
        private androidx.core.provider.h d(@m0 ProviderInfo providerInfo, @m0 PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new androidx.core.provider.h(str, str2, f7456d, b(this.f7457a.b(packageManager, str2)));
        }

        @m0
        private static b e() {
            return Build.VERSION.SDK_INT >= 28 ? new C0092d() : new c();
        }

        private boolean f(@o0 ProviderInfo providerInfo) {
            ApplicationInfo applicationInfo;
            return (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) ? false : true;
        }

        @o0
        private ProviderInfo g(@m0 PackageManager packageManager) {
            Iterator<ResolveInfo> it = this.f7457a.c(packageManager, new Intent(f7455c), 0).iterator();
            while (it.hasNext()) {
                ProviderInfo providerInfoA = this.f7457a.a(it.next());
                if (f(providerInfoA)) {
                    return providerInfoA;
                }
            }
            return null;
        }

        @o0
        @x0({x0.a.LIBRARY})
        public f.d c(@m0 Context context) {
            return a(context, h(context));
        }

        @o0
        @x0({x0.a.LIBRARY})
        @g1
        androidx.core.provider.h h(@m0 Context context) {
            PackageManager packageManager = context.getPackageManager();
            w.m(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo providerInfoG = g(packageManager);
            if (providerInfoG == null) {
                return null;
            }
            try {
                return d(providerInfoG, packageManager);
            } catch (PackageManager.NameNotFoundException e8) {
                Log.wtf(f7454b, e8);
                return null;
            }
        }
    }

    @x0({x0.a.LIBRARY})
    public static class b {
        @o0
        public ProviderInfo a(@m0 ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        @m0
        public Signature[] b(@m0 PackageManager packageManager, @m0 String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        @m0
        public List<ResolveInfo> c(@m0 PackageManager packageManager, @m0 Intent intent, int i7) {
            return Collections.emptyList();
        }
    }

    @t0(19)
    @x0({x0.a.LIBRARY})
    public static class c extends b {
        @Override // androidx.emoji2.text.d.b
        @o0
        public ProviderInfo a(@m0 ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.emoji2.text.d.b
        @m0
        public List<ResolveInfo> c(@m0 PackageManager packageManager, @m0 Intent intent, int i7) {
            return packageManager.queryIntentContentProviders(intent, i7);
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.d$d, reason: collision with other inner class name */
    @t0(28)
    @x0({x0.a.LIBRARY})
    public static class C0092d extends c {
        @Override // androidx.emoji2.text.d.b
        @m0
        public Signature[] b(@m0 PackageManager packageManager, @m0 String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    private d() {
    }

    @o0
    public static l a(@m0 Context context) {
        return (l) new a(null).c(context);
    }
}
