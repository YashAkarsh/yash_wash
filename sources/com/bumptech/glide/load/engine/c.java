package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
public enum c {
    ALL(true, true),
    NONE(false, false),
    SOURCE(true, false),
    RESULT(false, true);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f14303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f14304b;

    c(boolean z7, boolean z8) {
        this.f14303a = z7;
        this.f14304b = z8;
    }

    public boolean a() {
        return this.f14304b;
    }

    public boolean b() {
        return this.f14303a;
    }
}
