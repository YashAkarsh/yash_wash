package com.google.android.gms.common.api;

import c.h1;
import c.m0;
import c.o0;
import com.google.android.gms.common.api.internal.u2;
import com.google.android.gms.common.api.t;

/* JADX INFO: loaded from: classes.dex */
public abstract class w<R extends t, S extends t> {
    @m0
    public final n<S> a(@m0 Status status) {
        return new u2(status);
    }

    @m0
    public Status b(@m0 Status status) {
        return status;
    }

    @h1
    @o0
    public abstract n<S> c(@m0 R r7);
}
