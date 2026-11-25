package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
final class m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FrameLayout f16031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LayoutInflater f16032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ViewGroup f16033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Bundle f16034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ a f16035e;

    m(a aVar, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16035e = aVar;
        this.f16031a = frameLayout;
        this.f16032b = layoutInflater;
        this.f16033c = viewGroup;
        this.f16034d = bundle;
    }

    @Override // com.google.android.gms.dynamic.q
    public final void a(e eVar) {
        this.f16031a.removeAllViews();
        this.f16031a.addView(this.f16035e.f16015a.K(this.f16032b, this.f16033c, this.f16034d));
    }

    @Override // com.google.android.gms.dynamic.q
    public final int b() {
        return 2;
    }
}
