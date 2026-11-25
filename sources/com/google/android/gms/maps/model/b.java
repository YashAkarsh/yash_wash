package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f16672a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f16673b = 30.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f16674c = 60.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f16675d = 120.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f16676e = 180.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f16677f = 210.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f16678g = 240.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f16679h = 270.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f16680i = 300.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f16681j = 330.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static com.google.android.gms.internal.maps.s f16682k;

    private b() {
    }

    @m0
    public static a a() {
        try {
            return new a(i().a());
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public static a b(float f8) {
        try {
            return new a(i().r1(f8));
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public static a c(@m0 String str) {
        com.google.android.gms.common.internal.u.l(str, "assetName must not be null");
        try {
            return new a(i().R4(str));
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public static a d(@m0 Bitmap bitmap) {
        com.google.android.gms.common.internal.u.l(bitmap, "image must not be null");
        try {
            return new a(i().V1(bitmap));
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public static a e(@m0 String str) {
        com.google.android.gms.common.internal.u.l(str, "fileName must not be null");
        try {
            return new a(i().k4(str));
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public static a f(@m0 String str) {
        com.google.android.gms.common.internal.u.l(str, "absolutePath must not be null");
        try {
            return new a(i().f6(str));
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    @m0
    public static a g(int i7) {
        try {
            return new a(i().U4(i7));
        } catch (RemoteException e8) {
            throw new k(e8);
        }
    }

    public static void h(com.google.android.gms.internal.maps.s sVar) {
        if (f16682k != null) {
            return;
        }
        f16682k = (com.google.android.gms.internal.maps.s) com.google.android.gms.common.internal.u.l(sVar, "delegate must not be null");
    }

    private static com.google.android.gms.internal.maps.s i() {
        return (com.google.android.gms.internal.maps.s) com.google.android.gms.common.internal.u.l(f16682k, "IBitmapDescriptorFactory is not initialized");
    }
}
