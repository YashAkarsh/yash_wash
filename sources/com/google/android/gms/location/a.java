package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    public static final String f16321a = "activity_recognition";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.m0
    public static final com.google.android.gms.common.api.a<com.google.android.gms.common.api.a.d.C0181d> f16322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.m0
    @Deprecated
    public static final b f16323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a.g<com.google.android.gms.internal.location.z> f16324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a.AbstractC0179a<com.google.android.gms.internal.location.z, com.google.android.gms.common.api.a.d.C0181d> f16325e;

    static {
        com.google.android.gms.common.api.a.g<com.google.android.gms.internal.location.z> gVar = new com.google.android.gms.common.api.a.g<>();
        f16324d = gVar;
        t tVar = new t();
        f16325e = tVar;
        f16322b = new com.google.android.gms.common.api.a<>("ActivityRecognition.API", tVar, gVar);
        f16323c = new com.google.android.gms.internal.location.y0();
    }

    private a() {
    }

    @c.m0
    public static c a(@c.m0 Activity activity) {
        return new c(activity);
    }

    @c.m0
    public static c b(@c.m0 Context context) {
        return new c(context);
    }
}
