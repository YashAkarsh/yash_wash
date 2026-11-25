package com.airbnb.lottie.utils;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.airbnb.lottie.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f12325a = new HashSet();

    @Override // com.airbnb.lottie.k
    public void a(String str, Throwable th) {
        if (com.airbnb.lottie.e.f11761a) {
            Log.d(com.airbnb.lottie.e.f11762b, str, th);
        }
    }

    @Override // com.airbnb.lottie.k
    public void b(String str) {
        e(str, null);
    }

    @Override // com.airbnb.lottie.k
    public void c(String str, Throwable th) {
        Set<String> set = f12325a;
        if (set.contains(str)) {
            return;
        }
        Log.w(com.airbnb.lottie.e.f11762b, str, th);
        set.add(str);
    }

    @Override // com.airbnb.lottie.k
    public void d(String str) {
        c(str, null);
    }

    @Override // com.airbnb.lottie.k
    public void e(String str, Throwable th) {
        if (com.airbnb.lottie.e.f11761a) {
            Log.d(com.airbnb.lottie.e.f11762b, str, th);
        }
    }
}
