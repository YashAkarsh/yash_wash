package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f16983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16985c;

    public ViewOffsetBehavior() {
        this.f16984b = 0;
        this.f16985c = 0;
    }

    public int G() {
        e eVar = this.f16983a;
        if (eVar != null) {
            return eVar.d();
        }
        return 0;
    }

    public int H() {
        e eVar = this.f16983a;
        if (eVar != null) {
            return eVar.e();
        }
        return 0;
    }

    public boolean I() {
        e eVar = this.f16983a;
        return eVar != null && eVar.f();
    }

    public boolean J() {
        e eVar = this.f16983a;
        return eVar != null && eVar.g();
    }

    protected void K(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, int i7) {
        coordinatorLayout.N(v7, i7);
    }

    public void L(boolean z7) {
        e eVar = this.f16983a;
        if (eVar != null) {
            eVar.i(z7);
        }
    }

    public boolean M(int i7) {
        e eVar = this.f16983a;
        if (eVar != null) {
            return eVar.j(i7);
        }
        this.f16985c = i7;
        return false;
    }

    public boolean N(int i7) {
        e eVar = this.f16983a;
        if (eVar != null) {
            return eVar.k(i7);
        }
        this.f16984b = i7;
        return false;
    }

    public void O(boolean z7) {
        e eVar = this.f16983a;
        if (eVar != null) {
            eVar.l(z7);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 V v7, int i7) {
        K(coordinatorLayout, v7, i7);
        if (this.f16983a == null) {
            this.f16983a = new e(v7);
        }
        this.f16983a.h();
        this.f16983a.a();
        int i8 = this.f16984b;
        if (i8 != 0) {
            this.f16983a.k(i8);
            this.f16984b = 0;
        }
        int i9 = this.f16985c;
        if (i9 == 0) {
            return true;
        }
        this.f16983a.j(i9);
        this.f16985c = 0;
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16984b = 0;
        this.f16985c = 0;
    }
}
