package com.haier.globalwasher.mvp_api.volley;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class a extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Intent f24805c;

    public a() {
    }

    public Intent c() {
        return this.f24805c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f24805c != null ? "User needs to (re)enter credentials." : super.getMessage();
    }

    public a(Intent intent) {
        this.f24805c = intent;
    }

    public a(j jVar) {
        super(jVar);
    }

    public a(String str) {
        super(str);
    }

    public a(String str, Exception exc) {
        super(str, exc);
    }
}
