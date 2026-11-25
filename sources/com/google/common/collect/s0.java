package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public enum s0 {
    OPEN(false),
    CLOSED(true);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f21036a;

    s0(boolean z7) {
        this.f21036a = z7;
    }

    static s0 b(boolean z7) {
        return z7 ? CLOSED : OPEN;
    }

    s0 a() {
        return b(!this.f21036a);
    }
}
