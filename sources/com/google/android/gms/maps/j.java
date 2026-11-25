package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.maps.internal.f f16531a;

    j(com.google.android.gms.maps.internal.f fVar) {
        this.f16531a = fVar;
    }

    @c.m0
    public LatLng a(@c.m0 Point point) {
        com.google.android.gms.common.internal.u.k(point);
        try {
            return this.f16531a.p5(com.google.android.gms.dynamic.f.z3(point));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public VisibleRegion b() {
        try {
            return this.f16531a.a3();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public Point c(@c.m0 LatLng latLng) {
        com.google.android.gms.common.internal.u.k(latLng);
        try {
            return (Point) com.google.android.gms.dynamic.f.y0(this.f16531a.k2(latLng));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }
}
