package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class q1 implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f15387a;

    q1(i iVar) {
        this.f15387a = iVar;
    }

    @Override // com.google.android.gms.common.api.internal.d.a
    public final void a(boolean z7) {
        i iVar = this.f15387a;
        iVar.f15264p.sendMessage(iVar.f15264p.obtainMessage(1, Boolean.valueOf(z7)));
    }
}
