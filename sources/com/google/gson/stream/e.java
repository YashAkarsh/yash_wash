package com.google.gson.stream;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f23306a = 1;

    public e(String str) {
        super(str);
    }

    public e(String str, Throwable th) {
        super(str);
        initCause(th);
    }

    public e(Throwable th) {
        initCause(th);
    }
}
