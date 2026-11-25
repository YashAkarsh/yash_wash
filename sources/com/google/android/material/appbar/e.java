package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f16986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16991f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16992g = true;

    public e(View view) {
        this.f16986a = view;
    }

    void a() {
        View view = this.f16986a;
        n2.f1(view, this.f16989d - (view.getTop() - this.f16987b));
        View view2 = this.f16986a;
        n2.e1(view2, this.f16990e - (view2.getLeft() - this.f16988c));
    }

    public int b() {
        return this.f16988c;
    }

    public int c() {
        return this.f16987b;
    }

    public int d() {
        return this.f16990e;
    }

    public int e() {
        return this.f16989d;
    }

    public boolean f() {
        return this.f16992g;
    }

    public boolean g() {
        return this.f16991f;
    }

    void h() {
        this.f16987b = this.f16986a.getTop();
        this.f16988c = this.f16986a.getLeft();
    }

    public void i(boolean z7) {
        this.f16992g = z7;
    }

    public boolean j(int i7) {
        if (!this.f16992g || this.f16990e == i7) {
            return false;
        }
        this.f16990e = i7;
        a();
        return true;
    }

    public boolean k(int i7) {
        if (!this.f16991f || this.f16989d == i7) {
            return false;
        }
        this.f16989d = i7;
        a();
        return true;
    }

    public void l(boolean z7) {
        this.f16991f = z7;
    }
}
