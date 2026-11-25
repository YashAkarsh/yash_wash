package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomTabsService extends Service {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f2123c = "android.support.customtabs.action.CustomTabsService";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f2124d = "android.support.customtabs.otherurls.URL";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f2125e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f2126f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f2127g = -2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f2128h = -3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f2129i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f2130j = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<IBinder, IBinder.DeathRecipient> f2131a = new androidx.collection.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.support.customtabs.b.a f2132b = new a();

    class a extends android.support.customtabs.b.a {

        /* JADX INFO: renamed from: androidx.browser.customtabs.CustomTabsService$a$a, reason: collision with other inner class name */
        class C0029a implements IBinder.DeathRecipient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ f f2134a;

            C0029a(f fVar) {
                this.f2134a = fVar;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                CustomTabsService.this.a(this.f2134a);
            }
        }

        a() {
        }

        @Override // android.support.customtabs.b
        public Bundle B2(String str, Bundle bundle) {
            return CustomTabsService.this.b(str, bundle);
        }

        @Override // android.support.customtabs.b
        public boolean Z4(android.support.customtabs.a aVar, Bundle bundle) {
            return CustomTabsService.this.g(new f(aVar), bundle);
        }

        @Override // android.support.customtabs.b
        public boolean c1(android.support.customtabs.a aVar, Uri uri, Bundle bundle, List<Bundle> list) {
            return CustomTabsService.this.c(new f(aVar), uri, bundle, list);
        }

        @Override // android.support.customtabs.b
        public boolean l1(android.support.customtabs.a aVar, int i7, Uri uri, Bundle bundle) {
            return CustomTabsService.this.h(new f(aVar), i7, uri, bundle);
        }

        @Override // android.support.customtabs.b
        public int l4(android.support.customtabs.a aVar, String str, Bundle bundle) {
            return CustomTabsService.this.e(new f(aVar), str, bundle);
        }

        @Override // android.support.customtabs.b
        public boolean n5(android.support.customtabs.a aVar, Uri uri) {
            return CustomTabsService.this.f(new f(aVar), uri);
        }

        @Override // android.support.customtabs.b
        public boolean o3(long j7) {
            return CustomTabsService.this.i(j7);
        }

        @Override // android.support.customtabs.b
        public boolean y4(android.support.customtabs.a aVar) {
            f fVar = new f(aVar);
            try {
                C0029a c0029a = new C0029a(fVar);
                synchronized (CustomTabsService.this.f2131a) {
                    aVar.asBinder().linkToDeath(c0029a, 0);
                    CustomTabsService.this.f2131a.put(aVar.asBinder(), c0029a);
                }
                return CustomTabsService.this.d(fVar);
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    protected boolean a(f fVar) {
        try {
            synchronized (this.f2131a) {
                IBinder iBinderC = fVar.c();
                iBinderC.unlinkToDeath(this.f2131a.get(iBinderC), 0);
                this.f2131a.remove(iBinderC);
            }
            return true;
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    protected abstract Bundle b(String str, Bundle bundle);

    protected abstract boolean c(f fVar, Uri uri, Bundle bundle, List<Bundle> list);

    protected abstract boolean d(f fVar);

    protected abstract int e(f fVar, String str, Bundle bundle);

    protected abstract boolean f(f fVar, Uri uri);

    protected abstract boolean g(f fVar, Bundle bundle);

    protected abstract boolean h(f fVar, int i7, Uri uri, Bundle bundle);

    protected abstract boolean i(long j7);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2132b;
    }
}
