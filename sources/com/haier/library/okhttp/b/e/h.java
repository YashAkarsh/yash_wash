package com.haier.library.okhttp.b.e;

import com.haier.library.okhttp.j0;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends com.haier.library.okhttp.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f27079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f27080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.haier.library.a.i f27081d;

    public h(@Nullable String str, long j7, com.haier.library.a.i iVar) {
        this.f27079b = str;
        this.f27080c = j7;
        this.f27081d = iVar;
    }

    @Override // com.haier.library.okhttp.b
    public j0 C() {
        String str = this.f27079b;
        if (str != null) {
            return j0.d(str);
        }
        return null;
    }

    @Override // com.haier.library.okhttp.b
    public com.haier.library.a.i K() {
        return this.f27081d;
    }

    @Override // com.haier.library.okhttp.b
    public long u() {
        return this.f27080c;
    }
}
