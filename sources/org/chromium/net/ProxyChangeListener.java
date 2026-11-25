package org.chromium.net;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.UsedByReflection;

/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("WebView embedders call this to override proxy settings")
@x6.c("net")
public class ProxyChangeListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f39069g = "ProxyChangeListener";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f39070h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ boolean f39071i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Looper f39072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f39073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f39074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ProxyReceiver f39075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BroadcastReceiver f39076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f39077f;

    /* JADX INFO: Access modifiers changed from: private */
    @UsedByReflection("WebView embedders call this to override proxy settings")
    class ProxyReceiver extends BroadcastReceiver {
        private ProxyReceiver() {
        }

        private c b(Intent intent) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return null;
            }
            return c.b((ProxyInfo) extras.get("android.intent.extra.PROXY_INFO"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Intent intent) {
            ProxyChangeListener.this.h(b(intent));
        }

        @Override // android.content.BroadcastReceiver
        @UsedByReflection("WebView embedders call this to override proxy settings")
        public void onReceive(Context context, final Intent intent) {
            if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
                ProxyChangeListener.this.j(new Runnable() { // from class: org.chromium.net.g0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f39136a.c(intent);
                    }
                });
            }
        }
    }

    public interface b {
        void a();
    }

    private static class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f39079e = new c("", 0, "", new String[0]);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f39081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f39082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String[] f39083d;

        public c(String str, int i7, String str2, String[] strArr) {
            this.f39080a = str;
            this.f39081b = i7;
            this.f39082c = str2;
            this.f39083d = strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(21)
        public static c b(ProxyInfo proxyInfo) {
            if (proxyInfo == null) {
                return null;
            }
            Uri pacFileUrl = proxyInfo.getPacFileUrl();
            return new c(proxyInfo.getHost(), proxyInfo.getPort(), Uri.EMPTY.equals(pacFileUrl) ? null : pacFileUrl.toString(), proxyInfo.getExclusionList());
        }
    }

    private ProxyChangeListener() {
        Looper looperMyLooper = Looper.myLooper();
        this.f39072a = looperMyLooper;
        this.f39073b = new Handler(looperMyLooper);
    }

    @CalledByNative
    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    private void d() {
        if (org.chromium.base.l.f38814b && !g()) {
            throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
        }
    }

    @TargetApi(23)
    private c e() {
        ProxyInfo defaultProxy = ((ConnectivityManager) org.chromium.base.o.e().getSystemService("connectivity")).getDefaultProxy();
        return defaultProxy == null ? c.f39079e : c.b(defaultProxy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        h(e());
    }

    private boolean g() {
        return this.f39072a == Looper.myLooper();
    }

    @CalledByNative
    public static String getProperty(String str) {
        return System.getProperty(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(c cVar) {
        d();
        if (f39070h) {
            b bVar = this.f39077f;
            if (bVar != null) {
                bVar.a();
            }
            long j7 = this.f39074c;
            if (j7 == 0) {
                return;
            }
            if (cVar != null) {
                nativeProxySettingsChangedTo(j7, cVar.f39080a, cVar.f39081b, cVar.f39082c, cVar.f39083d);
            } else {
                nativeProxySettingsChanged(j7);
            }
        }
    }

    private void i() {
        d();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PROXY_CHANGE");
        this.f39075d = new ProxyReceiver();
        org.chromium.base.o.e().registerReceiver(this.f39075d, new IntentFilter());
        this.f39076e = new e0(this);
        org.chromium.base.o.e().registerReceiver(this.f39076e, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Runnable runnable) {
        if (g()) {
            runnable.run();
        } else {
            this.f39073b.post(runnable);
        }
    }

    public static void l(boolean z7) {
        f39070h = z7;
    }

    private void m() {
        d();
        org.chromium.base.o.e().unregisterReceiver(this.f39075d);
        if (this.f39076e != null) {
            org.chromium.base.o.e().unregisterReceiver(this.f39076e);
        }
        this.f39075d = null;
        this.f39076e = null;
    }

    @x6.f("ProxyConfigServiceAndroid::JNIDelegate")
    private native void nativeProxySettingsChanged(long j7);

    @x6.f("ProxyConfigServiceAndroid::JNIDelegate")
    private native void nativeProxySettingsChangedTo(long j7, String str, int i7, String str2, String[] strArr);

    public void k(b bVar) {
        this.f39077f = bVar;
    }

    void n() {
        j(new Runnable() { // from class: org.chromium.net.f0
            @Override // java.lang.Runnable
            public final void run() {
                this.f39135a.f();
            }
        });
    }

    @CalledByNative
    public void start(long j7) {
        d();
        this.f39074c = j7;
        i();
    }

    @CalledByNative
    public void stop() {
        d();
        this.f39074c = 0L;
        m();
    }
}
