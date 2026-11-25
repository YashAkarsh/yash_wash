package com.haier.library.common.util.permissions;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f26604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String[] f26605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f26606c;

    public void a(boolean z7) {
        this.f26604a = z7;
    }

    public void b(String[] strArr) {
        this.f26605b = strArr;
    }

    public boolean c() {
        return this.f26604a;
    }

    public void d(String[] strArr) {
        this.f26606c = strArr;
    }

    public String[] e() {
        return this.f26605b;
    }

    public String[] f() {
        return this.f26606c;
    }

    public String toString() {
        return "PermissionGrantResult{allGranted=" + this.f26604a + ", notGranted=" + Arrays.toString(this.f26605b) + ", failedGranted=" + Arrays.toString(this.f26606c) + '}';
    }
}
