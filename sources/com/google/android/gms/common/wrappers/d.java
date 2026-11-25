package com.google.android.gms.common.wrappers;

import android.content.Context;
import c.m0;
import c.o0;
import g1.d0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f16001b = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private c f16002a = null;

    @c1.a
    @m0
    public static c a(@m0 Context context) {
        return f16001b.b(context);
    }

    @d0
    @m0
    public final synchronized c b(@m0 Context context) {
        if (this.f16002a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f16002a = new c(context);
        }
        return this.f16002a;
    }
}
