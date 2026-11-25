package com.google.android.gms.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    @Deprecated
    public static final String f16330a = "com.google.android.location.LOCATION";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.m0
    public static final String f16331b = "mockLocation";

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    com.google.android.gms.common.api.n<Status> a(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 LocationRequest locationRequest, @c.m0 PendingIntent pendingIntent);

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    Location b(@c.m0 com.google.android.gms.common.api.k kVar);

    @c.m0
    com.google.android.gms.common.api.n<Status> c(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 k kVar2);

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    com.google.android.gms.common.api.n<Status> d(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 LocationRequest locationRequest, @c.m0 k kVar2, @c.m0 Looper looper);

    @c.m0
    com.google.android.gms.common.api.n<Status> e(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 PendingIntent pendingIntent);

    @c.m0
    com.google.android.gms.common.api.n<Status> f(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 l lVar);

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    com.google.android.gms.common.api.n<Status> g(@c.m0 com.google.android.gms.common.api.k kVar, boolean z7);

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    com.google.android.gms.common.api.n<Status> h(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 LocationRequest locationRequest, @c.m0 l lVar);

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    com.google.android.gms.common.api.n<Status> i(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 LocationRequest locationRequest, @c.m0 l lVar, @c.m0 Looper looper);

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    LocationAvailability j(@c.m0 com.google.android.gms.common.api.k kVar);

    @c.w0(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @c.m0
    com.google.android.gms.common.api.n<Status> k(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 Location location);

    @c.m0
    com.google.android.gms.common.api.n<Status> l(@c.m0 com.google.android.gms.common.api.k kVar);
}
