package com.google.android.gms.common.api.internal;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class t0 extends z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<com.google.android.gms.common.api.a.f> f15409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ a1 f15410c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(a1 a1Var, ArrayList<com.google.android.gms.common.api.a.f> arrayList) {
        super(a1Var, null);
        this.f15410c = a1Var;
        this.f15409b = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.z0
    @c.h1
    public final void a() {
        a1 a1Var = this.f15410c;
        a1Var.f15144a.f15353p.f15303s = a1.y(a1Var);
        ArrayList<com.google.android.gms.common.api.a.f> arrayList = this.f15409b;
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            com.google.android.gms.common.api.a.f fVar = arrayList.get(i7);
            a1 a1Var2 = this.f15410c;
            fVar.h(a1Var2.f15158o, a1Var2.f15144a.f15353p.f15303s);
        }
    }
}
