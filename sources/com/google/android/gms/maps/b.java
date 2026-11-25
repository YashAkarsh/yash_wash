package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.google.android.gms.maps.internal.a f16485a;

    private b() {
    }

    @c.m0
    public static a a(@c.m0 CameraPosition cameraPosition) {
        com.google.android.gms.common.internal.u.l(cameraPosition, "cameraPosition must not be null");
        try {
            return new a(m().F4(cameraPosition));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public static a b(@c.m0 LatLng latLng) {
        com.google.android.gms.common.internal.u.l(latLng, "latLng must not be null");
        try {
            return new a(m().e2(latLng));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public static a c(@c.m0 LatLngBounds latLngBounds, int i7) {
        com.google.android.gms.common.internal.u.l(latLngBounds, "bounds must not be null");
        try {
            return new a(m().B0(latLngBounds, i7));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public static a d(@c.m0 LatLngBounds latLngBounds, int i7, int i8, int i9) {
        com.google.android.gms.common.internal.u.l(latLngBounds, "bounds must not be null");
        try {
            return new a(m().o4(latLngBounds, i7, i8, i9));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public static a e(@c.m0 LatLng latLng, float f8) {
        com.google.android.gms.common.internal.u.l(latLng, "latLng must not be null");
        try {
            return new a(m().L5(latLng, f8));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public static a f(float f8, float f9) {
        try {
            return new a(m().N5(f8, f9));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public static a g(float f8) {
        try {
            return new a(m().I0(f8));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public static a h(float f8, @c.m0 Point point) {
        com.google.android.gms.common.internal.u.l(point, "focus must not be null");
        try {
            return new a(m().A3(f8, point.x, point.y));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public static a i() {
        try {
            return new a(m().M2());
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public static a j() {
        try {
            return new a(m().e5());
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @c.m0
    public static a k(float f8) {
        try {
            return new a(m().w5(f8));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public static void l(@c.m0 com.google.android.gms.maps.internal.a aVar) {
        f16485a = (com.google.android.gms.maps.internal.a) com.google.android.gms.common.internal.u.k(aVar);
    }

    private static com.google.android.gms.maps.internal.a m() {
        return (com.google.android.gms.maps.internal.a) com.google.android.gms.common.internal.u.l(f16485a, "CameraUpdateFactory is not initialized");
    }
}
