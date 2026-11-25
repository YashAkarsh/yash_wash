package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
public final class p1 implements com.google.android.gms.location.d {
    @Override // com.google.android.gms.location.d
    public final com.google.android.gms.common.api.n<Status> a(com.google.android.gms.common.api.k kVar, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return kVar.m(new k1(this, kVar, locationRequest, pendingIntent));
    }

    @Override // com.google.android.gms.location.d
    public final Location b(com.google.android.gms.common.api.k kVar) {
        String str;
        z zVarG = com.google.android.gms.location.m.g(kVar);
        Context contextQ = kVar.q();
        if (Build.VERSION.SDK_INT < 30 || contextQ == null) {
            str = null;
        } else {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(contextQ, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                str = null;
            }
        }
        try {
            return zVarG.Q0(str);
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // com.google.android.gms.location.d
    public final com.google.android.gms.common.api.n<Status> c(com.google.android.gms.common.api.k kVar, com.google.android.gms.location.k kVar2) {
        return kVar.m(new d1(this, kVar, kVar2));
    }

    @Override // com.google.android.gms.location.d
    public final com.google.android.gms.common.api.n<Status> d(com.google.android.gms.common.api.k kVar, LocationRequest locationRequest, com.google.android.gms.location.k kVar2, Looper looper) {
        return kVar.m(new j1(this, kVar, locationRequest, kVar2, looper));
    }

    @Override // com.google.android.gms.location.d
    public final com.google.android.gms.common.api.n<Status> e(com.google.android.gms.common.api.k kVar, PendingIntent pendingIntent) {
        return kVar.m(new m1(this, kVar, pendingIntent));
    }

    @Override // com.google.android.gms.location.d
    public final com.google.android.gms.common.api.n<Status> f(com.google.android.gms.common.api.k kVar, com.google.android.gms.location.l lVar) {
        return kVar.m(new l1(this, kVar, lVar));
    }

    @Override // com.google.android.gms.location.d
    public final com.google.android.gms.common.api.n<Status> g(com.google.android.gms.common.api.k kVar, boolean z7) {
        return kVar.m(new e1(this, kVar, z7));
    }

    @Override // com.google.android.gms.location.d
    public final com.google.android.gms.common.api.n<Status> h(com.google.android.gms.common.api.k kVar, LocationRequest locationRequest, com.google.android.gms.location.l lVar) {
        com.google.android.gms.common.internal.u.l(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
        return kVar.m(new h1(this, kVar, locationRequest, lVar));
    }

    @Override // com.google.android.gms.location.d
    public final com.google.android.gms.common.api.n<Status> i(com.google.android.gms.common.api.k kVar, LocationRequest locationRequest, com.google.android.gms.location.l lVar, Looper looper) {
        return kVar.m(new i1(this, kVar, locationRequest, lVar, looper));
    }

    @Override // com.google.android.gms.location.d
    public final LocationAvailability j(com.google.android.gms.common.api.k kVar) {
        try {
            return com.google.android.gms.location.m.g(kVar).v0();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.location.d
    public final com.google.android.gms.common.api.n<Status> k(com.google.android.gms.common.api.k kVar, Location location) {
        return kVar.m(new f1(this, kVar, location));
    }

    @Override // com.google.android.gms.location.d
    public final com.google.android.gms.common.api.n<Status> l(com.google.android.gms.common.api.k kVar) {
        return kVar.m(new g1(this, kVar));
    }
}
