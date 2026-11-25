package com.haier.library.okhttp.b.d;

import com.haier.library.okhttp.n;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IOException f27029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IOException f27030b;

    public e(IOException iOException) {
        super(iOException);
        this.f27029a = iOException;
        this.f27030b = iOException;
    }

    public IOException a() {
        return this.f27029a;
    }

    public void b(IOException iOException) {
        n.d.t(this.f27029a, iOException);
        this.f27030b = iOException;
    }

    public IOException c() {
        return this.f27030b;
    }
}
