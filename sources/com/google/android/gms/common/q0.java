package com.google.android.gms.common;

import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class q0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final q0 f15890d = new q0(true, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f15891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    final String f15892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    final Throwable f15893c;

    q0(boolean z7, @Nullable String str, @Nullable Throwable th) {
        this.f15891a = z7;
        this.f15892b = str;
        this.f15893c = th;
    }

    static q0 b() {
        return f15890d;
    }

    static q0 c(@c.m0 String str) {
        return new q0(false, str, null);
    }

    static q0 d(@c.m0 String str, @c.m0 Throwable th) {
        return new q0(false, str, th);
    }

    @Nullable
    String a() {
        return this.f15892b;
    }

    final void e() {
        if (this.f15891a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f15893c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f15893c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
