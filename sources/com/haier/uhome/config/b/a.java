package com.haier.uhome.config.b;

import com.haier.uhome.usdk.base.api.ErrorConst;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28452a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f28453b = ErrorConst.ERR_USDK_START_FAILED.getErrorId();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f28454c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28456e;

    public a(int i7, String str) {
        this.f28455d = i7;
        this.f28456e = str;
    }

    public void a() {
        e3.a.h(this.f28456e, new Object[0]);
    }

    public int b() {
        return this.f28455d;
    }
}
