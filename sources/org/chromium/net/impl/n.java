package org.chromium.net.impl;

import org.chromium.net.z;

/* JADX INFO: loaded from: classes3.dex */
public class n extends z {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final /* synthetic */ boolean f39393n = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final int f39394l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final int f39395m;

    public n(String str, int i7, int i8) {
        super(str, null);
        this.f39394l = i7;
        this.f39395m = i8;
    }

    @Override // org.chromium.net.z
    public int a() {
        return this.f39395m;
    }

    @Override // org.chromium.net.z
    public int b() {
        return this.f39394l;
    }

    @Override // org.chromium.net.z
    public boolean c() {
        int i7 = this.f39394l;
        return i7 == 3 || i7 == 4 || i7 == 5 || i7 == 6 || i7 == 8;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(super.getMessage());
        sb.append(", ErrorCode=");
        sb.append(this.f39394l);
        if (this.f39395m != 0) {
            sb.append(", InternalErrorCode=");
            sb.append(this.f39395m);
        }
        sb.append(", Retryable=");
        sb.append(c());
        return sb.toString();
    }
}
