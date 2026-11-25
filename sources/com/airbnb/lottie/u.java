package com.airbnb.lottie;

import c.g1;
import c.o0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f12319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final LottieAnimationView f12320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private final h f12321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12322d;

    @g1
    u() {
        this.f12319a = new HashMap();
        this.f12322d = true;
        this.f12320b = null;
        this.f12321c = null;
    }

    private String a(String str) {
        return str;
    }

    private void c() {
        LottieAnimationView lottieAnimationView = this.f12320b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        h hVar = this.f12321c;
        if (hVar != null) {
            hVar.invalidateSelf();
        }
    }

    public final String b(String str) {
        if (this.f12322d && this.f12319a.containsKey(str)) {
            return this.f12319a.get(str);
        }
        String strA = a(str);
        if (this.f12322d) {
            this.f12319a.put(str, strA);
        }
        return strA;
    }

    public void d() {
        this.f12319a.clear();
        c();
    }

    public void e(String str) {
        this.f12319a.remove(str);
        c();
    }

    public void f(boolean z7) {
        this.f12322d = z7;
    }

    public void g(String str, String str2) {
        this.f12319a.put(str, str2);
        c();
    }

    public u(LottieAnimationView lottieAnimationView) {
        this.f12319a = new HashMap();
        this.f12322d = true;
        this.f12320b = lottieAnimationView;
        this.f12321c = null;
    }

    public u(h hVar) {
        this.f12319a = new HashMap();
        this.f12322d = true;
        this.f12321c = hVar;
        this.f12320b = null;
    }
}
