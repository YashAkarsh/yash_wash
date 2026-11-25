package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import c.o0;
import c.x0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.support.customtabs.b f2144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f2145b;

    static class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f2146a;

        a(Context context) {
            this.f2146a = context;
        }

        @Override // androidx.browser.customtabs.d
        public final void a(ComponentName componentName, b bVar) {
            bVar.g(0L);
            this.f2146a.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: renamed from: androidx.browser.customtabs.b$b, reason: collision with other inner class name */
    class BinderC0030b extends android.support.customtabs.a.AbstractBinderC0000a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Handler f2147i = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ androidx.browser.customtabs.a f2148j;

        /* JADX INFO: renamed from: androidx.browser.customtabs.b$b$a */
        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f2150a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f2151b;

            a(int i7, Bundle bundle) {
                this.f2150a = i7;
                this.f2151b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                BinderC0030b.this.f2148j.c(this.f2150a, this.f2151b);
            }
        }

        /* JADX INFO: renamed from: androidx.browser.customtabs.b$b$b, reason: collision with other inner class name */
        class RunnableC0031b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f2153a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f2154b;

            RunnableC0031b(String str, Bundle bundle) {
                this.f2153a = str;
                this.f2154b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                BinderC0030b.this.f2148j.a(this.f2153a, this.f2154b);
            }
        }

        /* JADX INFO: renamed from: androidx.browser.customtabs.b$b$c */
        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bundle f2156a;

            c(Bundle bundle) {
                this.f2156a = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                BinderC0030b.this.f2148j.b(this.f2156a);
            }
        }

        /* JADX INFO: renamed from: androidx.browser.customtabs.b$b$d */
        class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f2158a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f2159b;

            d(String str, Bundle bundle) {
                this.f2158a = str;
                this.f2159b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                BinderC0030b.this.f2148j.d(this.f2158a, this.f2159b);
            }
        }

        /* JADX INFO: renamed from: androidx.browser.customtabs.b$b$e */
        class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f2161a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Uri f2162b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f2163c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f2164d;

            e(int i7, Uri uri, boolean z7, Bundle bundle) {
                this.f2161a = i7;
                this.f2162b = uri;
                this.f2163c = z7;
                this.f2164d = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                BinderC0030b.this.f2148j.e(this.f2161a, this.f2162b, this.f2163c, this.f2164d);
            }
        }

        BinderC0030b(androidx.browser.customtabs.a aVar) {
            this.f2148j = aVar;
        }

        @Override // android.support.customtabs.a
        public void I4(String str, Bundle bundle) throws RemoteException {
            if (this.f2148j == null) {
                return;
            }
            this.f2147i.post(new RunnableC0031b(str, bundle));
        }

        @Override // android.support.customtabs.a
        public void K5(String str, Bundle bundle) throws RemoteException {
            if (this.f2148j == null) {
                return;
            }
            this.f2147i.post(new d(str, bundle));
        }

        @Override // android.support.customtabs.a
        public void S5(Bundle bundle) throws RemoteException {
            if (this.f2148j == null) {
                return;
            }
            this.f2147i.post(new c(bundle));
        }

        @Override // android.support.customtabs.a
        public void X5(int i7, Uri uri, boolean z7, @o0 Bundle bundle) throws RemoteException {
            if (this.f2148j == null) {
                return;
            }
            this.f2147i.post(new e(i7, uri, z7, bundle));
        }

        @Override // android.support.customtabs.a
        public void i5(int i7, Bundle bundle) {
            if (this.f2148j == null) {
                return;
            }
            this.f2147i.post(new a(i7, bundle));
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    b(android.support.customtabs.b bVar, ComponentName componentName) {
        this.f2144a = bVar;
        this.f2145b = componentName;
    }

    public static boolean a(Context context, String str, d dVar) {
        Intent intent = new Intent(CustomTabsService.f2123c);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, dVar, 33);
    }

    public static boolean b(Context context, String str) {
        if (str == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            return a(applicationContext, str, new a(applicationContext));
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static String d(Context context, @o0 List<String> list) {
        return e(context, list, false);
    }

    public static String e(Context context, @o0 List<String> list, boolean z7) {
        ResolveInfo resolveInfoResolveActivity;
        PackageManager packageManager = context.getPackageManager();
        List<String> arrayList = list == null ? new ArrayList<>() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z7 && (resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveInfoResolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent(CustomTabsService.f2123c);
        for (String str2 : arrayList) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        return null;
    }

    public Bundle c(String str, Bundle bundle) {
        try {
            return this.f2144a.B2(str, bundle);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public e f(androidx.browser.customtabs.a aVar) {
        BinderC0030b binderC0030b = new BinderC0030b(aVar);
        try {
            if (this.f2144a.y4(binderC0030b)) {
                return new e(this.f2144a, binderC0030b, this.f2145b);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public boolean g(long j7) {
        try {
            return this.f2144a.o3(j7);
        } catch (RemoteException unused) {
            return false;
        }
    }
}
