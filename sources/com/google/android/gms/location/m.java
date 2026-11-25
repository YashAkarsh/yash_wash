package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    public static final com.google.android.gms.common.api.a<com.google.android.gms.common.api.a.d.C0181d> f16384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.m0
    @Deprecated
    public static final d f16385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.m0
    @Deprecated
    public static final h f16386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.m0
    @Deprecated
    public static final r f16387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a.g<com.google.android.gms.internal.location.z> f16388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a.AbstractC0179a<com.google.android.gms.internal.location.z, com.google.android.gms.common.api.a.d.C0181d> f16389f;

    static {
        com.google.android.gms.common.api.a.g<com.google.android.gms.internal.location.z> gVar = new com.google.android.gms.common.api.a.g<>();
        f16388e = gVar;
        c1 c1Var = new c1();
        f16389f = c1Var;
        f16384a = new com.google.android.gms.common.api.a<>("LocationServices.API", c1Var, gVar);
        f16385b = new com.google.android.gms.internal.location.p1();
        f16386c = new com.google.android.gms.internal.location.f();
        f16387d = new com.google.android.gms.internal.location.g0();
    }

    private m() {
    }

    @c.m0
    public static e a(@c.m0 Activity activity) {
        return new e(activity);
    }

    @c.m0
    public static e b(@c.m0 Context context) {
        return new e(context);
    }

    @c.m0
    public static i c(@c.m0 Activity activity) {
        return new i(activity);
    }

    @c.m0
    public static i d(@c.m0 Context context) {
        return new i(context);
    }

    @c.m0
    public static s e(@c.m0 Activity activity) {
        return new s(activity);
    }

    @c.m0
    public static s f(@c.m0 Context context) {
        return new s(context);
    }

    public static com.google.android.gms.internal.location.z g(com.google.android.gms.common.api.k kVar) {
        com.google.android.gms.common.internal.u.b(kVar != null, "GoogleApiClient parameter is required.");
        com.google.android.gms.internal.location.z zVar = (com.google.android.gms.internal.location.z) kVar.o(f16388e);
        com.google.android.gms.common.internal.u.r(zVar != null, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zVar;
    }
}
