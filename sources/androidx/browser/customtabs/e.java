package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.RemoteViews;
import c.g1;
import c.m0;
import c.o0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f2198e = "CustomTabsSession";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f2199a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.support.customtabs.b f2200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final android.support.customtabs.a f2201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ComponentName f2202d;

    e(android.support.customtabs.b bVar, android.support.customtabs.a aVar, ComponentName componentName) {
        this.f2200b = bVar;
        this.f2201c = aVar;
        this.f2202d = componentName;
    }

    @m0
    @g1
    public static e a(@m0 ComponentName componentName) {
        return new e(null, new f.b(), componentName);
    }

    IBinder b() {
        return this.f2201c.asBinder();
    }

    ComponentName c() {
        return this.f2202d;
    }

    public boolean d(Uri uri, Bundle bundle, List<Bundle> list) {
        try {
            return this.f2200b.c1(this.f2201c, uri, bundle, list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public int e(String str, Bundle bundle) {
        int iL4;
        synchronized (this.f2199a) {
            try {
                try {
                    iL4 = this.f2200b.l4(this.f2201c, str, bundle);
                } catch (RemoteException unused) {
                    return -2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iL4;
    }

    public boolean f(Uri uri) {
        try {
            return this.f2200b.n5(this.f2201c, uri);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean g(@m0 Bitmap bitmap, @m0 String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(c.f2177n, bitmap);
        bundle.putString(c.f2178o, str);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(c.f2174k, bundle);
        try {
            return this.f2200b.Z4(this.f2201c, bundle2);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean h(@o0 RemoteViews remoteViews, @o0 int[] iArr, @o0 PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(c.f2185v, remoteViews);
        bundle.putIntArray(c.f2186w, iArr);
        bundle.putParcelable(c.f2187x, pendingIntent);
        try {
            return this.f2200b.Z4(this.f2201c, bundle);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Deprecated
    public boolean i(int i7, @m0 Bitmap bitmap, @m0 String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(c.A, i7);
        bundle.putParcelable(c.f2177n, bitmap);
        bundle.putString(c.f2178o, str);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(c.f2174k, bundle);
        try {
            return this.f2200b.Z4(this.f2201c, bundle2);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean j(int i7, @m0 Uri uri, @o0 Bundle bundle) {
        if (i7 >= 1 && i7 <= 2) {
            try {
                return this.f2200b.l1(this.f2201c, i7, uri, bundle);
            } catch (RemoteException unused) {
            }
        }
        return false;
    }
}
