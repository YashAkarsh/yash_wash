package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface h {
    @c.w0("android.permission.ACCESS_FINE_LOCATION")
    @c.m0
    @Deprecated
    com.google.android.gms.common.api.n<Status> a(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 List<f> list, @c.m0 PendingIntent pendingIntent);

    @c.m0
    com.google.android.gms.common.api.n<Status> b(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 PendingIntent pendingIntent);

    @c.w0("android.permission.ACCESS_FINE_LOCATION")
    @c.m0
    com.google.android.gms.common.api.n<Status> c(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 GeofencingRequest geofencingRequest, @c.m0 PendingIntent pendingIntent);

    @c.m0
    com.google.android.gms.common.api.n<Status> d(@c.m0 com.google.android.gms.common.api.k kVar, @c.m0 List<String> list);
}
