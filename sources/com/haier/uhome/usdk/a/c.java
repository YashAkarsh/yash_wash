package com.haier.uhome.usdk.a;

/* JADX INFO: loaded from: classes2.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f30297a;

    public c(long j7) {
        this.f30297a = j7 + System.currentTimeMillis();
    }

    @Override // com.haier.uhome.usdk.a.b
    public boolean isTimeout() {
        return this.f30297a < System.currentTimeMillis();
    }
}
