package com.haier.uhome.usdk.base.json;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasicReq f31340a;

    public /* synthetic */ a(BasicReq basicReq) {
        this.f31340a = basicReq;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f31340a.timeout();
    }
}
