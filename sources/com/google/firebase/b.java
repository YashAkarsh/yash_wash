package com.google.firebase;

import c.m0;
import com.google.android.gms.common.internal.u;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Exception {
    @Deprecated
    protected b() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@m0 String str) {
        super(str);
        u.h(str, "Detail message must not be empty");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@m0 String str, @m0 Throwable th) {
        super(str, th);
        u.h(str, "Detail message must not be empty");
    }
}
