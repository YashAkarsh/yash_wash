package androidx.browser.customtabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.r;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f2203c = "CustomTabsSessionToken";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final android.support.customtabs.a f2204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.browser.customtabs.a f2205b = new a();

    class a extends androidx.browser.customtabs.a {
        a() {
        }

        @Override // androidx.browser.customtabs.a
        public void a(String str, Bundle bundle) {
            try {
                f.this.f2204a.I4(str, bundle);
            } catch (RemoteException unused) {
                Log.e(f.f2203c, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void b(Bundle bundle) {
            try {
                f.this.f2204a.S5(bundle);
            } catch (RemoteException unused) {
                Log.e(f.f2203c, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void c(int i7, Bundle bundle) {
            try {
                f.this.f2204a.i5(i7, bundle);
            } catch (RemoteException unused) {
                Log.e(f.f2203c, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void d(String str, Bundle bundle) {
            try {
                f.this.f2204a.K5(str, bundle);
            } catch (RemoteException unused) {
                Log.e(f.f2203c, "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.a
        public void e(int i7, Uri uri, boolean z7, Bundle bundle) {
            try {
                f.this.f2204a.X5(i7, uri, z7, bundle);
            } catch (RemoteException unused) {
                Log.e(f.f2203c, "RemoteException during ICustomTabsCallback transaction");
            }
        }
    }

    static class b extends android.support.customtabs.a.AbstractBinderC0000a {
        b() {
        }

        @Override // android.support.customtabs.a
        public void I4(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.a
        public void K5(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.a
        public void S5(Bundle bundle) {
        }

        @Override // android.support.customtabs.a
        public void X5(int i7, Uri uri, boolean z7, Bundle bundle) {
        }

        @Override // android.support.customtabs.a.AbstractBinderC0000a, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.support.customtabs.a
        public void i5(int i7, Bundle bundle) {
        }
    }

    f(android.support.customtabs.a aVar) {
        this.f2204a = aVar;
    }

    @m0
    public static f a() {
        return new f(new b());
    }

    public static f d(Intent intent) {
        IBinder iBinderA = r.a(intent.getExtras(), c.f2167d);
        if (iBinderA == null) {
            return null;
        }
        return new f(android.support.customtabs.a.AbstractBinderC0000a.i0(iBinderA));
    }

    public androidx.browser.customtabs.a b() {
        return this.f2205b;
    }

    IBinder c() {
        return this.f2204a.asBinder();
    }

    public boolean e(e eVar) {
        return eVar.b().equals(this.f2204a);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return ((f) obj).c().equals(this.f2204a.asBinder());
        }
        return false;
    }

    public int hashCode() {
        return c().hashCode();
    }
}
