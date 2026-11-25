package com.realsil.sdk.core.bluetooth.scanner;

import android.content.Context;
import android.os.Build;
import h4.c;
import h4.g;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f33222a;

    public b(Context context) {
        this.f33222a = a(context, Build.VERSION.SDK_INT);
    }

    public a a(Context context, int i7) {
        if (i7 >= 21) {
            return new g(context);
        }
        if (i7 >= 18) {
            return new c(context);
        }
        return null;
    }

    public boolean b() {
        return this.f33222a.b();
    }

    public boolean c(ScannerParams scannerParams, boolean z7) {
        return this.f33222a.f(scannerParams, z7);
    }

    public boolean d(boolean z7) {
        return c(null, z7);
    }

    public synchronized void e(a.InterfaceC0402a interfaceC0402a) {
        a aVar = this.f33222a;
        if (aVar != null) {
            aVar.h(interfaceC0402a);
        }
    }

    public b(Context context, int i7) {
        this.f33222a = a(context, i7);
    }
}
