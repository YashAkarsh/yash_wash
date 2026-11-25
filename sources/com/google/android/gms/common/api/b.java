package com.google.android.gms.common.api;

import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    @Deprecated
    protected final Status f15083a;

    public b(@m0 Status status) {
        int iP0 = status.p0();
        String strR0 = status.r0() != null ? status.r0() : "";
        StringBuilder sb = new StringBuilder(String.valueOf(strR0).length() + 13);
        sb.append(iP0);
        sb.append(": ");
        sb.append(strR0);
        super(sb.toString());
        this.f15083a = status;
    }

    @m0
    public Status a() {
        return this.f15083a;
    }

    public int b() {
        return this.f15083a.p0();
    }

    @o0
    @Deprecated
    public String c() {
        return this.f15083a.r0();
    }
}
