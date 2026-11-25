package com.google.android.gms.signin;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.common.q;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.g<com.google.android.gms.signin.internal.a> f16758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @y
    public static final com.google.android.gms.common.api.a.g<com.google.android.gms.signin.internal.a> f16759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a.AbstractC0179a<com.google.android.gms.signin.internal.a, a> f16760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final com.google.android.gms.common.api.a.AbstractC0179a<com.google.android.gms.signin.internal.a, d> f16761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Scope f16762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Scope f16763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<a> f16764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a<d> f16765h;

    static {
        com.google.android.gms.common.api.a.g<com.google.android.gms.signin.internal.a> gVar = new com.google.android.gms.common.api.a.g<>();
        f16758a = gVar;
        com.google.android.gms.common.api.a.g<com.google.android.gms.signin.internal.a> gVar2 = new com.google.android.gms.common.api.a.g<>();
        f16759b = gVar2;
        b bVar = new b();
        f16760c = bVar;
        c cVar = new c();
        f16761d = cVar;
        f16762e = new Scope(q.f15877a);
        f16763f = new Scope("email");
        f16764g = new com.google.android.gms.common.api.a<>("SignIn.API", bVar, gVar);
        f16765h = new com.google.android.gms.common.api.a<>("SignIn.INTERNAL_API", cVar, gVar2);
    }
}
