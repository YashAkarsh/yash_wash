package androidx.navigation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.e7;
import c.b0;
import c.l0;
import c.m0;
import c.o0;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f8866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private n f8867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Bundle f8869e;

    private static class a extends x {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final w<l> f8870c = new C0115a();

        /* JADX INFO: renamed from: androidx.navigation.j$a$a, reason: collision with other inner class name */
        class C0115a extends w<l> {
            C0115a() {
            }

            @Override // androidx.navigation.w
            @m0
            public l a() {
                return new l("permissive");
            }

            @Override // androidx.navigation.w
            @o0
            public l b(@m0 l lVar, @o0 Bundle bundle, @o0 t tVar, @o0 w.a aVar) {
                throw new IllegalStateException("navigate is not supported");
            }

            @Override // androidx.navigation.w
            public boolean e() {
                throw new IllegalStateException("popBackStack is not supported");
            }
        }

        a() {
            a(new o(this));
        }

        @Override // androidx.navigation.x
        @m0
        public w<? extends l> e(@m0 String str) {
            try {
                return super.e(str);
            } catch (IllegalStateException unused) {
                return this.f8870c;
            }
        }
    }

    public j(@m0 Context context) {
        this.f8865a = context;
        if (context instanceof Activity) {
            this.f8866b = new Intent(context, context.getClass());
        } else {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            this.f8866b = launchIntentForPackage == null ? new Intent() : launchIntentForPackage;
        }
        this.f8866b.addFlags(268468224);
    }

    private void c() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(this.f8867c);
        l lVar = null;
        while (!arrayDeque.isEmpty() && lVar == null) {
            l lVar2 = (l) arrayDeque.poll();
            if (lVar2.m() == this.f8868d) {
                lVar = lVar2;
            } else if (lVar2 instanceof n) {
                Iterator<l> it = ((n) lVar2).iterator();
                while (it.hasNext()) {
                    arrayDeque.add(it.next());
                }
            }
        }
        if (lVar != null) {
            this.f8866b.putExtra("android-support-nav:controller:deepLinkIds", lVar.g());
            return;
        }
        throw new IllegalArgumentException("Navigation destination " + l.l(this.f8865a, this.f8868d) + " cannot be found in the navigation graph " + this.f8867c);
    }

    @m0
    public PendingIntent a() {
        Bundle bundle = this.f8869e;
        int i7 = 0;
        if (bundle != null) {
            Iterator<String> it = bundle.keySet().iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                Object obj = this.f8869e.get(it.next());
                iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
            }
            i7 = iHashCode;
        }
        return b().o((i7 * 31) + this.f8868d, 134217728);
    }

    @m0
    public e7 b() {
        if (this.f8866b.getIntArrayExtra("android-support-nav:controller:deepLinkIds") == null) {
            if (this.f8867c == null) {
                throw new IllegalStateException("You must call setGraph() before constructing the deep link");
            }
            throw new IllegalStateException("You must call setDestination() before constructing the deep link");
        }
        e7 e7VarB = e7.h(this.f8865a).b(new Intent(this.f8866b));
        for (int i7 = 0; i7 < e7VarB.m(); i7++) {
            e7VarB.j(i7).putExtra(NavController.f8764w, this.f8866b);
        }
        return e7VarB;
    }

    @m0
    public j d(@o0 Bundle bundle) {
        this.f8869e = bundle;
        this.f8866b.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
        return this;
    }

    @m0
    public j e(@m0 ComponentName componentName) {
        this.f8866b.setComponent(componentName);
        return this;
    }

    @m0
    public j f(@m0 Class<? extends Activity> cls) {
        return e(new ComponentName(this.f8865a, cls));
    }

    @m0
    public j g(@b0 int i7) {
        this.f8868d = i7;
        if (this.f8867c != null) {
            c();
        }
        return this;
    }

    @m0
    public j h(@l0 int i7) {
        return i(new s(this.f8865a, new a()).c(i7));
    }

    @m0
    public j i(@m0 n nVar) {
        this.f8867c = nVar;
        if (this.f8868d != 0) {
            c();
        }
        return this;
    }

    j(@m0 NavController navController) {
        this(navController.i());
        this.f8867c = navController.m();
    }
}
