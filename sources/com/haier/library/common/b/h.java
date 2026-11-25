package com.haier.library.common.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.haier.library.common.util.w;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f26393a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static h f26394a = new h();

        private a() {
        }
    }

    public h() {
        e3.a.e("NetworkMonitor net sdk version <%d>", Integer.valueOf(Build.VERSION.SDK_INT));
        if (this.f26393a == null) {
            this.f26393a = new d();
        }
    }

    public static h a() {
        return a.f26394a;
    }

    public void b(Context context, e eVar) {
        com.haier.library.common.b.a aVarA;
        e3.a.e("NetworkMonitor net addNetworkObserve", new Object[0]);
        if (eVar != null) {
            e eVar2 = this.f26393a;
            if (eVar2 instanceof i) {
                ((i) eVar2).b(context, eVar);
                aVarA = ((i) this.f26393a).a();
            } else if (eVar2 instanceof c) {
                ((c) eVar2).b(context, eVar);
                aVarA = ((c) this.f26393a).a();
            } else if (eVar2 instanceof d) {
                ((d) eVar2).b(context, eVar);
                aVarA = ((d) this.f26393a).a();
            } else {
                aVarA = null;
            }
            if (aVarA == null || w.f26618d.equals(aVarA.l())) {
                aVarA = com.haier.library.common.b.a.c(context, w.l(context));
            }
            eVar.a(aVarA);
        }
    }

    public boolean c(Context context) {
        if (context == null) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        e3.a.o("Network error", new Object[0]);
        return false;
    }

    public void d(Context context, e eVar) {
        e3.a.e("NetworkMonitor net rmNetworkObserve", new Object[0]);
        if (eVar != null) {
            e eVar2 = this.f26393a;
            if (eVar2 instanceof i) {
                ((i) eVar2).c(context, eVar);
            } else if (eVar2 instanceof c) {
                ((c) eVar2).c(context, eVar);
            } else if (eVar2 instanceof d) {
                ((d) eVar2).c(context, eVar);
            }
        }
    }
}
